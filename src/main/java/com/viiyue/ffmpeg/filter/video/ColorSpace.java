package com.viiyue.ffmpeg.filter.video;

import com.viiyue.ffmpeg.annotation.Function;
import com.viiyue.ffmpeg.common.AbstractEnum;
import com.viiyue.ffmpeg.filter.AbstractFunction;

/**
 * Convert colorspace, transfer characteristics or color primaries. Input video needs to have an even size.
 * 
 * @author tangxbai
 * @since 2022/06/15
 * @see <a href="https://ffmpeg.org/ffmpeg-filters.html#colorspace">ffmpeg-filters#colorspace</a>
 */
@Function( "colorspace" )
public class ColorSpace extends AbstractFunction<ColorSpace> {

	// Don't let anyone instantiate this class
	private ColorSpace() {}

	/**
	 * Quickly create an instances of {@link ColorSpace}
	 * 
	 * @return the {@link ColorSpace} instance
	 */
	public static final ColorSpace of() {
		return new ColorSpace();
	}

	/**
	 * Specify all color properties at once.
	 * 
	 * @apiNote (flags) all
	 * @param property the color property
	 * @return the {@link ColorSpace} instance
	 * @see ColorProperty
	 */
	public ColorSpace all( ColorProperty property ) {
		return super.addArg( "all", property );
	}

	/**
	 * Override all input properties at once
	 * 
	 * @apiNote (flags) iall
	 * @param property the color property
	 * @return the {@link ColorSpace} instance
	 * @see ColorProperty
	 */
	public ColorSpace inputAll( ColorProperty property ) {
		return super.addArg( "iall", property );
	}

	/**
	 * Specify output color space
	 * 
	 * @apiNote (flags) space
	 * @param space the color space
	 * @return the {@link ColorSpace} instance
	 * @see ColorSpaces
	 */
	public ColorSpace space( ColorSpaces space ) {
		return super.addArg( "space", space );
	}

	/**
	 * Override input color space
	 * 
	 * @apiNote (flags) ispace
	 * @param space the color space
	 * @return the {@link ColorSpace} instance
	 * @see ColorSpaces
	 */
	public ColorSpace inputSpace( ColorSpaces space ) {
		return super.addArg( "ispace", space );
	}

	/**
	 * Specify output color primaries
	 * 
	 * @apiNote (flags) primaries
	 * @param range the output color primaries
	 * @return the {@link ColorSpace} instance
	 * @see ColorPrimaries
	 */
	public ColorSpace primaries( ColorPrimaries primaries ) {
		return super.addArg( "primaries", primaries );
	}

	/**
	 * Override input color primaries
	 * 
	 * @apiNote (flags) iprimaries
	 * @param range the output color primaries
	 * @return the {@link ColorSpace} instance
	 * @see ColorPrimaries
	 */
	public ColorSpace inputPrimaries( ColorPrimaries primaries ) {
		return super.addArg( "iprimaries", primaries );
	}

	/**
	 * Specify output transfer characteristics
	 * 
	 * @apiNote (flags) trc
	 * @param space the output transfer characteristics
	 * @return the {@link ColorSpace} instance
	 * @see TransferCharacteristics
	 */
	public ColorSpace transfer( TransferCharacteristics characteristics ) {
		return super.addArg( "trc", characteristics );
	}

	/**
	 * Override input transfer characteristics
	 * 
	 * @apiNote (flags) itrc
	 * @param space the output transfer characteristics
	 * @return the {@link ColorSpace} instance
	 * @see TransferCharacteristics
	 */
	public ColorSpace inputTransfer( TransferCharacteristics characteristics ) {
		return super.addArg( "itrc", characteristics );
	}

	/**
	 * Specify output color range
	 * 
	 * @apiNote (flags) range
	 * @param range the output color range
	 * @return the {@link ColorSpace} instance
	 * @see ColorRange
	 */
	public ColorSpace range( ColorRange range ) {
		return super.addArg( "range", range );
	}

	/**
	 * Override input color range
	 * 
	 * @apiNote (flags) irange
	 * @param range the output color range
	 * @return the {@link ColorSpace} instance
	 * @see ColorRange
	 */
	public ColorSpace inputRange( ColorRange range ) {
		return super.addArg( "irange", range );
	}

	/**
	 * Specify output color format
	 * 
	 * @apiNote (flags) format
	 * @param format the output color format
	 * @return the {@link ColorSpace} instance
	 * @see ColorFormat
	 */
	public ColorSpace format( ColorFormat format ) {
		return super.addArg( "format", format );
	}

	/**
	 * Do a fast conversion, which skips gamma/primary correction. This will take significantly less CPU, but
	 * will be mathematically incorrect. To get output compatible with that produced by the colormatrix
	 * filter, use fast=1.
	 * 
	 * @apiNote (boolean) fast
	 * @return the {@link ColorSpace} instance
	 */
	public ColorSpace fast( boolean enable ) {
		return super.status( "fast", enable );
	}

	/**
	 * Specify dithering mode
	 * 
	 * @apiNote (flags) dither
	 * @param dither the dithering mode
	 * @return the {@link ColorSpace} instance
	 * @see Dither
	 */
	public ColorSpace dither( Dither dither ) {
		return super.addArg( "dither", dither );
	}

	/**
	 * White point adaptation mode
	 * 
	 * @apiNote (flags) wpadapt
	 * @param mode the adaptation mode
	 * @return the {@link ColorSpace} instance
	 * @see WhitePointMode
	 */
	public ColorSpace whitePointMode( WhitePointMode mode ) {
		return super.addArg( "wpadapt", mode );
	}

	/**
	 * Color properties
	 * 
	 * @author tangxbai
	 * @since 2022/06/16
	 */
	public enum ColorProperty implements AbstractEnum {
		/** BT.470M */
		BT470M,
		/** BT.470BG */
		BT470BG,
		/** BT.601-6 525 */
		BT601_6_525,
		/** BT.601-6 625 */
		BT601_6_625,
		/** BT.709 */
		BT709,
		/** BT.2020 */
		BT2020,
		/** SMPTE-170M */
		SMPTE_170M,
		/** SMPTE-240M */
		SMPTE_240M
	}

	/**
	 * Output color format
	 * 
	 * @author tangxbai
	 * @since 2022/06/16
	 */
	public enum ColorFormat implements AbstractEnum {
		/** YUV 4:2:0 planar 8-bits */
		YUV_420_P,
		/** YUV 4:2:0 planar 10-bits */
		YUV_420_P_10,
		/** YUV 4:2:0 planar 12-bits */
		YUV_420_P_12,
		/** YUV 4:2:2 planar 8-bits */
		YUV_422_P,
		/** YUV 4:2:0 planar 8-bits */
		YUV_422_P_10,
		/** YUV 4:2:2 planar 10-bits */
		YUV_422_P_12,
		/** YUV 4:2:0 planar 12-bits */
		YUV_444_P,
		/** YUV 4:4:4 planar 10-bits */
		YUV_444_P_10,
		/** YUV 4:4:4 planar 12-bits */
		YUV_444_P_12
	}

	/**
	 * Output color range
	 * 
	 * @author tangxbai
	 * @since 2022/06/16
	 */
	public enum ColorRange implements AbstractEnum {
		/** TV (restricted) range */
		TV,
		/** MPEG (restricted) range */
		MPEG,
		/** PC (full) range */
		PC,
		/** JPEG (full) range */
		JPEG
	}

	/**
	 * Output color primaries
	 * 
	 * @author tangxbai
	 * @since 2022/06/16
	 */
	public enum ColorPrimaries implements AbstractEnum {
		/** film */
		FILM,
		/** BT.709 */
		BT709,
		/** BT.470M */
		BT470_M,
		/** BT.470BG OR BT.601-6 625 */
		BT470_BG,
		/** BT.2020 */
		BT2020,
		/** SMPTE-170M OR BT.601-6 525 */
		SMPTE_170M,
		/** SMPTE-240M */
		SMPTE_240M,
		/** SMPTE-431 */
		SMPTE_431,
		/** SMPTE-432 */
		SMPTE_432,
		/** JEDEC P22 phosphors */
		JEDEC_P22
	}

	/**
	 * Output color space
	 * 
	 * @author tangxbai
	 * @since 2022/06/16
	 */
	public enum ColorSpaces implements AbstractEnum {
		/** FCC */
		FCC,
		/** BT.709 */
		BT709,
		/** BT.470BG OR BT.601-6 625 */
		BT470_BG,
		/** SMPTE-170M OR BT.601-6 525 */
		SMPTE_170M,
		/** SMPTE-240M */
		SMPTE_240M,
		/** YCgCo */
		YCGCO,
		/** BT.2020 with non-constant luminance */
		BT2020_NCL
	}

	/**
	 * Output transfer characteristics
	 * 
	 * @author tangxbai
	 * @since 2022/06/16
	 */
	public enum TransferCharacteristics implements AbstractEnum {
		/** BT.709 */
		BT709,
		/** BT.470M */
		BT470_M,
		/** BT.470BG */
		BT470_BG,
		/** BT.2020 for 10-bits content */
		BT2020_10,
		/** BT.2020 for 12-bits content */
		BT2020_12,
		/** SMPTE-170M, BT.601-6 625 OR BT.601-6 525 */
		SMPTE_170M,
		/** SMPTE-240M */
		SMPTE_240M,
		/** Constant gamma of 2.2 */
		GAMMA_22,
		/** Constant gamma of 2.8 */
		GAMMA_28,
		/** SRGB */
		SRGB,
		/** IEC61966-2-1 */
		IEC61966_2_1,
		/** IEC61966-2-4 */
		IEC61966_2_4,
		/** XVYCC */
		XVYCC
	}

	/**
	 * Dithering mode
	 * 
	 * @author tangxbai
	 * @since 2022/06/16
	 */
	public enum Dither implements AbstractEnum {
		/** No dithering */
		NONE,
		/** Floyd-Steinberg dithering */
		FSB
	}

	/**
	 * Dithering mode
	 * 
	 * @author tangxbai
	 * @since 2022/06/16
	 */
	public enum WhitePointMode implements AbstractEnum {
		/** Bradford whitepoint adaptation */
		BRADFORD,
		/** Von Kries whitepoint adaptation */
		VONKRIES,
		/** Identity whitepoint adaptation (i.e. no whitepoint adaptation) */
		IDENTITY,
	}

}
