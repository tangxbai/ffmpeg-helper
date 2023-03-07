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
package com.viiyue.ffmpeg.filter.video;

import com.viiyue.ffmpeg.annotation.Function;
import com.viiyue.ffmpeg.common.AbstractEnum;
import com.viiyue.ffmpeg.filter.AbstractFunction;
import com.viiyue.ffmpeg.util.Assert;

/**
 * Template of a common function
 * 
 * @author tangxbai
 * @since 2022/08/10
 * @see <a href="https://ffmpeg.org/ffmpeg-filters.html#template">ffmpeg-filters#template</a>
 */
@Function( "template" )
public class ZZZTemplate extends AbstractFunction<ZZZTemplate> {

	// Don't let anyone instantiate this class
	private ZZZTemplate() {}

	/**
	 * Quickly create an instances of {@link ZZZTemplate}
	 * 
	 * @return the {@link ZZZTemplate} instance
	 */
	public static final ZZZTemplate of() {
		return new ZZZTemplate();
	}

	/**
	 * Parameter without value
	 * 
	 * @apiNote (arg) demo
	 * @return the {@link ZZZTemplate} instance
	 */
	public ZZZTemplate demo() {
		return super.addArg( "demo", null );
	}

	/**
	 * Parameter member
	 * 
	 * @apiNote (arg) demo
	 * @param value the value description
	 * @return the {@link ZZZTemplate} instance
	 */
	public ZZZTemplate demo( double value ) {
		Assert.rangeCheck( value, 0.1, 1.0 );
		return super.addArg( "demo", value );
	}

	/**
	 * Enumeration template
	 * 
	 * @author tangxbai
	 * @since 2022/06/16
	 */
	public enum AA implements AbstractEnum {
		AAA,
	}

}
