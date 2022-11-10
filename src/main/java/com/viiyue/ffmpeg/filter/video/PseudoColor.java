package com.viiyue.ffmpeg.filter.video;

import com.viiyue.ffmpeg.annotation.Function;
import com.viiyue.ffmpeg.common.AbstractEnum;
import com.viiyue.ffmpeg.filter.AbstractFunction;

/**
 * Alter frame colors in video with pseudocolors
 * 
 * @author tangxbai
 * @since 2022/07/21
 * @see <a href="https://ffmpeg.org/ffmpeg-filters.html#pseudocolor">ffmpeg-filters#pseudocolor</a>
 */
@Function( "pseudocolor" )
public class PseudoColor extends AbstractFunction<PseudoColor> {

	// Don't let anyone instantiate this class
	private PseudoColor() {}

	/**
	 * Quickly create an instances of {@link PseudoColor}
	 * 
	 * @return the {@link PseudoColor} instance
	 */
	public static final PseudoColor of() {
		return new PseudoColor();
	}

	/**
	 * Set pixel first component expression
	 * 
	 * <p>
	 * The expressions can contain the following constants and functions:
	 * 
	 * <ul>
	 * <li><b>w, h</b> - the input width and height.
	 * <li><b>val</b> - the input value for the pixel component.
	 * <li><b>ymin, umin, vmin, amin</b> - the minimum allowed component value.
	 * <li><b>ymax, umax, vmax, amax</b> - the maximum allowed component value.
	 * </ul>
	 * 
	 * @apiNote (string) c0
	 * @param expression the component expression
	 * @return the {@link PseudoColor} instance
	 */
	public PseudoColor c0( String expression ) {
		return super.addArg( "c0", expression );
	}

	/**
	 * Set pixel second component expression
	 * 
	 * <p>
	 * The expressions can contain the following constants and functions:
	 * 
	 * <ul>
	 * <li><b>w, h</b> - the input width and height.
	 * <li><b>val</b> - the input value for the pixel component.
	 * <li><b>ymin, umin, vmin, amin</b> - the minimum allowed component value.
	 * <li><b>ymax, umax, vmax, amax</b> - the maximum allowed component value.
	 * </ul>
	 * 
	 * @apiNote (string) c1
	 * @param expression the component expression
	 * @return the {@link PseudoColor} instance
	 */
	public PseudoColor c1( String expression ) {
		return super.addArg( "c1", expression );
	}

	/**
	 * Set pixel third component expression
	 * 
	 * <p>
	 * The expressions can contain the following constants and functions:
	 * 
	 * <ul>
	 * <li><b>w, h</b> - the input width and height.
	 * <li><b>val</b> - the input value for the pixel component.
	 * <li><b>ymin, umin, vmin, amin</b> - the minimum allowed component value.
	 * <li><b>ymax, umax, vmax, amax</b> - the maximum allowed component value.
	 * </ul>
	 * 
	 * @apiNote (string) c2
	 * @param expression the component expression
	 * @return the {@link PseudoColor} instance
	 */
	public PseudoColor c2( String expression ) {
		return super.addArg( "c2", expression );
	}

	/**
	 * Set pixel fourth component expression, corresponds to the alpha component.
	 * 
	 * <p>
	 * The expressions can contain the following constants and functions:
	 * 
	 * <ul>
	 * <li><b>w, h</b> - the input width and height.
	 * <li><b>val</b> - the input value for the pixel component.
	 * <li><b>ymin, umin, vmin, amin</b> - the minimum allowed component value.
	 * <li><b>ymax, umax, vmax, amax</b> - the maximum allowed component value.
	 * </ul>
	 * 
	 * @apiNote (string) c3
	 * @param expression the component expression
	 * @return the {@link PseudoColor} instance
	 */
	public PseudoColor c3( String expression ) {
		return super.addArg( "c3", expression );
	}

	/**
	 * Set component to use as base for altering colors
	 * 
	 * @apiNote (int) index, i
	 * @param value the component index
	 * @return the {@link PseudoColor} instance
	 */
	public PseudoColor index( int value ) {
		return super.addArg( "i", value ); // index, i
	}

	/**
	 * Set opacity of output colors. Allowed range is from 0 to 1, default value is set to <b>1</b>.
	 * 
	 * @apiNote (double) opacity
	 * @param value the output color opacity
	 * @return the {@link PseudoColor} instance
	 */
	public PseudoColor opacity( double value ) {
		return super.addArg( "opacity", value );
	}

	/**
	 * Pick one of built-in LUTs. By default is set to {@link Preset#NONE NONE}.
	 * 
	 * @apiNote (flags) preset, p
	 * @param preset the built-in LUT
	 * @return the {@link PseudoColor} instance
	 * @see Preset
	 */
	public PseudoColor preset( Preset preset ) {
		return super.addArg( "p", preset ); // preset, p
	}

	/**
	 * Built-in LUTs
	 *
	 * @author tangxbai
	 * @since 2022/07/21
	 */
	public enum Preset implements AbstractEnum {
		NONE, MAGMA, INFERNO, PLASMA, VIRIDIS, TURBO, CIVIDIS, RANGE1, RANGE2, SHADOWS, HIGHLIGHTS, SOLAR, NOMINAL,
		PREFERRED, TOTAL
	}

}
