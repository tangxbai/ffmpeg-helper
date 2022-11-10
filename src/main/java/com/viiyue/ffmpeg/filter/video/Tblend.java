package com.viiyue.ffmpeg.filter.video;

import com.viiyue.ffmpeg.annotation.Function;
import com.viiyue.ffmpeg.enums.EofAction;
import com.viiyue.ffmpeg.filter.AbstractFunction;
import com.viiyue.ffmpeg.filter.video.Blend.ComponentMode;
import com.viiyue.ffmpeg.util.Assert;

/**
 * <p>
 * Blend two video frames into each other.
 * 
 * <p>
 * The blend filter takes two input streams and outputs one stream, the first input is the "top" layer and
 * second input is "bottom" layer. By default, the output terminates when the longest input terminates.
 * 
 * <p>
 * The tblend (time blend) filter takes two consecutive frames from one single stream, and outputs the result
 * obtained by blending the new frame on top of the old frame.
 *
 * @author tangxbai
 * @since 2022/08/05
 * @see <a href="https://ffmpeg.org/ffmpeg-filters.html#tblend">ffmpeg-filters#tblend</a>
 */
@Function( "tblend" )
public class Tblend extends AbstractFunction<Tblend> {

	// Don't let anyone instantiate this class
	private Tblend() {}

	/**
	 * Quickly create an instances of {@link Tblend}
	 * 
	 * @return the {@link Tblend} instance
	 */
	public static final Tblend the() {
		return new Tblend();
	}

	/**
	 * Set blend mode 0 for specific pixel component, default value is {@link ComponentMode#NORMAL NORMAL}.
	 * 
	 * @apiNote (flags) c0_mode
	 * @param mode the pixel blend mode
	 * @return the {@link Tblend} instance
	 */
	public Tblend c0mode( ComponentMode mode ) {
		return super.addArg( "c0_mode", mode );
	}

	/**
	 * Set blend mode 1 for specific pixel component, default value is {@link ComponentMode#NORMAL NORMAL}.
	 * 
	 * @apiNote (flags) c1_mode
	 * @param mode the pixel blend mode
	 * @return the {@link Tblend} instance
	 */
	public Tblend c1mode( ComponentMode mode ) {
		return super.addArg( "c1_mode", mode );
	}

	/**
	 * Set blend mode 2 for specific pixel component, default value is {@link ComponentMode#NORMAL NORMAL}.
	 * 
	 * @apiNote (flags) c2_mode
	 * @param mode the component mode
	 * @return the {@link Tblend} instance
	 */
	public Tblend c2mode( ComponentMode mode ) {
		return super.addArg( "c2_mode", mode );
	}

	/**
	 * Set blend mode 3 for specific pixel component, default value is {@link ComponentMode#NORMAL NORMAL}.
	 * 
	 * @apiNote (flags) c3_mode
	 * @param mode the component mode
	 * @return the {@link Tblend} instance
	 */
	public Tblend c3mode( ComponentMode mode ) {
		return super.addArg( "c3_mode", mode );
	}

	/**
	 * Set blend mode for all pixel components in case of all_mode, default value is
	 * {@link ComponentMode#NORMAL NORMAL}.
	 * 
	 * @apiNote (flags) all_mode
	 * @param mode the components mode
	 * @return the {@link Tblend} instance
	 */
	public Tblend allMode( ComponentMode mode ) {
		return super.addArg( "all_mode", mode );
	}

	/**
	 * Set blend opacity for specific pixel component, only used in combination with pixel component blend.
	 * modes, default is <b>1</b>.
	 * 
	 * @apiNote (double) c0_opacity
	 * @param opacity the pixel blend opacity, range is from 0 to 1.
	 * @return the {@link Tblend} instance
	 */
	public Tblend c0opacity( double opacity ) {
		Assert.rangeCheck( opacity, 0, 1 );
		return super.addArg( "c0_opacity", opacity );
	}

	/**
	 * Set blend opacity for pixel component, only used in combination with pixel component blend modes,
	 * default is <b>1</b>.
	 * 
	 * @apiNote (double) c1_opacity
	 * @param opacity the pixel blend opacity, range is from 0 to 1.
	 * @return the {@link Tblend} instance
	 */
	public Tblend c1opacity( double opacity ) {
		return super.addArg( "c1_opacity", opacity );
	}

	/**
	 * Set blend opacity for pixel component, only used in combination with pixel component blend modes,
	 * default is <b>1</b>.
	 * 
	 * @apiNote (double) c2_opacity
	 * @param opacity the pixel blend opacity, range is from 0 to 1.
	 * @return the {@link Tblend} instance
	 */
	public Tblend c2opacity( double opacity ) {
		return super.addArg( "c2_opacity", opacity );
	}

	/**
	 * Set blend opacity for pixel component, only used in combination with pixel component blend modes,
	 * default is <b>1</b>.
	 * 
	 * @apiNote (double) c3_opacity
	 * @param opacity the pixel blend opacity, range is from 0 to 1.
	 * @return the {@link Tblend} instance
	 */
	public Tblend c3opacity( double opacity ) {
		return super.addArg( "c3_opacity", opacity );
	}

	/**
	 * Set blend opacity all pixel components in case of all_opacity, only used in combination with pixel
	 * component blend modes, default is <b>1</b>.
	 * 
	 * @apiNote (double) all_opacity
	 * @param opacity the all pixels blend opacity, range is from 0 to 1.
	 * @return the {@link Tblend} instance
	 */
	public Tblend allOpacity( double opacity ) {
		return super.addArg( "all_opacity", opacity );
	}

	/**
	 * Set blend expression for specific pixel component.
	 * 
	 * <p>
	 * Note that related mode options will be ignored if those are set.
	 * 
	 * <p>
	 * The expressions can use the following variables:
	 * 
	 * <pre>
	 * <code>N</code> The sequential number of the filtered frame, starting from 0.
	 * <code>X</code> <code>Y</code> The coordinates of the current sample
	 * <code>W</code> <code>H</code> The width and height of currently filtered plane
	 * 
	 * <code>SW</code> <code>SH</code>
	 * Width and height scale for the plane being filtered. It is the ratio between the dimensions of
	 * the current plane to the luma plane, e.g. for a yuv420p frame, the values are 1,1 for the luma plane
	 * and 0.5,0.5 for the chroma planes.
	 * 
	 * <code>T</code> Time of the current frame, expressed in seconds.
	 * <code>TOP, A</code> Value of pixel component at current location for first video frame (top layer).
	 * <code>BOTTOM, B</code> Value of pixel component at current location for second video frame (bottom layer).
	 * </pre>
	 * 
	 * @apiNote (string) c0_expr
	 * @param expression the blend expression
	 * @return the {@link Tblend} instance
	 */
	public Tblend c0expr( String expression ) {
		return super.addArg( "c0_expr", expression );
	}

	/**
	 * Set blend expression for specific pixel component.
	 * 
	 * <p>
	 * Note that related mode options will be ignored if those are set.
	 * 
	 * <p>
	 * The expressions can use the following variables:
	 * 
	 * <pre>
	 * <code>N</code> The sequential number of the filtered frame, starting from 0.
	 * <code>X</code> <code>Y</code> The coordinates of the current sample
	 * <code>W</code> <code>H</code> The width and height of currently filtered plane
	 * 
	 * <code>SW</code> <code>SH</code>
	 * Width and height scale for the plane being filtered. It is the ratio between the dimensions of
	 * the current plane to the luma plane, e.g. for a yuv420p frame, the values are 1,1 for the luma plane
	 * and 0.5,0.5 for the chroma planes.
	 * 
	 * <code>T</code> Time of the current frame, expressed in seconds.
	 * <code>TOP, A</code> Value of pixel component at current location for first video frame (top layer).
	 * <code>BOTTOM, B</code> Value of pixel component at current location for second video frame (bottom layer).
	 * </pre>
	 * 
	 * @apiNote (string) c1_expr
	 * @param expression the blend expression
	 * @return the {@link Tblend} instance
	 */
	public Tblend c1expr( String expression ) {
		return super.addArg( "c1_expr", expression );
	}

	/**
	 * Set blend expression for specific pixel component.
	 * 
	 * <p>
	 * Note that related mode options will be ignored if those are set.
	 * 
	 * <p>
	 * The expressions can use the following variables:
	 * 
	 * <pre>
	 * <code>N</code> The sequential number of the filtered frame, starting from 0.
	 * <code>X</code> <code>Y</code> The coordinates of the current sample
	 * <code>W</code> <code>H</code> The width and height of currently filtered plane
	 * 
	 * <code>SW</code> <code>SH</code>
	 * Width and height scale for the plane being filtered. It is the ratio between the dimensions of
	 * the current plane to the luma plane, e.g. for a yuv420p frame, the values are 1,1 for the luma plane
	 * and 0.5,0.5 for the chroma planes.
	 * 
	 * <code>T</code> Time of the current frame, expressed in seconds.
	 * <code>TOP, A</code> Value of pixel component at current location for first video frame (top layer).
	 * <code>BOTTOM, B</code> Value of pixel component at current location for second video frame (bottom layer).
	 * </pre>
	 * 
	 * @apiNote (string) c2_expr
	 * @param expression the blend expression
	 * @return the {@link Tblend} instance
	 */
	public Tblend c2expr( String expression ) {
		return super.addArg( "c2_expr", expression );
	}

	/**
	 * Set blend expression for specific pixel component.
	 * 
	 * <p>
	 * Note that related mode options will be ignored if those are set.
	 * 
	 * <p>
	 * The expressions can use the following variables:
	 * 
	 * <pre>
	 * <code>N</code> The sequential number of the filtered frame, starting from 0.
	 * <code>X</code> <code>Y</code> The coordinates of the current sample
	 * <code>W</code> <code>H</code> The width and height of currently filtered plane
	 * 
	 * <code>SW</code> <code>SH</code>
	 * Width and height scale for the plane being filtered. It is the ratio between the dimensions of
	 * the current plane to the luma plane, e.g. for a yuv420p frame, the values are 1,1 for the luma plane
	 * and 0.5,0.5 for the chroma planes.
	 * 
	 * <code>T</code> Time of the current frame, expressed in seconds.
	 * <code>TOP, A</code> Value of pixel component at current location for first video frame (top layer).
	 * <code>BOTTOM, B</code> Value of pixel component at current location for second video frame (bottom layer).
	 * </pre>
	 * 
	 * @apiNote (string) c3_expr
	 * @param expression the blend expression
	 * @return the {@link Tblend} instance
	 */
	public Tblend c3expr( String expression ) {
		return super.addArg( "c3_expr", expression );
	}

	/**
	 * Set blend expression for all pixel components in case of all_expr.
	 * 
	 * <p>
	 * Note that related mode options will be ignored if those are set.
	 * 
	 * <p>
	 * The expressions can use the following variables:
	 * 
	 * <pre>
	 * <code>N</code> The sequential number of the filtered frame, starting from 0.
	 * <code>X</code> <code>Y</code> The coordinates of the current sample
	 * <code>W</code> <code>H</code> The width and height of currently filtered plane
	 * 
	 * <code>SW</code> <code>SH</code>
	 * Width and height scale for the plane being filtered. It is the ratio between the dimensions of
	 * the current plane to the luma plane, e.g. for a yuv420p frame, the values are 1,1 for the luma plane
	 * and 0.5,0.5 for the chroma planes.
	 * 
	 * <code>T</code> Time of the current frame, expressed in seconds.
	 * <code>TOP, A</code> Value of pixel component at current location for first video frame (top layer).
	 * <code>BOTTOM, B</code> Value of pixel component at current location for second video frame (bottom layer).
	 * </pre>
	 * 
	 * @apiNote (string) all_expr
	 * @param expression the all blend expressions
	 * @return the {@link Tblend} instance
	 */
	public Tblend allExpr( String expression ) {
		return super.addArg( "all_expr", expression );
	}

	/**
	 * The action to take when EOF is encountered on the secondary input
	 * 
	 * @apiNote (flags) eof_action
	 * @param action the EOF action
	 * @return the {@link Tblend} instance
	 */
	public Tblend action( EofAction action ) {
		return super.addArg( "eof_action", action );
	}

	/**
	 * If set to true, force the output to terminate when the shortest input terminates. default value is
	 * false.
	 * 
	 * @apiNote (boolean) shortest
	 * @param state the shortest state
	 * @return the {@link Tblend} instance
	 */
	public Tblend shortest( boolean state ) {
		return super.status( "shortest", state );
	}

	/**
	 * If set to true, force the filter to extend the last frame of secondary streams until the end of the
	 * primary stream. A value of 0 disables this behavior, default value is false.
	 * 
	 * @apiNote (boolean) repeatlast
	 * @param state the repeat last state
	 * @return the {@link Tblend} instance
	 */
	public Tblend repeatLast( boolean state ) {
		return super.status( "repeatlast", state );
	}

}
