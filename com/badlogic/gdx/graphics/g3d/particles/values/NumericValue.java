/*    */ package com.badlogic.gdx.graphics.g3d.particles.values;
/*    */ 
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
/*    */ 
/*    */ public class NumericValue
/*    */   extends ParticleValue
/*    */ {
/*    */   private float value;
/*    */   
/*    */   public float getValue() {
/* 28 */     return this.value;
/*    */   }
/*    */   
/*    */   public void setValue(float paramFloat) {
/* 32 */     this.value = paramFloat;
/*    */   }
/*    */   
/*    */   public void load(NumericValue paramNumericValue) {
/* 36 */     load(paramNumericValue);
/* 37 */     this.value = paramNumericValue.value;
/*    */   }
/*    */ 
/*    */   
/*    */   public void write(Json paramJson) {
/* 42 */     super.write(paramJson);
/* 43 */     paramJson.writeValue("value", Float.valueOf(this.value));
/*    */   }
/*    */ 
/*    */   
/*    */   public void read(Json paramJson, JsonValue paramJsonValue) {
/* 48 */     super.read(paramJson, paramJsonValue);
/* 49 */     this.value = ((Float)paramJson.readValue("value", float.class, paramJsonValue)).floatValue();
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gdx\graphics\g3d\particles\values\NumericValue.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */