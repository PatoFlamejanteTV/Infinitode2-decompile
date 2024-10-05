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
/*    */ 
/*    */ 
/*    */ public class ParticleValue
/*    */   implements Json.Serializable
/*    */ {
/*    */   public boolean active;
/*    */   
/*    */   public ParticleValue() {}
/*    */   
/*    */   public ParticleValue(ParticleValue paramParticleValue) {
/* 32 */     this.active = paramParticleValue.active;
/*    */   }
/*    */   
/*    */   public boolean isActive() {
/* 36 */     return this.active;
/*    */   }
/*    */   
/*    */   public void setActive(boolean paramBoolean) {
/* 40 */     this.active = paramBoolean;
/*    */   }
/*    */   
/*    */   public void load(ParticleValue paramParticleValue) {
/* 44 */     this.active = paramParticleValue.active;
/*    */   }
/*    */ 
/*    */   
/*    */   public void write(Json paramJson) {
/* 49 */     paramJson.writeValue("active", Boolean.valueOf(this.active));
/*    */   }
/*    */ 
/*    */   
/*    */   public void read(Json paramJson, JsonValue paramJsonValue) {
/* 54 */     this.active = ((Boolean)paramJson.readValue("active", Boolean.class, paramJsonValue)).booleanValue();
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gdx\graphics\g3d\particles\values\ParticleValue.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */