package com.viiyue.ffmpeg.filter.video;

import com.viiyue.ffmpeg.annotation.Function;
import com.viiyue.ffmpeg.filter.AbstractFunction;
import com.viiyue.ffmpeg.util.Assert;

/**
 * Apply alpha premultiply effect to input video stream using first plane of second stream as alpha. Both
 * streams must have same dimensions and same pixel format.
 * 
 * @author tangxbai
 * @since 2022/07/20
 * @see <a href="https://ffmpeg.org/ffmpeg-filters.html#premultiply">ffmpeg-filters#premultiply</a>
 */
@Function( "premultiply" )
public class PreMultiply extends AbstractFunction<PreMultiply> {

	// Don't let anyone instantiate this class
	private PreMultiply() {}

	/**
	 * Quickly create an instances of {@link PreMultiply}
	 * 
	 * @return the {@link PreMultiply} instance
	 */
	public static final PreMultiply of() {
		return new PreMultiply();
	}

	/**
	 * Set planes to filter. Value range allowed is from 0 to 15, default value is <b>15</b>, all planes will
	 * be processed.
	 * 
	 * @apiNote (int) planes
	 * @param value the plane filter
	 * @return the {@link PreMultiply} instance
	 */
	public PreMultiply planes( int value ) {
		Assert.rangeCheck( value, 0, 15 );
		return super.addArg( "planes", value );
	}

	/**
	 * Do not require 2nd input for processing, instead use alpha plane from input stream.
	 * 
	 * @apiNote (boolean) inplace
	 * @return the {@link PreMultiply} instance
	 */
	public PreMultiply inplace() {
		return super.enable( "inplace" );
	}

}
