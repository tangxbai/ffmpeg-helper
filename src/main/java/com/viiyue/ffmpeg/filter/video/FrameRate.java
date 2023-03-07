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
 * Change the frame rate by interpolating new video output frames from the source frames.
 * 
 * <p>
 * This filter is not designed to function correctly with interlaced media. If you wish to change the frame
 * rate of interlaced media then you are required to deinterlace before this filter and re-interlace after
 * this filter.
 * 
 * @author tangxbai
 * @since 2022/07/06
 * @see <a href="https://ffmpeg.org/ffmpeg-filters.html#framerate">ffmpeg-filters#framerate</a>
 */
@Function( "framerate" )
public class FrameRate extends AbstractColorFunction<FrameRate> {

	// Don't let anyone instantiate this class
	private FrameRate() {}

	/**
	 * Quickly create an instances of {@link FrameRate}
	 * 
	 * @return the {@link FrameRate} instance
	 */
	public static final FrameRate of() {
		return new FrameRate();
	}

	/**
	 * Specify the output frames per second. This option can also be specified as a value alone. The default
	 * is <b>50</b>.
	 * 
	 * @apiNote (double) fps
	 * @param fps the required output frames per second rate
	 * @return the {@link FrameRate} instance
	 */
	public FrameRate fps( double fps ) {
		return super.addArg( "fps", fps );
	}

	/**
	 * Specify the start of a range where the output frame will be created as a linear interpolation of two
	 * frames. The range is [0-255], and default is <b>15</b>.
	 * 
	 * @apiNote (int) interp_start
	 * @param value the start linear interpolation
	 * @return the {@link FrameRate} instance
	 */
	public FrameRate interpStart( double value ) {
		Assert.rangeCheck( value, 0.0, 255.0 );
		return super.addArg( "interp_start", value );
	}

	/**
	 * Specify the end of a range where the output frame will be created as a linear interpolation of two
	 * frames. The range is [0-255], and default is <b>340</b>.
	 * 
	 * @apiNote (int) interp_end
	 * @param value the start linear interpolation
	 * @return the {@link FrameRate} instance
	 */
	public FrameRate interpEnd( double value ) {
		Assert.rangeCheck( value, 0.0, 255.0 );
		return super.addArg( "interp_end", value );
	}

	/**
	 * Specify the level at which a scene change is detected as a value between 0 and 100 to indicate a new
	 * scene; a low value reflects a low probability for the current frame to introduce a new scene, while a
	 * higher value means the current frame is more likely to be one, default is <b>8.2</b>.
	 * 
	 * @apiNote (double) scene
	 * @param value the scene change level
	 * @return the {@link FrameRate} instance
	 */
	public FrameRate scene( double value ) {
		Assert.rangeCheck( value, 0.0, 100.0 );
		return super.addArg( "scene", value );
	}

	/**
	 * Specify flags influencing the filter process
	 * 
	 * @apiNote (flags) flags
	 * @return the {@link FrameRate} instance
	 */
	public FrameRate enableSceneChangeDetect() {
		return super.addArg( "flags", "scd" ); // scd, scene_change_detect
	}

}
