package com.viiyue.ffmpeg.filter.video;

import com.viiyue.ffmpeg.annotation.Function;
import com.viiyue.ffmpeg.enums.When;
import com.viiyue.ffmpeg.filter.AbstractColorFunction;
import com.viiyue.ffmpeg.util.Assert;

/**
 * Apply arbitrary expressions to samples in frequency domain
 * 
 * @author tangxbai
 * @since 2022/06/30
 * @see <a href="https://ffmpeg.org/ffmpeg-filters.html#fftfilt">ffmpeg-filters#fftfilt</a>
 */
@Function( "fftfilt" )
public class FftFilt extends AbstractColorFunction<FftFilt> {

	// Don't let anyone instantiate this class
	private FftFilt() {}

	/**
	 * Quickly create an instances of {@link ExtractPlanes}
	 * 
	 * @return the {@link FftFilt} instance
	 */
	public static final FftFilt of() {
		return new FftFilt();
	}

	/**
	 * Adjust the dc value (gain) of the luma plane of the image. The filter accepts an integer value in range
	 * 0 to 1000. The default value is set to <b>0</b>.
	 * 
	 * @apiNote (double) dc_Y
	 * @param value the gain in Y plane
	 * @return the {@link FftFilt} instance
	 */
	public FftFilt dcY( double value ) {
		Assert.rangeCheck( value, 0, 1000 );
		return super.addArg( "dc_Y", value );
	}

	/**
	 * Adjust the dc value (gain) of the 1st chroma plane of the image. The filter accepts an integer value in
	 * range 0 to 1000. The default value is set to <b>0</b>.
	 * 
	 * @apiNote (double) dc_U
	 * @param value the gain in U plane
	 * @return the {@link FftFilt} instance
	 */
	public FftFilt dcU( double value ) {
		Assert.rangeCheck( value, 0, 1000 );
		return super.addArg( "dc_U", value );
	}

	/**
	 * Adjust the dc value (gain) of the 2nd chroma plane of the image. The filter accepts an integer value in
	 * range 0 to 1000. The default value is set to <b>0</b>.
	 * 
	 * @apiNote (double) dc_V
	 * @param value the gain in U plane
	 * @return the {@link FftFilt} instance
	 */
	public FftFilt dcV( double value ) {
		Assert.rangeCheck( value, 0, 1000 );
		return super.addArg( "dc_V", value );
	}

	/**
	 * <p>
	 * Set the frequency domain weight expression for the luma plane
	 * 
	 * <p>
	 * The filter accepts the following variables:
	 * <ul>
	 * <li><b>X Y</b> - the coordinates of the current sample
	 * <li><b>W H</b> - the width and height of the image
	 * <li><b>N</b> - the number of input frame, starting from 0.
	 * <li><b>WS HS</b> - the size of FFT array for horizontal and vertical processing
	 * </ul>
	 * 
	 * @apiNote (string) weight_Y
	 * @param value the chrominance expression in Y plane
	 * @return the {@link FftFilt} instance
	 */
	public FftFilt weightY( String expression ) {
		return super.addArg( "weight_Y", expression );
	}

	/**
	 * <p>
	 * Set the frequency domain weight expression for the 1st chroma plane
	 * 
	 * <p>
	 * The filter accepts the following variables:
	 * <ul>
	 * <li><b>X Y</b> - the coordinates of the current sample
	 * <li><b>W H</b> - the width and height of the image
	 * <li><b>N</b> - the number of input frame, starting from 0.
	 * <li><b>WS HS</b> - the size of FFT array for horizontal and vertical processing
	 * </ul>
	 * 
	 * @apiNote (string) weight_U
	 * @param value the chrominance expression in U plane
	 * @return the {@link FftFilt} instance
	 */
	public FftFilt weightU( String value ) {
		return super.addArg( "weight_U", value );
	}

	/**
	 * <p>
	 * Set the frequency domain weight expression for the 2nd chroma plane
	 * 
	 * <p>
	 * The filter accepts the following variables:
	 * <ul>
	 * <li><b>X Y</b> - the coordinates of the current sample
	 * <li><b>W H</b> - the width and height of the image
	 * <li><b>N</b> - the number of input frame, starting from 0.
	 * <li><b>WS HS</b> - the size of FFT array for horizontal and vertical processing
	 * </ul>
	 * 
	 * @apiNote (string) weight_V
	 * @param value the chrominance expression in V plane
	 * @return the {@link FftFilt} instance
	 */
	public FftFilt weightV( String value ) {
		return super.addArg( "weight_V", value );
	}

	/**
	 * Set when the expressions are evaluated
	 * 
	 * @apiNote (flags) eval
	 * @param when specify when to evaluate expressions
	 * @return the {@link Eq} instance
	 * @see When
	 */
	public FftFilt eval( When when ) {
		return super.addArg( "eval", when );
	}

}
