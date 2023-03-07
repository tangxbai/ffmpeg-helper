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
import com.viiyue.ffmpeg.util.Assert;

/**
 * Apply the xBR high-quality magnification filter which is designed for pixel art. It follows a set of
 * edge-detection rules, see <a href=
 * "https://forums.libretro.com/t/xbr-algorithm-tutorial/123">https://forums.libretro.com/t/xbr-algorithm-tutorial/123</a>.
 * 
 * @author tangxbai
 * @since 2022/10/19
 * @see <a href= "https://ffmpeg.org/ffmpeg-filters.html#xbr">ffmpeg-filters#xbr</a>
 */
@Function( "xbr" )
public class Xbr extends AbstractFunction<Xbr> {

	// Don't let anyone instantiate this class
	private Xbr() {}

	/**
	 * <p>
	 * Quickly create an instances of {@link Xbr}
	 * 
	 * <p>
	 * Set the scaling dimension: 2 for {@code 2xBR}, 3 for {@code 3xBR} and 4 for {@code 4xBR}. Default is
	 * <b>3</b>.
	 * 
	 * @apiNote (int) n
	 * @param num the scaling dimension
	 * @return the {@link Xbr} instance
	 */
	public static final Xbr of( int num ) {
		Assert.rangeCheck( num, 2, 4 );
		return new Xbr().addArg( "n", num );
	}

}
