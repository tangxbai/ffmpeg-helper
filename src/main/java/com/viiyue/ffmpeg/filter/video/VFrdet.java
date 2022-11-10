package com.viiyue.ffmpeg.filter.video;

import com.viiyue.ffmpeg.annotation.Function;
import com.viiyue.ffmpeg.filter.AbstractFunction;

/**
 * <p>
 * Detect variable frame rate video.
 * 
 * <p>
 * This filter tries to detect if the input is variable or constant frame rate.
 * 
 * <p>
 * At end it will output number of frames detected as having variable delta pts, and ones with constant delta
 * pts. If there was frames with variable delta, than it will also show min, max and average delta
 * encountered.
 * 
 * @author tangxbai
 * @since 2022/10/13
 * @see <a href="https://ffmpeg.org/ffmpeg-filters.html#vfrdet">ffmpeg-filters#vfrdet</a>
 */
@Function( "vfrdet" )
public class VFrdet extends AbstractFunction<VFrdet> {

	// Don't let anyone instantiate this class
	private VFrdet() {}

}
