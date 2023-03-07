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
import com.viiyue.ffmpeg.filter.AbstractColorFunction;

/**
 * Decompose a video made of tiled images into the individual images
 * 
 * @author tangxbai
 * @since 2022/10/09
 * @see <a href="https://ffmpeg.org/ffmpeg-filters.html#untile-1">ffmpeg-filters#untile</a>
 */
@Function( "untile" )
public class Untile extends AbstractColorFunction<Untile> {

	// Don't let anyone instantiate this class
	private Untile() {}

	/**
	 * <p>
	 * Quickly create an instances of {@link Untile}
	 * 
	 * <p>
	 * Set the grid size in the form COLUMNSxROWS. Range is up to {@link Integer#MAX_VALUE} cells. Default is
	 * 6x5.
	 * 
	 * @apiNote (size) layout
	 * @param h the grid columns
	 * @param n the grid rows
	 * @return the {@link Untile} instance
	 */
	public static final Untile the( int h, int n ) {
		return new Untile().addArg( null, h + "x" + n ); // layout
	}

}
