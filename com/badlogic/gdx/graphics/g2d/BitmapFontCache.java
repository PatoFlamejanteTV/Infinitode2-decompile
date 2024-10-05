/*     */ package com.badlogic.gdx.graphics.g2d;
/*     */ 
/*     */ import com.badlogic.gdx.graphics.Color;
/*     */ import com.badlogic.gdx.utils.Array;
/*     */ import com.badlogic.gdx.utils.IntArray;
/*     */ import com.badlogic.gdx.utils.NumberUtils;
/*     */ import com.badlogic.gdx.utils.Pools;
/*     */ import java.util.Arrays;
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
/*     */ public class BitmapFontCache
/*     */ {
/*  37 */   private static final Color tempColor = new Color(1.0F, 1.0F, 1.0F, 1.0F);
/*     */   
/*     */   private final BitmapFont font;
/*     */   private boolean integer;
/*  41 */   private final Array<GlyphLayout> layouts = new Array(1);
/*  42 */   private final Array<GlyphLayout> pooledLayouts = new Array(0); private int glyphCount;
/*     */   private float x;
/*     */   private float y;
/*  45 */   private final Color color = new Color(1.0F, 1.0F, 1.0F, 1.0F);
/*     */   
/*     */   private float currentTint;
/*     */   
/*     */   private float[][] pageVertices;
/*     */   
/*     */   private int[] idx;
/*     */   
/*     */   private IntArray[] pageGlyphIndices;
/*     */   
/*     */   private int[] tempGlyphCount;
/*     */ 
/*     */   
/*     */   public BitmapFontCache(BitmapFont paramBitmapFont) {
/*  59 */     this(paramBitmapFont, paramBitmapFont.usesIntegerPositions());
/*     */   }
/*     */ 
/*     */   
/*     */   public BitmapFontCache(BitmapFont paramBitmapFont, boolean paramBoolean) {
/*  64 */     this.font = paramBitmapFont;
/*  65 */     this.integer = paramBoolean;
/*     */     
/*     */     int i;
/*  68 */     if ((i = paramBitmapFont.regions.size) == 0) throw new IllegalArgumentException("The specified font must contain at least one texture page.");
/*     */     
/*  70 */     this.pageVertices = new float[i][];
/*  71 */     this.idx = new int[i];
/*  72 */     if (i > 1) {
/*     */       
/*  74 */       this.pageGlyphIndices = new IntArray[i]; int j;
/*  75 */       for (paramBoolean = false, j = this.pageGlyphIndices.length; paramBoolean < j; paramBoolean++)
/*  76 */         this.pageGlyphIndices[paramBoolean] = new IntArray(); 
/*     */     } 
/*  78 */     this.tempGlyphCount = new int[i];
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setPosition(float paramFloat1, float paramFloat2) {
/*  85 */     translate(paramFloat1 - this.x, paramFloat2 - this.y);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void translate(float paramFloat1, float paramFloat2) {
/*  92 */     if (paramFloat1 == 0.0F && paramFloat2 == 0.0F)
/*  93 */       return;  if (this.integer) {
/*  94 */       paramFloat1 = Math.round(paramFloat1);
/*  95 */       paramFloat2 = Math.round(paramFloat2);
/*     */     } 
/*  97 */     this.x += paramFloat1;
/*  98 */     this.y += paramFloat2;
/*     */     
/* 100 */     float[][] arrayOfFloat = this.pageVertices; byte b; int i;
/* 101 */     for (b = 0, i = arrayOfFloat.length; b < i; b++) {
/* 102 */       float[] arrayOfFloat1 = arrayOfFloat[b]; byte b1; int j;
/* 103 */       for (b1 = 0, j = this.idx[b]; b1 < j; b1 += 5) {
/* 104 */         arrayOfFloat1[b1] = arrayOfFloat1[b1] + paramFloat1;
/* 105 */         arrayOfFloat1[b1 + 1] = arrayOfFloat1[b1 + 1] + paramFloat2;
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void tint(Color paramColor) {
/* 112 */     float f = paramColor.toFloatBits();
/* 113 */     if (this.currentTint == f)
/* 114 */       return;  this.currentTint = f;
/*     */     
/* 116 */     float[][] arrayOfFloat = this.pageVertices;
/* 117 */     Color color = tempColor;
/*     */     int[] arrayOfInt;
/* 119 */     Arrays.fill(arrayOfInt = this.tempGlyphCount, 0); byte b;
/*     */     int i;
/* 121 */     for (b = 0, i = this.layouts.size; b < i; b++) {
/*     */       GlyphLayout glyphLayout;
/* 123 */       IntArray intArray = (glyphLayout = (GlyphLayout)this.layouts.get(b)).colors;
/* 124 */       byte b1 = 0; boolean bool = false; byte b2 = 0;
/* 125 */       float f1 = 0.0F; byte b3; int j;
/* 126 */       for (b3 = 0, j = glyphLayout.runs.size; b3 < j; b3++) {
/*     */         GlyphLayout.GlyphRun glyphRun;
/* 128 */         Object[] arrayOfObject = (glyphRun = (GlyphLayout.GlyphRun)glyphLayout.runs.get(b3)).glyphs.items; int k; byte b4;
/* 129 */         for (b4 = 0, k = glyphRun.glyphs.size; b4 < k; b4++) {
/* 130 */           if (b2++ == bool) {
/* 131 */             Color.abgr8888ToColor(color, intArray.get(++b1));
/* 132 */             f1 = color.mul(paramColor).toFloatBits();
/* 133 */             bool = (++b1 < intArray.size) ? intArray.get(b1) : true;
/*     */           } 
/* 135 */           int m = ((BitmapFont.Glyph)arrayOfObject[b4]).page;
/* 136 */           int n = arrayOfInt[m] * 20 + 2;
/* 137 */           arrayOfInt[m] = arrayOfInt[m] + 1;
/*     */           float[] arrayOfFloat1;
/* 139 */           (arrayOfFloat1 = arrayOfFloat[m])[n] = f1;
/* 140 */           arrayOfFloat1[n + 5] = f1;
/* 141 */           arrayOfFloat1[n + 10] = f1;
/* 142 */           arrayOfFloat1[n + 15] = f1;
/*     */         } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void setAlphas(float paramFloat) {
/* 150 */     int i = (int)(254.0F * paramFloat) << 24;
/* 151 */     float f1 = 0.0F, f2 = 0.0F; byte b; int j;
/* 152 */     for (b = 0, j = this.pageVertices.length; b < j; b++) {
/* 153 */       float[] arrayOfFloat = this.pageVertices[b]; byte b1; int k;
/* 154 */       for (b1 = 2, k = this.idx[b]; b1 < k; b1 += 5) {
/*     */         float f;
/* 156 */         if ((f = arrayOfFloat[b1]) == f1 && b1 != 2) {
/* 157 */           arrayOfFloat[b1] = f2;
/*     */         } else {
/* 159 */           f1 = f;
/*     */           
/*     */           int m;
/* 162 */           float f3 = NumberUtils.intToFloatColor(m = (m = NumberUtils.floatToIntColor(f)) & 0xFFFFFF | i);
/* 163 */           arrayOfFloat[b1] = f3;
/*     */         } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */   public void setColors(float paramFloat) {
/*     */     byte b;
/*     */     int i;
/* 171 */     for (b = 0, i = this.pageVertices.length; b < i; b++) {
/* 172 */       float[] arrayOfFloat = this.pageVertices[b]; byte b1; int j;
/* 173 */       for (b1 = 2, j = this.idx[b]; b1 < j; b1 += 5) {
/* 174 */         arrayOfFloat[b1] = paramFloat;
/*     */       }
/*     */     } 
/*     */   }
/*     */   
/*     */   public void setColors(Color paramColor) {
/* 180 */     setColors(paramColor.toFloatBits());
/*     */   }
/*     */ 
/*     */   
/*     */   public void setColors(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4) {
/* 185 */     int i = (int)(255.0F * paramFloat4) << 24 | (int)(255.0F * paramFloat3) << 16 | (int)(255.0F * paramFloat2) << 8 | (int)(255.0F * paramFloat1);
/* 186 */     setColors(NumberUtils.intToFloatColor(i));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setColors(Color paramColor, int paramInt1, int paramInt2) {
/* 192 */     setColors(paramColor.toFloatBits(), paramInt1, paramInt2);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setColors(float paramFloat, int paramInt1, int paramInt2) {
/* 198 */     if (this.pageVertices.length == 1) {
/* 199 */       float[] arrayOfFloat = this.pageVertices[0];
/* 200 */       for (int j = paramInt1 * 20 + 2, k = Math.min(paramInt2 * 20, this.idx[0]); j < k; j += 5) {
/* 201 */         arrayOfFloat[j] = paramFloat;
/*     */       }
/*     */       return;
/*     */     } 
/* 205 */     int i = this.pageVertices.length;
/* 206 */     for (byte b = 0; b < i; b++) {
/* 207 */       float[] arrayOfFloat = this.pageVertices[b];
/* 208 */       IntArray intArray = this.pageGlyphIndices[b]; byte b1;
/*     */       int j, k;
/* 210 */       for (b1 = 0, j = intArray.size; b1 < j && (
/*     */ 
/*     */ 
/*     */         
/* 214 */         k = intArray.items[b1]) < paramInt2; b1++) {
/*     */ 
/*     */         
/* 217 */         if (k >= paramInt1) {
/* 218 */           k = b1 * 20 + 2;
/* 219 */           arrayOfFloat[k] = paramFloat;
/* 220 */           arrayOfFloat[k + 5] = paramFloat;
/* 221 */           arrayOfFloat[k + 10] = paramFloat;
/* 222 */           arrayOfFloat[k + 15] = paramFloat;
/*     */         } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public Color getColor() {
/* 231 */     return this.color;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setColor(Color paramColor) {
/* 236 */     this.color.set(paramColor);
/*     */   }
/*     */ 
/*     */   
/*     */   public void setColor(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4) {
/* 241 */     this.color.set(paramFloat1, paramFloat2, paramFloat3, paramFloat4);
/*     */   }
/*     */   
/*     */   public void draw(Batch paramBatch) {
/* 245 */     Array<TextureRegion> array = this.font.getRegions(); byte b; int i;
/* 246 */     for (b = 0, i = this.pageVertices.length; b < i; b++) {
/* 247 */       if (this.idx[b] > 0) {
/* 248 */         float[] arrayOfFloat = this.pageVertices[b];
/* 249 */         paramBatch.draw(((TextureRegion)array.get(b)).getTexture(), arrayOfFloat, 0, this.idx[b]);
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   public void draw(Batch paramBatch, int paramInt1, int paramInt2) {
/* 255 */     if (this.pageVertices.length == 1) {
/* 256 */       paramBatch.draw(this.font.getRegion().getTexture(), this.pageVertices[0], paramInt1 * 20, (paramInt2 - paramInt1) * 20);
/*     */       
/*     */       return;
/*     */     } 
/*     */     
/* 261 */     Array<TextureRegion> array = this.font.getRegions(); byte b; int i;
/* 262 */     for (b = 0, i = this.pageVertices.length; b < i; b++) {
/* 263 */       byte b1 = -1; byte b2 = 0;
/*     */ 
/*     */       
/* 266 */       IntArray intArray = this.pageGlyphIndices[b]; byte b3; int j, k;
/* 267 */       for (b3 = 0, j = intArray.size; b3 < j && (
/*     */ 
/*     */ 
/*     */         
/* 271 */         k = intArray.get(b3)) < paramInt2; b3++) {
/*     */ 
/*     */         
/* 274 */         if (b1 == -1 && k >= paramInt1) b1 = b3;
/*     */ 
/*     */         
/* 277 */         if (k >= paramInt1) b2++;
/*     */       
/*     */       } 
/*     */       
/* 281 */       if (b1 != -1 && b2 != 0)
/*     */       {
/*     */         
/* 284 */         paramBatch.draw(((TextureRegion)array.get(b)).getTexture(), this.pageVertices[b], b1 * 20, b2 * 20); } 
/*     */     } 
/*     */   }
/*     */   
/*     */   public void draw(Batch paramBatch, float paramFloat) {
/* 289 */     if (paramFloat == 1.0F) {
/* 290 */       draw(paramBatch);
/*     */       return;
/*     */     } 
/*     */     Color color;
/* 294 */     float f = (color = getColor()).a;
/* 295 */     color.a *= paramFloat;
/* 296 */     setColors(color);
/* 297 */     draw(paramBatch);
/* 298 */     color.a = f;
/* 299 */     setColors(color);
/*     */   }
/*     */ 
/*     */   
/*     */   public void clear() {
/* 304 */     this.x = 0.0F;
/* 305 */     this.y = 0.0F;
/* 306 */     Pools.freeAll(this.pooledLayouts, true);
/* 307 */     this.pooledLayouts.clear();
/* 308 */     this.layouts.clear(); byte b; int i;
/* 309 */     for (b = 0, i = this.idx.length; b < i; b++) {
/* 310 */       if (this.pageGlyphIndices != null) this.pageGlyphIndices[b].clear(); 
/* 311 */       this.idx[b] = 0;
/*     */     } 
/*     */   }
/*     */   
/*     */   private void requireGlyphs(GlyphLayout paramGlyphLayout) {
/* 316 */     if (this.pageVertices.length == 1) {
/*     */       
/* 318 */       requirePageGlyphs(0, paramGlyphLayout.glyphCount); return;
/*     */     } 
/*     */     int[] arrayOfInt;
/* 321 */     Arrays.fill(arrayOfInt = this.tempGlyphCount, 0); byte b;
/*     */     int i;
/* 323 */     for (b = 0, i = paramGlyphLayout.runs.size; b < i; b++) {
/*     */       Array<BitmapFont.Glyph> array;
/* 325 */       Object[] arrayOfObject = (array = ((GlyphLayout.GlyphRun)paramGlyphLayout.runs.get(b)).glyphs).items; int j; byte b1;
/* 326 */       for (b1 = 0, j = array.size; b1 < j; b1++) {
/* 327 */         arrayOfInt[((BitmapFont.Glyph)arrayOfObject[b1]).page] = arrayOfInt[((BitmapFont.Glyph)arrayOfObject[b1]).page] + 1;
/*     */       }
/*     */     } 
/* 330 */     for (b = 0, i = arrayOfInt.length; b < i; b++) {
/* 331 */       requirePageGlyphs(b, arrayOfInt[b]);
/*     */     }
/*     */   }
/*     */   
/*     */   private void requirePageGlyphs(int paramInt1, int paramInt2) {
/* 336 */     if (this.pageGlyphIndices != null && 
/* 337 */       paramInt2 > (this.pageGlyphIndices[paramInt1]).items.length) {
/* 338 */       this.pageGlyphIndices[paramInt1].ensureCapacity(paramInt2 - (this.pageGlyphIndices[paramInt1]).size);
/*     */     }
/*     */     
/* 341 */     paramInt2 = this.idx[paramInt1] + paramInt2 * 20;
/*     */     float[] arrayOfFloat;
/* 343 */     if ((arrayOfFloat = this.pageVertices[paramInt1]) == null) {
/* 344 */       this.pageVertices[paramInt1] = new float[paramInt2]; return;
/* 345 */     }  if (arrayOfFloat.length < paramInt2) {
/* 346 */       float[] arrayOfFloat1 = new float[paramInt2];
/* 347 */       System.arraycopy(arrayOfFloat, 0, arrayOfFloat1, 0, this.idx[paramInt1]);
/* 348 */       this.pageVertices[paramInt1] = arrayOfFloat1;
/*     */     } 
/*     */   }
/*     */   
/*     */   private void setPageCount(int paramInt) {
/* 353 */     float[][] arrayOfFloat = new float[paramInt][];
/* 354 */     System.arraycopy(this.pageVertices, 0, arrayOfFloat, 0, this.pageVertices.length);
/* 355 */     this.pageVertices = arrayOfFloat;
/*     */     
/* 357 */     int[] arrayOfInt = new int[paramInt];
/* 358 */     System.arraycopy(this.idx, 0, arrayOfInt, 0, this.idx.length);
/* 359 */     this.idx = arrayOfInt;
/*     */     
/* 361 */     IntArray[] arrayOfIntArray = new IntArray[paramInt];
/* 362 */     int i = 0;
/* 363 */     if (this.pageGlyphIndices != null) {
/* 364 */       i = this.pageGlyphIndices.length;
/* 365 */       System.arraycopy(this.pageGlyphIndices, 0, arrayOfIntArray, 0, this.pageGlyphIndices.length);
/*     */     } 
/* 367 */     for (i = i; i < paramInt; i++)
/* 368 */       arrayOfIntArray[i] = new IntArray(); 
/* 369 */     this.pageGlyphIndices = arrayOfIntArray;
/*     */     
/* 371 */     this.tempGlyphCount = new int[paramInt];
/*     */   }
/*     */   
/*     */   private void addToCache(GlyphLayout paramGlyphLayout, float paramFloat1, float paramFloat2) {
/*     */     int i;
/* 376 */     if ((i = paramGlyphLayout.runs.size) == 0) {
/*     */       return;
/*     */     }
/* 379 */     if (this.pageVertices.length < this.font.regions.size) setPageCount(this.font.regions.size);
/*     */     
/* 381 */     this.layouts.add(paramGlyphLayout);
/* 382 */     requireGlyphs(paramGlyphLayout);
/*     */     
/* 384 */     IntArray intArray = paramGlyphLayout.colors;
/* 385 */     byte b1 = 0; boolean bool = false; byte b2 = 0;
/* 386 */     float f = 0.0F;
/* 387 */     for (byte b3 = 0; b3 < i; b3++) {
/*     */       GlyphLayout.GlyphRun glyphRun;
/* 389 */       Object[] arrayOfObject = (glyphRun = (GlyphLayout.GlyphRun)paramGlyphLayout.runs.get(b3)).glyphs.items;
/* 390 */       float[] arrayOfFloat = glyphRun.xAdvances.items;
/* 391 */       float f1 = paramFloat1 + glyphRun.x, f2 = paramFloat2 + glyphRun.y; int j; byte b;
/* 392 */       for (b = 0, j = glyphRun.glyphs.size; b < j; b++) {
/* 393 */         if (b2++ == bool) {
/* 394 */           f = NumberUtils.intToFloatColor(intArray.get(++b1));
/* 395 */           bool = (++b1 < intArray.size) ? intArray.get(b1) : true;
/*     */         } 
/* 397 */         f1 += arrayOfFloat[b];
/* 398 */         addGlyph((BitmapFont.Glyph)arrayOfObject[b], f1, f2, f);
/*     */       } 
/*     */     } 
/*     */     
/* 402 */     this.currentTint = Color.WHITE_FLOAT_BITS;
/*     */   }
/*     */   
/*     */   private void addGlyph(BitmapFont.Glyph paramGlyph, float paramFloat1, float paramFloat2, float paramFloat3) {
/* 406 */     float f1 = this.font.data.scaleX, f2 = this.font.data.scaleY;
/* 407 */     paramFloat1 += paramGlyph.xoffset * f1;
/* 408 */     paramFloat2 += paramGlyph.yoffset * f2;
/* 409 */     f1 = paramGlyph.width * f1; f2 = paramGlyph.height * f2;
/* 410 */     float f3 = paramGlyph.u, f4 = paramGlyph.u2, f5 = paramGlyph.v, f6 = paramGlyph.v2;
/*     */     
/* 412 */     if (this.integer) {
/* 413 */       paramFloat1 = Math.round(paramFloat1);
/* 414 */       paramFloat2 = Math.round(paramFloat2);
/* 415 */       f1 = Math.round(f1);
/* 416 */       f2 = Math.round(f2);
/*     */     } 
/* 418 */     f1 = paramFloat1 + f1; f2 = paramFloat2 + f2;
/*     */     
/* 420 */     int i = paramGlyph.page;
/* 421 */     int j = this.idx[i];
/* 422 */     this.idx[i] = this.idx[i] + 20;
/*     */     
/* 424 */     if (this.pageGlyphIndices != null) this.pageGlyphIndices[i].add(this.glyphCount++);
/*     */     
/*     */     float[] arrayOfFloat;
/* 427 */     (arrayOfFloat = this.pageVertices[i])[j++] = paramFloat1;
/* 428 */     arrayOfFloat[j++] = paramFloat2;
/* 429 */     arrayOfFloat[j++] = paramFloat3;
/* 430 */     arrayOfFloat[j++] = f3;
/* 431 */     arrayOfFloat[j++] = f5;
/*     */     
/* 433 */     arrayOfFloat[j++] = paramFloat1;
/* 434 */     arrayOfFloat[j++] = f2;
/* 435 */     arrayOfFloat[j++] = paramFloat3;
/* 436 */     arrayOfFloat[j++] = f3;
/* 437 */     arrayOfFloat[j++] = f6;
/*     */     
/* 439 */     arrayOfFloat[j++] = f1;
/* 440 */     arrayOfFloat[j++] = f2;
/* 441 */     arrayOfFloat[j++] = paramFloat3;
/* 442 */     arrayOfFloat[j++] = f4;
/* 443 */     arrayOfFloat[j++] = f6;
/*     */     
/* 445 */     arrayOfFloat[j++] = f1;
/* 446 */     arrayOfFloat[j++] = paramFloat2;
/* 447 */     arrayOfFloat[j++] = paramFloat3;
/* 448 */     arrayOfFloat[j++] = f4;
/* 449 */     arrayOfFloat[j] = f5;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public GlyphLayout setText(CharSequence paramCharSequence, float paramFloat1, float paramFloat2) {
/* 455 */     clear();
/* 456 */     return addText(paramCharSequence, paramFloat1, paramFloat2, 0, paramCharSequence.length(), 0.0F, 8, false);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public GlyphLayout setText(CharSequence paramCharSequence, float paramFloat1, float paramFloat2, float paramFloat3, int paramInt, boolean paramBoolean) {
/* 462 */     clear();
/* 463 */     return addText(paramCharSequence, paramFloat1, paramFloat2, 0, paramCharSequence.length(), paramFloat3, paramInt, paramBoolean);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public GlyphLayout setText(CharSequence paramCharSequence, float paramFloat1, float paramFloat2, int paramInt1, int paramInt2, float paramFloat3, int paramInt3, boolean paramBoolean) {
/* 470 */     clear();
/* 471 */     return addText(paramCharSequence, paramFloat1, paramFloat2, paramInt1, paramInt2, paramFloat3, paramInt3, paramBoolean);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public GlyphLayout setText(CharSequence paramCharSequence, float paramFloat1, float paramFloat2, int paramInt1, int paramInt2, float paramFloat3, int paramInt3, boolean paramBoolean, String paramString) {
/* 478 */     clear();
/* 479 */     return addText(paramCharSequence, paramFloat1, paramFloat2, paramInt1, paramInt2, paramFloat3, paramInt3, paramBoolean, paramString);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setText(GlyphLayout paramGlyphLayout, float paramFloat1, float paramFloat2) {
/* 485 */     clear();
/* 486 */     addText(paramGlyphLayout, paramFloat1, paramFloat2);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public GlyphLayout addText(CharSequence paramCharSequence, float paramFloat1, float paramFloat2) {
/* 492 */     return addText(paramCharSequence, paramFloat1, paramFloat2, 0, paramCharSequence.length(), 0.0F, 8, false, null);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public GlyphLayout addText(CharSequence paramCharSequence, float paramFloat1, float paramFloat2, float paramFloat3, int paramInt, boolean paramBoolean) {
/* 498 */     return addText(paramCharSequence, paramFloat1, paramFloat2, 0, paramCharSequence.length(), paramFloat3, paramInt, paramBoolean, null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public GlyphLayout addText(CharSequence paramCharSequence, float paramFloat1, float paramFloat2, int paramInt1, int paramInt2, float paramFloat3, int paramInt3, boolean paramBoolean) {
/* 505 */     return addText(paramCharSequence, paramFloat1, paramFloat2, paramInt1, paramInt2, paramFloat3, paramInt3, paramBoolean, null);
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
/*     */ 
/*     */ 
/*     */   
/*     */   public GlyphLayout addText(CharSequence paramCharSequence, float paramFloat1, float paramFloat2, int paramInt1, int paramInt2, float paramFloat3, int paramInt3, boolean paramBoolean, String paramString) {
/* 521 */     GlyphLayout glyphLayout = (GlyphLayout)Pools.obtain(GlyphLayout.class);
/* 522 */     this.pooledLayouts.add(glyphLayout);
/* 523 */     glyphLayout.setText(this.font, paramCharSequence, paramInt1, paramInt2, this.color, paramFloat3, paramInt3, paramBoolean, paramString);
/* 524 */     addText(glyphLayout, paramFloat1, paramFloat2);
/* 525 */     return glyphLayout;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void addText(GlyphLayout paramGlyphLayout, float paramFloat1, float paramFloat2) {
/* 531 */     addToCache(paramGlyphLayout, paramFloat1, paramFloat2 + this.font.data.ascent);
/*     */   }
/*     */ 
/*     */   
/*     */   public float getX() {
/* 536 */     return this.x;
/*     */   }
/*     */ 
/*     */   
/*     */   public float getY() {
/* 541 */     return this.y;
/*     */   }
/*     */   
/*     */   public BitmapFont getFont() {
/* 545 */     return this.font;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setUseIntegerPositions(boolean paramBoolean) {
/* 551 */     this.integer = paramBoolean;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean usesIntegerPositions() {
/* 556 */     return this.integer;
/*     */   }
/*     */   
/*     */   public float[] getVertices() {
/* 560 */     return getVertices(0);
/*     */   }
/*     */   
/*     */   public float[] getVertices(int paramInt) {
/* 564 */     return this.pageVertices[paramInt];
/*     */   }
/*     */   
/*     */   public int getVertexCount(int paramInt) {
/* 568 */     return this.idx[paramInt];
/*     */   }
/*     */   
/*     */   public Array<GlyphLayout> getLayouts() {
/* 572 */     return this.layouts;
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gdx\graphics\g2d\BitmapFontCache.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */