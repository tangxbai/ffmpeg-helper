/**
 * Copyright (C) 2022-2023 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.viiyue.ffmpeg.filter;

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
