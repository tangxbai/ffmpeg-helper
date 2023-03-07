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
import com.viiyue.ffmpeg.filter.AbstractFunction;

/**
 * Force {@code libavfilter} not to use any of the specified pixel formats for the input to the next filter.
 * 
 * @author tangxbai
 * @since 2022/07/19
 * @see <a href="https://ffmpeg.org/ffmpeg-filters.html#noformat">ffmpeg-filters#noformat</a>
 */
@Function( "noformat" )
public class NoFormat extends AbstractFunction<NoFormat> {

	// Don't let anyone instantiate this class
	private NoFormat() {}

	/**
	 * Quickly create an instances of {@link NoFormat}
	 * 
	 * @return the {@link NoFormat} instance
	 */
	public static final NoFormat of( PixelFormat ... formats ) {
		return new NoFormat().addArg2( null, Const.LIST_SEPARATOR, formats );
	}

}
