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

/**
 * Apply Directional blur filter.
 *
 * @author tangxbai
 * @since 2022/06/022
 * @see <a href="https://ffmpeg.org/ffmpeg-filters.html#dblur">ffmpeg-filters#dblur</a>
 */
@Function( "dblur" )
public class Dblur extends AbstractFunction<Dblur> {

	// Don't let anyone instantiate this class
	private Dblur() {}

	/**
	 * Quickly create an instances of {@link DataScope}
	 * 
	 * @return the {@link DataScope} instance
	 */
	public static final Dblur the() {
		return new Dblur();
	}

	/**
	 * Set angle of directional blur, value range is from 0 to 360, default is <b>45</b>.
	 * 
	 * @apiNote (int) range
	 * @param angle the angle value
	 * @return the {@link Dblur} instance
	 */
	public Dblur angle( int angle ) {
		return super.addArg( "angle", angle );
	}

	/**
	 * Set radius of directional blur, default is <b>5</b>.
	 * 
	 * @apiNote (int) radius
	 * @param radius the radius
	 * @return the {@link Dblur} instance
	 */
	public Dblur radius( int radius ) {
		return super.addArg( "radius", radius );
	}

	/**
	 * Set which planes to filter, by default all planes are filtered.
	 * 
	 * @apiNote (int) planes
	 * @param planes the plans value
	 * @return the {@link Dblur} instance
	 */
	public Dblur planes( int planes ) {
		return super.addArg( "planes", planes );
	}

}
