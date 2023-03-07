/**
 * Copyright (C) 2022-2023 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in
 * compliance with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License is
 * distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and limitations under the License.
 */
package com.viiyue.ffmpeg.filter.video;

import com.viiyue.ffmpeg.annotation.Function;
import com.viiyue.ffmpeg.filter.AbstractFunction;

/**
 * Crop the input video to given dimensions.
 * 
 * @author tangxbai
 * @since 2022/06/17
 * @see <a href="https://ffmpeg.org/ffmpeg-filters.html#crop">ffmpeg-filters#crop</a>
 */
@Function( "crop" )
public class Crop extends AbstractFunction<Crop> {

	// Don't let anyone instantiate this class
	private Crop() {}

	/**
	 * Quickly create an instances of {@link Crop}
	 * 
	 * @param width  the width of dimensions
	 * @param height the height of dimensions
	 * @param x      the x position
	 * @param y      the y position
	 * @return the {@link Crop} instance
	 */
	public static final Crop the( int w, int h, int x, int y ) {
		return new Crop().dimensions( w, h, x, y );
	}

	/**
	 * Quickly create an instances of {@link Crop}
	 * 
	 * <p>
	 * The expressions can contain the following constants:
	 * 
	 * <pre>
	 * {@code x, y}         - The computed values for x and y. They are evaluated for each new frame.
	 * {@code in_w, in_h}   - The input width and height.
	 * {@code iw, ih}       - These are the same as in_w and in_h.
	 * {@code out_w, out_h} - The output (cropped) width and height.
	 * {@code ow, oh}       - These are the same as out_w and out_h.
	 * {@code a}            - Same as iw / ih
	 * {@code sar}          - Input sample aspect ratio
	 * {@code dar}          - Input display aspect ratio, it is the same as (iw / ih) * sar
	 * {@code hsub, vsub}   - Horizontal and vertical chroma subsample values. For example for the pixel format "yuv422p" hsub is 2 and vsub is 1.
	 * {@code n}            - The number of the input frame, starting from 0.
	 * {@code pos}          - The position in the file of the input frame, NAN if unknown
	 * {@code t}            - The timestamp expressed in seconds. It’s NAN if the input timestamp is unknown.
	 * </pre>
	 * 
	 * @param width  the width expression
	 * @param height the height expression
	 * @param x      the x expression
	 * @param y      the y expression
	 * @return the {@link Crop} instance
	 */
	public static final Crop the( String w, String h, String x, String y ) {
		return new Crop().dimensions( w, h, x, y );
	}

	/**
	 * If set to true will force the output display aspect ratio to be the same of the input, by changing the
	 * output sample aspect ratio. It defaults to false.
	 * 
	 * @return the {@link Crop} instance
	 */
	public Crop keepAspect() {
		return super.enable( "keep_aspect" );
	}

	/**
	 * Enable exact cropping. If enabled, subsampled videos will be cropped at exact width/height/x/y as
	 * specified and will not be rounded to nearest smaller value. It defaults to false.
	 * 
	 * @return the {@link Crop} instance
	 */
	public Crop exact() {
		return super.enable( "exact" );
	}

	/**
	 * Set the crop dimensions
	 * 
	 * @param w the width of dimensions
	 * @param h the height of dimensions
	 * @param x the x position
	 * @param y the y position
	 * @return the {@link Crop} instance
	 */
	private Crop dimensions( Object w, Object h, Object x, Object y ) {
		return super.addBaseArg( "w", w ).addBaseArg( "h", h ).addBaseArg( "x", x ).addBaseArg( "y", y );
	}

}
