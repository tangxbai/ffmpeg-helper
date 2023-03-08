/**
 * Copyright (C) 2022-2023 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.viiyue.ffmpeg.filter.video;

import com.viiyue.ffmpeg.annotation.Function;
import com.viiyue.ffmpeg.common.AbstractEnum;
import com.viiyue.ffmpeg.enums.AspectRatio;
import com.viiyue.ffmpeg.enums.VideoSize;
import com.viiyue.ffmpeg.enums.When;
import com.viiyue.ffmpeg.filter.AbstractFunction;
import com.viiyue.ffmpeg.util.Assert;

/**
 * <p>
 * Scale (resize) the input video, using the libswscale library.
 * 
 * <p>
 * The scale filter forces the output display aspect ratio to be the same of the input, by changing the output
 * sample aspect ratio.
 * 
 * <p>
 * If the input image format is different from the format requested by the next filter, the scale filter will
 * convert the input to the requested format.
 * 
 * @author tangxbai
 * @since 2022/08/02
 * @see <a href="https://ffmpeg.org/ffmpeg-filters.html#scale">ffmpeg-filters#scale</a>
 */
@Function( "scale" )
public class Scale extends AbstractFunction<Scale> {

	// Don't let anyone instantiate this class
	private Scale() {}

	/**
	 * Quickly create an instances of {@link Scale} and set the width and height of the output video by the
	 * way
	 * 
	 * @apiNote (int) width
	 * @apiNote (int) height
	 * @param width  the output video width dimension
	 * @param height the output video width dimension
	 * @return the {@link Scale} instance
	 */
	public static final Scale to( int width, int height ) {
		return new Scale().addBaseArg( "w", width ).addBaseArg( "h", height );
	}

	/**
	 * <p>
	 * Quickly create an instances of {@link Scale} and set the width and height of the output video by the
	 * way
	 * 
	 * <p>
	 * The values of the {@code width} and {@code width} options are expressions containing the following
	 * constants:
	 * 
	 * <ul>
	 * <li><b>in_w, in_h</b> - the input width and height
	 * <li><b>iw, ih</b> - these are the same as in_w and in_h.
	 * <li><b>out_w, out_h</b> - the output (scaled) width and height
	 * <li><b>ow, oh</b> - these are the same as out_w and out_h
	 * <li><b>a</b> - the same as iw / ih
	 * <li><b>sar</b> - input sample aspect ratio
	 * <li><b>dar</b> - the input display aspect ratio. Calculated from (iw / ih) * sar.
	 * <li><b>hsub, vsub</b> - horizontal and vertical input chroma subsample values. For example for the
	 * pixel format "yuv422p" hsub is 2 and vsub is 1.
	 * <li><b>ohsub, ovsub</b> - horizontal and vertical output chroma subsample values. For example for the
	 * pixel format "yuv422p" hsub is 2 and vsub is 1.
	 * <li><b>n</b> - the (sequential) number of the input frame, starting from 0. Only available with
	 * eval=frame.
	 * <li><b>t</b> - the presentation timestamp of the input frame, expressed as a number of seconds. Only
	 * available with eval=frame.
	 * <li><b>pos</b> - the position (byte offset) of the frame in the input stream, or NaN if this
	 * information is unavailable and/or meaningless (for example in case of synthetic video). Only available
	 * with eval=frame.
	 * </ul>
	 * 
	 * @apiNote (string) width
	 * @apiNote (string) height
	 * @param width  the output video width expression
	 * @param height the output video width expression
	 * @return the {@link Scale} instance
	 */
	public static final Scale to( String width, String height ) {
		return new Scale().addBaseArg( "w", width ).addBaseArg( "h", height );
	}

	/**
	 * Quickly create an instances of {@link Scale} and set the width and height of the output video by the
	 * way
	 * 
	 * @apiNote (flags) size, s
	 * @param s the output video size option
	 * @return the {@link Scale} instance
	 */
	public static final Scale to( VideoSize size ) {
		return new Scale().addArg( "s", size ); // size, s
	}

	/**
	 * Specify when to evaluate width and height expression
	 * 
	 * @apiNote (flags) eval
	 * @param when the expression evaluated timing
	 * @return the {@link Scale} instance
	 */
	public Scale eval( When when ) {
		return super.addArg( "eval", when );
	}

	/**
	 * Set libswscale scaling flags. See
	 * <a href="https://ffmpeg.org/ffmpeg-scaler.html#sws_005fflags">(ffmpeg-scaler)the ffmpeg-scaler
	 * manual</a> for the complete list of values. If not explicitly specified the filter applies the default
	 * flags.
	 * 
	 * @apiNote (string) flags
	 * @param expression the flags to pass to libswscale
	 * @return the {@link Scale} instance
	 */
	public Scale flags( String expression ) {
		return super.addArg( "flags", expression );
	}

	/**
	 * Set whether to interlace
	 * 
	 * @apiNote (boolean) interl
	 * @param expression the flags to pass to libswscale
	 * @return the {@link Scale} instance
	 */
	public Scale interlacing() {
		return super.enable( "interl" );
	}

	/**
	 * Set libswscale input parameters for scaling algorithms that need them. See
	 * (<a href="https://ffmpeg.org/ffmpeg-scaler.html#sws_005fparams">ffmpeg-scaler)the ffmpeg-scaler
	 * manual</a> for the complete documentation. If not explicitly specified the filter applies empty
	 * parameters, default is <b>123456</b>.
	 * 
	 * @apiNote (int) param0
	 * @param value the param0 value
	 * @return the {@link Scale} instance
	 */
	public Scale param0( double value ) {
		return super.addArg( "param0", value );
	}

	/**
	 * Set libswscale input parameters for scaling algorithms that need them. See
	 * (<a href="https://ffmpeg.org/ffmpeg-scaler.html#sws_005fparams">ffmpeg-scaler)the ffmpeg-scaler
	 * manual</a> for the complete documentation. If not explicitly specified the filter applies empty
	 * parameters, default is <b>123456</b>.
	 * 
	 * @apiNote (int) param1
	 * @param value the param1 value
	 * @return the {@link Scale} instance
	 */
	public Scale param1( double value ) {
		return super.addArg( "param1", value );
	}

	/**
	 * <p>
	 * Set input YCbCr color space type.
	 * 
	 * <p>
	 * This allows the autodetected value to be overridden as well as allows forcing a specific value used for
	 * the output and encoder.
	 * 
	 * <p>
	 * If not specified, the color space type depends on the pixel format.
	 * 
	 * @apiNote (flags) in_color_matrix
	 * @param matrix the input color matrix
	 * @return the {@link Scale} instance
	 * @see ColorMatrix
	 */
	public Scale inColorMatrix( ColorMatrix matrix ) {
		return super.addArg( "in_color_matrix", matrix );
	}

	/**
	 * <p>
	 * Set output YCbCr color space type.
	 * 
	 * <p>
	 * This allows the autodetected value to be overridden as well as allows forcing a specific value used for
	 * the output and encoder.
	 * 
	 * <p>
	 * If not specified, the color space type depends on the pixel format.
	 * 
	 * @apiNote (flags) out_color_matrix
	 * @param matrix the output color matrix
	 * @return the {@link Scale} instance
	 * @see ColorMatrix
	 */
	public Scale outColorMatrix( ColorMatrix matrix ) {
		return super.addArg( "out_color_matrix", matrix );
	}

	/**
	 * <p>
	 * Set input YCbCr sample range.
	 * 
	 * <p>
	 * This allows the autodetected value to be overridden as well as allows forcing a specific value used for
	 * the output and encoder. If not specified, the range depends on the pixel format.
	 * 
	 * @apiNote (flags) out_range
	 * @param range the input sample range
	 * @return the {@link Scale} instance
	 */
	public Scale inRange( SampleRange range ) {
		return super.addArg( "in_range", range );
	}

	/**
	 * <p>
	 * Set output YCbCr sample range.
	 * 
	 * <p>
	 * This allows the autodetected value to be overridden as well as allows forcing a specific value used for
	 * the output and encoder. If not specified, the range depends on the pixel format.
	 * 
	 * @apiNote (flags) out_range
	 * @param range the output sample range
	 * @return the {@link Scale} instance
	 */
	public Scale outRange( SampleRange range ) {
		return super.addArg( "out_range", range );
	}

	/**
	 * Enable decreasing or increasing output video width or height if necessary to keep the original aspect
	 * ratio
	 * 
	 * @apiNote (flags) force_original_aspect_ratio
	 * @param ratio the width expression
	 * @return the {@link Scale} instance
	 * @see AspectRatio
	 */
	public Scale forceOrginalAspectRatio( AspectRatio ratio ) {
		return super.addArg( "force_original_aspect_ratio", ratio );
	}

	/**
	 * Enable decreasing or increasing output video width or height if necessary to keep the original aspect
	 * ratio
	 * 
	 * @apiNote (int) force_divisible_by
	 * @param value the divisible value
	 * @return the {@link Scale} instance
	 */
	public Scale forceDivisibleBy( int value ) {
		Assert.rangeCheck( value, 1, 256 );
		return super.addArg( "force_divisible_by", value );
	}

	/**
	 * Color matrix
	 *
	 * @author tangxbai
	 * @since 2022/07/12
	 */
	public enum ColorMatrix implements AbstractEnum {
		AUTO,
		/** FCC */
		FCC,
		/** BT.470 */
		BT470,
		/** BT.601 */
		BT601,
		/** BT.709 */
		BT709,
		/** BT.2020 */
		BT2020,
		/** SMPTE-170M */
		SMPTE170M,
		/** SMPTE-240M */
		SMPTE240M
	}

	/**
	 * Color matrix
	 *
	 * @author tangxbai
	 * @since 2022/07/12
	 */
	public enum SampleRange implements AbstractEnum {
		/** Choose automatically */
		AUTO,
		/** Choose automatically */
		UNKNOWN,

		/** Set full range (0-255 in case of 8-bit luma) */
		JPEG,
		/** Set full range (0-255 in case of 8-bit luma) */
		FULL,
		/** Set full range (0-255 in case of 8-bit luma) */
		PC,

		/** Set "MPEG" range (16-235 in case of 8-bit luma) */
		MPEG,
		/** Set "MPEG" range (16-235 in case of 8-bit luma) */
		LIMITED,
		/** Set "MPEG" range (16-235 in case of 8-bit luma) */
		TV
	}

}
