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
package com.viiyue.ffmpeg.filter;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.StringJoiner;
import java.util.concurrent.ConcurrentHashMap;

import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;

import com.viiyue.ffmpeg.annotation.Function;
import com.viiyue.ffmpeg.common.Const;
import com.viiyue.ffmpeg.util.Helper;

public final class Stream {

	private static final Map<Class<?>, String> caches = new ConcurrentHashMap<>( 128 );
	private static final java.util.function.Function<Class<?>, String> provider = type -> {
		Function fun = type.getAnnotation( Function.class );
		return fun == null ? null : fun.value();
	};

	private final Filters filters;
	private final String input;
	private final List<String> chains = new LinkedList<>();
	private String tag;

	protected Stream( Filters filters ) {
		this.input = null;
		this.filters = filters;
	}
	
	protected Stream( Filters filters, Integer ... streams ) {
		this.filters = filters;
		this.input = input( streams );
	}
	
	protected Stream( Filters filters,  String ... streams ) {
		this.filters = filters;
		this.input = input( streams );
	}
	
	protected Stream( Filters filters, List<?> streams ) {
		this.filters = filters;
		this.input = input( streams.toArray( new Object [ streams.size() ] ) );
	}

	private String input( Object ... streams ) {
		return Helper.expandAll( "", Helper::wrap, streams ).toString(); // "[a][b]..."
	}
	
	public Stream add( String expression ) {
		if ( StringUtils.isNotEmpty( expression ) ) {
			this.chains.add( expression );
		}
		return this;
	}

	public Stream add( String ... expressions ) {
		if ( ArrayUtils.isNotEmpty( expressions ) ) {
			for ( String exp : expressions ) {
				add( exp );
			}
		}
		return this;
	}

	public Stream add( AbstractResult<?> result ) {
		if ( result != null ) {
			this.chains.add( result.getResult() );
		}
		return this;
	}
		
	public Stream add( AbstractResult<?> ... results ) {
		if ( ArrayUtils.isNotEmpty( results ) ) {
			for ( AbstractResult<?> result : results ) {
				add( result );
			}
		}
		return this;
	}

	public Stream add( Class<? extends AbstractResult<?>> simple ) {
		if ( simple != null ) {
			String funName = caches.computeIfAbsent( simple, provider );
			if ( funName != null ) {
				this.chains.add( funName );
			}
		}
		return this;
	}
	
	public Stream add( Class<? extends AbstractResult<?>> ... simples ) {
		if ( ArrayUtils.isNotEmpty( simples ) ) {
			for ( Class<? extends AbstractResult<?>> simple : simples ) {
				add( simple );
			}
		}
		return this;
	}

	public Filters over() {
		return this.filters;
	}
	
	public Stream tag( String tag ) {
		if ( StringUtils.isNotEmpty( tag ) ) {
			this.tag = Helper.wrap( tag );
		}
		return this;
	}

	public String getInput() {
		return input;
	}

	public String getTag() {
		return StringUtils.defaultString( tag );
	}

	public String output() {
		Object [] allFuntions = chains.toArray();
		StringJoiner filters = Helper.expandAll( Const.PART_SEPARATOR, allFuntions );
		String output = StringUtils.isEmpty( input ) ? filters.toString() : input + filters;
		return output + getTag();
	}

}
