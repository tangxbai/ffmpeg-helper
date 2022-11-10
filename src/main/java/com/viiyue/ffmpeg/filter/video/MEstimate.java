package com.viiyue.ffmpeg.filter.video;

import com.viiyue.ffmpeg.annotation.Function;
import com.viiyue.ffmpeg.enums.EstimationMethod;
import com.viiyue.ffmpeg.filter.AbstractFunction;
import com.viiyue.ffmpeg.util.Assert;

/**
 * Estimate and export motion vectors using block matching algorithms. Motion vectors are stored in frame side
 * data to be used by other filters.
 * 
 * @author tangxbai
 * @since 2022/07/18
 * @see <a href="https://ffmpeg.org/ffmpeg-filters.html#mestimate">ffmpeg-filters#mestimate</a>
 */
@Function( "mestimate" )
public class MEstimate extends AbstractFunction<MEstimate> {

	// Don't let anyone instantiate this class
	private MEstimate() {}

	/**
	 * Quickly create an instances of {@link MEstimate}
	 * 
	 * @return the {@link MEstimate} instance
	 */
	public static final MEstimate of() {
		return new MEstimate();
	}

	/**
	 * Specify the motion estimation method
	 * 
	 * @apiNote (flags) method
	 * @param method the motion estimation method
	 * @return the {@link MEstimate} instance
	 * @see EstimationMethod
	 */
	public MEstimate method( EstimationMethod method ) {
		return super.addArg( "method", method );
	}

	/**
	 * Set macroblock size. Value must be greater than or equal to 8, default is <b>16</b>.
	 * 
	 * @apiNote (int) mb_size
	 * @param value the macroblock size
	 * @return the {@link MEstimate} instance
	 */
	public MEstimate mbSize( int value ) {
		Assert.isTrue( value >= 8, "Value must be greater than or equal to 8" );
		return super.addArg( "mb_size", value );
	}

	/**
	 * Set search parameter. Value must be greater than or equal to 4, default is <b>7</b>.
	 * 
	 * @apiNote (int) search_param
	 * @param value the search parameter
	 * @return the {@link MEstimate} instance
	 */
	public MEstimate searchParam( int value ) {
		Assert.isTrue( value >= 8, "Value must be greater than or equal to 4" );
		return super.addArg( "search_param", value );
	}

}
