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
import com.viiyue.ffmpeg.filter.AbstractFunction;
import com.viiyue.ffmpeg.util.Assert;

/**
 * Adjust color contrast between RGB components.
 *
 * @author tangxbai
 * @since 2022/06/15
 * @see <a href="https://ffmpeg.org/ffmpeg-filters.html#colorcontrast">ffmpeg-filters#colorcontrast</a>
 */
@Function( "colorcontrast" )
public class ColorContrast extends AbstractFunction<ColorContrast> {

	// Don't let anyone instantiate this class
	private ColorContrast() {}

	/**
	 * Quickly create an instances of {@link ColorContrast}
	 * 
	 * @return the {@link ColorContrast} instance
	 */
	public static final ColorContrast the() {
		return new ColorContrast();
	}

	/**
	 * Set the red-cyan contrast, defaults is <b>0.0</b> and allowed range is from -1.0 to 1.0.
	 * 
	 * @apiNote (double) rc
	 * @param contrast the color contrast
	 * @return the {@link ColorContrast} instance
	 */
	public ColorContrast redCyanContrast( double contrast ) {
		Assert.rangeCheck( contrast, -1.0, 1.0 );
		return super.addArg( "rc", contrast );
	}

	/**
	 * Set the green-magenta contrast, defaults is <b>0.0</b> and allowed range is from -1.0 to 1.0.
	 * 
	 * @apiNote (double) gm
	 * @param contrast the color contrast
	 * @return the {@link ColorContrast} instance
	 */
	public ColorContrast greenMagentaContrast( double contrast ) {
		Assert.rangeCheck( contrast, -1.0, 1.0 );
		return super.addArg( "gm", contrast );
	}

	/**
	 * Set the blue-yellow contrast, defaults is <b>0.0</b> and allowed range is from -1.0 to 1.0.
	 * 
	 * @apiNote (double) by
	 * @param contrast the color contrast
	 * @return the {@link ColorContrast} instance
	 */
	public ColorContrast blueYellowContrast( double contrast ) {
		Assert.rangeCheck( contrast, -1.0, 1.0 );
		return super.addArg( "by", contrast );
	}

	/**
	 * <p>
	 * Set the weight of {@code rc} option value, default value is <b>0.0</b> and allowed range is from 0.0 to
	 * 1.0.
	 * 
	 * <p>
	 * If all weights are 0.0 filtering is disabled.
	 * 
	 * @apiNote (double) rcw
	 * @param weight the weight of {@code rc}
	 * @return the {@link ColorContrast} instance
	 */
	public ColorContrast redCyanWeight( double weight ) {
		Assert.rangeCheck( weight, 0, 1.0 );
		return super.addArg( "rcw", weight );
	}

	/**
	 * <p>
	 * Set the weight of gm option value, default value is <b>0.0</b> and allowed range is from 0.0 to 1.0.
	 * 
	 * <p>
	 * If all weights are 0.0 filtering is disabled.
	 * 
	 * @apiNote (double) gmw
	 * @param weight the weight of {@code gm}
	 * @return the {@link ColorContrast} instance
	 */
	public ColorContrast greenMagentaWeight( double weight ) {
		Assert.rangeCheck( weight, 0, 1.0 );
		return super.addArg( "gmw", weight );
	}

	/**
	 * <p>
	 * Set the weight of {@code by} option value, default value is <b>0.0</b> and allowed range is from 0.0 to
	 * 1.0.
	 * 
	 * <p>
	 * If all weights are 0.0 filtering is disabled.
	 * 
	 * @apiNote (double) byw
	 * @param weight the weight of {@code by}
	 * @return the {@link ColorContrast} instance
	 */
	public ColorContrast blueYellowWeigh( double weight ) {
		Assert.rangeCheck( weight, 0, 1.0 );
		return super.addArg( "byw", weight );
	}

	/**
	 * Set the amount of preserving lightness, default value is <b>0.0</b> and allowed range is from 0.0 to
	 * 1.0.
	 * 
	 * @apiNote (double) pl
	 * @param weight the weight of {@code by}
	 * @return the {@link ColorContrast} instance
	 */
	public ColorContrast lightness( double lightness ) {
		Assert.rangeCheck( lightness, 0, 1.0 );
		return super.addArg( "pl", lightness );
	}

}
