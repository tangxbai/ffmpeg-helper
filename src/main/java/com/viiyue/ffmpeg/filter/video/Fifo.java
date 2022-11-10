package com.viiyue.ffmpeg.filter.video;

import com.viiyue.ffmpeg.filter.AbstractFunction;

/**
 * <p>
 * Buffer input images and send them when they are requested. It is mainly useful when auto-inserted by the
 * {@code libavfilter} framework.
 * 
 * <p>
 * It does not take parameters.
 * 
 * @author tangxbai
 * @since 2022/06/02
 * @see <a href="https://ffmpeg.org/ffmpeg-filters.html#fifo_002c-afifo">ffmpeg-filters#fifo</a>
 */
public class Fifo extends AbstractFunction<Fifo> {

	private final String funName;

	// Don't let anyone instantiate this class
	private Fifo( String funName ) {
		this.funName = funName;
	}

	public static final Fifo that() {
		return new Fifo( "fifo" );
	}

	public static final Fifo afifo() {
		return new Fifo( "afifo" );
	}

	@Override
	protected String getResult() {
		return this.funName;
	}

}
