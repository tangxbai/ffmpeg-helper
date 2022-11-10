package com.viiyue.ffmpeg.filter.video;

import com.viiyue.ffmpeg.annotation.Function;
import com.viiyue.ffmpeg.enums.Color;
import com.viiyue.ffmpeg.filter.AbstractFunction;
import com.viiyue.ffmpeg.util.Assert;

/**
 * <p>
 * Normalize RGB video (aka histogram stretching, contrast stretching). See:
 * https://en.wikipedia.org/wiki/Normalization_(image_processing)
 * 
 * <p>
 * For each channel of each frame, the filter computes the input range and maps it linearly to the
 * user-specified output range. The output range defaults to the full dynamic range from pure black to pure
 * white.
 * 
 * <p>
 * Temporal smoothing can be used on the input range to reduce flickering (rapid changes in brightness) caused
 * when small dark or bright objects enter or leave the scene. This is similar to the auto-exposure (automatic
 * gain control) on a video camera, and, like a video camera, it may cause a period of over- or under-exposure
 * of the video.
 * 
 * <p>
 * The R,G,B channels can be normalized independently, which may cause some color shifting, or linked together
 * as a single channel, which prevents color shifting. Linked normalization preserves hue. Independent
 * normalization does not, so it can be used to remove some color casts. Independent and linked normalization
 * can be combined in any ratio.
 * 
 * @author tangxbai
 * @since 2022/07/19
 * @see <a href="https://ffmpeg.org/ffmpeg-filters.html#normalize">ffmpeg-filters#normalize</a>
 */
@Function( "normalize" )
public class Normalize extends AbstractFunction<Normalize> {

	// Don't let anyone instantiate this class
	private Normalize() {}

	/**
	 * Quickly create an instances of {@link Normalize}
	 * 
	 * @return the {@link Normalize} instance
	 */
	public static final Normalize of() {
		return new Normalize();
	}

	/**
	 * Output color to which darkest input color is mapped
	 * 
	 * @apiNote (string) blackpt
	 * @param value the mapped color
	 * @return the {@link Normalize} instance
	 */
	public Normalize blackpt( String color ) {
		return super.addArg( "blackpt", color );
	}

	/**
	 * Output color to which darkest input color is mapped
	 * 
	 * @apiNote (color) blackpt
	 * @param value the mapped color
	 * @return the {@link Normalize} instance
	 * @see Color
	 */
	public Normalize blackpt( Color color ) {
		return super.addArg( "blackpt", color );
	}

	/**
	 * Output color to which brightest input color is mapped
	 * 
	 * @apiNote (string) whitept
	 * @param value the mapped color
	 * @return the {@link Normalize} instance
	 */
	public Normalize whitept( String color ) {
		return super.addArg( "whitept", color );
	}

	/**
	 * Output color to which brightest input color is mapped
	 * 
	 * @apiNote (color) whitept
	 * @param value the mapped color
	 * @return the {@link Normalize} instance
	 * @see Color
	 */
	public Normalize whitept( Color color ) {
		return super.addArg( "whitept", color );
	}

	/**
	 * The number of previous frames to use for temporal smoothing. The input range of each channel is
	 * smoothed using a rolling average over the current frame and the smoothing previous frames. The default
	 * is <b>0</b> (no temporal smoothing).
	 * 
	 * @apiNote (int) smoothing
	 * @param value the amount of temporal smoothing
	 * @return the {@link Normalize} instance
	 */
	public Normalize smoothing( int value ) {
		return super.addArg( "smoothing", value );
	}

	/**
	 * Controls the ratio of independent (color shifting) channel normalization to linked (color preserving)
	 * normalization. 0.0 is fully linked, 1.0 is fully independent. Defaults to <b>1.0</b> (fully
	 * independent).
	 * 
	 * @apiNote (double) independence
	 * @param value the ratio value
	 * @return the {@link Normalize} instance
	 */
	public Normalize independence( double value ) {
		Assert.rangeCheck( value, 0.0, 1.0 );
		return super.addArg( "independence", value );
	}

	/**
	 * Overall strength of the filter. 1.0 is full strength. 0.0 is a rather expensive no-op. Defaults to
	 * <b>1.0</b> (full strength).
	 * 
	 * @apiNote (double) strength
	 * @param value the strength value
	 * @return the {@link Normalize} instance
	 */
	public Normalize strength( double value ) {
		Assert.rangeCheck( value, 0.0, 1.0 );
		return super.addArg( "strength", value );
	}

}
