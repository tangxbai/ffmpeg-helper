package com.viiyue.ffmpeg.filter.video;

import com.viiyue.ffmpeg.annotation.Function;
import com.viiyue.ffmpeg.filter.AbstractFunction;

/**
 * <p>
 * A color constancy filter that applies color correction based on the grayworld assumption
 * 
 * <p>
 * See: <a href=
 * "https://www.researchgate.net/publication/275213614_A_New_Color_Correction_Method_for_Underwater_Imaging">
 * https://www.researchgate.net/publication/275213614_A_New_Color_Correction_Method_for_Underwater_Imaging
 * </a>
 * 
 * <p>
 * The algorithm uses linear light, so input data should be linearized beforehand (and possibly correctly
 * tagged).
 *
 * @author tangxbai
 * @since 2022/07/11
 * @see <a href="https://ffmpeg.org/ffmpeg-filters.html#grayworld">ffmpeg-filters#grayworld</a>
 */
@Function( "grayworld" )
public class GrayWorld extends AbstractFunction<GrayWorld> {

	// Don't let anyone instantiate this class
	private GrayWorld() {}

}
