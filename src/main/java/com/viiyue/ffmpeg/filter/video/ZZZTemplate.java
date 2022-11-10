package com.viiyue.ffmpeg.filter.video;

import com.viiyue.ffmpeg.annotation.Function;
import com.viiyue.ffmpeg.common.AbstractEnum;
import com.viiyue.ffmpeg.filter.AbstractFunction;
import com.viiyue.ffmpeg.util.Assert;

/**
 * 
 * 
 * @author tangxbai
 * @since 2022/08/
 * @see <a href="https://ffmpeg.org/ffmpeg-filters.html#template">ffmpeg-filters#template</a>
 */
@Function( "template" )
public class ZZZTemplate extends AbstractFunction<ZZZTemplate> {

	// Don't let anyone instantiate this class
	private ZZZTemplate() {}

	/**
	 * Quickly create an instances of {@link ZZZTemplate}
	 * 
	 * @return the {@link ZZZTemplate} instance
	 */
	public static final ZZZTemplate of() {
		return new ZZZTemplate();
	}

	/**
	 * 
	 * 
	 * @apiNote ()
	 * @return the {@link ZZZTemplate} instance
	 */
	public ZZZTemplate demo() {
		return super.addArg( "demo", null );
	}

	/**
	 * 
	 * 
	 * @apiNote () demo
	 * @param value the
	 * @return the {@link ZZZTemplate} instance
	 */
	public ZZZTemplate demo( double value ) {
		Assert.rangeCheck( value, 0.1, 1.0 );
		return super.addArg( "demo", value );
	}

	/**
	 * 
	 * 
	 * @author tangxbai
	 * @since 2022/06/16
	 */
	public enum AA implements AbstractEnum {
		AAA,
	}

}
