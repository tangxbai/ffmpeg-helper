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
 * Apply dilation effect to the video, this filter replaces the pixel by the local(3x3) maximum.
 * 
 * @author tangxbai
 * @since 2022/06/27
 * @see <a href="https://ffmpeg.org/ffmpeg-filters.html#dilation">ffmpeg-filters#dilation</a>
 */
@Function( "dilation" )
public class Dilation extends AbstractFunction<Dilation> {

	// Don't let anyone instantiate this class
	private Dilation() {}

	/**
	 * Quickly create an instances of {@link Dilation}
	 * 
	 * @return the {@link Dilation} instance
	 */
	public static final Dilation of() {
		return new Dilation();
	}

	/**
	 * Limit the maximum change for 1st plane, default is <b>65535</b>. If 0, plane will remain unchanged.
	 * 
	 * @apiNote (int) threshold0
	 * @param threshold the threshold for 1st plane
	 * @return the {@link Dilation} instance
	 */
	public Dilation threshold0( int threshold ) {
		Assert.rangeCheck( threshold, 0, 65535 );
		return super.addArg( "threshold0", threshold );
	}

	/**
	 * Limit the maximum change for 2nd plane, default is <b>65535</b>. If 0, plane will remain unchanged.
	 * 
	 * @apiNote (int) threshold1
	 * @param threshold the threshold for 2nd plane
	 * @return the {@link Dilation} instance
	 */
	public Dilation threshold1( int threshold ) {
		Assert.rangeCheck( threshold, 0, 65535 );
		return super.addArg( "threshold1", threshold );
	}

	/**
	 * Limit the maximum change for 3rd plane, default is <b>65535</b>. If 0, plane will remain unchanged.
	 * 
	 * @apiNote (int) threshold2
	 * @param threshold the threshold for 3rd plane
	 * @return the {@link Dilation} instance
	 */
	public Dilation threshold2( int threshold ) {
		Assert.rangeCheck( threshold, 0, 65535 );
		return super.addArg( "threshold2", threshold );
	}

	/**
	 * Limit the maximum change for 4th plane, default is <b>65535</b>. If 0, plane will remain unchanged.
	 * 
	 * @apiNote (int) threshold3
	 * @param threshold the threshold for 4th plane
	 * @return the {@link Dilation} instance
	 */
	public Dilation threshold3( int threshold ) {
		Assert.rangeCheck( threshold, 0, 65535 );
		return super.addArg( "threshold3", threshold );
	}

	/**
	 * Flag which specifies the pixel to refer to, default is <b>255</b>.
	 * 
	 * @apiNote (int) coordinates
	 * @param threshold the threshold for 4th plane
	 * @return the {@link Dilation} instance
	 */
	public Dilation coordinates( int coordinates ) {
		Assert.rangeCheck( coordinates, 0, 255 );
		return super.addArg( "coordinates", coordinates );
	}

}
