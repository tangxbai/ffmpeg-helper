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
import com.viiyue.ffmpeg.common.Const;
import com.viiyue.ffmpeg.filter.AbstractColorFunction;
import com.viiyue.ffmpeg.util.Assert;

/**
 * <p>
 * Apply a frei0r effect to the input video.
 * 
 * <p>
 * To enable the compilation of this filter, you need to install the frei0r header and configure FFmpeg with
 * <font color="green">--enable-frei0r</font>.
 * 
 * @author tangxbai
 * @since 2022/07/06
 * @see <a href="https://ffmpeg.org/ffmpeg-filters.html#freior">ffmpeg-filters#freior</a>
 */
@Function( "freior" )
public class FreiOr extends AbstractColorFunction<FreiOr> {

	// Don't let anyone instantiate this class
	private FreiOr() {}

	/**
	 * Quickly create an instances of {@link FreiOr}
	 * 
	 * @return the {@link FreiOr} instance
	 */
	public static final FreiOr of() {
		return new FreiOr();
	}

	/**
	 * The name of the frei0r effect to load. If the environment variable
	 * <font color="green">FREI0R_PATH</font> is defined, the frei0r effect is searched for in each of the
	 * directories specified by the colon-separated list in <font color="green">FREI0R_PATH</font>. Otherwise,
	 * the standard frei0r paths are searched, in this order: HOME/.frei0r-1/lib/, /usr/local/lib/frei0r-1/,
	 * /usr/lib/frei0r-1/.
	 * 
	 * @apiNote (long) first
	 * @param value the first frame to freeze
	 * @return the {@link FreiOr} instance
	 */
	public FreiOr filterName( long value ) {
		Assert.isTrue( value >= 1, "Step value must be greater than or equal to 1" );
		return super.addArg( "filter_name", value );
	}

	/**
	 * A "|"-separated list of parameters to pass to the frei0r effect
	 * 
	 * @apiNote (string) filter_params
	 * @param effects the effect strings
	 * @return the {@link FreiOr} instance
	 */
	public FreiOr filterParams( String ... effects ) {
		return super.addArg2( "filter_params", Const.LIST_SEPARATOR, effects );
	}

}
