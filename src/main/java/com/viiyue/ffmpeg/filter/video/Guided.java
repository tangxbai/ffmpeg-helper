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
import com.viiyue.ffmpeg.enums.Guidance;
import com.viiyue.ffmpeg.filter.AbstractFunction;
import com.viiyue.ffmpeg.util.Assert;

/**
 * Apply guided filter for edge-preserving smoothing, dehazing and so on.
 *
 * @author tangxbai
 * @since 2022/07/11
 * @see <a href="https://ffmpeg.org/ffmpeg-filters.html#guided">ffmpeg-filters#guided</a>
 */
@Function( "guided" )
public class Guided extends AbstractFunction<Guided> {

	// Don't let anyone instantiate this class
	private Guided() {}

	/**
	 * Quickly create an instances of {@link Guided} and set the filtering mode
	 * 
	 * @apiNote (string) mode
	 * @return the {@link Guided} instance
	 */
	public static final Guided basic() {
		return new Guided().addArg( "mode", "basic" );
	}

	/**
	 * Quickly create an instances of {@link Guided} and set the filtering mode
	 * 
	 * @apiNote (string) mode
	 * @return the {@link Guided} instance
	 */
	public static final Guided fast() {
		return new Guided().addArg( "mode", "fast" );
	}

	/**
	 * Set the box radius in pixels. Allowed range is 1 to 20, default is <b>3</b>.
	 * 
	 * @apiNote (int) radius
	 * @param value the box radius
	 * @return the {@link Guided} instance
	 */
	public Guided radius( int value ) {
		Assert.rangeCheck( value, 1, 20 );
		return super.addArg( "radius", value );
	}

	/**
	 * Set subsampling ratio for fast mode. Range is 2 to 64, default is <b>4</b>. No subsampling occurs in
	 * basic mode.
	 * 
	 * @apiNote (int) sub
	 * @param value the subsampling ratio for fast mode
	 * @return the {@link Guided} instance
	 */
	public Guided subsampling( int value ) {
		Assert.rangeCheck( value, 1, 20 );
		return super.addArg( "sub", value );
	}

	/**
	 * Set guidance mode. Can be off or on. Default is off. If off, single input is required. If on, two
	 * inputs of the same resolution and pixel format are required. The second input serves as the guidance.
	 * 
	 * @apiNote (int) guidance
	 * @param guidance the guidance mode
	 * @return the {@link Guided} instance
	 * @see Guidance
	 */
	public Guided guidance( Guidance guidance ) {
		return super.addArg( "guidance", guidance );
	}

	/**
	 * Set planes to filter
	 * 
	 * @apiNote (int) planes
	 * @param value the filter planes
	 * @return the {@link Guided} instance
	 * @see Guidance
	 */
	public Guided planes( int value ) {
		Assert.rangeCheck( value, 1, 15 );
		return super.addArg( "planes", value );
	}

}
