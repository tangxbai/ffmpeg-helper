package com.viiyue.ffmpeg.executor;

import com.viiyue.ffmpeg.enums.Library;
import com.viiyue.ffmpeg.enums.LogLevel;

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
