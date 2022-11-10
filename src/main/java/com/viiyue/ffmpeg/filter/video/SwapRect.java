package com.viiyue.ffmpeg.filter.video;

import com.viiyue.ffmpeg.annotation.Function;
import com.viiyue.ffmpeg.filter.AbstractFunction;

/**
 * Swap two rectangular objects in video
 * 
 * @author tangxbai
 * @since 2022/08/05
 * @see <a href="https://ffmpeg.org/ffmpeg-filters.html#swaprect">ffmpeg-filters#swaprect</a>
 */
@Function( "swaprect" )
public class SwapRect extends AbstractFunction<SwapRect> {

	// Don't let anyone instantiate this class
	private SwapRect() {}

	/**
	 * Quickly create an instances of {@link SwapRect}
	 * 
	 * @return the {@link SwapRect} instance
	 */
	public static final SwapRect of() {
		return new SwapRect();
	}

	/**
	 * Set object width
	 * 
	 * @apiNote (int) w
	 * @param width the object width
	 * @return the {@link SwapRect} instance
	 */
	public SwapRect width( int width ) {
		return super.addArg( "w", width );
	}

	/**
	 * <p>
	 * Set object width
	 * 
	 * <p>
	 * The expression can contain the following constants:
	 * 
	 * <ul>
	 * <li><b>w, h</b> - the input width and height.
	 * <li><b>a</b> - same as w / h
	 * <li><b>sar</b> - input sample aspect ratio
	 * <li><b>dar</b> - input display aspect ratio, it is the same as (w / h) * sar
	 * <li><b>n</b> - the number of the input frame, starting from 0.
	 * <li><b>t</b> - the timestamp expressed in seconds. It’s NAN if the input timestamp is unknown.
	 * <li><b>pos</b> - the position in the file of the input frame, NAN if unknown
	 * </ul>
	 * 
	 * @apiNote (int) w
	 * @param width the width expression
	 * @return the {@link SwapRect} instance
	 */
	public SwapRect width( String width ) {
		return super.addArg( "w", width );
	}

	/**
	 * Set object height
	 * 
	 * @apiNote (int) h
	 * @param height the object height
	 * @return the {@link SwapRect} instance
	 */
	public SwapRect height( int height ) {
		return super.addArg( "h", height );
	}

	/**
	 * Set object height
	 * 
	 * @apiNote (int) height
	 * @param height the height expression
	 * @return the {@link SwapRect} instance
	 */
	public SwapRect height( String height ) {
		return super.addArg( "h", height );
	}

	/**
	 * Set 1st rectangular coordinates
	 * 
	 * @apiNote (int) x1
	 * @apiNote (int) y1
	 * @param x1 the rect x coordinate
	 * @param y1 the rect y coordinate
	 * @return the {@link SwapRect} instance
	 */
	public SwapRect pos1( int x1, int y1 ) {
		return super.addArg( "x1", x1 ).addArg( "y1", y1 );
	}

	/**
	 * <p>
	 * Set 1st rectangular coordinates
	 * 
	 * <p>
	 * The expression can contain the following constants:
	 * 
	 * <ul>
	 * <li><b>w, h</b> - the input width and height.
	 * <li><b>a</b> - same as w / h
	 * <li><b>sar</b> - input sample aspect ratio
	 * <li><b>dar</b> - input display aspect ratio, it is the same as (w / h) * sar
	 * <li><b>n</b> - the number of the input frame, starting from 0.
	 * <li><b>t</b> - the timestamp expressed in seconds. It’s NAN if the input timestamp is unknown.
	 * <li><b>pos</b> - the position in the file of the input frame, NAN if unknown
	 * </ul>
	 * 
	 * @apiNote (int) x1
	 * @apiNote (int) y1
	 * @param x1 the rect x coordinate expression
	 * @param y1 the rect y coordinate expression
	 * @return the {@link SwapRect} instance
	 */
	public SwapRect pos1( String x1, String y1 ) {
		return super.addArg( "x1", x1 ).addArg( "y1", y1 );
	}

	/**
	 * Set 2nd rectangular coordinates
	 * 
	 * @apiNote (int) x2
	 * @apiNote (int) y2
	 * @param x2 the rect x coordinate
	 * @param y2 the rect y coordinate
	 * @return the {@link SwapRect} instance
	 */
	public SwapRect pos2( int x2, int y2 ) {
		return super.addArg( "x2", x2 ).addArg( "y2", y2 );
	}

	/**
	 * <p>
	 * Set 2nd rectangular coordinates
	 * 
	 * <p>
	 * The expression can contain the following constants:
	 * 
	 * <ul>
	 * <li><b>w, h</b> - the input width and height.
	 * <li><b>a</b> - same as w / h
	 * <li><b>sar</b> - input sample aspect ratio
	 * <li><b>dar</b> - input display aspect ratio, it is the same as (w / h) * sar
	 * <li><b>n</b> - the number of the input frame, starting from 0.
	 * <li><b>t</b> - the timestamp expressed in seconds. It’s NAN if the input timestamp is unknown.
	 * <li><b>pos</b> - the position in the file of the input frame, NAN if unknown
	 * </ul>
	 * 
	 * @apiNote (int) x2
	 * @apiNote (int) y2
	 * @param x2 the rect x coordinate expression
	 * @param y2 the rect y coordinate expression
	 * @return the {@link SwapRect} instance
	 */
	public SwapRect pos2( String x2, String y2 ) {
		return super.addArg( "x2", x2 ).addArg( "y2", y2 );
	}

}
