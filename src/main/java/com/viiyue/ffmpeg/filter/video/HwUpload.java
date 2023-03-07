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
 * Upload system memory frames to hardware surfaces.
 * 
 * <p>
 * The device to upload to must be supplied when the filter is initialised. If using ffmpeg, select the
 * appropriate device with the -filter_hw_device option or with the derive_device option. The input and output
 * devices must be of different types and compatible - the exact meaning of this is system-dependent, but
 * typically it means that they must refer to the same underlying hardware context (for example, refer to the
 * same graphics card).
 *
 * @author tangxbai
 * @since 2022/07/11
 * @see <a href="https://ffmpeg.org/ffmpeg-filters.html#hwupload-1">ffmpeg-filters#hwupload</a>
 */
@Function( "hwupload" )
public class HwUpload extends AbstractFunction<HwUpload> {

	// Don't let anyone instantiate this class
	private HwUpload() {}

	/**
	 * Quickly create an instances of {@link HwUpload}
	 * 
	 * <p>
	 * Rather than using the device supplied at initialisation, instead derive a new device of type type from
	 * the device the input frames exist on.
	 * 
	 * @apiNote (string) derive_device
	 * @param value the new device of this type
	 * @return the {@link HwUpload} instance
	 */
	public static final HwUpload of( String type ) {
		return new HwUpload().addArg( "derive_device", type );
	}

}
