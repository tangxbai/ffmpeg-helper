package com.viiyue.ffmpeg.filter.video;

import com.viiyue.ffmpeg.annotation.Function;
import com.viiyue.ffmpeg.filter.AbstractFunction;

/**
 * <p>
 * The setdar filter sets the Display Aspect Ratio for the filter output video.
 * 
 * <p>
 * This is done by changing the specified Sample (aka Pixel) Aspect Ratio, according to the following
 * equation:
 *
 * <pre>
 * DAR = HORIZONTAL_RESOLUTION / VERTICAL_RESOLUTION * SAR
 * </pre>
 * 
 * <p>
 * Keep in mind that the setdar filter does not modify the pixel dimensions of the video frame. Also, the
 * display aspect ratio set by this filter may be changed by later filters in the filterchain, e.g. in case of
 * scaling or if another "setdar" or a "setsar" filter is applied.
 * 
 * <p>
 * The setsar filter sets the Sample (aka Pixel) Aspect Ratio for the filter output video.
 * 
 * <p>
 * Note that as a consequence of the application of this filter, the output display aspect ratio will change
 * according to the equation above.
 * 
 * <p>
 * Keep in mind that the sample aspect ratio set by the setsar filter may be changed by later filters in the
 * filterchain, e.g. if another "setsar" or a "setdar" filter is applied.
 * 
 * @author tangxbai
 * @since 2022/08/03
 * @see <a href="https://ffmpeg.org/ffmpeg-filters.html#setdar_002c-setsar">ffmpeg-filters#setdar</a>
 */
@Function( "setdar" )
public class SetDar extends AbstractFunction<SetDar> {

	// Don't let anyone instantiate this class
	private SetDar() {}

	/**
	 * Quickly create an instances of {@link SetDar}
	 * 
	 * @return the {@link SetDar} instance
	 */
	public static final SetDar of() {
		return new SetDar();
	}

	/**
	 * Set the aspect ratio used by the filter
	 * 
	 * @apiNote (double) dar
	 * @param ratio the aspect ratio
	 * @return the {@link SetDar} instance
	 */
	public SetDar dar( double ratio ) {
		return super.addArg( "dar", ratio );
	}

	/**
	 * Set the aspect ratio used by the filter
	 * 
	 * @apiNote (string) dar
	 * @param num the ratio numerator
	 * @param num the ratio denominator
	 * @return the {@link SetDar} instance
	 */
	public SetDar dar( int num, int den ) {
		return super.addArg( "dar", num + "/" + den );
	}

	/**
	 * Set the aspect ratio used by the filter
	 * 
	 * @apiNote (double) ratio
	 * @param ratio the aspect ratio
	 * @param num   the ratio denominator
	 * @return the {@link SetDar} instance
	 */
	public SetDar ratio( double ratio ) {
		return super.addArg( "r", ratio ); // ratio, r
	}

	/**
	 * Set the aspect ratio used by the filter
	 * 
	 * @apiNote (string) ratio
	 * @param num the ratio numerator
	 * @param num the ratio denominator
	 * @return the {@link SetDar} instance
	 */
	public SetDar ratio( int num, int den ) {
		return super.addArg( "r", num + "/" + den ); // ratio, r
	}

	/**
	 * Set the maximum integer value to use for expressing numerator and denominator when reducing the
	 * expressed aspect ratio to a rational. Default value is <b>100</b>.
	 * 
	 * @apiNote (int) max
	 * @param value the maximum integer value
	 * @return the {@link SetDar} instance
	 */
	public SetDar max( int value ) {
		return super.addArg( "max", value );
	}

}
