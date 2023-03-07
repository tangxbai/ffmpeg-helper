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
import com.viiyue.ffmpeg.enums.CombMatch;
import com.viiyue.ffmpeg.enums.Parity;
import com.viiyue.ffmpeg.filter.AbstractColorFunction;
import com.viiyue.ffmpeg.util.Assert;

/**
 * <p>
 * Field matching filter for inverse telecine. It is meant to reconstruct the progressive frames from a
 * telecined stream. The filter does not drop duplicated frames, so to achieve a complete inverse telecine
 * fieldmatch needs to be followed by a decimation filter such as decimate in the filtergraph.
 * 
 * <p>
 * The separation of the field matching and the decimation is notably motivated by the possibility of
 * inserting a de-interlacing filter fallback between the two. If the source has mixed telecined and real
 * interlaced content, fieldmatch will not be able to match fields for the interlaced parts. But these
 * remaining combed frames will be marked as interlaced, and thus can be de-interlaced by a later filter such
 * as yadif before decimation.
 * 
 * <p>
 * In addition to the various configuration options, fieldmatch can take an optional second stream, activated
 * through the ppsrc option. If enabled, the frames reconstruction will be based on the fields and frames from
 * this second stream. This allows the first input to be pre-processed in order to help the various algorithms
 * of the filter, while keeping the output lossless (assuming the fields are matched properly). Typically, a
 * field-aware denoiser, or brightness/contrast adjustments can help.
 * 
 * <p>
 * Note that this filter uses the same algorithms as TIVTC/TFM (AviSynth project) and VIVTC/VFM (VapourSynth
 * project). The later is a light clone of TFM from which fieldmatch is based on. While the semantic and usage
 * are very close, some behaviour and options names can differ.
 * 
 * <p>
 * The decimate filter currently only works for constant frame rate input. If your input has mixed telecined
 * (30fps) and progressive content with a lower framerate like 24fps use the following filterchain to produce
 * the necessary cfr stream: dejudder,fps=30000/1001,fieldmatch,decimate.
 * 
 * @author tangxbai
 * @since 2022/07/04
 * @see <a href="https://ffmpeg.org/ffmpeg-filters.html#fieldmatch">ffmpeg-filters#fieldmatch</a>
 */
@Function( "fieldmatch" )
public class FieldMatch extends AbstractColorFunction<FieldMatch> {

	// Don't let anyone instantiate this class
	private FieldMatch() {}

	/**
	 * Quickly create an instances of {@link ExtractPlanes}
	 * 
	 * @return the {@link FieldMatch} instance
	 */
	public static final FieldMatch of() {
		return new FieldMatch();
	}

	/**
	 * <p>
	 * Specify the assumed field order of the input stream
	 * 
	 * <p>
	 * Note that it is sometimes recommended not to trust the parity announced by the stream, default value is
	 * {@link FieldOrder#AUTO}.
	 * 
	 * @apiNote (flags) order
	 * @param order the assumed field order
	 * @return the {@link FieldMatch} instance
	 */
	public FieldMatch order( Parity order ) {
		return super.addArg( "order", order );
	}

	/**
	 * <p>
	 * Set the matching mode or strategy to use. {@code pc} mode is the safest in the sense that it won’t risk
	 * creating jerkiness due to duplicate frames when possible, but if there are bad edits or blended fields
	 * it will end up outputting combed frames when a good match might actually exist. On the other hand,
	 * {@code pcn_ub} mode is the most risky in terms of creating jerkiness, but will almost always find a
	 * good frame if there is one. The other values are all somewhere in between {@code pc} and {@code pcn_ub}
	 * in terms of risking jerkiness and creating duplicate frames versus finding good matches in sections
	 * with bad edits, orphaned fields, blended fields, etc.
	 * 
	 * <p>
	 * More details about {@code p/c/n/u/b} are available in <font color="green">p/c/n/u/b meaning</font>
	 * section.
	 * 
	 * <p>
	 * The parenthesis at the end indicate the matches that would be used for that mode assuming order=tff
	 * (and field on auto or top).
	 * 
	 * <p>
	 * In terms of speed pc mode is by far the fastest and pcn_ub is the slowest, default value is
	 * {@link FieldMode#PC_N}.
	 * 
	 * @apiNote (flags) mode
	 * @param mode the hint mode
	 * @return the {@link FieldMatch} instance
	 */
	public FieldMatch mode( FieldMode mode ) {
		return super.addArg( "mode", mode );
	}

	/**
	 * <p>
	 * Mark the main input stream as a pre-processed input, and enable the secondary input stream as the clean
	 * source to pick the fields from. See the filter introduction for more details. It is similar to the
	 * clip2 feature from VFM/TFM.
	 * 
	 * <p>
	 * Default value is {@code false} (disabled).
	 * 
	 * @apiNote (boolean) ppsrc
	 * @return the {@link FieldMatch} instance
	 */
	public FieldMatch ppsrc() {
		return super.enable( "ppsrc" );
	}

	/**
	 * Set the field to match from. It is recommended to set this to the same value as order unless you
	 * experience matching failures with that setting. In certain circumstances changing the field that is
	 * used to match from can have a large impact on matching performance.
	 * 
	 * @apiNote (flags) match
	 * @param match the field match mode
	 * @return the {@link FieldMatch} instance
	 */
	public FieldMatch field( FieldMatcher match ) {
		return super.addArg( "match", match );
	}

	/**
	 * <p>
	 * Set whether or not chroma is included during the match comparisons. In most cases it is recommended to
	 * leave this enabled. You should set this to 0 only if your clip has bad chroma problems such as heavy
	 * rainbowing or other artifacts. Setting this to 0 could also be used to speed things up at the cost of
	 * some accuracy.
	 * 
	 * <p>
	 * Default value is {@code true}.
	 * 
	 * @apiNote (boolean) mchroma
	 * @return the {@link FieldMatch} instance
	 */
	public FieldMatch nonMatchChroma() {
		return super.disable( "mchroma" );
	}

	/**
	 * These define an exclusion band which excludes the lines between {@code y0} and {@code y1} from being
	 * included in the field matching decision. An exclusion band can be used to ignore subtitles, a logo, or
	 * other things that may interfere with the matching. {@code y0} sets the starting scan line and
	 * {@code y1} sets the ending line; all lines in between {@code y0} and y1 (including y0 and y1) will be
	 * ignored. Setting y0 and y1 to the same value will disable the feature. {@code y0} and {@code y1}
	 * defaults to <b>0</b>.
	 * 
	 * @apiNote (int) y0/y1
	 * @param y0Line the start line
	 * @param y1Line the end line
	 * @return the {@link FieldMatch} instance
	 */
	public FieldMatch scan( int y0Line, int y1Line ) {
		return super.addArg( "y0", y0Line ).addArg( "y1", y1Line );
	}

	/**
	 * <p>
	 * Set the scene change detection threshold as a percentage of maximum change on the luma plane. Good
	 * values are in the [8.0, 14.0] range. Scene change detection is only relevant in case combmatch=sc. The
	 * range for scthresh is [0.0, 100.0].
	 * 
	 * <p>
	 * Default value is <b>12.0</b>.
	 * 
	 * @apiNote (double) scthresh
	 * @param threshold the scene change detection threshold
	 * @return the {@link FieldMatch} instance
	 */
	public FieldMatch sceneChangeThreshold( double threshold ) {
		Assert.rangeCheck( threshold, 0.0, 100.0 );
		return super.addArg( "scthresh", threshold );
	}

	/**
	 * When {@code combatch} is not {@link CombMatch#NONE}, {@code fieldmatch} will take into account
	 * the combed scores of matches when deciding what match to use as the final match.
	 * 
	 * @apiNote (flags) combmatch
	 * @param match the combination mode
	 * @return the {@link FieldMatch} instance
	 */
	public FieldMatch combMatch( CombMatch match ) {
		return super.addArg( "combmatch", match );
	}

	/**
	 * Force {@code fieldmatch} to calculate the combed metrics for certain matches and print them. This
	 * setting is known as micout in TFM/VFM vocabulary
	 * 
	 * @apiNote (flags) combdbg
	 * @param match the combination debug mode
	 * @return the {@link FieldMatch} instance
	 */
	public FieldMatch combDebug( CombinationDebug debug ) {
		return super.addArg( "combdbg", debug );
	}

	/**
	 * <p>
	 * This is the area combing threshold used for combed frame detection. This essentially controls how
	 * "strong" or "visible" combing must be to be detected. Larger values mean combing must be more visible
	 * and smaller values mean combing can be less visible or strong and still be detected. Valid settings are
	 * from -1 (every pixel will be detected as combed) to 255 (no pixel will be detected as combed). This is
	 * basically a pixel difference value. A good range is [8, 12].
	 * 
	 * <p>
	 * The default value is <b>9</b>.
	 * 
	 * @apiNote (int) threshold
	 * @param threshold the area combing threshold
	 * @return the {@link FieldMatch} instance
	 */
	public FieldMatch combThreshold( int threshold ) {
		return super.addArg( "cthresh", threshold );
	}

	/**
	 * <p>
	 * Sets whether or not chroma is considered in the combed frame decision. Only disable this if your source
	 * has chroma problems (rainbowing, etc.) that are causing problems for the combed frame detection with
	 * chroma enabled. Actually, using chroma=0 is usually more reliable, except for the case where there is
	 * chroma only combing in the source.
	 * 
	 * <p>
	 * Default value is {@code false} (disabled).
	 * 
	 * @apiNote (boolean) chroma
	 * @return the {@link FieldMatch} instance
	 */
	public FieldMatch chroma() {
		return super.enable( "chroma" );
	}

	/**
	 * <p>
	 * Respectively set the x-axis and y-axis size of the window used during combed frame detection. This has
	 * to do with the size of the area in which combpel pixels are required to be detected as combed for a
	 * frame to be declared combed. See the combpel parameter description for more info. Possible values are
	 * any number that is a power of 2 starting at 4 and going up to 512.
	 * 
	 * <p>
	 * The default value is <b>16</b>.
	 * 
	 * @apiNote (int) blockx/blocky
	 * @param blockX the x-axis size
	 * @param blockY the y-axis size
	 * @return the {@link FieldMatch} instance
	 */
	public FieldMatch axis( int blockX, int blockY ) {
		return super.addArg( "blockx", blockX ).addArg( "blocky", blockY );
	}

	/**
	 * The number of combed pixels inside any of the blocky by blockx size blocks on the frame for the frame
	 * to be detected as combed. While cthresh controls how "visible" the combing must be, this setting
	 * controls "how much" combing there must be in any localized area (a window defined by the blockx and
	 * blocky settings) on the frame. Minimum value is 0 and maximum is <font color="green">blocky x
	 * blockx</font> (at which point no frames will ever be detected as combed). This setting is known as MI
	 * in TFM/VFM vocabulary.
	 * 
	 * <p>
	 * The default value is <b>80</b>.
	 * 
	 * @apiNote (int) combpel
	 * @param value the number of combed pixels
	 * @return the {@link FieldMatch} instance
	 */
	public FieldMatch combpel( int value ) {
		return super.addArg( "combpel", value );
	}

	/**
	 * Field match mode
	 *
	 * @author tangxbai
	 * @since 2022/07/04
	 */
	public enum FieldMatcher implements AbstractEnum {
		/** Automatic (same value as order) */
		AUTO,
		/** Match from the bottom field */
		TOP,
		/** Match from the top field */
		BOTTOM
	}

	/**
	 * Combination match mode
	 *
	 * @author tangxbai
	 * @since 2022/07/04
	 */
	public enum CombinationDebug implements AbstractEnum {
		/** No forced calculation */
		NONE,
		/** Force p/c/n calculations */
		PCN,
		/** Force p/c/n/u/b calculations */
		PCNUB
	}

	/**
	 * Assumed field order
	 *
	 * @author tangxbai
	 * @since 2022/07/04
	 */
	public enum FieldMode implements AbstractEnum {
		/** 2-way matching (p/c) */
		PC,
		/** 2-way matching, and trying 3rd match if still combed (p/c + n) */
		PC_N,
		/** 2-way matching, and trying 3rd match (same order) if still combed (p/c + u) */
		PC_U,
		/**
		 * 2-way matching, trying 3rd match if still combed, and trying 4th/5th matches if still combed (p/c +
		 * n + u/b)
		 */
		PC_N_UB,
		/** 3-way matching (p/c/n) */
		PCN,
		/**
		 * 3-way matching, and trying 4th/5th matches if all 3 of the original matches are detected as combed
		 * (p/c/n + u/b)
		 */
		PCN_UB
	}

}
