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
 * Multiply first video stream pixels values with second video stream pixels values
 * 
 * @author tangxbai
 * @since 2022/07/19
 * @see <a href="https://ffmpeg.org/ffmpeg-filters.html#multiply">ffmpeg-filters#multiply</a>
 */
@Function( "multiply" )
public class Multiply extends AbstractFunction<Multiply> {

	// Don't let anyone instantiate this class
	private Multiply() {}

	/**
	 * Quickly create an instances of {@link Multiply}
	 * 
	 * @return the {@link Multiply} instance
	 */
	public static final Multiply of() {
		return new Multiply();
	}

	/**
	 * Set the scale applied to second video stream. Allowed range is from 0 to 9, default is <b>1</b>.
	 * 
	 * @apiNote (int) scale
	 * @param state the scale value
	 * @return the {@link Multiply} instance
	 */
	public Multiply scale( int value ) {
		Assert.rangeCheck( value, 0, 9 );
		return super.addArg( "scale", value );
	}

	/**
	 * Set the offset applied to second video stream. Allowed range is from -1 to 1, default is <b>0.5</b>.
	 * 
	 * @apiNote (int) offset
	 * @param state the offset value
	 * @return the {@link Multiply} instance
	 */
	public Multiply offset( double value ) {
		Assert.rangeCheck( value, -1, 1 );
		return super.addArg( "offset", value );
	}

	/**
	 * Set planes to filter. Value range allowed is from 0 to 15, default value is <b>15</b>, all planes will
	 * be processed.
	 * 
	 * @apiNote (int) planes
	 * @param value the plane filter
	 * @return the {@link Multiply} instance
	 */
	public Multiply planes( int value ) {
		Assert.rangeCheck( value, 0, 15 );
		return super.addArg( "planes", value );
	}

}
