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
package com.viiyue.ffmpeg.executor;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;

import com.viiyue.ffmpeg.common.Argument;
import com.viiyue.ffmpeg.common.Const;
import com.viiyue.ffmpeg.util.Helper;

/**
 * The abstract command collector
 * 
 * @author tangxbai
 * @since 2022/05/25
 * @param <T> the subclasses
 */
abstract class AbstractCommander<T extends AbstractCommander<?>> {

	private final List<Argument> commands = new LinkedList<Argument>();

	protected final T output( String output ) {
		return cmd( Const.ARG_PREFIX, output, true );
	}

	/**
	 * Set the command
	 * 
	 * @param cmd the command value
	 * @return the current instance
	 */
	public final T cmd( String cmd ) {
		return cmd( cmd, null, true );
	}

	/**
	 * Set the command. <b>Note</b>: this method will wrap the command value in double quotes, just like
	 * {@code "cmd=value"}.
	 * 
	 * @param cmd the command value
	 * @return the current instance
	 * @since 1.0.1
	 */
	public final T cmdWrap( String cmd ) {
		return cmdWrap( cmd, null, true );
	}

	/**
	 * Set the command and specify whether the command is unique
	 * 
	 * @param cmd      the input command
	 * @param isUnique whether the command is unique
	 * @return the current instance
	 */
	public final T cmd( String cmd, boolean isUnique ) {
		return cmd( cmd, null, isUnique );
	}
	
	/**
	 * Set the command and value and specify whether the command is unique. <b>Note</b>: this method will wrap
	 * the command value in double quotes, just like {@code "cmd=value"}.
	 * 
	 * @param cmd      the input command
	 * @param isUnique whether the command is unique
	 * @return the current instance
	 * @since 1.0.1
	 */
	public final T cmdWrap( String cmd, boolean isUnique ) {
		return cmdWrap( cmd, null, isUnique );
	}

	/**
	 * Set the command and value and specify whether the command is unique
	 * 
	 * @param cmd   the command key
	 * @param value the command value
	 * @return the current instance
	 */
	public final T cmd( String cmd, Object value ) {
		return cmd( cmd, value, true );
	}

	/**
	 * Set the command and value and specify whether the command is unique. <b>Note</b>: this method will wrap
	 * the command value in double quotes, just like {@code "cmd=value"}.
	 * 
	 * @param cmd   the command key
	 * @param value the command value
	 * @return the current instance
	 * @since 1.0.1
	 */
	public final T cmdWrap( String cmd, Object value ) {
		return cmdWrap( cmd, value, true );
	}

	/**
	 * Set the command and value and specify whether the command is unique
	 * 
	 * @param cmd      the command key
	 * @param value    the command value
	 * @param isUnique whether the command is unique
	 * @return the current instance
	 */
	public final T cmd( String cmd, Object value, boolean isUnique ) {
		buildArg( cmd, value, isUnique );
		return ( T ) this;
	}
	
	/**
	 * Set the command and value and specify whether the command is unique. <b>Note</b>: this method will wrap
	 * the command value in double quotes, just like {@code "cmd=value"}.
	 * 
	 * @param cmd      the command key
	 * @param value    the command value
	 * @param isUnique whether the command is unique
	 * @return the current instance
	 */
	public final T cmdWrap( String cmd, Object value, boolean isUnique ) {
		buildArg( cmd, value, isUnique ).quotesWrap();
		return ( T ) this;
	}

	/**
	 * Removes the target command from the command list
	 * 
	 * @param cmd the target command
	 * @return the current instance
	 */
	protected final T remove( String cmd ) {
		Argument argument = find( cmd );
		if ( argument != null ) {
			this.commands.remove( argument.getIndex() );
		}
		return ( T ) this;
	}

	/**
	 * Replace the command that matches in the command list
	 * 
	 * @param cmd the command key
	 * @param value the target command for replacement
	 * @return the current instance
	 */
	protected final T replace( String cmd, Object value ) {
		Argument argument = find( cmd );
		if ( argument != null ) {
			argument.setValue( Helper.toValue( value ) );
		}
		return ( T ) this;
	}

	/**
	 * Check if the target command exists
	 * 
	 * @param cmd the command
	 * @return the current instance
	 */
	protected final boolean exist( String cmd ) {
		return find( cmd ) != null;
	}

	/**
	 * Expand all commands as a list string
	 * 
	 * @param preCommands the prepending commands
	 * @return the current instance
	 */
	protected final List<String> toCommands( String ... preCommands ) {
		List<String> fullCommands = new LinkedList<String>();
		if ( ArrayUtils.isNotEmpty( preCommands ) ) {
			fullCommands.addAll( 0, Arrays.asList( preCommands ) );
		}
		commands.forEach( arg -> {
			String cmd = arg.getKey();
			Object value = arg.getValue();
			if ( !cmd.equals( Const.ARG_PREFIX ) ) {
				fullCommands.add( cmd );
			}
			if ( value != null ) {
				if ( arg.isQuotesWrap() ) {
					fullCommands.add( Helper.quotes( value.toString() ) );
				} else {
					fullCommands.add( value.toString() );
				}
			}
		} );
		return fullCommands;
	}
	
	/**
	 * Expand all commands as a string
	 * 
	 * @return the command string
	 * @since 1.0.1
	 */
	protected final String toCommandString() {
		return StringUtils.join( toCommands(), ' ' );
	}
	
	/**
	 * Expand all commands as a string
	 * 
	 * @return the command string
	 * @since 1.0.1
	 */
	protected final String toCommandString( String ... preCommands ) {
		return StringUtils.join( toCommands( preCommands ), ' ' );
	}
	
	/**
	 * Find the matched command argument
	 * 
	 * @param cmd the searching command
	 * @return the found command argument
	 */
	private Argument find( String cmd ) {
		for ( Argument argument : commands ) {
			if ( argument.is( cmd ) ) {
				return argument;
			}
		}
		return null;
	}
	
	/**
	 * Build a command argument instance object
	 * 
	 * @param cmd      the command key string
	 * @param value    the command value
	 * @param isUnique whether the command is unique
	 * @return the command argument
	 */
	private Argument buildArg( String cmd, Object value, boolean isUnique ) {
		if ( cmd == null ) {
			throw new NullPointerException( "The command input cannot be null" );
		}
		Argument argument = null;
		if ( isUnique ) {
			argument = find( cmd );
		}
		if ( argument == null ) {
			argument = new Argument();
			argument.setKey( cmd );
			argument.setIndex( commands.size() );
			commands.add( argument );
		}
		argument.setValue( Helper.toValue( value ) );
		return argument;
	}

	@Override
	public String toString() {
		return commands.isEmpty() ? "[]" : "[" + toCommandString() + "]";
	}

}
