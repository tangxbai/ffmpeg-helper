package com.viiyue.ffmpeg.filter.video;

import com.viiyue.ffmpeg.annotation.Alias;
import com.viiyue.ffmpeg.annotation.Function;
import com.viiyue.ffmpeg.common.AbstractEnum;
import com.viiyue.ffmpeg.common.Const;
import com.viiyue.ffmpeg.enums.Envelope;
import com.viiyue.ffmpeg.enums.Graticule;
import com.viiyue.ffmpeg.filter.AbstractFunction;
import com.viiyue.ffmpeg.util.Assert;

/**
 * Display 2 color component values in the two dimensional graph (which is called a vectorscope).
 * 
 * @author tangxbai
 * @since 2022/10/11
 * @see <a href="https://ffmpeg.org/ffmpeg-filters.html#vectorscope">ffmpeg-filters#vectorscope</a>
 */
@Function( "vectorscope" )
public class VectorScope extends AbstractFunction<VectorScope> {

	// Don't let anyone instantiate this class
	private VectorScope() {}

	/**
	 * Quickly create an instances of {@link VectorScope}
	 * 
	 * @return the {@link VectorScope} instance
	 */
	public static final VectorScope of() {
		return new VectorScope();
	}

	/**
	 * Set vectorscope mode, default is {@link ScopeMode#GRAY}.
	 * 
	 * @apiNote (flags) mode, m
	 * @param mode the vectorscope mode
	 * @return the {@link VectorScope} instance
	 */
	public VectorScope mode( ScopeMode mode ) {
		return super.addArg( "m", mode ); // mode, m
	}

	/**
	 * Set which color component will be represented on X-axis/Y-axis, X-axis default is <b>1</b>, Y-axis
	 * default is <b>2</b>.
	 * 
	 * @apiNote (int) x
	 * @apiNote (int) y
	 * @param x the color component on X axis
	 * @param y the color component on Y axis
	 * @return the {@link VectorScope} instance
	 */
	public VectorScope position( int x, int y ) {
		return super.addArg( "x", x ).addArg( "y", y );
	}

	/**
	 * Set intensity, used by modes: gray, color, color3 and color5 for increasing brightness of color
	 * component which represents frequency of (X, Y) location in graph. Default is <b>0.004</b>.
	 * 
	 * @apiNote (double) intensity, i
	 * @param value the intensity value
	 * @return the {@link VectorScope} instance
	 */
	public VectorScope intensity( double value ) {
		return super.addArg( "i", value ); // intensity, i
	}

	/**
	 * Set the envelope
	 * 
	 * @apiNote (flags) envelope, e
	 * @param value the envelope flags
	 * @return the {@link VectorScope} instance
	 * @see Envelope
	 */
	public VectorScope envelope( Envelope ... elements ) {
		return super.addArg( "e", Const.APPEND_SEPARATOR, elements ); // envelope, e
	}

	/**
	 * Set what kind of graticule to draw
	 * 
	 * @apiNote (flags) graticule, g
	 * @param graticule the graticule flag
	 * @return the {@link VectorScope} instance
	 * @see Graticule
	 */
	public VectorScope graticule( Graticule graticule ) {
		return super.addArg( "g", graticule ); // graticule, g
	}

	/**
	 * Set graticule opacity. Values range is from 0 to 1, default is <b>0.75</b>.
	 * 
	 * @apiNote (double) opacity, o
	 * @param value the graticule opacity value
	 * @return the {@link VectorScope} instance
	 */
	public VectorScope opacity( double value ) {
		Assert.rangeCheck( value, 0, 1 );
		return super.addArg( "o", value ); // opacity, o
	}

	/**
	 * Set graticule flags, default is {@link GraticuleFlags#NAME}
	 * 
	 * @apiNote (flags) flags, f
	 * @param value the graticule opacity value
	 * @return the {@link VectorScope} instance
	 * @see GraticuleFlags
	 */
	public VectorScope flags( GraticuleFlags flags ) {
		return super.addArg( "f", flags ); // flags, f
	}

	/**
	 * Set background opacity. Values range is from 0 to 1, default is <b>0.3</b>.
	 * 
	 * @apiNote (double) bgopacity, b
	 * @param value the background opacity value
	 * @return the {@link VectorScope} instance
	 */
	public VectorScope bgOpacity( double value ) {
		Assert.rangeCheck( value, 0, 1 );
		return super.addArg( "o", value ); // bgopacity, b
	}

	/**
	 * Set low threshold for color component not represented on X or Y axis. Values lower than this value will
	 * be ignored. Default is <b>0</b>. Note this value is multiplied with actual max possible value one pixel
	 * component can have. So for 8-bit input and low threshold value of 0.1 actual threshold is 0.1 * 255 =
	 * 25.
	 * 
	 * @apiNote (double) lthreshold, l
	 * @param value the low threshold value
	 * @return the {@link VectorScope} instance
	 */
	public VectorScope lowThreshold( double value ) {
		Assert.rangeCheck( value, 0, 1 );
		return super.addArg( "l", value ); // lthreshold, l
	}

	/**
	 * Set high threshold for color component not represented on X or Y axis. Values lower than this value
	 * will be ignored. Default is <b>1</b>. Note this value is multiplied with actual max possible value one
	 * pixel component can have. So for 8-bit input and low threshold value of 0.9 actual threshold is 0.9 *
	 * 255 = 230.
	 * 
	 * @apiNote (double) hthreshold, h
	 * @param value the high threshold value
	 * @return the {@link VectorScope} instance
	 */
	public VectorScope heighThreshold( double value ) {
		Assert.rangeCheck( value, 0, 1 );
		return super.addArg( "l", value ); // hthreshold, h
	}

	/**
	 * Set what kind of colorspace to use when drawing graticule
	 * 
	 * @apiNote (flags) colorspace, c
	 * @param value the high threshold value
	 * @return the {@link VectorScope} instance
	 * @see ColorSpace
	 */
	public VectorScope colorSpace( ColorSpace space ) {
		return super.addArg( "c", space ); // colorspace, c
	}

	/**
	 * Set color tint for gray/tint vectorscope mode. By default both options are zero. This means no tint,
	 * and output will remain gray. Default is <b>0</b>.
	 * 
	 * @apiNote (double) tint0, t0
	 * @param value the 1st tint value
	 * @return the {@link VectorScope} instance
	 */
	public VectorScope tint0( double value ) {
		Assert.rangeCheck( value, -1, 1 );
		return super.addArg( "t0", value ); // tint0, t0
	}

	/**
	 * Set color tint for gray/tint vectorscope mode. By default both options are zero. This means no tint,
	 * and output will remain gray. Default is <b>0</b>.
	 * 
	 * @apiNote (double) tint1, t1
	 * @param value the 2nd tint value
	 * @return the {@link VectorScope} instance
	 */
	public VectorScope tint1( double value ) {
		Assert.rangeCheck( value, -1, 1 );
		return super.addArg( "t1", value ); // tint1, t1
	}

	/**
	 * Vector Scope mode
	 *
	 * @author tangxbai
	 * @since 2022/10/11
	 */
	public enum ScopeMode implements AbstractEnum {
		/**
		 * Gray values are displayed on graph, higher brightness means more pixels have same component color
		 * value on location in graph. This is the default mode.
		 */
		GRAY,
		/**
		 * Gray values are displayed on graph, higher brightness means more pixels have same component color
		 * value on location in graph. This is the default mode.
		 */
		TINT,

		/**
		 * Gray values are displayed on graph. Surrounding pixels values which are not present in video frame
		 * are drawn in gradient of 2 color components which are set by option x and y. The 3rd color
		 * component is static.
		 */
		COLOR,

		/** Actual color components values present in video frame are displayed on graph */
		COLOR2,

		/**
		 * Similar as color2 but higher frequency of same values {@code x} and {@code y} on graph increases
		 * value of another color component, which is luminance by default values of {@code x} and {@code y}.
		 */
		COLOR3,

		/**
		 * Actual colors present in video frame are displayed on graph. If two different colors map to same
		 * position on graph then color with higher value of component not present in graph is picked
		 */
		COLOR4,

		/**
		 * Gray values are displayed on graph. Similar to {@code color} but with 3rd color component picked
		 * from radial gradient
		 */
		COLOR5
	}

	/**
	 * Graticule flags
	 *
	 * @author tangxbai
	 * @since 2022/10/11
	 */
	public enum GraticuleFlags implements AbstractEnum {
		/** Draw graticule for white point */
		WHITE,
		/** Draw graticule for black point */
		BLACK,
		/** Draw color points short names */
		NAME
	}

	/**
	 * Color Space
	 *
	 * @author tangxbai
	 * @since 2022/10/11
	 */
	public enum ColorSpace implements AbstractEnum {
		AUTO, @Alias( "601" )
		$601, @Alias( "709" )
		$709
	}

}
