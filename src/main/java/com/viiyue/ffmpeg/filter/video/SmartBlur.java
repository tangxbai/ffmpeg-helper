package com.viiyue.ffmpeg.filter.video;

import com.viiyue.ffmpeg.annotation.Function;
import com.viiyue.ffmpeg.filter.AbstractFunction;
import com.viiyue.ffmpeg.util.Assert;

/**
 * Apply Shape Adaptive Blur
 * 
 * @author tangxbai
 * @since 2022/08/04
 */
@Function( "sab" )
public class SmartBlur extends AbstractFunction<SmartBlur> {

	// Don't let anyone instantiate this class
	private SmartBlur() {}

	/**
	 * Quickly create an instances of {@link Roberts}
	 * 
	 * @return {@link SmartBlur} instance
	 */
	public static final SmartBlur of() {
		return new SmartBlur();
	}

	/**
	 * Set the luma radius. The option value must be a float number in the range [0.1,5.0] that specifies the
	 * variance of the gaussian filter used to blur the image (slower if larger). Default value is <b>1.0</b>.
	 * 
	 * @apiNote (double) luma_radius, lr
	 * @param value the luma radius
	 * @return {@link SmartBlur} instance
	 */
	public SmartBlur lumaRadius( double value ) {
		Assert.rangeCheck( value, 0.1, 5.0 );
		return super.addArg( "lr", value );
	}

	/**
	 * Set the luma strength. The option value must be a float number in the range [-1.0,1.0] that configures
	 * the blurring. A value included in [0.0,1.0] will blur the image whereas a value included in [-1.0,0.0]
	 * will sharpen the image. Default value is <b>1.0</b>.
	 * 
	 * @apiNote (double) luma_strength, ls
	 * @param value the luma strength
	 * @return {@link SmartBlur} instance
	 */
	public SmartBlur lumaStrength( double value ) {
		Assert.rangeCheck( value, -1.0, 1.0 );
		return super.addArg( "ls", value );
	}

	/**
	 * Set the luma threshold used as a coefficient to determine whether a pixel should be blurred or not. The
	 * option value must be an integer in the range [-30,30]. A value of 0 will filter all the image, a value
	 * included in [0,30] will filter flat areas and a value included in [-30,0] will filter edges. Default
	 * value is <b>0</b>.
	 * 
	 * @apiNote (double) luma_threshold, lt
	 * @param value the luma threshold
	 * @return {@link SmartBlur} instance
	 */
	public SmartBlur lumaThreshold( int value ) {
		Assert.rangeCheck( value, -30, 30 );
		return super.addArg( "lt", value );
	}

	/**
	 * Set the chroma radius. The option value must be a float number in the range [-0.9,5.0] that specifies
	 * the variance of the gaussian filter used to blur the image (slower if larger). Default value is
	 * luma_radius.
	 * 
	 * @apiNote (double) chroma_radius, cr
	 * @param value the chroma radius
	 * @return {@link SmartBlur} instance
	 */
	public SmartBlur chromaRadius( double value ) {
		Assert.rangeCheck( value, -0.9, 5.0 );
		return super.addArg( "cr", value );
	}

	/**
	 * Set the chroma strength. The option value must be a float number in the range [-2.0,1.0] that
	 * configures the blurring. A value included in [0.0,1.0] will blur the image whereas a value included in
	 * [-1.0,0.0] will sharpen the image. Default value is {@code luma_strength}.
	 * 
	 * @apiNote (double) chroma_strength, cs
	 * @param value the luma strength
	 * @return {@link SmartBlur} instance
	 */
	public SmartBlur chromaStrength( double value ) {
		Assert.rangeCheck( value, -2.0, 1.0 );
		return super.addArg( "cs", value );
	}

	/**
	 * Set the chroma threshold used as a coefficient to determine whether a pixel should be blurred or not.
	 * The option value must be an integer in the range [-30,30]. A value of 0 will filter all the image, a
	 * value included in [0,30] will filter flat areas and a value included in [-30,0] will filter edges.
	 * Default value is {@code luma_threshold}.
	 * 
	 * @apiNote (double) chroma_threshold, ct
	 * @param value the chroma threshold
	 * @return {@link SmartBlur} instance
	 */
	public SmartBlur chromaThreshold( int value ) {
		Assert.rangeCheck( value, -30, 30 );
		return super.addArg( "ct", value );
	}

}
