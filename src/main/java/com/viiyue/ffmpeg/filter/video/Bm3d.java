package com.viiyue.ffmpeg.filter.video;

import com.viiyue.ffmpeg.annotation.Function;
import com.viiyue.ffmpeg.common.AbstractEnum;
import com.viiyue.ffmpeg.filter.AbstractFunction;
import com.viiyue.ffmpeg.util.Assert;

/**
 * Denoise frames using Block-Matching 3D algorithm.
 *
 * @author tangxbai
 * @since 2022/06/02
 * @see <a href="https://ffmpeg.org/ffmpeg-filters.html#bm3d">ffmpeg-filters#bm3d</a>
 */
@Function( "bm3d" )
public class Bm3d extends AbstractFunction<Bm3d> {

	// Don't let anyone instantiate this class
	private Bm3d() {}

	/**
	 * Quickly create an instances of {@link Bm3d}
	 * 
	 * @return the {@link Bm3d} instance
	 */
	public static final Bm3d the() {
		return new Bm3d();
	}

	/**
	 * Set denoising strength, default value is <b>1</b>. Allowed range is from 0 to 999.9. The denoising
	 * algorithm is very sensitive to sigma, so adjust it according to the source. is 0 to 512. Default is
	 * 0.1.
	 * 
	 * @apiNote (double) sigma
	 * @param value the sigma value, range is 0 to 999.9.
	 * @return the {@link Bm3d} instance
	 */
	public Bm3d sigma( double value ) {
		Assert.rangeCheck( value, 0, 999.9 );
		return super.addArg( "sigma", value );
	}

	/**
	 * Set local patch size. This sets dimensions in 2D.
	 * 
	 * @apiNote (int) block
	 * @param value the local patch size, range is from 4 to 6.
	 * @return the {@link Bm3d} instance
	 */
	public Bm3d block( int value ) {
		Assert.rangeCheck( value, 4, 6 );
		return super.addArg( "block", value );
	}

	/**
	 * <p>
	 * Set sliding step for processing blocks, default value is <b>4</b>.
	 * 
	 * <p>
	 * Allowed range is from 1 to 64. Smaller values allows processing more reference blocks and is slower.
	 * 
	 * @apiNote (int) bstep
	 * @param value the step value from 1 to 64
	 * @return the {@link Bm3d} instance
	 */
	public Bm3d bstep( int value ) {
		Assert.rangeCheck( value, 1, 64 );
		return super.addArg( "bstep", value );
	}

	/**
	 * <p>
	 * Set step between two search locations for block matching, default is <b>1</b>, allowed range is from 1
	 * to 64. Smaller is slower.
	 * 
	 * @apiNote (int) mstep
	 * @param value the mstep value, range is from 1 to 64.
	 * @return the {@link Bm3d} instance
	 */
	public Bm3d mstep( int value ) {
		Assert.rangeCheck( value, 1, 64 );
		return super.addArg( "mstep", value );
	}

	/**
	 * Set maximal number of similar blocks for 3rd dimension, default value is <b>1</b>. When set to 1, no
	 * block matching is done. Larger values allows more blocks in single group. Allowed range is from 1 to
	 * 256.
	 * 
	 * @apiNote (int) group
	 * @param value the group value is from 1 to 256
	 * @return the {@link Bm3d} instance
	 */
	public Bm3d group( int value ) {
		Assert.rangeCheck( value, 1, 256 );
		return super.addArg( "group", value );
	}

	/**
	 * Set radius for search block matching. Default is 9. Allowed range is from 1 to INT32_MAX.
	 * 
	 * @apiNote (int) range
	 * @param value the range value is from 1 to {@linkplain Integer#MAX_VALUE})
	 * @return the {@link Bm3d} instance
	 */
	public Bm3d range( int range ) {
		Assert.isTrue( range > 1, "Range value must greater than 1" );
		return super.addArg( "range", range );
	}

	/**
	 * Set threshold of mean square error for block matching. Valid range is 0 to INT32_MAX.
	 * 
	 * @apiNote (double) thmse
	 * @param value the threshold value is from 1 to {@linkplain Integer#MAX_VALUE})
	 * @return the {@link Bm3d} instance
	 */
	public Bm3d thmse( double threshold ) {
		Assert.isTrue( threshold > 0.0, "Range value must greater than 0" );
		return super.addArg( "thmse", threshold );
	}

	/**
	 * Set filtering estimation mode, default is {@link Estimation#BASIC BASIC}.
	 * 
	 * @apiNote (flags) estim
	 * @param value the estim value
	 * @return the {@link Bm3d} instance
	 * @see Estimation
	 */
	public Bm3d estim( Estimation estimation ) {
		return super.addArg( "estim", estimation );
	}

	/**
	 * If enabled, filter will use 2nd stream for block matching. Default is disabled for basic value of estim
	 * option, and always enabled if value of estim is final.
	 * 
	 * @apiNote (boolean) ref
	 * @return the {@link Bm3d} instance
	 */
	public Bm3d ref() {
		return super.enable( "ref" );
	}

	/**
	 * Set planes to filter, default is <b>7</b>.
	 * 
	 * @apiNote (int) planes
	 * @param value the planes index, range is from 0 to 15.
	 * @return the {@link Bm3d} instance
	 */
	public Bm3d planes( int planes ) {
		Assert.rangeCheck( planes, 0, 15 );
		return super.addArg( "planes", planes );
	}

	/**
	 * Filtering estimation mode
	 * 
	 * @author tangxbai
	 * @since 2022/06/27
	 */
	public enum Estimation implements AbstractEnum {
		/** Basic estimate */
		BASIC,
		/** Final estimate */
		FINAL
	}

}
