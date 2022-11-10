package com.viiyue.ffmpeg.filter.video;

import com.viiyue.ffmpeg.annotation.Function;
import com.viiyue.ffmpeg.common.AbstractEnum;
import com.viiyue.ffmpeg.enums.VideoRate;
import com.viiyue.ffmpeg.enums.VideoSize;
import com.viiyue.ffmpeg.filter.AbstractFunction;
import com.viiyue.ffmpeg.util.Assert;

/**
 * <p>
 * Show various filtergraph stats.
 * 
 * <p>
 * With this filter one can debug complete filtergraph. Especially issues with links filling with queued
 * frames.
 *
 * @author tangxbai
 * @since 2022/07/07
 * @see <a href="https://ffmpeg.org/ffmpeg-filters.html#graphmonitor-1">ffmpeg-filters#graphmonitor</a>
 */
@Function( "graphmonitor" )
public class GraphMonitor extends AbstractFunction<GraphMonitor> {

	// Don't let anyone instantiate this class
	private GraphMonitor() {}

	/**
	 * Quickly create an instances of {@link GraphMonitor}
	 * 
	 * @return the {@link GraphMonitor} instance
	 */
	public static final GraphMonitor of() {
		return new GraphMonitor();
	}

	/**
	 * Set the video output size, default is {@code hd720}( 1280x720 ).
	 * 
	 * @apiNote (string) size
	 * @param width  the video output width
	 * @param height the video output height
	 * @return the {@link GraphMonitor} instance
	 */
	public GraphMonitor size( int width, int height ) {
		return super.addArg( "size", width + "x" + height );
	}

	/**
	 * Set the video output size, default is {@code hd720}( 1280x720 ).
	 * 
	 * @apiNote (flags) size
	 * @param size the video output size constants
	 * @return the {@link GraphMonitor} instance
	 * @see VideoSize
	 */
	public GraphMonitor size( VideoSize size ) {
		return super.addArg( "size", size );
	}

	/**
	 * Set video opacity. Default is <b>0.9</b>, allowed range is from 0 to 1.
	 * 
	 * @apiNote (double) opacity, o
	 * @param value the
	 * @return the {@link GraphMonitor} instance
	 * @see VideoSize
	 */
	public GraphMonitor opacity( double value ) {
		Assert.rangeCheck( value, 0.0, 1.0 );
		return super.addArg( "o", value ); // opacity, o
	}

	/**
	 * Set video opacity. Default is <b>0.9</b>, allowed range is from 0 to 1.
	 * 
	 * @apiNote (flags) mode, m
	 * @param mode the output mode
	 * @return the {@link GraphMonitor} instance
	 * @see OuputMode
	 */
	public GraphMonitor mode( OuputMode mode ) {
		return super.addArg( "m", mode ); // mode, m
	}

	/**
	 * Set flags which enable which stats are shown in video, default is {@link ShownFlags#QUEUE}.
	 * 
	 * @apiNote (flags) flags, f
	 * @param flag the shown flags
	 * @return the {@link GraphMonitor} instance
	 */
	public GraphMonitor flags( ShownFlags flag ) {
		return super.addArg( "f", flag ); // flags, f
	}

	/**
	 * Set upper limit for video rate of output stream, Default value is <b>25</b>. This guarantee that output
	 * video frame rate will not be higher than this value.
	 * 
	 * @apiNote (int) rate, r
	 * @param rate the video rate
	 * @return the {@link GraphMonitor} instance
	 */
	public GraphMonitor rate( int rate ) {
		return super.addArg( "r", rate ); // rate, r
	}

	/**
	 * Set upper limit for video rate of output stream, Default value is <b>25</b>. This guarantee that output
	 * video frame rate will not be higher than this value.
	 * 
	 * @apiNote (int) rate, r
	 * @param rate the video rate
	 * @return the {@link GraphMonitor} instance
	 * @see VideoRate
	 */
	public GraphMonitor rate( VideoRate rate ) {
		return super.addArg( "r", rate ); // rate, r
	}

	/**
	 * Video output mode
	 *
	 * @author tangxbai
	 * @since 2022/07/11
	 */
	public enum OuputMode implements AbstractEnum {
		FULL, COMPACT
	}

	/**
	 * Flags to enable which stats are shown in the video
	 *
	 * @author tangxbai
	 * @since 2022/07/07
	 */
	public enum ShownFlags implements AbstractEnum {
		/** Display number of queued frames in each link */
		QUEUE,
		/** Display number of frames taken from filter */
		FRAME_COUNT_IN,
		/** Display number of frames given out from filter */
		FRAME_COUNT_OUT,
		/** Display delta number of frames between above two values */
		FRAME_COUNT_DELTA,
		/** Display current filtered frame pts */
		PTS,
		/** Display pts delta between current and previous frame */
		PTS_DELTA,
		/** Display current filtered frame time */
		TIME,
		/** Display time delta between current and previous frame */
		TIME_DELTA,
		/** Display time base for filter link */
		TIMEBASE,
		/** Display used format for filter link */
		FORMAT,
		/** Display video size or number of audio channels in case of audio used by filter link */
		SIZE,
		/** Display video frame rate or sample rate in case of audio used by filter link */
		RATE,
		/** Display link output status */
		EOF,
		/** Display number of samples taken from filter */
		SAMPLE_COUNT_IN,
		/** Display number of samples given out from filter */
		SAMPLE_COUNT_OUT,
		/** Display delta number of samples between above two values */
		SAMPLE_COUNT_DELTA
	}

}
