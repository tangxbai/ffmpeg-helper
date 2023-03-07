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
import com.viiyue.ffmpeg.util.Assert;

/**
 * <p>
 * The removegrain filter is a spatial denoiser for progressive video
 * 
 * <p>
 * Range of mode is from <b>0</b> to <b>24</b>, description of each mode follows:
 * 
 * <ul>
 * <li><b>0</b> - Leave input plane unchanged. Default.
 * <li><b>1</b> - Clips the pixel with the minimum and maximum of the 8 neighbour pixels.
 * <li><b>2</b> - Clips the pixel with the second minimum and maximum of the 8 neighbour pixels.
 * <li><b>3</b> - Clips the pixel with the third minimum and maximum of the 8 neighbour pixels.
 * <li><b>4</b> - Clips the pixel with the fourth minimum and maximum of the 8 neighbour pixels. This is
 * equivalent to a median filter.
 * <li><b>5</b> - Line-sensitive clipping giving the minimal change.
 * <li><b>6</b> - Line-sensitive clipping, intermediate.
 * <li><b>7</b> - Line-sensitive clipping, intermediate.
 * <li><b>8</b> - Line-sensitive clipping, intermediate.
 * <li><b>9</b> - Line-sensitive clipping on a line where the neighbours pixels are the closest.
 * <li><b>10</b> - Replaces the target pixel with the closest neighbour.
 * <li><b>11</b> - [1 2 1] horizontal and vertical kernel blur.
 * <li><b>12</b> - Same as mode 11.
 * <li><b>13</b> - Bob mode, interpolates top field from the line where the neighbours pixels are the closest.
 * <li><b>14</b> - Bob mode, interpolates bottom field from the line where the neighbours pixels are the
 * closest.
 * <li><b>15</b> - Bob mode, interpolates top field. Same as 13 but with a more complicated interpolation
 * formula.
 * <li><b>16</b> - Bob mode, interpolates bottom field. Same as 14 but with a more complicated interpolation
 * formula.
 * <li><b>17</b> - Clips the pixel with the minimum and maximum of respectively the maximum and minimum of
 * each pair of opposite neighbour pixels.
 * <li><b>18</b> - Line-sensitive clipping using opposite neighbours whose greatest distance from the current
 * pixel is minimal.
 * <li><b>19</b> - Replaces the pixel with the average of its 8 neighbours.
 * <li><b>20</b> - Averages the 9 pixels ([1 1 1] horizontal and vertical blur).
 * <li><b>21</b> - Clips pixels using the averages of opposite neighbour.
 * <li><b>22</b> - Same as mode 21 but simpler and faster.
 * <li><b>23</b> - Small edge and halo removal, but reputed useless.
 * <li><b>24</b> - Similar as 23.
 * </ul>
 * 
 * @author tangxbai
 * @since 2022/07/25
 * @see <a href="https://ffmpeg.org/ffmpeg-filters.html#removegrain">ffmpeg-filters#removegrain</a>
 */
@Function( "removegrain" )
public class RemoveGrain extends AbstractFunction<RemoveGrain> {

	// Don't let anyone instantiate this class
	private RemoveGrain() {}

	/**
	 * Quickly create an instances of {@link RemoveGrain}
	 * 
	 * @return the {@link RemoveGrain} instance
	 */
	public static final RemoveGrain of() {
		return new RemoveGrain();
	}

	/**
	 * Set mode for the first plane
	 * 
	 * @apiNote (int) m0
	 * @param value the plane mode value
	 * @return the {@link RemoveGrain} instance
	 */
	public RemoveGrain mode0( int value ) {
		Assert.rangeCheck( value, 0, 24 );
		return super.addArg( "m0", value );
	}

	/**
	 * Set mode for the second plane
	 * 
	 * @apiNote (int) m1
	 * @param value the plane mode value
	 * @return the {@link RemoveGrain} instance
	 */
	public RemoveGrain mode1( int value ) {
		Assert.rangeCheck( value, 0, 24 );
		return super.addArg( "m1", value );
	}

	/**
	 * Set mode for the third plane
	 * 
	 * @apiNote (int) m2
	 * @param value the plane mode value
	 * @return the {@link RemoveGrain} instance
	 */
	public RemoveGrain mode2( int value ) {
		Assert.rangeCheck( value, 0, 24 );
		return super.addArg( "m2", value );
	}

	/**
	 * Set mode for the fourth plane
	 * 
	 * @apiNote (int) m3
	 * @param value the plane mode value
	 * @return the {@link RemoveGrain} instance
	 */
	public RemoveGrain mode3( int value ) {
		Assert.rangeCheck( value, 0, 24 );
		return super.addArg( "m4", value );
	}

}
