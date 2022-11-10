package com.viiyue.ffmpeg.filter.video;

import com.viiyue.ffmpeg.annotation.Function;
import com.viiyue.ffmpeg.common.Const;
import com.viiyue.ffmpeg.enums.PixelFormat;
import com.viiyue.ffmpeg.filter.AbstractFunction;

/**
 * Force {@code libavfilter} not to use any of the specified pixel formats for the input to the next filter.
 * 
 * @author tangxbai
 * @since 2022/07/19
 * @see <a href="https://ffmpeg.org/ffmpeg-filters.html#noformat">ffmpeg-filters#noformat</a>
 */
@Function( "noformat" )
public class NoFormat extends AbstractFunction<NoFormat> {

	// Don't let anyone instantiate this class
	private NoFormat() {}

	/**
	 * Quickly create an instances of {@link NoFormat}
	 * 
	 * @return the {@link NoFormat} instance
	 */
	public static final NoFormat of( PixelFormat ... formats ) {
		return new NoFormat().addArg2( null, Const.LIST_SEPARATOR, formats );
	}

}
