package com.viiyue.ffmpeg.filter.video;

import com.viiyue.ffmpeg.annotation.Function;
import com.viiyue.ffmpeg.common.AbstractEnum;
import com.viiyue.ffmpeg.filter.AbstractFunction;

/**
 * Apply a 1D LUT to an input video
 * 
 * @author tangxbai
 * @since 2022/07/13
 * @see <a href="https://ffmpeg.org/ffmpeg-filters.html#lut1d">ffmpeg-filters#lut1d</a>
 */
@Function( "lut1d" )
public class Lut1d extends AbstractFunction<Lut1d> {

	// Don't let anyone instantiate this class
	private Lut1d() {}

	/**
	 * Quickly create an instances of {@link Lut1d} and set the 1D LUT file name
	 * 
	 * @apiNote (string) file
	 * @param value the file name
	 * @return the {@link Lut1d} instance
	 */
	public static final Lut1d file( String name ) {
		return new Lut1d().addArg( "file", name );
	}

	/**
	 * Quickly create an instances of {@link Lut1d} and set the 1D LUT file name
	 * 
	 * @apiNote (string) file
	 * @param value the file name enum constants
	 * @return the {@link Lut1d} instance
	 */
	public static final Lut1d file( FileName name ) {
		return new Lut1d().addArg( "file", name );
	}

	/**
	 * Select interpolation mode
	 * 
	 * @apiNote (flags) interp
	 * @param value the interpolation mode
	 * @return the {@link Lut1d} instance
	 */
	public Lut1d interp( Interpolation mode ) {
		return super.addArg( "interp", mode );
	}

	/**
	 * Defined the file name constants
	 *
	 * @author tangxbai
	 * @since 2022/07/13
	 */
	public enum FileName implements AbstractEnum {
		CUBE, CSP
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
		/** Interpolate values using the linear interpolation */
		LINEAR,
		/** Interpolate values using the cosine interpolation */
		COSINE,
		/** Interpolate values using the cubic interpolation */
		CUBIC,
		/** Interpolate values using the spline interpolation */
		SPLINE,
	}

}
