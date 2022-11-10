package com.viiyue.ffmpeg.filter.video;

import com.viiyue.ffmpeg.annotation.Function;
import com.viiyue.ffmpeg.filter.AbstractFunction;
import com.viiyue.ffmpeg.util.Assert;

/**
 * Apply Overcomplete Wavelet denoiser
 * 
 * @author tangxbai
 * @since 2022/07/19
 * @see <a href="https://ffmpeg.org/ffmpeg-filters.html#owdenoise">ffmpeg-filters#owdenoise</a>
 */
@Function( "owdenoise" )
public class OwDenoise extends AbstractFunction<OwDenoise> {

	// Don't let anyone instantiate this class
	private OwDenoise() {}

	/**
	 * Quickly create an instances of {@link OwDenoise}
	 * 
	 * @return the {@link OwDenoise} instance
	 */
	public static final OwDenoise of() {
		return new OwDenoise();
	}

	/**
	 * Larger depth values will denoise lower frequency components more, but slow down filtering. Must be an
	 * int in the range 8-16, default is <b>8</b>.
	 * 
	 * @apiNote (int) depth
	 * @param value the depth value
	 * @return the {@link OwDenoise} instance
	 */
	public OwDenoise depth( int value ) {
		Assert.rangeCheck( value, 8, 16 );
		return super.addArg( "depth", value );
	}

	/**
	 * Set luma strength. Must be a double value in the range 0-1000, default is <b>1.0</b>.
	 * 
	 * @apiNote (int) luma_strength, ls
	 * @param value the depth value
	 * @return the {@link OwDenoise} instance
	 */
	public OwDenoise lumaStrength( double value ) {
		Assert.rangeCheck( value, 0, 1000 );
		return super.addArg( "ls", value ); // luma_strength, ls
	}

	/**
	 * Set chroma strength. Must be a double value in the range 0-1000, default is <b>1.0</b>.
	 * 
	 * @apiNote (int) luma_strength, cs
	 * @param value the depth value
	 * @return the {@link OwDenoise} instance
	 */
	public OwDenoise chromaStrength( double value ) {
		Assert.rangeCheck( value, 0, 1000 );
		return super.addArg( "cs", value ); // chroma_strength, cs
	}

}
