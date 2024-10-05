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
/*    */ public class IntAction
/*    */   extends TemporalAction
/*    */ {
/*    */   private int start;
/*    */   private int end;
/*    */   private int value;
/*    */   
/*    */   public IntAction() {
/* 30 */     this.start = 0;
/* 31 */     this.end = 1;
/*    */   }
/*    */ 
/*    */   
/*    */   public IntAction(int paramInt1, int paramInt2) {
/* 36 */     this.start = paramInt1;
/* 37 */     this.end = paramInt2;
/*    */   }
/*    */ 
/*    */   
/*    */   public IntAction(int paramInt1, int paramInt2, float paramFloat) {
/* 42 */     super(paramFloat);
/* 43 */     this.start = paramInt1;
/* 44 */     this.end = paramInt2;
/*    */   }
/*    */ 
/*    */   
/*    */   public IntAction(int paramInt1, int paramInt2, float paramFloat, @Null Interpolation paramInterpolation) {
/* 49 */     super(paramFloat, paramInterpolation);
/* 50 */     this.start = paramInt1;
/* 51 */     this.end = paramInt2;
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
/* 64 */     this.value = (int)(this.start + (this.end - this.start) * paramFloat);
/*    */   }
/*    */ 
/*    */   
/*    */   public int getValue() {
/* 69 */     return this.value;
/*    */   }
/*    */ 
/*    */   
/*    */   public void setValue(int paramInt) {
/* 74 */     this.value = paramInt;
/*    */   }
/*    */   
/*    */   public int getStart() {
/* 78 */     return this.start;
/*    */   }
/*    */ 
/*    */   
/*    */   public void setStart(int paramInt) {
/* 83 */     this.start = paramInt;
/*    */   }
/*    */   
/*    */   public int getEnd() {
/* 87 */     return this.end;
/*    */   }
/*    */ 
/*    */   
/*    */   public void setEnd(int paramInt) {
/* 92 */     this.end = paramInt;
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gdx\scenes\scene2d\actions\IntAction.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */