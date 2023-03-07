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
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicReference;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.StopWatch;
import org.slf4j.Logger;

import com.viiyue.ffmpeg.common.Const;
import com.viiyue.ffmpeg.enums.Library;
import com.viiyue.ffmpeg.util.Assert;
import com.viiyue.ffmpeg.util.Helper;

/**
 * The abstract command process executor
 * 
 * @author tangxbai
 * @since 2022/05/25
 * @param <T> the implementation subclasses
 */
public abstract class AbstractExecutor<T extends AbstractCommander<?>> extends AbstractCommander<T> {

	private static final Map<String, Boolean> VALIDATED = new HashMap<>( 4 );
	private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern( "YYYYMMddHHmmss" );
	private static final AtomicReference<String> LIBRARY_REF = new AtomicReference<>();
	private static final AtomicReference<String> LOG_LOCATION_REF = new AtomicReference<>( Const.TEMP_PATH );

	public static final void setLibrary( String library ) {
		LIBRARY_REF.set( library );
	}

	public static final void setLogLocation( String logLocation ) {
		LOG_LOCATION_REF.set( logLocation );
	}

	private final Library library;

	public AbstractExecutor( Library library ) {
		this.library = library;
	}

	protected abstract Logger getLogger();

	protected final String execute() {
		return execute( null );
	}

	protected final String execute( String message ) {
		Logger logger = getLogger();
		StopWatch monitor = StopWatch.createStarted();

		String library = loadLibrary();
		String logLocation = fetchLogLocation();
		String libraryName = FilenameUtils.getBaseName( library );
		String commander = StringUtils.capitalize( libraryName );

		List<String> commands = super.toCommands( library );

		if ( logger != null && logger.isInfoEnabled() ) {
			List<String> temps = super.toCommands( libraryName );
			logger.info( "------------------------------------------------------------------------" );
			if ( !Objects.equals( library, libraryName ) ) {
				logger.info( "{} library: {}", commander, library );
			}
			logger.info( "{} command: {}", commander, StringUtils.join( temps, ' ' ) );
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
			if ( output.exists() ) {
				output.delete();
			}
			if ( output.length() == 0 ) {
				return StringUtils.EMPTY;
			}
			String out = FileUtils.readFileToString( output, StandardCharsets.UTF_8 );
			if ( logger != null && logger.isInfoEnabled() ) {
				logger.info( "{} execution completed", commander );
				if ( message != null ) {
					logger.info( "{} {}", commander, message );
				}
			}
			return out;
		} catch ( IOException e ) {
			exception = true;
			throw new RuntimeException( libraryName + " command execution error" );
		} catch ( InterruptedException e ) {
			exception = true;
			throw new RuntimeException( e.getMessage() );
		} finally {
			monitor.stop();
			if ( exception && logger != null && logger.isErrorEnabled() ) {
				if ( !printed ) {
					logger.error( "------------------------------------------------------------------------" );
					logger.error( "* An exception occurred in the execution of \"{}\"", library );
					if ( output.length() > 0 ) {
						logger.error( "* Please check: \"{}\"", logLocation );
					}
					if ( !Helper.cmdCheck( library, "--help" ) ) {
						logger.error( "* Maybe the \"{}\" library doesn't seem to exist", library );
					}
				}
				logger.error( "----------------------------------------------------------------------" + ".--" );
			}
			if ( logger != null && logger.isInfoEnabled() ) {
				logger.info( "{} execution time {}", commander, monitor.toString() );
				logger.info( "------------------------------------------------------------------------" );
			}
		}
	}

	private String loadLibrary() {
		String thePath = LIBRARY_REF.get();
		if ( Objects.equals( VALIDATED.get( thePath ), Boolean.TRUE ) ) {
			return thePath;
		}
		Assert.notNull( thePath, "You must specify the library path for " + library.getName() + "!" );
		File theLibrary = new File( thePath );
		if ( theLibrary.exists() ) {
			Assert.isFalse( theLibrary.isDirectory(),
					"The specified " + library.getName() + " library cannot be a directory!" );
		}
		VALIDATED.put( thePath, Boolean.TRUE );
		return thePath;
	}

	private String fetchLogLocation() {
		String thePath = LOG_LOCATION_REF.get();
		String extension = FilenameUtils.getExtension( thePath );
		if ( StringUtils.isEmpty( extension ) ) {
			thePath = Helper.fixPath( thePath );
			String datetime = FORMATTER.format( LocalDateTime.now() );
			thePath += Const.FFMPEG + "/" + library.getName() + "-error-" + datetime + ".log";
		}
		return thePath;
	}
	
}
