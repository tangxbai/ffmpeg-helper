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
package com.viiyue.ffmpeg.enums;

import com.viiyue.ffmpeg.common.AbstractEnum;

/**
 * Specify the size of the sourced video, it may be a string of the form {@code width}x{@code height}, or the
 * name of a size abbreviation.
 *
 * @author tangxbai
 * @since 2022/07/07
 */
public enum VideoSize implements AbstractEnum {

	/** Size: 352x240 */
	FILM( "352x240" ),

	// NTSC series

	/** Size: 720x480 */
	NTSC( "720x480" ),
	/** Size: 352x240 */
	QNTSC( "352x240" ),
	/** Size: 640x480 */
	SNTSC( "640x480" ),

	// PAL series

	/** Size: 720x576 */
	PAL( "720x576" ),
	/** Size: 352x288 */
	QPAL( "352x288" ),
	/** Size: 768x576 */
	SPAL( "768x576" ),

	// CIF series

	/** Size: 352x288 */
	CIF( "352x288" ),
	/** Size: 704x576 */
	CIF4( "704x576" ),
	/** Size: 1408x1152 */
	CIF16( "1408x1152" ),
	/** Size: 128x96 */
	SQCIF( "128x96" ),
	/** Size: 176x144 */
	QCIF( "176x144" ),

	// HD series

	/** Size: 640x360 */
	NHD( "640x360" ),
	/** Size: 960x540 */
	QHD( "960x540" ),
	/** Size: 852x480 */
	HD480( "852x480" ),
	/** Size: 1280x720 */
	HD720( "1280x720" ),
	/** Size: 1920x1080 */
	HD1080( "1920x1080" ),

	// UHD series

	/** Size: 3840x2160 */
	UHD2160( "3840x2160" ),
	/** Size: 7680x4320 */
	UHD4320( "7680x4320" ),

	// GA series

	/** Size: 320x200 */
	CGA( "320x200" ),
	/** Size: 640x350 */
	EGA( "640x350" ),

	// VGA series

	/** Size: 640x480 */
	VGA( "640x480" ),
	/** Size: 320x240 */
	QVGA( "320x240" ),
	/** Size: 480x320 */
	HVGA( "480x320" ),
	/** Size: 800x600 */
	SVGA( "800x600" ),
	/** Size: 852x480 */
	WVGA( "852x480" ),
	/** Size: 160x120 */
	QQVGA( "160x120" ),
	/** Size: 240x160 */
	HQVGA( "240x160" ),
	/** Size: 400x240 */
	WQVGA( "400x240" ),
	/** Size: 432x240 */
	FWQVGA( "432x240" ),

	// XGA series

	/** Size: 1024x768 */
	XGA( "1024x768" ),
	/** Size: 1280x1024 */
	SXGA( "1280x1024" ),
	/** Size: 1366x768 */
	WXGA( "1366x768" ),
	/** Size: 160x120 */
	UXGA( "1600x1200" ),
	/** Size: 1600x1024 */
	WSXGA( "1600x1024" ),
	/** Size: 1920x1200 */
	WUXGA( "1920x1200" ),
	/** Size: 2048x1536 */
	QXGA( "2048x1536" ),
	/** Size: 2560x2048 */
	QSXGA( "2560x2048" ),
	/** Size: 2560x1600 */
	WOXGA( "2560x1600" ),
	/** Size: 3200x2048 */
	WQSXGA( "3200x2048" ),
	/** Size: 3840x2400 */
	WQUXGA( "3840x2400" ),
	/** Size: 5120x4096 */
	HSXGA( "5120x4096" ),
	/** Size: 6400x4096 */
	WHSXGA( "6400x4096" ),
	/** Size: 7680x4800 */
	WHUXGA( "7680x4800" ),

	// 2K series

	/** Size: 2K( 2048x1080 ) */
	TWO_K( "2k", "2048x1080" ),
	/** Size: 2K-FLAT( 1998x1080 ) */
	TWO_K_FLAT( "2kflat", "1998x1080" ),
	/** Size: 2K-SCOPE( 2048x858 ) */
	TWO_K_SCOPE( "2kscope", "2048x858" ),
	/** Size: 2K-DCI( 2048x1080 ) */
	TWO_K_DCI( "2kdci", "2048x1080" ),

	// 4K series

	/** Size: 4K( 4096x2160 ) */
	FOUR_K( "4k", "4096x2160" ),
	/** Size: 4K-FLAT( 3996x2160 ) */
	FOUR_K_FLAT( "4kflat", "3996x2160" ),
	/** Size: 4K-SCOPE( 4096x1716 ) */
	FOUR_K_SCOPE( "4kscope", "4096x1716" ),
	/** Size: 4K-DCI( 4096x2160 ) */
	FOUR_K_DCI( "4kdci", "4096x2160" );

	private String realName;

	private VideoSize( String size ) {
		this.realName = getName( null );
	}

	private VideoSize( String realName, String size ) {
		this.realName = realName;
	}

	@Override
	public String command() {
		return this.realName;
	}

}
