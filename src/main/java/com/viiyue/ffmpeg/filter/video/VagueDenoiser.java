package com.viiyue.ffmpeg.filter.video;

import com.viiyue.ffmpeg.annotation.Function;
import com.viiyue.ffmpeg.common.AbstractEnum;
import com.viiyue.ffmpeg.filter.AbstractFunction;
import com.viiyue.ffmpeg.util.Assert;

/**
 * <p>
 * Apply a wavelet based denoiser.
 * 
 * <p>
 * It transforms each frame from the video input into the wavelet domain, using Cohen-Daubechies-Feauveau 9/7.
 * Then it applies some filtering to the obtained coefficients. It does an inverse wavelet transform after.
 * Due to wavelet properties, it should give a nice smoothed result, and reduced noise, without blurring
 * picture features.
 * 
 * @author tangxbai
 * @since 2022/10/11
 * @see <a href="https://ffmpeg.org/ffmpeg-filters.html#vaguedenoiser">ffmpeg-filters#vaguedenoiser</a>
 */
@Function( "vaguedenoiser" )
public class VagueDenoiser extends AbstractFunction<VagueDenoiser> {

	// Don't let anyone instantiate this class
	private VagueDenoiser() {}

	/**
	 * Quickly create an instances of {@link VagueDenoiser}
	 * 
	 * @return the {@link VagueDenoiser} instance
	 */
	public static final VagueDenoiser of() {
		return new VagueDenoiser();
	}

	/**
	 * The filtering strength. The higher, the more filtered the video will be. Hard thresholding can use a
	 * higher threshold than soft thresholding before the video looks overfiltered, default is <b>2</b>.
	 * 
	 * @apiNote (double) threshold
	 * @param value the filtering strength
	 * @return the {@link VagueDenoiser} instance
	 */
	public VagueDenoiser threshold( double value ) {
		return super.addArg( "threshold", value );
	}

	/**
	 * The filtering method the filter will use, default method is {@link FilterMethod#GARROTE}.
	 * 
	 * @apiNote (flags) method
	 * @param method the filtering method
	 * @return the {@link VagueDenoiser} instance
	 * @see FilterMethod
	 */
	public VagueDenoiser method( FilterMethod method ) {
		return super.addArg( "method", method );
	}

	/**
	 * Number of times, the wavelet will decompose the picture. Picture can’t be decomposed beyond a
	 * particular point (typically, 8 for a 640x480 frame - as 2^9 = 512 > 480). Valid values are integers
	 * between 1 and 32, default is <b>2</b>.
	 * 
	 * @apiNote (int) nsteps
	 * @param value the number of steps
	 * @return the {@link VagueDenoiser} instance
	 */
	public VagueDenoiser nsteps( int value ) {
		Assert.rangeCheck( value, 1, 32 );
		return super.addArg( "nsteps", value );
	}

	/**
	 * Partial of full denoising (limited coefficients shrinking), from 0 to 100, default is <b>85</b>.
	 * 
	 * @apiNote (double) nsteps
	 * @param value the number of steps
	 * @return the {@link VagueDenoiser} instance
	 */
	public VagueDenoiser percent( double value ) {
		Assert.rangeCheck( value, 0, 100 );
		return super.addArg( "percent", value );
	}

	/**
	 * Set which planes to filter, default is <b>15</b>.
	 * 
	 * @apiNote (int) planes
	 * @param value the what planes to filter
	 * @return the {@link VagueDenoiser} instance
	 */
	public VagueDenoiser planes( int value ) {
		Assert.rangeCheck( value, 0, 15 );
		return super.addArg( "planes", value );
	}

	/**
	 * The threshold type the filter will use, default is {@link ThresholdType#UNIVERSAL}.
	 * 
	 * @apiNote (flags) type
	 * @param value the threshold type
	 * @return the {@link VagueDenoiser} instance
	 * @see ThresholdType
	 */
	public VagueDenoiser type( ThresholdType type ) {
		return super.addArg( "type", type );
	}

	/**
	 * Thresholding mode
	 *
	 * @author tangxbai
	 * @since 2022/10/11
	 */
	public enum FilterMethod implements AbstractEnum {
		/**
		 * All values under the threshold will be zeroed
		 */
		HARD,
		/**
		 * All values under the threshold will be zeroed. All values above will be reduced by the threshold.
		 */
		SOFT,
		/**
		 * Scales or nullifies coefficients - intermediary between (more) soft and (less) hard thresholding
		 */
		GARROTE
	}

	/**
	 * Threshold type
	 *
	 * @author tangxbai
	 * @since 2022/10/11
	 */
	public enum ThresholdType implements AbstractEnum {
		/** Threshold used is same for all decompositions */
		UNIVERSAL,
		/** Threshold used depends also on each decomposition coefficients */
		BAYES
	}

}
