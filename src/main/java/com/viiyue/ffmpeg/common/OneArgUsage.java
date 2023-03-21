package com.viiyue.ffmpeg.common;

/**
 * Usage for single parameter methods
 *
 * @author tangxbai
 * @since 2023/03/21, 1.0.1
 */
@FunctionalInterface
public interface OneArgUsage<T> extends UsageLambda {
	Object get( T arg );
}
