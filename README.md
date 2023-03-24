# FFMPEG


## 项目简介

FFmpeg 的名称来自 MPEG 视频编码标准，前面的 “FF” 代表 “Fast Forward”，FFmpeg 是一套可以用来记录、转换数字音频、视频，并能将其转化为流的开源计算机程序。可以轻易地实现多种视频格式之间的相互转换。

ffmpeg-helper 在库的基础上将命令行进行了简单封装，从而使得我们将重心转移到 Api 的使用上，而无须关心命令行怎么拼接怎么传递给库的，并带来简便高效的命令扩展方式，以后就可以直接使用而不用去处理麻烦的执行命令了。

*注意：此项目是一款完全开源的项目，您可以在任何适用的场景使用它，商用或者学习都可以，如果您有任何项目上的疑问，可以在issue上提出您问题，我会在第一时间回复您，如果您觉得它对您有些许帮助，希望能留下一个您的星星（★），谢谢。*

------

此项目遵照 [Apache 2.0 License]( http://www.apache.org/licenses/LICENSE-2.0.txt ) 开源许可。



## 快速开始

Maven方式（**推荐**）

```xml
<dependency>
	<groupId>com.viiyue.plugins</groupId>
	<artifactId>ffmpeg-helper</artifactId>
	<version>[VERSION]</version>
</dependency>
```

如果你没有使用Maven构建工具，那么你可以 [点击跳转下载页面](https://search.maven.org/search?q=g:com.viiyue.plugins%20AND%20a:ffmpeg-helper&core=gav)。

如何获取最新版本？[点击这里获取最新版本](https://search.maven.org/search?q=a:ffmpeg-helper)



## 使用方式

准备工作

```java
// 【必要】
// 需要绑定本地 FFmpeg 程序库
// 这一步必须要执行，否则无法正常使用相关 Api（用哪个设置哪个，不一定需要全部设）
Library.FFMPEG.bind( "/<path>/bin/ffmpeg.exe" ); 	-> FFmpegExecutor
Library.FFPROBE.bind( "/<path>/bin/ffprobe.exe" ); 	-> FFprobeExecutor
Library.FFPLAY.bind( "/<path>/ffplay.exe" ); 		-> FFplayExecutor

// 【可选】
// 设置本地日志路径（默认存放于系统临时目录中）
Library.setLogLocation( "D:/dekstop" );
```

命令执行器

```java
// FFmpeg
FFmpegExecutor ffmpeg = FFmpegExecutor.build();
ffmpeg.hideBanner(); // -hide_banner
ffmpeg.logLevel( LogLevel.QUIET ); // -v quite
ffmpeg.codec( "copy" ); // -c [codec]
ffmpeg.xxx(); // -xx [value?]
ffmpeg.cmd( "attr", "没有预设属性时，使用用这个方法" ); // -attr [value?]
ffmpeg.input( "/<path>/xx.mp4", ... ); // 指定输入源
ffmpeg.filters( filters ); // 添加视频效果过滤
ffmpeg.to( "/<path>/out.mp4" ); // 输出到文件

// FFproble
FFprobeExecutor ffprobe = FFprobeExecutor.build();
ffprobe.hideBanner(); // -hide_banner
ffprobe.logLevel( LogLevel.QUIET ); // -v quite
ffprobe.xxx(); // -xx [value?]
ffprobe.cmd( "attr", "没有预设属性时，使用用这个方法" ); // -attr [value?]
ffprobe.input( "/<path>/xx.mp4", ... ); // 指定输入源
String content = ffprobe.to( "[xml|json|ini|flat|scv]" );
String scv = ffprobe.toCSVString();
String json = ffprobe.toJsonString();
String flat = ffprobe.toFlatString();
String ini = ffprobe.toInitring();
Optional<FFprobe> opt = ffprobe.toBean();

// FFplay
HelpExecutor helper = HelpExecutor.ffmpeg();
HelpExecutor helper = HelpExecutor.ffprobe();
HelpExecutor helper = HelpExecutor.ffplay();
helper.hideBanner(); // -hide_banner
helper.logLevel( LogLevel.QUIET ); // -v quite
helper.cmd( "attr", "没有预设属性时，使用用这个方法" ); // -attr [value?]
helper.license();
helper.help();
helper.helpLong();
helper.xxx();
String content = helper.getAndReturn();
```

效果过滤器

```java
// 创建过滤器
Filters filters = Filters.simple(); // -vf
Filters filters = Filters.complex(); // -filter_complex

// 拆分流
filters.split().to( "a", "b", "c", ... ); // split[a][b][c][...]
filters.split( "0:v" ).to( "a", "b", "c", ... ); // [0:v]split[a][b][c]...

// 添加过滤效果
filters.add( ... ); // 默认流
filters.stream( "a" ).add( ... ).tag( "tagA" ); // 指定流
filters.stream( "b" ).add( ... ).tag( "tagB" ); // 指定流
filters.stream( "c" ).add( ... ).tag( "tagC" ); // 指定流
```

直接使用示例

```java
FFmpegExecutor ffmpeg = FFmpegExecutor.build();

// 分离视频流
ffmpeg.input( "input.mp4" ).codec( "v", "copy" ).disableAudio().to( "output.mp4" );
// ffmpeg -i input.mp4 -c:v copy -an output.mp4

// 分离音频流
ffmpeg.input( "input.mp4" ).codec( "a", "copy" ).disableVideo().to( "output.mp4" );
// ffmpeg -i input.mp4 -a:v copy -vn output.mp4

// 视频转码
ffmpeg.input( "input.mp4" )
    .codec( "v", "h264" )
    .size( 352, 278 )
    .disableAudio()
    .format( "m4v" )
    .to( "output.m4v" );
// ffmpeg -i input.mp4 -c:v h264 -s 342x278 -an -f m4v output.m4v

// 合并视频音频
ffmpeg.input( "video.mp4", "audio.mp3" )
    .codec( "v", "copy" )
    .codec( "a", "copy" )
    .to( "output.mp4" );
// ffmpeg –i video.mp4 –i audio.mp3 –c:v copy –c:a copy output.mp4

// 剪切视频
ffmpeg.search( "00:01:30", "00:01:50" ).input( "input.mp4" ).codec( "copy" ).to( "output.mp4" );
// ffmpeg -ss 00:01:30 -to 00:01:50 -i input.mp4 -c copy output.mp4

// 其他更多
ffmpeg.input( "input.mp4" ).xxx().to( "output.mp4" );
// ffmpeg -i input.mp4 ... output.mp4
```

内置过滤器参照：

```java
com.viiyue.ffmpeg.filter.video.*
```




## 关于作者

- 邮箱：tangxbai@hotmail.com
- 掘金： https://juejin.im/user/5da5621ce51d4524f007f35f
- 简书： https://www.jianshu.com/u/e62f4302c51f
- Issuse：https://github.com/tangxbai/ffmpeg-helper/issues
