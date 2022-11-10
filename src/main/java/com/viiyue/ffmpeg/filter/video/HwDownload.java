package com.viiyue.ffmpeg.filter.video;

import com.viiyue.ffmpeg.annotation.Function;
import com.viiyue.ffmpeg.filter.AbstractFunction;

/**
 * <p>
 * Download hardware frames to system memory
 * 
 * <p>
 * The input must be in hardware frames, and the output a non-hardware format. Not all formats will be
 * supported on the output - it may be necessary to insert an additional format filter immediately following
 * in the graph to get the output in a supported format.
 *
 * @author tangxbai
 * @since 2022/07/11
 * @see <a href="https://ffmpeg.org/ffmpeg-filters.html#hwdownload-1">ffmpeg-filters#hwdownload</a>
 */
@Function( "hwdownload" )
public class HwDownload extends AbstractFunction<HwDownload> {

	// Don't let anyone instantiate this class
	private HwDownload() {}

}
