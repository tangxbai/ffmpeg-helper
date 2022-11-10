package com.viiyue.ffmpeg.filter.video;

import com.viiyue.ffmpeg.annotation.Function;
import com.viiyue.ffmpeg.enums.FirstField;
import com.viiyue.ffmpeg.filter.AbstractFunction;

/**
 * Apply telecine process to the video
 * 
 * @author tangxbai
 * @since 2022/08/05
 * @see <a href="https://ffmpeg.org/ffmpeg-filters.html#telecine">ffmpeg-filters#telecine</a>
 */
@Function( "telecine" )
public class Telecine extends AbstractFunction<Telecine> {

	// Don't let anyone instantiate this class
	private Telecine() {}

	/**
	 * Quickly create an instances of {@link Telecine}
	 * 
	 * @return the {@link Telecine} instance
	 */
	public static final Telecine of() {
		return new Telecine();
	}

	/**
	 * To select first field
	 * 
	 * @apiNote (flags) first_field
	 * @param field the first field type
	 * @return the {@link Telecine} instance
	 * @see FirstField
	 */
	public Telecine firstField( FirstField field ) {
		return super.addArg( "first_field", field );
	}

	/**
	 * <p>
	 * A string of numbers representing the pulldown pattern you wish to apply. The default value is 23.
	 * 
	 * <pre>
	 * Some typical patterns:
	 * 
	 * NTSC output (30i): 
	 * 27.5p: 32222 
	 * 24p: 23 (classic) 
	 * 24p: 2332 (preferred) 
	 * 20p: 33 
	 * 18p: 334 
	 * 16p: 3444
	 * 
	 * PAL output (25i): 
	 * 27.5p: 12222 
	 * 24p: 222222222223 ("Euro pulldown") 
	 * 16.67p: 33 
	 * 16p: 33333334
	 * </pre>
	 * 
	 * @apiNote () demo
	 * @param value the
	 * @return the {@link Telecine} instance
	 */
	public Telecine pattern( String pattern ) {
		return super.addArg( "pattern", pattern );
	}

}
