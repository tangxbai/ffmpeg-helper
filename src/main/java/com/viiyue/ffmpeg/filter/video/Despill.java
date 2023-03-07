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
 * Remove unwanted contamination of foreground colors, caused by reflected color of greenscreen or bluescreen.
 * 
 * @author tangxbai
 * @since 2022/06/27
 * @see <a href="https://ffmpeg.org/ffmpeg-filters.html#despill">ffmpeg-filters#despill</a>
 */
@Function( "despill" )
public class Despill extends AbstractFunction<Despill> {

	// Don't let anyone instantiate this class
	private Despill() {}

	/**
	 * Quickly create an instances of {@link Despill}
	 * 
	 * @return the {@link Despill} instance
	 */
	public static final Despill of() {
		return new Despill();
	}

	/**
	 * Set what type of despill to use
	 * 
	 * @apiNote (flags) type
	 * @param type the screen type
	 * @return the {@link Despill} instance
	 */
	public Despill type( ScreenType type ) {
		return super.addArg( "type", type );
	}

	/**
	 * Set how spillmap will be generated, range is from 0 to 1, default is <b>0.5</b>.
	 * 
	 * @apiNote (double) mix
	 * @param value the spillmap mix value
	 * @return the {@link Despill} instance
	 */
	public Despill mix( double value ) {
		Assert.rangeCheck( value, 0.0, 1.0 );
		return super.addArg( "mix", value );
	}

	/**
	 * Set how much to get rid of still remaining spill, range is from 0 to 1, default is <b>0</b>.
	 * 
	 * @apiNote (double) expand
	 * @param value the spillmap expand value
	 * @return the {@link Despill} instance
	 */
	public Despill expand( double value ) {
		Assert.rangeCheck( value, 0.0, 1.0 );
		return super.addArg( "expand", value );
	}

	/**
	 * Controls amount of red in spill area, range is from -100 to 100, default is <b>0</b>.
	 * 
	 * @apiNote (double) red
	 * @param value the red scale value
	 * @return the {@link Despill} instance
	 */
	public Despill red( double value ) {
		Assert.rangeCheck( value, -100, 100 );
		return super.addArg( "red", value );
	}

	/**
	 * Controls amount of green in spill area, range is from -100 to 100, default is <b>-1</b>.
	 * 
	 * @apiNote (double) green
	 * @param value the green scale value
	 * @return the {@link Despill} instance
	 */
	public Despill green( double value ) {
		Assert.rangeCheck( value, -100, 100 );
		return super.addArg( "green", value );
	}

	/**
	 * Controls amount of blue in spill area, range is from -100 to 100, default is <b>0</b>.
	 * 
	 * @apiNote (double) blue
	 * @param value the blue scale value
	 * @return the {@link Despill} instance
	 */
	public Despill blue( double value ) {
		Assert.rangeCheck( value, -100, 100 );
		return super.addArg( "blue", value );
	}

	/**
	 * Controls brightness of spill area, preserving colors, range is from -10 to 10, default is <b>0</b>.
	 * 
	 * @apiNote (double) brightness
	 * @param value the brightness value
	 * @return the {@link Despill} instance
	 */
	public Despill brightness( double value ) {
		Assert.rangeCheck( value, -100, 100 );
		return super.addArg( "brightness", value );
	}

	/**
	 * Controls brightness of spill area, preserving colors, range is from -10 to 10, default is <b>0</b>.
	 * 
	 * @apiNote (boolean) alpha
	 * @param value the brightness value
	 * @return the {@link Despill} instance
	 */
	public Despill alpha() {
		return super.enable( "alpha" );
	}

	/**
	 * Screen type
	 *
	 * @author tangxbai
	 * @since 2022/06/27
	 */
	public enum ScreenType implements AbstractEnum {
		GREEN, BLUE
	}

}
