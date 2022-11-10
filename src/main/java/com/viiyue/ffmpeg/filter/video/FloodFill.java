package com.viiyue.ffmpeg.filter.video;

import com.viiyue.ffmpeg.annotation.Function;
import com.viiyue.ffmpeg.filter.AbstractColorFunction;
import com.viiyue.ffmpeg.util.Assert;

/**
 * Flood area with values of same pixel components with another values
 * 
 * @author tangxbai
 * @since 2022/07/06
 * @see <a href="https://ffmpeg.org/ffmpeg-filters.html#floodfill">ffmpeg-filters#floodfill</a>
 */
@Function( "floodfill" )
public class FloodFill extends AbstractColorFunction<FloodFill> {

	// Don't let anyone instantiate this class
	private FloodFill() {}

	/**
	 * Quickly create an instances of {@link FloodFill}
	 * 
	 * @return the {@link FloodFill} instance
	 */
	public static final FloodFill of() {
		return new FloodFill();
	}

	/**
	 * Set pixel x coordinate, value range is from 0 to 65535, and the default value is <b>0</b>.
	 * 
	 * @apiNote (int) x
	 * @param value the pixel x coordinate
	 * @return {@link FloodFill} instance
	 */
	public FloodFill x( int value ) {
		Assert.rangeCheck( value, 0, 65535 );
		return super.addArg( "x", value );
	}

	/**
	 * Set pixel y coordinate, value range is from 0 to 65535, and the default value is <b>0</b>.
	 * 
	 * @apiNote (int) y
	 * @param value the pixel y coordinate
	 * @return {@link FloodFill} instance
	 */
	public FloodFill y( int value ) {
		Assert.rangeCheck( value, 0, 65535 );
		return super.addArg( "y", value );
	}

	/**
	 * Set source #0 component value, value range is from -1 to 65535, and the default value is <b>0</b>.
	 * 
	 * @apiNote (int) s0
	 * @param value the source #0 component value
	 * @return {@link FloodFill} instance
	 */
	public FloodFill source0( int value ) {
		Assert.rangeCheck( value, -1, 65535 );
		return super.addArg( "s0", value );
	}

	/**
	 * Set source #1 component value, value range is from -1 to 65535, and the default value is <b>0</b>.
	 * 
	 * @apiNote (int) s1
	 * @param value the source #1 component value
	 * @return {@link FloodFill} instance
	 */
	public FloodFill source1( int value ) {
		Assert.rangeCheck( value, -1, 65535 );
		return super.addArg( "s1", value );
	}

	/**
	 * Set source #2 component value, value range is from -1 to 65535, and the default value is <b>0</b>.
	 * 
	 * @apiNote (int) s2
	 * @param value the source #2 component value
	 * @return {@link FloodFill} instance
	 */
	public FloodFill source2( int value ) {
		Assert.rangeCheck( value, -1, 65535 );
		return super.addArg( "s2", value );
	}

	/**
	 * Set source #3 component value, value range is from -1 to 65535, and the default value is <b>0</b>.
	 * 
	 * @apiNote (int) s3
	 * @param value the source #3 component value
	 * @return {@link FloodFill} instance
	 */
	public FloodFill source3( int value ) {
		Assert.rangeCheck( value, -1, 65535 );
		return super.addArg( "s3", value );
	}

	/**
	 * Set destination #0 component value, value range is from 0 to 65535, and the default value is <b>0</b>.
	 * 
	 * @apiNote (int) d0
	 * @param value the destination #0 component value
	 * @return {@link FloodFill} instance
	 */
	public FloodFill dest0( int value ) {
		Assert.rangeCheck( value, 0, 65535 );
		return super.addArg( "d0", value );
	}

	/**
	 * Set destination #1 component value, value range is from 0 to 65535, and the default value is <b>0</b>.
	 * 
	 * @apiNote (int) s1
	 * @param value the destination #1 component value
	 * @return {@link FloodFill} instance
	 */
	public FloodFill dest1( int value ) {
		Assert.rangeCheck( value, 0, 65535 );
		return super.addArg( "d1", value );
	}

	/**
	 * Set destination #2 component value, value range is from 0 to 65535, and the default value is <b>0</b>.
	 * 
	 * @apiNote (int) s2
	 * @param value the destination #2 component value
	 * @return {@link FloodFill} instance
	 */
	public FloodFill dest2( int value ) {
		Assert.rangeCheck( value, 0, 65535 );
		return super.addArg( "d2", value );
	}

	/**
	 * Set destination #3 component value, value range is from 0 to 65535, and the default value is <b>0</b>.
	 * 
	 * @apiNote (int) d3
	 * @param value the destination #3 component value
	 * @return {@link FloodFill} instance
	 */
	public FloodFill dest3( int value ) {
		Assert.rangeCheck( value, 0, 65535 );
		return super.addArg( "d3", value );
	}

}
