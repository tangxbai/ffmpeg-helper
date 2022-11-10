package com.viiyue.ffmpeg.filter.video;

import java.util.LinkedHashMap;
import java.util.Map;

import com.viiyue.ffmpeg.annotation.Function;
import com.viiyue.ffmpeg.common.Const;
import com.viiyue.ffmpeg.enums.ColorMode;
import com.viiyue.ffmpeg.filter.AbstractFunction;
import com.viiyue.ffmpeg.util.Assert;
import com.viiyue.ffmpeg.util.Helper;

/**
 * Adjust video input frames by re-mixing color channels.
 *
 * @author tangxbai
 * @since 2022/06/15
 * @see <a href=
 *      "https://ffmpeg.org/ffmpeg-filters.html#colorchannelmixer">ffmpeg-filters#colorchannelmixer</a>
 */
@Function( "colorchannelmixer" )
public class ColorChannelMixer extends AbstractFunction<ColorChannelMixer> {

	private ColorMode mode;
	private double amount = -1D;
	private final Map<String, String> values;

	// Don't let anyone instantiate this class
	private ColorChannelMixer() {
		this.values = new LinkedHashMap<String, String>();
		this.values.put( "r", "1:1:1:1" );
		this.values.put( "g", "1:1:1:1" );
		this.values.put( "b", "1:1:1:1" );
		this.values.put( "a", "0:0:0:1" );
	}

	/**
	 * Quickly create an instances of {@link ColorChannelMixer}
	 * 
	 * @return the {@link ColorChannelMixer} instance
	 */
	public static final ColorChannelMixer the() {
		return new ColorChannelMixer();
	}

	/**
	 * Adjust contribution of input red, green, blue and alpha channels for output red channel, default is 1
	 * for {@code rr}, and 0 for {@code rg}, {@code rb} and {@code ra}.
	 * 
	 * @apiNote (double) rr/rg/rb/ra
	 * @param red   the red mixing value
	 * @param green the green mixing value
	 * @param blue  the blue mixing value
	 * @param alpha the alpha mixing value
	 * @return the {@link ColorChannelMixer} instance
	 */
	public ColorChannelMixer red( double red, double green, double blue, double alpha ) {
		return adjust( "r", red, green, blue, alpha );
	}

	/**
	 * Adjust contribution of input red, green, blue and alpha channels for output green channel, default is 1
	 * for {@code rr}, and 0 for {@code rg}, {@code rb} and {@code ra}.
	 * 
	 * @apiNote (double) gr/gg/gb/ga
	 * @param red   the red mixing value
	 * @param green the green mixing value
	 * @param blue  the blue mixing value
	 * @param alpha the alpha mixing value
	 * @return the {@link ColorChannelMixer} instance
	 */
	public ColorChannelMixer green( double red, double green, double blue, double alpha ) {
		return adjust( "g", red, green, blue, alpha );
	}

	/**
	 * Adjust contribution of input red, green, blue and alpha channels for output blue channel, default is 1
	 * for {@code rr}, and 0 for {@code rg}, {@code rb} and {@code ra}.
	 * 
	 * @apiNote (double) br/bg/bb/ba
	 * @param red   the red mixing value
	 * @param green the green mixing value
	 * @param blue  the blue mixing value
	 * @param alpha the alpha mixing value
	 * @return the {@link ColorChannelMixer} instance
	 */
	public ColorChannelMixer blue( double red, double green, double blue, double alpha ) {
		return adjust( "b", red, green, blue, alpha );
	}

	/**
	 * Adjust contribution of input red, green, blue and alpha channels for output alpha channel, default is 1
	 * for {@code rr}, and 0 for {@code rg}, {@code rb} and {@code ra}.
	 * 
	 * @apiNote (double) ar/ag/ab/aa
	 * @param red   the red mixing value
	 * @param green the green mixing value
	 * @param blue  the blue mixing value
	 * @param alpha the alpha mixing value
	 * @return the {@link ColorChannelMixer} instance
	 */
	public ColorChannelMixer alpha( double red, double green, double blue, double alpha ) {
		return adjust( "a", red, green, blue, alpha );
	}

	/**
	 * Set preserve color mode
	 * 
	 * @apiNote (flags) mode
	 * @param mode the color mode
	 * @return the {@link ColorChannelMixer} instance
	 * @see ColorMode
	 */
	public ColorChannelMixer mode( ColorMode colorMode ) {
		this.mode = colorMode;
		return this;
	}

	/**
	 * Set the preserve color amount when changing colors, allowed range is from [0.0, 1.0] and default is
	 * 0.0, thus disabled.
	 * 
	 * @apiNote (double) pa
	 * @param amount the color mode
	 * @return the {@link ColorChannelMixer} instance
	 */
	public ColorChannelMixer amount( double colorAmount ) {
		Assert.rangeCheck( colorAmount, 0.0, 1.0 );
		this.amount = colorAmount;
		return this;
	}

	/**
	 * Adjust contribution of input red, green, blue and alpha channels for output given channel.
	 * 
	 * @param color the color abbreviated letter
	 * @param red   the red mixing value
	 * @param green the green mixing value
	 * @param blue  the blue mixing value
	 * @param alpha the alpha mixing value
	 * @return the {@link ColorChannelMixer} instance
	 */
	private ColorChannelMixer adjust( String color, double red, double green, double blue, double alpha ) {
		Assert.rangeCheck( red, -2.0, 2.0 );
		Assert.rangeCheck( green, -2.0, 2.0 );
		Assert.rangeCheck( blue, -2.0, 2.0 );
		Assert.rangeCheck( alpha, -2.0, 2.0 );
		this.values.put( color, Helper.expandAll( Const.PARAMETER_SEPARATOR, red, green, blue, alpha ).toString() );
		return this;
	}

	@Override
	protected String getResult() {
		super.addValues( this.values.values().toArray() );
		if ( mode != null ) {
			super.addValue( mode );
		}
		if ( amount >= 0 ) {
			super.addValue( amount );
		}
		return super.getResult();
	}

}
