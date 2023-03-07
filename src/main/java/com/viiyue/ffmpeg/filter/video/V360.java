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
import com.viiyue.ffmpeg.filter.AbstractColorFunction;
import com.viiyue.ffmpeg.util.Assert;

/**
 * Convert 360 videos between various formats
 * 
 * @author tangxbai
 * @since 2022/10/09
 * @see <a href="https://ffmpeg.org/ffmpeg-filters.html#v360">ffmpeg-filters#v360</a>
 */
@Function( "untile" )
public class V360 extends AbstractColorFunction<V360> {

	// Don't let anyone instantiate this class
	private V360() {}

	/**
	 * Quickly create an instances of {@link V360}
	 * 
	 * @return the {@link V360} instance
	 */
	public static final V360 of() {
		return new V360();
	}

	/**
	 * Set format of the input video
	 * 
	 * @apiNote (flags) input
	 * @param format the input format
	 * @return the {@link V360} instance
	 * @see InOutFormat
	 */
	public V360 input( InOutFormat format ) {
		return super.addArg( "input", format );
	}

	/**
	 * Set format of the output video
	 * 
	 * @apiNote (flags) output
	 * @param format the output format
	 * @return the {@link V360} instance
	 * @see InOutFormat
	 */
	public V360 output( InOutFormat format ) {
		return super.addArg( "output", format );
	}

	/**
	 * Set interpolation method
	 * 
	 * @apiNote (flags) interp
	 * @param interp the interpolation method
	 * @return the {@link V360} instance
	 * @see Interpolation
	 */
	public V360 interp( Interpolation interp ) {
		return super.addArg( "interp", interp );
	}

	/**
	 * Set the output video resolution
	 * 
	 * @apiNote (int) w, h
	 * @param w the output video width
	 * @param w the output video height
	 * @return the {@link V360} instance
	 */
	public V360 size( int width, int height ) {
		Assert.rangeCheck( width, 0, 32767 );
		Assert.rangeCheck( height, 0, 32767 );
		return super.addArg( "w", width ).addArg( "h", height );
	}

	/**
	 * Set the input stereo format
	 * 
	 * @apiNote (flags) in_stereo
	 * @param interp the input stereo format
	 * @return the {@link V360} instance
	 * @see Stereo
	 */
	public V360 inStereo( Stereo stereo ) {
		return super.addArg( "in_stereo", stereo );
	}

	/**
	 * Set the output stereo format
	 * 
	 * @apiNote (flags) out_stereo
	 * @param interp the output stereo format
	 * @return the {@link V360} instance
	 * @see Stereo
	 */
	public V360 outStereo( Stereo stereo ) {
		return super.addArg( "out_stereo", stereo );
	}

	/**
	 * Set yaw rotation for the output video, values in degrees. The value range is from -180 to 180, default
	 * is <b>0</b>.
	 * 
	 * @apiNote (double) yaw
	 * @param value the rotation degrees
	 * @return the {@link V360} instance
	 */
	public V360 yaw( double value ) {
		Assert.rangeCheck( value, -180, 180 );
		return super.addArg( "yaw", value );
	}

	/**
	 * Set pitch rotation for the output video, values in degrees. The value range is from -180 to 180,
	 * default is <b>0</b>.
	 * 
	 * @apiNote (double) pitch
	 * @param value the rotation degrees
	 * @return the {@link V360} instance
	 */
	public V360 pitch( double value ) {
		Assert.rangeCheck( value, -180, 180 );
		return super.addArg( "pitch", value );
	}

	/**
	 * Set roll rotation for the output video, values in degrees. The value range is from -180 to 180, default
	 * is <b>0</b>.
	 * 
	 * @apiNote (double) roll
	 * @param value the rotation degrees
	 * @return the {@link V360} instance
	 */
	public V360 roll( double value ) {
		Assert.rangeCheck( value, -180, 180 );
		return super.addArg( "roll", value );
	}

	/**
	 * Set rotation order for the output video. Choose one item for each position, default is <b>ypr</b>.
	 * 
	 * <pre>
	 * 'y, Y' - yaw
	 * 'p, P' - pitch
	 * 'r, R' - roll
	 * </pre>
	 * 
	 * @apiNote (string) rorder
	 * @param value the rotation degrees
	 * @return the {@link V360} instance
	 */
	public V360 rorder( String expression ) {
		return super.addArg( "rorder", expression );
	}

	/**
	 * Flip out video horizontally. Boolean values.
	 * 
	 * @apiNote (boolean) h_flip
	 * @return the {@link V360} instance
	 */
	public V360 hFlip() {
		return super.enable( "h_flip" );
	}

	/**
	 * Flip out video vertically. Boolean values.
	 * 
	 * @apiNote (boolean) v_flip
	 * @return the {@link V360} instance
	 */
	public V360 vFlip() {
		return super.enable( "v_flip" );
	}

	/**
	 * Flip out video indepth. Boolean values.
	 * 
	 * @apiNote (boolean) d_flip
	 * @return the {@link V360} instance
	 */
	public V360 dFlip() {
		return super.enable( "d_flip" );
	}

	/**
	 * Flip in video horizontally. Boolean values.
	 * 
	 * @apiNote (boolean) ih_flip
	 * @return the {@link V360} instance
	 */
	public V360 ihFlip() {
		return super.enable( "ih_flip" );
	}

	/**
	 * Flip in video vertically. Boolean values.
	 * 
	 * @apiNote (boolean) iv_flip
	 * @return the {@link V360} instance
	 */
	public V360 ivFlip() {
		return super.enable( "iv_flip" );
	}

	/**
	 * Set if input video is transposed. Boolean value, by default disabled.
	 * 
	 * @apiNote (boolean) in_trans
	 * @return the {@link V360} instance
	 */
	public V360 inTrans() {
		return super.enable( "in_trans" );
	}

	/**
	 * Set if output video needs to be transposed. Boolean value, by default disabled.
	 * 
	 * @apiNote (boolean) out_trans
	 * @return the {@link V360} instance
	 */
	public V360 outTrans() {
		return super.enable( "out_trans" );
	}

	/**
	 * Set output horizontal off-axis offset. Default is set to <b>0</b>, allowed range is from -1 to 1.
	 * 
	 * @apiNote (boolean) h_offset
	 * @param value the horizontal off-axis offset
	 * @return the {@link V360} instance
	 */
	public V360 hOffset( double value ) {
		Assert.rangeCheck( value, -1, 1 );
		return super.enable( "h_offset" );
	}

	/**
	 * Set output vertical off-axis offset. Default is set to <b>0</b>, allowed range is from -1 to 1.
	 * 
	 * @apiNote (boolean) v_offset
	 * @param value the horizontal off-axis offset
	 * @return the {@link V360} instance
	 */
	public V360 vOffset( double value ) {
		Assert.rangeCheck( value, -1, 1 );
		return super.enable( "v_offset" );
	}

	/**
	 * Build mask in alpha plane for all unmapped pixels by marking them fully transparent. Boolean value, by
	 * default disabled.
	 * 
	 * @apiNote (boolean) alpha_mask
	 * @return the {@link V360} instance
	 */
	public V360 alphaMask() {
		return super.enable( "alpha_mask" );
	}

	/**
	 * Reset rotation of output video. Boolean value, by default disabled.
	 * 
	 * @apiNote (boolean) reset_rot
	 * @return the {@link V360} instance
	 */
	public V360 resetRotation() {
		return super.enable( "reset_rot" );
	}

	/**
	 * Input/Output video format
	 *
	 * @author tangxbai
	 * @since 2022/10/09
	 */
	public enum InOutFormat implements AbstractEnum {

		/** Short name of the {@link #EQUIRECT} */
		E,
		/** Equirectangular projection */
		EQUIRECT,

		/** Cubemap with 3x2 layout */
		C3X2,
		/** Cubemap with 6x1 layout */
		C6X1,
		/** Cubemap with 1x6 layout */
		C1X6,

		/** Equi-Angular Cubemap */
		EAC,

		/** Regular video */
		FLAT,
		/** Regular video */
		GNOMONIC,
		/** Regular video */
		RECTILINEAR,

		/** Dual fisheye */
		DFISHEYE,

		/** Facebook’s 360 formats */
		FB,
		/** Facebook’s 360 formats */
		BARREL,
		/** Facebook’s 360 formats */
		@Alias( "barrelsplit" )
		BARREL_SPLIT,

		/** Stereographic format */
		SG,
		/** Mercator format */
		MERCATOR,
		/** Ball format, gives significant distortion toward the back */
		BALL,
		/** Hammer-Aitoff map projection format */
		HAMMER,
		/** Sinusoidal map projection format */
		SINUSOIDAL,
		/** Fisheye projection */
		FISHEYE,
		/** Pannini projection */
		PANNINI,
		/** Cylindrical projection */
		CYLINDRICAL,
		/** Perspective projection( <b>output</b> only ) */
		PERSPECTIVE,
		/** Tetrahedron projection */
		TETRAHEDRON,
		/** Truncated square pyramid projection */
		TSP,

		/** Half equirectangular projection */
		HE,
		/** Half equirectangular projection */
		HEQUIRECT,

		/** Equisolid format */
		EQUISOLID,

		/** Orthographic format */
		OG,
		/** Octahedron projection */
		OCTAHEDRON,

		/** Cylindrical Equal Area projection */
		CYLINDRICALEA
	}

	/**
	 * Interpolation method
	 *
	 * @author tangxbai
	 * @since 2022/10/09
	 */
	public enum Interpolation implements AbstractEnum {
		/** Nearest neighbour */
		NEAR,
		/** Nearest neighbour */
		NEAREST,

		/** Bilinear interpolation */
		LINE,
		/** Bilinear interpolation */
		LINEAR,

		/** Lagrange9 interpolation */
		LAGRANGE9,

		/** Bicubic interpolation */
		CUBE,
		/** Bicubic interpolation */
		CUBIC,

		/** Lanczos interpolation */
		LANC,
		/** Lanczos interpolation */
		LANCZOS,

		/** Spline16 interpolation */
		SP16,
		/** Spline16 interpolation */
		SPLINE16,

		/** Gaussian interpolation */
		GAUSS,
		/** Gaussian interpolation */
		GAUSSIAN,

		/** Mitchell interpolation */
		MITCHELL
	}

	/**
	 * Input/Output stereo format
	 *
	 * @author tangxbai
	 * @since 2022/10/09
	 */
	public enum Stereo implements AbstractEnum {
		/** 2D mono */
		@Alias( "2d" )
		TWO_D,
		/** Side by side */
		SBS,
		/** Top bottom */
		TB
	}

}
