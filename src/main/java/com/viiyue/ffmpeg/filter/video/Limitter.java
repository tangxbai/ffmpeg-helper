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
 * Limits the pixel components values to the specified range [min, max].
 * 
 * @author tangxbai
 * @since 2022/07/13
 * @see <a href="https://ffmpeg.org/ffmpeg-filters.html#limiter">ffmpeg-filters#limiter</a>
 */
@Function( "limiter" )
public class Limitter extends AbstractFunction<Limitter> {

	// Don't let anyone instantiate this class
	private Limitter() {}

	/**
	 * Quickly create an instances of {@link Limitter}
	 * 
	 * @return the {@link Limitter} instance
	 */
	public static final Limitter of() {
		return new Limitter();
	}

	/**
	 * Lower bound. Defaults to the lowest allowed value for the input. This value allowed range is from 0 to
	 * 65535, default value is <b>0</b>.
	 * 
	 * @apiNote (double) min
	 * @param value the lower bound
	 * @return the {@link Limitter} instance
	 */
	public Limitter min( int value ) {
		Assert.rangeCheck( value, 0, 65535 );
		return super.addArg( "min", value );
	}

	/**
	 * Upper bound. Defaults to the highest allowed value for the input. This value allowed range is from 0 to
	 * 65535, default value is <b>0</b>.
	 * 
	 * @apiNote (double) threshold
	 * @param value the upper bound
	 * @return the {@link Limitter} instance
	 */
	public Limitter max( int value ) {
		Assert.rangeCheck( value, 0, 65535 );
		return super.addArg( "max", value );
	}

	/**
	 * Specify which planes will be processed. Defaults to all available. Allowed value range is from 0 to 15,
	 * and default value is <b>15</b>.
	 * 
	 * @apiNote (int) planes
	 * @param value the filter planes
	 * @return the {@link Limitter} instance
	 */
	public Limitter planes( int value ) {
		Assert.rangeCheck( value, 0, 15 );
		return super.addArg( "planes", value );
	}

}
