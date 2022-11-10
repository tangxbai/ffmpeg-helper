package com.viiyue.ffmpeg.filter.video;

import com.viiyue.ffmpeg.annotation.Function;
import com.viiyue.ffmpeg.filter.AbstractFunction;
import com.viiyue.ffmpeg.util.Assert;

/**
 * Convert between different stereoscopic image formats
 * 
 * @author tangxbai
 * @since 2022/08/05
 * @see <a href=
 *      "https://ffmpeg.org/ffmpeg-filters.html#streamselect_002c-astreamselect">ffmpeg-filters#streamselect</a>
 */
@Function( "streamselect" )
public class StreamSelect extends AbstractFunction<StreamSelect> {

	// Don't let anyone instantiate this class
	private StreamSelect() {}

	/**
	 * Quickly create an instances of {@link StreamSelect}
	 * 
	 * @return the {@link StreamSelect} instance
	 */
	public static final StreamSelect of() {
		return new StreamSelect();
	}

	/**
	 * Set number of inputs
	 * 
	 * @apiNote (int) in
	 * @param value the inputs number
	 * @return the {@link StreamSelect} instance
	 */
	public StreamSelect inputs( int value ) {
		Assert.isTrue( value >= 2, "Input number must greater than or equal to 2" );
		return super.addArg( "inputs", value );
	}

	/**
	 * Set input indexes to remap to outputs
	 * 
	 * @apiNote (string) map
	 * @param indexs the input indexes
	 * @return the {@link StreamSelect} instance
	 */
	public StreamSelect map( String indexs ) {
		return super.addArg( "map", indexs );
	}

}
