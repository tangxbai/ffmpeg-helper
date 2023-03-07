/**
 * Copyright (C) 2022-2023 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.viiyue.ffmpeg.filter.video;

import com.viiyue.ffmpeg.annotation.Function;
import com.viiyue.ffmpeg.common.AbstractEnum;
import com.viiyue.ffmpeg.filter.AbstractFunction;

/**
 * Do image processing with deep neural networks. It works together with another filter which converts the
 * pixel format of the Frame to what the dnn network requires.
 * 
 * @author tangxbai
 * @since 2022/06/28
 * @see <a href="https://ffmpeg.org/ffmpeg-filters.html#dnn_processing">ffmpeg-filters#dnn_processing</a>
 */
@Function( "dnn_processing" )
public class DnnProcessing extends AbstractFunction<DnnProcessing> {

	// Don't let anyone instantiate this class
	private DnnProcessing() {}

	/**
	 * Quickly create an instances of {@link DnnProcessing}
	 * 
	 * @return the {@link DnnProcessing} instance
	 */
	public static final DnnProcessing of() {
		return new DnnProcessing();
	}

	/**
	 * Specify which DNN backend to use for model loading and execution. This option accepts only openvino
	 * now, tensorflow backends will be added. default is <b>2</b>.
	 * 
	 * @apiNote (flags) dnn_backend
	 * @param backend the DNN backend value
	 * @return the {@link DnnProcessing} instance
	 * @see DnnBackend
	 */
	public DnnProcessing backend( DnnBackend backend ) {
		return super.addArg( "dnn_backend", backend );
	}

	/**
	 * <p>
	 * Set path to model file specifying network architecture and its parameters. Note that different backends
	 * use different file formats. TensorFlow, OpenVINO and native backend can load files for only its format.
	 * 
	 * <p>
	 * Native model file (.model) can be generated from TensorFlow model file (.pb) by using
	 * tools/python/convert.py
	 * 
	 * @apiNote (string) model
	 * @param filePath the model file path
	 * @return the {@link DnnProcessing} instance
	 */
	public DnnProcessing model( String filePath ) {
		return super.addArg( "model", filePath );
	}

	/**
	 * Set the input name of the dnn network
	 * 
	 * @apiNote (string) input
	 * @param inputName the input name of the dnn network
	 * @return the {@link DnnProcessing} instance
	 */
	public DnnProcessing input( String inputName ) {
		return super.addArg( "input", inputName );
	}

	/**
	 * Set the output name of the dnn network
	 * 
	 * @apiNote (string) output
	 * @param outputName the output name of the dnn network
	 * @return the {@link DnnProcessing} instance
	 */
	public DnnProcessing output( String outputName ) {
		return super.addArg( "output", outputName );
	}

	/**
	 * Set the configs to be passed into backend. To use async execution, set async (default: set). Roll back
	 * to sync execution if the backend does not support async.
	 * 
	 * @apiNote (string) backend_configs
	 * @param configs the backend configs content
	 * @return the {@link DnnProcessing} instance
	 */
	public DnnProcessing configs( String configs ) {
		return super.addArg( "backend_configs", configs );
	}

	/**
	 * DNN backend options
	 *
	 * @author tangxbai
	 * @since 2022/06/28
	 */
	public enum DnnBackend implements AbstractEnum {
		/** Native implementation of DNN loading and execution */
		NATIVE,
		/**
		 * TensorFlow backend. To enable this backend you need to install the TensorFlow for C library (see
		 * <a href="https://www.tensorflow.org/install/lang_c">https://www.tensorflow.org/install/lang_c</a>)
		 * and configure FFmpeg with {@code --enable-libtensorflow}
		 */
		TENSORFLOW,
		/**
		 * OpenVINO backend. To enable this backend you need to build and install the OpenVINO for C library
		 * (see <a href=
		 * "https://github.com/openvinotoolkit/openvino/blob/master/build-instruction.md">https://github.com/openvinotoolkit/openvino/blob/master/build-instruction.md</a>)
		 * and configure FFmpeg with {@code --enable-libopenvino} (–extra-cflags=-I... –extra-ldflags=-L...
		 * might be needed if the header files and libraries are not installed into system path)
		 */
		OPENVINO
	}

}
