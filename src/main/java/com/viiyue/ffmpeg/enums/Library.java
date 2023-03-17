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
package com.viiyue.ffmpeg.enums;

import java.io.File;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicReference;

import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang3.StringUtils;

import com.viiyue.ffmpeg.common.Const;
import com.viiyue.ffmpeg.util.Assert;
import com.viiyue.ffmpeg.util.Helper;

/**
 * FFmpeg library reference
 *
 * @author tangxbai
 * @since 2022/06/30
 */
public enum Library {

	FFMPEG( "A complete, cross-platform solution to record, convert and stream audio and video." ),

	FFPROBE( "FFprobe gathers information from multimedia streams and prints it in human- and machine-readable fashion." ),

	FFPLAY( "FFplay is a very simple and portable media player using the FFmpeg libraries and the SDL library. It is mostly used as a testbed for the various FFmpeg APIs." );

	private String outName;
	private String description;
	private static final Map<Library, String> targets = new HashMap<>( 3 );
	private static final Map<String, Boolean> validated = new HashMap<>( 4 );
	private static final AtomicReference<String> LOCATION_REF = new AtomicReference<>( Const.TEMP_PATH );
	private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern( "YYYYMMddHHmmss" );

	private Library( String description ) {
		this.description = description;
		this.outName = name().toLowerCase( Locale.ENGLISH );
	}

	public String getDescription() {
		return this.description;
	}

	public String getName() {
		return outName;
	}
	
	/**
	 * Bind the target executable location
	 * 
	 * @param target the target executable location
	 * @since 1.0.1
	 */
	public void bind( String target ) {
		targets.put( this, target );
	}
	
	/**
	 * To get the target executable library location
	 * 
	 * @return the library path of the executable file
	 * @since 1.0.1
	 */
	public String getExecutable() {
		return checkTarget( targets.get( this ) );
	}
	
	/**
	 * Set the output log file location
	 * 
	 * @param location the ffmpeg output log location
	 * @since 1.0.1
	 */
	public static void setLogLocation( String location ) {
		LOCATION_REF.set( location );
	}
	
	/**
	 * Get the output log location
	 * 
	 * @return the ffmpeg log directory location
	 * @since 1.0.1
	 */
	public String getLogLocation() {
		String thePath = LOCATION_REF.get();
		String extension = FilenameUtils.getExtension( thePath );
		if ( StringUtils.isEmpty( extension ) ) {
			thePath = Helper.fixPath( thePath );
			String datetime = FORMATTER.format( LocalDateTime.now() );
			thePath += outName + "/" + datetime + ".log";
		}
		return thePath;
	}
	
	/**
	 * Check the target input
	 * 
	 * @param target the target library location
	 * @return the checked target
	 * @since 1.0.1
	 */
	private String checkTarget( String target ) {
		if ( Objects.equals( validated.get( target ), Boolean.TRUE ) ) {
			return target;
		}
		Assert.notNull( target, "You must specify the library path for " + outName + "!" );
		File file = new File( target );
		if ( file.exists() ) {
			Assert.isFalse( file.isDirectory(), "The specified " + target + " library cannot be a directory!" );
		}
		validated.put( target, Boolean.TRUE );
		return target;
	}

}
