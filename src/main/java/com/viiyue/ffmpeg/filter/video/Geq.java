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
import com.viiyue.ffmpeg.enums.Interpolation;
import com.viiyue.ffmpeg.filter.AbstractFunction;
import com.viiyue.ffmpeg.util.Helper;

/**
 * <p>
 * Apply generic equation to each pixel
 * 
 * <p>
 * For functions, if x and y are outside the area, the value will be automatically clipped to the closer edge.
 * 
 * <p>
 * Please note that this filter can use multiple threads in which case each slice will have its own expression
 * state. If you want to use only a single expression state because your expressions depend on previous state
 * then you should limit the number of filter threads to 1.
 *
 * @author tangxbai
 * @since 2022/07/07
 * @see <a href="https://ffmpeg.org/ffmpeg-filters.html#geq">ffmpeg-filters#geq</a>
 */
@Function( "geq" )
public class Geq extends AbstractFunction<Geq> {

	// Don't let anyone instantiate this class
	private Geq() {}

	/**
	 * Quickly create an instances of {@link Geq}
	 * 
	 * @return the {@link Geq} instance
	 */
	public static final Geq of() {
		return new Geq();
	}

	/**
	 * <p>
	 * Set the luminance expression
	 * 
	 * <p>
	 * The expressions can use the following variables and functions:
	 * <ul>
	 * <li><b>N</b> - the sequential number of the filtered frame, starting from 0.
	 * <li><b>x, y</b> - the coordinates of the current sample
	 * <li><b>W, H</b> - the width and height of the image
	 * <li><b>SW, SH</b> - Width and height scale depending on the currently filtered plane. It is the ratio
	 * between the corresponding luma plane number of pixels and the current plane ones. E.g. for YUV4:2:0 the
	 * values are 1,1 for the luma plane, and 0.5,0.5 for chroma planes.
	 * <li><b>T</b> - time of the current frame, expressed in seconds
	 * <li><b>p(x, y)</b> - return the value of the pixel at location (x,y) of the current plane
	 * <li><b>lum(x, y)</b> - return the value of the pixel at location (x,y) of the luminance plane
	 * <li><b>cb(x, y)</b> - return the value of the pixel at location (x,y) of the blue-difference chroma
	 * plane, return 0 if there is no such plane.
	 * <li><b>cr(x, y)</b> - return the value of the pixel at location (x,y) of the red-difference chroma
	 * plane, return 0 if there is no such plane.
	 * <li><b>r(x, y), g(x, y), b(x, y)</b> - return the value of the pixel at location (x,y) of the
	 * red/green/blue component, return 0 if there is no such component.
	 * <li><b>alpha(x, y)</b> - return the value of the pixel at location (x,y) of the alpha plane. Return 0
	 * if there is no such plane.
	 * <li><b>psum(x,y), lumsum(x, y), cbsum(x,y), crsum(x,y), rsum(x,y), gsum(x,y), bsum(x,y),
	 * alphasum(x,y)</b> - sum of sample values in the rectangle from (0,0) to (x,y), this allows obtaining
	 * sums of samples within a rectangle. See the functions without the sum postfix.
	 * </ul>
	 * 
	 * @apiNote (string) lum_expr, lum
	 * @param expression the luminance expression
	 * @return the {@link Geq} instance
	 */
	public Geq lumExpression( String expression ) {
		return super.addArg( "lum", Helper.escape( expression, true ) ); // lum_expr, lum
	}

	/**
	 * Set the chrominance blue expression
	 * 
	 * <p>
	 * The expressions can use the following variables and functions:
	 * <ul>
	 * <li><b>N</b> - the sequential number of the filtered frame, starting from 0.
	 * <li><b>x, y</b> - the coordinates of the current sample
	 * <li><b>W, H</b> - the width and height of the image
	 * <li><b>SW, SH</b> - Width and height scale depending on the currently filtered plane. It is the ratio
	 * between the corresponding luma plane number of pixels and the current plane ones. E.g. for YUV4:2:0 the
	 * values are 1,1 for the luma plane, and 0.5,0.5 for chroma planes.
	 * <li><b>T</b> - time of the current frame, expressed in seconds
	 * <li><b>p(x, y)</b> - return the value of the pixel at location (x,y) of the current plane
	 * <li><b>lum(x, y)</b> - return the value of the pixel at location (x,y) of the luminance plane
	 * <li><b>cb(x, y)</b> - return the value of the pixel at location (x,y) of the blue-difference chroma
	 * plane, return 0 if there is no such plane.
	 * <li><b>cr(x, y)</b> - return the value of the pixel at location (x,y) of the red-difference chroma
	 * plane, return 0 if there is no such plane.
	 * <li><b>r(x, y), g(x, y), b(x, y)</b> - return the value of the pixel at location (x,y) of the
	 * red/green/blue component, return 0 if there is no such component.
	 * <li><b>alpha(x, y)</b> - return the value of the pixel at location (x,y) of the alpha plane. Return 0
	 * if there is no such plane.
	 * <li><b>psum(x,y), lumsum(x, y), cbsum(x,y), crsum(x,y), rsum(x,y), gsum(x,y), bsum(x,y),
	 * alphasum(x,y)</b> - sum of sample values in the rectangle from (0,0) to (x,y), this allows obtaining
	 * sums of samples within a rectangle. See the functions without the sum postfix.
	 * </ul>
	 * 
	 * @apiNote (string) cb_expr, cb
	 * @param expression the chrominance blue expression
	 * @return the {@link Geq} instance
	 */
	public Geq chromBlueExpression( String expression ) {
		return super.addArg( "cb", Helper.escape( expression, true ) ); // cb_expr, cb
	}

	/**
	 * Set the chrominance red expression
	 * 
	 * <p>
	 * The expressions can use the following variables and functions:
	 * <ul>
	 * <li><b>N</b> - the sequential number of the filtered frame, starting from 0.
	 * <li><b>x, y</b> - the coordinates of the current sample
	 * <li><b>W, H</b> - the width and height of the image
	 * <li><b>SW, SH</b> - Width and height scale depending on the currently filtered plane. It is the ratio
	 * between the corresponding luma plane number of pixels and the current plane ones. E.g. for YUV4:2:0 the
	 * values are 1,1 for the luma plane, and 0.5,0.5 for chroma planes.
	 * <li><b>T</b> - time of the current frame, expressed in seconds
	 * <li><b>p(x, y)</b> - return the value of the pixel at location (x,y) of the current plane
	 * <li><b>lum(x, y)</b> - return the value of the pixel at location (x,y) of the luminance plane
	 * <li><b>cb(x, y)</b> - return the value of the pixel at location (x,y) of the blue-difference chroma
	 * plane, return 0 if there is no such plane.
	 * <li><b>cr(x, y)</b> - return the value of the pixel at location (x,y) of the red-difference chroma
	 * plane, return 0 if there is no such plane.
	 * <li><b>r(x, y), g(x, y), b(x, y)</b> - return the value of the pixel at location (x,y) of the
	 * red/green/blue component, return 0 if there is no such component.
	 * <li><b>alpha(x, y)</b> - return the value of the pixel at location (x,y) of the alpha plane. Return 0
	 * if there is no such plane.
	 * <li><b>psum(x,y), lumsum(x, y), cbsum(x,y), crsum(x,y), rsum(x,y), gsum(x,y), bsum(x,y),
	 * alphasum(x,y)</b> - sum of sample values in the rectangle from (0,0) to (x,y), this allows obtaining
	 * sums of samples within a rectangle. See the functions without the sum postfix.
	 * </ul>
	 * 
	 * @apiNote (string) cr_expr, cr
	 * @param expression the chrominance red expression
	 * @return the {@link Geq} instance
	 */
	public Geq chromRedExpression( String expression ) {
		return super.addArg( "cb", Helper.escape( expression, true ) ); // cr_expr, cr
	}

	/**
	 * Set the alpha expression
	 * 
	 * <p>
	 * The expressions can use the following variables and functions:
	 * <ul>
	 * <li><b>N</b> - the sequential number of the filtered frame, starting from 0.
	 * <li><b>x, y</b> - the coordinates of the current sample
	 * <li><b>W, H</b> - the width and height of the image
	 * <li><b>SW, SH</b> - Width and height scale depending on the currently filtered plane. It is the ratio
	 * between the corresponding luma plane number of pixels and the current plane ones. E.g. for YUV4:2:0 the
	 * values are 1,1 for the luma plane, and 0.5,0.5 for chroma planes.
	 * <li><b>T</b> - time of the current frame, expressed in seconds
	 * <li><b>p(x, y)</b> - return the value of the pixel at location (x,y) of the current plane
	 * <li><b>lum(x, y)</b> - return the value of the pixel at location (x,y) of the luminance plane
	 * <li><b>cb(x, y)</b> - return the value of the pixel at location (x,y) of the blue-difference chroma
	 * plane, return 0 if there is no such plane.
	 * <li><b>cr(x, y)</b> - return the value of the pixel at location (x,y) of the red-difference chroma
	 * plane, return 0 if there is no such plane.
	 * <li><b>r(x, y), g(x, y), b(x, y)</b> - return the value of the pixel at location (x,y) of the
	 * red/green/blue component, return 0 if there is no such component.
	 * <li><b>alpha(x, y)</b> - return the value of the pixel at location (x,y) of the alpha plane. Return 0
	 * if there is no such plane.
	 * <li><b>psum(x,y), lumsum(x, y), cbsum(x,y), crsum(x,y), rsum(x,y), gsum(x,y), bsum(x,y),
	 * alphasum(x,y)</b> - sum of sample values in the rectangle from (0,0) to (x,y), this allows obtaining
	 * sums of samples within a rectangle. See the functions without the sum postfix.
	 * </ul>
	 * 
	 * @apiNote (string) alpha_expr, a
	 * @param expression the alpha expression
	 * @return the {@link Geq} instance
	 */
	public Geq alphaExpression( String expression ) {
		return super.addArg( "a", Helper.escape( expression, true ) ); // alpha_expr, a
	}

	/**
	 * Set the red expression
	 * 
	 * <p>
	 * The expressions can use the following variables and functions:
	 * <ul>
	 * <li><b>N</b> - the sequential number of the filtered frame, starting from 0.
	 * <li><b>x, y</b> - the coordinates of the current sample
	 * <li><b>W, H</b> - the width and height of the image
	 * <li><b>SW, SH</b> - Width and height scale depending on the currently filtered plane. It is the ratio
	 * between the corresponding luma plane number of pixels and the current plane ones. E.g. for YUV4:2:0 the
	 * values are 1,1 for the luma plane, and 0.5,0.5 for chroma planes.
	 * <li><b>T</b> - time of the current frame, expressed in seconds
	 * <li><b>p(x, y)</b> - return the value of the pixel at location (x,y) of the current plane
	 * <li><b>lum(x, y)</b> - return the value of the pixel at location (x,y) of the luminance plane
	 * <li><b>cb(x, y)</b> - return the value of the pixel at location (x,y) of the blue-difference chroma
	 * plane, return 0 if there is no such plane.
	 * <li><b>cr(x, y)</b> - return the value of the pixel at location (x,y) of the red-difference chroma
	 * plane, return 0 if there is no such plane.
	 * <li><b>r(x, y), g(x, y), b(x, y)</b> - return the value of the pixel at location (x,y) of the
	 * red/green/blue component, return 0 if there is no such component.
	 * <li><b>alpha(x, y)</b> - return the value of the pixel at location (x,y) of the alpha plane. Return 0
	 * if there is no such plane.
	 * <li><b>psum(x,y), lumsum(x, y), cbsum(x,y), crsum(x,y), rsum(x,y), gsum(x,y), bsum(x,y),
	 * alphasum(x,y)</b> - sum of sample values in the rectangle from (0,0) to (x,y), this allows obtaining
	 * sums of samples within a rectangle. See the functions without the sum postfix.
	 * </ul>
	 * 
	 * @apiNote (string) red_expr, r
	 * @param expression the red expression
	 * @return the {@link Geq} instance
	 */
	public Geq redExpression( String expression ) {
		return super.addArg( "r", Helper.escape( expression, true ) ); // red_expr, r
	}

	/**
	 * Set the green expression
	 * 
	 * <p>
	 * The expressions can use the following variables and functions:
	 * <ul>
	 * <li><b>N</b> - the sequential number of the filtered frame, starting from 0.
	 * <li><b>x, y</b> - the coordinates of the current sample
	 * <li><b>W, H</b> - the width and height of the image
	 * <li><b>SW, SH</b> - Width and height scale depending on the currently filtered plane. It is the ratio
	 * between the corresponding luma plane number of pixels and the current plane ones. E.g. for YUV4:2:0 the
	 * values are 1,1 for the luma plane, and 0.5,0.5 for chroma planes.
	 * <li><b>T</b> - time of the current frame, expressed in seconds
	 * <li><b>p(x, y)</b> - return the value of the pixel at location (x,y) of the current plane
	 * <li><b>lum(x, y)</b> - return the value of the pixel at location (x,y) of the luminance plane
	 * <li><b>cb(x, y)</b> - return the value of the pixel at location (x,y) of the blue-difference chroma
	 * plane, return 0 if there is no such plane.
	 * <li><b>cr(x, y)</b> - return the value of the pixel at location (x,y) of the red-difference chroma
	 * plane, return 0 if there is no such plane.
	 * <li><b>r(x, y), g(x, y), b(x, y)</b> - return the value of the pixel at location (x,y) of the
	 * red/green/blue component, return 0 if there is no such component.
	 * <li><b>alpha(x, y)</b> - return the value of the pixel at location (x,y) of the alpha plane. Return 0
	 * if there is no such plane.
	 * <li><b>psum(x,y), lumsum(x, y), cbsum(x,y), crsum(x,y), rsum(x,y), gsum(x,y), bsum(x,y),
	 * alphasum(x,y)</b> - sum of sample values in the rectangle from (0,0) to (x,y), this allows obtaining
	 * sums of samples within a rectangle. See the functions without the sum postfix.
	 * </ul>
	 * 
	 * @apiNote (string) green_expr, g
	 * @param expression the green expression
	 * @return the {@link Geq} instance
	 */
	public Geq greenExpression( String expression ) {
		return super.addArg( "g", Helper.escape( expression, true ) ); // green_expr, g
	}

	/**
	 * Set the blue expression
	 * 
	 * <p>
	 * The expressions can use the following variables and functions:
	 * <ul>
	 * <li><b>N</b> - the sequential number of the filtered frame, starting from 0.
	 * <li><b>x, y</b> - the coordinates of the current sample
	 * <li><b>W, H</b> - the width and height of the image
	 * <li><b>SW, SH</b> - Width and height scale depending on the currently filtered plane. It is the ratio
	 * between the corresponding luma plane number of pixels and the current plane ones. E.g. for YUV4:2:0 the
	 * values are 1,1 for the luma plane, and 0.5,0.5 for chroma planes.
	 * <li><b>T</b> - time of the current frame, expressed in seconds
	 * <li><b>p(x, y)</b> - return the value of the pixel at location (x,y) of the current plane
	 * <li><b>lum(x, y)</b> - return the value of the pixel at location (x,y) of the luminance plane
	 * <li><b>cb(x, y)</b> - return the value of the pixel at location (x,y) of the blue-difference chroma
	 * plane, return 0 if there is no such plane.
	 * <li><b>cr(x, y)</b> - return the value of the pixel at location (x,y) of the red-difference chroma
	 * plane, return 0 if there is no such plane.
	 * <li><b>r(x, y), g(x, y), b(x, y)</b> - return the value of the pixel at location (x,y) of the
	 * red/green/blue component, return 0 if there is no such component.
	 * <li><b>alpha(x, y)</b> - return the value of the pixel at location (x,y) of the alpha plane. Return 0
	 * if there is no such plane.
	 * <li><b>psum(x,y), lumsum(x, y), cbsum(x,y), crsum(x,y), rsum(x,y), gsum(x,y), bsum(x,y),
	 * alphasum(x,y)</b> - sum of sample values in the rectangle from (0,0) to (x,y), this allows obtaining
	 * sums of samples within a rectangle. See the functions without the sum postfix.
	 * </ul>
	 * 
	 * @apiNote (string) blue_expr, b
	 * @param expression the blue expression
	 * @return the {@link Geq} instance
	 */
	public Geq blueExpression( String expression ) {
		return super.addArg( "b", Helper.escape( expression, true ) ); // blue_expr, b
	}

	/**
	 * Set one of interpolation methods
	 * 
	 * @apiNote (flags) interpolation, i
	 * @param method the interpolation method
	 * @return the {@link Geq} instance
	 */
	public Geq interpolation( Interpolation type ) {
		return super.addArg( "i", type ); // interpolation, i
	}

}
