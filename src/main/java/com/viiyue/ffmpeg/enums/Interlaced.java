package com.viiyue.ffmpeg.enums;

import com.viiyue.ffmpeg.annotation.Alias;
import com.viiyue.ffmpeg.common.AbstractEnum;

/**
 * The field scanning mode
 *
 * @author tangxbai
 * @since 2022/07/12
 */
public enum Interlaced implements AbstractEnum {
	/** Top field first: {@code tff} */
	@Alias( "tff" )
	TOP_FIELD_FIRST,

	/** Bottom field first: {@code bff} */
	@Alias( "bff" )
	BOTTOM_FIEL_FIRST
}
