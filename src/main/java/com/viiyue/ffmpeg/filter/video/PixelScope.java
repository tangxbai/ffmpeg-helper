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
 * Display sample values of color channels. Mainly useful for checking color and levels. Minimum supported
 * resolution is 640x480.
 * 
 * @author tangxbai
 * @since 2022/07/20
 * @see <a href="https://ffmpeg.org/ffmpeg-filters.html#pixscope">ffmpeg-filters#pixscope</a>
 */
@Function( "pixscope" )
public class PixelScope extends AbstractFunction<PixelScope> {

	// Don't let anyone instantiate this class
	private PixelScope() {}

	/**
	 * Quickly create an instances of {@link PixelScope}
	 * 
	 * @return the {@link PixelScope} instance
	 */
	public static final PixelScope of() {
		return new PixelScope();
	}

	/**
	 * Set scope width and height. Value range is [1,80], default value is <b>7</b>.
	 * 
	 * @apiNote (int) w
	 * @apiNote (int) h
	 * @param width  the scope width
	 * @param height the scope height
	 * @return the {@link PixelScope} instance
	 */
	public PixelScope size( int width, int height ) {
		Assert.rangeCheck( width, 1, 80 );
		Assert.rangeCheck( height, 1, 80 );
		return super.addArg( "w", width ).addArg( "h", height );
	}

	/**
	 * Set scope X and Y position, relative offset on X/Y axis. Value range is [0.0,1.0], default value is
	 * <b>0.5</b>.
	 * 
	 * @apiNote (double) x
	 * @apiNote (double) y
	 * @param x the scope X position
	 * @param y the scope Y position
	 * @return the {@link PixelScope} instance
	 */
	public PixelScope position( double x, double y ) {
		Assert.rangeCheck( x, 0.0, 1.0 );
		Assert.rangeCheck( y, 0.0, 1.0 );
		return super.addArg( "x", x ).addArg( "y", y );
	}

	/**
	 * Set window opacity, this window also holds statistics about pixel area. Value range is [0.0,1.0],
	 * default value is <b>0.5</b>.
	 * 
	 * @apiNote (double) o
	 * @param value the window opacity
	 * @return the {@link PixelScope} instance
	 */
	public PixelScope opacity( double value ) {
		Assert.rangeCheck( value, 0.0, 1.0 );
		return super.addArg( "o", value );
	}

	/**
	 * Set window X and Y position, relative offset on X/Y axis. Value range is [-1.0,1.0], default value is
	 * <b>-1.0</b>.
	 * 
	 * @apiNote (double) wx
	 * @apiNote (double) wy
	 * @param x the window x offset
	 * @param y the window y offset
	 * @return the {@link PixelScope} instance
	 */
	public PixelScope winPosition( double x, double y ) {
		Assert.rangeCheck( x, -1.0, 1.0 );
		Assert.rangeCheck( y, -1.0, 1.0 );
		return super.addArg( "wx", x ).addArg( "wy", y );
	}

}
