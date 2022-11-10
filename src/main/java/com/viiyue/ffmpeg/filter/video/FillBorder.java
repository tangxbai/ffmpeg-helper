package com.viiyue.ffmpeg.filter.video;

import com.viiyue.ffmpeg.annotation.Function;
import com.viiyue.ffmpeg.common.AbstractEnum;
import com.viiyue.ffmpeg.filter.AbstractColorFunction;

/**
 * <p>
 * Fill borders of the input video, without changing video stream dimensions.
 * 
 * <p>
 * Sometimes video can have garbage at the four edges and you may not want to crop video input to keep size
 * multiple of some number.
 * 
 * @author tangxbai
 * @since 2022/06/02
 * @see <a href="https://ffmpeg.org/ffmpeg-filters.html#fillborders">ffmpeg-filters#fillborders</a>
 */
@Function( "fillborders" )
public class FillBorder extends AbstractColorFunction<FillBorder> {

	// Don't let anyone instantiate this class
	private FillBorder() {}

	/**
	 * Quickly create an instances of {@link FillBorder}
	 * 
	 * @apiNote (int) left/top/right/bottom
	 * @param width the border parameters, and the border left/top/width/height distance will apply this
	 *              value.
	 * @return the {@link FillBorder} instance
	 */
	public static final FillBorder mark( int width ) {
		return new FillBorder().position( width, width, width, width );
	}

	/**
	 * Quickly create an instances of {@link FillBorder}
	 * 
	 * @apiNote (int) left/top/right/bottom
	 * @param leftRight the border parameters, and the left/top/width/height will apply this value.
	 * @param topBottom the border parameters, and the left/top/width/height will apply this value.
	 * @return the {@link FillBorder} instance
	 */
	public static final FillBorder mark( int leftRight, int topBottom ) {
		return new FillBorder().position( leftRight, topBottom, leftRight, topBottom );
	}

	/**
	 * Quickly create an instances of {@link FillBorder}
	 * 
	 * @apiNote (int) left/top/right/bottom
	 * @param left   the left border distance
	 * @param top    the top border distance
	 * @param right  the right border distance
	 * @param bottom the bottom border distance
	 * @return the {@link FillBorder} instance
	 */
	public static final FillBorder mark( int left, int top, int right, int bottom ) {
		return new FillBorder().position( left, top, right, bottom );
	}

	/**
	 * Set the fill border distance
	 * 
	 * @apiNote (int) left/top/right/bottom
	 * @param left   the left border distance
	 * @param top    the top border distance
	 * @param right  the right border distance
	 * @param bottom the bottom border distance
	 * @return the {@link FillBorder} instance
	 */
	private FillBorder position( int left, int top, int right, int bottom ) {
		super.addArg( "left", left );
		super.addArg( "top", top );
		super.addArg( "right", right );
		super.addArg( "bottom", bottom );
		return this;
	}

	/**
	 * Set the fill borders mode
	 * 
	 * @apiNote (flags) mode
	 * @param mode the border fill mode
	 * @return {@link FillBorder} instance
	 */
	public FillBorder mode( BorderMode mode ) {
		return super.addArg( "mode", mode );
	}

	/**
	 * @author tangxbai
	 * @since 2022/06/02
	 */
	public enum BorderMode implements AbstractEnum {
		SMEAR, MIRROR, FIXED, REFLECT, WRAP, FADE, MARGINS
	}

}
