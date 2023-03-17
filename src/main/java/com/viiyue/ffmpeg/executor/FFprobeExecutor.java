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

import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.viiyue.ffmpeg.enums.Library;
import com.viiyue.ffmpeg.metadata.FFprobe;
import com.viiyue.ffmpeg.util.Jaxb;

/**
 * FFprobe command executor
 * 
 * @author tangxbai
 * @since 2022/05/25
 */
public class FFprobeExecutor extends CommonExecutor<FFprobeExecutor> {

	private static final Logger LOG = LoggerFactory.getLogger( FFprobeExecutor.class );

	public static final FFprobeExecutor build() {
		return new FFprobeExecutor();
	}

	private FFprobeExecutor() {
		super( Library.FFPROBE );
	}

	@Override
	public Logger getLogger() {
		return LOG;
	}

	public FFprobeExecutor streams( String type ) {
		super.cmd( "show_streams" );
		return super.cmd( "select_streams", type );
	}

	public FFprobeExecutor vstreams() {
		return streams( "v" );
	}

	public FFprobeExecutor astreams() {
		return streams( "a" );
	}

	public FFprobeExecutor foramt() {
		return super.cmd( "show_format" );
	}

	public FFprobeExecutor versions() {
		return super.cmd( "show_versions" );
	}

	public FFprobeExecutor decoders() {
		return super.cmd( "decoders" );
	}

	public FFprobeExecutor sections() {
		return super.cmd( "sections" );
	}

	public FFprobeExecutor frames() {
		return super.cmd( "show_frames" );
	}

	public FFprobeExecutor chapters() {
		return super.cmd( "show_chapters" );
	}

	public FFprobeExecutor pixel() {
		return super.cmd( "show_pixel_formats" );
	}

	public FFprobeExecutor optional() {
		return super.cmd( "show_optional_fields" );
	}

	public FFprobeExecutor streamInfo() {
		return super.cmd( "find_stream_info" );
	}

	public String to() {
		return super.execute();
	}

	public String toCSVString() {
		return to( "scv" );
	}

	public String toJsonString() {
		return to( "json" );
	}

	public String toFlatString() {
		return to( "flat" );
	}

	public String toIniString() {
		return to( "ini" );
	}
	
	private static Map<String, Object> caches = new ConcurrentHashMap<String, Object>( 128 );

	public Optional<FFprobe> toBean() {
		return ( Optional<FFprobe> ) caches.computeIfAbsent( toCommandString(), cmd -> {
			return Optional.ofNullable( Jaxb.context().toBean( to( "xml" ), FFprobe.class ) );
		});
	}

	private String to( String format ) {
		super.cmd( "of", format );
		return ( String ) caches.computeIfAbsent( toCommandString(), cmd -> execute() );
	}

}
