package com.viiyue.ffmpeg.filter.video;

import com.viiyue.ffmpeg.annotation.Function;
import com.viiyue.ffmpeg.filter.AbstractFunction;
import com.viiyue.ffmpeg.util.Assert;

/**
 * <p>
 * Detect video intervals that are (almost) completely black. Can be useful to detect chapter transitions,
 * commercials, or invalid recordings.
 * 
 * <p>
 * The filter outputs its detection analysis to both the log as well as frame metadata. If a black segment of
 * at least the specified minimum duration is found, a line with the start and end timestamps as well as
 * duration is printed to the log with level info. In addition, a log line with level debug is printed per
 * frame showing the black amount detected for that frame.
 * 
 * <p>
 * The filter also attaches metadata to the first frame of a black segment with key lavfi.black_start and to
 * the first frame after the black segment ends with key lavfi.black_end. The value is the frame’s timestamp.
 * This metadata is added regardless of the minimum duration specified.
 *
 * @author tangxbai
 * @since 2022/06/09
 * @see <a href="https://ffmpeg.org/ffmpeg-filters.html#blackdetect">ffmpeg-filters#blackdetect</a>
 */
@Function( "blackdetect" )
public class BlackDetect extends AbstractFunction<BlackDetect> {

	// Don't let anyone instantiate this class
	private BlackDetect() {}

	/**
	 * Quickly create an instances of {@link BlackDetect}
	 * 
	 * @return the {@link BlackDetect} instance
	 */
	public static final BlackDetect the() {
		return new BlackDetect();
	}

	/**
	 * Set the minimum detected black duration expressed in seconds. It must be a non-negative floating point
	 * number, default value is <b>2.0</b>.
	 * 
	 * @apiNote (double) black_min_duration, d
	 * @param value the black duration
	 * @return the {@link BlackDetect} instance
	 */
	public BlackDetect min( double duration ) {
		Assert.isTrue( duration > 0, "Value muse be greater than 0" );
		return super.addArg( "d", duration ); // black_min_duration, d
	}

	/**
	 * Set the threshold for considering a picture "black", Picture with a default value of <b>0.98</b> for
	 * are considered black.
	 * 
	 * @apiNote (double) picture_black_ratio_th, pic_th
	 * @param value the black ratio
	 * @return the {@link BlackDetect} instance
	 */
	public BlackDetect blackRatio( double ratio ) {
		Assert.rangeCheck( ratio, 0, 1 );
		return super.addArg( "pic_th", ratio ); // picture_black_ratio_th, pic_th
	}

	/**
	 * Set the threshold for considering a pixel "black".
	 * 
	 * <p>
	 * The threshold expresses the maximum pixel luminance value for which a pixel is considered "black". The
	 * provided value is scaled according to the following equa tion. default is <b>0.98</b>.
	 * 
	 * @apiNote (double) pixel_black_th, pix_th
	 * @param value the black ratio
	 * @return the {@link BlackDetect} instance
	 */
	public BlackDetect threshold( double threshold ) {
		Assert.rangeCheck( threshold, 0, 1 );
		return super.addArg( "pic_th", threshold ); // pixel_black_th, pix_th
	}

}
