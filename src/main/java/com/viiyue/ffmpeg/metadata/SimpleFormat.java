package com.viiyue.ffmpeg.metadata;

public class SimpleFormat {

	private String sample;
	private String description;

	public SimpleFormat( String sample, String description ) {
		super();
		this.sample = sample;
		this.description = description;
	}

	public String getSample() {
		return sample;
	}

	public void setSample( String sample ) {
		this.sample = sample;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription( String description ) {
		this.description = description;
	}

	@Override
	public String toString() {
		return sample + "(" + description + ")";
	}

}
