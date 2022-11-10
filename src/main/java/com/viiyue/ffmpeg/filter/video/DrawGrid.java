package com.viiyue.ffmpeg.filter.video;

import com.viiyue.ffmpeg.annotation.Function;
import com.viiyue.ffmpeg.filter.AbstractColorFunction;

/**
 * <p>
 * Draw a grid on the input image
 * 
 * <p>
 * The parameters for x, y, width and height and t are expressions containing the following constants:
 * 
 * <ul>
 * <li><b>dar</b> - The input display aspect ratio, it is the same as (w / h) * sar.
 * <li><b>hsub</b>,<b>vsub</b> - horizontal and vertical chroma subsample values. For example for the pixel
 * format "yuv422p" hsub is 2 and vsub is 1.
 * <li><b>in_h</b>(ih), <b>in_w</b>(iw) - The input width and height.
 * <li><b>sar</b> - The input sample aspect ratio.
 * <li><b>x</b>, <b>y</b> - The x and y offset coordinates where the box is drawn.
 * <li><b>w</b>, <b>h</b> - The width and height of the drawn box.
 * <li><b>box_source</b> - Box source can be set as side_data_detection_bboxes if you want to use box data in
 * detection bboxes of side data. If box_source is set, the x, y, width and height will be ignored and still
 * use box data in detection bboxes of side data. So please do not use this parameter if you were not sure
 * about the box source.
 * <li><b>t</b> - The thickness of the drawn box. These constants allow the x, y, w, h and t expressions to
 * refer to each other, so you may for example specify {@code y=x/dar} or {@code h=w/dar}.
 * </ul>
 * 
 * @author tangxbai
 * @since 2022/06/28
 * @see <a href="https://ffmpeg.org/ffmpeg-filters.html#drawgrid">ffmpeg-filters#drawgrid</a>
 */
@Function( "drawgrid" )
public class DrawGrid extends AbstractColorFunction<DrawGrid> {

	// Don't let anyone instantiate this class
	private DrawGrid() {}

	/**
	 * Quickly create an instances of {@link DrawBox}, the distances which specify the width and height of the
	 * grid cell, if 0 they are interpreted as the input width and height, respectively, minus thickness, so
	 * image gets framed, default to <b>0</b>.
	 * 
	 * @apiNote (int) width, w
	 * @apiNote (int) height, h
	 * @param width  the width of the box, default is 0.
	 * @param height the height of the box, default is 0.
	 * @return the {@link DrawGrid} instance
	 */
	public static final DrawGrid size( int width, int height ) {
		return new DrawGrid().addArg( "w", width ).addArg( "h", height ); // width, w; height, h
	}

	/**
	 * Quickly create an instances of {@link DrawBox}, the expressions which specify the width and height of
	 * the grid cell, if 0 they are interpreted as the input width and height, respectively, minus thickness,
	 * so image gets framed, default to <b>0</b>.
	 * 
	 * @apiNote (string) width, w
	 * @apiNote (string) height, h
	 * @param width  the width expression of the box, default is "0".
	 * @param height the height expression of the box, default is "0".
	 * @return the {@link DrawGrid} instance
	 */
	public static final DrawGrid size( String width, String height ) {
		return new DrawGrid().addArg( "w", width ).addArg( "h", height );
	}

	/**
	 * The distances which specify the coordinates of some point of grid intersection (meant to configure
	 * offset). Both default to <b>0</b>.
	 * 
	 * @apiNote (int) x/y
	 * @param x the horizontal position of the left box edge, default is 0.
	 * @param y the vertical position of the top box edge, default is 0.
	 * @return the {@link DrawGrid} instance
	 */
	public DrawGrid at( int x, int y ) {
		return super.addArg( "x", x ).addArg( "y", y );
	}

	/**
	 * The expressions which specify the coordinates of some point of grid intersection (meant to configure
	 * offset). Both default to <b>0</b>.
	 * 
	 * @apiNote (string) x/y
	 * @param x the expression of horizontal position of the left box edge, default is "0".
	 * @param y the expression of vertical position of the top box edge, default is "0".
	 * @return the {@link DrawGrid} instance
	 */
	public DrawGrid at( String x, String y ) {
		return super.addArg( "x", x ).addArg( "y", y );
	}

	/**
	 * Set the thickness of the box edge, default value is <b>1</b>.
	 * 
	 * @apiNote (int) thickness, t
	 * @param thickness the box thickness value, default is 1.
	 * @return the {@link DrawGrid} instance
	 */
	public DrawGrid thickness( int thickness ) {
		return super.addArg( "t", thickness ); // thickness, t
	}

	/**
	 * The expression which sets the thickness of the box edge. A value of {@code fill} will create a filled
	 * box, default value is <b>1</b>.
	 * 
	 * @apiNote (string) thickness, t
	 * @param thickness the thickness expression
	 * @return the {@link DrawGrid} instance
	 */
	public DrawGrid thickness( String thickness ) {
		return super.addArg( "t", thickness ); // thickness, t
	}

	/**
	 * Applicable if the input has alpha. With value {@code true}, the pixels of the painted box will
	 * overwrite the video’s color and alpha pixels. Default is {@code false}, which composites the box onto
	 * the input, leaving the video’s alpha intact.
	 * 
	 * @apiNote (boolean) replace
	 * @return the {@link DrawGrid} instance
	 */
	public DrawGrid replace() {
		return super.enable( "replace" );
	}

}
