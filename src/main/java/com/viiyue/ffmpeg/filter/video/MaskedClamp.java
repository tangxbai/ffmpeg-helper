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
 * Clamp the first input stream with the second input and third input stream.
 * 
 * <p>
 * Returns the value of first stream to be between second input stream - {@code undershoot} and third input
 * stream + {@code overshoot}.
 * 
 * @author tangxbai
 * @since 2022/07/13
 * @see <a href="https://ffmpeg.org/ffmpeg-filters.html#maskedclamp">ffmpeg-filters#maskedclamp</a>
 */
@Function( "maskedclamp" )
public class MaskedClamp extends AbstractFunction<MaskedClamp> {

	// Don't let anyone instantiate this class
	private MaskedClamp() {}

	/**
	 * Quickly create an instances of {@link MaskedClamp}
	 * 
	 * @return the {@link MaskedClamp} instance
	 */
	public static final MaskedClamp of() {
		return new MaskedClamp();
	}

	/**
	 * Set the undershoot. Value range allowed is from 0 to 65535, default value is <b>0</b>.
	 * 
	 * @apiNote (int) undershoot
	 * @param value the undershoot value
	 * @return the {@link MaskedClamp} instance
	 */
	public MaskedClamp underShoot( int value ) {
		Assert.rangeCheck( value, 0, 65535 );
		return super.addArg( "undershoot", value );
	}

	/**
	 * Set the overshoot. Value range allowed is from 0 to 65535, default value is <b>0</b>.
	 * 
	 * @apiNote (int) overshoot
	 * @param value the overshoot value
	 * @return the {@link MaskedClamp} instance
	 */
	public MaskedClamp overShoot( int value ) {
		Assert.rangeCheck( value, 0, 65535 );
		return super.addArg( "undershoot", value );
	}

	/**
	 * Set which planes will be processed as bitmap, unprocessed planes will be copied from first stream.
	 * Value range allowed is from 0 to 15, default value is <b>15</b>, all planes will be processed.
	 * 
	 * @apiNote (int) planes
	 * @param value the plane filter
	 * @return the {@link MaskedClamp} instance
	 */
	public MaskedClamp planes( int value ) {
		Assert.rangeCheck( value, 0, 15 );
		return super.addArg( "planes", value );
	}

}
