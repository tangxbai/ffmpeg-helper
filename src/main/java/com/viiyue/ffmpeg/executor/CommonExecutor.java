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

import java.io.File;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;

import com.viiyue.ffmpeg.enums.Library;
import com.viiyue.ffmpeg.enums.Preset;

/**
 * The abstract command executor, you should have a subclass to implement it.
 * 
 * @author tangxbai
 * @since 2022/05/25
 * @param <T>
 */
public abstract class CommonExecutor<T extends GlobalExecutor<?>> extends GlobalExecutor<T> {

	protected int inputs;

	public CommonExecutor( Library library ) {
		super( library );
	}

	/**
	 * Force input or output file format. The format is normally auto detected for input files and guessed
	 * from the file extension for output files, so this option is not needed in most cases.
	 * 
	 * @param format
	 * @return
	 */
	public T format( String format ) {
		return super.cmd( "f", format );
	}

	public T codec( String codec ) {
		return super.cmd( "codec", codec );
	}

	public T limitSize( int bytes ) {
		return super.cmd( "fs", bytes );
	}

	public T timeOff( String offset ) {
		return super.cmd( "sseof", offset );
	}

	public T preset( String presetName ) {
		return super.cmd( "pre", presetName );
	}

	public T target( String type ) {
		return super.cmd( "target", type );
	}

	public T frames( int number ) {
		return super.cmd( "frames", number );
	}

	public T timestamp( Long timestamp ) {
		return super.cmd( "timestamp", timestamp );
	}

	public T metadata( String key, Object value ) {
		return super.cmd( "metadata", key + "=" + value, false );
	}

	public T search( String start, String end ) {
		super.cmd( "ss", start );
		super.cmd( "to", end );
		return ( T ) this;
	}

	public T search( double start, double end ) {
		super.cmd( "ss", start );
		super.cmd( "to", end );
		return ( T ) this;
	}

	public T searchAt( String start, double how ) {
		super.cmd( "ss", start );
		super.cmd( "t", how );
		return ( T ) this;
	}

	public T searchAt( double start, double how ) {
		super.cmd( "ss", start );
		super.cmd( "t", how );
		return ( T ) this;
	}

	public T map( String who ) {
		return super.cmd( "map", who );
	}
	
	/**
	 * This option allows you to set a range of choices from very fast (optimal speed) to very slow (best
	 * quality).
	 * 
	 * @param preset the preset option
	 * @return the current instance
	 * @since 1.0.1
	 */
	public T preset( Preset preset ) {
		return super.cmd( "preset", preset );
	}
	
	/**
	 * Set the number of frames to output
	 * 
	 * @param value the frames number
	 * @return the current instance
	 */
	public T filter( int value ) {
		return super.cmd( "filter", value );
	}

	/**
	 * Specifies the input source, which can be a file path or another expression.
	 * 
	 * @param inputs an array of input sources
	 * @return the current instance
	 */
	public T input( String ... inputs ) {
		return inputs( Arrays.asList( inputs ) );
	}
	
	/**
	 * Specifies the input source, which can be a file path or another expression.
	 * 
	 * @param inputs the list of input sources
	 * @return the current instance
	 */
	public T inputs( List<String> inputs ) {
		if ( CollectionUtils.isNotEmpty( inputs ) ) {
			this.inputs = inputs.size();
			for ( String input : inputs ) {
				if ( StringUtils.isNotEmpty( input ) ) {
					super.cmd( "i", input, false );
				}
			}
		}
		return ( T ) this;
	}
	
	/**
	 * Specifies the input file
	 * 
	 * @param files an array of input files
	 * @return the current instance
	 */
	public T file( File ... files ) {
		return files( Arrays.asList( files ) );
	}
	
	/**
	 * Specifies the input file path
	 * 
	 * @param files the array of input files
	 * @return the current instance
	 */
	public T file( String ... files ) {
		return files( Arrays.asList( files ) );
	}
	
	/**
	 * Specifies the input file
	 * 
	 * @param files the list of input files, and which can only be {@link String} and {@link File}.
	 * @return the current instance
	 */
	public T files( List<?> files ) {
		if ( CollectionUtils.isNotEmpty( files ) ) {
			this.inputs = files.size();
			for ( Object input : files ) {
				if ( input instanceof String ) {
					String i = ( String ) input;
					if ( StringUtils.isNotEmpty( i ) ) {
						super.cmd( "i", fileCheck( i ), false );
					}
				} else if ( input instanceof File ) {
					File i = ( File ) input;
					if ( i != null ) {
						super.cmd( "i", fileCheck( i ).getAbsolutePath(), false );
					}
				}
			}
		}
		return ( T ) this;
	}

	/**
	 * Do a simple file check
	 * 
	 * @param <E> the input file type
	 * @param input the input file
	 * @return the checked target
	 */
	private <E> E fileCheck( E input ) {
		if ( input == null ) {
			throw new NullPointerException( "Input file cannot be null" );
		}
		File inputFile = null;
		if ( input instanceof String ) {
			inputFile = new File( input.toString() );
		} else if ( input instanceof File ) {
			inputFile = ( File ) input;
		}
		if ( inputFile == null ) {
			throw new IllegalArgumentException( "Incorrect input argument type" );
		}
		if ( !inputFile.exists() ) {
			throw new RuntimeException( "Input file dose not exist: " + inputFile.getAbsolutePath() );
		}
		return input;
	}

}
