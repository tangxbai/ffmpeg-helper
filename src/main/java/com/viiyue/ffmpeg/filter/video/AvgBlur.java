package com.viiyue.ffmpeg.filter.video;

import com.viiyue.ffmpeg.annotation.Function;
import com.viiyue.ffmpeg.filter.AbstractFunction;
import com.viiyue.ffmpeg.util.Assert;

/**
 * Apply average blur filter
 *
 * @author tangxbai
 * @since 2022/06/02
 * @see <a href="https://ffmpeg.org/ffmpeg-filters.html#avgblur">ffmpeg-filters#avgblur</a>
 */
@Function( "avgblur" )
public class AvgBlur extends AbstractFunction<AvgBlur> {

	// Don't let anyone instantiate this class
	private AvgBlur() {}

	/**
	 * Quickly create an instances of {@link AvgBlur}
	 * 
	 * @return the {@link AvgBlur} instance
	 */
	public static final AvgBlur the() {
		return new AvgBlur();
	}

	/**
	 * Set radius size
	 * 
	 * @apiNote (int) sizeX, (int) sizeY
	 * @param radius the horizontal and vertical radius size
	 * @return the {@link AvgBlur} instance
	 */
	public AvgBlur size( int radius ) {
		return size( radius, radius );
	}

	/**
	 * Set radius size
	 * 
	 * @param radiusX the horizontal radius size
	 * @param radiusY the vertical radius size
	 * @return the {@link AvgBlur} instance
	 */
	public AvgBlur size( int radiusX, int radiusY ) {
		Assert.rangeCheck( radiusX, 1, 1024 );
		Assert.rangeCheck( radiusY, 0, 1024 );
		return super.addArg( "sizeX", radiusX ).addArg( "sizeY", radiusY );
	}

	/**
	 * Set which planes to filter. By default all planes are filtered, default is <b>15</b>.
	 * 
	 * @apiNote (int) planes
	 * @param planes the planes value
	 * @return the {@link AvgBlur} instance
	 */
	public AvgBlur planes( int planes ) {
		Assert.rangeCheck( planes, 0, 15 );
		return super.addArg( "planes", planes );
	}

}
