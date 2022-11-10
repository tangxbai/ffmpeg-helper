package com.viiyue.ffmpeg.enums;

import com.viiyue.ffmpeg.annotation.Alias;
import com.viiyue.ffmpeg.common.AbstractEnum;

/**
 * Screen first field type
 *
 * @author tangxbai
 * @since 2022/06/27
 */
public enum FirstField implements AbstractEnum {
	/** Top field first */
	@Alias( "t" )
	TOP,
	/** Bottom field first The default value is top */
	@Alias( "b" )
	BOTTOM
}
