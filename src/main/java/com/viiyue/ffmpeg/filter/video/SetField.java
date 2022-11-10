package com.viiyue.ffmpeg.filter.video;

import com.viiyue.ffmpeg.annotation.Function;
import com.viiyue.ffmpeg.enums.FieldMode;
import com.viiyue.ffmpeg.filter.AbstractFunction;

/**
 * <p>
 * Force field for the output video frame.
 * 
 * <p>
 * The {@code setfield} filter marks the interlace type field for the output frames. It does not change the
 * input frame, but only sets the corresponding property, which affects how the frame is treated by following
 * filters (e.g. {@code fieldorder} or {@code yadif}).
 * 
 * @author tangxbai
 * @since 2022/08/03
 * @see <a href="https://ffmpeg.org/ffmpeg-filters.html#setfield-1">ffmpeg-filters#setfield</a>
 */
@Function( "setfield" )
public class SetField extends AbstractFunction<SetField> {

	// Don't let anyone instantiate this class
	private SetField() {}

	/**
	 * Quickly create an instances of {@link SetField}
	 * 
	 * @apiNote (flags) mode
	 * @param mode the interlace mode
	 * @return the {@link SetField} instance
	 */
	public static final SetField of( FieldMode mode ) {
		return new SetField().addArg( "mode", mode );
	}

}
