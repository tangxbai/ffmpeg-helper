package com.viiyue.ffmpeg.filter.video;

import com.viiyue.ffmpeg.annotation.Function;
import com.viiyue.ffmpeg.filter.AbstractFunction;

/**
 * <p>
 * Upload system memory frames to hardware surfaces.
 * 
 * <p>
 * The device to upload to must be supplied when the filter is initialised. If using ffmpeg, select the
 * appropriate device with the -filter_hw_device option or with the derive_device option. The input and output
 * devices must be of different types and compatible - the exact meaning of this is system-dependent, but
 * typically it means that they must refer to the same underlying hardware context (for example, refer to the
 * same graphics card).
 *
 * @author tangxbai
 * @since 2022/07/11
 * @see <a href="https://ffmpeg.org/ffmpeg-filters.html#hwupload-1">ffmpeg-filters#hwupload</a>
 */
@Function( "hwupload" )
public class HwUpload extends AbstractFunction<HwUpload> {

	// Don't let anyone instantiate this class
	private HwUpload() {}

	/**
	 * Quickly create an instances of {@link HwUpload}
	 * 
	 * <p>
	 * Rather than using the device supplied at initialisation, instead derive a new device of type type from
	 * the device the input frames exist on.
	 * 
	 * @apiNote (string) derive_device
	 * @param value the new device of this type
	 * @return the {@link HwUpload} instance
	 */
	public static final HwUpload of( String type ) {
		return new HwUpload().addArg( "derive_device", type );
	}

}
