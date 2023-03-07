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
 * Download hardware frames to system memory
 * 
 * <p>
 * The input must be in hardware frames, and the output a non-hardware format. Not all formats will be
 * supported on the output - it may be necessary to insert an additional format filter immediately following
 * in the graph to get the output in a supported format.
 *
 * @author tangxbai
 * @since 2022/07/11
 * @see <a href="https://ffmpeg.org/ffmpeg-filters.html#hwdownload-1">ffmpeg-filters#hwdownload</a>
 */
@Function( "hwdownload" )
public class HwDownload extends AbstractFunction<HwDownload> {

	// Don't let anyone instantiate this class
	private HwDownload() {}

}
