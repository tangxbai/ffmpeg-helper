package com.viiyue.ffmpeg.filter.video;

import com.viiyue.ffmpeg.annotation.Alias;
import com.viiyue.ffmpeg.annotation.Function;
import com.viiyue.ffmpeg.common.AbstractEnum;
import com.viiyue.ffmpeg.filter.AbstractFunction;

/**
 * <p>
 * Delay interlaced video by one field time so that the field order changes.
 * 
 * <p>
 * The intended use is to fix PAL movies that have been captured with the opposite field order to the
 * film-to-video transfer.
 * 
 * @author tangxbai
 * @since 2022/07/20
 * @see <a href="https://ffmpeg.org/ffmpeg-filters.html#phase">ffmpeg-filters#phase</a>
 */
@Function( "phase" )
public class Phase extends AbstractFunction<Phase> {

	// Don't let anyone instantiate this class
	private Phase() {}

	/**
	 * Quickly create an instances of {@link Phase}
	 * 
	 * @apiNote (flags) mode
	 * @param mode the phase mode
	 * @return the {@link Phase} instance
	 */
	public static final Phase mode( PhaseMode mode ) {
		return new Phase().addArg( "mode", mode );
	}

	/**
	 * Phase mode
	 *
	 * @author tangxbai
	 * @since 2022/07/20
	 */
	public enum PhaseMode implements AbstractEnum {
		/**
		 * Capture and transfer with the same field order. This mode only exists for the documentation of the
		 * other options to refer to, but if you actually select it, the filter will faithfully do nothing.
		 */
		@Alias( "p" )
		PROGRESSIVE,

		/** Capture field order top-first, transfer bottom-first. Filter will delay the bottom field. */
		@Alias( "t" )
		TOP_FIRST,

		/** Capture field order bottom-first, transfer top-first. Filter will delay the top field. */
		@Alias( "b" )
		BOTTOM_FIRST,

		/**
		 * Capture top-first, transfer unknown or varying. Filter selects among ‘t’ and ‘p’ using image
		 * analysis.
		 */
		@Alias( "T" )
		TOP_FRIST_ANALYZE,

		/**
		 * Capture bottom-first, transfer unknown or varying. Filter selects among ‘b’ and ‘p’ using image
		 * analysis.
		 */
		@Alias( "B" )
		BOTTOM_FIRST_ANALYZE,

		/**
		 * Capture unknown or varying, transfer opposite. Filter selects among ‘t’ and ‘b’ on a frame by frame
		 * basis by analyzing the images and selecting the alternative that produces best match between the
		 * fields.
		 */
		@Alias( "u" )
		ANALYZE,

		/**
		 * Both capture and transfer unknown or varying. Filter selects among ‘t’, ‘b’ and ‘p’ using image
		 * analysis only.
		 */
		@Alias( "U" )
		FULL_ANALYZE,

		/**
		 * Capture field order determined automatically by field flags, transfer opposite. Filter selects
		 * among ‘t’ and ‘b’ modes on a frame by frame basis using field flags. If no field information is
		 * available, then this works just like ‘u’.
		 */
		@Alias( "a" )
		AUTO,

		/**
		 * Capture determined by field flags, transfer unknown or varying. Filter selects among ‘t’, ‘b’ and
		 * ‘p’ using field flags and image analysis. If no field information is available, then this works
		 * just like ‘U’. This is the default mode.
		 */
		@Alias( "A" )
		AUTO_ANALYZE
	}

}
