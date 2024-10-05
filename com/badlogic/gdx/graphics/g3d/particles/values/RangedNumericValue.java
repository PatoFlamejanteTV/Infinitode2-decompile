/*    */ package com.badlogic.gdx.graphics.g3d.particles.values;
/*    */ 
/*    */ import com.badlogic.gdx.math.MathUtils;
/*    */ import com.badlogic.gdx.utils.Json;
/*    */ import com.badlogic.gdx.utils.JsonValue;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class RangedNumericValue
/*    */   extends ParticleValue
/*    */ {
/*    */   private float lowMin;
/*    */   private float lowMax;
/*    */   
/*    */   public float newLowValue() {
/* 29 */     return this.lowMin + (this.lowMax - this.lowMin) * MathUtils.random();
/*    */   }
/*    */   
/*    */   public void setLow(float paramFloat) {
/* 33 */     this.lowMin = paramFloat;
/* 34 */     this.lowMax = paramFloat;
/*    */   }
/*    */   
/*    */   public void setLow(float paramFloat1, float paramFloat2) {
/* 38 */     this.lowMin = paramFloat1;
/* 39 */     this.lowMax = paramFloat2;
/*    */   }
/*    */   
/*    */   public float getLowMin() {
/* 43 */     return this.lowMin;
/*    */   }
/*    */   
/*    */   public void setLowMin(float paramFloat) {
/* 47 */     this.lowMin = paramFloat;
/*    */   }
/*    */   
/*    */   public float getLowMax() {
/* 51 */     return this.lowMax;
/*    */   }
/*    */   
/*    */   public void setLowMax(float paramFloat) {
/* 55 */     this.lowMax = paramFloat;
/*    */   }
/*    */   
/*    */   public void load(RangedNumericValue paramRangedNumericValue) {
/* 59 */     load(paramRangedNumericValue);
/* 60 */     this.lowMax = paramRangedNumericValue.lowMax;
/* 61 */     this.lowMin = paramRangedNumericValue.lowMin;
/*    */   }
/*    */ 
/*    */   
/*    */   public void write(Json paramJson) {
/* 66 */     super.write(paramJson);
/* 67 */     paramJson.writeValue("lowMin", Float.valueOf(this.lowMin));
/* 68 */     paramJson.writeValue("lowMax", Float.valueOf(this.lowMax));
/*    */   }
/*    */ 
/*    */   
/*    */   public void read(Json paramJson, JsonValue paramJsonValue) {
/* 73 */     super.read(paramJson, paramJsonValue);
/* 74 */     this.lowMin = ((Float)paramJson.readValue("lowMin", float.class, paramJsonValue)).floatValue();
/* 75 */     this.lowMax = ((Float)paramJson.readValue("lowMax", float.class, paramJsonValue)).floatValue();
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gdx\graphics\g3d\particles\values\RangedNumericValue.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */