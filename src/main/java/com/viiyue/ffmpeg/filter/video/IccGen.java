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
import com.viiyue.ffmpeg.filter.AbstractFunction;

/**
 * Generate ICC profiles and attach them to frames
 *
 * @author tangxbai
 * @since 2022/07/11
 * @see <a href="https://ffmpeg.org/ffmpeg-filters.html#iccgen">ffmpeg-filters#iccgen</a>
 */
@Function( "iccgen" )
public class IccGen extends AbstractFunction<IccGen> {

	// Don't let anyone instantiate this class
	private IccGen() {}

	/**
	 * Quickly create an instances of {@link IccGen}
	 * 
	 * @return the {@link IccGen} instance
	 */
	public static final IccGen of() {
		return new IccGen();
	}

	/**
	 * <p>
	 * Configure the colorspace that the ICC profile will be generated for. The default value of auto infers
	 * the value from the input frame’s metadata, defaulting to BT.709/sRGB as appropriate.
	 * 
	 * <p>
	 * See the setparams filter for a list of possible values, but note that unknown are not valid values for
	 * this filter.
	 * 
	 * @apiNote (string) color_primaries
	 * @param state the string value, maybe {@code null}.
	 * @return the {@link IccGen} instance
	 */
	public IccGen colorPrimaryies( String value ) {
		return super.addArg( "color_primaries", value );
	}

	/**
	 * <p>
	 * Configure the colorspace that the ICC profile will be generated for. The default value of auto infers
	 * the value from the input frame’s metadata, defaulting to BT.709/sRGB as appropriate.
	 * 
	 * <p>
	 * See the setparams filter for a list of possible values, but note that unknown are not valid values for
	 * this filter.
	 * 
	 * @apiNote (string) color_trc
	 * @param value the string value, maybe {@code null}.
	 * @return the {@link IccGen} instance
	 */
	public IccGen colorTrc( String value ) {
		return super.addArg( "color_trc", value );
	}

	/**
	 * If true, an ICC profile will be generated even if it would overwrite an already existing ICC profile.
	 * Disabled by default.
	 * 
	 * @apiNote (boolean) fource
	 * @param state the boolean state
	 * @return the {@link IccGen} instance
	 */
	public IccGen force( boolean state ) {
		return super.addArg( "force", state );
	}

}
