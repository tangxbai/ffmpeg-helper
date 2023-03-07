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
 * Denoise frames using 3D FFT (frequency domain filtering)
 * 
 * @author tangxbai
 * @since 2022/06/30
 * @see <a href="https://ffmpeg.org/ffmpeg-filters.html#fftdnoiz">ffmpeg-filters#fftdnoiz</a>
 */
@Function( "fftdnoiz" )
public class FftDnoiz extends AbstractColorFunction<FftDnoiz> {

	// Don't let anyone instantiate this class
	private FftDnoiz() {}

	/**
	 * Quickly create an instances of {@link ExtractPlanes}
	 * 
	 * @return the {@link FftDnoiz} instance
	 */
	public static final FftDnoiz of() {
		return new FftDnoiz();
	}

	/**
	 * Set the noise sigma constant. This sets denoising strength. Default value is <b>1</b>, allowed range is
	 * from 0 to 30. Using very high sigma with low overlap may give blocking artifacts.
	 * 
	 * @apiNote (double) sigma
	 * @param value the noise sigma constant
	 * @return {@link FftDnoiz} instance
	 */
	public FftDnoiz sigma( double value ) {
		Assert.rangeCheck( value, 0, 30 );
		return super.addArg( "sigma", value );
	}

	/**
	 * Set amount of denoising. By default all detected noise is reduced. Default value is <b>1</b>, allowed
	 * range is from 0.01 to 1.
	 * 
	 * @apiNote (double) amount
	 * @param value the denoising amount
	 * @return {@link FftDnoiz} instance
	 */
	public FftDnoiz amount( double value ) {
		Assert.rangeCheck( value, 0.01, 1 );
		return super.addArg( "amount", value );
	}

	/**
	 * Set size of block in pixels, default is <b>4</b>, can be 3 to 6.
	 * 
	 * @apiNote (int) block
	 * @param value the block pixels size
	 * @return {@link FftDnoiz} instance
	 */
	public FftDnoiz block( int value ) {
		Assert.rangeCheck( value, 3, 6 );
		return super.addArg( "block", value );
	}

	/**
	 * Set block overlap, default is <b>0.5</b>, allowed range is from 0.2 to 0.8.
	 * 
	 * @apiNote (double) overlap
	 * @param value the block overlap
	 * @return {@link FftDnoiz} instance
	 */
	public FftDnoiz overlap( int value ) {
		Assert.rangeCheck( value, 0.2D, 0.8D );
		return super.addArg( "overlap", value );
	}

	/**
	 * Set number of previous frames to use for denoising. By default is set to <b>0</b>.
	 * 
	 * @apiNote (int) prev
	 * @param value the previous frames number
	 * @return {@link FftDnoiz} instance
	 */
	public FftDnoiz prev( int value ) {
		return super.addArg( "prev", value );
	}

	/**
	 * Set number of next frames to to use for denoising. By default is set to <b>0</b>.
	 * 
	 * @apiNote (int) next
	 * @param value the next frames number
	 * @return {@link FftDnoiz} instance
	 */
	public FftDnoiz next( int value ) {
		return super.addArg( "next", value );
	}

	/**
	 * Set planes which will be filtered. By default is set to <b>7</b>, allowed range is from 0 to 15.
	 * 
	 * @apiNote (int) planes
	 * @param value the next frames number
	 * @return {@link FftDnoiz} instance
	 */
	public FftDnoiz planes( int value ) {
		return super.addArg( "planes", value );
	}

}
