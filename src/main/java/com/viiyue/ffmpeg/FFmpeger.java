/**
 * Copyright (C) 2022-2023 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in
 * compliance with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License is
 * distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and limitations under the License.
 */
package com.viiyue.ffmpeg;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

import org.apache.commons.lang3.StringUtils;

import com.viiyue.ffmpeg.enums.LogLevel;
import com.viiyue.ffmpeg.executor.AbstractExecutor;
import com.viiyue.ffmpeg.executor.FFmpegExecutor;
import com.viiyue.ffmpeg.executor.FFplayExecutor;
import com.viiyue.ffmpeg.executor.FFprobeExecutor;
import com.viiyue.ffmpeg.executor.HelpExecutor;
import com.viiyue.ffmpeg.metadata.FFprobe;
import com.viiyue.ffmpeg.metadata.Format;
import com.viiyue.ffmpeg.metadata.SimpleColor;
import com.viiyue.ffmpeg.metadata.SimpleFormat;
import com.viiyue.ffmpeg.metadata.Stream;

/**
 * 
 * @author tangxbai
 * @since 2022/05/25
 */
public final class FFmpeger {

	private static final Map<String, Object> caches = new ConcurrentHashMap<>( 16 );

	public static void init( String library, String logLocation ) {
		AbstractExecutor.setLibrary( library );
		AbstractExecutor.setLogLocation( logLocation );
	}

	public static void setLogLocation( String logLocation ) {
		AbstractExecutor.setLogLocation( logLocation );
	}

	// FFprobe
	// For more method calls, please see FFprobeExecutor

	public static FFprobeExecutor ffprobeInput( String input ) {
		return FFprobeExecutor.build().log( LogLevel.QUIET ).input( input );
	}

	public static Optional<FFprobe> readInfo( String input ) {
		return ffprobeInput( input ).toBean();
	}

	public static Optional<Stream> readVideoInfo( String input ) {
		return ffprobeInput( input ).vstreams().toBean().map( FFprobe::getVideoStream );
	}

	public static Optional<Stream> readAudioInfo( String input ) {
		return ffprobeInput( input ).astreams().toBean().map( FFprobe::getAudioStream );
	}

	public static Optional<Format> readFormatInfo( String input ) {
		return ffprobeInput( input ).foramt().toBean().map( FFprobe::getFormat );
	}

	// FFmpeg
	// For more method calls, please see FFmpegExecutor

	public static FFmpegExecutor ffmepg() {
		return FFmpegExecutor.build( true );
	}

	public static void transcoding( String input, String output, String codec ) {
		ffmepg().input( input ).codec( codec ).to( output );
	}

	public static void cutPart( String input, String output, double start, double end ) {
		ffmepg().input( input ).search( start, end ).to( output );
	}

	public static void cutAt( String input, String output, double start, double how ) {
		ffmepg().input( input ).searchAt( start, how ).to( output );
	}

	public static void mergeInputs( String output, String ... inputs ) {
		ffmepg().input( inputs ).to( output );
	}

	// FFplay

	public static FFplayExecutor ffplay( String input ) {
		return FFplayExecutor.build().input( input );
	}

	public static void playVideo( String input, String title, int width, int height ) {
		ffplay( input ).size( 400, 300 ).title( "预览视频" ).toPlay( true );
	}

	// Common
	// For more method calls, please see FFmpegExecutor

	public static HelpExecutor helpInfo() {
		return HelpExecutor.ffmpeg().log( LogLevel.QUIET );
	}

	public static List<SimpleFormat> readSupportedFormats() {
		return ( List<SimpleFormat> ) ( caches.computeIfAbsent( "info.formats", key -> {
			String content = helpInfo().formats().getAndReturn( "query results will be cached ..." );
			String [] lines = StringUtils.split( content, "\r\n" );
			List<SimpleFormat> formats = new ArrayList<SimpleFormat>( lines.length );

			boolean begin = false;
			for ( int i = 0; i < lines.length; i ++ ) {
				String line = StringUtils.strip( lines[ i ] );
				if ( begin ) {
					int spaceIndex = line.indexOf( " " );
					String string = line.substring( spaceIndex ).trim();
					spaceIndex = string.indexOf( " " );
					if ( spaceIndex >= 0 ) {
						String format = string.substring( 0, spaceIndex );
						String description = string.substring( spaceIndex );
						formats.add( new SimpleFormat( format, description.trim() ) );
					} else {
						formats.add( new SimpleFormat( string, null ) );
					}

				} else if ( line.startsWith( "--" ) ) {
					begin = true;
				}
			}
			return formats;
		} ) );
	}

	public static List<SimpleColor> readSupportedColors() {
		return ( List<SimpleColor> ) ( caches.computeIfAbsent( "info.colors", key -> {
			String content = helpInfo().colors().getAndReturn( "query results will be cached ..." );
			String [] lines = StringUtils.split( content, "\r\n" );

			List<SimpleColor> scolors = new ArrayList<SimpleColor>( lines.length );
			for ( int i = 1, s = lines.length; i < s; i ++ ) {
				String line = lines[ i ];

				String colors = StringUtils.replace( line, " ", "" );
				int hexIndex = colors.indexOf( "#" );
				String color = colors.substring( 0, hexIndex );
				String hexColor = colors.substring( hexIndex );

				scolors.add( new SimpleColor( color, hexColor ) );
			}
			return scolors;
		} ) );
	}

}
