package com.viiyue.ffmpeg.executor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.viiyue.ffmpeg.enums.Library;

public class AudioExecutor extends CommonExecutor<AudioExecutor> {

	private static final Logger LOG = LoggerFactory.getLogger( AudioExecutor.class );

	public static final AudioExecutor build() {
		return new AudioExecutor( true );
	}

	private AudioExecutor( boolean overwrite ) {
		super( Library.FFMPEG );
		if ( overwrite ) {
			super.overwrite();
		}
	}

	@Override
	public Logger getLogger() {
		return LOG;
	}

	public AudioExecutor disable() {
		return super.cmd( "dn" );
	}

	public AudioExecutor disableAudio() {
		return super.cmd( "vn" );
	}

	public AudioExecutor quality( double quality ) {
		return super.cmd( "aq", quality );
	}

	public AudioExecutor rate( int rate ) {
		return super.cmd( "ar", rate );
	}

	public AudioExecutor channel( int channels ) {
		return super.cmd( "ac", channels );
	}

	public AudioExecutor frameRate( int rate ) {
		return super.cmd( "r", rate );
	}

	public AudioExecutor aspect( double ratio ) {
		return super.cmd( "aspect", ratio );
	}

	public AudioExecutor aspect( String ratio ) {
		return super.cmd( "aspect", ratio );
	}

	public AudioExecutor pass( int num ) {
		return super.cmd( "pass", num );
	}

	public AudioExecutor frames( int how ) {
		return super.cmd( "aframes", how );
	}

	public AudioExecutor filters( String filters ) {
		return super.cmd( "af", filters );
	}

}
