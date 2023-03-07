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

/**
 * Suppress a TV station logo, using an image file to determine which pixels comprise the logo. It works by
 * filling in the pixels that comprise the logo with neighboring pixels.
 * 
 * @author tangxbai
 * @since 2022/07/25
 * @see <a href="https://ffmpeg.org/ffmpeg-filters.html#removelogo">ffmpeg-filters#removelogo</a>
 */
@Function( "removelogo" )
public class RemoveLogo extends AbstractFunction<RemoveLogo> {

	// Don't let anyone instantiate this class
	private RemoveLogo() {}

	/**
	 * <p>
	 * Quickly create an instances of {@link RemoveLogo}.
	 * 
	 * <p>
	 * Set the filter bitmap file, which can be any image format supported by libavformat. The width and
	 * height of the image file must match those of the video stream being processed.
	 * 
	 * @apiNote (string) filename, f
	 * @param image the log bitmap file
	 * @return the {@link RemoveLogo} instance
	 */
	public static final RemoveLogo of( String image ) {
		return new RemoveLogo().addArg( "f", image );
	}

}
