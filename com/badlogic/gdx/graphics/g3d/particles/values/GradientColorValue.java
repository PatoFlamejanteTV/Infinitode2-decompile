/*     */ package com.badlogic.gdx.graphics.g3d.particles.values;
/*     */ 
/*     */ import com.badlogic.gdx.utils.Json;
/*     */ import com.badlogic.gdx.utils.JsonValue;
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
/*     */ public class GradientColorValue
/*     */   extends ParticleValue
/*     */ {
/*  25 */   private static float[] temp = new float[3];
/*     */   
/*  27 */   private float[] colors = new float[] { 1.0F, 1.0F, 1.0F };
/*  28 */   public float[] timeline = new float[] { 0.0F };
/*     */   
/*     */   public float[] getTimeline() {
/*  31 */     return this.timeline;
/*     */   }
/*     */   
/*     */   public void setTimeline(float[] paramArrayOffloat) {
/*  35 */     this.timeline = paramArrayOffloat;
/*     */   }
/*     */   
/*     */   public float[] getColors() {
/*  39 */     return this.colors;
/*     */   }
/*     */   
/*     */   public void setColors(float[] paramArrayOffloat) {
/*  43 */     this.colors = paramArrayOffloat;
/*     */   }
/*     */   
/*     */   public float[] getColor(float paramFloat) {
/*  47 */     getColor(paramFloat, temp, 0);
/*  48 */     return temp;
/*     */   }
/*     */   
/*     */   public void getColor(float paramFloat, float[] paramArrayOffloat, int paramInt) {
/*  52 */     int i = 0, j = -1;
/*     */     float[] arrayOfFloat;
/*  54 */     int k = (arrayOfFloat = this.timeline).length;
/*  55 */     for (byte b = 1; b < k; b++) {
/*     */       float f;
/*  57 */       if ((f = arrayOfFloat[b]) > paramFloat) {
/*  58 */         j = b;
/*     */         break;
/*     */       } 
/*  61 */       i = b;
/*     */     } 
/*  63 */     float f3 = arrayOfFloat[i];
/*  64 */     i *= 3;
/*  65 */     float f4 = this.colors[i];
/*  66 */     float f2 = this.colors[i + 1];
/*  67 */     float f1 = this.colors[i + 2];
/*  68 */     if (j == -1) {
/*  69 */       paramArrayOffloat[paramInt] = f4;
/*  70 */       paramArrayOffloat[paramInt + 1] = f2;
/*  71 */       paramArrayOffloat[paramInt + 2] = f1;
/*     */       return;
/*     */     } 
/*  74 */     paramFloat = (paramFloat - f3) / (arrayOfFloat[j] - f3);
/*  75 */     j *= 3;
/*  76 */     paramArrayOffloat[paramInt] = f4 + (this.colors[j] - f4) * paramFloat;
/*  77 */     paramArrayOffloat[paramInt + 1] = f2 + (this.colors[j + 1] - f2) * paramFloat;
/*  78 */     paramArrayOffloat[paramInt + 2] = f1 + (this.colors[j + 2] - f1) * paramFloat;
/*     */   }
/*     */ 
/*     */   
/*     */   public void write(Json paramJson) {
/*  83 */     super.write(paramJson);
/*  84 */     paramJson.writeValue("colors", this.colors);
/*  85 */     paramJson.writeValue("timeline", this.timeline);
/*     */   }
/*     */ 
/*     */   
/*     */   public void read(Json paramJson, JsonValue paramJsonValue) {
/*  90 */     super.read(paramJson, paramJsonValue);
/*  91 */     this.colors = (float[])paramJson.readValue("colors", float[].class, paramJsonValue);
/*  92 */     this.timeline = (float[])paramJson.readValue("timeline", float[].class, paramJsonValue);
/*     */   }
/*     */   
/*     */   public void load(GradientColorValue paramGradientColorValue) {
/*  96 */     load(paramGradientColorValue);
/*  97 */     this.colors = new float[paramGradientColorValue.colors.length];
/*  98 */     System.arraycopy(paramGradientColorValue.colors, 0, this.colors, 0, this.colors.length);
/*  99 */     this.timeline = new float[paramGradientColorValue.timeline.length];
/* 100 */     System.arraycopy(paramGradientColorValue.timeline, 0, this.timeline, 0, this.timeline.length);
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gdx\graphics\g3d\particles\values\GradientColorValue.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */