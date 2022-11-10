package com.viiyue.ffmpeg.filter.video;

import com.viiyue.ffmpeg.annotation.Function;
import com.viiyue.ffmpeg.common.AbstractEnum;
import com.viiyue.ffmpeg.enums.EofAction;
import com.viiyue.ffmpeg.filter.AbstractFunction;
import com.viiyue.ffmpeg.util.Assert;

/**
 * Apply 2D deconvolution of video stream in frequency domain using second stream as impulse.
 * 
 * @author tangxbai
 * @since 2022/06/27
 * @see <a href="https://ffmpeg.org/ffmpeg-filters.html#deconvolve">ffmpeg-filters#deconvolve</a>
 */
@Function( "deconvolve" )
public class Deconvolve extends AbstractFunction<Deconvolve> {

	// Don't let anyone instantiate this class
	private Deconvolve() {}

	/**
	 * Quickly create an instances of {@link Deconvolve}
	 * 
	 * @return the {@link Deconvolve} instance
	 */
	public static final Deconvolve of() {
		return new Deconvolve();
	}

	/**
	 * Set which planes to process, default is <b>7</b>.
	 * 
	 * @apiNote (int) planes
	 * @param planes the plane value to process
	 * @return the {@link Deconvolve} instance
	 */
	public Deconvolve planes( int planes ) {
		Assert.rangeCheck( planes, 0, 15 );
		return super.addArg( "planes", planes );
	}

	/**
	 * Set which impulse video frames will be processed, can be {@link FrameImpulse#FIRST} or
	 * {@link FrameImpulse#ALL}, default is {@link FrameImpulse#ALL}.
	 * 
	 * @apiNote (flags) impulse
	 * @param planes the plane value to process
	 * @return the {@link Deconvolve} instance
	 * @see FrameImpulse
	 */
	public Deconvolve impulse( FrameImpulse impulse ) {
		return super.addArg( "impulse", impulse );
	}

	/**
	 * Set noise when doing divisions, default is <b>0.0000001</b>. Useful when width and height are not same
	 * and not power of 2 or if stream prior to convolving had noise.
	 * 
	 * @apiNote (double) noise
	 * @param noise the noise setting value
	 * @return the {@link Deconvolve} instance
	 */
	public Deconvolve noise( double noise ) {
		Assert.rangeCheck( noise, 0D, 1D );
		return super.addArg( "noise", noise );
	}

	/**
	 * The action to take when EOF is encountered on the secondary input
	 * 
	 * @apiNote (flags) eof_action
	 * @param action the EOF action
	 * @return the {@link Deconvolve} instance
	 */
	public Deconvolve action( EofAction action ) {
		return super.addArg( "eof_action", action );
	}

	/**
	 * If set to {@code true}, force the output to terminate when the shortest input terminates. default value
	 * is {@code false}.
	 * 
	 * @apiNote (boolean) shorttest
	 * @param state the shortest state
	 * @return the {@link Deconvolve} instance
	 */
	public Deconvolve shortest( boolean state ) {
		return super.status( "shortest", state );
	}

	/**
	 * If set to true, force the filter to extend the last frame of secondary streams until the end of the
	 * primary stream.
	 * 
	 * @apiNote (boolean) repeatlast
	 * @param state the repeat last state
	 * @return the {@link Deconvolve} instance
	 */
	public Deconvolve repeatLast( boolean state ) {
		return super.status( "repeatlast", state );
	}

	/**
	 * Impulse video options
	 *
	 * @author tangxbai
	 * @since 2022/06/27
	 */
	public enum FrameImpulse implements AbstractEnum {
		FIRST, ALL
	}

}
