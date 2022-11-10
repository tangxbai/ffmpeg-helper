package com.viiyue.ffmpeg.filter.video;

import com.viiyue.ffmpeg.annotation.Function;
import com.viiyue.ffmpeg.common.AbstractEnum;
import com.viiyue.ffmpeg.filter.AbstractFunction;
import com.viiyue.ffmpeg.util.Assert;

/**
 * Adjust color white balance selectively for blacks and whites, this filter operates in YUV colorspace.
 *
 * @author tangxbai
 * @since 2022/06/15
 * @see <a href="https://ffmpeg.org/ffmpeg-filters.html#colorcorrect">ffmpeg-filters#colorcorrect</a>
 */
@Function( "colorcorrect" )
public class ColorCorrect extends AbstractFunction<ColorCorrect> {

	// Don't let anyone instantiate this class
	private ColorCorrect() {}

	/**
	 * Quickly create an instances of {@link ColorCorrect}
	 * 
	 * @return the {@link ColorCorrect} instance
	 */
	public static final ColorCorrect the() {
		return new ColorCorrect();
	}

	/**
	 * Set the red shadow spot, allowed range is from -1.0 to 1.0 and default value is <b>0</b>.
	 * 
	 * @apiNote (double) rl
	 * @param contrast the red shadow spot
	 * @return the {@link ColorCorrect} instance
	 */
	public ColorCorrect redShadow( double spot ) {
		Assert.rangeCheck( spot, -1.0, 1.0 );
		return super.addArg( "rl", spot );
	}

	/**
	 * Set the blue shadow spot, allowed range is from -1.0 to 1.0 and default value is <b>0</b>.
	 * 
	 * @apiNote (double) bl
	 * @param contrast the blue shadow spot
	 * @return the {@link ColorCorrect} instance
	 */
	public ColorCorrect blueShadow( double spot ) {
		Assert.rangeCheck( spot, -1.0, 1.0 );
		return super.addArg( "bl", spot );
	}

	/**
	 * Set the red highlight spot, allowed range is from -1.0 to 1.0 and default value is <b>0</b>.
	 * 
	 * @apiNote (double) rh
	 * @param contrast the red highlight spot
	 * @return the {@link ColorCorrect} instance
	 */
	public ColorCorrect redHighligh( double spot ) {
		Assert.rangeCheck( spot, -1.0, 1.0 );
		return super.addArg( "rh", spot );
	}

	/**
	 * Set the blue highlight spot, allowed range is from -1.0 to 1.0 and default value is <b>0</b>.
	 * 
	 * @apiNote (double) bh
	 * @param contrast the blue highlight spot
	 * @return the {@link ColorCorrect} instance
	 */
	public ColorCorrect blueHighligh( double spot ) {
		Assert.rangeCheck( spot, -1.0, 1.0 );
		return super.addArg( "bh", spot );
	}

	/**
	 * If set to anything other than {@code manual} it will analyze every frame and use derived parameters for
	 * filtering output frame.
	 * 
	 * @apiNote (flags) analyze
	 * @param analyze the frame analyze option
	 * @return the {@link ColorCorrect} instance
	 * @see Analyze
	 */
	public ColorCorrect analyze( Analyze analyze ) {
		return super.addArg( "analyze", analyze );
	}

	/**
	 * Frame analysis of possible options
	 *
	 * @author tangxbai
	 * @since 2022/06/15
	 */
	public enum Analyze implements AbstractEnum {
		MANUAL, AVERAGE, MINMAX, MEDIAN
	}

}
