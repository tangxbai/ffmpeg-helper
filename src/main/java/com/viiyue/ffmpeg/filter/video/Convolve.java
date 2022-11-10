package com.viiyue.ffmpeg.filter.video;

import com.viiyue.ffmpeg.annotation.Function;
import com.viiyue.ffmpeg.common.Const;
import com.viiyue.ffmpeg.enums.EofAction;
import com.viiyue.ffmpeg.filter.AbstractFunction;

/**
 * Apply 2D convolution of video stream in frequency domain using second stream as impulse.
 * 
 * @author tangxbai
 * @since 2022/06/16
 * @see <a href="https://ffmpeg.org/ffmpeg-filters.html#convolve">ffmpeg-filters#convolve</a>
 */
@Function( "convolve" )
public class Convolve extends AbstractFunction<Convolve> {

	// Don't let anyone instantiate this class
	private Convolve() {}

	@Override
	protected String [] getArgWrapper() {
		return new String [] { Const.QUOTE, Const.QUOTE };
	}

	/**
	 * Quickly create an instances of {@link Convolve}
	 * 
	 * @return the {@link Convolve} instance
	 */
	public static final Convolve of() {
		return new Convolve();
	}

	/**
	 * Set which planes to process
	 * 
	 * @apiNote (int) planes
	 * @param planes the filter plane
	 * @return the {@link Convolve} instance
	 */
	public Convolve planes( int planes ) {
		return super.addArg( "planes", planes );
	}

	/**
	 * Set which impulse video frames will be processed, can be first or all. Default is all.
	 * 
	 * @apiNote (int) impulse
	 * @param impulse the video frames
	 * @return the {@link Convolve} instance
	 */
	public Convolve impulse( int impulse ) {
		return super.addArg( "impulse", impulse );
	}

	/**
	 * The action to take when EOF is encountered on the secondary input
	 * 
	 * @apiNote (flags) eof_action
	 * @param action the EOF action
	 * @return the {@link Deconvolve} instance
	 */
	public Convolve action( EofAction action ) {
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
	public Convolve shortest( boolean state ) {
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
	public Convolve repeatLast( boolean state ) {
		return super.status( "repeatlast", state );
	}

}
