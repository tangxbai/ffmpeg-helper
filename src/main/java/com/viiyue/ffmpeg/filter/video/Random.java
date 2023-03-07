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
 * Flush video frames from internal cache of frames into a random order. No frame is discarded. Inspired by
 * frei0r nervous filter.
 * 
 * @author tangxbai
 * @since 2022/07/22
 * @see <a href="https://ffmpeg.org/ffmpeg-filters.html#random">ffmpeg-filters#random</a>
 */
@Function( "random" )
public class Random extends AbstractFunction<Random> {

	// Don't let anyone instantiate this class
	private Random() {}

	/**
	 * Quickly create an instances of {@link Random}
	 * 
	 * @return the {@link Random} instance
	 */
	public static final Random of() {
		return new Random();
	}

	/**
	 * Set size in number of frames of internal cache, in range from 2 to 512, default is <b>30</b>.
	 * 
	 * @apiNote (int) frames
	 * @param value the number of frames in cache
	 * @return the {@link Random} instance
	 */
	public Random frames( int value ) {
		Assert.rangeCheck( value, 2, 512 );
		return super.addArg( "frames", value );
	}

	/**
	 * Set seed for random number generator, must be an integer included between 0 and UINT32_MAX. If not
	 * specified, or if explicitly set to less than 0, the filter will try to use a good random seed on a best
	 * effort basis.
	 * 
	 * @apiNote (long) seed
	 * @param value the random seed
	 * @return the {@link Random} instance
	 */
	public Random seed( long value ) {
		return super.addArg( "seed", value );
	}

}
