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
import com.viiyue.ffmpeg.common.Const;
import com.viiyue.ffmpeg.filter.AbstractFunction;
import com.viiyue.ffmpeg.util.Assert;

/**
 * Detect and draw edges. The filter uses the Canny Edge Detection algorithm
 * 
 * @author tangxbai
 * @since 2022/06/28
 * @see <a href="https://ffmpeg.org/ffmpeg-filters.html#edgedetect">ffmpeg-filters#edgedetect</a>
 */
@Function( "edgedetect" )
public class EdgeDetect extends AbstractFunction<EdgeDetect> {

	// Don't let anyone instantiate this class
	private EdgeDetect() {}

	/**
	 * Quickly create an instances of {@link EdgeDetect}
	 * 
	 * @return the {@link EdgeDetect} instance
	 */
	public static final EdgeDetect of() {
		return new EdgeDetect();
	}

	/**
	 * <p>
	 * Set low threshold value used by the Canny thresholding algorithm.
	 * 
	 * <p>
	 * The threshold value must be chosen in the range [0,1], and low should be lesser or equal to high.
	 * 
	 * <p>
	 * Default value is 20/255(About 0.0784314).
	 * 
	 * @apiNote (double) low
	 * @param value the low threshold
	 * @return the {@link EdgeDetect} instance
	 */
	public EdgeDetect low( double value ) {
		Assert.rangeCheck( value, 0.0, 1.0 );
		return super.addArg( "low", value );
	}

	/**
	 * <p>
	 * Set high threshold value used by the Canny thresholding algorithm.
	 * 
	 * <p>
	 * The high threshold selects the "strong" edge pixels, which are then connected through 8-connectivity
	 * with the "weak" edge pixels selected by the low threshold.
	 * 
	 * <p>
	 * The threshold values must be chosen in the range [0,1], and high should be greater or equal to low.
	 * 
	 * <p>
	 * Default value is 50/255(About 0.196078).
	 * 
	 * @apiNote (double) high
	 * @param value the high threshold
	 * @return the {@link EdgeDetect} instance
	 */
	public EdgeDetect high( double value ) {
		Assert.rangeCheck( value, 0.0, 1.0 );
		return super.addArg( "high", value );
	}

	/**
	 * Define the drawing mode
	 * 
	 * @apiNote (flags) mode
	 * @param mode the drawing mode
	 * @return the {@link EdgeDetect} instance
	 * @see EdgeMode
	 */
	public EdgeDetect mode( EdgeMode mode ) {
		return super.addArg( "mode", mode );
	}

	/**
	 * Define the filter luma plane
	 * 
	 * @apiNote (flags) planes
	 * @param plane the filter luma plane
	 * @return the {@link EdgeDetect} instance
	 * @see EdgePlane
	 */
	public EdgeDetect planes( EdgePlane ... plane ) {
		return super.addArg( "planes", Const.APPEND_SEPARATOR, plane );
	}

	/**
	 * DNN backend options
	 *
	 * @author tangxbai
	 * @since 2022/06/28
	 */
	public enum EdgeMode implements AbstractEnum {
		/** Draw white/gray wires on black background */
		WIRES,
		/** Mix the colors to create a paint/cartoon effect */
		COLORMIX,
		/** Apply Canny edge detector on all selected planes */
		CANNY
	}

	/**
	 * Filter luma plane
	 *
	 * @author tangxbai
	 * @since 2022/06/28
	 */
	public enum EdgePlane implements AbstractEnum {
		Y, U, V, R, G, B
	}

}
