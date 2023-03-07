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
 * Video data analysis filter, this filter shows hexadecimal pixel values of part of video.
 * 
 * @author tangxbai
 * @since 2022/06/22
 * @see <a href="https://ffmpeg.org/ffmpeg-filters.html#datascope">ffmpeg-filters#datascope</a>
 */
@Function( "datascope" )
public class DataScope extends AbstractFunction<DataScope> {

	// Don't let anyone instantiate this class
	private DataScope() {}

	/**
	 * Quickly create an instances of {@link DataScope}
	 * 
	 * @return the {@link DataScope} instance
	 */
	public static final DataScope of() {
		return new DataScope();
	}

	/**
	 * Set output video size
	 * 
	 * @apiNote (string) s
	 * @return the {@link DataScope} instance
	 */
	public DataScope size( int width, int height ) {
		return super.addArg( "s", width + "x" + height ); // size, s
	}

	/**
	 * Set the offsets of the position where x, y pixels to pick.
	 * 
	 * @apiNote (int) x, (int) y
	 * @return the {@link DataScope} instance
	 */
	public DataScope from( int x, int y ) {
		return super.addArg( "x", x ).addArg( "y", y );
	}

	/**
	 * Set scope mode
	 * 
	 * @apiNote (flags) mode
	 * @param mode the date scope mode
	 * @return the {@link DataScope} instance
	 * @see ScopeMode
	 */
	public DataScope mode( ScopeMode mode ) {
		return super.addArg( "mode", mode );
	}

	/**
	 * Draw rows and columns numbers on left and top of video
	 * 
	 * @apiNote (boolean) axis
	 * @return the {@link DataScope} instance
	 */
	public DataScope axis() {
		return super.enable( "axis" );
	}

	/**
	 * Draw rows and columns numbers on left and top of video
	 * 
	 * @apiNote (double) opacity
	 * @return the {@link DataScope} instance
	 */
	public DataScope opacity( double opacity ) {
		return super.addArg( "opacity", opacity );
	}

	/**
	 * Draw rows and columns numbers on left and top of video
	 * 
	 * @apiNote (flags) format
	 * @return the {@link DataScope} instance
	 * @see DisplayFormat
	 */
	public DataScope format( DisplayFormat format ) {
		return super.addArg( "format", format );
	}

	/**
	 * Set pixel components to display. By default all pixel components are displayed.
	 * 
	 * @apiNote (string) components
	 * @param components the pixel components
	 * @return the {@link DataScope} instance
	 */
	public DataScope components( String components ) {
		return super.addArg( "components", components );
	}

	/**
	 * Display number format
	 * 
	 * @author tangxbai
	 * @since 2022/06/22
	 */
	public enum DisplayFormat implements AbstractEnum {
		HEX, DEC
	}

	/**
	 * Data scope mode
	 * 
	 * @author tangxbai
	 * @since 2022/06/22
	 */
	public enum ScopeMode implements AbstractEnum {
		MONO, COLOR, COLOR2
	}

}
