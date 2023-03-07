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
import com.viiyue.ffmpeg.enums.EofAction;
import com.viiyue.ffmpeg.enums.Overlays;
import com.viiyue.ffmpeg.enums.When;
import com.viiyue.ffmpeg.filter.AbstractFunction;

/**
 * <p>
 * Overlay one video on top of another.
 * 
 * <p>
 * This is the CUDA variant of the overlay filter. It only accepts CUDA frames. The underlying input pixel
 * formats have to match.
 * 
 * <p>
 * It takes two inputs and has one output. The first input is the "main" video on which the second input is
 * overlaid.
 * 
 * @author tangxbai
 * @since 2022/06/02
 * @see <a href="https://ffmpeg.org/ffmpeg-filters.html#overlay_cuda-1">ffmpeg-filters#overlay_cuda</a>
 */
@Function( "overlay_cuda" )
public class OverlayCuda extends AbstractFunction<OverlayCuda> {

	// Don't let anyone instantiate this class
	private OverlayCuda() {}

	/**
	 * Quickly create an instances of {@link OverlayCuda}
	 * 
	 * @apiNote (int) x/y
	 * @param x the x coordinate position
	 * @param y the y coordinate position
	 * @return the {@link OverlayCuda} instance
	 */
	public static final OverlayCuda at( double x, double y ) {
		return new OverlayCuda().position( x, y );
	}

	/**
	 * <p>
	 * Quickly create an instances of {@link OverlayCuda}
	 * 
	 * <p>
	 * The x, and y expressions can contain the following parameters.
	 * 
	 * <ul>
	 * <li><b>main_w, W main_h, H</b> - the main input width and height.
	 * <li><b>overlay_w, w overlay_h, h</b> - the overlay input width and height.
	 * <li><b>x y</b> - the computed values for x and y. They are evaluated for each new frame.
	 * <li><b>n</b> - the number of input frame, starting from 0
	 * <li><b>pos</b> - the position in the file of the input frame, NAN if unknown
	 * <li><b>t</b> - the timestamp, expressed in seconds. It’s NAN if the input timestamp is unknown.
	 * </ul>
	 * 
	 * @apiNote (string) x/y
	 * @param x the x coordinate expression
	 * @param y the y coordinate expression
	 * @return the {@link OverlayCuda} instance
	 */
	public static final OverlayCuda at( String x, String y ) {
		return new OverlayCuda().position( x, y );
	}

	/**
	 * Quickly create an instances of {@link OverlayCuda}
	 * 
	 * @param overlays the overlay constant
	 * @return the {@link OverlayCuda} instance
	 */
	public static final OverlayCuda at( Overlays overlays ) {
		return new OverlayCuda().position( overlays.getX( 0D ), overlays.getY( 0D ) );
	}

	/**
	 * Quickly create an instances of {@link OverlayCuda}
	 * 
	 * @param overlays the overlay constant
	 * @param x        the x coordinate position
	 * @param y        the y coordinate position
	 * @return the {@link OverlayCuda} instance
	 */
	public static final OverlayCuda at( Overlays overlays, double x, double y ) {
		return new OverlayCuda().position( overlays.getX( x ), overlays.getY( y ) );
	}

	/**
	 * Quickly create an instances of {@link OverlayCuda}
	 * 
	 * @param overlays the overlay constant
	 * @param x        the x coordinate expression
	 * @param y        the y coordinate expression
	 * @return the {@link OverlayCuda} instance
	 */
	public static final OverlayCuda at( Overlays overlays, String x, String y ) {
		return new OverlayCuda().position( overlays.getX( x ), overlays.getY( y ) );
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
	 * <li><b>n</b> - the number of input frame, starting from 0
	 * <li><b>pos</b> - the position in the file of the input frame, NAN if unknown
	 * <li><b>t</b> - the timestamp, expressed in seconds. It’s NAN if the input timestamp is unknown.
	 * </ul>
	 * 
	 * @param x the x coordinate position or expression
	 * @param y the y coordinate position or expression
	 * @return the {@link OverlayCuda} instance
	 */
	private OverlayCuda position( Object x, Object y ) {
		return super.addBaseArg( "x", x ).addBaseArg( "y", y );
	}

	/**
	 * Set when the expressions for x, and y are evaluated.
	 * 
	 * @apiNote (flags) eval
	 * @param when the expression evaluated time
	 * @return the {@link OverlayCuda} instance
	 */
	public OverlayCuda eval( When when ) {
		return super.addArg( "eval", when );
	}

	/**
	 * The action to take when EOF is encountered on the secondary input
	 * 
	 * @apiNote (flags) eof_action
	 * @param action the EOF action
	 * @return the {@link OverlayCuda} instance
	 */
	public OverlayCuda action( EofAction action ) {
		return super.addArg( "eof_action", action );
	}

	/**
	 * If set to {@code true}, force the output to terminate when the shortest input terminates. default value
	 * is {@code false}.
	 * 
	 * @apiNote (boolean) shorttest
	 * @param state the shortest state
	 * @return the {@link OverlayCuda} instance
	 */
	public OverlayCuda shortest( boolean state ) {
		return super.status( "shortest", state );
	}

	/**
	 * If set to true, force the filter to extend the last frame of secondary streams until the end of the
	 * primary stream.
	 * 
	 * @apiNote (boolean) repeatlast
	 * @param state the repeat last state
	 * @return the {@link OverlayCuda} instance
	 */
	public OverlayCuda repeatLast( boolean state ) {
		return super.status( "repeatlast", state );
	}

}
