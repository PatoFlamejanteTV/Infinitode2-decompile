/*     */ package com.badlogic.gdx.graphics.g2d;
/*     */ 
/*     */ import com.badlogic.gdx.Gdx;
/*     */ import com.badlogic.gdx.files.FileHandle;
/*     */ import com.badlogic.gdx.graphics.Color;
/*     */ import com.badlogic.gdx.graphics.Texture;
/*     */ import com.badlogic.gdx.utils.Array;
/*     */ import com.badlogic.gdx.utils.Disposable;
/*     */ import com.badlogic.gdx.utils.FloatArray;
/*     */ import com.badlogic.gdx.utils.GdxRuntimeException;
/*     */ import com.badlogic.gdx.utils.StreamUtils;
/*     */ import java.io.BufferedReader;
/*     */ import java.io.InputStreamReader;
/*     */ import java.util.StringTokenizer;
/*     */ import java.util.regex.Matcher;
/*     */ import java.util.regex.Pattern;
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
/*     */ public class BitmapFont
/*     */   implements Disposable
/*     */ {
/*     */   private static final int LOG2_PAGE_SIZE = 9;
/*     */   private static final int PAGE_SIZE = 512;
/*     */   private static final int PAGES = 128;
/*     */   final BitmapFontData data;
/*     */   Array<TextureRegion> regions;
/*     */   private final BitmapFontCache cache;
/*     */   private boolean flipped;
/*     */   boolean integer;
/*     */   private boolean ownsTexture;
/*     */   
/*     */   public BitmapFont() {
/*  72 */     this(Gdx.files.classpath("com/badlogic/gdx/utils/lsans-15.fnt"), Gdx.files.classpath("com/badlogic/gdx/utils/lsans-15.png"), false, true);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public BitmapFont(boolean paramBoolean) {
/*  80 */     this(Gdx.files.classpath("com/badlogic/gdx/utils/lsans-15.fnt"), Gdx.files.classpath("com/badlogic/gdx/utils/lsans-15.png"), paramBoolean, true);
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
/*     */   public BitmapFont(FileHandle paramFileHandle, TextureRegion paramTextureRegion) {
/*  93 */     this(paramFileHandle, paramTextureRegion, false);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public BitmapFont(FileHandle paramFileHandle, TextureRegion paramTextureRegion, boolean paramBoolean) {
/* 103 */     this(new BitmapFontData(paramFileHandle, paramBoolean), paramTextureRegion, true);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public BitmapFont(FileHandle paramFileHandle) {
/* 109 */     this(paramFileHandle, false);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public BitmapFont(FileHandle paramFileHandle, boolean paramBoolean) {
/* 116 */     this(new BitmapFontData(paramFileHandle, paramBoolean), (TextureRegion)null, true);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public BitmapFont(FileHandle paramFileHandle1, FileHandle paramFileHandle2, boolean paramBoolean) {
/* 123 */     this(paramFileHandle1, paramFileHandle2, paramBoolean, true);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public BitmapFont(FileHandle paramFileHandle1, FileHandle paramFileHandle2, boolean paramBoolean1, boolean paramBoolean2) {
/* 131 */     this(new BitmapFontData(paramFileHandle1, paramBoolean1), new TextureRegion(new Texture(paramFileHandle2, false)), paramBoolean2);
/* 132 */     this.ownsTexture = true;
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
/*     */   public BitmapFont(BitmapFontData paramBitmapFontData, TextureRegion paramTextureRegion, boolean paramBoolean) {
/* 144 */     this(paramBitmapFontData, (paramTextureRegion != null) ? Array.with((Object[])new TextureRegion[] { paramTextureRegion }, ) : null, paramBoolean);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public BitmapFont(BitmapFontData paramBitmapFontData, Array<TextureRegion> paramArray, boolean paramBoolean) {
/*     */     int i;
/* 152 */     this.flipped = paramBitmapFontData.flipped;
/* 153 */     this.data = paramBitmapFontData;
/* 154 */     this.integer = paramBoolean;
/*     */     
/* 156 */     if (paramArray == null || paramArray.size == 0) {
/* 157 */       if (paramBitmapFontData.imagePaths == null) {
/* 158 */         throw new IllegalArgumentException("If no regions are specified, the font data must have an images path.");
/*     */       }
/*     */       
/* 161 */       i = paramBitmapFontData.imagePaths.length;
/* 162 */       this.regions = new Array(i);
/* 163 */       for (paramBoolean = false; paramBoolean < i; paramBoolean++) {
/*     */         FileHandle fileHandle;
/* 165 */         if (paramBitmapFontData.fontFile == null) {
/* 166 */           fileHandle = Gdx.files.internal(paramBitmapFontData.imagePaths[paramBoolean]);
/*     */         } else {
/* 168 */           fileHandle = Gdx.files.getFileHandle(paramBitmapFontData.imagePaths[paramBoolean], paramBitmapFontData.fontFile.type());
/* 169 */         }  this.regions.add(new TextureRegion(new Texture(fileHandle, false)));
/*     */       } 
/* 171 */       this.ownsTexture = true;
/*     */     } else {
/* 173 */       this.regions = i;
/* 174 */       this.ownsTexture = false;
/*     */     } 
/*     */     
/* 177 */     this.cache = newFontCache();
/*     */     
/* 179 */     load(paramBitmapFontData); } protected void load(BitmapFontData paramBitmapFontData) {
/*     */     Glyph[][] arrayOfGlyph;
/*     */     int i;
/*     */     byte b;
/* 183 */     for (i = (arrayOfGlyph = paramBitmapFontData.glyphs).length, b = 0; b < i; b++) {
/* 184 */       Glyph[] arrayOfGlyph1; if ((arrayOfGlyph1 = arrayOfGlyph[b]) != null) {
/* 185 */         int j; byte b1; for (j = (arrayOfGlyph1 = arrayOfGlyph1).length, b1 = 0; b1 < j; b1++)
/* 186 */         { Glyph glyph; if ((glyph = arrayOfGlyph1[b1]) != null) paramBitmapFontData.setGlyphRegion(glyph, (TextureRegion)this.regions.get(glyph.page));  } 
/*     */       } 
/* 188 */     }  if (paramBitmapFontData.missingGlyph != null) paramBitmapFontData.setGlyphRegion(paramBitmapFontData.missingGlyph, (TextureRegion)this.regions.get(paramBitmapFontData.missingGlyph.page));
/*     */   
/*     */   }
/*     */ 
/*     */   
/*     */   public GlyphLayout draw(Batch paramBatch, CharSequence paramCharSequence, float paramFloat1, float paramFloat2) {
/* 194 */     this.cache.clear();
/* 195 */     GlyphLayout glyphLayout = this.cache.addText(paramCharSequence, paramFloat1, paramFloat2);
/* 196 */     this.cache.draw(paramBatch);
/* 197 */     return glyphLayout;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public GlyphLayout draw(Batch paramBatch, CharSequence paramCharSequence, float paramFloat1, float paramFloat2, float paramFloat3, int paramInt, boolean paramBoolean) {
/* 203 */     this.cache.clear();
/* 204 */     GlyphLayout glyphLayout = this.cache.addText(paramCharSequence, paramFloat1, paramFloat2, paramFloat3, paramInt, paramBoolean);
/* 205 */     this.cache.draw(paramBatch);
/* 206 */     return glyphLayout;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public GlyphLayout draw(Batch paramBatch, CharSequence paramCharSequence, float paramFloat1, float paramFloat2, int paramInt1, int paramInt2, float paramFloat3, int paramInt3, boolean paramBoolean) {
/* 213 */     this.cache.clear();
/* 214 */     GlyphLayout glyphLayout = this.cache.addText(paramCharSequence, paramFloat1, paramFloat2, paramInt1, paramInt2, paramFloat3, paramInt3, paramBoolean);
/* 215 */     this.cache.draw(paramBatch);
/* 216 */     return glyphLayout;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public GlyphLayout draw(Batch paramBatch, CharSequence paramCharSequence, float paramFloat1, float paramFloat2, int paramInt1, int paramInt2, float paramFloat3, int paramInt3, boolean paramBoolean, String paramString) {
/* 223 */     this.cache.clear();
/* 224 */     GlyphLayout glyphLayout = this.cache.addText(paramCharSequence, paramFloat1, paramFloat2, paramInt1, paramInt2, paramFloat3, paramInt3, paramBoolean, paramString);
/* 225 */     this.cache.draw(paramBatch);
/* 226 */     return glyphLayout;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void draw(Batch paramBatch, GlyphLayout paramGlyphLayout, float paramFloat1, float paramFloat2) {
/* 232 */     this.cache.clear();
/* 233 */     this.cache.addText(paramGlyphLayout, paramFloat1, paramFloat2);
/* 234 */     this.cache.draw(paramBatch);
/*     */   }
/*     */ 
/*     */   
/*     */   public Color getColor() {
/* 239 */     return this.cache.getColor();
/*     */   }
/*     */ 
/*     */   
/*     */   public void setColor(Color paramColor) {
/* 244 */     this.cache.getColor().set(paramColor);
/*     */   }
/*     */ 
/*     */   
/*     */   public void setColor(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4) {
/* 249 */     this.cache.getColor().set(paramFloat1, paramFloat2, paramFloat3, paramFloat4);
/*     */   }
/*     */   
/*     */   public float getScaleX() {
/* 253 */     return this.data.scaleX;
/*     */   }
/*     */   
/*     */   public float getScaleY() {
/* 257 */     return this.data.scaleY;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public TextureRegion getRegion() {
/* 264 */     return (TextureRegion)this.regions.first();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public Array<TextureRegion> getRegions() {
/* 270 */     return this.regions;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public TextureRegion getRegion(int paramInt) {
/* 276 */     return (TextureRegion)this.regions.get(paramInt);
/*     */   }
/*     */ 
/*     */   
/*     */   public float getLineHeight() {
/* 281 */     return this.data.lineHeight;
/*     */   }
/*     */ 
/*     */   
/*     */   public float getSpaceXadvance() {
/* 286 */     return this.data.spaceXadvance;
/*     */   }
/*     */ 
/*     */   
/*     */   public float getXHeight() {
/* 291 */     return this.data.xHeight;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public float getCapHeight() {
/* 297 */     return this.data.capHeight;
/*     */   }
/*     */ 
/*     */   
/*     */   public float getAscent() {
/* 302 */     return this.data.ascent;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public float getDescent() {
/* 308 */     return this.data.descent;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isFlipped() {
/* 313 */     return this.flipped;
/*     */   }
/*     */ 
/*     */   
/*     */   public void dispose() {
/* 318 */     if (this.ownsTexture) {
/* 319 */       for (byte b = 0; b < this.regions.size; b++) {
/* 320 */         ((TextureRegion)this.regions.get(b)).getTexture().dispose();
/*     */       }
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public void setFixedWidthGlyphs(CharSequence paramCharSequence) {
/* 327 */     BitmapFontData bitmapFontData = this.data;
/* 328 */     int i = 0; byte b; int j;
/* 329 */     for (b = 0, j = paramCharSequence.length(); b < j; b++) {
/*     */       Glyph glyph;
/* 331 */       if ((glyph = bitmapFontData.getGlyph(paramCharSequence.charAt(b))) != null && glyph.xadvance > i) i = glyph.xadvance; 
/*     */     } 
/* 333 */     for (b = 0, j = paramCharSequence.length(); b < j; b++) {
/*     */       Glyph glyph;
/* 335 */       if ((glyph = bitmapFontData.getGlyph(paramCharSequence.charAt(b))) != null) {
/* 336 */         glyph.xoffset += (i - glyph.xadvance) / 2;
/* 337 */         glyph.xadvance = i;
/* 338 */         glyph.kerning = null;
/* 339 */         glyph.fixedWidth = true;
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   public void setUseIntegerPositions(boolean paramBoolean) {
/* 345 */     this.integer = paramBoolean;
/* 346 */     this.cache.setUseIntegerPositions(paramBoolean);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean usesIntegerPositions() {
/* 351 */     return this.integer;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public BitmapFontCache getCache() {
/* 358 */     return this.cache;
/*     */   }
/*     */ 
/*     */   
/*     */   public BitmapFontData getData() {
/* 363 */     return this.data;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean ownsTexture() {
/* 368 */     return this.ownsTexture;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setOwnsTexture(boolean paramBoolean) {
/* 375 */     this.ownsTexture = paramBoolean;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public BitmapFontCache newFontCache() {
/* 384 */     return new BitmapFontCache(this, this.integer);
/*     */   }
/*     */   
/*     */   public String toString() {
/* 388 */     return (this.data.name != null) ? this.data.name : super.toString();
/*     */   }
/*     */   public static class Glyph { public int id;
/*     */     public int srcX;
/*     */     public int srcY;
/*     */     public int width;
/*     */     public int height;
/*     */     public float u;
/*     */     public float v;
/*     */     public float u2;
/*     */     public float v2;
/*     */     public int xoffset;
/*     */     public int yoffset;
/*     */     public int xadvance;
/*     */     public byte[][] kerning;
/*     */     public boolean fixedWidth;
/* 404 */     public int page = 0;
/*     */     public int getKerning(char param1Char) {
/*     */       byte[] arrayOfByte;
/* 407 */       if (this.kerning != null && (
/*     */         
/* 409 */         arrayOfByte = this.kerning[param1Char >>> 9]) != null) return arrayOfByte[param1Char & 0x1FF];
/*     */       
/* 411 */       return 0;
/*     */     }
/*     */     
/*     */     public void setKerning(int param1Int1, int param1Int2) {
/* 415 */       if (this.kerning == null) this.kerning = new byte[128][]; 
/*     */       byte[] arrayOfByte;
/* 417 */       if ((arrayOfByte = this.kerning[param1Int1 >>> 9]) == null) this.kerning[param1Int1 >>> 9] = arrayOfByte = new byte[512]; 
/* 418 */       arrayOfByte[param1Int1 & 0x1FF] = (byte)param1Int2;
/*     */     }
/*     */     
/*     */     public String toString() {
/* 422 */       return Character.toString((char)this.id);
/*     */     } }
/*     */ 
/*     */   
/*     */   static int indexOf(CharSequence paramCharSequence, char paramChar, int paramInt) {
/* 427 */     int i = paramCharSequence.length();
/* 428 */     for (; paramInt < i; paramInt++) {
/* 429 */       if (paramCharSequence.charAt(paramInt) == paramChar) return paramInt; 
/* 430 */     }  return i;
/*     */   }
/*     */ 
/*     */   
/*     */   public static class BitmapFontData
/*     */   {
/*     */     public String name;
/*     */     
/*     */     public String[] imagePaths;
/*     */     public FileHandle fontFile;
/*     */     public boolean flipped;
/*     */     public float padTop;
/*     */     public float padRight;
/*     */     public float padBottom;
/*     */     public float padLeft;
/*     */     public float lineHeight;
/* 446 */     public float capHeight = 1.0F;
/*     */ 
/*     */     
/*     */     public float ascent;
/*     */     
/*     */     public float descent;
/*     */     
/*     */     public float down;
/*     */     
/* 455 */     public float blankLineScale = 1.0F;
/* 456 */     public float scaleX = 1.0F; public float scaleY = 1.0F;
/*     */     
/*     */     public boolean markupEnabled;
/*     */     
/*     */     public float cursorX;
/*     */     
/* 462 */     public final BitmapFont.Glyph[][] glyphs = new BitmapFont.Glyph[128][];
/*     */ 
/*     */     
/*     */     public BitmapFont.Glyph missingGlyph;
/*     */     
/*     */     public float spaceXadvance;
/*     */     
/* 469 */     public float xHeight = 1.0F;
/*     */     
/*     */     public char[] breakChars;
/*     */     
/* 473 */     public char[] xChars = new char[] { 'x', 'e', 'a', 'o', 'n', 's', 'r', 'c', 'u', 'm', 'v', 'w', 'z' };
/* 474 */     public char[] capChars = new char[] { 'M', 'N', 'B', 'D', 'C', 'E', 'F', 'K', 'A', 'G', 'H', 'I', 'J', 'L', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z' };
/*     */ 
/*     */ 
/*     */     
/*     */     public BitmapFontData() {}
/*     */ 
/*     */ 
/*     */     
/*     */     public BitmapFontData(FileHandle param1FileHandle, boolean param1Boolean) {
/* 483 */       this.fontFile = param1FileHandle;
/* 484 */       this.flipped = param1Boolean;
/* 485 */       load(param1FileHandle, param1Boolean);
/*     */     }
/*     */     
/*     */     public void load(FileHandle param1FileHandle, boolean param1Boolean) {
/* 489 */       if (this.imagePaths != null) throw new IllegalStateException("Already loaded.");
/*     */       
/* 491 */       this.name = param1FileHandle.nameWithoutExtension();
/*     */       
/* 493 */       BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(param1FileHandle.read()), 512); try {
/*     */         BitmapFont.Glyph[] arrayOfGlyph;
/*     */         String str3;
/* 496 */         if ((str3 = bufferedReader.readLine()) == null) throw new GdxRuntimeException("File is empty.");
/*     */ 
/*     */         
/*     */         String[] arrayOfString2;
/* 500 */         if ((arrayOfString2 = (str3 = str3.substring(str3.indexOf("padding=") + 8)).substring(0, str3.indexOf(' ')).split(",", 4)).length != 4) throw new GdxRuntimeException("Invalid padding."); 
/* 501 */         this.padTop = Integer.parseInt(arrayOfString2[0]);
/* 502 */         this.padRight = Integer.parseInt(arrayOfString2[1]);
/* 503 */         this.padBottom = Integer.parseInt(arrayOfString2[2]);
/* 504 */         this.padLeft = Integer.parseInt(arrayOfString2[3]);
/* 505 */         float f1 = this.padTop + this.padBottom;
/*     */         
/*     */         String str2;
/* 508 */         if ((str2 = bufferedReader.readLine()) == null) throw new GdxRuntimeException("Missing common header.");
/*     */ 
/*     */         
/*     */         String[] arrayOfString1;
/* 512 */         if ((arrayOfString1 = str2.split(" ", 9)).length < 3) throw new GdxRuntimeException("Invalid common header.");
/*     */         
/* 514 */         if (!arrayOfString1[1].startsWith("lineHeight=")) throw new GdxRuntimeException("Missing: lineHeight"); 
/* 515 */         this.lineHeight = Integer.parseInt(arrayOfString1[1].substring(11));
/*     */         
/* 517 */         if (!arrayOfString1[2].startsWith("base=")) throw new GdxRuntimeException("Missing: base"); 
/* 518 */         float f2 = Integer.parseInt(arrayOfString1[2].substring(5));
/*     */         
/* 520 */         int i = 1;
/* 521 */         if (arrayOfString1.length >= 6 && arrayOfString1[5] != null && arrayOfString1[5].startsWith("pages=")) {
/*     */           try {
/* 523 */             i = Math.max(1, Integer.parseInt(arrayOfString1[5].substring(6)));
/* 524 */           } catch (NumberFormatException numberFormatException) {}
/*     */         }
/*     */ 
/*     */         
/* 528 */         this.imagePaths = new String[i];
/*     */         
/*     */         byte b1;
/* 531 */         for (b1 = 0; b1 < i; b1++) {
/*     */           String str4;
/*     */           
/* 534 */           if ((str4 = bufferedReader.readLine()) == null) throw new GdxRuntimeException("Missing additional page definitions.");
/*     */ 
/*     */           
/*     */           Matcher matcher;
/* 538 */           if ((matcher = Pattern.compile(".*id=(\\d+)").matcher(str4)).find()) {
/* 539 */             String str = matcher.group(1);
/*     */             try {
/*     */               int m;
/* 542 */               if ((m = Integer.parseInt(str)) != b1) throw new GdxRuntimeException("Page IDs must be indices starting at 0: " + str); 
/* 543 */             } catch (NumberFormatException numberFormatException) {
/* 544 */               throw new GdxRuntimeException("Invalid page id: " + str, numberFormatException);
/*     */             } 
/*     */           } 
/*     */ 
/*     */           
/* 549 */           if (!(matcher = Pattern.compile(".*file=\"?([^\"]+)\"?").matcher(str4)).find()) throw new GdxRuntimeException("Missing: file"); 
/* 550 */           String str5 = matcher.group(1);
/*     */           
/* 552 */           this.imagePaths[b1] = param1FileHandle.parent().child(str5).path().replaceAll("\\\\", "/");
/*     */         } 
/* 554 */         this.descent = 0.0F;
/*     */         
/*     */         String str1;
/*     */         
/* 558 */         while ((str1 = bufferedReader.readLine()) != null && 
/* 559 */           !str1.startsWith("kernings ") && 
/* 560 */           !str1.startsWith("metrics ")) {
/* 561 */           if (str1.startsWith("char ")) {
/*     */             
/* 563 */             BitmapFont.Glyph glyph = new BitmapFont.Glyph();
/*     */             
/*     */             StringTokenizer stringTokenizer;
/* 566 */             (stringTokenizer = new StringTokenizer(str1, " =")).nextToken();
/* 567 */             stringTokenizer.nextToken();
/*     */             int m;
/* 569 */             if ((m = Integer.parseInt(stringTokenizer.nextToken())) <= 0) {
/* 570 */               this.missingGlyph = glyph;
/* 571 */             } else if (m <= 65535) {
/* 572 */               setGlyph(m, glyph);
/*     */             } else {
/*     */               continue;
/* 575 */             }  glyph.id = m;
/* 576 */             stringTokenizer.nextToken();
/* 577 */             glyph.srcX = Integer.parseInt(stringTokenizer.nextToken());
/* 578 */             stringTokenizer.nextToken();
/* 579 */             glyph.srcY = Integer.parseInt(stringTokenizer.nextToken());
/* 580 */             stringTokenizer.nextToken();
/* 581 */             glyph.width = Integer.parseInt(stringTokenizer.nextToken());
/* 582 */             stringTokenizer.nextToken();
/* 583 */             glyph.height = Integer.parseInt(stringTokenizer.nextToken());
/* 584 */             stringTokenizer.nextToken();
/* 585 */             glyph.xoffset = Integer.parseInt(stringTokenizer.nextToken());
/* 586 */             stringTokenizer.nextToken();
/* 587 */             if (param1Boolean) {
/* 588 */               glyph.yoffset = Integer.parseInt(stringTokenizer.nextToken());
/*     */             } else {
/* 590 */               glyph.yoffset = -(glyph.height + Integer.parseInt(stringTokenizer.nextToken()));
/* 591 */             }  stringTokenizer.nextToken();
/* 592 */             glyph.xadvance = Integer.parseInt(stringTokenizer.nextToken());
/*     */ 
/*     */             
/* 595 */             if (stringTokenizer.hasMoreTokens()) stringTokenizer.nextToken(); 
/* 596 */             if (stringTokenizer.hasMoreTokens()) {
/*     */               try {
/* 598 */                 glyph.page = Integer.parseInt(stringTokenizer.nextToken());
/* 599 */               } catch (NumberFormatException numberFormatException) {}
/*     */             }
/*     */ 
/*     */             
/* 603 */             if (glyph.width > 0 && glyph.height > 0) this.descent = Math.min(f2 + glyph.yoffset, this.descent); 
/*     */           } 
/* 605 */         }  this.descent += this.padBottom;
/*     */ 
/*     */ 
/*     */         
/* 609 */         while ((str1 = bufferedReader.readLine()) != null && 
/* 610 */           str1.startsWith("kerning ")) {
/*     */           StringTokenizer stringTokenizer;
/*     */           
/* 613 */           (stringTokenizer = new StringTokenizer(str1, " =")).nextToken();
/* 614 */           stringTokenizer.nextToken();
/* 615 */           int m = Integer.parseInt(stringTokenizer.nextToken());
/* 616 */           stringTokenizer.nextToken();
/* 617 */           int n = Integer.parseInt(stringTokenizer.nextToken());
/* 618 */           if (m >= 0 && m <= 65535 && n >= 0 && n <= 65535) {
/* 619 */             BitmapFont.Glyph glyph = getGlyph((char)m);
/* 620 */             stringTokenizer.nextToken();
/* 621 */             i = Integer.parseInt(stringTokenizer.nextToken());
/* 622 */             if (glyph != null) {
/* 623 */               glyph.setKerning(n, i);
/*     */             }
/*     */           } 
/*     */         } 
/* 627 */         b1 = 0;
/* 628 */         float f4 = 0.0F;
/* 629 */         float f5 = 0.0F;
/* 630 */         float f6 = 0.0F;
/* 631 */         float f3 = 0.0F;
/* 632 */         float f7 = 0.0F;
/* 633 */         float f8 = 0.0F;
/* 634 */         float f9 = 0.0F;
/*     */ 
/*     */         
/* 637 */         if (str1 != null && str1.startsWith("metrics ")) {
/*     */           
/* 639 */           b1 = 1;
/*     */           
/*     */           StringTokenizer stringTokenizer;
/* 642 */           (stringTokenizer = new StringTokenizer(str1, " =")).nextToken();
/* 643 */           stringTokenizer.nextToken();
/* 644 */           f4 = Float.parseFloat(stringTokenizer.nextToken());
/* 645 */           stringTokenizer.nextToken();
/* 646 */           f5 = Float.parseFloat(stringTokenizer.nextToken());
/* 647 */           stringTokenizer.nextToken();
/* 648 */           f6 = Float.parseFloat(stringTokenizer.nextToken());
/* 649 */           stringTokenizer.nextToken();
/* 650 */           f3 = Float.parseFloat(stringTokenizer.nextToken());
/* 651 */           stringTokenizer.nextToken();
/* 652 */           f7 = Float.parseFloat(stringTokenizer.nextToken());
/* 653 */           stringTokenizer.nextToken();
/* 654 */           f8 = Float.parseFloat(stringTokenizer.nextToken());
/* 655 */           stringTokenizer.nextToken();
/* 656 */           f9 = Float.parseFloat(stringTokenizer.nextToken());
/*     */         } 
/*     */         
/*     */         BitmapFont.Glyph glyph2;
/* 660 */         if ((glyph2 = getGlyph(' ')) == null) {
/*     */           
/* 662 */           (glyph2 = new BitmapFont.Glyph()).id = 32;
/*     */           BitmapFont.Glyph glyph;
/* 664 */           if ((glyph = getGlyph('l')) == null) glyph = getFirstGlyph(); 
/* 665 */           glyph2.xadvance = glyph.xadvance;
/* 666 */           setGlyph(32, glyph2);
/*     */         } 
/* 668 */         if (glyph2.width == 0) {
/* 669 */           glyph2.width = (int)(this.padLeft + glyph2.xadvance + this.padRight);
/* 670 */           glyph2.xoffset = (int)-this.padLeft;
/*     */         } 
/* 672 */         this.spaceXadvance = glyph2.xadvance;
/*     */         
/* 674 */         Object object = null; char arrayOfChar1[], c2; BitmapFont.Glyph glyph3; int j, k;
/* 675 */         for (j = (arrayOfChar1 = this.xChars).length, k = 0, c2 = arrayOfChar1[k]; k < j && (
/*     */           
/* 677 */           glyph3 = getGlyph(c2)) == null; k++);
/*     */         
/* 679 */         if (glyph3 == null) glyph3 = getFirstGlyph(); 
/* 680 */         this.xHeight = glyph3.height - f1;
/*     */         
/* 682 */         arrayOfChar1 = null; char c1; BitmapFont.Glyph glyph1; byte b2; char[] arrayOfChar2;
/* 683 */         for (k = (arrayOfChar2 = this.capChars).length, b2 = 0, c1 = arrayOfChar2[b2]; b2 < k && (
/*     */           
/* 685 */           glyph1 = getGlyph(c1)) == null; b2++);
/*     */         
/* 687 */         if (glyph1 == null)
/* 688 */         { BitmapFont.Glyph[][] arrayOfGlyph1; for (k = (arrayOfGlyph1 = this.glyphs).length, b2 = 0; b2 < k; b2++) {
/* 689 */             if ((arrayOfGlyph = arrayOfGlyph1[b2]) != null) {
/* 690 */               int m; byte b; for (m = (arrayOfGlyph = arrayOfGlyph).length, b = 0; b < m; ) {
/* 691 */                 BitmapFont.Glyph glyph; if ((glyph = arrayOfGlyph[b]) != null && glyph.height != 0 && glyph.width != 0)
/* 692 */                   this.capHeight = Math.max(this.capHeight, glyph.height);  b++;
/*     */               } 
/*     */             } 
/*     */           }  }
/* 696 */         else { this.capHeight = ((BitmapFont.Glyph)arrayOfGlyph).height; }
/* 697 */          this.capHeight -= f1;
/*     */         
/* 699 */         this.ascent = f2 - this.capHeight;
/* 700 */         this.down = -this.lineHeight;
/* 701 */         if (param1Boolean) {
/* 702 */           this.ascent = -this.ascent;
/* 703 */           this.down = -this.down;
/*     */         } 
/*     */         
/* 706 */         if (b1 != 0) {
/* 707 */           this.ascent = f4;
/* 708 */           this.descent = f5;
/* 709 */           this.down = f6;
/* 710 */           this.capHeight = f3;
/* 711 */           this.lineHeight = f7;
/* 712 */           this.spaceXadvance = f8;
/* 713 */           this.xHeight = f9;
/*     */         } 
/*     */         return;
/* 716 */       } catch (Exception exception) {
/* 717 */         throw new GdxRuntimeException("Error loading font file: " + param1FileHandle, exception);
/*     */       } finally {
/* 719 */         StreamUtils.closeQuietly(bufferedReader);
/*     */       } 
/*     */     }
/*     */     
/*     */     public void setGlyphRegion(BitmapFont.Glyph param1Glyph, TextureRegion param1TextureRegion) {
/* 724 */       Texture texture = param1TextureRegion.getTexture();
/* 725 */       float f3 = 1.0F / texture.getWidth();
/* 726 */       float f2 = 1.0F / texture.getHeight();
/*     */       
/* 728 */       float f4 = 0.0F, f5 = 0.0F;
/* 729 */       float f6 = param1TextureRegion.u;
/* 730 */       float f7 = param1TextureRegion.v;
/* 731 */       float f8 = param1TextureRegion.getRegionWidth();
/* 732 */       float f9 = param1TextureRegion.getRegionHeight();
/* 733 */       if (param1TextureRegion instanceof TextureAtlas.AtlasRegion) {
/*     */ 
/*     */         
/* 736 */         f4 = ((TextureAtlas.AtlasRegion)(param1TextureRegion = param1TextureRegion)).offsetX;
/* 737 */         f5 = (((TextureAtlas.AtlasRegion)param1TextureRegion).originalHeight - ((TextureAtlas.AtlasRegion)param1TextureRegion).packedHeight) - ((TextureAtlas.AtlasRegion)param1TextureRegion).offsetY;
/*     */       } 
/*     */       
/* 740 */       float f1 = param1Glyph.srcX;
/* 741 */       float f10 = (param1Glyph.srcX + param1Glyph.width);
/* 742 */       float f11 = param1Glyph.srcY;
/* 743 */       float f12 = (param1Glyph.srcY + param1Glyph.height);
/*     */ 
/*     */ 
/*     */       
/* 747 */       if (f4 > 0.0F) {
/*     */         
/* 749 */         if ((f1 = f1 - f4) < 0.0F) {
/* 750 */           param1Glyph.width = (int)(param1Glyph.width + f1);
/* 751 */           param1Glyph.xoffset = (int)(param1Glyph.xoffset - f1);
/* 752 */           f1 = 0.0F;
/*     */         } 
/*     */         
/* 755 */         if ((f10 = f10 - f4) > f8) {
/* 756 */           param1Glyph.width = (int)(param1Glyph.width - f10 - f8);
/* 757 */           f10 = f8;
/*     */         } 
/*     */       } 
/* 760 */       if (f5 > 0.0F) {
/*     */         
/* 762 */         if ((f11 = f11 - f5) < 0.0F) {
/* 763 */           param1Glyph.height = (int)(param1Glyph.height + f11);
/* 764 */           if (param1Glyph.height < 0) param1Glyph.height = 0; 
/* 765 */           f11 = 0.0F;
/*     */         } 
/*     */         
/* 768 */         if ((f12 = f12 - f5) > f9) {
/* 769 */           f4 = f12 - f9;
/* 770 */           param1Glyph.height = (int)(param1Glyph.height - f4);
/* 771 */           param1Glyph.yoffset = (int)(param1Glyph.yoffset + f4);
/* 772 */           f12 = f9;
/*     */         } 
/*     */       } 
/*     */       
/* 776 */       param1Glyph.u = f6 + f1 * f3;
/* 777 */       param1Glyph.u2 = f6 + f10 * f3;
/* 778 */       if (this.flipped) {
/* 779 */         param1Glyph.v = f7 + f11 * f2;
/* 780 */         param1Glyph.v2 = f7 + f12 * f2; return;
/*     */       } 
/* 782 */       param1Glyph.v2 = f7 + f11 * f2;
/* 783 */       param1Glyph.v = f7 + f12 * f2;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public void setLineHeight(float param1Float) {
/* 789 */       this.lineHeight = param1Float * this.scaleY;
/* 790 */       this.down = this.flipped ? this.lineHeight : -this.lineHeight;
/*     */     }
/*     */     
/*     */     public void setGlyph(int param1Int, BitmapFont.Glyph param1Glyph) {
/*     */       BitmapFont.Glyph[] arrayOfGlyph;
/* 795 */       if ((arrayOfGlyph = this.glyphs[param1Int / 512]) == null) this.glyphs[param1Int / 512] = arrayOfGlyph = new BitmapFont.Glyph[512]; 
/* 796 */       arrayOfGlyph[param1Int & 0x1FF] = param1Glyph; } public BitmapFont.Glyph getFirstGlyph() {
/*     */       BitmapFont.Glyph[][] arrayOfGlyph;
/*     */       int i;
/*     */       byte b;
/* 800 */       for (i = (arrayOfGlyph = this.glyphs).length, b = 0; b < i; b++) {
/* 801 */         BitmapFont.Glyph[] arrayOfGlyph1; if ((arrayOfGlyph1 = arrayOfGlyph[b]) != null) {
/* 802 */           int j; byte b1; for (j = (arrayOfGlyph1 = arrayOfGlyph1).length, b1 = 0; b1 < j; ) {
/* 803 */             BitmapFont.Glyph glyph; if ((glyph = arrayOfGlyph1[b1]) != null && glyph.height != 0 && glyph.width != 0)
/* 804 */               return glyph;  b1++;
/*     */           } 
/*     */         } 
/* 807 */       }  throw new GdxRuntimeException("No glyphs found.");
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean hasGlyph(char param1Char) {
/* 812 */       if (this.missingGlyph != null) return true; 
/* 813 */       return (getGlyph(param1Char) != null);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public BitmapFont.Glyph getGlyph(char param1Char) {
/*     */       BitmapFont.Glyph[] arrayOfGlyph;
/* 821 */       if ((arrayOfGlyph = this.glyphs[param1Char / 512]) != null) return arrayOfGlyph[param1Char & 0x1FF]; 
/* 822 */       return null;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public void getGlyphs(GlyphLayout.GlyphRun param1GlyphRun, CharSequence param1CharSequence, int param1Int1, int param1Int2, BitmapFont.Glyph param1Glyph) {
/*     */       int i;
/* 832 */       if ((i = param1Int2 - param1Int1) == 0)
/* 833 */         return;  boolean bool = this.markupEnabled;
/* 834 */       float f = this.scaleX;
/* 835 */       Array<BitmapFont.Glyph> array = param1GlyphRun.glyphs;
/* 836 */       FloatArray floatArray = param1GlyphRun.xAdvances;
/*     */ 
/*     */       
/* 839 */       array.ensureCapacity(i);
/* 840 */       param1GlyphRun.xAdvances.ensureCapacity(i + 1);
/*     */       
/*     */       while (true) {
/*     */         char c;
/* 844 */         while ((c = param1CharSequence.charAt(param1Int1++)) != '\r') {
/*     */           BitmapFont.Glyph glyph;
/* 846 */           if ((glyph = getGlyph(c)) == null)
/* 847 */             if (this.missingGlyph != null)
/* 848 */             { glyph = this.missingGlyph; }
/*     */             else { break; }
/* 850 */               array.add(glyph);
/* 851 */           floatArray.add((param1Glyph == null) ? (
/* 852 */               glyph.fixedWidth ? 0.0F : (-glyph.xoffset * f - this.padLeft)) : ((
/* 853 */               param1Glyph.xadvance + param1Glyph.getKerning(c)) * f));
/* 854 */           param1Glyph = glyph;
/*     */ 
/*     */           
/* 857 */           if (bool && c == '[' && param1Int1 < param1Int2 && param1CharSequence.charAt(param1Int1) == '[') param1Int1++; 
/* 858 */         }  if (param1Int1 >= param1Int2) {
/* 859 */           if (param1Glyph != null) {
/*     */             
/* 861 */             float f1 = param1Glyph.fixedWidth ? (param1Glyph.xadvance * f) : ((param1Glyph.width + param1Glyph.xoffset) * f - this.padRight);
/* 862 */             floatArray.add(f1);
/*     */           } 
/*     */           return;
/*     */         } 
/*     */       } 
/*     */     }
/*     */     public int getWrapIndex(Array<BitmapFont.Glyph> param1Array, int param1Int) {
/* 869 */       param1Int--;
/*     */       Object[] arrayOfObject;
/* 871 */       char c = (char)((BitmapFont.Glyph)(arrayOfObject = param1Array.items)[param1Int]).id;
/* 872 */       if (isWhitespace(c)) return param1Int; 
/* 873 */       if (isBreakChar(c)) param1Int--; 
/* 874 */       for (; param1Int > 0; param1Int--) {
/* 875 */         c = (char)((BitmapFont.Glyph)arrayOfObject[param1Int]).id;
/* 876 */         if (isWhitespace(c) || isBreakChar(c)) return param1Int + 1; 
/*     */       } 
/* 878 */       return 0;
/*     */     }
/*     */     
/*     */     public boolean isBreakChar(char param1Char) {
/* 882 */       if (this.breakChars == null) return false;  char[] arrayOfChar; int i; byte b;
/* 883 */       for (i = (arrayOfChar = this.breakChars).length, b = 0; b < i; ) { char c = arrayOfChar[b];
/* 884 */         if (param1Char == c) return true;  b++; }
/* 885 */        return false;
/*     */     }
/*     */     
/*     */     public boolean isWhitespace(char param1Char) {
/* 889 */       switch (param1Char) {
/*     */         case '\t':
/*     */         case '\n':
/*     */         case '\r':
/*     */         case ' ':
/* 894 */           return true;
/*     */       } 
/* 896 */       return false;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public String getImagePath(int param1Int) {
/* 902 */       return this.imagePaths[param1Int];
/*     */     }
/*     */     
/*     */     public String[] getImagePaths() {
/* 906 */       return this.imagePaths;
/*     */     }
/*     */     
/*     */     public FileHandle getFontFile() {
/* 910 */       return this.fontFile;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public void setScale(float param1Float1, float param1Float2) {
/* 919 */       if (param1Float1 == 0.0F) throw new IllegalArgumentException("scaleX cannot be 0."); 
/* 920 */       if (param1Float2 == 0.0F) throw new IllegalArgumentException("scaleY cannot be 0."); 
/* 921 */       float f1 = param1Float1 / this.scaleX;
/* 922 */       float f2 = param1Float2 / this.scaleY;
/* 923 */       this.lineHeight *= f2;
/* 924 */       this.spaceXadvance *= f1;
/* 925 */       this.xHeight *= f2;
/* 926 */       this.capHeight *= f2;
/* 927 */       this.ascent *= f2;
/* 928 */       this.descent *= f2;
/* 929 */       this.down *= f2;
/* 930 */       this.padLeft *= f1;
/* 931 */       this.padRight *= f1;
/* 932 */       this.padTop *= f2;
/* 933 */       this.padBottom *= f2;
/* 934 */       this.scaleX = param1Float1;
/* 935 */       this.scaleY = param1Float2;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public void setScale(float param1Float) {
/* 942 */       setScale(param1Float, param1Float);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public void scale(float param1Float) {
/* 949 */       setScale(this.scaleX + param1Float, this.scaleY + param1Float);
/*     */     }
/*     */     
/*     */     public String toString() {
/* 953 */       return (this.name != null) ? this.name : super.toString();
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gdx\graphics\g2d\BitmapFont.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */