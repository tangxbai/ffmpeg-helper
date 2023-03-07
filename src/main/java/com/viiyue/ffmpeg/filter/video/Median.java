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
 * Apply motion-compensation deinterlacing.
 * 
 * <p>
 * It needs one field per frame as input and must thus be used together with yadif=1/3 or equivalent.
 * 
 * <p>
 * This filter is only available in ffmpeg version 4.4 or earlier.
 * 
 * @author tangxbai
 * @since 2022/07/18
 * @see <a href="https://ffmpeg.org/ffmpeg-filters.html#mcdeint">ffmpeg-filters#mcdeint</a>
 */
@Function( "mcdeint" )
public class Median extends AbstractFunction<Median> {

	// Don't let anyone instantiate this class
	private Median() {}

	/**
	 * Quickly create an instances of {@link Median}
	 * 
	 * @return the {@link Median} instance
	 */
	public static final Median of() {
		return new Median();
	}

	/**
	 * Set horizontal radius size. Allowed range is integer from 1 to 127, default is <b>1</b>.
	 * 
	 * @apiNote (int) radius
	 * @param value the horizontal radius
	 * @return the {@link Median} instance
	 */
	public Median radius( int value ) {
		Assert.rangeCheck( value, 1, 127 );
		return super.addArg( "value", value );
	}

	/**
	 * Set vertical radius size. Allowed range is integer from 1 to 127, default is <b>1</b>.
	 * 
	 * @apiNote (int) radius
	 * @param value the vertical radius
	 * @return the {@link Median} instance
	 */
	public Median radiusV( int value ) {
		Assert.rangeCheck( value, 1, 127 );
		return super.addArg( "value", value );
	}

	/**
	 * Set median percentile. Default value is <b>0.5</b>. Default value of {@code 0.5} will pick always
	 * median values, while {@code 0} will pick minimum values, and {@code 1} maximum values.
	 * 
	 * @apiNote (double) percentile
	 * @param value the median percentile
	 * @return the {@link Median} instance
	 */
	public Median percentile( double value ) {
		Assert.rangeCheck( value, 0.0, 1.0 );
		return super.addArg( "percentile", value );
	}

	/**
	 * Set which planes to process. Value range allowed is from 0 to 15, default value is <b>15</b>, all
	 * planes will be processed.
	 * 
	 * @apiNote (int) planes
	 * @param value the plane filter
	 * @return the {@link Median} instance
	 */
	public Median planes( int value ) {
		Assert.rangeCheck( value, 0, 15 );
		return super.addArg( "planes", value );
	}

}
