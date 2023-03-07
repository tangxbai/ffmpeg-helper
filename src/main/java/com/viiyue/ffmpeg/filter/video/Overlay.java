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
import com.viiyue.ffmpeg.common.AbstractEnum;
import com.viiyue.ffmpeg.enums.EofAction;
import com.viiyue.ffmpeg.enums.Overlays;
import com.viiyue.ffmpeg.enums.When;
import com.viiyue.ffmpeg.filter.AbstractFunction;

/**
 * <p>
 * Overlay one video on top of another.
 * 
 * <p>
 * It takes two inputs and has one output. The first input is the "main" video on which the second input is
 * overlaid.
 * 
 * @author tangxbai
 * @since 2022/06/02
 * @see <a href="https://ffmpeg.org/ffmpeg-filters.html#overlay-1">ffmpeg-filters#overlay</a>
 */
@Function( "overlay" )
public class Overlay extends AbstractFunction<Overlay> {

	// Don't let anyone instantiate this class
	private Overlay() {}

	/**
	 * Quickly create an instances of {@link Overlay}
	 * 
	 * @apiNote (int) x/y
	 * @param x the x coordinate position
	 * @param y the y coordinate position
	 * @return the {@link Overlay} instance
	 */
	public static final Overlay at( double x, double y ) {
		return new Overlay().position( x, y );
	}

	/**
	 * <p>
	 * Quickly create an instances of {@link Overlay}
	 * 
	 * <p>
	 * The x, and y expressions can contain the following parameters.
	 * 
	 * <ul>
	 * <li><b>main_w, W main_h, H</b> - the main input width and height.
	 * <li><b>overlay_w, w overlay_h, h</b> - the overlay input width and height.
	 * <li><b>x y</b> - the computed values for x and y. They are evaluated for each new frame.
	 * <li><b>hsub vsub</b> - horizontal and vertical chroma subsample values of the output format. For
	 * example for the pixel format "yuv422p" hsub is 2 and vsub is 1.
	 * <li><b>n</b> - the number of input frame, starting from 0
	 * <li><b>pos</b> - the position in the file of the input frame, NAN if unknown
	 * <li><b>t</b> - the timestamp, expressed in seconds. It’s NAN if the input timestamp is unknown.
	 * </ul>
	 * 
	 * @apiNote (string) x/y
	 * @param x the x coordinate expression
	 * @param y the y coordinate expression
	 * @return the {@link Overlay} instance
	 */
	public static final Overlay at( String x, String y ) {
		return new Overlay().position( x, y );
	}

	/**
	 * Quickly create an instances of {@link Overlay}
	 * 
	 * @param overlays the overlay constant
	 * @return the {@link Overlay} instance
	 */
	public static final Overlay at( Overlays overlays ) {
		return new Overlay().position( overlays.getX( 0D ), overlays.getY( 0D ) );
	}

	/**
	 * Quickly create an instances of {@link Overlay}
	 * 
	 * @param overlays the overlay constant
	 * @param x        the x coordinate position
	 * @param y        the y coordinate position
	 * @return the {@link Overlay} instance
	 */
	public static final Overlay at( Overlays overlays, double x, double y ) {
		return new Overlay().position( overlays.getX( x ), overlays.getY( y ) );
	}

	/**
	 * Quickly create an instances of {@link Overlay}
	 * 
	 * @param overlays the overlay constant
	 * @param x        the x coordinate expression
	 * @param y        the y coordinate expression
	 * @return the {@link Overlay} instance
	 */
	public static final Overlay at( Overlays overlays, String x, String y ) {
		return new Overlay().position( overlays.getX( x ), overlays.getY( y ) );
	}

	/**
	 * <p>
	 * Set the expression for the x and y coordinates of the overlaid video on the main video. Default value
	 * is "0" for both expressions. In case the expression is invalid, it is set to a huge value (meaning that
	 * the overlay will not be displayed within the output visible area).
	 * 
	 * <p>
	 * The x, and y expressions can contain the following parameters.
	 * 
	 * <ul>
	 * <li><b>main_w, W main_h, H</b> - the main input width and height.
	 * <li><b>overlay_w, w overlay_h, h</b> - the overlay input width and height.
	 * <li><b>x y</b> - the computed values for x and y. They are evaluated for each new frame.
	 * <li><b>hsub vsub</b> - horizontal and vertical chroma subsample values of the output format. For
	 * example for the pixel format "yuv422p" hsub is 2 and vsub is 1.
	 * <li><b>n</b> - the number of input frame, starting from 0
	 * <li><b>pos</b> - the position in the file of the input frame, NAN if unknown
	 * <li><b>t</b> - the timestamp, expressed in seconds. It’s NAN if the input timestamp is unknown.
	 * </ul>
	 * 
	 * @param x the x coordinate position or expression
	 * @param y the y coordinate position or expression
	 * @return the {@link Overlay} instance
	 */
	private Overlay position( Object x, Object y ) {
		return super.addBaseArg( "x", x ).addBaseArg( "y", y );
	}

	/**
	 * Set when the expressions for x, and y are evaluated.
	 * 
	 * @apiNote (flags) eval
	 * @param when the expression evaluated time
	 * @return the {@link Overlay} instance
	 */
	public Overlay eval( When when ) {
		return super.addArg( "eval", when );
	}

	/**
	 * Set the format for the output video.
	 * 
	 * @apiNote (flags) format
	 * @param format the output video format
	 * @return the {@link Overlay} instance
	 * @see OuputFormat
	 */
	public Overlay format( OuputFormat format ) {
		return super.addArg( "format", format );
	}

	/**
	 * Set format of alpha of the overlaid video, it can be straight or premultiplied. Default is straight.
	 * 
	 * @apiNote (flags) alpha
	 * @param format the alpha format
	 * @return the {@link Overlay} instance
	 * @see AlphaFormat
	 */
	public Overlay alpha( AlphaFormat format ) {
		return super.addArg( "alpha", format );
	}

	/**
	 * The action to take when EOF is encountered on the secondary input
	 * 
	 * @apiNote (flags) eof_action
	 * @param action the EOF action
	 * @return the {@link Overlay} instance
	 */
	public Overlay action( EofAction action ) {
		return super.addArg( "eof_action", action );
	}

	/**
	 * If set to {@code true}, force the output to terminate when the shortest input terminates. default value
	 * is {@code false}.
	 * 
	 * @apiNote (boolean) shorttest
	 * @param state the shortest state
	 * @return the {@link Overlay} instance
	 */
	public Overlay shortest( boolean state ) {
		return super.status( "shortest", state );
	}

	/**
	 * If set to true, force the filter to extend the last frame of secondary streams until the end of the
	 * primary stream.
	 * 
	 * @apiNote (boolean) repeatlast
	 * @param state the repeat last state
	 * @return the {@link Overlay} instance
	 */
	public Overlay repeatLast( boolean state ) {
		return super.status( "repeatlast", state );
	}

	/**
	 * Output video fromat
	 *
	 * @author tangxbai
	 * @since 2022/07/19
	 */
	public enum OuputFormat implements AbstractEnum {
		YUV420, YUV420P10, YUV422, YUV422P10, YUV444, RGB, GBRP, AUTO
	}

	/**
	 * Output video fromat
	 *
	 * @author tangxbai
	 * @since 2022/07/19
	 */
	public enum AlphaFormat implements AbstractEnum {
		STRAIGHT, PREMULTIPLIED
	}

}
