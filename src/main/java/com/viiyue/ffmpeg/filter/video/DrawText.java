package com.viiyue.ffmpeg.filter.video;

import com.viiyue.ffmpeg.annotation.Function;
import com.viiyue.ffmpeg.common.AbstractEnum;
import com.viiyue.ffmpeg.enums.Color;
import com.viiyue.ffmpeg.filter.AbstractFunction;
import com.viiyue.ffmpeg.util.Helper;

/**
 * <p>
 * Draw a text string or text from a specified file on top of a video, using the libfreetype library.
 *
 * <p>
 * To enable compilation of this filter, you need to configure FFmpeg with {@code --enable-libfreetype}. To
 * enable default font fallback and the font option you need to configure FFmpeg with
 * {@code --enable-libfontconfig}. To enable the text_shaping option, you need to configure FFmpeg with
 * {@code --enable-libfribidi}.
 * 
 * <p>
 * The parameters for {@code x} and {@code y} are expressions containing the following constants and
 * functions:
 * 
 * <ul>
 * <li><b>dar</b> - input display aspect ratio, it is the same as (w / h) * sar.
 * <li><b>sar</b> - The input sample aspect ratio
 * <li><b>hsub</b>,<b>vsub</b> - horizontal and vertical chroma subsample values. For example for the pixel
 * format "yuv422p" hsub is 2 and vsub is 1.
 * <li><b>line_h</b>(lh) - the height of each text line
 * <li><b>main_h</b>(h, H) - the input height
 * <li><b>main_w</b>(w, W) - the input width
 * <li><b>max_glyph_a</b>(ascent) - the maximum distance from the baseline to the highest/upper grid
 * coordinate used to place a glyph outline point, for all the rendered glyphs. It is a positive value, due to
 * the grid’s orientation with the Y axis upwards.
 * <li><b>max_glyph_d</b>(descent) - the maximum distance from the baseline to the lowest grid coordinate used
 * to place a glyph outline point, for all the rendered glyphs. This is a negative value, due to the grid’s
 * orientation, with the Y axis upwards.
 * <li><b>max_glyph_h</b> - maximum glyph height, that is the maximum height for all the glyphs contained in
 * the rendered text, it is equivalent to ascent - descent.
 * <li><b>max_glyph_w</b> - maximum glyph width, that is the maximum width for all the glyphs contained in the
 * rendered text
 * <li><b>n</b> - the number of input frame, starting from 0
 * <li><b>rand(min, max)</b> - return a random number included between min and max
 * <li><b>t</b> - timestamp expressed in seconds, NAN if the input timestamp is unknown
 * <li><b>text_h</b>(th) - the height of the rendered text
 * <li><b>text_w</b>(tw) - the width of the rendered text
 * </ul>
 *
 * @author tangxbai
 * @since 2022/06/28
 */
@Function( "drawtext" )
public class DrawText extends AbstractFunction<DrawText> {

	// Don't let anyone instantiate this class
	private DrawText() {}

	/**
	 * Quickly create an instances of {@link DrawBox}
	 * 
	 * @return the {@link DrawGrid} instance
	 */
	public static final DrawText of() {
		return new DrawText();
	}

	/**
	 * The text string to be drawn. The text must be a sequence of UTF-8 encoded characters. This parameter is
	 * mandatory if no file is specified with the parameter textfile. <font color="red">If both <b>text</b>
	 * and <b>textfile</b> are specified, an error is thrown</font>.
	 * 
	 * @apiNote (string) text
	 * @param text the text content
	 * @return the {@link DrawText} instance
	 */
	public DrawText text( String text ) {
		return super.addArg( "text", Helper.escape( text ) );
	}

	/**
	 * A text file containing text to be drawn. The text must be a sequence of UTF-8 encoded characters. This
	 * parameter is mandatory if no text string is specified with the parameter text. <font color="red">If
	 * both <b>text</b> and <b>textfile</b> are specified, an error is thrown</font>.
	 * 
	 * @apiNote (string) textfile
	 * @param text the text content
	 * @return the {@link DrawText} instance
	 */
	public DrawText textFile( String filePath ) {
		return super.addArg( "textfile", Helper.escape( filePath, true ) );
	}

	/**
	 * If set to {@code true}, attempt to shape the text (for example, reverse the order of right-to-left text
	 * and join Arabic characters) before drawing it. Otherwise, just draw the text exactly as given. By
	 * default {@code true} (if supported).
	 * 
	 * @apiNote (boolean) text_shaping
	 * @return the {@link DrawText} instance
	 */
	public DrawText textShaping() {
		return super.enable( "text_shaping" );
	}

	/**
	 * A text file containing text to be drawn. The text must be a sequence of UTF-8 encoded characters.
	 * 
	 * @apiNote (string) fontfile
	 * @param fontPath the text font file path
	 * @return the {@link DrawText} instance
	 */
	public DrawText font( String fontPath ) {
		return super.addArg( "fontfile", Helper.escape( fontPath, true ) );
	}

	/**
	 * The font size to be used for drawing text. The default value of font size is 16.
	 * 
	 * @apiNote (int) fontsize
	 * @param fontSize the text font size
	 * @return the {@link DrawText} instance
	 */
	public DrawText fontSize( int fontSize ) {
		return super.addArg( "fontsize", fontSize );
	}

	/**
	 * The color to be used for drawing fonts. For the syntax of this option, check the (ffmpeg-utils) "Color"
	 * section in the ffmpeg-utils manual.
	 * 
	 * @apiNote (color) fontcolor
	 * @param color the java {@link Color} value
	 * @return the {@link DrawText} instance
	 */
	public DrawText fontColor( Color color ) {
		return fontColor( Color.ifEmpty( color ).command() );
	}

	/**
	 * The color to be used for drawing fonts. For the syntax of this option, check the
	 * <font color="green">(ffmpeg-utils) "Color" section in the ffmpeg-utils manual</font>.
	 * 
	 * @apiNote (string) fontcolor
	 * @param color the hex color value
	 * @return the {@link DrawText} instance
	 */
	public DrawText fontColor( String color ) {
		return super.addArg( "fontcolor", color );
	}

	/**
	 * String which is expanded the same way as text to obtain dynamic fontcolor value. By default this option
	 * has empty value and is not processed. When this option is set, it overrides fontcolor option.
	 * 
	 * @apiNote (string) fontcolor_expr
	 * @param expression the hex color expression
	 * @return the {@link DrawText} instance
	 */
	public DrawText fontColorExpr( String expression ) {
		return super.addArg( "fontcolor_expr", Helper.escape( expression ) );
	}

	/**
	 * Set text style
	 * 
	 * @param fontPath the text font file path
	 * @param fontSize the text font size
	 * @param color    the hex color
	 * @return the {@link DrawText} instance
	 */
	public DrawText fonts( String fontPath, int fontSize, String color ) {
		return font( fontPath ).fontColor( color ).fontSize( fontSize );
	}

	/**
	 * Set the line spacing in pixels of the border to be drawn around the box using box. The default value of
	 * line_spacing is 0.
	 * 
	 * @apiNote (int) line_spacing
	 * @param spacing the text spacing
	 * @return the {@link DrawText} instance
	 */
	public DrawText lineSpacing( int spacing ) {
		return super.addArg( "line_spacing", spacing );
	}

	/**
	 * Set the text position
	 * 
	 * @apiNote (int) x/y
	 * @param x the left offset
	 * @param y the top offset
	 * @return the {@link DrawText} instance
	 */
	public DrawText position( int x, int y ) {
		return super.addArg( "x", x ).addArg( "y", y );
	}

	/**
	 * Draw the text applying alpha blending. The value can be a number between 0.0 and 1.0. The expression
	 * accepts the same variables x, y as well. The default value is <b>1</b>. Please see fontcolor_expr.
	 * 
	 * @apiNote (double) alpha
	 * @param alpha the text alpha value
	 * @return the {@link DrawText} instance
	 * @see #fontColorExpr(String)
	 */
	public DrawText alpha( double alpha ) {
		return super.addArg( "alpha", alpha );
	}

	/**
	 * Used to draw a box around text using the background color. The value must be either {@code true}
	 * (enable) or {@code false} (disable). The default value of box is {@code false}.
	 * 
	 * @apiNote (boolean) box
	 * @return the {@link DrawText} instance
	 */
	public DrawText box() {
		return super.enable( "box" );
	}

	/**
	 * Set the width of the border to be drawn around the box using {@code boxcolor}. The default value of
	 * {@code boxborderw} is <b>0</b>.
	 * 
	 * @apiNote (int) boxborderw
	 * @param width the order width
	 * @return the {@link DrawText} instance
	 */
	public DrawText boxBorderWidth( int width ) {
		return super.addArg( "boxborderw", width );
	}

	/**
	 * <p>
	 * The color to be used for drawing box around text. For the syntax of this option, check the
	 * <font color="green">(ffmpeg-utils)"Color" section in the ffmpeg-utils manual</font>. The default value
	 * of boxcolor is "<b>white</b>".
	 * 
	 * <p>
	 * The default value of <{@code boxcolor} is "white".
	 * 
	 * @apiNote (string) boxcolor
	 * @param width the order color
	 * @return the {@link DrawText} instance
	 */
	public DrawText boxColor( String color ) {
		return super.addArg( "boxcolor", color );
	}

	/**
	 * The color to be used for drawing box around text. For the syntax of this option, check the
	 * <font color="green">(ffmpeg-utils)"Color" section in the ffmpeg-utils manual</font>.
	 * 
	 * @apiNote (color) boxcolor
	 * @param width the order color
	 * @return the {@link DrawText} instance
	 */
	public DrawText boxColor( Color color ) {
		return boxColor( Color.ifEmpty( color ).command() );
	}

	/**
	 * Set the width of the border to be drawn around the text using bordercolor. The default value of borderw
	 * is <b>0</b>.
	 * 
	 * @apiNote (int) borderw
	 * @param borderw the order width
	 * @return the {@link DrawText} instance
	 */
	public DrawText borderWidth( int borderWdith ) {
		return super.addArg( "borderw", borderWdith );
	}

	/**
	 * <p>
	 * Set the color to be used for drawing border around text. For the syntax of this option, check the
	 * <font color="green">(ffmpeg-utils)"Color" section in the ffmpeg-utils manual</font>.
	 * 
	 * <p>
	 * The default value of bordercolor is "black"( <font color="black">■</font> ).
	 * 
	 * @apiNote (string) bordercolor
	 * @param borderw the order color
	 * @return the {@link DrawText} instance
	 */
	public DrawText borderColor( String color ) {
		return super.addArg( "bordercolor", color );
	}

	/**
	 * Select how the text is expanded. Can be either {@link Expansion#NONE}, {@link Expansion#STRFTIME}
	 * (<s>deprecated</s>) or {@link Expansion#NORMAL} (default)
	 * 
	 * @apiNote (flags) expansion
	 * @param borderw the order color
	 * @return the {@link DrawText} instance
	 * @see Expansion
	 */
	public DrawText expansion( Expansion expansion ) {
		return super.addArg( "expansion", expansion );
	}

	/**
	 * The color to be used for drawing a shadow behind the drawn text. For the syntax of this option, check
	 * the <font color="green">(ffmpeg-utils)"Color" section in the ffmpeg-utils manual</font>.
	 * 
	 * @apiNote (color) shadowcolor
	 * @apiNote (int) x/y
	 * @param color the shadow color
	 * @param x     the shadow x
	 * @param y     the shadow y
	 * @return the {@link DrawText} instance
	 */
	public DrawText shadow( String color, int x, int y ) {
		return super.addArg( "shadowcolor", color ).addArg( "shadowx", x ).addArg( "shadowy", y );
	}

	/**
	 * Set a start time for the count. Value is in <b>microseconds</b>. Only applied in the deprecated
	 * strftime expansion mode. To emulate in normal expansion mode use the {@code pts} function, supplying
	 * the start time (in seconds) as the second argument.
	 * 
	 * @apiNote (long) base_time
	 * @param baseTime the start time
	 * @return the {@link DrawText} instance
	 */
	public DrawText baseTime( long baseTime ) {
		return super.addArg( "base_time", baseTime );
	}

	/**
	 * Set the initial timecode representation in "hh:mm:ss[:;.]ff" format. It can be used with or without
	 * text parameter. timecode_rate option must be specified.
	 * 
	 * @apiNote (string) timecode
	 * @param timeCode the time code expression( hh:mm:ss[:;.]ff )
	 * @return the {@link DrawText} instance
	 */
	public DrawText timeCode( String timeCode ) {
		return super.addArg( "timecode", Helper.escape( timeCode, true ) );
	}

	/**
	 * If enable this, the output of the {@code timecode} option will wrap around at 24 hours. Default is
	 * {@code false} (disabled).
	 * 
	 * @apiNote (boolean) tc24hmax
	 * @return the {@link DrawText} instance
	 */
	public DrawText tc24hmax() {
		return super.enable( "tc24hmax" );
	}

	/**
	 * Set the {@code timecode} frame rate ({@code timecode} only). Value will be rounded to nearest integer.
	 * Minimum value is "1". Drop-frame timecode is supported for frame rates 30 & 60.
	 * 
	 * @apiNote (int) timecode_rate, rate, r
	 * @param value the timecode frame rate
	 * @return the {@link DrawText} instance
	 */
	public DrawText rate( int value ) {
		return super.addArg( "r", value ); // timecode_rate, rate, r
	}

	/**
	 * check and fix text coords to avoid clipping. Default is {@code false}.
	 * 
	 * @apiNote (boolean) fix_bounds
	 * @return the {@link DrawText} instance
	 */
	public DrawText fixBounds() {
		return super.enable( "fix_bounds" );
	}

	/**
	 * The size in number of spaces to use for rendering the tab. Default value is <b>4</b>.
	 * 
	 * @apiNote (int) tabsize
	 * @param value the tab size of spaces
	 * @return the {@link DrawText} instance
	 */
	public DrawText tabSize( int value ) {
		return super.addArg( "tabsize", value );
	}

	/**
	 * The flags to be used for loading the fonts, default value is {@link LoadFlag#DEFAULT DEFAULT}.
	 * 
	 * @apiNote (flags) ft_load_flags
	 * @param flags the font load flags
	 * @return the {@link DrawText} instance
	 */
	public DrawText flags( LoadFlag ... flags ) {
		return super.addArg( "ft_load_flags", flags );
	}

	/**
	 * The starting frame number for the n/frame_num variable. The default value is <b>0</b>.
	 * 
	 * @apiNote (int) start_number
	 * @param value the starting frame number
	 * @return the {@link DrawText} instance
	 */
	public DrawText startNumber( int value ) {
		return super.addArg( "start_number", value );
	}

	/**
	 * The textfile will be reloaded at specified frame interval. Be sure to update textfile atomically, or it
	 * may be read partially, or even fail. Range is 0 to INT_MAX. Default is 0.
	 * 
	 * @apiNote (int) reload
	 * @param interval the reloaded frame interval
	 * @return the {@link DrawText} instance
	 */
	public DrawText reload( int interval ) {
		return super.addArg( "reload", interval );
	}

	/**
	 * Expansion mode, including: {@link #NONE}, {@link #NORMAL}, {@link #STRFTIME}(deprecated)
	 *
	 * @author tangxbai
	 * @since 2022/06/28
	 */
	public enum Expansion implements AbstractEnum {
		NONE, NORMAL, STRFTIME
	}

	/**
	 * Flag for loading fonts
	 *
	 * @author tangxbai
	 * @since 2022/06/28
	 */
	public enum LoadFlag implements AbstractEnum {
		DEFAULT, NO_SCALE, NO_HINTING, RENDER, NO_BITMAP, VERTICAL_LAYOUT, FORCE_AUTOHINT, CROP_BITMAP, PEDANTIC,
		IGNORE_GLOBAL_ADVANCE_WIDTH, NO_RECURSE, IGNORE_TRANSFORM, MONOCHROME, LINEAR_DESIGN, NO_AUTOHINT
	}

}
