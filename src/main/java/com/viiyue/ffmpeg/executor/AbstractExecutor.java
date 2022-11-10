package com.viiyue.ffmpeg.executor;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

import org.apache.commons.codec.Charsets;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.StopWatch;
import org.slf4j.Logger;

import com.viiyue.ffmpeg.common.Const;
import com.viiyue.ffmpeg.enums.Library;
import com.viiyue.ffmpeg.util.Helper;

/**
 * The abstract command process executor
 * 
 * @author tangxbai
 * @since 2022/05/25
 * @param <T>
 */
public abstract class AbstractExecutor<T extends AbstractCommander<?>> extends AbstractCommander<T> {

	private static final AtomicReference<String> LIBRARY_REF = new AtomicReference<>( Const.HOME_PATH );
	private static final AtomicReference<String> LOG_LOCATION_REF = new AtomicReference<>( Const.TEMP_PATH );

	public static final void initLibrary( String library ) {
		LIBRARY_REF.set( library );
	}

	public static final void initLogLocation( String logLocation ) {
		LOG_LOCATION_REF.set( logLocation );
	}

	private final Library library;

	public AbstractExecutor( Library library ) {
		this.library = library;
	}

	protected abstract Logger getLogger();

	protected boolean removeTemporary() {
		return true;
	}

	protected String loadLibrary() {
		String program = Const.PLATFORM.getProgram( library.getName() );
		return Helper.fixPath( LIBRARY_REF.get() ) + program;
	}

	protected String logLocation() {
		String logLocation = LOG_LOCATION_REF.get();
		String extension = FilenameUtils.getExtension( logLocation );
		if ( StringUtils.isEmpty( extension ) ) {
			logLocation = Helper.fixPath( logLocation );
			logLocation += Const.FFMPEG + "/" + library.getName() + "-" + System.currentTimeMillis() + ".log";
		}
		return logLocation;
	}

	protected boolean check( String ... cmd ) {
		try {
			return Runtime.getRuntime().exec( cmd ).waitFor() == 0;
		} catch ( Exception e ) {
			Logger logger = getLogger();
			if ( logger != null && logger.isErrorEnabled() ) {
				logger.error( e.getMessage(), e );
			}
			return false;
		}
	}

	protected final String execute() {
		return execute( null );
	}

	protected final String execute( String message ) {
		Logger logger = getLogger();
		StopWatch monitor = StopWatch.createStarted();

		String library = loadLibrary();
		String logLocation = logLocation();
		String libraryName = FilenameUtils.getBaseName( library );
		String outputName = StringUtils.capitalize( libraryName );

		List<String> commands = super.toCommands( library );

		if ( logger != null && logger.isInfoEnabled() ) {
			List<String> temps = super.toCommands( libraryName );
			logger.info( "------------------------------------------------------------------------" );
			logger.info( "{} work directory: {}", outputName, library );
			logger.info( "{} command: [ {} ]", outputName, StringUtils.join( temps, ' ' ) );
		}

		File output = new File( logLocation );
		Helper.createDirectoryIfNecessary( logLocation );
		if ( logger != null && logger.isInfoEnabled() ) {
			logger.info( "{} output log file location: {}", outputName, logLocation );
		}

		boolean excetion = false;
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
				}
				throw new InterruptedException( libraryName + " command was interrupted" );
			}
			String out = FileUtils.readFileToString( output, Charsets.UTF_8 );
			if ( logger != null && logger.isInfoEnabled() ) {
				logger.info( "{} execution completed", outputName );
				if ( message != null ) {
					logger.info( "{} {}", outputName, message );
				}
			}
			return out;
		} catch ( IOException e ) {
			excetion = true;
			throw new RuntimeException( libraryName + " command execution error" );
		} catch ( InterruptedException e ) {
			excetion = true;
			throw new RuntimeException( e.getMessage() );
		} finally {
			if ( excetion ) {
				if ( logger != null && logger.isErrorEnabled() ) {
					String logName = FilenameUtils.getBaseName( logLocation );
					String errorLog = StringUtils.replace( logLocation, logName, logName + "-error" );
					output.renameTo( new File( errorLog ) );
					monitor.stop();
					logger.error( "" );
					logger.error( "An exception occurred in the execution of <{}>", outputName );
					logger.error( "Please check: {}", errorLog );
					logger.error( "" );
					logger.error( "------------------------------------------------------------------------" );
					logger.error( "{} execution time {}", outputName, monitor.toString() );
					logger.error( "------------------------------------------------------------------------" );
				}
			} else {
				monitor.stop();
				if ( logger != null && logger.isInfoEnabled() ) {
					logger.info( "------------------------------------------------------------------------" );
					logger.info( "{} execution time {}", outputName, monitor.toString() );
					logger.info( "------------------------------------------------------------------------" );
				}
				if ( removeTemporary() && output.exists() ) {
					output.delete();
				}
			}
		}
	}

}
