package com.viiyue.ffmpeg.filter.video;

import com.viiyue.ffmpeg.annotation.Function;
import com.viiyue.ffmpeg.filter.AbstractFunction;

/**
 * Denoise frames using 2D DCT (frequency domain filtering), this filter is not designed for real time.
 * 
 * @author tangxbai
 * @since 2022/06/23
 * @see <a href="https://ffmpeg.org/ffmpeg-filters.html#dctdnoiz">ffmpeg-filters#dctdnoiz</a>
 */
@Function( "dctdnoiz" )
public class Dctdnoiz extends AbstractFunction<Dctdnoiz> {

	// Don't let anyone instantiate this class
	private Dctdnoiz() {}

	/**
	 * Quickly create an instances of {@link Dctdnoiz}
	 * 
	 * @return the {@link Dctdnoiz} instance
	 */
	public static final Dctdnoiz of() {
		return new Dctdnoiz();
	}

	/**
	 * <p>
	 * Set the noise sigma constant
	 * 
	 * <p>
	 * This sigma defines a hard threshold of 3 * sigma; every DCT coefficient (absolute value) below this
	 * threshold with be dropped.
	 * 
	 * @apiNote (double) sigma, s
	 * @param sigma the noise sigma constant
	 * @return the {@link Dctdnoiz} instance
	 */
	public Dctdnoiz sigma( double sigma ) {
		return super.addArg( "s", sigma ); // sigma, s
	}

	/**
	 * <p>
	 * Set the coefficient factor expression
	 * 
	 * <p>
	 * For each coefficient of a DCT block, this expression will be evaluated as a multiplier value for the
	 * coefficient.
	 * 
	 * <p>
	 * If this is option is set, the sigma option will be ignored, the absolute value of the coefficient can
	 * be accessed through the {@code c} variable.
	 * 
	 * @apiNote (string) expr, e
	 * @param sigma the noise sigma expression
	 * @return the {@link Dctdnoiz} instance
	 */
	public Dctdnoiz expression( String expression ) {
		return super.addArg( "e", expression ); // expr, e
	}

	/**
	 * <p>
	 * Set the {@code blocksize} using the number of bits. 1<<n defines the {@code blocksize}, which is the
	 * width and height of the processed blocks.
	 * 
	 * <p>
	 * The default value is 3 (8x8) and can be raised to 4 for a {@code blocksize} of 16x16. Note that
	 * changing this setting has huge consequences on the speed processing. Also, a larger block size does not
	 * necessarily means a better de-noising.
	 * 
	 * @apiNote (double) n
	 * @param sigma the noise sigma expression
	 * @return the {@link Dctdnoiz} instance
	 */
	public Dctdnoiz blockSize( String expression ) {
		return super.addArg( "n", expression );
	}

	/**
	 * <p>
	 * Set number overlapping pixels for each block. Since the filter can be slow, you may want to reduce this
	 * value, at the cost of a less effective filter and the risk of various artefacts.
	 * 
	 * <p>
	 * If the overlapping value doesn’t permit processing the whole input width or height, a warning will be
	 * displayed and according borders won’t be denoised.
	 * 
	 * <p>
	 * Default value is {@code blocksize} - 1, which is the best possible setting.
	 * 
	 * @apiNote (int) overlap
	 * @param pixels the overlapping pixels
	 * @return the {@link Dctdnoiz} instance
	 */
	public Dctdnoiz overlap( int pixels ) {
		return super.addArg( "overlap", pixels );
	}

}
