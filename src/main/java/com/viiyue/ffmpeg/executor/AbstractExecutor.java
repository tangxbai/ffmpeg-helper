/**
 * Copyright (C) 2022-2023 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.viiyue.ffmpeg.executor;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Objects;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.StopWatch;
import org.slf4j.Logger;

import com.viiyue.ffmpeg.enums.Library;
import com.viiyue.ffmpeg.util.Helper;

/**
 * The abstract command process executor
 * 
 * @author tangxbai
 * @since 2022/05/25
 * @param <T> the implementation subclasses
 */
public abstract class AbstractExecutor<T extends AbstractCommander<?>> extends AbstractCommander<T> {

	private final Library library;

	public AbstractExecutor( Library library ) {
		this.library = library;
	}

	/**
	 * @return the log implementation
	 */
	protected abstract Logger getLogger();

	/**
	 * Execute the final command and return the execution result
	 * 
	 * @return the execution result
	 */
	protected final String execute() {
		return execute( null );
	}

	/**
	 * Execute the final command and return the execution result
	 * 
	 * @param message the additional message to display
	 * @return the execution result
	 */
	protected final String execute( String message ) {
		Logger logger = getLogger();
		StopWatch monitor = StopWatch.createStarted();

		String executable = library.getExecutable();
		String logLocation = library.getLogLocation();
		String libraryName = FilenameUtils.getBaseName( executable );
		String commander = StringUtils.capitalize( libraryName );

		List<String> commands = super.toCommands( executable );

		if ( logger != null && logger.isInfoEnabled() ) {
			logger.info( "------------------------------------------------------------------------" );
			if ( !Objects.equals( executable, libraryName ) ) {
				logger.info( "{} library: {}", commander, executable );
			}
			logger.info( "{} command: {}", commander, super.toCommandString( libraryName ) );
		}

		File output = new File( logLocation );
		Helper.createDirectoryIfNecessary( logLocation );
		if ( logger != null && logger.isInfoEnabled() ) {
			logger.info( "{} log file: {}", commander, logLocation );
		}

		boolean printed = false;
		boolean exception = false;
		try {
			ProcessBuilder builder = new ProcessBuilder().inheritIO();
			builder.redirectErrorStream( true );
			builder.redirectOutput( output );
			builder.command( commands );
			int exitValue = builder.start().waitFor();
			if ( exitValue != 0 ) {
				if ( logger != null && logger.isErrorEnabled() ) {
					String line = null;
					logger.error( "------------------------------------------------------------------------" );
					try ( FileInputStream fis = new FileInputStream( output );
							BufferedReader br = new BufferedReader( new InputStreamReader( fis ) ) ) {
						while ( ( line = br.readLine() ) != null ) {
							if ( line.length() > 120 ) {
								line = line.substring( 0, 120 ) + "...";
							}
							logger.error( line );
						}
					}
					printed = true;
				}
				throw new InterruptedException( libraryName + " command was interrupted" );
			}
			if ( output.length() == 0 ) {
				return StringUtils.EMPTY;
			}
			String content = FileUtils.readFileToString( output, StandardCharsets.UTF_8 );
			if ( logger != null && logger.isInfoEnabled() ) {
				logger.info( "{} execution completed", commander );
				if ( message != null ) {
					logger.info( "{} {}", commander, message );
				}
			}
			return content;
		} catch ( IOException e ) {
			exception = true;
			throw new RuntimeException( libraryName + " command execution error" );
		} catch ( InterruptedException e ) {
			exception = true;
			throw new RuntimeException( e.getMessage() );
		} finally {
			monitor.stop();
			if ( exception ) {
				if ( logger != null && logger.isErrorEnabled() ) {
					if ( !printed ) {
						logger.error( "------------------------------------------------------------------------" );
						logger.error( "* An exception occurred in the execution of \"{}\"", executable );
						if ( output.length() > 0 ) {
							logger.error( "* Please check: \"{}\"", logLocation );
						}
						if ( !Helper.cmdCheck( executable, "--help" ) ) {
							logger.error( "* Maybe the \"{}\" library doesn't seem to exist", executable );
						}
					}
					logger.error( "----------------------------------------------------------------------" + ".--" );
				}
			} else {
				if ( output.exists() ) {
					output.delete();
				}
			}
			if ( logger != null && logger.isInfoEnabled() ) {
				logger.info( "{} execution time {}", commander, monitor.toString() );
				logger.info( "------------------------------------------------------------------------" );
			}
		}
	}

}
