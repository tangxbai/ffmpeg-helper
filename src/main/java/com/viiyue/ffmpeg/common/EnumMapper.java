package com.viiyue.ffmpeg.common;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.stream.Collectors;

import com.viiyue.ffmpeg.annotation.Alias;

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
