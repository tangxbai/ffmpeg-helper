package com.viiyue.ffmpeg.filter.video;

import com.viiyue.ffmpeg.annotation.Function;
import com.viiyue.ffmpeg.enums.Color;
import com.viiyue.ffmpeg.enums.Interpolation;
import com.viiyue.ffmpeg.filter.AbstractFunction;

/**
 * Apply shear transform to input video
 * 
 * @author tangxbai
 * @since 2022/08/04
 * @see <a href="https://ffmpeg.org/ffmpeg-filters.html#shear">ffmpeg-filters#shear</a>
 */
@Function( "shear" )
public class Shear extends AbstractFunction<Shear> {

	// Don't let anyone instantiate this class
	private Shear() {}

	/**
	 * Quickly create an instances of {@link Shear}
	 * 
	 * @return the {@link Shear} instance
	 */
	public static final Shear of() {
		return new Shear();
	}

	/**
	 * Shear factor in X-direction. Allowed range is from -2 to 2, default value is <b>0</b>.
	 * 
	 * @apiNote (double) shx
	 * @param value the x shear factor
	 * @return the {@link Shear} instance
	 */
	public Shear shearX( double value ) {
		return super.addArg( "shx", value );
	}

	/**
	 * Shear factor in Y-direction. Allowed range is from -2 to 2, default value is <b>0</b>.
	 * 
	 * @apiNote (double) shy
	 * @param value the x shear factor
	 * @return the {@link Shear} instance
	 */
	public Shear shearY( double value ) {
		return super.addArg( "shy", value );
	}

	/**
	 * <p>
	 * Set the color used to fill the output area not covered by the rotated image. For the general syntax of
	 * this option, check the
	 * <a href="https://ffmpeg.org/ffmpeg-utils.html#color-syntax">(ffmpeg-utils)"Color" section in the
	 * ffmpeg-utils manual</a>. If the special value "none" is selected then no background is printed (useful
	 * for example if the background is never shown).
	 * 
	 * <p>
	 * Default value is "black".
	 * 
	 * @apiNote (color) fillcolor
	 * @param color the fill color
	 * @return {@link Shear} instance
	 */
	public Shear fillColor( Color color ) {
		return fillColor( Color.ifEmpty( color ).command() );
	}

	/**
	 * <p>
	 * Set the color used to fill the output area not covered by the rotated image. For the general syntax of
	 * this option, check the
	 * <a href="https://ffmpeg.org/ffmpeg-utils.html#color-syntax">(ffmpeg-utils)"Color" section in the
	 * ffmpeg-utils manual</a>. If the special value "none" is selected then no background is printed (useful
	 * for example if the background is never shown).
	 * 
	 * <p>
	 * Default value is "black".
	 * 
	 * @apiNote (color) fillcolor
	 * @param color the fill color
	 * @return the {@link Shear} instance
	 */
	public Shear fillColor( String color ) {
		return super.addArg( "c", color );
	}

	/**
	 * Select the interlace mode
	 * 
	 * @apiNote (flags) field_mode
	 * @param mode the interlace mode
	 * @return the {@link Shear} instance
	 */
	public Shear interp( Interpolation interp ) {
		return super.addArg( "interp", interp );
	}

}
