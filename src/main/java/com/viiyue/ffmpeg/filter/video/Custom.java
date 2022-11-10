package com.viiyue.ffmpeg.filter.video;

import com.viiyue.ffmpeg.filter.AbstractColorFunction;

/**
 * Custom abstract function
 * 
 * @author tangxbai
 * @since 2022/07/06
 */
public class Custom extends AbstractColorFunction<Custom> {

	private final String funName;

	// Don't let anyone instantiate this class
	private Custom( String funName ) {
		this.funName = funName;
	}

	/**
	 * Quickly create an instances of {@link Custom}
	 * 
	 * @param funName the filter function name
	 * @return the {@link Custom} instance
	 */
	public static final Custom define( String funName ) {
		return new Custom( funName );
	}

	@Override
	protected String getFunName() {
		return this.funName;
	}

	@Override
	public Custom enable( String arg ) {
		return super.enable( arg );
	}

	@Override
	public Custom disable( String arg ) {
		return super.disable( arg );
	}

	@Override
	public Custom status( String arg, boolean state ) {
		return super.status( arg, state );
	}

	@Override
	public Custom addValue( Object value ) {
		return super.addValue( value );
	}

	@Override
	public Custom addValues( Object ... values ) {
		return super.addValues( values );
	}

	@Override
	public Custom addArg( String argName, Object ... values ) {
		return super.addArg( argName, values );
	}

	@Override
	public Custom addArg2( String argName, String separator, Object ... values ) {
		return super.addArg2( argName, separator, values );
	}

}
