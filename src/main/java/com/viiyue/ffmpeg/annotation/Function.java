package com.viiyue.ffmpeg.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Provide to get the filter function name
 *
 * @author tangxbai
 * @since 2022/07/05
 */
@Inherited
@Target( ElementType.TYPE )
@Retention( RetentionPolicy.RUNTIME )
public @interface Function {

	/** @return the filter function name */
	String value();

}
