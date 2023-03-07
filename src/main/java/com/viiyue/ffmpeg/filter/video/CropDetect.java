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
 * Auto-detect the crop size.
 * 
 * <p>
 * It calculates the necessary cropping parameters and prints the recommended parameters via the logging
 * system. The detected dimensions correspond to the non-black area of the input video.
 * 
 * @author tangxbai
 * @since 2022/06/17
 * @see <a href="https://ffmpeg.org/ffmpeg-filters.html#cropdetect">ffmpeg-filters#cropdetect</a>
 */
@Function( "cropdetect" )
public class CropDetect extends AbstractFunction<CropDetect> {

	// Don't let anyone instantiate this class
	private CropDetect() {}

	/**
	 * Quickly create an instances of {@link CropDetect}
	 * 
	 * @return the {@link CropDetect} instance
	 */
	public static final CropDetect the() {
		return new CropDetect();
	}

	/**
	 * Set higher black value threshold, which can be optionally specified from nothing (0) to everything (255
	 * for 8-bit based formats). An intensity value greater to the set value is considered non-black. It
	 * defaults to 24. You can also specify a value between 0.0 and 1.0 which will be scaled depending on the
	 * bitdepth of the pixel format.
	 * 
	 * @apiNote (double) limit
	 * @return the {@link CropDetect} instance
	 */
	public CropDetect limit( double threshold ) {
		if ( threshold <= 1.0 ) {
			Assert.rangeCheck( threshold, 0.0, 1.0 );
		} else {
			Assert.rangeCheck( ( int ) threshold, 0, 255 );
		}
		return super.addArg( "limit", threshold );
	}

	/**
	 * The value which the width/height should be divisible by. It defaults to 16. The offset is automatically
	 * adjusted to center the video. Use 2 to get only even dimensions (needed for 4:2:2 video). 16 is best
	 * when encoding to most video codecs.
	 * 
	 * @apiNote (double) round
	 * @param value the dimension value
	 * @return the {@link CropDetect} instance
	 */
	public CropDetect round( int value ) {
		return super.addArg( "round", value );
	}

	/**
	 * Set the number of initial frames for which evaluation is skipped, default is 2 and the range is 0 to
	 * {@link Integer#MAX_VALUE}.
	 * 
	 * @apiNote (double) round
	 * @param value the skip frames number
	 * @return the {@link CropDetect} instance
	 */
	public CropDetect skip( int value ) {
		return super.addArg( "round", value );
	}

	/**
	 * <p>
	 * Set the counter that determines after how many frames {@code cropdetect} will reset the previously
	 * detected largest video area and start over to detect the current optimal crop area. Default value is 0.
	 * 
	 * <p>
	 * This can be useful when channel logos distort the video area. 0 indicates ’never reset’, and returns
	 * the largest area encountered during playback.
	 * 
	 * @apiNote (boolean) reset 
	 * @return the {@link CropDetect} instance
	 */
	public CropDetect reset() {
		return super.enable( "reset" );
	}

}
