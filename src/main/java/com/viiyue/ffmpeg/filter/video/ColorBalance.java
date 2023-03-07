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
 * <p>
 * Modify intensity of primary colors (red, green and blue) of input frames.
 * 
 * <p>
 * The filter allows an input frame to be adjusted in the shadows, midtones or highlights regions for the
 * red-cyan, green-magenta or blue-yellow balance.
 * 
 * <p>
 * A positive adjustment value shifts the balance towards the primary color, a negative value towards the
 * complementary color.
 *
 * @author tangxbai
 * @since 2022/06/15
 * @see <a href="https://ffmpeg.org/ffmpeg-filters.html#colorbalance">ffmpeg-filters#colorbalance</a>
 */
@Function( "colorbalance" )
public class ColorBalance extends AbstractFunction<ColorBalance> {

	// Don't let anyone instantiate this class
	private ColorBalance() {}

	/**
	 * Quickly create an instances of {@link ColorBalance}
	 * 
	 * @return the {@link ColorBalance} instance
	 */
	public static final ColorBalance the() {
		return new ColorBalance();
	}

	/**
	 * Adjust red shadow darkest pixels
	 * 
	 * @apiNote (double) rs
	 * @param red the red shadow darkest pixel
	 * @return the {@link ColorBalance} instance
	 */
	public ColorBalance redShadow( double pixels ) {
		return super.addArg( "rs", check( pixels ) );
	}

	/**
	 * Adjust green shadow darkest pixels
	 * 
	 * @apiNote (double) gs
	 * @param red the green shadow darkest pixel
	 * @return the {@link ColorBalance} instance
	 */
	public ColorBalance greenShadow( double pixels ) {
		return super.addArg( "gs", check( pixels ) );
	}

	/**
	 * Adjust blue shadow darkest pixels
	 * 
	 * @apiNote (double) bs
	 * @param pixels the blue shadow darkest pixel
	 * @return the {@link ColorBalance} instance
	 */
	public ColorBalance blueShadow( double pixels ) {
		return super.addArg( "bs", check( pixels ) );
	}

	/**
	 * Adjust red, green and blue shadows (darkest pixels).
	 * 
	 * @apiNote (double) rs/gs/bs
	 * @param red   the red shadow darkest pixel
	 * @param green the green shadow darkest pixel
	 * @param blue  the blue shadow darkest pixel
	 * @return the {@link ColorBalance} instance
	 */
	public ColorBalance shadows( double red, double green, double blue ) {
		this.redShadow( red );
		this.greenShadow( green );
		this.blueShadow( blue );
		return this;
	}

	/**
	 * Adjust red midtones (medium pixels)
	 * 
	 * @apiNote (double) rm
	 * @param pixels the blue shadow darkest pixel
	 * @return the {@link ColorBalance} instance
	 */
	public ColorBalance redMidtone( double pixels ) {
		return super.addArg( "rm", check( pixels ) );
	}

	/**
	 * Adjust green midtones (medium pixels)
	 * 
	 * @apiNote (double) gm
	 * @param pixels the green shadow darkest pixel
	 * @return the {@link ColorBalance} instance
	 */
	public ColorBalance greenMidtone( double pixels ) {
		return super.addArg( "gm", check( pixels ) );
	}

	/**
	 * Adjust blue midtones (medium pixels)
	 * 
	 * @apiNote (double) bm
	 * @param pixels the blue shadow darkest pixel
	 * @return the {@link ColorBalance} instance
	 */
	public ColorBalance blueMidtone( double pixels ) {
		return super.addArg( "bm", check( pixels ) );
	}

	/**
	 * Adjust red, green and blue midtones (medium pixels).
	 * 
	 * @apiNote (double) rm/gm/bm
	 * @param red   the red shadow darkest pixel
	 * @param green the green shadow darkest pixel
	 * @param blue  the blue shadow darkest pixel
	 * @return the {@link ColorBalance} instance
	 */
	public ColorBalance midtones( double red, double green, double blue ) {
		this.redMidtone( red );
		this.greenMidtone( green );
		this.blueMidtone( blue );
		return this;
	}

	/**
	 * Adjust red highlights (brightest pixels).
	 * 
	 * @apiNote (double) rh
	 * @param pixels the red highlights brightest pixel
	 * @return the {@link ColorBalance} instance
	 */
	public ColorBalance redHighlight( double pixels ) {
		return super.addArg( "rh", check( pixels ) );
	}

	/**
	 * Adjust green highlights (brightest pixels).
	 * 
	 * @apiNote (double) gh
	 * @param pixels the green highlights brightest pixel
	 * @return the {@link ColorBalance} instance
	 */
	public ColorBalance greenHighlight( double pixels ) {
		return super.addArg( "gh", check( pixels ) );
	}

	/**
	 * Adjust blue highlights (brightest pixels).
	 * 
	 * @apiNote (double) bh
	 * @param pixels the blue highlights brightest pixel
	 * @return the {@link ColorBalance} instance
	 */
	public ColorBalance blueHighlight( double pixels ) {
		return super.addArg( "bh", check( pixels ) );
	}

	/**
	 * Adjust red, green and blue highlights (brightest pixels).
	 * 
	 * @apiNote (double) rh/gh/bh
	 * @param red   the red highlights brightest pixel
	 * @param green the green highlights brightest pixel
	 * @param blue  the blue highlights brightest pixel
	 * @return the {@link ColorBalance} instance
	 */
	public ColorBalance highlights( double red, double green, double blue ) {
		this.redHighlight( red );
		this.greenHighlight( green );
		this.blueHighlight( blue );
		return this;
	}

	/**
	 * Preserve lightness when changing color balance. Default is disabled.
	 * 
	 * @apiNote (boolean) pl
	 * @param pixels the blue highlights brightest pixel
	 * @return the {@link ColorBalance} instance
	 */
	public ColorBalance preserveLightness() {
		return super.enable( "pl" );
	}

	/**
	 * Check if input value is in range
	 * 
	 * @param input the input value that need range checking
	 * @return the original input
	 */
	private double check( double input ) {
		Assert.rangeCheck( input, -1.0, 1.0 );
		return input;
	}

}
