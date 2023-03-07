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
import com.viiyue.ffmpeg.enums.PixelFormat;
import com.viiyue.ffmpeg.filter.AbstractFunction;

/**
 * Merge color channel components from several video streams. The filter accepts up to 4 input streams, and
 * merge selected input planes to the output video.
 * 
 * @author tangxbai
 * @since 2022/07/18
 * @see <a href="https://ffmpeg.org/ffmpeg-filters.html#mergeplanes">ffmpeg-filters#mergeplanes</a>
 */
@Function( "mergeplanes" )
public class MergePlanes extends AbstractFunction<MergePlanes> {

	// Don't let anyone instantiate this class
	private MergePlanes() {}

	/**
	 * Quickly create an instances of {@link MergePlanes}
	 * 
	 * @return the {@link MergePlanes} instance
	 */
	public static final MergePlanes of() {
		return new MergePlanes();
	}

	/**
	 * <p>
	 * Set input to output plane mapping. Default is <b>0</b>.
	 * 
	 * <p>
	 * The mappings is specified as a bitmap. It should be specified as a hexadecimal number in the form
	 * 0xAa[Bb[Cc[Dd]]]. ’Aa’ describes the mapping for the first plane of the output stream. ’A’ sets the
	 * number of the input stream to use (from 0 to 3), and ’a’ the plane number of the corresponding input to
	 * use (from 0 to 3). The rest of the mappings is similar, ’Bb’ describes the mapping for the output
	 * stream second plane, ’Cc’ describes the mapping for the output stream third plane and ’Dd’ describes
	 * the mapping for the output stream fourth plane.
	 * 
	 * @apiNote (int) mapping
	 * @param value the input to output plane mapping
	 * @return the {@link MergePlanes} instance
	 */
	public MergePlanes mapping( int value ) {
		return super.addArg( "mapping", value );
	}

	/**
	 * Set output pixel format. Default is {@link PixelFormat#YUVA444P}.
	 * 
	 * @apiNote (flags) format
	 * @param format the output pixel format
	 * @return the {@link MergePlanes} instance
	 * @see PixelFormat
	 */
	public MergePlanes format( PixelFormat format ) {
		return super.addArg( "format", format );
	}

	/**
	 * Set input to output stream mapping for output Nth plane, default is <b>0</b>.
	 * 
	 * @apiNote (int) map0s
	 * @param value the stream mapping value
	 * @return the {@link MergePlanes} instance
	 */
	public MergePlanes map0s( int value ) {
		return super.addArg( "map0s", value );
	}

	/**
	 * Set input to output stream mapping for output Nth plane, default is <b>0</b>.
	 * 
	 * @apiNote (int) map1s
	 * @param value the stream mapping value
	 * @return the {@link MergePlanes} instance
	 */
	public MergePlanes map1s( int value ) {
		return super.addArg( "map1s", value );
	}

	/**
	 * Set input to output stream mapping for output Nth plane, default is <b>0</b>.
	 * 
	 * @apiNote (int) map2s
	 * @param value the stream mapping value
	 * @return the {@link MergePlanes} instance
	 */
	public MergePlanes map2s( int value ) {
		return super.addArg( "map2s", value );
	}

	/**
	 * Set input to output stream mapping for output Nth plane, default is <b>0</b>.
	 * 
	 * @apiNote (int) map3s
	 * @param value the stream mapping value
	 * @return the {@link MergePlanes} instance
	 */
	public MergePlanes map3s( int value ) {
		return super.addArg( "map3s", value );
	}

	/**
	 * Set input to output plane mapping for output Nth plane, default is <b>0</b>.
	 * 
	 * @apiNote (int) map0p
	 * @param value the plane mapping value
	 * @return the {@link MergePlanes} instance
	 */
	public MergePlanes map0p( int value ) {
		return super.addArg( "map0p", value );
	}

	/**
	 * Set input to output plane mapping for output Nth plane, default is <b>0</b>.
	 * 
	 * @apiNote (int) map0p
	 * @param value the plane mapping value
	 * @return the {@link MergePlanes} instance
	 */
	public MergePlanes map1p( int value ) {
		return super.addArg( "map1p", value );
	}

	/**
	 * Set input to output plane mapping for output Nth plane, default is <b>0</b>.
	 * 
	 * @apiNote (int) map2p
	 * @param value the plane mapping value
	 * @return the {@link MergePlanes} instance
	 */
	public MergePlanes map2p( int value ) {
		return super.addArg( "map2p", value );
	}

	/**
	 * Set input to output plane mapping for output Nth plane, default is <b>0</b>.
	 * 
	 * @apiNote (int) map3p
	 * @param value the plane mapping value
	 * @return the {@link MergePlanes} instance
	 */
	public MergePlanes map3p( int value ) {
		return super.addArg( "map3p", value );
	}

}
