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
package com.viiyue.ffmpeg.enums;

import com.viiyue.ffmpeg.annotation.Alias;
import com.viiyue.ffmpeg.common.AbstractEnum;

/**
 * CPU flags
 *
 * @author tangxbai
 * @since 2023/03/17
 * @since 1.0.1
 */
public enum CpuFlag implements AbstractEnum {

//  X86
	MMX,
	MMXEXT,
	SSE,
	SSE2,
	SSE2SLOW,
	SSE3,
	SSE3SLOW,
	SSSE3,
	ATOM,
	@Alias( "sse4.1" )
	SSE4_1,
	@Alias( "sse4.2" )
	SSE4_2,
	AVX,
	AVX2,
	XOP,
	FMA3,
	FMA4,
	@Alias( "3dnow" )
	_3DNOW,
	@Alias( "3dnowext" )
	_3DNOWEXT,
	BMI1,
	BMI2,
	CMOV,
	
// ARM
	ARMV5TE,
	ARMV6,
	ARMV6T2,
	VFP,
	VFPV3,
	NEON,
	SETEND,
	
// AArch64
	ARMV8,
//	VFP,
//	NEON,
	
// PowerPC
	ALTIVEC,

// Specific Processors
	PENTIUM2,
	PENTIUM3,
	PENTIUM4,
	K6,
	K62,
	ATHLON,
	ATHLONXP,
	K8
	
}
