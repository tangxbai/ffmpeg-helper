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
 * A color constancy variation filter which estimates scene illumination via grey edge algorithm and corrects
 * the scene colors accordingly.
 * 
 * <p>
 * See: <a href=
 * "https://staff.science.uva.nl/th.gevers/pub/GeversTIP07.pdf">https://staff.science.uva.nl/th.gevers/pub/GeversTIP07.pdf</a>
 *
 * @author tangxbai
 * @since 2022/07/11
 * @see <a href="https://ffmpeg.org/ffmpeg-filters.html#greyedge">ffmpeg-filters#greyedge</a>
 */
@Function( "greyedge" )
public class GreyEdge extends AbstractFunction<GreyEdge> {

	// Don't let anyone instantiate this class
	private GreyEdge() {}

	/**
	 * Quickly create an instances of {@link GreyEdge}
	 * 
	 * @return the {@link GreyEdge} instance
	 */
	public static final GreyEdge of() {
		return new GreyEdge();
	}

	/**
	 * The order of differentiation to be applied on the scene. Must be chosen in the range [0,2] and default
	 * value is <b>1</b>.
	 * 
	 * @apiNote (int) difford
	 * @param value the differentiation order
	 * @return the {@link GreyEdge} instance
	 */
	public GreyEdge difford( int value ) {
		Assert.rangeCheck( value, 0, 2 );
		return super.addArg( "difford", value );
	}

	/**
	 * The Minkowski parameter to be used for calculating the Minkowski distance. Must be chosen in the range
	 * [0,20] and default value is <b>1</b>. Set to 0 for getting max value instead of calculating Minkowski
	 * distance.
	 * 
	 * @apiNote (int) difford
	 * @param value the minkowski norm
	 * @return the {@link GreyEdge} instance
	 */
	public GreyEdge minknorm( int value ) {
		Assert.rangeCheck( value, 0, 20 );
		return super.addArg( "minknorm", value );
	}

	/**
	 * The standard deviation of Gaussian blur to be applied on the scene. Must be chosen in the range
	 * [0,1024.0] and default value is <b>1</b>. floor( sigma * break_off_sigma(3) ) can’t be equal to 0 if
	 * difford is greater than 0.
	 * 
	 * @apiNote (double) sigma
	 * @param value the sigma value
	 * @return the {@link GreyEdge} instance
	 */
	public GreyEdge sigma( double value ) {
		Assert.rangeCheck( value, 0.0, 1024.0 );
		return super.addArg( "sigma", value );
	}

}
