package com.viiyue.ffmpeg.filter.video;

import com.viiyue.ffmpeg.annotation.Function;
import com.viiyue.ffmpeg.filter.AbstractFunction;

/**
 * <p>
 * Reverse a video clip
 * 
 * <p>
 * Warning: This filter requires memory to buffer the entire clip, so trimming is suggested.
 * 
 * @author tangxbai
 * @since 2022/08/01
 * @see <a href="https://ffmpeg.org/ffmpeg-filters.html#reverse">ffmpeg-filters#reverse</a>
 */
@Function( "reverse" )
public class Reverse extends AbstractFunction<Reverse> {

	// Don't let anyone instantiate this class
	private Reverse() {}

}
