package com.viiyue.ffmpeg.filter.video;

import com.viiyue.ffmpeg.annotation.Function;
import com.viiyue.ffmpeg.filter.AbstractFunction;
import com.viiyue.ffmpeg.util.Assert;

/**
 * Pick median pixels from several successive input video frames.
 * 
 * @author tangxbai
 * @since 2022/09/26
 * @see <a href="https://ffmpeg.org/ffmpeg-filters.html#tmedian">ffmpeg-filters#tmedian</a>
 */
@Function( "tmedian" )
public class Tmedian extends AbstractFunction<Tmedian> {

	// Don't let anyone instantiate this class
	private Tmedian() {}

	/**
	 * Quickly create an instances of {@link Tmedian}
	 * 
	 * @apiNote (int) radius
	 * @param radius the frame radius
	 * @return the {@link Tmedian} instance
	 * @see Tmedian#initRadius(int)
	 */
	public static final Tmedian radius( int radius ) {
		return new Tmedian().initRadius( radius );
	}

	/**
	 * Set frame radius, the default is <b>1</b> and allowed range is from 1 to 127.
	 * 
	 * @apiNote (int) radius
	 * @param radius the radius value
	 * @return the {@link Tmedian} instance
	 */
	private Tmedian initRadius( int radius ) {
		Assert.rangeCheck( radius, 1, 127 );
		return super.addArg( "radius", radius );
	}

	/**
	 * Set which planes to filter, default is <b>15</b>.
	 * 
	 * @apiNote (int) planes
	 * @param planes the what planes to filter
	 * @return the {@link Tmedian} instance
	 */
	public Tmedian planes( int planes ) {
		Assert.rangeCheck( planes, 0, 15 );
		return super.addArg( "planes", planes );
	}

	/**
	 * Set the percentile, default is <b>0.5</b>.
	 * 
	 * @apiNote (double) percentile
	 * @param value the percentile value
	 * @return the {@link Tmedian} instance
	 */
	public Tmedian percentile( double value ) {
		Assert.rangeCheck( value, 0.0, 1.0 );
		return super.addArg( "percentile", value );
	}

}
