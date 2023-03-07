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

import com.viiyue.ffmpeg.filter.AbstractFunction;

/**
 * <p>
 * Add or replace the alpha component of the primary input with the grayscale value of a second input. This is
 * intended for use with alphaextract to allow the transmission or storage of frame sequences that have alpha
 * in a format that doesn’t support an alpha channel.
 * 
 * <p>
 * For example, to reconstruct full frames from a normal YUV-encoded video and a separate video created with
 * alphaextract, you might use:
 * 
 * <pre>
 * movie=in_alpha.mkv[alpha]; [in][alpha]alphamerge[out]
 * </pre>
 * 
 * @author tangxbai
 * @since 2022/06/02
 */
public class Flip extends AbstractFunction<Flip> {

	private final String funName;

	// Don't let anyone instantiate this class
	private Flip( String funName ) {
		this.funName = funName;
	}

	@Override
	protected String getResult() {
		return this.funName;
	}

	/**
	 * Flip the input video vertical
	 * 
	 * @return the {@link Flip} instance
	 */
	public static final Flip vertical() {
		return new Flip( "vflip" );
	}

	/**
	 * Flip the input video horizontally
	 * 
	 * @return the {@link Flip} instance
	 */
	public static final Flip horizontal() {
		return new Flip( "hflip" );
	}

}
