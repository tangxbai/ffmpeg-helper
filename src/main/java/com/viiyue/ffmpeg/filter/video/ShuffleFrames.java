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
import com.viiyue.ffmpeg.util.Helper;

/**
 * Reorder and/or duplicate and/or drop video frames
 * 
 * @author tangxbai
 * @since 2022/08/04
 * @see <a href="https://ffmpeg.org/ffmpeg-filters.html#shuffleframes">ffmpeg-filters#shuffleframes</a>
 */
@Function( "shuffleframes" )
public class ShuffleFrames extends AbstractFunction<ShuffleFrames> {

	// Don't let anyone instantiate this class
	private ShuffleFrames() {}

	/**
	 * <p>
	 * Quickly create an instances of {@link ShuffleFrames}
	 * 
	 * <p>
	 * Set the destination indexes of input frames. This is space or '|' separated list of indexes that maps
	 * input frames to output frames. Number of indexes also sets maximal value that each index may have. '-1'
	 * index have special meaning and that is to drop frame.
	 * 
	 * <p>
	 * The first frame has the index 0. The default is to keep the input unchanged.
	 * 
	 * @apiNote (string) mapping
	 * @param expression the destination indexes expression
	 * @return the {@link ShuffleFrames} instance
	 */
	public static final ShuffleFrames mapping( String expression ) {
		return new ShuffleFrames().addArg( "mapping", expression );
	}

	/**
	 * <p>
	 * Quickly create an instances of {@link ShuffleFrames}
	 * 
	 * <p>
	 * Set the destination indexes of input frames. This is space or '|' separated list of indexes that maps
	 * input frames to output frames. Number of indexes also sets maximal value that each index may have. '-1'
	 * index have special meaning and that is to drop frame.
	 * 
	 * <p>
	 * The first frame has the index 0. The default is to keep the input unchanged.
	 * 
	 * @apiNote (string) mapping
	 * @param expression the destination indexes expression
	 * @return the {@link ShuffleFrames} instance
	 */
	public static final ShuffleFrames mapping( int ... indexs ) {
		return new ShuffleFrames().addArg( "mapping", Helper.expandAll( " ", indexs ) );
	}

}
