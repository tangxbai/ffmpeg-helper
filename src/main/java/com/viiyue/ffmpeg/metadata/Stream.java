package com.viiyue.ffmpeg.metadata;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;

@XmlAccessorType( XmlAccessType.FIELD )
public class Stream {

	@XmlAttribute
	private int index;
	@XmlAttribute( name = "codec_name" )
	private String codecName;
	@XmlAttribute( name = "codec_long_name" )
	private String codecLongName;
	@XmlAttribute( name = "codec_type" )
	private String codecType;
	@XmlAttribute( name = "codec_time_base" )
	private int codeTimeBase;
	@XmlAttribute( name = "codec_tag" )
	private String codecTag;
	@XmlAttribute( name = "codec_tag_string" )
	private String codecTagString;
	@XmlAttribute( name = "sample_aspect_ratio" )
	private String sampleAspectRatio;
	@XmlAttribute( name = "display_aspect_ratio" )
	private String displayAspectRatio;
	@XmlAttribute( name = "pix_fmt" )
	private String pixFmt;
	@XmlAttribute
	private String profile;

	@XmlAttribute
	private int width;
	@XmlAttribute
	private int height;
	@XmlAttribute( name = "has_b_frames" )
	private int hasBufferedFrames;
	@XmlAttribute
	private int level;
	@XmlAttribute( name = "is_avc" )
	private boolean avc;
	@XmlAttribute( name = "nal_length_size" )
	private boolean nalLengthSize;

	@XmlAttribute( name = "r_frame_rate" )
	private String realFrameRate;
	@XmlAttribute( name = "avg_frame_rate" )
	private String avgFrameRate;

	@XmlAttribute( name = "start_time" )
	private double startTime;
	@XmlAttribute
	private double duration;
	@XmlAttribute( name = "nb_frames" )
	private int frames;

	public int getIndex() {
		return index;
	}

	public void setIndex( int index ) {
		this.index = index;
	}

	public String getCodecName() {
		return codecName;
	}

	public void setCodecName( String codecName ) {
		this.codecName = codecName;
	}

	public String getCodecLongName() {
		return codecLongName;
	}

	public void setCodecLongName( String codecLongName ) {
		this.codecLongName = codecLongName;
	}

	public String getCodecType() {
		return codecType;
	}

	public void setCodecType( String codecType ) {
		this.codecType = codecType;
	}

	public int getCodeTimeBase() {
		return codeTimeBase;
	}

	public void setCodeTimeBase( int codeTimeBase ) {
		this.codeTimeBase = codeTimeBase;
	}

	public String getCodecTag() {
		return codecTag;
	}

	public void setCodecTag( String codecTag ) {
		this.codecTag = codecTag;
	}

	public String getCodecTagString() {
		return codecTagString;
	}

	public void setCodecTagString( String codecTagString ) {
		this.codecTagString = codecTagString;
	}

	public String getSampleAspectRatio() {
		return sampleAspectRatio;
	}

	public void setSampleAspectRatio( String sampleAspectRatio ) {
		this.sampleAspectRatio = sampleAspectRatio;
	}

	public String getDisplayAspectRatio() {
		return displayAspectRatio;
	}

	public void setDisplayAspectRatio( String displayAspectRatio ) {
		this.displayAspectRatio = displayAspectRatio;
	}

	public String getPixFmt() {
		return pixFmt;
	}

	public void setPixFmt( String pixFmt ) {
		this.pixFmt = pixFmt;
	}

	public String getProfile() {
		return profile;
	}

	public void setProfile( String profile ) {
		this.profile = profile;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth( int width ) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight( int height ) {
		this.height = height;
	}

	public int getHasBufferedFrames() {
		return hasBufferedFrames;
	}

	public void setHasBufferedFrames( int hasBufferedFrames ) {
		this.hasBufferedFrames = hasBufferedFrames;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel( int level ) {
		this.level = level;
	}

	public boolean isAvc() {
		return avc;
	}

	public void setAvc( boolean avc ) {
		this.avc = avc;
	}

	public boolean isNalLengthSize() {
		return nalLengthSize;
	}

	public void setNalLengthSize( boolean nalLengthSize ) {
		this.nalLengthSize = nalLengthSize;
	}

	public String getRealFrameRate() {
		return realFrameRate;
	}

	public void setRealFrameRate( String realFrameRate ) {
		this.realFrameRate = realFrameRate;
	}

	public String getAvgFrameRate() {
		return avgFrameRate;
	}

	public void setAvgFrameRate( String avgFrameRate ) {
		this.avgFrameRate = avgFrameRate;
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

	public int getFrames() {
		return frames;
	}

	public void setFrames( int frames ) {
		this.frames = frames;
	}

}
