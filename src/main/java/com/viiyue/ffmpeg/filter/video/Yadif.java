package com.viiyue.ffmpeg.filter.video;

import com.viiyue.ffmpeg.annotation.Function;
import com.viiyue.ffmpeg.common.AbstractEnum;
import com.viiyue.ffmpeg.enums.Deinterlace;
import com.viiyue.ffmpeg.enums.Parity;
import com.viiyue.ffmpeg.filter.AbstractFunction;

/**
 * Deinterlace the input video ("yadif" means "yet another deinterlacing filter").
 *
 * @author tangxbai
 * @since 2022/10/20
 * @see <a href="https://ffmpeg.org/ffmpeg-filters.html#yadif-1">ffmpeg-filters#yadif</a>
 */
@Function( "yadif" )
public class Yadif extends AbstractFunction<Yadif> {

	// Don't let anyone instantiate this class
	private Yadif() {}

	/**
	 * Quickly create an instances of {@link Yadif}
	 * 
	 * @return the {@link Yadif} instance
	 */
	public static final Yadif of() {
		return new Yadif();
	}

	/**
	 * The interlacing mode to adopt, default flag is {@link InterlacingMode#SEND_FRAME}.
	 * 
	 * @apiNote (flags) mode
	 * @param value the interlacing mode
	 * @return the {@link Yadif} instance
	 * @see InterlacingMode
	 */
	public Yadif mode( InterlacingMode mode ) {
		return super.addArg( "mode", mode );
	}

	/**
	 * <p>
	 * The picture field parity assumed for the input interlaced video.
	 * 
	 * <p>
	 * The default value is {@link Parity#AUTO}. If the interlacing is unknown or the decoder does not export
	 * this information, top field first will be assumed.
	 * 
	 * @apiNote (flags) parity
	 * @param parity the field parity
	 * @return the {@link Yadif} instance
	 * @see Parity
	 */
	public Yadif parity( Parity parity ) {
		return super.addArg( "parity", parity );
	}

	/**
	 * Specify which frames to deinterlace, default is {@link Deinterlace#ALL}.
	 * 
	 * @apiNote (flags) deint
	 * @param deint specify which frames to deinterlace
	 * @return the {@link Yadif} instance
	 * @see Deinterlace
	 */
	public Yadif deint( Deinterlace deint ) {
		return super.addArg( "deint", deint );
	}

	/**
	 * Interlacing mode
	 *
	 * @author tangxbai
	 * @since 2022/10/20
	 */
	public enum InterlacingMode implements AbstractEnum {

		/** Output one frame for each frame */
		SEND_FRAME,

		/** Output one frame for each field */
		SEND_FIELD,

		/** Like {@link #SEND_FRAME}, but it skips the spatial interlacing check. */
		SEND_FRAME_NOSPATIAL,

		/** Like {@link #SEND_FIELD}, but it skips the spatial interlacing check. */
		SEND_FIELD_NOSPATIAL;

		@Override
		public String command() {
			return String.valueOf( ordinal() );
		}
	}

}
