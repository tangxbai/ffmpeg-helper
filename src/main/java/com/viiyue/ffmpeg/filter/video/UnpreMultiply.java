package com.viiyue.ffmpeg.filter.video;

import com.viiyue.ffmpeg.annotation.Function;
import com.viiyue.ffmpeg.filter.AbstractFunction;
import com.viiyue.ffmpeg.util.Assert;

/**
 * Apply alpha unpremultiply effect to input video stream using first plane of second stream as alpha. Both
 * streams must have same dimensions and same pixel format.
 * 
 * @author tangxbai
 * @since 2022/10/08
 * @see <a href="https://ffmpeg.org/ffmpeg-filters.html#unpremultiply">ffmpeg-filters#unpremultiply</a>
 */
@Function( "unpremultiply" )
public class UnpreMultiply extends AbstractFunction<UnpreMultiply> {

	// Don't let anyone instantiate this class
	private UnpreMultiply() {}

	/**
	 * Quickly create an instances of {@link UnpreMultiply}
	 * 
	 * @return the {@link UnpreMultiply} instance
	 */
	public static final UnpreMultiply of() {
		return new UnpreMultiply();
	}

	/**
	 * Set planes to filter. Value range allowed is from 0 to 15, default value is <b>15</b>, all planes will
	 * be processed.
	 * 
	 * @apiNote (int) planes
	 * @param value the plane filter
	 * @return the {@link UnpreMultiply} instance
	 */
	public UnpreMultiply planes( int value ) {
		Assert.rangeCheck( value, 0, 15 );
		return super.addArg( "planes", value );
	}

	/**
	 * Do not require 2nd input for processing, instead use alpha plane from input stream.
	 * 
	 * @apiNote (boolean) inplace
	 * @return the {@link UnpreMultiply} instance
	 */
	public UnpreMultiply inplace() {
		return super.enable( "inplace" );
	}

}
