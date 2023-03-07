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
 * Sharpen or blur the input video. All parameters are optional and default to the equivalent of the string
 * "5:5:1.0:5:5:0.0".
 * 
 * @author tangxbai
 * @since 2022/10/09
 * @see <a href="https://ffmpeg.org/ffmpeg-filters.html#unsharp-1">ffmpeg-filters#unsharp</a>
 */
@Function( "unsharp" )
public class Unsharp extends AbstractFunction<Unsharp> {

	// Don't let anyone instantiate this class
	private Unsharp() {}

	/**
	 * Quickly create an instances of {@link Unsharp}
	 * 
	 * @return the {@link Unsharp} instance
	 */
	public static final Unsharp of() {
		return new Unsharp();
	}

	/**
	 * Set the luma matrix horizontal size. It must be an odd integer between 3 and 23, the default value is
	 * <b>5</b>.
	 * 
	 * @apiNote (int) luma_msize_x, lx
	 * @param value the luma matrix horizontal size
	 * @return the {@link Unsharp} instance
	 */
	public Unsharp lumaMatrixSizeX( int value ) {
		Assert.rangeCheck( value, 3, 23 );
		return super.addArg( "lx", value ); // luma_msize_x, lx
	}

	/**
	 * Set the luma matrix vertical size. It must be an odd integer between 3 and 23, the default value is
	 * <b>5</b>.
	 * 
	 * @apiNote (int) luma_msize_y, ly
	 * @param value the luma matrix vertical size
	 * @return the {@link Unsharp} instance
	 */
	public Unsharp lumaMatrixSizeY( int value ) {
		Assert.rangeCheck( value, 3, 23 );
		return super.addArg( "ly", value ); // luma_msize_y, ly
	}

	/**
	 * <p>
	 * Set the luma effect strength. It must be a floating point number, reasonable values lay between -2.0
	 * and 5.0.
	 * 
	 * <p>
	 * Negative values will blur the input video, while positive values will sharpen it, a value of zero will
	 * disable the effect.
	 * 
	 * <p>
	 * Default value is <b>1.0</b>.
	 * 
	 * @apiNote (double) luma_amount, la
	 * @param value the luma effect strength
	 * @return the {@link Unsharp} instance
	 */
	public Unsharp lumaAmount( double value ) {
		Assert.rangeCheck( value, -2, 5 );
		return super.addArg( "la", value ); // luma_amount, la
	}

	/**
	 * Set the chroma matrix horizontal size. It must be an odd integer between 3 and 23, the default value is
	 * <b>5</b>.
	 * 
	 * @apiNote (int) chroma_msize_x, cx
	 * @param value the chroma matrix horizontal size
	 * @return the {@link Unsharp} instance
	 */
	public Unsharp chromaMatrixSizeX( int value ) {
		Assert.rangeCheck( value, 3, 23 );
		return super.addArg( "cx", value ); // chroma_msize_x, cx
	}

	/**
	 * Set the chroma matrix vertical size. It must be an odd integer between 3 and 23, the default value is
	 * <b>5</b>.
	 * 
	 * @apiNote (int) chroma_msize_y, ly
	 * @param value the chroma matrix vertical size
	 * @return the {@link Unsharp} instance
	 */
	public Unsharp chromaMatrixSizeY( int value ) {
		Assert.rangeCheck( value, 3, 23 );
		return super.addArg( "cy", value ); // chroma_msize_y, ly
	}

	/**
	 * <p>
	 * Set the chroma effect strength. It must be a floating point number, reasonable values lay between -2.0
	 * and 5.0.
	 * 
	 * <p>
	 * Negative values will blur the input video, while positive values will sharpen it, a value of zero will
	 * disable the effect.
	 * 
	 * <p>
	 * Default value is <b>0.0</b>.
	 * 
	 * @apiNote (double) chroma_amount, ca
	 * @param value the luma effect strength
	 * @return the {@link Unsharp} instance
	 */
	public Unsharp chromaAmount( double value ) {
		Assert.rangeCheck( value, -2, 5 );
		return super.addArg( "la", value ); // chroma_amount, ca
	}

	/**
	 * Set the alpha matrix horizontal size. It must be an odd integer between 3 and 23, the default value is
	 * <b>5</b>.
	 * 
	 * @apiNote (int) alpha_msize_x, cx
	 * @param value the alpha matrix horizontal size
	 * @return the {@link Unsharp} instance
	 */
	public Unsharp alphaMatrixSizeX( int value ) {
		Assert.rangeCheck( value, 3, 23 );
		return super.addArg( "ax", value ); // alpha_msize_x, ax
	}

	/**
	 * Set the alpha matrix vertical size. It must be an odd integer between 3 and 23, the default value is
	 * <b>5</b>.
	 * 
	 * @apiNote (int) alpha_msize_y, ay
	 * @param value the alpha matrix vertical size
	 * @return the {@link Unsharp} instance
	 */
	public Unsharp alphaMatrixSizeY( int value ) {
		Assert.rangeCheck( value, 3, 23 );
		return super.addArg( "cy", value ); // alpha_msize_y, ay
	}

	/**
	 * <p>
	 * Set the alpha effect strength. It must be a floating point number, reasonable values lay between -2.0
	 * and 5.0.
	 * 
	 * <p>
	 * Negative values will blur the input video, while positive values will sharpen it, a value of zero will
	 * disable the effect.
	 * 
	 * <p>
	 * Default value is <b>0.0</b>.
	 * 
	 * @apiNote (double) alpha_amount, aa
	 * @param value the alpha effect strength
	 * @return the {@link Unsharp} instance
	 */
	public Unsharp alphaAmount( double value ) {
		Assert.rangeCheck( value, -2, 5 );
		return super.addArg( "aa", value ); // alpha_amount, aa
	}

}
