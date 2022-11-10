package com.viiyue.ffmpeg.filter;

/**
 * @author tangxbai
 * @since 2022/06/02
 * @param <T>
 */
public abstract class AbstractResult<T extends AbstractResult<?>> {

	protected abstract String getResult();

	@Override
	public final String toString() {
		return getResult();
	}

}
