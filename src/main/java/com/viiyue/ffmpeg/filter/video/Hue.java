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
import com.viiyue.ffmpeg.util.Assert;

/**
 * <p>
 * Modify the hue and/or the saturation of the input
 *
 * <p>
 * {@link #angle(int)}/{@link #angle(String)} and {@link #radians(int)}/{@link #radians(String)} are mutually
 * exclusive, and can’t be specified at the same time.
 *
 * @author tangxbai
 * @since 2022/07/11
 * @see <a href="https://ffmpeg.org/ffmpeg-filters.html#hue">ffmpeg-filters#hue</a>
 */
@Function( "hue" )
public class Hue extends AbstractFunction<Hue> {

	// Don't let anyone instantiate this class
	private Hue() {}

	/**
	 * Quickly create an instances of {@link Hue}
	 * 
	 * @return the {@link Hue} instance
	 */
	public static final Hue of() {
		return new Hue();
	}

	/**
	 * Specify the hue angle as a number of degrees. It accepts an expression, and defaults to <b>0</b>.
	 * 
	 * @apiNote (int) h
	 * @param value the hue angle degrees
	 * @return the {@link Hue} instance
	 */
	public Hue angle( int value ) {
		return super.addArg( "h", value );
	}

	/**
	 * <p>
	 * Specify the hue angle as a number of degrees. It accepts an expression, and defaults to "0".
	 * 
	 * <p>
	 * The values are expressions containing the following constants:
	 * 
	 * <ul>
	 * <li><b>n</b> - frame count of the input frame starting from 0
	 * <li><b>pts</b> - presentation timestamp of the input frame expressed in time base units
	 * <li><b>r</b> - frame rate of the input video, NAN if the input frame rate is unknown
	 * <li><b>t</b> - timestamp expressed in seconds, NAN if the input timestamp is unknown
	 * <li><b>tb</b> - time base of the input video
	 * </ul>
	 * 
	 * @apiNote (string) h
	 * @param value the hue angle degrees expression
	 * @return the {@link Hue} instance
	 */
	public Hue angle( String expression ) {
		return super.addArg( "h", expression );
	}

	/**
	 * 
	 * Specify the saturation in the [-10,10] range. It accepts an expression and defaults to <b>1</b>.
	 * 
	 * @apiNote (int) s
	 * @param value the saturation value
	 * @return the {@link Hue} instance
	 */
	public Hue saturation( int value ) {
		Assert.rangeCheck( value, -10, 10 );
		return super.addArg( "s", value );
	}

	/**
	 * <p>
	 * Specify the saturation in the [-10,10] range. It accepts an expression and defaults to "1".
	 * 
	 * <p>
	 * The values are expressions containing the following constants:
	 * 
	 * <ul>
	 * <li><b>n</b> - frame count of the input frame starting from 0
	 * <li><b>pts</b> - presentation timestamp of the input frame expressed in time base units
	 * <li><b>r</b> - frame rate of the input video, NAN if the input frame rate is unknown
	 * <li><b>t</b> - timestamp expressed in seconds, NAN if the input timestamp is unknown
	 * <li><b>tb</b> - time base of the input video
	 * </ul>
	 * 
	 * @apiNote (string) s
	 * @param value the saturation expression
	 * @return the {@link Hue} instance
	 */
	public Hue saturation( String expression ) {
		return super.addArg( "s", expression );
	}

	/**
	 * Specify the saturation in the [-10,10] range. It accepts an expression and defaults to <b>0</b>.
	 * 
	 * @apiNote (int) H
	 * @param value the hue angle radians value
	 * @return the {@link Hue} instance
	 */
	public Hue radians( int value ) {
		return super.addArg( "H", value );
	}

	/**
	 * <p>
	 * Specify the saturation in the [-10,10] range. It accepts an expression and defaults to "0".
	 * 
	 * <p>
	 * The values are expressions containing the following constants:
	 * 
	 * <ul>
	 * <li><b>n</b> - frame count of the input frame starting from 0
	 * <li><b>pts</b> - presentation timestamp of the input frame expressed in time base units
	 * <li><b>r</b> - frame rate of the input video, NAN if the input frame rate is unknown
	 * <li><b>t</b> - timestamp expressed in seconds, NAN if the input timestamp is unknown
	 * <li><b>tb</b> - time base of the input video
	 * </ul>
	 * 
	 * @apiNote (string) H
	 * @param value the hue angle radians expression
	 * @return the {@link Hue} instance
	 */
	public Hue radians( String expression ) {
		return super.addArg( "H", expression );
	}

	/**
	 * Specify the brightness in the [-10,10] range. It accepts an expression and defaults to <b>0</b>.
	 * 
	 * @apiNote (int) b
	 * @param value the brightness value
	 * @return the {@link Hue} instance
	 */
	public Hue brightness( int value ) {
		return super.addArg( "b", value );
	}

	/**
	 * <p>
	 * Specify the brightness in the [-10,10] range. It accepts an expression and defaults to "0".
	 * 
	 * <p>
	 * The values are expressions containing the following constants:
	 * 
	 * <ul>
	 * <li><b>n</b> - frame count of the input frame starting from 0
	 * <li><b>pts</b> - presentation timestamp of the input frame expressed in time base units
	 * <li><b>r</b> - frame rate of the input video, NAN if the input frame rate is unknown
	 * <li><b>t</b> - timestamp expressed in seconds, NAN if the input timestamp is unknown
	 * <li><b>tb</b> - time base of the input video
	 * </ul>
	 * 
	 * @apiNote (string) H
	 * @param value the brightness expression
	 * @return the {@link Hue} instance
	 */
	public Hue brightness( String expression ) {
		return super.addArg( "b", expression );
	}

}
