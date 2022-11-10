package com.viiyue.ffmpeg.filter.video;

import com.viiyue.ffmpeg.annotation.Function;
import com.viiyue.ffmpeg.common.AbstractEnum;
import com.viiyue.ffmpeg.filter.AbstractFunction;

/**
 * Convert between different stereoscopic image formats
 * 
 * @author tangxbai
 * @since 2022/08/05
 * @see <a href="https://ffmpeg.org/ffmpeg-filters.html#stereo3d">ffmpeg-filters#stereo3d</a>
 */
@Function( "stereo3d" )
public class Stereo3d extends AbstractFunction<Stereo3d> {

	private InputFormat in;
	private OutputFormat out;

	// Don't let anyone instantiate this class
	private Stereo3d() {}

	@Override
	protected String getResult() {
		super.addValues( in, out );
		return super.getResult();
	}

	/**
	 * Quickly create an instances of {@link Stereo3d}
	 * 
	 * @return the {@link Stereo3d} instance
	 */
	public static final Stereo3d of() {
		return new Stereo3d();
	}

	/**
	 * Set stereoscopic image format of input
	 * 
	 * @apiNote (flags) in
	 * @param format the input format
	 * @return the {@link Stereo3d} instance
	 * @see InputFormat
	 */
	public Stereo3d in( InputFormat format ) {
		this.in = format;
		return this;
	}

	/**
	 * Set stereoscopic image format of output
	 * 
	 * @apiNote (flags) out
	 * @param format the output format
	 * @return the {@link Stereo3d} instance
	 * @see OutputFormat
	 */
	public Stereo3d out( OutputFormat format ) {
		this.out = format;
		return this;
	}

	/**
	 * Stereoscopic image format of input
	 *
	 * @author tangxbai
	 * @since 2022/08/05
	 */
	public enum InputFormat implements AbstractEnum {
		/** Side by side parallel (left eye left, right eye right) */
		SBSL,
		/** Side by side crosseye (right eye left, left eye right) */
		SBSR,
		/** Side by side parallel with half width resolution (left eye left, right eye right) */
		SBS2L,
		/** Side by side crosseye with half width resolution (right eye left, left eye right) */
		SBS2R,
		/** Above-below (left eye above, right eye below) */
		ABL, TBL,
		/** Above-below (right eye above, left eye below) */
		ABR, TBR,
		/** Above-below with half height resolution (left eye above, right eye below) */
		AB2L, TB2L,
		/** Above-below with half height resolution (right eye above, left eye below) */
		AB2R, TB2R,
		/** Alternating frames (left eye first, right eye second) */
		AL,
		/** Alternating frames (right eye first, left eye second) */
		AR,
		/** Interleaved rows (left eye has top row, right eye starts on next row) */
		IRL,
		/** Interleaved rows (right eye has top row, left eye starts on next row) */
		IRR,
		/** Interleaved columns, left eye first */
		ICL,
		/** Interleaved columns, right eye first */
		ICR
	}

	/**
	 * Stereoscopic image format of output
	 *
	 * @author tangxbai
	 * @since 2022/08/05
	 */
	public enum OutputFormat implements AbstractEnum {
		/** Side by side parallel (left eye left, right eye right) */
		SBSL,
		/** Side by side crosseye (right eye left, left eye right) */
		SBSR,
		/** Side by side parallel with half width resolution (left eye left, right eye right) */
		SBS2L,
		/** Side by side crosseye with half width resolution (right eye left, left eye right) */
		SBS2R,
		/** Above-below (left eye above, right eye below) */
		ABL, TBL,
		/** Above-below (right eye above, left eye below) */
		ABR, TBR,
		/** Above-below with half height resolution (left eye above, right eye below) */
		AB2L, TB2L,
		/** Above-below with half height resolution (right eye above, left eye below) */
		AB2R, TB2R,
		/** Alternating frames (left eye first, right eye second) */
		AL,
		/** Alternating frames (right eye first, left eye second) */
		AR,
		/** Interleaved rows (left eye has top row, right eye starts on next row) */
		IRL,
		/** Interleaved rows (right eye has top row, left eye starts on next row) */
		IRR,
		/** Anaglyph red/blue gray (red filter on left eye, blue filter on right eye) */
		ARBG,
		/** Anaglyph red/green gray (red filter on left eye, green filter on right eye) */
		ARGG,
		/** Anaglyph red/cyan gray (red filter on left eye, cyan filter on right eye) */
		ARCG,
		/** Anaglyph red/cyan half colored (red filter on left eye, cyan filter on right eye) */
		ARCH,
		/** Anaglyph red/cyan color (red filter on left eye, cyan filter on right eye) */
		ARCC,
		/**
		 * Anaglyph red/cyan color optimized with the least squares projection of dubois (red filter on left
		 * eye, cyan filter on right eye)
		 */
		ARCD,
		/** Anaglyph green/magenta gray (green filter on left eye, magenta filter on right eye) */
		AGMG,
		/** Anaglyph green/magenta half colored (green filter on left eye, magenta filter on right eye) */
		AGMH,
		/** Anaglyph green/magenta colored (green filter on left eye, magenta filter on right eye) */
		AGMC,
		/**
		 * Anaglyph green/magenta color optimized with the least squares projection of dubois (green filter on
		 * left eye, magenta filter on right eye)
		 */
		AGMD,
		/** Anaglyph yellow/blue gray (yellow filter on left eye, blue filter on right eye) */
		AYBG,
		/** Anaglyph yellow/blue half colored (yellow filter on left eye, blue filter on right eye) */
		AYBH,
		/** Anaglyph yellow/blue colored (yellow filter on left eye, blue filter on right eye) */
		AYBC,
		/**
		 * Anaglyph yellow/blue color optimized with the least squares projection of dubois (yellow filter on
		 * left eye, blue filter on right eye)
		 */
		AYBD,
		/** Mono output (left eye only) */
		ML,
		/** Mono output (right eye only) */
		MR,
		/** Checkerboard, left eye first */
		CHL,
		/** Checkerboard, right eye first */
		CHR,
		/** Interleaved columns, left eye first */
		ICL,
		/** Interleaved columns, right eye first */
		ICR,
		/** HDMI frame pack */
		HDMI
	}

}
