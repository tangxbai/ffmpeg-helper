package com.viiyue.ffmpeg.enums;

import com.viiyue.ffmpeg.common.AbstractEnum;

/**
 * Original aspect ratio
 *
 * @author tangxbai
 * @since 2022/07/12
 */
public enum AspectRatio implements AbstractEnum {
	/** Scale the video as specified and disable this feature */
	DISABLE,
	/** The output video dimensions will automatically be decreased if needed */
	DECREASE,
	/** The output video dimensions will automatically be increased if needed */
	INCREASE
}
