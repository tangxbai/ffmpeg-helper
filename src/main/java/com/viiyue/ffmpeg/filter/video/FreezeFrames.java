package com.viiyue.ffmpeg.filter.video;

import com.viiyue.ffmpeg.annotation.Function;
import com.viiyue.ffmpeg.filter.AbstractColorFunction;
import com.viiyue.ffmpeg.util.Assert;

/**
 * Freeze video frames, this filter freezes video frames using frame from 2nd input.
 * 
 * @author tangxbai
 * @since 2022/07/06
 * @see <a href="https://ffmpeg.org/ffmpeg-filters.html#freezeframes">ffmpeg-filters#freezeframes</a>
 */
@Function( "freezeframes" )
public class FreezeFrames extends AbstractColorFunction<FreezeFrames> {

	// Don't let anyone instantiate this class
	private FreezeFrames() {}

	/**
	 * Quickly create an instances of {@link FreezeFrames}
	 * 
	 * @return the {@link FreezeFrames} instance
	 */
	public static final FreezeFrames of() {
		return new FreezeFrames();
	}

	/**
	 * Set number of first frame from which to start freeze
	 * 
	 * @apiNote (long) first
	 * @param value the first frame to freeze
	 * @return the {@link FreezeFrames} instance
	 */
	public FreezeFrames first( long value ) {
		Assert.isTrue( value >= 1, "Step value must be greater than or equal to 1" );
		return super.addArg( "first", value ); // n, noise
	}

	/**
	 * Set number of last frame from which to end freeze
	 * 
	 * @apiNote (long) last
	 * @param value the last frame to freeze
	 * @return the {@link FreezeFrames} instance
	 */
	public FreezeFrames last( long value ) {
		Assert.isTrue( value >= 1, "Step value must be greater than or equal to 1" );
		return super.addArg( "last", value );
	}

	/**
	 * Set number of frame from 2nd input which will be used instead of replaced frames
	 * 
	 * @apiNote (long) replace
	 * @param value the frame to replace
	 * @return the {@link FreezeFrames} instance
	 */
	public FreezeFrames replace( long value ) {
		Assert.isTrue( value >= 1, "Step value must be greater than or equal to 1" );
		return super.addArg( "replace", value );
	}

}
