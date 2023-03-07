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
 * Delay video filtering until a given wallclock timestamp. The filter first passes on preroll amount of
 * frames, then it buffers at most buffer amount of frames and waits for the cue. After reaching the cue it
 * forwards the buffered frames and also any subsequent frames coming in its input.
 * 
 * <p>
 * The filter can be used synchronize the output of multiple ffmpeg processes for realtime output devices like
 * decklink. By putting the delay in the filtering chain and pre-buffering frames the process can pass on data
 * to output almost immediately after the target wallclock timestamp is reached.
 * 
 * <p>
 * Perfect frame accuracy cannot be guaranteed, but the result is good enough for some use cases.
 * 
 * @author tangxbai
 * @since 2022/06/15
 * @see <a href="https://ffmpeg.org/ffmpeg-filters.html#cue">ffmpeg-filters#cue</a>
 */
@Function( "cue" )
public class Cue extends AbstractFunction<Cue> {

	// Don't let anyone instantiate this class
	private Cue() {}

	/**
	 * Quickly create an instances of {@link Cue}
	 * 
	 * @apiNote (long) timestamp
	 * @param timestamp the cue timestamp expressed in a UNIX timestamp in microseconds
	 * @return the {@link Cue} instance
	 */
	public static final Cue of( long timestamp ) {
		return new Cue().addArg( "cue", timestamp );
	}

	/**
	 * The duration of content to pass on as preroll expressed in seconds, default is <b>0</b>.
	 * 
	 * @apiNote (int) preroll
	 * @param preroll the duration of preroll
	 * @return the {@link Cue} instance
	 */
	public Cue preroll( int duration ) {
		return super.addArg( "preroll", duration );
	}

	/**
	 * The maximum duration of content to buffer before waiting for the cue expressed in seconds, default is
	 * <b>0</b>.
	 * 
	 * @apiNote (int) buffer
	 * @param preroll the maximum duration of content
	 * @return the {@link Cue} instance
	 */
	public Cue buffer( int duration ) {
		return super.addArg( "buffer", duration );
	}

}
