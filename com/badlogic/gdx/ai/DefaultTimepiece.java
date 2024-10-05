/*    */ package com.badlogic.gdx.ai;
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
/*    */ public class DefaultTimepiece
/*    */   implements Timepiece
/*    */ {
/*    */   private float time;
/*    */   private float deltaTime;
/*    */   private float maxDeltaTime;
/*    */   
/*    */   public DefaultTimepiece() {
/* 27 */     this(Float.POSITIVE_INFINITY);
/*    */   }
/*    */   
/*    */   public DefaultTimepiece(float paramFloat) {
/* 31 */     this.time = 0.0F;
/* 32 */     this.deltaTime = 0.0F;
/* 33 */     this.maxDeltaTime = paramFloat;
/*    */   }
/*    */ 
/*    */   
/*    */   public float getTime() {
/* 38 */     return this.time;
/*    */   }
/*    */ 
/*    */   
/*    */   public float getDeltaTime() {
/* 43 */     return this.deltaTime;
/*    */   }
/*    */ 
/*    */   
/*    */   public void update(float paramFloat) {
/* 48 */     this.deltaTime = (paramFloat > this.maxDeltaTime) ? this.maxDeltaTime : paramFloat;
/* 49 */     this.time += this.deltaTime;
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gdx\ai\DefaultTimepiece.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */