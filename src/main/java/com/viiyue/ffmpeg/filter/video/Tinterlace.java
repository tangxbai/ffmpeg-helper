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

import com.viiyue.ffmpeg.annotation.Alias;
import com.viiyue.ffmpeg.annotation.Function;
import com.viiyue.ffmpeg.common.AbstractEnum;
import com.viiyue.ffmpeg.filter.AbstractFunction;

/**
 * <p>
 * Perform various types of temporal field interlacing.
 * 
 * <p>
 * Frames are counted starting from 1, so the first input frame is considered odd.
 * 
 * @author tangxbai
 * @since 2022/08/05
 * @see <a href="https://ffmpeg.org/ffmpeg-filters.html#tinterlace">ffmpeg-filters#tinterlace</a>
 */
@Function( "tinterlace" )
public class Tinterlace extends AbstractFunction<Tinterlace> {

	// Don't let anyone instantiate this class
	private Tinterlace() {}

	/**
	 * <p>
	 * Quickly create an instances of {@link Tinterlace}
	 * 
	 * <p>
	 * Specify the mode of the interlacing. This option can also be specified as a value alone.
	 * 
	 * @apiNote (flags) mode
	 * @param mode the mode interlace mode
	 * @return the {@link Tinterlace} instance
	 * @see InterlaceMode
	 */
	public static final Tinterlace mode( InterlaceMode mode ) {
		return new Tinterlace().addArg( "mode", mode );
	}

	/**
	 * Specify flags influencing the filter process
	 * 
	 * @apiNote (flags) flags
	 * @param mode the mode interlace mode
	 * @return the {@link Tinterlace} instance
	 * @see InfluencingFlag
	 */
	public Tinterlace flags( InfluencingFlag flag ) {
		return super.addArg( "flags", flag );
	}

	/**
	 * Influencing flag
	 * 
	 * @author tangxbai
	 * @since 2022/08/05
	 */
	public enum InfluencingFlag implements AbstractEnum {
		/**
		 * Enable linear vertical low-pass filtering in the filter. Vertical low-pass filtering is required
		 * when creating an interlaced destination from a progressive source which contains high-frequency
		 * vertical detail. Filtering will reduce interlace ’twitter’ and Moire patterning.
		 */
		@Alias( "vlpf" )
		LOW_PASS_FILTER,
		/**
		 * Enable complex vertical low-pass filtering. This will slightly less reduce interlace ’twitter’ and
		 * Moire patterning but better retain detail and subjective sharpness impression.
		 */
		@Alias( "cvlpf" )
		COMPLEX_FILTER,
		/**
		 * Bypass already interlaced frames, only adjust the frame rate
		 */
		BYPASS_IL
	}

	/**
	 * Interlace mode
	 * 
	 * @author tangxbai
	 * @since 2022/08/05
	 */
	public enum InterlaceMode implements AbstractEnum {
		/**
		 * <p>
		 * Move odd frames into the upper field, even into the lower field, generating a double height frame
		 * at half frame rate.
		 * 
		 * <pre style="background: white; border: 1px solid black; margin: 0; border-radius: 5px">
		 * 
		 *  ------> time
		 *  
		 * Input:
		 * Frame 1         Frame 2         Frame 3         Frame 4
		 * 
		 * 11111           22222           33333           44444
		 * 11111           22222           33333           44444
		 * 11111           22222           33333           44444
		 * 11111           22222           33333           44444
		 * 
		 * Output:
		 * 11111                           33333
		 * 22222                           44444
		 * 11111                           33333
		 * 22222                           44444
		 * 11111                           33333
		 * 22222                           44444
		 * 11111                           33333
		 * 22222                           44444
		 * </pre>
		 */
		MERGE,

		/**
		 * <p>
		 * Only output odd frames, even frames are dropped, generating a frame with unchanged height at half
		 * frame rate.
		 * 
		 * <pre style="background: white; border: 1px solid black; margin: 0; border-radius: 5px">
		 * 
		 *  ------> time
		 *  
		 * Input:
		 * Frame 1         Frame 2         Frame 3         Frame 4
		 * 
		 * 11111           22222           33333           44444
		 * 11111           22222           33333           44444
		 * 11111           22222           33333           44444
		 * 11111           22222           33333           44444
		 * 
		 * Output:
		 * 11111                           33333
		 * 11111                           33333
		 * 11111                           33333
		 * 11111                           33333
		 * </pre>
		 */
		DROP_EVEN,

		/**
		 * <p>
		 * Only output odd frames, even frames are dropped, generating a frame with unchanged height at half
		 * frame rate.
		 * 
		 * <pre style="background: white; border: 1px solid black; margin: 0; border-radius: 5px">
		 * 
		 *  ------> time
		 *  
		 * Input:
		 * Frame 1         Frame 2         Frame 3         Frame 4
		 * 
		 * 11111           22222           33333           44444
		 * 11111           22222           33333           44444
		 * 11111           22222           33333           44444
		 * 11111           22222           33333           44444
		 * 
		 * Output:
		 *                 22222                           44444
		 *                 22222                           44444
		 *                 22222                           44444
		 *                 22222                           44444
		 * </pre>
		 */
		DROP_ODD,

		/**
		 * <p>
		 * Expand each frame to full height, but pad alternate lines with black, generating a frame with
		 * double height at the same input frame rate.
		 * 
		 * <pre style="background: white; border: 1px solid black; margin: 0; border-radius: 5px">
		 * 
		 *  ------> time
		 *  
		 * Input:
		 * Frame 1         Frame 2         Frame 3         Frame 4
		 * 
		 * 11111           22222           33333           44444
		 * 11111           22222           33333           44444
		 * 11111           22222           33333           44444
		 * 11111           22222           33333           44444
		 * 
		 * Output:
		 * 11111           .....           33333           .....
		 * .....           22222           .....           44444
		 * 11111           .....           33333           .....
		 * .....           22222           .....           44444
		 * 11111           .....           33333           .....
		 * .....           22222           .....           44444
		 * 11111           .....           33333           .....
		 * .....           22222           .....           44444
		 * </pre>
		 */
		PAD,

		/**
		 * <p>
		 * Interleave the upper field from odd frames with the lower field from even frames, generating a
		 * frame with unchanged height at half frame rate.
		 * 
		 * <pre style="background: white; border: 1px solid black; margin: 0; border-radius: 5px">
		 * 
		 *  ------> time
		 *  
		 * Input:
		 * Frame 1         Frame 2         Frame 3         Frame 4
		 * 
		 * 11111<-         22222           33333<-         44444
		 * 11111           22222<-         33333           44444<-
		 * 11111<-         22222           33333<-         44444
		 * 11111           22222<-         33333           44444<-
		 * 
		 * Output:
		 * 11111                           33333
		 * 22222                           44444
		 * 11111                           33333
		 * 22222                           44444
		 * </pre>
		 */
		INTERLEAVE_TOP,

		/**
		 * <p>
		 * Interleave the lower field from odd frames with the upper field from even frames, generating a
		 * frame with unchanged height at half frame rate.
		 * 
		 * <pre style="background: white; border: 1px solid black; margin: 0; border-radius: 5px">
		 * 
		 *  ------> time
		 *  
		 * Input:
		 * Frame 1         Frame 2         Frame 3         Frame 4
		 * 
		 * 11111           22222<-         33333           44444<-
		 * 11111<-         22222           33333<-         44444
		 * 11111           22222<-         33333           44444<-
		 * 11111<-         22222           33333<-         44444
		 * 
		 * Output:
		 * 22222                           44444
		 * 11111                           33333
		 * 22222                           44444
		 * 11111                           33333
		 * </pre>
		 */
		INTERLEAVE_BOTTOM,

		/**
		 * <p>
		 * Double frame rate with unchanged height. Frames are inserted each containing the second temporal
		 * field from the previous input frame and the first temporal field from the next input frame. This
		 * mode relies on the top_field_first flag. Useful for interlaced video displays with no field
		 * synchronisation.
		 * 
		 * <pre style="background: white; border: 1px solid black; margin: 0; border-radius: 5px">
		 * 
		 *  ------> time
		 *  
		 * Input:
		 * Frame 1         Frame 2         Frame 3         Frame 4
		 * 
		 * 11111           22222           33333           44444
		 *  11111           22222           33333           44444
		 * 11111           22222           33333           44444
		 *  11111           22222           33333           44444
		 * 
		 * Output:
		 * 11111   22222   22222   33333   33333   44444   44444
		 *  11111   11111   22222   22222   33333   33333   44444
		 * 11111   22222   22222   33333   33333   44444   44444
		 *  11111   11111   22222   22222   33333   33333   44444
		 * </pre>
		 */
		INTERLACEX2,

		/**
		 * <p>
		 * Move odd frames into the upper field, even into the lower field, generating a double height frame
		 * at same frame rate.
		 * 
		 * <pre style="background: white; border: 1px solid black; margin: 0; border-radius: 5px">
		 * 
		 *  ------> time
		 *  
		 * Input:
		 * Frame 1         Frame 2         Frame 3         Frame 4
		 * 
		 * 11111           22222           33333           44444
		 * 11111           22222           33333           44444
		 * 11111           22222           33333           44444
		 * 11111           22222           33333           44444
		 * 
		 * Output:
		 * 11111           33333           33333           55555
		 * 22222           22222           44444           44444
		 * 11111           33333           33333           55555
		 * 22222           22222           44444           44444
		 * 11111           33333           33333           55555
		 * 22222           22222           44444           44444
		 * 11111           33333           33333           55555
		 * 22222           22222           44444           44444
		 * </pre>
		 */
		MERGEX2
	}

}
