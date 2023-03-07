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
import com.viiyue.ffmpeg.enums.FirstField;
import com.viiyue.ffmpeg.filter.AbstractFunction;

/**
 * The {@code doubleweave} works same as {@code weave} but without halving frame rate and frame count.
 * 
 * @author tangxbai
 * @since 2022/10/18
 * @see <a href= "https://ffmpeg.org/ffmpeg-filters.html#weave_002c-doubleweave">ffmpeg-filters#waveform</a>
 * @see Weave
 */
@Function( "weave" )
public class DoubleWeave extends AbstractFunction<DoubleWeave> {

	// Don't let anyone instantiate this class
	private DoubleWeave() {}

	/**
	 * Quickly create an instances of {@link DoubleWeave}
	 * 
	 * @return the {@link DoubleWeave} instance
	 */
	public static final DoubleWeave of() {
		return new DoubleWeave();
	}

	/**
	 * Quickly create an instances of {@link DoubleWeave}
	 * 
	 * @apiNote (flags) first_field
	 * @param field the first field
	 * @return the {@link DoubleWeave} instance
	 * @see FirstField
	 */
	public static final DoubleWeave of( FirstField field ) {
		return new DoubleWeave().addValue( field );
	}

}
