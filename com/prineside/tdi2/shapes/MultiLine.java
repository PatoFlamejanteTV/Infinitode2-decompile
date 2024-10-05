/*     */ package com.prineside.tdi2.shapes;
/*     */ 
/*     */ import com.badlogic.gdx.graphics.Color;
/*     */ import com.badlogic.gdx.graphics.g2d.Batch;
/*     */ import com.badlogic.gdx.graphics.g2d.TextureRegion;
/*     */ import com.badlogic.gdx.math.MathUtils;
/*     */ import com.badlogic.gdx.math.Vector2;
/*     */ import com.badlogic.gdx.utils.NumberUtils;
/*     */ import com.prineside.tdi2.ResourcePack;
/*     */ import com.prineside.tdi2.Shape;
/*     */ import com.prineside.tdi2.managers.AssetManager;
/*     */ import com.prineside.tdi2.utils.MaterialColor;
/*     */ 
/*     */ 
/*     */ public class MultiLine
/*     */   extends Shape
/*     */ {
/*  18 */   private float[] a = new float[0];
/*  19 */   private float[] b = new float[0];
/*  20 */   private int c = 0;
/*     */   
/*  22 */   private final Color d = Color.WHITE.cpy();
/*     */   
/*     */   private boolean e = true;
/*     */   
/*     */   private TextureRegion f;
/*     */   
/*     */   private boolean g;
/*     */   private boolean h;
/*     */   private float i;
/*     */   private float j;
/*     */   private float k;
/*     */   private float l;
/*     */   private float m;
/*  35 */   private final Vector2 n = new Vector2();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setNodesWithCount(float[] paramArrayOffloat, int paramInt) {
/*  42 */     b(paramInt);
/*  43 */     this.c = paramInt;
/*  44 */     for (byte b = 0; b < paramInt; b++) {
/*  45 */       int i = b << 2;
/*  46 */       int j = b * 6;
/*  47 */       this.b[j] = paramArrayOffloat[i];
/*  48 */       this.b[j + 1] = paramArrayOffloat[i + 1];
/*  49 */       this.b[j + 2] = paramArrayOffloat[i + 2] / 2.0F;
/*  50 */       this.b[j + 3] = paramArrayOffloat[i + 3];
/*     */     } 
/*     */     
/*  53 */     updateAllNodes();
/*     */     
/*  55 */     this.e = true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setNodes(float[] paramArrayOffloat) {
/*  62 */     setNodesWithCount(paramArrayOffloat, paramArrayOffloat.length / 4);
/*     */   }
/*     */   
/*     */   public int getNodeCount() {
/*  66 */     return this.c;
/*     */   }
/*     */   
/*     */   private static int a(int paramInt) {
/*  70 */     if (paramInt < 3) {
/*  71 */       return 2;
/*     */     }
/*  73 */     return paramInt - 1 << 1;
/*     */   }
/*     */ 
/*     */   
/*     */   private void b(int paramInt) {
/*  78 */     int i = a(paramInt) * 20;
/*  79 */     if (this.a.length < i) {
/*     */       
/*  81 */       float[] arrayOfFloat = new float[MathUtils.nextPowerOfTwo(i)];
/*  82 */       System.arraycopy(this.a, 0, arrayOfFloat, 0, this.a.length);
/*  83 */       this.a = arrayOfFloat;
/*     */     } 
/*     */     
/*  86 */     i = paramInt * 6;
/*  87 */     if (this.b.length < i) {
/*  88 */       float[] arrayOfFloat = new float[MathUtils.nextPowerOfTwo(i)];
/*  89 */       System.arraycopy(this.b, 0, arrayOfFloat, 0, this.b.length);
/*  90 */       this.b = arrayOfFloat;
/*     */       
/*  92 */       this.e = true;
/*     */     } 
/*     */   }
/*     */   
/*     */   public TextureRegion getTextureRegion() {
/*  97 */     return this.f;
/*     */   }
/*     */   
/*     */   public boolean getMirror() {
/* 101 */     return this.g;
/*     */   }
/*     */   
/*     */   public boolean getFlip() {
/* 105 */     return this.h;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setTextureRegion(TextureRegion paramTextureRegion, boolean paramBoolean1, boolean paramBoolean2) {
/* 110 */     this.f = paramTextureRegion;
/* 111 */     this.g = paramBoolean1;
/* 112 */     this.h = paramBoolean2;
/*     */     
/* 114 */     this.i = paramTextureRegion.getU();
/* 115 */     this.j = paramTextureRegion.getU2();
/*     */     
/* 117 */     if (paramBoolean1) {
/* 118 */       if (!paramBoolean2) {
/* 119 */         this.l = paramTextureRegion.getV();
/* 120 */         this.k = paramTextureRegion.getV2();
/*     */       } else {
/* 122 */         this.l = paramTextureRegion.getV2();
/* 123 */         this.k = paramTextureRegion.getV();
/*     */       } 
/* 125 */       this.m = this.k;
/*     */     } else {
/* 127 */       this.l = paramTextureRegion.getV() + (paramTextureRegion.getV2() - paramTextureRegion.getV()) * 0.5F;
/* 128 */       if (paramBoolean2) {
/* 129 */         this.k = paramTextureRegion.getV2();
/* 130 */         this.m = paramTextureRegion.getV();
/*     */       } else {
/* 132 */         this.k = paramTextureRegion.getV();
/* 133 */         this.m = paramTextureRegion.getV2();
/*     */       } 
/*     */     } 
/*     */     
/* 137 */     for (byte b = 1; b < this.c; b++) {
/* 138 */       e(b);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void appendNode(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, boolean paramBoolean) {
/* 146 */     b(this.c + 1);
/*     */ 
/*     */     
/* 149 */     int i, j = (i = this.c) * 6;
/* 150 */     this.c++;
/* 151 */     this.b[j] = paramFloat1;
/* 152 */     this.b[j + 1] = paramFloat2;
/* 153 */     this.b[j + 2] = paramFloat3 / 2.0F;
/* 154 */     this.b[j + 3] = paramFloat4;
/*     */     
/* 156 */     if (paramBoolean) {
/* 157 */       if (i != 0) d(i - 1); 
/* 158 */       d(i);
/*     */     } 
/*     */     
/* 161 */     if (i != 0) f(i); 
/*     */   }
/*     */   
/*     */   public void setNodePosition(int paramInt, float paramFloat1, float paramFloat2) {
/* 165 */     paramInt *= 6;
/* 166 */     this.b[paramInt] = paramFloat1;
/* 167 */     this.b[paramInt + 1] = paramFloat2;
/*     */   }
/*     */   private void c(int paramInt) {
/*     */     float f1, f2;
/* 171 */     if (this.c < 2)
/*     */       return; 
/* 173 */     int i = paramInt * 6;
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 178 */     if (paramInt == 0) {
/*     */       
/* 180 */       int j = i + 6;
/* 181 */       f1 = this.b[j] - this.b[i];
/* 182 */       f2 = this.b[j + 1] - this.b[i + 1];
/* 183 */     } else if (f1 == this.c - 1) {
/*     */       
/* 185 */       int j = i - 6;
/* 186 */       f1 = this.b[i] - this.b[j];
/* 187 */       f2 = this.b[i + 1] - this.b[j + 1];
/*     */     } else {
/* 189 */       int j = i - 6;
/* 190 */       int k = i + 6;
/* 191 */       f1 = this.b[k] - this.b[j];
/* 192 */       f2 = this.b[k + 1] - this.b[j + 1];
/*     */     } 
/*     */     
/* 195 */     this.n.set(f1, f2).nor();
/* 196 */     this.b[i + 4] = -this.n.y;
/* 197 */     this.b[i + 5] = this.n.x;
/*     */   }
/*     */   public void updateAllNodes() {
/*     */     byte b;
/* 201 */     for (b = 0; b < this.c; b++) {
/* 202 */       c(b);
/*     */     }
/* 204 */     for (b = 1; b < this.c; b++) {
/* 205 */       e(b);
/*     */     }
/*     */     
/* 208 */     this.e = true;
/*     */   }
/*     */   
/*     */   private void d(int paramInt) {
/* 212 */     c(paramInt);
/* 213 */     if (paramInt != 0) e(paramInt); 
/* 214 */     if (paramInt != this.c - 1) e(paramInt + 1);
/*     */     
/* 216 */     this.e = true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void e(int paramInt) {
/* 223 */     if (paramInt == 0) {
/*     */       return;
/*     */     }
/* 226 */     int i = paramInt * 6;
/* 227 */     int j = (paramInt - 1) * 6;
/*     */ 
/*     */     
/* 230 */     int k = (paramInt - 1 << 1) * 20;
/*     */ 
/*     */     
/* 233 */     this.a[k] = this.b[j];
/* 234 */     this.a[k + 1] = this.b[j + 1];
/*     */     
/* 236 */     this.a[k + 3] = this.j;
/* 237 */     this.a[k + 4] = this.l;
/*     */ 
/*     */     
/* 240 */     this.a[k + 5] = this.b[i];
/* 241 */     this.a[k + 6] = this.b[i + 1];
/*     */     
/* 243 */     this.a[k + 8] = this.i;
/* 244 */     this.a[k + 9] = this.l;
/*     */ 
/*     */     
/* 247 */     this.n.set(this.b[i + 4], this.b[i + 5]).scl(this.b[i + 2]);
/* 248 */     this.a[k + 10] = this.b[i] + this.n.x;
/* 249 */     this.a[k + 11] = this.b[i + 1] + this.n.y;
/*     */     
/* 251 */     this.a[k + 13] = this.i;
/* 252 */     this.a[k + 14] = this.k;
/*     */ 
/*     */     
/* 255 */     this.n.set(this.b[j + 4], this.b[j + 5]).scl(this.b[j + 2]);
/* 256 */     this.a[k + 15] = this.b[j] + this.n.x;
/* 257 */     this.a[k + 16] = this.b[j + 1] + this.n.y;
/*     */     
/* 259 */     this.a[k + 18] = this.j;
/* 260 */     this.a[k + 19] = this.k;
/*     */ 
/*     */     
/* 263 */     k = ((paramInt - 1 << 1) + 1) * 20;
/*     */ 
/*     */     
/* 266 */     this.n.set(this.b[j + 4], this.b[j + 5]).scl(-this.b[j + 2]);
/* 267 */     this.a[k] = this.b[j] + this.n.x;
/* 268 */     this.a[k + 1] = this.b[j + 1] + this.n.y;
/*     */     
/* 270 */     this.a[k + 3] = this.j;
/* 271 */     this.a[k + 4] = this.m;
/*     */ 
/*     */     
/* 274 */     this.n.set(this.b[i + 4], this.b[i + 5]).scl(-this.b[i + 2]);
/* 275 */     this.a[k + 5] = this.b[i] + this.n.x;
/* 276 */     this.a[k + 6] = this.b[i + 1] + this.n.y;
/*     */     
/* 278 */     this.a[k + 8] = this.i;
/* 279 */     this.a[k + 9] = this.m;
/*     */ 
/*     */     
/* 282 */     this.a[k + 10] = this.b[i];
/* 283 */     this.a[k + 11] = this.b[i + 1];
/*     */     
/* 285 */     this.a[k + 13] = this.i;
/* 286 */     this.a[k + 14] = this.l;
/*     */ 
/*     */     
/* 289 */     this.a[k + 15] = this.b[j];
/* 290 */     this.a[k + 16] = this.b[j + 1];
/*     */     
/* 292 */     this.a[k + 18] = this.j;
/* 293 */     this.a[k + 19] = this.l;
/*     */     
/* 295 */     this.e = true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setNodeColor(int paramInt, float paramFloat) {
/* 304 */     this.b[paramInt * 6 + 3] = paramFloat;
/*     */     
/* 306 */     if (paramInt != 0) f(paramInt); 
/*     */   }
/*     */   
/*     */   public void setTint(Color paramColor) {
/* 310 */     if (paramColor == null) paramColor = Color.WHITE;
/*     */     
/* 312 */     if (this.d.a == paramColor.a && this.d.r == paramColor.r && this.d.g == paramColor.g && this.d.b == paramColor.b)
/*     */       return; 
/* 314 */     this.d.set(paramColor);
/* 315 */     this.e = true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setTintWithAlpha(Color paramColor, float paramFloat) {
/* 324 */     if (paramColor == null) paramColor = Color.WHITE;
/*     */     
/* 326 */     if (this.d.a == paramFloat && this.d.r == paramColor.r && this.d.g == paramColor.g && this.d.b == paramColor.b)
/*     */       return; 
/* 328 */     this.d.set(paramColor);
/* 329 */     this.d.a = paramFloat;
/* 330 */     this.e = true;
/*     */   }
/*     */ 
/*     */   
/*     */   public Color getTint() {
/* 335 */     return this.d;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void f(int paramInt) {
/* 343 */     int i = paramInt * 6;
/* 344 */     int j = (paramInt - 1) * 6;
/*     */ 
/*     */     
/*     */     int n;
/*     */     
/* 349 */     i = (int)(((n = NumberUtils.floatToIntColor(this.b[i + 3])) & 0xFF) * this.d.r);
/* 350 */     int k = (int)((n >> 8 & 0xFF) * this.d.g);
/* 351 */     int m = (int)((n >> 16 & 0xFF) * this.d.b);
/* 352 */     n = (int)(((n & 0xFF000000) >>> 24) * this.d.a);
/*     */     
/* 354 */     float f2 = NumberUtils.intToFloatColor(i + (k << 8) + (m << 16) + (n << 24));
/*     */ 
/*     */     
/* 357 */     i = (int)(((n = NumberUtils.floatToIntColor(this.b[j + 3])) & 0xFF) * this.d.r);
/* 358 */     k = (int)((n >> 8 & 0xFF) * this.d.g);
/* 359 */     m = (int)((n >> 16 & 0xFF) * this.d.b);
/* 360 */     n = (int)(((n & 0xFF000000) >>> 24) * this.d.a);
/* 361 */     float f1 = NumberUtils.intToFloatColor(i + (k << 8) + (m << 16) + (n << 24));
/*     */ 
/*     */     
/* 364 */     j = (paramInt - 1 << 1) * 20;
/* 365 */     this.a[j + 2] = f1;
/* 366 */     this.a[j + 7] = f2;
/* 367 */     this.a[j + 12] = f2;
/* 368 */     this.a[j + 17] = f1;
/*     */ 
/*     */     
/* 371 */     j = ((paramInt - 1 << 1) + 1) * 20;
/* 372 */     this.a[j + 2] = f1;
/* 373 */     this.a[j + 7] = f2;
/* 374 */     this.a[j + 12] = f2;
/* 375 */     this.a[j + 17] = f1;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void a() {
/* 385 */     for (byte b = 1; b < this.c; b++) {
/* 386 */       f(b);
/*     */     }
/*     */     
/* 389 */     this.e = false;
/*     */   }
/*     */   
/*     */   public void bakeVerticesColorIfNeeded() {
/* 393 */     if (this.e) {
/* 394 */       a();
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public void draw(Batch paramBatch) {
/* 400 */     if (this.c < 2)
/*     */       return; 
/* 402 */     bakeVerticesColorIfNeeded();
/*     */     
/* 404 */     paramBatch.draw(this.f.getTexture(), this.a, 0, a(this.c) * 20);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void drawDebug(Batch paramBatch) {
/* 410 */     ResourcePack.AtlasTextureRegion atlasTextureRegion = (AssetManager.TextureRegions.i()).smallCircle;
/* 411 */     int i = a(this.c) * 20;
/* 412 */     paramBatch.setColor(MaterialColor.YELLOW.P500);
/* 413 */     for (byte b = 0; b < i; b += 5) {
/* 414 */       float f1 = this.a[b];
/* 415 */       float f2 = this.a[b + 1];
/* 416 */       paramBatch.draw((TextureRegion)atlasTextureRegion, f1 - 1.0F, f2 - 1.0F, 2.0F, 2.0F);
/*     */     } 
/* 418 */     paramBatch.setColor(Color.WHITE);
/*     */   }
/*     */ 
/*     */   
/*     */   public void reset() {
/* 423 */     this.c = 0;
/* 424 */     this.f = null;
/* 425 */     this.g = false;
/*     */     
/* 427 */     this.e = true;
/*     */   }
/*     */   
/*     */   private MultiLine() {}
/*     */   
/*     */   public static class MultiLineFactory extends Shape.Factory<MultiLine> {
/*     */     public void setup() {}
/*     */     
/*     */     private static MultiLine b() {
/* 436 */       return new MultiLine((byte)0);
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\shapes\MultiLine.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */