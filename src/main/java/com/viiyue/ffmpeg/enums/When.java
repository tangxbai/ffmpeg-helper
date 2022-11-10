package com.viiyue.ffmpeg.enums;

import com.viiyue.ffmpeg.common.AbstractEnum;

/**
 * When to evaluate expressions
 *
 * @author tangxbai
 * @since 2022/06/29
 */
public enum When implements AbstractEnum {
	/** Only evaluate expressions once during the filter initialization or when a command is processed */
	INIT,
	/** Evaluate expressions for each incoming frame */
	FRAME
}
