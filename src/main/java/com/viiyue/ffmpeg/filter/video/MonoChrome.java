package com.viiyue.ffmpeg.filter.video;

import com.viiyue.ffmpeg.annotation.Function;
import com.viiyue.ffmpeg.filter.AbstractFunction;
import com.viiyue.ffmpeg.util.Assert;

/**
 * Convert video to gray using custom color filter
 * 
 * @author tangxbai
 * @since 2022/07/19
 * @see <a href="https://ffmpeg.org/ffmpeg-filters.html#monochrome">ffmpeg-filters#monochrome</a>
 */
@Function( "monochrome" )
public class MonoChrome extends AbstractFunction<MonoChrome> {

	// Don't let anyone instantiate this class
	private MonoChrome() {}

	/**
	 * Quickly create an instances of {@link MonoChrome}
	 * 
	 * @return the {@link MonoChrome} instance
	 */
	public static final MonoChrome of() {
		return new MonoChrome();
	}

	/**
	 * Set the chroma blue spot. Allowed range is from -1 to 1, default value is <b>0</b>.
	 * 
	 * @apiNote (double) cb
	 * @param value the chroma blue spot
	 * @return the {@link MonoChrome} instance
	 */
	public MonoChrome chromaBlue( double value ) {
		Assert.rangeCheck( value, -1, 1 );
		return super.addArg( "cb", value );
	}

	/**
	 * Set the chroma red spot. Allowed range is from -1 to 1, default value is <b>0</b>.
	 * 
	 * @apiNote (double) cr
	 * @param value the chroma blue spot
	 * @return the {@link MonoChrome} instance
	 */
	public MonoChrome chromaRed( double value ) {
		Assert.rangeCheck( value, -1, 1 );
		return super.addArg( "cr", value );
	}

	/**
	 * Set the color filter size. Allowed range is from 0.1 to 10, default value is <b>1</b>.
	 * 
	 * @apiNote (double) size
	 * @param value the color filter size
	 * @return the {@link MonoChrome} instance
	 */
	public MonoChrome size( double value ) {
		Assert.rangeCheck( value, 0.1, 10 );
		return super.addArg( "size", value );
	}

	/**
	 * Set the highlights strength. Allowed range is from 0 to 1, default value is <b>1</b>.
	 * 
	 * @apiNote (double) high
	 * @param value the the highlights strength
	 * @return the {@link MonoChrome} instance
	 */
	public MonoChrome high( double value ) {
		Assert.rangeCheck( value, 0.0, 1.0 );
		return super.addArg( "high", value );
	}

}
