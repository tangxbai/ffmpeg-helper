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
 * Turn certain luma values into transparency
 * 
 * @author tangxbai
 * @since 2022/07/13
 * @see <a href="https://ffmpeg.org/ffmpeg-filters.html#lumakey">ffmpeg-filters#lumakey</a>
 */
@Function( "lumakey" )
public class LumaKey extends AbstractFunction<LumaKey> {

	// Don't let anyone instantiate this class
	private LumaKey() {}

	/**
	 * Quickly create an instances of {@link LumaKey}
	 * 
	 * @return the {@link LumaKey} instance
	 */
	public static final LumaKey of() {
		return new LumaKey();
	}

	/**
	 * Set the luma which will be used as base for transparency. Default value is <b>0</b>.
	 * 
	 * @apiNote (double) threshold
	 * @param value the threshold value
	 * @return the {@link LumaKey} instance
	 */
	public LumaKey threshold( double value ) {
		Assert.rangeCheck( value, 0.0, 1.0 );
		return super.addArg( "threshold", value );
	}

	/**
	 * Set the range of luma values to be keyed out. Default value is <b>0.01</b>.
	 * 
	 * @apiNote (double) tolerance
	 * @param value the tolerance value
	 * @return the {@link LumaKey} instance
	 */
	public LumaKey tolerance( double value ) {
		Assert.rangeCheck( value, 0.0, 1.0 );
		return super.addArg( "tolerance", value );
	}

	/**
	 * Set the range of softness. Default value is <b>0</b>. Use this to control gradual transition from zero
	 * to full transparency.
	 * 
	 * @apiNote (double) softness
	 * @param value the softness value
	 * @return the {@link LumaKey} instance
	 */
	public LumaKey softness( double value ) {
		Assert.rangeCheck( value, 0.0, 1.0 );
		return super.addArg( "softness", value );
	}

}
