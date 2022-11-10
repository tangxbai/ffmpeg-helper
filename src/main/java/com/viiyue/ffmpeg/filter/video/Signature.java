package com.viiyue.ffmpeg.filter.video;

import com.viiyue.ffmpeg.annotation.Function;
import com.viiyue.ffmpeg.common.AbstractEnum;
import com.viiyue.ffmpeg.filter.AbstractColorFunction;
import com.viiyue.ffmpeg.util.Assert;

/**
 * Calculates the MPEG-7 Video Signature. The filter can handle more than one input. In this case the matching
 * between the inputs can be calculated additionally. The filter always passes through the first input. The
 * signature of each stream can be written into a file.
 * 
 * @author tangxbai
 * @since 2022/08/04
 * @see <a href="https://ffmpeg.org/ffmpeg-filters.html#signature-1">ffmpeg-filters#signature</a>
 */
@Function( "signature" )
public class Signature extends AbstractColorFunction<Signature> {

	// Don't let anyone instantiate this class
	private Signature() {}

	/**
	 * Quickly create an instances of {@link Signature}
	 * 
	 * @return the {@link Signature} instance
	 */
	public static final Signature of() {
		return new Signature();
	}

	/**
	 * Enable or disable the matching process
	 * 
	 * @apiNote (flags) detectmode
	 * @param mode the detect mode
	 * @return the {@link Signature} instance
	 */
	public Signature detectMode( DetectMode mode ) {
		return super.addArg( "detectmode", mode );
	}

	/**
	 * Set the number of inputs. The option value must be a non negative integer, default value is <b>1</b>.
	 * 
	 * @apiNote (int) nb_inputs
	 * @param value the number of inputs
	 * @return the {@link Signature} instance
	 */
	public Signature numInputs( int value ) {
		Assert.isTrue( value > 0, "Value cannot be a negative integer" );
		return super.addArg( "nb_inputs", value );
	}

	/**
	 * Set the path to which the output is written. If there is more than one input, the path must be a
	 * prototype, i.e. must contain %d or %0nd (where n is a positive integer), that will be replaced with the
	 * input number. If no filename is specified, no output will be written. This is the default.
	 * 
	 * @apiNote (string) filename
	 * @param filePath the output file location
	 * @return the {@link Signature} instance
	 */
	public Signature fileName( String filePath ) {
		return super.addArg( "filename", filePath );
	}

	/**
	 * Choose the output format, use the specified {@code binary} representation (default).
	 * 
	 * @apiNote (string) format
	 * @return the {@link Signature} instance
	 */
	public Signature format2Binary() {
		return super.addArg( "format", "binary" );
	}

	/**
	 * Choose the output format, use the specified {@code xml} representation
	 * 
	 * @apiNote (string) format
	 * @return the {@link Signature} instance
	 */
	public Signature format2Xml() {
		return super.addArg( "format", "xml" );
	}

	/**
	 * Set threshold to detect one word as similar. The option value must be an integer greater than zero. The
	 * default value is <b>9000</b>.
	 * 
	 * @apiNote (int) th_d
	 * @param value the threshold value
	 * @return the {@link Signature} instance
	 */
	public Signature dThreshold( int value ) {
		Assert.isTrue( value >= 1, "Option value must be an integer greater than zero" );
		return super.addArg( "th_d", value );
	}

	/**
	 * Set threshold to detect all words as similar. The option value must be an integer greater than zero.
	 * The default value is <b>60000</b>.
	 * 
	 * @apiNote (int) th_dc
	 * @param value the threshold value
	 * @return the {@link Signature} instance
	 */
	public Signature dcThreshold( int value ) {
		Assert.isTrue( value >= 1, "Option value must be an integer greater than zero" );
		return super.addArg( "th_dc", value );
	}

	/**
	 * Choose the output format, use the specified {@code xml} representation
	 * 
	 * @apiNote (int) th_dc
	 * @param value the threshold value
	 * @return the {@link Signature} instance
	 */
	public Signature xhThreshold( int value ) {
		Assert.isTrue( value >= 1, "Option value must be an integer greater than zero" );
		return super.addArg( "th_xh", value );
	}

	/**
	 * Set the minimum length of a sequence in frames to recognize it as matching sequence. The option value
	 * must be a non negative integer value. The default value is <b>0</b>.
	 * 
	 * @apiNote (double) th_dc
	 * @param value the threshold value
	 * @return the {@link Signature} instance
	 */
	public Signature diThreshold( double value ) {
		Assert.isTrue( value >= 0, "Option value must be a non negative integer value" );
		return super.addArg( "th_di", value );
	}

	/**
	 * Set the minimum relation, that matching frames to all frames must have. The option value must be a
	 * double value between 0 and 1. The default value is <b>0.5</b>.
	 * 
	 * @apiNote (double) th_dc
	 * @param value the threshold value
	 * @return the {@link Signature} instance
	 */
	public Signature itThreshold( double value ) {
		Assert.rangeCheck( value, 0.0, 1.0 );
		return super.addArg( "th_it", value );
	}

	/**
	 * Detect mode
	 *
	 * @author tangxbai
	 * @since 2022/08/04
	 */
	public enum DetectMode implements AbstractEnum {
		/**
		 * Disable the calculation of a matching (default)
		 */
		OFF,
		/**
		 * Calculate the matching for the whole video and output whether the whole video matches or only parts
		 */
		FULL,
		/**
		 * Calculate only until a matching is found or the video ends. Should be faster in some cases
		 */
		FAST
	}

}
