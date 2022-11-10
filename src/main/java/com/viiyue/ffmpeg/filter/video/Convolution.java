package com.viiyue.ffmpeg.filter.video;

import com.viiyue.ffmpeg.annotation.Function;
import com.viiyue.ffmpeg.common.Const;
import com.viiyue.ffmpeg.filter.AbstractFunction;

/**
 * <p>
 * Apply convolution of 3x3, 5x5, 7x7 or horizontal/vertical up to 49 elements.
 * 
 * <pre>
 * Apply sharpen:
 * Convolution.define("0 -1 0 -1 5 -1 0 -1 0", "0 -1 0 -1 5 -1 0 -1 0", "0 -1 0 -1 5 -1 0 -1 0", "0 -1 0 -1 5 -1 0 -1 0" );
 * 
 * Apply blur: 
 * Convolution.define("1 1 1 1 1 1 1 1 1", "1 1 1 1 1 1 1 1 1", "1 1 1 1 1 1 1 1 1", "1 1 1 1 1 1 1 1 1", "1/9", "1/9", "1/9", "1/9" );
 * 
 * Apply edge enhance: 
 * Convolution.define("0 0 0 -1 1 0 0 0 0", "0 0 0 -1 1 0 0 0 0", "0 0 0 -1 1 0 0 0 0", "0 0 0 -1 1 0 0 0 0", "5", "1", "1", "1", "0", "128", "128", "128" );
 * 
 * Apply edge detect: 
 * Convolution.define("0 1 0 1 -4 1 0 1 0", "0 1 0 1 -4 1 0 1 0", "0 1 0 1 -4 1 0 1 0", "0 1 0 1 -4 1 0 1 0", "5", "5", "5", "1", "0", "128", "128", "128" );
 * 
 * Apply laplacian edge detector which includes diagonals: 
 * Convolution.define("1 1 1 1 -8 1 1 1 1", "1 1 1 1 -8 1 1 1 1", "1 1 1 1 -8 1 1 1 1", "1 1 1 1 -8 1 1 1 1", "5", "5", "5", "1", "0", "128", "128", "0" );
 * 
 * Apply emboss: 
 * Convolution.define("-2 -1 0 -1 1 1 0 1 2", "-2 -1 0 -1 1 1 0 1 2", "-2 -1 0 -1 1 1 0 1 2", "-2 -1 0 -1 1 1 0 1 2" );
 * </pre>
 * 
 * @author tangxbai
 * @since 2022/06/16
 * @see <a href="https://ffmpeg.org/ffmpeg-filters.html#convolution">ffmpeg-filters#convolution</a>
 */
@Function( "convolution" )
public class Convolution extends AbstractFunction<Convolution> {

	// Don't let anyone instantiate this class
	private Convolution() {}

	@Override
	protected String [] getArgWrapper() {
		return new String [] { Const.QUOTE, Const.QUOTE };
	}

	/**
	 * Quickly create an instances of {@link Convolution}
	 * 
	 * @return the {@link Convolution} instance
	 */
	public static final Convolution define( String ... matrixs ) {
		return new Convolution().addValues( matrixs );
	}

}
