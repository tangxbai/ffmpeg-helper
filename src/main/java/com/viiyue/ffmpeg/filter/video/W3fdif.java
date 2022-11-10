package com.viiyue.ffmpeg.filter.video;

import com.viiyue.ffmpeg.annotation.Function;
import com.viiyue.ffmpeg.common.AbstractEnum;
import com.viiyue.ffmpeg.enums.Deinterlace;
import com.viiyue.ffmpeg.enums.InterlacingMode;
import com.viiyue.ffmpeg.enums.Parity;
import com.viiyue.ffmpeg.filter.AbstractFunction;

/**
 * <p>
 * Deinterlace the input video ("w3fdif" stands for <b>"Weston 3 Field Deinterlacing Filter"</b>).
 * 
 * <p>
 * Based on the process described by Martin Weston for BBC R&D, and implemented based on the de-interlace
 * algorithm written by Jim Easterbrook for BBC R&D, the Weston 3 field deinterlacing filter uses filter
 * coefficients calculated by BBC R&D.
 * 
 * <p>
 * This filter uses field-dominance information in frame to decide which of each pair of fields to place first
 * in the output. If it gets it wrong use
 * <a href="https://ffmpeg.org/ffmpeg-filters.html#setfield">setfield</a> filter before {@code w3fdif} filter.
 * 
 * <p>
 * There are two sets of filter coefficients, so called "simple" and "complex"
 * 
 * @author tangxbai
 * @since 2022/10/14
 * @see <a href= "https://ffmpeg.org/ffmpeg-filters.html#w3fdif">ffmpeg-filters#w3fdif</a>
 */
@Function( "w3fdif" )
public class W3fdif extends AbstractFunction<W3fdif> {

	// Don't let anyone instantiate this class
	private W3fdif() {}

	/**
	 * Quickly create an instances of {@link W3fdif}
	 * 
	 * @return the {@link W3fdif} instance
	 */
	public static final W3fdif of() {
		return new W3fdif();
	}

	/**
	 * Set the interlacing filter coefficients. Default value is {@link Filter#COMPLEX}.
	 * 
	 * @apiNote (flags) filter
	 * @return the {@link W3fdif} instance
	 * @see Filter
	 */
	public W3fdif filter( Filter filter ) {
		return super.addArg( "filter", filter );
	}

	/**
	 * The interlacing mode to adopt. Default value is {@link InterlacingMode#FIELD}.
	 * 
	 * @apiNote (flags) mode
	 * @param mode the interlacing mode
	 * @return the {@link W3fdif} instance
	 * @see InterlacingMode
	 */
	public W3fdif mode( InterlacingMode mode ) {
		return super.addArg( "mode", mode );
	}

	/**
	 * The picture field parity assumed for the input interlaced video. Default value is {@link Parity#AUTO}.
	 * 
	 * @apiNote (flags) parity
	 * @param parity the picture field parity
	 * @return the {@link W3fdif} instance
	 * @see Parity
	 */
	public W3fdif parity( Parity parity ) {
		return super.addArg( "parity", parity );
	}

	/**
	 * Specify which frames to deinterlace
	 * 
	 * @apiNote (flags) deint
	 * @param deint the which frames to deinterlace
	 * @return the {@link Bwdif} instance
	 * @see Deinterlace
	 */
	public W3fdif deint( Deinterlace deint ) {
		return super.addArg( "deint", deint );
	}

	/**
	 * Interlacing filter coefficients
	 *
	 * @author tangxbai
	 * @since 2022/10/14
	 */
	public enum Filter implements AbstractEnum {
		/** Simple filter coefficient set */
		SIMPLE,
		/** More-complex filter coefficient set */
		COMPLEX
	}

}
