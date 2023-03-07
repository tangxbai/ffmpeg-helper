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
 * Change video quantization parameters (QP).
 * 
 * @author tangxbai
 * @since 2022/07/22
 * @see <a href="https://ffmpeg.org/ffmpeg-filters.html#qp">ffmpeg-filters#qp</a>
 */
@Function( "qp" )
public class Qp extends AbstractFunction<Qp> {

	// Don't let anyone instantiate this class
	private Qp() {}

	/**
	 * Quickly create an instances of {@link Qp}
	 * 
	 * @apiNote (string) qp
	 * @param expression the quantization parameter expression
	 * @return the {@link Qp} instance
	 */
	public static final Qp of( String expression ) {
		return new Qp().addArg( "qp", expression );
	}

}
