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
 * Measure graylevel entropy in histogram of color channels of video frames
 * 
 * @author tangxbai
 * @since 2022/06/29
 * @see <a href="https://ffmpeg.org/ffmpeg-filters.html#entropy">ffmpeg-filters#entropy</a>
 */
@Function( "entropy" )
public class Entropy extends AbstractFunction<Entropy> {

	// Don't let anyone instantiate this class
	private Entropy() {}

	/**
	 * Quickly create an instances of {@link Entropy}, and set kind of histogram entropy measurement.
	 * 
	 * @apiNote (flags) mode
	 * @return the {@link Entropy} instance
	 */
	public static final Entropy normal() {
		return new Entropy().addArg( "mode", "normal" );
	}

	/**
	 * Quickly create an instances of {@link Entropy}, and set kind of histogram entropy measurement.
	 * 
	 * @apiNote (flags) mode
	 * @return the {@link Entropy} instance
	 */
	public static final Entropy diff() {
		return new Entropy().addArg( "mode", "diff" );
	}

}
