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

import com.viiyue.ffmpeg.filter.AbstractFunction;

/**
 * Abstract LUT filter class
 * 
 * @author tangxbai
 * @param <T> the subclass
 * @since 2022/07/13
 * @see <a href=
 *      "https://ffmpeg.org/ffmpeg-filters.html#lut_002c-lutrgb_002c-lutyuv">ffmpeg-filters#lut-lutrgb-lutyuv</a>
 */
class AbstractLut<T extends AbstractFunction<T>> extends AbstractLut2<T> {

	/**
	 * <p>
	 * Set first pixel component expression
	 * 
	 * <p>
	 * The expressions can contain the following constants and functions:
	 * 
	 * <ul>
	 * <li><b>w, h</b> - the input width and height.
	 * 
	 * <li><b>val</b> - the input value for the pixel component.
	 * 
	 * <li><b>clipval</b> - the input value, clipped to the minval-maxval range.
	 * 
	 * <li><b>maxval</b> - the maximum value for the pixel component.
	 * 
	 * <li><b>minval</b> - the minimum value for the pixel component.
	 * 
	 * <li><b>negval</b> - the negated value for the pixel component value, clipped to the minval-maxval
	 * range; it corresponds to the expression "maxval-clipval+minval".
	 * 
	 * <li><b>clip(val)</b> - the computed value in val, clipped to the minval-maxval range.
	 * 
	 * <li><b>gammaval(gamma)</b> - the computed gamma correction value of the pixel component value, clipped
	 * to the minval-maxval range. It corresponds to the expression
	 * "pow((clipval-minval)/(maxval-minval)\,gamma)*(maxval-minval)+minval"
	 * </ul>
	 * 
	 * <p>
	 * All expressions default to "clipval".
	 * 
	 * @apiNote (string) c0
	 * @param expression the component expression
	 * @return the {@link AbstractLut} instance
	 */
	public T c0( String expression ) {
		return super.addArg( "c0", expression );
	}

	/**
	 * <p>
	 * Set second pixel component expression
	 * 
	 * <p>
	 * The expressions can contain the following constants and functions:
	 * 
	 * <ul>
	 * <li><b>w, h</b> - the input width and height.
	 * 
	 * <li><b>val</b> - the input value for the pixel component.
	 * 
	 * <li><b>clipval</b> - the input value, clipped to the minval-maxval range.
	 * 
	 * <li><b>maxval</b> - the maximum value for the pixel component.
	 * 
	 * <li><b>minval</b> - the minimum value for the pixel component.
	 * 
	 * <li><b>negval</b> - the negated value for the pixel component value, clipped to the minval-maxval
	 * range; it corresponds to the expression "maxval-clipval+minval".
	 * 
	 * <li><b>clip(val)</b> - the computed value in val, clipped to the minval-maxval range.
	 * 
	 * <li><b>gammaval(gamma)</b> - the computed gamma correction value of the pixel component value, clipped
	 * to the minval-maxval range. It corresponds to the expression
	 * "pow((clipval-minval)/(maxval-minval)\,gamma)*(maxval-minval)+minval"
	 * </ul>
	 * 
	 * <p>
	 * All expressions default to "clipval".
	 * 
	 * @apiNote (string) c1
	 * @param expression the component expression
	 * @return the {@link AbstractLut} instance
	 */
	public T c1( String expression ) {
		return super.addArg( "c1", expression );
	}

	/**
	 * <p>
	 * Set third pixel component expression
	 * 
	 * <p>
	 * The expressions can contain the following constants and functions:
	 * 
	 * <ul>
	 * <li><b>w, h</b> - the input width and height.
	 * 
	 * <li><b>val</b> - the input value for the pixel component.
	 * 
	 * <li><b>clipval</b> - the input value, clipped to the minval-maxval range.
	 * 
	 * <li><b>maxval</b> - the maximum value for the pixel component.
	 * 
	 * <li><b>minval</b> - the minimum value for the pixel component.
	 * 
	 * <li><b>negval</b> - the negated value for the pixel component value, clipped to the minval-maxval
	 * range; it corresponds to the expression "maxval-clipval+minval".
	 * 
	 * <li><b>clip(val)</b> - the computed value in val, clipped to the minval-maxval range.
	 * 
	 * <li><b>gammaval(gamma)</b> - the computed gamma correction value of the pixel component value, clipped
	 * to the minval-maxval range. It corresponds to the expression
	 * "pow((clipval-minval)/(maxval-minval)\,gamma)*(maxval-minval)+minval"
	 * </ul>
	 * 
	 * <p>
	 * All expressions default to "clipval".
	 * 
	 * @apiNote (string) c2
	 * @param expression the component expression
	 * @return the {@link AbstractLut} instance
	 */
	public T c2( String expression ) {
		return super.addArg( "c2", expression );
	}

	/**
	 * <p>
	 * Set fourth pixel component expression, corresponds to the alpha component.
	 * 
	 * <p>
	 * The expressions can contain the following constants and functions:
	 * 
	 * <ul>
	 * <li><b>w, h</b> - the input width and height.
	 * 
	 * <li><b>val</b> - the input value for the pixel component.
	 * 
	 * <li><b>clipval</b> - the input value, clipped to the minval-maxval range.
	 * 
	 * <li><b>maxval</b> - the maximum value for the pixel component.
	 * 
	 * <li><b>minval</b> - the minimum value for the pixel component.
	 * 
	 * <li><b>negval</b> - the negated value for the pixel component value, clipped to the minval-maxval
	 * range; it corresponds to the expression "maxval-clipval+minval".
	 * 
	 * <li><b>clip(val)</b> - the computed value in val, clipped to the minval-maxval range.
	 * 
	 * <li><b>gammaval(gamma)</b> - the computed gamma correction value of the pixel component value, clipped
	 * to the minval-maxval range. It corresponds to the expression
	 * "pow((clipval-minval)/(maxval-minval)\,gamma)*(maxval-minval)+minval"
	 * </ul>
	 * 
	 * <p>
	 * All expressions default to "clipval".
	 * 
	 * @apiNote (string) c3
	 * @param expression the component expression
	 * @return the {@link AbstractLut} instance
	 */
	public T c3( String expression ) {
		return super.addArg( "c3", expression );
	}

	/**
	 * <p>
	 * Set red component expression
	 * 
	 * <p>
	 * The expressions can contain the following constants and functions:
	 * 
	 * <ul>
	 * <li><b>w, h</b> - the input width and height.
	 * 
	 * <li><b>val</b> - the input value for the pixel component.
	 * 
	 * <li><b>clipval</b> - the input value, clipped to the minval-maxval range.
	 * 
	 * <li><b>maxval</b> - the maximum value for the pixel component.
	 * 
	 * <li><b>minval</b> - the minimum value for the pixel component.
	 * 
	 * <li><b>negval</b> - the negated value for the pixel component value, clipped to the minval-maxval
	 * range; it corresponds to the expression "maxval-clipval+minval".
	 * 
	 * <li><b>clip(val)</b> - the computed value in val, clipped to the minval-maxval range.
	 * 
	 * <li><b>gammaval(gamma)</b> - the computed gamma correction value of the pixel component value, clipped
	 * to the minval-maxval range. It corresponds to the expression
	 * "pow((clipval-minval)/(maxval-minval)\,gamma)*(maxval-minval)+minval"
	 * </ul>
	 * 
	 * <p>
	 * All expressions default to "clipval".
	 * 
	 * @apiNote (string) r
	 * @param expression the red component expression
	 * @return the {@link AbstractLut} instance
	 */
	public T red( String expression ) {
		return super.addArg( "r", expression );
	}

	/**
	 * <p>
	 * Set green component expression
	 * 
	 * <p>
	 * The expressions can contain the following constants and functions:
	 * 
	 * <ul>
	 * <li><b>w, h</b> - the input width and height.
	 * 
	 * <li><b>val</b> - the input value for the pixel component.
	 * 
	 * <li><b>clipval</b> - the input value, clipped to the minval-maxval range.
	 * 
	 * <li><b>maxval</b> - the maximum value for the pixel component.
	 * 
	 * <li><b>minval</b> - the minimum value for the pixel component.
	 * 
	 * <li><b>negval</b> - the negated value for the pixel component value, clipped to the minval-maxval
	 * range; it corresponds to the expression "maxval-clipval+minval".
	 * 
	 * <li><b>clip(val)</b> - the computed value in val, clipped to the minval-maxval range.
	 * 
	 * <li><b>gammaval(gamma)</b> - the computed gamma correction value of the pixel component value, clipped
	 * to the minval-maxval range. It corresponds to the expression
	 * "pow((clipval-minval)/(maxval-minval)\,gamma)*(maxval-minval)+minval"
	 * </ul>
	 * 
	 * <p>
	 * All expressions default to "clipval".
	 * 
	 * @apiNote (string) g
	 * @param expression the green component expression
	 * @return the {@link AbstractLut} instance
	 */
	public T green( String expression ) {
		return super.addArg( "g", expression );
	}

	/**
	 * <p>
	 * Set blue component expression
	 * 
	 * <p>
	 * The expressions can contain the following constants and functions:
	 * 
	 * <ul>
	 * <li><b>w, h</b> - the input width and height.
	 * 
	 * <li><b>val</b> - the input value for the pixel component.
	 * 
	 * <li><b>clipval</b> - the input value, clipped to the minval-maxval range.
	 * 
	 * <li><b>maxval</b> - the maximum value for the pixel component.
	 * 
	 * <li><b>minval</b> - the minimum value for the pixel component.
	 * 
	 * <li><b>negval</b> - the negated value for the pixel component value, clipped to the minval-maxval
	 * range; it corresponds to the expression "maxval-clipval+minval".
	 * 
	 * <li><b>clip(val)</b> - the computed value in val, clipped to the minval-maxval range.
	 * 
	 * <li><b>gammaval(gamma)</b> - the computed gamma correction value of the pixel component value, clipped
	 * to the minval-maxval range. It corresponds to the expression
	 * "pow((clipval-minval)/(maxval-minval)\,gamma)*(maxval-minval)+minval"
	 * </ul>
	 * 
	 * <p>
	 * All expressions default to "clipval".
	 * 
	 * @apiNote (string) b
	 * @param expression the blue component expression
	 * @return the {@link AbstractLut} instance
	 */
	public T blue( String expression ) {
		return super.addArg( "b", expression );
	}

	/**
	 * <p>
	 * Set alpha component expression
	 * 
	 * <p>
	 * The expressions can contain the following constants and functions:
	 * 
	 * <ul>
	 * <li><b>w, h</b> - the input width and height.
	 * 
	 * <li><b>val</b> - the input value for the pixel component.
	 * 
	 * <li><b>clipval</b> - the input value, clipped to the minval-maxval range.
	 * 
	 * <li><b>maxval</b> - the maximum value for the pixel component.
	 * 
	 * <li><b>minval</b> - the minimum value for the pixel component.
	 * 
	 * <li><b>negval</b> - the negated value for the pixel component value, clipped to the minval-maxval
	 * range; it corresponds to the expression "maxval-clipval+minval".
	 * 
	 * <li><b>clip(val)</b> - the computed value in val, clipped to the minval-maxval range.
	 * 
	 * <li><b>gammaval(gamma)</b> - the computed gamma correction value of the pixel component value, clipped
	 * to the minval-maxval range. It corresponds to the expression
	 * "pow((clipval-minval)/(maxval-minval)\,gamma)*(maxval-minval)+minval"
	 * </ul>
	 * 
	 * <p>
	 * All expressions default to "clipval".
	 * 
	 * @apiNote (string) a
	 * @param expression the alpha component expression
	 * @return the {@link AbstractLut} instance
	 */
	public T alpha( String expression ) {
		return super.addArg( "a", expression );
	}

	/**
	 * <p>
	 * Set Y/luminance component expression
	 * 
	 * <p>
	 * The expressions can contain the following constants and functions:
	 * 
	 * <ul>
	 * <li><b>w, h</b> - the input width and height.
	 * 
	 * <li><b>val</b> - the input value for the pixel component.
	 * 
	 * <li><b>clipval</b> - the input value, clipped to the minval-maxval range.
	 * 
	 * <li><b>maxval</b> - the maximum value for the pixel component.
	 * 
	 * <li><b>minval</b> - the minimum value for the pixel component.
	 * 
	 * <li><b>negval</b> - the negated value for the pixel component value, clipped to the minval-maxval
	 * range; it corresponds to the expression "maxval-clipval+minval".
	 * 
	 * <li><b>clip(val)</b> - the computed value in val, clipped to the minval-maxval range.
	 * 
	 * <li><b>gammaval(gamma)</b> - the computed gamma correction value of the pixel component value, clipped
	 * to the minval-maxval range. It corresponds to the expression
	 * "pow((clipval-minval)/(maxval-minval)\,gamma)*(maxval-minval)+minval"
	 * </ul>
	 * 
	 * <p>
	 * All expressions default to "clipval".
	 * 
	 * @apiNote (string) y
	 * @param expression the Y/luminance component expression
	 * @return the {@link AbstractLut} instance
	 */
	public T y( String expression ) {
		return super.addArg( "y", expression );
	}

	/**
	 * <p>
	 * Set U/Cb component expression
	 * 
	 * <p>
	 * The expressions can contain the following constants and functions:
	 * 
	 * <ul>
	 * <li><b>w, h</b> - the input width and height.
	 * 
	 * <li><b>val</b> - the input value for the pixel component.
	 * 
	 * <li><b>clipval</b> - the input value, clipped to the minval-maxval range.
	 * 
	 * <li><b>maxval</b> - the maximum value for the pixel component.
	 * 
	 * <li><b>minval</b> - the minimum value for the pixel component.
	 * 
	 * <li><b>negval</b> - the negated value for the pixel component value, clipped to the minval-maxval
	 * range; it corresponds to the expression "maxval-clipval+minval".
	 * 
	 * <li><b>clip(val)</b> - the computed value in val, clipped to the minval-maxval range.
	 * 
	 * <li><b>gammaval(gamma)</b> - the computed gamma correction value of the pixel component value, clipped
	 * to the minval-maxval range. It corresponds to the expression
	 * "pow((clipval-minval)/(maxval-minval)\,gamma)*(maxval-minval)+minval"
	 * </ul>
	 * 
	 * <p>
	 * All expressions default to "clipval".
	 * 
	 * @apiNote (string) u
	 * @param expression the U/Cb component expression
	 * @return the {@link AbstractLut} instance
	 */
	public T u( String expression ) {
		return super.addArg( "u", expression );
	}

	/**
	 * <p>
	 * Set V/Cr component expression
	 * 
	 * <p>
	 * The expressions can contain the following constants and functions:
	 * 
	 * <ul>
	 * <li><b>w, h</b> - the input width and height.
	 * 
	 * <li><b>val</b> - the input value for the pixel component.
	 * 
	 * <li><b>clipval</b> - the input value, clipped to the minval-maxval range.
	 * 
	 * <li><b>maxval</b> - the maximum value for the pixel component.
	 * 
	 * <li><b>minval</b> - the minimum value for the pixel component.
	 * 
	 * <li><b>negval</b> - the negated value for the pixel component value, clipped to the minval-maxval
	 * range; it corresponds to the expression "maxval-clipval+minval".
	 * 
	 * <li><b>clip(val)</b> - the computed value in val, clipped to the minval-maxval range.
	 * 
	 * <li><b>gammaval(gamma)</b> - the computed gamma correction value of the pixel component value, clipped
	 * to the minval-maxval range. It corresponds to the expression
	 * "pow((clipval-minval)/(maxval-minval)\,gamma)*(maxval-minval)+minval"
	 * </ul>
	 * 
	 * <p>
	 * All expressions default to "clipval".
	 * 
	 * @apiNote (string) v
	 * @param expression the V/Cr component expression
	 * @return the {@link AbstractLut} instance
	 */
	public T v( String expression ) {
		return super.addArg( "v", expression );
	}

}
