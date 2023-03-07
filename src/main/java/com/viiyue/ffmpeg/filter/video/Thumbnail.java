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
 * Select the most representative frame in a given sequence of consecutive frames
 * 
 * @author tangxbai
 * @since 2022/08/05
 * @see <a href="https://ffmpeg.org/ffmpeg-filters.html#thumbnail">ffmpeg-filters#thumbnail</a>
 */
@Function( "thumbnail" )
public class Thumbnail extends AbstractFunction<Thumbnail> {

	// Don't let anyone instantiate this class
	private Thumbnail() {}

	/**
	 * <p>
	 * Quickly create an instances of {@link Thumbnail}
	 * 
	 * <p>
	 * Set the frames batch size to analyze; in a set of n frames, the filter will pick one of them, and then
	 * handle the next batch of n frames until the end. Default is <b>100</b>.
	 * 
	 * @apiNote (int) n
	 * @param value the frames batch size
	 * @return the {@link Thumbnail} instance
	 */
	public static final Thumbnail of( int value ) {
		Assert.isTrue( value > 2, "Option value must greater than 1" );
		return new Thumbnail().addValue( value );
	}

}
