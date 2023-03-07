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
 * Reorder pixels in video frames
 * 
 * @author tangxbai
 * @since 2022/08/04
 * @see <a href="https://ffmpeg.org/ffmpeg-filters.html#shufflepixels">ffmpeg-filters#shufflepixels</a>
 */
@Function( "shufflepixels" )
public class ShufflePlanes extends AbstractFunction<ShufflePlanes> {

	// Don't let anyone instantiate this class
	private ShufflePlanes() {}

	/**
	 * Quickly create an instances of {@link ShufflePlanes}
	 * 
	 * @return the {@link ShufflePlanes} instance
	 */
	public static final ShufflePlanes of() {
		return new ShufflePlanes();
	}

	/**
	 * The index of the input plane to be used as the first output plane. Value range is from 0 to 3, default
	 * is <b>0</b>.
	 * 
	 * @apiNote (int) map0
	 * @param value the first output plane
	 * @return the {@link ShufflePlanes} instance
	 */
	public ShufflePlanes map0( int value ) {
		return super.addArg( "map0", value );
	}

	/**
	 * The index of the input plane to be used as the second output plane. Value range is from 0 to 3, default
	 * is <b>0</b>.
	 * 
	 * @apiNote (int) map1
	 * @param value the second output plane
	 * @return the {@link ShufflePlanes} instance
	 */
	public ShufflePlanes map1( int value ) {
		return super.addArg( "map1", value );
	}

	/**
	 * The index of the input plane to be used as the third output plane. Value range is from 0 to 3, default
	 * is <b>0</b>.
	 * 
	 * @apiNote (int) map2
	 * @param value the third output plane
	 * @return the {@link ShufflePlanes} instance
	 */
	public ShufflePlanes map2( int value ) {
		return super.addArg( "map2", value );
	}

	/**
	 * The index of the input plane to be used as the third fourth plane. Value range is from 0 to 3, default
	 * is <b>0</b>.
	 * 
	 * @apiNote (int) map3
	 * @param value the fourth output plane
	 * @return the {@link ShufflePlanes} instance
	 */
	public ShufflePlanes map3( int value ) {
		return super.addArg( "map3", value );
	}

}
