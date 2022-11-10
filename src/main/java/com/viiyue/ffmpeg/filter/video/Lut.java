package com.viiyue.ffmpeg.filter.video;

import com.viiyue.ffmpeg.annotation.Function;

/**
 * Compute a look-up table for binding each pixel component input value to an output value, and apply it to
 * the input video.
 * 
 * @author tangxbai
 * @since 2022/07/13
 * @see <a href="https://ffmpeg.org/ffmpeg-filters.html#lut_002c-lutrgb_002c-lutyuv">ffmpeg-filters#lut</a>
 */
@Function( "lut" )
public class Lut extends AbstractLut<Lut> {

	// Don't let anyone instantiate this class
	private Lut() {}

	/**
	 * Quickly create an instances of {@link Lut}
	 * 
	 * @return the {@link Lut} instance
	 */
	public static final Lut of() {
		return new Lut();
	}

}
