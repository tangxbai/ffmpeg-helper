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
import com.viiyue.ffmpeg.enums.Interpolation;
import com.viiyue.ffmpeg.filter.AbstractFunction;
import com.viiyue.ffmpeg.util.Assert;

/**
 * <p>
 * Correct radial lens distortion
 * 
 * <p>
 * This filter can be used to correct for radial distortion as can result from the use of wide angle lenses,
 * and thereby re-rectify the image. To find the right parameters one can use tools available for example as
 * part of opencv or simply trial-and-error. To use opencv use the calibration sample (under samples/cpp) from
 * the opencv sources and extract the k1 and k2 coefficients from the resulting matrix.
 * 
 * <p>
 * Note that effectively the same filter is available in the open-source tools Krita and Digikam from the KDE
 * project.
 * 
 * <p>
 * In contrast to the vignette filter, which can also be used to compensate lens errors, this filter corrects
 * the distortion of the image, whereas vignette corrects the brightness distribution, so you may want to use
 * both filters together in certain cases, though you will have to take care of ordering, i.e. whether
 * vignetting should be applied before or after lens correction.
 * 
 * @author tangxbai
 * @since 2022/07/12
 * @see <a href="https://ffmpeg.org/ffmpeg-filters.html#lenscorrection">ffmpeg-filters#lenscorrection</a>
 */
@Function( "lenscorrection" )
public class LensCorrection extends AbstractFunction<LensCorrection> {

	// Don't let anyone instantiate this class
	private LensCorrection() {}

	/**
	 * Quickly create an instances of {@link LensCorrection}
	 * 
	 * @return the {@link LensCorrection} instance
	 */
	public static final LensCorrection of() {
		return new LensCorrection();
	}

	/**
	 * Relative coordinates of the focal point of the image, and thereby the center of the distortion. This
	 * value has a range [0,1] and is expressed as fractions of the image width, default is <b>0.5</b>.
	 * 
	 * @apiNote (double) x/y
	 * @param x the relative center x coordinate
	 * @param y the relative center x coordinate
	 * @return the {@link LensCorrection} instance
	 */
	public LensCorrection center( double x, double y ) {
		Assert.rangeCheck( x, 0.0, 1.0 );
		Assert.rangeCheck( y, 0.0, 1.0 );
		return super.addArg( "cx", x ).addArg( "cy", y );
	}

	/**
	 * Coefficient of the quadratic correction term. This value has a range [-1,1]. 0 means no correction,
	 * default is <b>0</b>.
	 * 
	 * @apiNote (double) k1
	 * @param value the quadratic distortion factor
	 * @return the {@link LensCorrection} instance
	 */
	public LensCorrection factor1( double value ) {
		Assert.rangeCheck( value, -1.0, 1.0 );
		return super.addArg( "k1", value );
	}

	/**
	 * Coefficient of the double quadratic correction term. This value has a range [-1,1]. 0 means no
	 * correction, default is <b>0</b>.
	 * 
	 * @apiNote (double) k2
	 * @param value the double quadratic distortion factor
	 * @return the {@link LensCorrection} instance
	 */
	public LensCorrection factor2( double value ) {
		Assert.rangeCheck( value, 0.0, 1.0 );
		return super.addArg( "k2", value );
	}

	/**
	 * Set interpolation type, default is {@link Interpolation#NEAREST}.
	 * 
	 * @apiNote (flags) i
	 * @param type the interpolation type
	 * @return the {@link LensCorrection} instance
	 */
	public LensCorrection interp( Interpolation type ) {
		return super.addArg( "i", type );
	}

	/**
	 * Specify the color of the unmapped pixels. For the syntax of this option, check the
	 * <a href="https://ffmpeg.org/ffmpeg-utils.html#color-syntax">(ffmpeg-utils)"Color" section in the
	 * ffmpeg-utils manual</a>. Default color is <b>black@0</b>.
	 * 
	 * @apiNote (string) fc
	 * @param color the color of the unmapped pixels
	 * @return the {@link LensCorrection} instance
	 */
	public LensCorrection color( String color ) {
		return super.addArg( "fc", color );
	}

	/**
	 * Specify the color of the unmapped pixels. For the syntax of this option, check the
	 * <a href="https://ffmpeg.org/ffmpeg-utils.html#color-syntax">(ffmpeg-utils)"Color" section in the
	 * ffmpeg-utils manual</a>. Default color is <b>black@0</b>.
	 * 
	 * @apiNote (color) fc
	 * @param color the color of the unmapped pixels
	 * @return the {@link LensCorrection} instance
	 */
	public LensCorrection color( Color color ) {
		return super.addArg( "fc", color );
	}

}
