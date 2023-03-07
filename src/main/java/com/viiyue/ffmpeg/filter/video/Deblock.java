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
import com.viiyue.ffmpeg.common.AbstractEnum;
import com.viiyue.ffmpeg.filter.AbstractFunction;
import com.viiyue.ffmpeg.util.Assert;

/**
 * Remove blocking artifacts from input video
 * 
 * @author tangxbai
 * @since 2022/06/24
 * @see <a href="https://ffmpeg.org/ffmpeg-filters.html#deblock">ffmpeg-filters#deblock</a>
 */
@Function( "deblock" )
public class Deblock extends AbstractFunction<Deblock> {

	// Don't let anyone instantiate this class
	private Deblock() {}

	/**
	 * Quickly create an instances of {@link Deblock}
	 * 
	 * @return the {@link Deblock} instance
	 */
	public static Deblock of() {
		return new Deblock();
	}

	/**
	 * Set filter type, can be {@link Level#WEAK} or {@link Level#STRONG}, default is {@link Level#STRONG}.
	 * This controls what kind of deblocking is applied.
	 * 
	 * @apiNote (flags) filter
	 * @param level the filter type level
	 * @return the {@link Deblock} instance
	 * @see Level
	 */
	public Deblock filter( Level level ) {
		return super.addArg( "filter", level );
	}

	/**
	 * Set size of block, allowed range is from 4 to 512, and default is <b>8</b>.
	 * 
	 * @apiNote (int) block
	 * @param size the block size
	 * @return the {@link Deblock} instance
	 */
	public Deblock block( int size ) {
		Assert.rangeCheck( size, 4, 512 );
		return super.addArg( "block", size );
	}

	/**
	 * Set blocking detection thresholds. Allowed range is 0 to 1, default is <b>0.098</b>. Using higher
	 * threshold gives more deblocking strength. Setting alpha controls threshold detection at exact edge of
	 * block. Remaining options controls threshold detection near the edge. Each one for below/above or
	 * left/right. Setting any of those to 0 disables deblocking.
	 * 
	 * @apiNote (double) alpha
	 * @param threshold the blocking detection threshold
	 * @return the {@link Deblock} instance
	 */
	public Deblock alpha( double threshold ) {
		Assert.rangeCheck( threshold, 4, 512 );
		return super.addArg( "alpha", threshold );
	}

	/**
	 * Set blocking detection thresholds. Allowed range is 0 to 1, default is <b>0.05</b>. Using higher
	 * threshold gives more deblocking strength. Setting alpha controls threshold detection at exact edge of
	 * block. Remaining options controls threshold detection near the edge. Each one for below/above or
	 * left/right. Setting any of those to 0 disables deblocking.
	 * 
	 * @apiNote (double) beta
	 * @param threshold the blocking detection threshold
	 * @return the {@link Deblock} instance
	 */
	public Deblock beta( double threshold ) {
		Assert.rangeCheck( threshold, 0, 1 );
		return super.addArg( "beta", threshold );
	}

	/**
	 * Set blocking detection thresholds. Allowed range is 0 to 1, default is <b>0.05</b>. Using higher
	 * threshold gives more deblocking strength. Setting alpha controls threshold detection at exact edge of
	 * block. Remaining options controls threshold detection near the edge. Each one for below/above or
	 * left/right. Setting any of those to 0 disables deblocking.
	 * 
	 * @param threshold the blocking detection threshold
	 * @return the {@link Deblock} instance
	 */
	public Deblock gamma( double threshold ) {
		Assert.rangeCheck( threshold, 0, 1 );
		return super.addArg( "gamma", threshold );
	}

	/**
	 * <p>
	 * Set blocking detection thresholds. Allowed range is 0 to 1, default is <b>0.05</b>. Using higher
	 * threshold gives more deblocking strength. Setting alpha controls threshold detection at exact edge of
	 * block.
	 * 
	 * <p>
	 * Remaining options controls threshold detection near the edge. Each one for below/above or left/right.
	 * Setting any of those to 0 disables deblocking.
	 * 
	 * @apiNote (double) delta
	 * @param threshold the blocking detection threshold
	 * @return the {@link Deblock} instance
	 */
	public Deblock delta( double threshold ) {
		Assert.rangeCheck( threshold, 0, 1 );
		return super.addArg( "delta", threshold );
	}

	/**
	 * Set planes to filter, default is to filter all available planes.
	 * 
	 * @apiNote (int) planes
	 * @param size the filter planes
	 * @return the {@link Deblock} instance
	 */
	public Deblock planes( int planes ) {
		Assert.rangeCheck( planes, 0, 15 );
		return super.addArg( "planes", planes );
	}

	/**
	 * Deblock filter type
	 *
	 * @author tangxbai
	 * @since 2022/06/24
	 */
	public enum Level implements AbstractEnum {
		WEAK, STRONG
	}

}
