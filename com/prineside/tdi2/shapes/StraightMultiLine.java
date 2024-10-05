/*     */ package com.prineside.tdi2.shapes;
/*     */ 
/*     */ import com.badlogic.gdx.graphics.Color;
/*     */ import com.badlogic.gdx.graphics.g2d.Batch;
/*     */ import com.badlogic.gdx.graphics.g2d.TextureRegion;
/*     */ import com.badlogic.gdx.math.MathUtils;
/*     */ import com.badlogic.gdx.math.Vector2;
/*     */ import com.badlogic.gdx.utils.NumberUtils;
/*     */ import com.prineside.tdi2.Shape;
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class StraightMultiLine
/*     */   extends Shape
/*     */ {
/*  16 */   private float[] a = new float[0];
/*  17 */   private float[] b = new float[0];
/*  18 */   private int c = 0;
/*  19 */   private float d = 16.0F;
/*     */   
/*  21 */   private final Color e = Color.WHITE.cpy();
/*     */   
/*     */   private boolean f = true;
/*     */   
/*     */   private TextureRegion g;
/*     */   
/*     */   private TextureRegion h;
/*  28 */   private final Vector2 i = new Vector2();
/*  29 */   private final Vector2 j = new Vector2();
/*  30 */   private final Vector2 k = new Vector2();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final void setWidth(float paramFloat) {
/*  37 */     this.d = paramFloat * 0.5F;
/*     */     
/*  39 */     updateAllNodes();
/*     */   }
/*     */   
/*     */   public final void setNodesSliced(float[] paramArrayOffloat, int paramInt) {
/*  43 */     b(paramInt);
/*  44 */     this.c = paramInt;
/*  45 */     for (byte b = 0; b < paramInt; b++) {
/*  46 */       int i = b * 3;
/*  47 */       int j = b * 5;
/*  48 */       this.b[j] = paramArrayOffloat[i];
/*  49 */       this.b[j + 1] = paramArrayOffloat[i + 1];
/*  50 */       this.b[j + 2] = paramArrayOffloat[i + 2];
/*     */     } 
/*     */     
/*  53 */     updateAllNodes();
/*     */     
/*  55 */     this.f = true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final void setNodes(float[] paramArrayOffloat) {
/*  62 */     setNodesSliced(paramArrayOffloat, paramArrayOffloat.length / 3);
/*     */   }
/*     */   
/*     */   public final int getNodeCount() {
/*  66 */     return this.c;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static int a(int paramInt) {
/*  73 */     if (paramInt < 3) {
/*  74 */       return 3;
/*     */     }
/*  76 */     return (paramInt - 1) * 3;
/*     */   }
/*     */ 
/*     */   
/*     */   private void b(int paramInt) {
/*  81 */     int i = a(paramInt) * 20;
/*  82 */     if (this.a.length < i) {
/*     */       
/*  84 */       float[] arrayOfFloat = new float[MathUtils.nextPowerOfTwo(i)];
/*  85 */       System.arraycopy(this.a, 0, arrayOfFloat, 0, this.a.length);
/*  86 */       this.a = arrayOfFloat;
/*     */     } 
/*     */     
/*  89 */     i = paramInt * 5;
/*  90 */     if (this.b.length < i) {
/*  91 */       float[] arrayOfFloat = new float[MathUtils.nextPowerOfTwo(i)];
/*  92 */       System.arraycopy(this.b, 0, arrayOfFloat, 0, this.b.length);
/*  93 */       this.b = arrayOfFloat;
/*     */       
/*  95 */       this.f = true;
/*     */     } 
/*     */   }
/*     */   
/*     */   public final TextureRegion getMainTexture() {
/* 100 */     return this.g;
/*     */   }
/*     */ 
/*     */   
/*     */   public final void setTextureRegion(TextureRegion paramTextureRegion1, TextureRegion paramTextureRegion2) {
/* 105 */     this.g = paramTextureRegion1;
/* 106 */     this.h = paramTextureRegion2;
/*     */     
/* 108 */     for (byte b = 1; b < this.c; b++) {
/* 109 */       d(b);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final void appendNode(float paramFloat1, float paramFloat2, float paramFloat3, boolean paramBoolean) {
/* 117 */     b(this.c + 1);
/*     */ 
/*     */     
/* 120 */     int i, j = (i = this.c) * 5;
/* 121 */     this.c++;
/* 122 */     this.b[j] = paramFloat1;
/* 123 */     this.b[j + 1] = paramFloat2;
/* 124 */     this.b[j + 2] = paramFloat3;
/*     */     
/* 126 */     if (paramBoolean) {
/* 127 */       if (i != 0) c(i - 1); 
/* 128 */       c(i);
/*     */     } 
/*     */     
/* 131 */     if (i != 0) e(i); 
/*     */   }
/*     */   
/*     */   public final void setNodePosition(int paramInt, float paramFloat1, float paramFloat2) {
/* 135 */     paramInt *= 5;
/* 136 */     this.b[paramInt] = paramFloat1;
/* 137 */     this.b[paramInt + 1] = paramFloat2;
/*     */   }
/*     */   
/*     */   public final void updateAllNodes() {
/* 141 */     for (byte b = 1; b < this.c; b++) {
/* 142 */       d(b);
/*     */     }
/*     */     
/* 145 */     this.f = true;
/*     */   }
/*     */   
/*     */   private void c(int paramInt) {
/* 149 */     if (paramInt != 0) d(paramInt); 
/* 150 */     if (paramInt != this.c - 1) d(paramInt + 1);
/*     */     
/* 152 */     this.f = true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void d(int paramInt) {
/* 159 */     if (paramInt == 0) {
/*     */       return;
/*     */     }
/* 162 */     int i = paramInt * 5;
/* 163 */     int j = (paramInt - 1) * 5;
/*     */     
/* 165 */     float f1 = this.g.getU2();
/* 166 */     float f2 = this.g.getU();
/* 167 */     float f3 = this.g.getV2();
/* 168 */     float f4 = this.g.getV();
/* 169 */     float f5 = this.h.getU2();
/* 170 */     float f6 = this.h.getU();
/* 171 */     float f7 = this.h.getV2();
/* 172 */     float f8 = this.h.getV();
/*     */     
/* 174 */     float f9 = this.b[j];
/* 175 */     float f10 = this.b[j + 1];
/* 176 */     float f11 = this.b[i];
/* 177 */     float f12 = this.b[i + 1];
/*     */     
/* 179 */     this.i.set(this.b[i] - this.b[j], this.b[i + 1] - this.b[j + 1]).nor().scl(this.d);
/* 180 */     this.j.set(this.i).rotate90(1);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 189 */     i = (paramInt - 1) * 3 * 20;
/*     */ 
/*     */     
/* 192 */     this.k.set(this.j).scl(-1.0F).add(f9, f10);
/* 193 */     this.a[i] = this.k.x;
/* 194 */     this.a[i + 1] = this.k.y;
/* 195 */     this.a[i + 3] = f5;
/* 196 */     this.a[i + 4] = f8;
/*     */ 
/*     */     
/* 199 */     this.k.add(-this.i.x, -this.i.y);
/* 200 */     this.a[i + 5] = this.k.x;
/* 201 */     this.a[i + 6] = this.k.y;
/* 202 */     this.a[i + 8] = f6;
/* 203 */     this.a[i + 9] = f8;
/*     */ 
/*     */     
/* 206 */     this.k.add(this.j.x * 2.0F, this.j.y * 2.0F);
/* 207 */     this.a[i + 10] = this.k.x;
/* 208 */     this.a[i + 11] = this.k.y;
/* 209 */     this.a[i + 13] = f6;
/* 210 */     this.a[i + 14] = f7;
/*     */ 
/*     */     
/* 213 */     this.k.add(this.i.x, this.i.y);
/* 214 */     this.a[i + 15] = this.k.x;
/* 215 */     this.a[i + 16] = this.k.y;
/* 216 */     this.a[i + 18] = f5;
/* 217 */     this.a[i + 19] = f7;
/*     */ 
/*     */     
/* 220 */     i = ((paramInt - 1) * 3 + 1) * 20;
/*     */ 
/*     */     
/* 223 */     this.k.set(this.j).scl(-1.0F).add(f11, f12);
/* 224 */     this.a[i] = this.k.x;
/* 225 */     this.a[i + 1] = this.k.y;
/* 226 */     this.a[i + 3] = f1;
/* 227 */     this.a[i + 4] = f4;
/*     */ 
/*     */     
/* 230 */     this.k.set(this.j).scl(-1.0F).add(f9, f10);
/* 231 */     this.a[i + 5] = this.k.x;
/* 232 */     this.a[i + 6] = this.k.y;
/* 233 */     this.a[i + 8] = f2;
/* 234 */     this.a[i + 9] = f4;
/*     */ 
/*     */     
/* 237 */     this.k.add(this.j.x * 2.0F, this.j.y * 2.0F);
/* 238 */     this.a[i + 10] = this.k.x;
/* 239 */     this.a[i + 11] = this.k.y;
/* 240 */     this.a[i + 13] = f2;
/* 241 */     this.a[i + 14] = f3;
/*     */ 
/*     */     
/* 244 */     this.k.set(this.j).add(f11, f12);
/* 245 */     this.a[i + 15] = this.k.x;
/* 246 */     this.a[i + 16] = this.k.y;
/* 247 */     this.a[i + 18] = f1;
/* 248 */     this.a[i + 19] = f3;
/*     */ 
/*     */     
/* 251 */     i = ((paramInt - 1) * 3 + 2) * 20;
/*     */ 
/*     */     
/* 254 */     this.k.set(this.j).scl(-1.0F).add(f11, f12).add(this.i.x, this.i.y);
/* 255 */     this.a[i] = this.k.x;
/* 256 */     this.a[i + 1] = this.k.y;
/* 257 */     this.a[i + 3] = f6;
/* 258 */     this.a[i + 4] = f8;
/*     */ 
/*     */     
/* 261 */     this.k.set(this.j).scl(-1.0F).add(f11, f12);
/* 262 */     this.a[i + 5] = this.k.x;
/* 263 */     this.a[i + 6] = this.k.y;
/* 264 */     this.a[i + 8] = f5;
/* 265 */     this.a[i + 9] = f8;
/*     */ 
/*     */     
/* 268 */     this.k.add(this.j.x * 2.0F, this.j.y * 2.0F);
/* 269 */     this.a[i + 10] = this.k.x;
/* 270 */     this.a[i + 11] = this.k.y;
/* 271 */     this.a[i + 13] = f5;
/* 272 */     this.a[i + 14] = f7;
/*     */ 
/*     */     
/* 275 */     this.k.add(this.i.x, this.i.y);
/* 276 */     this.a[i + 15] = this.k.x;
/* 277 */     this.a[i + 16] = this.k.y;
/* 278 */     this.a[i + 18] = f6;
/* 279 */     this.a[i + 19] = f7;
/*     */     
/* 281 */     this.f = true;
/*     */   }
/*     */   
/*     */   public final void setNodeColor(int paramInt, float paramFloat) {
/* 285 */     this.b[paramInt * 5 + 2] = paramFloat;
/*     */     
/* 287 */     if (paramInt != 0) e(paramInt); 
/*     */   }
/*     */   
/*     */   public final void setTint(Color paramColor) {
/* 291 */     if (paramColor == null) paramColor = Color.WHITE;
/*     */     
/* 293 */     if (this.e.a == paramColor.a && this.e.r == paramColor.r && this.e.g == paramColor.g && this.e.b == paramColor.b)
/*     */       return; 
/* 295 */     this.e.set(paramColor);
/* 296 */     this.f = true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final void setTintAndAlpha(Color paramColor, float paramFloat) {
/* 303 */     if (paramColor == null) paramColor = Color.WHITE;
/*     */     
/* 305 */     if (this.e.a == paramFloat && this.e.r == paramColor.r && this.e.g == paramColor.g && this.e.b == paramColor.b)
/*     */       return; 
/* 307 */     this.e.set(paramColor);
/* 308 */     this.e.a = paramFloat;
/* 309 */     this.f = true;
/*     */   }
/*     */   
/*     */   public final Color getTint() {
/* 313 */     return this.e;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void e(int paramInt) {
/* 321 */     int i = paramInt * 5;
/* 322 */     int j = (paramInt - 1) * 5;
/*     */ 
/*     */     
/*     */     int n;
/*     */     
/* 327 */     i = (int)(((n = NumberUtils.floatToIntColor(this.b[i + 2])) & 0xFF) * this.e.r);
/* 328 */     int k = (int)((n >> 8 & 0xFF) * this.e.g);
/* 329 */     int m = (int)((n >> 16 & 0xFF) * this.e.b);
/* 330 */     n = (int)(((n & 0xFF000000) >>> 24) * this.e.a);
/*     */     
/* 332 */     float f2 = NumberUtils.intToFloatColor(i + (k << 8) + (m << 16) + (n << 24));
/*     */ 
/*     */     
/* 335 */     i = (int)(((n = NumberUtils.floatToIntColor(this.b[j + 2])) & 0xFF) * this.e.r);
/* 336 */     k = (int)((n >> 8 & 0xFF) * this.e.g);
/* 337 */     m = (int)((n >> 16 & 0xFF) * this.e.b);
/* 338 */     n = (int)(((n & 0xFF000000) >>> 24) * this.e.a);
/* 339 */     float f1 = NumberUtils.intToFloatColor(i + (k << 8) + (m << 16) + (n << 24));
/*     */ 
/*     */     
/* 342 */     j = (paramInt - 1) * 3 * 20;
/* 343 */     this.a[j + 2] = f1;
/* 344 */     this.a[j + 7] = f1;
/* 345 */     this.a[j + 12] = f1;
/* 346 */     this.a[j + 17] = f1;
/*     */ 
/*     */     
/* 349 */     j = ((paramInt - 1) * 3 + 1) * 20;
/* 350 */     this.a[j + 2] = f2;
/* 351 */     this.a[j + 7] = f1;
/* 352 */     this.a[j + 12] = f1;
/* 353 */     this.a[j + 17] = f2;
/*     */ 
/*     */     
/* 356 */     j = ((paramInt - 1) * 3 + 2) * 20;
/* 357 */     this.a[j + 2] = f2;
/* 358 */     this.a[j + 7] = f2;
/* 359 */     this.a[j + 12] = f2;
/* 360 */     this.a[j + 17] = f2;
/*     */   }
/*     */ 
/*     */   
/*     */   private void a() {
/* 365 */     for (byte b = 1; b < this.c; b++) {
/* 366 */       e(b);
/*     */     }
/*     */     
/* 369 */     this.f = false;
/*     */   }
/*     */ 
/*     */   
/*     */   public final void draw(Batch paramBatch) {
/* 374 */     if (this.c < 2)
/*     */       return; 
/* 376 */     if (this.f) {
/* 377 */       a();
/*     */     }
/*     */     
/* 380 */     paramBatch.draw(this.g.getTexture(), this.a, 0, a(this.c) * 20);
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
/*     */   public final void reset() {
/* 410 */     this.c = 0;
/* 411 */     this.g = null;
/* 412 */     this.h = null;
/*     */     
/* 414 */     this.f = true;
/*     */   }
/*     */   
/*     */   private StraightMultiLine() {}
/*     */   
/*     */   public static class StraightMultiLineFactory extends Shape.Factory<StraightMultiLine> {
/*     */     public void setup() {}
/*     */     
/*     */     private static StraightMultiLine b() {
/* 423 */       return new StraightMultiLine((byte)0);
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\shapes\StraightMultiLine.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */