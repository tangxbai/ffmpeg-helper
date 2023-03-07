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
import com.viiyue.ffmpeg.filter.AbstractColorFunction;

/**
 * Draw a graph using input video metadata
 * 
 * @author tangxbai
 * @since 2022/06/28
 * @see <a href="https://ffmpeg.org/ffmpeg-filters.html#drawgraph">ffmpeg-filters#drawgraph</a>
 */
@Function( "drawgraph" )
public class DrawGraph extends AbstractColorFunction<DrawGraph> {

	// Don't let anyone instantiate this class
	private DrawGraph() {}

	/**
	 * Quickly create an instances of {@link DrawGraph}
	 * 
	 * @return the {@link DrawGraph} instance
	 */
	public static final DrawGraph of() {
		return new DrawGraph();
	}

	/**
	 * Set 1st frame metadata key from which metadata values will be used to draw a graph
	 * 
	 * @apiNote (string) m1
	 * @param key the 1st metadata key
	 * @return the {@link DrawGraph} instance
	 */
	public DrawGraph md1( String key ) {
		return super.addArg( "m1", key );
	}

	/**
	 * Set 2nd frame metadata key from which metadata values will be used to draw a graph
	 * 
	 * @apiNote (string) m2
	 * @param key the 2nd metadata key
	 * @return the {@link DrawGraph} instance
	 */
	public DrawGraph md2( String key ) {
		return super.addArg( "m2", key );
	}

	/**
	 * Set 3rd frame metadata key from which metadata values will be used to draw a graph
	 * 
	 * @apiNote (string) m3
	 * @param key the 3rd metadata key
	 * @return the {@link DrawGraph} instance
	 */
	public DrawGraph md3( String key ) {
		return super.addArg( "m3", key );
	}

	/**
	 * Set 4th frame metadata key from which metadata values will be used to draw a graph
	 * 
	 * @apiNote (string) m4
	 * @param key the 4th metadata key
	 * @return the {@link DrawGraph} instance
	 */
	public DrawGraph md4( String key ) {
		return super.addArg( "m4", key );
	}

	/**
	 * Set 1st foreground color expression, default color is "<b>0xffff0000</b>". If you want set
	 * transparency, you can set it like this: "0xffffff@0.5".
	 * 
	 * @apiNote (string) fg1
	 * @param key the 1st foreground color expression
	 * @return the {@link DrawGraph} instance
	 */
	public DrawGraph fg1( String color ) {
		return super.addArg( "fg1", color );
	}

	/**
	 * Set 2nd foreground color expression, default color is "<b>0xff00ff00</b>". If you want set
	 * transparency, you can set it like this: "0xffffff@0.5".
	 * 
	 * @apiNote (string) fg2
	 * @param key the 2nd foreground color expression
	 * @return the {@link DrawGraph} instance
	 */
	public DrawGraph fg2( String color ) {
		return super.addArg( "fg2", color );
	}

	/**
	 * Set 3rd foreground color expression, default color is "<b>0xffff00ff</b>". If you want set
	 * transparency, you can set it like this: "0xffffff@0.5".
	 * 
	 * @apiNote (string) fg3
	 * @param key the 3rd foreground color expression
	 * @return the {@link DrawGraph} instance
	 */
	public DrawGraph fg3( String color ) {
		return super.addArg( "fg3", color );
	}

	/**
	 * Set 4th foreground color expression, default color is "<b>0xffffff00</b>". If you want set
	 * transparency, you can set it like this: "0xffffff@0.5".
	 * 
	 * @apiNote (string) fg4
	 * @param key the 4th foreground color expression
	 * @return the {@link DrawGraph} instance
	 */
	public DrawGraph fg4( String color ) {
		return super.addArg( "fg4", color );
	}

	/**
	 * Set minimal value of metadata value, default is <b>-1</b>;
	 * 
	 * @apiNote (double) min
	 * @param value the minimal value
	 * @return the {@link DrawGraph} instance
	 */
	public DrawGraph min( double value ) {
		return super.addArg( "min", value );
	}

	/**
	 * Set maximal value of metadata value, default is <b>1</b>;
	 * 
	 * @apiNote (double) max
	 * @param value the maximal value
	 * @return the {@link DrawGraph} instance
	 */
	public DrawGraph max( double value ) {
		return super.addArg( "max", value );
	}

	/**
	 * Set graph background color, default color is "<b>white</b>". If you want set transparency, you can set
	 * it like this: "black@0.5".
	 * 
	 * @apiNote (string) bg
	 * @param key the background color
	 * @return the {@link DrawGraph} instance
	 */
	public DrawGraph bg( String color ) {
		return super.addArg( "bg", color );
	}

	/**
	 * Set the graph mode
	 * 
	 * @apiNote (flags) mode
	 * @param key the graph mode
	 * @return the {@link DrawGraph} instance
	 * @see GraphMode
	 */
	public DrawGraph mode( GraphMode mode ) {
		return super.addArg( "mode", mode );
	}

	/**
	 * Set the slide mode
	 * 
	 * @apiNote (flags) slide
	 * @param key the graph mode
	 * @return the {@link DrawGraph} instance
	 * @see SlideMode
	 */
	public DrawGraph slide( SlideMode mode ) {
		return super.addArg( "slide", mode );
	}

	/**
	 * Set size of graph video, the default value is <b>900x256</b>.
	 * 
	 * @apiNote (string) size
	 * @param key the graph size
	 * @return the {@link DrawGraph} instance
	 */
	public DrawGraph size( int width, int height ) {
		return super.addArg( "size", width + "x" + height );
	}

	/**
	 * Set the output frame rate, the default value is <b>25</b>.
	 * 
	 * @apiNote (int) rate, r
	 * @param key the output frame size
	 * @return the {@link DrawGraph} instance
	 */
	public DrawGraph rate( int frameRate ) {
		return super.addArg( "r", frameRate ); // rate, r
	}

	/**
	 * Graph mode, including: {@link #BAR}, {@link #DOT}, {@link #LINE}.
	 *
	 * @author tangxbai
	 * @since 2022/06/28
	 */
	public enum GraphMode implements AbstractEnum {
		BAR, DOT, LINE
	}

	/**
	 * Slide mode, including: {@link #FRAME}, {@link #REPLACE}, {@link #SCROLL}, {@link #RSCROLL},
	 * {@link #PICTURE}.
	 *
	 * @author tangxbai
	 * @since 2022/06/28
	 */
	public enum SlideMode implements AbstractEnum {
		/** Draw new frame when right border is reached */
		FRAME,
		/** Replace old columns with new ones */
		REPLACE,
		/** Scroll from right to left */
		SCROLL,
		/** Scroll from left to right */
		RSCROLL,
		/** Draw single picture */
		PICTURE
	}

}
