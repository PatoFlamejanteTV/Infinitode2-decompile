/*     */ package com.prineside.tdi2.ui.actors;
/*     */ 
/*     */ import com.badlogic.gdx.graphics.Color;
/*     */ import com.badlogic.gdx.graphics.g2d.Batch;
/*     */ import com.badlogic.gdx.graphics.g2d.TextureRegion;
/*     */ import com.prineside.tdi2.Game;
/*     */ import com.prineside.tdi2.scene2d.ui.Widget;
/*     */ 
/*     */ 
/*     */ public class QuadActor
/*     */   extends Widget
/*     */ {
/*  13 */   private float[] j = new float[] { 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F };
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  20 */   private int[] k = new int[] { 255, 255, 255, 255, 255, 255, 255, 255, 255, 255, 255, 255, 255, 255, 255, 255 };
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  27 */   private float[] l = new float[] { 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 1.0F, 0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 0.0F, 0.0F, 0.0F, 1.0F, 0.0F };
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
/*     */   private TextureRegion m;
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
/*     */   public QuadActor(float[] paramArrayOffloat, int[] paramArrayOfint) {
/*  53 */     setVertices(paramArrayOffloat);
/*  54 */     setVertexColorsDirect(paramArrayOfint);
/*     */   }
/*     */   
/*     */   public QuadActor(float[] paramArrayOffloat, Color paramColor) {
/*  58 */     setVertices(paramArrayOffloat);
/*  59 */     setVertexColorsSingle(paramColor);
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
/*     */   public QuadActor(Color paramColor, float[] paramArrayOffloat) {
/*  73 */     setVertexPositions(paramArrayOffloat);
/*  74 */     setVertexColorsSingle(paramColor);
/*     */   }
/*     */   
/*     */   public QuadActor(Color[] paramArrayOfColor, float[] paramArrayOffloat) {
/*  78 */     setVertexPositions(paramArrayOffloat);
/*  79 */     setVertexColors(paramArrayOfColor[0], paramArrayOfColor[1], paramArrayOfColor[2], paramArrayOfColor[3]);
/*     */   }
/*     */   
/*     */   public QuadActor(float[] paramArrayOffloat, Color paramColor1, Color paramColor2, Color paramColor3, Color paramColor4) {
/*  83 */     setVertices(paramArrayOffloat);
/*  84 */     setVertexColors(paramColor1, paramColor2, paramColor3, paramColor4);
/*     */   }
/*     */   
/*     */   public void setTextureRegion(TextureRegion paramTextureRegion) {
/*  88 */     this.m = paramTextureRegion;
/*  89 */     setVertices(this.j);
/*     */   }
/*     */   
/*     */   public TextureRegion getTextureRegion() {
/*  93 */     if (this.m == null) {
/*  94 */       setTextureRegion((TextureRegion)Game.i.assetManager.getBlankWhiteTextureRegion());
/*     */     }
/*     */     
/*  97 */     return this.m;
/*     */   }
/*     */   
/*     */   public float[] getVertexPositions() {
/* 101 */     return this.j;
/*     */   }
/*     */   
/*     */   public void setVertexPositions(float[] paramArrayOffloat) {
/* 105 */     float f1 = StrictMath.max(paramArrayOffloat[4], paramArrayOffloat[6]);
/* 106 */     float f2 = StrictMath.max(paramArrayOffloat[3], paramArrayOffloat[5]);
/* 107 */     setWidth(f1);
/* 108 */     setHeight(f2);
/*     */     
/* 110 */     float[] arrayOfFloat = new float[8];
/* 111 */     for (byte b = 0; b < 4; b++) {
/* 112 */       arrayOfFloat[b << 1] = paramArrayOffloat[b << 1] / f1;
/* 113 */       arrayOfFloat[(b << 1) + 1] = paramArrayOffloat[(b << 1) + 1] / f2;
/*     */     } 
/*     */     
/* 116 */     setVertices(arrayOfFloat);
/*     */   }
/*     */   
/*     */   public void setVertices(float[] paramArrayOffloat) {
/* 120 */     if (paramArrayOffloat.length != 8) {
/* 121 */       throw new RuntimeException("vertices must be an array of 8 floats, " + paramArrayOffloat.length + " passed");
/*     */     }
/*     */     
/* 124 */     System.arraycopy(paramArrayOffloat, 0, this.j, 0, this.j.length);
/*     */     
/*     */     TextureRegion textureRegion;
/*     */     
/* 128 */     float f2 = (textureRegion = getTextureRegion()).getU();
/* 129 */     float f3 = textureRegion.getV();
/* 130 */     float f4 = textureRegion.getU2();
/* 131 */     float f1 = textureRegion.getV2();
/*     */ 
/*     */     
/* 134 */     this.l[3] = f2;
/* 135 */     this.l[4] = f1;
/*     */     
/* 137 */     this.l[8] = f2;
/* 138 */     this.l[9] = f3;
/*     */     
/* 140 */     this.l[13] = f4;
/* 141 */     this.l[14] = f3;
/*     */     
/* 143 */     this.l[18] = f4;
/* 144 */     this.l[19] = f1;
/*     */   }
/*     */   
/*     */   public void setVertexColorsDirect(int[] paramArrayOfint) {
/* 148 */     if (paramArrayOfint.length != 16) {
/* 149 */       throw new RuntimeException("colors must be an array of 16 ints, " + paramArrayOfint.length + " passed");
/*     */     }
/*     */     
/* 152 */     System.arraycopy(paramArrayOfint, 0, this.k, 0, this.k.length);
/*     */   }
/*     */   
/*     */   public void setVertexColors(Color paramColor1, Color paramColor2, Color paramColor3, Color paramColor4) {
/* 156 */     this.k[0] = (int)(paramColor1.r * 255.0F);
/* 157 */     this.k[1] = (int)(paramColor1.g * 255.0F);
/* 158 */     this.k[2] = (int)(paramColor1.b * 255.0F);
/* 159 */     this.k[3] = (int)(paramColor1.a * 255.0F);
/*     */     
/* 161 */     this.k[4] = (int)(paramColor2.r * 255.0F);
/* 162 */     this.k[5] = (int)(paramColor2.g * 255.0F);
/* 163 */     this.k[6] = (int)(paramColor2.b * 255.0F);
/* 164 */     this.k[7] = (int)(paramColor2.a * 255.0F);
/*     */     
/* 166 */     this.k[8] = (int)(paramColor3.r * 255.0F);
/* 167 */     this.k[9] = (int)(paramColor3.g * 255.0F);
/* 168 */     this.k[10] = (int)(paramColor3.b * 255.0F);
/* 169 */     this.k[11] = (int)(paramColor3.a * 255.0F);
/*     */     
/* 171 */     this.k[12] = (int)(paramColor4.r * 255.0F);
/* 172 */     this.k[13] = (int)(paramColor4.g * 255.0F);
/* 173 */     this.k[14] = (int)(paramColor4.b * 255.0F);
/* 174 */     this.k[15] = (int)(paramColor4.a * 255.0F);
/*     */   }
/*     */   
/*     */   public void setVertexColorsSingle(Color paramColor) {
/* 178 */     setVertexColors(paramColor, paramColor, paramColor, paramColor);
/*     */   }
/*     */ 
/*     */   
/*     */   public void draw(Batch paramBatch, float paramFloat) {
/* 183 */     validate();
/*     */     
/* 185 */     TextureRegion textureRegion = getTextureRegion();
/*     */     
/* 187 */     float f1 = getX();
/* 188 */     float f2 = getY();
/* 189 */     float f3 = getWidth();
/* 190 */     float f4 = getHeight();
/*     */     
/* 192 */     Color color = getColor();
/* 193 */     for (byte b = 0; b < 4; b++) {
/* 194 */       this.l[b * 5] = f1 + f3 * this.j[b << 1];
/* 195 */       this.l[b * 5 + 1] = f2 + f4 * this.j[(b << 1) + 1];
/* 196 */       this.l[b * 5 + 2] = Color.toFloatBits((int)(this.k[b << 2] * color.r), (int)(this.k[(b << 2) + 1] * color.g), (int)(this.k[(b << 2) + 2] * color.b), (int)(this.k[(b << 2) + 3] * paramFloat * color.a));
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 205 */     paramBatch.draw(textureRegion.getTexture(), this.l, 0, 20);
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi\\ui\actors\QuadActor.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */