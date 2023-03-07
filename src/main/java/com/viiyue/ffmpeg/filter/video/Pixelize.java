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
 * Apply pixelization to video stream
 * 
 * @author tangxbai
 * @since 2022/07/20
 * @see <a href="https://ffmpeg.org/ffmpeg-filters.html#pixelize">ffmpeg-filters#pixelize</a>
 */
@Function( "pixelize" )
public class Pixelize extends AbstractFunction<Pixelize> {

	// Don't let anyone instantiate this class
	private Pixelize() {}

	/**
	 * Quickly create an instances of {@link Pixelize}
	 * 
	 * @return the {@link Pixelize} instance
	 */
	public static final Pixelize of() {
		return new Pixelize();
	}

	/**
	 * Set block dimensions that will be used for pixelization
	 * 
	 * @apiNote (int) width, w
	 * @param value the width of block dimensions
	 * @return the {@link Pixelize} instance
	 */
	public Pixelize width( int value ) {
		return super.addArg( "w", value ); // width, w
	}

	/**
	 * Set block dimensions that will be used for pixelization
	 * 
	 * @apiNote (int) height, h
	 * @param value the height of block dimensions
	 * @return the {@link Pixelize} instance
	 */
	public Pixelize height( int value ) {
		return super.addArg( "h", value ); // height, h
	}

	/**
	 * Set the mode of pixelization used
	 * 
	 * @apiNote (flags) mode, m
	 * @param mode the pixelization used mode
	 * @return the {@link Pixelize} instance
	 */
	public Pixelize mode( PixelMode mode ) {
		return super.addArg( "m", mode ); // mode, m
	}

	/**
	 * Set what planes to filter. Value range allowed is from 0 to 15, default value is <b>15</b>, all planes
	 * will be processed.
	 * 
	 * @apiNote (int) planes
	 * @param value the plane filter
	 * @return the {@link Pixelize} instance
	 */
	public Pixelize planes( int value ) {
		Assert.rangeCheck( value, 0, 15 );
		return super.addArg( "planes", value );
	}

	/**
	 * Pixelization mode
	 *
	 * @author tangxbai
	 * @since 2022/07/20
	 */
	public enum PixelMode implements AbstractEnum {
		AVG, MIN, MAX
	}

}
