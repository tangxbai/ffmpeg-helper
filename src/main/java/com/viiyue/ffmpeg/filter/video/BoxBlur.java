package com.viiyue.ffmpeg.filter.video;

import com.viiyue.ffmpeg.annotation.Function;
import com.viiyue.ffmpeg.filter.AbstractFunction;
import com.viiyue.ffmpeg.util.Helper;

/**
 * Apply a boxblur algorithm to the input video.
 *
 * @author tangxbai
 * @since 2022/06/02
 * @see <a href="https://ffmpeg.org/ffmpeg-filters.html#boxblur">ffmpeg-filters#boxblur</a>
 */
@Function( "boxblur" )
public class BoxBlur extends AbstractFunction<BoxBlur> {

	// Don't let anyone instantiate this class
	private BoxBlur() {}

	/**
	 * Quickly create an instances of {@link BoxBlur}
	 * 
	 * @return the {@link BoxBlur} instance
	 */
	public static final BoxBlur the() {
		return new BoxBlur();
	}

	/**
	 * <p>
	 * Set an expression for the box radius in pixels used for blurring the corresponding input plane. The
	 * radius value must be a non-negative number, and must not be greater than the value of the expression
	 * min(w,h)/2 for the luma and alpha planes, and of min(cw,ch)/2 for the chroma planes.
	 * 
	 * <p>
	 * The expressions can contain the following constants:
	 * 
	 * <pre>
	 * <code>w</code> 
	 * <code>h</code> 
	 * The input width and height in pixels.
	 * 
	 * <code>cw</code> 
	 * <code>ch</code> 
	 * The input chroma image width and height in pixels.
	 * 
	 * <code>hsub</code> 
	 * <code>vsub</code> 
	 * The horizontal and vertical chroma subsample values. 
	 * For example, for the pixel format "yuv422p", hsub is 2 and vsub is 1.
	 * </pre>
	 * 
	 * @apiNote (string) lr
	 * @param expression the radius expression
	 * @return the {@link BoxBlur} instance
	 */
	public BoxBlur lumaRadius( String expression ) {
		return super.addArg( "lr", Helper.escape( expression, true ) ); // luma_radius, lr
	}

	/**
	 * Set the box radius in pixels used for blurring the corresponding input plane
	 * 
	 * @apiNote (double) lr
	 * @param expression the radius expression
	 * @return the {@link BoxBlur} instance
	 */
	public BoxBlur lumaRadius( double radius ) {
		return super.addArg( "lr", radius ); // luma_radius, lr
	}

	/**
	 * @apiNote (string) cr
	 * @param expression the radius expression
	 * @return the {@link BoxBlur} instance
	 * @see #lumaRadius(String)
	 */
	public BoxBlur chromaRadius( String expression ) {
		return super.addArg( "cr", Helper.escape( expression, true ) ); // chroma_radius, cr
	}

	/**
	 * Set the box radius in pixels used for blurring the corresponding input plane
	 * 
	 * @apiNote (double) cr
	 * @param expression the radius expression
	 * @return the {@link BoxBlur} instance
	 */
	public BoxBlur chromaRadius( double radius ) {
		return super.addArg( "cr", radius ); // chroma_radius, cr
	}

	/**
	 * Please refer to {@link #lumaRadius(String)}
	 * 
	 * @apiNote (string) ar
	 * @param expression the radius expression
	 * @return the {@link BoxBlur} instance
	 * @see #lumaRadius(String)
	 */
	public BoxBlur alphaRadius( String expression ) {
		return super.addArg( "ar", Helper.escape( expression, true ) ); // alpha_radius, ar
	}

	/**
	 * Set the box radius in pixels used for blurring the corresponding input plane
	 * 
	 * @apiNote (double) ar
	 * @param expression the radius expression
	 * @return the {@link BoxBlur} instance
	 */
	public BoxBlur alphaRadius( double radius ) {
		return super.addArg( "ar", radius ); // alpha_radius, ar
	}

	/**
	 * <p>
	 * Specify how many times the boxblur filter is applied to the corresponding plane.
	 * 
	 * <p>
	 * Default value for luma_power is 2. If not specified, chroma_power and alpha_power default to the
	 * corresponding value set for luma_power.
	 * 
	 * <p>
	 * A value of 0 will disable the effect.
	 * 
	 * @apiNote (int) lp
	 * @param times the filter applied times
	 * @return the {@link BoxBlur} instance
	 */
	public BoxBlur lumaPower( int times ) {
		return super.addArg( "lp", times ); // luma_power, lp
	}

	/**
	 * Please refer to {@link #lumaPower(int)}
	 * 
	 * @apiNote (int) cp
	 * @param times the filter applied times
	 * @return the {@link BoxBlur} instance
	 */
	public BoxBlur chromaPower( int times ) {
		return super.addArg( "cp", times ); // chroma_power, cp
	}

	/**
	 * Please refer to {@link #lumaPower(int)}
	 * 
	 * @apiNote (int) ap
	 * @param times the filter applied times
	 * @return the {@link BoxBlur} instance
	 */
	public BoxBlur alphaPower( int times ) {
		return super.addArg( "ap", times ); // alpha_power, ap
	}

}
