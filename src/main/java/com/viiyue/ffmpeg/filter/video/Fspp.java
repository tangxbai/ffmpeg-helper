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
import com.viiyue.ffmpeg.filter.AbstractColorFunction;
import com.viiyue.ffmpeg.util.Assert;

/**
 * <p>
 * Apply fast and simple postprocessing. It is a faster version of spp.
 * 
 * <p>
 * It splits (I)DCT into horizontal/vertical passes. Unlike the simple post- processing filter, one of them is
 * performed once per block, not per pixel. This allows for much higher speed.
 * 
 * @author tangxbai
 * @since 2022/07/07
 * @see <a href="https://ffmpeg.org/ffmpeg-filters.html#fspp">ffmpeg-filters#fspp</a>
 */
@Function( "fspp" )
public class Fspp extends AbstractColorFunction<Fspp> {

	// Don't let anyone instantiate this class
	private Fspp() {}

	/**
	 * Quickly create an instances of {@link Fspp}
	 * 
	 * @return the {@link Fspp} instance
	 */
	public static final Fspp of() {
		return new Fspp();
	}

	/**
	 * Set quality. This option defines the number of levels for averaging. It accepts an integer in the range
	 * 4-5. Default value is <b>4</b>.
	 * 
	 * @apiNote (int) quality
	 * @param value the video quality
	 * @return the {@link Fspp} instance
	 */
	public Fspp quality( int value ) {
		Assert.rangeCheck( value, 4, 5 );
		return super.addArg( "quality", value );
	}

	/**
	 * Force a constant quantization parameter. It accepts an integer in range 0-63. If not set, the filter
	 * will use the QP from the video stream (if available), default is <b>0</b>.
	 * 
	 * @apiNote (int) qp
	 * @param value the quantization parameter
	 * @return the {@link Fspp} instance
	 */
	public Fspp quantizerParameter( int value ) {
		Assert.rangeCheck( value, 0, 64 );
		return super.addArg( "quality", value );
	}

	/**
	 * Set filter strength. It accepts an integer in range -15 to 32. Lower values mean more details but also
	 * more artifacts, while higher values make the image smoother but also blurrier. Default value is 0 −
	 * PSNR optimal.
	 * 
	 * @apiNote (int) qp
	 * @param value the quantization parameter
	 * @return the {@link Fspp} instance
	 */
	public Fspp strength( int value ) {
		Assert.rangeCheck( value, -15, 32 );
		return super.addArg( "strength", value );
	}

	/**
	 * Enable the use of the QP from the B-Frames if set to {@code true}. Using this option may cause flicker
	 * since the B-Frames have often larger QP. Default is {@code false} (not enabled).
	 * 
	 * @apiNote (boolean) use_bframe_qp
	 * @return the {@link Fspp} instance
	 */
	public Fspp bFramesQP() {
		return super.enable( "use_bframe_qp" );
	}

}
