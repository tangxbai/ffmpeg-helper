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
import com.viiyue.ffmpeg.filter.AbstractFunction;
import com.viiyue.ffmpeg.util.Assert;

/**
 * <p>
 * Apply lens correction via the lensfun library
 * (<a href="https://lensfun.github.io">http://lensfun.sourceforge.net/</a>).
 * 
 * <p>
 * The lensfun filter requires the camera make, camera model, and lens model to apply the lens correction. The
 * filter will load the lensfun database and query it to find the corresponding camera and lens entries in the
 * database. As long as these entries can be found with the given options, the filter can perform corrections
 * on frames. Note that incomplete strings will result in the filter choosing the best match with the given
 * options, and the filter will output the chosen camera and lens models (logged with level "info"). You must
 * provide the make, camera model, and lens model as they are required.
 * 
 * <p>
 * To obtain a list of available makes and models, leave out one or both of make and model options. The filter
 * will send the full list to the log with level INFO. The first column is the make and the second column is
 * the model. To obtain a list of available lenses, set any values for make and model and leave out the
 * lens_model option. The filter will send the full list of lenses in the log with level INFO. The ffmpeg tool
 * will exit after the list is printed.
 * 
 * @author tangxbai
 * @since 2022/07/12
 * @see <a href="https://ffmpeg.org/ffmpeg-filters.html#lensfun">ffmpeg-filters#lensfun</a>
 */
@Function( "lensfun" )
public class LensFun extends AbstractFunction<LensFun> {

	// Don't let anyone instantiate this class
	private LensFun() {}

	/**
	 * Quickly create an instances of {@link LensFun}
	 * 
	 * @return the {@link LensFun} instance
	 */
	public static final LensFun of() {
		return new LensFun();
	}

	/**
	 * The make of the camera (for example, "Canon"), this option is <b>required</b>.
	 * 
	 * @apiNote (string) make
	 * @param maker the camera maker
	 * @return the {@link LensFun} instance
	 */
	public LensFun make( String maker ) {
		return super.addArg( "make", maker );
	}

	/**
	 * Set the make of the camera (for example, "Canon"), the model of the lens (for example, "Canon EF-S
	 * 18-55mm f/3.5-5.6 IS STM") and the model of the lens(for example, "Canon EF-S 18-55mm f/3.5-5.6 IS
	 * STM"), these options are <b>required</b>.
	 * 
	 * @apiNote (string) make
	 * @apiNote (string) model
	 * @apiNote (string) lens
	 * @param maker the camera maker
	 * @param model the camera model
	 * @param lens  the lens model
	 * @return the {@link LensFun} instance
	 */
	public LensFun model( String maker, String model, String lens ) {
		Assert.notEmpty( maker, "Camera maker cannot be null or empty string" );
		Assert.notEmpty( model, "Camera model cannot be null or empty string" );
		Assert.notEmpty( lens, "Lens model cannot be null or empty string" );
		return super.addArg( "make", maker ).addArg( "model", model ).addArg( "lens", lens );
	}

	/**
	 * The full path to the lens database folder. If not set, the filter will attempt to load the database
	 * from the install path when the library was built. Default is <b>unset</b>.
	 * 
	 * @apiNote (string) db_path
	 * @param path the lens database folder
	 * @return the {@link LensFun} instance
	 */
	public LensFun dbPath( String path ) {
		return super.addArg( "db_path", path );
	}

	/**
	 * The type of correction to apply, default is {@link CorrectionType#GEOMETRY}.
	 * 
	 * @apiNote (flags) mode
	 * @param type the correction type
	 * @return the {@link LensFun} instance
	 * @see CorrectionType
	 */
	public LensFun mode( CorrectionType type ) {
		return super.addArg( "mode", type );
	}

	/**
	 * The focal length of the image/video (zoom; expected constant for video). For example, a 18–55mm lens
	 * has focal length range of [18–55], so a value in that range should be chosen when using that lens,
	 * default is <b>18</b>.
	 * 
	 * @apiNote (double) focal_length
	 * @param value the focal length of video
	 * @return the {@link LensFun} instance
	 */
	public LensFun focalLength( double value ) {
		Assert.rangeCheck( value, 18, 55 );
		return super.addArg( "focal_length", value );
	}

	/**
	 * The aperture of the image/video (expected constant for video). Note that aperture is only used for
	 * vignetting correction, default is <b>3.5</b>.
	 * 
	 * @apiNote (double) focal_length
	 * @param value the aperture of the image/video
	 * @return the {@link LensFun} instance
	 */
	public LensFun aperture( double value ) {
		return super.addArg( "aperture", value );
	}

	/**
	 * The focus distance of the image/video (expected constant for video). Note that focus distance is only
	 * used for vignetting and only slightly affects the vignetting correction process. If unknown, leave it
	 * at the default value (which is <b>1000</b>).
	 * 
	 * @apiNote (double) focus_distance
	 * @param value the focus distance of the image/video
	 * @return the {@link LensFun} instance
	 */
	public LensFun focusDistance( double value ) {
		return super.addArg( "focus_distance", value );
	}

	/**
	 * <p>
	 * The scale factor which is applied after transformation. After correction the video is no longer
	 * necessarily rectangular. This parameter controls how much of the resulting image is visible.
	 * 
	 * <p>
	 * The value 0 means that a value will be chosen automatically such that there is little or no unmapped
	 * area in the output image.
	 * 
	 * <p>
	 * 1.0 means that no additional scaling is done. Lower values may result in more of the corrected image
	 * being visible, while higher values may avoid unmapped areas in the output.
	 * 
	 * @apiNote (double) scale
	 * @param value the scale factor applied after corrections
	 * @return the {@link LensFun} instance
	 */
	public LensFun scale( double value ) {
		return super.addArg( "scale", value );
	}

	/**
	 * Set the target geometry of the output image/video
	 * 
	 * @apiNote (flags) target_geometry
	 * @param target the target geometry of the output image/video
	 * @return the {@link LensFun} instance
	 * @see TargetGeometry
	 */
	public LensFun targetGeometry( TargetGeometry target ) {
		return super.addArg( "target_geometry", target );
	}

	/**
	 * Apply the reverse of image correction (instead of correcting distortion, apply it).
	 * 
	 * @apiNote (boolean) reverse
	 * @return the {@link LensFun} instance
	 */
	public LensFun reverse() {
		return super.enable( "reverse" );
	}

	/**
	 * Set the type of interpolation used when correcting distortion
	 * 
	 * @apiNote (flags) interpolation
	 * @return the {@link LensFun} instance
	 */
	public LensFun interp( Interpolation interp ) {
		return super.addArg( "interpolation", interp );
	}

	/**
	 * Correction type
	 *
	 * @author tangxbai
	 * @since 2022/07/12
	 */
	public enum CorrectionType implements AbstractEnum {
		/** Enables fixing lens vignetting */
		VIGNETTING,
		/** Enables fixing lens geometry, this is the <b>default</b> */
		GEOMETRY,
		/** Enables fixing chromatic aberrations */
		@Alias( "subpixel" )
		SUB_PIXEL,
		/** Enables fixing lens vignetting and lens geometry */
		VIG_GEO,
		/** Enables fixing lens vignetting and chromatic aberrations */
		VIG_SUBPIXEL,
		/** Enables fixing both lens geometry and chromatic aberrations */
		DISTORTION,
		/** Enables all possible corrections */
		ALL,
	}

	/**
	 * Target geometry of the output image/video
	 *
	 * @author tangxbai
	 * @since 2022/07/12
	 */
	public enum TargetGeometry implements AbstractEnum {
		RECTILINEAR, FISHEYE, PANORAMIC, EQUIRECTANGULAR, FISHEYE_ORTHOGRAPHIC, FISHEYE_STEREOGRAPHIC,
		FISHEYE_EQUISOLID, FISHEYE_THOBY
	}

	/**
	 * Type of interpolation used when correcting distortion
	 *
	 * @author tangxbai
	 * @since 2022/07/12
	 */
	public enum Interpolation implements AbstractEnum {
		NEAREST, LINEAR, LANCZOS
	}

}
