package com.viiyue.ffmpeg.filter.video;

import com.viiyue.ffmpeg.annotation.Function;
import com.viiyue.ffmpeg.filter.AbstractFunction;
import com.viiyue.ffmpeg.util.Assert;

/**
 * 2D Video Oscilloscope. Useful to measure spatial impulse, step responses, chroma delays, etc.
 * 
 * @author tangxbai
 * @since 2022/07/19
 * @see <a href="https://ffmpeg.org/ffmpeg-filters.html#oscilloscope">ffmpeg-filters#oscilloscope</a>
 */
@Function( "oscilloscope" )
public class Oscilloscope extends AbstractFunction<Oscilloscope> {

	// Don't let anyone instantiate this class
	private Oscilloscope() {}

	/**
	 * Quickly create an instances of {@link Oscilloscope}
	 * 
	 * @return the {@link Oscilloscope} instance
	 */
	public static final Oscilloscope of() {
		return new Oscilloscope();
	}

	/**
	 * Set scope center x position, value range is from 0 to 1, default is <b>0.5</b>.
	 * 
	 * @apiNote (double) x
	 * @param value the scope x position
	 * @return the {@link Oscilloscope} instance
	 */
	public Oscilloscope x( double value ) {
		Assert.rangeCheck( value, 0.0, 1.0 );
		return super.addArg( "x", value );
	}

	/**
	 * Set scope center y position, value range is from 0 to 1, default is <b>0.5</b>.
	 * 
	 * @apiNote (double) y
	 * @param value the scope y position
	 * @return the {@link Oscilloscope} instance
	 */
	public Oscilloscope y( double value ) {
		Assert.rangeCheck( value, 0.0, 1.0 );
		return super.addArg( "y", value );
	}

	/**
	 * Set scope size, relative to frame diagonal, value range is from 0 to 1, default is <b>0.8</b>.
	 * 
	 * @apiNote (double) s
	 * @param value the scope size
	 * @return the {@link Oscilloscope} instance
	 */
	public Oscilloscope size( double value ) {
		Assert.rangeCheck( value, 0.0, 1.0 );
		return super.addArg( "s", value );
	}

	/**
	 * Set scope tilt/rotation, value range is from 0 to 1, default is <b>0.5</b>.
	 * 
	 * @apiNote (double) t
	 * @param value the scope tilt
	 * @return the {@link Oscilloscope} instance
	 */
	public Oscilloscope tilt( double value ) {
		Assert.rangeCheck( value, 0.0, 1.0 );
		return super.addArg( "t", value );
	}

	/**
	 * Set trace opacity, value range is from 0 to 1, default is <b>0.8</b>.
	 * 
	 * @apiNote (double) o
	 * @param value the trace opacity
	 * @return the {@link Oscilloscope} instance
	 */
	public Oscilloscope opacity( double value ) {
		Assert.rangeCheck( value, 0.0, 1.0 );
		return super.addArg( "o", value );
	}

	/**
	 * Set trace center x position, value range is from 0 to 1, default is <b>0.5</b>.
	 * 
	 * @apiNote (double) tx
	 * @param value the trace x position
	 * @return the {@link Oscilloscope} instance
	 */
	public Oscilloscope traceX( double value ) {
		Assert.rangeCheck( value, 0.0, 1.0 );
		return super.addArg( "tx", value );
	}

	/**
	 * Set trace center y position, value range is from 0 to 1, default is <b>0.5</b>.
	 * 
	 * @apiNote (double) ty
	 * @param value the trace y position
	 * @return the {@link Oscilloscope} instance
	 */
	public Oscilloscope traceY( double value ) {
		Assert.rangeCheck( value, 0.0, 1.0 );
		return super.addArg( "ty", value );
	}

	/**
	 * Set trace width, relative to width of frame, value range is from 0.1 to 1.0, default is <b>0.8</b>.
	 * 
	 * @apiNote (double) tw
	 * @param value the trace width
	 * @return the {@link Oscilloscope} instance
	 */
	public Oscilloscope traceWidth( double value ) {
		Assert.rangeCheck( value, 0.1, 1.0 );
		return super.addArg( "tw", value );
	}

	/**
	 * Set trace height, relative to height of frame, value range is from 0.1 to 1.0, default is <b>0.8</b>.
	 * 
	 * @apiNote (double) th
	 * @param value the trace height
	 * @return the {@link Oscilloscope} instance
	 */
	public Oscilloscope traceHeight( double value ) {
		Assert.rangeCheck( value, 0.1, 1.0 );
		return super.addArg( "th", value );
	}

	/**
	 * Set which components to trace. By default it traces first three components. Value range is from 0 to
	 * 15, default is <b>7</b>.
	 * 
	 * @apiNote (double) c
	 * @param value the component to trace
	 * @return the {@link Oscilloscope} instance
	 */
	public Oscilloscope trace( int value ) {
		Assert.rangeCheck( value, 0, 15 );
		return super.addArg( "c", value );
	}

	/**
	 * Draw trace grid. By default is enabled.
	 * 
	 * @apiNote (boolean) g
	 * @return the {@link Oscilloscope} instance
	 */
	public Oscilloscope grid( boolean show ) {
		return super.status( "g", show );
	}

	/**
	 * Draw some statistics. By default is enabled.
	 * 
	 * @apiNote (boolean) st
	 * @return the {@link Oscilloscope} instance
	 */
	public Oscilloscope statistics( boolean show ) {
		return super.status( "st", show );
	}

	/**
	 * Draw scope. By default is enabled.
	 * 
	 * @apiNote (boolean) sc
	 * @return the {@link Oscilloscope} instance
	 */
	public Oscilloscope scope( boolean show ) {
		return super.status( "sc", show );
	}

}
