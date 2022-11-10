package com.viiyue.ffmpeg.filter.video;

import com.viiyue.ffmpeg.annotation.Function;

/**
 * Apply a 3D LUT to an input video
 * 
 * @author tangxbai
 * @since 2022/07/13
 * @see <a href= "https://ffmpeg.org/ffmpeg-filters.html#lut2_002c-tlut2">ffmpeg-filters#tlut2</a>
 */
@Function( "lut2" )
public class Tlut2 extends AbstractLut2<Tlut2> {

	// Don't let anyone instantiate this class
	private Tlut2() {}

	/**
	 * Quickly create an instances of {@link Tlut2} and set the 1D LUT file name
	 * 
	 * @return the {@link Tlut2} instance
	 */
	public static final Tlut2 of() {
		return new Tlut2();
	}

}
