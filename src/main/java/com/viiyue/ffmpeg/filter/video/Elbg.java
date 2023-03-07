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
 * Apply a posterize effect using the ELBG (Enhanced LBG) algorithm.
 * 
 * <p>
 * For each input image, the filter will compute the optimal mapping from the input to the output given the
 * codebook length, that is the number of distinct output colors.
 * 
 * @author tangxbai
 * @since 2022/06/28
 * @see <a href="https://ffmpeg.org/ffmpeg-filters.html#elbg">ffmpeg-filters#elbg</a>
 */
@Function( "elbg" )
public class Elbg extends AbstractFunction<Elbg> {

	// Don't let anyone instantiate this class
	private Elbg() {}

	/**
	 * Quickly create an instances of {@link Elbg}
	 * 
	 * @return the {@link Elbg} instance
	 */
	public static final Elbg of() {
		return new Elbg();
	}

	/**
	 * Set codebook length. The value must be a positive integer, and represents the number of distinct output
	 * colors, default value is <b>256</b>.
	 * 
	 * @apiNote (int) codebook_length, l
	 * @param value the codebook length
	 * @return the {@link Elbg} instance
	 */
	public Elbg codebookLength( int value ) {
		Assert.isTrue( value >= 1, "Value muse be greater than or equal to 1" );
		return super.addArg( "l", value ); // codebook_length, l
	}

	/**
	 * Set the maximum number of iterations to apply for computing the optimal mapping. The higher the value
	 * the better the result and the higher the computation time, default value is <b>1</b>.
	 * 
	 * @apiNote (int) nb_steps, b
	 * @param value the codebook length
	 * @return the {@link Elbg} instance
	 */
	public Elbg maxStep( int value ) {
		Assert.isTrue( value >= 1, "Value muse be greater than or equal to 1" );
		return super.addArg( "n", value ); // nb_steps, b
	}

	/**
	 * Set a random seed, must be an integer included between 0 and {@link Long#MAX_VALUE MAX_VALUE}. If not
	 * specified, or if explicitly set to -1, the filter will try to use a good random seed on a best effort
	 * basis, default value is <b>-1</b>.
	 * 
	 * @apiNote (long) seed, s
	 * @param value the random seed
	 * @return the {@link Elbg} instance
	 */
	public Elbg seed( long value ) {
		Assert.isTrue( value >= -1, "Value muse be greater than or equal to -1" );
		return super.addArg( "s", value ); // seed, s
	}

	/**
	 * Set pal8 output pixel format. This option does not work with codebook length greater than 256. Default
	 * is {@code false}(disabled).
	 * 
	 * @apiNote (boolean) pal8
	 * @return the {@link Elbg} instance
	 */
	public Elbg pal8() {
		return super.enable( "pal8" );
	}

	/**
	 * Include alpha values in the quantization calculation. Allows creating palettized output images (e.g.
	 * PNG8) with multiple alpha smooth blending.
	 * 
	 * @apiNote (boolean) use_alpha
	 * @return the {@link Elbg} instance
	 */
	public Elbg useAlpha() {
		return super.enable( "use_alpha" );
	}

}
