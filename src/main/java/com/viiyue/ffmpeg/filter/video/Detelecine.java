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
import com.viiyue.ffmpeg.enums.FirstField;
import com.viiyue.ffmpeg.filter.AbstractFunction;
import com.viiyue.ffmpeg.util.Assert;

/**
 * Apply an exact inverse of the telecine operation. It requires a predefined pattern specified using the
 * pattern option which must be the same as that passed to the telecine filter.
 * 
 * @author tangxbai
 * @since 2022/06/27
 * @see <a href="https://ffmpeg.org/ffmpeg-filters.html#detelecine">ffmpeg-filters#detelecine</a>
 */
@Function( "detelecine" )
public class Detelecine extends AbstractFunction<Detelecine> {

	// Don't let anyone instantiate this class
	private Detelecine() {}

	/**
	 * Quickly create an instances of {@link Detelecine}
	 * 
	 * @return the {@link Detelecine} instance
	 */
	public static final Detelecine of() {
		return new Detelecine();
	}

	/**
	 * To select first field
	 * 
	 * @apiNote (flags) first_field
	 * @param field the first field type
	 * @return the {@link Detelecine} instance
	 * @see FirstField
	 */
	public Detelecine firstField( FirstField field ) {
		return super.addArg( "first_field", field );
	}

	/**
	 * A string of numbers representing the pulldown pattern you wish to apply, default value is <b>23</b>.
	 * 
	 * @apiNote (string) pattern
	 * @param pattern the describe pattern
	 * @return the {@link Detelecine} instance
	 */
	public Detelecine pattern( String pattern ) {
		return super.addArg( "pattern", pattern );
	}

	/**
	 * A number representing position of the first frame with respect to the telecine pattern. This is to be
	 * used if the stream is cut, default value is <b>0</b>.
	 * 
	 * @apiNote (int) start_frame
	 * @param frames the describe pattern
	 * @return the {@link Detelecine} instance
	 */
	public Detelecine start( int frames ) {
		Assert.rangeCheck( frames, 0, 13 );
		return super.addArg( "start_frame", frames );
	}

}
