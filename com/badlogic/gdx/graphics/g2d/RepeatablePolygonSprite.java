/*     */ package com.badlogic.gdx.graphics.g2d;
/*     */ 
/*     */ import com.badlogic.gdx.graphics.Color;
/*     */ import com.badlogic.gdx.math.EarClippingTriangulator;
/*     */ import com.badlogic.gdx.math.Intersector;
/*     */ import com.badlogic.gdx.math.Polygon;
/*     */ import com.badlogic.gdx.math.Rectangle;
/*     */ import com.badlogic.gdx.math.Vector2;
/*     */ import com.badlogic.gdx.utils.Array;
/*     */ import com.badlogic.gdx.utils.ShortArray;
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
/*     */ public class RepeatablePolygonSprite
/*     */ {
/*     */   private TextureRegion region;
/*     */   private float density;
/*     */   private boolean dirty = true;
/*  35 */   private Array<float[]> parts = new Array();
/*     */   
/*  37 */   private Array<float[]> vertices = new Array();
/*  38 */   private Array<short[]> indices = new Array();
/*     */   private int cols;
/*     */   private int rows;
/*     */   private float gridWidth;
/*     */   private float gridHeight;
/*  43 */   public float x = 0.0F;
/*  44 */   public float y = 0.0F;
/*  45 */   private Color color = Color.WHITE;
/*  46 */   private Vector2 offset = new Vector2();
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setPolygon(TextureRegion paramTextureRegion, float[] paramArrayOffloat) {
/*  52 */     setPolygon(paramTextureRegion, paramArrayOffloat, -1.0F);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setPolygon(TextureRegion paramTextureRegion, float[] paramArrayOffloat, float paramFloat) {
/*  61 */     this.region = paramTextureRegion;
/*     */     
/*  63 */     paramArrayOffloat = offset(paramArrayOffloat);
/*     */     
/*  65 */     Polygon polygon1 = new Polygon(paramArrayOffloat);
/*  66 */     Polygon polygon2 = new Polygon();
/*  67 */     Polygon polygon3 = new Polygon();
/*  68 */     EarClippingTriangulator earClippingTriangulator = new EarClippingTriangulator();
/*     */ 
/*     */ 
/*     */     
/*  72 */     Rectangle rectangle = polygon1.getBoundingRectangle();
/*     */     
/*  74 */     if (paramFloat == -1.0F) paramFloat = rectangle.getWidth() / paramTextureRegion.getRegionWidth();
/*     */     
/*  76 */     float f = paramTextureRegion.getRegionHeight() / paramTextureRegion.getRegionWidth();
/*  77 */     this.cols = (int)Math.ceil(paramFloat);
/*  78 */     this.gridWidth = rectangle.getWidth() / paramFloat;
/*  79 */     this.gridHeight = f * this.gridWidth;
/*  80 */     this.rows = (int)Math.ceil((rectangle.getHeight() / this.gridHeight));
/*     */     
/*  82 */     for (byte b = 0; b < this.cols; b++) {
/*  83 */       for (byte b1 = 0; b1 < this.rows; b1++) {
/*     */         float[] arrayOfFloat;
/*     */         
/*  86 */         (arrayOfFloat = new float[8])[0] = b * this.gridWidth;
/*  87 */         arrayOfFloat[1] = b1 * this.gridHeight;
/*  88 */         arrayOfFloat[2] = b * this.gridWidth;
/*  89 */         arrayOfFloat[3] = (b1 + 1) * this.gridHeight;
/*  90 */         arrayOfFloat[4] = (b + 1) * this.gridWidth;
/*  91 */         arrayOfFloat[5] = (b1 + 1) * this.gridHeight;
/*  92 */         arrayOfFloat[6] = (b + 1) * this.gridWidth;
/*  93 */         arrayOfFloat[7] = b1 * this.gridHeight;
/*  94 */         polygon2.setVertices(arrayOfFloat);
/*     */         
/*  96 */         Intersector.intersectPolygons(polygon1, polygon2, polygon3);
/*     */         
/*  98 */         if ((arrayOfFloat = polygon3.getVertices()).length > 0) {
/*  99 */           this.parts.add(snapToGrid(arrayOfFloat));
/* 100 */           ShortArray shortArray = earClippingTriangulator.computeTriangles(arrayOfFloat);
/* 101 */           this.indices.add(shortArray.toArray());
/*     */         }
/*     */         else {
/*     */           
/* 105 */           this.parts.add(null);
/*     */         } 
/*     */       } 
/*     */     } 
/*     */     
/* 110 */     buildVertices();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private float[] snapToGrid(float[] paramArrayOffloat) {
/* 117 */     for (byte b = 0; b < paramArrayOffloat.length; b += 2) {
/* 118 */       float f1 = paramArrayOffloat[b] / this.gridWidth % 1.0F;
/* 119 */       float f2 = paramArrayOffloat[b + 1] / this.gridHeight % 1.0F;
/* 120 */       if (f1 > 0.99F || f1 < 0.01F) {
/* 121 */         paramArrayOffloat[b] = this.gridWidth * Math.round(paramArrayOffloat[b] / this.gridWidth);
/*     */       }
/* 123 */       if (f2 > 0.99F || f2 < 0.01F) {
/* 124 */         paramArrayOffloat[b + 1] = this.gridHeight * Math.round(paramArrayOffloat[b + 1] / this.gridHeight);
/*     */       }
/*     */     } 
/*     */     
/* 128 */     return paramArrayOffloat;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private float[] offset(float[] paramArrayOffloat) {
/* 135 */     this.offset.set(paramArrayOffloat[0], paramArrayOffloat[1]); byte b;
/* 136 */     for (b = 0; b < paramArrayOffloat.length - 1; b += 2) {
/* 137 */       if (this.offset.x > paramArrayOffloat[b]) {
/* 138 */         this.offset.x = paramArrayOffloat[b];
/*     */       }
/* 140 */       if (this.offset.y > paramArrayOffloat[b + 1]) {
/* 141 */         this.offset.y = paramArrayOffloat[b + 1];
/*     */       }
/*     */     } 
/* 144 */     for (b = 0; b < paramArrayOffloat.length; b += 2) {
/* 145 */       paramArrayOffloat[b] = paramArrayOffloat[b] - this.offset.x;
/* 146 */       paramArrayOffloat[b + 1] = paramArrayOffloat[b + 1] - this.offset.y;
/*     */     } 
/*     */     
/* 149 */     return paramArrayOffloat;
/*     */   }
/*     */ 
/*     */   
/*     */   private void buildVertices() {
/* 154 */     this.vertices.clear();
/* 155 */     for (byte b = 0; b < this.parts.size; b++) {
/*     */       float[] arrayOfFloat;
/* 157 */       if ((arrayOfFloat = (float[])this.parts.get(b)) != null) {
/*     */         
/* 159 */         float[] arrayOfFloat1 = new float[5 * arrayOfFloat.length / 2];
/* 160 */         byte b1 = 0;
/*     */         
/* 162 */         int i = b / this.rows;
/* 163 */         int j = b % this.rows;
/*     */         
/* 165 */         for (byte b2 = 0; b2 < arrayOfFloat.length; b2 += 2) {
/* 166 */           arrayOfFloat1[b1++] = arrayOfFloat[b2] + this.offset.x + this.x;
/* 167 */           arrayOfFloat1[b1++] = arrayOfFloat[b2 + 1] + this.offset.y + this.y;
/*     */           
/* 169 */           arrayOfFloat1[b1++] = this.color.toFloatBits();
/*     */           
/* 171 */           float f1 = arrayOfFloat[b2] % this.gridWidth / this.gridWidth;
/* 172 */           float f2 = arrayOfFloat[b2 + 1] % this.gridHeight / this.gridHeight;
/* 173 */           if (arrayOfFloat[b2] == i * this.gridWidth) f1 = 0.0F; 
/* 174 */           if (arrayOfFloat[b2] == (i + 1) * this.gridWidth) f1 = 1.0F; 
/* 175 */           if (arrayOfFloat[b2 + 1] == j * this.gridHeight) f2 = 0.0F; 
/* 176 */           if (arrayOfFloat[b2 + 1] == (j + 1) * this.gridHeight) f2 = 1.0F; 
/* 177 */           f1 = this.region.getU() + (this.region.getU2() - this.region.getU()) * f1;
/* 178 */           f2 = this.region.getV() + (this.region.getV2() - this.region.getV()) * f2;
/* 179 */           arrayOfFloat1[b1++] = f1;
/* 180 */           arrayOfFloat1[b1++] = f2;
/*     */         } 
/* 182 */         this.vertices.add(arrayOfFloat1);
/*     */       } 
/* 184 */     }  this.dirty = false;
/*     */   }
/*     */   
/*     */   public void draw(PolygonSpriteBatch paramPolygonSpriteBatch) {
/* 188 */     if (this.dirty) {
/* 189 */       buildVertices();
/*     */     }
/* 191 */     for (byte b = 0; b < this.vertices.size; b++) {
/* 192 */       paramPolygonSpriteBatch.draw(this.region.getTexture(), (float[])this.vertices.get(b), 0, ((float[])this.vertices.get(b)).length, (short[])this.indices.get(b), 0, ((short[])this.indices.get(b)).length);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public void setColor(Color paramColor) {
/* 198 */     this.color = paramColor;
/* 199 */     this.dirty = true;
/*     */   }
/*     */   
/*     */   public void setPosition(float paramFloat1, float paramFloat2) {
/* 203 */     this.x = paramFloat1;
/* 204 */     this.y = paramFloat2;
/* 205 */     this.dirty = true;
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gdx\graphics\g2d\RepeatablePolygonSprite.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */