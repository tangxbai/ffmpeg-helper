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
 * Mix several video input streams into one video stream
 * 
 * @author tangxbai
 * @since 2022/07/18
 * @see <a href="https://ffmpeg.org/ffmpeg-filters.html#mix">ffmpeg-filters#mix</a>
 */
@Function( "mix" )
public class Mix extends AbstractFunction<Mix> {

	// Don't let anyone instantiate this class
	private Mix() {}

	/**
	 * Quickly create an instances of {@link Mix}
	 * 
	 * @return the {@link Mix} instance
	 */
	public static final Mix of() {
		return new Mix();
	}

	/**
	 * Set the number of inputs. Value range is from 2 to 32767, If unspecified, it defaults to <b>2</b>.
	 * 
	 * @apiNote (int) inputs
	 * @param value the number of inputs
	 * @return the {@link Mix} instance
	 */
	public Mix inputs( int value ) {
		Assert.rangeCheck( value, 2, 32767 );
		return super.addArg( "inputs", value );
	}

	/**
	 * Specify weight of each input video stream as sequence. Each weight is separated by space. If number of
	 * weights is smaller than number of frames last specified weight will be used for all remaining unset
	 * weights.
	 * 
	 * @apiNote (int) weights
	 * @param weights the weight for each input
	 * @return the {@link Mix} instance
	 */
	public Mix weights( int ... weights ) {
		return super.addArg2( "weights", " ", weights );
	}

	/**
	 * Specify scale, if it is set it will be multiplied with sum of each weight multiplied with pixel values
	 * to give final destination pixel value. By default scale is auto scaled to sum of weights.
	 * 
	 * @apiNote (double) scale
	 * @param value the specify scale value
	 * @return the {@link Mix} instance
	 */
	public Mix scale( double value ) {
		return super.addArg( "scale", value );
	}

	/**
	 * Set which planes will be processed as bitmap, unprocessed planes will be copied from first stream.
	 * Value range allowed is from 0 to 15, default value is <b>15</b>, all planes will be processed.
	 * 
	 * @apiNote (int) planes
	 * @param value the plane filter
	 * @return the {@link Mix} instance
	 */
	public Mix planes( int value ) {
		Assert.rangeCheck( value, 0, 15 );
		return super.addArg( "planes", value );
	}

	/**
	 * Specify how end of stream is determined
	 * 
	 * @apiNote (flags) duration
	 * @param mode the duration mode
	 * @return the {@link Mix} instance
	 * @see Duration
	 */
	public Mix duration( Duration mode ) {
		return super.addArg( "duration", mode );
	}

	/**
	 * Motion interpolation mode
	 *
	 * @author tangxbai
	 * @since 2022/07/18
	 */
	public enum Duration implements AbstractEnum {
		/** The duration of the longest input. (default) */
		LONGEST,
		/** The duration of the shortest input */
		SHORTEST,
		/** The duration of the first input */
		FIRST
	}

}
