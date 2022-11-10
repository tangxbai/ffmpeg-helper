package com.viiyue.ffmpeg.filter.video;

import com.viiyue.ffmpeg.annotation.Function;
import com.viiyue.ffmpeg.filter.AbstractFunction;
import com.viiyue.ffmpeg.util.Assert;

/**
 * Amplify differences between current pixel and pixels of adjacent frames in same pixel location.
 * 
 * @author tangxbai
 * @since 2022/06/08
 * @see <a href="https://ffmpeg.org/ffmpeg-filters.html#amplify">ffmpeg-filters#amplify</a>
 */
@Function( "amplify" )
public class Amplify extends AbstractFunction<Amplify> {

	// Don't let anyone instantiate this class
	private Amplify() {}

	/**
	 * Quickly create an instances of {@link Amplify}
	 * 
	 * @apiNote (int) radius
	 * @param radius the frame radius
	 * @return the {@link Amplify} instance
	 * @see Amplify#initRadius(int)
	 */
	public static final Amplify radius( int radius ) {
		return new Amplify().initRadius( radius );
	}

	/**
	 * <p>
	 * Set frame radius, the default is <b>2</b> and allowed range is from 1 to 63.
	 * 
	 * <p>
	 * For example radius of 3 will instruct filter to calculate average of 7 frames.
	 * 
	 * @apiNote (int) radius
	 * @param radius the radius value, range is 1 to 63.
	 * @return the {@link Amplify} instance
	 */
	private Amplify initRadius( int radius ) {
		Assert.rangeCheck( radius, 1, 63 );
		return super.addArg( "radius", radius );
	}

	/**
	 * Set factor to amplify difference, default is <b>2</b>.
	 * 
	 * @apiNote (int) factor
	 * @param factor the factor value, range is 0 to 65535
	 * @return the {@link Amplify} instance
	 */
	public Amplify factor( int factor ) {
		Assert.rangeCheck( factor, 0, 65535 );
		return super.addArg( "factor", factor );
	}

	/**
	 * <p>
	 * Set threshold for difference amplification.
	 * 
	 * <p>
	 * Any difference greater or equal to this value will not alter source pixel, default is <b>10</b> and
	 * allowed range is from 0 to 65535.
	 * 
	 * @apiNote (int) threshold
	 * @param threshold the value range is from 0 to 65535
	 * @return the {@link Amplify} instance
	 */
	public Amplify threshold( int threshold ) {
		Assert.rangeCheck( threshold, 0, 65535 );
		return super.addArg( "threshold", threshold );
	}

	/**
	 * <p>
	 * Set tolerance for difference amplification.
	 * 
	 * <p>
	 * Any difference lower to this value will not alter source pixel, default is <b>0</b> and allowed range
	 * is from 0 to 65535.
	 * 
	 * @apiNote (int) tolerance
	 * @param tolerance the value range is from 0 to 65535
	 * @return the {@link Amplify} instance
	 */
	public Amplify tolerance( int tolerance ) {
		Assert.rangeCheck( tolerance, 0, 65535 );
		return super.addArg( "tolerance", tolerance );
	}

	/**
	 * <p>
	 * Set lower limit for changing source pixel, default is <b>65535</b>.
	 * 
	 * <p>
	 * Allowed range is from 0 to 65535. this option controls maximum possible value that will decrease source
	 * pixel value.
	 * 
	 * @apiNote (int) low
	 * @param low the lower limit value, range is from 0 to 65535.
	 * @return the {@link Amplify} instance
	 */
	public Amplify low( int low ) {
		Assert.rangeCheck( low, 0, 65535 );
		return super.addArg( "low", low );
	}

	/**
	 * <p>
	 * Set high limit for changing source pixel, default is <b>65535</b>.
	 * 
	 * <p>
	 * Allowed range is from 0 to 65535, this option controls maximum possible value that will increase source
	 * pixel value.
	 * 
	 * @apiNote (int) high
	 * @param high the value range is from 0 to 65535
	 * @return the {@link Amplify} instance
	 */
	public Amplify high( int high ) {
		Assert.rangeCheck( high, 0, 65535 );
		return super.addArg( "high", high );
	}

	/**
	 * Set which planes to filter, default is <b>7</b>.
	 * 
	 * @apiNote (int) planes
	 * @param planes the what planes to filter, range is from 0 to 15.
	 * @return the {@link Amplify} instance
	 */
	public Amplify planes( int planes ) {
		Assert.rangeCheck( planes, 0, 15 );
		return super.addArg( "planes", planes );
	}

}
