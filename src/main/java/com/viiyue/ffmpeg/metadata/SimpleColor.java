package com.viiyue.ffmpeg.metadata;

public class SimpleColor {

	private String color;
	private String hexValue;

	public SimpleColor( String color, String hexValue ) {
		super();
		this.color = color;
		this.hexValue = hexValue;
	}

	public String getColor() {
		return color;
	}

	public void setColor( String color ) {
		this.color = color;
	}

	public String getHex() {
		return hexValue;
	}

	public void setHex( String hex ) {
		this.hexValue = hex;
	}

	@Override
	public String toString() {
		return color + "(" + hexValue + ")";
	}

}
