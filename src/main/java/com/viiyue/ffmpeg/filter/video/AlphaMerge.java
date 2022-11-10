package com.viiyue.ffmpeg.filter.video;

import com.viiyue.ffmpeg.annotation.Function;
import com.viiyue.ffmpeg.filter.AbstractFunction;

/**
 * <p>
 * Add or replace the alpha component of the primary input with the grayscale value of a second input. This is
 * intended for use with alphaextract to allow the transmission or storage of frame sequences that have alpha
 * in a format that doesn’t support an alpha channel.
 * 
 * <p>
 * For example, to reconstruct full frames from a normal YUV-encoded video and a separate video created with
 * alphaextract, you might use:
 * 
 * <pre>
 * movie=in_alpha.mkv[alpha]; [in][alpha]alphamerge[out]
 * </pre>
 * 
 * @author tangxbai
 * @since 2022/06/02
 * @see <a href="https://ffmpeg.org/ffmpeg-filters.html#alphamerge">ffmpeg-filters#alphamerge</a>
 */
@Function( "alphamerge" )
public class AlphaMerge extends AbstractFunction<AlphaMerge> {

	// Don't let anyone instantiate this class
	private AlphaMerge() {}

}
