package com.viiyue.ffmpeg.filter.video;

import com.viiyue.ffmpeg.annotation.Function;
import com.viiyue.ffmpeg.filter.AbstractFunction;
import com.viiyue.ffmpeg.util.Assert;

/**
 * Apply limited difference filter using second and optionally third video stream
 * 
 * @author tangxbai
 * @since 2022/07/13
 * @see <a href="https://ffmpeg.org/ffmpeg-filters.html#limitdiff">ffmpeg-filters#limitdiff</a>
 */
@Function( "limitdiff" )
public class LimitDifference extends AbstractFunction<LimitDifference> {

	// Don't let anyone instantiate this class
	private LimitDifference() {}

	/**
	 * Quickly create an instances of {@link LimitDifference}
	 * 
	 * @return the {@link LimitDifference} instance
	 */
	public static final LimitDifference of() {
		return new LimitDifference();
	}

	/**
	 * <p>
	 * Set the threshold to use when allowing certain differences between video streams. Any absolute
	 * difference value lower or exact than this threshold will pick pixel components from first video stream.
	 * 
	 * <p>
	 * This threshold value allowed range is from 0 to 1, and default value is <b>0.00392157</b>.
	 * 
	 * @apiNote (double) threshold
	 * @param value the specified threshold
	 * @return the {@link LimitDifference} instance
	 */
	public LimitDifference threshold( double value ) {
		Assert.rangeCheck( value, 0.0, 1.0 );
		return super.addArg( "threshold", value );
	}

	/**
	 * <p>
	 * Set the elasticity of soft thresholding when processing video streams. This value multiplied with first
	 * one sets second threshold. Any absolute difference value greater or exact than second threshold will
	 * pick pixel components from second video stream. For values between those two threshold linear
	 * interpolation between first and second video stream will be used.
	 * 
	 * <p>
	 * This threshold value allowed range is from 0 to 10, and default value is <b>2</b>.
	 * 
	 * @apiNote (double) elasticity
	 * @param value the elasticity value
	 * @return the {@link LimitDifference} instance
	 */
	public LimitDifference elasticity( double value ) {
		Assert.rangeCheck( value, 0.0, 1.0 );
		return super.addArg( "elasticity", value );
	}

	/**
	 * Enable the reference (third) video stream processing. By default is {@code false} (disabled). If set,
	 * this video stream will be used for calculating absolute difference with first video stream.
	 * 
	 * @apiNote (boolean) reference
	 * @return the {@link LimitDifference} instance
	 */
	public LimitDifference reference() {
		return super.enable( "reference" );
	}

	/**
	 * Specify which planes will be processed. Defaults to all available. Allowed value range is from 0 to 15,
	 * and default value is <b>15</b>.
	 * 
	 * @apiNote (int) planes
	 * @param value the filter planes
	 * @return the {@link LimitDifference} instance
	 */
	public LimitDifference planes( int value ) {
		Assert.rangeCheck( value, 0, 15 );
		return super.addArg( "planes", value );
	}

}
