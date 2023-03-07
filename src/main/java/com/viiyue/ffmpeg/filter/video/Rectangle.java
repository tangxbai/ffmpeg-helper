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
import com.viiyue.ffmpeg.filter.AbstractColorFunction;

/**
 * Draw a colored box on the input image.
 * 
 * @author tangxbai
 * @since 2022/06/02
 */
@Function( "drawbox" )
public class Rectangle extends AbstractColorFunction<Rectangle> {

	// Don't let anyone instantiate this class
	private Rectangle() {}

	public static final Rectangle the( int x, int y, int w, int h ) {
		return new Rectangle().position( x, y, w, h );
	}

	public static final Rectangle the( String x, String y, String w, String h ) {
		return new Rectangle().position( x, y, w, h );
	}

	/**
	 * Specify the box size, including parameters such as width, height and coordinates
	 * 
	 * <pre>
	 * <b>x, y</b>: The x and y offset coordinates where the box is drawn.
	 * <b>ih, iw</b>: The input width and height.
	 * 
	 * <b>DEMO</b>: 
	 * y = 0.5*(ih-iw/2.4)
	 * w = iw*2
	 * h = iw/2.4
	 * </pre>
	 * 
	 * @param x The expressions which specify the left corner coordinates of the box
	 * @param y The expressions which specify the top corner coordinates of the box
	 * @param w The expressions which specify the width of the box
	 * @param h The expressions which specify the height of the box
	 * @return the {@link Rectangle} instance
	 */
	private Rectangle position( Object x, Object y, Object w, Object h ) {
		super.addArg( "x", x );
		super.addArg( "y", y );
		super.addArg( "w", w );
		super.addArg( "h", h );
		return this;
	}

	/**
	 * The expression which sets the thickness of the box edge. A value of {@code fill} will create
	 * a filled box. Default value is 3.
	 * 
	 * @param thickness the thickness of the box edge( "fill" or number value )
	 * @return the {@link Rectangle} instance
	 */
	public Rectangle thickness( String thickness ) {
		return super.addArg( "t", thickness );
	}

	/**
	 * Create a filled box
	 * 
	 * @return the {@link Rectangle} instance
	 */
	public Rectangle fill() {
		return thickness( "fill" );
	}

}
