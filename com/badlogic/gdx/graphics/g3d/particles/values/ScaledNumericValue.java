/*     */ package com.badlogic.gdx.graphics.g3d.particles.values;
/*     */ 
/*     */ import com.badlogic.gdx.math.MathUtils;
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
/*     */ public class ScaledNumericValue
/*     */   extends RangedNumericValue
/*     */ {
/*  26 */   private float[] scaling = new float[] { 1.0F };
/*  27 */   public float[] timeline = new float[] { 0.0F };
/*     */   
/*     */   private float highMin;
/*     */   
/*     */   public float newHighValue() {
/*  32 */     return this.highMin + (this.highMax - this.highMin) * MathUtils.random();
/*     */   }
/*     */   private float highMax; private boolean relative = false;
/*     */   public void setHigh(float paramFloat) {
/*  36 */     this.highMin = paramFloat;
/*  37 */     this.highMax = paramFloat;
/*     */   }
/*     */   
/*     */   public void setHigh(float paramFloat1, float paramFloat2) {
/*  41 */     this.highMin = paramFloat1;
/*  42 */     this.highMax = paramFloat2;
/*     */   }
/*     */   
/*     */   public float getHighMin() {
/*  46 */     return this.highMin;
/*     */   }
/*     */   
/*     */   public void setHighMin(float paramFloat) {
/*  50 */     this.highMin = paramFloat;
/*     */   }
/*     */   
/*     */   public float getHighMax() {
/*  54 */     return this.highMax;
/*     */   }
/*     */   
/*     */   public void setHighMax(float paramFloat) {
/*  58 */     this.highMax = paramFloat;
/*     */   }
/*     */   
/*     */   public float[] getScaling() {
/*  62 */     return this.scaling;
/*     */   }
/*     */   
/*     */   public void setScaling(float[] paramArrayOffloat) {
/*  66 */     this.scaling = paramArrayOffloat;
/*     */   }
/*     */   
/*     */   public float[] getTimeline() {
/*  70 */     return this.timeline;
/*     */   }
/*     */   
/*     */   public void setTimeline(float[] paramArrayOffloat) {
/*  74 */     this.timeline = paramArrayOffloat;
/*     */   }
/*     */   
/*     */   public boolean isRelative() {
/*  78 */     return this.relative;
/*     */   }
/*     */   
/*     */   public void setRelative(boolean paramBoolean) {
/*  82 */     this.relative = paramBoolean;
/*     */   }
/*     */   
/*     */   public float getScale(float paramFloat) {
/*  86 */     int i = -1;
/*  87 */     int j = this.timeline.length;
/*     */     
/*     */     int k;
/*  90 */     for (k = 1; k < j; k++) {
/*     */       float f;
/*  92 */       if ((f = this.timeline[k]) > paramFloat) {
/*  93 */         i = k;
/*     */         break;
/*     */       } 
/*     */     } 
/*  97 */     if (i == -1) return this.scaling[j - 1]; 
/*  98 */     k = i - 1;
/*  99 */     float f2 = this.scaling[k];
/* 100 */     float f1 = this.timeline[k];
/* 101 */     return f2 + (this.scaling[i] - f2) * (paramFloat - f1) / (this.timeline[i] - f1);
/*     */   }
/*     */   
/*     */   public void load(ScaledNumericValue paramScaledNumericValue) {
/* 105 */     load(paramScaledNumericValue);
/* 106 */     this.highMax = paramScaledNumericValue.highMax;
/* 107 */     this.highMin = paramScaledNumericValue.highMin;
/* 108 */     this.scaling = new float[paramScaledNumericValue.scaling.length];
/* 109 */     System.arraycopy(paramScaledNumericValue.scaling, 0, this.scaling, 0, this.scaling.length);
/* 110 */     this.timeline = new float[paramScaledNumericValue.timeline.length];
/* 111 */     System.arraycopy(paramScaledNumericValue.timeline, 0, this.timeline, 0, this.timeline.length);
/* 112 */     this.relative = paramScaledNumericValue.relative;
/*     */   }
/*     */ 
/*     */   
/*     */   public void write(Json paramJson) {
/* 117 */     super.write(paramJson);
/* 118 */     paramJson.writeValue("highMin", Float.valueOf(this.highMin));
/* 119 */     paramJson.writeValue("highMax", Float.valueOf(this.highMax));
/* 120 */     paramJson.writeValue("relative", Boolean.valueOf(this.relative));
/* 121 */     paramJson.writeValue("scaling", this.scaling);
/* 122 */     paramJson.writeValue("timeline", this.timeline);
/*     */   }
/*     */ 
/*     */   
/*     */   public void read(Json paramJson, JsonValue paramJsonValue) {
/* 127 */     super.read(paramJson, paramJsonValue);
/* 128 */     this.highMin = ((Float)paramJson.readValue("highMin", float.class, paramJsonValue)).floatValue();
/* 129 */     this.highMax = ((Float)paramJson.readValue("highMax", float.class, paramJsonValue)).floatValue();
/* 130 */     this.relative = ((Boolean)paramJson.readValue("relative", boolean.class, paramJsonValue)).booleanValue();
/* 131 */     this.scaling = (float[])paramJson.readValue("scaling", float[].class, paramJsonValue);
/* 132 */     this.timeline = (float[])paramJson.readValue("timeline", float[].class, paramJsonValue);
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gdx\graphics\g3d\particles\values\ScaledNumericValue.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */