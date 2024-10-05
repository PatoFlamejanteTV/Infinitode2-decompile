/*     */ package com.badlogic.gdx.graphics.g2d;
/*     */ 
/*     */ import com.badlogic.gdx.graphics.Texture;
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
/*     */ public class TextureRegion
/*     */ {
/*     */   Texture texture;
/*     */   float u;
/*     */   float v;
/*     */   float u2;
/*     */   float v2;
/*     */   int regionWidth;
/*     */   int regionHeight;
/*     */   
/*     */   public TextureRegion() {}
/*     */   
/*     */   public TextureRegion(Texture paramTexture) {
/*  37 */     if (paramTexture == null) throw new IllegalArgumentException("texture cannot be null."); 
/*  38 */     this.texture = paramTexture;
/*  39 */     setRegion(0, 0, paramTexture.getWidth(), paramTexture.getHeight());
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public TextureRegion(Texture paramTexture, int paramInt1, int paramInt2) {
/*  45 */     this.texture = paramTexture;
/*  46 */     setRegion(0, 0, paramInt1, paramInt2);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public TextureRegion(Texture paramTexture, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
/*  52 */     this.texture = paramTexture;
/*  53 */     setRegion(paramInt1, paramInt2, paramInt3, paramInt4);
/*     */   }
/*     */   
/*     */   public TextureRegion(Texture paramTexture, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4) {
/*  57 */     this.texture = paramTexture;
/*  58 */     setRegion(paramFloat1, paramFloat2, paramFloat3, paramFloat4);
/*     */   }
/*     */ 
/*     */   
/*     */   public TextureRegion(TextureRegion paramTextureRegion) {
/*  63 */     setRegion(paramTextureRegion);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public TextureRegion(TextureRegion paramTextureRegion, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
/*  71 */     setRegion(paramTextureRegion, paramInt1, paramInt2, paramInt3, paramInt4);
/*     */   }
/*     */ 
/*     */   
/*     */   public void setRegion(Texture paramTexture) {
/*  76 */     this.texture = paramTexture;
/*  77 */     setRegion(0, 0, paramTexture.getWidth(), paramTexture.getHeight());
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setRegion(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
/*  83 */     float f1 = 1.0F / this.texture.getWidth();
/*  84 */     float f2 = 1.0F / this.texture.getHeight();
/*  85 */     setRegion(paramInt1 * f1, paramInt2 * f2, (paramInt1 + paramInt3) * f1, (paramInt2 + paramInt4) * f2);
/*  86 */     this.regionWidth = Math.abs(paramInt3);
/*  87 */     this.regionHeight = Math.abs(paramInt4);
/*     */   }
/*     */   
/*     */   public void setRegion(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4) {
/*  91 */     int i = this.texture.getWidth(), j = this.texture.getHeight();
/*  92 */     this.regionWidth = Math.round(Math.abs(paramFloat3 - paramFloat1) * i);
/*  93 */     this.regionHeight = Math.round(Math.abs(paramFloat4 - paramFloat2) * j);
/*     */ 
/*     */     
/*  96 */     if (this.regionWidth == 1 && this.regionHeight == 1) {
/*  97 */       float f = 0.25F / i;
/*  98 */       paramFloat1 += f;
/*  99 */       paramFloat3 -= f;
/* 100 */       f = 0.25F / j;
/* 101 */       paramFloat2 += f;
/* 102 */       paramFloat4 -= f;
/*     */     } 
/*     */     
/* 105 */     this.u = paramFloat1;
/* 106 */     this.v = paramFloat2;
/* 107 */     this.u2 = paramFloat3;
/* 108 */     this.v2 = paramFloat4;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setRegion(TextureRegion paramTextureRegion) {
/* 113 */     this.texture = paramTextureRegion.texture;
/* 114 */     setRegion(paramTextureRegion.u, paramTextureRegion.v, paramTextureRegion.u2, paramTextureRegion.v2);
/*     */   }
/*     */ 
/*     */   
/*     */   public void setRegion(TextureRegion paramTextureRegion, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
/* 119 */     this.texture = paramTextureRegion.texture;
/* 120 */     setRegion(paramTextureRegion.getRegionX() + paramInt1, paramTextureRegion.getRegionY() + paramInt2, paramInt3, paramInt4);
/*     */   }
/*     */   
/*     */   public Texture getTexture() {
/* 124 */     return this.texture;
/*     */   }
/*     */   
/*     */   public void setTexture(Texture paramTexture) {
/* 128 */     this.texture = paramTexture;
/*     */   }
/*     */   
/*     */   public float getU() {
/* 132 */     return this.u;
/*     */   }
/*     */   
/*     */   public void setU(float paramFloat) {
/* 136 */     this.u = paramFloat;
/* 137 */     this.regionWidth = Math.round(Math.abs(this.u2 - paramFloat) * this.texture.getWidth());
/*     */   }
/*     */   
/*     */   public float getV() {
/* 141 */     return this.v;
/*     */   }
/*     */   
/*     */   public void setV(float paramFloat) {
/* 145 */     this.v = paramFloat;
/* 146 */     this.regionHeight = Math.round(Math.abs(this.v2 - paramFloat) * this.texture.getHeight());
/*     */   }
/*     */   
/*     */   public float getU2() {
/* 150 */     return this.u2;
/*     */   }
/*     */   
/*     */   public void setU2(float paramFloat) {
/* 154 */     this.u2 = paramFloat;
/* 155 */     this.regionWidth = Math.round(Math.abs(paramFloat - this.u) * this.texture.getWidth());
/*     */   }
/*     */   
/*     */   public float getV2() {
/* 159 */     return this.v2;
/*     */   }
/*     */   
/*     */   public void setV2(float paramFloat) {
/* 163 */     this.v2 = paramFloat;
/* 164 */     this.regionHeight = Math.round(Math.abs(paramFloat - this.v) * this.texture.getHeight());
/*     */   }
/*     */   
/*     */   public int getRegionX() {
/* 168 */     return Math.round(this.u * this.texture.getWidth());
/*     */   }
/*     */   
/*     */   public void setRegionX(int paramInt) {
/* 172 */     setU(paramInt / this.texture.getWidth());
/*     */   }
/*     */   
/*     */   public int getRegionY() {
/* 176 */     return Math.round(this.v * this.texture.getHeight());
/*     */   }
/*     */   
/*     */   public void setRegionY(int paramInt) {
/* 180 */     setV(paramInt / this.texture.getHeight());
/*     */   }
/*     */ 
/*     */   
/*     */   public int getRegionWidth() {
/* 185 */     return this.regionWidth;
/*     */   }
/*     */   
/*     */   public void setRegionWidth(int paramInt) {
/* 189 */     if (isFlipX()) {
/* 190 */       setU(this.u2 + paramInt / this.texture.getWidth()); return;
/*     */     } 
/* 192 */     setU2(this.u + paramInt / this.texture.getWidth());
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int getRegionHeight() {
/* 198 */     return this.regionHeight;
/*     */   }
/*     */   
/*     */   public void setRegionHeight(int paramInt) {
/* 202 */     if (isFlipY()) {
/* 203 */       setV(this.v2 + paramInt / this.texture.getHeight()); return;
/*     */     } 
/* 205 */     setV2(this.v + paramInt / this.texture.getHeight());
/*     */   }
/*     */ 
/*     */   
/*     */   public void flip(boolean paramBoolean1, boolean paramBoolean2) {
/* 210 */     if (paramBoolean1) {
/* 211 */       float f = this.u;
/* 212 */       this.u = this.u2;
/* 213 */       this.u2 = f;
/*     */     } 
/* 215 */     if (paramBoolean2) {
/* 216 */       float f = this.v;
/* 217 */       this.v = this.v2;
/* 218 */       this.v2 = f;
/*     */     } 
/*     */   }
/*     */   
/*     */   public boolean isFlipX() {
/* 223 */     return (this.u > this.u2);
/*     */   }
/*     */   
/*     */   public boolean isFlipY() {
/* 227 */     return (this.v > this.v2);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void scroll(float paramFloat1, float paramFloat2) {
/* 235 */     if (paramFloat1 != 0.0F) {
/* 236 */       float f = (this.u2 - this.u) * this.texture.getWidth();
/* 237 */       this.u = (this.u + paramFloat1) % 1.0F;
/* 238 */       this.u2 = this.u + f / this.texture.getWidth();
/*     */     } 
/* 240 */     if (paramFloat2 != 0.0F) {
/* 241 */       float f = (this.v2 - this.v) * this.texture.getHeight();
/* 242 */       this.v = (this.v + paramFloat2) % 1.0F;
/* 243 */       this.v2 = this.v + f / this.texture.getHeight();
/*     */     } 
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
/*     */   public TextureRegion[][] split(int paramInt1, int paramInt2) {
/* 256 */     int i = getRegionX();
/* 257 */     int j = getRegionY();
/* 258 */     int k = this.regionWidth;
/*     */ 
/*     */     
/* 261 */     int m = (m = this.regionHeight) / paramInt2;
/* 262 */     k /= paramInt1;
/*     */     
/* 264 */     int n = i;
/* 265 */     TextureRegion[][] arrayOfTextureRegion = new TextureRegion[m][k];
/* 266 */     for (byte b = 0; b < m; b++, j += paramInt2) {
/* 267 */       i = n;
/* 268 */       for (byte b1 = 0; b1 < k; b1++, i += paramInt1) {
/* 269 */         arrayOfTextureRegion[b][b1] = new TextureRegion(this.texture, i, j, paramInt1, paramInt2);
/*     */       }
/*     */     } 
/*     */     
/* 273 */     return arrayOfTextureRegion;
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
/*     */   public static TextureRegion[][] split(Texture paramTexture, int paramInt1, int paramInt2) {
/*     */     TextureRegion textureRegion;
/* 286 */     return (textureRegion = new TextureRegion(paramTexture)).split(paramInt1, paramInt2);
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gdx\graphics\g2d\TextureRegion.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */