package com.viiyue.ffmpeg.filter.video;

import com.viiyue.ffmpeg.annotation.Function;
import com.viiyue.ffmpeg.common.AbstractEnum;
import com.viiyue.ffmpeg.filter.AbstractFunction;
import com.viiyue.ffmpeg.util.Assert;
import com.viiyue.ffmpeg.util.Helper;

/**
 * Cover a rectangular object
 * 
 * @author tangxbai
 * @since 2022/06/17
 * @see <a href="https://ffmpeg.org/ffmpeg-filters.html#cover_rect">ffmpeg-filters#cover_rect</a>
 */
@Function( "cover_rect" )
public class CoverRectangle extends AbstractFunction<CoverRectangle> {

	// Don't let anyone instantiate this class
	private CoverRectangle() {}

	/**
	 * Quickly create an instances of {@link CoverRectangle}
	 * 
	 * @apiNote (string) cover
	 * @param filePath the cover image path
	 * @return the {@link CoverRectangle} instance
	 */
	public static final CoverRectangle cover( String filePath ) {
		return new CoverRectangle().init( filePath );
	}

	/**
	 * File path of the optional cover image, needs to be in yuv420.
	 * 
	 * @apiNote (string) cover
	 * @param filePath the cover image path
	 * @return the {@link CoverRectangle} instance
	 */
	private CoverRectangle init( String filePath ) {
		Assert.checkFile( filePath, false );
		return super.addArg( "cover", Helper.escape( filePath, true ) );
	}

	/**
	 * Set the rectangular object covering mode
	 * 
	 * @apiNote (flags) mode
	 * @param mode the covering mode
	 * @return the {@link CoverRectangle} instance
	 * @see CoverMode
	 */
	public CoverRectangle mode( CoverMode mode ) {
		return super.addArg( "mode", mode );
	}

	/**
	 * Rectangular object covering mode
	 * 
	 * @author tangxbai
	 * @since 2022/06/17
	 */
	public enum CoverMode implements AbstractEnum {
		COVER, BLUR
	}

}
