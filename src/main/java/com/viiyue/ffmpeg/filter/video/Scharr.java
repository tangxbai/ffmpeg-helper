package com.viiyue.ffmpeg.filter.video;

import com.viiyue.ffmpeg.annotation.Function;
import com.viiyue.ffmpeg.filter.AbstractFunction;
import com.viiyue.ffmpeg.util.Assert;

/**
 * Apply scharr operator to input video stream
 * 
 * @author tangxbai
 * @since 2022/08/03
 * @see <a href="https://ffmpeg.org/ffmpeg-filters.html#scharr">ffmpeg-filters#scharr</a>
 */
@Function( "scharr" )
public class Scharr extends AbstractFunction<Scharr> {

	// Don't let anyone instantiate this class
	private Scharr() {}

	/**
	 * Quickly create an instances of {@link Scharr}
	 * 
	 * @return the {@link Scharr} instance
	 */
	public static final Scharr of() {
		return new Scharr();
	}

	/**
	 * Set planes to filter. Value range allowed is from 0 to 15, default value is <b>15</b>, all planes will
	 * be processed.
	 * 
	 * @apiNote (int) planes
	 * @param value the plane filter
	 * @return the {@link Scharr} instance
	 */
	public Scharr planes( int value ) {
		Assert.rangeCheck( value, 0, 15 );
		return super.addArg( "planes", value );
	}

	/**
	 * Set value which will be multiplied with filtered result
	 * 
	 * @apiNote (int) scale
	 * @param value the scale value
	 * @return the {@link Scharr} instance
	 */
	public Scharr scale( double value ) {
		Assert.rangeCheck( value, 0.0, 65535.0 );
		return super.addArg( "scale", value );
	}

	/**
	 * Set value which will be added to filtered result
	 * 
	 * @apiNote (int) delta
	 * @param value the delta value
	 * @return the {@link Scharr} instance
	 */
	public Scharr delta( double value ) {
		Assert.rangeCheck( value, -65535.0, 65535.0 );
		return super.addArg( "delta", value );
	}

}
