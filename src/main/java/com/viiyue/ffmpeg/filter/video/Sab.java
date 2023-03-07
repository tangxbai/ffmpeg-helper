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
 * Apply Shape Adaptive Blur
 * 
 * @author tangxbai
 * @since 2022/08/02
 * @see <a href="https://ffmpeg.org/ffmpeg-filters.html#sab">ffmpeg-filters#sab</a>
 */
@Function( "sab" )
public class Sab extends AbstractFunction<Sab> {

	// Don't let anyone instantiate this class
	private Sab() {}

	/**
	 * Quickly create an instances of {@link Roberts}
	 * 
	 * @return {@link Sab} instance
	 */
	public static final Sab of() {
		return new Sab();
	}

	/**
	 * Set luma blur filter strength, must be a value in range 0.1-4.0, default value is <b>1.0</b>. A greater
	 * value will result in a more blurred image, and in slower processing.
	 * 
	 * @apiNote (double) luma_radius, lr
	 * @param value the luma radius
	 * @return {@link Sab} instance
	 */
	public Sab lumaRadius( double value ) {
		Assert.rangeCheck( value, 0.1, 4.0 );
		return super.addArg( "lr", value );
	}

	/**
	 * Set luma pre-filter radius, must be a value in the 0.1-2.0 range, default value is <b>1.0</b>.
	 * 
	 * @apiNote (double) luma_pre_filter_radius, lpfr
	 * @param value the luma pre-filter radius
	 * @return {@link Sab} instance
	 */
	public Sab lumaPreFilterRadius( double value ) {
		Assert.rangeCheck( value, 0.1, 2.0 );
		return super.addArg( "lpfr", value );
	}

	/**
	 * Set luma maximum difference between pixels to still be considered, must be a value in the 0.1-100.0
	 * range, default value is <b>1.0</b>.
	 * 
	 * @apiNote (double) luma_strength, ls
	 * @param value the luma strength
	 * @return {@link Sab} instance
	 */
	public Sab lumaStrength( double value ) {
		Assert.rangeCheck( value, 0.1, 100.0 );
		return super.addArg( "ls", value );
	}

	/**
	 * Set chroma blur filter strength, must be a value in range -0.9-4.0, default is <b>-0.9</b>. A greater
	 * value will result in a more blurred image, and in slower processing.
	 * 
	 * @apiNote (double) chroma_radius, cr
	 * @param value the chroma radius
	 * @return {@link Sab} instance
	 */
	public Sab chromaRadius( double value ) {
		Assert.rangeCheck( value, -0.9, 4.0 );
		return super.addArg( "cr", value );
	}

	/**
	 * Set chroma pre-filter radius, must be a value in the -0.9-2.0 range, default is <b>-0.9</b>.
	 * 
	 * @apiNote (double) chroma_pre_filter_radius, cpfr
	 * @param value the chroma radius
	 * @return {@link Sab} instance
	 */
	public Sab chromaPreFilterRadius( double value ) {
		Assert.rangeCheck( value, -0.9, 2.0 );
		return super.addArg( "cpfr", value );
	}

	/**
	 * Set chroma maximum difference between pixels to still be considered, must be a value in the -0.9-100.0
	 * range, default is <b>-0.9</b>.
	 * 
	 * @apiNote (double) chroma_strength, cs
	 * @param value the luma strength
	 * @return {@link Sab} instance
	 */
	public Sab chromaStrength( double value ) {
		Assert.rangeCheck( value, -0.9, 100.0 );
		return super.addArg( "cs", value );
	}

}
