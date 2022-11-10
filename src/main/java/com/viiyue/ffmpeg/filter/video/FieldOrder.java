package com.viiyue.ffmpeg.filter.video;

import com.viiyue.ffmpeg.annotation.Function;
import com.viiyue.ffmpeg.filter.AbstractColorFunction;

/**
 * Transform the field order of the input video
 * 
 * @author tangxbai
 * @since 2022/07/05
 * @see <a href="https://ffmpeg.org/ffmpeg-filters.html#fieldorder">ffmpeg-filters#fieldorder</a>
 */
@Function( "fieldorder" )
public class FieldOrder extends AbstractColorFunction<FieldOrder> {

	// Don't let anyone instantiate this class
	private FieldOrder() {}

	/**
	 * Quickly create an instances of {@link ExtractPlanes}, and set top field first.
	 * 
	 * @apiNote (flags) order
	 * @return the {@link FieldOrder} instance
	 */
	public static final FieldOrder topFirst() {
		return new FieldOrder().addArg( "order", "tff" );
	}

	/**
	 * Quickly create an instances of {@link ExtractPlanes}, and set bottom field first.
	 * 
	 * @apiNote (flags) order
	 * @return the {@link FieldOrder} instance
	 */
	public static final FieldOrder bottomFirst() {
		return new FieldOrder().addArg( "order", "bff" );
	}

}
