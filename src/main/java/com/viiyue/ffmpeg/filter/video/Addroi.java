package com.viiyue.ffmpeg.filter.video;

import com.viiyue.ffmpeg.annotation.Function;
import com.viiyue.ffmpeg.filter.AbstractFunction;
import com.viiyue.ffmpeg.util.Assert;

/**
 * <p>
 * Mark a region of interest in a video frame.
 *
 * <p>
 * The frame data is passed through unchanged, but metadata is attached to the frame indicating regions of
 * interest which can affect the behaviour of later encoding. Multiple regions can be marked by applying the
 * filter multiple times.
 *
 * @author tangxbai
 * @since 2022/06/02
 * @see <a href="https://ffmpeg.org/ffmpeg-filters.html#addroi">ffmpeg-filters#addroi</a>
 */
@Function( "addroi" )
public class Addroi extends AbstractFunction<Addroi> {

	// Don't let anyone instantiate this class
	private Addroi() {}

	/**
	 * Quickly create an instances of {@link Addroi}
	 * 
	 * @apiNote (string) x, (string) y, (string) w, (string) h
	 * @param left   the left distance
	 * @param top    the top distance
	 * @param width  the region width
	 * @param height the region height
	 * @return the {@link Addroi} instance
	 */
	public static final Addroi mark( double left, double top, double width, double height ) {
		return new Addroi().region( left, top, width, height );
	}

	/**
	 * Quickly create an instances of {@link Addroi}
	 * 
	 * @apiNote (string) x, (string) y, (string) w, (string) h
	 * @param left   the left distance expression
	 * @param top    the top distance expression
	 * @param width  the region width expression
	 * @param height the region height expression
	 * @return the {@link Addroi} instance
	 */
	public static final Addroi mark( String left, String top, String width, String height ) {
		return new Addroi().region( left, top, width, height );
	}

	/**
	 * Set mark region parameters
	 * 
	 * @apiNote (string) x, (string) y, (string) w, (string) h
	 * @param left   the left distance object, which can be a double or an expression.
	 * @param top    the top distance object, which can be a double or an expression.
	 * @param width  the region width object, which can be a double or an expression.
	 * @param height the region height object, which can be a double or an expression.
	 * @return the {@link Addroi} instance
	 */
	private Addroi region( Object left, Object top, Object width, Object height ) {
		super.addArg( "x", left );
		super.addArg( "y", top );
		super.addArg( "w", width );
		super.addArg( "h", height );
		return this;
	}

	/**
	 * If set to true, remove any existing regions of interest marked on the frame before adding the new one.
	 * 
	 * @apiNote (boolean) clear
	 * @return the {@link Addroi} instance
	 */
	public Addroi clear() {
		return super.enable( "clear" );
	}

	/**
	 * <p>
	 * Quantisation offset to apply within the region.
	 * 
	 * <p>
	 * This must be a real value in the range -1 to +1. A value of zero indicates no quality change. A
	 * negative value asks for better quality (less quantisation), while a positive value asks for worse
	 * quality (greater quantisation).
	 * 
	 * <p>
	 * The range is calibrated so that the extreme values indicate the largest possible offset - if the rest
	 * of the frame is encoded with the worst possible quality, an offset of -1 indicates that this region
	 * should be encoded with the best possible quality anyway. Intermediate values are then interpolated in
	 * some codec-dependent way.
	 * 
	 * <p>
	 * For example, in 10-bit H.264 the quantisation parameter varies between -12 and 51. A typical qoffset
	 * value of -1/10 therefore indicates that this region should be encoded with a QP around one-tenth of the
	 * full range better than the rest of the frame. So, if most of the frame were to be encoded with a QP of
	 * around 30, this region would get a QP of around 24 (an offset of approximately -1/10 * (51 - -12) =
	 * -6.3). An extreme value of -1 would indicate that this region should be encoded with the best possible
	 * quality regardless of the treatment of the rest of the frame - that is, should be encoded at a QP of
	 * -12.
	 * 
	 * @apiNote (int) qoffset
	 * @param offset the offset region
	 * @return the {@link Addroi} instance
	 */
	public Addroi offset( double offset ) {
		Assert.rangeCheck( offset, -1, 1 );
		return super.addArg( "qoffset", offset );
	}

}
