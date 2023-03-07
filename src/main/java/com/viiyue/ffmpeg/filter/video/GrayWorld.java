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
 * A color constancy filter that applies color correction based on the grayworld assumption
 * 
 * <p>
 * See: <a href=
 * "https://www.researchgate.net/publication/275213614_A_New_Color_Correction_Method_for_Underwater_Imaging">
 * https://www.researchgate.net/publication/275213614_A_New_Color_Correction_Method_for_Underwater_Imaging
 * </a>
 * 
 * <p>
 * The algorithm uses linear light, so input data should be linearized beforehand (and possibly correctly
 * tagged).
 *
 * @author tangxbai
 * @since 2022/07/11
 * @see <a href="https://ffmpeg.org/ffmpeg-filters.html#grayworld">ffmpeg-filters#grayworld</a>
 */
@Function( "grayworld" )
public class GrayWorld extends AbstractFunction<GrayWorld> {

	// Don't let anyone instantiate this class
	private GrayWorld() {}

}
