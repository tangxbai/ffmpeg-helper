package com.viiyue.ffmpeg.enums;

import com.viiyue.ffmpeg.common.AbstractEnum;

/**
 * DNN backend
 *
 * @author tangxbai
 * @since 2022/06/27
 */
public enum DnnBackend implements AbstractEnum {
	/**
	 * Native implementation of DNN loading and execution
	 */
	NATIVE,
	/**
	 * TensorFlow backend. To enable this backend you need to install the TensorFlow for C library (see
	 * https://www.tensorflow.org/install/lang_c) and configure FFmpeg with {@code --enable-libtensorflow}
	 */
	TENSORFLOW
}
