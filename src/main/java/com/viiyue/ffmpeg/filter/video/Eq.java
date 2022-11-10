package com.viiyue.ffmpeg.filter.video;

import com.viiyue.ffmpeg.annotation.Function;
import com.viiyue.ffmpeg.enums.When;
import com.viiyue.ffmpeg.filter.AbstractFunction;
import com.viiyue.ffmpeg.util.Assert;

/**
 * Set brightness, contrast, saturation and approximate gamma adjustment.
 * 
 * <p>
 * All expressions can accept the following parameters:
 * <ul>
 * <li><b>n</b> - frame count of the input frame starting from 0
 * <li><b>pos</b> - byte position of the corresponding packet in the input file, NAN if unspecified.
 * <li><b>r</b> - frame rate of the input video, NAN if the input frame rate is unknown.
 * <li><b>t</b> - timestamp expressed in seconds, NAN if the input timestamp is unknown.
 * </ul>
 * 
 * @author tangxbai
 * @since 2022/06/29
 * @see <a href="https://ffmpeg.org/ffmpeg-filters.html#eq">ffmpeg-filters#eq</a>
 */
@Function( "eq" )
public class Eq extends AbstractFunction<Eq> {

	// Don't let anyone instantiate this class
	private Eq() {}

	/**
	 * Quickly create an instances of {@link Eq}, and set the scale factor, default is {@link Scaling#TRIPLE}.
	 * 
	 * @return the {@link Eq} instance
	 */
	public static final Eq of() {
		return new Eq();
	}

	/**
	 * Set the contrast value. The evaluated value must be a double value in range -1000.0 to 1000.0. The
	 * default value is <b>1</b>.
	 * 
	 * @apiNote (double) contrast
	 * @param value the contrast value
	 * @return the {@link Eq} instance
	 */
	public Eq contrast( double value ) {
		Assert.rangeCheck( value, -1000.0, 1000.0 );
		return super.addArg( "contrast", value );
	}

	/**
	 * Set the contrast expression. The value must be a double value in range -1000.0 to 1000.0. The default
	 * value is "1".
	 * 
	 * @apiNote (string) contrast
	 * @param when the contrast expression
	 * @return the {@link Eq} instance
	 */
	public Eq contrast( String expression ) {
		return super.addArg( "contrast", expression );
	}

	/**
	 * Set the brightness value. The value must be a double value in range -1.0 to 1.0. The default value is
	 * <b>0</b>.
	 * 
	 * @apiNote (double) brightness
	 * @param value the brightness value
	 * @return the {@link Eq} instance
	 */
	public Eq brightness( double value ) {
		Assert.rangeCheck( value, -1.0, 1.0 );
		return super.addArg( "brightness", value );
	}

	/**
	 * Set the brightness expression. The evaluated value must be a double value in range -1.0 to 1.0. The
	 * default value is "0".
	 * 
	 * @apiNote (string) brightness
	 * @param when the brightness expression
	 * @return the {@link Eq} instance
	 */
	public Eq brightness( String expression ) {
		return super.addArg( "brightness", expression );
	}

	/**
	 * Set the saturation value. The value must be a double in range 0.0 to 3.0. The default value is
	 * <b>1</b>.
	 * 
	 * @apiNote (double) saturation
	 * @param value the saturation value
	 * @return the {@link Eq} instance
	 */
	public Eq saturation( double value ) {
		Assert.rangeCheck( value, 0.0, 3.0 );
		return super.addArg( "saturation", value );
	}

	/**
	 * Set the saturation expression. The evaluated value must be a double in range 0.0 to 3.0. The default
	 * value is "1".
	 * 
	 * @apiNote (string) saturation
	 * @param when the saturation expression
	 * @return the {@link Eq} instance
	 */
	public Eq saturation( String expression ) {
		return super.addArg( "saturation", expression );
	}

	/**
	 * Set the gamma value. The value must be a double in range 0.1 to 10.0. The default value is <b>1</b>.
	 * 
	 * @apiNote (double) gamma
	 * @param value the initial gamma value
	 * @return the {@link Eq} instance
	 */
	public Eq gamma( double value ) {
		Assert.rangeCheck( value, 0.1, 10.0 );
		return super.addArg( "gamma", value );
	}

	/**
	 * Set the gamma expression. The evaluated value must be a float in range 0.1 to 10.0. The default value
	 * is "1".
	 * 
	 * @apiNote (string) gamma
	 * @param when the initial gamma expression
	 * @return the {@link Eq} instance
	 */
	public Eq gamma( String expression ) {
		return super.addArg( "gamma", expression );
	}

	/**
	 * Set the gamma value for red. The value must be a double in range 0.1 to 10.0. The default value is
	 * <b>1</b>.
	 * 
	 * @apiNote (double) gamma_r
	 * @param value the initial gamma value for red
	 * @return the {@link Eq} instance
	 */
	public Eq gammaRed( double value ) {
		Assert.rangeCheck( value, 0.1, 10.0 );
		return super.addArg( "gamma_r", value );
	}

	/**
	 * Set the gamma expression for red. The evaluated value must be a float in range 0.1 to 10.0. The default
	 * value is "1".
	 * 
	 * @apiNote (string) gamma_r
	 * @param when the initial gamma expression for red
	 * @return the {@link Eq} instance
	 */
	public Eq gammaRed( String expression ) {
		return super.addArg( "gamma_r", expression );
	}

	/**
	 * Set the gamma value for green. The value must be a double in range 0.1 to 10.0. The default value is
	 * <b>1</b>.
	 * 
	 * @apiNote (double) gamma_g
	 * @param value the initial gamma value for green
	 * @return the {@link Eq} instance
	 */
	public Eq gammaGreen( double value ) {
		Assert.rangeCheck( value, 0.1, 10.0 );
		return super.addArg( "gamma_g", value );
	}

	/**
	 * Set the gamma expression for green. The evaluated value must be a float in range 0.1 to 10.0. The
	 * default value is "1".
	 * 
	 * @apiNote (string) gamma_g
	 * @param when the initial gamma expression for green
	 * @return the {@link Eq} instance
	 */
	public Eq gammaGreen( String expression ) {
		return super.addArg( "gamma_g", expression );
	}

	/**
	 * Set the gamma value for blue. The value must be a double in range 0.1 to 10.0. The default value is
	 * <b>1</b>.
	 * 
	 * @apiNote (double) gamma_b
	 * @param value the initial gamma value for blue
	 * @return the {@link Eq} instance
	 */
	public Eq gammaBlue( double value ) {
		Assert.rangeCheck( value, 0.1, 10.0 );
		return super.addArg( "gamma_b", value );
	}

	/**
	 * Set the gamma expression for blue. The evaluated value must be a float in range 0.1 to 10.0. The
	 * default value is "1".
	 * 
	 * @apiNote (string) gamma_b
	 * @param when the initial gamma expression for blue
	 * @return the {@link Eq} instance
	 */
	public Eq gammaBlue( String expression ) {
		return super.addArg( "gamma_b", expression );
	}

	/**
	 * Set the gamma weight value. It can be used to reduce the effect of a high gamma value on bright image
	 * areas(e.g. keep them from getting overamplified and just plain white). The value must be a double in
	 * range 0.0 to 1.0. A value of 0.0 turns the gamma correction all the way down while 1.0 leaves it at its
	 * full strength. The default value is <b>1</b>.
	 * 
	 * @apiNote (double) gamma_weight
	 * @param value the gamma weight
	 * @return the {@link Eq} instance
	 */
	public Eq gammaWeight( double value ) {
		Assert.rangeCheck( value, 0.1, 1.0 );
		return super.addArg( "gamma_weight", value );
	}

	/**
	 * Set the gamma weight expression. It can be used to reduce the effect of a high gamma value on bright
	 * image areas(e.g. keep them from getting overamplified and just plain white). The value must be a double
	 * in range 0.0 to 1.0. A value of 0.0 turns the gamma correction all the way down while 1.0 leaves it at
	 * its full strength. The default value is "1".
	 * 
	 * @apiNote (string) gamma_weight
	 * @param when the gamma weight expression
	 * @return the {@link Eq} instance
	 */
	public Eq gammaWeight( String expression ) {
		return super.addArg( "gamma_weight", expression );
	}

	/**
	 * Set when the expressions for brightness, contrast, saturation and gamma expressions are evaluated.
	 * 
	 * @apiNote (flags) eval
	 * @param when specify when to evaluate expressions
	 * @return the {@link Eq} instance
	 * @see When
	 */
	public Eq eval( When when ) {
		return super.addArg( "eval", when );
	}

}
