/*    */ package com.badlogic.gdx.graphics.g3d.particles.emitters;
/*    */ 
/*    */ import com.badlogic.gdx.graphics.g3d.particles.ParticleControllerComponent;
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
/*    */ public abstract class Emitter
/*    */   extends ParticleControllerComponent
/*    */   implements Json.Serializable
/*    */ {
/*    */   public int minParticleCount;
/* 30 */   public int maxParticleCount = 4;
/*    */   
/*    */   public float percent;
/*    */ 
/*    */   
/*    */   public Emitter(Emitter paramEmitter) {
/* 36 */     set(paramEmitter);
/*    */   }
/*    */ 
/*    */   
/*    */   public Emitter() {}
/*    */ 
/*    */   
/*    */   public void init() {
/* 44 */     this.controller.particles.size = 0;
/*    */   }
/*    */ 
/*    */   
/*    */   public void end() {
/* 49 */     this.controller.particles.size = 0;
/*    */   }
/*    */   
/*    */   public boolean isComplete() {
/* 53 */     return (this.percent >= 1.0F);
/*    */   }
/*    */   
/*    */   public int getMinParticleCount() {
/* 57 */     return this.minParticleCount;
/*    */   }
/*    */   
/*    */   public void setMinParticleCount(int paramInt) {
/* 61 */     this.minParticleCount = paramInt;
/*    */   }
/*    */   
/*    */   public int getMaxParticleCount() {
/* 65 */     return this.maxParticleCount;
/*    */   }
/*    */   
/*    */   public void setMaxParticleCount(int paramInt) {
/* 69 */     this.maxParticleCount = paramInt;
/*    */   }
/*    */   
/*    */   public void setParticleCount(int paramInt1, int paramInt2) {
/* 73 */     setMinParticleCount(paramInt1);
/* 74 */     setMaxParticleCount(paramInt2);
/*    */   }
/*    */   
/*    */   public void set(Emitter paramEmitter) {
/* 78 */     this.minParticleCount = paramEmitter.minParticleCount;
/* 79 */     this.maxParticleCount = paramEmitter.maxParticleCount;
/*    */   }
/*    */ 
/*    */   
/*    */   public void write(Json paramJson) {
/* 84 */     paramJson.writeValue("minParticleCount", Integer.valueOf(this.minParticleCount));
/* 85 */     paramJson.writeValue("maxParticleCount", Integer.valueOf(this.maxParticleCount));
/*    */   }
/*    */ 
/*    */   
/*    */   public void read(Json paramJson, JsonValue paramJsonValue) {
/* 90 */     this.minParticleCount = ((Integer)paramJson.readValue("minParticleCount", int.class, paramJsonValue)).intValue();
/* 91 */     this.maxParticleCount = ((Integer)paramJson.readValue("maxParticleCount", int.class, paramJsonValue)).intValue();
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gdx\graphics\g3d\particles\emitters\Emitter.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */