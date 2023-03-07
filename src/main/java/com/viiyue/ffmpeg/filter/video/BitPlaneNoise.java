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
 * Show and measure bit plane noise
 *
 * @author tangxbai
 * @since 2022/06/09
 * @see <a href="https://ffmpeg.org/ffmpeg-filters.html#bitplanenoise">ffmpeg-filters#bitplanenoise</a>
 */
@Function( "bitplanenoise" )
public class BitPlaneNoise extends AbstractFunction<BitPlaneNoise> {

	// Don't let anyone instantiate this class
	private BitPlaneNoise() {}

	/**
	 * Quickly create an instances of {@link BitPlaneNoise}
	 * 
	 * @return the {@link BitPlaneNoise} instance
	 */
	public static final BitPlaneNoise the() {
		return new BitPlaneNoise();
	}

	/**
	 * Set which plane to analyze, the default is <b>1</b>.
	 * 
	 * @apiNote (double) bitplane
	 * @param value the plane value, range is from 1 to 16.
	 * @return the {@link BitPlaneNoise} instance
	 */
	public BitPlaneNoise plane( double plane ) {
		Assert.rangeCheck( plane, 1, 16 );
		return super.addArg( "bitplane", plane );
	}

	/**
	 * Set which plane to analyze, the default is {@code false}.
	 * 
	 * @apiNote (boolean) filter
	 * @return the {@link BitPlaneNoise} instance
	 */
	public BitPlaneNoise filter() {
		return super.enable( "filter" );
	}

}
