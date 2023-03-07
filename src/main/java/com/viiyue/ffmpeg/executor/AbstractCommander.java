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
 * @param <T>
 */
abstract class AbstractCommander<T extends AbstractCommander<?>> {

	private final List<Argument> commands = new LinkedList<Argument>();

	protected final T output( String output ) {
		return cmd( Const.ARG_PREFIX, output, true );
	}

	public final T cmd( String cmd ) {
		return cmd( cmd, null, true );
	}

	public final T cmd( String cmd, boolean isUnique ) {
		return cmd( cmd, null, isUnique );
	}

	public final T cmd( String cmd, Object value ) {
		return cmd( cmd, value, true );
	}

	public final T cmd( String cmd, Object value, boolean isUnique ) {
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
		return ( T ) this;
	}

	protected final T remove( String cmd ) {
		Argument argument = find( cmd );
		if ( argument != null ) {
			this.commands.remove( argument.getIndex() );
		}
		return ( T ) this;
	}

	protected final T replace( String cmd, Object value ) {
		Argument argument = find( cmd );
		if ( argument != null ) {
			argument.setValue( Helper.toValue( value ) );
		}
		return ( T ) this;
	}

	protected final boolean exist( String cmd ) {
		return find( cmd ) != null;
	}

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
				fullCommands.add( value.toString() );
			}
		} );
		return fullCommands;
	}

	@Override
	public String toString() {
		return commands.isEmpty() ? "[]" : "[" + StringUtils.join( toCommands(), ' ' ) + "]";
	}

	private Argument find( String cmd ) {
		for ( Argument argument : commands ) {
			if ( argument.is( cmd ) ) {
				return argument;
			}
		}
		return null;
	}

}
