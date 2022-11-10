package com.viiyue.ffmpeg.filter.video;

import com.viiyue.ffmpeg.annotation.Function;
import com.viiyue.ffmpeg.filter.AbstractFunction;
import com.viiyue.ffmpeg.util.Assert;

/**
 * Loop video frames
 * 
 * @author tangxbai
 * @since 2022/07/13
 * @see <a href="https://ffmpeg.org/ffmpeg-filters.html#loop">ffmpeg-filters#loop</a>
 */
@Function( "loop" )
public class Loop extends AbstractFunction<Loop> {

	// Don't let anyone instantiate this class
	private Loop() {}

	/**
	 * Quickly create an instances of {@link Loop} and set the number of loops
	 * 
	 * @apiNote (int) loop
	 * @param value the loop times
	 * @return the {@link Loop} instance
	 */
	public static final Loop the( int value ) {
		return new Loop().addArg( "loop", value );
	}

	/**
	 * Set maximal size in number of frames. This value allowed range is from 0 to 32767, default value is
	 * <b>0</b>.
	 * 
	 * @apiNote (double) size
	 * @param value the maximal size in number of frames
	 * @return the {@link Loop} instance
	 */
	public Loop size( int value ) {
		Assert.rangeCheck( value, 0, 32767 );
		return super.addArg( "size", value );
	}

	/**
	 * Set first frame of loop, default value is <b>0</b>.
	 * 
	 * @apiNote (double) size
	 * @param value the maximal size in number of frames
	 * @return the {@link Loop} instance
	 */
	public Loop start( int value ) {
		return super.addArg( "size", value );
	}

}
