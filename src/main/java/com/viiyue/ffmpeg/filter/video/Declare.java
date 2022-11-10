package com.viiyue.ffmpeg.filter.video;

import com.viiyue.ffmpeg.common.Const;
import com.viiyue.ffmpeg.filter.AbstractFunction;
import com.viiyue.ffmpeg.util.Helper;

/**
 * Declare move namespace
 *
 * @author tangxbai
 * @since 2022/06/02
 */
public class Declare extends AbstractFunction<Declare> {

	// Don't let anyone instantiate this class
	private Declare() {
		super( Const.PART_SEPARATOR );
	}

	public static final Declare the() {
		return new Declare();
	}

	public Declare movie( String path ) {
		return super.addArg( "movie", Helper.escape( path, true ) );
	}

	public Declare size( int width, int height ) {
		return super.addArg( "scale", width, height );
	}

	public Declare size( String width, String height ) {
		return super.addArg( "scale", width, height );
	}

}
