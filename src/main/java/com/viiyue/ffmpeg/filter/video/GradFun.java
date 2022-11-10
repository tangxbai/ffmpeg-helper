package com.viiyue.ffmpeg.filter.video;

import com.viiyue.ffmpeg.annotation.Function;
import com.viiyue.ffmpeg.filter.AbstractFunction;
import com.viiyue.ffmpeg.util.Assert;

/**
 * <p>
 * Fix the banding artifacts that are sometimes introduced into nearly flat regions by truncation to 8-bit
 * color depth. Interpolate the gradients that should go where the bands are, and dither them.
 * 
 * <p>
 * It is designed for playback only. Do not use it prior to lossy compression, because compression tends to
 * lose the dither and bring back the bands.
 *
 * @author tangxbai
 * @since 2022/07/07
 * @see <a href="https://ffmpeg.org/ffmpeg-filters.html#geq">ffmpeg-filters#geq</a>
 */
@Function( "geq" )
public class GradFun extends AbstractFunction<GradFun> {

	// Don't let anyone instantiate this class
	private GradFun() {}

	/**
	 * Quickly create an instances of {@link GradFun}
	 * 
	 * @return the {@link GradFun} instance
	 */
	public static final GradFun of() {
		return new GradFun();
	}

	/**
	 * The neighborhood to fit the gradient to. A larger radius makes for smoother gradients, but also
	 * prevents the filter from modifying the pixels near detailed regions. Acceptable values are 4-32; the
	 * default value is <b>16</b>. Out-of-range values will be clipped to the valid range.
	 * 
	 * @apiNote (double) radius
	 * @param value the neighborhood to fit the gradient to
	 * @return the {@link GradFun} instance
	 */
	public GradFun radius( int value ) {
		Assert.rangeCheck( value, 4, 32 );
		return super.addArg( "radius", value );
	}

	/**
	 * The maximum amount by which the filter will change any one pixel. This is also the threshold for
	 * detecting nearly flat regions. Acceptable values range from 0.51 to 64; the default value is <b>1.2</>.
	 * Out-of-range values will be clipped to the valid range.
	 * 
	 * @apiNote (double) strength
	 * @param value the maximum amount by which the filter will change any one pixel
	 * @return the {@link GradFun} instance
	 */
	public GradFun strength( double value ) {
		Assert.rangeCheck( value, 0.51D, 64D );
		return super.addArg( "strength", value );
	}

}
