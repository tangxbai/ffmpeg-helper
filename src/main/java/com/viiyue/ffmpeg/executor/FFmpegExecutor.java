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

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.viiyue.ffmpeg.enums.Library;
import com.viiyue.ffmpeg.enums.VideoSize;
import com.viiyue.ffmpeg.filter.AbstractResult;
import com.viiyue.ffmpeg.filter.Filters;

/**
 * FFmpeg command executor
 * 
 * @author tangxbai
 * @since 2022/05/25
 */
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
			super.override();
		}
	}

	@Override
	public Logger getLogger() {
		return LOG;
	}

	/**
	 * Loop over the input
	 * 
	 * @return the {@link FFmpegExecutor} instance 
	 */
	public FFmpegExecutor loop() {
		return super.cmd( "-loop", 1 );
	}

	/**
	 * Deprecated! <b>DO NOT USE THIS METHOD AGAIN</b>.
	 *  
	 * @return the {@link FFmpegExecutor} instance
	 * @deprecated Do not use this method!!
	 */
	@Deprecated
	public FFmpegExecutor disable() {
		return super.cmd( "dn" );
	}

	/**
	 * Disable video
	 * 
	 * @return the {@link FFmpegExecutor} instance 
	 */
	public FFmpegExecutor disableVideo() {
		return super.cmd( "vn" );
	}

	/**
	 * Disable audio
	 * 
	 * @return the {@link FFmpegExecutor} instance 
	 */
	public FFmpegExecutor disableAudio() {
		return super.cmd( "an" );
	}
	
	/**
	 * Disable subtitle
	 * 
	 * @return the {@link FFmpegExecutor} instance 
	 */
	public FFmpegExecutor disableSubtitle() {
		return super.cmd( "sn" );
	}
	
	/**
	 * Set video bit rate
	 * 
	 * @param bitRate the video bit rate
	 * @return the {@link FFmpegExecutor} instance 
	 */
	@Deprecated
	public FFmpegExecutor bitRate( int bitRate ) {
		return this.videoBitRate( bitRate );
	}

	/**
	 * Set video bit rate
	 * 
	 * @param bitRate the bit rate
	 * @return the {@link FFmpegExecutor} instance 
	 */
	public FFmpegExecutor videoBitRate( int bitRate ) {
		return super.cmd( "b:v", bitRate );
	}

	/**
	 * Set audio bit rate
	 * 
	 * @param bitRate the audio bit rate
	 * @return the {@link FFmpegExecutor} instance 
	 */
	public FFmpegExecutor audioBitRate( int bitRate ) {
		return super.cmd( "b:a", bitRate );
	}

	/**
	 * Set the video frame rate
	 * 
	 * @param rate the frame rate
	 * @return the {@link FFmpegExecutor} instance 
	 */
	public FFmpegExecutor frameRate( int rate ) {
		return super.cmd( "r", rate );
	}
	
	/**
	 * Set the audio rate
	 * 
	 * @param rate the audio rate
	 * @return the {@link FFmpegExecutor} instance 
	 */
	public FFmpegExecutor audioRate( int rate ) {
		return super.cmd( "ar", rate );
	}

	/**
	 * <p>
	 * When used as an input option (before {@code -i}), limit the duration of data read from the input file.
	 * 
	 * <p>
	 * When used as an output option (before an output url), stop writing the output after its duration
	 * reaches duration.
	 * 
	 * <p>
	 * duration must be a time duration specification, see
	 * <a href="https://ffmpeg.org/ffmpeg-utils.html#time-duration-syntax">(ffmpeg-utils)the Time duration
	 * section in the ffmpeg-utils(1) manual</a>.
	 * 
	 * <p>
	 * {@code -to} and {@code -t} are mutually exclusive and -t has priority.
	 * 
	 * @param duration
	 * @return the {@link FFmpegExecutor} instance
	 * @since 1.0.1
	 */
	public FFmpegExecutor duration( double duration ) {
		return super.cmd( "t", duration );
	}

	/**
	 * Set aspect ratio (4:3, 16:9 or 1.3333, 1.7777)
	 * 
	 * @param how the frame rate
	 * @return the {@link FFmpegExecutor} instance
	 * @see #aspect(String)
	 */
	public FFmpegExecutor aspect( double ratio ) {
		return super.cmd( "aspect", ratio );
	}

	/**
	 * Set aspect ratio (4:3, 16:9 or 1.3333, 1.7777)
	 * 
	 * @param ratio the frame rate
	 * @return the {@link FFmpegExecutor} instance
	 * @see #aspect(double)
	 */
	public FFmpegExecutor aspect( String ratio ) {
		return super.cmd( "aspect", ratio );
	}

	/**
	 * 
	 * 
	 * @param how the frame rate
	 * @return the {@link FFmpegExecutor} instance 
	 */
	public FFmpegExecutor pass( int num ) {
		return super.cmd( "pass", num );
	}

	/**
	 * 
	 * 
	 * @param how the frame rate
	 * @return the {@link FFmpegExecutor} instance 
	 */
	public FFmpegExecutor frames( int how ) {
		return super.cmd( "vframes", how );
	}

	/**
	 * Set max frame rate (Hz value, fraction or abbreviation)
	 * 
	 * @param how the frame rate
	 * @return the {@link FFmpegExecutor} instance 
	 */
	public FFmpegExecutor maxFrames( int how ) {
		return super.cmd( "fpsmax", how );
	}

	/**
	 * Set the audio codec name
	 * 
	 * @param codec the codec name
	 * @return the {@link FFmpegExecutor} instance 
	 */
	public FFmpegExecutor acodec( String codec ) {
		return super.codec( "a", codec );
	}

	/**
	 * Set the video codec name
	 * 
	 * @param codec the codec name
	 * @return the {@link FFmpegExecutor} instance
	 */
	public FFmpegExecutor vcodec( String codec ) {
		return super.codec( "v", codec );
	}

	/**
	 * Set initial TimeCode value(e.g. hh:mm:ss[:;.]ff )
	 * 
	 * @deprecated seee {@link #timeCode(String)}
	 * @param timeCode the timecode 
	 * @return
	 */
	public FFmpegExecutor time( String timeCode ) {
		return this.timeCode( timeCode );
	}
	
	/**
	 * Set initial TimeCode value(e.g. hh:mm:ss[:;.]ff )
	 * 
	 * @param timeCode the timecode 
	 * @return
	 * @since 1.0.1
	 */
	public FFmpegExecutor timeCode( String timeCode ) {
		return super.cmd( "timecode", timeCode );
	}
	
	/**
	 * Set initial TimeCode value
	 * 
	 * @param timeCode the timecode 
	 * @return
	 */
	public FFmpegExecutor timeBase( String timeCode ) {
		return super.cmd( "time_base", timeCode );
	}

	/**
	 * Set the quality for constant quality mode
	 * 
	 * @param rate the quality value
	 * @return the {@link FFmpegExecutor} instance
	 */
	public FFmpegExecutor factor( int quality ) {
		return super.cmd( "crf", quality );
	}

	/**
	 * Set frame size (WxH or abbreviation)
	 * 
	 * @param width  the frame width size
	 * @param height the frame height size
	 * @return the {@link FFmpegExecutor} instance
	 */
	public FFmpegExecutor resize( int width, int height ) {
		return super.cmd( "s", width + "x" + height );
	}

	/**
	 * Use constant enumeration to set the frame size
	 * 
	 * @param size the enumeration frame size
	 * @return the {@link FFmpegExecutor} instance
	 */
	public FFmpegExecutor resize( VideoSize size ) {
		return super.cmd( "s", size );
	}
	
	/**
	 * Set video filter
	 * 
	 * @param filters the video filter
	 * @return the {@link FFmpegExecutor} instance
	 */
	public FFmpegExecutor filters( Filters filters ) {
		return super.cmdWrap( filters.getFilter(), filters );
	}

	/**
	 * Set video filter
	 * 
	 * @param results the video function chain array
	 * @return the {@link FFmpegExecutor} instance
	 */
	public FFmpegExecutor filters( AbstractResult<?> ... results ) {
		return filters( Filters.simple().add( results ).over() );
	}

	/**
	 * Output video to a file
	 * 
	 * @param output the output file path
	 * @return the {@link FFmpegExecutor} instance
	 */
	public String to( String output ) {
		super.output( output ).execute();
		return output;
	}
	
	@Override
	protected void usages() {
		super.usages();
		super.usage( "loop", this::loop, "Set the number of loops" );
		super.<String>usage( "c", this::codec, "Set codec name" );
		super.usage( "vn", this::disableVideo, "Disable video" );
		super.usage( "an", this::disableAudio, "Disable audio" );
		super.usage( "sn", this::disableSubtitle, "Disable subtitle" );
		super.usage( "b:v", this::videoBitRate, "Set video bit rate" );
		super.usage( "b:a", this::audioBitRate, "Set audio bit rate" );
		super.usage( "r", this::frameRate, "Set frame rate (Hz value, fraction or abbreviation)" );
		super.usage( "t", this::duration, "Record or transcode 'duration' seconds of audio/video" );
		super.<String>usage( "aspect", this::aspect, "Set aspect ratio (4:3, 16:9 or 1.3333, 1.7777)" );
		super.usage( "pass", this::pass, "Select the pass number (1 to 3)" );
		super.usage( "vframes", this::frames, "Set the number of video frames to output" );
		super.usage( "c:a", "codec(..)", "Set the audio codec name" );
		super.usage( "c:v", "codec(..)", "Set the video codec name" );
		super.usage( "fpsmax", this::maxFrames, "Set max frame rate (Hz value, fraction or abbreviation)" );
		super.usage( "timecode", this::timeCode, "Set initial TimeCode value" );
		super.usage( "crf", this::factor, "Set the quality for constant quality mode" );
		super.<Integer, Integer>usage( "s", this::resize, "Set frame size (WxH or abbreviation)" );
		super.usage( "vf", "filters(.)", "Set frame size (WxH or abbreviation)" );
		super.usage( "filter_complex", "filters(.)", "Set frame size (WxH or abbreviation)" );
	}

}
