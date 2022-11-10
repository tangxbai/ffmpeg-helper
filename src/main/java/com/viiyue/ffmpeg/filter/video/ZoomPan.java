package com.viiyue.ffmpeg.filter.video;

import com.viiyue.ffmpeg.annotation.Function;
import com.viiyue.ffmpeg.filter.AbstractFunction;

/**
 * Apply Zoom & Pan effect
 *
 * @author tangxbai
 * @since 2022/10/21
 * @see <a href="https://ffmpeg.org/ffmpeg-filters.html#zoompan">ffmpeg-filters#zoompan</a>
 */
@Function( "zoompan" )
public class ZoomPan extends AbstractFunction<ZoomPan> {

	// Don't let anyone instantiate this class
	private ZoomPan() {}

	/**
	 * Quickly create an instances of {@link ZoomPan}
	 * 
	 * @return the {@link ZoomPan} instance
	 */
	public static final ZoomPan of() {
		return new ZoomPan();
	}

	/**
	 * Set the zoom expression
	 * 
	 * @apiNote (string) zoom, z
	 * @param expression the zoom expression
	 * @return the {@link ZoomPan} instance
	 */
	public ZoomPan zoom( String expression ) {
		return super.addArg( "z", expression ); // zoom, z
	}

	/**
	 * Set the x coordinate
	 * 
	 * @apiNote (int) x
	 * @param value the x coordinate
	 * @return the {@link ZoomPan} instance
	 */
	public ZoomPan x( int value ) {
		return super.addArg( "x", value );
	}

	/**
	 * Set the x coordinate expression
	 * 
	 * @apiNote (string) x
	 * @param value the x coordinate expression
	 * @return the {@link ZoomPan} instance
	 */
	public ZoomPan x( String expression ) {
		return super.addArg( "x", expression );
	}

	/**
	 * Set the y coordinate
	 * 
	 * @apiNote (int) y
	 * @param value the y coordinate
	 * @return the {@link ZoomPan} instance
	 */
	public ZoomPan y( int value ) {
		return super.addArg( "y", value );
	}

	/**
	 * Set the y coordinate expression
	 * 
	 * @apiNote (string) y
	 * @param value the y coordinate expression
	 * @return the {@link ZoomPan} instance
	 */
	public ZoomPan y( String expression ) {
		return super.addArg( "y", expression );
	}

	/**
	 * Set the duration in number of frames. This sets for how many number of frames effect will last for
	 * single input image.
	 * 
	 * @apiNote (double) d
	 * @param value the animation duration
	 * @return the {@link ZoomPan} instance
	 */
	public ZoomPan duration( double value ) {
		return super.addArg( "d", value );
	}

	/**
	 * Set the duration expression in number of frames. This sets for how many number of frames effect will
	 * last for single input image.
	 * 
	 * @apiNote (string) d
	 * @param value the animation duration
	 * @return the {@link ZoomPan} instance
	 */
	public ZoomPan duration( String expression ) {
		return super.addArg( "d", expression );
	}

}
