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
 * Reduce chrominance noise
 * 
 * @author tangxbai
 * @since 2022/06/14
 * @see <a href="https://ffmpeg.org/ffmpeg-filters.html#chromanr">ffmpeg-filters#chromanr</a>
 */
@Function( "chromanr" )
public class Chromanr extends AbstractFunction<Chromanr> {

	// Don't let anyone instantiate this class
	private Chromanr() {}

	/**
	 * Quickly create an instances of {@link Chromanr}
	 * 
	 * @return the {@link Chromanr} instance
	 */
	public static final Chromanr the() {
		return new Chromanr();
	}

	/**
	 * Set threshold for averaging chrominance values. Sum of absolute difference of Y, U and V pixel
	 * components of current pixel and neighbour pixels lower than this threshold will be used in averaging.
	 * Luma component is left unchanged and is copied to output. Default value is <b>30</b>, allowed range is
	 * from 1 to 200.
	 * 
	 * @apiNote (int) thres
	 * @param threshold the averaging chrominance threshold
	 * @return the {@link Chromanr} instance
	 */
	public Chromanr threshold( int threshold ) {
		Assert.rangeCheck( threshold, 1, 200 );
		return super.addArg( "thres", threshold );
	}

	/**
	 * Set horizontal radius of rectangle used for averaging, allowed range is from 1 to 100, and default
	 * value is <b>5</b>.
	 * 
	 * @apiNote (int) sizew
	 * @param radius the horizontal radius
	 * @return the {@link Chromanr} instance
	 */
	public Chromanr sizeW( int radius ) {
		Assert.rangeCheck( radius, 1, 100 );
		return super.addArg( "sizew", radius );
	}

	/**
	 * Set vertical radius of rectangle used for averaging, allowed range is from 1 to 100, and default value
	 * is <b>5</b>.
	 * 
	 * @apiNote (int) sizeh
	 * @param radius the horizontal radius
	 * @return the {@link Chromanr} instance
	 */
	public Chromanr sizeH( int radius ) {
		Assert.rangeCheck( radius, 1, 100 );
		return super.addArg( "sizeh", radius );
	}

	/**
	 * Set horizontal step when averaging, default value is <b>1</b>, allowed range is from 1 to 50, mostly
	 * useful to speed-up filtering.
	 * 
	 * @apiNote (int) stepw
	 * @param step the horizontal step
	 * @return the {@link Chromanr} instance
	 */
	public Chromanr stepW( int step ) {
		Assert.rangeCheck( step, 1, 50 );
		return super.addArg( "stepw", step );
	}

	/**
	 * Set vertical step when averaging, default value is <b>1</b>, allowed range is from 1 to 50, mostly
	 * useful to speed-up filtering.
	 * 
	 * @apiNote (int) steph
	 * @param step the horizontal step
	 * @return the {@link Chromanr} instance
	 */
	public Chromanr stepH( int step ) {
		Assert.rangeCheck( step, 1, 50 );
		return super.addArg( "steph", step );
	}

	/**
	 * Set Y threshold for averaging chrominance values. Set finer control for max allowed difference between
	 * Y components of current pixel and neigbour pixels. Default value is <b>200</b>, allowed range is from 1
	 * to 200.
	 * 
	 * @apiNote (int) threy
	 * @param step the horizontal step
	 * @return the {@link Chromanr} instance
	 */
	public Chromanr thresholdY( int threshold ) {
		Assert.rangeCheck( threshold, 1, 200 );
		return super.addArg( "threy", threshold );
	}

	/**
	 * Set U threshold for averaging chrominance values. Set finer control for max allowed difference between
	 * U components of current pixel and neigbour pixels. Default value is <b>200</b>, allowed range is from 1
	 * to 200.
	 * 
	 * @apiNote (int) threu
	 * @param step the horizontal step
	 * @return the {@link Chromanr} instance
	 */
	public Chromanr thresholdU( int threshold ) {
		Assert.rangeCheck( threshold, 1, 200 );
		return super.addArg( "threu", threshold );
	}

	/**
	 * Set V threshold for averaging chrominance values. Set finer control for max allowed difference between
	 * V components of current pixel and neigbour pixels. Default value is <b>200</b>, allowed range is from 1
	 * to 200.
	 * 
	 * @apiNote (int) threv
	 * @param step the horizontal step
	 * @return the {@link Chromanr} instance
	 */
	public Chromanr thresholdV( int threshold ) {
		Assert.rangeCheck( threshold, 1, 200 );
		return super.addArg( "threv", threshold );
	}

	/**
	 * Set distance type used in calculations.
	 * 
	 * @apiNote (flags) distance
	 * @param step the horizontal step
	 * @return the {@link Chromanr} instance
	 */
	public Chromanr distance( Distance distance ) {
		return super.addArg( "distance", distance );
	}

	/**
	 * the type of distance used in the calculation
	 *
	 * @author tangxbai
	 * @since 2022/06/14
	 */
	public enum Distance implements AbstractEnum {
		MANHATTAN, EUCLIDEAN
	}

}
