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
package com.viiyue.ffmpeg.util;

import java.awt.Color;
import java.io.File;
import java.lang.invoke.SerializedLambda;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.util.StringJoiner;
import java.util.function.Function;
import java.util.regex.Pattern;

import org.apache.commons.lang3.StringUtils;

import com.viiyue.ffmpeg.common.AbstractEnum;
import com.viiyue.ffmpeg.common.Const;
import com.viiyue.ffmpeg.common.NoArgUsage;
import com.viiyue.ffmpeg.common.UsageLambda;

/**
 * Common helper for global project
 *
 * @author tangxbai
 * @since 2022/05/25
 */
public final class Helper {

	private final static String DECIMAL_TEMPLATE = "%.3f";
	private final static Pattern PATTERN = Pattern.compile( "([:=\\[\\]\\\\])" );

	public static String nullKey( int index ) {
		return Const.NULL + "_" + index;
	}

	public static boolean isNullKey( String key ) {
		return StringUtils.isNotEmpty( key ) && key.startsWith( Const.NULL );
	}

	public static String command( String cmd ) {
		return cmd.startsWith( Const.ARG_PREFIX ) ? cmd : Const.ARG_PREFIX + cmd;
	}

	public static boolean isInteger( double value ) {
		return value - Math.floor( value ) < Const.DECIMAL_EPS;
	}

	public static String escape( Object input ) {
		return escape( input.toString(), false );
	}

	public static String escape( String input, boolean quote ) {
		String replacement = PATTERN.matcher( input ).replaceAll( "\\\\$0" );
		return quote ? Const.QUOTE + replacement + Const.QUOTE : replacement;
	}

	public static String quotes( String input ) {
		if ( input.startsWith( Const.DB_QUOTES ) && input.endsWith( Const.DB_QUOTES ) ) {
			return input;
		}
		return Const.DB_QUOTES + input + Const.DB_QUOTES;
	}
	
	public static String fixPath( String path ) {
		if ( StringUtils.isEmpty( path ) ) {
			return path;
		}
		return StringUtils.endsWithAny( path, Const.SLASH, File.separator ) ? path : path + Const.SLASH;
	}

	public static String wrap( Object content ) {
		if ( content == null ) {
			return StringUtils.EMPTY;
		}
		return Const.INPUT_TOKEN_START + content + Const.INPUT_TOKEN_END;
	}

	public static int getDecimalDigits( double number ) {
		if ( number == ( long ) number ) {
			return 0;
		}
		int i = 0;
		while ( true ) {
			i ++;
			if ( number * Math.pow( 10, i ) % 1 == 0 ) {
				return i;
			}
		}
	}

	public static StringJoiner expandAll( String delimiter, Object ... arrays ) {
		return expandAll( delimiter, null, arrays );
	}

	public static StringJoiner expandAll( String delimiter, Function<Object, Object> handler, Object ... arrays ) {
		StringJoiner joiner = new StringJoiner( delimiter );
		for ( Object element : arrays ) {
			Object realValue = toValue( element );
			if ( realValue != null ) {
				joiner.add( ( handler == null ? realValue : handler.apply( realValue ) ).toString() );
			}
		}
		return joiner;
	}
	
	public static StringJoiner expandFlags( AbstractEnum ... flags ) {
		return expandFlags( Const.APPEND_SEPARATOR, flags );
	}
	
	public static StringJoiner expandFlags( String separtor, AbstractEnum ... flags ) {
		return Helper.expandAll( separtor, Helper::toValue, flags );
	}

	public static String toHexColor( Color color ) {
		String red = toHexValue( color.getRed() );
		String green = toHexValue( color.getGreen() );
		String blue = toHexValue( color.getBlue() );
		return "#" + red + green + blue;
	}

	public static String to16HexColor( Color color ) {
		String red = toHexValue( color.getRed() );
		String green = toHexValue( color.getGreen() );
		String blue = toHexValue( color.getBlue() );
		return "0x" + red + green + blue;
	}

	public static String toHexValue( int number ) {
		String result = Integer.toHexString( number & 0xff );
		while ( result.length() < 2 ) {
			result = "0" + result;
		}
		return result.toUpperCase();
	}

	public static Object toValue( Object value ) {
		if ( value == null ) {
			return null;
		}
		if ( value instanceof Float || value instanceof Double ) {
			Double dbValue = ( Double ) value;
			if ( isInteger( dbValue ) ) {
				return String.valueOf( dbValue.intValue() );
			}
			if ( Helper.getDecimalDigits( dbValue ) > 3 ) {
				return String.format( DECIMAL_TEMPLATE, dbValue );
			}
			return dbValue.toString();
		}
		if ( value instanceof BigDecimal ) {
			return ( ( BigDecimal ) value ).setScale( 2, BigDecimal.ROUND_HALF_UP ).toPlainString();
		}
		if ( value instanceof AbstractEnum ) {
			return ( ( AbstractEnum ) value ).command();
		}
		return value;
	}

	public static void createDirectoryIfNecessary( String filePath ) {
		if ( StringUtils.isNotEmpty( filePath ) ) {
			createDirectoryIfNecessary( new File( filePath ) );
		}
	}

	public static void createDirectoryIfNecessary( File file ) {
		if ( file != null ) {
			File parentFile = file.getParentFile();
			if ( !parentFile.exists() ) {
				parentFile.mkdirs();
			}
		}
	}
	
	public static boolean cmdCheck(  String ... cmd ) {
		try {
			return Runtime.getRuntime().exec( cmd ).waitFor() == 0;
		} catch ( Exception e ) {
			return false;
		}
	}
	
	public static String fillLength( int length, String input, char placeholder ) {
		return fillLength( length, input, placeholder, false );
	}
	
	public static String fillLength( int length, String input, char placeholder, boolean reverse ) {
		if ( input == null ) {
			return Const.NONE;
		}
		if ( input.length() >= length ) {
			return input;
		}
		StringBuilder builder = new StringBuilder( input );
		while ( builder.length() < length ) {
			if ( reverse ) {
				builder.insert( 0, placeholder );
			} else {
				builder.append( placeholder );
			}
		}
		return builder.toString();
	}
	
	public static String getLambdaMethod( UsageLambda lambda ) {
		if ( lambda == null ) {
			return Const.NULL;
		}
		try {
			Method method = lambda.getClass().getDeclaredMethod( "writeReplace" );
			if ( !method.isAccessible() ) {
				method.setAccessible( true );
			}
			SerializedLambda sl = ( SerializedLambda ) method.invoke( lambda );
			String methodName = sl.getImplMethodName();
			if ( lambda instanceof NoArgUsage ) {
				return methodName + "()";
			}
			String implMethodName = sl.getInstantiatedMethodType();
			implMethodName = implMethodName.substring( 0, implMethodName.indexOf( ")" ) );
			implMethodName = implMethodName.substring( implMethodName.lastIndexOf( "/" ) + 1, implMethodName.lastIndexOf( ";" ) );
			return implMethodName + "(" + implMethodName + ")";
		} catch ( Exception e ) {
			return lambda.getClass().getSimpleName();
		}
	}

}
