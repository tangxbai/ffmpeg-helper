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
 * Apply a high-quality magnification filter designed for pixel art. This filter was originally created by
 * Maxim Stepin.
 * 
 * @author tangxbai
 * @since 2022/07/11
 * @see <a href="https://ffmpeg.org/ffmpeg-filters.html#hqx">ffmpeg-filters#hqx</a>
 */
@Function( "hqx" )
public class Hqx extends AbstractFunction<Hqx> {

	// Don't let anyone instantiate this class
	private Hqx() {}

	/**
	 * Quickly create an instances of {@link Hqx}
	 * 
	 * @return the {@link Hqx} instance
	 */
	public static final Hqx hq2x() {
		return new Hqx().addArg( "n", 2 );
	}

	/**
	 * Quickly create an instances of {@link Hqx}
	 * 
	 * @return the {@link Hqx} instance
	 */
	public static final Hqx hq3x() {
		return new Hqx().addArg( "n", 3 );
	}

	/**
	 * Quickly create an instances of {@link Hqx}
	 * 
	 * @return the {@link Hqx} instance
	 */
	public static final Hqx hq4x() {
		return new Hqx().addArg( "n", 4 );
	}

}
