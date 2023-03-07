/**
 * Copyright (C) 2022-2023 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in
 * compliance with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License is
 * distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and limitations under the License.
 */
package com.viiyue.ffmpeg.enums;

import org.apache.commons.lang3.StringUtils;

/**
 * Different server running platforms
 *
 * @author tangxbai
 * @since 2022/06/15
 */
public enum Platform {

	LINUX, WINDOWS( ".exe" ), ANDROID( ".so" );

	private String ext;

	private Platform() {
		this( StringUtils.EMPTY );
	}

	private Platform( String ext ) {
		this.ext = ext;
	}

	public String getExtension() {
		return this.ext;
	}

	public String getProgram( String name ) {
		return name.concat( ext );
	}

}
