package com.viiyue.ffmpeg.filter.video;

import com.viiyue.ffmpeg.annotation.Function;
import com.viiyue.ffmpeg.filter.AbstractFunction;
import com.viiyue.ffmpeg.util.Assert;

/**
 * <p>
 * Pick pixels comparing absolute difference of two video streams with fixed threshold.
 * 
 * <p>
 * If absolute difference between pixel component of first and second video stream is equal or lower than user
 * supplied threshold than pixel component from first video stream is picked, otherwise pixel component from
 * second video stream is picked.
 * 
 * @author tangxbai
 * @since 2022/07/13
 * @see <a href="https://ffmpeg.org/ffmpeg-filters.html#maskedmin">ffmpeg-filters#maskedmin</a>
 */
@Function( "maskedmin" )
public class MaskedThreshold extends AbstractFunction<MaskedThreshold> {

	// Don't let anyone instantiate this class
	private MaskedThreshold() {}

	/**
	 * Quickly create an instances of {@link MaskedThreshold}
	 * 
	 * @return the {@link MaskedThreshold} instance
	 */
	public static final MaskedThreshold of() {
		return new MaskedThreshold();
	}

	/**
	 * Set which planes will be processed as bitmap, unprocessed planes will be copied from second stream.
	 * Value range allowed is from 0 to 15, default value is <b>15</b>, all planes will be processed.
	 * 
	 * @apiNote (int) planes
	 * @param value the plane filter
	 * @return the {@link MaskedThreshold} instance
	 */
	public MaskedThreshold planes( int value ) {
		Assert.rangeCheck( value, 0, 15 );
		return super.addArg( "planes", value );
	}

	/**
	 * Set threshold used when picking pixels from absolute difference from two input video streams. Value
	 * range allowed is from 0 to 65535, default value is <b>1</b>.
	 * 
	 * @apiNote (double) threshold
	 * @param value the threshold value
	 * @return the {@link MaskedThreshold} instance
	 */
	public MaskedThreshold threshold( int value ) {
		Assert.rangeCheck( value, 0, 65535 );
		return super.addArg( "threshold", value );
	}

}
