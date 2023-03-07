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
 * Create mask from input video
 * 
 * <p>
 * For example it is useful to create motion masks after {@code tblend} filter.
 * 
 * @author tangxbai
 * @since 2022/07/18
 * @see <a href="https://ffmpeg.org/ffmpeg-filters.html#maskfun">ffmpeg-filters#maskfun</a>
 */
@Function( "maskfun" )
public class MaskFun extends AbstractFunction<MaskFun> {

	// Don't let anyone instantiate this class
	private MaskFun() {}

	/**
	 * Quickly create an instances of {@link MaskFun}
	 * 
	 * @return the {@link MaskFun} instance
	 */
	public static final MaskFun of() {
		return new MaskFun();
	}

	/**
	 * Set low threshold. Any pixel component lower or exact than this value will be set to 0. Value range
	 * allowed is from 0 to 65535, default value is <b>10</b>.
	 * 
	 * @apiNote (int) low
	 * @param value the low threshold value
	 * @return the {@link MaskFun} instance
	 */
	public MaskFun low( int value ) {
		Assert.rangeCheck( value, 0, 65535 );
		return super.addArg( "low", value );
	}

	/**
	 * Set high threshold. Any pixel component higher than this value will be set to max value allowed for
	 * current pixel format. Value range allowed is from 0 to 65535, default value is <b>10</b>.
	 * 
	 * @apiNote (int) high
	 * @param value the high threshold value
	 * @return the {@link MaskFun} instance
	 */
	public MaskFun high( int value ) {
		Assert.rangeCheck( value, 0, 65535 );
		return super.addArg( "high", value );
	}

	/**
	 * Set planes to filter. Value range allowed is from 0 to 15, default value is <b>15</b>, all planes will
	 * be processed.
	 * 
	 * @apiNote (int) planes
	 * @param value the plane filter
	 * @return the {@link MaskFun} instance
	 */
	public MaskFun planes( int value ) {
		Assert.rangeCheck( value, 0, 15 );
		return super.addArg( "planes", value );
	}

	/**
	 * Set threshold used when picking pixels from absolute difference from two input video streams. Value
	 * range allowed is from 0 to 65535, default value is <b>10</b>.
	 * 
	 * @apiNote (int) sum
	 * @param value the threshold value
	 * @return the {@link MaskFun} instance
	 */
	public MaskFun sum( int value ) {
		Assert.rangeCheck( value, 0, 65535 );
		return super.addArg( "sum", value );
	}

}
