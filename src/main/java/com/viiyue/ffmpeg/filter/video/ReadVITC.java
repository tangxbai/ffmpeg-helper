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
 * Read vertical interval timecode (VITC) information from the top lines of a video frame.
 * 
 * <p>
 * The filter adds frame metadata key {@code lavfi.readvitc.tc_str} with the timecode value, if a valid
 * timecode has been detected. Further metadata key {@code lavfi.readvitc.found} is set to 0/1 depending on
 * whether timecode data has been found or not.
 * 
 * @author tangxbai
 * @since 2022/07/25
 * @see <a href="https://ffmpeg.org/ffmpeg-filters.html#readvitc">ffmpeg-filters#readvitc</a>
 */
@Function( "readvitc" )
public class ReadVITC extends AbstractFunction<ReadVITC> {

	// Don't let anyone instantiate this class
	private ReadVITC() {}

	/**
	 * Quickly create an instances of {@link ReadVITC}
	 * 
	 * @return the {@link ReadVITC} instance
	 */
	public static final ReadVITC of() {
		return new ReadVITC();
	}

	/**
	 * Set the maximum number of lines to scan for VITC data. If the value is set to -1 the full video frame
	 * is scanned. Default is <b>45</b>.
	 * 
	 * @apiNote (int) scan_max
	 * @param value the maximum line numbers
	 * @return the {@link ReadVITC} instance
	 */
	public ReadVITC scanMax( int value ) {
		return super.addArg( "scan_max", value );
	}

	/**
	 * Set the luma threshold for black. Accepts float numbers in the range [0.0,1.0], default value is
	 * <b>0.2</b>. The value must be equal or less than {@code thr_w}.
	 * 
	 * @apiNote (int) thr_b
	 * @param value the black color threshold
	 * @return the {@link ReadVITC} instance
	 */
	public ReadVITC thresholdOfBlack( double value ) {
		return super.addArg( "thr_b", value );
	}

	/**
	 * Set the luma threshold for white. Accepts float numbers in the range [0.0,1.0], default value is
	 * <b>0.6</b>. The value must be equal or greater than {@code thr_b}.
	 * 
	 * @apiNote (int) thr_w
	 * @param value the white color threshold
	 * @return the {@link ReadVITC} instance
	 */
	public ReadVITC thresholdOfWhite( double value ) {
		return super.addArg( "thr_w", value );
	}

}
