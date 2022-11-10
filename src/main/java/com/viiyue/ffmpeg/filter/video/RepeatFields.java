package com.viiyue.ffmpeg.filter.video;

import com.viiyue.ffmpeg.annotation.Function;
import com.viiyue.ffmpeg.filter.AbstractFunction;

/**
 * This filter uses the repeat_field flag from the Video ES headers and hard repeats fields based on its
 * value.
 * 
 * @author tangxbai
 * @since 2022/08/01
 * @see <a href="https://ffmpeg.org/ffmpeg-filters.html#repeatfields">ffmpeg-filters#repeatfields</a>
 */
@Function( "repeatfields" )
public class RepeatFields extends AbstractFunction<RepeatFields> {

	// Don't let anyone instantiate this class
	private RepeatFields() {}

}
