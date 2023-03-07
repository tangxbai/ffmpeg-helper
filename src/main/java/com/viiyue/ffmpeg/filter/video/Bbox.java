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
 * <p>
 * Compute the bounding box for the non-black pixels in the input frame luminance plane.
 * 
 * <p>
 * This filter computes the bounding box containing all the pixels with a luminance value greater than the
 * minimum allowed value. The parameters describing the bounding box are printed on the filter log.
 *
 * @author tangxbai
 * @since 2022/06/09
 * @see <a href="https://ffmpeg.org/ffmpeg-filters.html#bbox">ffmpeg-filters#bbox</a>
 */
@Function( "bbox" )
public class Bbox extends AbstractFunction<Bbox> {

	// Don't let anyone instantiate this class
	private Bbox() {}

	/**
	 * Quickly create an instances of {@link Bbox}
	 * 
	 * @apiNote (int) min_val
	 * @param luminance the minimal luminance value, and the default is 16.
	 * @return the {@link Bbox} instance
	 */
	public static final Bbox luminance( int luminance ) {
		Assert.rangeCheck( luminance, 0, 65535 );
		return new Bbox().addArg( "min_val", luminance );
	}

}
