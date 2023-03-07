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
package com.viiyue.ffmpeg.metadata;

/**
 * 
 * @author tangxbai
 * @since 2022/05/25
 */
public class SimpleFormat {

	private String sample;
	private String description;

	public SimpleFormat( String sample, String description ) {
		super();
		this.sample = sample;
		this.description = description;
	}

	public String getSample() {
		return sample;
	}

	public void setSample( String sample ) {
		this.sample = sample;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription( String description ) {
		this.description = description;
	}

	@Override
	public String toString() {
		return sample + "(" + description + ")";
	}

}
