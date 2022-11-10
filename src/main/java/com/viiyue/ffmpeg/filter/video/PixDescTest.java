package com.viiyue.ffmpeg.filter.video;

import com.viiyue.ffmpeg.annotation.Function;
import com.viiyue.ffmpeg.filter.AbstractFunction;

/**
 * Pixel format descriptor test filter, mainly useful for internal testing. The output video should be equal
 * to the input video.
 * 
 * @author tangxbai
 * @since 2022/07/20
 * @see <a href="https://ffmpeg.org/ffmpeg-filters.html#pixdesctest">ffmpeg-filters#pixdesctest</a>
 */
@Function( "pixdesctest" )
public class PixDescTest extends AbstractFunction<PixDescTest> {

	// Don't let anyone instantiate this class
	private PixDescTest() {}

}
