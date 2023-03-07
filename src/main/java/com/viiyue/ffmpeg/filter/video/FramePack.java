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

import com.viiyue.ffmpeg.annotation.Alias;
import com.viiyue.ffmpeg.annotation.Function;
import com.viiyue.ffmpeg.common.AbstractEnum;
import com.viiyue.ffmpeg.filter.AbstractColorFunction;

/**
 * Pack two different video streams into a stereoscopic video, setting proper metadata on supported codecs.
 * The two views should have the same size and framerate and processing will stop when the shorter video ends.
 * Please note that you may conveniently adjust view properties with the {@code scale} and {@code fps}
 * filters.
 * 
 * @author tangxbai
 * @since 2022/07/06
 * @see <a href="https://ffmpeg.org/ffmpeg-filters.html#framepack">ffmpeg-filters#framepack</a>
 */
@Function( "framepack" )
public class FramePack extends AbstractColorFunction<FramePack> {

	// Don't let anyone instantiate this class
	private FramePack() {}

	/**
	 * Quickly create an instances of {@link FramePack}, and specify the desired packing format.
	 * 
	 * @return the {@link FramePack} instance
	 */
	public static final FramePack format( PackFormat format ) {
		return new FramePack().addValue( format );
	}

	/**
	 * The desired packing format
	 *
	 * @author tangxbai
	 * @since 2022/07/06
	 */
	public enum PackFormat implements AbstractEnum {
		/** The views are next to each other (default) */
		SBS,
		/** The views are on top of each other */
		LINES,
		/** The views are packed by line */
		TAB,
		/** The views are packed by column */
		COLUMNS,
		/** The views are temporally interleaved */
		@Alias( "frameseq" )
		FRAME_SEQ
	}

}
