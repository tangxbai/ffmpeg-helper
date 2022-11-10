package com.viiyue.ffmpeg.metadata;

import java.util.List;
import java.util.Objects;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

import org.apache.commons.collections.CollectionUtils;

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
