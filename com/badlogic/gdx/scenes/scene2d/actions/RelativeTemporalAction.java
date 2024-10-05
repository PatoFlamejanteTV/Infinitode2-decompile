/*    */ package com.badlogic.gdx.scenes.scene2d.actions;
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
/*    */ public abstract class RelativeTemporalAction
/*    */   extends TemporalAction
/*    */ {
/*    */   private float lastPercent;
/*    */   
/*    */   protected void begin() {
/* 25 */     this.lastPercent = 0.0F;
/*    */   }
/*    */   
/*    */   protected void update(float paramFloat) {
/* 29 */     updateRelative(paramFloat - this.lastPercent);
/* 30 */     this.lastPercent = paramFloat;
/*    */   }
/*    */   
/*    */   protected abstract void updateRelative(float paramFloat);
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gdx\scenes\scene2d\actions\RelativeTemporalAction.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */