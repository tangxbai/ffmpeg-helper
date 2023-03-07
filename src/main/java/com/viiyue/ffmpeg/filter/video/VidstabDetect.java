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
import com.viiyue.ffmpeg.util.Helper;

/**
 * <p>
 * Analyze video stabilization/deshaking. Perform pass 1 of 2, see
 * <a href="https://ffmpeg.org/ffmpeg-filters.html#vidstabtransform">vidstabtransform</a> for pass 2.
 * 
 * <p>
 * This filter generates a file with relative translation and rotation transform information about subsequent
 * frames, which is then used by the
 * <a href="https://ffmpeg.org/ffmpeg-filters.html#vidstabtransform">vidstabtransform</a> filter.
 * 
 * <p>
 * To enable compilation of this filter you need to configure FFmpeg with {@code --enable-libvidstab}.
 * 
 * @author tangxbai
 * @since 2022/10/13
 * @see <a href="https://ffmpeg.org/ffmpeg-filters.html#vidstabdetect-1">ffmpeg-filters#vidstabdetect</a>
 */
@Function( "vidstabdetect" )
public class VidstabDetect extends AbstractFunction<VidstabDetect> {

	// Don't let anyone instantiate this class
	private VidstabDetect() {}

	/**
	 * Quickly create an instances of {@link VidstabDetect}
	 * 
	 * @return the {@link VidstabDetect} instance
	 */
	public static final VidstabDetect of() {
		return new VidstabDetect();
	}

	/**
	 * Set the path to the file used to write the transforms information. Default value is
	 * <b>"transforms.trf"</b>.
	 * 
	 * @apiNote (string) result
	 * @param path the file used to write the transforms
	 * @return the {@link VidstabDetect} instance
	 */
	public VidstabDetect result( String path ) {
		return super.addArg( "result", Helper.escape( path, true ) );
	}

	/**
	 * Set how shaky the video is and how quick the camera is. It accepts an integer in the range 1-10, a
	 * value of 1 means little shakiness, a value of 10 means strong shakiness. Default value is <b>5</b>.
	 * 
	 * @apiNote (int) shakiness
	 * @param value the video shaky value
	 * @return the {@link VidstabDetect} instance
	 */
	public VidstabDetect shakiness( int value ) {
		Assert.rangeCheck( value, 1, 15 );
		return super.addArg( "shakiness", value );
	}

	/**
	 * Set the accuracy of the detection process. It must be a value in the range 1-15. A value of 1 means low
	 * accuracy, a value of 15 means high accuracy. Default value is <b>15</b>.
	 * 
	 * @apiNote (int) accuracy
	 * @param value the accuracy detection
	 * @return the {@link VidstabDetect} instance
	 */
	public VidstabDetect accuracy( int value ) {
		Assert.rangeCheck( value, 1, 15 );
		return super.addArg( "accuracy", value );
	}

	/**
	 * Set stepsize of the search process. The region around minimum is scanned with 1 pixel resolution.
	 * Default value is <b>6</b>.
	 * 
	 * @apiNote (int) stepsize
	 * @param value the stepsize region
	 * @return the {@link VidstabDetect} instance
	 */
	public VidstabDetect stepSize( int value ) {
		Assert.rangeCheck( value, 1, 32 );
		return super.addArg( "stepsize", value );
	}

	/**
	 * Set minimum contrast. Below this value a local measurement field is discarded. Must be a floating point
	 * value in the range 0-1. Default value is <b>0.25</b>.
	 * 
	 * @apiNote (int) mincontrast
	 * @param value the minimum contrast value
	 * @return the {@link VidstabDetect} instance
	 */
	public VidstabDetect mincontrast( double value ) {
		Assert.rangeCheck( value, 0, 1 );
		return super.addArg( "mincontrast", value );
	}

	/**
	 * <p>
	 * Set reference frame number for tripod mode.
	 * 
	 * <p>
	 * If enabled, the motion of the frames is compared to a reference frame in the filtered stream,
	 * identified by the specified number. The idea is to compensate all movements in a more-or-less static
	 * scene and keep the camera view absolutely still.
	 * 
	 * <p>
	 * If set to 0, it is disabled. The frames are counted starting from 1.
	 * 
	 * @apiNote (int) tripod
	 * @param value the tripod mode frame number
	 * @return the {@link VidstabDetect} instance
	 */
	public VidstabDetect tripod( int value ) {
		return super.addArg( "tripod", value );
	}

	/**
	 * Show fields and transforms in the resulting frames. It accepts an integer in the range 0-2. Default
	 * value is <b>0</b>, which disables any visualization.
	 * 
	 * @apiNote (int) tripod
	 * @param value the fields and transforms resulting frames
	 * @return the {@link VidstabDetect} instance
	 */
	public VidstabDetect show( int value ) {
		Assert.rangeCheck( value, 0, 2 );
		return super.addArg( "show", value );
	}

}
