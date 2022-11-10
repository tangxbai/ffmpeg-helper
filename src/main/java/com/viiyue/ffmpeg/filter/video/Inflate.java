package com.viiyue.ffmpeg.filter.video;

import com.viiyue.ffmpeg.annotation.Function;
import com.viiyue.ffmpeg.filter.AbstractFunction;
import com.viiyue.ffmpeg.util.Assert;

/**
 * Apply inflate effect to the video, this filter replaces the pixel by the local(3x3) average by taking into
 * account only values higher than the pixel.
 *
 * @author tangxbai
 * @since 2022/07/11
 * @see <a href="https://ffmpeg.org/ffmpeg-filters.html#inflate">ffmpeg-filters#inflate</a>
 */
@Function( "inflate" )
public class Inflate extends AbstractFunction<Inflate> {

	// Don't let anyone instantiate this class
	private Inflate() {}

	/**
	 * Quickly create an instances of {@link Inflate}
	 * 
	 * @return the {@link Inflate} instance
	 */
	public static final Inflate of() {
		return new Inflate();
	}

	/**
	 * Limit the maximum change for 1st plane. Allowed value range is form 0 to 65535, default is
	 * <b>65535</b>. If 0, plane will remain unchanged.
	 * 
	 * @apiNote (double) threshold0
	 * @param value the plane threshold
	 * @return the {@link Inflate} instance
	 */
	public Inflate threshold0( double value ) {
		Assert.rangeCheck( value, 0, 65535 );
		return super.addArg( "threshold0", value );
	}

	/**
	 * Limit the maximum change for 2nd plane. Allowed value range is form 0 to 65535, default is
	 * <b>65535</b>. If 0, plane will remain unchanged.
	 * 
	 * @apiNote (double) threshold1
	 * @param value the plane threshold
	 * @return the {@link Inflate} instance
	 */
	public Inflate threshold1( double value ) {
		Assert.rangeCheck( value, 0, 65535 );
		return super.addArg( "threshold1", value );
	}

	/**
	 * Limit the maximum change for 3rd plane. Allowed value range is form 0 to 65535, default is
	 * <b>65535</b>. If 0, plane will remain unchanged.
	 * 
	 * @apiNote (double) threshold2
	 * @param value the plane threshold
	 * @return the {@link Inflate} instance
	 */
	public Inflate threshold2( double value ) {
		Assert.rangeCheck( value, 0, 65535 );
		return super.addArg( "threshold2", value );
	}

	/**
	 * Limit the maximum change for 4th plane. Allowed value range is form 0 to 65535, default is
	 * <b>65535</b>. If 0, plane will remain unchanged.
	 * 
	 * @apiNote (double) threshold3
	 * @param value the plane threshold
	 * @return the {@link Inflate} instance
	 */
	public Inflate threshold3( double value ) {
		Assert.rangeCheck( value, 0, 65535 );
		return super.addArg( "threshold3", value );
	}

}
