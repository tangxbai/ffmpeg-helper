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
 * Apply a fade-in/out effect to the input video.
 * 
 * @author tangxbai
 * @since 2022/06/30
 * @see <a href="https://ffmpeg.org/ffmpeg-filters.html#fade">ffmpeg-filters#fade</a>
 */
@Function( "fade" )
public class Fade extends AbstractColorFunction<Fade> {

	// Don't let anyone instantiate this class
	private Fade() {}

	/**
	 * Apply a fade-in effect to the input video
	 * 
	 * @apiNote (string) type, t
	 * @return the {@link Fade} instance
	 */
	public static final Fade in() {
		return new Fade().addArg( "t", "in" );
	}

	/**
	 * Apply a fade-out effect to the input video
	 * 
	 * @apiNote (string) type, t
	 * @return the {@link Fade} instance
	 */
	public static final Fade out() {
		return new Fade().addArg( "t", "out" );
	}

	/**
	 * Specify the timestamp (in seconds) of the frame to start to apply the fade effect
	 * 
	 * @apiNote (double) start_frame, st
	 * @apiNote (double) duration, d
	 * @param time     the frame to start to apply the fade effect
	 * @param duration the fade effect has to last
	 * @return the {@link Fade} instance
	 */
	public Fade at( double time, double duration ) {
		if ( time > 0D ) {
			startTime( time );
		}
		if ( duration > 0D ) {
			duration( duration );
		}
		return this;
	}

	/**
	 * Specify the number of the frame to start applying the fade effect at
	 * 
	 * @apiNote (int) start_frame, s
	 * @apiNote (int) nb_frames, n
	 * @param index the start frame index
	 * @param num   The number of frames that the fade effect lasts
	 * @return the {@link Fade} instance
	 */
	public Fade frame( int index, int num ) {
		if ( index > 0 ) {
			startFrame( index );
		}
		if ( num > 0 ) {
			totalFrames( num );
		}
		return this;
	}

	/**
	 * Specify the number of the frame to start applying the fade effect at, default is <b>0</b>.
	 * 
	 * @apiNote (int) start_frame, s
	 * @param value The number of the frame
	 * @return the {@link Fade} instance
	 */
	public Fade startFrame( int value ) {
		return super.addArg( "s", value ); // start_frame, s
	}

	/**
	 * The number of frames that the fade effect lasts. At the end of the fade-in effect, the output video
	 * will have the same intensity as the input video. At the end of the fade-out transition, the output
	 * video will be filled with the selected color, default is <b>25</b>.
	 * 
	 * @apiNote (int) nb_frames, n
	 * @param value The number of frames that the fade effect lasts
	 * @return the {@link Fade} instance
	 */
	public Fade totalFrames( int value ) {
		return super.addArg( "n", value ); // nb_frames, n
	}

	/**
	 * If enable this option, fade only alpha channel, if one exists on the input.
	 * 
	 * @apiNote (boolean) alpha
	 * @return the {@link Fade} instance
	 */
	public Fade alpha() {
		return super.enable( "alpha" );
	}

	/**
	 * Specify the timestamp (in seconds) of the frame to start to apply the fade effect. If both
	 * {@code start_frame} and {@code start_time} are specified, the fade will start at whichever comes last,
	 * default is <b>0</b>.
	 * 
	 * @apiNote (double) start_frame, st
	 * @param value the frame to start to apply the fade effect
	 * @return the {@link Fade} instance
	 */
	public Fade startTime( double value ) {
		return super.addArg( "st", value ); // start_frame, st
	}

	/**
	 * <p>
	 * The number of seconds for which the fade effect has to last. At the end of the fade-in effect the
	 * output video will have the same intensity as the input video, at the end of the fade-out transition the
	 * output video will be filled with the selected color. If both duration and {@code nb_frames} are
	 * specified, duration is used.
	 * 
	 * <p>
	 * Default is <b>0</b> ({@code nb_frames} is used by default).
	 * 
	 * @apiNote (double) duration, d
	 * @param value the animation effect duration
	 * @return the {@link Fade} instance
	 */
	public Fade duration( double value ) {
		return super.addArg( "d", value ); // duration, d
	}

}
