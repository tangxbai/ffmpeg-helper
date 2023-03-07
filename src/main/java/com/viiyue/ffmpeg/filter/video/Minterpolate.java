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
import com.viiyue.ffmpeg.enums.EstimationMethod;
import com.viiyue.ffmpeg.filter.AbstractFunction;
import com.viiyue.ffmpeg.util.Assert;

/**
 * Convert the video to specified frame rate using motion interpolation
 * 
 * @author tangxbai
 * @since 2022/07/18
 * @see <a href="https://ffmpeg.org/ffmpeg-filters.html#minterpolate">ffmpeg-filters#minterpolate</a>
 */
@Function( "minterpolate" )
public class Minterpolate extends AbstractFunction<Minterpolate> {

	// Don't let anyone instantiate this class
	private Minterpolate() {}

	/**
	 * Quickly create an instances of {@link Minterpolate}
	 * 
	 * @return the {@link Minterpolate} instance
	 */
	public static final Minterpolate of() {
		return new Minterpolate();
	}

	/**
	 * Specify the motion interpolation mode
	 * 
	 * @apiNote (flags) mi_mode
	 * @param mi_mode the motion interpolation mode
	 * @return the {@link Minterpolate} instance
	 * @see MotionInterpolationMode
	 */
	public Minterpolate miMode( MotionInterpolationMode mode ) {
		return super.addArg( "mi_mode", mode );
	}

	/**
	 * Specify the motion compensation mode
	 * 
	 * @apiNote (flags) mc_mode
	 * @param mc_mode the motion compensation mode
	 * @return the {@link Minterpolate} instance
	 * @see MotionInterpolationMode
	 */
	public Minterpolate mcMode( MotionInterpolationMode mode ) {
		return super.addArg( "mc_mode", mode );
	}

	/**
	 * Specify the motion estimation mode
	 * 
	 * @apiNote (flags) me_mode
	 * @param mc_mode the motion estimation mode
	 * @return the {@link Minterpolate} instance
	 * @see MotionEstimationMode
	 */
	public Minterpolate meMode( MotionEstimationMode mode ) {
		return super.addArg( "me_mode", mode );
	}

	/**
	 * Specify the motion estimation method
	 * 
	 * @apiNote (flags) me_mode
	 * @param mc_mode the motion estimation mode
	 * @return the {@link Minterpolate} instance
	 * @see EstimationMethod
	 */
	public Minterpolate method( EstimationMethod mode ) {
		return super.addArg( "method", mode );
	}

	/**
	 * Set macroblock size. Value must be greater than or equal to 8, default is <b>16</b>.
	 * 
	 * @apiNote (int) mb_size
	 * @param value the macroblock size
	 * @return the {@link Minterpolate} instance
	 */
	public Minterpolate mbSize( int value ) {
		Assert.isTrue( value >= 8, "Value must be greater than or equal to 8" );
		return super.addArg( "mb_size", value );
	}

	/**
	 * Set search parameter. Value must be greater than or equal to 4, default is <b>7</b>.
	 * 
	 * @apiNote (int) search_param
	 * @param value the search parameter
	 * @return the {@link Minterpolate} instance
	 */
	public Minterpolate searchParam( int value ) {
		Assert.isTrue( value >= 8, "Value must be greater than or equal to 4" );
		return super.addArg( "search_param", value );
	}

	/**
	 * Enable variable-size block motion compensation. Motion estimation is applied with smaller block sizes
	 * at object boundaries in order to make the them less blur. Default is {@code false} (disabled).
	 * 
	 * @apiNote (boolean) vsbmc
	 * @return the {@link Minterpolate} instance
	 */
	public Minterpolate vsbmc() {
		return super.enable( "vsbmc" );
	}

	/**
	 * Scene change detection method. Scene change leads motion vectors to be in random direction. Scene
	 * change detection replace interpolated frames by duplicate ones. May not be needed for other modes
	 * 
	 * @apiNote (flags) scd
	 * @param method the scene change detection method
	 * @return the {@link Minterpolate} instance
	 * @see SceneChangeDetection
	 */
	public Minterpolate sceneChangeDetection( SceneChangeDetection method ) {
		return super.addArg( "scd", method );
	}

	/**
	 * Scene change detection threshold. Value range is from 0 to 100, default is <b>10</b>.
	 * 
	 * @apiNote (int) scd_threshold
	 * @param value the change detection threshold
	 * @return the {@link Minterpolate} instance
	 */
	public Minterpolate sceneChangeThreshold( double value ) {
		Assert.rangeCheck( value, 0, 100 );
		return super.addArg( "scd_threshold", value );
	}

	/**
	 * Motion interpolation mode
	 *
	 * @author tangxbai
	 * @since 2022/07/18
	 */
	public enum MotionInterpolationMode implements AbstractEnum {
		/** Duplicate previous or next frame for interpolating new ones */
		DUP,
		/** Blend source frames. Interpolated frame is mean of previous and next frames */
		BLEND,
		/** Motion compensated interpolation */
		MCI
	}

	/**
	 * Motion compensation mode.
	 *
	 * @author tangxbai
	 * @since 2022/07/18
	 */
	public enum MotionCompensationMode implements AbstractEnum {
		/** Overlapped block motion compensation */
		OBMC,
		/**
		 * Adaptive overlapped block motion compensation. Window weighting coefficients are controlled
		 * adaptively according to the reliabilities of the neighboring motion vectors to reduce oversmoothing
		 */
		AOBMC
	}

	/**
	 * Motion estimation mode.
	 *
	 * @author tangxbai
	 * @since 2022/07/18
	 */
	public enum MotionEstimationMode implements AbstractEnum {
		/**
		 * Bidirectional motion estimation. Motion vectors are estimated for each source frame in both forward
		 * and backward directions.
		 */
		BIDIR,
		/** Bilateral motion estimation. Motion vectors are estimated directly for interpolated frame. */
		BILAT
	}

	/**
	 * Scene change detection
	 *
	 * @author tangxbai
	 * @since 2022/07/18
	 */
	public enum SceneChangeDetection implements AbstractEnum {
		/** Disable scene change detection */
		NONE,
		/**
		 * Frame difference. Corresponding pixel values are compared and if it satisfies scd_threshold scene
		 * change is detected
		 */
		FDIFF
	}

}
