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
import com.viiyue.ffmpeg.filter.AbstractFunction;
import com.viiyue.ffmpeg.util.Assert;

/**
 * <p>
 * Tone map colors from different dynamic ranges.
 * 
 * <p>
 * This filter expects data in single precision floating point, as it needs to operate on (and can output)
 * out-of-range values. Another filter, such as zscale, is needed to convert the resulting frame to a usable
 * format.
 * 
 * <p>
 * The tonemapping algorithms implemented only work on linear light, so input data should be linearized
 * beforehand (and possibly correctly tagged).
 * 
 * @author tangxbai
 * @since 2022/09/29
 * @see <a href="https://ffmpeg.org/ffmpeg-filters.html#tonemap-1">ffmpeg-filters#tonemap</a>
 */
@Function( "tonemap" )
public class ToneMap extends AbstractFunction<ToneMap> {

	// Don't let anyone instantiate this class
	private ToneMap() {}

	/**
	 * Quickly create an instances of {@link ToneMap}
	 * 
	 * @return the {@link ToneMap} instance
	 */
	public static final ToneMap of( Option option ) {
		return new ToneMap().addValue( option );
	}

	/**
	 * <p>
	 * Apply desaturation for highlights that exceed this level of brightness. The higher the parameter, the
	 * more color information will be preserved. This setting helps prevent unnaturally blown-out colors for
	 * super-highlights, by (smoothly) turning into white instead. This makes images feel more natural, at the
	 * cost of reducing information about out-of-range colors.
	 * 
	 * <p>
	 * The default of <b>2.0</b> is somewhat conservative and will mostly just apply to skies or directly
	 * sunlit surfaces. A setting of 0.0 disables this option.
	 * 
	 * <p>
	 * This option works only if the input frame has a supported color tag.
	 * 
	 * @apiNote (double) desat
	 * @param value the desat value
	 * @return the {@link ToneMap} instance
	 */
	public ToneMap desat( double value ) {
		Assert.rangeCheck( value, 0, 32767 );
		return super.addArg( "desat", value );
	}

	/**
	 * Override signal/nominal/reference peak with this value. Useful when the embedded peak information in
	 * display metadata is not reliable or when tone mapping from a lower range to a higher range.
	 * 
	 * @apiNote (double) peak
	 * @param value the signal peak override
	 * @return the {@link ToneMap} instance
	 */
	public ToneMap peak( double value ) {
		return super.addArg( "peak", value );
	}

	/**
	 * ToneMap enum options
	 * 
	 * @author tangxbai
	 * @since 2022/09/29
	 */
	public enum Option implements AbstractEnum {
		/** Do not apply any tone map, only desaturate overbright pixels. */
		NONE,
		/**
		 * Hard-clip any out-of-range values. Use it for perfect color accuracy for in-range values, while
		 * distorting out-of-range values.
		 */
		CLIP,
		/** Stretch the entire reference gamut to a linear multiple of the display. */
		LINEAR,
		/** Fit a logarithmic transfer between the tone curves. */
		GAMMA,
		/**
		 * Preserve overall image brightness with a simple curve, using nonlinear contrast, which results in
		 * flattening details and degrading color accuracy.
		 */
		REINHARD,
		/**
		 * Preserve both dark and bright details better than reinhard, at the cost of slightly darkening
		 * everything. Use it when detail preservation is more important than color and brightness accuracy.
		 */
		HABLE,
		/**
		 * Smoothly map out-of-range values, while retaining contrast and colors for in-range material as much
		 * as possible. Use it when color accuracy is more important than detail preservation.
		 */
		MOBIUS
	}

}
