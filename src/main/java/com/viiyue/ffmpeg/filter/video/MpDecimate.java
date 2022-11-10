package com.viiyue.ffmpeg.filter.video;

import com.viiyue.ffmpeg.annotation.Function;
import com.viiyue.ffmpeg.filter.AbstractFunction;

/**
 * <p>
 * Drop frames that do not differ greatly from the previous frame in order to reduce frame rate.
 * 
 * <p>
 * The main use of this filter is for very-low-bitrate encoding (e.g. streaming over dialup modem), but it
 * could in theory be used for fixing movies that were inverse-telecined incorrectly.
 * 
 * @author tangxbai
 * @since 2022/07/19
 * @see <a href="https://ffmpeg.org/ffmpeg-filters.html#mpdecimate">ffmpeg-filters#mpdecimate</a>
 */
@Function( "mpdecimate" )
public class MpDecimate extends AbstractFunction<MpDecimate> {

	// Don't let anyone instantiate this class
	private MpDecimate() {}

	/**
	 * Quickly create an instances of {@link MpDecimate}
	 * 
	 * @return the {@link MpDecimate} instance
	 */
	public static final MpDecimate of() {
		return new MpDecimate();
	}

	/**
	 * <p>
	 * Set the maximum number of consecutive frames which can be dropped (if positive), or the minimum
	 * interval between dropped frames (if negative). If the value is 0, the frame is dropped disregarding the
	 * number of previous sequentially dropped frames.
	 * 
	 * <p>
	 * Default value is <b>0</b>.
	 * 
	 * @apiNote (int) max
	 * @param value the maximum number of consecutive dropped frames
	 * @return the {@link MpDecimate} instance
	 */
	public MpDecimate max( int value ) {
		return super.addArg( "max", value );
	}

	/**
	 * Set the high dropping threshold value, default value is <b>768</b>.
	 * 
	 * @apiNote (int) high
	 * @param value the high dropping threshold
	 * @return the {@link MpDecimate} instance
	 */
	public MpDecimate high( int value ) {
		return super.addArg( "high", value );
	}

	/**
	 * Set the low dropping threshold value, default value is <b>320</b>.
	 * 
	 * @apiNote (int) lo
	 * @param value the low dropping threshold
	 * @return the {@link MpDecimate} instance
	 */
	public MpDecimate low( int value ) {
		return super.addArg( "lo", value );
	}

	/**
	 * Set the fraction dropping threshold value, default value is <b>320</b>.
	 * 
	 * @apiNote (int) frac
	 * @param value the fraction dropping threshold
	 * @return the {@link MpDecimate} instance
	 */
	public MpDecimate fraction( int value ) {
		return super.addArg( "frac", value );
	}

}
