package com.viiyue.ffmpeg.filter.video;

import com.viiyue.ffmpeg.annotation.Function;
import com.viiyue.ffmpeg.enums.EofAction;
import com.viiyue.ffmpeg.filter.AbstractFunction;

/**
 * <p>
 * Obtain the MSAD (Mean Sum of Absolute Differences) between two input videos. This filter takes two input
 * videos.
 * 
 * <p>
 * Both input videos must have the same resolution and pixel format for this filter to work correctly. Also it
 * assumes that both inputs have the same number of frames, which are compared one by one.
 * 
 * <p>
 * The obtained per component, average, min and max MSAD is printed through the logging system.
 * 
 * <p>
 * The filter stores the calculated MSAD of each frame in frame metadata.
 * 
 * <p>
 * In the below example the input file main.mpg being processed is compared with the reference file ref.mpg.
 * 
 * @author tangxbai
 * @since 2022/07/19
 * @see <a href="https://ffmpeg.org/ffmpeg-filters.html#msad">ffmpeg-filters#msad</a>
 */
@Function( "msad" )
public class Msad extends AbstractFunction<Msad> {

	// Don't let anyone instantiate this class
	private Msad() {}

	/**
	 * Quickly create an instances of {@link Msad}
	 * 
	 * @return the {@link Msad} instance
	 */
	public static final Msad of() {
		return new Msad();
	}

	/**
	 * The action to take when EOF is encountered on the secondary input
	 * 
	 * @apiNote (flags) eof_action
	 * @param action the EOF action
	 * @return the {@link Msad} instance
	 */
	public Msad action( EofAction action ) {
		return super.addArg( "eof_action", action );
	}

	/**
	 * If set to {@code true}, force the output to terminate when the shortest input terminates. default value
	 * is {@code false}.
	 * 
	 * @apiNote (boolean) shorttest
	 * @param state the shortest state
	 * @return the {@link Msad} instance
	 */
	public Msad shortest( boolean state ) {
		return super.status( "shortest", state );
	}

	/**
	 * If set to true, force the filter to extend the last frame of secondary streams until the end of the
	 * primary stream.
	 * 
	 * @apiNote (boolean) repeatlast
	 * @param state the repeat last state
	 * @return the {@link Msad} instance
	 */
	public Msad repeatLast( boolean state ) {
		return super.status( "repeatlast", state );
	}

}
