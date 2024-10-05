/*     */ package com.prineside.tdi2.utils;
/*     */ 
/*     */ import com.badlogic.gdx.graphics.Color;
/*     */ import com.badlogic.gdx.graphics.g2d.Batch;
/*     */ import com.badlogic.gdx.graphics.g2d.TextureRegion;
/*     */ import com.badlogic.gdx.math.MathUtils;
/*     */ import com.badlogic.gdx.math.Vector2;
/*     */ import com.badlogic.gdx.utils.Array;
/*     */ import com.badlogic.gdx.utils.IntArray;
/*     */ import com.badlogic.gdx.utils.Null;
/*     */ import com.badlogic.gdx.utils.ShortArray;
/*     */ import com.badlogic.gdx.utils.reflect.ArrayReflection;
/*     */ import com.prineside.tdi2.Game;
/*     */ import com.prineside.tdi2.utils.logging.TLog;
/*     */ import java.util.Arrays;
/*     */ 
/*     */ public final class AABB<T> {
/*     */   static {
/*  19 */     TLog.forClass(AABB.class);
/*     */   }
/*  21 */   private short a = 0;
/*  22 */   private short b = 0;
/*  23 */   private float c = Float.MAX_VALUE;
/*  24 */   private float d = Float.MAX_VALUE;
/*  25 */   private float e = Float.MIN_VALUE;
/*  26 */   private float f = Float.MIN_VALUE;
/*     */   
/*     */   private float g;
/*     */   
/*     */   private float h;
/*     */   
/*     */   private T[] i;
/*  33 */   private BitVector j = new BitVector();
/*     */   
/*  35 */   private float[] k = new float[0];
/*     */ 
/*     */   
/*  38 */   private short[] l = new short[0];
/*  39 */   private short[] m = new short[0];
/*     */ 
/*     */   
/*     */   public Batch debugBatch;
/*     */ 
/*     */ 
/*     */   
/*     */   public final boolean isEmpty() {
/*  47 */     return (this.a == 0);
/*     */   }
/*     */   
/*     */   public final float getMinX() {
/*  51 */     return this.c;
/*     */   }
/*     */   
/*     */   public final float getMaxX() {
/*  55 */     return this.d;
/*     */   }
/*     */   
/*     */   public final float getMinY() {
/*  59 */     return this.e;
/*     */   }
/*     */   
/*     */   public final float getMaxY() {
/*  63 */     return this.f;
/*     */   }
/*     */   
/*     */   public final short getCols() {
/*  67 */     return this.a;
/*     */   }
/*     */   
/*     */   public final short getRows() {
/*  71 */     return this.b;
/*     */   }
/*     */   
/*     */   public final float getCellSizeXInv() {
/*  75 */     return this.g;
/*     */   }
/*     */   
/*     */   public final float getCellSizeYInv() {
/*  79 */     return this.h;
/*     */   }
/*     */ 
/*     */   
/*     */   public final int getEntityCount(int paramInt) {
/*  84 */     if ((paramInt = this.m[paramInt]) == -1) return 0;
/*     */     
/*  86 */     return this.l[paramInt];
/*     */   }
/*     */   
/*     */   public final boolean entriesExistInRect(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4) {
/*  90 */     return (paramFloat1 < this.d && paramFloat3 > this.c && paramFloat2 < this.f && paramFloat4 > this.e);
/*     */   }
/*     */   
/*     */   public final boolean lineCanHitEntry(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4) {
/*  94 */     float f1 = paramFloat1;
/*  95 */     float f2 = paramFloat3;
/*  96 */     if (paramFloat1 > paramFloat3) {
/*  97 */       f1 = paramFloat3;
/*  98 */       f2 = paramFloat1;
/*     */     } 
/* 100 */     paramFloat1 = paramFloat2;
/* 101 */     paramFloat3 = paramFloat4;
/* 102 */     if (paramFloat2 > paramFloat4) {
/* 103 */       paramFloat1 = paramFloat4;
/* 104 */       paramFloat3 = paramFloat2;
/*     */     } 
/* 106 */     return entriesExistInRect(f1, paramFloat1, f2, paramFloat3);
/*     */   }
/*     */   
/*     */   private void a(BitVector paramBitVector, EntryFilter paramEntryFilter, EntryRetriever<T> paramEntryRetriever) {
/* 110 */     int i = 0;
/*     */ 
/*     */     
/* 113 */     while ((i = paramBitVector.nextSetBit(i + 1)) != -1) {
/* 114 */       int j = i - 1;
/* 115 */       float f1 = this.k[j * 3];
/* 116 */       float f2 = this.k[j * 3 + 1];
/* 117 */       float f3 = this.k[j * 3 + 2];
/* 118 */       if (paramEntryFilter.test(f1, f2, f3)) {
/* 119 */         T t = this.i[j];
/* 120 */         if (paramEntryRetriever.retrieve(t, f1, f2, f3))
/*     */           continue; 
/*     */         break;
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   private short a(float paramFloat) {
/* 128 */     return (short)MathUtils.clamp((int)((paramFloat - this.c) * this.g), 0, this.a - 1);
/*     */   }
/*     */   
/*     */   private short b(float paramFloat) {
/* 132 */     return (short)MathUtils.clamp((int)((paramFloat - this.e) * this.h), 0, this.b - 1);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final void traverseEntriesInRect(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, EntryFilter paramEntryFilter, EntryRetriever<T> paramEntryRetriever) {
/*     */     BitVector bitVector;
/*     */     boolean bool;
/* 141 */     if (isEmpty())
/*     */       return; 
/* 143 */     short s1 = a(paramFloat1);
/* 144 */     short s3 = a(paramFloat3);
/* 145 */     short s2 = b(paramFloat2);
/* 146 */     short s4 = b(paramFloat4);
/*     */ 
/*     */ 
/*     */     
/* 150 */     if (this.j == null) {
/* 151 */       bitVector = new BitVector(this.i.length + 1);
/* 152 */       bool = false;
/*     */     } else {
/* 154 */       bitVector = this.j;
/* 155 */       this.j = null;
/* 156 */       bitVector.clear();
/* 157 */       bitVector.ensureCapacity(this.i.length + 1);
/* 158 */       bool = true;
/*     */     } 
/* 160 */     for (short s = s2; s <= s4; s++) {
/* 161 */       for (short s5 = s1; s5 <= s3; s5++) {
/* 162 */         int i = s * this.a + s5;
/*     */         short s6;
/* 164 */         if ((s6 = this.m[i]) != -1) {
/*     */           
/* 166 */           short s7 = this.l[s6];
/* 167 */           for (byte b = 0; b < s7; b++) {
/* 168 */             int j = this.l[s6 + b + 1] + 1;
/* 169 */             bitVector.unsafeSet(j);
/*     */           } 
/*     */         } 
/*     */       } 
/*     */     } 
/* 174 */     a(bitVector, paramEntryFilter, paramEntryRetriever);
/*     */     
/* 176 */     if (this.debugBatch != null) {
/* 177 */       float f1 = 1.0F / getCellSizeXInv();
/* 178 */       float f2 = 1.0F / getCellSizeYInv();
/*     */       int i;
/* 180 */       for (i = s2; i <= s4; i++) {
/* 181 */         for (short s5 = s1; s5 <= s3; s5++) {
/* 182 */           float f3 = s5 * f1 + this.c;
/* 183 */           float f4 = i * f2 + this.e;
/* 184 */           int j = i * this.a + s5;
/*     */           
/* 186 */           if ((s2 = this.m[j]) == -1) {
/* 187 */             this.debugBatch.setColor(1.0F, 0.0F, 0.0F, 0.28F);
/* 188 */             this.debugBatch.draw((TextureRegion)Game.i.assetManager.getBlankWhiteTextureRegion(), f3, f4, f1, f2);
/*     */           } else {
/* 190 */             s2 = this.l[s2];
/* 191 */             this.debugBatch.setColor(0.0F, 1.0F, 0.0F, 0.28F);
/* 192 */             this.debugBatch.draw((TextureRegion)Game.i.assetManager.getBlankWhiteTextureRegion(), f3, f4, f1, f2);
/* 193 */             Game.i.assetManager.getSmallDebugFont().draw(this.debugBatch, s2, f3 + f1 * 0.5F, f4 + 10.0F, 1.0F, 1, false);
/*     */           } 
/*     */         } 
/*     */       } 
/*     */       
/* 198 */       this.debugBatch.setColor(1.0F, 0.7F, 0.0F, 0.28F);
/* 199 */       i = 0;
/*     */ 
/*     */       
/* 202 */       while ((i = bitVector.nextSetBit(i + 1)) != -1) {
/* 203 */         int j = i - 1;
/* 204 */         float f3 = this.k[j * 3];
/* 205 */         float f4 = this.k[j * 3 + 1];
/* 206 */         float f5 = this.k[j * 3 + 2];
/* 207 */         if (paramEntryFilter.test(f3, f4, f5)) {
/* 208 */           this.debugBatch.draw((TextureRegion)Game.i.assetManager.getTextureRegion("circle"), f3 - f5, f4 - f5, f5 * 2.0F, f5 * 2.0F);
/* 209 */           Game.i.assetManager.getSmallDebugFont().draw(this.debugBatch, j, f3 + f5 * 0.5F, f4 + f5 * 0.5F, 1.0F, 1, false);
/*     */         } 
/*     */       } 
/* 212 */       this.debugBatch.setColor(Color.WHITE);
/*     */     } 
/*     */     
/* 215 */     if (bool)
/* 216 */       this.j = bitVector; 
/*     */   }
/*     */   public final void traverseEntriesInLine(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, EntryFilter paramEntryFilter, EntryRetriever<T> paramEntryRetriever) {
/*     */     BitVector bitVector;
/*     */     boolean bool;
/* 221 */     if (isEmpty())
/*     */       return; 
/* 223 */     float f1 = 1.0F / this.g;
/* 224 */     float f2 = 1.0F / this.h;
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 229 */     if (this.j == null) {
/* 230 */       bitVector = new BitVector(this.i.length + 1);
/* 231 */       bool = false;
/*     */     } else {
/* 233 */       bitVector = this.j;
/* 234 */       this.j = null;
/* 235 */       bitVector.clear();
/* 236 */       bitVector.ensureCapacity(this.i.length + 1);
/* 237 */       bool = true;
/*     */     } 
/*     */     
/* 240 */     Vector2 vector21 = (new Vector2(paramFloat3 - paramFloat1, paramFloat4 - paramFloat2)).nor();
/* 241 */     paramFloat3 = PMath.getDistanceBetweenPoints(paramFloat1, paramFloat2, paramFloat3, paramFloat4);
/* 242 */     paramFloat4 = Math.min(f1, f2) * 0.5F;
/* 243 */     Vector2 vector22 = (new Vector2(vector21)).rotate90(0).scl(paramFloat4 * 0.5F);
/* 244 */     vector21.scl(paramFloat4);
/*     */     
/* 246 */     IntArray intArray = null;
/* 247 */     if (this.debugBatch != null) {
/* 248 */       intArray = new IntArray();
/*     */     }
/* 250 */     double d = 0.0D;
/* 251 */     paramFloat1 = paramFloat1;
/* 252 */     paramFloat2 = paramFloat2;
/*     */     
/* 254 */     int i = -1;
/* 255 */     while (d < (paramFloat3 + paramFloat4)) {
/* 256 */       float f3 = paramFloat1 + vector22.x;
/* 257 */       float f4 = paramFloat2 + vector22.y;
/*     */       
/* 259 */       if (this.debugBatch != null) {
/* 260 */         this.debugBatch.setColor(Color.WHITE);
/* 261 */         this.debugBatch.draw((TextureRegion)Game.i.assetManager.getTextureRegion("circle"), f3 - 2.0F, f4 - 2.0F, 4.0F, 4.0F);
/*     */       } 
/*     */       
/* 264 */       if (f3 >= this.c && f3 <= this.d && f4 >= this.e && f4 <= this.f) {
/* 265 */         short s1 = a(f3);
/*     */         short s2;
/* 267 */         int j = (s2 = b(f4)) * this.a + s1;
/* 268 */         if (i != j) {
/* 269 */           i = j;
/* 270 */           if (intArray != null) {
/* 271 */             intArray.add(s1, s2);
/*     */           }
/*     */           short s;
/* 274 */           if ((s = this.m[j]) != -1) {
/* 275 */             short s3 = this.l[s];
/* 276 */             for (s1 = 0; s1 < s3; s1++) {
/* 277 */               int k = this.l[s + s1 + 1] + 1;
/* 278 */               bitVector.unsafeSet(k);
/*     */             } 
/*     */           } 
/*     */         } 
/*     */       } 
/* 283 */       f3 = paramFloat1 - vector22.x;
/* 284 */       f4 = paramFloat2 - vector22.y;
/*     */       
/* 286 */       if (this.debugBatch != null) {
/* 287 */         this.debugBatch.setColor(Color.WHITE);
/* 288 */         this.debugBatch.draw((TextureRegion)Game.i.assetManager.getTextureRegion("circle"), f3 - 2.0F, f4 - 2.0F, 4.0F, 4.0F);
/*     */       } 
/* 290 */       if (f3 >= this.c && f3 <= this.d && f4 >= this.e && f4 <= this.f) {
/* 291 */         short s1 = a(f3);
/*     */         short s2;
/* 293 */         int j = (s2 = b(f4)) * this.a + s1;
/* 294 */         if (i != j) {
/* 295 */           i = j;
/* 296 */           if (intArray != null) {
/* 297 */             intArray.add(s1, s2);
/*     */           }
/*     */           short s;
/* 300 */           if ((s = this.m[j]) != -1) {
/* 301 */             short s3 = this.l[s];
/* 302 */             for (s1 = 0; s1 < s3; s1++) {
/* 303 */               int k = this.l[s + s1 + 1] + 1;
/* 304 */               bitVector.unsafeSet(k);
/*     */             } 
/*     */           } 
/*     */         } 
/*     */       } 
/*     */       
/* 310 */       d += paramFloat4;
/* 311 */       paramFloat1 += vector21.x;
/* 312 */       paramFloat2 += vector21.y;
/*     */     } 
/* 314 */     a(bitVector, paramEntryFilter, paramEntryRetriever);
/*     */     
/* 316 */     if (this.debugBatch != null) {
/* 317 */       this.debugBatch.setColor(0.0F, 1.0F, 0.0F, 0.28F); int j;
/* 318 */       for (j = 0; j < intArray.size; j += 2) {
/* 319 */         float f3 = intArray.items[j] * f1 + this.c;
/* 320 */         float f4 = intArray.items[j + 1] * f2 + this.e;
/* 321 */         this.debugBatch.draw((TextureRegion)Game.i.assetManager.getBlankWhiteTextureRegion(), f3, f4, f1, f2);
/*     */       } 
/*     */       
/* 324 */       this.debugBatch.setColor(1.0F, 0.7F, 0.0F, 0.28F);
/* 325 */       j = 0;
/*     */ 
/*     */       
/* 328 */       while ((j = bitVector.nextSetBit(j + 1)) != -1) {
/* 329 */         int k = j - 1;
/* 330 */         float f3 = this.k[k * 3];
/* 331 */         float f4 = this.k[k * 3 + 1];
/* 332 */         float f5 = this.k[k * 3 + 2];
/* 333 */         if (paramEntryFilter.test(f3, f4, f5)) {
/* 334 */           this.debugBatch.draw((TextureRegion)Game.i.assetManager.getTextureRegion("circle"), f3 - f5, f4 - f5, f5 * 2.0F, f5 * 2.0F);
/* 335 */           Game.i.assetManager.getSmallDebugFont().draw(this.debugBatch, k, f3 + f5 * 0.5F, f4 + f5 * 0.5F, 1.0F, 1, false);
/*     */         } 
/*     */       } 
/* 338 */       this.debugBatch.setColor(Color.WHITE);
/*     */     } 
/*     */     
/* 341 */     if (bool)
/* 342 */       this.j = bitVector; 
/*     */   }
/*     */   
/*     */   private AABB() {}
/*     */   
/* 347 */   public static final class Factory<T> { private final Array<AABB.Entry<T>> a = new Array(true, 1, AABB.Entry.class);
/*     */     
/*     */     private int b;
/*     */     private final float c;
/*     */     private final Class<T> d;
/* 352 */     private final Array<ShortArray> e = new Array(true, 1, ShortArray.class);
/* 353 */     private final Array<ShortArray> f = new Array(true, 1, ShortArray.class);
/*     */     
/*     */     public Factory(Class<T> param1Class, float param1Float) {
/* 356 */       this.c = param1Float;
/* 357 */       this.d = param1Class;
/*     */     }
/*     */     
/*     */     public final void add(T param1T, float param1Float1, float param1Float2, float param1Float3) {
/* 361 */       if (this.b > this.a.size) {
/*     */         AABB.Entry entry;
/*     */         
/* 364 */         (entry = ((AABB.Entry[])this.a.items)[this.a.size]).object = param1T;
/* 365 */         entry.x = param1Float1;
/* 366 */         entry.y = param1Float2;
/* 367 */         entry.size = param1Float3;
/* 368 */         this.a.size++;
/*     */         return;
/*     */       } 
/* 371 */       this.a.add(new AABB.Entry(param1T, param1Float1, param1Float2, param1Float3, (byte)0));
/* 372 */       this.b++;
/*     */     }
/*     */ 
/*     */     
/*     */     public final void reset() {
/* 377 */       for (byte b = 0; b < this.a.size; b++) {
/* 378 */         (((AABB.Entry[])this.a.items)[b]).object = null;
/*     */       }
/* 380 */       this.a.size = 0;
/*     */     }
/*     */     
/*     */     public final AABB<T> bake(@Null AABB<T> param1AABB) {
/*     */       AABB<T> aABB;
/* 385 */       float f1 = Float.MAX_VALUE;
/* 386 */       float f2 = Float.MAX_VALUE;
/* 387 */       float f3 = -3.4028235E38F;
/* 388 */       float f4 = -3.4028235E38F;
/* 389 */       for (byte b = 0; b < this.a.size; b++) {
/* 390 */         AABB.Entry entry = ((AABB.Entry[])this.a.items)[b];
/* 391 */         f1 = Math.min(f1, entry.x - entry.size);
/* 392 */         f2 = Math.min(f2, entry.y - entry.size);
/* 393 */         f3 = Math.max(f3, entry.x + entry.size);
/* 394 */         f4 = Math.max(f4, entry.y + entry.size);
/*     */       } 
/*     */ 
/*     */       
/* 398 */       float f5 = f3 - f1;
/* 399 */       float f6 = f4 - f2;
/* 400 */       short s1 = (short)MathUtils.ceil(f5 / this.c);
/* 401 */       short s2 = (short)MathUtils.ceil(f6 / this.c);
/* 402 */       f5 /= s1;
/* 403 */       f6 /= s2;
/* 404 */       float f7 = 1.0F / f5;
/* 405 */       float f8 = 1.0F / f6;
/* 406 */       int i = s1 * s2;
/*     */ 
/*     */       
/* 409 */       int j = 0; short s;
/* 410 */       for (s = 0; s < this.a.size; s = (short)(s + 1)) {
/*     */         AABB.Entry entry;
/*     */         
/* 413 */         float f9 = (entry = ((AABB.Entry[])this.a.items)[s]).x - entry.size - f1;
/* 414 */         float f10 = entry.y - entry.size - f2;
/* 415 */         float f11 = entry.x + entry.size - f1;
/* 416 */         float f12 = entry.y + entry.size - f2;
/* 417 */         int k = MathUtils.clamp((int)(f9 * f7), 0, s1 - 1);
/* 418 */         int i1 = MathUtils.clamp((int)(f11 * f7), 0, s1 - 1);
/* 419 */         int m = MathUtils.clamp((int)(f10 * f8), 0, s2 - 1);
/* 420 */         int n = MathUtils.clamp((int)(f12 * f8), 0, s2 - 1);
/*     */         
/* 422 */         j += (n - m + 1) * (i1 - k + 1);
/*     */       } 
/* 424 */       j += i;
/*     */ 
/*     */ 
/*     */       
/* 428 */       if (param1AABB == null) {
/*     */ 
/*     */         
/* 431 */         AABB.a(aABB = new AABB((byte)0), (Object[])ArrayReflection.newInstance(this.d, this.a.size));
/*     */       } else {
/* 433 */         aABB = param1AABB;
/*     */       } 
/*     */       
/* 436 */       if (this.a.size == 0) {
/*     */         
/* 438 */         Arrays.fill(AABB.a(aABB), (Object)null);
/* 439 */         AABB.a(aABB, AABB.b(aABB, Float.MAX_VALUE));
/* 440 */         AABB.c(aABB, AABB.d(aABB, -3.4028235E38F));
/* 441 */         AABB.a(aABB, AABB.b(aABB, (short)0));
/*     */       } else {
/*     */         
/* 444 */         if ((AABB.a(aABB)).length < this.a.size) {
/*     */           
/* 446 */           AABB.a(aABB, (Object[])ArrayReflection.newInstance(this.d, this.a.size));
/*     */         } else {
/* 448 */           Arrays.fill(AABB.a(aABB), (Object)null);
/*     */         } 
/* 450 */         if ((AABB.b(aABB)).length < this.a.size * 3) {
/* 451 */           AABB.a(aABB, new float[this.a.size * 3]);
/*     */         }
/* 453 */         if ((AABB.c(aABB)).length < j) {
/* 454 */           AABB.a(aABB, new short[j]);
/*     */         }
/* 456 */         if ((AABB.d(aABB)).length < i) {
/* 457 */           AABB.b(aABB, new short[i]);
/*     */         }
/* 459 */         AABB.a(aABB, s1);
/* 460 */         AABB.b(aABB, s2);
/* 461 */         AABB.e(aABB, 1.0F / f5);
/* 462 */         AABB.f(aABB, 1.0F / f6);
/* 463 */         AABB.a(aABB, f1);
/* 464 */         AABB.b(aABB, f2);
/* 465 */         AABB.c(aABB, f3);
/* 466 */         AABB.d(aABB, f4);
/*     */         
/* 468 */         this.e.clear(); short s3;
/* 469 */         for (s3 = 0; s3 < this.a.size; s3 = (short)(s3 + 1)) {
/* 470 */           AABB.Entry entry = ((AABB.Entry[])this.a.items)[s3];
/*     */           
/* 472 */           AABB.a(aABB)[s3] = entry.object;
/* 473 */           AABB.b(aABB)[s3 * 3] = entry.x;
/* 474 */           AABB.b(aABB)[s3 * 3 + 1] = entry.y;
/* 475 */           AABB.b(aABB)[s3 * 3 + 2] = entry.size;
/*     */           
/* 477 */           float f10 = entry.x - entry.size - f1;
/* 478 */           float f11 = entry.y - entry.size - f2;
/* 479 */           float f12 = entry.x + entry.size - f1;
/* 480 */           float f9 = entry.y + entry.size - f2;
/* 481 */           short s8 = (short)MathUtils.clamp((int)(f10 * f7), 0, s1 - 1);
/* 482 */           short s6 = (short)MathUtils.clamp((int)(f12 * f7), 0, s1 - 1);
/* 483 */           short s7 = (short)MathUtils.clamp((int)(f11 * f8), 0, s2 - 1);
/* 484 */           short s4 = (short)MathUtils.clamp((int)(f9 * f8), 0, s2 - 1); short s5;
/* 485 */           for (s5 = s7; s5 <= s4; s5 = (short)(s5 + 1)) {
/* 486 */             short s9; for (s9 = s8; s9 <= s6; s9 = (short)(s9 + 1)) {
/* 487 */               int k = s5 * s1 + s9;
/*     */               ShortArray shortArray;
/* 489 */               if ((shortArray = (ShortArray)((this.e.size > k) ? this.e.get(k) : null)) == null) {
/* 490 */                 shortArray = (this.f.size == 0) ? new ShortArray() : (ShortArray)this.f.pop();
/* 491 */                 if (this.e.size < k + 1) {
/* 492 */                   this.e.setSize(k + 1);
/*     */                 }
/* 494 */                 this.e.set(k, shortArray);
/*     */               } 
/* 496 */               shortArray.add(s3);
/*     */             } 
/*     */           } 
/*     */         } 
/*     */ 
/*     */         
/* 502 */         for (s3 = 0; s3 < i; s3++) {
/* 503 */           AABB.d(aABB)[s3] = -1;
/*     */         }
/*     */         
/* 506 */         s3 = 0;
/* 507 */         for (byte b1 = 0; b1 < i; b1++) {
/*     */           ShortArray shortArray;
/* 509 */           if ((shortArray = (ShortArray)((this.e.size > b1) ? ((ShortArray[])this.e.items)[b1] : null)) != null) {
/* 510 */             short s4 = s3;
/* 511 */             AABB.d(aABB)[b1] = s3;
/* 512 */             s3 = (short)(s3 + shortArray.size + 1);
/*     */             
/* 514 */             AABB.c(aABB)[s4] = (short)shortArray.size;
/* 515 */             System.arraycopy(shortArray.items, 0, AABB.c(aABB), s4 + 1, shortArray.size);
/*     */             
/* 517 */             shortArray.clear();
/* 518 */             this.f.add(shortArray);
/*     */           } 
/*     */         } 
/*     */       } 
/*     */       
/* 523 */       return aABB;
/*     */     } }
/*     */ 
/*     */   
/*     */   private static final class Entry<T> {
/*     */     public T object;
/*     */     public float x;
/*     */     public float y;
/*     */     public float size;
/*     */     
/*     */     private Entry() {}
/*     */     
/*     */     private Entry(T param1T, float param1Float1, float param1Float2, float param1Float3) {
/* 536 */       this.object = param1T;
/* 537 */       this.x = param1Float1;
/* 538 */       this.y = param1Float2;
/* 539 */       this.size = param1Float3;
/*     */     }
/*     */   }
/*     */   
/*     */   @FunctionalInterface
/*     */   public static interface EntryRetriever<T> {
/*     */     boolean retrieve(T param1T, float param1Float1, float param1Float2, float param1Float3);
/*     */   }
/*     */   
/*     */   @FunctionalInterface
/*     */   public static interface EntryFilter {
/*     */     boolean test(float param1Float1, float param1Float2, float param1Float3);
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi\\utils\AABB.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */