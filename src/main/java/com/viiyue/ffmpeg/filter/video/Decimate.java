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
 * Drop duplicated frames at regular intervals
 * 
 * @author tangxbai
 * @since 2022/06/24
 * @see <a href="https://ffmpeg.org/ffmpeg-filters.html#decimate">ffmpeg-filters#decimate</a>
 */
@Function( "decimate" )
public class Decimate extends AbstractFunction<Decimate> {

	// Don't let anyone instantiate this class
	private Decimate() {}

	/**
	 * Quickly create an instances of {@link Decimate}
	 * 
	 * @return the {@link Decimate} instance
	 */
	public static final Decimate of() {
		return new Decimate();
	}

	/**
	 * Set the number of frames from which one will be dropped. Setting this to N means one frame in every
	 * batch of N frames will be dropped, the default is <b>5</b>.
	 * 
	 * @apiNote (int) cycle
	 * @param frames the number of frames
	 * @return the {@link Decimate} instance
	 */
	public Decimate cycle( int frames ) {
		Assert.rangeCheck( frames, 2, 25 );
		return super.addArg( "cycle", frames );
	}

	/**
	 * Set the threshold for duplicate detection. If the difference metric for a frame is less than or equal
	 * to this value, then it is declared as duplicate, default is <b>1.1</b>.
	 * 
	 * @apiNote (double) dupthresh
	 * @param threshold the scene change threshold
	 * @return the {@link Decimate} instance
	 */
	public Decimate duplicateThreshold( double threshold ) {
		Assert.rangeCheck( threshold, 0, 100 );
		return super.addArg( "dupthresh", threshold );
	}

	/**
	 * Set scene change threshold
	 * 
	 * @apiNote (double) scthresh
	 * @param threshold the scene change threshold
	 * @return the {@link Decimate} instance
	 */
	public Decimate sceneChangeThreshold( double threshold ) {
		Assert.rangeCheck( threshold, 0, 100 );
		return super.addArg( "scthresh", threshold );
	}

	/**
	 * Set the size of the x and y-axis blocks used during metric calculations. Larger blocks give better
	 * noise suppression, but also give worse detection of small movements. Must be a power of two, default is
	 * <b>32</b>.
	 * 
	 * @apiNote (double) blockx/blocky
	 * @param x the blockX value
	 * @param y the blockY value
	 * @return the {@link Decimate} instance
	 */
	public Decimate blocks( int x, int y ) {
		Assert.rangeCheck( x, 4, 512 );
		Assert.rangeCheck( y, 4, 512 );
		return super.addArg( "blockx", x ).addArg( "blocky", y );
	}

	/**
	 * Mark main input as a pre-processed input and activate clean source input stream. This allows the input
	 * to be pre-processed with various filters to help the metrics calculation while keeping the frame
	 * selection lossless. When set to {@code true}, the first stream is for the pre-processed input, and the
	 * second stream is the clean source from where the kept frames are chosen, default is <b>false</b>.
	 * 
	 * @apiNote (boolean) ppsrc
	 * @return the {@link Decimate} instance
	 */
	public Decimate ppsrc() {
		return super.enable( "ppsrc" );
	}

	/**
	 * Set whether or not chroma is considered in the metric calculations, default is {@code true}.
	 * 
	 * @apiNote (boolean) chroma
	 * @return the {@link Decimate} instance
	 */
	public Decimate noChromaticity() {
		return super.disable( "chroma" );
	}

}
