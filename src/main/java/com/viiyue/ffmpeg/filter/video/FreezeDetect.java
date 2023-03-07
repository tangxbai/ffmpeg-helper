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
import com.viiyue.ffmpeg.filter.AbstractColorFunction;
import com.viiyue.ffmpeg.util.Assert;

/**
 * <p>
 * Detect frozen video
 * 
 * <p>
 * This filter logs a message and sets frame metadata when it detects that the input video has no significant
 * change in content during a specified duration. Video freeze detection calculates the mean average absolute
 * difference of all the components of video frames and compares it to a noise floor.
 * 
 * <p>
 * The printed times and duration are expressed in seconds. The
 * <font color="green">lavfi.freezedetect.freeze_start</font> metadata key is set on the first frame whose
 * timestamp equals or exceeds the detection duration and it contains the timestamp of the first frame of the
 * freeze. The <font color="green">lavfi.freezedetect.freeze_duration</font> and
 * <font color="green">lavfi.freezedetect.freeze_end</font> metadata keys are set on the first frame after the
 * freeze.
 * 
 * @author tangxbai
 * @since 2022/07/06
 * @see <a href="https://ffmpeg.org/ffmpeg-filters.html#freezedetect">ffmpeg-filters#freezedetect</a>
 */
@Function( "freezedetect" )
public class FreezeDetect extends AbstractColorFunction<FreezeDetect> {

	// Don't let anyone instantiate this class
	private FreezeDetect() {}

	/**
	 * Quickly create an instances of {@link FreezeDetect}
	 * 
	 * @return the {@link FreezeDetect} instance
	 */
	public static final FreezeDetect of() {
		return new FreezeDetect();
	}

	/**
	 * Set noise tolerance. Can be specified in dB (in case "dB" is appended to the specified value) or as a
	 * difference ratio between 0 and 1. Default is -60dB, or <b>0.001</b>.
	 * 
	 * @apiNote (double) n, noise
	 * @param value the noise tolerance
	 * @return the {@link FreezeDetect} instance
	 */
	public FreezeDetect noise( double value ) {
		Assert.rangeCheck( value, 0.0, 1.0 );
		return super.addArg( "n", value ); // n, noise
	}

	/**
	 * Set freeze duration until notification (default is 2 seconds)
	 * 
	 * @apiNote (double) d, duration
	 * @param value the minimum duration in seconds
	 * @return the {@link FreezeDetect} instance
	 */
	public FreezeDetect duration( double value ) {
		Assert.rangeCheck( value, 0.0, 1.0 );
		return super.addArg( "d", value ); // d, duration
	}

}
