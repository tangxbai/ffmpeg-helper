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
 * Apply an Adaptive Temporal Averaging Denoiser to the video input.
 *
 * @author tangxbai
 * @since 2022/06/08
 * @see <a href="https://ffmpeg.org/ffmpeg-filters.html#atadenoise">ffmpeg-filters#atadenoise</a>
 */
@Function( "atadenoise" )
public class AtadeNoise extends AbstractFunction<AtadeNoise> {

	// Don't let anyone instantiate this class
	private AtadeNoise() {}

	/**
	 * Quickly create an instances of {@link AtadeNoise}
	 * 
	 * @return the {@link AtadeNoise} instance
	 */
	public static final AtadeNoise of() {
		return new AtadeNoise();
	}

	/**
	 * Set threshold A for 1st plane, default is 0.02 and the valid range is 0 to 0.3.
	 * 
	 * @apiNote (double) 0a
	 * @param threshold the threshold range is 0 to 0.3
	 * @return the {@link AtadeNoise} instance
	 */
	public AtadeNoise thresholdA0( double threshold ) {
		Assert.rangeCheck( threshold, 0, 0.3 );
		return super.addArg( "0a", threshold );
	}

	/**
	 * Set threshold B for 1st plane, default is 0.04 and the valid range is 0 to 5.
	 * 
	 * @apiNote (double) 0b
	 * @param plane the plane range is 0 to 5
	 * @return the {@link AtadeNoise} instance
	 */
	public AtadeNoise thresholdB0( double plane ) {
		Assert.rangeCheck( plane, 0, 5 );
		return super.addArg( "0b", plane );
	}

	/**
	 * Set threshold A for 2nd plane, default is 0.02 and the valid range is 0 to 0.3.
	 * 
	 * @apiNote (double) 1a
	 * @param threshold the threshold range is 0 to 0.3
	 * @return the {@link AtadeNoise} instance
	 */
	public AtadeNoise thresholdA1( double threshold ) {
		Assert.rangeCheck( threshold, 0, 0.3 );
		return super.addArg( "1a", threshold );
	}

	/**
	 * Set threshold B for 2nd plane, default is 0.04 and the valid range is 0 to 5.
	 * 
	 * @apiNote (double) 1b
	 * @param threshold the threshold range is 0 to 5
	 * @return the {@link AtadeNoise} instance
	 */
	public AtadeNoise thresholdB1( double threshold ) {
		Assert.rangeCheck( threshold, 0, 5 );
		return super.addArg( "1b", threshold );
	}

	/**
	 * Set threshold A for 3rd plane, default is 0.02 and the valid range is 0 to 0.3.
	 * 
	 * @apiNote (double) 2a
	 * @param threshold the threshold range is 0 to 0.3
	 * @return the {@link AtadeNoise} instance
	 */
	public AtadeNoise thresholdA2( double threshold ) {
		Assert.rangeCheck( threshold, 0, 0.3 );
		return super.addArg( "2a", threshold );
	}

	/**
	 * Set threshold B for 3rd plane, default is 0.04 and the valid range is 0 to 5.
	 * 
	 * @apiNote (double) 2b
	 * @param plane the plane range is 0 to 5
	 * @return the {@link AtadeNoise} instance
	 */
	public AtadeNoise thresholdB2( double threshold ) {
		Assert.rangeCheck( threshold, 0, 5 );
		return super.addArg( "2b", threshold );
	}

	/**
	 * Set number of frames filter will use for averaging, default is 9 and must be odd number in range [5,
	 * 129].
	 * 
	 * @apiNote (int) s
	 * @param frames the odd number in range [5, 129]
	 * @return the {@link AtadeNoise} instance
	 */
	public AtadeNoise frames( int frames ) {
		Assert.rangeCheck( frames, 5, 129 );
		Assert.isFalse( frames % 2 == 0, "Accepted value must be odd number" );
		return super.addArg( "s", frames );
	}

	/**
	 * Set what planes of frame filter will use for averaging, default is <b>9</b>.
	 * 
	 * @apiNote (int) p
	 * @param planes the plane frame
	 * @return the {@link AtadeNoise} instance
	 */
	public AtadeNoise planes( int planes ) {
		return super.addArg( "p", planes );
	}

	/**
	 * Set what variant of algorithm filter will use for averaging. Default is p parallel. Alternatively can
	 * be set to s serial.
	 *
	 * Parallel can be faster then serial, while other way around is never true. Parallel will abort early on
	 * first change being greater then thresholds, while serial will continue processing other side of frames
	 * if they are equal or below thresholds.
	 * 
	 * @apiNote (int) a
	 * @param variant the variant algorithm filter value
	 * @return the {@link AtadeNoise} instance
	 */
	public AtadeNoise variant( int variant ) {
		return super.addArg( "a", variant );
	}

	/**
	 * Set sigma for 1st plane, the default is 32767 and valid range is from 0 to 32767.
	 * 
	 * This options controls weight for each pixel in radius defined by size, default value means every pixel
	 * have same weight, setting this option to 0 effectively disables filtering.
	 * 
	 * @apiNote (int) 0s
	 * @param sigma the the sigma plane value range accepts 0 to 32767
	 * @return the {@link AtadeNoise} instance
	 */
	public AtadeNoise sigma0( int sigma ) {
		Assert.rangeCheck( sigma, 0, 32767 );
		return super.addArg( "0s", sigma );
	}

	/**
	 * Set sigma for 1st plane, the default is 32767 and valid range is from 0 to 32767.
	 * 
	 * This options controls weight for each pixel in radius defined by size, default value means every pixel
	 * have same weight, setting this option to 0 effectively disables filtering.
	 * 
	 * @apiNote (int) 1s
	 * @param sigma the sigma plane value range accepts 0 to 32767
	 * @return the {@link AtadeNoise} instance
	 */
	public AtadeNoise sigma1( int sigma ) {
		Assert.rangeCheck( sigma, 0, 32767 );
		return super.addArg( "1s", sigma );
	}

	/**
	 * Set sigma for 3rd plane, the default is 32767, valid range is from 0 to 32767.
	 * 
	 * This options controls weight for each pixel in radius defined by size, default value means every pixel
	 * have same weight, setting this option to 0 effectively disables filtering.
	 * 
	 * @apiNote (int) 2s
	 * @param sigma the sigma plane value range accepts 0 to 32767
	 * @return the {@link AtadeNoise} instance
	 */
	public AtadeNoise sigma2( int sigma ) {
		Assert.rangeCheck( sigma, 0, 32767 );
		return super.addArg( "2s", sigma );
	}

}
