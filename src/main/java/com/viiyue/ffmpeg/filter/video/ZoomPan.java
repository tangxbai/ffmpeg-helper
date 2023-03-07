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
import com.viiyue.ffmpeg.enums.VideoSize;
import com.viiyue.ffmpeg.filter.AbstractFunction;

/**
 * Apply Zoom & Pan effect
 *
 * @author tangxbai
 * @since 2022/10/21
 * @see <a href="https://ffmpeg.org/ffmpeg-filters.html#zoompan">ffmpeg-filters#zoompan</a>
 */
@Function( "zoompan" )
public class ZoomPan extends AbstractFunction<ZoomPan> {

	// Don't let anyone instantiate this class
	private ZoomPan() {}

	/**
	 * Quickly create an instances of {@link ZoomPan}
	 * 
	 * @return the {@link ZoomPan} instance
	 */
	public static final ZoomPan of() {
		return new ZoomPan();
	}

	/**
	 * Set the zoom expression
	 * 
	 * <p>
	 * Each expression can contain the following constants:
	 * <ul>
	 * <li><b>in_w, iw</b> - Input width
	 * <li><b>in_h, ih</b> - Input height
	 * <li><b>out_w, ow</b> - Output width
	 * <li><b>out_h, oh</b> - Output height
	 * <li><b>in</b> - Input frame count
	 * <li><b>on</b> - Output frame count
	 * <li><b>in_time, it</b> - The input timestamp expressed in seconds. It’s NAN if the input timestamp is
	 * unknown
	 * <li><b>out_time, time, ot</b> - The output timestamp expressed in seconds
	 * <li><b>x, y</b> - Last calculated ’x’ and ’y’ position from ’x’ and ’y’ expression for current input
	 * frame.
	 * <li><b>px, py</b> - ’x’ and ’y’ of last output frame of previous input frame or 0 when there was not
	 * yet such frame (first input frame
	 * <li><b>zoom</b> - Last calculated zoom from ’z’ expression for current input frame
	 * <li><b>pzoom</b> - Last calculated zoom of last output frame of previous input frame
	 * <li><b>duration</b> - Number of output frames for current input frame. Calculated from ’d’ expression
	 * for each input frame
	 * <li><b>pduration</b> - number of output frames created for previous input frame
	 * <li><b>a</b> - Rational number: input width / input height
	 * <li><b>sar</b> - sample aspect ratio
	 * <li><b>dar</b> - display aspect ratio
	 * </ul>
	 * 
	 * @apiNote (string) zoom, z
	 * @param expression the zoom expression
	 * @return the {@link ZoomPan} instance
	 */
	public ZoomPan zoom( String expression ) {
		return super.addArg( "z", expression ); // zoom, z
	}

	/**
	 * Set the x coordinate
	 * 
	 * @apiNote (int) x
	 * @param value the x coordinate
	 * @return the {@link ZoomPan} instance
	 */
	public ZoomPan x( int value ) {
		return super.addArg( "x", value );
	}

	/**
	 * Set the x coordinate expression
	 * 
	 * <p>
	 * Each expression can contain the following constants:
	 * <ul>
	 * <li><b>in_w, iw</b> - Input width
	 * <li><b>in_h, ih</b> - Input height
	 * <li><b>out_w, ow</b> - Output width
	 * <li><b>out_h, oh</b> - Output height
	 * <li><b>in</b> - Input frame count
	 * <li><b>on</b> - Output frame count
	 * <li><b>in_time, it</b> - The input timestamp expressed in seconds. It’s NAN if the input timestamp is
	 * unknown
	 * <li><b>out_time, time, ot</b> - The output timestamp expressed in seconds
	 * <li><b>x, y</b> - Last calculated ’x’ and ’y’ position from ’x’ and ’y’ expression for current input
	 * frame.
	 * <li><b>px, py</b> - ’x’ and ’y’ of last output frame of previous input frame or 0 when there was not
	 * yet such frame (first input frame
	 * <li><b>zoom</b> - Last calculated zoom from ’z’ expression for current input frame
	 * <li><b>pzoom</b> - Last calculated zoom of last output frame of previous input frame
	 * <li><b>duration</b> - Number of output frames for current input frame. Calculated from ’d’ expression
	 * for each input frame
	 * <li><b>pduration</b> - number of output frames created for previous input frame
	 * <li><b>a</b> - Rational number: input width / input height
	 * <li><b>sar</b> - sample aspect ratio
	 * <li><b>dar</b> - display aspect ratio
	 * </ul>
	 * 
	 * @apiNote (string) x
	 * @param value the x coordinate expression
	 * @return the {@link ZoomPan} instance
	 */
	public ZoomPan x( String expression ) {
		return super.addArg( "x", expression );
	}

	/**
	 * Set the y coordinate
	 * 
	 * @apiNote (int) y
	 * @param value the y coordinate
	 * @return the {@link ZoomPan} instance
	 */
	public ZoomPan y( int value ) {
		return super.addArg( "y", value );
	}

	/**
	 * Set the y coordinate expression
	 * 
	 * <p>
	 * Each expression can contain the following constants:
	 * <ul>
	 * <li><b>in_w, iw</b> - Input width
	 * <li><b>in_h, ih</b> - Input height
	 * <li><b>out_w, ow</b> - Output width
	 * <li><b>out_h, oh</b> - Output height
	 * <li><b>in</b> - Input frame count
	 * <li><b>on</b> - Output frame count
	 * <li><b>in_time, it</b> - The input timestamp expressed in seconds. It’s NAN if the input timestamp is
	 * unknown
	 * <li><b>out_time, time, ot</b> - The output timestamp expressed in seconds
	 * <li><b>x, y</b> - Last calculated ’x’ and ’y’ position from ’x’ and ’y’ expression for current input
	 * frame.
	 * <li><b>px, py</b> - ’x’ and ’y’ of last output frame of previous input frame or 0 when there was not
	 * yet such frame (first input frame
	 * <li><b>zoom</b> - Last calculated zoom from ’z’ expression for current input frame
	 * <li><b>pzoom</b> - Last calculated zoom of last output frame of previous input frame
	 * <li><b>duration</b> - Number of output frames for current input frame. Calculated from ’d’ expression
	 * for each input frame
	 * <li><b>pduration</b> - number of output frames created for previous input frame
	 * <li><b>a</b> - Rational number: input width / input height
	 * <li><b>sar</b> - sample aspect ratio
	 * <li><b>dar</b> - display aspect ratio
	 * </ul>
	 * 
	 * @apiNote (string) y
	 * @param value the y coordinate expression
	 * @return the {@link ZoomPan} instance
	 */
	public ZoomPan y( String expression ) {
		return super.addArg( "y", expression );
	}

	/**
	 * Set the duration in number of frames. This sets for how many number of frames effect will last for
	 * single input image.
	 * 
	 * @apiNote (double) d
	 * @param value the animation duration
	 * @return the {@link ZoomPan} instance
	 */
	public ZoomPan duration( double value ) {
		return super.addArg( "d", value );
	}

	/**
	 * Set the duration expression in number of frames. This sets for how many number of frames effect will
	 * last for single input image.
	 * 
	 * <p>
	 * Each expression can contain the following constants:
	 * <ul>
	 * <li><b>in_w, iw</b> - Input width
	 * <li><b>in_h, ih</b> - Input height
	 * <li><b>out_w, ow</b> - Output width
	 * <li><b>out_h, oh</b> - Output height
	 * <li><b>in</b> - Input frame count
	 * <li><b>on</b> - Output frame count
	 * <li><b>in_time, it</b> - The input timestamp expressed in seconds. It’s NAN if the input timestamp is
	 * unknown
	 * <li><b>out_time, time, ot</b> - The output timestamp expressed in seconds
	 * <li><b>x, y</b> - Last calculated ’x’ and ’y’ position from ’x’ and ’y’ expression for current input
	 * frame.
	 * <li><b>px, py</b> - ’x’ and ’y’ of last output frame of previous input frame or 0 when there was not
	 * yet such frame (first input frame
	 * <li><b>zoom</b> - Last calculated zoom from ’z’ expression for current input frame
	 * <li><b>pzoom</b> - Last calculated zoom of last output frame of previous input frame
	 * <li><b>duration</b> - Number of output frames for current input frame. Calculated from ’d’ expression
	 * for each input frame
	 * <li><b>pduration</b> - number of output frames created for previous input frame
	 * <li><b>a</b> - Rational number: input width / input height
	 * <li><b>sar</b> - sample aspect ratio
	 * <li><b>dar</b> - display aspect ratio
	 * </ul>
	 * 
	 * @apiNote (string) d
	 * @param value the animation duration
	 * @return the {@link ZoomPan} instance
	 */
	public ZoomPan duration( String expression ) {
		return super.addArg( "d", expression );
	}

	/**
	 * Set the output image size
	 * 
	 * @apiNote (string) s
	 * @param size the video image size
	 * @return the {@link ZoomPan} instance
	 */
	public ZoomPan size( VideoSize size ) {
		return super.addArg( "s", size );
	}

	/**
	 * Set the output image size
	 * 
	 * <p>
	 * Each expression can contain the following constants:
	 * <ul>
	 * <li><b>in_w, iw</b> - Input width
	 * <li><b>in_h, ih</b> - Input height
	 * <li><b>out_w, ow</b> - Output width
	 * <li><b>out_h, oh</b> - Output height
	 * <li><b>in</b> - Input frame count
	 * <li><b>on</b> - Output frame count
	 * <li><b>in_time, it</b> - The input timestamp expressed in seconds. It’s NAN if the input timestamp is
	 * unknown
	 * <li><b>out_time, time, ot</b> - The output timestamp expressed in seconds
	 * <li><b>x, y</b> - Last calculated ’x’ and ’y’ position from ’x’ and ’y’ expression for current input
	 * frame.
	 * <li><b>px, py</b> - ’x’ and ’y’ of last output frame of previous input frame or 0 when there was not
	 * yet such frame (first input frame
	 * <li><b>zoom</b> - Last calculated zoom from ’z’ expression for current input frame
	 * <li><b>pzoom</b> - Last calculated zoom of last output frame of previous input frame
	 * <li><b>duration</b> - Number of output frames for current input frame. Calculated from ’d’ expression
	 * for each input frame
	 * <li><b>pduration</b> - number of output frames created for previous input frame
	 * <li><b>a</b> - Rational number: input width / input height
	 * <li><b>sar</b> - sample aspect ratio
	 * <li><b>dar</b> - display aspect ratio
	 * </ul>
	 * 
	 * @apiNote (string) s
	 * @param size the video image size
	 * @return the {@link ZoomPan} instance
	 */
	public ZoomPan size( String size ) {
		return super.addArg( "s", size );
	}

	/**
	 * Set the output frame rate
	 * 
	 * <p>
	 * Each expression can contain the following constants:
	 * <ul>
	 * <li><b>in_w, iw</b> - Input width
	 * <li><b>in_h, ih</b> - Input height
	 * <li><b>out_w, ow</b> - Output width
	 * <li><b>out_h, oh</b> - Output height
	 * <li><b>in</b> - Input frame count
	 * <li><b>on</b> - Output frame count
	 * <li><b>in_time, it</b> - The input timestamp expressed in seconds. It’s NAN if the input timestamp is
	 * unknown
	 * <li><b>out_time, time, ot</b> - The output timestamp expressed in seconds
	 * <li><b>x, y</b> - Last calculated ’x’ and ’y’ position from ’x’ and ’y’ expression for current input
	 * frame.
	 * <li><b>px, py</b> - ’x’ and ’y’ of last output frame of previous input frame or 0 when there was not
	 * yet such frame (first input frame
	 * <li><b>zoom</b> - Last calculated zoom from ’z’ expression for current input frame
	 * <li><b>pzoom</b> - Last calculated zoom of last output frame of previous input frame
	 * <li><b>duration</b> - Number of output frames for current input frame. Calculated from ’d’ expression
	 * for each input frame
	 * <li><b>pduration</b> - number of output frames created for previous input frame
	 * <li><b>a</b> - Rational number: input width / input height
	 * <li><b>sar</b> - sample aspect ratio
	 * <li><b>dar</b> - display aspect ratio
	 * </ul>
	 * 
	 * @apiNote (string) fps
	 * @param size the video frame rate
	 * @return the {@link ZoomPan} instance
	 */
	public ZoomPan fps( String rate ) {
		return super.addArg( "fps", rate );
	}

}
