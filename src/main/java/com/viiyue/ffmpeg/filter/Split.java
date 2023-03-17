/**
 * Copyright (C) 2022-2023 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in
 * compliance with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License is
 * distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and limitations under the License.
 */
package com.viiyue.ffmpeg.filter;

import com.viiyue.ffmpeg.util.Helper;

public final class Split extends AbstractResult<Split> {

	private final Filters filters;
	private final String stream;
	
	private String to;

	protected Split( Filters filters ) {
		this( filters, null );
	}
	
	protected Split( Filters filters, String stream ) {
		this.filters = filters;
		this.stream = Helper.wrap( stream );
	}

	public Split to( String ... streams ) {
		this.to = "split" + Helper.expandAll( "", Helper::wrap, streams ).toString();
		return this;
	}

	public Filters and() {
		return this.filters;
	}

	@Override
	protected String getResult() {
		if ( stream != null ) {
			return stream.concat( to );
		}
		return to.toString();
	}

}
