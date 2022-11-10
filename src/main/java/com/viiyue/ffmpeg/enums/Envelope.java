package com.viiyue.ffmpeg.enums;

import com.viiyue.ffmpeg.common.AbstractEnum;

/**
 * Display envelope
 *
 * @author tangxbai
 * @since 2022/10/11
 */
public enum Envelope implements AbstractEnum {
	/** No envelope, this is default */
	NONE,
	/** Instant envelope, even darkest single pixel will be clearly highlighted. */
	INSTANT,
	/**
	 * Hold maximum and minimum values presented in graph over time. This way you can still spot out of range
	 * values without constantly looking at vectorscope.
	 */
	PEAK
}
