package com.viiyue.ffmpeg.filter;

import com.viiyue.ffmpeg.enums.Color;

/**
 * Abstract color methods
 * 
 * @author tangxbai
 * @since 2022/06/02
 * @param <T> the current instance
 */
public abstract class AbstractColorFunction<T extends AbstractColorFunction<?>> extends AbstractFunction<T> {

	/**
	 * Specify the color of the box to write. For the general syntax of this option, check the
	 * (ffmpeg-utils)"Color" section in the ffmpeg-utils manual. If the special value invert is used, the box
	 * edge color is the same as the video with inverted luma.
	 * 
	 * @apiNote (color) color, c
	 * @param color the box color
	 * @return <T> the current instance
	 * @see Color
	 */
	public T color( Color color ) {
		return color( color, 0 );
	}

	/**
	 * Specify the color of the box to write. For the general syntax of this option, check the (ffmpeg-utils)
	 * "Color" section in the ffmpeg-utils manual. If the special value invert is used, the box edge color is
	 * the same as the video with inverted luma.
	 * 
	 * @apiNote (color) color, c
	 * @param color the box color
	 * @param alpha the alpha value
	 * @return <T> the current instance
	 * @see Color
	 */
	public T color( Color color, double alpha ) {
		return color( ( color == null ? Color.RANDOM : color ).command(), alpha );
	}

	/**
	 * Specify the color of the box to write. For the general syntax of this option, check the (ffmpeg-utils)
	 * "Color" section in the ffmpeg-utils manual. If the special value invert is used, the box edge color is
	 * the same as the video with inverted luma.
	 * 
	 * @apiNote (color) color, c
	 * @param color the hex color
	 * @return <T> the current instance
	 */
	public T color( String color ) {
		return color( color, 0 );
	}

	/**
	 * Specify the color of the box to write. For the general syntax of this option, check the (ffmpeg-utils)
	 * "Color" section in the ffmpeg-utils manual. If the special value invert is used, the box edge color is
	 * the same as the video with inverted luma.
	 * 
	 * @apiNote (color) color, c
	 * @param color the hex color
	 * @param alpha the alpha value
	 * @return <T> the current instance
	 */
	public T color( String color, double alpha ) {
		return super.addArg( "color", alpha > 0 ? color + "@" + alpha : color );
	}

}
