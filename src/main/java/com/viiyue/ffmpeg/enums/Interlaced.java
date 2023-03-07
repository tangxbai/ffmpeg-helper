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
 * The field scanning mode
 *
 * @author tangxbai
 * @since 2022/07/12
 */
public enum Interlaced implements AbstractEnum {
	/** Top field first: {@code tff} */
	@Alias( "tff" )
	TOP_FIELD_FIRST,

	/** Bottom field first: {@code bff} */
	@Alias( "bff" )
	BOTTOM_FIEL_FIRST
}
