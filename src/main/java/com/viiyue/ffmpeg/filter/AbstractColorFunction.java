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
package com.viiyue.ffmpeg.filter;

import com.viiyue.ffmpeg.enums.Color;

/**
 * Abstract color methods
 * 
 * @author tangxbai
 * @since 2022/06/02
 * @param <T> the current instance
 */
public abstract class AbstractColorFunction<T extends AbstractColorFunction<?>> extends AbstractFunction<T> {

	/**
	 * Specify the color of the box to write. For the general syntax of this option, check the
	 * (ffmpeg-utils)"Color" section in the ffmpeg-utils manual. If the special value invert is used, the box
	 * edge color is the same as the video with inverted luma.
	 * 
	 * @apiNote (color) color, c
	 * @param color the box color
	 * @return <T> the current instance
	 * @see Color
	 */
	public T color( Color color ) {
		return color( color, 0 );
	}

	/**
	 * Specify the color of the box to write. For the general syntax of this option, check the (ffmpeg-utils)
	 * "Color" section in the ffmpeg-utils manual. If the special value invert is used, the box edge color is
	 * the same as the video with inverted luma.
	 * 
	 * @apiNote (color) color, c
	 * @param color the box color
	 * @param alpha the alpha value
	 * @return <T> the current instance
	 * @see Color
	 */
	public T color( Color color, double alpha ) {
		return color( Color.nullable( color ).command(), alpha );
	}

	/**
	 * Specify the color of the box to write. For the general syntax of this option, check the (ffmpeg-utils)
	 * "Color" section in the ffmpeg-utils manual. If the special value invert is used, the box edge color is
	 * the same as the video with inverted luma.
	 * 
	 * @apiNote (color) color, c
	 * @param color the hex color
	 * @return <T> the current instance
	 */
	public T color( String color ) {
		return color( color, 0 );
	}

	/**
	 * Specify the color of the box to write. For the general syntax of this option, check the (ffmpeg-utils)
	 * "Color" section in the ffmpeg-utils manual. If the special value invert is used, the box edge color is
	 * the same as the video with inverted luma.
	 * 
	 * @apiNote (color) color, c
	 * @param color the hex color
	 * @param alpha the alpha value
	 * @return <T> the current instance
	 */
	public T color( String color, double alpha ) {
		return super.addArg( "color", alpha > 0 ? color + "@" + alpha : color );
	}

}
