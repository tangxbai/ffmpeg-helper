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
import com.viiyue.ffmpeg.filter.AbstractFunction;
import com.viiyue.ffmpeg.util.Assert;

/**
 * Shift R/G/B/A pixels horizontally and/or vertically
 * 
 * @author tangxbai
 * @since 2022/08/01
 * @see <a href="https://ffmpeg.org/ffmpeg-filters.html#rgbashift">ffmpeg-filters#rgbashift</a>
 */
@Function( "rgbashift" )
public class RgbaShift extends AbstractFunction<RgbaShift> {

	// Don't let anyone instantiate this class
	private RgbaShift() {}

	/**
	 * Quickly create an instances of {@link RgbaShift}
	 * 
	 * @return the {@link RgbaShift} instance
	 */
	public static final RgbaShift of() {
		return new RgbaShift();
	}

	/**
	 * Set edge mode
	 * 
	 * @apiNote (flags) edge
	 * @param mode the edge mode
	 * @return the {@link RgbaShift} instance
	 */
	public RgbaShift edge( EdgeMode mode ) {
		return super.addArg( "edge", mode );
	}

	/**
	 * Set amount to shift red horizontally, value range is from -255 to 255, default is <b>0</b>.
	 * 
	 * @apiNote (int) rh
	 * @param value the amount value
	 * @return the {@link RgbaShift} instance
	 */
	public RgbaShift redHorizontally( int value ) {
		Assert.rangeCheck( value, -255, 255 );
		return super.addArg( "rh", value );
	}

	/**
	 * Set amount to shift red vertically, value range is from -255 to 255, default is <b>0</b>.
	 * 
	 * @apiNote (int) rv
	 * @param value the amount value
	 * @return the {@link RgbaShift} instance
	 */
	public RgbaShift redVertically( int value ) {
		Assert.rangeCheck( value, -255, 255 );
		return super.addArg( "rv", value );
	}

	/**
	 * Set amount to shift green horizontally, value range is from -255 to 255, default is <b>0</b>.
	 * 
	 * @apiNote (int) gh
	 * @param value the amount value
	 * @return the {@link RgbaShift} instance
	 */
	public RgbaShift greenHorizontally( int value ) {
		Assert.rangeCheck( value, -255, 255 );
		return super.addArg( "gh", value );
	}

	/**
	 * Set amount to shift green vertically, value range is from -255 to 255, default is <b>0</b>.
	 * 
	 * @apiNote (int) gv
	 * @param value the amount value
	 * @return the {@link RgbaShift} instance
	 */
	public RgbaShift greenVertically( int value ) {
		Assert.rangeCheck( value, -255, 255 );
		return super.addArg( "gv", value );
	}

	/**
	 * Set amount to shift blue horizontally, value range is from -255 to 255, default is <b>0</b>.
	 * 
	 * @apiNote (int) bh
	 * @param value the amount value
	 * @return the {@link RgbaShift} instance
	 */
	public RgbaShift blueHorizontally( int value ) {
		Assert.rangeCheck( value, -255, 255 );
		return super.addArg( "bh", value );
	}

	/**
	 * Set amount to shift blue vertically, value range is from -255 to 255, default is <b>0</b>.
	 * 
	 * @apiNote (int) bv
	 * @param value the amount value
	 * @return the {@link RgbaShift} instance
	 */
	public RgbaShift blueVertically( int value ) {
		Assert.rangeCheck( value, -255, 255 );
		return super.addArg( "bv", value );
	}

	/**
	 * Set amount to shift alpha horizontally, value range is from -255 to 255, default is <b>0</b>.
	 * 
	 * @apiNote (int) ah
	 * @param value the amount value
	 * @return the {@link RgbaShift} instance
	 */
	public RgbaShift alphaHorizontally( int value ) {
		Assert.rangeCheck( value, -255, 255 );
		return super.addArg( "ah", value );
	}

	/**
	 * Set amount to shift alpha vertically, value range is from -255 to 255, default is <b>0</b>.
	 * 
	 * @apiNote (int) bv
	 * @param value the amount value
	 * @return the {@link RgbaShift} instance
	 */
	public RgbaShift alphaVertically( int value ) {
		Assert.rangeCheck( value, -255, 255 );
		return super.addArg( "av", value );
	}

	public enum EdgeMode implements AbstractEnum {
		SMEAR, WARP
	}

}
