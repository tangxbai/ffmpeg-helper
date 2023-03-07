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
 * <p>
 * Determines blockiness of frames without altering the input frames.
 * 
 * <p>
 * Based on Remco Muijs and Ihor Kirenko: "A no-reference blocking artifact measure for adaptive video
 * processing." 2005 13th European signal processing conference.
 *
 * @author tangxbai
 * @since 2022/06/09
 * @see <a href="https://ffmpeg.org/ffmpeg-filters.html#blockdetect-1">ffmpeg-filters#blockdetect</a>
 */
@Function( "blockdetect" )
public class BlockDetect extends AbstractFunction<BlockDetect> {

	// Don't let anyone instantiate this class
	private BlockDetect() {}

	/**
	 * Quickly create an instances of {@link BlockDetect}
	 * 
	 * @return the {@link BlockDetect} instance
	 */
	public static final BlockDetect the() {
		return new BlockDetect();
	}

	/**
	 * Set minimum value for determining pixel grids (periods), default value is 3.
	 * 
	 * @apiNote (int) period_min
	 * @param pixel the minimum values
	 * @return the {@link BlockDetect} instance
	 */
	public BlockDetect periodMin( int pixel ) {
		return super.addArg( "period_min", pixel );
	}

	/**
	 * Set maximum value for determining pixel grids (periods), default value is 24.
	 * 
	 * @apiNote (int) period_max
	 * @param pixel the minimum values
	 * @return the {@link BlockDetect} instance
	 */
	public BlockDetect periodMax( int pixel ) {
		return super.addArg( "period_max", pixel );
	}

	/**
	 * Set planes to filter, default is first only.
	 * 
	 * @apiNote (int) planes
	 * @param plane the plane value
	 * @return the {@link BlockDetect} instance
	 */
	public BlockDetect planes( int plane ) {
		return super.addArg( "planes", plane );
	}

}
