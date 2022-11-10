package com.viiyue.ffmpeg.filter.video;

import com.viiyue.ffmpeg.annotation.Function;
import com.viiyue.ffmpeg.filter.AbstractFunction;

/**
 * <p>
 * Concatenate audio and video streams, joining them together one after the other.
 * 
 * <p>
 * The filter works on segments of synchronized video and audio streams. All segments must have the same
 * number of streams of each type, and that will also be the number of streams at output.
 *
 * @author tangxbai
 * @since 2022/06/30
 * @see <a href= "https://ffmpeg.org/ffmpeg-filters.html#concat">ffmpeg-filters#concat</a>
 */
@Function( "concat" )
public class Concat extends AbstractFunction<Concat> {

	// Don't let anyone instantiate this class
	private Concat() {}

	/**
	 * Quickly create an instances of {@link Concat}
	 * 
	 * @apiNote (int) n
	 * @param how specify the total number to input
	 * @return the {@link Concat} instance
	 */
	public static final Concat in( int how ) {
		return new Concat().input( how );
	}

	/**
	 * Quickly create an instances of {@link Concat}
	 * 
	 * @apiNote (int) n, (int) v, (int) a
	 * @param how      specify the total number to input
	 * @param videoNum specify the number of videos to input
	 * @param audioNum specify the number of audios to enter
	 * @return the {@link Concat} instance
	 */
	public static final Concat in( int how, int videoNum, int audioNum ) {
		return in( how ).video( videoNum ).audio( audioNum );
	}

	/**
	 * Quickly create an instances of {@link Concat}
	 * 
	 * @apiNote (int) n
	 * @param value specify the total number to input
	 * @return the {@link Concat} instance
	 */
	public Concat input( int value ) {
		return super.addArg( "n", value );
	}

	/**
	 * Quickly create an instances of {@link Concat}
	 * 
	 * @apiNote (int) v
	 * @param value specify the number of videos to input
	 * @return the {@link Concat} instance
	 */
	public Concat video( int value ) {
		return super.addArg( "v", value );
	}

	/**
	 * Quickly create an instances of {@link Concat}
	 * 
	 * @apiNote (int) a
	 * @param value specify the number of audios to enter
	 * @return the {@link Concat} instance
	 */
	public Concat audio( int value ) {
		return super.addArg( "a", value );
	}

}
