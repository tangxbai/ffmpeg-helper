package com.viiyue.ffmpeg.filter.video;

import com.viiyue.ffmpeg.annotation.Function;
import com.viiyue.ffmpeg.filter.AbstractFunction;
import com.viiyue.ffmpeg.util.Assert;

/**
 * Adjust color temperature in video to simulate variations in ambient color temperature.
 *
 * @author tangxbai
 * @since 2022/06/16
 * @see <a href="https://ffmpeg.org/ffmpeg-filters.html#colortemperature">ffmpeg-filters#colortemperature</a>
 */
@Function( "colortemperature" )
public class ColorTemperature extends AbstractFunction<ColorTemperature> {

	// Don't let anyone instantiate this class
	private ColorTemperature() {}

	/**
	 * Quickly create an instances of {@link ZZZTemplate}
	 * 
	 * @return the {@link ZZZTemplate} instance
	 */
	public static final ColorTemperature set( int value ) {
		return new ColorTemperature().temperature( value );
	}

	/**
	 * Set the temperature in Kelvin, allowed range is from 1000 to 40000, default value is 6500K.
	 * 
	 * @apiNote (int) temperature
	 * @param value the temperature value
	 * @return the {@link ColorTemperature} instance
	 */
	private ColorTemperature temperature( int value ) {
		Assert.rangeCheck( value, 1000, 40000 );
		return super.addArg( "temperature", value );
	}

	/**
	 * Set mixing with filtered output, allowed range is from 0 to 1 and default value is 1.
	 * 
	 * @apiNote (double) mix
	 * @param value the mix value is from 0 to 1
	 * @return the {@link ColorTemperature} instance
	 */
	public ColorTemperature mix( double value ) {
		Assert.rangeCheck( value, 0.0, 1.0 );
		return super.addArg( "mix", value );
	}

	/**
	 * Set the amount of preserving lightness, allowed range is from 0 to 1, default value is 0.
	 * 
	 * @apiNote (double) pl
	 * @param value the similarity value is from 0 to 1
	 * @return the {@link ColorTemperature} instance
	 */
	public ColorTemperature pl( double value ) {
		Assert.rangeCheck( value, 0.0, 1.0 );
		return super.addArg( "pl", value );
	}

}
