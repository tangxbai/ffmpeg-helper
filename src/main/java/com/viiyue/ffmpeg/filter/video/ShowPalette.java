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
 * Displays the 256 colors palette of each frame. This filter is only relevant for pal8 pixel format frames.
 * 
 * @author tangxbai
 * @since 2022/08/04
 * @see <a href="https://ffmpeg.org/ffmpeg-filters.html#showpalette">ffmpeg-filters#showpalette</a>
 */
@Function( "showpalette" )
public class ShowPalette extends AbstractFunction<ShowPalette> {

	// Don't let anyone instantiate this class
	private ShowPalette() {}

	/**
	 * Quickly create an instances of {@link ShowPalette}
	 * 
	 * @apiNote (int) width
	 * @apiNote (int) height
	 * @param width  the palette size of width
	 * @param height the palette size of height
	 * @return the {@link ShowPalette} instance
	 */
	public static final ShowPalette of( int width, int height ) {
		return new ShowPalette().addArg( "s", width + "x" + height );
	}

}
