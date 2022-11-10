package com.viiyue.ffmpeg.filter.video;

import com.viiyue.ffmpeg.annotation.Function;
import com.viiyue.ffmpeg.filter.AbstractFunction;
import com.viiyue.ffmpeg.util.Assert;

/**
 * Apply kirsch operator to input video stream
 * 
 * @author tangxbai
 * @since 2022/07/12
 * @see <a href="https://ffmpeg.org/ffmpeg-filters.html#kirsch">ffmpeg-filters#kirsch</a>
 */
@Function( "kirsch" )
public class Kirsch extends AbstractFunction<Kirsch> {

	// Don't let anyone instantiate this class
	private Kirsch() {}

	/**
	 * Quickly create an instances of {@link Kirsch}
	 * 
	 * @return the {@link Kirsch} instance
	 */
	public static final Kirsch of() {
		return new Kirsch();
	}

	/**
	 * Set which planes will be processed, unprocessed planes will be copied. By default value <b>15</b>, all
	 * planes will be processed.
	 * 
	 * @apiNote (int) planes
	 * @param value the filter plane
	 * @return the {@link Kirsch} instance
	 */
	public Kirsch planes( int value ) {
		Assert.rangeCheck( value, 0, 15 );
		return super.addArg( "thresh", value );
	}

	/**
	 * Set value which will be multiplied with filtered result, value range is from 0 to 65535, default is
	 * <b>1</b>.
	 * 
	 * @apiNote (double) scale
	 * @param value the scale value
	 * @return the {@link Kirsch} instance
	 */
	public Kirsch scale( double value ) {
		return super.addArg( "scale", value );
	}

	/**
	 * Set value which will be added to filtered result, value range is from -65535 to 65535, default is
	 * <b>0</b>.
	 * 
	 * @apiNote (double) delta
	 * @param value the delta value
	 * @return the {@link Kirsch} instance
	 */
	public Kirsch delta( double value ) {
		Assert.rangeCheck( value, -65535, 65535 );
		return super.addArg( "delta", value );
	}

}
