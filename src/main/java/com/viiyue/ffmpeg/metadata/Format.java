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
package com.viiyue.ffmpeg.metadata;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;

/**
 * 
 * @author tangxbai
 * @since 2022/05/25
 */
@XmlAccessorType( XmlAccessType.FIELD )
public class Format {

	@XmlAttribute
	private String filename;
	@XmlAttribute( name = "nb_streams" )
	private int streams;
	@XmlAttribute( name = "nb_programs" )
	private int programs;
	@XmlAttribute( name = "format_name" )
	private String formats;
	@XmlAttribute( name = "start_time" )
	private double startTime;
	@XmlAttribute
	private double duration;
	@XmlAttribute
	private long size;
	@XmlAttribute( name = "bit_rate" )
	private long bitRate;
	@XmlAttribute( name = "probe_score" )
	private int probeScore;

	public String getFilename() {
		return filename;
	}

	public void setFilename( String filename ) {
		this.filename = filename;
	}

	public int getStreams() {
		return streams;
	}

	public void setStreams( int streams ) {
		this.streams = streams;
	}

	public int getPrograms() {
		return programs;
	}

	public void setPrograms( int programs ) {
		this.programs = programs;
	}

	public String getFormats() {
		return formats;
	}

	public void setFormats( String formats ) {
		this.formats = formats;
	}

	public double getStartTime() {
		return startTime;
	}

	public void setStartTime( double startTime ) {
		this.startTime = startTime;
	}

	public double getDuration() {
		return duration;
	}

	public void setDuration( double duration ) {
		this.duration = duration;
	}

	public long getSize() {
		return size;
	}

	public void setSize( long size ) {
		this.size = size;
	}

	public long getBitRate() {
		return bitRate;
	}

	public void setBitRate( long bitRate ) {
		this.bitRate = bitRate;
	}

	public int getProbeScore() {
		return probeScore;
	}

	public void setProbeScore( int probeScore ) {
		this.probeScore = probeScore;
	}

}
