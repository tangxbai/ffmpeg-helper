package com.viiyue.ffmpeg.filter.video;

import com.viiyue.ffmpeg.annotation.Function;
import com.viiyue.ffmpeg.filter.AbstractFunction;

/**
 * Extract the alpha component from the input as a grayscale video. This is especially useful with the
 * {@code alphamerge} filter.
 * 
 * @author tangxbai
 * @since 2022/06/02
 * @see <a href="https://ffmpeg.org/ffmpeg-filters.html#alphaextract">ffmpeg-filters#alphaextract</a>
 */
@Function( "alphaextract" )
public class AlphaExtract extends AbstractFunction<AlphaExtract> {

	// Don't let anyone instantiate this class
	private AlphaExtract() {}

}
