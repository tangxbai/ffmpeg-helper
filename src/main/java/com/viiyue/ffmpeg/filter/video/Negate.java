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
import com.viiyue.ffmpeg.common.Const;
import com.viiyue.ffmpeg.enums.PlaneComponent;
import com.viiyue.ffmpeg.filter.AbstractFunction;

/**
 * Negate (invert) the input video
 * 
 * @author tangxbai
 * @since 2022/07/19
 * @see <a href="https://ffmpeg.org/ffmpeg-filters.html#negate">ffmpeg-filters#negate</a>
 */
@Function( "negate" )
public class Negate extends AbstractFunction<Negate> {

	// Don't let anyone instantiate this class
	private Negate() {}

	/**
	 * Quickly create an instances of {@link Negate}
	 * 
	 * @return the {@link Negate} instance
	 */
	public static final Negate of() {
		return new Negate();
	}

	/**
	 * Set the scale applied to second video stream. Allowed range is from 0 to 9, default is <b>1</b>.
	 * 
	 * @apiNote (int) components
	 * @param components the single target component
	 * @return the {@link Negate} instance
	 * @see PlaneComponent
	 */
	public Negate components( PlaneComponent ... components ) {
		return super.addArg2( "components", Const.APPEND_SEPARATOR, components );
	}

	/**
	 * With value {@code true}, it negates the alpha component, if present. Default value is {@code false}.
	 * 
	 * @apiNote (boolean) negate_alpha
	 * @return the {@link Negate} instance
	 */
	public Negate negateAlpha() {
		return super.enable( "negate_alpha" );
	}

}
