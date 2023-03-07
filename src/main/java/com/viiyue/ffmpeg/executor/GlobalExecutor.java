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

import com.viiyue.ffmpeg.enums.Library;
import com.viiyue.ffmpeg.enums.LogLevel;

/**
 * 
 * @author tangxbai
 * @since 2022/05/25
 * @param <T>
 */
public abstract class GlobalExecutor<T extends AbstractExecutor<?>> extends AbstractExecutor<T> {

	public GlobalExecutor( Library library ) {
		super( library );
	}

	/**
	 * Overwrite existing files without confirming
	 * 
	 * @return the current subclass instance
	 */
	public T overwrite() {
		return overwrite( true );
	}

	/**
	 * Overwrite existing files without confirming
	 * 
	 * @return the current subclass instance
	 */
	public T overwrite( boolean overwrite ) {
		return super.cmd( overwrite ? "y" : "n" );
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
	 * Number of non-complex filter threads
	 * 
	 * @param threads the filter threads
	 * @return the current subclass instance
	 */
	public T filterThreads( int threads ) {
		return super.cmd( "filter_threads", threads );
	}

	/**
	 * Number of threads for -filter_complex
	 * 
	 * @param threads the filter threads
	 * @return the current subclass instance
	 */
	public T filterComplexThreads( int threads ) {
		return super.cmd( "filter_complex_threads", threads );
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
	 * @param volume the maximum error rate ratio
	 * @return the current subclass instance
	 */
	public T maxErrorRate( double rate ) {
		return super.cmd( "max_error_rate", rate );
	}

	/**
	 * Change audio volume (256=normal)
	 * 
	 * @param volume the audio volume
	 * @return the current subclass instance
	 */
	public T volume( int volume ) {
		return super.cmd( "vol", volume );
	}

	/**
	 * Set logging level
	 * 
	 * @param level the print log level
	 * @return the current subclass instance
	 */
	public T log( LogLevel level ) {
		return super.cmd( "v", level.getName() );
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
	 * @param bytes the maximum size of a single allocated block
	 * @return the current subclass instance
	 */
	public T maxSizeOfsingleAllocatedBlock( int bytes ) {
		return super.cmd( "max_allo", bytes );
	}

}
