package com.viiyue.ffmpeg.filter.video;

import com.viiyue.ffmpeg.annotation.Function;
import com.viiyue.ffmpeg.filter.AbstractFunction;

/**
 * Measure graylevel entropy in histogram of color channels of video frames
 * 
 * @author tangxbai
 * @since 2022/06/29
 * @see <a href="https://ffmpeg.org/ffmpeg-filters.html#entropy">ffmpeg-filters#entropy</a>
 */
@Function( "entropy" )
public class Entropy extends AbstractFunction<Entropy> {

	// Don't let anyone instantiate this class
	private Entropy() {}

	/**
	 * Quickly create an instances of {@link Entropy}, and set kind of histogram entropy measurement.
	 * 
	 * @apiNote (flags) mode
	 * @return the {@link Entropy} instance
	 */
	public static final Entropy normal() {
		return new Entropy().addArg( "mode", "normal" );
	}

	/**
	 * Quickly create an instances of {@link Entropy}, and set kind of histogram entropy measurement.
	 * 
	 * @apiNote (flags) mode
	 * @return the {@link Entropy} instance
	 */
	public static final Entropy diff() {
		return new Entropy().addArg( "mode", "diff" );
	}

}
