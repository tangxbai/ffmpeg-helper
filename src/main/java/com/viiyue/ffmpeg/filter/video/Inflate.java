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
 * Apply inflate effect to the video, this filter replaces the pixel by the local(3x3) average by taking into
 * account only values higher than the pixel.
 *
 * @author tangxbai
 * @since 2022/07/11
 * @see <a href="https://ffmpeg.org/ffmpeg-filters.html#inflate">ffmpeg-filters#inflate</a>
 */
@Function( "inflate" )
public class Inflate extends AbstractFunction<Inflate> {

	// Don't let anyone instantiate this class
	private Inflate() {}

	/**
	 * Quickly create an instances of {@link Inflate}
	 * 
	 * @return the {@link Inflate} instance
	 */
	public static final Inflate of() {
		return new Inflate();
	}

	/**
	 * Limit the maximum change for 1st plane. Allowed value range is form 0 to 65535, default is
	 * <b>65535</b>. If 0, plane will remain unchanged.
	 * 
	 * @apiNote (double) threshold0
	 * @param value the plane threshold
	 * @return the {@link Inflate} instance
	 */
	public Inflate threshold0( double value ) {
		Assert.rangeCheck( value, 0, 65535 );
		return super.addArg( "threshold0", value );
	}

	/**
	 * Limit the maximum change for 2nd plane. Allowed value range is form 0 to 65535, default is
	 * <b>65535</b>. If 0, plane will remain unchanged.
	 * 
	 * @apiNote (double) threshold1
	 * @param value the plane threshold
	 * @return the {@link Inflate} instance
	 */
	public Inflate threshold1( double value ) {
		Assert.rangeCheck( value, 0, 65535 );
		return super.addArg( "threshold1", value );
	}

	/**
	 * Limit the maximum change for 3rd plane. Allowed value range is form 0 to 65535, default is
	 * <b>65535</b>. If 0, plane will remain unchanged.
	 * 
	 * @apiNote (double) threshold2
	 * @param value the plane threshold
	 * @return the {@link Inflate} instance
	 */
	public Inflate threshold2( double value ) {
		Assert.rangeCheck( value, 0, 65535 );
		return super.addArg( "threshold2", value );
	}

	/**
	 * Limit the maximum change for 4th plane. Allowed value range is form 0 to 65535, default is
	 * <b>65535</b>. If 0, plane will remain unchanged.
	 * 
	 * @apiNote (double) threshold3
	 * @param value the plane threshold
	 * @return the {@link Inflate} instance
	 */
	public Inflate threshold3( double value ) {
		Assert.rangeCheck( value, 0, 65535 );
		return super.addArg( "threshold3", value );
	}

}
