package com.viiyue.ffmpeg.common;

/**
 * Usage for two parameter methods
 *
 * @author tangxbai
 * @since 2023/03/21, 1.0.1
 */
@FunctionalInterface
public interface TwoArgUsage<A, B> extends UsageLambda {
	Object get( A a, B b );
}
