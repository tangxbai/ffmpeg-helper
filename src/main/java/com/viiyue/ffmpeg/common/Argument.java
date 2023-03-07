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
package com.viiyue.ffmpeg.common;

import java.util.Objects;

import com.viiyue.ffmpeg.util.Helper;

/**
 * The argument object of the FFmpeg filter function
 *
 * @author tangxbai
 * @since 2022/09/30
 */
public final class Argument {

	private int index;
	private String key;
	private Object value;

	public int getIndex() {
		return index;
	}

	public void setIndex( int index ) {
		this.index = index;
	}

	public String getKey() {
		return key;
	}

	public void setKey( String key ) {
		this.key = Helper.command( key );
	}

	public Object getValue() {
		return value;
	}

	public void setValue( Object value ) {
		this.value = value;
	}

	public boolean is( String key ) {
		return Objects.equals( Helper.command( key ), this.key );
	}

	@Override
	public String toString() {
		return key + ( value == null ? "" : " " + value );
	}

}
