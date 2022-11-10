package com.viiyue.ffmpeg.filter.video;

import com.viiyue.ffmpeg.annotation.Function;
import com.viiyue.ffmpeg.common.AbstractEnum;
import com.viiyue.ffmpeg.enums.Color;
import com.viiyue.ffmpeg.filter.AbstractFunction;
import com.viiyue.ffmpeg.util.Assert;

/**
 * <p>
 * Compute and draw a color distribution histogram for the input video across time.
 * 
 * <p>
 * Unlike histogram video filter which only shows histogram of single input frame at certain time, this filter
 * shows also past histograms of number of frames defined by {@code width} option.
 * 
 * <p>
 * The computed histogram is a representation of the color component distribution in an image.
 * 
 * @author tangxbai
 * @since 2022/08/05
 * @see <a href="https://ffmpeg.org/ffmpeg-filters.html#thistogram">ffmpeg-filters#thistogram</a>
 */
@Function( "thistogram" )
public class Thistogram extends AbstractFunction<Thistogram> {

	// Don't let anyone instantiate this class
	private Thistogram() {}

	/**
	 * Quickly create an instances of {@link Thistogram}
	 * 
	 * @return the {@link Thistogram} instance
	 */
	public static final Thistogram of() {
		return new Thistogram();
	}

	/**
	 * Set width of single color component output. Default value is 0. Value of {@code 0} means width will be
	 * picked from input video. This also set number of passed histograms to keep. Allowed range is [0, 8192].
	 * 
	 * @apiNote (int) width, w
	 * @param width the width of single color component output
	 * @return the {@link Thistogram} instance
	 */
	public Thistogram width( int width ) {
		Assert.rangeCheck( width, 0, 8192 );
		return super.addArg( "w", null ); // width, w
	}

	/**
	 * Set display mode
	 * 
	 * @apiNote (flags) display_mode, d
	 * @param mode the specified display mode
	 * @return the {@link Thistogram} instance
	 * @see DisplayMode
	 */
	public Thistogram displayMode( DisplayMode mode ) {
		return super.addArg( "d", mode ); // display_mode, d
	}

	/**
	 * Set levels mode
	 * 
	 * @apiNote (flags) levels_mode, m
	 * @param mode the levels mode
	 * @return the {@link Thistogram} instance
	 * @see LevelsMode
	 */
	public Thistogram levelsMode( LevelsMode mode ) {
		return super.addArg( "m", mode ); // levels_mode, m
	}

	/**
	 * Set what color components to display. Value range is from 1 to 15, default is <b>7</b>.
	 * 
	 * @apiNote (int) components, c
	 * @param value the color components to display
	 * @return the {@link Thistogram} instance
	 */
	public Thistogram components( int value ) {
		Assert.rangeCheck( value, 1, 15 );
		return super.addArg( "c", value ); // components, c
	}

	/**
	 * Set background opacity. Value range is from 0 to 1, default is <b>0.9</b>.
	 * 
	 * @apiNote (int) bgopacity, b
	 * @param value the background opacity
	 * @return the {@link Thistogram} instance
	 */
	public Thistogram bgOpacity( double value ) {
		Assert.rangeCheck( value, 0.0, 1.0 );
		return super.addArg( "b", value ); // bgopacity, b
	}

	/**
	 * Show envelope, default is {@code false} (disabled).
	 * 
	 * @apiNote (boolean) envelope, e
	 * @param value the background opacity
	 * @return the {@link Thistogram} instance
	 */
	public Thistogram envelope() {
		return super.enable( "e" ); // envelope, e
	}

	/**
	 * Set envelope color. Default is <span style="padding:0 5px;background: gold">gold</b>.
	 * 
	 * @apiNote (boolean) ecolor, ec
	 * @param color the envelope color
	 * @return the {@link Thistogram} instance
	 * @see Color
	 */
	public Thistogram envelopeColor( Color color ) {
		return envelopeColor( Color.ifEmpty( color ).command() ); // ecolor, ec
	}

	/**
	 * Set envelope color. Default is <span style="padding:0 5px;background: gold">gold</b>.
	 * 
	 * @apiNote (boolean) ecolor, ec
	 * @param color the envelope color
	 * @return the {@link Thistogram} instance
	 */
	public Thistogram envelopeColor( String color ) {
		return super.addArg( "ec", color ); // ecolor, ec
	}

	/**
	 * Set slide mode
	 * 
	 * @apiNote (flags) slide
	 * @param mode the slide mode
	 * @return the {@link Thistogram} instance
	 * @see SlideMode
	 */
	public Thistogram slide( SlideMode mode ) {
		return super.addArg( "slide", mode );
	}

	/**
	 * Display mode
	 * 
	 * @author tangxbai
	 * @since 2022/06/16
	 */
	public enum DisplayMode implements AbstractEnum {
		/**
		 * Per color component graphs are placed below each other (<b>default</b>)
		 */
		STACK,
		/**
		 * Per color component graphs are placed side by side
		 */
		PARADE,
		/**
		 * Presents information identical to that in the parade, except that the graphs representing color
		 * components are superimposed directly over one another.
		 */
		OVERLAY
	}

	/**
	 * Levels mode
	 * 
	 * @author tangxbai
	 * @since 2022/08/05
	 */
	public enum LevelsMode implements AbstractEnum {
		LINEAR, LOGARITHMIC,
	}

	/**
	 * Slide mode
	 * 
	 * @author tangxbai
	 * @since 2022/08/05
	 */
	public enum SlideMode implements AbstractEnum {
		/** Draw new frame when right border is reached */
		FRAME,
		/** Replace old columns with new ones */
		REPLACE,
		/** Scroll from right to left */
		SCROLL,
		/** Scroll from left to right */
		RSCROLL,
		/** Draw single picture */
		PICTURE
	}

}
