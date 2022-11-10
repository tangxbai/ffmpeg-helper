package com.viiyue.ffmpeg.filter.video;

import com.viiyue.ffmpeg.annotation.Function;
import com.viiyue.ffmpeg.filter.AbstractFunction;
import com.viiyue.ffmpeg.util.Assert;

/**
 * <p>
 * Stack input videos horizontally.
 * 
 * <p>
 * All streams must be of same pixel format and of same height.
 * 
 * <p>
 * Note that this filter is faster than using overlay and pad filter to create same output.
 *
 * @author tangxbai
 * @since 2022/07/11
 * @see <a href="https://ffmpeg.org/ffmpeg-filters.html#hstack">ffmpeg-filters#hstack</a>
 */
@Function( "hstack" )
public class Hstack extends AbstractFunction<Hstack> {

	// Don't let anyone instantiate this class
	private Hstack() {}

	/**
	 * Quickly create an instances of {@link Hstack}
	 * 
	 * @apiNote (int) inputs
	 * @param value the input number
	 * @return the {@link Hstack} instance
	 */
	public static final Hstack inputs( int value ) {
		Assert.isTrue( value >= 2, "Value must be greater than or equal to 2" );
		return new Hstack().addArg( "inputs", value );
	}

	/**
	 * If set to {@code true}, force the output to terminate when the shortest input terminates. Default value
	 * is {@code false}.
	 * 
	 * @apiNote (boolean) shortest
	 * @return the {@link Hstack} instance
	 */
	public Hstack shortest() {
		return super.enable( "shortest" );
	}

}
