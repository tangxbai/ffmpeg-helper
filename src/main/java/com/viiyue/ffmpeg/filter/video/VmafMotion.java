package com.viiyue.ffmpeg.filter.video;

import com.viiyue.ffmpeg.annotation.Function;
import com.viiyue.ffmpeg.filter.AbstractFunction;

/**
 * <p>
 * Obtain the average VMAF motion score of a video. It is one of the component metrics of VMAF.
 * 
 * <p>
 * The obtained average motion score is printed through the logging system.
 * 
 * @author tangxbai
 * @since 2022/10/14
 * @see <a href= "https://ffmpeg.org/ffmpeg-filters.html#vmafmotion">ffmpeg-filters#vmafmotion</a>
 */
@Function( "vmafmotion" )
public class VmafMotion extends AbstractFunction<VmafMotion> {

	// Don't let anyone instantiate this class
	private VmafMotion() {}

	/**
	 * <p>
	 * Quickly create an instances of {@link VmafMotion}
	 * 
	 * <p>
	 * If specified, the filter will use the named file to save the motion score of each frame with respect to
	 * the previous frame. When filename equals "-" the data is sent to standard output.
	 * 
	 * @apiNote (string) file
	 * @param file the file path to store per-frame difference information
	 * @return the {@link VmafMotion} instance
	 */
	public static final VmafMotion of( String file ) {
		return new VmafMotion().addArg( "stats_file", file );
	}

}
