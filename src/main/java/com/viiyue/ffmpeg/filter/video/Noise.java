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
 * Add noise on video input frame
 * 
 * @author tangxbai
 * @since 2022/07/19
 * @see <a href="https://ffmpeg.org/ffmpeg-filters.html#noise">ffmpeg-filters#noise</a>
 */
@Function( "noise" )
public class Noise extends AbstractFunction<Noise> {

	// Don't let anyone instantiate this class
	private Noise() {}

	/**
	 * Quickly create an instances of {@link Noise}
	 * 
	 * @return the {@link Noise} instance
	 */
	public static final Noise of() {
		return new Noise();
	}

	/**
	 * Set noise seed for specific pixel component or all pixel components in case of {@code all_seed}.
	 * 
	 * @apiNote (string) all_seed
	 * @param value the noise seed
	 * @return the {@link Noise} instance
	 */
	public Noise allSeed( int value ) {
		return super.addArg( "all_seed", value );
	}

	/**
	 * Set component #0 noise seed
	 * 
	 * @apiNote (string) c0_seed
	 * @param value the component #0 noise seed
	 * @return the {@link Noise} instance
	 */
	public Noise c0seed( int value ) {
		return super.addArg( "c0_seed", value );
	}

	/**
	 * Set component #1 noise seed
	 * 
	 * @apiNote (string) c1_seed
	 * @param value the component #1 noise seed
	 * @return the {@link Noise} instance
	 */
	public Noise c1seed( int value ) {
		return super.addArg( "c1_seed", value );
	}

	/**
	 * Set component #2 noise seed
	 * 
	 * @apiNote (string) c2_seed
	 * @param value the component #2 noise seed
	 * @return the {@link Noise} instance
	 */
	public Noise c2seed( int value ) {
		return super.addArg( "c2_seed", value );
	}

	/**
	 * Set component #3 noise seed
	 * 
	 * @apiNote (string) c3_seed
	 * @param value the component #3 noise seed
	 * @return the {@link Noise} instance
	 */
	public Noise c3seed( int value ) {
		return super.addArg( "c3_seed", value );
	}

	/**
	 * Set noise strength for specific pixel component or all pixel components in case {@code all_strength}.
	 * 
	 * @apiNote (string) all_strength, alls
	 * @param value the noise strength
	 * @return the {@link Noise} instance
	 */
	public Noise allStrength( int value ) {
		Assert.rangeCheck( value, 0, 100 );
		return super.addArg( "alls", value ); // all_strength, alls
	}

	/**
	 * Set noise component #0 strength
	 * 
	 * @apiNote (string) c0_strength, c0s
	 * @param value the component #0 strength
	 * @return the {@link Noise} instance
	 */
	public Noise c0trength( int value ) {
		Assert.rangeCheck( value, 0, 100 );
		return super.addArg( "c0s", value ); // c0_strength, c0s
	}

	/**
	 * Set noise component #1 strength
	 * 
	 * @apiNote (string) c1_strength, c1s
	 * @param value the component #1 strength
	 * @return the {@link Noise} instance
	 */
	public Noise c1trength( int value ) {
		Assert.rangeCheck( value, 0, 100 );
		return super.addArg( "c1s", value ); // c1_strength, c1s
	}

	/**
	 * Set noise component #2 strength
	 * 
	 * @apiNote (string) c2_strength, c2s
	 * @param value the component #2 strength
	 * @return the {@link Noise} instance
	 */
	public Noise c2trength( int value ) {
		Assert.rangeCheck( value, 0, 100 );
		return super.addArg( "c2s", value ); // c2_strength, c2s
	}

	/**
	 * Set noise component #3 strength
	 * 
	 * @apiNote (string) c3_strength, c3s
	 * @param value the component #3 strength
	 * @return the {@link Noise} instance
	 */
	public Noise c3trength( int value ) {
		Assert.rangeCheck( value, 0, 100 );
		return super.addArg( "c3s", value ); // c3_strength, c3s
	}

	/**
	 * Set pixel component flags or set flags for all components if {@code all_flags}.
	 * 
	 * @apiNote (string) all_flags, allf
	 * @param value the pixel component flags
	 * @return the {@link Noise} instance
	 */
	public Noise allFlags( Flags flags ) {
		return super.addArg( "allf", flags ); // all_flags, allf
	}

	/**
	 * Set pixel component #0 flags
	 * 
	 * @apiNote (string) c0_flags, c0f
	 * @param value the component #0 flags
	 * @return the {@link Noise} instance
	 */
	public Noise c0flags( Flags flags ) {
		return super.addArg( "c0f", flags ); // c0_flags, c0f
	}

	/**
	 * Set pixel component #1 flags
	 * 
	 * @apiNote (string) c1_flags, c1f
	 * @param value the component #1 flags
	 * @return the {@link Noise} instance
	 */
	public Noise c1flags( Flags flags ) {
		return super.addArg( "c1f", flags ); // c1_flags, c1f
	}

	/**
	 * Set pixel component #2 flags
	 * 
	 * @apiNote (string) c2_flags, c2f
	 * @param value the component #2 flags
	 * @return the {@link Noise} instance
	 */
	public Noise c2flags( Flags flags ) {
		return super.addArg( "c2f", flags ); // c2_flags, c2f
	}

	/**
	 * Set pixel component #3 flags
	 * 
	 * @apiNote (string) c3_flags, c3f
	 * @param value the component #3 flags
	 * @return the {@link Noise} instance
	 */
	public Noise c3flags( Flags flags ) {
		return super.addArg( "c3f", flags ); // c3_flags, c3f
	}

	/**
	 * Operating mode
	 *
	 * @author tangxbai
	 * @since 2022/07/19
	 */
	public enum Flags implements AbstractEnum {
		/** Averaged temporal noise (smoother) */
		A,
		/** Mix random noise with a (semi)regular pattern */
		P,
		/** Temporal noise (noise pattern changes between frames) */
		T,
		/** Uniform noise (gaussian otherwise) */
		U
	}

}
