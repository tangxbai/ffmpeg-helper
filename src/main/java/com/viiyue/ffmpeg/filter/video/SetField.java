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
import com.viiyue.ffmpeg.enums.FieldMode;
import com.viiyue.ffmpeg.filter.AbstractFunction;

/**
 * <p>
 * Force field for the output video frame.
 * 
 * <p>
 * The {@code setfield} filter marks the interlace type field for the output frames. It does not change the
 * input frame, but only sets the corresponding property, which affects how the frame is treated by following
 * filters (e.g. {@code fieldorder} or {@code yadif}).
 * 
 * @author tangxbai
 * @since 2022/08/03
 * @see <a href="https://ffmpeg.org/ffmpeg-filters.html#setfield-1">ffmpeg-filters#setfield</a>
 */
@Function( "setfield" )
public class SetField extends AbstractFunction<SetField> {

	// Don't let anyone instantiate this class
	private SetField() {}

	/**
	 * Quickly create an instances of {@link SetField}
	 * 
	 * @apiNote (flags) mode
	 * @param mode the interlace mode
	 * @return the {@link SetField} instance
	 */
	public static final SetField of( FieldMode mode ) {
		return new SetField().addArg( "mode", mode );
	}

}
