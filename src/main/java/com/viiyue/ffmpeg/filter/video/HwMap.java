package com.viiyue.ffmpeg.filter.video;

import com.viiyue.ffmpeg.annotation.Function;
import com.viiyue.ffmpeg.common.AbstractEnum;
import com.viiyue.ffmpeg.filter.AbstractFunction;

/**
 * <p>
 * Map hardware frames to system memory or to another device.
 * 
 * <p>
 * This filter has several different modes of operation; which one is used depends on the input and output
 * formats:
 * 
 * <ul>
 * <li>Hardware frame input, normal frame output Map the input frames to system memory and pass them to the
 * output. If the original hardware frame is later required (for example, after overlaying something else on
 * part of it), the hwmap filter can be used again in the next mode to retrieve it.<br>
 * <br>
 * 
 * <li>Normal frame input, hardware frame output If the input is actually a software-mapped hardware frame,
 * then unmap it - that is, return the original hardware frame. <br>
 * <br>
 * Otherwise, a device must be provided. Create new hardware surfaces on that device for the output, then map
 * them back to the software format at the input and give those frames to the preceding filter. This will then
 * act like the hwupload filter, but may be able to avoid an additional copy when the input is already in a
 * compatible format.<br>
 * <br>
 * 
 * <li>Hardware frame input and output A device must be supplied for the output, either directly or with the
 * derive_device option. The input and output devices must be of different types and compatible - the exact
 * meaning of this is system-dependent, but typically it means that they must refer to the same underlying
 * hardware context (for example, refer to the same graphics card). <br>
 * <br>
 * If the input frames were originally created on the output device, then unmap to retrieve the original
 * frames. <br>
 * <br>
 * Otherwise, map the frames to the output device - create new hardware frames on the output corresponding to
 * the frames on the input.
 * </ul>
 *
 * @author tangxbai
 * @since 2022/07/11
 * @see <a href="https://ffmpeg.org/ffmpeg-filters.html#hwmap">ffmpeg-filters#hwmap</a>
 */
@Function( "hwmap" )
public class HwMap extends AbstractFunction<HwMap> {

	// Don't let anyone instantiate this class
	private HwMap() {}

	/**
	 * Quickly create an instances of {@link HwMap}
	 * 
	 * @return the {@link HwMap} instance
	 */
	public static final HwMap of() {
		return new HwMap();
	}

	/**
	 * Set the frame mapping mode
	 * 
	 * @apiNote (flags) mode
	 * @param value the frame mapping mode
	 * @return the {@link Hqdn3d} instance
	 */
	public HwMap mode( FrameMappingMode mode ) {
		return super.addArg( "mode", mode );
	}

	/**
	 * Rather than using the device supplied at initialisation, instead derive a new device of type type from
	 * the device the input frames exist on.
	 * 
	 * @apiNote (string) derive_device
	 * @param value the new device of this type
	 * @return the {@link Hqdn3d} instance
	 */
	public HwMap deriveDevice( String type ) {
		return super.addArg( "derive_device", type );
	}

	/**
	 * <p>
	 * In a hardware to hardware mapping, map in reverse - create frames in the sink and map them back to the
	 * source. This may be necessary in some cases where a mapping in one direction is required but only the
	 * opposite direction is supported by the devices being used.
	 * 
	 * <p>
	 * This option is dangerous - it may break the preceding filter in undefined ways if there are any
	 * additional constraints on that filter’s output. Do not use it without fully understanding the
	 * implications of its use.
	 * 
	 * @apiNote (boolean) reverse
	 * @return the {@link Hqdn3d} instance
	 */
	public HwMap reverse() {
		return super.enable( "reverse" );
	}

	/**
	 * Frame mapping mode
	 *
	 * @author tangxbai
	 * @since 2022/07/11
	 */
	public enum FrameMappingMode implements AbstractEnum {
		/** The mapped frame should be readable */
		READ,
		/** The mapped frame should be writeable */
		WRITE,
		/**
		 * The mapping will always overwrite the entire frame.
		 * <p>
		 * This may improve performance in some cases, as the original contents of the frame need not be
		 * loaded.
		 */
		OVERWRITE,
		/***
		 * The mapping must not involve any copying.
		 * <p>
		 * Indirect mappings to copies of frames are created in some cases where either direct mapping is not
		 * possible or it would have unexpected properties. Setting this flag ensures that the mapping is
		 * direct and will fail if that is not possible.
		 */
		DIRECT
	}

}
