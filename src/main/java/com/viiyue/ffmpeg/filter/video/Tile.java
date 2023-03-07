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
import com.viiyue.ffmpeg.filter.AbstractColorFunction;

/**
 * Tile several successive frames together.
 * 
 * @author tangxbai
 * @since 2022/06/02
 * @see <a href="https://ffmpeg.org/ffmpeg-filters.html#tile-1">ffmpeg-filters#tile</a>
 */
@Function( "tile" )
public class Tile extends AbstractColorFunction<Tile> {

	// Don't let anyone instantiate this class
	private Tile() {}

	/**
	 * <p>
	 * Quickly create an instances of {@link Tile}
	 * 
	 * <p>
	 * Set the grid size in the form COLUMNSxROWS. Range is up to {@link Integer#MAX_VALUE} cells. Default is
	 * 6x5.
	 * 
	 * @apiNote (size) layout
	 * @param h the grid columns
	 * @param n the grid rows
	 * @return the {@link Tile} instance
	 */
	public static final Tile the( int h, int n ) {
		return new Tile().addArg( null, h + "x" + n ); // layout
	}

	/**
	 * Set the maximum number of frames to render in the given area. It must be less than or equal to wxh. The
	 * default value is 0, meaning all the area will be used.
	 * 
	 * @param total the picture frame number
	 * @return the {@link Tile} instance
	 */
	public Tile show( int total ) {
		return super.addArg( "nb_frames", total );
	}

	/**
	 * Set the outer border margin in pixels. Value range is 0 to 1024, default is <b>0</b>.
	 * 
	 * @apiNote (int) margin
	 * @param value the margin value
	 * @return the {@link Tile} instance
	 */
	public Tile margin( int value ) {
		return super.addArg( "margin", value );
	}

	/**
	 * Set the inner border thickness (i.e. the number of pixels between frames). For more advanced padding
	 * options (such as having different values for the edges), refer to the pad video filter. Value range is
	 * 0 to 1024, default is <b>0</b>.
	 * 
	 * @apiNote (int) padding
	 * @param value the padding value
	 * @return the {@link Tile} instance
	 */
	public Tile padding( int value ) {
		return super.addArg( "padding", value );
	}

	/**
	 * Set the number of frames to initially be empty before displaying first output frame. This controls how
	 * soon will one get first output frame. The value must be between 0 and nb_frames-1, default is <b>0</b>.
	 * 
	 * @apiNote (int) init_padding
	 * @param value the padding value
	 * @return the {@link Tile} instance
	 */
	public Tile initPadding( int value ) {
		return super.addArg( "init_padding", value );
	}

	/**
	 * Set the number of frames to overlap when tiling several successive frames together. The value must be
	 * between 0 and nb_frames-1.
	 * 
	 * @apiNote (int) overlap
	 * @param overlap the overlap value( 0 ~ {nb_frames}-1 )
	 * @return the {@link Tile} instance
	 */
	public Tile overlap( int overlap ) {
		return super.addArg( "overlap", overlap );
	}

}
