package com.viiyue.ffmpeg.filter.video;

import com.viiyue.ffmpeg.annotation.Function;
import com.viiyue.ffmpeg.filter.AbstractFunction;
import com.viiyue.ffmpeg.util.Assert;

/**
 * <p>
 * Remove judder produced by partially interlaced telecined content.
 * 
 * <p>
 * Judder can be introduced, for instance, by pullup filter. If the original source was partially telecined
 * content then the output of pullup,dejudder will have a variable frame rate. May change the recorded frame
 * rate of the container. Aside from that change, this filter will not affect constant frame rate video.
 * 
 * @author tangxbai
 * @since 2022/06/27
 * @see <a href="https://ffmpeg.org/ffmpeg-filters.html#dejudder">ffmpeg-filters#dejudder</a>
 */
@Function( "dejudder" )
public class Dejudder extends AbstractFunction<Dejudder> {

	// Don't let anyone instantiate this class
	private Dejudder() {}

	/**
	 * Quickly create an instances of {@link Dejudder}, and specify the length of the window over which the
	 * judder repeats, default is <b>4</b>.
	 * 
	 * @apiNote (int) cycle
	 * @param cycle the length of the cycle to use
	 * @return the {@link Dejudder} instance
	 */
	public static final Dejudder cycle( int cycle ) {
		Assert.rangeCheck( cycle, 2, 240 );
		return new Dejudder().addArg( "cycle", cycle );
	}

}
