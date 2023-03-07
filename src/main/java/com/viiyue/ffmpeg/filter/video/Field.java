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
import com.viiyue.ffmpeg.filter.AbstractColorFunction;

/**
 * Extract a single field from an interlaced image using stride arithmetic to avoid wasting CPU time. The
 * output frames are marked as non-interlaced.
 * 
 * @author tangxbai
 * @since 2022/06/30
 * @see <a href="https://ffmpeg.org/ffmpeg-filters.html#field">ffmpeg-filters#field</a>
 */
@Function( "field" )
public class Field extends AbstractColorFunction<Field> {

	// Don't let anyone instantiate this class
	private Field( String field ) {
		super.addArg( "type", field );
	}

	/**
	 * Quickly create an instances of {@link ExtractPlanes} and specify whether to extract the top field
	 * 
	 * @return the {@link Field} instance
	 */
	public static final Field top() {
		return new Field( "top" );
	}

	/**
	 * Quickly create an instances of {@link ExtractPlanes} and specify whether to extract the bottom field
	 * 
	 * @return the {@link Field} instance
	 */
	public static final Field bottom() {
		return new Field( "bottom" );
	}

}
