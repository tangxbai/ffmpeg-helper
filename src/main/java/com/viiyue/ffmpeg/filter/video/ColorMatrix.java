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
import com.viiyue.ffmpeg.common.AbstractEnum;
import com.viiyue.ffmpeg.filter.AbstractFunction;
import com.viiyue.ffmpeg.util.Assert;

/**
 * Convert color matrix
 * 
 * @author tangxbai
 * @since 2022/06/15
 * @see <a href="https://ffmpeg.org/ffmpeg-filters.html#colormatrix">ffmpeg-filters#colormatrix</a>
 */
@Function( "colormatrix" )
public class ColorMatrix extends AbstractFunction<ColorMatrix> {

	// Don't let anyone instantiate this class
	private ColorMatrix() {}

	/**
	 * Quickly create an instances of {@link ColorMatrix}
	 * 
	 * @param src  the source color matrix
	 * @param dest the target color matrix
	 * @return the {@link ColorMatrix} instance
	 */
	public static final ColorMatrix define( TargetAtrix src, TargetAtrix dest ) {
		Assert.notNull( src, "The \"src\" value must be specified" );
		Assert.notNull( dest, "The \"dest\" value must be specified" );
		return new ColorMatrix().addValues( src, dest );
	}

	/**
	 * Color Matrix
	 *
	 * @author tangxbai
	 * @since 2022/06/16
	 */
	public enum TargetAtrix implements AbstractEnum {
		FCC,
		/** BT.470 */
		BT470,
		/** BT.601 */
		BT601,
		/** BT.709 */
		BT709,
		/** BT.2020 */
		BT2020,
		/** BT.470BG */
		BT470BG,
		/** SMPTE-170M */
		SMPTE170M,
		/** SMPTE-240M */
		SMPTE240M
	}

}
