package com.viiyue.ffmpeg.filter.video;

import com.viiyue.ffmpeg.annotation.Function;
import com.viiyue.ffmpeg.filter.AbstractColorFunction;

/**
 * <p>
 * Apply feedback video filter.
 * 
 * <p>
 * This filter pass cropped input frames to 2nd output. From there it can be filtered with other video
 * filters. After filter receives frame from 2nd input, that frame is combined on top of original frame from
 * 1st input and passed to 1st output.
 * 
 * <p>
 * The typical usage is filter only part of frame.
 * 
 * <p>
 * <b>Note</b>: {@code ffmpeg} doesn't seem to support it.
 * 
 * @author tangxbai
 * @since 2022/06/30
 * @see <a href="https://ffmpeg.org/ffmpeg-filters.html#feedback">ffmpeg-filters#feedback</a>
 */
@Function( "feedback" )
public class Feedback extends AbstractColorFunction<Feedback> {

	// Don't let anyone instantiate this class
	private Feedback() {}

	/**
	 * Quickly create an instances of {@link ExtractPlanes}
	 * 
	 * @param width  the crop width
	 * @param height the crop height
	 * @param x      the left crop position
	 * @param y      the top crop position
	 * @return the {@link Feedback} instance
	 */
	public static final Feedback the( int width, int height, int x, int y ) {
		return new Feedback().addArg( "w", width ).addArg( "h", height ).addArg( "x", x ).addArg( "y", y );
	}

}
