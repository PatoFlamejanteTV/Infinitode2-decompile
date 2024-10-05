/*     */ package com.vladsch.flexmark.util.html.ui;
/*     */ 
/*     */ import com.vladsch.flexmark.util.sequence.SequenceUtils;
/*     */ import java.awt.Color;
/*     */ import java.util.HashMap;
/*     */ import java.util.Locale;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class ColorStyler
/*     */   extends HtmlStylerBase<Color>
/*     */ {
/*     */   public String getStyle(Color paramColor) {
/*  30 */     if (paramColor instanceof BackgroundColor) return String.format("background-color:#%s", new Object[] { getColorValue(paramColor) }); 
/*  31 */     return (paramColor == null) ? "" : String.format("color:#%s", new Object[] { getColorValue(paramColor) });
/*     */   }
/*     */   
/*     */   public static Color getNamedColor(String paramString) {
/*  35 */     if (paramString.startsWith("#")) {
/*     */       String str1, str2, str3;
/*     */       Integer integer1;
/*  38 */       if ((integer1 = SequenceUtils.parseIntOrNull(paramString.substring(1), 16)) == null) return null; 
/*  39 */       paramString = paramString.substring(1);
/*     */ 
/*     */ 
/*     */       
/*  43 */       String str4 = "";
/*     */       
/*  45 */       switch (paramString.length()) {
/*     */         case 3:
/*  47 */           str1 = paramString.substring(0, 1);
/*  48 */           str2 = paramString.substring(1, 2);
/*  49 */           str3 = paramString.substring(2, 3);
/*     */           break;
/*     */         
/*     */         case 4:
/*  53 */           str1 = paramString.substring(0, 1);
/*  54 */           str2 = paramString.substring(1, 2);
/*  55 */           str3 = paramString.substring(2, 3);
/*  56 */           str4 = paramString.substring(3, 4);
/*     */           break;
/*     */         
/*     */         case 6:
/*  60 */           str1 = paramString.substring(0, 2);
/*  61 */           str2 = paramString.substring(2, 4);
/*  62 */           str3 = paramString.substring(4, 6);
/*     */           break;
/*     */         
/*     */         case 8:
/*  66 */           str1 = paramString.substring(0, 2);
/*  67 */           str2 = paramString.substring(2, 4);
/*  68 */           paramString.substring(4, 6);
/*  69 */           str3 = paramString.substring(6, 8);
/*     */           break;
/*     */         
/*     */         default:
/*  73 */           return null;
/*     */       } 
/*     */       
/*  76 */       if (str1.length() == 1) str1 = str1 + str1; 
/*  77 */       if (str2.length() == 1) str2 = str2 + str2; 
/*  78 */       if (str3.length() == 1) str3 = str3 + str3; 
/*  79 */       if (str4.length() == 1) str4 = str4 + str4;
/*     */       
/*  81 */       if (str4.isEmpty()) {
/*  82 */         str4 = "ff";
/*     */       }
/*     */       
/*  85 */       return new Color(parse(str1), parse(str2), parse(str3), parse(str4));
/*     */     } 
/*     */     
/*     */     Integer integer;
/*  89 */     return ((integer = nameColorMap.get(paramString)) == null) ? null : new Color(integer.intValue());
/*     */   }
/*     */   
/*     */   static int parse(String paramString) {
/*  93 */     return Integer.parseInt(paramString, 16);
/*     */   }
/*     */   
/*     */   public static String getColorName(Color paramColor) {
/*  97 */     return (paramColor != null) ? colorNameMap.get(Integer.valueOf(paramColor.getRGB() & 0xFFFFFF)) : null;
/*     */   }
/*     */   
/*     */   public static String getColorValue(Color paramColor) {
/* 101 */     return (paramColor == null) ? "" : ((paramColor.getAlpha() != 255) ? String.format(Locale.US, "rgba(%d,%d,%d,%d)", new Object[] { Integer.valueOf(paramColor.getRed()), Integer.valueOf(paramColor.getGreen()), Integer.valueOf(paramColor.getBlue()), Integer.valueOf(paramColor.getAlpha())
/* 102 */         }) : String.format(Locale.US, "%02x%02x%02x", new Object[] { Integer.valueOf(paramColor.getRed()), Integer.valueOf(paramColor.getGreen()), Integer.valueOf(paramColor.getBlue()) }));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static String getColorNameOrRGB(Color paramColor) {
/* 108 */     if (paramColor != null) {
/* 109 */       int i = paramColor.getRGB();
/*     */       String str;
/* 111 */       return ((str = colorNameMap.get(Integer.valueOf(i & 0xFFFFFF))) != null) ? str : String.format(Locale.US, "rgb(%d,%d,%d)", new Object[] { Integer.valueOf(paramColor.getRed()), Integer.valueOf(paramColor.getGreen()), Integer.valueOf(paramColor.getBlue()) });
/*     */     } 
/* 113 */     return "";
/*     */   }
/*     */   
/* 116 */   public static final HashMap<Integer, String> colorNameMap = new HashMap<>();
/* 117 */   public static final HashMap<String, Integer> nameColorMap = new HashMap<>();
/*     */   
/*     */   private static void addColorName(int paramInt, String paramString) {
/* 120 */     colorNameMap.put(Integer.valueOf(paramInt), paramString);
/* 121 */     nameColorMap.put(paramString, Integer.valueOf(paramInt));
/*     */   }
/*     */   
/*     */   static {
/* 125 */     addColorName(0, "black");
/* 126 */     addColorName(128, "navy");
/* 127 */     addColorName(139, "darkblue");
/* 128 */     addColorName(205, "mediumblue");
/* 129 */     addColorName(255, "blue");
/* 130 */     addColorName(25600, "darkgreen");
/* 131 */     addColorName(32768, "green");
/* 132 */     addColorName(32896, "teal");
/* 133 */     addColorName(35723, "darkcyan");
/* 134 */     addColorName(49151, "deepskyblue");
/* 135 */     addColorName(52945, "darkturquoise");
/* 136 */     addColorName(64154, "mediumspringgreen");
/* 137 */     addColorName(65280, "lime");
/* 138 */     addColorName(65407, "springgreen");
/* 139 */     addColorName(65535, "aqua");
/* 140 */     addColorName(1644912, "midnightblue");
/* 141 */     addColorName(2003199, "dodgerblue");
/* 142 */     addColorName(2142890, "lightseagreen");
/* 143 */     addColorName(2263842, "forestgreen");
/* 144 */     addColorName(3050327, "seagreen");
/* 145 */     addColorName(3100495, "darkslategray");
/* 146 */     addColorName(3100495, "darkslategrey");
/* 147 */     addColorName(3329330, "limegreen");
/* 148 */     addColorName(3978097, "mediumseagreen");
/* 149 */     addColorName(4251856, "turquoise");
/* 150 */     addColorName(4286945, "royalblue");
/* 151 */     addColorName(4620980, "steelblue");
/* 152 */     addColorName(4734347, "darkslateblue");
/* 153 */     addColorName(4772300, "mediumturquoise");
/* 154 */     addColorName(4915330, "indigo");
/* 155 */     addColorName(5597999, "darkolivegreen");
/* 156 */     addColorName(6266528, "cadetblue");
/* 157 */     addColorName(6591981, "cornflowerblue");
/* 158 */     addColorName(6697881, "rebeccapurple");
/* 159 */     addColorName(6737322, "mediumaquamarine");
/* 160 */     addColorName(6908265, "dimgray");
/* 161 */     addColorName(6908265, "dimgrey");
/* 162 */     addColorName(6970061, "slateblue");
/* 163 */     addColorName(7048739, "olivedrab");
/* 164 */     addColorName(7372944, "slategray");
/* 165 */     addColorName(7372944, "slategrey");
/* 166 */     addColorName(7833753, "lightslategray");
/* 167 */     addColorName(7833753, "lightslategrey");
/* 168 */     addColorName(8087790, "mediumslateblue");
/* 169 */     addColorName(8190976, "lawngreen");
/* 170 */     addColorName(8388352, "chartreuse");
/* 171 */     addColorName(8388564, "aquamarine");
/* 172 */     addColorName(8388608, "maroon");
/* 173 */     addColorName(8388736, "purple");
/* 174 */     addColorName(8421376, "olive");
/* 175 */     addColorName(8421504, "gray");
/* 176 */     addColorName(8421504, "grey");
/* 177 */     addColorName(8900331, "skyblue");
/* 178 */     addColorName(8900346, "lightskyblue");
/* 179 */     addColorName(9055202, "blueviolet");
/* 180 */     addColorName(9109504, "darkred");
/* 181 */     addColorName(9109643, "darkmagenta");
/* 182 */     addColorName(9127187, "saddlebrown");
/* 183 */     addColorName(9419919, "darkseagreen");
/* 184 */     addColorName(9498256, "lightgreen");
/* 185 */     addColorName(9662683, "mediumpurple");
/* 186 */     addColorName(9699539, "darkviolet");
/* 187 */     addColorName(10025880, "palegreen");
/* 188 */     addColorName(10040012, "darkorchid");
/* 189 */     addColorName(10145074, "yellowgreen");
/* 190 */     addColorName(10506797, "sienna");
/* 191 */     addColorName(10824234, "brown");
/* 192 */     addColorName(11119017, "darkgray");
/* 193 */     addColorName(11119017, "darkgrey");
/* 194 */     addColorName(11393254, "lightblue");
/* 195 */     addColorName(11403055, "greenyellow");
/* 196 */     addColorName(11529966, "paleturquoise");
/* 197 */     addColorName(11584734, "lightsteelblue");
/* 198 */     addColorName(11591910, "powderblue");
/* 199 */     addColorName(11674146, "firebrick");
/* 200 */     addColorName(12092939, "darkgoldenrod");
/* 201 */     addColorName(12211667, "mediumorchid");
/* 202 */     addColorName(12357519, "rosybrown");
/* 203 */     addColorName(12433259, "darkkhaki");
/* 204 */     addColorName(12632256, "silver");
/* 205 */     addColorName(13047173, "mediumvioletred");
/* 206 */     addColorName(13458524, "indianred");
/* 207 */     addColorName(13468991, "peru");
/* 208 */     addColorName(13789470, "chocolate");
/* 209 */     addColorName(13808780, "tan");
/* 210 */     addColorName(13882323, "lightgray");
/* 211 */     addColorName(13882323, "lightgrey");
/* 212 */     addColorName(14204888, "thistle");
/* 213 */     addColorName(14315734, "orchid");
/* 214 */     addColorName(14329120, "goldenrod");
/* 215 */     addColorName(14381203, "palevioletred");
/* 216 */     addColorName(14423100, "crimson");
/* 217 */     addColorName(14474460, "gainsboro");
/* 218 */     addColorName(14524637, "plum");
/* 219 */     addColorName(14596231, "burlywood");
/* 220 */     addColorName(14745599, "lightcyan");
/* 221 */     addColorName(15132410, "lavender");
/* 222 */     addColorName(15308410, "darksalmon");
/* 223 */     addColorName(15631086, "violet");
/* 224 */     addColorName(15657130, "palegoldenrod");
/* 225 */     addColorName(15761536, "lightcoral");
/* 226 */     addColorName(15787660, "khaki");
/* 227 */     addColorName(15792383, "aliceblue");
/* 228 */     addColorName(15794160, "honeydew");
/* 229 */     addColorName(15794175, "azure");
/* 230 */     addColorName(16032864, "sandybrown");
/* 231 */     addColorName(16113331, "wheat");
/* 232 */     addColorName(16119260, "beige");
/* 233 */     addColorName(16119285, "whitesmoke");
/* 234 */     addColorName(16121850, "mintcream");
/* 235 */     addColorName(16316671, "ghostwhite");
/* 236 */     addColorName(16416882, "salmon");
/* 237 */     addColorName(16444375, "antiquewhite");
/* 238 */     addColorName(16445670, "linen");
/* 239 */     addColorName(16448210, "lightgoldenrodyellow");
/* 240 */     addColorName(16643558, "oldlace");
/* 241 */     addColorName(16711680, "red");
/* 242 */     addColorName(16711935, "fuchsia");
/* 243 */     addColorName(16716947, "deeppink");
/* 244 */     addColorName(16729344, "orangered");
/* 245 */     addColorName(16737095, "tomato");
/* 246 */     addColorName(16738740, "hotpink");
/* 247 */     addColorName(16744272, "coral");
/* 248 */     addColorName(16747520, "darkorange");
/* 249 */     addColorName(16752762, "lightsalmon");
/* 250 */     addColorName(16753920, "orange");
/* 251 */     addColorName(16758465, "lightpink");
/* 252 */     addColorName(16761035, "pink");
/* 253 */     addColorName(16766720, "gold");
/* 254 */     addColorName(16767673, "peachpuff");
/* 255 */     addColorName(16768685, "navajowhite");
/* 256 */     addColorName(16770229, "moccasin");
/* 257 */     addColorName(16770244, "bisque");
/* 258 */     addColorName(16770273, "mistyrose");
/* 259 */     addColorName(16772045, "blanchedalmond");
/* 260 */     addColorName(16773077, "papayawhip");
/* 261 */     addColorName(16773365, "lavenderblush");
/* 262 */     addColorName(16774638, "seashell");
/* 263 */     addColorName(16775388, "cornsilk");
/* 264 */     addColorName(16775885, "lemonchiffon");
/* 265 */     addColorName(16775920, "floralwhite");
/* 266 */     addColorName(16775930, "snow");
/* 267 */     addColorName(16776960, "yellow");
/* 268 */     addColorName(16777184, "lightyellow");
/* 269 */     addColorName(16777200, "ivory");
/* 270 */     addColorName(16777215, "white");
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\vladsch\flexmar\\util\htm\\ui\ColorStyler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */