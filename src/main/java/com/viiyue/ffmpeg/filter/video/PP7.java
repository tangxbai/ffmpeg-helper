package com.viiyue.ffmpeg.filter.video;

import com.viiyue.ffmpeg.annotation.Function;
import com.viiyue.ffmpeg.filter.AbstractFunction;
import com.viiyue.ffmpeg.util.Assert;

/**
 * Apply Postprocessing filter 7. It is variant of the spp filter, similar to spp = 6 with 7 point DCT, where
 * only the center sample is used after IDCT.
 * 
 * @author tangxbai
 * @since 2022/07/20
 * @see <a href="https://ffmpeg.org/ffmpeg-filters.html#pp7">ffmpeg-filters#pp7</a>
 */
@Function( "pp7" )
public class PP7 extends AbstractFunction<PP7> {

	// Don't let anyone instantiate this class
	private PP7() {}

	/**
	 * Quickly create an instances of {@link PP7}
	 * 
	 * @return the {@link PP7} instance
	 */
	public static final PP7 of() {
		return new PP7();
	}

	/**
	 * Force a constant quantization parameter. It accepts an integer in range 0 to 64. If not set, the filter
	 * will use the QP from the video stream (if available).
	 * 
	 * @apiNote (int) qp
	 * @param value the quantization parameter
	 * @return the {@link PP7} instance
	 */
	public PP7 qp( int value ) {
		Assert.rangeCheck( value, 0, 64 );
		return super.addArg( "qp", value );
	}

	/**
	 * Set thresholding mode
	 * 
	 * @apiNote (flags) mode
	 * @param mode the thresholding mode
	 * @return the {@link PP7} instance
	 * @see Threshold
	 */
	public PP7 mode( Threshold mode ) {
		return super.addArg( "mode", mode );
	}

}
