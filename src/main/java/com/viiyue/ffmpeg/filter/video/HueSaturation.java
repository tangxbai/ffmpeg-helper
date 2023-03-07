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
import com.viiyue.ffmpeg.common.AbstractEnum;
import com.viiyue.ffmpeg.common.Const;
import com.viiyue.ffmpeg.filter.AbstractFunction;
import com.viiyue.ffmpeg.util.Assert;

/**
 * Apply hue-saturation-intensity adjustments to input video stream, this filter operates in RGB colorspace.
 *
 * @author tangxbai
 * @since 2022/07/11
 * @see <a href="https://ffmpeg.org/ffmpeg-filters.html#huesaturation">ffmpeg-filters#huesaturation</a>
 */
@Function( "huesaturation" )
public class HueSaturation extends AbstractFunction<HueSaturation> {

	// Don't let anyone instantiate this class
	private HueSaturation() {}

	/**
	 * Quickly create an instances of {@link HueSaturation}
	 * 
	 * @return the {@link HueSaturation} instance
	 */
	public static final HueSaturation of() {
		return new HueSaturation();
	}

	/**
	 * Set the hue shift in degrees to apply. Allowed range is from -180 to 180, default value is <b>0</b>.
	 * 
	 * @apiNote (double) hue
	 * @param value the hue shift value
	 * @return the {@link HueSaturation} instance
	 */
	public HueSaturation hue( double value ) {
		Assert.rangeCheck( value, -180, 180 );
		return super.addArg( "hue", value );
	}

	/**
	 * Set the saturation value which will be used in color difference calculation. Allowed range is from -1
	 * to 1, default value is <b>0</b>.
	 * 
	 * @apiNote (double) sat
	 * @param value the saturation value
	 * @return the {@link HueSaturation} instance
	 */
	public HueSaturation saturation( double value ) {
		Assert.rangeCheck( value, -1, 1 );
		return super.addArg( "sat", value );
	}

	/**
	 * Set the intensity shift. Allowed range is from -1 to 1, default value is <b>0</b>.
	 * 
	 * @apiNote (double) intensity
	 * @param value the intensity shift
	 * @return the {@link HueSaturation} instance
	 */
	public HueSaturation intensity( double value ) {
		Assert.rangeCheck( value, -1, 1 );
		return super.addArg( "intensity", value );
	}

	/**
	 * Set which primary and complementary colors are going to be adjusted. This options is set by providing
	 * one or multiple values. This can select multiple colors at once. By default all colors are selected.
	 * 
	 * @apiNote (flags) colors
	 * @param value the colors range
	 * @return the {@link HueSaturation} instance
	 */
	public HueSaturation colors( ColorRange ... ranges ) {
		return super.addArg2( "colors", Const.APPEND_SEPARATOR, ranges );
	}

	/**
	 * Set strength of filtering. Allowed range is from 0 to 100, default value is <b>1</b>.
	 * 
	 * @apiNote (flags) strength
	 * @param value the filtering strength
	 * @return the {@link HueSaturation} instance
	 */
	public HueSaturation strength( double value ) {
		Assert.rangeCheck( value, 0.0, 100.0 );
		return super.addArg( "strength", value );
	}

	/**
	 * Set weight for red component. Allowed range is from 0 to 1. By default is set to <b>0.333</b>. Those
	 * options are used in saturation and lightess processing.
	 * 
	 * @apiNote (flags) rw
	 * @param value the red component weight
	 * @return the {@link HueSaturation} instance
	 */
	public HueSaturation redWeight( double value ) {
		Assert.rangeCheck( value, 0.0, 100.0 );
		return super.addArg( "rw", value );
	}

	/**
	 * Set weight for green component. Allowed range is from 0 to 1. By default is set to <b>0.334</b>,
	 * <b>0.333</b>. Those options are used in saturation and lightess processing.
	 * 
	 * @apiNote (flags) gw
	 * @param value the green component weight
	 * @return the {@link HueSaturation} instance
	 */
	public HueSaturation greenWeight( double value ) {
		Assert.rangeCheck( value, 0.0, 100.0 );
		return super.addArg( "gw", value );
	}

	/**
	 * Set weight for blue component. Allowed range is from 0 to 1. By default is set to <b>0.333</b>. Those
	 * options are used in saturation and lightess processing.
	 * 
	 * @apiNote (flags) gw
	 * @param value the blue component weight
	 * @return the {@link HueSaturation} instance
	 */
	public HueSaturation blueWeight( double value ) {
		Assert.rangeCheck( value, 0.0, 100.0 );
		return super.addArg( "gw", value );
	}

	/**
	 * Set preserving lightness, by default is {@code false} (disabled). Adjusting hues can change lightness
	 * from original RGB triplet, with this option enabled lightness is kept at same value.
	 * 
	 * @apiNote (boolean) lightness
	 * @return the {@link HueSaturation} instance
	 */
	public HueSaturation lightness() {
		return super.enable( "lightness" );
	}

	/**
	 * Colors range
	 *
	 * @author tangxbai
	 * @since 2022/07/11
	 */
	public enum ColorRange implements AbstractEnum {
		R, Y, G, C, B, M, A
	}

}
