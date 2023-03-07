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
import com.viiyue.ffmpeg.enums.EofAction;
import com.viiyue.ffmpeg.filter.AbstractFunction;
import com.viiyue.ffmpeg.util.Assert;

/**
 * <p>
 * This filter allows to apply main morphological grayscale transforms, erode and dilate with arbitrary
 * structures set in second input stream.
 * 
 * <p>
 * Unlike naive implementation and much slower performance in
 * <a href="https://ffmpeg.org/ffmpeg-filters.html#erosion">erosion</a> and
 * <a href="https://ffmpeg.org/ffmpeg-filters.html#dilation">dilation</a> filters, when speed is critical
 * {@code morpho} filter should be used instead.
 * 
 * @author tangxbai
 * @since 2022/07/19
 * @see <a href="https://ffmpeg.org/ffmpeg-filters.html#morpho">ffmpeg-filters#morpho</a>
 */
@Function( "morpho" )
public class Morpho extends AbstractFunction<Morpho> {

	// Don't let anyone instantiate this class
	private Morpho() {}

	/**
	 * Quickly create an instances of {@link Morpho}
	 * 
	 * @return the {@link Morpho} instance
	 */
	public static final Morpho of() {
		return new Morpho();
	}

	/**
	 * Set morphological transform to apply
	 * 
	 * @apiNote (flags) mode
	 * @param value the morphological transform
	 * @return the {@link Morpho} instance
	 * @see Transform
	 */
	public Morpho mode( Transform transform ) {
		return super.addArg( "mode", transform );
	}

	/**
	 * Set planes to filter. Value range allowed is from 0 to 15, default value is <b>15</b>, all planes will
	 * be processed.
	 * 
	 * @apiNote (int) planes
	 * @param value the plane filter
	 * @return the {@link Morpho} instance
	 */
	public Morpho planes( int value ) {
		Assert.rangeCheck( value, 0, 15 );
		return super.addArg( "planes", value );
	}

	/**
	 * Set which structure video frames will be processed from second input stream, default is
	 * {@link Structure#ALL}.
	 * 
	 * @apiNote (flags) structure
	 * @param value when to process structures
	 * @return the {@link Morpho} instance
	 * @see Structure
	 */
	public Morpho structure( Structure structure ) {
		return super.addArg( "structure", structure );
	}
	
	/**
	 * The action to take when EOF is encountered on the secondary input
	 * 
	 * @apiNote (flags) eof_action
	 * @param action the EOF action
	 * @return the {@link Morpho} instance
	 */
	public Morpho action( EofAction action ) {
		return super.addArg( "eof_action", action );
	}

	/**
	 * If set to {@code true}, force the output to terminate when the shortest input terminates. default value
	 * is {@code false}.
	 * 
	 * @apiNote (boolean) shorttest
	 * @param state the shortest state
	 * @return the {@link Morpho} instance
	 */
	public Morpho shortest( boolean state ) {
		return super.status( "shortest", state );
	}

	/**
	 * If set to true, force the filter to extend the last frame of secondary streams until the end of the
	 * primary stream.
	 * 
	 * @apiNote (boolean) repeatlast
	 * @param state the repeat last state
	 * @return the {@link Morpho} instance
	 */
	public Morpho repeatLast( boolean state ) {
		return super.status( "repeatlast", state );
	}

	/**
	 * When to process structures
	 *
	 * @author tangxbai
	 * @since 2022/07/19
	 */
	public enum Transform implements AbstractEnum {
		ERODE, DILATE, OPEN, CLOSE, GRADIENT, TOPHAT, BLACKHAT
	}

	/**
	 * When to process structures
	 *
	 * @author tangxbai
	 * @since 2022/07/19
	 */
	public enum Structure implements AbstractEnum {
		FIRST, ALL
	}

}
