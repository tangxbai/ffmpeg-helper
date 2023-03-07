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
import com.viiyue.ffmpeg.common.AbstractEnum;
import com.viiyue.ffmpeg.enums.Color;
import com.viiyue.ffmpeg.filter.AbstractFunction;
import com.viiyue.ffmpeg.util.Assert;

/**
 * Generate one palette for a whole video stream
 * 
 * @author tangxbai
 * @since 2022/07/20
 * @see <a href="https://ffmpeg.org/ffmpeg-filters.html#palettegen-1">ffmpeg-filters#palettegen</a>
 */
@Function( "palettegen" )
public class PaletteGen extends AbstractFunction<PaletteGen> {

	// Don't let anyone instantiate this class
	private PaletteGen() {}

	/**
	 * Quickly create an instances of {@link PaletteGen}
	 * 
	 * @return the {@link PaletteGen} instance
	 */
	public static final PaletteGen of() {
		return new PaletteGen();
	}

	/**
	 * Set the maximum number of colors to quantize in the palette. Note: the palette will still contain 256
	 * colors; the unused palette entries will be black.
	 * 
	 * @apiNote (int) max_colors
	 * @param value the maximum number of colors
	 * @return the {@link PaletteGen} instance
	 */
	public PaletteGen maxColors( int value ) {
		Assert.rangeCheck( value, 4, 256 );
		return super.addArg( "max_colors", value );
	}

	/**
	 * Create a palette of 255 colors maximum and reserve the last one for transparency. Reserving the
	 * transparency color is useful for GIF optimization. If not set, the maximum of colors in the palette
	 * will be 256. You probably want to disable this option for a standalone image. Set by default.
	 * 
	 * @apiNote (boolean) reserve_transparent
	 * @param state whether to keep palette entries for transparency
	 * @return the {@link PaletteGen} instance
	 */
	public PaletteGen reserveTransparent( boolean state ) {
		return super.status( "reserve_transparent", state );
	}

	/**
	 * Set the color that will be used as background for transparency
	 * 
	 * @apiNote (color) transparency_color
	 * @param color the used as background for transparency
	 * @return the {@link PaletteGen} instance
	 */
	public PaletteGen transparencyColor( String color ) {
		return super.addArg( "transparency_color", color );
	}

	/**
	 * Set the color that will be used as background for transparency
	 * 
	 * @apiNote (color) transparency_color
	 * @param color the used as background for transparency
	 * @return the {@link PaletteGen} instance
	 * @see Color
	 */
	public PaletteGen transparencyColor( Color color ) {
		return super.addArg( "transparency_color", color );
	}

	/**
	 * Set statistics mode
	 * 
	 * @apiNote (flags) stats_mode
	 * @param mode the statistics mode
	 * @return the {@link PaletteGen} instance
	 * @see StatsMode
	 */
	public PaletteGen statsMode( StatsMode mode ) {
		return super.addArg( "stats_mode", mode );
	}

	/**
	 * Create a palette of colors with alpha components. Setting this, will automatically disable
	 * 'reserve_transparent'.
	 * 
	 * @apiNote (boolean) use_alpha
	 * @return the {@link PaletteGen} instance
	 */
	public PaletteGen useAlpha() {
		return super.enable( "use_alpha" );
	}

	/**
	 * Statistics mode
	 *
	 * @author tangxbai
	 * @since 2022/07/20
	 */
	public enum StatsMode implements AbstractEnum {
		/** Compute full frame histograms */
		FULL,
		/** Compute new histogram for each frame */
		SINGLE,
		/**
		 * Compute histograms only for the part that differs from previous frame. This might be relevant to
		 * give more importance to the moving part of your input if the background is static.
		 */
		DIFF
	}

}
