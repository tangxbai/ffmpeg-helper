package com.viiyue.ffmpeg.filter.video;

import com.viiyue.ffmpeg.annotation.Function;
import com.viiyue.ffmpeg.common.AbstractEnum;
import com.viiyue.ffmpeg.filter.AbstractFunction;
import com.viiyue.ffmpeg.util.Assert;
import com.viiyue.ffmpeg.util.Helper;

/**
 * <p>
 * Video stabilization/deshaking: pass 2 of 2, see
 * <a href="https://ffmpeg.org/ffmpeg-filters.html#vidstabdetect">vidstabdetect</a> for pass 1.
 * 
 * <p>
 * Read a file with transform information for each frame and apply/compensate them. Together with the
 * <a href="https://ffmpeg.org/ffmpeg-filters.html#vidstabdetect">vidstabdetect</a> filter this can be used to
 * deshake videos. See also
 * <a href="http://public.hronopik.de/vid.stab">http://public.hronopik.de/vid.stab</a>. It is important to
 * also use the <a href="https://ffmpeg.org/ffmpeg-filters.html#unsharp">unsharp</a> filter, see below.
 * 
 * <p>
 * To enable compilation of this filter you need to configure FFmpeg with {@code --enable-libvidstab}.
 * 
 * @author tangxbai
 * @since 2022/10/13
 * @see <a href=
 *      "https://ffmpeg.org/ffmpeg-filters.html#vidstabtransform-1">ffmpeg-filters#vidstabtransform</a>
 */
@Function( "vidstabtransform" )
public class VidstabTransform extends AbstractFunction<VidstabTransform> {

	// Don't let anyone instantiate this class
	private VidstabTransform() {}

	/**
	 * Quickly create an instances of {@link VidstabTransform}
	 * 
	 * @return the {@link VidstabTransform} instance
	 */
	public static final VidstabTransform of() {
		return new VidstabTransform();
	}

	/**
	 * Set the path to the file used to read the transforms information. Default value is
	 * <b>"transforms.trf"</b>.
	 * 
	 * @apiNote (string) input
	 * @param path the file used to read the transforms
	 * @return the {@link VidstabTransform} instance
	 */
	public VidstabTransform input( String path ) {
		return super.addArg( "input", Helper.escape( path, true ) );
	}

	/**
	 * <p>
	 * Set the number of frames (value*2 + 1) used for lowpass filtering the camera movements. Default value
	 * is <b>10</b>.
	 * 
	 * <p>
	 * For example a number of 10 means that 21 frames are used (10 in the past and 10 in the future) to
	 * smoothen the motion in the video. A larger value leads to a smoother video, but limits the acceleration
	 * of the camera (pan/tilt movements). 0 is a special case where a static camera is simulated. Default
	 * value is <b>15</b>.
	 * 
	 * @apiNote (int) smoothing
	 * @param value the number of "frames*2+1" used for lowpass
	 * @return the {@link VidstabTransform} instance
	 */
	public VidstabTransform smoothing( int value ) {
		Assert.rangeCheck( value, 0, 1000 );
		return super.addArg( "smoothing", value );
	}

	/**
	 * Set the camera path optimization algorithm, default value is {@link OptimizationAlgorithm#GAUSS}.
	 * 
	 * @apiNote (int) optalgo
	 * @param value the camera path optimization algorithm
	 * @return the {@link VidstabTransform} instance
	 * @see OptimizationAlgorithm
	 */
	public VidstabTransform optAlgo( OptimizationAlgorithm opt ) {
		return super.addArg( "optalgo", opt );
	}

	/**
	 * Set maximal number of pixels to translate frames. Default value is <b>-1</b>, meaning no limit.
	 * 
	 * @apiNote (int) maxshift
	 * @param value the maximal number of pixels
	 * @return the {@link VidstabTransform} instance
	 */
	public VidstabTransform maxShift( int value ) {
		Assert.rangeCheck( value, -1, 500 );
		return super.addArg( "maxshift", value );
	}

	/**
	 * Set maximal angle in radians (degree*PI/180) to rotate frames. Default value is <b>-1</b>, meaning no
	 * limit.
	 * 
	 * @apiNote (int) maxangle
	 * @param value the maximal angle in radians
	 * @return the {@link VidstabTransform} instance
	 */
	public VidstabTransform maxAngle( double value ) {
		Assert.rangeCheck( value, -1, 3.14 );
		return super.addArg( "maxshift", value );
	}

	/**
	 * Specify how to deal with borders that may be visible due to movement compensation
	 * 
	 * @apiNote (int) crop
	 * @param value the orders cropping mode
	 * @return the {@link VidstabTransform} instance
	 * @see CroppingMode
	 */
	public VidstabTransform crop( CroppingMode mode ) {
		return super.addArg( "crop", mode );
	}

	/**
	 * Invert transforms
	 * 
	 * @apiNote (boolean) crop
	 * @return the {@link VidstabTransform} instance
	 */
	public VidstabTransform invert() {
		return super.enable( "invert" );
	}

	/**
	 * Consider transforms as relative
	 * 
	 * @apiNote (boolean) relative
	 * @return the {@link VidstabTransform} instance
	 */
	public VidstabTransform relative() {
		return super.enable( "relative" );
	}

	/**
	 * Consider transforms as absolute
	 * 
	 * @apiNote (boolean) relative
	 * @return the {@link VidstabTransform} instance
	 */
	public VidstabTransform absolute() {
		return super.disable( "relative" );
	}

	/**
	 * Set percentage to zoom. A positive value will result in a zoom-in effect, a negative value in a
	 * zoom-out effect. Default value is <b>0</b> (no zoom).
	 * 
	 * @apiNote (double) zoom
	 * @param value the percentage to zoom
	 * @return the {@link VidstabTransform} instance
	 */
	public VidstabTransform zoom( double value ) {
		Assert.rangeCheck( value, 0, 2 );
		return super.addArg( "zoom", value );
	}

	/**
	 * <p>
	 * Set optimal zooming to avoid borders
	 * 
	 * <ul>
	 * <li>0 - disabled
	 * <li>1 - optimal static zoom value is determined (only very strong movements will lead to visible
	 * borders) (default)
	 * <li>2 - optimal adaptive zoom value is determined (no borders will be visible), see zoomspeed
	 * </ul>
	 * 
	 * @apiNote (int) optzoom
	 * @param value the optimal zoom
	 * @return the {@link VidstabTransform} instance
	 */
	public VidstabTransform optZoom( int value ) {
		Assert.rangeCheck( value, 0, 2 );
		return super.addArg( "optzoom", value );
	}

	/**
	 * Set percent to zoom maximally each frame (enabled when optzoom is set to 2). Range is from 0 to 5,
	 * default value is <b>0.25</b>.
	 * 
	 * @apiNote (int) zoomspeed
	 * @param value the percent to zoom maximally each frame
	 * @return the {@link VidstabTransform} instance
	 */
	public VidstabTransform zoomZpeed( double value ) {
		Assert.rangeCheck( value, 0, 5 );
		return super.addArg( "zoomspeed", value );
	}

	/**
	 * Specify type of interpolation
	 * 
	 * @apiNote (int) interpol
	 * @param value the type of interpolation
	 * @return the {@link VidstabTransform} instance
	 * @see Interpolation
	 */
	public VidstabTransform interpol( Interpolation interpol ) {
		return super.addArg( "interpol", interpol );
	}

	/**
	 * <p>
	 * Enable virtual tripod mode if set to true, which is equivalent to {@code relative=0:smoothing=0}.
	 * Default value is <b>false</b>.
	 * 
	 * <p>
	 * Use also {@code tripod} option of
	 * <a href="https://ffmpeg.org/ffmpeg-filters.html#vidstabdetect">vidstabdetect</a>.
	 * 
	 * @apiNote (int) tripod
	 * @return the {@link VidstabTransform} instance
	 */
	public VidstabTransform tripod() {
		return super.enable( "tripod" );
	}

	/**
	 * Increase log verbosity if set to true. Also the detected global motions are written to the temporary
	 * file global_motions.trf. Default value is {@code false}.
	 * 
	 * @apiNote (boolean) debug
	 * @return the {@link VidstabTransform} instance
	 */
	public VidstabTransform debug() {
		return super.enable( "debug" );
	}

	/**
	 * Optimization Algorithm
	 *
	 * @author tangxbai
	 * @since 2022/10/13
	 */
	public enum OptimizationAlgorithm implements AbstractEnum {
		/** Global optimization */
		OPT,
		/** Gaussian kernel low-pass filter on camera motion (default) */
		GAUSS,
		/** Averaging on transformations */
		AVG
	}

	/**
	 * Cropping mode
	 *
	 * @author tangxbai
	 * @since 2022/10/13
	 */
	public enum CroppingMode implements AbstractEnum {
		/** keep image information from previous frame (default) */
		KEEP,
		/** Fill the border black */
		BLACK
	}

	/**
	 * Interpolation mode
	 *
	 * @author tangxbai
	 * @since 2022/10/13
	 */
	public enum Interpolation implements AbstractEnum {
		/** No interpolation */
		NO,
		/** Linear only horizontal */
		LINEAR,
		/** Linear in both directions (default) */
		BILINEAR,
		/** Cubic in both directions (slow) */
		BICUBIC
	}

}
