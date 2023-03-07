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
import com.viiyue.ffmpeg.filter.AbstractColorFunction;

/**
 * Transpose rows with columns in the input video and optionally flip it
 * 
 * @author tangxbai
 * @since 2022/10/08
 * @see <a href="https://ffmpeg.org/ffmpeg-filters.html#transpose-1">ffmpeg-filters#transpose</a>
 */
@Function( "transpose" )
public class Transpose extends AbstractColorFunction<Transpose> {

	// Don't let anyone instantiate this class
	private Transpose() {}

	/**
	 * Quickly create an instances of {@link Transpose}
	 * 
	 * @return the {@link Transpose} instance
	 */
	public static final Transpose of() {
		return new Transpose();
	}

	/**
	 * Specify the transposition direction
	 * 
	 * @apiNote (flags) dir
	 * @param dir the transposition direction
	 * @return the {@link Transpose} instance
	 */
	public Transpose dir( Direction dir ) {
		return super.addArg( "dir", dir );
	}

	/**
	 * Do not apply the transposition if the input geometry matches the one specified by the specified value
	 * 
	 * @apiNote (flags) passthrough
	 * @param passthrough the passthrough enum flags
	 * @return the {@link Transpose} instance
	 */
	public Transpose passthrough( Passthrough passthrough ) {
		return super.addArg( "passthrough", passthrough );
	}

	/**
	 * Transposition direction
	 * 
	 * @author tangxbai
	 * @since 2022/10/08
	 */
	public enum Direction implements AbstractEnum {
		/** Rotate clockwise */
		CLOCK,
		/** Rotate clockwise with vertical flip */
		CLOCK_FLIP,
		/** Rotate counter-clockwise */
		CCLOCK,
		/** Rotate counter-clockwise with vertical flip */
		CCLOCK_FLIP
	}

	/**
	 * Transposition direction
	 * 
	 * @author tangxbai
	 * @since 2022/10/08
	 */
	public enum Passthrough implements AbstractEnum {
		/** Always apply transposition */
		NONE,
		/** Preserve portrait geometry */
		PORTRAIT,
		/** Preserve landscape geometry */
		LANDSCAPE
	}

}
