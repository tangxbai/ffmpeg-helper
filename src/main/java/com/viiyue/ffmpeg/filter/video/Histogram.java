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

import com.viiyue.ffmpeg.annotation.Alias;
import com.viiyue.ffmpeg.annotation.Function;
import com.viiyue.ffmpeg.common.AbstractEnum;
import com.viiyue.ffmpeg.filter.AbstractFunction;
import com.viiyue.ffmpeg.util.Assert;

/**
 * <p>
 * Compute and draw a color distribution histogram for the input video.
 * 
 * <p>
 * The computed histogram is a representation of the color component distribution in an image.
 * 
 * <p>
 * Standard histogram displays the color components distribution in an image. Displays color graph for each
 * color component. Shows distribution of the Y, U, V, A or R, G, B components, depending on input format, in
 * the current frame. Below each graph a color component scale meter is shown.
 *
 * @author tangxbai
 * @since 2022/07/11
 * @see <a href="https://ffmpeg.org/ffmpeg-filters.html#histogram-1">ffmpeg-filters#histogram</a>
 */
@Function( "histeq" )
public class Histogram extends AbstractFunction<Histogram> {

	// Don't let anyone instantiate this class
	private Histogram() {}

	/**
	 * Quickly create an instances of {@link Histogram}
	 * 
	 * @return the {@link Histogram} instance
	 */
	public static final Histogram of() {
		return new Histogram();
	}

	/**
	 * Set height of level. Default value is <b>200</b>, allowed range is [50, 2048].
	 * 
	 * @apiNote (double) level_height
	 * @param value the level height
	 * @return the {@link Histogram} instance
	 */
	public Histogram levelHeight( int value ) {
		Assert.rangeCheck( value, 50, 2048 );
		return super.addArg( "level_height", value );
	}

	/**
	 * Set height of color scale. Default value is <b>200</b>, allowed range is [0, 40].
	 * 
	 * @apiNote (double) scale_height
	 * @param value the scale height
	 * @return the {@link Histogram} instance
	 */
	public Histogram scaleHeight( int value ) {
		Assert.rangeCheck( value, 50, 2048 );
		return super.addArg( "scale_height", value );
	}

	/**
	 * Set display mode, default is {@link DisplayMode#STACK}.
	 * 
	 * @apiNote (double) display_mode, d
	 * @param value the display mode
	 * @return the {@link Histogram} instance
	 */
	public Histogram displayMode( DisplayMode mode ) {
		return super.addArg( "d", mode ); // display_mode, d
	}

	/**
	 * Set levels mode, default is {@link LevelMode#LINEAR}.
	 * 
	 * @apiNote (double) levels_mode, m
	 * @param value the level mode
	 * @return the {@link Histogram} instance
	 */
	public Histogram levelMode( LevelMode mode ) {
		return super.addArg( "d", mode ); // levels_mode, m
	}

	/**
	 * Set what color components to display, allowed value range is from 1 to 15, default is <b>7</b>.
	 * 
	 * @apiNote (int) components, c
	 * @param value the color component
	 * @return the {@link Histogram} instance
	 */
	public Histogram components( int value ) {
		return super.addArg( "c", value ); // components, c
	}

	/**
	 * Set foreground opacity, allowed value range is from 0 to 1, default is <b>0.7</b>.
	 * 
	 * @apiNote (double) fgopacity, f
	 * @param value the foreground opacity
	 * @return the {@link Histogram} instance
	 */
	public Histogram fgOpacity( double value ) {
		return super.addArg( "f", value ); // fgopacity, f
	}

	/**
	 * Set background opacity, allowed value range is from 0 to 1, default is <b>0.5</b>.
	 * 
	 * @apiNote (double) bgopacity, b
	 * @param value the foreground opacity
	 * @return the {@link Histogram} instance
	 */
	public Histogram bgOpacity( double value ) {
		return super.addArg( "b", value ); // bgopacity, b
	}

	/**
	 * Set the colors mode
	 * 
	 * @apiNote (flags) colors_mode, l
	 * @param mode the colors mode
	 * @return the {@link Histogram} instance
	 */
	public Histogram colorsMode( ColorsMode mode ) {
		return super.addArg( "l", mode ); // colors_mode, l
	}

	/**
	 * Display mode
	 *
	 * @author tangxbai
	 * @since 2022/07/11
	 */
	public enum DisplayMode implements AbstractEnum {
		STACK, PARADE, OVERLAY
	}

	/**
	 * Levels mode
	 *
	 * @author tangxbai
	 * @since 2022/07/11
	 */
	public enum LevelMode implements AbstractEnum {
		LINEAR, LOGARITHMIC
	}

	/**
	 * Colors mode
	 *
	 * @author tangxbai
	 * @since 2022/07/11
	 */
	public enum ColorsMode implements AbstractEnum {
		@Alias( "whiteonblack" )
		WHITEON_BLACK, 
		@Alias( "blackonwhite" )
		BLACKON_WHITE, 
		@Alias( "whiteongray" )
		WHITE_ONGRAY, 
		@Alias( "blackongray" )
		BLACK_ONGRAY, 
		@Alias( "coloronblack" )
		COLORON_BLACK, 
		@Alias( "coloronwhite" )
		COLORON_WHITE, 
		@Alias( "colorongray" )
		COLORON_GRAY, 
		@Alias( "blackoncolor" )
		BLACKON_COLOR, 
		@Alias( "whiteoncolor" )
		WHITEON_COLOR, 
		@Alias( "grayoncolor" )
		GRAYON_COLOR
	}

}
