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
import com.viiyue.ffmpeg.filter.AbstractFunction;
import com.viiyue.ffmpeg.util.Helper;

/**
 * Rotate video by an arbitrary angle expressed in radians.
 * 
 * @author tangxbai
 * @since 2022/08/01
 * @see <a href="https://ffmpeg.org/ffmpeg-filters.html#rotate">ffmpeg-filters#rotate</a>
 */
@Function( "rotate" )
public class Rotate extends AbstractFunction<Rotate> {

	// Don't let anyone instantiate this class
	private Rotate() {}

	/**
	 * Sets the angle by which the input video is rotated clockwise, in radians. Negative values will cause
	 * counterclockwise rotation. By default, it is set to 0.
	 * 
	 * @apiNote (double) angle, a
	 * @param angle the rotate angle
	 * @return {@link Rotate} instance
	 */
	public static final Rotate the( double angle ) {
		return new Rotate().addArg( "a", angle );
	}

	/**
	 * <p>
	 * Set an expression for the angle by which to rotate the input video clockwise, expressed as a number of
	 * radians. A negative value will result in a counter-clockwise rotation. By default it is set to "0".
	 * 
	 * <p>
	 * This expression is evaluated for each frame.
	 * 
	 * <p>
	 * The expressions for the angle and the output size can contain the following constants and functions:
	 * 
	 * <ul>
	 * <li><b>n</b> - sequential number of the input frame, starting from 0. It is always NAN before the first
	 * frame is filtered.
	 * <li><b>t</b> - time in seconds of the input frame, it is set to 0 when the filter is configured. It is
	 * always NAN before the first frame is filtered.
	 * <li><b>hsub, vsub</b> - horizontal and vertical chroma subsample values. For example for the pixel
	 * format "yuv422p" hsub is 2 and vsub is 1.
	 * <li><b>in_w, iw</b><br>
	 * <b>in_h, ih</b> - the input video width and height
	 * <li><b><b>out_w, ow</b><br>
	 * <b>out_h, oh</b> - the output width and height, that is the size of the padded area as specified by the
	 * width and height expressions
	 * <ul>
	 * 
	 * @apiNote (color) fillcolor
	 * @param angle the rotate angle
	 * @return {@link Rotate} instance
	 */
	public static final Rotate the( String angle ) {
		return new Rotate().addArg( "a", Helper.escape( angle, true ) );
	}

	/**
	 * Set the output width/height size
	 * 
	 * @param with   the output with size
	 * @param height the output height size
	 * @return the {@link Rotate} instance
	 */
	public Rotate size( int with, int height ) {
		return super.addArg( "ow", with ).addArg( "oh", height );
	}

	/**
	 * <p>
	 * Set the output width/height expression, default value is "iw"/"ih". This expression is evaluated just
	 * once during configuration.
	 * 
	 * <p>
	 * The expressions for the angle and the output size can contain the following constants and functions:
	 * 
	 * <ul>
	 * <li><b>n</b> - sequential number of the input frame, starting from 0. It is always NAN before the first
	 * frame is filtered.
	 * 
	 * <li><b>t</b> - time in seconds of the input frame, it is set to 0 when the filter is configured. It is
	 * always NAN before the first frame is filtered.
	 * 
	 * <li><b>hsub, vsub</b> - horizontal and vertical chroma subsample values. For example for the pixel
	 * format "yuv422p" hsub is 2 and vsub is 1.
	 * 
	 * <li><b>in_w, iw</b><br>
	 * <b>in_h, ih</b> - the input video width and height
	 * 
	 * <li><b><b>out_w, ow</b><br>
	 * <b>out_h, oh</b> - the output width and height, that is the size of the padded area as specified by the
	 * width and height expressions
	 * 
	 * <li><b>rotw(a) roth(a)</b> - the minimal width/height required for completely containing the input
	 * video rotated by a radians.
	 * <ul>
	 * 
	 * @param with   the output with expression
	 * @param height the output height expression
	 * @return the {@link Rotate} instance
	 */
	public Rotate size( String with, String height ) {
		return super.addArg( "ow", Helper.escape( with, true ) ).addArg( "oh", Helper.escape( height, true ) );
	}

	/**
	 * <p>
	 * Set the color used to fill the output area not covered by the rotated image. For the general syntax of
	 * this option, check the
	 * <a href="https://ffmpeg.org/ffmpeg-utils.html#color-syntax">(ffmpeg-utils)"Color" section in the
	 * ffmpeg-utils manual</a>. If the special value "none" is selected then no background is printed (useful
	 * for example if the background is never shown).
	 * 
	 * <p>
	 * Default value is "black".
	 * 
	 * @apiNote (color) fillcolor
	 * @param color the fill color
	 * @return {@link Rotate} instance
	 */
	public Rotate fillColor( Color color ) {
		return fillColor( Color.nullable( color ).command() );
	}

	/**
	 * <p>
	 * Set the color used to fill the output area not covered by the rotated image. For the general syntax of
	 * this option, check the
	 * <a href="https://ffmpeg.org/ffmpeg-utils.html#color-syntax">(ffmpeg-utils)"Color" section in the
	 * ffmpeg-utils manual</a>. If the special value "none" is selected then no background is printed (useful
	 * for example if the background is never shown).
	 * 
	 * <p>
	 * Default value is "black".
	 * 
	 * @apiNote (color) fillcolor
	 * @param color the fill color
	 * @return the {@link Rotate} instance
	 */
	public Rotate fillColor( String color ) {
		return super.addArg( "c", color );
	}

	/**
	 * Enable bilinear interpolation if set to {@code true}, a value of {@code false} disables it. Default
	 * value is {@code true}.
	 * 
	 * @apiNote (boolean) bilinear
	 * @param frame the frame index
	 * @return the {@link Rotate} instance
	 */
	public Rotate nonBilinear() {
		return super.status( "bilinear", false );
	}

}
