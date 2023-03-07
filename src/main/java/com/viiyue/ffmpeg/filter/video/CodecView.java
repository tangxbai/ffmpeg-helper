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
import com.viiyue.ffmpeg.annotation.Nullable;
import com.viiyue.ffmpeg.common.AbstractEnum;
import com.viiyue.ffmpeg.common.Const;
import com.viiyue.ffmpeg.filter.AbstractFunction;

/**
 * <p>
 * Visualize information exported by some codecs. Some codecs can export information through frames using
 * side-data or other means.
 * 
 * <p>
 * For example, some MPEG based codecs export motion vectors through the export_mvs flag in the codec flags2
 * option.
 * 
 * @author tangxbai
 * @since 2022/06/15
 * @see <a href="https://ffmpeg.org/ffmpeg-filters.html#codecview">ffmpeg-filters#codecview</a>
 */
@Function( "codecview" )
public class CodecView extends AbstractFunction<CodecView> {

	// Don't let anyone instantiate this class
	private CodecView() {}

	/**
	 * Quickly create an instances of {@link CodecView}
	 * 
	 * @return the {@link CodecView} instance
	 */
	public static final CodecView the() {
		return new CodecView();
	}

	/**
	 * Display block partition structure using the luma plane
	 * 
	 * @apiNote (string) block
	 * @param value the string type value, it may be <b>null</b>.
	 * @return the {@link CodecView} instance
	 */
	public CodecView block( @Nullable String value ) {
		return super.addArg( "block", value );
	}

	/**
	 * Set motion vectors to visualize
	 * 
	 * @apiNote (flags) mv
	 * @param mvs the visualize motion vectors
	 * @return the {@link CodecView} instance
	 * @see MotionVector
	 */
	public CodecView motionVector( MotionVector ... mvs ) {
		return super.addArg2( "mv", Const.APPEND_SEPARATOR, mvs );
	}

	/**
	 * Set motion vectors type to visualize. Includes MVs from all frames unless specified by frame_type
	 * option.
	 * 
	 * @apiNote (flags) mv_type, mvt
	 * @param mvts the motion vector type
	 * @return the {@link CodecView} instance
	 * @see MotionVectorType
	 */
	public CodecView motionVectorType( MotionVectorType ... mvts ) {
		return super.addArg2( "mvt", Const.APPEND_SEPARATOR, mvts ); // mv_type, mvt
	}

	/**
	 * Set frame type to visualize motion vectors of
	 * 
	 * @apiNote (flags) frame_type, ft
	 * @param ft the frame type of visualize motion vectors
	 * @return the {@link CodecView} instance
	 * @see FrameType
	 */
	public CodecView frameType( FrameType ... fts ) {
		return super.addArg2( "ft", Const.APPEND_SEPARATOR, fts ); // frame_type, ft
	}

	/**
	 * Display quantization parameters using the chroma planes
	 * 
	 * @apiNote (string) qp
	 * @param value the string type value, it may be <b>null</b>.
	 * @return the {@link CodecView} instance
	 */
	public CodecView qp( @Nullable String value ) {
		return super.addArg( "qp", value );
	}

	/**
	 * Visualized motion vectors, there are flags available: "PF", "BF", "BB".
	 *
	 * @author tangxbai
	 * @since 2022/06/15
	 */
	public enum MotionVector implements AbstractEnum {
		/** forward predicted MVs of P-frames */
		PF,
		/** forward predicted MVs of B-frames */
		BF,
		/** backward predicted MVs of B-frames */
		BB
	}

	/**
	 * Visualized motion vectors, there are flags available: "FP", "BP".
	 *
	 * @author tangxbai
	 * @since 2022/06/15
	 */
	public enum MotionVectorType implements AbstractEnum {
		/** forward predicted MVs */
		FP,
		/** backward predicted MVs */
		BP
	}

	/**
	 * Frame type for visualizing motion vectors, there are flags available: "IF", "PF", "BF".
	 *
	 * @author tangxbai
	 * @since 2022/06/15
	 */
	public enum FrameType implements AbstractEnum {
		/** intra-coded frames (I-frames) */
		IF,
		/** predicted frames (P-frames) */
		PF,
		/** bi-directionally predicted frames (B-frames) */
		BF
	}

}
