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
 * Remove temporal frame luminance variations
 * 
 * @author tangxbai
 * @since 2022/06/15
 * @see <a href="https://ffmpeg.org/ffmpeg-filters.html#deflicker">ffmpeg-filters#deflicker</a>
 */
@Function( "deflicker" )
public class Deflicker extends AbstractFunction<Deflicker> {

	// Don't let anyone instantiate this class
	private Deflicker() {}

	/**
	 * Quickly create an instances of {@link Deflicker}
	 * 
	 * @return the {@link Deflicker} instance
	 */
	public static final Deflicker of() {
		return new Deflicker();
	}

	/**
	 * Set moving-average filter size in frames, default is <b>5</b>. Allowed range is from 2 to 129.
	 * 
	 * @apiNote (double) size, s
	 * @param size the filter size
	 * @return the {@link Deflicker} instance
	 */
	public Deflicker size( int size ) {
		Assert.rangeCheck( size, 2, 129 );
		return super.addArg( "s", size ); // size, s
	}

	/**
	 * Set averaging mode to smooth temporal luminance variations
	 * 
	 * @apiNote (flags) mode, m
	 * @param mode the averaging mode
	 * @return the {@link Deflicker} instance
	 * @see AveragingMode
	 */
	public Deflicker mode( AveragingMode mode ) {
		return super.addArg( "m", mode ); // mode, m
	}

	/**
	 * Do not actually modify frame. Useful when one only wants metadata.
	 * 
	 * @apiNote (boolean) bypass
	 * @return the {@link Deflicker} instance
	 */
	public Deflicker byPass() {
		return super.enable( "bypass" );
	}

	/**
	 * Averaging mode
	 * 
	 * @author tangxbai
	 * @since 2022/06/16
	 */
	public enum AveragingMode implements AbstractEnum {
		/** Arithmetic mean */
		AM,
		/** Geometric mean */
		GM,
		/** Harmonic mean */
		HM,
		/** Quadratic mean */
		QM,
		/** Cubic mean */
		CM,
		/** Power mean */
		PM,
		/** Median */
		MEDIAN;
	}

}
