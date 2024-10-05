/*    */ package com.badlogic.gdx.scenes.scene2d.actions;
/*    */ 
/*    */ import com.badlogic.gdx.math.Interpolation;
/*    */ import com.badlogic.gdx.utils.Null;
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
/*    */ public class FloatAction
/*    */   extends TemporalAction
/*    */ {
/*    */   private float start;
/*    */   private float end;
/*    */   private float value;
/*    */   
/*    */   public FloatAction() {
/* 30 */     this.start = 0.0F;
/* 31 */     this.end = 1.0F;
/*    */   }
/*    */ 
/*    */   
/*    */   public FloatAction(float paramFloat1, float paramFloat2) {
/* 36 */     this.start = paramFloat1;
/* 37 */     this.end = paramFloat2;
/*    */   }
/*    */ 
/*    */   
/*    */   public FloatAction(float paramFloat1, float paramFloat2, float paramFloat3) {
/* 42 */     super(paramFloat3);
/* 43 */     this.start = paramFloat1;
/* 44 */     this.end = paramFloat2;
/*    */   }
/*    */ 
/*    */   
/*    */   public FloatAction(float paramFloat1, float paramFloat2, float paramFloat3, @Null Interpolation paramInterpolation) {
/* 49 */     super(paramFloat3, paramInterpolation);
/* 50 */     this.start = paramFloat1;
/* 51 */     this.end = paramFloat2;
/*    */   }
/*    */   
/*    */   protected void begin() {
/* 55 */     this.value = this.start;
/*    */   }
/*    */   
/*    */   protected void update(float paramFloat) {
/* 59 */     if (paramFloat == 0.0F) {
/* 60 */       this.value = this.start; return;
/* 61 */     }  if (paramFloat == 1.0F) {
/* 62 */       this.value = this.end; return;
/*    */     } 
/* 64 */     this.value = this.start + (this.end - this.start) * paramFloat;
/*    */   }
/*    */ 
/*    */   
/*    */   public float getValue() {
/* 69 */     return this.value;
/*    */   }
/*    */ 
/*    */   
/*    */   public void setValue(float paramFloat) {
/* 74 */     this.value = paramFloat;
/*    */   }
/*    */   
/*    */   public float getStart() {
/* 78 */     return this.start;
/*    */   }
/*    */ 
/*    */   
/*    */   public void setStart(float paramFloat) {
/* 83 */     this.start = paramFloat;
/*    */   }
/*    */   
/*    */   public float getEnd() {
/* 87 */     return this.end;
/*    */   }
/*    */ 
/*    */   
/*    */   public void setEnd(float paramFloat) {
/* 92 */     this.end = paramFloat;
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gdx\scenes\scene2d\actions\FloatAction.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */