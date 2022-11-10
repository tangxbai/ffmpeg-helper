package com.viiyue.ffmpeg.filter.video;

import com.viiyue.ffmpeg.annotation.Function;
import com.viiyue.ffmpeg.common.AbstractEnum;
import com.viiyue.ffmpeg.filter.AbstractFunction;
import com.viiyue.ffmpeg.util.Assert;

/**
 * <p>
 * Use a palette to downsample an input video stream.
 * 
 * <p>
 * The filter takes two inputs: one video stream and a palette. The palette must be a 256 pixels image.
 * 
 * @author tangxbai
 * @since 2022/07/20
 * @see <a href="https://ffmpeg.org/ffmpeg-filters.html#paletteuse">ffmpeg-filters#paletteuse</a>
 */
@Function( "paletteuse" )
public class PaletteUse extends AbstractFunction<PaletteUse> {

	// Don't let anyone instantiate this class
	private PaletteUse() {}

	/**
	 * Quickly create an instances of {@link PaletteUse}
	 * 
	 * @return the {@link PaletteUse} instance
	 */
	public static final PaletteUse of() {
		return new PaletteUse();
	}

	/**
	 * Select dithering mode
	 * 
	 * @apiNote (flags) dither
	 * @param dither the dither mode
	 * @return the {@link PaletteUse} instance
	 * @see Dither
	 */
	public PaletteUse dither( Dither dither ) {
		return super.addArg( "dither", dither );
	}

	/**
	 * <p>
	 * When bayer dithering is selected, this option defines the scale of the pattern (how much the crosshatch
	 * pattern is visible). A low value means more visible pattern for less banding, and higher value means
	 * less visible pattern at the cost of more banding.
	 * 
	 * <p>
	 * The option must be an integer value in the range [0,5], default is <b>2</b>.
	 * 
	 * @apiNote (int) bayer_scale
	 * @param value the bayer dithering scale
	 * @return the {@link PaletteUse} instance
	 */
	public PaletteUse bayerScale( int value ) {
		Assert.rangeCheck( value, 0, 5 );
		return super.addArg( "bayer_scale", value );
	}

	/**
	 * Define the zone to process
	 * 
	 * @apiNote (flags) diff_mode
	 * @param value the frame different mode
	 * @return the {@link PaletteUse} instance
	 */
	public PaletteUse diffMode( DifferentMode mode ) {
		return super.addArg( "diff_mode", mode );
	}

	/**
	 * Take new palette for each output frame
	 * 
	 * @apiNote (boolean) new
	 * @return the {@link PaletteUse} instance
	 */
	public PaletteUse ofNew() {
		return super.enable( "new" );
	}

	/**
	 * <p>
	 * Sets the alpha threshold for transparency. Alpha values above this threshold will be treated as
	 * completely opaque, and values below this threshold will be treated as completely transparent.
	 * 
	 * <p>
	 * The option must be an integer value in the range [0,255], default is <b>128</b>.
	 * 
	 * @apiNote (int) alpha_threshold
	 * @param value the alpha threshold for transparency
	 * @return the {@link PaletteUse} instance
	 */
	public PaletteUse alphaThreshold( int value ) {
		Assert.rangeCheck( value, 0, 255 );
		return super.addArg( "alpha_threshold", value );
	}

	/**
	 * Apply the palette by taking alpha values into account. Only useful with palettes that are containing
	 * multiple colors with alpha components. Setting this will automatically disable 'alpha_treshold'.
	 * 
	 * @apiNote (boolean) use_alpha
	 * @return the {@link PaletteUse} instance
	 */
	public PaletteUse useAlpha() {
		return super.enable( "use_alpha" );
	}

	/**
	 * Save Graphviz graph of the kdtree in specified file
	 * 
	 * @apiNote (string) debug_kdtree
	 * @param path the specified target file
	 * @return the {@link PaletteUse} instance
	 */
	public PaletteUse debugKdtree( String path ) {
		return super.addArg( "debug_kdtree", path );
	}

	/**
	 * Set reverse colormap color search method
	 * 
	 * @apiNote (string) debug_kdtree
	 * @param search the colormap color search method
	 * @return the {@link PaletteUse} instance
	 */
	public PaletteUse colorSearch( ColorSearch search ) {
		return super.addArg( "color_search", search );
	}

	/**
	 * Compute and print mean error
	 * 
	 * @apiNote (boolean) mean_err
	 * @return the {@link PaletteUse} instance
	 */
	public PaletteUse meanError() {
		return super.enable( "mean_err" );
	}

	/**
	 * Test color search accuracy
	 * 
	 * @apiNote (boolean) debug_accuracy
	 * @return the {@link PaletteUse} instance
	 */
	public PaletteUse debugAccuracy() {
		return super.enable( "debug_accuracy" );
	}

	/**
	 * Statistics mode
	 *
	 * @author tangxbai
	 * @since 2022/07/20
	 */
	public enum Dither implements AbstractEnum {
		/** Ordered 8x8 bayer dithering (deterministic) */
		BAYER,
		/**
		 * Dithering as defined by Paul Heckbert in 1982 (simple error diffusion). Note: this dithering is
		 * sometimes considered "wrong" and is included as a reference.
		 */
		HECKBERT,
		/** Floyd and Steingberg dithering (error diffusion) */
		FLOYD_STEINBERG,
		/** Frankie Sierra dithering v2 (error diffusion) */
		SIERRA2,
		/** Frankie Sierra dithering v2 "Lite" (error diffusion) */
		SIERRA2_4A
	}

	/**
	 * Different mode
	 *
	 * @author tangxbai
	 * @since 2022/07/20
	 */
	public enum DifferentMode implements AbstractEnum {
		NONE,
		/**
		 * Only the changing rectangle will be reprocessed. This is similar to GIF cropping/offsetting
		 * compression mechanism. This option can be useful for speed if only a part of the image is changing,
		 * and has use cases such as limiting the scope of the error diffusal dither to the rectangle that
		 * bounds the moving scene (it leads to more deterministic output if the scene doesn’t change much,
		 * and as a result less moving noise and better GIF compression).
		 */
		RECTANGLE
	}

	/**
	 * Reverse colormap color search method
	 *
	 * @author tangxbai
	 * @since 2022/07/20
	 */
	public enum ColorSearch implements AbstractEnum {
		NNS_ITERATIVE, NNS_RECURSIVE, BRUTEFORCE
	}

}
