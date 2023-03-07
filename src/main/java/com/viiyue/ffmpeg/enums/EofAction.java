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
 * Some filters with several inputs support a common set of options. These options can only be set by name,
 * not with the short notation.
 *
 * @author tangxbai
 * @since 2022/06/05
 */
public enum EofAction implements AbstractEnum {
	/** Repeat the last frame (the default) */
	REPEAT,
	/** End both streams */
	@Alias( "endall" )
	END_ALL,
	/** Pass the main input through */
	PASS
}
