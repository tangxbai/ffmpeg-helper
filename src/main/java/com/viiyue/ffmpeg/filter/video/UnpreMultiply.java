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
 * Apply alpha unpremultiply effect to input video stream using first plane of second stream as alpha. Both
 * streams must have same dimensions and same pixel format.
 * 
 * @author tangxbai
 * @since 2022/10/08
 * @see <a href="https://ffmpeg.org/ffmpeg-filters.html#unpremultiply">ffmpeg-filters#unpremultiply</a>
 */
@Function( "unpremultiply" )
public class UnpreMultiply extends AbstractFunction<UnpreMultiply> {

	// Don't let anyone instantiate this class
	private UnpreMultiply() {}

	/**
	 * Quickly create an instances of {@link UnpreMultiply}
	 * 
	 * @return the {@link UnpreMultiply} instance
	 */
	public static final UnpreMultiply of() {
		return new UnpreMultiply();
	}

	/**
	 * Set planes to filter. Value range allowed is from 0 to 15, default value is <b>15</b>, all planes will
	 * be processed.
	 * 
	 * @apiNote (int) planes
	 * @param value the plane filter
	 * @return the {@link UnpreMultiply} instance
	 */
	public UnpreMultiply planes( int value ) {
		Assert.rangeCheck( value, 0, 15 );
		return super.addArg( "planes", value );
	}

	/**
	 * Do not require 2nd input for processing, instead use alpha plane from input stream.
	 * 
	 * @apiNote (boolean) inplace
	 * @return the {@link UnpreMultiply} instance
	 */
	public UnpreMultiply inplace() {
		return super.enable( "inplace" );
	}

}
