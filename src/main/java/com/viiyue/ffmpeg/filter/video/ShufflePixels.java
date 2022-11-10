package com.viiyue.ffmpeg.filter.video;

import com.viiyue.ffmpeg.annotation.Function;
import com.viiyue.ffmpeg.common.AbstractEnum;
import com.viiyue.ffmpeg.filter.AbstractFunction;

/**
 * Reorder pixels in video frames
 * 
 * @author tangxbai
 * @since 2022/08/04
 * @see <a href="https://ffmpeg.org/ffmpeg-filters.html#shufflepixels">ffmpeg-filters#shufflepixels</a>
 */
@Function( "shufflepixels" )
public class ShufflePixels extends AbstractFunction<ShufflePixels> {

	// Don't let anyone instantiate this class
	private ShufflePixels() {}

	/**
	 * Quickly create an instances of {@link ShufflePixels}
	 * 
	 * @return the {@link ShufflePixels} instance
	 */
	public static final ShufflePixels of() {
		return new ShufflePixels();
	}

	/**
	 * Set shuffle direction
	 * 
	 * @apiNote (flags) direction, d
	 * @param direction the shuffle direction
	 * @return the {@link ShufflePixels} instance
	 */
	public ShufflePixels direction( Direction direction ) {
		return super.addArg( "d", direction ); // direction, d
	}

	/**
	 * Set shuffle mode
	 * 
	 * @apiNote (flags) mode, m
	 * @param mode the shuffle mode
	 * @return the {@link ShufflePixels} instance
	 */
	public ShufflePixels mode( ShuffleMode mode ) {
		return super.addArg( "m", mode ); // mode, m
	}

	/**
	 * Set shuffle block_size. In case of horizontal shuffle mode only width part of size is used, and in case
	 * of vertical shuffle mode only height part of size is used.
	 * 
	 * @apiNote (int) width, w
	 * @param width the shuffle width of block_size
	 * @return the {@link ShufflePixels} instance
	 */
	public ShufflePixels width( int width ) {
		return super.addArg( "w", width ); // width, w
	}

	/**
	 * Set shuffle block_size. In case of horizontal shuffle mode only width part of size is used, and in case
	 * of vertical shuffle mode only height part of size is used.
	 * 
	 * @apiNote (int) height, h
	 * @param height the shuffle height of block_size
	 * @return the {@link ShufflePixels} instance
	 */
	public ShufflePixels height( int height ) {
		return super.addArg( "h", height ); // height, h
	}

	/**
	 * Set random seed used with shuffling pixels. Mainly useful to set to be able to reverse filtering
	 * process to get original input. For example, to reverse forward shuffle you need to use same parameters
	 * and exact same seed and to set direction to inverse.
	 * 
	 * @apiNote (long) seed, s
	 * @param value the random seed value
	 * @return the {@link ShufflePixels} instance
	 */
	public ShufflePixels seed( long value ) {
		return super.addArg( "s", value ); // seed, s
	}

	/**
	 * Shuffle direction
	 *
	 * @author tangxbai
	 * @since 2022/08/04
	 */
	public enum Direction implements AbstractEnum {
		FORWARD, INVERSE
	}

	/**
	 * Shuffle direction
	 *
	 * @author tangxbai
	 * @since 2022/08/04
	 */
	public enum ShuffleMode implements AbstractEnum {
		HORIZONTAL, VERTICAL, BLOCK
	}

}
