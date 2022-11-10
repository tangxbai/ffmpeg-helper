package com.viiyue.ffmpeg.filter.video;

import com.viiyue.ffmpeg.annotation.Function;

/**
 * Compute a look-up table for binding each pixel component input value to an output value, and apply it to
 * the input video.
 * 
 * lutyuv applies a lookup table to a YUV input video, lutrgb to an RGB input video.
 * 
 * @author tangxbai
 * @since 2022/07/13
 * @see <a href="https://ffmpeg.org/ffmpeg-filters.html#lut_002c-lutrgb_002c-lutyuv">ffmpeg-filters#lutyuv</a>
 */
@Function( "lutyuv" )
public class LutYuv extends AbstractLut<LutYuv> {

	// Don't let anyone instantiate this class
	private LutYuv() {}

	/**
	 * Quickly create an instances of {@link LutYuv}
	 * 
	 * @return the {@link LutYuv} instance
	 */
	public static final LutYuv of() {
		return new LutYuv();
	}

}
