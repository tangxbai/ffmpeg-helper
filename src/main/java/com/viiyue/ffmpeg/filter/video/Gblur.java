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
 * Apply Gaussian blur filter
 *
 * @author tangxbai
 * @since 2022/07/07
 * @see <a href="https://ffmpeg.org/ffmpeg-filters.html#gblur">ffmpeg-filters#gblur</a>
 */
@Function( "gblur" )
public class Gblur extends AbstractFunction<Gblur> {

	// Don't let anyone instantiate this class
	private Gblur() {}

	/**
	 * Quickly create an instances of {@link Gblur}
	 * 
	 * @apiNote (double) sigma/sigmaV
	 * @param sigmaH the horizontal sigma
	 * @param sigmaV the vertical sigma
	 * @return the {@link Gblur} instance
	 */
	public static final Gblur the( double sigma ) {
		return new Gblur().sigma( sigma, sigma );
	}

	/**
	 * Quickly create an instances of {@link Gblur}
	 * 
	 * @apiNote (double) sigma/sigmaV
	 * @param sigmaH the horizontal sigma
	 * @param sigmaV the vertical sigma
	 * @return the {@link Gblur} instance
	 */
	public static final Gblur the( double sigmaH, double sigmaV ) {
		return new Gblur().sigma( sigmaH, sigmaV );
	}

	/**
	 * Set sigmas, standard deviation of Gaussian blur, the {@code sigma} default is <b>0.5</b>,
	 * {@code sigmaV} default is <b>-1</b>.
	 * 
	 * @apiNote (double) sigma/sigmaV
	 * @param sigmaH the horizontal sigma
	 * @param sigmaV the vertical sigma
	 * @return the {@link Gblur} instance
	 */
	private Gblur sigma( double sigmaH, double sigmaV ) {
		Assert.rangeCheck( sigmaV, 0, 1024 );
		Assert.rangeCheck( sigmaV, -1, 1024 );
		return super.addArg( "sigma", sigmaH ).addArg( "sigmaV", sigmaV );
	}

	/**
	 * Set number of steps for Gaussian approximation, default is <b>1</b>.
	 * 
	 * @apiNote (int) steps
	 * @param value the step value
	 * @return the {@link Gblur} instance
	 */
	public Gblur steps( int value ) {
		Assert.rangeCheck( value, 1, 6 );
		return super.addArg( "steps", value );
	}

	/**
	 * Set which planes to filter, by default all planes are filtered.
	 * 
	 * @apiNote (int) planes
	 * @param value the plane
	 * @return the {@link Gblur} instance
	 */
	public Gblur planes( int value ) {
		Assert.rangeCheck( value, 0, 15 );
		return super.addArg( "planes", value );
	}

}
