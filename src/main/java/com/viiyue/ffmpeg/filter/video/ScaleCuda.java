package com.viiyue.ffmpeg.filter.video;

import com.viiyue.ffmpeg.annotation.Function;
import com.viiyue.ffmpeg.common.AbstractEnum;
import com.viiyue.ffmpeg.enums.AspectRatio;
import com.viiyue.ffmpeg.enums.PixelFormat;
import com.viiyue.ffmpeg.enums.VideoSize;
import com.viiyue.ffmpeg.filter.AbstractFunction;
import com.viiyue.ffmpeg.util.Assert;

/**
 * Scale (resize) and convert (pixel format) the input video, using accelerated CUDA kernels. Setting the
 * output width and height works in the same way as for the {@link Scale} filter.
 * 
 * @author tangxbai
 * @since 2022/08/03
 * @see <a href="https://ffmpeg.org/ffmpeg-filters.html#scale_005fcuda">ffmpeg-filters#scale_cuda</a>
 */
@Function( "scale_cuda" )
public class ScaleCuda extends AbstractFunction<ScaleCuda> {

	// Don't let anyone instantiate this class
	private ScaleCuda() {}

	/**
	 * Quickly create an instances of {@link ScaleCuda} and set the width and height of the output video by
	 * the way
	 * 
	 * @apiNote (int) width
	 * @apiNote (int) height
	 * @param width  the output video width dimension
	 * @param height the output video width dimension
	 * @return the {@link ScaleCuda} instance
	 */
	public static final ScaleCuda to( int width, int height ) {
		return new ScaleCuda().addArg( "w", width ).addArg( "h", height );
	}

	/**
	 * <p>
	 * Quickly create an instances of {@link ScaleCuda} and set the width and height of the output video by
	 * the way
	 * 
	 * <p>
	 * The values of the {@code width} and {@code width} options are expressions containing the following
	 * constants:
	 * 
	 * <ul>
	 * <li><b>in_w, in_h</b> - the input width and height
	 * 
	 * <li><b>iw, ih</b> - these are the same as in_w and in_h.
	 * 
	 * <li><b>out_w, out_h</b> - the output (scaled) width and height
	 * 
	 * <li><b>ow, oh</b> - these are the same as out_w and out_h
	 * 
	 * <li><b>a</b> - the same as iw / ih
	 * 
	 * <li><b>sar</b> - input sample aspect ratio
	 * 
	 * <li><b>dar</b> - the input display aspect ratio. Calculated from (iw / ih) * sar.
	 * 
	 * <li><b>hsub, vsub</b> - horizontal and vertical input chroma subsample values. For example for the
	 * pixel format "yuv422p" hsub is 2 and vsub is 1.
	 * 
	 * <li><b>ohsub, ovsub</b> - horizontal and vertical output chroma subsample values. For example for the
	 * pixel format "yuv422p" hsub is 2 and vsub is 1.
	 * 
	 * <li><b>n</b> - the (sequential) number of the input frame, starting from 0. Only available with
	 * eval=frame.
	 * 
	 * <li><b>t</b> - the presentation timestamp of the input frame, expressed as a number of seconds. Only
	 * available with eval=frame.
	 * 
	 * <li><b>pos</b> - the position (byte offset) of the frame in the input stream, or NaN if this
	 * information is unavailable and/or meaningless (for example in case of synthetic video). Only available
	 * with eval=frame.
	 * </ul>
	 * 
	 * @apiNote (string) width
	 * @apiNote (string) height
	 * @param width  the output video width expression
	 * @param height the output video width expression
	 * @return the {@link ScaleCuda} instance
	 */
	public static final ScaleCuda to( String width, String height ) {
		return new ScaleCuda().addArg( "w", width ).addArg( "h", height );
	}

	/**
	 * Quickly create an instances of {@link ScaleCuda} and set the width and height of the output video by
	 * the way
	 * 
	 * @apiNote (flags) size, s
	 * @param s the output video size option
	 * @return the {@link ScaleCuda} instance
	 */
	public static final ScaleCuda to( VideoSize size ) {
		return new ScaleCuda().addArg( "s", size ); // size, s
	}

	/**
	 * Sets the algorithm used for scaling
	 * 
	 * @apiNote (flags) interp_algo
	 * @param algorithm the scaling algorithm
	 * @return the {@link ScaleCuda} instance
	 */
	public ScaleCuda interpAlgorithm( InterpAlgorithm algorithm ) {
		return super.addArg( "interp_algo", algorithm );
	}

	/**
	 * <p>
	 * Controls the output pixel format. By default, or if none is specified, the input pixel format is used.
	 * 
	 * <p>
	 * The filter does not support converting between YUV and RGB pixel formats.
	 * 
	 * @apiNote (flags) format
	 * @param format the output pixel format
	 * @return the {@link ScaleCuda} instance
	 */
	public ScaleCuda format( PixelFormat format ) {
		return super.addArg( "format", format );
	}

	/**
	 * <p>
	 * If set to {@code false}, every frame is processed, even if no conversion is neccesary. This mode can be
	 * useful to use the filter as a buffer for a downstream frame-consumer that exhausts the limited decoder
	 * frame pool.
	 * 
	 * <p>
	 * If set to {@code true}, frames are passed through as-is if they match the desired output parameters.
	 * This is the default behaviour.
	 * 
	 * @apiNote (boolean) passthrough
	 * @return the {@link ScaleCuda} instance
	 */
	public ScaleCuda passthrough() {
		return super.enable( "passthrough" );
	}

	/**
	 * Algorithm-Specific parameter. Affects the curves of the bicubic algorithm.
	 * 
	 * @apiNote (int) param
	 * @param value the param value
	 * @return the {@link ScaleCuda} instance
	 */
	public ScaleCuda param( double value ) {
		return super.addArg( "param", value );
	}

	/**
	 * Enable decreasing or increasing output video width or height if necessary to keep the original aspect
	 * ratio
	 * 
	 * @apiNote (flags) force_original_aspect_ratio
	 * @param ratio the width expression
	 * @return the {@link ScaleCuda} instance
	 * @see AspectRatio
	 */
	public ScaleCuda forceOrginalAspectRatio( AspectRatio ratio ) {
		return super.addArg( "force_original_aspect_ratio", ratio );
	}

	/**
	 * Enable decreasing or increasing output video width or height if necessary to keep the original aspect
	 * ratio
	 * 
	 * @apiNote (int) force_divisible_by
	 * @param value the divisible value
	 * @return the {@link ScaleCuda} instance
	 */
	public ScaleCuda forceDivisibleBy( int value ) {
		Assert.rangeCheck( value, 1, 256 );
		return super.addArg( "force_divisible_by", value );
	}

	/**
	 * Interpolation algorithm used for resizing
	 *
	 * @author tangxbai
	 * @since 2022/08/03
	 */
	public enum InterpAlgorithm implements AbstractEnum {
		NEAREST, BILINEAR, BICUBIC, LANCZOS
	}

}
