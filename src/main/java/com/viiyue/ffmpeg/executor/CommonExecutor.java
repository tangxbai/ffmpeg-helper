package com.viiyue.ffmpeg.executor;

import java.io.File;
import java.util.List;

import com.viiyue.ffmpeg.enums.Library;

public abstract class CommonExecutor<T extends GlobalExecutor<?>> extends GlobalExecutor<T> {

	protected int inputs;

	public CommonExecutor( Library library ) {
		super( library );
	}

	public T format( String format ) {
		return super.cmd( "f", format );
	}

	public T codec( String codec ) {
		return super.cmd( "codec", codec );
	}

	public T limitSize( int bytes ) {
		return super.cmd( "fs", bytes );
	}

	public T timeOff( String offset ) {
		return super.cmd( "sseof", offset );
	}

	public T preset( String presetName ) {
		return super.cmd( "pre", presetName );
	}

	public T target( String type ) {
		return super.cmd( "target", type );
	}

	public T frames( int number ) {
		return super.cmd( "frames", number );
	}

	public T timestamp( Long timestamp ) {
		return super.cmd( "timestamp", timestamp );
	}

	public T metadata( String key, Object value ) {
		return super.cmd( "metadata", key + "=" + value, false );
	}

	public T search( String start, String end ) {
		super.cmd( "ss", start );
		super.cmd( "to", end );
		return ( T ) this;
	}

	public T search( double start, double end ) {
		super.cmd( "ss", start );
		super.cmd( "to", end );
		return ( T ) this;
	}

	public T searchAt( String start, double how ) {
		super.cmd( "ss", start );
		super.cmd( "t", how );
		return ( T ) this;
	}

	public T searchAt( double start, double how ) {
		super.cmd( "ss", start );
		super.cmd( "t", how );
		return ( T ) this;
	}

	public T map( String who ) {
		super.cmd( "map", who );
		return ( T ) this;
	}

	public T filter( int filterGraph ) {
		super.cmd( "filter", filterGraph );
		return ( T ) this;
	}

	public T input( String ... files ) {
		this.inputs = files.length;
		for ( String f : files ) {
			super.cmd( "i", fileCheck( f ), false );
		}
		return ( T ) this;
	}

	public T input( List<String> files ) {
		this.inputs = files.size();
		for ( String f : files ) {
			super.cmd( "i", fileCheck( f ), false );
		}
		return ( T ) this;
	}

	public T input( File ... files ) {
		this.inputs = files.length;
		for ( File f : files ) {
			super.cmd( "i", fileCheck( f.getAbsolutePath() ), false );
		}
		return ( T ) this;
	}

	private <E> E fileCheck( E input ) {
		if ( input == null ) {
			throw new NullPointerException( "Input file cannot be null" );
		}
		File inputFile = null;
		if ( input instanceof String ) {
			inputFile = new File( input.toString() );
		} else if ( input instanceof File ) {
			inputFile = ( File ) input;
		}
		if ( inputFile == null ) {
			throw new IllegalArgumentException( "Incorrect input argument type" );
		}
		if ( !inputFile.exists() ) {
			throw new RuntimeException( "Input file dose not exist: " + inputFile.getAbsolutePath() );
		}
		return input;
	}

}
