package com.viiyue.ffmpeg.filter.video;

import com.viiyue.ffmpeg.annotation.Function;
import com.viiyue.ffmpeg.filter.AbstractFunction;
import com.viiyue.ffmpeg.util.Assert;

/**
 * This is a high precision/quality 3d denoise filter. It aims to reduce image noise, producing smooth images
 * and making still images really still. It should enhance compressibility.
 *
 * @author tangxbai
 * @since 2022/07/11
 * @see <a href="https://ffmpeg.org/ffmpeg-filters.html#hqdn3d-1">ffmpeg-filters#hqdn3d</a>
 */
@Function( "hqdn3d" )
public class Hqdn3d extends AbstractFunction<Hqdn3d> {

	// Don't let anyone instantiate this class
	private Hqdn3d() {}

	/**
	 * Quickly create an instances of {@link Hqdn3d}
	 * 
	 * @return the {@link Hqdn3d} instance
	 */
	public static final Hqdn3d of() {
		return new Hqdn3d();
	}

	/**
	 * A non-negative floating point number which specifies spatial luma strength. It defaults to <b>0</b>.
	 * 
	 * @apiNote (double) luma_spatial
	 * @param value the luma strength
	 * @return the {@link Hqdn3d} instance
	 */
	public Hqdn3d lumaSpatial( double value ) {
		Assert.isTrue( value >= 0D, "Value must be greater than or euqal to 0" );
		return super.addArg( "luma_spatial", value );
	}

	/**
	 * A floating point number which specifies luma temporal strength. It defaults to
	 * <b>6.0*luma_spatial/4.0</b>.
	 * 
	 * @apiNote (double) luma_tmp
	 * @param value the luma temporal strength
	 * @return the {@link Hqdn3d} instance
	 */
	public Hqdn3d lumaTmp( double value ) {
		Assert.isTrue( value >= 0D, "Value must be greater than or euqal to 0" );
		return super.addArg( "luma_tmp", value );
	}

	/**
	 * A non-negative floating point number which specifies spatial chroma strength. It defaults to
	 * <b>3.0*luma_spatial/4.0</b>.
	 * 
	 * @apiNote (double) chroma_spatial
	 * @param value the specifies spatial chroma strength
	 * @return the {@link Hqdn3d} instance
	 */
	public Hqdn3d chromaSpatial( double value ) {
		Assert.isTrue( value >= 0D, "Value must be greater than or euqal to 0" );
		return super.addArg( "chroma_spatial", value );
	}

	/**
	 * A floating point number which specifies chroma temporal strength. It defaults to
	 * <b>luma_tmp*chroma_spatial/luma_spatial</b>.
	 * 
	 * @apiNote (double) chroma_tmp
	 * @param value the chroma temporal strength
	 * @return the {@link Hqdn3d} instance
	 */
	public Hqdn3d chromaTmp( double value ) {
		Assert.isTrue( value >= 0D, "Value must be greater than or euqal to 0" );
		return super.addArg( "chroma_tmp", value );
	}

}
