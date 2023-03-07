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
 * Deinterlace input video by applying Donald Graft’s adaptive kernel deinterling. Work on interlaced parts of
 * a video to produce progressive frames.
 *
 * @author tangxbai
 * @since 2022/07/12
 * @see <a href="https://ffmpeg.org/ffmpeg-filters.html#kerndeint">ffmpeg-filters#kerndeint</a>
 */
@Function( "kerndeint" )
public class Kerndeint extends AbstractFunction<Kerndeint> {

	// Don't let anyone instantiate this class
	private Kerndeint() {}

	/**
	 * Quickly create an instances of {@link Kerndeint}
	 * 
	 * @return the {@link Kerndeint} instance
	 */
	public static final Kerndeint of() {
		return new Kerndeint();
	}

	/**
	 * Set the threshold which affects the filter’s tolerance when determining if a pixel line must be
	 * processed. It must be an integer in the range [0,255] and defaults to <b>10</b>. A value of 0 will
	 * result in applying the process on every pixels.
	 * 
	 * @apiNote (int) thresh
	 * @param value the threshold
	 * @return the {@link Kerndeint} instance
	 */
	public Kerndeint threshold( int value ) {
		return super.addArg( "thresh", value );
	}

	/**
	 * Paint pixels exceeding the threshold value to white if set to {@code true}, default is {@code false}.
	 * 
	 * @apiNote (boolean) map
	 * @return the {@link Kerndeint} instance
	 */
	public Kerndeint map() {
		return super.enable( "map" );
	}

	/**
	 * Set the fields order. Swap fields if set to {@code true}, leave fields alone if {@code false}, default
	 * is {@code false}.
	 * 
	 * @apiNote (boolean) order
	 * @return the {@link Kerndeint} instance
	 */
	public Kerndeint order() {
		return super.enable( "order" );
	}

	/**
	 * Enable additional sharpening if set to {@code true}, default is {@code false}.
	 * 
	 * @apiNote (boolean) sharp
	 * @return the {@link Kerndeint} instance
	 */
	public Kerndeint sharp() {
		return super.enable( "sharp" );
	}

	/**
	 * Enable {@code twoway} sharpening if set to {@code true}, default is {@code false}.
	 * 
	 * @apiNote (boolean) twoway
	 * @return the {@link Kerndeint} instance
	 */
	public Kerndeint twoWay() {
		return super.enable( "twoway" );
	}

}
