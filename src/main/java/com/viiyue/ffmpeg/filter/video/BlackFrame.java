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
 * Detect frames that are (almost) completely black. Can be useful to detect chapter transitions or
 * commercials. Output lines consist of the frame number of the detected frame, the percentage of blackness,
 * the position in the file if known or -1 and the timestamp in seconds.
 * 
 * <p>
 * In order to display the output lines, you need to set the log level at least to the AV_LOG_INFO value.
 * 
 * <p>
 * This filter exports frame metadata lavfi.blackframe.pblack. The value represents the percentage of pixels
 * in the picture that are below the threshold value. specified.
 *
 * @author tangxbai
 * @since 2022/06/10
 * @see <a href="https://ffmpeg.org/ffmpeg-filters.html#blackframe">ffmpeg-filters#blackframe</a>
 */
@Function( "blackframe" )
public class BlackFrame extends AbstractFunction<BlackFrame> {

	// Don't let anyone instantiate this class
	private BlackFrame() {}

	/**
	 * Quickly create an instances of {@link BlackFrame}
	 * 
	 * @apiNote (double) amount
	 * @param percentage the black pixels percentage, the default is 98%.
	 * @return the {@link BlackFrame} instance
	 */
	public static final BlackFrame of( double percentage ) {
		return new BlackFrame().percentage( percentage );
	}

	/**
	 * The percentage of the pixels that have to be below the threshold, it defaults to <b>98</b>.
	 * 
	 * @apiNote (double) amount
	 * @param amount the black pixels percentage, the default is 98%.
	 * @return the {@link BlackFrame} instance
	 */
	private BlackFrame percentage( double percentage ) {
		Assert.rangeCheck( percentage, 0, 100 );
		return super.addArg( "amount", percentage );
	}

	/**
	 * The threshold below which a pixel value is considered black, it defaults to 32.
	 * 
	 * @apiNote (double) thresh
	 * @param value the black threshold, the default is 32.
	 * @return the {@link BlackFrame} instance
	 */
	public BlackFrame threshold( double threshold ) {
		Assert.rangeCheck( threshold, 0, 255 );
		return super.addArg( "thresh", threshold ); // threshold, thresh
	}

}
