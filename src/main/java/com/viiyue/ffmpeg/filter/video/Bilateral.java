package com.viiyue.ffmpeg.filter.video;

import com.viiyue.ffmpeg.annotation.Function;
import com.viiyue.ffmpeg.filter.AbstractFunction;
import com.viiyue.ffmpeg.util.Assert;

/**
 * Apply bilateral filter, spatial smoothing while preserving edges.
 *
 * @author tangxbai
 * @since 2022/06/02
 * @see <a href="https://ffmpeg.org/ffmpeg-filters.html#bilateral">ffmpeg-filters#bilateral</a>
 */
@Function( "bilateral" )
public class Bilateral extends AbstractFunction<Bilateral> {

	// Don't let anyone instantiate this class
	private Bilateral() {}

	/**
	 * Quickly create an instances of {@link Bilateral}
	 * 
	 * @return the {@link Bilateral} instance
	 */
	public static final Bilateral the() {
		return new Bilateral();
	}

	/**
	 * Set sigma of gaussian function to calculate spatial weight. Allowed range is 0 to 512. Default is
	 * <b>0.1</b>.
	 * 
	 * @apiNote (double) sigmaS
	 * @param value the sigma value, value range is is 0 to 512.
	 * @return the {@link Bilateral} instance
	 */
	public Bilateral sigmaS( double value ) {
		Assert.rangeCheck( value, 0, 512 );
		return super.addArg( "sigmaS", value );
	}

	/**
	 * Set sigma of gaussian function to calculate range weight. Allowed range is 0 to 1, default is
	 * <b>0.1</b>.
	 * 
	 * @apiNote (double) sigmaR
	 * @param value the sigma value, value range is 0 to 1.
	 * @return the {@link Bilateral} instance
	 */
	public Bilateral sigmaR( double value ) {
		Assert.rangeCheck( value, 0, 1 );
		return super.addArg( "sigmaR", value );
	}

	/**
	 * Set planes to filter, default is first only of <b>1</b>.
	 * 
	 * @apiNote (int) planes
	 * @param planes the planes index, value range is from 0 to 15.
	 * @return the {@link Bilateral} instance
	 */
	public Bilateral planes( int planes ) {
		Assert.rangeCheck( planes, 0, 15 );
		return super.addArg( "planes", planes );
	}

}
