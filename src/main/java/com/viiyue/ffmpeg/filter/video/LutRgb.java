package com.viiyue.ffmpeg.filter.video;

import com.viiyue.ffmpeg.annotation.Function;

/**
 * Apply a 3D LUT to an input video
 * 
 * @author tangxbai
 * @since 2022/07/13
 * @see <a href="https://ffmpeg.org/ffmpeg-filters.html#lut_002c-lutrgb_002c-lutyuv">ffmpeg-filters#lutrgb</a>
 */
@Function( "lutrgb" )
public class LutRgb extends AbstractLut<LutRgb> {

	// Don't let anyone instantiate this class
	private LutRgb() {}

	/**
	 * Quickly create an instances of {@link LutRgb}
	 * 
	 * @return the {@link LutRgb} instance
	 */
	public static final LutRgb of() {
		return new LutRgb();
	}

}
