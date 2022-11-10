package com.viiyue.ffmpeg.filter.video;

import com.viiyue.ffmpeg.annotation.Function;
import com.viiyue.ffmpeg.filter.AbstractColorFunction;
import com.viiyue.ffmpeg.util.Assert;

/**
 * Remove all color information for all colors except for certain one.
 * 
 * @author tangxbai
 * @since 2022/06/14
 * @see <a href="https://ffmpeg.org/ffmpeg-filters.html#chromahold">ffmpeg-filters#chromahold</a>
 */
@Function( "chromahold" )
public class ChromaHold extends AbstractColorFunction<ChromaHold> {

	// Don't let anyone instantiate this class
	private ChromaHold() {}

	/**
	 * Quickly create an instances of {@link ChromaHold}
	 * 
	 * @return the {@link ChromaHold} instance
	 */
	public static final ChromaHold the() {
		return new ChromaHold();
	}

	/**
	 * Similarity percentage with the above color. 0.01 matches only the exact key color, while 1.0 matches
	 * everything.
	 * 
	 * @apiNote (double) similarity
	 * @param radius the similarity percentage, range is from 0.01 to 1.0.
	 * @return the {@link ChromaHold} instance
	 */
	public ChromaHold similarity( double percentage ) {
		Assert.rangeCheck( percentage, 0.01, 1.0 );
		return super.addArg( "similarity", percentage );
	}

	/**
	 * <p>
	 * Signals that the color passed is already in YUV instead of RGB.
	 * 
	 * <p>
	 * Literal colors like "green" or "red" don’t make sense with this enabled anymore. This can be used to
	 * pass exact YUV values as hexadecimal numbers.
	 * 
	 * @apiNote (boolean) yuv 
	 * @return the {@link ChromaHold} instance
	 */
	public ChromaHold yuv() {
		return super.enable( "yuv" );
	}

}
