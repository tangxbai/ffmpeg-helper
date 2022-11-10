package com.viiyue.ffmpeg.filter.video;

import com.viiyue.ffmpeg.annotation.Function;
import com.viiyue.ffmpeg.common.AbstractEnum;
import com.viiyue.ffmpeg.enums.When;
import com.viiyue.ffmpeg.filter.AbstractFunction;
import com.viiyue.ffmpeg.util.Assert;

/**
 * Make or reverse a natural vignetting effect
 * 
 * @author tangxbai
 * @since 2022/10/13
 * @see <a href= "https://ffmpeg.org/ffmpeg-filters.html#vignette-1">ffmpeg-filters#vignette</a>
 */
@Function( "vignette" )
public class Vignette extends AbstractFunction<Vignette> {

	// Don't let anyone instantiate this class
	private Vignette() {}

	/**
	 * Quickly create an instances of {@link Vignette}
	 * 
	 * @return the {@link Vignette} instance
	 */
	public static final Vignette of() {
		return new Vignette();
	}

	/**
	 * Set lens angle as a number of radians. Values range is in the [0, PI/2], default is <b>"PI/5"</b>.
	 * 
	 * @apiNote (int) angle, a
	 * @param value the lens angle
	 * @return the {@link Vignette} instance
	 */
	public Vignette angle( double value ) {
		Assert.rangeCheck( value, 0, Math.PI / 2 );
		return super.addArg( "a", value ); // angle, a
	}

	/**
	 * Set lens angle expression as a number of radians. Values range is in the [0, PI/2], default is
	 * <b>PI/5</b>.
	 * 
	 * @apiNote (int) angle, a
	 * @param value the lens angle expression
	 * @return the {@link Vignette} instance
	 */
	public Vignette angle( String expression ) {
		return super.addArg( "a", expression ); // angle, a
	}

	/**
	 * Set center coordinates
	 * 
	 * @apiNote (double) x0
	 * @apiNote (double) y0
	 * @param x0 the center coordinates of x
	 * @param y0 the center coordinates of y
	 * @return the {@link Vignette} instance
	 */
	public Vignette coordinates( double x0, double y0 ) {
		return super.addArg( "x0", x0 ).addArg( "y0", y0 );
	}

	/**
	 * <p>
	 * Set center coordinates expressions. Respectively "w/2" and "h/2" by default.
	 * 
	 * <p>
	 * The x0 and y0 expressions can contain the following parameters.
	 * 
	 * <ul>
	 * <li><b>w h</b> - input width and height
	 * <li><b>n</b> - the number of input frame, starting from 0
	 * <li><b>pts</b> - the PTS (Presentation TimeStamp) time of the filtered video frame, expressed in TB
	 * units, NAN if undefined
	 * <li><b>r</b> - frame rate of the input video, NAN if the input frame rate is unknown
	 * <li><b>t</b> - the PTS (Presentation TimeStamp) of the filtered video frame, expressed in seconds, NAN
	 * if undefined
	 * <li><b>tb</b> - time base of the input video
	 * </ul>
	 * 
	 * @apiNote (string) x0
	 * @apiNote (string) y0
	 * @param x0 the center coordinates of x
	 * @param y0 the center coordinates of y
	 * @return the {@link Vignette} instance
	 */
	public Vignette coordinates( String x0, String y0 ) {
		return super.addArg( "x0", x0 ).addArg( "y0", y0 );
	}

	/**
	 * Set forward/backward mode, default is {@link Mode#FORWARD}.
	 * 
	 * @apiNote (flags) mode
	 * @param mode the forward/backward mode
	 * @return the {@link Vignette} instance
	 * @see Mode
	 */
	public Vignette mode( Mode mode ) {
		return super.addArg( "mode", mode );
	}

	/**
	 * Set evaluation mode for the expressions (angle, x0, y0)
	 * 
	 * @apiNote (flags) eval
	 * @param when the evaluation mode
	 * @return the {@link Vignette} instance
	 * @see When
	 */
	public Vignette eval( When when ) {
		return super.addArg( "eval", when );
	}

	/**
	 * Set dithering to reduce the circular banding effects. Default is {@code false}.
	 * 
	 * @apiNote (boolean) dither
	 * @return the {@link Vignette} instance
	 */
	public Vignette dither() {
		return super.enable( "dither" );
	}

	/**
	 * <p>
	 * Set vignette aspect. This setting allows one to adjust the shape of the vignette. Setting this value to
	 * the SAR of the input will make a rectangular vignetting following the dimensions of the video.
	 * 
	 * <p>
	 * Default is {@code 1/1}.
	 * 
	 * @apiNote (string) dither
	 * @param expression the vignette aspect expression
	 * @return the {@link Vignette} instance
	 */
	public Vignette aspect( String expression ) {
		return super.addArg( "aspect", expression );
	}

	/**
	 * Forward/backward mode
	 *
	 * @author tangxbai
	 * @since 2022/10/13
	 */
	public enum Mode implements AbstractEnum {
		/** The larger the distance from the central point, the darker the image becomes */
		FORWARD,
		/**
		 * The larger the distance from the central point, the brighter the image becomes. This can be used to
		 * reverse a vignette effect, though there is no automatic detection to extract the lens angle and
		 * other settings (yet). It can also be used to create a burning effect.
		 */
		BACKWARD
	}

}
