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
import com.viiyue.ffmpeg.common.AbstractEnum;
import com.viiyue.ffmpeg.enums.Deinterlace;
import com.viiyue.ffmpeg.enums.Parity;
import com.viiyue.ffmpeg.filter.AbstractFunction;

/**
 * <p>
 * Deinterlace the input video ("bwdif" stands for "Bob Weaver Deinterlacing Filter").
 * 
 * <p>
 * Motion adaptive deinterlacing based on yadif with the use of w3fdif and cubic interpolation algorithms
 *
 * @author tangxbai
 * @since 2022/06/02
 * @see <a href="https://ffmpeg.org/ffmpeg-filters.html#bwdif">ffmpeg-filters#bwdif</a>
 */
@Function( "bwdif" )
public class Bwdif extends AbstractFunction<Bwdif> {

	// Don't let anyone instantiate this class
	private Bwdif() {}

	/**
	 * Quickly create an instances of {@link Bwdif}
	 * 
	 * @return the {@link Bwdif} instance
	 */
	public static final Bwdif the() {
		return new Bwdif();
	}

	/**
	 * Quickly create an instances of {@link Bwdif}
	 * 
	 * @apiNote (flags) mode
	 * @return the {@link Bwdif} instance
	 */
	public static final Bwdif the( InterlacingMode mode ) {
		return new Bwdif().addArg( "mode", mode );
	}

	/**
	 * The picture field parity assumed for the input interlaced video
	 * 
	 * @apiNote (flags) parity
	 * @param parity the picture field parity
	 * @return the {@link Bwdif} instance
	 * @see Parity
	 */
	public Bwdif parity( Parity parity ) {
		return super.addArg( "parity", parity );
	}

	/**
	 * Specify which frames to deinterlace
	 * 
	 * @apiNote (flags) deint
	 * @param deint the which frames to deinterlace
	 * @return the {@link Bwdif} instance
	 * @see Deinterlace
	 */
	public Bwdif deint( Deinterlace deint ) {
		return super.addArg( "deint", deint );
	}

	/**
	 * The interlacing mode to adopt
	 *
	 * @author tangxbai
	 * @since 2022/06/14
	 */
	public enum InterlacingMode implements AbstractEnum {
		SEND_FRAME, SEND_FIELD
	}

}
