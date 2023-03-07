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

/**
 * Apply telecine process to the video
 * 
 * @author tangxbai
 * @since 2022/08/05
 * @see <a href="https://ffmpeg.org/ffmpeg-filters.html#telecine">ffmpeg-filters#telecine</a>
 */
@Function( "telecine" )
public class Telecine extends AbstractFunction<Telecine> {

	// Don't let anyone instantiate this class
	private Telecine() {}

	/**
	 * Quickly create an instances of {@link Telecine}
	 * 
	 * @return the {@link Telecine} instance
	 */
	public static final Telecine of() {
		return new Telecine();
	}

	/**
	 * To select first field
	 * 
	 * @apiNote (flags) first_field
	 * @param field the first field type
	 * @return the {@link Telecine} instance
	 * @see FirstField
	 */
	public Telecine firstField( FirstField field ) {
		return super.addArg( "first_field", field );
	}

	/**
	 * <p>
	 * A string of numbers representing the pulldown pattern you wish to apply. The default value is 23.
	 * 
	 * <pre>
	 * Some typical patterns:
	 * 
	 * NTSC output (30i): 
	 * 27.5p: 32222 
	 * 24p: 23 (classic) 
	 * 24p: 2332 (preferred) 
	 * 20p: 33 
	 * 18p: 334 
	 * 16p: 3444
	 * 
	 * PAL output (25i): 
	 * 27.5p: 12222 
	 * 24p: 222222222223 ("Euro pulldown") 
	 * 16.67p: 33 
	 * 16p: 33333334
	 * </pre>
	 * 
	 * @apiNote () demo
	 * @param value the
	 * @return the {@link Telecine} instance
	 */
	public Telecine pattern( String pattern ) {
		return super.addArg( "pattern", pattern );
	}

}
