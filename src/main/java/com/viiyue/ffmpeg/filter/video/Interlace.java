package com.viiyue.ffmpeg.filter.video;

import com.viiyue.ffmpeg.annotation.Function;
import com.viiyue.ffmpeg.common.AbstractEnum;
import com.viiyue.ffmpeg.enums.Interlaced;
import com.viiyue.ffmpeg.filter.AbstractFunction;

/**
 * Simple interlacing filter from progressive contents. This interleaves upper (or lower) lines from odd
 * frames with lower (or upper) lines from even frames, halving the frame rate and preserving image height.
 *
 * @author tangxbai
 * @since 2022/07/12
 * @see <a href="https://ffmpeg.org/ffmpeg-filters.html#interlace">ffmpeg-filters#interlace</a>
 */
@Function( "interlace" )
public class Interlace extends AbstractFunction<Interlace> {

	// Don't let anyone instantiate this class
	private Interlace() {}

	/**
	 * Quickly create an instances of {@link Interlace}
	 * 
	 * @return the {@link Interlace} instance
	 */
	public static final Interlace of() {
		return new Interlace();
	}

	/**
	 * This determines whether the interlaced frame is taken from the even ({@link Interlaced#TOP_FIELD_FIRST
	 * tff} - default) or odd ({@link Interlaced#BOTTOM_FIEL_FIRST bff}) lines of the progressive frame.
	 * 
	 * @apiNote (flags) scan
	 * @param mode the interlaced frame scan mode
	 * @return the {@link Interlace} instance
	 */
	public Interlace scan( Interlaced mode ) {
		return super.addArg( "scan", mode );
	}

	/**
	 * Vertical {@code lowpass} filter to avoid twitter interlacing and reduce moire patterns
	 * 
	 * @apiNote (flags) lowpass
	 * @param filter the lowpass filter
	 * @return the {@link Interlace} instance
	 */
	public Interlace lowpass( LowPass filter ) {
		return super.addArg( "lowpass", filter );
	}

	public enum LowPass implements AbstractEnum {
		/** Disable vertical lowpass filter */
		OFF,
		/** Enable linear filter (default) */
		LINEAR,
		/**
		 * Enable complex filter, this will slightly less reduce twitter and moire but better retain detail
		 * and subjective sharpness impression.
		 */
		COMPLEX
	}

}
