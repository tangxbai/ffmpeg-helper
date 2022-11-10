package com.viiyue.ffmpeg.filter.video;

import com.viiyue.ffmpeg.annotation.Function;
import com.viiyue.ffmpeg.filter.AbstractFunction;

/**
 * <p>
 * Determines blockiness of frames without altering the input frames.
 * 
 * <p>
 * Based on Remco Muijs and Ihor Kirenko: "A no-reference blocking artifact measure for adaptive video
 * processing." 2005 13th European signal processing conference.
 *
 * @author tangxbai
 * @since 2022/06/09
 * @see <a href="https://ffmpeg.org/ffmpeg-filters.html#blockdetect-1">ffmpeg-filters#blockdetect</a>
 */
@Function( "blockdetect" )
public class BlockDetect extends AbstractFunction<BlockDetect> {

	// Don't let anyone instantiate this class
	private BlockDetect() {}

	/**
	 * Quickly create an instances of {@link BlockDetect}
	 * 
	 * @return the {@link BlockDetect} instance
	 */
	public static final BlockDetect the() {
		return new BlockDetect();
	}

	/**
	 * Set minimum value for determining pixel grids (periods), default value is 3.
	 * 
	 * @apiNote (int) period_min
	 * @param pixel the minimum values
	 * @return the {@link BlockDetect} instance
	 */
	public BlockDetect periodMin( int pixel ) {
		return super.addArg( "period_min", pixel );
	}

	/**
	 * Set maximum value for determining pixel grids (periods), default value is 24.
	 * 
	 * @apiNote (int) period_max
	 * @param pixel the minimum values
	 * @return the {@link BlockDetect} instance
	 */
	public BlockDetect periodMax( int pixel ) {
		return super.addArg( "period_max", pixel );
	}

	/**
	 * Set planes to filter, default is first only.
	 * 
	 * @apiNote (int) planes
	 * @param plane the plane value
	 * @return the {@link BlockDetect} instance
	 */
	public BlockDetect planes( int plane ) {
		return super.addArg( "planes", plane );
	}

}
