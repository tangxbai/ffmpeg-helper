/**
 * Copyright (C) 2022-2023 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.viiyue.ffmpeg.filter.video;

import com.viiyue.ffmpeg.annotation.Function;
import com.viiyue.ffmpeg.enums.Color;
import com.viiyue.ffmpeg.enums.When;
import com.viiyue.ffmpeg.filter.AbstractFunction;
import com.viiyue.ffmpeg.util.Helper;

/**
 * Add paddings to the input image, and place the original input at the provided x, y coordinates.
 * 
 * @author tangxbai
 * @since 2022/07/19
 * @see <a href="https://ffmpeg.org/ffmpeg-filters.html#pad-1">ffmpeg-filters#pad</a>
 */
@Function( "pad" )
public class Pad extends AbstractFunction<Pad> {

	// Don't let anyone instantiate this class
	private Pad() {}

	/**
	 * Quickly create an instances of {@link Pad}
	 * 
	 * @return the {@link Pad} instance
	 */
	public static final Pad of() {
		return new Pad();
	}

	/**
	 * <p>
	 * Specify an expression for the size of the output image with the paddings added. If the value for width
	 * or height is 0, the corresponding input size is used for the output.
	 * 
	 * <p>
	 * The width expression can reference the value set by the height expression, and vice versa. The default
	 * value of width and height is 0.
	 * 
	 * @apiNote (int) width, w
	 * @apiNote (int) height, h
	 * @param width  the pad area width
	 * @param height the pad area height
	 * @return the {@link Pad} instance
	 */
	public Pad size( int width, int height ) {
		return super.addArg( "w", width ).addArg( "h", height );
	}

	/**
	 * <p>
	 * Specify an expression for the size of the output image with the paddings added. If the value for width
	 * or height is 0, the corresponding input size is used for the output.
	 * 
	 * <p>
	 * The width expression can reference the value set by the height expression, and vice versa. The default
	 * value of width and height is 0.
	 * 
	 * <p>
	 * The value for the width, height, x, and y options are expressions containing the following constants:
	 * 
	 * <ul>
	 * <li><b>in_w, in_h</b> - the input video width and height.
	 * <li><b>iw ih</b> - these are the same as in_w and in_h.
	 * <li><b>out_w out_h</b> - the output width and height (the size of the padded area), as specified by the
	 * width and height expressions.
	 * <li><b>ow oh</b> - these are the same as out_w and out_h.
	 * <li><b>x y</b> - the x and y offsets as specified by the x and y expressions, or NAN if not yet
	 * specified.
	 * <li><b>a</b> - same as iw / ih
	 * <li><b>sar</b> - input sample aspect ratio
	 * <li><b>dar</b> - input display aspect ratio, it is the same as (iw / ih) * sar
	 * <li><b>hsub vsub</b> - the horizontal and vertical chroma subsample values. For example for the pixel
	 * format "yuv422p" hsub is 2 and vsub is 1.
	 * </ul>
	 * 
	 * @apiNote (string) width, w
	 * @apiNote (string) height, h
	 * @param width  the pad area width expression
	 * @param height the pad area height expression
	 * @return the {@link Pad} instance
	 */
	public Pad size( String width, String height ) {
		return super.addArg( "w", Helper.escape( width ) ).addArg( "h", Helper.escape( height ) );
	}

	/**
	 * <p>
	 * Specify the offsets to place the input image at within the padded area, with respect to the top/left
	 * border of the output image.
	 * 
	 * <p>
	 * The x expression can reference the value set by the y expression, and vice versa.
	 * 
	 * <p>
	 * The default value of x and y is 0.
	 * 
	 * <p>
	 * If x or y evaluate to a negative number, they’ll be changed so the input image is centered on the
	 * padded area.
	 * 
	 * @apiNote (int) x
	 * @apiNote (int) y
	 * @param x the x position offset
	 * @param y the y position offset
	 * @return the {@link Pad} instance
	 */
	public Pad position( int x, int y ) {
		return super.addArg( "x", x ).addArg( "y", y );
	}

	/**
	 * <p>
	 * Specify the offsets to place the input image at within the padded area, with respect to the top/left
	 * border of the output image.
	 * 
	 * <p>
	 * The x expression can reference the value set by the y expression, and vice versa. The default value of
	 * x and y is 0.
	 * 
	 * <p>
	 * If x or y evaluate to a negative number, they’ll be changed so the input image is centered on the
	 * padded area.
	 * 
	 * <p>
	 * The value for the width, height, x, and y options are expressions containing the following constants:
	 * 
	 * <ul>
	 * <li><b>in_w, in_h</b> - the input video width and height.
	 * <li><b>iw ih</b> - these are the same as in_w and in_h.
	 * <li><b>out_w out_h</b> - the output width and height (the size of the padded area), as specified by the
	 * width and height expressions.
	 * <li><b>ow oh</b> - these are the same as out_w and out_h.
	 * <li><b>x y</b> - the x and y offsets as specified by the x and y expressions, or NAN if not yet
	 * specified.
	 * <li><b>a</b> - same as iw / ih
	 * <li><b>sar</b> - input sample aspect ratio
	 * <li><b>dar</b> - input display aspect ratio, it is the same as (iw / ih) * sar
	 * <li><b>hsub vsub</b> - the horizontal and vertical chroma subsample values. For example for the pixel
	 * format "yuv422p" hsub is 2 and vsub is 1.
	 * </ul>
	 * 
	 * @apiNote (string) x
	 * @apiNote (string) y
	 * @param x the x position offset expression
	 * @param y the y position offset expression
	 * @return the {@link Pad} instance
	 */
	public Pad position( String x, String y ) {
		return super.addArg( "x", Helper.escape( x ) ).addArg( "y", Helper.escape( y ) );
	}

	/**
	 * <p>
	 * Specify the color of the padded area. For the syntax of this option, check the
	 * <a href="https://ffmpeg.org/ffmpeg-utils.html#color-syntax">(ffmpeg-utils)"Color" section in the
	 * ffmpeg-utils manual</a>.
	 * 
	 * <p>
	 * The default value of color is "black".
	 * 
	 * @apiNote (string) color
	 * @param color the pad area color
	 * @return the {@link Pad} instance
	 */
	public Pad color( String color ) {
		return super.addArg( "color", color );
	}

	/**
	 * <p>
	 * Specify the color of the padded area. For the syntax of this option, check the
	 * <a href="https://ffmpeg.org/ffmpeg-utils.html#color-syntax">(ffmpeg-utils)"Color" section in the
	 * ffmpeg-utils manual</a>.
	 * 
	 * <p>
	 * The default value of color is {@link Color#BLACK}.
	 * 
	 * @apiNote (color) color
	 * @param color the pad area color
	 * @return the {@link Pad} instance
	 */
	public Pad color( Color color ) {
		return super.addArg( "color", color );
	}

	/**
	 * Specify when to evaluate width, height, x and y expression.
	 * 
	 * @apiNote (flags) eval
	 * @param when specify when to evaluate expressions
	 * @return the {@link Pad} instance
	 */
	public Pad eval( When when ) {
		return super.addArg( "eval", when );
	}

	/**
	 * Pad to aspect instead to a resolution
	 * 
	 * @apiNote (rational) aspect
	 * @param how   the horizontal scale
	 * @param toHow the vertical scale
	 * @return the {@link Pad} instance
	 */
	public Pad aspect( int how, int toHow ) {
		return super.addArg( "aspect", how + "/" + toHow );
	}

}
