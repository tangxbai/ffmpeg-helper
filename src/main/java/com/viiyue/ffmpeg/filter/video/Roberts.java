package com.viiyue.ffmpeg.filter.video;

import com.viiyue.ffmpeg.annotation.Function;
import com.viiyue.ffmpeg.filter.AbstractFunction;
import com.viiyue.ffmpeg.util.Assert;

/**
 * Shift R/G/B/A pixels horizontally and/or vertically
 * 
 * @author tangxbai
 * @since 2022/08/01
 * @see <a href="https://ffmpeg.org/ffmpeg-filters.html#roberts">ffmpeg-filters#roberts</a>
 */
@Function( "roberts" )
public class Roberts extends AbstractFunction<Roberts> {

	// Don't let anyone instantiate this class
	private Roberts() {}

	/**
	 * Quickly create an instances of {@link Roberts}
	 * 
	 * @return the {@link Roberts} instance
	 */
	public static final Roberts of() {
		return new Roberts();
	}

	/**
	 * Set planes to filter. Value range allowed is from 0 to 15, default value is <b>15</b>, all planes will
	 * be processed.
	 * 
	 * @apiNote (int) planes
	 * @param value the plane filter
	 * @return the {@link Roberts} instance
	 */
	public Roberts planes( int value ) {
		Assert.rangeCheck( value, 0, 15 );
		return super.addArg( "planes", value );
	}

	/**
	 * Set value which will be multiplied with filtered result
	 * 
	 * @apiNote (int) scale
	 * @param value the scale value
	 * @return the {@link Roberts} instance
	 */
	public Roberts scale( double value ) {
		Assert.rangeCheck( value, 0.0, 65535.0 );
		return super.addArg( "scale", value );
	}

	/**
	 * Set value which will be added to filtered result
	 * 
	 * @apiNote (int) delta
	 * @param value the delta value
	 * @return the {@link Roberts} instance
	 */
	public Roberts delta( double value ) {
		Assert.rangeCheck( value, -65535.0, 65535.0 );
		return super.addArg( "delta", value );
	}

}
