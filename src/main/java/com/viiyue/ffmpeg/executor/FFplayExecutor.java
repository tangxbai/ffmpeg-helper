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
package com.viiyue.ffmpeg.executor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.viiyue.ffmpeg.enums.Library;
import com.viiyue.ffmpeg.filter.Filters;

/**
 * FFplay command executor
 * 
 * @author tangxbai
 * @since 2022/05/25
 */
public class FFplayExecutor extends CommonExecutor<FFplayExecutor> {

	private static final Logger LOG = LoggerFactory.getLogger( FFplayExecutor.class );

	public static final FFplayExecutor build() {
		return new FFplayExecutor();
	}

	private FFplayExecutor() {
		super( Library.FFPLAY );
	}

	@Override
	public Logger getLogger() {
		return LOG;
	}

	public FFplayExecutor title( String title ) {
		return super.cmd( "window_title", title );
	}

	public FFplayExecutor size( int width, int height ) {
		return super.cmd( "x", width ).cmd( "y", height );
	}

	public FFplayExecutor mode( String mode ) {
		return super.cmd( "showmode", mode );
	}

	public FFplayExecutor filters( Filters filters ) {
		return super.cmd( filters.getFilter(), filters );
	}

	public void toPlay() {
		toPlay( false );
	}

	public void toPlay( boolean isAutoExit ) {
		if ( isAutoExit ) {
			super.cmd( "autoexit" );
		}
		super.execute();
	}

}
