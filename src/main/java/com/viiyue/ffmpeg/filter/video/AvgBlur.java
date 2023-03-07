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
 * Apply average blur filter
 *
 * @author tangxbai
 * @since 2022/06/02
 * @see <a href="https://ffmpeg.org/ffmpeg-filters.html#avgblur">ffmpeg-filters#avgblur</a>
 */
@Function( "avgblur" )
public class AvgBlur extends AbstractFunction<AvgBlur> {

	// Don't let anyone instantiate this class
	private AvgBlur() {}

	/**
	 * Quickly create an instances of {@link AvgBlur}
	 * 
	 * @return the {@link AvgBlur} instance
	 */
	public static final AvgBlur the() {
		return new AvgBlur();
	}

	/**
	 * Set radius size
	 * 
	 * @apiNote (int) sizeX, (int) sizeY
	 * @param radius the horizontal and vertical radius size
	 * @return the {@link AvgBlur} instance
	 */
	public AvgBlur size( int radius ) {
		return size( radius, radius );
	}

	/**
	 * Set radius size
	 * 
	 * @param radiusX the horizontal radius size
	 * @param radiusY the vertical radius size
	 * @return the {@link AvgBlur} instance
	 */
	public AvgBlur size( int radiusX, int radiusY ) {
		Assert.rangeCheck( radiusX, 1, 1024 );
		Assert.rangeCheck( radiusY, 0, 1024 );
		return super.addArg( "sizeX", radiusX ).addArg( "sizeY", radiusY );
	}

	/**
	 * Set which planes to filter. By default all planes are filtered, default is <b>15</b>.
	 * 
	 * @apiNote (int) planes
	 * @param planes the planes value
	 * @return the {@link AvgBlur} instance
	 */
	public AvgBlur planes( int planes ) {
		Assert.rangeCheck( planes, 0, 15 );
		return super.addArg( "planes", planes );
	}

}
