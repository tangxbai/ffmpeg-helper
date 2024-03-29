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
 * Overlay a solid color on the video stream.
 *
 * @author tangxbai
 * @since 2022/06/15
 * @see <a href="https://ffmpeg.org/ffmpeg-filters.html#colorize">ffmpeg-filters#colorize</a>
 */
@Function( "colorize" )
public class Colorize extends AbstractFunction<Colorize> {

	// Don't let anyone instantiate this class
	private Colorize() {}

	/**
	 * Quickly create an instances of {@link Colorize}
	 * 
	 * @return the {@link Colorize} instance
	 */
	public static final Colorize the() {
		return new Colorize();
	}

	/**
	 * Set the color hue, allowed range is from 0 to 360, and default value is <b>0</b>.
	 * 
	 * @apiNote (int) hue
	 * @param radius the radius value
	 * @return the {@link Colorize} instance
	 */
	public Colorize hue( int radius ) {
		Assert.rangeCheck( radius, 0, 360 );
		return super.addArg( "hue", radius );
	}

	/**
	 * Set the color lightness, allowed range is from 0 to 1, and default value is <b>0.5</b>.
	 * 
	 * @apiNote (double) hightness
	 * @param lightness the lightness value
	 * @return the {@link Colorize} instance
	 */
	public Colorize lightness( double lightness ) {
		Assert.rangeCheck( lightness, 0, 1 );
		return super.addArg( "lightness", lightness );
	}

	/**
	 * Set the mix of source lightness, by default is set to <b>1.0</b>, allowed range is from 0.0 to 1.0.
	 * 
	 * @apiNote (double) lightness
	 * @param lightness the radius value
	 * @return the {@link Colorize} instance
	 */
	public Colorize mix( double lightness ) {
		Assert.rangeCheck( lightness, 0, 1 );
		return super.addArg( "mix", lightness );
	}

}
