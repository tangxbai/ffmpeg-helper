package com.viiyue.ffmpeg.filter.video;

import com.viiyue.ffmpeg.annotation.Function;
import com.viiyue.ffmpeg.filter.AbstractFunction;
import com.viiyue.ffmpeg.util.Assert;

/**
 * Do classification with deep neural networks based on bounding boxes
 * 
 * @author tangxbai
 * @since 2022/06/27
 * @see <a href="https://ffmpeg.org/ffmpeg-filters.html#dnn_classify">ffmpeg-filters#dnn_classify</a>
 */
@Function( "dnn_classify" )
public class DnnClassify extends AbstractFunction<DnnClassify> {

	// Don't let anyone instantiate this class
	private DnnClassify() {}

	/**
	 * Quickly create an instances of {@link DnnClassify}
	 * 
	 * @return the {@link DnnClassify} instance
	 */
	public static final DnnClassify of() {
		return new DnnClassify();
	}

	/**
	 * Specify which DNN backend to use for model loading and execution. This option accepts only openvino
	 * now, tensorflow backends will be added. default is <b>2</b>.
	 * 
	 * @apiNote (int) dnn_backend
	 * @param backend the DNN backend value
	 * @return the {@link DnnClassify} instance
	 */
	public DnnClassify backend( int backend ) {
		return super.addArg( "dnn_backend", backend );
	}

	/**
	 * Set path to model file specifying network architecture and its parameters. Note that different backends
	 * use different file formats.
	 * 
	 * @apiNote (string) model
	 * @param filePath the model file path
	 * @return the {@link DnnClassify} instance
	 */
	public DnnClassify model( String filePath ) {
		return super.addArg( "model", filePath );
	}

	/**
	 * Set the input name of the dnn network
	 * 
	 * @apiNote (string) input
	 * @param inputName the input name of the dnn network
	 * @return the {@link DnnClassify} instance
	 */
	public DnnClassify input( String inputName ) {
		return super.addArg( "input", inputName );
	}

	/**
	 * Set the output name of the dnn network
	 * 
	 * @apiNote (string) output
	 * @param outputName the output name of the dnn network
	 * @return the {@link DnnClassify} instance
	 */
	public DnnClassify output( String outputName ) {
		return super.addArg( "output", outputName );
	}

	/**
	 * Set the confidence threshold, range is from 0.0 to 1.0, default is <b>0.5</b>.
	 * 
	 * @apiNote (double) confidence
	 * @param threshold the confidence threshold
	 * @return the {@link DnnClassify} instance
	 */
	public DnnClassify confidence( double threshold ) {
		Assert.rangeCheck( threshold, 0.0, 1.0 );
		return super.addArg( "confidence", threshold );
	}

	/**
	 * Set path to label file specifying the mapping between label id and name. Each label name is written in
	 * one line, tailing spaces and empty lines are skipped. The first line is the name of label id 0, and the
	 * second line is the name of label id 1, etc. The label id is considered as name if the label file is not
	 * provided.
	 * 
	 * @apiNote (string) labels
	 * @param labels the path to labels file
	 * @return the {@link DnnClassify} instance
	 */
	public DnnClassify labels( String labels ) {
		return super.addArg( "labels", labels );
	}

	/**
	 * <p>
	 * Set the configs to be passed into backend
	 * 
	 * <p>
	 * For tensorflow backend, you can set its configs with sess_config options, please use
	 * tools/python/tf_sess_config.py to get the configs for your system.
	 * 
	 * @apiNote (string) backend_configs
	 * @param configs the backend configs content
	 * @return the {@link DnnClassify} instance
	 */
	public DnnClassify configs( String configs ) {
		return super.addArg( "backend_configs", configs );
	}

	/**
	 * Set which one to be classified
	 * 
	 * @apiNote (string) target
	 * @param classified the which one to be classified
	 * @return the {@link DnnClassify} instance
	 */
	public DnnClassify target( String classified ) {
		return super.addArg( "target", classified );
	}

}
