package com.viiyue.ffmpeg.filter.video;

import com.viiyue.ffmpeg.annotation.Function;
import com.viiyue.ffmpeg.filter.AbstractFunction;
import com.viiyue.ffmpeg.util.Assert;

/**
 * Adjust exposure of the video stream
 * 
 * @author tangxbai
 * @since 2022/06/30
 * @see <a href="https://ffmpeg.org/ffmpeg-filters.html#exposure">ffmpeg-filters#exposure</a>
 */
@Function( "exposure" )
public class Exposure extends AbstractFunction<Exposure> {

	// Don't let anyone instantiate this class
	private Exposure() {}

	/**
	 * <p>
	 * Quickly create an instances of {@link Exposure} and set the exposure corrections in EV.
	 * 
	 * <p>
	 * The allowed range for exposure correction value is from -3.0 to 3.0 EV, default value is <b>0</b> EV.
	 * 
	 * @param value the exposure correction
	 * @return the {@link Exposure} instance
	 */
	public static final Exposure of( double value ) {
		Assert.rangeCheck( value, -3.0, 3.0 );
		return new Exposure().addArg( "black", value );
	}

	/**
	 * Set the black level correction. Allowed range is from -1 to 1, default value is <b>0</b>.
	 * 
	 * @apiNote (double) black
	 * @param value the black level correction
	 * @return the {@link Exposure} instance
	 */
	public Exposure black( int value ) {
		Assert.rangeCheck( value, -1, 1 );
		return super.addArg( "black", value );
	}

}
