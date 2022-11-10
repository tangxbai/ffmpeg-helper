package com.viiyue.ffmpeg.filter.video;

import com.viiyue.ffmpeg.annotation.Function;
import com.viiyue.ffmpeg.filter.AbstractFunction;
import com.viiyue.ffmpeg.util.Assert;

/**
 * <p>
 * Compute and draw a color distribution histogram for the input video across time.
 * 
 * <p>
 * Unlike histogram video filter which only shows histogram of single input frame at certain time, this filter
 * shows also past histograms of number of frames defined by {@code width} option.
 * 
 * <p>
 * The computed histogram is a representation of the color component distribution in an image.
 * 
 * @author tangxbai
 * @since 2022/08/05
 * @see <a href="https://ffmpeg.org/ffmpeg-filters.html#threshold">ffmpeg-filters#threshold</a>
 */
@Function( "threshold" )
public class Threshold extends AbstractFunction<Threshold> {

	// Don't let anyone instantiate this class
	private Threshold() {}

	/**
	 * <p>
	 * Quickly create an instances of {@link Threshold}
	 * 
	 * <p>
	 * Set planes to filter. Value range allowed is from 0 to 15, default value is <b>15</b>, all planes will
	 * be processed.
	 * 
	 * @apiNote (int) planes
	 * @param value the plane filter
	 * @return the {@link Threshold} instance
	 */
	public static final Threshold of( int value ) {
		Assert.rangeCheck( value, 0, 15 );
		return new Threshold().addArg( "planes", value );
	}

}
