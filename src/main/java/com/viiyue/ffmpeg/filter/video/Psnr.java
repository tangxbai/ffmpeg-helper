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
 * Obtain the average, maximum and minimum PSNR (Peak Signal to Noise Ratio) between two input videos.
 * 
 * <p>
 * This filter takes in input two input videos, the first input is considered the "main" source and is passed
 * unchanged to the output. The second input is used as a "reference" video for computing the PSNR.
 * 
 * <p>
 * Both video inputs must have the same resolution and pixel format for this filter to work correctly. Also it
 * assumes that both inputs have the same number of frames, which are compared one by one.
 * 
 * <p>
 * The obtained average PSNR is printed through the logging system.
 * 
 * <p>
 * The filter stores the accumulated MSE (mean squared error) of each frame, and at the end of the processing
 * it is averaged across all frames equally, and the following formula is applied to obtain the PSNR:
 * 
 * <pre>
 * PSNR = 10 * log10( MAX ^ 2 / MSE )
 * </pre>
 * 
 * <p>
 * Where MAX is the average of the maximum values of each component of the image.
 * 
 * @author tangxbai
 * @since 2022/07/21
 * @see <a href="https://ffmpeg.org/ffmpeg-filters.html#psnr">ffmpeg-filters#psnr</a>
 */
@Function( "psnr" )
public class Psnr extends AbstractFunction<Psnr> {

	// Don't let anyone instantiate this class
	private Psnr() {}

	/**
	 * Quickly create an instances of {@link Psnr}
	 * 
	 * @return the {@link Psnr} instance
	 */
	public static final Psnr of() {
		return new Psnr();
	}

	/**
	 * If specified the filter will use the named file to save the PSNR of each individual frame. When
	 * filename equals "-" the data is sent to standard output.
	 * 
	 * @apiNote (string) stats_file, f
	 * @param file the output stats file
	 * @return the {@link Psnr} instance
	 */
	public Psnr statsFile( String file ) {
		return super.addArg( "f", file ); // stats_file, f
	}

	/**
	 * Specifies which version of the stats file format to use. Details of each format are written below.
	 * Default value is <b>1</b>.
	 * 
	 * @apiNote (int) stats_version
	 * @param value the format version for the stats file
	 * @return the {@link Psnr} instance
	 */
	public Psnr statsVersion( int value ) {
		return super.addArg( "stats_version", value );
	}

	/**
	 * Specifies which version of the stats file format to use. Details of each format are written below.
	 * Default value is <b>1</b>.
	 * 
	 * @apiNote (int) stats_version
	 * @param value the format version for the stats file
	 * @return the {@link Psnr} instance
	 */
	public Psnr statsAddMax( int value ) {
		return super.addArg( "stats_version", value );
	}

	/**
	 * Add raw stats (max values) to the output log
	 * 
	 * @apiNote (boolean) output_max
	 * @return the {@link Psnr} instance
	 */
	public Psnr outputMax( int value ) {
		return super.enable( "output_max" );
	}

	/**
	 * The action to take when EOF is encountered on the secondary input
	 * 
	 * @apiNote (flags) eof_action
	 * @param action the EOF action
	 * @return the {@link Psnr} instance
	 */
	public Psnr action( EofAction action ) {
		return super.addArg( "eof_action", action );
	}

	/**
	 * If set to {@code true}, force the output to terminate when the shortest input terminates. default value
	 * is {@code false}.
	 * 
	 * @apiNote (boolean) shorttest
	 * @param state the shortest state
	 * @return the {@link Psnr} instance
	 */
	public Psnr shortest( boolean state ) {
		return super.status( "shortest", state );
	}

	/**
	 * If set to true, force the filter to extend the last frame of secondary streams until the end of the
	 * primary stream.
	 * 
	 * @apiNote (boolean) repeatlast
	 * @param state the repeat last state
	 * @return the {@link Psnr} instance
	 */
	public Psnr repeatLast( boolean state ) {
		return super.status( "repeatlast", state );
	}

}
