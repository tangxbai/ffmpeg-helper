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
 * Upload system memory frames to a CUDA device
 *
 * @author tangxbai
 * @since 2022/07/11
 * @see <a href="https://ffmpeg.org/ffmpeg-filters.html#hwupload_cuda-1">ffmpeg-filters#hwupload_cuda</a>
 */
@Function( "hwupload_cuda" )
public class HwUploadCuda extends AbstractFunction<HwUploadCuda> {

	// Don't let anyone instantiate this class
	private HwUploadCuda() {}

	/**
	 * Quickly create an instances of {@link HwUploadCuda} and upload system memory frames to a CUDA device.
	 * 
	 * @apiNote (int) device
	 * @param value the number of the CUDA device to use
	 * @return the {@link HwUploadCuda} instance
	 */
	public static final HwUploadCuda device( int value ) {
		return new HwUploadCuda().addArg( "device", value );
	}

}
