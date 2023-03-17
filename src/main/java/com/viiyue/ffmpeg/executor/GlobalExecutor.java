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

import com.viiyue.ffmpeg.enums.CpuFlag;
import com.viiyue.ffmpeg.enums.Library;
import com.viiyue.ffmpeg.enums.LogLevel;
import com.viiyue.ffmpeg.util.Helper;

/**
 * Global FFmpeg command executor
 * 
 * @author tangxbai
 * @since 2022/05/25
 * @param <T>
 */
public abstract class GlobalExecutor<T extends AbstractExecutor<?>> extends AbstractExecutor<T> {

	public GlobalExecutor( Library library ) {
		super( library );
	}
	
	// Global options (affect whole program instead of just one file)
	
	/**
	 * Set logging level
	 * 
	 * @param level the print log level
	 * @return the current subclass instance
	 */
	public T logLevel( LogLevel level ) {
		return super.cmd( "v", level.getName() );
	}

	/**
	 * Set logging level
	 * 
	 * @param level the print log level
	 * @return the current subclass instance
	 * @deprecated please use {@link #logLevel(LogLevel)}
	 */
	public T log( LogLevel level ) {
		return this.logLevel( level );
	}
	
	/**
	 * Generate a report
	 * 
	 * @return the current subclass instance
	 */
	public T report() {
		return super.cmd( "report" );
	}
	
	/**
	 * Set maximum size of a single allocated block
	 * 
	 * @param value the maximum size of a single allocated block
	 * @return the current subclass instance
	 */
	public T maxSizeOfsingleAllocatedBlock( int value ) {
		return super.cmd( "max_allo", value );
	}
	
	/**
	 * Overwrite existing files without confirming
	 * 
	 * @return the current subclass instance
	 * @since 1.0.1
	 */
	public T override() {
		return overwrite( true );
	}

	/**
	 * Overwrite existing files without confirming
	 * 
	 * @return the current subclass instance
	 * @since 1.0.1
	 */
	public T override( boolean value ) {
		return super.cmd( value ? "y" : "n" );
	}
	
	/**
	 * Overwrite existing files without confirming
	 * 
	 * @return the current subclass instance
	 * @deprecated please use {@link #override()}
	 */
	public T overwrite() {
		return this.override();
	}
	
	/**
	 * Overwrite existing files without confirming
	 * 
	 * @return the current subclass instance
	 * @deprecated please use {@link #override()}
	 */
	public T overwrite( boolean value ) {
		return this.override( value );
	}

	/**
	 * Ignore unknown stream types
	 * 
	 * @return the current subclass instance
	 */
	public T ignoreUnknownStream() {
		return super.cmd( "ignore_unknown" );
	}

	/**
	 * Number of filter threads
	 * 
	 * @param value the filter threads
	 * @return the current subclass instance
	 * @since 1.0.1
	 */
	public T threads( int value ) {
		return super.cmd( "threads", value );
	}
	
	/**
	 * Number of non-complex filter threads
	 * 
	 * @param value the filter threads
	 * @return the current subclass instance
	 */
	public T filterThreads( int value ) {
		return super.cmd( "filter_threads", value );
	}

	/**
	 * Number of threads for -filter_complex
	 * 
	 * @param value the filter threads
	 * @return the current subclass instance
	 * @since 1.0.1
	 */
	public T filterComplexThreads( int value ) {
		return super.cmd( "filter_complex_threads", value );
	}

	/**
	 * Print progress report during encoding
	 * 
	 * @return the current subclass instance
	 */
	public T stats() {
		return super.cmd( "stats" );
	}

	/**
	 * maximum error rate ratio of decoding errors (0.0: no errors, 1.0: 100% errors) above which ffmpeg
	 * returns an error instead of success.
	 * 
	 * @param value the maximum error rate ratio
	 * @return the current subclass instance
	 */
	public T maxErrorRate( double value ) {
		return super.cmd( "max_error_rate", value );
	}

	/**
	 * Set the number of bits per raw sample
	 * 
	 * @param value the number of bits per raw sample
	 * @return the current subclass instance
	 * @since 1.0.1
	 */
	public T bitPreRawSampe( int value ) {
		return super.cmd( "bits_per_raw_sample", value );
	}
	
	/**
	 * Change audio volume (256=normal)
	 * 
	 * @param value the audio volume
	 * @return the current subclass instance
	 */
	public T volume( int value ) {
		return super.cmd( "vol", value );
	}
	
	// Advanced global options
	
	/**
	 * Allows setting and clearing CPU flags. This option is intended for testing. <b>Do not use it unless you
	 * know what you’re doing</b>.
	 * 
	 * @param value the audio volume
	 * @return the current subclass instance
	 * @since 1.0.1
	 */
	public T cpuFlags( CpuFlag ... flags ) {
		return super.cmd( "cpuflags", Helper.expandFlags( flags ) );
	}
	
	/**
	 * Suppress printing banner
	 * 
	 * @return the current subclass instance
	 * @since 1.0.1
	 */
	public T hideBanner() {
		return super.cmd( "hide_banner" );
	}
	
	/**
	 * Allow input streams with unknown type to be copied instead of failing if copying such streams is
	 * attempted.
	 * 
	 * @return the current subclass instance
	 * @since 1.0.1
	 */
	public T copyUnknown() {
		return super.cmd( "copy_unknown" );
	}
	
	/**
	 * <p>
	 * Enable interaction on standard input. On by default unless standard input is used as an input. To
	 * explicitly disable interaction you need to specify {@code -nostdin}.
	 * 
	 * <p>
	 * Disabling interaction on standard input is useful, for example, if ffmpeg is in the background process
	 * group. Roughly the same result can be achieved with <font color="green">ffmpeg ... < /dev/null</font>
	 * but it requires a shell.
	 * 
	 * @return the current subclass instance
	 * @since 1.0.1
	 */
	public T standardInput() {
		return super.cmd( "stdin" );
	}
	
	/**
	 * <p>
	 * Enable interaction on standard input. On by default unless standard input is used as an input. To
	 * explicitly disable interaction you need to specify {@code -nostdin}.
	 * 
	 * <p>
	 * Disabling interaction on standard input is useful, for example, if ffmpeg is in the background process
	 * group. Roughly the same result can be achieved with <font color="green">ffmpeg ... < /dev/null</font>
	 * but it requires a shell.
	 * 
	 * @return the current subclass instance
	 * @since 1.0.1
	 */
	public T noStandardInput() {
		return super.cmd( "nostdin" );
	}
	
	/**
	 * Exit after FFmpeg has been running for duration seconds in CPU user time
	 * 
	 * @param value the running duration
	 * @return the current subclass instance
	 * @since 1.0.1
	 */
	public T timeLimit( double value ) {
		return super.cmd( "timelimit", value );
	}
	
	/**
	 * Dump each input packet to {@code stderr}
	 * 
	 * @return the current subclass instance
	 * @since 1.0.1
	 */
	public T dump() {
		return super.cmd( "dump" );
	}
	
	/**
	 * When dumping packets, also dump the payload.
	 * 
	 * @return the current subclass instance
	 * @since 1.0.1
	 */
	public T hex() {
		return super.cmd( "hex" );
	}
	
	/**
	 * Video sync method
	 * 
	 * @param value the sync threshold
	 * @return the current subclass instance
	 * @since 1.0.1
	 */
	public T vsync( double value ) {
		return super.cmd( "vsync", value );
	}
	
	/**
	 * Audio sync method
	 * 
	 * @param value the sync threshold
	 * @return the current subclass instance
	 * @since 1.0.1
	 */
	public T async( double value ) {
		return super.cmd( "async", value );
	}
	
	/**
	 * Frame drop threshold, which specifies how much behind video frames can be before they are dropped. In
	 * frame rate units, so 1.0 is one frame. The default is -1.1. One possible usecase is to avoid framedrops
	 * in case of noisy timestamps or to increase frame drop precision in case of exact timestamps.
	 * 
	 * @param value the frame drop threshold
	 * @return the current subclass instance
	 * @since 1.0.1
	 */
	public T frameDropThreshold( double value ) {
		return super.cmd( "frame_drop_threshold", value );
	}
	
	/**
	 * Set the minimum difference between timestamps and audio data (in seconds) to trigger adding/dropping
	 * samples to make it match the timestamps. This option effectively is a threshold to select between hard
	 * (add/drop) and soft (squeeze/stretch) compensation. {@code -async} must be set to a positive value.
	 * 
	 * @param value the the minimum difference threshold
	 * @return the current subclass instance
	 * @since 1.0.1
	 */
	public T adriftThresholdThreshold( double value ) {
		return super.cmd( "adrift_threshold threshold", value );
	}
	
	/**
	 * <p>
	 * Do not process input timestamps, but keep their values without trying to sanitize them. In particular,
	 * do not remove the initial start time offset value.
	 * 
	 * <p>
	 * Note that, depending on the {@code vsync} option or on specific muxer processing (e.g. in case the format
	 * option avoid_negative_ts is enabled) the output timestamps may mismatch with the input timestamps even
	 * when this option is selected.
	 * 
	 * @param value the the minimum difference threshold
	 * @return the current subclass instance
	 * @since 1.0.1
	 */
	public T copyts( double value ) {
		return super.cmd( "copyts", value );
	}
	
}
