package com.viiyue.ffmpeg.filter.video;

import com.viiyue.ffmpeg.annotation.Function;
import com.viiyue.ffmpeg.filter.AbstractFunction;

/**
 * Deinterlace input video by applying Donald Graft’s adaptive kernel deinterling. Work on interlaced parts of
 * a video to produce progressive frames.
 *
 * @author tangxbai
 * @since 2022/07/12
 * @see <a href="https://ffmpeg.org/ffmpeg-filters.html#kerndeint">ffmpeg-filters#kerndeint</a>
 */
@Function( "kerndeint" )
public class Kerndeint extends AbstractFunction<Kerndeint> {

	// Don't let anyone instantiate this class
	private Kerndeint() {}

	/**
	 * Quickly create an instances of {@link Kerndeint}
	 * 
	 * @return the {@link Kerndeint} instance
	 */
	public static final Kerndeint of() {
		return new Kerndeint();
	}

	/**
	 * Set the threshold which affects the filter’s tolerance when determining if a pixel line must be
	 * processed. It must be an integer in the range [0,255] and defaults to <b>10</b>. A value of 0 will
	 * result in applying the process on every pixels.
	 * 
	 * @apiNote (int) thresh
	 * @param value the threshold
	 * @return the {@link Kerndeint} instance
	 */
	public Kerndeint threshold( int value ) {
		return super.addArg( "thresh", value );
	}

	/**
	 * Paint pixels exceeding the threshold value to white if set to {@code true}, default is {@code false}.
	 * 
	 * @apiNote (boolean) map
	 * @return the {@link Kerndeint} instance
	 */
	public Kerndeint map() {
		return super.enable( "map" );
	}

	/**
	 * Set the fields order. Swap fields if set to {@code true}, leave fields alone if {@code false}, default
	 * is {@code false}.
	 * 
	 * @apiNote (boolean) order
	 * @return the {@link Kerndeint} instance
	 */
	public Kerndeint order() {
		return super.enable( "order" );
	}

	/**
	 * Enable additional sharpening if set to {@code true}, default is {@code false}.
	 * 
	 * @apiNote (boolean) sharp
	 * @return the {@link Kerndeint} instance
	 */
	public Kerndeint sharp() {
		return super.enable( "sharp" );
	}

	/**
	 * Enable {@code twoway} sharpening if set to {@code true}, default is {@code false}.
	 * 
	 * @apiNote (boolean) twoway
	 * @return the {@link Kerndeint} instance
	 */
	public Kerndeint twoWay() {
		return super.enable( "twoway" );
	}

}
