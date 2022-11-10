package com.viiyue.ffmpeg.filter;

import java.util.Arrays;
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

public final class Graph {

	private static final Map<Class<?>, String> caches = new ConcurrentHashMap<>( 128 );
	private static final java.util.function.Function<Class<?>, String> provider = type -> {
		Function fun = type.getAnnotation( Function.class );
		return fun == null ? null : fun.value();
	};

	private String alias;
	private String input;
	private List<String> graphs = new LinkedList<>();

	private Graph() {}

	public static Graph stream( Integer ... streams ) {
		return new Graph().input( streams );
	}

	public static Graph stream( String ... streams ) {
		return new Graph().input( streams );
	}

	public static Graph append( AbstractResult<?> ... funResults ) {
		return new Graph().add( funResults );
	}

	public static Graph append( String ... expressions ) {
		return new Graph().add( expressions );
	}

	public static Graph append( Class<? extends AbstractResult<?>> ... simples ) {
		return new Graph().add( simples );
	}

	private Graph input( Object ... streams ) {
		this.input = Helper.expandAll( "", Helper::wrap, streams ).toString(); // "[a][b]..."
		return this;
	}

	public Graph add( String ... expressions ) {
		this.graphs.addAll( Arrays.asList( expressions ) );
		return this;
	}

	public Graph add( AbstractResult<?> ... funResults ) {
		if ( ArrayUtils.isNotEmpty( funResults ) ) {
			for ( AbstractResult<?> result : funResults ) {
				if ( result != null ) {
					this.graphs.add( result.getResult() );
				}
			}
		}
		return this;
	}

	public Graph add( Class<? extends AbstractResult<?>> ... simples ) {
		if ( ArrayUtils.isNotEmpty( simples ) ) {
			for ( Class<? extends AbstractResult<?>> simple : simples ) {
				if ( simple != null ) {
					String funName = caches.computeIfAbsent( simple, provider );
					if ( funName != null ) {
						this.graphs.add( funName );
					}
				}
			}
		}
		return this;
	}

	public Graph to( String alias ) {
		this.alias = Helper.wrap( alias );
		return this;
	}

	public String getInput() {
		return input;
	}

	public String getAlias() {
		return alias;
	}

	public String get() {
		Object [] allFuntions = graphs.toArray();
		StringJoiner filters = Helper.expandAll( Const.PART_SEPARATOR, allFuntions );
		return StringUtils.isEmpty( input ) ? filters.toString() : input + filters;
	}

}
