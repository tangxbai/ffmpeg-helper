package com.viiyue.ffmpeg.filter.video;

import com.viiyue.ffmpeg.annotation.Function;
import com.viiyue.ffmpeg.common.AbstractEnum;
import com.viiyue.ffmpeg.filter.AbstractFunction;
import com.viiyue.ffmpeg.util.Assert;

/**
 * <p>
 * Apply custom color maps to video stream.
 * 
 * <p>
 * This filter needs three input video streams. First stream is video stream that is going to be filtered out.
 * Second and third video stream specify color patches for source color to target color mapping.
 * 
 * @author tangxbai
 * @since 2022/06/16
 * @see <a href="https://ffmpeg.org/ffmpeg-filters.html#colormap">ffmpeg-filters#colormap</a>
 */
@Function( "colormap" )
public class ColorMap extends AbstractFunction<ColorMap> {

	// Don't let anyone instantiate this class
	private ColorMap() {}

	/**
	 * Quickly create an instances of {@link ColorMap}
	 * 
	 * @return the {@link ColorMap} instance
	 */
	public static final ColorMap of() {
		return new ColorMap();
	}

	/**
	 * Set the source and target video stream patch size in pixels.
	 * 
	 * @apiNote (int) patch_size
	 * @param pixels the video stream patch size
	 * @return the {@link ColorMap} instance
	 */
	public ColorMap patchSize( int pixels ) {
		return super.addArg( "patch_size", pixels );
	}

	/**
	 * Set the max number of used patches from source and target video stream.
	 * 
	 * Default value is number of patches available in additional video streams. Max allowed number of patches
	 * is 64.
	 * 
	 * @apiNote (int) nb_patches
	 * @param pixels the number of patches available
	 * @return the {@link ColorMap} instance
	 */
	public ColorMap patches( int pixels ) {
		Assert.rangeCheck( pixels, 0, 64 );
		return super.addArg( "nb_patches", pixels );
	}

	/**
	 * Set the adjustments used for target colors, it can be {@code relative} or {@code absolute}, defaults is
	 * {@code absolute}.
	 * 
	 * @apiNote (flags) type
	 * @param type the number of patches available
	 * @return the {@link ColorMap} instance
	 */
	public ColorMap type( Adjustment type ) {
		return super.addArg( "type", type );
	}

	/**
	 * Set the kernel used to measure color differences between mapped colors
	 * 
	 * @apiNote (flags) kernel
	 * @param type the number of patches available
	 * @return the {@link ColorMap} instance
	 */
	public ColorMap kernel( Kernel kernel ) {
		return super.addArg( "kernel", kernel );
	}

	/**
	 * Adjustment for target color, it can be "RELATIVE" or "ABSOLUTE".
	 *
	 * @author tangxbai
	 * @since 2022/06/16
	 */
	public enum Adjustment implements AbstractEnum {
		RELATIVE, ABSOLUTE
	}

	/**
	 * Measures the color difference between the mapped color kernels, it can be "EUCLIDEAN" or "WEUCLIDEAN".
	 * 
	 * @author tangxbai
	 * @since 2022/06/16
	 */
	public enum Kernel implements AbstractEnum {
		EUCLIDEAN, WEUCLIDEAN
	}

}
