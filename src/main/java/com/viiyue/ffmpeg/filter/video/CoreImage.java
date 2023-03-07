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
import com.viiyue.ffmpeg.filter.AbstractFunction;
import com.viiyue.ffmpeg.util.Helper;

/**
 * Video filtering on GPU using Apple’s CoreImage API on OSX.
 * 
 * Hardware acceleration is based on an OpenGL context. Usually, this means it is processed by video hardware.
 * However, software-based OpenGL implementations exist which means there is no guarantee for hardware
 * processing. It depends on the respective OSX.
 * 
 * There are many filters and image generators provided by Apple that come with a large variety of options.
 * The filter has to be referenced by its name along with its options.
 * 
 * @author tangxbai
 * @since 2022/06/17
 * @see <a href="https://ffmpeg.org/ffmpeg-filters.html#coreimage">ffmpeg-filters#coreimage</a>
 */
@Function( "coreimage" )
public class CoreImage extends AbstractFunction<CoreImage> {

	// Don't let anyone instantiate this class
	private CoreImage() {}

	/**
	 * Quickly create an instances of {@link CoreImage}
	 * 
	 * @return the {@link CoreImage} instance
	 */
	public static final CoreImage of() {
		return new CoreImage();
	}

	/**
	 * List all available filters and generators along with all their respective options as well as possible
	 * minimum and maximum values along with the default values.
	 * 
	 * @apiNote (string) list_filters
	 * @return the {@link CoreImage} instance
	 */
	public CoreImage listFilters() {
		return super.addArg( "list_filters", "true" );
	}

	/**
	 * <p>
	 * Specify all filters by their respective name and options. Use list_filters to determine all valid
	 * filter names and options. Numerical options are specified by a float value and are automatically
	 * clamped to their respective value range. Vector and color options have to be specified by a list of
	 * space separated float values. Character escaping has to be done. A special option name default is
	 * available to use default options for a filter.
	 * 
	 * <p>
	 * It is required to specify either default or at least one of the filter options. All omitted options are
	 * used with their default values.
	 * 
	 * <p>
	 * The syntax of the filter string is as follows:
	 * 
	 * <pre>
	 * filter=&lt;NAME&gt;@&lt;OPTION&gt;=&lt;VALUE&gt;[@&lt;OPTION&gt;=&lt;VALUE&gt;][@...][#&lt;NAME&gt;@&lt;OPTION&gt;=&lt;VALUE&gt;[@&lt;OPTION&gt;=&lt;VALUE&gt;][@...]][#...]
	 * </pre>
	 * 
	 * @apiNote (string) filter
	 * @param expression the OSX filter expression
	 * @return the {@link CoreImage} instance
	 */
	public CoreImage filter( String expression ) {
		super.addArg( "filter", Helper.escape( expression, true ) );
		return this;
	}

	/**
	 * <p>
	 * Specify a rectangle where the output of the filter chain is copied into the input image.
	 * 
	 * <p>
	 * It is given by a list of space separated float values:
	 * 
	 * <pre>
	 * output_rect=x\ y\ width\ height
	 * </pre>
	 * 
	 * @apiNote (string) filter
	 * @param expression the OSX filter expression
	 * @return the {@link CoreImage} instance
	 */
	public CoreImage outputRect( double x, double y, double width, double height ) {
		super.addArg( "filter", Helper.expandAll( "\\ ", x, y, width, height ) );
		return this;
	}

}
