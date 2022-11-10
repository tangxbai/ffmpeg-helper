package com.viiyue.ffmpeg.executor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.viiyue.ffmpeg.enums.Library;
import com.viiyue.ffmpeg.enums.VideoSize;
import com.viiyue.ffmpeg.filter.AbstractResult;
import com.viiyue.ffmpeg.filter.Filters;

public class FFmpegExecutor extends CommonExecutor<FFmpegExecutor> {

	private static final Logger LOG = LoggerFactory.getLogger( FFmpegExecutor.class );

	public static final FFmpegExecutor build() {
		return new FFmpegExecutor( true );
	}

	public static final FFmpegExecutor build( boolean overwrite ) {
		return new FFmpegExecutor( overwrite );
	}

	private FFmpegExecutor( boolean overwrite ) {
		super( Library.FFMPEG );
		if ( overwrite ) {
			super.overwrite();
		}
	}

	@Override
	public Logger getLogger() {
		return LOG;
	}

	public FFmpegExecutor loop() {
		return super.cmd( "-loop", 1 );
	}

	public FFmpegExecutor copy() {
		return super.cmd( "-c:a", "copy" );
	}

	public FFmpegExecutor disable() {
		return super.cmd( "dn" );
	}

	public FFmpegExecutor disableVideo() {
		return super.cmd( "vn" );
	}

	public FFmpegExecutor disableAudio() {
		return super.cmd( "vn" );
	}

	public FFmpegExecutor bitRate( int bitRate ) {
		return super.cmd( "b", bitRate );
	}

	public FFmpegExecutor audioBitRate( int bitRate ) {
		return super.cmd( "ab", bitRate );
	}

	public FFmpegExecutor frameRate( int rate ) {
		return super.cmd( "r", rate );
	}

	public FFmpegExecutor aspect( double ratio ) {
		return super.cmd( "aspect", ratio );
	}

	public FFmpegExecutor aspect( String ratio ) {
		return super.cmd( "aspect", ratio );
	}

	public FFmpegExecutor pass( int num ) {
		return super.cmd( "pass", num );
	}

	public FFmpegExecutor frames( int how ) {
		return super.cmd( "vframes", how );
	}

	public FFmpegExecutor maxFrames( int how ) {
		return super.cmd( "fpsmax", how );
	}

	public FFmpegExecutor acodec( String codec ) {
		return super.cmd( "acodec", codec );
	}

	public FFmpegExecutor vcodec( String codec ) {
		return super.cmd( "vcodec", codec );
	}

	public FFmpegExecutor time( String timeCode ) {
		return super.cmd( "timecode", timeCode );
	}

	public FFmpegExecutor factor( int rate ) {
		return super.cmd( "-crf", rate );
	}

	public FFmpegExecutor resize( int width, int height ) {
		return super.cmd( "-s", width + "x" + height );
	}

	public FFmpegExecutor resize( VideoSize size ) {
		return super.cmd( "-s", size );
	}

	public FFmpegExecutor filters( Filters filters ) {
		return super.cmd( filters.getFilter(), filters );
	}

	public FFmpegExecutor filters( AbstractResult<?> ... results ) {
		return filters( Filters.simple().graph( results ) );
	}

	public String to( String output ) {
		super.output( output ).execute();
		return output;
	}

}
