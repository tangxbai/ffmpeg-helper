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
import com.viiyue.ffmpeg.enums.ColorMode;
import com.viiyue.ffmpeg.filter.AbstractFunction;
import com.viiyue.ffmpeg.util.Assert;

/**
 * Adjust video input frames using levels
 * 
 * @author tangxbai
 * @since 2022/06/16
 * @see <a href="https://ffmpeg.org/ffmpeg-filters.html#colorlevels">ffmpeg-filters#colorlevels</a>
 */
@Function( "colorlevels" )
public class ColorLevels extends AbstractFunction<ColorLevels> {

	// Don't let anyone instantiate this class
	private ColorLevels() {}

	/**
	 * Quickly create an instances of {@link ColorCorrect}
	 * 
	 * @return the {@link ColorLevels} instance
	 */
	public static final ColorLevels of() {
		return new ColorLevels();
	}

	/**
	 * Adjust red input black point, allowed ranges for options are [-1.0, 1.0], defaults are 0.
	 * 
	 * @apiNote (double) rimi
	 * @param value the red input minimum value
	 * @return the {@link ColorLevels} instance
	 */
	public ColorLevels redInputMin( double value ) {
		Assert.rangeCheck( value, -1.0, 1.0 );
		return super.addArg( "rimin", value );
	}

	/**
	 * Adjust green input black point, allowed ranges for options are [-1.0, 1.0], defaults are 0.
	 * 
	 * @apiNote (double) gimin
	 * @param value the green input minimum value
	 * @return the {@link ColorLevels} instance
	 */
	public ColorLevels greenInputMin( double value ) {
		Assert.rangeCheck( value, -1.0, 1.0 );
		return super.addArg( "gimin", value );
	}

	/**
	 * Adjust blue input black point, allowed ranges for options are [-1.0, 1.0], defaults are 0.
	 * 
	 * @apiNote (double) bimin
	 * @param value the blue input minimum value
	 * @return the {@link ColorLevels} instance
	 */
	public ColorLevels blueInputMin( double value ) {
		Assert.rangeCheck( value, -1.0, 1.0 );
		return super.addArg( "bimin", value );
	}

	/**
	 * Adjust alpha input black point, allowed ranges for options are [-1.0, 1.0], defaults are 0.
	 * 
	 * @apiNote (double) aimin
	 * @param value the alpha input minimum value
	 * @return the {@link ColorLevels} instance
	 */
	public ColorLevels alphaInputMin( double value ) {
		Assert.rangeCheck( value, -1.0, 1.0 );
		return super.addArg( "aimin", value );
	}

	/**
	 * Adjust red input white point, allowed ranges for options are [-1.0, 1.0], defaults are 0.
	 * 
	 * @apiNote (double) rimax
	 * @param value the red input minimum value
	 * @return the {@link ColorLevels} instance
	 */
	public ColorLevels redInputMax( double value ) {
		Assert.rangeCheck( value, -1.0, 1.0 );
		return super.addArg( "rimax", value );
	}

	/**
	 * Adjust green input white point, allowed ranges for options are [-1.0, 1.0], defaults are 0.
	 * 
	 * @apiNote (double) gimax
	 * @param max the green input maximum value
	 * @return the {@link ColorLevels} instance
	 */
	public ColorLevels greenInputMax( double min ) {
		Assert.rangeCheck( min, -1.0, 1.0 );
		return super.addArg( "gimax", min );
	}

	/**
	 * Adjust blue input white point, allowed ranges for options are [-1.0, 1.0], defaults are 0.
	 * 
	 * @apiNote (double) bimax
	 * @param value the blue input maximum value
	 * @return the {@link ColorLevels} instance
	 */
	public ColorLevels blueInputMax( double value ) {
		Assert.rangeCheck( value, -1.0, 1.0 );
		return super.addArg( "bimax", value );
	}

	/**
	 * Adjust alpha input white point, allowed ranges for options are [-1.0, 1.0], defaults are 0.
	 * 
	 * @apiNote (double) aimax
	 * @param value the alpha input maximum value
	 * @return the {@link ColorLevels} instance
	 */
	public ColorLevels alphaInputMax( double value ) {
		Assert.rangeCheck( value, -1.0, 1.0 );
		return super.addArg( "aimax", value );
	}

	/**
	 * Adjust red output black point, allowed ranges for options are [0, 1.0], defaults are 0.
	 * 
	 * @apiNote (double) romin
	 * @param value the red output maximum value
	 * @return the {@link ColorLevels} instance
	 */
	public ColorLevels redOutputMin( double value ) {
		Assert.rangeCheck( value, 0, 1.0 );
		super.addArg( "romin", value );
		return this;
	}

	/**
	 * Adjust green output black point, allowed ranges for options are [0, 1.0], defaults are 0.
	 * 
	 * @apiNote (double) gomin
	 * @param value the green output maximum value
	 * @return the {@link ColorLevels} instance
	 */
	public ColorLevels greenOutputMin( double value ) {
		Assert.rangeCheck( value, 0, 1.0 );
		return super.addArg( "gomin", value );
	}

	/**
	 * Adjust blue output black point, allowed ranges for options are [0, 1.0], defaults are 0.
	 * 
	 * @apiNote (double) homin
	 * @param value the blue output maximum value
	 * @return the {@link ColorLevels} instance
	 */
	public ColorLevels blueOutputMin( double value ) {
		Assert.rangeCheck( value, 0, 1.0 );
		return super.addArg( "bomin", value );
	}

	/**
	 * Adjust alpha output black point, allowed ranges for options are [0, 1.0], defaults are 0.
	 * 
	 * @apiNote (double) aomin
	 * @param value the alpha output maximum value
	 * @return the {@link ColorLevels} instance
	 */
	public ColorLevels alphaOutputMin( double value ) {
		Assert.rangeCheck( value, 0, 1.0 );
		return super.addArg( "aomin", value );
	}

	/**
	 * Adjust red output white point, allowed ranges for options are [0, 1.0], defaults are 0.
	 * 
	 * @apiNote (double) romax
	 * @param value the red output maximum value
	 * @return the {@link ColorLevels} instance
	 */
	public ColorLevels redOutputMax( double value ) {
		Assert.rangeCheck( value, 0, 1.0 );
		return super.addArg( "romax", value );
	}

	/**
	 * Adjust green output white point, allowed ranges for options are [0, 1.0], defaults are 0.
	 * 
	 * @apiNote (double) gomax
	 * @param value the green output maximum value
	 * @return the {@link ColorLevels} instance
	 */
	public ColorLevels greenOutputMax( double value ) {
		Assert.rangeCheck( value, 0, 1.0 );
		return super.addArg( "gomax", value );
	}

	/**
	 * Adjust blue output white point, allowed ranges for options are [0, 1.0], defaults are 0.
	 * 
	 * @apiNote (double) homax
	 * @param value the blue output maximum value
	 * @return the {@link ColorLevels} instance
	 */
	public ColorLevels blueOutputMax( double value ) {
		Assert.rangeCheck( value, 0, 1.0 );
		return super.addArg( "bomax", value );
	}

	/**
	 * Adjust alpha output white point, allowed ranges for options are [0, 1.0], defaults are 0.
	 * 
	 * @apiNote (double) aomax
	 * @param value the alpha output maximum value
	 * @return the {@link ColorLevels} instance
	 */
	public ColorLevels alphaOutputMax( double value ) {
		Assert.rangeCheck( value, 0, 1.0 );
		return super.addArg( "aomax", value );
	}

	/**
	 * Set preserve color mode
	 * 
	 * @apiNote (flags) preserve
	 * @param blend the alpha value
	 * @return the {@link ColorLevels} instance
	 * @see ColorMode
	 */
	public ColorLevels mode( ColorMode colorMode ) {
		return super.addArg( "preserve", colorMode );
	}

}
