/*    */ package com.badlogic.gdx.scenes.scene2d.actions;
/*    */ 
/*    */ import com.badlogic.gdx.math.MathUtils;
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
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class RotateToAction
/*    */   extends TemporalAction
/*    */ {
/*    */   private float start;
/*    */   private float end;
/*    */   private boolean useShortestDirection = false;
/*    */   
/*    */   public RotateToAction() {}
/*    */   
/*    */   public RotateToAction(boolean paramBoolean) {
/* 42 */     this.useShortestDirection = paramBoolean;
/*    */   }
/*    */   
/*    */   protected void begin() {
/* 46 */     this.start = this.target.getRotation();
/*    */   }
/*    */ 
/*    */   
/*    */   protected void update(float paramFloat) {
/* 51 */     if (paramFloat == 0.0F) {
/* 52 */       paramFloat = this.start;
/* 53 */     } else if (paramFloat == 1.0F) {
/* 54 */       paramFloat = this.end;
/* 55 */     } else if (this.useShortestDirection) {
/* 56 */       paramFloat = MathUtils.lerpAngleDeg(this.start, this.end, paramFloat);
/*    */     } else {
/* 58 */       paramFloat = this.start + (this.end - this.start) * paramFloat;
/* 59 */     }  this.target.setRotation(paramFloat);
/*    */   }
/*    */   
/*    */   public float getRotation() {
/* 63 */     return this.end;
/*    */   }
/*    */   
/*    */   public void setRotation(float paramFloat) {
/* 67 */     this.end = paramFloat;
/*    */   }
/*    */   
/*    */   public boolean isUseShortestDirection() {
/* 71 */     return this.useShortestDirection;
/*    */   }
/*    */   
/*    */   public void setUseShortestDirection(boolean paramBoolean) {
/* 75 */     this.useShortestDirection = paramBoolean;
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gdx\scenes\scene2d\actions\RotateToAction.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */