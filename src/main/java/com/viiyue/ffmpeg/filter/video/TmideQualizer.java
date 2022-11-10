package com.viiyue.ffmpeg.filter.video;

import com.viiyue.ffmpeg.annotation.Function;
import com.viiyue.ffmpeg.filter.AbstractFunction;
import com.viiyue.ffmpeg.util.Assert;

/**
 * <p>
 * Apply Temporal Midway Video Equalization effect.
 * 
 * <p>
 * Midway Video Equalization adjusts a sequence of video frames to have the same histograms, while maintaining
 * their dynamics as much as possible. It’s useful for e.g. matching exposures from a video frames sequence.
 * 
 * @author tangxbai
 * @since 2022/09/28
 * @see <a href="https://ffmpeg.org/ffmpeg-filters.html#tmidequalizer">ffmpeg-filters#tmidequalizer</a>
 */
@Function( "tmidequalizer" )
public class TmideQualizer extends AbstractFunction<TmideQualizer> {

	// Don't let anyone instantiate this class
	private TmideQualizer() {}

	/**
	 * Quickly create an instances of {@link TmideQualizer}
	 * 
	 * @apiNote (int) radius
	 * @param radius the frame radius
	 * @return the {@link TmideQualizer} instance
	 * @see TmideQualizer#initRadius(int)
	 */
	public static final TmideQualizer radius( int radius ) {
		return new TmideQualizer().initRadius( radius );
	}

	/**
	 * Set frame radius, the default is <b>5</b> and allowed range is from 1 to 127.
	 * 
	 * @apiNote (int) radius
	 * @param radius the radius value
	 * @return the {@link TmideQualizer} instance
	 */
	private TmideQualizer initRadius( int radius ) {
		Assert.rangeCheck( radius, 1, 127 );
		return super.addArg( "radius", radius );
	}

	/**
	 * Set which planes to filter, default is <b>15</b>.
	 * 
	 * @apiNote (int) planes
	 * @param planes the what planes to filter
	 * @return the {@link TmideQualizer} instance
	 */
	public TmideQualizer planes( int planes ) {
		Assert.rangeCheck( planes, 0, 15 );
		return super.addArg( "planes", planes );
	}

	/**
	 * Set the sigma value, default is <b>0.5</b>.
	 * 
	 * @apiNote (double) sigma
	 * @param value the sigma value
	 * @return the {@link TmideQualizer} instance
	 */
	public TmideQualizer sigma( double value ) {
		Assert.rangeCheck( value, 0.0, 1.0 );
		return super.addArg( "sigma", value );
	}

}
