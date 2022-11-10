package com.viiyue.ffmpeg.filter.video;

import com.viiyue.ffmpeg.annotation.Function;
import com.viiyue.ffmpeg.enums.FirstField;
import com.viiyue.ffmpeg.filter.AbstractFunction;

/**
 * The {@code doubleweave} works same as {@code weave} but without halving frame rate and frame count.
 * 
 * @author tangxbai
 * @since 2022/10/18
 * @see <a href= "https://ffmpeg.org/ffmpeg-filters.html#weave_002c-doubleweave">ffmpeg-filters#waveform</a>
 * @see Weave
 */
@Function( "weave" )
public class DoubleWeave extends AbstractFunction<DoubleWeave> {

	// Don't let anyone instantiate this class
	private DoubleWeave() {}

	/**
	 * Quickly create an instances of {@link DoubleWeave}
	 * 
	 * @return the {@link DoubleWeave} instance
	 */
	public static final DoubleWeave of() {
		return new DoubleWeave();
	}

	/**
	 * Quickly create an instances of {@link DoubleWeave}
	 * 
	 * @apiNote (flags) first_field
	 * @param field the first field
	 * @return the {@link DoubleWeave} instance
	 * @see FirstField
	 */
	public static final DoubleWeave of( FirstField field ) {
		return new DoubleWeave().addValue( field );
	}

}
