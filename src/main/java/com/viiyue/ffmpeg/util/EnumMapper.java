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

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.stream.Collectors;

import com.viiyue.ffmpeg.annotation.Alias;
import com.viiyue.ffmpeg.common.AbstractEnum;

/**
 * Enumeration item provider
 * 
 * @author tangxbai
 * @since 2022/09/30
 */
public class EnumMapper {

	private static final Map<Class<?>, Map<String, Field>> caches = new ConcurrentHashMap<>( 32 );

	private static class Holder {
		private static final EnumMapper INSTANCE = new EnumMapper();
	}

	public static final Field getField( Class<? extends AbstractEnum> type, String name ) {
		EnumMapper mapper = Holder.INSTANCE;
		Map<String, Field> fields = mapper.init( type );
		return fields.get( name );
	}

	public static final String getName( Class<? extends AbstractEnum> type, AbstractEnum ae ) {
		Field field = getField( type, ae.name() );
		Alias annotation = field.getAnnotation( Alias.class );
		return annotation == null ? ae.getName( null ) : annotation.value();
	}

	public Map<String, Field> init( Class<? extends AbstractEnum> type ) {
		return caches.computeIfAbsent( type, t -> Arrays.stream( t.getDeclaredFields() ).filter( Field::isEnumConstant )
				.collect( Collectors.toMap( Field::getName, Function.identity() ) ) );
	}

}
