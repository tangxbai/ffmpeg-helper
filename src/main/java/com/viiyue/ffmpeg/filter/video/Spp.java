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
 * Apply a simple postprocessing filter that compresses and decompresses the image at several (or - in the
 * case of quality level {@code 6} - all) shifts and average the results.
 * 
 * @author tangxbai
 * @since 2022/08/04
 * @see <a href="https://ffmpeg.org/ffmpeg-filters.html#spp-1">ffmpeg-filters#spp</a>
 */
@Function( "spp" )
public class Spp extends AbstractFunction<Spp> {

	// Don't let anyone instantiate this class
	private Spp() {}

	/**
	 * Quickly create an instances of {@link Spp}
	 * 
	 * @return the {@link Spp} instance
	 */
	public static final Spp of() {
		return new Spp();
	}

	/**
	 * Set quality. This option defines the number of levels for averaging. It accepts an integer in the range
	 * 0-6. If set to 0, the filter will have no effect. A value of 6 means the higher quality. For each
	 * increment of that value the speed drops by a factor of approximately 2. Default value is <b>3</b>.
	 * 
	 * @apiNote (int) quality
	 * @param value the quality value
	 * @return the {@link Spp} instance
	 */
	public Spp quality( int value ) {
		Assert.rangeCheck( value, 0, 6 );
		return super.addArg( "quality", value );
	}

	/**
	 * Force a constant quantization parameter. If not set, the filter will use the QP from the video stream
	 * (if available). Value range is [0-63] and default is <b>0</b>.
	 * 
	 * @apiNote (int) qp
	 * @param value the constant quantizer parameter
	 * @return the {@link Spp} instance
	 */
	public Spp quantizerParameter( int value ) {
		Assert.rangeCheck( value, 0, 6 );
		return super.addArg( "qp", value );
	}

	/**
	 * Set thresholding mode
	 * 
	 * @apiNote (int) qp
	 * @param mode the thresholding mode
	 * @return the {@link Spp} instance
	 */
	public Spp mode( Threshold mode ) {
		return super.addArg( "mode", mode );
	}

	/**
	 * Enable the use of the QP from the B-Frames if set to {@code true}. Using this option may cause flicker
	 * since the B-Frames have often larger QP. Default is {@code false} (not enabled).
	 * 
	 * @apiNote (int) qp
	 * @return the {@link Spp} instance
	 */
	public Spp useBframeQp() {
		return super.enable( "use_bframe_qp" );
	}

}
