package com.viiyue.ffmpeg.filter.video;

import com.viiyue.ffmpeg.annotation.Function;
import com.viiyue.ffmpeg.common.AbstractEnum;
import com.viiyue.ffmpeg.enums.EofAction;
import com.viiyue.ffmpeg.filter.AbstractFunction;

/**
 * <p>
 * Apply a Hald CLUT to a video stream.
 * 
 * <p>
 * First input is the video stream to process, and second one is the Hald CLUT. The Hald CLUT input can be a
 * simple picture or a complete video stream.
 *
 * @author tangxbai
 * @since 2022/07/11
 * @see <a href="https://ffmpeg.org/ffmpeg-filters.html#haldclut-1">ffmpeg-filters#haldclut</a>
 */
@Function( "haldclut" )
public class HaldClut extends AbstractFunction<HaldClut> {

	// Don't let anyone instantiate this class
	private HaldClut() {}

	/**
	 * Quickly create an instances of {@link HaldClut}
	 * 
	 * @return the {@link HaldClut} instance
	 */
	public static final HaldClut of() {
		return new HaldClut();
	}

	/**
	 * Select interpolation mode
	 * 
	 * @apiNote (flags) interp
	 * @param interp the interpolation mode
	 * @return the {@link HaldClut} instance
	 */
	public HaldClut interp( Interpolation interp ) {
		return super.addArg( "interp", interp );
	}

	/**
	 * The action to take when EOF is encountered on the secondary input
	 * 
	 * @apiNote (flags) eof_action
	 * @param action the EOF action
	 * @return the {@link HaldClut} instance
	 */
	public HaldClut action( EofAction action ) {
		return super.addArg( "eof_action", action );
	}

	/**
	 * If set to {@code true}, force the output to terminate when the shortest input terminates. default value
	 * is {@code false}.
	 * 
	 * @apiNote (boolean) shorttest
	 * @param state the shortest state
	 * @return the {@link HaldClut} instance
	 */
	public HaldClut shortest( boolean state ) {
		return super.status( "shortest", state );
	}

	/**
	 * If set to true, force the filter to extend the last frame of secondary streams until the end of the
	 * primary stream.
	 * 
	 * @apiNote (boolean) repeatlast
	 * @param state the repeat last state
	 * @return the {@link HaldClut} instance
	 */
	public HaldClut repeatLast( boolean state ) {
		return super.status( "repeatlast", state );
	}

	/**
	 * Interpolation mode
	 *
	 * @author tangxbai
	 * @since 2022/07/11
	 */
	public enum Interpolation implements AbstractEnum {
		NEAREST, TRILINEAR, TETRAHEDRAL, PYRAMID, PRISM
	}

}
