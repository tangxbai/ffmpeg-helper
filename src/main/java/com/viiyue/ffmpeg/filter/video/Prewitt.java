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
 * Apply prewitt operator to input video stream
 * 
 * @author tangxbai
 * @since 2022/07/21
 * @see <a href="https://ffmpeg.org/ffmpeg-filters.html#prewitt">ffmpeg-filters#prewitt</a>
 */
@Function( "prewitt" )
public class Prewitt extends AbstractFunction<Prewitt> {

	// Don't let anyone instantiate this class
	private Prewitt() {}

	/**
	 * Quickly create an instances of {@link Prewitt}
	 * 
	 * @return the {@link Prewitt} instance
	 */
	public static final Prewitt of() {
		return new Prewitt();
	}

	/**
	 * Set planes to filter. Value range allowed is from 0 to 15, default value is <b>15</b>, all planes will
	 * be processed.
	 * 
	 * @apiNote (int) planes
	 * @param value the plane filter
	 * @return the {@link Prewitt} instance
	 */
	public Prewitt planes( int value ) {
		Assert.rangeCheck( value, 0, 15 );
		return super.addArg( "planes", value );
	}

	/**
	 * Set value which will be multiplied with filtered result. Value range is [0,65535], default is <b>1</b>.
	 * 
	 * @apiNote (double) scale
	 * @param value the scale value
	 * @return the {@link Prewitt} instance
	 */
	public Prewitt scale( double value ) {
		Assert.rangeCheck( value, 0, 65535 );
		return super.addArg( "scale", value );
	}

	/**
	 * Set value which will be added to filtered result. Value range is [-65535,65535], default is <b>0</b>.
	 * 
	 * @apiNote (double) delta
	 * @param value the delta value
	 * @return the {@link Prewitt} instance
	 */
	public Prewitt delta( double value ) {
		Assert.rangeCheck( value, -65535, 65535 );
		return super.addArg( "delta", value );
	}

}
