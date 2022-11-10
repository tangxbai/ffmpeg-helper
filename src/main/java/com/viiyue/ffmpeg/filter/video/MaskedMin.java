package com.viiyue.ffmpeg.filter.video;

import com.viiyue.ffmpeg.annotation.Function;
import com.viiyue.ffmpeg.filter.AbstractFunction;
import com.viiyue.ffmpeg.util.Assert;

/**
 * Merge the second and third input stream into output stream using absolute differences between second input
 * stream and first input stream and absolute difference between third input stream and first input stream.
 * The picked value will be from second input stream if second absolute difference is less than first one or
 * from third input stream otherwise.
 * 
 * @author tangxbai
 * @since 2022/07/13
 * @see <a href="https://ffmpeg.org/ffmpeg-filters.html#maskedmin">ffmpeg-filters#maskedmin</a>
 */
@Function( "maskedmin" )
public class MaskedMin extends AbstractFunction<MaskedMin> {

	// Don't let anyone instantiate this class
	private MaskedMin() {}

	/**
	 * Quickly create an instances of {@link MaskedMin}
	 * 
	 * @return the {@link MaskedMin} instance
	 */
	public static final MaskedMin of() {
		return new MaskedMin();
	}

	/**
	 * Set which planes will be processed as bitmap, unprocessed planes will be copied from first stream.
	 * Value range allowed is from 0 to 15, default value is <b>15</b>, all planes will be processed.
	 * 
	 * @apiNote (int) planes
	 * @param value the plane filter
	 * @return the {@link MaskedMin} instance
	 */
	public MaskedMin planes( int value ) {
		Assert.rangeCheck( value, 0, 15 );
		return super.addArg( "planes", value );
	}

}
