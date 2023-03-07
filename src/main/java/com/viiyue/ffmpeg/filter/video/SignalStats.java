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
import com.viiyue.ffmpeg.filter.AbstractColorFunction;

/**
 * Evaluate various visual metrics that assist in determining issues associated with the digitization of
 * analog video media
 * 
 * @author tangxbai
 * @since 2022/08/04
 * @see <a href="https://ffmpeg.org/ffmpeg-filters.html#signalstats">ffmpeg-filters#signalstats</a>
 */
@Function( "signalstats" )
public class SignalStats extends AbstractColorFunction<SignalStats> {

	// Don't let anyone instantiate this class
	private SignalStats() {}

	/**
	 * Quickly create an instances of {@link SignalStats}
	 * 
	 * @return the {@link SignalStats} instance
	 */
	public static final SignalStats of() {
		return new SignalStats();
	}

	/**
	 * stat specify an additional form of image analysis. out output video with the specified type of pixel
	 * highlighted.
	 * 
	 * @apiNote (int) stat
	 * @param statistics the statistics filters
	 * @return the {@link SignalStats} instance
	 */
	public SignalStats stat( Statistics statistics ) {
		return super.addArg( "stat", statistics );
	}

	/**
	 * stat specify an additional form of image analysis. out output video with the specified type of pixel
	 * highlighted.
	 * 
	 * @apiNote (int) stat
	 * @param statistics the statistics filters
	 * @return the {@link SignalStats} instance
	 */
	public SignalStats out( Statistics statistics ) {
		return super.addArg( "stat", statistics );
	}

	/**
	 * Statistics filters
	 *
	 * @author tangxbai
	 * @since 2022/08/04
	 */
	public enum Statistics implements AbstractEnum {
		/**
		 * Identify temporal outliers pixels. A temporal outlier is a pixel unlike the neighboring pixels of
		 * the same field. Examples of temporal outliers include the results of video dropouts, head clogs, or
		 * tape tracking issues.
		 */
		TOUT,
		/**
		 * Identify vertical line repetition. Vertical line repetition includes similar rows of pixels within
		 * a frame. In born-digital video vertical line repetition is common, but this pattern is uncommon in
		 * video digitized from an analog source. When it occurs in video that results from the digitization
		 * of an analog source it can indicate concealment from a dropout compensator.
		 */
		VREP,
		/**
		 * Identify pixels that fall outside of legal broadcast range
		 */
		BRNG
	}

}
