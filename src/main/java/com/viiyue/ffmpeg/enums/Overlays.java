package com.viiyue.ffmpeg.enums;

import com.viiyue.ffmpeg.util.Helper;

/**
 * Mask orientation constant
 *
 * @author tangxbai
 * @since 2022/06/05
 */
public enum Overlays {

	/**
	 * <pre>
	 * --------------
	 * --------------
	 * -----HERE-----
	 * --------------
	 * --------------
	 * </pre>
	 */
	CENTER( "(main_w-overlay_w)/2", "(main_h-overlay_h)/2" ),

	/**
	 * <pre>
	 * HERE----------
	 * --------------
	 * --------------
	 * --------------
	 * --------------
	 * </pre>
	 */
	LEFT_TOP( "%s", "%s" ),

	/**
	 * <pre>
	 * --------------
	 * --------------
	 * Here----------
	 * --------------
	 * --------------
	 * </pre>
	 */
	LEFT_CENTER( "%s", "(main_h-overlay_h)/2" ),

	/**
	 * <pre>
	 * ----------HERE
	 * --------------
	 * --------------
	 * --------------
	 * --------------
	 * </pre>
	 */
	RIGHT_TOP( "main_w-overlay_w-%s", "%s" ),

	/**
	 * <pre>
	 * --------------
	 * --------------
	 * ----------HERE
	 * --------------
	 * --------------
	 * </pre>
	 */
	RIGHT_CENTER( "main_w-overlay_w-%s", "(main_h-overlay_h)/2" ),

	/**
	 * <pre>
	 * --------------
	 * --------------
	 * --------------
	 * --------------
	 * ----------HERE
	 * </pre>
	 */
	RIGHT_BOTTOM( "main_w-overlay_w-%s", "main_h-overlay_h-%s" ),

	/**
	 * <pre>
	 * --------------
	 * --------------
	 * --------------
	 * --------------
	 * HERE----------
	 * </pre>
	 */
	LEFT_BOTTOM( "%s", "main_h-overlay_h-%s" );

	private String x, y;

	private Overlays( String x, String y ) {
		this.x = x;
		this.y = y;
	}

	public String getX( Object x ) {
		return format( this.x, x );
	}

	public String getY( Object y ) {
		return format( this.y, y );
	}

	public String expression( Object x, Object y ) {
		return getX( x ) + ":" + getY( y );
	}

	private String format( String expression, Object value ) {
		return expression.contains( "%" ) ? String.format( expression, Helper.toValue( value ) ) : expression;
	}

}
