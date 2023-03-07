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

import com.viiyue.ffmpeg.annotation.Alias;
import com.viiyue.ffmpeg.annotation.Function;
import com.viiyue.ffmpeg.common.AbstractEnum;
import com.viiyue.ffmpeg.filter.AbstractFunction;
import com.viiyue.ffmpeg.util.Assert;

/**
 * Display CIE color diagram with pixels overlaid onto it.
 *
 * @author tangxbai
 * @since 2022/06/14
 * @see <a href="https://ffmpeg.org/ffmpeg-filters.html#ciescope">ffmpeg-filters#ciescope</a>
 */
@Function( "ciescope" )
public class CieScope extends AbstractFunction<CieScope> {

	// Don't let anyone instantiate this class
	private CieScope() {}

	/**
	 * Quickly create an instances of {@link CieScope}
	 * 
	 * @return the {@link CieScope} instance
	 */
	public static final CieScope the() {
		return new CieScope();
	}

	/**
	 * Set color system
	 * 
	 * @apiNote (flags) system
	 * @param system the color system
	 * @return the {@link CieScope} instance
	 * @see ColorSystem
	 */
	public CieScope colorSystem( ColorSystem system ) {
		return super.addArg( "system", system );
	}

	/**
	 * Set CIE system
	 * 
	 * @apiNote (flags) cie
	 * @param system the cie system
	 * @return the {@link CieScope} instance
	 * @see CIESystem
	 */
	public CieScope cieSystem( CIESystem system ) {
		return super.addArg( "cie", system );
	}

	/**
	 * Set what gamuts to draw
	 * 
	 * @apiNote (flags) gamuts
	 * @param system the color system
	 * @return the {@link CieScope} instance
	 */
	public CieScope gamuts( CIESystem system ) {
		return super.addArg( "gamuts", system );
	}

	/**
	 * Set ciescope size, by default set to 512.
	 * 
	 * @apiNote (int) ciescope, s
	 * @param system the color system
	 * @return the {@link CieScope} instance
	 */
	public CieScope cieScope( int size ) {
		return super.addArg( "s", size ); // ciescope, s
	}

	/**
	 * Set intensity used to map input pixel values to CIE diagram
	 * 
	 * @apiNote (double) intensity, i
	 * @param intensity the map intensity
	 * @return the {@link CieScope} instance
	 */
	public CieScope intensity( double intensity ) {
		Assert.rangeCheck( intensity, 0, 1 );
		return super.addArg( "i", intensity ); // intensity, i
	}

	/**
	 * Set contrast used to draw tongue colors that are out of active color system gamut, value range is from
	 * 0 to 1, default is <b>0.75</b>.
	 * 
	 * @apiNote (double) contrast
	 * @param system the color system
	 * @return the {@link CieScope} instance
	 */
	public CieScope contrast( double contrast ) {
		Assert.rangeCheck( contrast, 0, 1 );
		return super.addArg( "contrast", contrast );
	}

	/**
	 * Correct gamma displayed on scope, by default enabled.
	 * 
	 * @apiNote (boolean) corrgramma
	 * @return the {@link CieScope} instance
	 */
	public CieScope disableGamma() {
		return super.disable( "corrgamma" );
	}

	/**
	 * Show white point on CIE diagram, by default disabled.
	 * 
	 * @apiNote (boolean) showwhite
	 * @return the {@link CieScope} instance
	 */
	public CieScope enableWhitePoint() {
		return super.enable( "showwhite" );
	}

	/**
	 * Set input gamma. Used only with XYZ input color space, value range is from 0.1f to 6f.
	 * 
	 * @apiNote (double) gamma
	 * @param gama the input gamma value
	 * @return the {@link CieScope} instance
	 */
	public CieScope gamma( double gamma ) {
		Assert.rangeCheck( gamma, 0.1, 6 );
		return super.addArg( "gamma", gamma );
	}

	/**
	 * Fill with CIE colors, by default is {@code true} (enabled).
	 * 
	 * @apiNote (boolean) fill
	 * @return the {@link CieScope} instance
	 */
	public CieScope noFill() {
		return super.disable( "fill" );
	}

	/**
	 * Color system
	 *
	 * @author tangxbai
	 * @since 2022/06/14
	 */
	public static enum ColorSystem implements AbstractEnum {
		NTSC, @Alias( "470m" )
		M470, EBU, @Alias( "470bg" )
		BG470, SMPTE, @Alias( "240m" )
		M240, APPLE, @Alias( "widergb" )
		WIDE_RGB, HDTV, @Alias( "cie1931" )
		CIE_1931, REC709, UHDTV, REC2020, DCIP3
	}

	/**
	 * CIE system
	 *
	 * @author tangxbai
	 * @since 2022/06/15
	 */
	public static enum CIESystem implements AbstractEnum {
		XYY, UCS, LUV
	}

}
