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
import com.viiyue.ffmpeg.util.Assert;

/**
 * <p>
 * Apply cross fade from one input video stream to another input video stream. The cross fade is applied for
 * specified duration.
 * 
 * <p>
 * Both inputs must be constant frame-rate and have the same resolution, pixel format, frame rate and
 * time-base.
 * 
 * @author tangxbai
 * @since 2022/06/07
 * @see <a href="https://ffmpeg.org/ffmpeg-filters.html#xfade">ffmpeg-filters#xfade</a>
 */
@Function( "xfade" )
public class Xfade extends AbstractFunction<Xfade> {

	// Don't let anyone instantiate this class
	private Xfade() {}

	/**
	 * Quickly create an instances of {@link Xfade}
	 * 
	 * @param effector the transition effect
	 * @return the {@link Xfade} instance
	 */
	public static final Xfade of( Effector effector ) {
		return new Xfade().addArg( "transition", effector );
	}

	/**
	 * Quickly create an instances of {@link Xfade}
	 * 
	 * @param effector the transition effect
	 * @param duration the transition duration
	 * @return the {@link Xfade} instance
	 */
	public static final Xfade of( Effector effector, double duration ) {
		return new Xfade().addArg( "transition", effector ).duration( duration );
	}

	/**
	 * Quickly create an instances of {@link Xfade}
	 * 
	 * @param effector the transition effect
	 * @param offset   the transition start position
	 * @param duration the transition duration
	 * @return the {@link Xfade} instance
	 */
	public static final Xfade of( Effector effector, double offset, double duration ) {
		return new Xfade().addArg( "transition", effector ).offset( offset ).duration( duration );
	}

	/**
	 * Set cross fade start relative to first input stream in seconds, default offset is 0.
	 * 
	 * @param offset the cross fade start relative
	 * @return the {@link Xfade} instance
	 */
	public Xfade offset( double offset ) {
		return super.addArg( "offset", offset );
	}

	/**
	 * Set cross fade duration in seconds, the range is 0 to 60 seconds, default duration is 1 second.
	 * 
	 * @param duration the cross fade duration
	 * @return the {@link Xfade} instance
	 */
	public Xfade duration( double duration ) {
		Assert.rangeCheck( duration, 0, 60 );
		return super.addArg( "duration", duration );
	}

	/**
	 * Set expression for custom transition effect.
	 * 
	 * <p>
	 * The expressions can use the following variables and functions:
	 * 
	 * <pre>
	 * X, Y --- the coordinates of the current sample.
	 * W,H ---- the width and height of the image.
	 * P ------ progress of transition effect.
	 * PLANE -- currently processed plane.
	 * A ------ return value of first input at current location and plane.
	 * B ------ return value of second input at current location and plane.
	 *
	 * a0(x, y) \
	 * a1(x, y)  \
	 * a2(x, y)  / Return the value of the pixel at location (x,y) of the first/second/third/fourth component of first input.
	 * a3(x, y) / 
	 *
	 * b0(x, y) \
	 * b1(x, y)  \
	 * b2(x, y)  / Return the value of the pixel at location (x,y) of the first/second/third/fourth component of second input.
	 * b3(x, y) /
	 * </pre>
	 * 
	 * @param duration the cross fade duration
	 * @return the {@link Xfade} instance
	 */
	public Xfade expression( String expression ) {
		return super.addArg( "expr", expression );
	}

	/**
	 * Video transition animation set
	 * 
	 * @author tangxbai
	 * @since 2022/04/13
	 */
	public enum Effector implements AbstractEnum {

		/**
		 * <img src= "https://trac.ffmpeg.org/raw-attachment/wiki/Xfade/fade.gif"/>
		 */
		FADE( "fade" ),

		/**
		 * <img src= "https://trac.ffmpeg.org/raw-attachment/wiki/Xfade/fadeblack.gif"/>
		 */
		FADE_BLACK( "fadeblack" ),

		/**
		 * <img src= "https://trac.ffmpeg.org/raw-attachment/wiki/Xfade/fadewhite.gif"/>
		 */
		FADE_WHITE( "fadewhite" ),

		/**
		 * <img src= "https://trac.ffmpeg.org/raw-attachment/wiki/Xfade/fadegrays.gif"/>
		 */
		FADE_GRAYS( "fadegrays" ),

		/**
		 * <img src= "https://trac.ffmpeg.org/raw-attachment/wiki/Xfade/distance.gif"/>
		 */
		DISTANCE( "distance" ),

		/**
		 * <img src= "https://trac.ffmpeg.org/raw-attachment/wiki/Xfade/wipeleft.gif"/>
		 */
		WIPE_LEFT( "wipeleft" ),

		/**
		 * <img src= "https://trac.ffmpeg.org/raw-attachment/wiki/Xfade/wiperight.gif"/>
		 */
		WIPE_RIGHT( "wiperight" ),

		/**
		 * <img src= "https://trac.ffmpeg.org/raw-attachment/wiki/Xfade/wipeup.gif"/>
		 */
		WIPE_UP( "wipeup" ),

		/**
		 * <img src= "https://trac.ffmpeg.org/raw-attachment/wiki/Xfade/wipedown.gif"/>
		 */
		WIPE_DOWN( "wipedown" ),

		/**
		 * <img src= "https://trac.ffmpeg.org/raw-attachment/wiki/Xfade/slideleft.gif"/>
		 */
		SLIDE_LEFT( "slideleft" ),

		/**
		 * <img src= "https://trac.ffmpeg.org/raw-attachment/wiki/Xfade/slideright.gif"/>
		 */
		SLIDE_RIGHT( "slideright" ),

		/**
		 * <img src= "https://trac.ffmpeg.org/raw-attachment/wiki/Xfade/slideup.gif"/>
		 */
		SLIDE_UP( "slideup" ),

		/**
		 * <img src= "https://trac.ffmpeg.org/raw-attachment/wiki/Xfade/slidedown.gif"/>
		 */
		SLIDE_DOWN( "slidedown" ),

		/**
		 * <img src= "https://trac.ffmpeg.org/raw-attachment/wiki/Xfade/smoothleft.gif"/>
		 */
		SMOOTH_LEFT( "smoothleft" ),

		/**
		 * <img src= "https://trac.ffmpeg.org/raw-attachment/wiki/Xfade/smoothright.gif"/>
		 */
		SMOOTH_RIGHT( "smoothright" ),

		/**
		 * <img src= "https://trac.ffmpeg.org/raw-attachment/wiki/Xfade/smoothup.gif"/>
		 */
		SMOOTH_UP( "smoothup" ),

		/**
		 * <img src= "https://trac.ffmpeg.org/raw-attachment/wiki/Xfade/smoothdown.gif"/>
		 */
		SMOOTH_DOWN( "smoothdown" ),

		/**
		 * <img src= "https://trac.ffmpeg.org/raw-attachment/wiki/Xfade/rectcrop.gif"/>
		 */
		RECT_CROP( "rectcrop" ),

		/**
		 * <img src= "https://trac.ffmpeg.org/raw-attachment/wiki/Xfade/circlecrop.gif"/>
		 */
		CIRCLE_CROP( "circlecrop" ),

		/**
		 * <img src= "https://trac.ffmpeg.org/raw-attachment/wiki/Xfade/circleopen.gif"/>
		 */
		CIRCLE_OPEN( "circleopen" ),

		/**
		 * <img src= "https://trac.ffmpeg.org/raw-attachment/wiki/Xfade/circleclose.gif"/>
		 */
		CIRCLE_CLOSE( "circleclose" ),

		/**
		 * <img src= "https://trac.ffmpeg.org/raw-attachment/wiki/Xfade/horzopen.gif"/>
		 */
		HORZ_OPEN( "horzopen" ),

		/**
		 * <img src= "https://trac.ffmpeg.org/raw-attachment/wiki/Xfade/horzclose.gif"/>
		 */
		HORZ_CLOSE( "horzclose" ),

		/**
		 * <img src= "https://trac.ffmpeg.org/raw-attachment/wiki/Xfade/vertopen.gif"/>
		 */
		VERT_OPEN( "vertopen" ),

		/**
		 * <img src= "https://trac.ffmpeg.org/raw-attachment/wiki/Xfade/vertclose.gif"/>
		 */
		VERT_CLOSE( "vertclose" ),

		/**
		 * <img src= "https://trac.ffmpeg.org/raw-attachment/wiki/Xfade/diagbl.gif"/>
		 */
		DIAG_BL( "diagbl" ),

		/**
		 * <img src= "https://trac.ffmpeg.org/raw-attachment/wiki/Xfade/diagbr.gif"/>
		 */
		DIAG_BR( "diagbr" ),

		/**
		 * <img src= "https://trac.ffmpeg.org/raw-attachment/wiki/Xfade/diagtl.gif"/>
		 */
		DIAG_TL( "diagtl" ),

		/**
		 * <img src= "https://trac.ffmpeg.org/raw-attachment/wiki/Xfade/diagtr.gif"/>
		 */
		DIAG_TR( "diagtr" ),

		/**
		 * <img src= "https://trac.ffmpeg.org/raw-attachment/wiki/Xfade/hlslice.gif"/>
		 */
		HL_SLICE( "hlslice" ),

		/**
		 * <img src= "https://trac.ffmpeg.org/raw-attachment/wiki/Xfade/hrslice.gif"/>
		 */
		HR_SLICE( "hrslice" ),

		/**
		 * <img src= "https://trac.ffmpeg.org/raw-attachment/wiki/Xfade/vuslice.gif"/>
		 */
		VU_SLICE( "vuslice" ),

		/**
		 * <img src= "https://trac.ffmpeg.org/raw-attachment/wiki/Xfade/vdslice.gif"/>
		 */
		VD_SLICE( "vdslice" ),

		/**
		 * <img src= "https://trac.ffmpeg.org/raw-attachment/wiki/Xfade/dissolve.gif"/>
		 */
		DISSOLVE( "dissolve" ),

		/**
		 * <img src= "https://trac.ffmpeg.org/raw-attachment/wiki/Xfade/pixelize.gif"/>
		 */
		PIXELIZE( "pixelize" ),

		/**
		 * <img src= "https://trac.ffmpeg.org/raw-attachment/wiki/Xfade/radial.gif"/>
		 */
		RADIAL( "radial" ),

		/**
		 * <img src= "https://trac.ffmpeg.org/raw-attachment/wiki/Xfade/hblur.gif"/>
		 */
		HBLUR( "hblur" ),

		/**
		 * <img src= "https://trac.ffmpeg.org/raw-attachment/wiki/Xfade/wipetl.gif"/>
		 */
		WIPE_TL( "wipetl" ),

		/**
		 * <img src= "https://trac.ffmpeg.org/raw-attachment/wiki/Xfade/wipetr.gif"/>
		 */
		WIPE_TR( "wipetr" ),

		/**
		 * <img src= "https://trac.ffmpeg.org/raw-attachment/wiki/Xfade/wipebl.gif"/>
		 */
		WIPE_BL( "wipebl" ),

		/**
		 * <img src="https://trac.ffmpeg.org/raw-attachment/wiki/Xfade/wipebr.gif"/>
		 */
		WIPE_BR( "wipebr" ),

		/**
		 * <img src= "https://trac.ffmpeg.org/raw-attachment/wiki/Xfade/squeezev.gif"/>
		 */
		SQUEEZE_VERT( "squeezev" ),

		/**
		 * <img src= "https://trac.ffmpeg.org/raw-attachment/wiki/Xfade/squeezeh.gif"/>
		 */
		SQUEEZE_HORZ( "squeezeh" ),

		/**
		 * <img src="https://trac.ffmpeg.org/raw-attachment/wiki/Xfade/zoomin.gif"/>
		 */
		ZOOM_IN( "zoomin" );

		private String animation;

		Effector( String animation ) {
			this.animation = animation;
		}

		@Override
		public String command() {
			return this.animation;
		}

	}

}
