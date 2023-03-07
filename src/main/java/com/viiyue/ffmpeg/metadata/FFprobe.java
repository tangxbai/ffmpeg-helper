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

import java.util.List;
import java.util.Objects;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

import org.apache.commons.collections.CollectionUtils;

/**
 * 
 * @author tangxbai
 * @since 2022/05/25
 */
@XmlRootElement( name = "ffprobe" )
@XmlAccessorType( XmlAccessType.FIELD )
public class FFprobe {

	@XmlElement
	private Format format;

	@XmlElement( name = "stream" )
	@XmlElementWrapper( name = "streams" )
	private List<Stream> streams;

	public Format getFormat() {
		return format;
	}

	public void setFormat( Format format ) {
		this.format = format;
	}

	public List<Stream> getStreams() {
		return streams;
	}

	public void setStreams( List<Stream> streams ) {
		this.streams = streams;
	}

	public Stream getVideoStream() {
		return findStream( "video" );
	}

	public Stream getAudioStream() {
		return findStream( "audio" );
	}

	private Stream findStream( String codecType ) {
		if ( CollectionUtils.isNotEmpty( streams ) ) {
			for ( Stream stream : streams ) {
				if ( Objects.equals( stream.getCodecType(), codecType ) ) {
					return stream;
				}
			}
		}
		return null;
	}

}
