package com.viiyue.ffmpeg.filter.video;

import com.viiyue.ffmpeg.annotation.Function;
import com.viiyue.ffmpeg.enums.EofAction;
import com.viiyue.ffmpeg.filter.AbstractFunction;

/**
 * <p>
 * Obtain the identity score between two input videos, this filter takes two input videos.
 * 
 * <p>
 * Both input videos must have the same resolution and pixel format for this filter to work correctly. Also it
 * assumes that both inputs have the same number of frames, which are compared one by one.
 * 
 * <p>
 * The obtained per component, average, min and max identity score is printed through the logging system.
 * 
 * <p>
 * The filter stores the calculated identity scores of each frame in frame metadata.
 * 
 * <p>
 * In the below example the input file main.mpg being processed is compared with the reference file ref.mpg.
 *
 * @author tangxbai
 * @since 2022/07/11
 * @see <a href="https://ffmpeg.org/ffmpeg-filters.html#identity">ffmpeg-filters#identity</a>
 */
@Function( "identity" )
public class Identity extends AbstractFunction<Identity> {

	// Don't let anyone instantiate this class
	private Identity() {}

	/**
	 * Quickly create an instances of {@link Identity}
	 * 
	 * @return the {@link Identity} instance
	 */
	public static final Identity of() {
		return new Identity();
	}

	/**
	 * The action to take when EOF is encountered on the secondary input
	 * 
	 * @apiNote (flags) eof_action
	 * @param action the EOF action
	 * @return the {@link Identity} instance
	 */
	public Identity action( EofAction action ) {
		return super.addArg( "eof_action", action );
	}

	/**
	 * If set to {@code true}, force the output to terminate when the shortest input terminates. default value
	 * is {@code false}.
	 * 
	 * @apiNote (boolean) shorttest
	 * @param state the shortest state
	 * @return the {@link Identity} instance
	 */
	public Identity shortest( boolean state ) {
		return super.status( "shortest", state );
	}

	/**
	 * If set to true, force the filter to extend the last frame of secondary streams until the end of the
	 * primary stream.
	 * 
	 * @apiNote (boolean) repeatlast
	 * @param state the repeat last state
	 * @return the {@link Identity} instance
	 */
	public Identity repeatLast( boolean state ) {
		return super.status( "repeatlast", state );
	}

}
