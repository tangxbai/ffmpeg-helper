package com.viiyue.ffmpeg.filter.video;

import com.viiyue.ffmpeg.annotation.Function;
import com.viiyue.ffmpeg.common.AbstractEnum;
import com.viiyue.ffmpeg.filter.AbstractFunction;
import com.viiyue.ffmpeg.util.Helper;

/**
 * <p>
 * Adjust cyan, magenta, yellow and black (CMYK) to certain ranges of colors (such as "reds", "yellows",
 * "greens", "cyans", ...). The adjustment range is defined by the "purity" of the color (that is, how
 * saturated it already is).
 * 
 * <p>
 * This filter is similar to the Adobe Photoshop Selective Color tool.
 * 
 * @author tangxbai
 * @since 2022/08/03
 * @see <a href="https://ffmpeg.org/ffmpeg-filters.html#selectivecolor">ffmpeg-filters#selectivecolor</a>
 */
@Function( "selectivecolor" )
public class SelectiveColor extends AbstractFunction<SelectiveColor> {

	// Don't let anyone instantiate this class
	private SelectiveColor() {}

	/**
	 * Quickly create an instances of {@link SelectiveColor}
	 * 
	 * @return the {@link SelectiveColor} instance
	 */
	public static final SelectiveColor of() {
		return new SelectiveColor();
	}

	/**
	 * Select color correction method
	 * 
	 * @apiNote (flags) correction_method
	 * @param method the color correction method
	 * @return the {@link SelectiveColor} instance
	 */
	public SelectiveColor correctionMethod( CorrectionMethod method ) {
		return super.addArg( "correction_method", method ); // horizontal, h
	}

	/**
	 * Adjustments for red pixels (pixels where the red component is the maximum)
	 * 
	 * @apiNote (string) reds
	 * @param expression the color pixels
	 * @return the {@link SelectiveColor} instance
	 */
	public SelectiveColor reds( String expression ) {
		return super.addArg( "reds", Helper.escape( expression, true ) );
	}

	/**
	 * Adjustments for yellow pixels (pixels where the blue component is the maximum)
	 * 
	 * @apiNote (string) yellows
	 * @param expression the color pixels
	 * @return the {@link SelectiveColor} instance
	 */
	public SelectiveColor yellows( String expression ) {
		return super.addArg( "yellows", Helper.escape( expression, true ) );
	}

	/**
	 * Adjustments for green pixels (pixels where the green component is the maximum)
	 * 
	 * @apiNote (string) greens
	 * @param expression the color pixels
	 * @return the {@link SelectiveColor} instance
	 */
	public SelectiveColor greens( String expression ) {
		return super.addArg( "greens", Helper.escape( expression, true ) );
	}

	/**
	 * Adjustments for cyan pixels (pixels where the red component is the maximum)
	 * 
	 * @apiNote (string) cyans
	 * @param expression the color pixels
	 * @return the {@link SelectiveColor} instance
	 */
	public SelectiveColor cyans( String expression ) {
		return super.addArg( "cyans", Helper.escape( expression, true ) );
	}

	/**
	 * Adjustments for blue pixels (pixels where the blue component is the maximum)
	 * 
	 * @apiNote (string) blues
	 * @param expression the color pixels
	 * @return the {@link SelectiveColor} instance
	 */
	public SelectiveColor blues( String expression ) {
		return super.addArg( "blues", Helper.escape( expression, true ) );
	}

	/**
	 * Adjustments for magenta pixels (pixels where the green component is the maximum)
	 * 
	 * @apiNote (string) blues
	 * @param expression the color pixels
	 * @return the {@link SelectiveColor} instance
	 */
	public SelectiveColor magentas( String expression ) {
		return super.addArg( "magentas", Helper.escape( expression, true ) );
	}

	/**
	 * Adjustments for white pixels (pixels where the all components are greater than 128)
	 * 
	 * @apiNote (string) whites
	 * @param expression the color pixels
	 * @return the {@link SelectiveColor} instance
	 */
	public SelectiveColor whites( String expression ) {
		return super.addArg( "whites", Helper.escape( expression, true ) );
	}

	/**
	 * Adjustments for all pixels except pure black and pure white
	 * 
	 * @apiNote (string) neutrals
	 * @param expression the color pixels
	 * @return the {@link SelectiveColor} instance
	 */
	public SelectiveColor neutrals( String expression ) {
		return super.addArg( "neutrals", Helper.escape( expression, true ) );
	}

	/**
	 * Adjustments for black pixels (pixels where all components are lesser than 128)
	 * 
	 * @apiNote (string) blacks
	 * @param expression the color pixels
	 * @return the {@link SelectiveColor} instance
	 */
	public SelectiveColor blacks( String expression ) {
		return super.addArg( "blacks", Helper.escape( expression, true ) );
	}

	/**
	 * Specify a Photoshop selective color file (.asv) to import the settings from.
	 * 
	 * @apiNote (string) psfile
	 * @param path the photoshop selectivecolor file name
	 * @return the {@link SelectiveColor} instance
	 */
	public SelectiveColor psfile( String path ) {
		return super.addArg( "psfile", Helper.escape( path, true ) );
	}

	/**
	 * Color correction method
	 *
	 * @author tangxbai
	 * @since 2022/08/03
	 */
	public enum CorrectionMethod implements AbstractEnum {
		/** Specified adjustments are applied "as-is" (added/subtracted to original pixel component value). */
		ABSOLUTE,
		/** Specified adjustments are relative to the original component value */
		RELATIVE
	}

}
