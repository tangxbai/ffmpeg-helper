package com.viiyue.ffmpeg.filter.video;

import com.viiyue.ffmpeg.annotation.Function;
import com.viiyue.ffmpeg.filter.AbstractFunction;
import com.viiyue.ffmpeg.util.Assert;

/**
 * <p>
 * Determines blurriness of frames without altering the input frames.
 * 
 * <p>
 * Based on Marziliano, Pina, et al. "A no-reference perceptual blur metric." Allows for a block-based
 * abbreviation.
 *
 * @author tangxbai
 * @since 2022/06/09
 * @see <a href="https://ffmpeg.org/ffmpeg-filters.html#blurdetect-1">ffmpeg-filters#blurdetect</a>
 */
@Function( "blurdetect" )
public class BlurDetect extends AbstractFunction<BlurDetect> {

	// Don't let anyone instantiate this class
	private BlurDetect() {}

	/**
	 * Quickly create an instances of {@link BlurDetect}
	 * 
	 * @return the {@link BlurDetect} instance
	 */
	public static final BlurDetect the() {
		return new BlurDetect();
	}

	/**
	 * Define the radius to search around an edge pixel for local maxima.
	 * 
	 * @apiNote (int) radius
	 * @param radius the search radius
	 * @return the {@link BlurDetect} instance
	 */
	public BlurDetect radius( int radius ) {
		return super.addArg( "radius", radius );
	}

	/**
	 * <p>
	 * Set low threshold value used by the Canny thresholding algorithm.
	 * 
	 * <p>
	 * Threshold values must be chosen in the range [0,1], and should be lesser or equal to high, default
	 * value for low is 20/255.
	 * 
	 * @apiNote (double) low
	 * @param threshold the low threshold
	 * @return the {@link BlurDetect} instance
	 */
	public BlurDetect low( double threshold ) {
		Assert.rangeCheck( threshold, 0, 1 );
		return super.addArg( "low", threshold );
	}

	/**
	 * <p>
	 * Set high threshold value used by the Canny thresholding algorithm.
	 * 
	 * <p>
	 * Threshold values must be chosen in the range [0,1], and should be greater or equal to low, default
	 * value for low is 50/255.
	 * 
	 * @apiNote (double) high
	 * @param threshold the high threshold
	 * @return the {@link BlurDetect} instance
	 */
	public BlurDetect high( double threshold ) {
		Assert.rangeCheck( threshold, 0, 1 );
		return super.addArg( "high", threshold );
	}

	/**
	 * Determine blurriness only for the most significant blocks, given in percentage.
	 * 
	 * @apiNote (double) block_pct
	 * @param percentage the blurriness percentage
	 * @return the {@link BlurDetect} instance
	 */
	public BlurDetect bloackPercentage( double percentage ) {
		return super.addArg( "block_pct", percentage );
	}

	/**
	 * Determine blurriness for blocks of width block_width. If set to any value smaller 1, no blocks are used
	 * and the whole image is processed as one no matter of block_height.
	 * 
	 * @apiNote (double) block_width
	 * @param width the blurriness block width
	 * @return the {@link BlurDetect} instance
	 */
	public BlurDetect blockWidth( double width ) {
		return super.addArg( "block_width", width );
	}

	/**
	 * Determine blurriness for blocks of height block_height. If set to any value smaller 1, no blocks are
	 * used and the whole image is processed as one no matter of block_width.
	 * 
	 * @apiNote (double) block_height
	 * @param height the blurriness block height
	 * @return the {@link BlurDetect} instance
	 */
	public BlurDetect blockHeight( double height ) {
		return super.addArg( "block_height", height );
	}

	/**
	 * Set planes to filter, default is first only.
	 * 
	 * @apiNote (int) planes
	 * @param plane the plane value
	 * @return the {@link BlurDetect} instance
	 */
	public BlurDetect planes( int plane ) {
		return super.addArg( "planes", plane );
	}

}
