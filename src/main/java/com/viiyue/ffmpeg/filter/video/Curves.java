package com.viiyue.ffmpeg.filter.video;

import com.viiyue.ffmpeg.annotation.Function;
import com.viiyue.ffmpeg.common.AbstractEnum;
import com.viiyue.ffmpeg.filter.AbstractFunction;
import com.viiyue.ffmpeg.util.Assert;
import com.viiyue.ffmpeg.util.Helper;

/**
 * <p>
 * Apply color adjustments using curves.
 * 
 * <p>
 * This filter is similar to the Adobe Photoshop and GIMP curves tools. Each component (red, green and blue)
 * has its values defined by N key points tied from each other using a smooth curve. The x-axis represents the
 * pixel values from the input frame, and the y-axis the new pixel values to be set for the output frame.
 * 
 * <p>
 * By default, a component curve is defined by the two points (0;0) and (1;1). This creates a straight line
 * where each original pixel value is "adjusted" to its own value, which means no change to the image.
 * 
 * <p>
 * The filter allows you to redefine these two points and add some more. A new curve (using a natural cubic
 * spline interpolation) will be define to pass smoothly through all these new coordinates. The new defined
 * points needs to be strictly increasing over the x-axis, and their x and y values must be in the [0;1]
 * interval. If the computed curves happened to go outside the vector spaces, the values will be clipped
 * accordingly.
 * 
 * @author tangxbai
 * @since 2022/06/17
 * @see <a href="https://ffmpeg.org/ffmpeg-filters.html#curves">ffmpeg-filters#curves</a>
 */
@Function( "curves" )
public class Curves extends AbstractFunction<Curves> {

	// Don't let anyone instantiate this class
	private Curves() {}

	/**
	 * Quickly create an instances of {@link Curves}
	 * 
	 * @return the {@link Curves} instance
	 */
	public static final Curves of() {
		return new Curves();
	}

	/**
	 * Select one of the available color presets. This option can be used in addition to the r, g, b
	 * parameters; in this case, the later options takes priority on the preset values.
	 * 
	 * @apiNote (flags) preset
	 * @param preset the color preset
	 * @return the {@link Curves} instance
	 */
	public Curves preset( ColorPreset preset ) {
		return super.addArg( "preset", preset );
	}

	/**
	 * <p>
	 * Set the master key points. These points will define a second pass mapping. It is sometimes called a
	 * "luminance" or "value" mapping. It can be used with r, g, b or all since it acts like a post-processing
	 * LUT.
	 * 
	 * <p>
	 * To avoid some {@code filtergraph} syntax conflicts, each key points list need to be defined using the
	 * following syntax: <code>x0/y0 x1/y1 x2/y2 ....</code>
	 * 
	 * @apiNote (flags) master, m
	 * @param keyPoints the master key points
	 * @return the {@link Curves} instance
	 */
	public Curves master( String keyPoints ) {
		return super.addArg( "m", Helper.escape( keyPoints, true ) ); // master, m
	}

	/**
	 * <p>
	 * Set the key points for the red component
	 * 
	 * <p>
	 * To avoid some {@code filtergraph} syntax conflicts, each key points list need to be defined using the
	 * following syntax: <code>x0/y0 x1/y1 x2/y2 ....</code>
	 * 
	 * @apiNote (string) red, r
	 * @param keyPoints the red key points
	 * @return the {@link Curves} instance
	 */
	public Curves red( String keyPoints ) {
		return super.addArg( "r", Helper.escape( keyPoints, true ) ); // red, r
	}

	/**
	 * <p>
	 * Set the key points for the green component
	 * 
	 * <p>
	 * To avoid some {@code filtergraph} syntax conflicts, each key points list need to be defined using the
	 * following syntax: <code>x0/y0 x1/y1 x2/y2 ....</code>
	 * 
	 * @apiNote (string) green, g
	 * @param keyPoints the red key points
	 * @return the {@link Curves} instance
	 */
	public Curves green( String keyPoints ) {
		return super.addArg( "g", Helper.escape( keyPoints, true ) ); // green, g
	}

	/**
	 * <p>
	 * Set the key points for the blue component
	 * 
	 * <p>
	 * To avoid some {@code filtergraph} syntax conflicts, each key points list need to be defined using the
	 * following syntax: <code>x0/y0 x1/y1 x2/y2 ....</code>
	 * 
	 * @apiNote (string) blue, b
	 * @param keyPoints the blue key points
	 * @return the {@link Curves} instance
	 */
	public Curves blue( String keyPoints ) {
		return super.addArg( "b", Helper.escape( keyPoints, true ) ); // blue, b
	}

	/**
	 * <p>
	 * Set the key points for all components (not including master). Can be used in addition to the other key
	 * points component options. In this case, the unset component(s) will fallback on this all setting.
	 * 
	 * <p>
	 * To avoid some {@code filtergraph} syntax conflicts, each key points list need to be defined using the
	 * following syntax: <code>x0/y0 x1/y1 x2/y2 ....</code>
	 * 
	 * @apiNote (string) all
	 * @param keyPoints the blue key points
	 * @return the {@link Curves} instance
	 */
	public Curves all( String keyPoints ) {
		return super.addArg( "all", Helper.escape( keyPoints, true ) );
	}

	/**
	 * Specify a Photoshop curves file (.acv) to import the settings from.
	 * 
	 * @apiNote (string) psfile
	 * @param filePath the photoshop curves file path
	 * @return the {@link Curves} instance
	 */
	public Curves psfile( String filePath ) {
		Assert.notEmpty( filePath, "acv" );
		return super.addArg( "psfile", Helper.escape( filePath, true ) );
	}

	/**
	 * Save Gnuplot script of the curves in specified file.
	 * 
	 * @apiNote (string) plot
	 * @param target the specified script file path
	 * @return the {@link Curves} instance
	 */
	public Curves gnuplot( String target ) {
		return super.addArg( "plot", Helper.escape( target, true ) );
	}

	/**
	 * Available color presets
	 * 
	 * @author tangxbai
	 * @since 2022/06/16
	 */
	public enum ColorPreset implements AbstractEnum {
		NONE, COLOR_NEGATIVE, CROSS_PROCESS, DARKER, INCREASE_CONTRAST, LIGHTER, LINEAR_CONTRAST, MEDIUM_CONTRAST,
		NEGATIVE, STRONG_CONTRAST, VINTAGE
	}

}
