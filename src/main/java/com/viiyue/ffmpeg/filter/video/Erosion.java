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
 * Apply erosion effect to the video.
 * 
 * <p>
 * This filter replaces the pixel by the local(3x3) minimum.
 * 
 * @author tangxbai
 * @since 2022/06/30
 * @see <a href="https://ffmpeg.org/ffmpeg-filters.html#erosion">ffmpeg-filters#erosion</a>
 */
@Function( "erosion" )
public class Erosion extends AbstractFunction<Erosion> {

	// Don't let anyone instantiate this class
	private Erosion() {}

	/**
	 * Quickly create an instances of {@link Erosion}
	 * 
	 * @return the {@link Erosion} instance
	 */
	public static final Erosion of() {
		return new Erosion();
	}

	/**
	 * Limit the maximum change for 1st plane, default is 65535. If 0, plane will remain unchanged. Default is
	 * <b>65535</b>.
	 * 
	 * @apiNote (int) threshold0
	 * @param value the threshold for 1st plane
	 * @return the {@link Erosion} instance
	 */
	public Erosion threshold0( int value ) {
		Assert.rangeCheck( value, 0, 65535 );
		return super.addArg( "threshold0", value );
	}

	/**
	 * Limit the maximum change for 2nd plane, default is 65535. If 0, plane will remain unchanged. Default is
	 * <b>65535</b>.
	 * 
	 * @apiNote (int) threshold1
	 * @param value the threshold for 2nd plane
	 * @return the {@link Erosion} instance
	 */
	public Erosion threshold1( int value ) {
		Assert.rangeCheck( value, 0, 65535 );
		return super.addArg( "threshold1", value );
	}

	/**
	 * Limit the maximum change for 3rd plane, default is 65535. If 0, plane will remain unchanged. Default is
	 * <b>65535</b>.
	 * 
	 * @apiNote (int) threshold2
	 * @param value the threshold for 3rd plane
	 * @return the {@link Erosion} instance
	 */
	public Erosion threshold2( int value ) {
		Assert.rangeCheck( value, 0, 65535 );
		return super.addArg( "threshold2", value );
	}

	/**
	 * Limit the maximum change for 4th plane, default is 65535. If 0, plane will remain unchanged. Default is
	 * <b>65535</b>.
	 * 
	 * @apiNote (int) threshold3
	 * @param value the threshold for 4th plane
	 * @return the {@link Erosion} instance
	 */
	public Erosion threshold3( int value ) {
		Assert.rangeCheck( value, 0, 65535 );
		return super.addArg( "threshold3", value );
	}

	/**
	 * Flag which specifies the pixel to refer to(i.e. all eight pixels are used). Default value is
	 * <b>255</b>.
	 * 
	 * @apiNote (int) coordinates
	 * @param value the pixel coordinates
	 * @return the {@link Erosion} instance
	 */
	public Erosion coordinates( int value ) {
		Assert.rangeCheck( value, 0, 255 );
		return super.addArg( "coordinates", value );
	}

}
