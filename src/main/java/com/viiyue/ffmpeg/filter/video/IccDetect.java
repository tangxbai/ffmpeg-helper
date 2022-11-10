package com.viiyue.ffmpeg.filter.video;

import com.viiyue.ffmpeg.annotation.Function;
import com.viiyue.ffmpeg.filter.AbstractFunction;

/**
 * Detect the colorspace from an embedded ICC profile (if present), and update the frame’s tags accordingly.
 *
 * @author tangxbai
 * @since 2022/07/11
 * @see <a href="https://ffmpeg.org/ffmpeg-filters.html#iccdetect">ffmpeg-filters#iccdetect</a>
 */
@Function( "iccdetect" )
public class IccDetect extends AbstractFunction<IccDetect> {

	// Don't let anyone instantiate this class
	private IccDetect() {}

}
