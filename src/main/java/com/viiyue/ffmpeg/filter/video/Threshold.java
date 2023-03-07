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
 * Compute and draw a color distribution histogram for the input video across time.
 * 
 * <p>
 * Unlike histogram video filter which only shows histogram of single input frame at certain time, this filter
 * shows also past histograms of number of frames defined by {@code width} option.
 * 
 * <p>
 * The computed histogram is a representation of the color component distribution in an image.
 * 
 * @author tangxbai
 * @since 2022/08/05
 * @see <a href="https://ffmpeg.org/ffmpeg-filters.html#threshold">ffmpeg-filters#threshold</a>
 */
@Function( "threshold" )
public class Threshold extends AbstractFunction<Threshold> {

	// Don't let anyone instantiate this class
	private Threshold() {}

	/**
	 * <p>
	 * Quickly create an instances of {@link Threshold}
	 * 
	 * <p>
	 * Set planes to filter. Value range allowed is from 0 to 15, default value is <b>15</b>, all planes will
	 * be processed.
	 * 
	 * @apiNote (int) planes
	 * @param value the plane filter
	 * @return the {@link Threshold} instance
	 */
	public static final Threshold of( int value ) {
		Assert.rangeCheck( value, 0, 15 );
		return new Threshold().addArg( "planes", value );
	}

}
