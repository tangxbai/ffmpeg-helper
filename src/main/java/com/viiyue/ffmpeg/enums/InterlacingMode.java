package com.viiyue.ffmpeg.enums;

import com.viiyue.ffmpeg.common.AbstractEnum;

/**
 * Interlacing mode
 *
 * @author tangxbai
 * @since 2022/06/30
 */
public enum InterlacingMode implements AbstractEnum {
	/** Output one frame for each frame */
	FRAME,
	/** Output one frame for each field */
	FIELD
}
