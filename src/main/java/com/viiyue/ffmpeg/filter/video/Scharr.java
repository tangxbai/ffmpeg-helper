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
 * Apply scharr operator to input video stream
 * 
 * @author tangxbai
 * @since 2022/08/03
 * @see <a href="https://ffmpeg.org/ffmpeg-filters.html#scharr">ffmpeg-filters#scharr</a>
 */
@Function( "scharr" )
public class Scharr extends AbstractFunction<Scharr> {

	// Don't let anyone instantiate this class
	private Scharr() {}

	/**
	 * Quickly create an instances of {@link Scharr}
	 * 
	 * @return the {@link Scharr} instance
	 */
	public static final Scharr of() {
		return new Scharr();
	}

	/**
	 * Set planes to filter. Value range allowed is from 0 to 15, default value is <b>15</b>, all planes will
	 * be processed.
	 * 
	 * @apiNote (int) planes
	 * @param value the plane filter
	 * @return the {@link Scharr} instance
	 */
	public Scharr planes( int value ) {
		Assert.rangeCheck( value, 0, 15 );
		return super.addArg( "planes", value );
	}

	/**
	 * Set value which will be multiplied with filtered result
	 * 
	 * @apiNote (int) scale
	 * @param value the scale value
	 * @return the {@link Scharr} instance
	 */
	public Scharr scale( double value ) {
		Assert.rangeCheck( value, 0.0, 65535.0 );
		return super.addArg( "scale", value );
	}

	/**
	 * Set value which will be added to filtered result
	 * 
	 * @apiNote (int) delta
	 * @param value the delta value
	 * @return the {@link Scharr} instance
	 */
	public Scharr delta( double value ) {
		Assert.rangeCheck( value, -65535.0, 65535.0 );
		return super.addArg( "delta", value );
	}

}
