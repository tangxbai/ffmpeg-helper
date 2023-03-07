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

/**
 * Compute a look-up table for binding each pixel component input value to an output value, and apply it to
 * the input video.
 * 
 * lutyuv applies a lookup table to a YUV input video, lutrgb to an RGB input video.
 * 
 * @author tangxbai
 * @since 2022/07/13
 * @see <a href="https://ffmpeg.org/ffmpeg-filters.html#lut_002c-lutrgb_002c-lutyuv">ffmpeg-filters#lutyuv</a>
 */
@Function( "lutyuv" )
public class LutYuv extends AbstractLut<LutYuv> {

	// Don't let anyone instantiate this class
	private LutYuv() {}

	/**
	 * Quickly create an instances of {@link LutYuv}
	 * 
	 * @return the {@link LutYuv} instance
	 */
	public static final LutYuv of() {
		return new LutYuv();
	}

}
