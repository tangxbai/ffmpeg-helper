package com.viiyue.ffmpeg.enums;

import com.viiyue.ffmpeg.annotation.Alias;
import com.viiyue.ffmpeg.common.AbstractEnum;

/**
 * The field parity assumed for the input interlaced video
 *
 * @author tangxbai
 * @since 2022/06/14
 */
public enum Parity implements AbstractEnum {

	/** Auto detect parity (use FFmpeg’s internal parity value) */
	AUTO,

	/** Assume top field first */
	@Alias( "tff" )
	TOP_FIELD_FIRST,

	/** Assume bottom field first */
	@Alias( "bff" )
	BOTTOM_FIEL_FIRST

}
