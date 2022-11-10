package com.viiyue.ffmpeg.filter.video;

import com.viiyue.ffmpeg.annotation.Function;
import com.viiyue.ffmpeg.common.AbstractEnum;
import com.viiyue.ffmpeg.enums.Color;
import com.viiyue.ffmpeg.filter.AbstractFunction;

/**
 * <p>
 * Remap pixels using 2nd: Xmap and 3rd: Ymap input video stream.
 * 
 * <p>
 * Destination pixel at position (X, Y) will be picked from source (x, y) position where x = Xmap(X, Y) and y
 * = Ymap(X, Y). If mapping values are out of range, zero value for pixel will be used for destination pixel.
 * 
 * <p>
 * Xmap and Ymap input video streams must be of same dimensions. Output video stream will have Xmap/Ymap video
 * stream dimensions. Xmap and Ymap input video streams are 16bit depth, single channel.
 * 
 * @author tangxbai
 * @since 2022/07/25
 * @see <a href="https://ffmpeg.org/ffmpeg-filters.html#remap">ffmpeg-filters#remap</a>
 */
@Function( "remap" )
public class Remap extends AbstractFunction<Remap> {

	// Don't let anyone instantiate this class
	private Remap() {}

	/**
	 * Quickly create an instances of {@link Remap}
	 * 
	 * @return the {@link Remap} instance
	 */
	public static final Remap of() {
		return new Remap();
	}

	/**
	 * Specify pixel format of output from this filter, default is {@link ColorFormat#COLOR COLOR}.
	 * 
	 * @apiNote (int) scan_max
	 * @param value the color format
	 * @return the {@link Remap} instance
	 */
	public Remap format( ColorFormat format ) {
		return super.addArg( "format", format );
	}

	/**
	 * Specify the color of the unmapped pixels. For the syntax of this option, check the
	 * <a href="https://ffmpeg.org/ffmpeg-utils.html#color-syntax">(ffmpeg-utils)"Color" section in the
	 * ffmpeg-utils manual</a>. Default color is
	 * <span style="padding:0 10px;background:black;color:white">black</span>.
	 * 
	 * @apiNote (color) color
	 * @param value the fill color
	 * @return the {@link Remap} instance
	 */
	public Remap fill( Color color ) {
		return super.addArg( "color", color );
	}

	/**
	 * Specify the color of the unmapped pixels. For the syntax of this option, check the
	 * <a href="https://ffmpeg.org/ffmpeg-utils.html#color-syntax">(ffmpeg-utils)"Color" section in the
	 * ffmpeg-utils manual</a>. Default color is
	 * <span style="padding:0 10px;background:black;color:white">black</span>.
	 * 
	 * @apiNote (color) color
	 * @param value the fill color
	 * @return the {@link Remap} instance
	 */
	public Remap fill( String color ) {
		return super.addArg( "fill", color );
	}

	/**
	 * Output format color
	 *
	 * @author tangxbai
	 * @since 2022/07/25
	 */
	public enum ColorFormat implements AbstractEnum {
		COLOR, GRAY
	}

}
