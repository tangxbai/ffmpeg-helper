package com.viiyue.ffmpeg.enums;

import com.viiyue.ffmpeg.annotation.Alias;
import com.viiyue.ffmpeg.common.AbstractEnum;

/**
 * Interlace mode
 *
 * @author tangxbai
 * @since 2022/08/03
 */
public enum FieldMode implements AbstractEnum {
	/** Keep the same field property */
	AUTO,

	/** Mark the frame as top-field-first */
	@Alias( "tff" )
	TOP_FIELD_FIRST,

	/** Mark the frame as bottom-field-first */
	@Alias( "bff" )
	BOTTOM_FIEL_FIRST,

	/** Mark the frame as progressive */
	@Alias( "prog" )
	PROGRESSIVE
}
