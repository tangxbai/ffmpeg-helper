package com.viiyue.ffmpeg.filter.video;

import com.viiyue.ffmpeg.annotation.Function;
import com.viiyue.ffmpeg.filter.AbstractFunction;
import com.viiyue.ffmpeg.util.Assert;

/**
 * Apply deflate effect to the video
 * 
 * @author tangxbai
 * @since 2022/06/27
 * @see <a href="https://ffmpeg.org/ffmpeg-filters.html#template">ffmpeg-filters#deflate</a>
 */
@Function( "deflate" )
public class Deflate extends AbstractFunction<Deflate> {

	// Don't let anyone instantiate this class
	private Deflate() {}

	/**
	 * Quickly create an instances of {@link Deflate}
	 * 
	 * @return the {@link Deflate} instance
	 */
	public static final Deflate of() {
		return new Deflate();
	}

	/**
	 * Limit the maximum change for 1st plane, default is <b>65535</b>. If 0, plane will remain unchanged.
	 * 
	 * @apiNote (double) threshold0
	 * @param threshold the plane threshold
	 * @return the {@link Deflate} instance
	 */
	public Deflate threshold0( double threshold ) {
		Assert.rangeCheck( threshold, 0, 65535 );
		return super.addArg( "threshold0", threshold );
	}

	/**
	 * Limit the maximum change for 2nd plane, default is <b>65535</b>. If 0, plane will remain unchanged.
	 * 
	 * @apiNote (double) threshold1
	 * @param threshold the plane threshold
	 * @return the {@link Deflate} instance
	 */
	public Deflate threshold1( double threshold ) {
		Assert.rangeCheck( threshold, 0, 65535 );
		return super.addArg( "threshold1", threshold );
	}

	/**
	 * Limit the maximum change for 3rd plane, default is <b>65535</b>. If 0, plane will remain unchanged.
	 * 
	 * @apiNote (double) threshold2
	 * @param threshold the plane threshold
	 * @return the {@link Deflate} instance
	 */
	public Deflate threshold2( double threshold ) {
		Assert.rangeCheck( threshold, 0, 65535 );
		return super.addArg( "threshold2", threshold );
	}

	/**
	 * Limit the maximum change for 4th plane, default is <b>65535</b>. If 0, plane will remain unchanged.
	 * 
	 * @apiNote (double) threshold3
	 * @param threshold the plane threshold
	 * @return the {@link Deflate} instance
	 */
	public Deflate threshold3( double threshold ) {
		Assert.rangeCheck( threshold, 0, 65535 );
		return super.addArg( "threshold3", threshold );
	}

}
