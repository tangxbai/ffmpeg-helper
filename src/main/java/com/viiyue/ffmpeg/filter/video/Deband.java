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
 * Remove banding artifacts from input video. It works by replacing banded pixels with average value of
 * referenced pixels.
 * 
 * @author tangxbai
 * @since 2022/06/23
 * @see <a href="https://ffmpeg.org/ffmpeg-filters.html#deband">ffmpeg-filters#deband</a>
 */
@Function( "deband" )
public class Deband extends AbstractFunction<Deband> {

	// Don't let anyone instantiate this class
	private Deband() {}

	/**
	 * Quickly create an instances of {@link Deband}
	 * 
	 * @return the {@link Deband} instance
	 */
	public static final Deband of() {
		return new Deband();
	}

	/**
	 * <p>
	 * Set banding detection threshold for each plane. Valid range is 0.00003 to 0.5. If difference between
	 * current pixel and reference pixel is less than threshold, it will be considered as banded.
	 * 
	 * <p>
	 * The default value is <b>0.02</b>.
	 * 
	 * @apiNote (double) 1thr/2thr/3thr/4thr
	 * @param thr1 the banding detection threshold plane 1
	 * @param thr2 the banding detection threshold plane 2
	 * @param thr3 the banding detection threshold plane 3
	 * @param thr4 the banding detection threshold plane 4
	 * @return the {@link Deband} instance
	 */
	public Deband threshold( double thr1, double thr2, double thr3, double thr4 ) {
		Assert.rangeCheck( thr1, 0.00003D, 0.5D );
		Assert.rangeCheck( thr2, 0.00003D, 0.5D );
		Assert.rangeCheck( thr3, 0.00003D, 0.5D );
		Assert.rangeCheck( thr4, 0.00003D, 0.5D );
		return super.addArg( "1thr", thr1 ).addArg( "2thr", thr2 ).addArg( "3thr", thr3 ).addArg( "4thr", thr4 );
	}

	/**
	 * Set banding detection threshold for all plane. Default is <b>0.02</b>. Valid range is 0.00003 to 0.5.
	 * 
	 * @apiNote (double) 1thr/2thr/3thr/4thr
	 * @param threshold the banding detection threshold for each plane
	 * @return the {@link Deband} instance
	 */
	public Deband thresholds( double threshold ) {
		return threshold( threshold, threshold, threshold, threshold );
	}

	/**
	 * <p>
	 * Banding detection range in pixels
	 * 
	 * <p>
	 * If positive, random number in range 0 to set value will be used.
	 * 
	 * <p>
	 * If negative, exact absolute value will be used. The range defines square of four pixels around current
	 * pixel.
	 * 
	 * <p>
	 * The default value is <b>16</b>.
	 * 
	 * @apiNote (int) range, r
	 * @param endValue the banding detection range in pixels, it can be positive or negative.
	 * @return the {@link Deband} instance
	 */
	public Deband range( int endValue ) {
		return super.addArg( "r", endValue ); // range, r
	}

	/**
	 * <p>
	 * Set direction in radians from which four pixel will be compared.
	 * 
	 * <p>
	 * If positive, random direction from 0 to set direction will be picked.
	 * 
	 * <p>
	 * If negative, exact of absolute value will be picked. For example direction 0, -PI or -2*PI radians will
	 * pick only pixels on same row and -PI/2 will pick only pixels on same column.
	 * 
	 * @apiNote (double) direction, d
	 * @param value the direction radian value
	 * @return the {@link Deband} instance
	 */
	public Deband direction( double value ) {
		Assert.rangeCheck( value, -6.28316D, 6.28319D );
		return super.addArg( "d", value ); // direction, d
	}

	/**
	 * <p>
	 * If enabled, current pixel is compared with average value of all four surrounding pixels.
	 * 
	 * <p>
	 * If disabled current pixel is compared with all four surrounding pixels. The pixel is considered banded
	 * if only all four differences with surrounding pixels are less than threshold.
	 * 
	 * <p>
	 * The default is <b>true</b> (enabled).
	 * 
	 * @apiNote (boolean) blur, b
	 * @return the {@link Deband} instance
	 */
	public Deband blur() {
		return super.enable( "b" ); // blur, b
	}

	/**
	 * <p>
	 * If enabled, current pixel is changed if and only if all pixel components are banded, e.g. banding
	 * detection threshold is triggered for all color components.
	 * 
	 * <p>
	 * The default is <b>false</b> (disabled).
	 * 
	 * @apiNote (boolean) coupling, c
	 * @return the {@link Deband} instance
	 */
	public Deband coupling() {
		return super.enable( "c" ); // coupling, c
	}

}
