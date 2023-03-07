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
import com.viiyue.ffmpeg.enums.Envelope;
import com.viiyue.ffmpeg.enums.Graticule;
import com.viiyue.ffmpeg.filter.AbstractFunction;
import com.viiyue.ffmpeg.util.Assert;

/**
 * <p>
 * Video waveform monitor.
 * 
 * <p>
 * The waveform monitor plots color component intensity. By default luminance only. Each column of the
 * waveform corresponds to a column of pixels in the source video.
 * 
 * @author tangxbai
 * @since 2022/10/14
 * @see <a href= "https://ffmpeg.org/ffmpeg-filters.html#waveform">ffmpeg-filters#waveform</a>
 */
@Function( "w3fdif" )
public class WaveForm extends AbstractFunction<WaveForm> {

	// Don't let anyone instantiate this class
	private WaveForm() {}

	/**
	 * Quickly create an instances of {@link WaveForm}
	 * 
	 * @return the {@link WaveForm} instance
	 */
	public static final WaveForm of() {
		return new WaveForm();
	}

	/**
	 * Can be either {@link Mode#ROW}, or {@link Mode#COLUMN}. Default is {@link Mode#COLUMN}. In
	 * {@link Mode#ROW} mode, the graph on the left side represents color component value 0 and the right side
	 * represents value = 255. In {@link Mode#COLUMN} mode, the top side represents color component value = 0
	 * and bottom side represents value = 255.
	 * 
	 * @apiNote (flags) mode, m
	 * @param mode the waveform mode
	 * @return the {@link WaveForm} instance
	 * @see Mode
	 */
	public WaveForm mode( Mode mode ) {
		return super.addArg( "m", mode ); // mode, m
	}

	/**
	 * Set intensity. Smaller values are useful to find out how many values of the same luminance are
	 * distributed across input rows/columns. Default value is <b>0.04</b>. Allowed range is [0, 1].
	 * 
	 * @apiNote (double) intensity
	 * @param value the intensity value
	 * @return the {@link WaveForm} instance
	 */
	public WaveForm intensity( double value ) {
		Assert.rangeCheck( value, 0, 1 );
		return super.addArg( "i", value ); // intensity, i
	}

	/**
	 * Set mirroring mode. {@code false} means unmirrored, {@code true} means mirrored. In mirrored mode,
	 * higher values will be represented on the left side for row mode and at the top for column mode. Default
	 * is {@code true} (mirrored).
	 * 
	 * @apiNote (double) intensity
	 * @param value the intensity value
	 * @return the {@link WaveForm} instance
	 */
	public WaveForm unmirrored() {
		return super.enable( "mirror" );
	}

	/**
	 * Set display mode. Default value is {@link Display#STACK}.
	 * 
	 * @apiNote (flags) display, d
	 * @return the {@link WaveForm} instance
	 * @see Display
	 */
	public WaveForm display( Display display ) {
		return super.addArg( "d", display ); // display, d
	}

	/**
	 * Set which color components to display. Default is <b>1</b>, which means only luminance or red color
	 * component if input is in RGB colorspace. If is set for example to 7 it will display all 3 (if)
	 * available color components.
	 * 
	 * @apiNote (int) components, c
	 * @param value the components value to display
	 * @return the {@link WaveForm} instance
	 */
	public WaveForm components( int value ) {
		Assert.rangeCheck( value, 1, 15 );
		return super.addArg( "d", value ); // components, c
	}

	/**
	 * Set envelope to display
	 * 
	 * @apiNote (int) envelope, e
	 * @param envelope the display envelope flag
	 * @return the {@link WaveForm} instance
	 * @see Envelope
	 */
	public WaveForm envelope( Envelope envelope ) {
		return super.addArg( "e", envelope ); // envelope, e
	}

	/**
	 * Set filter
	 * 
	 * @apiNote (int) filter, f
	 * @param filter the filter flag
	 * @return the {@link WaveForm} instance
	 * @see Filter
	 */
	public WaveForm filter( Filter filter ) {
		return super.addArg( "f", filter ); // filter, f
	}

	/**
	 * Set which graticule to display
	 * 
	 * @apiNote (int) graticule, g
	 * @param filter the filter flag
	 * @return the {@link WaveForm} instance
	 * @see Filter
	 */
	public WaveForm graticule( Graticule graticule ) {
		return super.addArg( "g", graticule ); // graticule, g
	}

	/**
	 * Set graticule opacity. Values range is from 0 to 1, default is <b>0.75</b>.
	 * 
	 * @apiNote (int) opacity, o
	 * @param value the opacity value
	 * @return the {@link WaveForm} instance
	 */
	public WaveForm opacity( double value ) {
		Assert.rangeCheck( value, 0, 1 );
		return super.addArg( "o", value ); // opacity, o
	}

	/**
	 * Set graticule flags
	 * 
	 * @apiNote (flags) flags, fl
	 * @param flags the graticule flags
	 * @return the {@link WaveForm} instance
	 * @see Flags
	 */
	public WaveForm flags( Flags flags ) {
		return super.addArg( "fl", flags ); // flags, fl
	}

	/**
	 * Set scale used for displaying graticule. Default is {@link Scale#DIGITAL}.
	 * 
	 * @apiNote (flags) scale, s
	 * @param flags the graticule flags
	 * @return the {@link WaveForm} instance
	 * @see Scale
	 */
	public WaveForm scale( Scale scale ) {
		return super.addArg( "s", scale ); // scale, s
	}

	/**
	 * Set background opacity. Values range is from 0 to 1, default is <b>0.75</b>.
	 * 
	 * @apiNote (int) bgopacity, b
	 * @param value the background opacity value
	 * @return the {@link WaveForm} instance
	 */
	public WaveForm bgOpacity( double value ) {
		Assert.rangeCheck( value, 0, 1 );
		return super.addArg( "b", value ); // bgopacity, b
	}

	/**
	 * Set tint for output. Only used with lowpass filter and when display is not overlay and input pixel
	 * formats are not RGB.
	 * 
	 * @apiNote (double) tint0, t0
	 * @param value the 1st tint value
	 * @return the {@link WaveForm} instance
	 */
	public WaveForm tint0( double value ) {
		Assert.rangeCheck( value, -1, 1 );
		return super.addArg( "t0", value ); // tint0, t0
	}

	/**
	 * Set tint for output. Only used with lowpass filter and when display is not overlay and input pixel
	 * formats are not RGB.
	 * 
	 * @apiNote (double) tint1, t1
	 * @param value the 2nd tint value
	 * @return the {@link WaveForm} instance
	 */
	public WaveForm tint1( double value ) {
		Assert.rangeCheck( value, -1, 1 );
		return super.addArg( "t1", value ); // tint1, t1
	}

	/**
	 * Set sample aspect ratio of video output frames. Can be used to configure waveform so it is not streched
	 * too much in one of directions.
	 * 
	 * @apiNote (flags) fitmode, fm
	 * @param flags the graticule flags
	 * @return the {@link WaveForm} instance
	 * @see FitMode
	 */
	public WaveForm fitMode( FitMode mode ) {
		return super.addArg( "fm", mode ); // fitmode, fm
	}

	/**
	 * Waveform mode
	 *
	 * @author tangxbai
	 * @since 2022/10/14
	 */
	public enum Mode implements AbstractEnum {
		ROW, COLUMN
	}

	/**
	 * Display mode
	 *
	 * @author tangxbai
	 * @since 2022/10/14
	 */
	public enum Display implements AbstractEnum {
		/**
		 * Presents information identical to that in the {@code parade}, except that the graphs representing
		 * color components are superimposed directly over one another.
		 * 
		 * This display mode makes it easier to spot relative differences or similarities in overlapping areas
		 * of the color components that are supposed to be identical, such as neutral whites, grays, or
		 * blacks.
		 */
		OVERLAY,

		/**
		 * Display separate graph for the color components side by side in row mode or one below the other in
		 * {@link Mode#COLUMN} mode.
		 */
		STACK,

		/**
		 * Display separate graph for the color components side by side in {@link Mode#COLUMN} mode or one
		 * below the other in {@link Mode#ROW} mode.
		 * 
		 * Using this display mode makes it easy to spot color casts in the highlights and shadows of an
		 * image, by comparing the contours of the top and the bottom graphs of each waveform. Since whites,
		 * grays, and blacks are characterized by exactly equal amounts of red, green, and blue, neutral areas
		 * of the picture should display three waveforms of roughly equal width/height. If not, the correction
		 * is easy to perform by making level adjustments the three waveforms.
		 */
		PARADE
	}

	/**
	 * Filter type
	 *
	 * @author tangxbai
	 * @since 2022/10/14
	 */
	public enum Filter implements AbstractEnum {
		/** No filtering, this is default. */
		LOWPASS,
		/** Luma and chroma combined together */
		FLAT,
		/** Similar as above, but shows difference between blue and red chroma */
		@Alias( "aflat" )
		A_FLAT,
		/** Similar as above, but use different colors. */
		@Alias( "xflat" )
		X_FLAT,
		/** Similar as above, but again with different colors. */
		@Alias( "yflat" )
		Y_FLAT,
		/** Displays only chroma */
		CHROMA,
		/** Displays actual color value on waveform */
		COLOR,
		/** Similar as above, but with luma showing frequency of chroma values. */
		@Alias( "acolor" )
		A_COLOR
	}

	/**
	 * Graticule flags
	 *
	 * @author tangxbai
	 * @since 2022/10/14
	 */
	public enum Flags implements AbstractEnum {
		/** Draw numbers above lines. By default enabled. */
		NUMBERS,
		/** Draw dots instead of lines */
		DOTS
	}

	/**
	 * Graticule scale
	 *
	 * @author tangxbai
	 * @since 2022/10/14
	 */
	public enum Scale implements AbstractEnum {
		DIGITAL, MILLIVOLTS, IRE
	}

	/**
	 * Fit mode
	 *
	 * @author tangxbai
	 * @since 2022/10/14
	 */
	public enum FitMode implements AbstractEnum {
		/** Set sample aspect ration to 1/1 */
		NONE,
		/** Set sample aspect ratio to match input size of video */
		SIZE
	}

}
