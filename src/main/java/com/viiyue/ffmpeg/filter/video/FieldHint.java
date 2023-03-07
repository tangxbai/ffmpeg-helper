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
import com.viiyue.ffmpeg.filter.AbstractColorFunction;

/**
 * Create new frames by copying the top and bottom fields from surrounding frames supplied as numbers by the
 * hint file
 * 
 * @author tangxbai
 * @since 2022/07/04
 * @see <a href="https://ffmpeg.org/ffmpeg-filters.html#fieldhint">ffmpeg-filters#fieldhint</a>
 */
@Function( "fieldhint" )
public class FieldHint extends AbstractColorFunction<FieldHint> {

	// Don't let anyone instantiate this class
	private FieldHint() {}

	/**
	 * Quickly create an instances of {@link ExtractPlanes}
	 * 
	 * @return the {@link FieldHint} instance
	 */
	public static final FieldHint of() {
		return new FieldHint();
	}

	/**
	 * <p>
	 * Set file containing hints: absolute/relative frame numbers.
	 * 
	 * <p>
	 * There must be one line for each frame in a clip. Each line must contain two numbers separated by the
	 * comma, optionally followed by - or +. Numbers supplied on each line of file can not be out of [N-1,N+1]
	 * where N is current frame number for absolute mode or out of [-1, 1] range for relative mode. First
	 * number tells from which frame to pick up top field and second number tells from which frame to pick up
	 * bottom field.
	 * 
	 * <p>
	 * If optionally followed by + output frame will be marked as interlaced, else if followed by - output
	 * frame will be marked as progressive, else it will be marked same as input frame. If optionally followed
	 * by t output frame will use only top field, or in case of b it will use only bottom field. If line
	 * starts with # or ; that line is skipped.
	 * 
	 * @apiNote (string) hint
	 * @param hint the hint file path
	 * @return the {@link FieldHint} instance
	 */
	public FieldHint hint( String hintFilePath ) {
		return super.addArg( "hint", hintFilePath );
	}

	/**
	 * Can be item {@link HintMode#ABSOLUTE} or {@link HintMode#RELATIVE}. Default is
	 * {@link HintMode#ABSOLUTE}. The pattern mode is same as relative mode, except at last entry of file if
	 * there are more frames to process than hint file is seek back to start.
	 * 
	 * @apiNote (flags) mode
	 * @param mode the hint mode
	 * @return the {@link FieldHint} instance
	 */
	public FieldHint mode( HintMode mode ) {
		return super.addArg( "mode", mode );
	}

	/**
	 * Field hint mode
	 *
	 * @author tangxbai
	 * @since 2022/07/04
	 */
	public enum HintMode implements AbstractEnum {
		ABSOLUTE, RELATIVE
	}

}
