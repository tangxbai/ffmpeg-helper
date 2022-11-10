package com.viiyue.ffmpeg.common;

import java.util.Locale;

public interface AbstractEnum {

	/**
	 * @return the enum element name
	 * @see Enum#name()
	 */
	String name();

	default String getName() {
		return name().toLowerCase( Locale.ENGLISH );
	}

	default String getName( String yours ) {
		return yours == null ? getName() : yours;
	}

	default String command() {
		return EnumMapper.getName( getClass(), this );
	}

}
