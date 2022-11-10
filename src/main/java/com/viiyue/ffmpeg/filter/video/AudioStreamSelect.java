package com.viiyue.ffmpeg.filter.video;

import com.viiyue.ffmpeg.annotation.Function;
import com.viiyue.ffmpeg.filter.AbstractFunction;
import com.viiyue.ffmpeg.util.Assert;

/**
 * Select audio streams
 * 
 * @author tangxbai
 * @since 2022/08/05
 * @see <a href=
 *      "https://ffmpeg.org/ffmpeg-filters.html#streamselect_002c-astreamselect">ffmpeg-filters#astreamselect</a>
 */
@Function( "astreamselect" )
public class AudioStreamSelect extends AbstractFunction<AudioStreamSelect> {

	// Don't let anyone instantiate this class
	private AudioStreamSelect() {}

	/**
	 * Quickly create an instances of {@link AudioStreamSelect}
	 * 
	 * @return the {@link AudioStreamSelect} instance
	 */
	public static final AudioStreamSelect of() {
		return new AudioStreamSelect();
	}

	/**
	 * Set number of inputs
	 * 
	 * @apiNote (int) in
	 * @param value the inputs number
	 * @return the {@link AudioStreamSelect} instance
	 */
	public AudioStreamSelect inputs( int value ) {
		Assert.isTrue( value >= 2, "Input number must greater than or equal to 2" );
		return super.addArg( "inputs", value );
	}

	/**
	 * Set input indexes to remap to outputs
	 * 
	 * @apiNote (string) map
	 * @param indexs the input indexes
	 * @return the {@link AudioStreamSelect} instance
	 */
	public AudioStreamSelect map( String indexs ) {
		return super.addArg( "map", indexs );
	}

}
