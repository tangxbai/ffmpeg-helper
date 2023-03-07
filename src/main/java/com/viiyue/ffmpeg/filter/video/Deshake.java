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
 * Attempt to fix small changes in horizontal and/or vertical shift. This filter helps remove camera shake
 * from hand-holding a camera, bumping a tripod, moving on a vehicle, etc.
 * 
 * @author tangxbai
 * @since 2022/06/27
 * @see <a href="https://ffmpeg.org/ffmpeg-filters.html#deshake">ffmpeg-filters#deshake</a>
 */
@Function( "deshake" )
public class Deshake extends AbstractFunction<Deshake> {

	// Don't let anyone instantiate this class
	private Deshake() {}

	/**
	 * Quickly create an instances of {@link Deshake}
	 * 
	 * @return the {@link Deshake} instance
	 */
	public static final Deshake the() {
		return new Deshake();
	}

	/**
	 * Set x for the rectangular search area, range is from -1 to {@link Integer#MAX_VALUE INT_MAX}, default
	 * is <b>-1</b>.
	 * 
	 * @apiNote (int) x
	 * @param value the left search distance
	 * @return the {@link Deshake} instance
	 */
	public Deshake x( int value ) {
		Assert.isTrue( value >= -1, "Value range must be greater than -1" );
		return super.addArg( "x", value );
	}

	/**
	 * Set y for the rectangular search area, range is from -1 to {@link Integer#MAX_VALUE INT_MAX}, default
	 * is <b>-1</b>.
	 * 
	 * @apiNote (int) y
	 * @param value the top search distance
	 * @return the {@link Deshake} instance
	 */
	public Deshake y( int value ) {
		Assert.isTrue( value >= -1, "Value range must be greater than -1" );
		return super.addArg( "y", value );
	}

	/**
	 * set width for the rectangular search area, range is from -1 to {@link Integer#MAX_VALUE INT_MAX},
	 * default is <b>-1</b>.
	 * 
	 * @apiNote (int) w
	 * @param value the width for the rectangular search area
	 * @return the {@link Deshake} instance
	 */
	public Deshake width( int value ) {
		Assert.isTrue( value >= -1, "Value range must be greater than -1" );
		return super.addArg( "w", value );
	}

	/**
	 * set height for the rectangular search area, range is from -1 to {@link Integer#MAX_VALUE INT_MAX},
	 * default is <b>-1</b>.
	 * 
	 * @apiNote (int) h
	 * @param value the height for the rectangular search area
	 * @return the {@link Deshake} instance
	 */
	public Deshake height( int value ) {
		Assert.isTrue( value >= -1, "Value range must be greater than -1" );
		return super.addArg( "h", value );
	}

	/**
	 * Specify the maximum extent of movement in x directions in the range 0-64 pixels, default is <b>16</b>.
	 * 
	 * @apiNote (int) rx
	 * @param value the maximum extend of movement in x
	 * @return the {@link Deshake} instance
	 */
	public Deshake rx( int value ) {
		Assert.rangeCheck( value, 0, 64 );
		return super.addArg( "rx", value );
	}

	/**
	 * Specify the maximum extent of movement in y directions in the range 0-64 pixels, default is <b>16</b>.
	 * 
	 * @apiNote (int) ry
	 * @param value the maximum extend of movement in y
	 * @return the {@link Deshake} instance
	 */
	public Deshake ry( int value ) {
		Assert.rangeCheck( value, 0, 64 );
		return super.addArg( "ry", value );
	}

	/**
	 * Specify the {@code blocksize} to use for motion search. Range is from 4 to 128 pixels, default is
	 * <b>8</b>.
	 * 
	 * @apiNote (int) blocksize
	 * @param size the block size, range is from 4 to 128.
	 * @return the {@link Deshake} instance
	 */
	public Deshake blockSize( int size ) {
		Assert.rangeCheck( size, 4, 128 );
		return super.addArg( "blocksize", size );
	}

	/**
	 * Specify the contrast threshold for blocks. Only blocks with more than the specified contrast
	 * (difference between darkest and lightest pixels) will be considered. Range is from 1 to 255, default is
	 * <b>125</b>.
	 * 
	 * @apiNote (int) contrast
	 * @param size the motion search blocksize
	 * @return the {@link Deshake} instance
	 */
	public Deshake contrast( int size ) {
		Assert.rangeCheck( size, 1, 255 );
		return super.addArg( "contrast", size );
	}

	/**
	 * Specify the search strategy
	 * 
	 * @apiNote (flags) search
	 * @param size the search strategy
	 * @return the {@link Deshake} instance
	 * @see Search
	 */
	public Deshake search( Search search ) {
		return super.addArg( "search", search );
	}

	/**
	 * If set then a detailed log of the motion search is written to the specified file
	 * 
	 * @apiNote (string) filename
	 * @param fileName the motion search detailed log file name
	 * @return the {@link Deshake} instance
	 */
	public Deshake fileName( String fileName ) {
		return super.addArg( "filename", fileName );
	}

	/**
	 * Specify how to generate pixels to fill blanks at the edge of the frame
	 * 
	 * @apiNote (flags) edge
	 * @param mode the edge mode
	 * @return the {@link Deshake} instance
	 * @see EdgeMode
	 */
	public Deshake edge( EdgeMode mode ) {
		return super.addArg( "edge", mode );
	}

	/**
	 * Edge blank fill type
	 *
	 * @author tangxbai
	 * @since 2022/06/27
	 */
	public enum EdgeMode implements AbstractEnum {
		/** Fill zeroes at blank locations */
		BLANK,
		/** Original image at blank locations */
		ORIGINAL,
		/** Extruded edge value at blank locations */
		CLAMP,
		/** Mirrored edge at blank locations */
		MIRROR
	}

	/**
	 * Edge blank fill type
	 *
	 * @author tangxbai
	 * @since 2022/06/27
	 */
	public enum Search implements AbstractEnum {
		/** Set exhaustive search */
		EXHAUSTIVE,
		/** Set less exhaustive search */
		LESS
	}

}
