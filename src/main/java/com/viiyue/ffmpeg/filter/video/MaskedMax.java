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
import com.viiyue.ffmpeg.util.Assert;

/**
 * <p>
 * Merge the first input stream with the second input stream using per pixel weights in the third input
 * stream.
 * 
 * <p>
 * A value of 0 in the third stream pixel component means that pixel component from first stream is returned
 * unchanged, while maximum value (eg. 255 for 8-bit videos) means that pixel component from second stream is
 * returned unchanged. Intermediate values define the amount of merging between both input stream’s pixel
 * components.
 * 
 * @author tangxbai
 * @since 2022/07/13
 * @see <a href="https://ffmpeg.org/ffmpeg-filters.html#maskedmerge">ffmpeg-filters#maskedmerge</a>
 */
@Function( "maskedmerge" )
public class MaskedMax extends AbstractFunction<MaskedMax> {

	// Don't let anyone instantiate this class
	private MaskedMax() {}

	/**
	 * Quickly create an instances of {@link MaskedMax}
	 * 
	 * @return the {@link MaskedMax} instance
	 */
	public static final MaskedMax of() {
		return new MaskedMax();
	}

	/**
	 * Set which planes will be processed as bitmap, unprocessed planes will be copied from first stream. By
	 * default value 0xf, all planes will be processed. Value range allowed is from 0 to 15, default value is
	 * <b>15</b>, all planes will be processed.
	 * 
	 * @apiNote (int) planes
	 * @param value the plane filter
	 * @return the {@link MaskedMax} instance
	 */
	public MaskedMax planes( int value ) {
		Assert.rangeCheck( value, 0, 15 );
		return super.addArg( "planes", value );
	}

}
