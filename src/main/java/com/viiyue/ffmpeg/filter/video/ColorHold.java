package com.viiyue.ffmpeg.filter.video;

import com.viiyue.ffmpeg.annotation.Function;
import com.viiyue.ffmpeg.enums.Color;
import com.viiyue.ffmpeg.filter.AbstractFunction;
import com.viiyue.ffmpeg.util.Assert;

/**
 * Remove all color information for all RGB colors except for certain one.
 * 
 * @author tangxbai
 * @since 2022/06/15
 * @see <a href="https://ffmpeg.org/ffmpeg-filters.html#colorhold">ffmpeg-filters#colorhold</a>
 */
@Function( "colorhold" )
public class ColorHold extends AbstractFunction<ColorHold> {

	private final Object color;
	private double similarity;
	private double blend;

	// Don't let anyone instantiate this class
	private ColorHold( Object color ) {
		this.color = color;
	}

	@Override
	protected String getResult() {
		super.addValues( color, similarity, blend );
		return super.getResult();
	}

	/**
	 * Quickly create an instances of {@link ColorHold}
	 * 
	 * @apiNote (string) color
	 * @param color the color value
	 * @return the {@link ColorHold} instance
	 */
	public static final ColorHold of( String color ) {
		return new ColorHold( color );
	}

	/**
	 * Quickly create an instances of {@link ColorCorrect}
	 * 
	 * @apiNote (color) rl
	 * @param color the color instance
	 * @return the {@link ColorHold} instance
	 * @see Color
	 */
	public static final ColorHold of( Color color ) {
		return new ColorHold( color );
	}

	/**
	 * Quickly create an instances of {@link ColorCorrect}
	 * 
	 * @apiNote (string) color, (double) similarity, (double) blend
	 * @param color      the color value
	 * @param similarity the color similarity
	 * @param blend      the color blend value
	 * @return the {@link ColorHold} instance
	 */
	public static final ColorHold of( String color, double similarity, double blend ) {
		return new ColorHold( color ).similarity( similarity ).blend( blend );
	}

	/**
	 * Quickly create an instances of {@link ColorCorrect}
	 * 
	 * @apiNote (color) color, (double) similarity, (double) blend
	 * @param color      the color instance
	 * @param similarity the color similarity
	 * @param blend      the color blend value
	 * @return the {@link ColorHold} instance
	 */
	public static final ColorHold of( Color color, double similarity, double blend ) {
		return new ColorHold( color ).similarity( similarity ).blend( blend );
	}

	/**
	 * <p>
	 * Set the radius from the key color within which other colors also have full transparency.
	 * 
	 * <p>
	 * The computed distance is related to the unit fractional distance in 3D space between the RGB values of
	 * the key color and the pixel’s color.
	 * 
	 * <p>
	 * Range is 0.01 to 1.0. 0.01 matches within a very small radius around the exact key color, while 1.0
	 * matches everything, default is <b>0.01</b>.
	 * 
	 * @apiNote (double) similarity
	 * @param similarity the color similarity
	 * @return the {@link ColorHold} instance
	 */
	public ColorHold similarity( double similarity ) {
		Assert.rangeCheck( similarity, 0.01, 1.0 );
		this.similarity = similarity;
		return this;
	}

	/**
	 * <p>
	 * Set how the alpha value for pixels that fall outside the similarity radius is computed.
	 * 
	 * <p>
	 * 0.0 makes pixels either fully transparent or fully opaque. Higher values result in semi-transparent
	 * pixels, with greater transparency the more similar the pixel color is to the key color, range is 0.0 to
	 * 1.0 and default is <b>0.0</b>.
	 * 
	 * @apiNote (double) blend
	 * @param blend the alpha value
	 * @return the {@link ColorHold} instance
	 */
	public ColorHold blend( double blend ) {
		Assert.rangeCheck( blend, 0.0, 1.0 );
		this.blend = blend;
		return this;
	}

}
