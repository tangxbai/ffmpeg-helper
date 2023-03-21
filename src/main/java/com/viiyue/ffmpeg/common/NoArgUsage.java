package com.viiyue.ffmpeg.common;

/**
 * Usage for parameterless methods
 *
 * @author tangxbai
 * @since 2023/03/21, 1.0.1
 */
@FunctionalInterface
public interface NoArgUsage extends UsageLambda {
	Object get();
}
