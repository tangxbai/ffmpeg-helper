package com.viiyue.ffmpeg.enums;

import com.viiyue.ffmpeg.annotation.Alias;
import com.viiyue.ffmpeg.common.AbstractEnum;

/**
 * Combination match mode
 *
 * @author tangxbai
 * @since 2022/07/04
 */
public enum CombMatch implements AbstractEnum {
	/** No final matching based on combed scores */
	NONE,
	/** Combed scores are only used when a scene change is detected */
	@Alias( "sc" )
	SCENE_CHANGE,
	/** Use combed scores all the time */
	FULL
}
