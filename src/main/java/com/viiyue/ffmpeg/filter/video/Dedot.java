package com.viiyue.ffmpeg.filter.video;

import com.viiyue.ffmpeg.annotation.Function;
import com.viiyue.ffmpeg.common.AbstractEnum;
import com.viiyue.ffmpeg.common.Const;
import com.viiyue.ffmpeg.filter.AbstractFunction;
import com.viiyue.ffmpeg.util.Assert;

/**
 * Reduce cross-luminance (dot-crawl) and cross-color (rainbows) from video.
 * 
 * @author tangxbai
 * @since 2022/06/27
 * @see <a href="https://ffmpeg.org/ffmpeg-filters.html#dedot">ffmpeg-filters#dedot</a>
 */
@Function( "dedot" )
public class Dedot extends AbstractFunction<Dedot> {

	// Don't let anyone instantiate this class
	private Dedot() {}

	/**
	 * Quickly create an instances of {@link Dedot}
	 * 
	 * @return the {@link Dedot} instance
	 */
	public static final Dedot of() {
		return new Dedot();
	}

	/**
	 * Set mode of operation. Can be combination of dotcrawl for cross-luminance reduction and/or rainbows for
	 * cross-color reduction.
	 * 
	 * @apiNote (flags) m
	 * @return the {@link Dedot} instance
	 * @see DedotMode
	 */
	public Dedot mode( DedotMode ... modes ) {
		return super.addArg2( "m", Const.APPEND_SEPARATOR, modes );
	}

	/**
	 * Set spatial luma threshold. Lower values increases reduction of cross-luminance, value range is from 0
	 * to 1, default values is <b>0.079</b>.
	 * 
	 * @apiNote (double) lt
	 * @param threshold the spatial luma threshold
	 * @return the {@link Dedot} instance
	 */
	public Dedot lumaThreshold( double threshold ) {
		Assert.rangeCheck( threshold, 0D, 1D );
		return super.addArg( "lt", threshold );
	}

	/**
	 * Set tolerance for temporal luma. Higher values increases reduction of cross-luminance, value range is
	 * from 0 to 1, default values is <b>0.079</b>.
	 * 
	 * @apiNote (double) tl
	 * @param tolerance the temporal luma tolerance
	 * @return the {@link Dedot} instance
	 */
	public Dedot temporalLuma( double tolerance ) {
		Assert.rangeCheck( tolerance, 0D, 1D );
		return super.addArg( "tl", tolerance );
	}

	/**
	 * Set tolerance for chroma temporal variation. Higher values increases reduction of cross-color, value
	 * range is from 0 to 1, default values is <b>0.058</b>.
	 * 
	 * @apiNote (double) tc
	 * @param tolerance the tolerance for chroma temporal variation
	 * @return the {@link Dedot} instance
	 */
	public Dedot toleranceChroma( double tolerance ) {
		Assert.rangeCheck( tolerance, 0D, 1D );
		return super.addArg( "tc", tolerance );
	}

	/**
	 * Set temporal chroma threshold. Lower values increases reduction of cross-color, value range is from 0
	 * to 1, default values is <b>0.019</b>.
	 * 
	 * @apiNote (double) tc
	 * @param tolerance the temporal chroma threshold
	 * @return the {@link Dedot} instance
	 */
	public Dedot chromaThreshold( double tolerance ) {
		Assert.rangeCheck( tolerance, 0, 1 );
		return super.addArg( "ct", tolerance );
	}

	/**
	 * Dedot filtering mode
	 * 
	 * @author tangxbai
	 * @since 2022/06/27
	 */
	public enum DedotMode implements AbstractEnum {
		DOTCRAWL, RAINBOWS
	}

}
