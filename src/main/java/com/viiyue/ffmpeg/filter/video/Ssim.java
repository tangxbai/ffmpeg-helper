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
import com.viiyue.ffmpeg.enums.EofAction;
import com.viiyue.ffmpeg.filter.AbstractFunction;

/**
 * <p>
 * Obtain the SSIM (Structural SImilarity Metric) between two input videos.
 * 
 * <p>
 * This filter takes in input two input videos, the first input is considered the "main" source and is passed
 * unchanged to the output. The second input is used as a "reference" video for computing the SSIM.
 * 
 * <p>
 * Both video inputs must have the same resolution and pixel format for this filter to work correctly. Also it
 * assumes that both inputs have the same number of frames, which are compared one by one.
 * 
 * <p>
 * The filter stores the calculated SSIM of each frame.
 * 
 * @author tangxbai
 * @since 2022/08/05
 * @see <a href="https://ffmpeg.org/ffmpeg-filters.html#spp-1">ffmpeg-filters#spp</a>
 */
@Function( "sr" )
public class Ssim extends AbstractFunction<Ssim> {

	// Don't let anyone instantiate this class
	private Ssim() {}

	/**
	 * Quickly create an instances of {@link Ssim}
	 * 
	 * @return the {@link Ssim} instance
	 */
	public static final Ssim of() {
		return new Ssim();
	}

	/**
	 * If specified the filter will use the named file to save the SSIM of each individual frame. When
	 * filename equals "-" the data is sent to standard output.
	 * 
	 * @apiNote (string) stats_file, f
	 * @param filePath the file where to store per-frame difference information
	 * @return the {@link Ssim} instance
	 */
	public Ssim statsFile( String filePath ) {
		return super.addArg( "f", filePath );
	}

	/**
	 * The action to take when EOF is encountered on the secondary input
	 * 
	 * @apiNote (flags) eof_action
	 * @param action the EOF action
	 * @return the {@link Ssim} instance
	 */
	public Ssim action( EofAction action ) {
		return super.addArg( "eof_action", action );
	}

	/**
	 * If set to true, force the output to terminate when the shortest input terminates. default value is
	 * false.
	 * 
	 * @apiNote (boolean) shortest
	 * @param state the shortest state
	 * @return the {@link Ssim} instance
	 */
	public Ssim shortest( boolean state ) {
		return super.status( "shortest", state );
	}

	/**
	 * If set to true, force the filter to extend the last frame of secondary streams until the end of the
	 * primary stream. A value of 0 disables this behavior, default value is false.
	 * 
	 * @apiNote (boolean) repeatlast
	 * @param state the repeat last state
	 * @return the {@link Ssim} instance
	 */
	public Ssim repeatLast( boolean state ) {
		return super.status( "repeatlast", state );
	}

}
