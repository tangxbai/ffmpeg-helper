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
package com.viiyue.ffmpeg.enums;

import com.viiyue.ffmpeg.annotation.Alias;
import com.viiyue.ffmpeg.common.AbstractEnum;

/**
 * Interlace mode
 *
 * @author tangxbai
 * @since 2022/08/03
 */
public enum FieldMode implements AbstractEnum {
	/** Keep the same field property */
	AUTO,

	/** Mark the frame as top-field-first */
	@Alias( "tff" )
	TOP_FIELD_FIRST,

	/** Mark the frame as bottom-field-first */
	@Alias( "bff" )
	BOTTOM_FIEL_FIRST,

	/** Mark the frame as progressive */
	@Alias( "prog" )
	PROGRESSIVE
}
