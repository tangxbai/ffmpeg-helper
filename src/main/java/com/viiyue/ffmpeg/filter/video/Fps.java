package com.viiyue.ffmpeg.filter.video;

import com.viiyue.ffmpeg.annotation.Function;
import com.viiyue.ffmpeg.common.AbstractEnum;
import com.viiyue.ffmpeg.filter.AbstractColorFunction;

/**
 * Convert the video to specified constant frame rate by duplicating or dropping frames as necessary
 * 
 * @author tangxbai
 * @since 2022/07/06
 * @see <a href="https://ffmpeg.org/ffmpeg-filters.html#fps-1">ffmpeg-filters#fps</a>
 */
@Function( "fps" )
public class Fps extends AbstractColorFunction<Fps> {

	// Don't let anyone instantiate this class
	private Fps() {}

	/**
	 * Quickly create an instances of {@link Fps}, and specify the desired output frame rate.
	 * 
	 * @apiNote (string) fps
	 * @param link the FPS constant
	 * @return the {@link Fps} instance
	 */
	public static final Fps of( FpsLink link ) {
		return new Fps().addArg( "fps", link );
	}

	/**
	 * Quickly create an instances of {@link Fps}, and specify the desired output frame rate.
	 * 
	 * @apiNote (int) fps
	 * @param fps the fps frame rate
	 * @return the {@link Fps} instance
	 */
	public static final Fps of( int fps ) {
		return new Fps().addArg( "fps", fps );
	}

	/**
	 * Assume the first PTS should be the given value, in seconds. This allows for padding/trimming at the
	 * start of stream. By default, no assumption is made about the first frame’s expected PTS, so no padding
	 * or trimming is done. For example, this could be set to 0 to pad the beginning with duplicates of the
	 * first frame if a video stream starts after the audio stream or to trim any frames with a negative PTS.
	 * 
	 * @apiNote (double) start_time
	 * @param startTime the first PTS should be this value
	 * @return the {@link Fps} instance
	 */
	public Fps startTime( double startTime ) {
		return super.addArg( "start_time", startTime );
	}

	/**
	 * Timestamp (PTS) rounding method
	 * 
	 * @apiNote (flags) round
	 * @param round the rounding method for timestamps
	 * @return the {@link Fps} instance
	 */
	public Fps round( RoundMethod round ) {
		return super.addArg( "round", round );
	}

	/**
	 * Action performed when reading the last frame
	 * 
	 * @apiNote (flags) eof_action
	 * @param round the action performed for last frame
	 * @return the {@link Fps} instance
	 */
	public Fps action( EofAction action ) {
		return super.addArg( "eof_action", action );
	}

	/**
	 * FPS option constants
	 *
	 * @author tangxbai
	 * @since 2022/07/06
	 */
	public enum FpsLink implements AbstractEnum {
		/** The input’s frame rate */
		SOURCE_FPS,
		/** NTSC frame rate of <font color="green">30000/1001</font> */
		NTSC,
		/** PAL frame rate of <font color="green">25.0</font> */
		PAL,
		/** Film frame rate of <font color="green">24.0</font> */
		FILM,
		/** NTSC-film frame rate of <font color="green">24000/1001</font> */
		NTSC_FIL
	}

	/**
	 * The rounding method for timestamps
	 *
	 * @author tangxbai
	 * @since 2022/07/06
	 */
	public enum RoundMethod implements AbstractEnum {
		/** Round towards 0 */
		ZERO,
		/** Round away from 0 */
		INF,
		/** Round towards -infinity */
		DOWN,
		/** Round towards +infinity */
		UP,
		/** Round to nearest */
		NEAR
	}

	/**
	 * The rounding method for timestamps
	 *
	 * @author tangxbai
	 * @since 2022/07/06
	 */
	public enum EofAction implements AbstractEnum {
		/** Use same timestamp rounding method as used for other frames */
		ROUND,
		/** Pass through last frame if input duration has not been reached yet */
		PASS
	}

}
