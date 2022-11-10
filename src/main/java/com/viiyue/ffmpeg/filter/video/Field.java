package com.viiyue.ffmpeg.filter.video;

import com.viiyue.ffmpeg.annotation.Function;
import com.viiyue.ffmpeg.filter.AbstractColorFunction;

/**
 * Extract a single field from an interlaced image using stride arithmetic to avoid wasting CPU time. The
 * output frames are marked as non-interlaced.
 * 
 * @author tangxbai
 * @since 2022/06/30
 * @see <a href="https://ffmpeg.org/ffmpeg-filters.html#field">ffmpeg-filters#field</a>
 */
@Function( "field" )
public class Field extends AbstractColorFunction<Field> {

	// Don't let anyone instantiate this class
	private Field( String field ) {
		super.addArg( "type", field );
	}

	/**
	 * Quickly create an instances of {@link ExtractPlanes} and specify whether to extract the top field
	 * 
	 * @return the {@link Field} instance
	 */
	public static final Field top() {
		return new Field( "top" );
	}

	/**
	 * Quickly create an instances of {@link ExtractPlanes} and specify whether to extract the bottom field
	 * 
	 * @return the {@link Field} instance
	 */
	public static final Field bottom() {
		return new Field( "bottom" );
	}

}
