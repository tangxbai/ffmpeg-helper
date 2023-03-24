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
package com.tangxbai.ffmpeg;

import com.viiyue.ffmpeg.enums.Library;
import com.viiyue.ffmpeg.enums.VideoSize;
import com.viiyue.ffmpeg.filter.Filters;
import com.viiyue.ffmpeg.filter.video.Scale;

public class Test {

	public static void main( String [] args ) {

		Library.FFMPEG.bind( "E:/Ffmpeg-full-build/bin/ffmpeg.exe" );
		Library.FFPROBE.bind( "E:/Ffmpeg-full-build/bin/ffprobe.exe" );
		Library.FFPLAY.bind( "E:/Ffmpeg-full-build/bin/ffplay.exe" );
		Library.setLogLocation( "E:/dekstop" );
		
//		FFmpeger.readVideoInfo( "F:/videos/bin/demo.mp4" );

		Filters filters = Filters.simple();
		filters.stream( 0, 1 ).add( Scale.to( VideoSize.CGA ) ).tag( "d" );
		filters.add( Scale.to( VideoSize.CGA ) ).tag( "d" );
//		filters.add( "settb=AVTB", "setpts=PTS-STARTPTS" ).tag( "0x" );
//		filters.add( Graph.stream( "1" ).add( "settb=AVTB", "setpts=PTS-STARTPTS" ).tag( "1x" ) );
//		filters.add( Graph.stream( "2" ).add( "settb=AVTB", "setpts=PTS-STARTPTS" ).tag( "2x" ) );
//		filters.add( Graph.stream( "0x", "1x" ).add( Xfade.of( Effector.HR_SLICE, 0, 2 ) ).tag( "1v" ) );
//		filters.add( Graph.stream( "1v", "2x" ).add( Xfade.of( Effector.HR_SLICE, 0, 2 ) ).tag( "2x" ) );
//		filters.add( Graph.stream( 0, 1, 2 ).add( Concat.in( 3 ) ) );
//		filters.add( Graph.stream( "0", "1" ).add( Xfade.of( Effector.DISTANCE, 4, 2 ), Amplify.radius( 10 ).factor( 1000 ) ).tag( "1x" ) );
//		filters.add( Graph.stream( "1x", "2" ).add( Xfade.of( Effector.DISTANCE, 9, 2 ) ).tag( "2x" ) );
//		filters.add( Graph.stream( "2x", "3" ).add( AlphaMerge.class ).tag( "3x" ) );
//		filters.add( "scale=iw+50:-1", "crop=iw-50:ih-50:25:25" );
//		filters.add( ChromaHold.the().color( Color.RED ).similarity( 0.5 ).yuv() );
//		filters.add( CodecView.the().mv( MotionVector.BB, MotionVector.PF ) );
//		filters.add( ColorChannelMixer.the().red( .55, .45, .23, .89 ).mode( Mode.AVG ).amount( 0.5 ) );
//		filters.add( Graph.stream( "1" ).add( ColorKey.of( Color.BLACK, 1, .33 ) ).tag( "1x" ) );
//		filters.add( Graph.stream( "1" ).add( ColorLevels.of().mode( ColorMode.LUM ) ).tag( "1x" ) );
//		filters.add( ColorMatrix.define( TargetAtrix.BT2020, TargetAtrix.FCC ) );
//		filters.add( ColorSpace.of().all( ColorProperty.BT709 ) );
//		filters.add( Convolution.define("1 1 1 1 1 1 1 1 1", "1 1 1 1 1 1 1 1 1", "1 1 1 1 1 1 1 1 1", "1 1 1 1 1 1 1 1 1", "1/9", "1/9", "1/9", "1/9" ) );
//		filters.add( CoreImage.of().outputRect( 10, 10, 100, 100 ) );
//		filters.add( CoverRectangle.cover( "F:/videos/poster.png" ) );
//		filters.add( Crop.the( 100, 100, 500, 500 ).keepAspect() );
		filters.add( Scale.to( 400, -1 ) );
//		filters.add( CropDetect.the().limit( 50 ) );
//		filters.add( Eq.of().contrast( 0.5 ).eval( When.FRAME ) );
//		filters.add( Flip.horizontal(), Flip.vertical() );
//		filters.add( Format.of( PixelFormat.GRAY, PixelFormat.YUV420P, PixelFormat.YUV411P, PixelFormat.ZERO_RGB ) );
//		filters.add( FramePack.format( PackFormat.FRAME_SEQ ) );
//		filters.add( FrameStep.of( 0 ) );
//		filters.add( FillBorder.mark( 100 ).mode( BorderMode.FADE ).color( Color.RANDOM ) );
//		filters.add( Pad.of().size( 1920, 1080 ).position( "(ow-iw)/2", "(oh-ih)/2" ).color( Color.BLUE_VIOLET ) );
//		filters.add( Custom.define( "fspp" ).addArg( "quality", 0.5 ).addArg2( "filter_params", "|", "1", "2" ) );
//		filters.add( Stereo3d.of().out( OutputFormat.ABR ).in( InputFormat.AL ) );
//		filters.add( ToneMap.of( Option.CLIP ).peak( 52.5 ).desat( 13.5 ) );
//		filters.add( Graph.append( Declare.the( "test.jpg" ) ).tag( "wm" ) );
//		filters.add( Graph.stream( "in", "wm" ).add( Overlay.at( Overlays.CENTER ), Scale.to( VideoSize.HD720 ) ).tag( "out" ) );
		System.out.println( filters );

//		FFmpegExecutor executor = FFmpegExecutor.build();
//		executor.input( "F:/videos/bin/input.mp4" );
//		executor.filters( filters );
//		executor.to( "F:/videos/bin/output.mp4" );

	}

}
