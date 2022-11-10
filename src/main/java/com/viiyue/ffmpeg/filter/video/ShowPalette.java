package com.viiyue.ffmpeg.filter.video;

import com.viiyue.ffmpeg.annotation.Function;
import com.viiyue.ffmpeg.filter.AbstractFunction;

/**
 * Displays the 256 colors palette of each frame. This filter is only relevant for pal8 pixel format frames.
 * 
 * @author tangxbai
 * @since 2022/08/04
 * @see <a href="https://ffmpeg.org/ffmpeg-filters.html#showpalette">ffmpeg-filters#showpalette</a>
 */
@Function( "showpalette" )
public class ShowPalette extends AbstractFunction<ShowPalette> {

	// Don't let anyone instantiate this class
	private ShowPalette() {}

	/**
	 * Quickly create an instances of {@link ShowPalette}
	 * 
	 * @apiNote (int) width
	 * @apiNote (int) height
	 * @param width  the palette size of width
	 * @param height the palette size of height
	 * @return the {@link ShowPalette} instance
	 */
	public static final ShowPalette of( int width, int height ) {
		return new ShowPalette().addArg( "s", width + "x" + height );
	}

}
