package com.viiyue.ffmpeg.filter.video;

import com.viiyue.ffmpeg.annotation.Function;
import com.viiyue.ffmpeg.filter.AbstractFunction;
import com.viiyue.ffmpeg.util.Assert;

/**
 * Select the most representative frame in a given sequence of consecutive frames
 * 
 * @author tangxbai
 * @since 2022/08/05
 * @see <a href="https://ffmpeg.org/ffmpeg-filters.html#thumbnail">ffmpeg-filters#thumbnail</a>
 */
@Function( "thumbnail" )
public class Thumbnail extends AbstractFunction<Thumbnail> {

	// Don't let anyone instantiate this class
	private Thumbnail() {}

	/**
	 * <p>
	 * Quickly create an instances of {@link Thumbnail}
	 * 
	 * <p>
	 * Set the frames batch size to analyze; in a set of n frames, the filter will pick one of them, and then
	 * handle the next batch of n frames until the end. Default is <b>100</b>.
	 * 
	 * @apiNote (int) n
	 * @param value the frames batch size
	 * @return the {@link Thumbnail} instance
	 */
	public static final Thumbnail of( int value ) {
		Assert.isTrue( value > 2, "Option value must greater than 1" );
		return new Thumbnail().addValue( value );
	}

}
