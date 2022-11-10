package com.viiyue.ffmpeg.filter.video;

import com.viiyue.ffmpeg.annotation.Function;
import com.viiyue.ffmpeg.common.AbstractEnum;
import com.viiyue.ffmpeg.filter.AbstractColorFunction;

/**
 * Temporarily pad video frames
 * 
 * @author tangxbai
 * @since 2022/09/29
 * @see <a href="https://ffmpeg.org/ffmpeg-filters.html#tpad">ffmpeg-filters#tpad</a>
 */
@Function( "tpad" )
public class Tpad extends AbstractColorFunction<Tpad> {

	// Don't let anyone instantiate this class
	private Tpad() {}

	/**
	 * Quickly create an instances of {@link Tpad}
	 * 
	 * @return the {@link Tpad} instance
	 */
	public static final Tpad of() {
		return new Tpad();
	}

	/**
	 * Specify number of delay frames before input video stream, default is <b>0</b>.
	 * 
	 * @apiNote (int) start
	 * @param value the number of frames to delay input
	 * @return the {@link Tpad} instance
	 */
	public Tpad start( int value ) {
		return super.addArg( "start", value );
	}

	/**
	 * Specify number of padding frames after input video stream. Set to -1 to pad indefinitely, default is
	 * <b>0</b>.
	 * 
	 * @apiNote (int) stop
	 * @param value the number of frames to add after input finished
	 * @return the {@link Tpad} instance
	 */
	public Tpad stop( int value ) {
		return super.addArg( "stop", value );
	}

	/**
	 * Specify the duration of the start delay. See
	 * <a href="https://ffmpeg.org/ffmpeg-utils.html#time-duration-syntax">(ffmpeg-utils)the Time duration
	 * section in the ffmpeg-utils(1) manual</a> for the accepted syntax. These options override start,
	 * default is <b>0</b>.
	 * 
	 * @apiNote (int) start
	 * @param value the duration to delay input
	 * @return the {@link Tpad} instance
	 */
	public Tpad startDuration( String expression ) {
		return super.addArg( "start_duration", expression );
	}

	/**
	 * Specify the duration of the stop delay. See
	 * <a href="https://ffmpeg.org/ffmpeg-utils.html#time-duration-syntax">(ffmpeg-utils)the Time duration
	 * section in the ffmpeg-utils(1) manual</a> for the accepted syntax. These options override stop, default
	 * is <b>0</b>.
	 * 
	 * @apiNote (duration) expression
	 * @param value the duration to pad input
	 * @return the {@link Tpad} instance
	 */
	public Tpad stopDuration( String expression ) {
		return super.addArg( "stop_duration", expression );
	}

	/**
	 * Set kind of frames added to beginning of stream. Can be either add or clone. With add frames of
	 * solid-color are added. With clone frames are clones of first frame. Default is {@link AddedMode#ADD
	 * ADD}.
	 * 
	 * @apiNote (flags) start_mode
	 * @param mode the mode of added frames to start
	 * @return the {@link Tpad} instance
	 */
	public Tpad startMode( AddedMode mode ) {
		return super.addArg( "start_mode", mode );
	}

	/**
	 * Set kind of frames added to end of stream. Can be either add or clone. With add frames of solid-color
	 * are added. With clone frames are clones of last frame. Default is {@link AddedMode#ADD ADD}.
	 * 
	 * @apiNote (flags) top_mode
	 * @param mode the mode of added frames to end
	 * @return the {@link Tpad} instance
	 * @see AddedMode
	 */
	public Tpad stopMode( AddedMode mode ) {
		return super.addArg( "stop_mode", mode );
	}

	/**
	 * Mode of added frames
	 * 
	 * @author tangxbai
	 * @since 2022/09/30
	 */
	public enum AddedMode implements AbstractEnum {
		/** Add solid-color frames */
		ADD,
		/** Clone first/last frame */
		CLONE
	}

}
