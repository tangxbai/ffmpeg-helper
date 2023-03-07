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
import com.viiyue.ffmpeg.filter.AbstractFunction;
import com.viiyue.ffmpeg.util.Assert;

/**
 * Apply variable blur filter by using 2nd video stream to set blur radius. The 2nd stream must have the same
 * dimensions
 * 
 * @author tangxbai
 * @since 2022/10/11
 * @see <a href="https://ffmpeg.org/ffmpeg-filters.html#varblur">ffmpeg-filters#varblur</a>
 */
@Function( "varblur" )
public class VarBlur extends AbstractFunction<VarBlur> {

	// Don't let anyone instantiate this class
	private VarBlur() {}

	/**
	 * Quickly create an instances of {@link VarBlur}
	 * 
	 * @return the {@link VarBlur} instance
	 */
	public static final VarBlur of() {
		return new VarBlur();
	}

	/**
	 * Set min allowed radius. Allowed range is from 0 to 254, default is <b>0</b>.
	 * 
	 * @apiNote (int) min_r
	 * @param value the min blur radius
	 * @return the {@link VarBlur} instance
	 */
	public VarBlur minRadius( int value ) {
		Assert.rangeCheck( value, 0, 254 );
		return super.addArg( "min_r", value );
	}

	/**
	 * Set max allowed radius. Allowed range is from 1 to 255, default is <b>8</b>.
	 * 
	 * @apiNote (int) max_r
	 * @param value the max blur radius
	 * @return the {@link VarBlur} instance
	 */
	public VarBlur maxRadius( int value ) {
		Assert.rangeCheck( value, 1, 255 );
		return super.addArg( "max_r", value );
	}

	/**
	 * Set which planes to filter, default is <b>15</b>.
	 * 
	 * @apiNote (int) planes
	 * @param value the what planes to filter
	 * @return the {@link VarBlur} instance
	 */
	public VarBlur planes( int value ) {
		Assert.rangeCheck( value, 0, 15 );
		return super.addArg( "planes", value );
	}

	/**
	 * The action to take when EOF is encountered on the secondary input
	 * 
	 * @apiNote (flags) eof_action
	 * @param action the EOF action
	 * @return the {@link VarBlur} instance
	 * @see EofAction
	 */
	public VarBlur action( EofAction action ) {
		return super.addArg( "eof_action", action );
	}

	/**
	 * If set to true, force the output to terminate when the shortest input terminates. default value is
	 * false.
	 * 
	 * @apiNote (boolean) shortest
	 * @param state the shortest state
	 * @return the {@link VarBlur} instance
	 */
	public VarBlur shortest( boolean state ) {
		return super.status( "shortest", state );
	}

	/**
	 * If set to true, force the filter to extend the last frame of secondary streams until the end of the
	 * primary stream. A value of 0 disables this behavior, default value is false.
	 * 
	 * @apiNote (boolean) repeatlast
	 * @param state the repeat last state
	 * @return the {@link VarBlur} instance
	 */
	public VarBlur repeatLast( boolean state ) {
		return super.status( "repeatlast", state );
	}

}
