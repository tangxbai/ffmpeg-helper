package com.viiyue.ffmpeg.filter.video;

import com.viiyue.ffmpeg.annotation.Function;
import com.viiyue.ffmpeg.filter.AbstractFunction;

/**
 * Suppress a TV station logo by a simple interpolation of the surrounding pixels. Just set a rectangle
 * covering the logo and watch it disappear (and sometimes something even uglier appear - your mileage may
 * vary).
 * 
 * @author tangxbai
 * @since 2022/06/27
 * @see <a href="https://ffmpeg.org/ffmpeg-filters.html#delogo">ffmpeg-filters#delogo</a>
 */
@Function( "delogo" )
public class Delogo extends AbstractFunction<Delogo> {

	// Don't let anyone instantiate this class
	private Delogo() {}

	/**
	 * Quickly create an instances of {@link Delogo}
	 * 
	 * @apiNote (int) w/h/x/y
	 * @return the {@link Delogo} instance
	 */
	public static final Delogo at( int w, int h, int x, int y ) {
		return new Delogo().postion( w, h, x, y );
	}

	/**
	 * Quickly create an instances of {@link Delogo}
	 * 
	 * @apiNote (string) w/h/x/y
	 * @return the {@link Delogo} instance
	 */
	public static final Delogo at( String w, String h, String x, String y ) {
		return new Delogo().postion( w, h, x, y );
	}

	/**
	 * Specify distance position of the logo to clear, they must be specified.
	 * 
	 * @apiNote (int) w/h/x/y
	 * @param w the logo width distance
	 * @param h the logo height distance
	 * @param x the left corner coordinates
	 * @param y the top corner coordinates
	 * @return the {@link Delogo} instance
	 */
	private Delogo postion( Object w, Object h, Object x, Object y ) {
		return super.addArg( "w", w ).addArg( "h", h ).addArg( "x", x ).addArg( "y", y );
	}

	/**
	 * <p>
	 * When set to {@code true}, a green rectangle is drawn on the screen to simplify finding the right x, y,
	 * w, and h parameters. The default value is {@code false}.
	 * 
	 * <p>
	 * The rectangle is drawn on the outermost pixels which will be (partly) replaced with interpolated
	 * values. The values of the next pixels immediately outside this rectangle in each direction will be used
	 * to compute the interpolated pixel values inside the rectangle.
	 * 
	 * @apiNote (boolean) show
	 * @return the {@link Delogo} instance
	 */
	public Delogo showArea() {
		return super.enable( "show" );
	}

}
