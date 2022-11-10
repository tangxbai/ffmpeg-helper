package com.viiyue.ffmpeg.filter.video;

import com.viiyue.ffmpeg.annotation.Function;
import com.viiyue.ffmpeg.filter.AbstractFunction;
import com.viiyue.ffmpeg.util.Assert;

/**
 * Flush video frames from internal cache of frames into a random order. No frame is discarded. Inspired by
 * frei0r nervous filter.
 * 
 * @author tangxbai
 * @since 2022/07/22
 * @see <a href="https://ffmpeg.org/ffmpeg-filters.html#random">ffmpeg-filters#random</a>
 */
@Function( "random" )
public class Random extends AbstractFunction<Random> {

	// Don't let anyone instantiate this class
	private Random() {}

	/**
	 * Quickly create an instances of {@link Random}
	 * 
	 * @return the {@link Random} instance
	 */
	public static final Random of() {
		return new Random();
	}

	/**
	 * Set size in number of frames of internal cache, in range from 2 to 512, default is <b>30</b>.
	 * 
	 * @apiNote (int) frames
	 * @param value the number of frames in cache
	 * @return the {@link Random} instance
	 */
	public Random frames( int value ) {
		Assert.rangeCheck( value, 2, 512 );
		return super.addArg( "frames", value );
	}

	/**
	 * Set seed for random number generator, must be an integer included between 0 and UINT32_MAX. If not
	 * specified, or if explicitly set to less than 0, the filter will try to use a good random seed on a best
	 * effort basis.
	 * 
	 * @apiNote (long) seed
	 * @param value the random seed
	 * @return the {@link Random} instance
	 */
	public Random seed( long value ) {
		return super.addArg( "seed", value );
	}

}
