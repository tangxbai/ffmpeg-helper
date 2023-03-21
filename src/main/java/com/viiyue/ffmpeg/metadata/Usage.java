package com.viiyue.ffmpeg.metadata;

import java.util.Objects;

import com.viiyue.ffmpeg.common.Const;
import com.viiyue.ffmpeg.common.UsageLambda;
import com.viiyue.ffmpeg.util.Helper;

public class Usage {

	private static final String LINE_BREAK = Helper.command( "//" );

	private String usage;
	private String method = Const.NONE;
	private String description;

	public static final Usage builder() {
		return new Usage();
	}

	public Usage usage( String name ) {
		this.usage = Helper.command( name );
		return this;
	}

	public Usage usage( String name, UsageLambda method ) {
		return this.usage( name, Helper.getLambdaMethod( method ) );
	}
	
	public Usage usage( String name, String method ) {
		this.usage( name );
		this.method = method;
		return this;
	}

	public Usage des( String description ) {
		this.description = description;
		return this;
	}

	public Usage divider() {
		this.usage = LINE_BREAK;
		return this;
	}
	
	public boolean isDivider() {
		return Objects.equals( usage, LINE_BREAK );
	}
	
	public int mLength() {
		return method == null ? 0 : method.length();
	}

	public String getUsage() {
		return usage;
	}

	public String getMethod() {
		return method;
	}

	public String getDescription() {
		return description;
	}

}
