/*     */ package com.badlogic.gdx.scenes.scene2d.utils;
/*     */ 
/*     */ import com.badlogic.gdx.graphics.Color;
/*     */ import com.badlogic.gdx.graphics.Texture;
/*     */ import com.badlogic.gdx.graphics.g2d.Batch;
/*     */ import com.badlogic.gdx.graphics.g2d.TextureRegion;
/*     */ import com.badlogic.gdx.utils.Align;
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
/*     */ public class TiledDrawable
/*     */   extends TextureRegionDrawable
/*     */ {
/*  29 */   private final Color color = new Color(1.0F, 1.0F, 1.0F, 1.0F);
/*  30 */   private float scale = 1.0F;
/*  31 */   private int align = 12;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public TiledDrawable(TextureRegion paramTextureRegion) {
/*  38 */     super(paramTextureRegion);
/*     */   }
/*     */   
/*     */   public TiledDrawable(TextureRegionDrawable paramTextureRegionDrawable) {
/*  42 */     super(paramTextureRegionDrawable);
/*     */   }
/*     */   
/*     */   public void draw(Batch paramBatch, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4) {
/*  46 */     float f = paramBatch.getPackedColor();
/*  47 */     paramBatch.setColor(paramBatch.getColor().mul(this.color));
/*     */     
/*  49 */     draw(paramBatch, getRegion(), paramFloat1, paramFloat2, paramFloat3, paramFloat4, this.scale, this.align);
/*     */     
/*  51 */     paramBatch.setPackedColor(f);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void draw(Batch paramBatch, TextureRegion paramTextureRegion, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, int paramInt) {
/*  56 */     float f8, f9, f10, f11, f2 = paramTextureRegion.getRegionWidth() * paramFloat5;
/*  57 */     float f3 = paramTextureRegion.getRegionHeight() * paramFloat5;
/*     */     
/*     */     Texture texture;
/*  60 */     float f4 = (texture = paramTextureRegion.getTexture()).getWidth() * paramFloat5;
/*  61 */     paramFloat5 = texture.getHeight() * paramFloat5;
/*  62 */     float f5 = paramTextureRegion.getU();
/*  63 */     float f6 = paramTextureRegion.getV();
/*  64 */     float f7 = paramTextureRegion.getU2();
/*  65 */     float f1 = paramTextureRegion.getV2();
/*     */     
/*  67 */     int i = (int)(paramFloat3 / f2);
/*     */ 
/*     */     
/*  70 */     if (Align.isLeft(paramInt)) {
/*  71 */       f8 = 0.0F;
/*  72 */       f9 = paramFloat3 - f2 * i;
/*  73 */     } else if (Align.isRight(paramInt)) {
/*  74 */       f8 = paramFloat3 - f2 * i;
/*  75 */       f9 = 0.0F;
/*     */     }
/*  77 */     else if (i != 0) {
/*  78 */       i = (i % 2 == 1) ? i : (i - 1);
/*     */       
/*  80 */       float f = 0.5F * (paramFloat3 - f2 * i);
/*  81 */       f9 = f;
/*     */     } else {
/*  83 */       f8 = 0.0F;
/*  84 */       f9 = 0.0F;
/*     */     } 
/*     */     
/*  87 */     int j = (int)(paramFloat4 / f3);
/*     */ 
/*     */     
/*  90 */     if (Align.isTop(paramInt)) {
/*  91 */       f10 = 0.0F;
/*  92 */       f11 = paramFloat4 - f3 * j;
/*  93 */     } else if (Align.isBottom(paramInt)) {
/*  94 */       f10 = paramFloat4 - f3 * j;
/*  95 */       f11 = 0.0F;
/*     */     }
/*  97 */     else if (j != 0) {
/*  98 */       j = (j % 2 == 1) ? j : (j - 1);
/*     */       
/* 100 */       float f = 0.5F * (paramFloat4 - f3 * j);
/* 101 */       f11 = f;
/*     */     } else {
/* 103 */       f10 = 0.0F;
/* 104 */       f11 = 0.0F;
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/* 109 */     float f13 = paramFloat2;
/*     */ 
/*     */     
/* 112 */     if (f8 > 0.0F) {
/* 113 */       float f = f7 - f8 / f4;
/*     */ 
/*     */       
/* 116 */       if (f11 > 0.0F) {
/* 117 */         float f20 = f6 + f11 / paramFloat5;
/* 118 */         paramBatch.draw(texture, paramFloat1, paramFloat2, f8, f11, f, f20, f7, f6);
/* 119 */         f13 = paramFloat2 + f11;
/*     */       } 
/*     */ 
/*     */       
/* 123 */       if (j == 0 && Align.isCenterVertical(paramInt)) {
/* 124 */         float f20 = 0.5F * (f1 - f6) * (1.0F - paramFloat4 / f3);
/* 125 */         float f21 = f1 - f20;
/* 126 */         float f22 = f6 + f20;
/* 127 */         paramBatch.draw(texture, paramFloat1, f13, f8, paramFloat4, f, f21, f7, f22);
/* 128 */         f13 += paramFloat4;
/*     */       } else {
/* 130 */         for (byte b1 = 0; b1 < j; b1++) {
/* 131 */           paramBatch.draw(texture, paramFloat1, f13, f8, f3, f, f1, f7, f6);
/* 132 */           f13 += f3;
/*     */         } 
/*     */       } 
/*     */ 
/*     */       
/* 137 */       if (f10 > 0.0F) {
/* 138 */         float f20 = f1 - f10 / paramFloat5;
/* 139 */         paramBatch.draw(texture, paramFloat1, f13, f8, f10, f, f1, f7, f20);
/*     */       } 
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 146 */     if (f11 > 0.0F) {
/* 147 */       float f20 = paramFloat1 + f8;
/* 148 */       f13 = paramFloat2;
/*     */       
/* 150 */       float f21 = f6 + f11 / paramFloat5;
/*     */       
/* 152 */       if (i == 0 && Align.isCenterHorizontal(paramInt)) {
/* 153 */         float f22 = 0.5F * (f7 - f5) * (1.0F - paramFloat3 / f2);
/* 154 */         float f23 = f5 + f22;
/* 155 */         float f24 = f7 - f22;
/* 156 */         paramBatch.draw(texture, f20, paramFloat2, paramFloat3, f11, f23, f21, f24, f6);
/*     */       } else {
/*     */         
/* 159 */         for (byte b1 = 0; b1 < i; b1++) {
/* 160 */           paramBatch.draw(texture, f20, paramFloat2, f2, f11, f5, f21, f7, f6);
/* 161 */           f20 += f2;
/*     */         } 
/*     */       } 
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/* 168 */     float f12 = paramFloat1 + f8;
/*     */     
/* 170 */     int k = i;
/* 171 */     int m = j;
/*     */     
/* 173 */     float f14 = f2;
/* 174 */     float f15 = f3;
/* 175 */     float f16 = f5;
/* 176 */     float f17 = f7;
/* 177 */     float f18 = f1;
/* 178 */     float f19 = f6;
/* 179 */     if (i == 0 && Align.isCenterHorizontal(paramInt)) {
/* 180 */       i = 1;
/* 181 */       f14 = paramFloat3;
/* 182 */       float f = 0.5F * (f7 - f5) * (1.0F - paramFloat3 / f2);
/* 183 */       f16 = f5 + f;
/* 184 */       f17 = f7 - f;
/*     */     } 
/* 186 */     if (j == 0 && Align.isCenterVertical(paramInt)) {
/* 187 */       j = 1;
/* 188 */       f15 = paramFloat4;
/* 189 */       float f = 0.5F * (f1 - f6) * (1.0F - paramFloat4 / f3);
/* 190 */       f18 = f1 - f;
/* 191 */       f19 = f6 + f;
/*     */     } 
/* 193 */     for (byte b = 0; b < i; b++) {
/* 194 */       f13 = paramFloat2 + f11;
/* 195 */       for (byte b1 = 0; b1 < j; b1++) {
/* 196 */         paramBatch.draw(texture, f12, f13, f14, f15, f16, f18, f17, f19);
/*     */         
/* 198 */         f13 += f15;
/*     */       } 
/* 200 */       f12 += f14;
/*     */     } 
/*     */     
/* 203 */     i = k;
/* 204 */     j = m;
/*     */ 
/*     */ 
/*     */     
/* 208 */     if (f10 > 0.0F) {
/* 209 */       f12 = paramFloat1 + f8;
/*     */       
/* 211 */       float f = f1 - f10 / paramFloat5;
/*     */       
/* 213 */       if (i == 0 && Align.isCenterHorizontal(paramInt)) {
/* 214 */         float f20 = 0.5F * (f7 - f5) * (1.0F - paramFloat3 / f2);
/* 215 */         f14 = f5 + f20;
/* 216 */         f15 = f7 - f20;
/* 217 */         paramBatch.draw(texture, f12, f13, paramFloat3, f10, f14, f1, f15, f);
/* 218 */         f12 += paramFloat3;
/*     */       } else {
/* 220 */         for (m = 0; m < i; m++) {
/* 221 */           paramBatch.draw(texture, f12, f13, f2, f10, f5, f1, f7, f);
/* 222 */           f12 += f2;
/*     */         } 
/*     */       } 
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/* 229 */     if (f9 > 0.0F) {
/* 230 */       f13 = paramFloat2;
/*     */       
/* 232 */       float f = f5 + f9 / f4;
/*     */ 
/*     */       
/* 235 */       if (f11 > 0.0F) {
/* 236 */         float f20 = f6 + f11 / paramFloat5;
/* 237 */         paramBatch.draw(texture, f12, paramFloat2, f9, f11, f5, f20, f, f6);
/* 238 */         f13 = paramFloat2 + f11;
/*     */       } 
/*     */ 
/*     */       
/* 242 */       if (j == 0 && Align.isCenterVertical(paramInt)) {
/* 243 */         float f20 = 0.5F * (f1 - f6) * (1.0F - paramFloat4 / f3);
/* 244 */         f14 = f1 - f20;
/* 245 */         f15 = f6 + f20;
/* 246 */         paramBatch.draw(texture, f12, f13, f9, paramFloat4, f5, f14, f, f15);
/* 247 */         f13 += paramFloat4;
/*     */       } else {
/* 249 */         for (m = 0; m < j; m++) {
/* 250 */           paramBatch.draw(texture, f12, f13, f9, f3, f5, f1, f, f6);
/* 251 */           f13 += f3;
/*     */         } 
/*     */       } 
/*     */ 
/*     */       
/* 256 */       if (f10 > 0.0F) {
/* 257 */         float f20 = f1 - f10 / paramFloat5;
/* 258 */         paramBatch.draw(texture, f12, f13, f9, f10, f5, f1, f, f20);
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void draw(Batch paramBatch, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6, float paramFloat7, float paramFloat8, float paramFloat9) {
/* 265 */     throw new UnsupportedOperationException();
/*     */   }
/*     */   
/*     */   public Color getColor() {
/* 269 */     return this.color;
/*     */   }
/*     */   
/*     */   public void setScale(float paramFloat) {
/* 273 */     this.scale = paramFloat;
/*     */   }
/*     */   
/*     */   public float getScale() {
/* 277 */     return this.scale;
/*     */   }
/*     */   
/*     */   public int getAlign() {
/* 281 */     return this.align;
/*     */   }
/*     */   
/*     */   public void setAlign(int paramInt) {
/* 285 */     this.align = paramInt;
/*     */   }
/*     */   
/*     */   public TiledDrawable tint(Color paramColor) {
/*     */     TiledDrawable tiledDrawable;
/* 290 */     (tiledDrawable = new TiledDrawable(this)).color.set(paramColor);
/* 291 */     tiledDrawable.setLeftWidth(getLeftWidth());
/* 292 */     tiledDrawable.setRightWidth(getRightWidth());
/* 293 */     tiledDrawable.setTopHeight(getTopHeight());
/* 294 */     tiledDrawable.setBottomHeight(getBottomHeight());
/* 295 */     return tiledDrawable;
/*     */   }
/*     */   
/*     */   public TiledDrawable() {}
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gdx\scenes\scene2\\utils\TiledDrawable.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */