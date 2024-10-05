/*     */ package com.prineside.tdi2.ui.actors;
/*     */ 
/*     */ import com.badlogic.gdx.graphics.Texture;
/*     */ import com.badlogic.gdx.graphics.g2d.Batch;
/*     */ import com.badlogic.gdx.graphics.g2d.TextureRegion;
/*     */ import com.badlogic.gdx.math.MathUtils;
/*     */ import com.prineside.tdi2.Config;
/*     */ import com.prineside.tdi2.scene2d.utils.Drawable;
/*     */ import com.prineside.tdi2.utils.IgnoreMethodOverloadLuaDefWarning;
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
/*     */ public class RadialSprite
/*     */   implements Drawable
/*     */ {
/*     */   private Texture a;
/*  28 */   private final float[] b = new float[60]; private float c; private float d; private float e; private float f;
/*     */   private float g;
/*     */   private float h;
/*  31 */   private int o = 0; private float i; private float j; private float k; private float l; private float m; private boolean n = true;
/*  32 */   private float p = 270.0F; private float q;
/*     */   private float r;
/*  34 */   private float s = 1.0F, t = 1.0F;
/*     */   
/*     */   private float u;
/*     */   
/*     */   private float v;
/*     */   
/*     */   private float w;
/*     */   
/*     */   private float x;
/*     */   
/*     */   private float y;
/*     */   
/*     */   private float z;
/*     */ 
/*     */   
/*     */   private void a(float paramFloat) {
/*  50 */     for (byte b = 0; b < 12; b++)
/*  51 */       this.b[b * 5 + 2] = paramFloat; 
/*     */   }
/*     */   
/*     */   private final void a(float[] paramArrayOffloat, int paramInt, float paramFloat1, float paramFloat2) {
/*  55 */     float f1 = this.h + this.l * (paramFloat1 - this.c) / this.f;
/*  56 */     float f2 = this.j + this.m * (1.0F - (paramFloat2 - this.d) / this.g);
/*  57 */     a(paramArrayOffloat, paramInt, paramFloat1, paramFloat2, f1, f2);
/*     */   }
/*     */   
/*     */   private final void a(float[] paramArrayOffloat, int paramInt, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4) {
/*  61 */     paramArrayOffloat[paramInt] = this.c + this.q + (paramFloat1 - this.c - this.q) * this.s;
/*  62 */     paramArrayOffloat[paramInt + 1] = this.d + this.r + (paramFloat2 - this.d - this.r) * this.t;
/*  63 */     paramArrayOffloat[paramInt + 3] = paramFloat3;
/*  64 */     paramArrayOffloat[paramInt + 4] = paramFloat4;
/*     */   }
/*     */   
/*     */   private void a(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6, float paramFloat7, float paramFloat8, float paramFloat9) {
/*  68 */     if (!this.n && this.c == paramFloat1 && this.d == paramFloat2 && this.e == paramFloat5 && this.f == paramFloat3 && this.g == paramFloat4 && this.h == paramFloat6 && this.k == paramFloat9 && this.i == paramFloat8 && this.k == paramFloat9) {
/*     */       return;
/*     */     }
/*  71 */     this.c = paramFloat1;
/*  72 */     this.d = paramFloat2;
/*  73 */     this.f = paramFloat3;
/*  74 */     this.g = paramFloat4;
/*  75 */     this.e = paramFloat5;
/*  76 */     this.h = paramFloat6;
/*  77 */     this.j = paramFloat7;
/*  78 */     this.i = paramFloat8;
/*  79 */     this.k = paramFloat9;
/*  80 */     paramFloat6 = paramFloat3 * 0.5F;
/*  81 */     paramFloat7 = paramFloat4 * 0.5F;
/*  82 */     paramFloat3 = paramFloat1 + paramFloat3;
/*  83 */     paramFloat4 = paramFloat2 + paramFloat4;
/*  84 */     paramFloat8 = paramFloat1 + paramFloat6;
/*  85 */     paramFloat9 = paramFloat2 + paramFloat7;
/*  86 */     float f1 = MathUtils.cosDeg(paramFloat5 + this.p);
/*  87 */     paramFloat5 = MathUtils.sinDeg(paramFloat5 + this.p);
/*  88 */     float f2 = (f1 != 0.0F) ? StrictMath.abs(paramFloat6 / f1) : 1.0E8F;
/*  89 */     float f3 = (paramFloat5 != 0.0F) ? StrictMath.abs(paramFloat7 / paramFloat5) : 1.0E8F;
/*     */ 
/*     */     
/*  92 */     float f4, f5 = (f4 = StrictMath.min(f2, f3)) * f1;
/*  93 */     f4 *= paramFloat5;
/*  94 */     a(this.b, 5, paramFloat1 + paramFloat6, paramFloat2);
/*  95 */     if (f1 >= 0.0F) {
/*  96 */       a(this.b, 15, paramFloat1, paramFloat4);
/*  97 */       a(this.b, 0, paramFloat8, paramFloat4);
/*  98 */       a(this.b, 10, paramFloat1, paramFloat2);
/*  99 */       a(this.b, 30, paramFloat8, paramFloat9);
/* 100 */       a(this.b, 35, paramFloat8, paramFloat4);
/* 101 */       if (f2 < f3) {
/* 102 */         a(this.b, 20, paramFloat3, paramFloat4);
/* 103 */         a(this.b, 25, paramFloat3, paramFloat9 + f4);
/* 104 */         this.o = 2;
/* 105 */       } else if (paramFloat5 > 0.0F) {
/* 106 */         a(this.b, 25, paramFloat8 + f5, paramFloat4);
/* 107 */         a(this.b, 20, paramFloat8 + f5 * 0.5F, paramFloat4);
/* 108 */         this.o = 2;
/*     */       } else {
/* 110 */         a(this.b, 20, paramFloat3, paramFloat4);
/* 111 */         a(this.b, 25, paramFloat3, paramFloat2);
/* 112 */         a(this.b, 55, paramFloat8, paramFloat9);
/* 113 */         a(this.b, 40, paramFloat3, paramFloat2);
/* 114 */         a(this.b, 50, paramFloat8 + f5, paramFloat2);
/* 115 */         a(this.b, 45, paramFloat8 + f5 * 0.5F, paramFloat2);
/* 116 */         this.o = 3;
/*     */       } 
/*     */     } else {
/* 119 */       a(this.b, 0, paramFloat1 + paramFloat6, paramFloat2 + paramFloat7);
/* 120 */       if (f2 < f3) {
/* 121 */         a(this.b, 10, paramFloat1, paramFloat2);
/* 122 */         a(this.b, 15, paramFloat1, paramFloat9 + f4);
/* 123 */         this.o = 1;
/* 124 */       } else if (paramFloat5 < 0.0F) {
/* 125 */         a(this.b, 15, paramFloat8 + f5, paramFloat2);
/* 126 */         a(this.b, 10, paramFloat8 + f5 * 0.5F, paramFloat2);
/* 127 */         this.o = 1;
/*     */       } else {
/* 129 */         a(this.b, 15, paramFloat1, paramFloat4);
/* 130 */         a(this.b, 10, paramFloat1, paramFloat2);
/* 131 */         a(this.b, 25, paramFloat8, paramFloat9);
/* 132 */         a(this.b, 30, paramFloat1, paramFloat4);
/* 133 */         a(this.b, 35, paramFloat8 + f5 * 0.5F, paramFloat4);
/* 134 */         a(this.b, 20, paramFloat8 + f5, paramFloat4);
/* 135 */         this.o = 2;
/*     */       } 
/*     */     } 
/* 138 */     this.n = false;
/*     */   }
/*     */   
/*     */   @IgnoreMethodOverloadLuaDefWarning
/*     */   public void draw(Batch paramBatch, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5) {
/* 143 */     if (paramFloat3 < 0.0F) { this.s = -1.0F; paramFloat3 = -paramFloat3; }
/* 144 */      if (paramFloat4 < 0.0F) { this.t = -1.0F; paramFloat4 = -paramFloat4; }
/* 145 */      a(paramFloat1, paramFloat2, paramFloat3, paramFloat4, paramFloat5, this.h, this.j, this.i, this.k);
/* 146 */     a(paramBatch.getPackedColor());
/* 147 */     paramBatch.draw(this.a, this.b, 0, 20 * this.o);
/*     */   }
/*     */   
/*     */   @IgnoreMethodOverloadLuaDefWarning
/*     */   public void draw(Batch paramBatch, float paramFloat1, float paramFloat2, float paramFloat3) {
/* 152 */     draw(paramBatch, paramFloat1, paramFloat2, this.f, this.g, paramFloat3);
/*     */   }
/*     */   
/*     */   public void setOrigin(float paramFloat1, float paramFloat2) {
/* 156 */     if (this.q == paramFloat1 && this.r == paramFloat2)
/*     */       return; 
/* 158 */     this.q = paramFloat1;
/* 159 */     this.r = paramFloat2;
/* 160 */     this.n = true;
/*     */   }
/*     */   
/*     */   public void setScale(float paramFloat1, float paramFloat2) {
/* 164 */     if (this.s == paramFloat1 && this.t == paramFloat2)
/*     */       return; 
/* 166 */     this.s = paramFloat1;
/* 167 */     this.t = paramFloat2;
/* 168 */     this.n = true;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   @IgnoreMethodOverloadLuaDefWarning
/*     */   public void draw(Batch paramBatch, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4) {
/* 175 */     draw(paramBatch, paramFloat1, paramFloat2, paramFloat3, paramFloat4, this.e);
/*     */   }
/*     */   
/*     */   public float getAngle() {
/* 179 */     return this.e;
/*     */   }
/*     */   
/*     */   public void setAngle(float paramFloat) {
/* 183 */     if (this.e == paramFloat)
/*     */       return; 
/* 185 */     this.e = paramFloat;
/* 186 */     this.n = true;
/*     */   }
/*     */   
/* 189 */   public RadialSprite(TextureRegion paramTextureRegion) { this.u = 0.0F;
/* 190 */     this.v = 0.0F;
/* 191 */     this.w = 0.0F;
/* 192 */     this.x = 0.0F;
/* 193 */     this.y = 0.0F;
/* 194 */     this.z = 0.0F; this.a = paramTextureRegion.getTexture(); this.h = paramTextureRegion.getU(); this.j = paramTextureRegion.getV(); this.i = paramTextureRegion.getU2(); this.k = paramTextureRegion.getV2(); this.l = this.i - this.h;
/*     */     this.m = this.k - this.j;
/*     */     this.f = paramTextureRegion.getRegionWidth();
/*     */     this.g = paramTextureRegion.getRegionHeight();
/* 198 */     a(Config.WHITE_COLOR_CACHED_FLOAT_BITS.toFloatBits()); } public float getLeftWidth() { return this.u; }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setLeftWidth(float paramFloat) {
/* 203 */     this.u = paramFloat;
/*     */   }
/*     */ 
/*     */   
/*     */   public float getRightWidth() {
/* 208 */     return this.v;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setRightWidth(float paramFloat) {
/* 213 */     this.v = paramFloat;
/*     */   }
/*     */ 
/*     */   
/*     */   public float getTopHeight() {
/* 218 */     return this.w;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setTopHeight(float paramFloat) {
/* 223 */     this.w = paramFloat;
/*     */   }
/*     */ 
/*     */   
/*     */   public float getBottomHeight() {
/* 228 */     return this.x;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setBottomHeight(float paramFloat) {
/* 233 */     this.x = paramFloat;
/*     */   }
/*     */ 
/*     */   
/*     */   public float getMinWidth() {
/* 238 */     return this.y;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setMinWidth(float paramFloat) {
/* 243 */     this.y = paramFloat;
/*     */   }
/*     */ 
/*     */   
/*     */   public float getMinHeight() {
/* 248 */     return this.z;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setMinHeight(float paramFloat) {
/* 253 */     this.z = paramFloat;
/*     */   }
/*     */   
/*     */   public Texture getTexture() {
/* 257 */     return this.a;
/*     */   }
/*     */   
/*     */   public void setTextureRegion(TextureRegion paramTextureRegion) {
/* 261 */     this.a = paramTextureRegion.getTexture();
/* 262 */     this.h = paramTextureRegion.getU();
/* 263 */     this.j = paramTextureRegion.getV();
/* 264 */     this.i = paramTextureRegion.getU2();
/* 265 */     this.k = paramTextureRegion.getV2();
/* 266 */     this.n = true;
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi\\ui\actors\RadialSprite.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */