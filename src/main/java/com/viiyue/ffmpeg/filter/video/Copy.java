package com.viiyue.ffmpeg.filter.video;

import com.viiyue.ffmpeg.annotation.Function;
import com.viiyue.ffmpeg.filter.AbstractFunction;

/**
 * Copy the input video source unchanged to the output. This is mainly useful for testing purposes.
 * 
 * @author tangxbai
 * @since 2022/06/17
 * @see <a href="https://ffmpeg.org/ffmpeg-filters.html#copy">ffmpeg-filters#copy</a>
 */
@Function( "copy" )
public class Copy extends AbstractFunction<Copy> {

	// Don't let anyone instantiate this class
	private Copy() {}

}
