package com.viiyue.ffmpeg.filter.video;

import com.viiyue.ffmpeg.annotation.Alias;
import com.viiyue.ffmpeg.annotation.Function;
import com.viiyue.ffmpeg.common.AbstractEnum;
import com.viiyue.ffmpeg.enums.Deinterlace;
import com.viiyue.ffmpeg.filter.AbstractFunction;
import com.viiyue.ffmpeg.util.Assert;

/**
 * Deinterlace video using neural network edge directed interpolation
 * 
 * @author tangxbai
 * @since 2022/07/19
 * @see <a href="https://ffmpeg.org/ffmpeg-filters.html#nnedi">ffmpeg-filters#nnedi</a>
 */
@Function( "nnedi" )
public class Nnedi extends AbstractFunction<Nnedi> {

	// Don't let anyone instantiate this class
	private Nnedi() {}

	/**
	 * Quickly create an instances of {@link Nnedi}
	 * 
	 * @return the {@link Nnedi} instance
	 */
	public static final Nnedi of() {
		return new Nnedi();
	}

	/**
	 * Mandatory option, without binary file filter can not work. Currently file can be found here: <a href=
	 * "https://github.com/dubhater/vapoursynth-nnedi3/blob/master/src/nnedi3_weights.bin">nnedi3_weights.bin</a>
	 * 
	 * @apiNote (string) weights
	 * @param file the weights binary file
	 * @return the {@link Nnedi} instance
	 */
	public Nnedi weights( String file ) {
		return super.addArg( "weights", file );
	}

	/**
	 * Specify which frames to deinterlace
	 * 
	 * @apiNote (flags) deint
	 * @param deint the which frames to deinterlace
	 * @return the {@link Nnedi} instance
	 * @see Deinterlace
	 */
	public Nnedi deint( Deinterlace deint ) {
		return super.addArg( "deint", deint );
	}

	/**
	 * Set mode of operation
	 * 
	 * @apiNote (flags) field
	 * @param mode the operatiing mode
	 * @return the {@link Nnedi} instance
	 * @see Operation
	 */
	public Nnedi field( Operation mode ) {
		return super.addArg( "field", mode );
	}

	/**
	 * Set planes to filter. Value range allowed is from 0 to 15, default value is <b>15</b>, all planes will
	 * be processed.
	 * 
	 * @apiNote (int) planes
	 * @param value the plane filter
	 * @return the {@link Nnedi} instance
	 */
	public Nnedi planes( int value ) {
		Assert.rangeCheck( value, 0, 15 );
		return super.addArg( "planes", value );
	}

	/**
	 * Set size of local neighborhood around each pixel, used by the predictor neural network.
	 * 
	 * @apiNote (flags) nsize
	 * @param size the pixel constant size
	 * @return the {@link Nnedi} instance
	 * @see PixelSize
	 */
	public Nnedi nsize( PixelSize size ) {
		return super.addArg( "nsize", size );
	}

	/**
	 * Set the number of neurons in predictor neural network
	 * 
	 * @apiNote (flags) nsize
	 * @param neuron the specified neuron
	 * @return the {@link Nnedi} instance
	 * @see Neurons
	 */
	public Nnedi nns( Neurons neuron ) {
		return super.addArg( "nns", neuron );
	}

	/**
	 * Controls the number of different neural network predictions that are blended together to compute the
	 * final output value.
	 * 
	 * @apiNote (flags) qual
	 * @param quality the quality
	 * @return the {@link Nnedi} instance
	 * @see Quality
	 */
	public Nnedi quality( Quality quality ) {
		return super.addArg( "qual", quality );
	}

	/**
	 * Set which set of weights to use in the predictor
	 * 
	 * @apiNote (flags) etype
	 * @param type the weight type
	 * @return the {@link Nnedi} instance
	 * @see WeightType
	 */
	public Nnedi etype( WeightType type ) {
		return super.addArg( "etype", type );
	}

	/**
	 * Controls whether or not the prescreener neural network is used to decide which pixels should be
	 * processed by the predictor neural network and which can be handled by simple cubic interpolation. The
	 * prescreener is trained to know whether cubic interpolation will be sufficient for a pixel or whether it
	 * should be predicted by the predictor nn. The computational complexity of the prescreener nn is much
	 * less than that of the predictor nn. Since most pixels can be handled by cubic interpolation, using the
	 * prescreener generally results in much faster processing. The prescreener is pretty accurate, so the
	 * difference between using it and not using it is almost always unnoticeable.
	 * 
	 * @apiNote (flags) pscrn
	 * @param type the prescreener type
	 * @return the {@link Nnedi} instance
	 * @see Prescreener
	 */
	public Nnedi pscrn( Prescreener type ) {
		return super.addArg( "pscrn", type );
	}

	/**
	 * Operating mode
	 *
	 * @author tangxbai
	 * @since 2022/07/19
	 */
	public enum Operation implements AbstractEnum {
		/** Use frame flags, both fields. */
		AF,
		/** Use frame flags, single field. */
		A,
		/** Use top field only */
		T,
		/** Use bottom field only */
		B,
		/** Use both fields, top first. */
		TF,
		/** Use both fields, bottom first. */
		BF
	}

	/**
	 * The size of local neighborhood around each pixel
	 *
	 * @author tangxbai
	 * @since 2022/07/19
	 */
	public enum PixelSize implements AbstractEnum {
		S8X6, S16X6, S32X6, S48X6, S8X4, S16X4, S32X4
	}

	/**
	 * The number of of neurons in predictor neural network
	 *
	 * @author tangxbai
	 * @since 2022/07/19
	 */
	public enum Neurons implements AbstractEnum {
		N16, N32, N64, N128, N256
	}

	/**
	 * Computational quality
	 *
	 * @author tangxbai
	 * @since 2022/07/19
	 */
	public enum Quality implements AbstractEnum {
		FAST, SLOW
	}

	/**
	 * Predictor weight type
	 * 
	 * @author tangxbai
	 * @since 2022/07/19
	 */
	public enum WeightType implements AbstractEnum {
		/** Weights trained to minimize absolute error */
		ABS,
		/** Weights trained to minimize squared error */
		MSE
	}

	/**
	 * Prescreener type
	 * 
	 * @author tangxbai
	 * @since 2022/07/19
	 */
	public enum Prescreener implements AbstractEnum {
		NONE, 
		ORIGINAL, 
		@Alias( "new" )
		NEW1, 
		NEW2, 
		NEW3
	}

}
