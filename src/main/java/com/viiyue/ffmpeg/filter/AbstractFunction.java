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

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.StringJoiner;
import java.util.concurrent.ConcurrentHashMap;

import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;

import com.viiyue.ffmpeg.annotation.Function;
import com.viiyue.ffmpeg.common.AbstractEnum;
import com.viiyue.ffmpeg.common.Const;
import com.viiyue.ffmpeg.util.Helper;

/**
 * Abstract filter function
 * 
 * @author tangxbai
 * @since 2022/06/02
 * @param <T>
 */
public abstract class AbstractFunction<T extends AbstractFunction<?>> extends AbstractResult<T> {

	private static final Map<Class<?>, String> funNames = new ConcurrentHashMap<>( 16 );

	private boolean basicOnly = true;
	private Map<String, Object> basically;

	private final String separator;
	private final HashMap<String, Object> args = new LinkedHashMap<String, Object>( 8 ) {
		private static final long serialVersionUID = 1L;
		private int nullIndex;

		@Override
		public Object put( String key, Object value ) {
			if ( key == null ) {
				key = Helper.nullKey( nullIndex ++ ); // NULL_1, NULL_2, ..., NULL_N
			}
			// Null value
			if ( value == null ) {
				return super.put( key, null );
			}
			// Other values(StringJoiner, AbstractEnum, Integer, Double, BigDecimal...)
			return super.put( key, Helper.toValue( value ) );
		}
	};

	/**
	 * Set the separator via the constructor, and initialize the separator to
	 * {@link Const#PARAMETER_SEPARATOR}
	 */
	public AbstractFunction() {
		this( Const.PARAMETER_SEPARATOR );
	}

	/**
	 * Set the separator via the constructor
	 * 
	 * @param groupSeparator the separator between parameters
	 */
	public AbstractFunction( String groupSeparator ) {
		this.separator = groupSeparator;
	}

	/**
	 * Get the wrapper tokens for the argument
	 * 
	 * @return the wrapper tokens
	 */
	protected String [] getArgWrapper() {
		return Const.ARGUMENT_WRAPPER;
	}

	/**
	 * Let the subclass override to get the latest function name, if not, try to get the function name defined
	 * in the class annotation {@link Function}.
	 * 
	 * @return the filter function name
	 */
	protected String getFunName() {
		Class<? extends AbstractFunction<?>> clazz = ( Class<? extends AbstractFunction<?>> ) getClass();
		return funNames.computeIfAbsent( clazz, key -> {
			Function function = clazz.getAnnotation( Function.class );
			return function == null ? null : function.value();
		} );
	}

	/**
	 * Enable the specified parameter setting
	 * 
	 * @param arg the parameter that need to be enabled
	 * @return the current instance reference
	 */
	protected T enable( String arg ) {
		return status( arg, true );
	}

	/**
	 * Disable the specified parameter setting
	 * 
	 * @param arg the parameter that need to be disabled
	 * @return the current instance reference
	 */
	protected T disable( String arg ) {
		return status( arg, false );
	}

	/**
	 * Enable or disable the specified parameter setting
	 * 
	 * @param arg the parameter that need to be disabled
	 * @return the current instance reference
	 */
	protected T status( String arg, boolean state ) {
		return this.addArg( arg, state ? 1 : 0 );
	}

	/**
	 * Add a value without parameter name, which can be {@link String}, {@link AbstractEnum}, {@link Double},
	 * {@link Float} or {@link BigDecimal}.
	 * 
	 * @param value the plain value
	 * @return the current instance reference
	 */
	protected T addValue( Object value ) {
		return this.addArg( null, value );
	}

	/**
	 * Add a list of values without parameter names, which can be {@link String}, {@link AbstractEnum},
	 * {@link Double}, {@link Float} or {@link BigDecimal}.
	 * 
	 * @param values the varargs
	 * @return the current instance reference
	 */
	protected T addValues( Object ... values ) {
		return addArg( null, values );
	}

	/**
	 * Add the parameters required by the function, the values can be {@link String}, {@link AbstractEnum},
	 * {@link Double}, {@link Float} or {@link BigDecimal}.
	 * 
	 * @param argName the function parameter name
	 * @param values  the function varargs
	 * @return the current instance reference
	 */
	protected T addArg( String argName, Object ... values ) {
		return addArg2( argName, this.separator, values );
	}

	/**
	 * Add the parameters required by the function, the values can be {@link String}, {@link AbstractEnum},
	 * {@link Double}, {@link Float} or {@link BigDecimal}.
	 * 
	 * @param argName   the parameter name
	 * @param separator the parameter separator
	 * @param values    the function varargs
	 * @return the current instance reference
	 */
	protected T addArg2( String argName, String separator, Object ... values ) {
		if ( basicOnly ) {
			this.basicOnly = false;
			if ( this.basically != null ) {
				this.basically.forEach( ( k, v ) -> addArg2( k, separator, v ) );
			}
		}
		if ( ArrayUtils.isEmpty( values ) ) {
			this.args.put( argName, null );
		} else if ( values.length == 1 ) {
			this.args.put( argName, values[ 0 ] );
		} else {
			this.args.put( argName, Helper.expandAll( separator, Helper::toValue, values ) );
		}
		return ( T ) this;
	}

	/**
	 * Add the basic parameters required by the function, the values can be {@link String},
	 * {@link AbstractEnum}, {@link Double}, {@link Float} or {@link BigDecimal}.
	 * 
	 * @param argName the base parameter name
	 * @param values  the function varargs
	 * @return the current instance reference
	 */
	protected T addBaseArg( String argName, Object value ) {
		if ( this.basically == null ) {
			this.basically = new LinkedHashMap<String, Object>( 4 );
		}
		this.basically.put( argName, value );
		return ( T ) this;
	}

	/**
	 * Get a list of all arguments to a function and return it as a string
	 * 
	 * @return all arguments of the function
	 */
	protected StringJoiner getArguments() {
		String [] wrapper = getArgWrapper();
		StringJoiner joiner = new StringJoiner( separator, wrapper[ 0 ], wrapper[ 1 ] );
		this.args.forEach( ( argName, value ) -> {
			if ( Helper.isNullKey( argName ) ) {
				if ( value != null ) {
					joiner.add( value.toString() );
				}
			} else {
				if ( value == null ) {
					joiner.add( argName );
				} else {
					joiner.add( argName + Const.VALUE_SEPARATOR + value );
				}
			}
		} );
		return joiner;
	}

	@Override
	protected String getResult() {
		if ( basicOnly ) {
			this.basicOnly = false;
			if ( this.basically != null ) {
				this.addValues( this.basically.values().toArray() );
			}
		}

		String funName = getFunName();

		// output -> function
		if ( this.args.isEmpty() ) {
			return StringUtils.defaultString( funName );
		}

		// output -> arg1=value1:arg2=value2...
		StringJoiner arguments = getArguments();
		if ( funName == null ) {
			return arguments.toString();
		}

		// output -> function=arg1=value1:arg2=value2...
		return funName + Const.VALUE_SEPARATOR + arguments;
	}

}
