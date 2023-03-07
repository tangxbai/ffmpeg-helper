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
 * <p>
 * Apply Midway Image Equalization effect using two video streams.
 * 
 * <p>
 * Midway Image Equalization adjusts a pair of images to have the same histogram, while maintaining their
 * dynamics as much as possible. It’s useful for e.g. matching exposures from a pair of stereo cameras.
 * 
 * <p>
 * This filter has two inputs and one output, which must be of same pixel format, but may be of different
 * sizes. The output of filter is first input adjusted with midway histogram of both inputs.
 * 
 * @author tangxbai
 * @since 2022/07/18
 * @see <a href="https://ffmpeg.org/ffmpeg-filters.html#midequalizer">ffmpeg-filters#midequalizer</a>
 */
@Function( "midequalizer" )
public class MediumEqualizer extends AbstractFunction<MediumEqualizer> {

	// Don't let anyone instantiate this class
	private MediumEqualizer() {}

	/**
	 * Quickly create an instances of {@link MediumEqualizer}
	 * 
	 * @apiNote (int) planes
	 * @param value the plane filter
	 * @return the {@link MediumEqualizer} instance
	 */
	public static final MediumEqualizer planes( int value ) {
		Assert.rangeCheck( value, 0, 15 );
		return new MediumEqualizer().addArg( "planes", value );
	}

}
