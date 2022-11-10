package com.viiyue.ffmpeg.filter.video;

import com.viiyue.ffmpeg.annotation.Function;
import com.viiyue.ffmpeg.filter.AbstractFunction;
import com.viiyue.ffmpeg.util.Assert;

/**
 * <p>
 * Read closed captioning (EIA-608) information from the top lines of a video frame.
 * 
 * <p>
 * This filter adds frame metadata for lavfi.readeia608.X.cc and lavfi.readeia608.X.line, where X is the
 * number of the identified line with EIA-608 data (starting from 0).
 * 
 * @author tangxbai
 * @since 2022/07/22
 * @see <a href="https://ffmpeg.org/ffmpeg-filters.html#readeia608">ffmpeg-filters#readeia608</a>
 */
@Function( "readeia608" )
public class ReaDeia608 extends AbstractFunction<ReaDeia608> {

	// Don't let anyone instantiate this class
	private ReaDeia608() {}

	/**
	 * Quickly create an instances of {@link ReaDeia608}
	 * 
	 * @return the {@link ReaDeia608} instance
	 */
	public static final ReaDeia608 of() {
		return new ReaDeia608();
	}

	/**
	 * Set the line to start scanning for EIA-608 data. Default is <b>0</b>.
	 * 
	 * @apiNote (int) scan_min
	 * @param value the start scanning line
	 * @return the {@link ReaDeia608} instance
	 */
	public ReaDeia608 scanMin( int value ) {
		return super.addArg( "scan_min", value );
	}

	/**
	 * Set the line to end scanning for EIA-608 data. Default is <b>29</b>.
	 * 
	 * @apiNote (int) scan_max
	 * @param value the start scanning line
	 * @return the {@link ReaDeia608} instance
	 */
	public ReaDeia608 scanMax( int value ) {
		return super.addArg( "scan_max", value );
	}

	/**
	 * Set the ratio of width reserved for sync code detection. Default is <b>0.27</b>. Allowed range is [0.1
	 * - 0.7].
	 * 
	 * @apiNote (double) spw
	 * @param value the ratio of width reserved for sync code detection
	 * @return the {@link ReaDeia608} instance
	 */
	public ReaDeia608 spw( double value ) {
		Assert.rangeCheck( value, 0.1, 0.7 );
		return super.addArg( "spw", value );
	}

	/**
	 * Enable checking the parity bit. In the event of a parity error, the filter will output 0x00 for that
	 * character. Default is {@code false}.
	 * 
	 * @apiNote (boolean) chp
	 * @return the {@link ReaDeia608} instance
	 */
	public ReaDeia608 chp() {
		return super.enable( "chp" );
	}

	/**
	 * Lowpass lines prior to further processing. Default is {@code true} (enabled).
	 * 
	 * @apiNote (boolean) lp
	 * @return the {@link ReaDeia608} instance
	 */
	public ReaDeia608 lp() {
		return super.enable( "lp" );
	}

}
