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
 * This option itemizes a range of choices from veryfast (best speed) to veryslow (best quality).
 *
 * @author tangxbai
 * @since 2023/03/17
 */
public enum Preset implements AbstractEnum {
	ULTRAFAST,
	SUPERFAST,
	@Alias( "veryfast" )
	VERY_FAST, 
	FASTER, 
	FAST, 
	MEDIUM, 
	SLOW, 
	SLOWER, 
	@Alias( "veryslow" )
	VERY_SLOW,
	PLACEBO
}
