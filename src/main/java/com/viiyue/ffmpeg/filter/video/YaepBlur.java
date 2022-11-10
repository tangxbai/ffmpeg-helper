package com.viiyue.ffmpeg.filter.video;

import com.viiyue.ffmpeg.annotation.Function;
import com.viiyue.ffmpeg.filter.AbstractFunction;
import com.viiyue.ffmpeg.util.Assert;

/**
 * Apply blur filter while preserving edges ("yaepblur" means "yet another edge preserving blur filter"). The
 * algorithm is described in "J. S. Lee, Digital image enhancement and noise filtering by use of local
 * statistics, IEEE Trans. Pattern Anal. Mach. Intell. PAMI-2, 1980."
 *
 * @author tangxbai
 * @since 2022/10/21
 * @see <a href="https://ffmpeg.org/ffmpeg-filters.html#yaepblur">ffmpeg-filters#yaepblur</a>
 */
@Function( "yaepblur" )
public class YaepBlur extends AbstractFunction<YaepBlur> {

	// Don't let anyone instantiate this class
	private YaepBlur() {}

	/**
	 * Quickly create an instances of {@link YaepBlur}
	 * 
	 * @return the {@link YaepBlur} instance
	 */
	public static final YaepBlur of() {
		return new YaepBlur();
	}

	/**
	 * Set the window radius, default is <b>3</b>.
	 * 
	 * @apiNote (double) radius, r
	 * @param value the radius value
	 * @return the {@link YaepBlur} instance
	 */
	public YaepBlur radius( double value ) {
		Assert.rangeCheck( value, 0, 999.9 );
		return super.addArg( "r", value ); // radius, r
	}

	/**
	 * Set which planes to filter. Value ranges is in [0, 15], default is <b>1</b>.
	 * 
	 * @apiNote (double) planes
	 * @param value the planes to filter
	 * @return the {@link YaepBlur} instance
	 */
	public YaepBlur planes( int value ) {
		Assert.rangeCheck( value, 0, 15 );
		return super.addArg( "p", value ); // planes, p
	}

	/**
	 * Set blur strength, default is <b>128</b>.
	 * 
	 * @apiNote (double) sigma
	 * @param value the blur strength
	 * @return the {@link YaepBlur} instance
	 */
	public YaepBlur sigma( double value ) {
		Assert.rangeCheck( value, 0, 999.9 );
		return super.addArg( "s", value ); // sigma, s
	}

}
