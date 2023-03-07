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

import java.util.Map;
import java.util.StringJoiner;

import org.apache.commons.collections.MapUtils;

import com.viiyue.ffmpeg.annotation.Function;
import com.viiyue.ffmpeg.common.Const;
import com.viiyue.ffmpeg.filter.AbstractFunction;
import com.viiyue.ffmpeg.util.Helper;

/**
 * <p>
 * Draw subtitles on top of input video using the libass library.
 * 
 * <p>
 * To enable compilation of this filter you need to configure FFmpeg with {@code --enable-libass}.
 * 
 * <p>
 * This filter also requires a build with libavcodec and libavformat to convert the passed subtitles file to
 * ASS (Advanced Substation Alpha) subtitles format.
 * 
 * @author tangxbai
 * @since 2022/06/08
 * @see <a href= "https://ffmpeg.org/ffmpeg-filters.html#subtitles-1">ffmpeg-filters#subtitles</a>
 */
@Function( "subtitles" )
public class Subtitles extends AbstractFunction<Subtitles> {

	// Don't let anyone instantiate this class
	private Subtitles() {}

	// DO NOTHING
	protected Subtitles( Object doNothing ) {}

	/**
	 * Quickly create an instances of {@link Subtitles}
	 * 
	 * @apiNote (string) filename, f
	 * @param file the subtitles file path
	 * @return the {@link Subtitles} instance
	 */
	public static Subtitles of( String file ) {
		return new Subtitles().addArg( "f", file ); // filename, f
	}

	/**
	 * <p>
	 * Specify the size of the original video, the video for which the ASS file was composed. For the syntax
	 * of this option, check the
	 * <a href="https://ffmpeg.org/ffmpeg-utils.html#video-size-syntax">(ffmpeg-utils) "Video size" section in
	 * the ffmpeg-utils manual</a>.
	 * 
	 * <p>
	 * Due to a misdesign in ASS aspect ratio arithmetic, this is necessary to correctly scale the fonts if
	 * the aspect ratio has been changed.
	 * 
	 * @apiNote (string) original_size
	 * @param width  the width of the original video size
	 * @param height the height of the original video size
	 * @return the {@link Subtitles} instance
	 */
	public Subtitles size( int width, int height ) {
		return super.addArg( "original_size", width + "x" + height );
	}

	/**
	 * <p>
	 * Set a directory path containing fonts that can be used by the filter.
	 * 
	 * <p>
	 * These fonts will be used in addition to whatever the font provider uses.
	 * 
	 * @apiNote (string) fontsdir
	 * @param fontDirectory the font root directory
	 * @return the {@link Subtitles} instance
	 */
	public Subtitles dir( String fontDirectory ) {
		return super.addArg( "fontsdir", Helper.escape( fontDirectory ) );
	}

	/**
	 * Set subtitles input character encoding. subtitles filter only. Only useful if not UTF-8.
	 * 
	 * @apiNote (string) charenc
	 * @param charset the subtitles input character
	 * @return the {@link Subtitles} instance
	 */
	public Subtitles encoding( String charset ) {
		return super.addArg( "charenc", charset );
	}

	/**
	 * Set subtitles stream index, {@code subtitles} filter only. The index value must greater the or equal to
	 * -1.
	 * 
	 * @apiNote (int) stream_index, si
	 * @param index the subtitles filter index
	 * @return the {@link Subtitles} instance
	 */
	public Subtitles streamIndex( int index ) {
		return super.addArg( "si", index );
	}

	/**
	 * <p>
	 * Override default style or script info parameters of the subtitles.
	 * 
	 * <p>
	 * It accepts a string containing ASS style format KEY=VALUE couples separated by ",".
	 * 
	 * @apiNote (string) force_style
	 * @param styles the ASS style
	 * @return the {@link Subtitles} instance
	 */
	public Subtitles styles( Map<String, Object> styles ) {
		if ( MapUtils.isNotEmpty( styles ) ) {
			StringJoiner joiner = new StringJoiner( Const.PART_SEPARATOR );
			styles.forEach( ( p, v ) -> joiner.add( p + Const.VALUE_SEPARATOR + v ) );
			return super.addArg( "force_style", Helper.escape( joiner ) );
		}
		return this;
	}

}
