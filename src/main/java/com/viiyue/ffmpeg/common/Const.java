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
package com.viiyue.ffmpeg.common;

import static org.apache.commons.lang3.StringUtils.EMPTY;

import com.viiyue.ffmpeg.enums.Platform;
import com.viiyue.ffmpeg.util.Helper;

/**
 * Plug-in defined constants
 *
 * @author tangxbai
 * @since 2022/09/30
 */
public final class Const {

	private Const() {}

	// FFmpeg program name

	public static final String FFMPEG = "ffmpeg";
	public static final String FFPROBE = "ffprobe";
	public static final String FFPLAY = "ffplay";

	// Common constants

	public static final Platform PLATFORM = Helper.getPlatform();
	public static final String HOME_PATH = System.getProperty( "user.home", "/" );
	public static final String TEMP_PATH = System.getProperty( "java.io.tmpdir", "/" );

	/** NULL placeholder: {@value} */
	public static final String NONE = "";
	public static final String NULL = "NULL";
	public static final String SLASH = "/";
	public static final String ARG_PREFIX = "-";
	public static final double DECIMAL_EPS = 1e-10;

	// Wrap tokens

	/** Input token start part: {@value} */
	public static final String INPUT_TOKEN_START = "[";
	/** Input token end part: {@value} */
	public static final String INPUT_TOKEN_END = "]";
	/** Input token single quote: {@value} */
	public static final String QUOTE = "'";
	/** Input token double quote: {@value} */
	public static final String DB_QUOTES = "\"";
	/** Input arguments wrapper: ["", ""] */
	public static final String [] ARGUMENT_WRAPPER = { EMPTY, EMPTY };

	// Character separator

	/** Value separator: {@value} */
	public static final String VALUE_SEPARATOR = "=";
	/** Filter parameter separator: {@value} */
	public static final String PARAMETER_SEPARATOR = ":";
	/** Filter group separator: {@value} */
	public static final String GROUP_SEPARATOR = ";";
	/** Value separator: {@value} */
	public static final String PART_SEPARATOR = ",";
	/** Value append separator: {@value} */
	public static final String APPEND_SEPARATOR = "+";
	/** Or value separator: {@value} */
	public static final String LIST_SEPARATOR = "|";

}
