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

import com.viiyue.ffmpeg.common.Const;
import com.viiyue.ffmpeg.filter.AbstractFunction;
import com.viiyue.ffmpeg.util.Helper;

/**
 * Declare move namespace
 *
 * @author tangxbai
 * @since 2022/06/02
 */
public class Declare extends AbstractFunction<Declare> {

	// Don't let anyone instantiate this class
	private Declare() {
		super( Const.PART_SEPARATOR );
	}

	public static final Declare the( String path ) {
		return new Declare().addArg( "movie", Helper.escape( path, true ) );
	}

	public Declare size( int width, int height ) {
		return super.addArg( "scale", width, height );
	}

	public Declare size( String width, String height ) {
		return super.addArg( "scale", width, height );
	}

}
