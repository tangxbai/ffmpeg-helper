package com.viiyue.ffmpeg.executor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.viiyue.ffmpeg.enums.Library;
import com.viiyue.ffmpeg.filter.Filters;

public class FFplayExecutor extends CommonExecutor<FFplayExecutor> {

	private static final Logger LOG = LoggerFactory.getLogger( FFplayExecutor.class );

	public static final FFplayExecutor build() {
		return new FFplayExecutor();
	}

	private FFplayExecutor() {
		super( Library.FFPLAY );
	}

	@Override
	public Logger getLogger() {
		return LOG;
	}

	public FFplayExecutor title( String title ) {
		return super.cmd( "window_title", title );
	}

	public FFplayExecutor size( int width, int height ) {
		return super.cmd( "x", width ).cmd( "y", height );
	}

	public FFplayExecutor mode( String mode ) {
		return super.cmd( "showmode", mode );
	}

	public FFplayExecutor filters( Filters filters ) {
		return super.cmd( filters.getFilter(), filters );
	}

	public void toPlay() {
		toPlay( false );
	}

	public void toPlay( boolean isAutoExit ) {
		if ( isAutoExit ) {
			super.cmd( "autoexit" );
		}
		super.execute();
	}

}
