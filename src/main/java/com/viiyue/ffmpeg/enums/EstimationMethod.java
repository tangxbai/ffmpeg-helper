package com.viiyue.ffmpeg.enums;

import com.viiyue.ffmpeg.common.AbstractEnum;

/**
 * Motion estimation method
 *
 * @author tangxbai
 * @since 2022/07/18
 */
public enum EstimationMethod implements AbstractEnum {
	/** Exhaustive search algorithm */
	ESA,
	/** Three step search algorithm */
	TSS,
	/** Two dimensional logarithmic search algorithm */
	TDLS,
	/** New three step search algorithm */
	NTSS,
	/** Four step search algorithm */
	FSS,
	/** Diamond search algorithm */
	DS,
	/** Hexagon-based search algorithm */
	HEXBS,
	/** Enhanced predictive zonal search algorithm */
	EPZS,
	/** Uneven multi-hexagon search algorithm */
	UMH
}
