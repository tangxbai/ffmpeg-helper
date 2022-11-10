package com.viiyue.ffmpeg.filter.video;

import com.viiyue.ffmpeg.annotation.Function;
import com.viiyue.ffmpeg.filter.AbstractFunction;
import com.viiyue.ffmpeg.util.Assert;

/**
 * Do object detection with deep neural networks
 * 
 * @author tangxbai
 * @since 2022/06/28
 * @see <a href="https://ffmpeg.org/ffmpeg-filters.html#dnn_detect">ffmpeg-filters#dnn_detect</a>
 */
@Function( "dnn_detect" )
public class DnnDetect extends AbstractFunction<DnnDetect> {

	// Don't let anyone instantiate this class
	private DnnDetect() {}

	/**
	 * Quickly create an instances of {@link DnnDetect}
	 * 
	 * @return the {@link DnnDetect} instance
	 */
	public static final DnnDetect of() {
		return new DnnDetect();
	}

	/**
	 * Specify which DNN backend to use for model loading and execution. This option accepts only openvino
	 * now, tensorflow backends will be added. default is <b>2</b>.
	 * 
	 * @apiNote (int) dnn_backend
	 * @param backend the DNN backend value
	 * @return the {@link DnnDetect} instance
	 */
	public DnnDetect backend( int backend ) {
		return super.addArg( "dnn_backend", backend );
	}

	/**
	 * Set path to model file specifying network architecture and its parameters. Note that different backends
	 * use different file formats.
	 * 
	 * @apiNote (string) model
	 * @param filePath the model file path
	 * @return the {@link DnnDetect} instance
	 */
	public DnnDetect model( String filePath ) {
		return super.addArg( "model", filePath );
	}

	/**
	 * Set the input name of the dnn network
	 * 
	 * @apiNote (string) input
	 * @param inputName the input name of the dnn network
	 * @return the {@link DnnDetect} instance
	 */
	public DnnDetect input( String inputName ) {
		return super.addArg( "input", inputName );
	}

	/**
	 * Set the output name of the dnn network
	 * 
	 * @apiNote (string) output
	 * @param outputName the output name of the dnn network
	 * @return the {@link DnnDetect} instance
	 */
	public DnnDetect output( String outputName ) {
		return super.addArg( "output", outputName );
	}

	/**
	 * Set the confidence threshold, range is from 0.0 to 1.0, default is <b>0.5</b>.
	 * 
	 * @apiNote (double) confidence
	 * @param threshold the confidence threshold
	 * @return the {@link DnnDetect} instance
	 */
	public DnnDetect confidence( double threshold ) {
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
	 * @return the {@link DnnDetect} instance
	 */
	public DnnDetect labels( String labels ) {
		return super.addArg( "labels", labels );
	}

	/**
	 * Set the configs to be passed into backend. To use async execution, set async (default: set). Roll back
	 * to sync execution if the backend does not support async.
	 * 
	 * @param configs the backend configs content
	 * @return the {@link DnnDetect} instance
	 */
	public DnnDetect configs( String configs ) {
		return super.addArg( "backend_configs", configs );
	}

}
