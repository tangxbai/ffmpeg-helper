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

import com.viiyue.ffmpeg.annotation.Alias;
import com.viiyue.ffmpeg.annotation.Function;
import com.viiyue.ffmpeg.common.AbstractEnum;
import com.viiyue.ffmpeg.enums.Deinterlace;
import com.viiyue.ffmpeg.enums.InterlacingMode;
import com.viiyue.ffmpeg.filter.AbstractFunction;
import com.viiyue.ffmpeg.util.Assert;

/**
 * <p>
 * Deinterlace the input video ("estdif" stands for "Edge Slope Tracing Deinterlacing Filter").
 * 
 * <p>
 * Spatial only filter that uses edge slope tracing algorithm to interpolate missing lines.
 * 
 * @author tangxbai
 * @since 2022/06/30
 * @see <a href="https://ffmpeg.org/ffmpeg-filters.html#estdif">ffmpeg-filters#estdif</a>
 */
@Function( "estdif" )
public class Estdif extends AbstractFunction<Estdif> {

	// Don't let anyone instantiate this class
	private Estdif() {}

	/**
	 * Quickly create an instances of {@link Estdif}
	 * 
	 * @return the {@link Estdif} instance
	 */
	public static final Estdif of() {
		return new Estdif();
	}

	/**
	 * The interlacing mode to adopt
	 * 
	 * @apiNote (flags) mode
	 * @param value the specify mode
	 * @return the {@link Estdif} instance
	 * @see InterlacingMode
	 */
	public Estdif mode( InterlacingMode mode ) {
		return super.addArg( "mode", mode );
	}

	/**
	 * The picture field parity assumed for the input interlaced video. The default value is
	 * {@link Parity#AUTO AUTO}. If the interlacing is unknown or the decoder does not export this
	 * information, top field first will be assumed.
	 * 
	 * @apiNote (flags) parity
	 * @param parity the assumed picture field parity
	 * @return the {@link Estdif} instance
	 * @see Parity
	 */
	public Estdif parity( Parity parity ) {
		return super.addArg( "parity", parity );
	}

	/**
	 * Specify which frames to deinterlace, the default value is {@link Deinterlace#ALL}.
	 * 
	 * @apiNote (flags) deint
	 * @param value the frames to deinterlace
	 * @return the {@link Estdif} instance
	 * @see Deinterlace
	 */
	public Estdif deint( Deinterlace deint ) {
		return super.addArg( "deint", deint );
	}

	/**
	 * Specify the search radius for edge slope tracing. Allowed range is from 1 to 15, default value is
	 * <b>1</b>.
	 * 
	 * @apiNote (int) rslope
	 * @param value the search radius for edge slope tracing
	 * @return the {@link Estdif} instance
	 */
	public Estdif slopeRaduis( int value ) {
		Assert.rangeCheck( value, 1, 15 );
		return super.addArg( "rslope", value );
	}

	/**
	 * Specify the search radius for best edge matching. Allowed range is from 0 to 15, default value is
	 * <b>2</b>.
	 * 
	 * @apiNote (int) redge
	 * @param value the search radius for edge slope tracing
	 * @return the {@link Estdif} instance
	 */
	public Estdif edgeRadius( int value ) {
		Assert.rangeCheck( value, 0, 15 );
		return super.addArg( "redge", value );
	}

	/**
	 * Specify the edge cost for edge matching. Allowed range is from 0 to 1, default value is <b>0.03125</b>.
	 * 
	 * @apiNote (double) ecost
	 * @param value the edge cost for edge matching
	 * @return the {@link Estdif} instance
	 */
	public Estdif edgeCost( double value ) {
		Assert.rangeCheck( value, 0D, 1D );
		return super.addArg( "ecost", value );
	}

	/**
	 * Specify the middle cost for edge matching. Allowed range is from 0 to 1, default value is <b>0.5</b>.
	 * 
	 * @apiNote (double) mcost
	 * @param value the middle cost for edge matching
	 * @return the {@link Estdif} instance
	 */
	public Estdif middleCost( double value ) {
		Assert.rangeCheck( value, 0D, 1D );
		return super.addArg( "mcost", value );
	}

	/**
	 * Specify the distance cost for edge matching. Allowed range is from 0 to 1, default value is <b>0.5</b>.
	 * 
	 * @apiNote (double) dcost
	 * @param value the distance cost for edge matching
	 * @return the {@link Estdif} instance
	 */
	public Estdif distanceCost( double value ) {
		Assert.rangeCheck( value, 0D, 1D );
		return super.addArg( "dcost", value );
	}

	/**
	 * Specify the interpolation used. Default is {@link Interpolation#FOUR_POINT FOUR_POINT}(4p)
	 * interpolation
	 * 
	 * @apiNote (flags) interp
	 * @param interpolation the interpolation type
	 * @return the {@link Estdif} instance
	 * @see Interpolation
	 */
	public Estdif interp( Interpolation interpolation ) {
		return super.addArg( "interp", interpolation );
	}

	/**
	 * Assume picture field parity
	 *
	 * @author tangxbai
	 * @since 2022/06/30
	 */
	public enum Parity implements AbstractEnum {
		/** Assume the top field is first */
		TFF,
		/** Assume the bottom field is first */
		FIELD,
		/** Enable automatic detection of field parity */
		AUTO
	}

	/**
	 * Interpolation type
	 *
	 * @author tangxbai
	 * @since 2022/06/30
	 */
	public enum Interpolation implements AbstractEnum {
		/** (2p) Two-point interpolation */
		@Alias( "2p" )
		TWO_POINT,
		/** (4p) Four-point interpolation */
		@Alias( "4p" )
		FOUR_POINT,
		/** (6p) Six-point interpolation */
		@Alias( "6p" )
		SIX_POINT
	}

}
