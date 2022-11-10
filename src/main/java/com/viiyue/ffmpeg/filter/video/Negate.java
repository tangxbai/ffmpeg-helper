package com.viiyue.ffmpeg.filter.video;

import com.viiyue.ffmpeg.annotation.Function;
import com.viiyue.ffmpeg.common.Const;
import com.viiyue.ffmpeg.enums.PlaneComponent;
import com.viiyue.ffmpeg.filter.AbstractFunction;

/**
 * Negate (invert) the input video
 * 
 * @author tangxbai
 * @since 2022/07/19
 * @see <a href="https://ffmpeg.org/ffmpeg-filters.html#negate">ffmpeg-filters#negate</a>
 */
@Function( "negate" )
public class Negate extends AbstractFunction<Negate> {

	// Don't let anyone instantiate this class
	private Negate() {}

	/**
	 * Quickly create an instances of {@link Negate}
	 * 
	 * @return the {@link Negate} instance
	 */
	public static final Negate of() {
		return new Negate();
	}

	/**
	 * Set the scale applied to second video stream. Allowed range is from 0 to 9, default is <b>1</b>.
	 * 
	 * @apiNote (int) components
	 * @param components the single target component
	 * @return the {@link Negate} instance
	 * @see PlaneComponent
	 */
	public Negate components( PlaneComponent ... components ) {
		return super.addArg2( "components", Const.APPEND_SEPARATOR, components );
	}

	/**
	 * With value {@code true}, it negates the alpha component, if present. Default value is {@code false}.
	 * 
	 * @apiNote (boolean) negate_alpha
	 * @return the {@link Negate} instance
	 */
	public Negate negateAlpha() {
		return super.enable( "negate_alpha" );
	}

}
