package com.viiyue.ffmpeg.filter.video;

import com.viiyue.ffmpeg.annotation.Function;
import com.viiyue.ffmpeg.common.Const;
import com.viiyue.ffmpeg.enums.PixelFormat;
import com.viiyue.ffmpeg.filter.AbstractColorFunction;

/**
 * Convert the input video to one of the specified pixel formats. Libavfilter will try to pick one that is
 * suitable as input to the next filter.
 * 
 * @author tangxbai
 * @since 2022/07/06
 * @see <a href="https://ffmpeg.org/ffmpeg-filters.html#format-1">ffmpeg-filters#format</a>
 */
@Function( "format" )
public class Format extends AbstractColorFunction<Format> {

	// Don't let anyone instantiate this class
	private Format() {}

	/**
	 * Quickly create an instances of {@link Format}
	 * 
	 * @return the {@link Format} instance
	 */
	public static final Format of( PixelFormat ... formats ) {
		return new Format().addArg2( null, Const.LIST_SEPARATOR, formats );
	}

}
