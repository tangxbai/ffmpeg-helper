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
 * Reduce various flashes in video, so to help users with epilepsy.
 * 
 * @author tangxbai
 * @since 2022/07/20
 * @see <a href="https://ffmpeg.org/ffmpeg-filters.html#photosensitivity">ffmpeg-filters#photosensitivity</a>
 */
@Function( "photosensitivity" )
public class PhotoSensitivity extends AbstractFunction<PhotoSensitivity> {

	// Don't let anyone instantiate this class
	private PhotoSensitivity() {}

	/**
	 * Quickly create an instances of {@link PhotoSensitivity}
	 * 
	 * @return the {@link PhotoSensitivity} instance
	 */
	public static final PhotoSensitivity of() {
		return new PhotoSensitivity();
	}

	/**
	 * Set how many frames to use when filtering. Value range is [2,200], default is <b>30</b>.
	 * 
	 * @apiNote (int) frames, f
	 * @param value the how frames to use
	 * @return the {@link PhotoSensitivity} instance
	 */
	public PhotoSensitivity frames( int value ) {
		Assert.rangeCheck( value, 2, 200 );
		return super.addArg( "f", value ); // frames, f
	}

	/**
	 * Set detection threshold factor. Default is <b>1</b>. Lower is stricter.
	 * 
	 * @apiNote (int) threshold, t
	 * @param value the how frames to use
	 * @return the {@link PhotoSensitivity} instance
	 */
	public PhotoSensitivity threshold( int value ) {
		return super.addArg( "t", value ); // threshold, t
	}

	/**
	 * Set how many pixels to skip when sampling frames. Allowed range is from 1 to 1024, default is <b>1</b>.
	 * 
	 * @apiNote (int) skip
	 * @param value the pixels to skip
	 * @return the {@link PhotoSensitivity} instance
	 */
	public PhotoSensitivity skip( int value ) {
		Assert.rangeCheck( value, 1, 1024 );
		return super.addArg( "skip", value );
	}

	/**
	 * Leave frames unchanged. Default is {@code false} (disabled).
	 * 
	 * @apiNote (boolean) bypass
	 * @return the {@link PhotoSensitivity} instance
	 */
	public PhotoSensitivity byPass() {
		return super.enable( "bypass" );
	}

}
