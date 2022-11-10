package com.viiyue.ffmpeg.executor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.viiyue.ffmpeg.enums.Library;

public class HelpExecutor extends GlobalExecutor<HelpExecutor> {

	private static final Logger LOG = LoggerFactory.getLogger( HelpExecutor.class );

	public static final HelpExecutor ffmpeg() {
		return new HelpExecutor( Library.FFMPEG );
	}

	public static final HelpExecutor ffprobe() {
		return new HelpExecutor( Library.FFPROBE );
	}

	public static final HelpExecutor ffplay() {
		return new HelpExecutor( Library.FFPLAY );
	}

	private HelpExecutor( Library library ) {
		super( library );
	}

	@Override
	public Logger getLogger() {
		return LOG;
	}

	public HelpExecutor license() {
		return super.cmd( "L" );
	}

	public HelpExecutor version() {
		return super.cmd( "version" );
	}

	public HelpExecutor help() {
		return super.cmd( "L" );
	}

	public HelpExecutor helpLong() {
		return super.cmd( "h", "long" );
	}

	public HelpExecutor helpFull() {
		return super.cmd( "h", "full" );
	}

	public HelpExecutor help( String name ) {
		return super.cmd( "h", "type=" + name );
	}

	public HelpExecutor buildInfo() {
		return super.cmd( "buildconf" );
	}

	public HelpExecutor colors() {
		return super.cmd( "colors" );
	}

	public HelpExecutor formats() {
		return super.cmd( "formats" );
	}

	public HelpExecutor filters() {
		return super.cmd( "filters" );
	}

	public String getAndReturn() {
		return super.execute( null );
	}

	public String getAndReturn( String message ) {
		return super.execute( message );
	}

}
