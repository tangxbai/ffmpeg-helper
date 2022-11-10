package com.viiyue.ffmpeg.filter.video;

import com.viiyue.ffmpeg.annotation.Function;
import com.viiyue.ffmpeg.common.AbstractEnum;
import com.viiyue.ffmpeg.enums.DnnBackend;
import com.viiyue.ffmpeg.filter.AbstractFunction;

/**
 * <p>
 * Remove the rain in the input image/video by applying the derain methods based on convolutional neural
 * networks. Supported models:
 * 
 * <p>
 * Recurrent Squeeze-and-Excitation Context Aggregation Net (RESCAN). See <a href=
 * "http://openaccess.thecvf.com/content_ECCV_2018/papers/Xia_Li_Recurrent_Squeeze-and-Excitation_Context_ECCV_2018_paper.pdf">
 * Xia_Li_Recurrent_Squeeze-and-Excitation_Context_ECCV_2018_paper.pdf </a>
 * 
 * <p>
 * Training as well as model generation scripts are provided in the repository at
 * https://github.com/XueweiMeng/derain_filter.git.
 * 
 * <p>
 * Native model files (.model) can be generated from TensorFlow model files (.pb) by using
 * tools/python/convert.py
 * 
 * @author tangxbai
 * @since 2022/06/27
 * @see <a href="https://ffmpeg.org/ffmpeg-filters.html#derain">ffmpeg-filters#derain</a>
 */
@Function( "derain" )
public class Derain extends AbstractFunction<Derain> {

	// Don't let anyone instantiate this class
	private Derain() {}

	/**
	 * Quickly create an instances of {@link Derain}
	 * 
	 * @return the {@link Derain} instance
	 */
	public static final Derain of() {
		return new Derain();
	}

	/**
	 * Specify which filter to use
	 * 
	 * @apiNote (flags) fliter_type
	 * @param type the filter type
	 * @return the {@link Derain} instance
	 * @see FilterType
	 */
	public Derain filter( FilterType type ) {
		return super.addArg( "filter_type", type );
	}

	/**
	 * Specify which DNN backend to use for model loading and execution
	 * 
	 * @apiNote (flags) dnn_backend
	 * @param backend the DNN backend type
	 * @return the {@link Derain} instance
	 * @see DnnBackend
	 */
	public Derain dnnBackend( DnnBackend backend ) {
		return super.addArg( "dnn_backend", backend );
	}

	/**
	 * Set path to model file specifying network architecture and its parameters. Note that different backends
	 * use different file formats. TensorFlow and native backend can load files for only its format.
	 * 
	 * @apiNote (string) model
	 * @param model the model file path
	 * @return the {@link Derain} instance
	 */
	public Derain model( String model ) {
		return super.addArg( "model", model );
	}

	/**
	 * The {@code derain} filter type
	 *
	 * @author tangxbai
	 * @since 2022/06/27
	 */
	public enum FilterType implements AbstractEnum {
		/** Derain filter, To conduct derain filter, you need to use a derain model. */
		DERAIN,
		/** Dehaze filter, To conduct dehaze filter, you need to use a dehaze model. */
		DEHAZE
	}

}
