package com.viiyue.ffmpeg.filter.video;

import com.viiyue.ffmpeg.annotation.Function;
import com.viiyue.ffmpeg.common.AbstractEnum;
import com.viiyue.ffmpeg.enums.EofAction;
import com.viiyue.ffmpeg.filter.AbstractFunction;
import com.viiyue.ffmpeg.util.Assert;

/**
 * <p>
 * Apply normalized cross-correlation between first and second input video stream.
 * 
 * <p>
 * Second input video stream dimensions must be lower than first input video stream.
 *
 * @author tangxbai
 * @since 2022/10/19
 * @see <a href="https://ffmpeg.org/ffmpeg-filters.html#xcorrelate">ffmpeg-filters#xcorrelate</a>
 */
@Function( "xcorrelate" )
public class Xcorrelate extends AbstractFunction<Xcorrelate> {

	// Don't let anyone instantiate this class
	private Xcorrelate() {}

	/**
	 * Quickly create an instances of {@link Xcorrelate}
	 * 
	 * @return the {@link Xcorrelate} instance
	 */
	public static final Xcorrelate of() {
		return new Xcorrelate();
	}

	/**
	 * Set which planes to filter, default is <b>7</b>.
	 * 
	 * @apiNote (int) planes
	 * @param planes the what planes to filter
	 * @return the {@link Xcorrelate} instance
	 */
	public Xcorrelate planes( int planes ) {
		Assert.rangeCheck( planes, 0, 15 );
		return super.addArg( "planes", planes );
	}

	/**
	 * Set which secondary video frames will be processed from second input video stream, can be
	 * {@link Secondary#FIRST} or {@link Secondary#ALL}. Default is {@link Secondary#ALL}.
	 * 
	 * @apiNote (flags) secondary
	 * @param secondary when to process secondary frame
	 * @return the {@link Xcorrelate} instance
	 */
	public Xcorrelate secondary( Secondary secondary ) {
		return super.addArg( "secondary", secondary );
	}

	/**
	 * The action to take when EOF is encountered on the secondary input
	 * 
	 * @apiNote (flags) eof_action
	 * @param action the EOF action
	 * @return the {@link Xcorrelate} instance
	 */
	public Xcorrelate action( EofAction action ) {
		return super.addArg( "eof_action", action );
	}

	/**
	 * If set to true, force the output to terminate when the shortest input terminates. default value is
	 * false.
	 * 
	 * @apiNote (boolean) shortest
	 * @param state the shortest state
	 * @return the {@link Xcorrelate} instance
	 */
	public Xcorrelate shortest( boolean state ) {
		return super.status( "shortest", state );
	}

	/**
	 * If set to true, force the filter to extend the last frame of secondary streams until the end of the
	 * primary stream. A value of 0 disables this behavior, default value is false.
	 * 
	 * @apiNote (boolean) repeatlast
	 * @param state the repeat last state
	 * @return the {@link Xcorrelate} instance
	 */
	public Xcorrelate repeatLast( boolean state ) {
		return super.status( "repeatlast", state );
	}

	/**
	 * Secondary frame
	 *
	 * @author tangxbai
	 * @since 2022/10/19
	 */
	public enum Secondary implements AbstractEnum {
		FIRST, ALL
	}

}
