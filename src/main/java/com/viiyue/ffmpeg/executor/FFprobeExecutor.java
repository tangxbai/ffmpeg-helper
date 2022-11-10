package com.viiyue.ffmpeg.executor;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.viiyue.ffmpeg.enums.Library;
import com.viiyue.ffmpeg.metadata.FFprobe;
import com.viiyue.ffmpeg.util.Jaxb;

public class FFprobeExecutor extends CommonExecutor<FFprobeExecutor> {

	private static final Logger LOG = LoggerFactory.getLogger( FFprobeExecutor.class );

	public static final FFprobeExecutor build() {
		return new FFprobeExecutor();
	}

	private FFprobeExecutor() {
		super( Library.FFPROBE );
	}

	@Override
	public Logger getLogger() {
		return LOG;
	}

	public FFprobeExecutor streams( String type ) {
		super.cmd( "show_streams" );
		return super.cmd( "select_streams", type );
	}

	public FFprobeExecutor vstreams() {
		return streams( "v" );
	}

	public FFprobeExecutor astreams() {
		return streams( "a" );
	}

	public FFprobeExecutor foramt() {
		return super.cmd( "show_format" );
	}

	public FFprobeExecutor versions() {
		return super.cmd( "show_versions" );
	}

	public FFprobeExecutor decoders() {
		return super.cmd( "decoders" );
	}

	public FFprobeExecutor sections() {
		return super.cmd( "sections" );
	}

	public FFprobeExecutor frames() {
		return super.cmd( "show_frames" );
	}

	public FFprobeExecutor chapters() {
		return super.cmd( "show_chapters" );
	}

	public FFprobeExecutor pixel() {
		return super.cmd( "show_pixel_formats" );
	}

	public FFprobeExecutor optional() {
		return super.cmd( "show_optional_fields" );
	}

	public FFprobeExecutor streamInfo() {
		return super.cmd( "find_stream_info" );
	}

	public String to() {
		return super.execute();
	}

	public String toCSVString() {
		return to( "scv" );
	}

	public String toJsonString() {
		return to( "json" );
	}

	public String toFlatString() {
		return to( "flat" );
	}

	public String toIniString() {
		return to( "ini" );
	}

	public Optional<FFprobe> toBean() {
		return Optional.ofNullable( Jaxb.context().toBean( to( "xml" ), FFprobe.class ) );
	}

	private String to( String format ) {
		return super.cmd( "of", format ).execute();
	}

}
