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

/**
 * 
 * @author tangxbai
 * @since 2022/05/25
 */
public class HelpExecutor extends GlobalExecutor<HelpExecutor> {

	private static final Logger LOG = LoggerFactory.getLogger( HelpExecutor.class );

	public static final HelpExecutor ffmpeg() {
		return new HelpExecutor( Library.FFMPEG );
	}

	public static final HelpExecutor ffprobe() {
		return new HelpExecutor( Library.FFPROBE );
	}

	public static final HelpExecutor ffplay() {
		return new HelpExecutor( Library.FFPLAY );
	}

	private HelpExecutor( Library library ) {
		super( library );
	}

	@Override
	public Logger getLogger() {
		return LOG;
	}

	public HelpExecutor license() {
		return super.cmd( "L" );
	}

	public HelpExecutor version() {
		return super.cmd( "version" );
	}

	public HelpExecutor help() {
		return super.cmd( "L" );
	}

	public HelpExecutor helpLong() {
		return super.cmd( "h", "long" );
	}

	public HelpExecutor helpFull() {
		return super.cmd( "h", "full" );
	}

	public HelpExecutor help( String name ) {
		return super.cmd( "h", "type=" + name );
	}

	public HelpExecutor buildInfo() {
		return super.cmd( "buildconf" );
	}

	public HelpExecutor colors() {
		return super.cmd( "colors" );
	}

	public HelpExecutor formats() {
		return super.cmd( "formats" );
	}

	public HelpExecutor filters() {
		return super.cmd( "filters" );
	}

	public String getAndReturn() {
		return super.execute( null );
	}

	public String getAndReturn( String message ) {
		return super.execute( message );
	}

}
