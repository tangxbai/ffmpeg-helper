package com.viiyue.ffmpeg.filter.video;

import com.viiyue.ffmpeg.annotation.Function;
import com.viiyue.ffmpeg.filter.AbstractColorFunction;
import com.viiyue.ffmpeg.util.Assert;

/**
 * Find a rectangular object
 * 
 * @author tangxbai
 * @since 2022/07/05
 * @see <a href="https://ffmpeg.org/ffmpeg-filters.html#find_005frect">ffmpeg-filters#find_rect</a>
 */
@Function( "find_rect" )
public class FindRect extends AbstractColorFunction<FindRect> {

	// Don't let anyone instantiate this class
	private FindRect() {}

	/**
	 * Quickly create an instances of {@link FindRect}
	 * 
	 * @apiNote (string) object
	 * @param object the object bitmap filename, needs to be in gray8.
	 * @return the {@link FindRect} instance
	 */
	public static final FindRect of( String object ) {
		return new FindRect().addArg( "object", object );
	}

	/**
	 * Change the detection threshold, value range is from 0 to 1, and the default value is <b>0.5</b>.
	 * 
	 * @apiNote (double) threshold
	 * @param threshold the detection threshold
	 * @return {@link FindRect} instance
	 */
	public FindRect threshold( double threshold ) {
		Assert.rangeCheck( threshold, 0.0, 1.0 );
		return super.addArg( "threshold", threshold );
	}

	/**
	 * Set the number of mipmaps, value range is from 1 to 5, and the default value is <b>3</b>.
	 * 
	 * @apiNote (int) threshold
	 * @param threshold the detection threshold
	 * @return {@link FindRect} instance
	 */
	public FindRect mipmaps( int threshold ) {
		Assert.rangeCheck( threshold, 1, 5 );
		return super.addArg( "mipmaps", threshold );
	}

	/**
	 * Specifies the smallest rectangle in which to search, the default is <b>0</b>.
	 * 
	 * @apiNote (int) xmin/ymin
	 * @param x the min search rectangle coordinate of x-axis
	 * @param y the min search rectangle coordinate of y-axis
	 * @return {@link FindRect} instance
	 */
	public FindRect minOf( int x, int y ) {
		return super.addArg( "xmin", x ).addArg( "ymin", y );
	}

	/**
	 * Specifies the largest rectangle in which to search, the default is <b>0</b>.
	 * 
	 * @apiNote (int) xmax/ymax
	 * @param x the max search rectangle coordinate of x-axis
	 * @param y the max search rectangle coordinate of y-axis
	 * @return {@link FindRect} instance
	 */
	public FindRect maxOf( int x, int y ) {
		return super.addArg( "xmax", x ).addArg( "ymax", y );
	}

	/**
	 * Discard frames where object is not detected. Default is {@code false} (disabled).
	 * 
	 * @apiNote (boolean) discard
	 * @return {@link FindRect} instance
	 */
	public FindRect discard() {
		return super.enable( "discard" );
	}

}
