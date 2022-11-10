package com.viiyue.ffmpeg.filter.video;

import com.viiyue.ffmpeg.annotation.Function;
import com.viiyue.ffmpeg.filter.AbstractFunction;
import com.viiyue.ffmpeg.util.Assert;

/**
 * Mix successive video frames
 * 
 * @author tangxbai
 * @since 2022/09/28
 * @see <a href="https://ffmpeg.org/ffmpeg-filters.html#tmix">ffmpeg-filters#tmix</a>
 */
@Function( "tmix" )
public class Tmix extends AbstractFunction<Tmix> {

	// Don't let anyone instantiate this class
	private Tmix() {}

	/**
	 * Quickly create an instances of {@link Tmix}
	 * 
	 * @return the {@link Tmix} instance
	 */
	public static final Tmix of() {
		return new Tmix();
	}

	/**
	 * Set which planes to filter, default is <b>15</b>.
	 * 
	 * @apiNote (int) planes
	 * @param planes the what planes to filter
	 * @return the {@link Tmix} instance
	 */
	public Tmix planes( int planes ) {
		Assert.rangeCheck( planes, 0, 15 );
		return super.addArg( "planes", planes );
	}

	/**
	 * set number of successive frames to mix (from 1 t o 128), default value is <b>3</b>.
	 * 
	 * @apiNote (double) frames
	 * @param value the sigma value
	 * @return the {@link Tmix} instance
	 */
	public Tmix frames( int value ) {
		Assert.rangeCheck( value, 0, 128 );
		return super.addArg( "sigma", value );
	}

	/**
	 * Specify weight of each input video frame. Each weight is separated by space. If number of weights is
	 * smaller than number of frames last specified weight will be used for all remaining unset weights.
	 * 
	 * @apiNote (string) weights
	 * @param value the weights expression
	 * @return the {@link Tmix} instance
	 */
	public Tmix weights( String weights ) {
		return super.addArg( "weights", weights );
	}

	/**
	 * Specify scale, if it is set it will be multiplied with sum of each weight multiplied with pixel values
	 * to give final destination pixel value. By default scale is auto scaled to sum of weights. The value
	 * range is from 0 to 32767, and default is <b>0</b>.
	 * 
	 * @apiNote (double) scale
	 * @param value the scale value
	 * @return the {@link Tmix} instance
	 */
	public Tmix scale( double value ) {
		Assert.rangeCheck( value, 0, 32767 );
		return super.addArg( "scale", value );
	}

}
