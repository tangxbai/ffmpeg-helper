package com.viiyue.ffmpeg.filter.video;

import com.viiyue.ffmpeg.annotation.Function;
import com.viiyue.ffmpeg.filter.AbstractFunction;

/**
 * Change video quantization parameters (QP).
 * 
 * @author tangxbai
 * @since 2022/07/22
 * @see <a href="https://ffmpeg.org/ffmpeg-filters.html#qp">ffmpeg-filters#qp</a>
 */
@Function( "qp" )
public class Qp extends AbstractFunction<Qp> {

	// Don't let anyone instantiate this class
	private Qp() {}

	/**
	 * Quickly create an instances of {@link Qp}
	 * 
	 * @apiNote (string) qp
	 * @param expression the quantization parameter expression
	 * @return the {@link Qp} instance
	 */
	public static final Qp of( String expression ) {
		return new Qp().addArg( "qp", expression );
	}

}
