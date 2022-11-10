package com.viiyue.ffmpeg.filter.video;

import com.viiyue.ffmpeg.annotation.Function;
import com.viiyue.ffmpeg.enums.EofAction;
import com.viiyue.ffmpeg.filter.AbstractFunction;
import com.viiyue.ffmpeg.util.Assert;

/**
 * Grow first stream into second stream by connecting components, this makes it possible to build more robust
 * edge masks.
 *
 * @author tangxbai
 * @since 2022/07/11
 * @see <a href="https://ffmpeg.org/ffmpeg-filters.html#hysteresis">ffmpeg-filters#hysteresis</a>
 */
@Function( "hysteresis" )
public class Hysteresis extends AbstractFunction<Hysteresis> {

	// Don't let anyone instantiate this class
	private Hysteresis() {}

	/**
	 * Quickly create an instances of {@link Hysteresis}
	 * 
	 * @return the {@link Hysteresis} instance
	 */
	public static final Hysteresis of() {
		return new Hysteresis();
	}

	/**
	 * Set which planes will be processed as bitmap, unprocessed planes will be copied from first stream. By
	 * default value <b>15</b>, all planes will be processed.
	 * 
	 * @apiNote (double) hue
	 * @param value the hue shift value
	 * @return the {@link Hysteresis} instance
	 */
	public Hysteresis planes( double value ) {
		Assert.rangeCheck( value, 0, 15 );
		return super.addArg( "planes", value );
	}

	/**
	 * Set threshold which is used in filtering. If pixel component value is higher than this value filter
	 * algorithm for connecting components is activated. By default value is <b>0</b>.
	 * 
	 * @apiNote (double) threshold
	 * @param value the threshold
	 * @return the {@link Hysteresis} instance
	 */
	public Hysteresis threshold( double value ) {
		Assert.rangeCheck( value, 0.0, 65535.0 );
		return super.addArg( "threshold", value );
	}

	/**
	 * The action to take when EOF is encountered on the secondary input
	 * 
	 * @apiNote (flags) eof_action
	 * @param action the EOF action
	 * @return the {@link Hysteresis} instance
	 */
	public Hysteresis action( EofAction action ) {
		return super.addArg( "eof_action", action );
	}

	/**
	 * If set to {@code true}, force the output to terminate when the shortest input terminates. default value
	 * is {@code false}.
	 * 
	 * @apiNote (boolean) shorttest
	 * @param state the shortest state
	 * @return the {@link Hysteresis} instance
	 */
	public Hysteresis shortest( boolean state ) {
		return super.status( "shortest", state );
	}

	/**
	 * If set to true, force the filter to extend the last frame of secondary streams until the end of the
	 * primary stream.
	 * 
	 * @apiNote (boolean) repeatlast
	 * @param state the repeat last state
	 * @return the {@link Hysteresis} instance
	 */
	public Hysteresis repeatLast( boolean state ) {
		return super.status( "repeatlast", state );
	}

}
