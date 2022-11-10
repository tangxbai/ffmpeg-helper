package com.viiyue.ffmpeg.filter.video;

import com.viiyue.ffmpeg.annotation.Function;
import com.viiyue.ffmpeg.filter.AbstractFunction;

/**
 * Upload system memory frames to a CUDA device
 *
 * @author tangxbai
 * @since 2022/07/11
 * @see <a href="https://ffmpeg.org/ffmpeg-filters.html#hwupload_cuda-1">ffmpeg-filters#hwupload_cuda</a>
 */
@Function( "hwupload_cuda" )
public class HwUploadCuda extends AbstractFunction<HwUploadCuda> {

	// Don't let anyone instantiate this class
	private HwUploadCuda() {}

	/**
	 * Quickly create an instances of {@link HwUploadCuda} and upload system memory frames to a CUDA device.
	 * 
	 * @apiNote (int) device
	 * @param value the number of the CUDA device to use
	 * @return the {@link HwUploadCuda} instance
	 */
	public static final HwUploadCuda device( int value ) {
		return new HwUploadCuda().addArg( "device", value );
	}

}
