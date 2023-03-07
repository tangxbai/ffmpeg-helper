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
 * Select one frame every N-th frame
 * 
 * @author tangxbai
 * @since 2022/07/06
 * @see <a href="https://ffmpeg.org/ffmpeg-filters.html#framerate">ffmpeg-filters#framerate</a>
 */
@Function( "framestep" )
public class FrameStep extends AbstractColorFunction<FrameStep> {

	// Don't let anyone instantiate this class
	private FrameStep() {}

	/**
	 * Quickly create an instances of {@link FrameStep}
	 * 
	 * @apiNote (int) step
	 * @param step the frame step
	 * @return the {@link FrameStep} instance
	 */
	public static final FrameStep of( int step ) {
		Assert.isTrue( step >= 1, "Step value must be greater than or equal to 1" );
		return new FrameStep().addArg( "step", step );
	}

}
