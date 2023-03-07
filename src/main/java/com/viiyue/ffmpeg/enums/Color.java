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

import org.apache.commons.lang3.ObjectUtils;

import com.viiyue.ffmpeg.common.AbstractEnum;

/**
 * <p>
 * It can be the name of a color as defined below (case insensitive match) or a [0x|#]RRGGBB[AA] sequence,
 * possibly followed by @ and a string representing the alpha component.
 * 
 * <p>
 * The alpha component may be a string composed by "0x" followed by an hexadecimal number or a decimal number
 * between 0.0 and 1.0, which represents the opacity value (‘0x00’ or ‘0.0’ means completely transparent,
 * ‘0xff’ or ‘1.0’ completely opaque). If the alpha component is not specified then ‘0xff’ is assumed.
 * 
 * <p>
 * The string ‘random’ will result in a random color.
 *
 * @author tangxbai
 * @since 2022/07/07
 */
public enum Color implements AbstractEnum {

	/** Random color */
	RANDOM( "random" ),

	/** <span style="padding:10px; background:#F0F8FF">AliceBlue(0xF0F8FF)</span> */
	ALICE_BLUE( "0xF0F8FF", "AliceBlue" ),
	/** <span style="padding:10px; background:#FAEBD7">AntiqueWhite(0xFAEBD7)</span> */
	ANTIQUE_WHITE( "0xFAEBD7", "AntiqueWhite" ),
	/** <span style="padding:10px; background:#00FFFF">Aqua(0x00FFFF)</span> */
	AQUA( "0x00FFFF", "Aqua" ),
	/** <span style="padding:10px; background:#7FFFD4">AquaMarine(0x7FFFD4)</span> */
	AQUA_MARINE( "0x7FFFD4", "AquaMarine" ),
	/** <span style="padding:10px; background:#F0FFFF">Azure(0xF0FFFF)</span> */
	AZURE( "0xF0FFFF", "Azure" ),
	/** <span style="padding:10px; background:#F5F5DC">Beige(0xF5F5DC)</span> */
	BEIGE( "0xF5F5DC", "Beige" ),
	/** <span style="padding:10px; background:#FFE4C4">Bisque(0xFFE4C4)</span> */
	BISQUE( "0xFFE4C4", "Bisque" ),
	/** <span style="padding:10px; background:#000000; color:white">Black(0x000000)</span> */
	BLACK( "0x000000", "Black" ),
	/** <span style="padding:10px; background:#FFEBCD">BlanchedAlmond(0xFFEBCD)</span> */
	BLANCHED_ALMOND( "0xFFEBCD", "BlanchedAlmond" ),
	/** <span style="padding:10px; background:#0000FF; color:white">Blue(0x0000FF)</span> */
	BLUE( "0x0000FF", "Blue" ),
	/** <span style="padding:10px; background:#8A2BE2; color:white">BlueViolet(0x8A2BE2)</span> */
	BLUE_VIOLET( "0x8A2BE2", "BlueViolet" ),
	/** <span style="padding:10px; background:#A52A2A; color:white">Brown(0xA52A2A)</span> */
	BROWN( "0xA52A2A", "Brown" ),
	/** <span style="padding:10px; background:#DEB887">BurlyWood(0xDEB887)</span> */
	BURLY_WOOD( "0xDEB887", "BurlyWood" ),
	/** <span style="padding:10px; background:#5F9EA0; color:white">CadetBlue(0x5F9EA0)</span> */
	CADET_BLUE( "0x5F9EA0", "CadetBlue" ),
	/** <span style="padding:10px; background:#7FFF00">Chartreuse(0x7FFF00)</span> */
	CHARTREUSE( "0x7FFF00", "Chartreuse" ),
	/** <span style="padding:10px; background:#D2691E; color:white">(0xD2691E)</span> */
	CHOCOLATE( "0xD2691E", "Chocolate" ),
	/** <span style="padding:10px; background:#FF7F50; color:white">Coral(0xFF7F50)</span> */
	CORAL( "0xFF7F50", "Coral" ),
	/** <span style="padding:10px; background:#6495ED; color:white">CornflowerBlue(0x6495ED)</span> */
	CORNFLOWER_BLUE( "0x6495ED", "CornflowerBlue" ),
	/** <span style="padding:10px; background:#FFF8DC">Cornsilk(0xFFF8DC)</span> */
	CORNSILK( "0xFFF8DC", "Cornsilk" ),
	/** <span style="padding:10px; background:#DC143C; color:white">Crimson(0xDC143C)</span> */
	CRIMSON( "0xDC143C", "Crimson" ),
	/** <span style="padding:10px; background:#00FFFF">Cyan(0x00FFFF)</span> */
	CYAN( "0x00FFFF", "Cyan" ),
	/** <span style="padding:10px; background:#00008B; color:white">DarkBlue(0x00008B)</span> */
	DARK_BLUE( "0x00008B", "DarkBlue" ),
	/** <span style="padding:10px; background:#008B8B; color:white">DarkCyan(0x008B8B)</span> */
	DARK_CYAN( "0x008B8B", "DarkCyan" ),
	/** <span style="padding:10px; background:#B8860B; color:white">DarkGoldenRod(0xB8860B)</span> */
	DARK_GOLDEN_ROD( "0x008B8B", "DarkGoldenRod" ),
	/** <span style="padding:10px; background:#A9A9A9; color:white">DarkGray(0xA9A9A9)</span> */
	DARK_GRAY( "0xA9A9A9", "DarkGray" ),
	/** <span style="padding:10px; background:#006400; color:white">DarkGreen(0x006400)</span> */
	DARK_GREEN( "0x006400", "DarkGreen" ),
	/** <span style="padding:10px; background:#BDB76B">DarkKhaki(0xBDB76B)</span> */
	DARK_KHAKI( "0xBDB76B", "DarkKhaki" ),
	/** <span style="padding:10px; background:#8B008B; color:white">DarkMagenta(0x8B008B)</span> */
	DARK_MAGENTA( "0xBDB76B", "DarkMagenta" ),
	/** <span style="padding:10px; background:#556B2F; color:white">DarkOliveGreen(0x556B2F)</span> */
	DARK_OLIVE_GREEN( "0x556B2F", "DarkOliveGreen" ),
	/** <span style="padding:10px; background:#FF8C00">DarkOrange(0xFF8C00)</span> */
	DARK_ORANGE( "0xFF8C00", "DarkOrange" ),
	/** <span style="padding:10px; background:#9932CC; color:white">DarkOrchid(0x9932CC)</span> */
	DARK_ORCHID( "0x9932CC", "DarkOrchid" ),
	/** <span style="padding:10px; background:#8B0000; color:white">DarkRed(0x8B0000)</span> */
	DARK_RED( "0x8B0000", "DarkRed" ),
	/** <span style="padding:10px; background:#E9967A">DarkSalmon(0xE9967A)</span> */
	DARK_SALMON( "0xE9967A", "DarkSalmon" ),
	/** <span style="padding:10px; background:#8FBC8F; color:white">DarkSeaGreen(0x8FBC8F)</span> */
	DARK_SEA_GREEN( "0x8FBC8F", "DarkSeaGreen" ),
	/** <span style="padding:10px; background:#483D8B; color:white">DarkSlateBlue(0x483D8B)</span> */
	DARK_SLATE_BLUE( "0x483D8B", "DarkSlateBlue" ),
	/** <span style="padding:10px; background:#2F4F4F; color:white">DarkSlateGray(0x2F4F4F)</span> */
	DARK_SLATE_GRAY( "0x2F4F4F", "DarkSlateGray" ),
	/** <span style="padding:10px; background:#00CED1">DarkTurquoise(0x00CED1)</span> */
	DARK_TURQUOISE( "0x00CED1", "DarkTurquoise" ),
	/** <span style="padding:10px; background:#9400D3; color:white">DarkViolet(0x9400D3)</span> */
	DARK_VIOLET( "0x9400D3", "DarkViolet" ),
	/** <span style="padding:10px; background:#FF1493; color:white">DeepPink(0xFF1493)</span> */
	DEEP_PINK( "0xFF1493", "DeepPink" ),
	/** <span style="padding:10px; background:#00BFFF; color:white">DeepSkyBlue(0x00BFFF)</span> */
	DEEP_SKY_BLUE( "0x00BFFF", "DeepSkyBlue" ),
	/** <span style="padding:10px; background:#696969; color:white">DimGray(0x696969)</span> */
	DIM_GRAY( "0x696969", "DimGray" ),
	/** <span style="padding:10px; background:#1E90FF; color:white">DodgerBlue(0x1E90FF)</span> */
	DODGER_BLUE( "0x1E90FF", "DodgerBlue" ),
	/** <span style="padding:10px; background:#B22222; color:white">FireBrick(0xB22222)</span> */
	FIRE_BRICK( "0xB22222", "FireBrick" ),
	/** <span style="padding:10px; background:#FFFAF0">FloralWhite(0xFFFAF0)</span> */
	FLORAL_WHITE( "0xFFFAF0", "FloralWhite" ),
	/** <span style="padding:10px; background:#228B22; color:white">ForestGreen(0x228B22)</span> */
	FOREST_GREEN( "0x228B22", "ForestGreen" ),
	/** <span style="padding:10px; background:#FF00FF">Fuchsia(0xFF00FF)</span> */
	FUCHSIA( "0xFF00FF", "Fuchsia" ),
	/** <span style="padding:10px; background:#FF00FF">Gainsboro(0xFF00FF)</span> */
	GAINSBORO( "0xFF00FF", "Gainsboro" ),
	/** <span style="padding:10px; background:#F8F8FF">GhostWhite(0xF8F8FF)</span> */
	GHOST_WHITE( "0xF8F8FF", "GhostWhite" ),
	/** <span style="padding:10px; background:#FFD700">Gold(0xFFD700)</span> */
	GOLD( "0xFFD700", "Gold" ),
	/** <span style="padding:10px; background:#DAA520">GoldenRod(0xDAA520)</span> */
	GOLDEN_ROD( "0xDAA520", "GoldenRod" ),
	/** <span style="padding:10px; background:#808080; color:white">Gray(0x808080)</span> */
	GRAY( "0x808080", "Gray" ),
	/** <span style="padding:10px; background:#008000; color:white">Green(0x008000)</span> */
	GREEN( "0x008000", "Green" ),
	/** <span style="padding:10px; background:#ADFF2F">GreenYellow(0xADFF2F)</span> */
	GREEN_YELLOW( "0xADFF2F", "GreenYellow" ),
	/** <span style="padding:10px; background:#F0FFF0">HoneyDew(0xF0FFF0)</span> */
	HONEY_DEW( "0xF0FFF0", "HoneyDew" ),
	/** <span style="padding:10px; background:#FF69B4">HotPink(0xFF69B4)</span> */
	HOT_PINK( "0xFF69B4", "HotPink" ),
	/** <span style="padding:10px; background:#CD5C5C; color:white">IndianRed(0xCD5C5C)</span> */
	INDIAN_RED( "0xCD5C5C", "IndianRed" ),
	/** <span style="padding:10px; background:#4B0082; color:white">Indigo(0x4B0082)</span> */
	INDIGO( "0x4B0082", "Indigo" ),
	/** <span style="padding:10px; background:#FFFFF0">Ivory(0xFFFFF0)</span> */
	IVORY( "0xFFFFF0", "Ivory" ),
	/** <span style="padding:10px; background:#F0E68C">Khaki(0xF0E68C)</span> */
	KHAKI( "0xF0E68C", "Khaki" ),
	/** <span style="padding:10px; background:#E6E6FA">Lavender(0xE6E6FA)</span> */
	LAVENDER( "0xE6E6FA", "Lavender" ),
	/** <span style="padding:10px; background:#FFF0F5">LavenderBlush(0xFFF0F5)</span> */
	LAVENDER_BLUSH( "0xFFF0F5", "LavenderBlush" ),
	/** <span style="padding:10px; background:#7CFC00">LawnGreen(0x7CFC00)</span> */
	LAWN_GREEN( "0x7CFC00", "LawnGreen" ),
	/** <span style="padding:10px; background:#FFFACD">LemonChiffon(0xFFFACD)</span> */
	LEMON_CHIFFON( "0xFFFACD", "LemonChiffon" ),
	/** <span style="padding:10px; background:#ADD8E6">LightBlue(0xADD8E6)</span> */
	LIGHT_BLUE( "0xADD8E6", "LightBlue" ),
	/** <span style="padding:10px; background:#F08080">LightCoral(0xF08080)</span> */
	LIGHT_CORAL( "0xF08080", "LightCoral" ),
	/** <span style="padding:10px; background:#E0FFFF">LightCyan(0xE0FFFF)</span> */
	LIGHT_CYAN( "0xE0FFFF", "LightCyan" ),
	/** <span style="padding:10px; background:#FAFAD2">LightGoldenRodYellow(0xFAFAD2)</span> */
	LIGHT_GOLDEN_ROD_YELLOW( "0xFAFAD2", "LightGoldenRodYellow" ),
	/** <span style="padding:10px; background:#90EE90">LightGreen(0x90EE90)</span> */
	LIGHT_GREEN( "0x90EE90", "LightGreen" ),
	/** <span style="padding:10px; background:#D3D3D3">LightGrey(0xD3D3D3)</span> */
	LIGHT_GREY( "0xD3D3D3", "LightGrey" ),
	/** <span style="padding:10px; background:#FFB6C1">LightPink(0xFFB6C1)</span> */
	LIGHT_PINK( "0xFFB6C1", "LightPink" ),
	/** <span style="padding:10px; background:#FFA07A">LightSalmon(0xFFA07A)</span> */
	LIGHT_SALMON( "0xFFA07A", "LightSalmon" ),
	/** <span style="padding:10px; background:#20B2AA; color:white">LightSeaGreen(0x20B2AA)</span> */
	LIGHT_SEA_GREEN( "0x20B2AA", "LightSeaGreen" ),
	/** <span style="padding:10px; background:#87CEFA">LightSkyBlue(0x87CEFA)</span> */
	LIGHT_SKY_BLUE( "0x87CEFA", "LightSkyBlue" ),
	/** <span style="padding:10px; background:#778899; color:white">LightSlateGray(0x778899)</span> */
	LIGHT_SLATE_GRAY( "0x778899", "LightSlateGray" ),
	/** <span style="padding:10px; background:#B0C4DE">LightSteelBlue(0xB0C4DE)</span> */
	LIGHT_STEEL_BLUE( "0xB0C4DE", "LightSteelBlue" ),
	/** <span style="padding:10px; background:#FFFFE0">LightYellow(0xFFFFE0)</span> */
	LIGHT_YELLOW( "0xFFFFE0", "LightYellow" ),
	/** <span style="padding:10px; background:#00FF00">Lime(0x00FF00)</span> */
	LIME( "0x00FF00", "Lime" ),
	/** <span style="padding:10px; background:#32CD32">LimeGreen(0x32CD32)</span> */
	LIME_GREEN( "0x32CD32", "LimeGreen" ),
	/** <span style="padding:10px; background:#FAF0E6">Linen(0xFAF0E6)</span> */
	LINEN( "0xFAF0E6", "Linen" ),
	/** <span style="padding:10px; background:#FF00FF">Magenta(0xFF00FF)</span> */
	MAGENTA( "0xFF00FF", "Magenta" ),
	/** <span style="padding:10px; background:#800000; color:white">Maroon(0x800000)</span> */
	MAROON( "0xFF00FF", "Maroon" ),
	/** <span style="padding:10px; background:#66CDAA; color:white">MediumAquaMarine(0x66CDAA)</span> */
	MEDIUM_AQUA_MARINE( "0x66CDAA", "MediumAquaMarine" ),
	/** <span style="padding:10px; background:#0000CD; color:white">MediumBlue(0x0000CD)</span> */
	MEDIUM_BLUE( "0x0000CD", "MediumBlue" ),
	/** <span style="padding:10px; background:#BA55D3; color:white">MediumOrchid(0xBA55D3)</span> */
	MEDIUM_ORCHID( "0xBA55D3", "MediumOrchid" ),
	/** <span style="padding:10px; background:#9370D8; color:white">MediumPurple(0x9370D8)</span> */
	MEDIUM_PURPLE( "0x9370D8", "MediumPurple" ),
	/** <span style="padding:10px; background:#3CB371; color:white">MediumSeaGreen(0x3CB371)</span> */
	MEDIUM_SEA_GREEN( "0x3CB371", "MediumSeaGreen" ),
	/** <span style="padding:10px; background:#7B68EE; color:white">MediumSlateBlue(0x7B68EE)</span> */
	MEDIUM_SLATE_BLUE( "0x7B68EE", "MediumSlateBlue" ),
	/** <span style="padding:10px; background:#00FA9A">MediumSpringGreen(0x00FA9A)</span> */
	MEDIUM_SPRING_GREEN( "0x00FA9A", "MediumSpringGreen" ),
	/** <span style="padding:10px; background:#48D1CC">MediumTurquoise(0x48D1CC)</span> */
	MEDIUM_TURQUOISE( "0x48D1CC", "MediumTurquoise" ),
	/** <span style="padding:10px; background:#C71585; color:white">MediumVioletRed(0xC71585)</span> */
	MEDIUM_VIOLET_RED( "0xC71585", "MediumVioletRed" ),
	/** <span style="padding:10px; background:#191970; color:white">MidnightBlue(0x191970)</span> */
	MIDNIGHT_BLUE( "0x191970", "MidnightBlue" ),
	/** <span style="padding:10px; background:#F5FFFA">MintCream(0xF5FFFA)</span> */
	MINT_CREAM( "0xF5FFFA", "MintCream" ),
	/** <span style="padding:10px; background:#FFE4E1">MistyRose(0xFFE4E1)</span> */
	MISTY_ROSE( "0xFFE4E1", "MistyRose" ),
	/** <span style="padding:10px; background:#FFE4B5">Moccasin(0xFFE4B5)</span> */
	MOCCASIN( "0xFFE4B5", "Moccasin" ),
	/** <span style="padding:10px; background:#FFDEAD">NavajoWhite(0xFFDEAD)</span> */
	NAVAJO_WHITE( "0xFFDEAD", "NavajoWhite" ),
	/** <span style="padding:10px; background:#000080; color:white">Navy(0x000080)</span> */
	NAVY( "0x000080", "Navy" ),
	/** <span style="padding:10px; background:#FDF5E6">OldLace(0xFDF5E6)</span> */
	OLD_LACE( "0xFDF5E6", "OldLace" ),
	/** <span style="padding:10px; background:#808000; color:white">Olive(0x808000)</span> */
	OLIVE( "0x808000", "Olive" ),
	/** <span style="padding:10px; background:#6B8E23; color:white">OliveDrab(0x6B8E23)</span> */
	OLIVE_DRAB( "0x6B8E23", "OliveDrab" ),
	/** <span style="padding:10px; background:#FFA500">Orange(0xFFA500)</span> */
	ORANGE( "0xFFA500", "Orange" ),
	/** <span style="padding:10px; background:#FF4500">OrangeRed(0xFF4500)</span> */
	ORANGERED( "0xFF4500", "OrangeRed" ),
	/** <span style="padding:10px; background:#DA70D6">Orchid(0xDA70D6)</span> */
	ORCHID( "0xDA70D6", "Orchid" ),
	/** <span style="padding:10px; background:#EEE8AA">PaleGoldenRod(0xEEE8AA)</span> */
	PALE_GOLDEN_ROD( "0xEEE8AA", "PaleGoldenRod" ),
	/** <span style="padding:10px; background:#98FB98">PaleGreen(0x98FB98)</span> */
	PALE_GREEN( "0x98FB98", "PaleGreen" ),
	/** <span style="padding:10px; background:#AFEEEE">PaleTurquoise(0xAFEEEE)</span> */
	PALE_TURQUOISE( "0xAFEEEE", "PaleTurquoise" ),
	/** <span style="padding:10px; background:#D87093; color:white">PaleVioletRed(0xD87093)</span> */
	PALE_VIOLET_RED( "0xD87093", "PaleVioletRed" ),
	/** <span style="padding:10px; background:#FFEFD5">PapayaWhip(0xFFEFD5)</span> */
	PAPAYA_WHIP( "0xFFEFD5", "PapayaWhip" ),
	/** <span style="padding:10px; background:#FFDAB9">PeachPuff(0xFFDAB9)</span> */
	PEACH_PUFF( "0xFFDAB9", "PeachPuff" ),
	/** <span style="padding:10px; background:#CD853F">Peru(0xCD853F)</span> */
	PERU( "0xCD853F", "Peru" ),
	/** <span style="padding:10px; background:#FFC0CB">Pink(0xFFC0CB)</span> */
	PINK( "0xFFC0CB", "Pink" ),
	/** <span style="padding:10px; background:#DDA0DD">Plum(0xDDA0DD)</span> */
	PLUM( "0xDDA0DD", "Plum" ),
	/** <span style="padding:10px; background:#B0E0E6">PowderBlue(0xB0E0E6)</span> */
	POWDER_BLUE( "0xB0E0E6", "PowderBlue" ),
	/** <span style="padding:10px; background:#800080; color:white">Purple(0x800080)</span> */
	PURPLE( "0x800080", "Purple" ),
	/** <span style="padding:10px; background:#FF0000">Red(0xFF0000)</span> */
	RED( "0xFF0000", "Red" ),
	/** <span style="padding:10px; background:#BC8F8F; color:white">RosyBrown(0xBC8F8F)</span> */
	ROSY_BROWN( "0xBC8F8F", "RosyBrown" ),
	/** <span style="padding:10px; background:#4169E1; color:white">RoyalBlue(0x4169E1)</span> */
	ROYAL_BLUE( "0x4169E1", "RoyalBlue" ),
	/** <span style="padding:10px; background:#8B4513; color:white">SaddleBrown(0x8B4513)</span> */
	SADDLE_BROWN( "0x8B4513", "SaddleBrown" ),
	/** <span style="padding:10px; background:#FA8072">Salmon(0xFA8072)</span> */
	SALMON( "0xFA8072", "Salmon" ),
	/** <span style="padding:10px; background:#F4A460">SandyBrown(0xF4A460)</span> */
	SANDY_BROWN( "0xF4A460", "SandyBrown" ),
	/** <span style="padding:10px; background:#2E8B57; color:white">SeaGreen(0x2E8B57)</span> */
	SEA_GREEN( "0x2E8B57", "" ),
	/** <span style="padding:10px; background:#FFF5EE">SeaShell(0xFFF5EE)</span> */
	SEA_SHELL( "0xFFF5EE", "SeaShell" ),
	/** <span style="padding:10px; background:#A0522D; color:white">Sienna(0xA0522D)</span> */
	SIENNA( "0xA0522D", "Sienna" ),
	/** <span style="padding:10px; background:#C0C0C0">Silver(0xC0C0C0)</span> */
	SILVER( "0xC0C0C0", "Silver" ),
	/** <span style="padding:10px; background:#87CEEB">SkyBlue(0x87CEEB)</span> */
	SKY_BLUE( "0x87CEEB", "SkyBlue" ),
	/** <span style="padding:10px; background:#6A5ACD; color:white">SlateBlue(0x6A5ACD)</span> */
	SLATE_BLUE( "0x6A5ACD", "SlateBlue" ),
	/** <span style="padding:10px; background:#708090; color:white">SlateGray(0x708090)</span> */
	SLATE_GRAY( "0x708090", "SlateGray" ),
	/** <span style="padding:10px; background:#FFFAFA">Snow(0xFFFAFA)</span> */
	SNOW( "0xFFFAFA", "Snow" ),
	/** <span style="padding:10px; background:#00FF7F">SpringGreen(0x00FF7F)</span> */
	SPRING_GREEN( "0x00FF7F", "SpringGreen" ),
	/** <span style="padding:10px; background:#4682B4; color:white">SteelBlue(0x4682B4)</span> */
	STEEL_BLUE( "0x4682B4", "SteelBlue" ),
	/** <span style="padding:10px; background:#D2B48C">Tan(0xD2B48C)</span> */
	TAN( "0xD2B48C", "Tan" ),
	/** <span style="padding:10px; background:#008080; color:white">Teal(0x008080)</span> */
	TEAL( "0x008080", "Teal" ),
	/** <span style="padding:10px; background:#D8BFD8">Thistle(0xD8BFD8)</span> */
	THISTLE( "0xD8BFD8", "Thistle" ),
	/** <span style="padding:10px; background:#FF6347">Tomato(0xFF6347)</span> */
	TOMATO( "0xFF6347", "Tomato" ),
	/** <span style="padding:10px; background:#40E0D0">Turquoise(0x40E0D0)</span> */
	TURQUOISE( "0x40E0D0", "Turquoise" ),
	/** <span style="padding:10px; background:#EE82EE">Violet(0xEE82EE)</span> */
	VIOLET( "0xEE82EE", "Violet" ),
	/** <span style="padding:10px; background:#F5DEB3">Wheat(0xF5DEB3)</span> */
	WHEAT( "0xF5DEB3", "Wheat" ),
	/** <span style="padding:10px; background:#FFFFFF">White(0xFFFFFF)</span> */
	WHITE( "0xFFFFFF", "White" ),
	/** <span style="padding:10px; background:#F5F5F5">WhiteSmoke(0xF5F5F5)</span> */
	WHITE_SMOKE( "0xF5F5F5", "WhiteSmoke" ),
	/** <span style="padding:10px; background:#FFFF00">Yellow(0xFFFF00)</span> */
	YELLOW( "0xFFFF00", "Yellow" ),
	/** <span style="padding:10px; background:#9ACD32">YellowGreen(0x9ACD32)</span> */
	YELLOW_GREEN( "0x9ACD32", "YellowGreen" );

	private String color;
	private String colorName;

	private Color( String expression ) {
		this( expression, null );
	}

	private Color( String expression, String colorName ) {
		this.color = expression;
		this.colorName = colorName;
	}

	public String getValue() {
		return this.color;
	}

	public String getHexValue() {
		return this.color.replace( "0x", "#" );
	}

	@Override
	public String command() {
		return ObjectUtils.defaultIfNull( this.colorName, this.color );
	}

	public static final Color nullable( Color color ) {
		return color == null ? Color.RANDOM : color;
	}

}
