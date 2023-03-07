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
 * Detect video interlacing type.
 * 
 * <p>
 * This filter tries to detect if the input frames are interlaced, progressive, top or bottom field first. It
 * will also try to detect fields that are repeated between adjacent frames (a sign of telecine).
 * 
 * <p>
 * Single frame detection considers only immediately adjacent frames when classifying each frame. Multiple
 * frame detection incorporates the classification history of previous frames.
 *
 * @author tangxbai
 * @since 2022/07/11
 * @see <a href="https://ffmpeg.org/ffmpeg-filters.html#identity">ffmpeg-filters#identity</a>
 */
@Function( "identity" )
public class Idet extends AbstractFunction<Idet> {

	// Don't let anyone instantiate this class
	private Idet() {}

	/**
	 * Quickly create an instances of {@link Idet}
	 * 
	 * @return the {@link Idet} instance
	 */
	public static final Idet of() {
		return new Idet();
	}

	/**
	 * Set interlacing threshold, default value is <b>1.04</b>.
	 * 
	 * @apiNote (double) intl_thres
	 * @param action the interlacing threshold
	 * @return the {@link Idet} instance
	 */
	public Idet interlacingThreshold( double threshold ) {
		Assert.isTrue( threshold >= -1, "Value cannot be less than -1" );
		return super.addArg( "intl_thres", threshold );
	}

	/**
	 * Set progressive threshold, default value is <b>1.5</b>.
	 * 
	 * @apiNote (double) prog_thres
	 * @param action the progressive threshold
	 * @return the {@link Idet} instance
	 */
	public Idet progressiveThreshold( double threshold ) {
		Assert.isTrue( threshold >= -1, "Value cannot be less than -1" );
		return super.addArg( "prog_thres", threshold );
	}

	/**
	 * Threshold for repeated field detection, default value is <b>3</b>.
	 * 
	 * @apiNote (double) rep_thres
	 * @param action the repeat threshold
	 * @return the {@link Idet} instance
	 */
	public Idet repeatedThreshold( double threshold ) {
		Assert.isTrue( threshold >= -1, "Value cannot be less than -1" );
		return super.addArg( "rep_thres", threshold );
	}

	/**
	 * Number of frames after which a given frame’s contribution to the statistics is halved (i.e., it
	 * contributes only 0.5 to its classification). The default of 0 means that all frames seen are given full
	 * weight of 1.0 forever, default value is <b>0</b>.
	 * 
	 * @apiNote (double) half_life
	 * @param action the half life of cumulative statistics
	 * @return the {@link Idet} instance
	 */
	public Idet halfLife( double value ) {
		Assert.isTrue( value >= -1, "Value cannot be less than -1" );
		return super.addArg( "half_life", value );
	}

	/**
	 * Number of frames after which a given frame’s contribution to the statistics is halved (i.e., it
	 * contributes only 0.5 to its classification). The default of 0 means that all frames seen are given full
	 * weight of 1.0 forever, default value is <b>0</b>.
	 * 
	 * @apiNote (double) analyze_interlaced_flag
	 * @param action the interlace flag
	 * @return the {@link Idet} instance
	 */
	public Idet analyze( double value ) {
		Assert.isTrue( value >= -1, "Value cannot be less than -1" );
		return super.addArg( "analyze_interlaced_flag", value );
	}

}
