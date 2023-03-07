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
 * <p>
 * The {@code separatefields} takes a frame-based video input and splits each frame into its components
 * fields, producing a new half height clip with twice the frame rate and twice the frame count.
 * 
 * <p>
 * This filter use field-dominance information in frame to decide which of each pair of fields to place first
 * in the output. If it gets it wrong use setfield filter before {@code separatefields} filter.
 * 
 * @author tangxbai
 * @since 2022/08/03
 * @see <a href="https://ffmpeg.org/ffmpeg-filters.html#separatefields-1">ffmpeg-filters#separatefields</a>
 */
@Function( "separatefields" )
public class SeparateFields extends AbstractFunction<SeparateFields> {

	// Don't let anyone instantiate this class
	private SeparateFields() {}

}
