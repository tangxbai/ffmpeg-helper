package com.viiyue.ffmpeg.filter.video;

import com.viiyue.ffmpeg.annotation.Function;
import com.viiyue.ffmpeg.filter.AbstractColorFunction;
import com.viiyue.ffmpeg.util.Assert;

/**
 * YUV colorspace color/chroma keying.
 * 
 * @author tangxbai
 * @since 2022/06/14
 * @see <a href="https://ffmpeg.org/ffmpeg-filters.html#chromakey">ffmpeg-filters#chromakey</a>
 */
@Function( "chromakey" )
public class ChromaKey extends AbstractColorFunction<ChromaKey> {

	// Don't let anyone instantiate this class
	private ChromaKey() {}

	/**
	 * Quickly create an instances of {@link ChromaKey}
	 * 
	 * @return the {@link ChromaKey} instance
	 */
	public static final ChromaKey the() {
		return new ChromaKey();
	}

	/**
	 * Similarity percentage with the above color. 0.01 matches only the exact key color, while 1.0 matches
	 * everything.
	 * 
	 * @apiNote (double) similarity
	 * @param radius the similarity percentage, range is from 0.01 to 1.0.
	 * @return the {@link ChromaKey} instance
	 */
	public ChromaKey similarity( double percentage ) {
		Assert.rangeCheck( percentage, 0.01, 1.0 );
		return super.addArg( "similarity", percentage );
	}

	/**
	 * <p>
	 * Blend percentage.
	 * 
	 * <p>
	 * 0.0 makes pixels either fully transparent, or not transparent at all.
	 * 
	 * <p>
	 * Higher values result in semi-transparent pixels, with a higher transparency the more similar the pixels
	 * color is to the key color.
	 * 
	 * @apiNote (double) blend
	 * @param radius the similarity percentage, range is from 0.01 to 1.0.
	 * @return the {@link ChromaKey} instance
	 */
	public ChromaKey blend( double percentage ) {
		Assert.rangeCheck( percentage, 0.01, 1.0 );
		return super.addArg( "blend", percentage );
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
	 * @return the {@link ChromaKey} instance
	 */
	public ChromaKey yuv() {
		return super.enable( "yuv" );
	}

}
