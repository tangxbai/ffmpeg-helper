package com.viiyue.ffmpeg.enums;

import org.apache.commons.lang3.StringUtils;

/**
 * Different server running platforms
 *
 * @author tangxbai
 * @since 2022/06/15
 */
public enum Platform {

	WINDOWS( ".exe" ), LINUX, MACOS, ANDROID( ".so" ), IOS;

	private String ext = StringUtils.EMPTY;

	private Platform() {}

	private Platform( String ext ) {
		this.ext = ext;
	}

	public String getExtension() {
		return this.ext;
	}

	public String getProgram( String name ) {
		return name + ext;
	}

}
