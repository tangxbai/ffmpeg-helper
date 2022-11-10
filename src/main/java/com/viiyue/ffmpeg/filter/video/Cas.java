package com.viiyue.ffmpeg.filter.video;

import com.viiyue.ffmpeg.annotation.Function;
import com.viiyue.ffmpeg.filter.AbstractFunction;

/**
 * Apply Contrast Adaptive Sharpen filter to video stream.
 *
 * @author tangxbai
 * @since 2022/06/14
 * @see <a href="https://ffmpeg.org/ffmpeg-filters.html#cas">ffmpeg-filters#cas</a>
 */
@Function( "cas" )
public class Cas extends AbstractFunction<Cas> {

	// Don't let anyone instantiate this class
	private Cas() {}

	/**
	 * Quickly create an instances of {@link Cas}
	 * 
	 * @return the {@link Cas} instance
	 */
	public static final Cas the() {
		return new Cas();
	}

	/**
	 * Set the sharpening strength, default value is <b>0</b>.
	 * 
	 * @apiNote (double) strength
	 * @param strength the sharpening strength
	 * @return the {@link Cas} instance
	 */
	public Cas strength( double strength ) {
		return super.addArg( "strength", strength );
	}

	/**
	 * Set planes to filter, default value is to filter all planes except alpha plane.
	 * 
	 * @apiNote (int) planes
	 * @param planes the filter plane
	 * @return the {@link Cas} instance
	 */
	public Cas plane( int planes ) {
		return super.addArg( "planes", planes );
	}

}
