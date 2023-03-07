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
 * Boost or alter saturation
 * 
 * @author tangxbai
 * @since 2022/10/13
 * @see <a href= "https://ffmpeg.org/ffmpeg-filters.html#vibrance">ffmpeg-filters#vibrance</a>
 */
@Function( "vibrance" )
public class Vibrance extends AbstractFunction<Vibrance> {

	// Don't let anyone instantiate this class
	private Vibrance() {}

	/**
	 * Quickly create an instances of {@link Vibrance}
	 * 
	 * @return the {@link Vibrance} instance
	 */
	public static final Vibrance of() {
		return new Vibrance();
	}

	/**
	 * Set strength of boost if positive value or strength of alter if negative value. Default is <b>0</b>.
	 * Allowed range is from -2 to 2.
	 * 
	 * @apiNote (double) intensity
	 * @param value the intensity value
	 * @return the {@link Vibrance} instance
	 */
	public Vibrance intensity( double value ) {
		Assert.rangeCheck( value, -2, 2 );
		return super.addArg( "intensity", value );
	}

	/**
	 * Set the red balance. Allowed range is from -10 to 10, default is <b>1</b>.
	 * 
	 * @apiNote (double) rbal
	 * @param value the red balance value
	 * @return the {@link Vibrance} instance
	 */
	public Vibrance rBalance( double value ) {
		Assert.rangeCheck( value, -10, 10 );
		return super.addArg( "rbal", value );
	}

	/**
	 * Set the green balance. Allowed range is from -10 to 10, default is <b>1</b>.
	 * 
	 * @apiNote (double) gbal
	 * @param value the green balance value
	 * @return the {@link Vibrance} instance
	 */
	public Vibrance gBalance( double value ) {
		Assert.rangeCheck( value, -10, 10 );
		return super.addArg( "gbal", value );
	}

	/**
	 * Set the blue balance. Allowed range is from -10 to 10, default is <b>1</b>.
	 * 
	 * @apiNote (double) bbal
	 * @param value the blue balance value
	 * @return the {@link Vibrance} instance
	 */
	public Vibrance bBalance( double value ) {
		Assert.rangeCheck( value, -10, 10 );
		return super.addArg( "bbal", value );
	}

	/**
	 * Set the red luma coefficient. Allowed range is from 0 to 1, default value is <b>0.072186</b>.
	 * 
	 * @apiNote (double) rlum
	 * @param value the red luma coefficient value
	 * @return the {@link Vibrance} instance
	 */
	public Vibrance rLuma( double value ) {
		Assert.rangeCheck( value, -10, 10 );
		return super.addArg( "rlum", value );
	}

	/**
	 * Set the green luma coefficient. Allowed range is from 0 to 1, default value is <b>0.715158</b>.
	 * 
	 * @apiNote (double) glum
	 * @param value the green luma coefficient value
	 * @return the {@link Vibrance} instance
	 */
	public Vibrance gLuma( double value ) {
		Assert.rangeCheck( value, -10, 10 );
		return super.addArg( "glum", value );
	}

	/**
	 * Set the blue luma coefficient. Allowed range is from 0 to 1, default value is <b>0.212656</b>.
	 * 
	 * @apiNote (double) rlum
	 * @param value the blue luma coefficient value
	 * @return the {@link Vibrance} instance
	 */
	public Vibrance bLuma( double value ) {
		Assert.rangeCheck( value, -10, 10 );
		return super.addArg( "blue", value );
	}

	/**
	 * If intensity is negative and this is set to {@code true}, colors will change, otherwise colors will be
	 * less saturated, more towards gray.
	 * 
	 * @apiNote (boolean) alternate
	 * @return the {@link Vibrance} instance
	 */
	public Vibrance alternate() {
		return super.enable( "alternate" );
	}

}
