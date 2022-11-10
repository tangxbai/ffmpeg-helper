package com.viiyue.ffmpeg.filter.video;

import com.viiyue.ffmpeg.annotation.Function;
import com.viiyue.ffmpeg.filter.AbstractFunction;

/**
 * <p>
 * Scale the input by 2x and smooth using the Super2xSaI (Scale and Interpolate) pixel art scaling algorithm.
 * 
 * <p>
 * Useful for enlarging pixel art images without reducing sharpness.
 * 
 * @author tangxbai
 * @since 2022/08/05
 * @see <a href="https://ffmpeg.org/ffmpeg-filters.html#super2xsai">ffmpeg-filters#super2xsai</a>
 */
@Function( "super2xsai" )
public class Super2Xsai extends AbstractFunction<Super2Xsai> {

	// Don't let anyone instantiate this class
	private Super2Xsai() {}

}
