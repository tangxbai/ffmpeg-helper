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
import com.viiyue.ffmpeg.filter.AbstractFunction;

/**
 * Shift chroma pixels horizontally and/or vertically.
 * 
 * @author tangxbai
 * @since 2022/06/14
 * @see <a href="https://ffmpeg.org/ffmpeg-filters.html#chromashift">ffmpeg-filters#chromashift</a>
 */
@Function( "chromashift" )
public class ChromaShift extends AbstractFunction<ChromaShift> {

	// Don't let anyone instantiate this class
	private ChromaShift() {}

	/**
	 * Quickly create an instances of {@link ChromaShift}
	 * 
	 * @return the {@link ChromaShift} instance
	 */
	public static final ChromaShift the() {
		return new ChromaShift();
	}

	/**
	 * Set amount to shift chroma-blue horizontally.
	 * 
	 * @apiNote (string) cbh
	 * @param expression the chroma-blue horizontally
	 * @return the {@link ChromaShift} instance
	 */
	public ChromaShift chromaBlueHorizontally( String expression ) {
		return super.addArg( "cbh", expression );
	}

	/**
	 * Set amount to shift chroma-blue vertically.
	 * 
	 * @apiNote (string) cbv
	 * @param expression the chroma-blue vertically
	 * @return the {@link ChromaShift} instance
	 */
	public ChromaShift chromaBlueVertically( String expression ) {
		return super.addArg( "cbv", expression );
	}

	/**
	 * Set amount to shift chroma-red horizontally.
	 * 
	 * @apiNote (string) crh
	 * @param expression the chroma-red vertically
	 * @return the {@link ChromaShift} instance
	 */
	public ChromaShift chromaRedHoriaontally( String expression ) {
		return super.addArg( "crh", expression );
	}

	/**
	 * Set amount to shift chroma-red vertically.
	 * 
	 * @apiNote (string) crv
	 * @param expression the chroma-red vertically
	 * @return the {@link ChromaShift} instance
	 */
	public ChromaShift chromaRedVertically( String expression ) {
		return super.addArg( "crv", expression );
	}

	/**
	 * Set edge mode
	 * 
	 * @apiNote (flags) edge
	 * @param edge the edge mode
	 * @return the {@link ChromaShift} instance
	 */
	public ChromaShift edge( Edge edge ) {
		return super.addArg( "edge", edge );
	}

	/**
	 * Edge mode
	 *
	 * @author tangxbai
	 * @since 2022/06/14
	 */
	public static enum Edge implements AbstractEnum {
		SMEAR, DEFAULT, WARP
	}

}
