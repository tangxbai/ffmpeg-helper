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

/**
 * <p>
 * Deinterleave or interleave fields.
 * 
 * <p>
 * This filter allows one to process interlaced images fields without deinterlacing them. Deinterleaving
 * splits the input frame into 2 fields (so called half pictures). Odd lines are moved to the top half of the
 * output image, even lines to the bottom half. You can process (filter) them independently and then
 * re-interleave them.
 *
 * @author tangxbai
 * @since 2022/07/11
 * @see <a href="https://ffmpeg.org/ffmpeg-filters.html#il">ffmpeg-filters#il</a>
 */
@Function( "il" )
public class Ierleave extends AbstractFunction<Ierleave> {

	// Don't let anyone instantiate this class
	private Ierleave() {}

	/**
	 * Quickly create an instances of {@link Ierleave}
	 * 
	 * @return the {@link Ierleave} instance
	 */
	public static final Ierleave of() {
		return new Ierleave();
	}

	/**
	 * Set luma mode
	 * 
	 * @apiNote (double) luma_mode, l
	 * @param mode the luma mode
	 * @return the {@link Ierleave} instance
	 */
	public Ierleave lumaMode( InterleaveMode mode ) {
		return super.addArg( "l", mode ); // luma_mode, l
	}

	/**
	 * Set chroma mode
	 * 
	 * @apiNote (double) chroma_mode, l
	 * @param mode the chroma mode
	 * @return the {@link Ierleave} instance
	 */
	public Ierleave chromaMode( InterleaveMode mode ) {
		return super.addArg( "c", mode ); // chroma_mode, l
	}

	/**
	 * Set alpha mode
	 * 
	 * @apiNote (double) alpha_mode, a
	 * @param mode the alpha mode
	 * @return the {@link Ierleave} instance
	 */
	public Ierleave alphaMode( InterleaveMode mode ) {
		return super.addArg( "c", mode ); // alpha_mode, a
	}

	/**
	 * Set swap luma fields, default is {@code false}.
	 * 
	 * @apiNote (double) luma_swap, ls
	 * @return the {@link Ierleave} instance
	 */
	public Ierleave lumaSwap() {
		return super.enable( "ls" ); // luma_swap, ls
	}

	/**
	 * Set swap chroma fields, default is {@code false}.
	 * 
	 * @apiNote (double) chroma_swap, cs
	 * @return the {@link Ierleave} instance
	 */
	public Ierleave chromaSwap() {
		return super.enable( "ls" ); // chroma_swap, cs
	}

	/**
	 * Set swap alpha fields, default is {@code false}.
	 * 
	 * @apiNote (double) alpha_swap, as
	 * @return the {@link Ierleave} instance
	 */
	public Ierleave alphaSwap() {
		return super.enable( "ls" ); // alpha_swap, as
	}

	/**
	 * Interleave modes for {@code luma_mode}, {@code chroma_mode} and {@code alpha_mode}.
	 *
	 * @author tangxbai
	 * @since 2022/07/11
	 */
	public enum InterleaveMode implements AbstractEnum {
		/** Do nothing */
		NONE,
		/** Deinterleave fields, placing one above the other. */
		@Alias( "f" )
		DEINTERLEAVE,
		/** Interleave fields. Reverse the effect of deinterleaving. */
		@Alias( "i" )
		INTERLEAVE
	}

}
