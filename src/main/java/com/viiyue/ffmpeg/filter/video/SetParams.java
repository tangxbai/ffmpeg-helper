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
import com.viiyue.ffmpeg.enums.FieldMode;
import com.viiyue.ffmpeg.filter.AbstractFunction;

/**
 * <p>
 * Force frame parameter for the output video frame.
 * 
 * <p>
 * The {@code setparams} filter marks interlace and color range for the output frames. It does not change the
 * input frame, but only sets the corresponding property, which affects how the frame is treated by
 * filters/encoders.
 * 
 * @author tangxbai
 * @since 2022/08/04
 * @see <a href="https://ffmpeg.org/ffmpeg-filters.html#setparams-1">ffmpeg-filters#setparams</a>
 */
@Function( "setparams" )
public class SetParams extends AbstractFunction<SetParams> {

	// Don't let anyone instantiate this class
	private SetParams() {}

	/**
	 * Quickly create an instances of {@link SetParams}
	 * 
	 * @return the {@link SetParams} instance
	 */
	public static final SetParams of() {
		return new SetParams();
	}

	/**
	 * Select the interlace mode
	 * 
	 * @apiNote (flags) field_mode
	 * @param mode the interlace mode
	 * @return the {@link SetParams} instance
	 */
	public SetParams fieldMode( FieldMode mode ) {
		return super.addArg( "field_mode", mode );
	}

	/**
	 * Select the color range
	 * 
	 * @apiNote (flags) range
	 * @param mode the color range
	 * @return the {@link SetParams} instance
	 */
	public SetParams range( ColorRange range ) {
		return super.addArg( "range", range );
	}

	/**
	 * Specify output color primaries
	 * 
	 * @apiNote (flags) primaries
	 * @param range the output color primaries
	 * @return the {@link SetParams} instance
	 * @see ColorPrimaries
	 */
	public SetParams primaries( ColorPrimaries primaries ) {
		return super.addArg( "color_primaries", primaries );
	}

	/**
	 * Specify output transfer characteristics
	 * 
	 * @apiNote (flags) trc
	 * @param space the output transfer characteristics
	 * @return the {@link SetParams} instance
	 * @see TransferCharacteristics
	 */
	public SetParams transfer( TransferCharacteristics characteristics ) {
		return super.addArg( "color_trc", characteristics );
	}

	/**
	 * Specify output color space
	 * 
	 * @apiNote (flags) space
	 * @param space the color space
	 * @return the {@link SetParams} instance
	 * @see ColorSpaces
	 */
	public SetParams space( ColorSpaces space ) {
		return super.addArg( "colorspace", space );
	}

	/**
	 * Color range
	 *
	 * @author tangxbai
	 * @since 2022/08/04
	 */
	public enum ColorRange implements AbstractEnum {
		/** Keep the same color range property (default) */
		AUTO,

		/** Mark the frame as unspecified color range */
		UNSPECIFIED,
		/** Mark the frame as unspecified color range */
		UNKNOWN,

		/** Mark the frame as limited range */
		LIMITED,
		/** Mark the frame as limited range */
		TV,
		/** Mark the frame as limited range */
		MPEG,

		/** Mark the frame as full range */
		FULL,
		/** Mark the frame as full range */
		PC,
		/** Mark the frame as full range */
		JPEG
	}

	/**
	 * Output color primaries
	 * 
	 * @author tangxbai
	 * @since 2022/08/04
	 */
	public enum ColorPrimaries implements AbstractEnum {
		/** Keep the same color primaries property (default) */
		AUTO,
		/** UNKNOWN */
		UNKNOWN,
		/** Film */
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
		/** SMPTE-428 */
		SMPTE_428,
		/** SMPTE-431 */
		SMPTE_431,
		/** SMPTE-432 */
		SMPTE_432,
		/** JEDEC P22 phosphors */
		JEDEC_P22
	}

	/**
	 * Output transfer characteristics
	 * 
	 * @author tangxbai
	 * @since 2022/08/04
	 */
	public enum TransferCharacteristics implements AbstractEnum {
		/** Keep the same color trc property (default) */
		AUTO,
		/** UNKNOWN */
		UNKNOWN,
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
		/** SMPTE-2084 */
		SMPTE_2084,
		/** SMPTE-428 */
		SMPTE_428,
		/** LINEAR */
		LINEAR,
		/** LOG-100 */
		LOG100,
		/** LOG-316 */
		LOG316,
		/** IEC61966-2-1 */
		IEC61966_2_1,
		/** IEC61966-2-4 */
		IEC61966_2_4,
		/** BT.1361E */
		BT1361E,
		/** ARIB-STD-B67 */
		ARIB_STD_B67
	}

	/**
	 * Output color space
	 * 
	 * @author tangxbai
	 * @since 2022/08/04
	 */
	public enum ColorSpaces implements AbstractEnum {
		AUTO,
		/** GBR */
		GBR,
		/** UNKNOWN */
		UNKNOWN,
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
		/** BT.2020-NC */
		BT2020_NC,
		/** BT.2020-C */
		BT2020_C,
		/** SMPTE-2085 */
		SMPTE_2085,
		/** CHROMA-DERIVED-NC */
		CHROMA_DERIVED_NC,
		/** CHROMA-DERIVED-C */
		CHROMA_DERIVED_C,
		/** ICTCP */
		ICTCP
	}

}
