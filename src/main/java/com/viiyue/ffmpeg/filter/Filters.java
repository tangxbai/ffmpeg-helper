/**
 * Copyright (C) 2022-2023 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in
 * compliance with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License is
 * distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and limitations under the License.
 */
package com.viiyue.ffmpeg.filter;

import java.util.LinkedList;
import java.util.List;
import java.util.StringJoiner;

import org.apache.commons.lang3.StringUtils;

import com.viiyue.ffmpeg.common.Const;
import com.viiyue.ffmpeg.util.Assert;

/**
 * @author tangxbai
 * @since 2022/06/06
 */
public final class Filters {

	private final String filter;

	private List<Split> spliters = new LinkedList<Split>();
	private List<Stream> streams = new LinkedList<Stream>();

	private Filters( String filter ) {
		this.filter = filter;
	}

	public static Filters simple() {
		return define( "vf" );
	}

	public static Filters complex() {
		return define( "filter_complex" );
	}

	public static Filters define( String type ) {
		return new Filters( type );
	}
	
	public Split split() {
		Split split = new Split( this );
		this.spliters.add( split );
		return split;
	}

	public Split split( String stream ) {
		Assert.notEmpty( stream, "The input split stream name cannot be empty" );
		Split split = new Split( this, stream );
		this.spliters.add( split );
		return split;
	}
	
	public Stream stream( Integer ... streams ) {
		Stream stream = new Stream( this, streams );
		this.streams.add( stream );
		return stream;
	}
	
	public Stream stream( String ... streams ) {
		Stream stream = new Stream( this, streams );
		this.streams.add( stream );
		return stream;
	}
	
	public Stream stream( List<?> streams ) {
		Stream stream = new Stream( this, streams );
		this.streams.add( stream );
		return stream;
	}

	public Stream add( AbstractResult<?> result ) {
		Stream stream = new Stream( this ).add( result );
		this.streams.add( stream );
		return stream;
	}
	
	public Stream add( AbstractResult<?> ... results ) {
		Stream stream = new Stream( this ).add( results );
		this.streams.add( stream );
		return stream;
	}

	public Stream add( String expression ) {
		Stream stream = new Stream( this ).add( expression );
		this.streams.add( stream );
		return stream;
	}
	
	public Stream add( String ... expressions ) {
		Stream stream = new Stream( this ).add( expressions );
		this.streams.add( stream );
		return stream;
	}

	public Stream add( Class<? extends AbstractResult<?>> simple ) {
		Stream stream = new Stream( this ).add( simple );
		this.streams.add( stream );
		return stream;
	}
	
	public Stream add( Class<? extends AbstractResult<?>> ... simples ) {
		Stream stream = new Stream( this ).add( simples );
		this.streams.add( stream );
		return stream;
	}

	public String getFilter() {
		return this.filter;
	}

	@Override
	public String toString() {
		if ( streams.isEmpty() ) {
			return StringUtils.EMPTY;
		}
		StringJoiner joiner = new StringJoiner( Const.GROUP_SEPARATOR );
		for ( Split split : spliters ) {
			joiner.add( split.getResult() );
		}
		for ( int i = 0, s = streams.size(); i < s; i ++ ) {
			joiner.add( streams.get( i ).output() );
		}
		return joiner.toString();
	}

}
