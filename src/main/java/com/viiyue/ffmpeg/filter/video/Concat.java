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
 * Concatenate audio and video streams, joining them together one after the other.
 * 
 * <p>
 * The filter works on segments of synchronized video and audio streams. All segments must have the same
 * number of streams of each type, and that will also be the number of streams at output.
 *
 * @author tangxbai
 * @since 2022/06/30
 * @see <a href= "https://ffmpeg.org/ffmpeg-filters.html#concat">ffmpeg-filters#concat</a>
 */
@Function( "concat" )
public class Concat extends AbstractFunction<Concat> {

	// Don't let anyone instantiate this class
	private Concat() {}

	/**
	 * Quickly create an instances of {@link Concat}
	 * 
	 * @apiNote (int) n
	 * @param how specify the total number to input
	 * @return the {@link Concat} instance
	 */
	public static final Concat in( int how ) {
		return new Concat().input( how );
	}

	/**
	 * Quickly create an instances of {@link Concat}
	 * 
	 * @apiNote (int) n, (int) v, (int) a
	 * @param how      specify the total number to input
	 * @param videoNum specify the number of videos to input
	 * @param audioNum specify the number of audios to enter
	 * @return the {@link Concat} instance
	 */
	public static final Concat in( int how, int videoNum, int audioNum ) {
		return in( how ).video( videoNum ).audio( audioNum );
	}

	/**
	 * Quickly create an instances of {@link Concat}
	 * 
	 * @apiNote (int) n
	 * @param value specify the total number to input
	 * @return the {@link Concat} instance
	 */
	public Concat input( int value ) {
		return super.addArg( "n", value );
	}

	/**
	 * Quickly create an instances of {@link Concat}
	 * 
	 * @apiNote (int) v
	 * @param value specify the number of videos to input
	 * @return the {@link Concat} instance
	 */
	public Concat video( int value ) {
		return super.addArg( "v", value );
	}

	/**
	 * Quickly create an instances of {@link Concat}
	 * 
	 * @apiNote (int) a
	 * @param value specify the number of audios to enter
	 * @return the {@link Concat} instance
	 */
	public Concat audio( int value ) {
		return super.addArg( "a", value );
	}

}
