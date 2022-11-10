package com.viiyue.ffmpeg.filter.video;

import com.viiyue.ffmpeg.annotation.Function;
import com.viiyue.ffmpeg.common.Const;
import com.viiyue.ffmpeg.enums.PlaneComponent;
import com.viiyue.ffmpeg.filter.AbstractFunction;

/**
 * Extract color channel components from input video stream into separate grayscale video streams
 * 
 * @author tangxbai
 * @since 2022/06/30
 * @see <a href="https://ffmpeg.org/ffmpeg-filters.html#extractplanes">ffmpeg-filters#extractplanes</a>
 */
@Function( "extractplanes" )
public class ExtractPlanes extends AbstractFunction<ExtractPlanes> {

	// Don't let anyone instantiate this class
	private ExtractPlanes() {}

	/**
	 * <p>
	 * Quickly create an instances of {@link ExtractPlanes} and set plane(s) to extract
	 * 
	 * @apiNote (flags) plane
	 * @param value the exposure correction
	 * @return the {@link ExtractPlanes} instance
	 * @see PlaneComponent
	 */
	public static final ExtractPlanes of( PlaneComponent ... plane ) {
		return new ExtractPlanes().addArg( "plane", Const.APPEND_SEPARATOR, plane );
	}

}
