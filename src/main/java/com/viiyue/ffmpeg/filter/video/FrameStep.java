package com.viiyue.ffmpeg.filter.video;

import com.viiyue.ffmpeg.annotation.Function;
import com.viiyue.ffmpeg.filter.AbstractColorFunction;
import com.viiyue.ffmpeg.util.Assert;

/**
 * Select one frame every N-th frame
 * 
 * @author tangxbai
 * @since 2022/07/06
 * @see <a href="https://ffmpeg.org/ffmpeg-filters.html#framerate">ffmpeg-filters#framerate</a>
 */
@Function( "framestep" )
public class FrameStep extends AbstractColorFunction<FrameStep> {

	// Don't let anyone instantiate this class
	private FrameStep() {}

	/**
	 * Quickly create an instances of {@link FrameStep}
	 * 
	 * @apiNote (int) step
	 * @param step the frame step
	 * @return the {@link FrameStep} instance
	 */
	public static final FrameStep of( int step ) {
		Assert.isTrue( step >= 1, "Step value must be greater than or equal to 1" );
		return new FrameStep().addArg( "step", step );
	}

}
