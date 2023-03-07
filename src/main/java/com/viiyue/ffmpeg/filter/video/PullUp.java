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

/**
 * <p>
 * Pulldown reversal (inverse telecine) filter, capable of handling mixed hard-telecine, 24000/1001 fps
 * progressive, and 30000/1001 fps progressive content.
 * 
 * <p>
 * The pullup filter is designed to take advantage of future context in making its decisions. This filter is
 * stateless in the sense that it does not lock onto a pattern to follow, but it instead looks forward to the
 * following fields in order to identify matches and rebuild progressive frames.
 * 
 * <p>
 * To produce content with an even framerate, insert the fps filter after pullup, use fps=24000/1001 if the
 * input frame rate is 29.97fps, fps=24 for 30fps and the (rare) telecined 25fps input.
 * 
 * @author tangxbai
 * @since 2022/07/22
 * @see <a href="https://ffmpeg.org/ffmpeg-filters.html#pullup-1">ffmpeg-filters#pullup</a>
 */
@Function( "pullup" )
public class PullUp extends AbstractFunction<PullUp> {

	// Don't let anyone instantiate this class
	private PullUp() {}

	/**
	 * Quickly create an instances of {@link PullUp}
	 * 
	 * @return the {@link PullUp} instance
	 */
	public static final PullUp of() {
		return new PullUp();
	}

	/**
	 * These options set the amount of "junk" to ignore at the left, right, top, and bottom of the image,
	 * respectively. Left and right are in units of 8 pixels, while top and bottom are in units of 2 lines.
	 * The default is 8 pixels on each side.
	 * 
	 * @apiNote (int) jl
	 * @apiNote (int) jr
	 * @apiNote (int) jt
	 * @apiNote (int) jb
	 * @param left   the left junk size
	 * @param right  the right junk size
	 * @param top    the top junk size
	 * @param bottom the bottom junk size
	 * @return the {@link PullUp} instance
	 */
	public PullUp junk( int left, int right, int top, int bottom ) {
		return super.addArg( "jl", left ).addArg( "jr", right ).addArg( "jt", top ).addArg( "jb", bottom );
	}

	/**
	 * Set the strict breaks. Setting this option to 1 will reduce the chances of filter generating an
	 * occasional mismatched frame, but it may also cause an excessive number of frames to be dropped during
	 * high motion sequences. Conversely, setting it to -1 will make filter match fields more easily. This may
	 * help processing of video where there is slight blurring between the fields, but may also cause there to
	 * be interlaced frames in the output. Default value is {@code false}.
	 * 
	 * @apiNote (boolean) sb
	 * @return the {@link PullUp} instance
	 */
	public PullUp strictBreaks() {
		return super.enable( "sb" );
	}

	/**
	 * <p>
	 * Set the metric plane to use
	 * 
	 * <p>
	 * This option may be set to use chroma plane instead of the default luma plane for doing filter’s
	 * computations. This may improve accuracy on very clean source material, but more likely will decrease
	 * accuracy, especially if there is chroma noise (rainbow effect) or any grayscale video. The main purpose
	 * of setting mp to a chroma plane is to reduce CPU load and make pullup usable in realtime on slow
	 * machines.
	 * 
	 * @apiNote (flags) mp
	 * @param plane the metric plane
	 * @return the {@link PullUp} instance
	 */
	public PullUp metricPlane( MetricPlane plane ) {
		return super.addArg( "mp", plane );
	}

	/**
	 * Metric plane
	 *
	 * @author tangxbai
	 * @since 2022/07/22
	 */
	public enum MetricPlane implements AbstractEnum {
		/** Use luma plane */
		L,
		/** Use chroma blue plane */
		U,
		/** Use chroma red plane */
		V
	}

}
