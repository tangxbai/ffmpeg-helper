package com.viiyue.ffmpeg.filter.video;

import com.viiyue.ffmpeg.annotation.Function;
import com.viiyue.ffmpeg.filter.AbstractFunction;
import com.viiyue.ffmpeg.util.Assert;

/**
 * <p>
 * Denoise frames using Non-Local Means algorithm.
 * 
 * <p>
 * Each pixel is adjusted by looking for other pixels with similar contexts. This context similarity is
 * defined by comparing their surrounding patches of size pxp. Patches are searched in an area of rxr around
 * the pixel.
 * 
 * <p>
 * Note that the research area defines centers for patches, which means some patches will be made of pixels
 * outside that research area.
 * 
 * @author tangxbai
 * @since 2022/07/19
 * @see <a href="https://ffmpeg.org/ffmpeg-filters.html#negate">ffmpeg-filters#negate</a>
 */
@Function( "negate" )
public class NlMeans extends AbstractFunction<NlMeans> {

	// Don't let anyone instantiate this class
	private NlMeans() {}

	/**
	 * Quickly create an instances of {@link NlMeans}
	 * 
	 * @return the {@link NlMeans} instance
	 */
	public static final NlMeans of() {
		return new NlMeans();
	}

	/**
	 * Set denoising strength. Default is <b>1.0</b>. Must be in range [1.0, 30.0].
	 * 
	 * @apiNote (double) s
	 * @param value the denoising strength
	 * @return the {@link NlMeans} instance
	 */
	public NlMeans strength( double value ) {
		Assert.rangeCheck( value, 1, 30 );
		return super.addArg( "s", value );
	}

	/**
	 * Set patch size. Default is <b>7</b>. Must be in range [0, 99].
	 * 
	 * @apiNote (int) p
	 * @param value the patch size
	 * @return the {@link NlMeans} instance
	 */
	public NlMeans patch( double value ) {
		Assert.rangeCheck( value, 0, 99 );
		return super.addArg( "p", value );
	}

	/**
	 * Same as {@code p} but for chroma planes. The default value is <b>0</b> and means automatic.
	 * 
	 * @apiNote (int) pc
	 * @param value the patch size for chroma planes
	 * @return the {@link NlMeans} instance
	 */
	public NlMeans patchChroma( double value ) {
		Assert.rangeCheck( value, 0, 99 );
		return super.addArg( "pc", value );
	}

	/**
	 * Set research size. Default is <b>15</b>. Must be odd number in range [0, 99].
	 * 
	 * @apiNote (int) r
	 * @param value the research size
	 * @return the {@link NlMeans} instance
	 */
	public NlMeans research( double value ) {
		Assert.rangeCheck( value, 0, 99 );
		return super.addArg( "r", value );
	}

	/**
	 * Same as {@code r} but for chroma planes. The default value is <b>0</b> and means automatic.
	 * 
	 * @apiNote (int) rc
	 * @param value the research size for chroma plane
	 * @return the {@link NlMeans} instance
	 */
	public NlMeans researchChroma( double value ) {
		Assert.rangeCheck( value, 0, 99 );
		return super.addArg( "rc", value );
	}

}
