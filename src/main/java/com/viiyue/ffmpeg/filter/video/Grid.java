package com.viiyue.ffmpeg.filter.video;

import com.viiyue.ffmpeg.annotation.Function;
import com.viiyue.ffmpeg.filter.AbstractColorFunction;

/**
 * Draw a colored box on the input image.
 * 
 * @author tangxbai
 * @since 2022/06/02
 */
@Function( "drawgrid" )
public class Grid extends AbstractColorFunction<Grid> {

	// Don't let anyone instantiate this class
	private Grid() {}

	public static final Grid the( int w, int h ) {
		return new Grid().position( w, h );
	}

	public static final Grid the( String w, String h ) {
		return new Grid().position( w, h );
	}

	/**
	 * Specify the box size, including parameters such as width, height and coordinates
	 * 
	 * <pre>
	 * <b>x, y</b>: The x and y offset coordinates where the box is drawn.
	 * <b>ih, iw</b>: The input width and height.
	 * 
	 * <b>DEMO</b>: 
	 * y = 0.5*(ih-iw/2.4)
	 * w = iw*2
	 * h = ih/2.4
	 * </pre>
	 * 
	 * @param w The expressions which specify the width of the box
	 * @param h The expressions which specify the height of the box
	 * @return the {@link Grid} instance
	 */
	private Grid position( Object w, Object h ) {
		super.addArg( "w", w );
		super.addArg( "h", h );
		return this;
	}

	/**
	 * The expression which sets the thickness of the box edge. A value of {@code fill} will create
	 * a filled box. Default value is 3.
	 * 
	 * @param thickness the thickness of the box edge( "fill" or number value )
	 * @return the {@link Grid} instance
	 */
	public Grid thickness( String thickness ) {
		return super.addArg( "t", thickness );
	}

}
