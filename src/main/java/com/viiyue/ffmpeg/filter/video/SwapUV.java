package com.viiyue.ffmpeg.filter.video;

import com.viiyue.ffmpeg.annotation.Function;
import com.viiyue.ffmpeg.filter.AbstractFunction;

/**
 * Swap U & V plane
 * 
 * @author tangxbai
 * @since 2022/08/05
 * @see <a href="https://ffmpeg.org/ffmpeg-filters.html#swapuv">ffmpeg-filters#swapuv</a>
 */
@Function( "swapuv" )
public class SwapUV extends AbstractFunction<SwapUV> {

	// Don't let anyone instantiate this class
	private SwapUV() {}

}
