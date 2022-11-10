package com.viiyue.ffmpeg.filter.video;

import com.viiyue.ffmpeg.annotation.Alias;
import com.viiyue.ffmpeg.annotation.Function;
import com.viiyue.ffmpeg.common.AbstractEnum;
import com.viiyue.ffmpeg.filter.AbstractFunction;

/**
 * Apply a 3D LUT to an input video
 * 
 * @author tangxbai
 * @since 2022/07/13
 * @see <a href="https://ffmpeg.org/ffmpeg-filters.html#lut1d">ffmpeg-filters#lut1d</a>
 */
@Function( "lut1d" )
public class Lut3d extends AbstractFunction<Lut3d> {

	// Don't let anyone instantiate this class
	private Lut3d() {}

	/**
	 * Quickly create an instances of {@link Lut3d} and set the 1D LUT file name
	 * 
	 * @apiNote (string) file
	 * @param value the file name
	 * @return the {@link Lut3d} instance
	 */
	public static final Lut3d file( String name ) {
		return new Lut3d().addArg( "file", name );
	}

	/**
	 * Quickly create an instances of {@link Lut3d} and set the 1D LUT file name
	 * 
	 * @apiNote (string) file
	 * @param value the file name enum constants
	 * @return the {@link Lut3d} instance
	 */
	public static final Lut3d file( FileName name ) {
		return new Lut3d().addArg( "file", name );
	}

	/**
	 * Select interpolation mode
	 * 
	 * @apiNote (flags) interp
	 * @param value the interpolation mode
	 * @return the {@link Lut3d} instance
	 */
	public Lut3d interp( Interpolation interp ) {
		return super.addArg( "interp", interp );
	}

	/**
	 * Defined the file name constants
	 *
	 * @author tangxbai
	 * @since 2022/07/13
	 */
	public enum FileName implements AbstractEnum {
		@Alias( "3dl" )
		THREE_DL, CUBE, DAT, M3D, CSP
	}

	/**
	 * Interpolation mode
	 *
	 * @author tangxbai
	 * @since 2022/07/13
	 */
	public enum Interpolation implements AbstractEnum {
		/** Use values from the nearest defined point */
		NEAREST,
		/** Interpolate values using the 8 points defining a cube */
		TRILINEAR,
		/** Interpolate values using a tetrahedron */
		TETRAHEDRAL,
		/** Interpolate values using a pyramid */
		PYRAMID,
		/** Interpolate values using a prism */
		PRISM,
	}

}
