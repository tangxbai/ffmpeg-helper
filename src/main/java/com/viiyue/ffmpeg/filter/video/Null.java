package com.viiyue.ffmpeg.filter.video;

import com.viiyue.ffmpeg.annotation.Function;
import com.viiyue.ffmpeg.filter.AbstractFunction;

/**
 * Pass the video source unchanged to the output
 * 
 * @author tangxbai
 * @since 2022/07/19
 * @see <a href="https://ffmpeg.org/ffmpeg-filters.html#null">ffmpeg-filters#null</a>
 */
@Function( "null" )
public class Null extends AbstractFunction<Null> {

	// Don't let anyone instantiate this class
	private Null() {}

}
