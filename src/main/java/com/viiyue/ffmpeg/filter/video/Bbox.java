package com.viiyue.ffmpeg.filter.video;

import com.viiyue.ffmpeg.annotation.Function;
import com.viiyue.ffmpeg.filter.AbstractFunction;
import com.viiyue.ffmpeg.util.Assert;

/**
 * <p>
 * Compute the bounding box for the non-black pixels in the input frame luminance plane.
 * 
 * <p>
 * This filter computes the bounding box containing all the pixels with a luminance value greater than the
 * minimum allowed value. The parameters describing the bounding box are printed on the filter log.
 *
 * @author tangxbai
 * @since 2022/06/09
 * @see <a href="https://ffmpeg.org/ffmpeg-filters.html#bbox">ffmpeg-filters#bbox</a>
 */
@Function( "bbox" )
public class Bbox extends AbstractFunction<Bbox> {

	// Don't let anyone instantiate this class
	private Bbox() {}

	/**
	 * Quickly create an instances of {@link Bbox}
	 * 
	 * @apiNote (int) min_val
	 * @param luminance the minimal luminance value, and the default is 16.
	 * @return the {@link Bbox} instance
	 */
	public static final Bbox luminance( int luminance ) {
		Assert.rangeCheck( luminance, 0, 65535 );
		return new Bbox().addArg( "min_val", luminance );
	}

}
