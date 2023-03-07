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
import com.viiyue.ffmpeg.enums.EofAction;
import com.viiyue.ffmpeg.util.Assert;

/**
 * Apply a 3D LUT to an input video
 * 
 * @author tangxbai
 * @since 2022/07/13
 * @see <a href= "https://ffmpeg.org/ffmpeg-filters.html#lut2_002c-tlut2">ffmpeg-filters#lut2</a>
 */
@Function( "lut2" )
public class Lut2 extends AbstractLut2<Lut2> {

	// Don't let anyone instantiate this class
	private Lut2() {}

	/**
	 * Quickly create an instances of {@link Lut2} and set the 1D LUT file name
	 * 
	 * @return the {@link Lut2} instance
	 */
	public static final Lut2 of() {
		return new Lut2();
	}

	/**
	 * Set output bit depth, only available for {@code lut2} filter. By default is <b>0</b>, which means bit
	 * depth is automatically picked from first input format.
	 * 
	 * @apiNote (int) d
	 * @param value the output bit depth value
	 * @return the {@link Lut2} instance
	 */
	public Lut2 depth( int value ) {
		Assert.rangeCheck( value, 0, 16 );
		return super.addArg( "d", value );
	}

	/**
	 * The action to take when EOF is encountered on the secondary input
	 * 
	 * @apiNote (flags) eof_action
	 * @param action the EOF action
	 * @return the {@link Lut2} instance
	 */
	public Lut2 action( EofAction action ) {
		return super.addArg( "eof_action", action );
	}

	/**
	 * If set to {@code true}, force the output to terminate when the shortest input terminates. default value
	 * is {@code false}.
	 * 
	 * @apiNote (boolean) shorttest
	 * @param state the shortest state
	 * @return the {@link Lut2} instance
	 */
	public Lut2 shortest( boolean state ) {
		return super.status( "shortest", state );
	}

	/**
	 * If set to true, force the filter to extend the last frame of secondary streams until the end of the
	 * primary stream.
	 * 
	 * @apiNote (boolean) repeatlast
	 * @param state the repeat last state
	 * @return the {@link Lut2} instance
	 */
	public Lut2 repeatLast( boolean state ) {
		return super.status( "repeatlast", state );
	}

}
