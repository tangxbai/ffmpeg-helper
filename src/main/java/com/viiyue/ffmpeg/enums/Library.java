package com.viiyue.ffmpeg.enums;

import java.util.Locale;

public enum Library {

	FFMPEG( "A complete, cross-platform solution to record, convert and stream audio and video." ),

	FFPROBE( "FFprobe gathers information from multimedia streams and prints it in human- and machine-readable fashion." ),

	FFPLAY( "FFplay is a very simple and portable media player using the FFmpeg libraries and the SDL library. It is mostly used as a testbed for the various FFmpeg APIs." );

	private String description;

	private Library( String description ) {
		this.description = description;
	}

	public String getDescription() {
		return this.description;
	}

	public String getName() {
		return name().toLowerCase( Locale.ENGLISH );
	}

}
