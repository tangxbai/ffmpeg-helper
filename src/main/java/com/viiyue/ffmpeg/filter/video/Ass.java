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
import com.viiyue.ffmpeg.common.AbstractEnum;

/**
 * <p>
 * Draw subtitles on top of input video using the libass library.
 * 
 * <p>
 * To enable compilation of this filter you need to configure FFmpeg with --enable-libass.
 * 
 * <p>
 * This filter also requires a build with libavcodec and libavformat to convert the passed subtitles file to
 * ASS (Advanced Substation Alpha) subtitles format.
 * 
 * @author tangxbai
 * @since 2022/06/08
 * @see <a href="https://ffmpeg.org/ffmpeg-filters.html#ass">ffmpeg-filters#ass</a>
 */
@Function( "ass" )
public class Ass extends Subtitles {

	// Don't let anyone instantiate this class
	private Ass() {
		super( null );
	}

	/**
	 * Quickly create an instances of {@link Ass}
	 * 
	 * @param file the subtitles file path
	 * @return the {@link Ass} instance
	 */
	public static final Ass of( String file ) {
		return of( file, null );
	}

	/**
	 * Quickly create an instances of {@link Ass}
	 * 
	 * @param file   the subtitles file path
	 * @param engine the shaping engine
	 * @return the {@link Ass} instance
	 */
	public static final Ass of( String file, Engine engine ) {
		Ass ass = new Ass();
		ass.addArg( "f", file );
		if ( engine != null ) {
			ass.addArg( "shaping", engine );
		}
		return ass;
	}

	/**
	 * Shaping Engine
	 *
	 * @author tangxbai
	 * @since 2022/06/08
	 */
	public enum Engine implements AbstractEnum {
		AUTO, SIMPLE, COMPLEX
	}

}
