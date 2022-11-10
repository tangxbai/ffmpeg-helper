package com.viiyue.ffmpeg.filter.video;

import com.viiyue.ffmpeg.annotation.Function;
import com.viiyue.ffmpeg.enums.EofAction;
import com.viiyue.ffmpeg.filter.AbstractFunction;
import com.viiyue.ffmpeg.util.Assert;

/**
 * Pick median pixels from several input videos
 *
 * @author tangxbai
 * @since 2022/10/19
 * @see <a href="https://ffmpeg.org/ffmpeg-filters.html#xcorrelate">ffmpeg-filters#xcorrelate</a>
 */
@Function( "xcorrelate" )
public class Xmedian extends AbstractFunction<Xmedian> {

	// Don't let anyone instantiate this class
	private Xmedian() {}

	/**
	 * Quickly create an instances of {@link Xmedian}
	 * 
	 * @return the {@link Xmedian} instance
	 */
	public static final Xmedian of() {
		return new Xmedian();
	}

	/**
	 * Set number of inputs. Default is <b>3</b>. Allowed range is from 3 to 255. If number of inputs is even
	 * number, than result will be mean value between two median values.
	 * 
	 * @apiNote (int) inputs
	 * @param value the number of inputs
	 * @return the {@link Xmedian} instance
	 */
	public Xmedian inputs( int value ) {
		Assert.rangeCheck( value, 3, 255 );
		return super.addArg( "inputs", value );
	}

	/**
	 * Set which planes to filter, default is <b>7</b>.
	 * 
	 * @apiNote (int) planes
	 * @param planes the what planes to filter
	 * @return the {@link Xmedian} instance
	 */
	public Xmedian planes( int planes ) {
		Assert.rangeCheck( planes, 0, 15 );
		return super.addArg( "planes", planes );
	}

	/**
	 * Set median percentile. Default value is <b>0.5</b>. Default value of 0.5 will pick always median
	 * values, while 0 will pick minimum values, and 1 maximum values.
	 * 
	 * @apiNote (double) percentile
	 * @param planes the what planes to filter
	 * @return the {@link Xmedian} instance
	 */
	public Xmedian percentile( double value ) {
		Assert.rangeCheck( value, 0, 1 );
		return super.addArg( "percentile", value );
	}

	/**
	 * The action to take when EOF is encountered on the secondary input
	 * 
	 * @apiNote (flags) eof_action
	 * @param action the EOF action
	 * @return the {@link Xmedian} instance
	 */
	public Xmedian action( EofAction action ) {
		return super.addArg( "eof_action", action );
	}

	/**
	 * If set to true, force the output to terminate when the shortest input terminates. default value is
	 * false.
	 * 
	 * @apiNote (boolean) shortest
	 * @param state the shortest state
	 * @return the {@link Xmedian} instance
	 */
	public Xmedian shortest( boolean state ) {
		return super.status( "shortest", state );
	}

	/**
	 * If set to true, force the filter to extend the last frame of secondary streams until the end of the
	 * primary stream. A value of 0 disables this behavior, default value is false.
	 * 
	 * @apiNote (boolean) repeatlast
	 * @param state the repeat last state
	 * @return the {@link Xmedian} instance
	 */
	public Xmedian repeatLast( boolean state ) {
		return super.status( "repeatlast", state );
	}

}
