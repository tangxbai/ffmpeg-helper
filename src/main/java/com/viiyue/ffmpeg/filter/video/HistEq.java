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
 * This filter applies a global color histogram equalization on a per-frame basis.
 * 
 * <p>
 * It can be used to correct video that has a compressed range of pixel intensities. The filter redistributes
 * the pixel intensities to equalize their distribution across the intensity range. It may be viewed as an
 * "automatically adjusting contrast filter". This filter is useful only for correcting degraded or poorly
 * captured source video.
 *
 * @author tangxbai
 * @since 2022/07/11
 * @see <a href="https://ffmpeg.org/ffmpeg-filters.html#histeq">ffmpeg-filters#histeq</a>
 */
@Function( "histeq" )
public class HistEq extends AbstractFunction<HistEq> {

	// Don't let anyone instantiate this class
	private HistEq() {}

	/**
	 * Quickly create an instances of {@link HistEq}
	 * 
	 * @return the {@link HistEq} instance
	 */
	public static final HistEq of() {
		return new HistEq();
	}

	/**
	 * Determine the amount of equalization to be applied. As the strength is reduced, the distribution of
	 * pixel intensities more-and-more approaches that of the input frame. The value must be a float number in
	 * the range [0,1] and defaults to <b>0.200</b>.
	 * 
	 * @apiNote (double) strength
	 * @param value the amount of equalization
	 * @return the {@link HistEq} instance
	 */
	public HistEq strength( double value ) {
		Assert.rangeCheck( value, 0.0, 1.0 );
		return super.addArg( "strength", value );
	}

	/**
	 * Set the maximum intensity that can generated and scale the output values appropriately. The strength
	 * should be set as desired and then the intensity can be limited if needed to avoid washing-out. The
	 * value must be a float number in the range [0,1] and defaults to <b>0.210</b>.
	 * 
	 * @apiNote (double) intensity
	 * @param value the maximum intensity
	 * @return the {@link HistEq} instance
	 */
	public HistEq intensity( double value ) {
		Assert.rangeCheck( value, 0.0, 1.0 );
		return super.addArg( "intensity", value );
	}

	/**
	 * Set the antibanding level. If enabled the filter will randomly vary the luminance of output pixels by a
	 * small amount to avoid banding of the histogram. Possible values are none, weak or strong. It defaults
	 * to {@link AntibandingLevel#NONE}.
	 * 
	 * @apiNote (flags) antibanding
	 * @param level the antibanding level
	 * @return the {@link HistEq} instance
	 */
	public HistEq antibanding( AntibandingLevel level ) {
		return super.addArg( "antibanding", level );
	}

	/**
	 * Antibanding level
	 *
	 * @author tangxbai
	 * @since 2022/07/11
	 */
	public enum AntibandingLevel implements AbstractEnum {
		NONE, WEAK, STRONG
	}

}
