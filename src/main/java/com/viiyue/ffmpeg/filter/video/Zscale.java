package com.viiyue.ffmpeg.filter.video;

import com.viiyue.ffmpeg.annotation.Alias;
import com.viiyue.ffmpeg.annotation.Function;
import com.viiyue.ffmpeg.common.AbstractEnum;
import com.viiyue.ffmpeg.enums.VideoSize;
import com.viiyue.ffmpeg.filter.AbstractFunction;

/**
 * <p>
 * Scale (resize) the input video, using the z.lib library:
 * <a href="https://github.com/sekrit-twc/zimg">https://github.com/sekrit-twc/zimg</a>. To enable compilation
 * of this filter, you need to configure FFmpeg with <code>--enable-libzimg</code>.
 * 
 * <p>
 * The zscale filter forces the output display aspect ratio to be the same as the input, by changing the
 * output sample aspect ratio.
 * 
 * <p>
 * If the input image format is different from the format requested by the next filter, the zscale filter will
 * convert the input to the requested format.
 * 
 * @author tangxbai
 * @since 2022/12/21
 * @see <a href="https://ffmpeg.org/ffmpeg-filters.html#zscale-1">ffmpeg-filters#zscale-z</a>
 */
@Function( "zscale" )
public class Zscale extends AbstractFunction<Zscale> {

	// Don't let anyone instantiate this class
	private Zscale() {}

	/**
	 * Quickly create an instances of {@link Zscale}
	 * 
	 * @return the {@link Zscale} instance
	 */
	public static final Zscale of() {
		return new Zscale();
	}

	/**
	 * Set the output video dimension
	 * 
	 * @apiNote (double) width, w
	 * @param size the video output width
	 * @return the {@link Zscale} instance
	 */
	public Zscale width( double width ) {
		return super.addArg( "w", width ); // width, w
	}

	/**
	 * <p>
	 * Set the output video dimension expression. Default value is the input dimension.
	 * 
	 * <p>
	 * If the width or w value is 0, the input width is used for the output. If the height or h value is 0,
	 * the input height is used for the output.
	 * 
	 * <p>
	 * If one and only one of the values is -n with n >= 1, the zscale filter will use a value that maintains
	 * the aspect ratio of the input image, calculated from the other specified dimension. After that it will,
	 * however, make sure that the calculated dimension is divisible by n and adjust the value if necessary.
	 * 
	 * <p>
	 * If both values are -n with n >= 1, the behavior will be identical to both values being set to 0 as
	 * previously detailed.
	 * 
	 * <p>
	 * See below for the list of accepted constants for use in the dimension expression.
	 * 
	 * <p>
	 * The values of the w and h options are expressions containing the following constants:
	 * <ul>
	 * <li><b>in_w, in_h</b> - The input width and height
	 * <li><b>iw ih</b> - These are the same as in_w and in_h.
	 * <li><b>out_w, out_h</b> - The output (scaled) width and height
	 * <li><b>ow, oh</b> - These are the same as out_w and out_h
	 * <li><b>a</b> - The same as iw / ih
	 * <li><b>sar</b> - input sample aspect ratio
	 * <li><b>dar</b> - The input display aspect ratio. Calculated from (iw / ih) * sar.
	 * <li><b>hsub, vsub</b> - horizontal and vertical input chroma subsample values. For example for the
	 * pixel format "yuv422p" hsub is 2 and vsub is 1.
	 * <li><b>ohsub, ovsub</b> - horizontal and vertical output chroma subsample values. For example for the
	 * pixel format "yuv422p" hsub is 2 and vsub is 1.
	 * </ul>
	 * 
	 * @apiNote (string) width, w
	 * @param size the video output width
	 * @return the {@link Zscale} instance
	 */
	public Zscale width( String width ) {
		return super.addArg( "w", width ); // width, w
	}

	/**
	 * Set the output video dimension
	 * 
	 * @apiNote (double) height, h
	 * @param size the video output height
	 * @return the {@link Zscale} instance
	 */
	public Zscale height( double height ) {
		return super.addArg( "h", height ); // height, h
	}

	/**
	 * <p>
	 * Set the output video dimension expression. Default value is the input dimension.
	 * 
	 * <p>
	 * If the width or w value is 0, the input width is used for the output. If the height or h value is 0,
	 * the input height is used for the output.
	 * 
	 * <p>
	 * If one and only one of the values is -n with n >= 1, the zscale filter will use a value that maintains
	 * the aspect ratio of the input image, calculated from the other specified dimension. After that it will,
	 * however, make sure that the calculated dimension is divisible by n and adjust the value if necessary.
	 * 
	 * <p>
	 * If both values are -n with n >= 1, the behavior will be identical to both values being set to 0 as
	 * previously detailed.
	 * 
	 * <p>
	 * See below for the list of accepted constants for use in the dimension expression.
	 * 
	 * <p>
	 * The values of the w and h options are expressions containing the following constants:
	 * <ul>
	 * <li><b>in_w, in_h</b> - The input width and height
	 * <li><b>iw ih</b> - These are the same as in_w and in_h.
	 * <li><b>out_w, out_h</b> - The output (scaled) width and height
	 * <li><b>ow, oh</b> - These are the same as out_w and out_h
	 * <li><b>a</b> - The same as iw / ih
	 * <li><b>sar</b> - input sample aspect ratio
	 * <li><b>dar</b> - The input display aspect ratio. Calculated from (iw / ih) * sar.
	 * <li><b>hsub, vsub</b> - horizontal and vertical input chroma subsample values. For example for the
	 * pixel format "yuv422p" hsub is 2 and vsub is 1.
	 * <li><b>ohsub, ovsub</b> - horizontal and vertical output chroma subsample values. For example for the
	 * pixel format "yuv422p" hsub is 2 and vsub is 1.
	 * </ul>
	 * 
	 * @apiNote (string) height, h
	 * @param size the video output width
	 * @return the {@link Zscale} instance
	 */
	public Zscale height( String height ) {
		return super.addArg( "h", height ); // height, h
	}

	/**
	 * Set the video size. For the syntax of this option, check the
	 * <a href="https://ffmpeg.org/ffmpeg-utils.html#video-size-syntax">(ffmpeg-utils)"Video size" section in
	 * the ffmpeg-utils manual</a>.
	 * 
	 * @apiNote (flags) size, s
	 * @param size the video size flag
	 * @return the {@link Zscale} instance
	 */
	public Zscale size( VideoSize size ) {
		return super.addArg( "s", size ); // size, s
	}

	/**
	 * Set the dither type
	 * 
	 * @apiNote (flags) dither, d
	 * @param dither the dither type
	 * @return the {@link Zscale} instance
	 */
	public Zscale dither( Dither dither ) {
		return super.addArg( "d", dither ); // dither, d
	}

	/**
	 * Set the resize filter type
	 * 
	 * @apiNote (flags) filter, f
	 * @param dither the resize filter type
	 * @return the {@link Zscale} instance
	 */
	public Zscale filter( Filter filter ) {
		return super.addArg( "f", filter ); // filter, f
	}

	/**
	 * Set the color range
	 * 
	 * @apiNote (flags) range, r
	 * @param dither the color range
	 * @return the {@link Zscale} instance
	 */
	public Zscale range( Range range ) {
		return super.addArg( "r", range ); // range, r
	}

	/**
	 * Set the input color range
	 * 
	 * @apiNote (flags) rangein, rin
	 * @param dither the input color range
	 * @return the {@link Zscale} instance
	 */
	public Zscale rangeIn( Range range ) {
		return super.addArg( "rin", range ); // rangein, rin
	}

	/**
	 * Set the color primaries
	 * 
	 * @apiNote (flags) primaries, p
	 * @param dither the color primaries
	 * @return the {@link Zscale} instance
	 */
	public Zscale primaries( Primaries primaries ) {
		return super.addArg( "p", primaries ); // primaries, p
	}

	/**
	 * Set the color primaries
	 * 
	 * @apiNote (flags) primaries, p
	 * @param dither the color primaries
	 * @return the {@link Zscale} instance
	 */
	public Zscale primariesIn( Primaries primaries ) {
		return super.addArg( "pin", primaries ); // primariesin, pin
	}

	/**
	 * Set the transfer characteristics
	 * 
	 * @apiNote (flags) transfer, t
	 * @param dither the transfer characteristics
	 * @return the {@link Zscale} instance
	 */
	public Zscale transfer( Transfer transfer ) {
		return super.addArg( "t", transfer ); // transfer, t
	}

	/**
	 * Set the input transfer characteristics
	 * 
	 * @apiNote (flags) transferin, tin
	 * @param dither the input transfer characteristics
	 * @return the {@link Zscale} instance
	 */
	public Zscale transferIn( Transfer transfer ) {
		return super.addArg( "tin", transfer ); // transferin, tin
	}

	/**
	 * Set the colorspace matrix
	 * 
	 * @apiNote (flags) matrix, m
	 * @param dither the colorspace matrix
	 * @return the {@link Zscale} instance
	 */
	public Zscale matrix( Matrix matrix ) {
		return super.addArg( "m", matrix ); // matrix, m
	}

	/**
	 * Set the input colorspace matrix
	 * 
	 * @apiNote (flags) matrixin, min
	 * @param dither the input colorspace matrix
	 * @return the {@link Zscale} instance
	 */
	public Zscale matrixIn( Matrix matrix ) {
		return super.addArg( "min", matrix ); // matrixin, min
	}

	/**
	 * Set the output chroma location
	 * 
	 * @apiNote (flags) chromal, c
	 * @param dither the output chroma location
	 * @return the {@link Zscale} instance
	 */
	public Zscale chromal( Chroma chroma ) {
		return super.addArg( "c", chroma ); // chromal, c
	}

	/**
	 * Set the input chroma location
	 * 
	 * @apiNote (flags) chromalin, cin
	 * @param dither the input chroma location
	 * @return the {@link Zscale} instance
	 */
	public Zscale chromalIn( Chroma chroma ) {
		return super.addArg( "cin", chroma ); // chromalin, cin
	}

	/**
	 * Set the nominal peak luminance
	 * 
	 * @apiNote (double) npl
	 * @param value the nominal peak luminance value
	 * @return the {@link Zscale} instance
	 */
	public Zscale npl( double value ) {
		return super.addArg( "npl", value );
	}

	/**
	 * Allow approximate gamma, default is {@code true}.
	 * 
	 * @apiNote (boolean) agamma
	 * @param state the approximate gamma state
	 * @return the {@link Zscale} instance
	 */
	public Zscale agamma( boolean state ) {
		return super.status( "agamma", state );
	}

	/**
	 * Parameter A for scaling filters. Parameter "b" for bicubic, and the number of filter taps for lanczos.
	 * 
	 * @apiNote (double) param_a
	 * @param value the scaling filters parameter
	 * @return the {@link Zscale} instance
	 */
	public Zscale paramA( double value ) {
		return super.addArg( "param_a", value );
	}

	/**
	 * Parameter B for scaling filters. Parameter "c" for bicubic.
	 * 
	 * @apiNote (double) param_b
	 * @param value the scaling filters parameter
	 * @return the {@link Zscale} instance
	 */
	public Zscale paramB( double value ) {
		return super.addArg( "param_b", value );
	}

	/**
	 * Dither type
	 * 
	 * @author tangxbai
	 * @since 2022/12/21
	 */
	public enum Dither implements AbstractEnum {
		NONE, ORDERED, RANDOM, ERROR_DIFFUSION
	}

	/**
	 * Resize filter type
	 * 
	 * @author tangxbai
	 * @since 2022/12/21
	 */
	public enum Filter implements AbstractEnum {
		POINT, BILINEAR, BICUBIC, SPLINE16, SPLINE36, LANCZOS
	}

	/**
	 * Color range
	 * 
	 * @author tangxbai
	 * @since 2022/12/21
	 */
	public enum Range implements AbstractEnum {
		INPUT, LIMITED, FULL
	}

	/**
	 * Color primaries
	 * 
	 * @author tangxbai
	 * @since 2022/12/21
	 */
	public enum Primaries implements AbstractEnum {
		INPUT, @Alias( "709" )
		_709, UNSPECIFIED, @Alias( "170m" )
		_170M, @Alias( "240m" )
		_240M, @Alias( "2020" )
		_2020
	}

	/**
	 * Transfer characteristics
	 * 
	 * @author tangxbai
	 * @since 2022/12/21
	 */
	public enum Transfer implements AbstractEnum {
		INPUT, @Alias( "709" )
		_709, UNSPECIFIED, @Alias( "601" )
		_601, LINEAR, @Alias( "2020_10" )
		_2020_10, @Alias( "2020_12" )
		_2020_12, SMPTE2084, @Alias( "iec61966-2-1" )
		IEC61966_2_1, @Alias( "arib-std-b67" )
		ARIB_STD_B67
	}

	/**
	 * Input transfer characteristics
	 * 
	 * @author tangxbai
	 * @since 2022/12/22
	 */
	public enum TransferIn implements AbstractEnum {
		INPUT, @Alias( "709" )
		_709, UNSPECIFIED, @Alias( "601" )
		_601, LINEAR, @Alias( "2020_10" )
		_2020_10, @Alias( "2020_12" )
		_2020_12
	}

	/**
	 * Colorspace matrix
	 * 
	 * @author tangxbai
	 * @since 2022/12/21
	 */
	public enum Matrix implements AbstractEnum {
		INPUT, @Alias( "709" )
		_709, UNSPECIFIED, @Alias( "470bg" )
		_470BG, @Alias( "170m" )
		_170M, @Alias( "2020_ncl" )
		_2020_NCL, @Alias( "2020_cl" )
		_2020_CL
	}

	/**
	 * Output chroma location
	 * 
	 * @author tangxbai
	 * @since 2022/12/22
	 */
	public enum Chroma implements AbstractEnum {
		INPUT, LEFT, CENTER, @Alias( "topleft" )
		TOP_LEFT, TOP, @Alias( "bottomleft" )
		BOTTOM_LEFT, BOTTOM
	}

}
