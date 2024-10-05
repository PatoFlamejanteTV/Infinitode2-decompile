/*    */ package com.prineside.tdi2.scene2d.actions;
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
/*    */   private float c;
/*    */   private float d;
/*    */   private float e;
/*    */   
/*    */   public FloatAction() {
/* 30 */     this.c = 0.0F;
/* 31 */     this.d = 1.0F;
/*    */   }
/*    */ 
/*    */   
/*    */   public FloatAction(float paramFloat1, float paramFloat2) {
/* 36 */     this.c = paramFloat1;
/* 37 */     this.d = paramFloat2;
/*    */   }
/*    */ 
/*    */   
/*    */   public FloatAction(float paramFloat1, float paramFloat2, float paramFloat3) {
/* 42 */     super(paramFloat3);
/* 43 */     this.c = paramFloat1;
/* 44 */     this.d = paramFloat2;
/*    */   }
/*    */ 
/*    */   
/*    */   public FloatAction(float paramFloat1, float paramFloat2, float paramFloat3, @Null Interpolation paramInterpolation) {
/* 49 */     super(paramFloat3, paramInterpolation);
/* 50 */     this.c = paramFloat1;
/* 51 */     this.d = paramFloat2;
/*    */   }
/*    */   
/*    */   protected final void a() {
/* 55 */     this.e = this.c;
/*    */   }
/*    */   
/*    */   protected final void a(float paramFloat) {
/* 59 */     if (paramFloat == 0.0F) {
/* 60 */       this.e = this.c; return;
/* 61 */     }  if (paramFloat == 1.0F) {
/* 62 */       this.e = this.d; return;
/*    */     } 
/* 64 */     this.e = this.c + (this.d - this.c) * paramFloat;
/*    */   }
/*    */ 
/*    */   
/*    */   public float getValue() {
/* 69 */     return this.e;
/*    */   }
/*    */ 
/*    */   
/*    */   public void setValue(float paramFloat) {
/* 74 */     this.e = paramFloat;
/*    */   }
/*    */   
/*    */   public float getStart() {
/* 78 */     return this.c;
/*    */   }
/*    */ 
/*    */   
/*    */   public void setStart(float paramFloat) {
/* 83 */     this.c = paramFloat;
/*    */   }
/*    */   
/*    */   public float getEnd() {
/* 87 */     return this.d;
/*    */   }
/*    */ 
/*    */   
/*    */   public void setEnd(float paramFloat) {
/* 92 */     this.d = paramFloat;
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\scene2d\actions\FloatAction.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */