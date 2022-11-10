package com.viiyue.ffmpeg.filter;

import java.util.LinkedList;
import java.util.List;
import java.util.StringJoiner;

import org.apache.commons.lang3.StringUtils;

import com.viiyue.ffmpeg.common.Const;
import com.viiyue.ffmpeg.util.Assert;
import com.viiyue.ffmpeg.util.Helper;

/**
 * @author tangxbai
 * @since 2022/06/06
 */
public final class Filters {

	private final String filter;

	private String spliter;
	private List<Graph> filters = new LinkedList<Graph>();

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

	public Filters split( String ... streams ) {
		Assert.notEmpty( streams, "The input split stream name cannot be empty" );
		this.spliter = Helper.expandAll( "", Helper::wrap, streams ).toString(); // [a][b]...
		return this;
	}

	public Filters graph( Graph graph ) {
		Assert.notNull( graph, "The filter graph cannot be null" );
		this.filters.add( graph );
		return this;
	}

	public Filters graph( AbstractResult<?> ... results ) {
		this.filters.add( Graph.append( results ) );
		return this;
	}

	public Filters graph( String ... expressions ) {
		this.filters.add( Graph.append( expressions ) );
		return this;
	}

	public Filters graph( Class<? extends AbstractResult<?>> ... simples ) {
		this.filters.add( Graph.append( simples ) );
		return this;
	}

	public String getFilter() {
		return this.filter;
	}

	@Override
	public String toString() {
		if ( filters.isEmpty() ) {
			return StringUtils.EMPTY;
		}
		StringJoiner joiner = new StringJoiner( Const.GROUP_SEPARATOR );
		if ( this.spliter != null ) {
			joiner.add( "split" + this.spliter ); // split [a][b]...
		}
		for ( int i = 0, s = filters.size(); i < s; i ++ ) {
			Graph graph = filters.get( i );
			String streamAlias = graph.getAlias();
			joiner.add( graph.get() + StringUtils.defaultString( streamAlias ) );
		}
		return joiner.toString();
	}

}
