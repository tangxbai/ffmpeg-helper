package com.viiyue.ffmpeg.enums;

import com.viiyue.ffmpeg.annotation.Alias;
import com.viiyue.ffmpeg.common.AbstractEnum;

/**
 * Some filters with several inputs support a common set of options. These options can only be set by name,
 * not with the short notation.
 *
 * @author tangxbai
 * @since 2022/06/05
 */
public enum EofAction implements AbstractEnum {
	/** Repeat the last frame (the default) */
	REPEAT,
	/** End both streams */
	@Alias( "endall" )
	END_ALL,
	/** Pass the main input through */
	PASS
}
