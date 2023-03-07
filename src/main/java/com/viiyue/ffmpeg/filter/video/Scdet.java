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
 * Detect video scene change.
 * 
 * <p>
 * This filter sets frame metadata with mafd between frame, the scene score, and forward the frame to the next
 * filter, so they can use these metadata to detect scene change or others.
 * 
 * <p>
 * In addition, this filter logs a message and sets frame metadata when it detects a scene change by
 * threshold.
 * 
 * <p>
 * {@code lavfi.scd.mafd metadata} keys are set with mafd for every frame.
 * 
 * <p>
 * {@code lavfi.scd.score metadata} keys are set with scene change score for every frame to detect scene
 * change.
 * 
 * <p>
 * {@code lavfi.scd.time metadata} keys are set with current filtered frame time which detect scene change
 * with threshold.
 * 
 * @author tangxbai
 * @since 2022/08/03
 * @see <a href="https://ffmpeg.org/ffmpeg-filters.html#scdet-1">ffmpeg-filters#scdet</a>
 */
@Function( "scdet" )
public class Scdet extends AbstractFunction<Scdet> {

	// Don't let anyone instantiate this class
	private Scdet() {}

	/**
	 * Quickly create an instances of {@link Scdet}
	 * 
	 * @return the {@link Scdet} instance
	 */
	public static final Scdet of() {
		return new Scdet();
	}

	/**
	 * <p>
	 * Set the scene change detection threshold as a percentage of maximum change. Good values are in the
	 * [8.0, 14.0] range. The range for threshold is [0.0, 100.0].
	 * 
	 * <p>
	 * Default value is <b>10.0</b>.
	 * 
	 * @apiNote (int) threshold, t
	 * @param value the scene change detect threshold
	 * @return the {@link Scdet} instance
	 */
	public Scdet threshold( double value ) {
		Assert.rangeCheck( value, 0.0, 100.0 );
		return super.addArg( "h", value ); // threshold, t
	}

	/**
	 * Set the flag to pass scene change frames to the next filter. Default value is {@code false}, you can
	 * enable it if you want to get snapshot of scene change frames only.
	 * 
	 * @apiNote (boolean) sc_pass, s
	 * @return the {@link Scdet} instance
	 */
	public Scdet scenePass() {
		return super.enable( "s" ); // sc_pass, s
	}

}
