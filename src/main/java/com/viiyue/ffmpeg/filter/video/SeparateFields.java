package com.viiyue.ffmpeg.filter.video;

import com.viiyue.ffmpeg.annotation.Function;
import com.viiyue.ffmpeg.filter.AbstractFunction;

/**
 * <p>
 * The {@code separatefields} takes a frame-based video input and splits each frame into its components
 * fields, producing a new half height clip with twice the frame rate and twice the frame count.
 * 
 * <p>
 * This filter use field-dominance information in frame to decide which of each pair of fields to place first
 * in the output. If it gets it wrong use setfield filter before {@code separatefields} filter.
 * 
 * @author tangxbai
 * @since 2022/08/03
 * @see <a href="https://ffmpeg.org/ffmpeg-filters.html#separatefields-1">ffmpeg-filters#separatefields</a>
 */
@Function( "separatefields" )
public class SeparateFields extends AbstractFunction<SeparateFields> {

	// Don't let anyone instantiate this class
	private SeparateFields() {}

}
