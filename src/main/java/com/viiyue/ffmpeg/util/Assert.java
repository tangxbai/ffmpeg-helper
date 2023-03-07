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
package com.viiyue.ffmpeg.util;

import java.io.File;
import java.util.Collection;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;

/**
 * 
 * @author tangxbai
 * @since 2022/05/25
 */
public class Assert {

	public static void isTrue( boolean expression, String message ) {
		if ( !expression ) {
			throw new IllegalArgumentException( message );
		}
	}

	public static void isFalse( boolean expression, String message ) {
		if ( expression ) {
			throw new IllegalArgumentException( message );
		}
	}

	public static final void notEmpty( Object [] target, String message ) {
		if ( ArrayUtils.isEmpty( target ) ) {
			throw new NullPointerException( message );
		}
	}

	public static final void notEmpty( Collection<?> target, String message ) {
		if ( CollectionUtils.isEmpty( target ) ) {
			throw new NullPointerException( message );
		}
	}

	public static final void notEmpty( String target, String message ) {
		if ( StringUtils.isEmpty( target ) ) {
			throw new NullPointerException( message );
		}
	}

	public static final void notNull( Object target, String message ) {
		if ( target == null ) {
			throw new NullPointerException( message );
		}
	}

	public static void rangeCheck( double value, double start, double end ) {
		if ( value < start || value > end ) {
			throw new IllegalArgumentException(
					"Value out of range(" + start + "," + end + "), but your value is " + value );
		}
	}

	public static void extCheck( String path, String ext ) {
		if ( !StringUtils.endsWith( path, ext ) ) {
			String extension = FilenameUtils.getExtension( path );
			throw new IllegalArgumentException(
					"Your path variable must end with \"." + ext + "\", but now it is \"." + extension + "\"." );
		}
	}

	public static void rangeCheck( int value, int start, int end ) {
		if ( value < start || value > end ) {
			throw new IllegalArgumentException(
					"Value out of range(" + start + "," + end + "), but your value is " + value );
		}
	}

	public static File checkFile( String filePath, boolean isDirectory ) {
		if ( StringUtils.isEmpty( filePath ) ) {
			throw new IllegalArgumentException( "The target directory cannot be empty" );
		}
		return checkFile( new File( filePath ), isDirectory );
	}

	public static File checkFile( File file, boolean isDirectory ) {
		if ( file == null ) {
			throw new IllegalArgumentException( "The target file cannot be empty" );
		}
		Helper.createDirectoryIfNecessary( file );
		if ( !file.exists() ) {
			throw new IllegalArgumentException( "The target file does not exist" );
		}
		if ( isDirectory ) {
			if ( !file.isDirectory() ) {
				throw new IllegalArgumentException( "The target file can only be a folder" );
			}
		} else {
			if ( file.isDirectory() ) {
				throw new IllegalArgumentException( "The target file cannot be a folder" );
			}
		}
		return file;
	}

}
