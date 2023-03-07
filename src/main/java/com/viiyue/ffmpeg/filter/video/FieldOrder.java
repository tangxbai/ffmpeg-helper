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
 * Transform the field order of the input video
 * 
 * @author tangxbai
 * @since 2022/07/05
 * @see <a href="https://ffmpeg.org/ffmpeg-filters.html#fieldorder">ffmpeg-filters#fieldorder</a>
 */
@Function( "fieldorder" )
public class FieldOrder extends AbstractColorFunction<FieldOrder> {

	// Don't let anyone instantiate this class
	private FieldOrder() {}

	/**
	 * Quickly create an instances of {@link ExtractPlanes}, and set top field first.
	 * 
	 * @apiNote (flags) order
	 * @return the {@link FieldOrder} instance
	 */
	public static final FieldOrder topFirst() {
		return new FieldOrder().addArg( "order", "tff" );
	}

	/**
	 * Quickly create an instances of {@link ExtractPlanes}, and set bottom field first.
	 * 
	 * @apiNote (flags) order
	 * @return the {@link FieldOrder} instance
	 */
	public static final FieldOrder bottomFirst() {
		return new FieldOrder().addArg( "order", "bff" );
	}

}
