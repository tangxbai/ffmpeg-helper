package com.viiyue.ffmpeg.filter.video;

import com.viiyue.ffmpeg.annotation.Function;
import com.viiyue.ffmpeg.filter.AbstractFunction;

/**
 * Apply the EPX magnification filter which is designed for pixel art
 * 
 * @author tangxbai
 * @since 2022/06/29
 * @see <a href="https://ffmpeg.org/ffmpeg-filters.html#epx">ffmpeg-filters#epx</a>
 */
@Function( "epx" )
public class Epx extends AbstractFunction<Epx> {

	// Don't let anyone instantiate this class
	private Epx() {}

	/**
	 * Quickly create an instances of {@link Epx}, and set the scale factor.
	 * 
	 * @apiNote (flags) n
	 * @return the {@link Epx} instance
	 */
	public static final Epx double2x() {
		return new Epx().addArg( "n", 2 );
	}

	/**
	 * Quickly create an instances of {@link Epx}, and set the scale factor.
	 * 
	 * @apiNote (flags) n
	 * @return the {@link Epx} instance
	 */
	public static final Epx triple3x() {
		return new Epx().addArg( "n", 3 );
	}

}
