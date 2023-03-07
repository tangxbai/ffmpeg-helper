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
 * The {@code weave} takes a field-based video input and join each two sequential fields into single frame,
 * producing a new double height clip with half the frame rate and half the frame count.
 * 
 * @author tangxbai
 * @since 2022/10/17
 * @see <a href= "https://ffmpeg.org/ffmpeg-filters.html#weave_002c-doubleweave">ffmpeg-filters#waveform</a>
 * @see DoubleWeave
 */
@Function( "weave" )
public class Weave extends AbstractFunction<Weave> {

	// Don't let anyone instantiate this class
	private Weave() {}

	/**
	 * Quickly create an instances of {@link Weave}
	 * 
	 * @return the {@link Weave} instance
	 */
	public static final Weave of() {
		return new Weave();
	}

	/**
	 * Quickly create an instances of {@link Weave}
	 * 
	 * @apiNote (flags) first_field
	 * @param field the first field
	 * @return the {@link Weave} instance
	 * @see FirstField
	 */
	public static final Weave of( FirstField field ) {
		return new Weave().addValue( field );
	}

}
