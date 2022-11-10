package com.viiyue.ffmpeg.filter.video;

import com.viiyue.ffmpeg.annotation.Function;
import com.viiyue.ffmpeg.common.AbstractEnum;
import com.viiyue.ffmpeg.enums.When;
import com.viiyue.ffmpeg.filter.AbstractFunction;

/**
 * Correct perspective of video not recorded perpendicular to the screen
 * 
 * @author tangxbai
 * @since 2022/07/20
 * @see <a href="https://ffmpeg.org/ffmpeg-filters.html#perspective">ffmpeg-filters#perspective</a>
 */
@Function( "perspective" )
public class Perspective extends AbstractFunction<Perspective> {

	// Don't let anyone instantiate this class
	private Perspective() {}

	/**
	 * Quickly create an instances of {@link Perspective}
	 * 
	 * @return the {@link Perspective} instance
	 */
	public static final Perspective of() {
		return new Perspective();
	}

	/**
	 * Set coordinates expression for top left, top right, bottom left and bottom right corners. Default
	 * values are {@code 0:0:W:0:0:H:W:H} with which perspective will remain unchanged. If the {@code sense}
	 * option is set to {@code source}, then the specified points will be sent to the corners of the
	 * {@code destination}. If the sense option is set to destination, then the corners of the source will be
	 * sent to the specified coordinates.
	 * 
	 * @apiNote (int) x0/y0, x1/y1, x2/y2, x3/y3
	 * @param x0 the left-top x coordinate
	 * @param y0 the left-top y coordinate
	 * @param x1 the right-top x coordinate
	 * @param y1 the right-top y coordinate
	 * @param x2 the left-bottom x coordinate
	 * @param y2 the left-bottom y coordinate
	 * @param x3 the right-bottom x coordinate
	 * @param y3 the right-bottom y coordinate
	 * @return the {@link Perspective} instance
	 */
	public Perspective coordinates( int x0, int y0, int x1, int y1, int x2, int y2, int x3, int y3 ) {
		super.addArg( "x0", x0 );
		super.addArg( "y0", y0 );
		super.addArg( "x1", x1 );
		super.addArg( "y1", y1 );
		super.addArg( "x2", x2 );
		super.addArg( "y2", y2 );
		super.addArg( "x3", x3 );
		super.addArg( "y3", y3 );
		return this;
	}

	/**
	 * Set interpolation for perspective correction
	 * 
	 * @apiNote (flags) interpolation
	 * @param interpolation the perspective correction
	 * @return the {@link Perspective} instance
	 */
	public Perspective interpolation( Interpolation interpolation ) {
		return super.addArg( "interpolation", interpolation );
	}

	/**
	 * Set interpretation of coordinate options
	 * 
	 * @apiNote (flags) sense
	 * @param sense the coordinate sense
	 * @return the {@link Perspective} instance
	 */
	public Perspective sense( Sense sense ) {
		return super.addArg( "sense", sense );
	}

	/**
	 * Set when the expressions for coordinates x0,y0,...x3,y3 are evaluated.
	 * 
	 * @apiNote (flags) eval
	 * @param when specify when to evaluated the expressions for coordinates
	 * @return the {@link Perspective} instance
	 */
	public Perspective eval( When when ) {
		return super.addArg( "eval", when );
	}

	/**
	 * Perspective correction
	 *
	 * @author tangxbai
	 * @since 2022/07/20
	 */
	public enum Interpolation implements AbstractEnum {
		LINEAR, CUBIC
	}

	/**
	 * Coordinates sense
	 *
	 * @author tangxbai
	 * @since 2022/07/20
	 */
	public enum Sense implements AbstractEnum {
		/** Send point in the source specified by the given coordinates to the corners of the destination */
		SOURCE,
		/**
		 * Send the corners of the source to the point in the destination specified by the given coordinates
		 */
		DESTINATION
	}

}
