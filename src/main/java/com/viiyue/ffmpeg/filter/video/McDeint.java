package com.viiyue.ffmpeg.filter.video;

import com.viiyue.ffmpeg.annotation.Function;
import com.viiyue.ffmpeg.common.AbstractEnum;
import com.viiyue.ffmpeg.enums.Parity;
import com.viiyue.ffmpeg.filter.AbstractFunction;

/**
 * <p>
 * Apply motion-compensation deinterlacing.
 * 
 * <p>
 * It needs one field per frame as input and must thus be used together with yadif=1/3 or equivalent.
 * 
 * <p>
 * This filter is only available in ffmpeg version 4.4 or earlier.
 * 
 * @author tangxbai
 * @since 2022/07/18
 * @see <a href="https://ffmpeg.org/ffmpeg-filters.html#mcdeint">ffmpeg-filters#mcdeint</a>
 */
@Function( "mcdeint" )
public class McDeint extends AbstractFunction<McDeint> {

	// Don't let anyone instantiate this class
	private McDeint() {}

	/**
	 * Quickly create an instances of {@link McDeint}
	 * 
	 * @return the {@link McDeint} instance
	 */
	public static final McDeint of() {
		return new McDeint();
	}

	/**
	 * Set the deinterlacing mode
	 * 
	 * @apiNote (flags) mode
	 * @param mode the deinterlacing mode
	 * @return the {@link McDeint} instance
	 * @see DeintMode
	 */
	public McDeint mode( DeintMode mode ) {
		return super.addArg( "mode", mode );
	}

	/**
	 * Set the picture field parity assumed for the input video
	 * 
	 * @apiNote (flags) parity
	 * @param parity the picture field parity
	 * @return the {@link McDeint} instance
	 * @see Parity
	 */
	public McDeint parity( Parity parity ) {
		return super.addArg( "parity", parity );
	}

	/**
	 * <p>
	 * Set per-block quantization parameter (QP) used by the internal encoder.
	 * 
	 * <p>
	 * Higher values should result in a smoother motion vector field but less optimal individual vectors.
	 * Default value is <b>1</b>.
	 * 
	 * @apiNote (int) qp
	 * @param value the quantization parameter value
	 * @return the {@link McDeint} instance
	 */
	public McDeint qp( int value ) {
		return super.addArg( "qp", value );
	}

	/**
	 * Deinterlacing mode
	 *
	 * @author tangxbai
	 * @since 2022/07/18
	 */
	public enum DeintMode implements AbstractEnum {
		FAST, MEDIUM, SLOW, EXTRA_SLOW
	}

}
