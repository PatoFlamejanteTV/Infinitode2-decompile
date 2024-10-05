/*     */ package com.badlogic.gdx.graphics;
/*     */ 
/*     */ import com.badlogic.gdx.math.MathUtils;
/*     */ import com.badlogic.gdx.utils.NumberUtils;
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
/*     */ 
/*     */ public class Color
/*     */ {
/*  27 */   public static final Color WHITE = new Color(1.0F, 1.0F, 1.0F, 1.0F);
/*  28 */   public static final Color LIGHT_GRAY = new Color(-1077952513);
/*  29 */   public static final Color GRAY = new Color(2139062271);
/*  30 */   public static final Color DARK_GRAY = new Color(1061109759);
/*  31 */   public static final Color BLACK = new Color(0.0F, 0.0F, 0.0F, 1.0F);
/*     */ 
/*     */   
/*  34 */   public static final float WHITE_FLOAT_BITS = WHITE.toFloatBits();
/*     */   
/*  36 */   public static final Color CLEAR = new Color(0.0F, 0.0F, 0.0F, 0.0F);
/*  37 */   public static final Color CLEAR_WHITE = new Color(1.0F, 1.0F, 1.0F, 0.0F);
/*     */   
/*  39 */   public static final Color BLUE = new Color(0.0F, 0.0F, 1.0F, 1.0F);
/*  40 */   public static final Color NAVY = new Color(0.0F, 0.0F, 0.5F, 1.0F);
/*  41 */   public static final Color ROYAL = new Color(1097458175);
/*  42 */   public static final Color SLATE = new Color(1887473919);
/*  43 */   public static final Color SKY = new Color(-2016482305);
/*  44 */   public static final Color CYAN = new Color(0.0F, 1.0F, 1.0F, 1.0F);
/*  45 */   public static final Color TEAL = new Color(0.0F, 0.5F, 0.5F, 1.0F);
/*     */   
/*  47 */   public static final Color GREEN = new Color(16711935);
/*  48 */   public static final Color CHARTREUSE = new Color(2147418367);
/*  49 */   public static final Color LIME = new Color(852308735);
/*  50 */   public static final Color FOREST = new Color(579543807);
/*  51 */   public static final Color OLIVE = new Color(1804477439);
/*     */   
/*  53 */   public static final Color YELLOW = new Color(-65281);
/*  54 */   public static final Color GOLD = new Color(-2686721);
/*  55 */   public static final Color GOLDENROD = new Color(-626712321);
/*  56 */   public static final Color ORANGE = new Color(-5963521);
/*     */   
/*  58 */   public static final Color BROWN = new Color(-1958407169);
/*  59 */   public static final Color TAN = new Color(-759919361);
/*  60 */   public static final Color FIREBRICK = new Color(-1306385665);
/*     */   
/*  62 */   public static final Color RED = new Color(-16776961);
/*  63 */   public static final Color SCARLET = new Color(-13361921);
/*  64 */   public static final Color CORAL = new Color(-8433409);
/*  65 */   public static final Color SALMON = new Color(-92245249);
/*  66 */   public static final Color PINK = new Color(-9849601);
/*  67 */   public static final Color MAGENTA = new Color(1.0F, 0.0F, 1.0F, 1.0F);
/*     */   
/*  69 */   public static final Color PURPLE = new Color(-1608453889);
/*  70 */   public static final Color VIOLET = new Color(-293409025);
/*  71 */   public static final Color MAROON = new Color(-1339006721);
/*     */   
/*     */   public float r;
/*     */   
/*     */   public float g;
/*     */   public float b;
/*     */   public float a;
/*     */   
/*     */   public Color() {}
/*     */   
/*     */   public Color(int paramInt) {
/*  82 */     rgba8888ToColor(this, paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Color(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4) {
/*  92 */     this.r = paramFloat1;
/*  93 */     this.g = paramFloat2;
/*  94 */     this.b = paramFloat3;
/*  95 */     this.a = paramFloat4;
/*  96 */     clamp();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Color(Color paramColor) {
/* 103 */     set(paramColor);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Color set(Color paramColor) {
/* 111 */     this.r = paramColor.r;
/* 112 */     this.g = paramColor.g;
/* 113 */     this.b = paramColor.b;
/* 114 */     this.a = paramColor.a;
/* 115 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Color set(Color paramColor, float paramFloat) {
/* 124 */     this.r = paramColor.r;
/* 125 */     this.g = paramColor.g;
/* 126 */     this.b = paramColor.b;
/* 127 */     this.a = MathUtils.clamp(paramFloat, 0.0F, 1.0F);
/* 128 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Color mul(Color paramColor) {
/* 136 */     this.r *= paramColor.r;
/* 137 */     this.g *= paramColor.g;
/* 138 */     this.b *= paramColor.b;
/* 139 */     this.a *= paramColor.a;
/* 140 */     return clamp();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Color mul(float paramFloat) {
/* 148 */     this.r *= paramFloat;
/* 149 */     this.g *= paramFloat;
/* 150 */     this.b *= paramFloat;
/* 151 */     this.a *= paramFloat;
/* 152 */     return clamp();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Color add(Color paramColor) {
/* 160 */     this.r += paramColor.r;
/* 161 */     this.g += paramColor.g;
/* 162 */     this.b += paramColor.b;
/* 163 */     this.a += paramColor.a;
/* 164 */     return clamp();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Color sub(Color paramColor) {
/* 172 */     this.r -= paramColor.r;
/* 173 */     this.g -= paramColor.g;
/* 174 */     this.b -= paramColor.b;
/* 175 */     this.a -= paramColor.a;
/* 176 */     return clamp();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public Color clamp() {
/* 182 */     if (this.r < 0.0F)
/* 183 */     { this.r = 0.0F; }
/* 184 */     else if (this.r > 1.0F) { this.r = 1.0F; }
/*     */     
/* 186 */     if (this.g < 0.0F)
/* 187 */     { this.g = 0.0F; }
/* 188 */     else if (this.g > 1.0F) { this.g = 1.0F; }
/*     */     
/* 190 */     if (this.b < 0.0F)
/* 191 */     { this.b = 0.0F; }
/* 192 */     else if (this.b > 1.0F) { this.b = 1.0F; }
/*     */     
/* 194 */     if (this.a < 0.0F)
/* 195 */     { this.a = 0.0F; }
/* 196 */     else if (this.a > 1.0F) { this.a = 1.0F; }
/* 197 */      return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Color set(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4) {
/* 209 */     this.r = paramFloat1;
/* 210 */     this.g = paramFloat2;
/* 211 */     this.b = paramFloat3;
/* 212 */     this.a = paramFloat4;
/* 213 */     return clamp();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Color set(int paramInt) {
/* 221 */     rgba8888ToColor(this, paramInt);
/* 222 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Color add(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4) {
/* 234 */     this.r += paramFloat1;
/* 235 */     this.g += paramFloat2;
/* 236 */     this.b += paramFloat3;
/* 237 */     this.a += paramFloat4;
/* 238 */     return clamp();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Color sub(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4) {
/* 250 */     this.r -= paramFloat1;
/* 251 */     this.g -= paramFloat2;
/* 252 */     this.b -= paramFloat3;
/* 253 */     this.a -= paramFloat4;
/* 254 */     return clamp();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Color mul(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4) {
/* 266 */     this.r *= paramFloat1;
/* 267 */     this.g *= paramFloat2;
/* 268 */     this.b *= paramFloat3;
/* 269 */     this.a *= paramFloat4;
/* 270 */     return clamp();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Color lerp(Color paramColor, float paramFloat) {
/* 279 */     this.r += paramFloat * (paramColor.r - this.r);
/* 280 */     this.g += paramFloat * (paramColor.g - this.g);
/* 281 */     this.b += paramFloat * (paramColor.b - this.b);
/* 282 */     this.a += paramFloat * (paramColor.a - this.a);
/* 283 */     return clamp();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Color lerp(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5) {
/* 295 */     this.r += paramFloat5 * (paramFloat1 - this.r);
/* 296 */     this.g += paramFloat5 * (paramFloat2 - this.g);
/* 297 */     this.b += paramFloat5 * (paramFloat3 - this.b);
/* 298 */     this.a += paramFloat5 * (paramFloat4 - this.a);
/* 299 */     return clamp();
/*     */   }
/*     */ 
/*     */   
/*     */   public Color premultiplyAlpha() {
/* 304 */     this.r *= this.a;
/* 305 */     this.g *= this.a;
/* 306 */     this.b *= this.a;
/* 307 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean equals(Object paramObject) {
/* 312 */     if (this == paramObject) return true; 
/* 313 */     if (paramObject == null || getClass() != paramObject.getClass()) return false; 
/* 314 */     paramObject = paramObject;
/* 315 */     return (toIntBits() == paramObject.toIntBits());
/*     */   }
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 320 */     int i = (this.r != 0.0F) ? NumberUtils.floatToIntBits(this.r) : 0;
/* 321 */     i = i * 31 + ((this.g != 0.0F) ? NumberUtils.floatToIntBits(this.g) : 0);
/* 322 */     i = i * 31 + ((this.b != 0.0F) ? NumberUtils.floatToIntBits(this.b) : 0);
/*     */     
/* 324 */     return i = i * 31 + ((this.a != 0.0F) ? NumberUtils.floatToIntBits(this.a) : 0);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public float toFloatBits() {
/*     */     int i;
/* 333 */     return NumberUtils.intToFloatColor(i = (int)(255.0F * this.a) << 24 | (int)(255.0F * this.b) << 16 | (int)(255.0F * this.g) << 8 | (int)(255.0F * this.r));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int toIntBits() {
/* 339 */     return (int)(255.0F * this.a) << 24 | (int)(255.0F * this.b) << 16 | (int)(255.0F * this.g) << 8 | (int)(255.0F * this.r);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/* 345 */     String str = Integer.toHexString((int)(255.0F * this.r) << 24 | (int)(255.0F * this.g) << 16 | (int)(255.0F * this.b) << 8 | (int)(255.0F * this.a));
/* 346 */     while (str.length() < 8)
/* 347 */       str = "0" + str; 
/* 348 */     return str;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static Color valueOf(String paramString) {
/* 354 */     return valueOf(paramString, new Color());
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static Color valueOf(String paramString, Color paramColor) {
/* 360 */     paramString = (paramString.charAt(0) == '#') ? paramString.substring(1) : paramString;
/* 361 */     paramColor.r = Integer.parseInt(paramString.substring(0, 2), 16) / 255.0F;
/* 362 */     paramColor.g = Integer.parseInt(paramString.substring(2, 4), 16) / 255.0F;
/* 363 */     paramColor.b = Integer.parseInt(paramString.substring(4, 6), 16) / 255.0F;
/* 364 */     paramColor.a = (paramString.length() != 8) ? 1.0F : (Integer.parseInt(paramString.substring(6, 8), 16) / 255.0F);
/* 365 */     return paramColor;
/*     */   }
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
/*     */   public static float toFloatBits(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
/*     */     float f;
/* 379 */     return f = NumberUtils.intToFloatColor(paramInt1 = paramInt4 << 24 | paramInt3 << 16 | paramInt2 << 8 | paramInt1);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static float toFloatBits(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4) {
/*     */     int i;
/* 387 */     return NumberUtils.intToFloatColor(i = (int)(255.0F * paramFloat4) << 24 | (int)(255.0F * paramFloat3) << 16 | (int)(255.0F * paramFloat2) << 8 | (int)(255.0F * paramFloat1));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static int toIntBits(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
/* 398 */     return paramInt4 << 24 | paramInt3 << 16 | paramInt2 << 8 | paramInt1;
/*     */   }
/*     */   
/*     */   public static int alpha(float paramFloat) {
/* 402 */     return (int)(paramFloat * 255.0F);
/*     */   }
/*     */   
/*     */   public static int luminanceAlpha(float paramFloat1, float paramFloat2) {
/* 406 */     return (int)(paramFloat1 * 255.0F) << 8 | (int)(paramFloat2 * 255.0F);
/*     */   }
/*     */   
/*     */   public static int rgb565(float paramFloat1, float paramFloat2, float paramFloat3) {
/* 410 */     return (int)(paramFloat1 * 31.0F) << 11 | (int)(paramFloat2 * 63.0F) << 5 | (int)(paramFloat3 * 31.0F);
/*     */   }
/*     */   
/*     */   public static int rgba4444(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4) {
/* 414 */     return (int)(paramFloat1 * 15.0F) << 12 | (int)(paramFloat2 * 15.0F) << 8 | (int)(paramFloat3 * 15.0F) << 4 | (int)(paramFloat4 * 15.0F);
/*     */   }
/*     */   
/*     */   public static int rgb888(float paramFloat1, float paramFloat2, float paramFloat3) {
/* 418 */     return (int)(paramFloat1 * 255.0F) << 16 | (int)(paramFloat2 * 255.0F) << 8 | (int)(paramFloat3 * 255.0F);
/*     */   }
/*     */   
/*     */   public static int rgba8888(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4) {
/* 422 */     return (int)(paramFloat1 * 255.0F) << 24 | (int)(paramFloat2 * 255.0F) << 16 | (int)(paramFloat3 * 255.0F) << 8 | (int)(paramFloat4 * 255.0F);
/*     */   }
/*     */   
/*     */   public static int argb8888(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4) {
/* 426 */     return (int)(paramFloat1 * 255.0F) << 24 | (int)(paramFloat2 * 255.0F) << 16 | (int)(paramFloat3 * 255.0F) << 8 | (int)(paramFloat4 * 255.0F);
/*     */   }
/*     */   
/*     */   public static int rgb565(Color paramColor) {
/* 430 */     return (int)(paramColor.r * 31.0F) << 11 | (int)(paramColor.g * 63.0F) << 5 | (int)(paramColor.b * 31.0F);
/*     */   }
/*     */   
/*     */   public static int rgba4444(Color paramColor) {
/* 434 */     return (int)(paramColor.r * 15.0F) << 12 | (int)(paramColor.g * 15.0F) << 8 | (int)(paramColor.b * 15.0F) << 4 | (int)(paramColor.a * 15.0F);
/*     */   }
/*     */   
/*     */   public static int rgb888(Color paramColor) {
/* 438 */     return (int)(paramColor.r * 255.0F) << 16 | (int)(paramColor.g * 255.0F) << 8 | (int)(paramColor.b * 255.0F);
/*     */   }
/*     */   
/*     */   public static int rgba8888(Color paramColor) {
/* 442 */     return (int)(paramColor.r * 255.0F) << 24 | (int)(paramColor.g * 255.0F) << 16 | (int)(paramColor.b * 255.0F) << 8 | (int)(paramColor.a * 255.0F);
/*     */   }
/*     */   
/*     */   public static int argb8888(Color paramColor) {
/* 446 */     return (int)(paramColor.a * 255.0F) << 24 | (int)(paramColor.r * 255.0F) << 16 | (int)(paramColor.g * 255.0F) << 8 | (int)(paramColor.b * 255.0F);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void rgb565ToColor(Color paramColor, int paramInt) {
/* 455 */     paramColor.r = ((paramInt & 0xF800) >>> 11) / 31.0F;
/* 456 */     paramColor.g = ((paramInt & 0x7E0) >>> 5) / 63.0F;
/* 457 */     paramColor.b = (paramInt & 0x1F) / 31.0F;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void rgba4444ToColor(Color paramColor, int paramInt) {
/* 466 */     paramColor.r = ((paramInt & 0xF000) >>> 12) / 15.0F;
/* 467 */     paramColor.g = ((paramInt & 0xF00) >>> 8) / 15.0F;
/* 468 */     paramColor.b = ((paramInt & 0xF0) >>> 4) / 15.0F;
/* 469 */     paramColor.a = (paramInt & 0xF) / 15.0F;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void rgb888ToColor(Color paramColor, int paramInt) {
/* 478 */     paramColor.r = (paramInt >>> 16 & 0xFF) / 255.0F;
/* 479 */     paramColor.g = (paramInt >>> 8 & 0xFF) / 255.0F;
/* 480 */     paramColor.b = (paramInt & 0xFF) / 255.0F;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void rgba8888ToColor(Color paramColor, int paramInt) {
/* 489 */     paramColor.r = ((paramInt & 0xFF000000) >>> 24) / 255.0F;
/* 490 */     paramColor.g = (paramInt >>> 16 & 0xFF) / 255.0F;
/* 491 */     paramColor.b = (paramInt >>> 8 & 0xFF) / 255.0F;
/* 492 */     paramColor.a = (paramInt & 0xFF) / 255.0F;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void argb8888ToColor(Color paramColor, int paramInt) {
/* 501 */     paramColor.a = ((paramInt & 0xFF000000) >>> 24) / 255.0F;
/* 502 */     paramColor.r = (paramInt >>> 16 & 0xFF) / 255.0F;
/* 503 */     paramColor.g = (paramInt >>> 8 & 0xFF) / 255.0F;
/* 504 */     paramColor.b = (paramInt & 0xFF) / 255.0F;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static void abgr8888ToColor(Color paramColor, int paramInt) {
/* 510 */     paramColor.a = ((paramInt & 0xFF000000) >>> 24) / 255.0F;
/* 511 */     paramColor.b = (paramInt >>> 16 & 0xFF) / 255.0F;
/* 512 */     paramColor.g = (paramInt >>> 8 & 0xFF) / 255.0F;
/* 513 */     paramColor.r = (paramInt & 0xFF) / 255.0F;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static void abgr8888ToColor(Color paramColor, float paramFloat) {
/* 519 */     int i = NumberUtils.floatToIntColor(paramFloat);
/* 520 */     paramColor.a = ((i & 0xFF000000) >>> 24) / 255.0F;
/* 521 */     paramColor.b = (i >>> 16 & 0xFF) / 255.0F;
/* 522 */     paramColor.g = (i >>> 8 & 0xFF) / 255.0F;
/* 523 */     paramColor.r = (i & 0xFF) / 255.0F;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Color fromHsv(float paramFloat1, float paramFloat2, float paramFloat3) {
/* 534 */     int i = (int)(paramFloat1 = (paramFloat1 / 60.0F + 6.0F) % 6.0F);
/* 535 */     paramFloat1 -= i;
/* 536 */     float f1 = paramFloat3 * (1.0F - paramFloat2);
/* 537 */     float f2 = paramFloat3 * (1.0F - paramFloat2 * paramFloat1);
/* 538 */     paramFloat1 = paramFloat3 * (1.0F - paramFloat2 * (1.0F - paramFloat1));
/* 539 */     switch (i)
/*     */     { case 0:
/* 541 */         this.r = paramFloat3;
/* 542 */         this.g = paramFloat1;
/* 543 */         this.b = f1;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 571 */         return clamp();case 1: this.r = f2; this.g = paramFloat3; this.b = f1; return clamp();case 2: this.r = f1; this.g = paramFloat3; this.b = paramFloat1; return clamp();case 3: this.r = f1; this.g = f2; this.b = paramFloat3; return clamp();case 4: this.r = paramFloat1; this.g = f1; this.b = paramFloat3; return clamp(); }  this.r = paramFloat3; this.g = f1; this.b = f2; return clamp();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Color fromHsv(float[] paramArrayOffloat) {
/* 579 */     return fromHsv(paramArrayOffloat[0], paramArrayOffloat[1], paramArrayOffloat[2]);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public float[] toHsv(float[] paramArrayOffloat) {
/* 586 */     float f1 = Math.max(Math.max(this.r, this.g), this.b);
/* 587 */     float f2 = Math.min(Math.min(this.r, this.g), this.b);
/*     */     float f3;
/* 589 */     if ((f3 = f1 - f2) == 0.0F) {
/* 590 */       paramArrayOffloat[0] = 0.0F;
/* 591 */     } else if (f1 == this.r) {
/* 592 */       paramArrayOffloat[0] = (60.0F * (this.g - this.b) / f3 + 360.0F) % 360.0F;
/* 593 */     } else if (f1 == this.g) {
/* 594 */       paramArrayOffloat[0] = 60.0F * (this.b - this.r) / f3 + 120.0F;
/*     */     } else {
/* 596 */       paramArrayOffloat[0] = 60.0F * (this.r - this.g) / f3 + 240.0F;
/*     */     } 
/*     */     
/* 599 */     if (f1 > 0.0F) {
/* 600 */       paramArrayOffloat[1] = 1.0F - f2 / f1;
/*     */     } else {
/* 602 */       paramArrayOffloat[1] = 0.0F;
/*     */     } 
/*     */     
/* 605 */     paramArrayOffloat[2] = f1;
/*     */     
/* 607 */     return paramArrayOffloat;
/*     */   }
/*     */ 
/*     */   
/*     */   public Color cpy() {
/* 612 */     return new Color(this);
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gdx\graphics\Color.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */