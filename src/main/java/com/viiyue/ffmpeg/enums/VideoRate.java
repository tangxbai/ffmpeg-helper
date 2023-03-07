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
 * Specify the frame rate of a video, expressed as the number of frames generated per second. It has to be a
 * string in the format frame_rate_num/frame_rate_den, an integer number, a float number or a valid video
 * frame rate abbreviation.
 *
 * @author tangxbai
 * @since 2022/07/07
 */
public enum VideoRate implements AbstractEnum {

	/** Rate: 24/1 */
	FILM( "24/1" ),

	/** Rate: 25/1 */
	PAL( "25/1" ),
	/** Rate: 25/1 */
	QPAL( "25/1" ),
	/** Rate: 25/1 */
	SPAL( "25/1" ),

	/** Rate: 30000/1001 */
	NTSC( "30000/1001" ),
	/** Rate: 30000/1001 */
	QNTSC( "30000/1001" ),
	/** Rate: 30000/1001 */
	SNTSC( "30000/1001" ),
	/** Rate: 24000/1001 */
	NTSC_FILM( "ntsc-film", "24000/1001" );

	private String realName;

	private VideoRate( String expression ) {
		this.realName = getName( null );
	}

	private VideoRate( String realName, String expression ) {
		this.realName = realName;
	}

	@Override
	public String command() {
		return this.realName;
	}

}
