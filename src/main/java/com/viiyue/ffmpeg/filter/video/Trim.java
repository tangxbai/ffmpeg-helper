package com.viiyue.ffmpeg.filter.video;

import com.viiyue.ffmpeg.annotation.Function;
import com.viiyue.ffmpeg.filter.AbstractColorFunction;

/**
 * Trim the input so that the output contains one continuous subpart of the input
 * 
 * @author tangxbai
 * @since 2022/10/08
 * @see <a href="https://ffmpeg.org/ffmpeg-filters.html#trim">ffmpeg-filters#trim</a>
 */
@Function( "trim" )
public class Trim extends AbstractColorFunction<Trim> {

	// Don't let anyone instantiate this class
	private Trim() {}

	/**
	 * Quickly create an instances of {@link Trim}
	 * 
	 * @return the {@link Trim} instance
	 */
	public static final Trim of() {
		return new Trim();
	}

	/**
	 * <p>
	 * Specify the time of the start of the kept section, i.e. the frame with the timestamp start will be the
	 * first frame in the output.
	 * 
	 * <p>
	 * See <a href="https://ffmpeg.org/ffmpeg-utils.html#time-duration-syntax">(ffmpeg-utils)the Time duration
	 * section in the ffmpeg-utils(1) manual</a> for the accepted syntax
	 * 
	 * @apiNote (duration) start
	 * @param start the timestamp of the first frame that should be passed
	 * @return the {@link Trim} instance
	 */
	public Trim start( String expression ) {
		return super.addArg( "start", expression );
	}

	/**
	 * <p>
	 * Specify the time of the first frame that will be dropped, i.e. the frame immediately preceding the one
	 * with the timestamp end will be the last frame in the output.
	 * 
	 * <p>
	 * See <a href="https://ffmpeg.org/ffmpeg-utils.html#time-duration-syntax">(ffmpeg-utils)the Time duration
	 * section in the ffmpeg-utils(1) manual</a> for the accepted syntax
	 * 
	 * @apiNote (duration) end
	 * @param start the timestamp of the first frame that should be dropped again
	 * @return the {@link Trim} instance
	 */
	public Trim end( String expression ) {
		return super.addArg( "end", expression );
	}

	/**
	 * This is the same as start, except this option sets the start timestamp in timebase units instead of
	 * seconds.
	 * 
	 * @apiNote (int) start_pts
	 * @param start_pts the timestamp of the first frame that should be passed
	 * @return the {@link Trim} instance
	 */
	public Trim startPts( int value ) {
		return super.addArg( "start_pts", value );
	}

	/**
	 * This is the same as end, except this option sets the end timestamp in timebase units instead of
	 * seconds.
	 * 
	 * @apiNote (int) end_pts
	 * @param end_pts the timestamp of the first frame that should be dropped again
	 * @return the {@link Trim} instance
	 */
	public Trim endPts( int value ) {
		return super.addArg( "end_pts", value );
	}

	/**
	 * <p>
	 * The maximum duration of the output in seconds
	 * 
	 * <p>
	 * See <a href="https://ffmpeg.org/ffmpeg-utils.html#time-duration-syntax">(ffmpeg-utils)the Time duration
	 * section in the ffmpeg-utils(1) manual</a> for the accepted syntax
	 * 
	 * @apiNote (duration) duration
	 * @param start the maximum duration of the output
	 * @return the {@link Trim} instance
	 */
	public Trim duration( String expression ) {
		return super.addArg( "duration", expression );
	}

	/**
	 * The number of the first frame that should be passed to the output
	 * 
	 * @apiNote (int) start_frame
	 * @param start_pts the number of the first frame that should be passed to the output
	 * @return the {@link Trim} instance
	 */
	public Trim startFrame( int value ) {
		return super.addArg( "start_frame", value );
	}

	/**
	 * The number of the first frame that should be dropped
	 * 
	 * @apiNote (int) end_frame
	 * @param end_pts the number of the first frame that should be dropped again
	 * @return the {@link Trim} instance
	 */
	public Trim endFrame( int value ) {
		return super.addArg( "end_frame", value );
	}

}
