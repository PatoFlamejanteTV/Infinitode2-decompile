/*    */ package com.prineside.tdi2.scene2d.actions;
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
/*    */   private float c;
/*    */   private float d;
/*    */   private boolean e = false;
/*    */   
/*    */   public RotateToAction() {}
/*    */   
/*    */   public RotateToAction(boolean paramBoolean) {
/* 42 */     this.e = paramBoolean;
/*    */   }
/*    */   
/*    */   protected final void a() {
/* 46 */     this.c = this.b.getRotation();
/*    */   }
/*    */ 
/*    */   
/*    */   protected final void a(float paramFloat) {
/* 51 */     if (paramFloat == 0.0F) {
/* 52 */       paramFloat = this.c;
/* 53 */     } else if (paramFloat == 1.0F) {
/* 54 */       paramFloat = this.d;
/* 55 */     } else if (this.e) {
/* 56 */       paramFloat = MathUtils.lerpAngleDeg(this.c, this.d, paramFloat);
/*    */     } else {
/* 58 */       paramFloat = this.c + (this.d - this.c) * paramFloat;
/* 59 */     }  this.b.setRotation(paramFloat);
/*    */   }
/*    */   
/*    */   public float getRotation() {
/* 63 */     return this.d;
/*    */   }
/*    */   
/*    */   public void setRotation(float paramFloat) {
/* 67 */     this.d = paramFloat;
/*    */   }
/*    */   
/*    */   public boolean isUseShortestDirection() {
/* 71 */     return this.e;
/*    */   }
/*    */   
/*    */   public void setUseShortestDirection(boolean paramBoolean) {
/* 75 */     this.e = paramBoolean;
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\scene2d\actions\RotateToAction.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */