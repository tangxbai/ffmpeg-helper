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
 * Scroll input video horizontally and/or vertically by constant speed
 * 
 * @author tangxbai
 * @since 2022/08/03
 * @see <a href="https://ffmpeg.org/ffmpeg-filters.html#scroll">ffmpeg-filters#scroll</a>
 */
@Function( "scroll" )
public class Scroll extends AbstractFunction<Scroll> {

	// Don't let anyone instantiate this class
	private Scroll() {}

	/**
	 * Quickly create an instances of {@link Scroll}
	 * 
	 * @return the {@link Scroll} instance
	 */
	public static final Scroll of() {
		return new Scroll();
	}

	/**
	 * Set the horizontal scrolling speed. Allowed range is from -1 to 1, default value is <b>0</b>. Negative
	 * values changes scrolling direction.
	 * 
	 * @apiNote (int) horizontal, h
	 * @param value the horizontal scrolling speed
	 * @return the {@link Scroll} instance
	 */
	public Scroll horizontal( double value ) {
		Assert.rangeCheck( value, -1.0, 1.0 );
		return super.addArg( "h", value ); // horizontal, h
	}

	/**
	 * Set the vertical scrolling speed. Allowed range is from -1 to 1, default value is <b>0</b>. Negative
	 * values changes scrolling direction.
	 * 
	 * @apiNote (int) vertical, v
	 * @param value the vertical scrolling speed
	 * @return the {@link Scroll} instance
	 */
	public Scroll vertical( double value ) {
		Assert.rangeCheck( value, -1.0, 1.0 );
		return super.addArg( "v", value ); // vertical, v
	}

	/**
	 * Set the initial horizontal scrolling position. Allowed range is from 0 to 1, default value is <b>0</b>.
	 * Negative values changes scrolling direction.
	 * 
	 * @apiNote (int) hpos
	 * @param value the initial horizontal scrolling position
	 * @return the {@link Scroll} instance
	 */
	public Scroll hPosition( double value ) {
		Assert.rangeCheck( value, 0.0, 1.0 );
		return super.addArg( "hpos", value );
	}

	/**
	 * Set the vertical horizontal scrolling position. Allowed range is from 0 to 1, default value is
	 * <b>0</b>. Negative values changes scrolling direction.
	 * 
	 * @apiNote (int) vpos
	 * @param value the initial vertical scrolling position
	 * @return the {@link Scroll} instance
	 */
	public Scroll vPosition( double value ) {
		Assert.rangeCheck( value, 0.0, 1.0 );
		return super.addArg( "vpos", value );
	}

}
