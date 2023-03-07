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
 * Displace pixels as indicated by second and third input stream.
 * 
 * <p>
 * It takes three input streams and outputs one stream, the first input is the source, and second and third
 * input are displacement maps.
 * 
 * <p>
 * The second input specifies how much to displace pixels along the x-axis, while the third input specifies
 * how much to displace pixels along the y-axis. If one of displacement map streams terminates, last frame
 * from that displacement map will be used.
 * 
 * <p>
 * Note that once generated, displacements maps can be reused over and over again.
 * 
 * @author tangxbai
 * @since 2022/06/27
 * @see <a href="https://ffmpeg.org/ffmpeg-filters.html#displace">ffmpeg-filters#displace</a>
 */
@Function( "displace" )
public class Displace extends AbstractFunction<Displace> {

	// Don't let anyone instantiate this class
	private Displace() {}

	/**
	 * Quickly create an instances of {@link Displace}
	 * 
	 * @apiNote (flags) edge
	 * @return the {@link Displace} instance
	 * @see EdgeMode
	 */
	public static final Displace edge( EdgeMode mode ) {
		return new Displace().addArg( "edge", mode );
	}

	/**
	 * Edge mode, including: {@link #BLANK}, {@link #SMEAR}, {@link #WRAP}, {@link #MIRROR}.
	 *
	 * @author tangxbai
	 * @since 2022/06/27
	 */
	public enum EdgeMode implements AbstractEnum {
		/** Missing pixels are replaced by black pixels */
		BLANK,
		/** Adjacent pixels will spread out to replace missing pixels */
		SMEAR,
		/** Out of range pixels are wrapped so they point to pixels of other side */
		WRAP,
		/** Out of range pixels will be replaced with mirrored pixels */
		MIRROR
	}

}
