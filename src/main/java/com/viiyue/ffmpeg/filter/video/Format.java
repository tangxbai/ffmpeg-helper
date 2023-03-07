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
import com.viiyue.ffmpeg.common.Const;
import com.viiyue.ffmpeg.enums.PixelFormat;
import com.viiyue.ffmpeg.filter.AbstractColorFunction;

/**
 * Convert the input video to one of the specified pixel formats. Libavfilter will try to pick one that is
 * suitable as input to the next filter.
 * 
 * @author tangxbai
 * @since 2022/07/06
 * @see <a href="https://ffmpeg.org/ffmpeg-filters.html#format-1">ffmpeg-filters#format</a>
 */
@Function( "format" )
public class Format extends AbstractColorFunction<Format> {

	// Don't let anyone instantiate this class
	private Format() {}

	/**
	 * Quickly create an instances of {@link Format}
	 * 
	 * @return the {@link Format} instance
	 */
	public static final Format of( PixelFormat ... formats ) {
		return new Format().addArg2( null, Const.LIST_SEPARATOR, formats );
	}

}
