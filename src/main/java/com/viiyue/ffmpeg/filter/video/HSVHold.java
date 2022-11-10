package com.viiyue.ffmpeg.filter.video;

import com.viiyue.ffmpeg.annotation.Function;
import com.viiyue.ffmpeg.filter.AbstractFunction;
import com.viiyue.ffmpeg.util.Assert;

/**
 * <p>
 * Turns a certain HSV range into gray values.
 * 
 * <p>
 * This filter measures color difference between set HSV color in options and ones measured in video stream.
 * Depending on options, output colors can be changed to be gray or not.
 *
 * @author tangxbai
 * @since 2022/07/11
 * @see <a href="https://ffmpeg.org/ffmpeg-filters.html#hsvhold">ffmpeg-filters#hsvhold</a>
 */
@Function( "hsvhold" )
public class HSVHold extends AbstractFunction<HSVHold> {

	// Don't let anyone instantiate this class
	private HSVHold() {}

	/**
	 * Quickly create an instances of {@link HSVHold}
	 * 
	 * @return the {@link HSVHold} instance
	 */
	public static final HSVHold of() {
		return new HSVHold();
	}

	/**
	 * Set the hue value which will be used in color difference calculation. Allowed range is from -360 to
	 * 360, default value is <b>0</b>.
	 * 
	 * @apiNote (double) hue
	 * @param value the hue value
	 * @return the {@link HSVHold} instance
	 */
	public HSVHold hue( double value ) {
		Assert.rangeCheck( value, -360, 360 );
		return super.addArg( "hue", value );
	}

	/**
	 * Set the saturation value which will be used in color difference calculation. Allowed range is from -1
	 * to 1, default value is <b>0</b>.
	 * 
	 * @apiNote (double) sat
	 * @param value the saturation value
	 * @return the {@link HSVHold} instance
	 */
	public HSVHold saturation( double value ) {
		Assert.rangeCheck( value, -1, 1 );
		return super.addArg( "sat", value );
	}

	/**
	 * Set the value which will be used in color difference calculation. Allowed range is from -1 to 1,
	 * default value is <b>0</b>.
	 * 
	 * @apiNote (double) val
	 * @param value the real value
	 * @return the {@link HSVHold} instance
	 */
	public HSVHold val( double value ) {
		Assert.rangeCheck( value, -1, 1 );
		return super.addArg( "val", value );
	}

	/**
	 * <p>
	 * Set similarity percentage with the key color. Allowed range is from 0 to 1, default value is
	 * <b>0.01</b>.
	 * 
	 * <p>
	 * {@code 0.00001} matches only the exact key color, while 1.0 matches everything.
	 * 
	 * @apiNote (double) similarity
	 * @param value the hsvhold similarity value
	 * @return the {@link HSVHold} instance
	 */
	public HSVHold similarity( double value ) {
		Assert.rangeCheck( value, -1, 1 );
		return super.addArg( "similarity", value );
	}

	/**
	 * <p>
	 * Blend percentage. Allowed range is from 0 to 1, default value is <b>0</b>.
	 * 
	 * <p>
	 * 0.0 makes pixels either fully gray, or not gray at all.
	 * 
	 * <p>
	 * Higher values result in more gray pixels, with a higher gray pixel the more similar the pixels color is
	 * to the key color.
	 * 
	 * @apiNote (double) blend
	 * @param value the hsvhold blend value
	 * @return the {@link HSVHold} instance
	 */
	public HSVHold blend( double value ) {
		Assert.rangeCheck( value, -1, 1 );
		return super.addArg( "blend", value );
	}

}
