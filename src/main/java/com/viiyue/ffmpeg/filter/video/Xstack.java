package com.viiyue.ffmpeg.filter.video;

import com.viiyue.ffmpeg.annotation.Function;
import com.viiyue.ffmpeg.enums.Color;
import com.viiyue.ffmpeg.filter.AbstractFunction;
import com.viiyue.ffmpeg.util.Assert;

/**
 * <p>
 * Stack video inputs into custom layout
 * 
 * <p>
 * <b>NOTE</b>: "All streams must be of <b>same pixel format</b>"
 *
 * @author tangxbai
 * @since 2022/10/19
 * @see <a href="https://ffmpeg.org/ffmpeg-filters.html#xstack">ffmpeg-filters#xstack</a>
 */
@Function( "xstack" )
public class Xstack extends AbstractFunction<Xstack> {

	// Don't let anyone instantiate this class
	private Xstack() {}

	/**
	 * Quickly create an instances of {@link Xstack}
	 * 
	 * @return the {@link Xstack} instance
	 */
	public static final Xstack of() {
		return new Xstack();
	}

	/**
	 * Set number of input streams. Default is <b>2</b>.
	 * 
	 * @apiNote (int) inputs
	 * @param value the number of input streams
	 * @return the {@link Xstack} instance
	 */
	public Xstack inputs( int value ) {
		Assert.isTrue( value >= 2, "Input stream number must be be greater than or equal to 2" );
		return super.addArg( "inputs", value );
	}

	/**
	 * <p>
	 * Specify layout of inputs. This option requires the desired layout configuration to be explicitly set by
	 * the user. This sets position of each video input in output. Each input is separated by ’|’. The first
	 * number represents the column, and the second number represents the row. Numbers start at 0 and are
	 * separated by ’_’. Optionally one can use wX and hX, where X is video input from which to take width or
	 * height. Multiple values can be used when separated by ’+’. In such case values are summed together.
	 * 
	 * <p>
	 * Note that if inputs are of different sizes gaps may appear, as not all of the output video frame will
	 * be filled. Similarly, videos can overlap each other if their position doesn’t leave enough space for
	 * the full frame of adjoining videos.
	 * 
	 * <p>
	 * For 2 inputs, a default layout of {@code 0_0|w0_0} (equivalent to {@code grid=2x1}) is set. In all
	 * other cases, a layout or a grid must be set by the user. Either {@code grid} or {@code layout} can be
	 * specified at a time. Specifying both will result in an error.
	 * 
	 * @apiNote (string) layout
	 * @param expression the custom layout string
	 * @return the {@link Xstack} instance
	 */
	public Xstack layout( String expression ) {
		return super.addArg( "layout", expression );
	}

	/**
	 * <p>
	 * Specify a fixed size grid of inputs. This option is used to create a fixed size grid of the input
	 * streams. Set the grid size in the form COLUMNSxROWS. There must be ROWS * COLUMNS input streams and
	 * they will be arranged as a grid with ROWS rows and COLUMNS columns. When using this option, each input
	 * stream within a row must have the same height and all the rows must have the same width.
	 * 
	 * <p>
	 * If grid is set, then inputs option is ignored and is implicitly set to ROWS * COLUMNS.
	 * 
	 * <p>
	 * For 2 inputs, a default grid of 2x1 (equivalent to layout=0_0|w0_0) is set. In all other cases, a
	 * layout or a grid must be set by the user. Either grid or layout can be specified at a time. Specifying
	 * both will result in an error.
	 * 
	 * @apiNote (string) layout
	 * @param expression the grid size of inputs
	 * @return the {@link Xstack} instance
	 */
	public Xstack grid( String expression ) {
		return super.addArg( "grid", expression );
	}

	/**
	 * If set to {@code true}, force the output to terminate when the shortest input terminates. default value
	 * is false.
	 * 
	 * @apiNote (boolean) shortest
	 * @param state the shortest state
	 * @return the {@link Xstack} instance
	 */
	public Xstack shortest() {
		return super.enable( "shortest" );
	}

	/**
	 * If set to valid color, all unused pixels will be filled with that color. By default fill is set to
	 * none, so it is disabled.
	 * 
	 * @apiNote (string) fill
	 * @param color the file color value
	 * @return the {@link Xstack} instance
	 */
	public Xstack fill( String color ) {
		return super.addArg( "fill", color );
	}

	/**
	 * If set to valid color, all unused pixels will be filled with that color. By default fill is set to
	 * none, so it is disabled.
	 * 
	 * @apiNote (string) fill
	 * @param color the file color value
	 * @return the {@link Xstack} instance
	 */
	public Xstack fill( Color color ) {
		return super.addArg( "fill", ( color == null ? Color.RANDOM : color ).command() );
	}

}
