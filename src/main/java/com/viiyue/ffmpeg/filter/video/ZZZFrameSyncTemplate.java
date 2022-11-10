package com.viiyue.ffmpeg.filter.video;

import com.viiyue.ffmpeg.enums.EofAction;
import com.viiyue.ffmpeg.filter.AbstractFunction;

public class ZZZFrameSyncTemplate extends AbstractFunction<ZZZFrameSyncTemplate> {

	/**
	 * The action to take when EOF is encountered on the secondary input
	 * 
	 * @apiNote (flags) eof_action
	 * @param action the EOF action
	 * @return the {@link ZZZFrameSyncTemplate} instance
	 */
	public ZZZFrameSyncTemplate action( EofAction action ) {
		return super.addArg( "eof_action", action );
	}

	/**
	 * If set to true, force the output to terminate when the shortest input terminates. default value is
	 * false.
	 * 
	 * @apiNote (boolean) shortest
	 * @param state the shortest state
	 * @return the {@link ZZZFrameSyncTemplate} instance
	 */
	public ZZZFrameSyncTemplate shortest( boolean state ) {
		return super.status( "shortest", state );
	}

	/**
	 * If set to true, force the filter to extend the last frame of secondary streams until the end of the
	 * primary stream. A value of 0 disables this behavior, default value is false.
	 * 
	 * @apiNote (boolean) repeatlast
	 * @param state the repeat last state
	 * @return the {@link ZZZFrameSyncTemplate} instance
	 */
	public ZZZFrameSyncTemplate repeatLast( boolean state ) {
		return super.status( "repeatlast", state );
	}

}
