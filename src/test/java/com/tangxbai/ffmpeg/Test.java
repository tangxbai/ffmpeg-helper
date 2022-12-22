package com.tangxbai.ffmpeg;

import com.viiyue.ffmpeg.FFSamples;
import com.viiyue.ffmpeg.enums.Overlays;
import com.viiyue.ffmpeg.enums.VideoSize;
import com.viiyue.ffmpeg.filter.Filters;
import com.viiyue.ffmpeg.filter.Graph;
import com.viiyue.ffmpeg.filter.video.Declare;
import com.viiyue.ffmpeg.filter.video.Overlay;
import com.viiyue.ffmpeg.filter.video.Scale;

public class Test {

	public static void main( String [] args ) {

		FFSamples.init( "E:/Ffmpeg-full-build/bin", "F:/desktop" );
//		FFSamples.init( "C:/Users/admin/.javacpp/cache/ffmpeg-5.0-1.5.7-windows-x86_64.jar/org/bytedeco/ffmpeg/windows-x86_64", "F:/desktop" );
//		FFSamples.readVideoInfo( "F:/videos/bin/input.mp4" );
//		FFSamples.readVideoInfo( "F:/videos/bin/demo.mp4" );

		Filters filters = Filters.complex();
//		filters.graph( Graph.stream( "0" ).add( "settb=AVTB", "setpts=PTS-STARTPTS" ).to( "0x" ) );
//		filters.graph( Graph.stream( "1" ).add( "settb=AVTB", "setpts=PTS-STARTPTS" ).to( "1x" ) );
//		filters.graph( Graph.stream( "2" ).add( "settb=AVTB", "setpts=PTS-STARTPTS" ).to( "2x" ) );
//		filters.graph( Graph.stream( "0x", "1x" ).add( Xfade.of( Effector.HR_SLICE, 0, 2 ) ).to( "1v" ) );
//		filters.graph( Graph.stream( "1v", "2x" ).add( Xfade.of( Effector.HR_SLICE, 0, 2 ) ).to( "2x" ) );
//		filters.graph( Graph.stream( 0, 1, 2 ).add( Concat.in( 3 ) ) );
//		filters.graph( Graph.stream( "0", "1" ).add( Xfade.of( Effector.DISTANCE, 4, 2 ), Amplify.radius( 10 ).factor( 1000 ) ).to( "1x" ) );
//		filters.graph( Graph.stream( "1x", "2" ).add( Xfade.of( Effector.DISTANCE, 9, 2 ) ).to( "2x" ) );
//		filters.graph( Graph.stream( "2x", "3" ).add( AlphaMerge.class ).to( "3x" ) );
//		filters.graph( "scale=iw+50:-1", "crop=iw-50:ih-50:25:25" );
//		filters.graph( ChromaHold.the().color( Color.RED ).similarity( 0.5 ).yuv() );
//		filters.graph( CodecView.the().mv( MotionVector.BB, MotionVector.PF ) );
//		filters.graph( ColorChannelMixer.the().red( .55, .45, .23, .89 ).mode( Mode.AVG ).amount( 0.5 ) );
//		filters.graph( Graph.stream( "1" ).add( ColorKey.of( Color.BLACK, 1, .33 ) ).to( "1x" ) );
//		filters.graph( Graph.stream( "1" ).add( ColorLevels.of().mode( ColorMode.LUM ) ).to( "1x" ) );
//		filters.graph( ColorMatrix.define( TargetAtrix.BT2020, TargetAtrix.FCC ) );
//		filters.graph( ColorSpace.of().all( ColorProperty.BT709 ) );
//		filters.graph( Convolution.define("1 1 1 1 1 1 1 1 1", "1 1 1 1 1 1 1 1 1", "1 1 1 1 1 1 1 1 1", "1 1 1 1 1 1 1 1 1", "1/9", "1/9", "1/9", "1/9" ) );
//		filters.graph( CoreImage.of().outputRect( 10, 10, 100, 100 ) );
//		filters.graph( CoverRectangle.cover( "F:/videos/poster.png" ) );
//		filters.graph( Crop.the( 100, 100, 500, 500 ).keepAspect() );
//		filters.graph( CropDetect.the().limit( 50 ) );
//		filters.graph( Eq.of().contrast( 0.5 ).eval( When.FRAME ) );
//		filters.graph( Flip.horizontal(), Flip.vertical() );
//		filters.graph( Format.of( PixelFormat.GRAY, PixelFormat.YUV420P, PixelFormat.YUV411P, PixelFormat.ZERO_RGB ) );
//		filters.graph( FramePack.format( PackFormat.FRAME_SEQ ) );
//		filters.graph( FrameStep.of( 0 ) );
//		filters.graph( FillBorder.mark( 100 ).mode( BorderMode.FADE ).color( Color.RANDOM ) );
//		filters.graph( Pad.of().size( 1920, 1080 ).position( "(ow-iw)/2", "(oh-ih)/2" ).color( Color.BLUE_VIOLET ) );
//		filters.graph( Custom.define( "fspp" ).addArg( "quality", 0.5 ).addArg2( "filter_params", "|", "1", "2" ) );
//		filters.graph( Stereo3d.of().out( OutputFormat.ABR ).in( InputFormat.AL ) );
//		filters.graph( ToneMap.of( Option.CLIP ).peak( 52.5 ).desat( 13.5 ) );
		filters.graph( Graph.append( Declare.the().movie( "test.jpg" ) ).to( "wm" ) );
		filters.graph( Graph.stream( "in", "wm" ).add( Overlay.at( Overlays.CENTER ), Scale.to( VideoSize.HD720 ) ).to( "out" ) );
		System.out.println( filters );

//		FFmpegExecutor executor = FFmpegExecutor.build();
//		executor.input( "F:/videos/bin/input.mp4" );
//		executor.filters( filters );
//		executor.to( "F:/videos/bin/output.mp4" );

	}

}
