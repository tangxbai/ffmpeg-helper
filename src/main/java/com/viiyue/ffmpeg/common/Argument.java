package com.viiyue.ffmpeg.common;

import java.util.Objects;

import com.viiyue.ffmpeg.util.Helper;

public final class Argument {

	private int index;
	private String key;
	private Object value;

	public int getIndex() {
		return index;
	}

	public void setIndex( int index ) {
		this.index = index;
	}

	public String getKey() {
		return key;
	}

	public void setKey( String key ) {
		this.key = Helper.command( key );
	}

	public Object getValue() {
		return value;
	}

	public void setValue( Object value ) {
		this.value = value;
	}

	public boolean is( String key ) {
		return Objects.equals( Helper.command( key ), this.key );
	}

	@Override
	public String toString() {
		return key + ( value == null ? "" : " " + value );
	}

}
