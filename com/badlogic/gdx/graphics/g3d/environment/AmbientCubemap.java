/*     */ package com.badlogic.gdx.graphics.g3d.environment;
/*     */ 
/*     */ import com.badlogic.gdx.graphics.Color;
/*     */ import com.badlogic.gdx.math.Vector3;
/*     */ import com.badlogic.gdx.utils.GdxRuntimeException;
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
/*     */ public class AmbientCubemap
/*     */ {
/*     */   private static final int NUM_VALUES = 18;
/*     */   public final float[] data;
/*     */   
/*     */   private static final float clamp(float paramFloat) {
/*  27 */     return (paramFloat < 0.0F) ? 0.0F : ((paramFloat > 1.0F) ? 1.0F : paramFloat);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public AmbientCubemap() {
/*  33 */     this.data = new float[18];
/*     */   }
/*     */   
/*     */   public AmbientCubemap(float[] paramArrayOffloat) {
/*  37 */     if (paramArrayOffloat.length != 18) throw new GdxRuntimeException("Incorrect array size"); 
/*  38 */     this.data = new float[paramArrayOffloat.length];
/*  39 */     System.arraycopy(paramArrayOffloat, 0, this.data, 0, this.data.length);
/*     */   }
/*     */   
/*     */   public AmbientCubemap(AmbientCubemap paramAmbientCubemap) {
/*  43 */     this(paramAmbientCubemap.data);
/*     */   }
/*     */   
/*     */   public AmbientCubemap set(float[] paramArrayOffloat) {
/*  47 */     for (byte b = 0; b < this.data.length; b++)
/*  48 */       this.data[b] = paramArrayOffloat[b]; 
/*  49 */     return this;
/*     */   }
/*     */   
/*     */   public AmbientCubemap set(AmbientCubemap paramAmbientCubemap) {
/*  53 */     return set(paramAmbientCubemap.data);
/*     */   }
/*     */   
/*     */   public AmbientCubemap set(Color paramColor) {
/*  57 */     return set(paramColor.r, paramColor.g, paramColor.b);
/*     */   }
/*     */   
/*     */   public AmbientCubemap set(float paramFloat1, float paramFloat2, float paramFloat3) {
/*  61 */     for (byte b = 0; b < 18; ) {
/*  62 */       this.data[b] = paramFloat1;
/*  63 */       this.data[b + 1] = paramFloat2;
/*  64 */       this.data[b + 2] = paramFloat3;
/*  65 */       b += 3;
/*     */     } 
/*  67 */     return this;
/*     */   }
/*     */   
/*     */   public Color getColor(Color paramColor, int paramInt) {
/*  71 */     paramInt *= 3;
/*  72 */     return paramColor.set(this.data[paramInt], this.data[paramInt + 1], this.data[paramInt + 2], 1.0F);
/*     */   }
/*     */   
/*     */   public AmbientCubemap clear() {
/*  76 */     for (byte b = 0; b < this.data.length; b++)
/*  77 */       this.data[b] = 0.0F; 
/*  78 */     return this;
/*     */   }
/*     */   
/*     */   public AmbientCubemap clamp() {
/*  82 */     for (byte b = 0; b < this.data.length; b++)
/*  83 */       this.data[b] = clamp(this.data[b]); 
/*  84 */     return this;
/*     */   }
/*     */   
/*     */   public AmbientCubemap add(float paramFloat1, float paramFloat2, float paramFloat3) {
/*  88 */     for (byte b = 0; b < this.data.length; ) {
/*  89 */       this.data[b++] = this.data[b++] + paramFloat1;
/*  90 */       this.data[b++] = this.data[b++] + paramFloat2;
/*  91 */       this.data[b++] = this.data[b++] + paramFloat3;
/*     */     } 
/*  93 */     return this;
/*     */   }
/*     */   
/*     */   public AmbientCubemap add(Color paramColor) {
/*  97 */     return add(paramColor.r, paramColor.g, paramColor.b);
/*     */   }
/*     */   
/*     */   public AmbientCubemap add(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6) {
/* 101 */     float f1 = paramFloat4 * paramFloat4, f2 = paramFloat5 * paramFloat5, f3 = paramFloat6 * paramFloat6;
/*     */     float f4;
/* 103 */     if ((f4 = f1 + f2 + f3) == 0.0F) return this; 
/* 104 */     f4 = 1.0F / f4 * (f4 + 1.0F);
/* 105 */     paramFloat1 *= f4; paramFloat2 *= f4; paramFloat3 *= f4;
/* 106 */     byte b = (paramFloat4 > 0.0F) ? 0 : 3;
/* 107 */     this.data[b] = this.data[b] + f1 * paramFloat1;
/* 108 */     this.data[b + 1] = this.data[b + 1] + f1 * paramFloat2;
/* 109 */     this.data[b + 2] = this.data[b + 2] + f1 * paramFloat3;
/* 110 */     b = (paramFloat5 > 0.0F) ? 6 : 9;
/* 111 */     this.data[b] = this.data[b] + f2 * paramFloat1;
/* 112 */     this.data[b + 1] = this.data[b + 1] + f2 * paramFloat2;
/* 113 */     this.data[b + 2] = this.data[b + 2] + f2 * paramFloat3;
/* 114 */     b = (paramFloat6 > 0.0F) ? 12 : 15;
/* 115 */     this.data[b] = this.data[b] + f3 * paramFloat1;
/* 116 */     this.data[b + 1] = this.data[b + 1] + f3 * paramFloat2;
/* 117 */     this.data[b + 2] = this.data[b + 2] + f3 * paramFloat3;
/* 118 */     return this;
/*     */   }
/*     */   
/*     */   public AmbientCubemap add(Color paramColor, Vector3 paramVector3) {
/* 122 */     return add(paramColor.r, paramColor.g, paramColor.b, paramVector3.x, paramVector3.y, paramVector3.z);
/*     */   }
/*     */   
/*     */   public AmbientCubemap add(float paramFloat1, float paramFloat2, float paramFloat3, Vector3 paramVector3) {
/* 126 */     return add(paramFloat1, paramFloat2, paramFloat3, paramVector3.x, paramVector3.y, paramVector3.z);
/*     */   }
/*     */   
/*     */   public AmbientCubemap add(Color paramColor, float paramFloat1, float paramFloat2, float paramFloat3) {
/* 130 */     return add(paramColor.r, paramColor.g, paramColor.b, paramFloat1, paramFloat2, paramFloat3);
/*     */   }
/*     */   
/*     */   public AmbientCubemap add(Color paramColor, Vector3 paramVector31, Vector3 paramVector32) {
/* 134 */     return add(paramColor.r, paramColor.g, paramColor.b, paramVector32.x - paramVector31.x, paramVector32.y - paramVector31.y, paramVector32.z - paramVector31.z);
/*     */   }
/*     */   
/*     */   public AmbientCubemap add(Color paramColor, Vector3 paramVector31, Vector3 paramVector32, float paramFloat) {
/* 138 */     paramFloat /= 1.0F + paramVector32.dst(paramVector31);
/* 139 */     return add(paramColor.r * paramFloat, paramColor.g * paramFloat, paramColor.b * paramFloat, paramVector32.x - paramVector31.x, paramVector32.y - paramVector31.y, paramVector32.z - paramVector31.z);
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/* 144 */     String str = "";
/* 145 */     for (byte b = 0; b < this.data.length; b += 3) {
/* 146 */       str = str + Float.toString(this.data[b]) + ", " + Float.toString(this.data[b + 1]) + ", " + Float.toString(this.data[b + 2]) + "\n";
/*     */     }
/* 148 */     return str;
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gdx\graphics\g3d\environment\AmbientCubemap.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */