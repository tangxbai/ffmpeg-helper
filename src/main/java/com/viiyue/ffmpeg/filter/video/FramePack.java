package com.viiyue.ffmpeg.filter.video;

import com.viiyue.ffmpeg.annotation.Alias;
import com.viiyue.ffmpeg.annotation.Function;
import com.viiyue.ffmpeg.common.AbstractEnum;
import com.viiyue.ffmpeg.filter.AbstractColorFunction;

/**
 * Pack two different video streams into a stereoscopic video, setting proper metadata on supported codecs.
 * The two views should have the same size and framerate and processing will stop when the shorter video ends.
 * Please note that you may conveniently adjust view properties with the {@code scale} and {@code fps}
 * filters.
 * 
 * @author tangxbai
 * @since 2022/07/06
 * @see <a href="https://ffmpeg.org/ffmpeg-filters.html#framepack">ffmpeg-filters#framepack</a>
 */
@Function( "framepack" )
public class FramePack extends AbstractColorFunction<FramePack> {

	// Don't let anyone instantiate this class
	private FramePack() {}

	/**
	 * Quickly create an instances of {@link FramePack}, and specify the desired packing format.
	 * 
	 * @return the {@link FramePack} instance
	 */
	public static final FramePack format( PackFormat format ) {
		return new FramePack().addValue( format );
	}

	/**
	 * The desired packing format
	 *
	 * @author tangxbai
	 * @since 2022/07/06
	 */
	public enum PackFormat implements AbstractEnum {
		/** The views are next to each other (default) */
		SBS,
		/** The views are on top of each other */
		LINES,
		/** The views are packed by line */
		TAB,
		/** The views are packed by column */
		COLUMNS,
		/** The views are temporally interleaved */
		@Alias( "frameseq" )
		FRAME_SEQ
	}

}
