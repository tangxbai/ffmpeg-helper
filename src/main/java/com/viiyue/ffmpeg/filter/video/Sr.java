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
import com.viiyue.ffmpeg.enums.DnnBackend;
import com.viiyue.ffmpeg.filter.AbstractFunction;
import com.viiyue.ffmpeg.util.Assert;

/**
 * <p>
 * Scale the input by applying one of the super-resolution methods based on convolutional neural networks.
 * Supported models:
 * 
 * <ul>
 * <li>Super-Resolution Convolutional Neural Network model (SRCNN). See
 * <a href="https://arxiv.org/abs/1501.00092">https://arxiv.org/abs/1501.00092</a>.
 * <li>Efficient Sub-Pixel Convolutional Neural Network model (ESPCN). See
 * <a href="https://arxiv.org/abs/1609.05158">https://arxiv.org/abs/1609.05158</a>.
 * </ul>
 * 
 * <p>
 * Training scripts as well as scripts for model file (.pb) saving can be found at <a href=
 * "https://github.com/XueweiMeng/sr/tree/sr_dnn_native">https://github.com/XueweiMeng/sr/tree/sr_dnn_native</a>.
 * Original repository is at <a href=
 * "https://github.com/HighVoltageRocknRoll/sr.git">https://github.com/HighVoltageRocknRoll/sr.git</a>.
 * 
 * <p>
 * Native model files (.model) can be generated from TensorFlow model files (.pb) by using
 * tools/python/convert.py
 * 
 * @author tangxbai
 * @since 2022/08/05
 * @see <a href="https://ffmpeg.org/ffmpeg-filters.html#spp-1">ffmpeg-filters#spp</a>
 */
@Function( "sr" )
public class Sr extends AbstractFunction<Sr> {

	// Don't let anyone instantiate this class
	private Sr() {}

	/**
	 * Quickly create an instances of {@link Sr}
	 * 
	 * @return the {@link Sr} instance
	 */
	public static final Sr of() {
		return new Sr();
	}

	/**
	 * Specify which DNN backend to use for model loading and execution
	 * 
	 * @apiNote (flags) dnn_backend
	 * @param backend the DNN backend type
	 * @return the {@link Sr} instance
	 * @see DnnBackend
	 */
	public Sr dnnBackend( DnnBackend backend ) {
		return super.addArg( "dnn_backend", backend );
	}

	/**
	 * Set path to model file specifying network architecture and its parameters. Note that different backends
	 * use different file formats. TensorFlow and native backend can load files for only its format.
	 * 
	 * @apiNote (string) model
	 * @param model the model file path
	 * @return the {@link Sr} instance
	 */
	public Sr model( String model ) {
		return super.addArg( "model", model );
	}

	/**
	 * Set scale factor for SRCNN model. Allowed values are <b>2</b>, <b>3</b> and <b>4</b>. Default value is
	 * <b>2</b>. Scale factor is necessary for SRCNN model, because it accepts input upscaled using bicubic
	 * upscaling with proper scale factor.
	 * 
	 * @apiNote (int) scale_factor
	 * @param value the scale factor value
	 * @return the {@link Sr} instance
	 */
	public Sr scaleFactor( int value ) {
		Assert.rangeCheck( value, 2, 4 );
		return super.addArg( "scale_factor", value );
	}

}
