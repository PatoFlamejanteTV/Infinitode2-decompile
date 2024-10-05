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
/*    */ public class IntAction
/*    */   extends TemporalAction
/*    */ {
/*    */   private int c;
/*    */   private int d;
/*    */   private int e;
/*    */   
/*    */   public IntAction() {
/* 30 */     this.c = 0;
/* 31 */     this.d = 1;
/*    */   }
/*    */ 
/*    */   
/*    */   public IntAction(int paramInt1, int paramInt2) {
/* 36 */     this.c = paramInt1;
/* 37 */     this.d = paramInt2;
/*    */   }
/*    */ 
/*    */   
/*    */   public IntAction(int paramInt1, int paramInt2, float paramFloat) {
/* 42 */     super(paramFloat);
/* 43 */     this.c = paramInt1;
/* 44 */     this.d = paramInt2;
/*    */   }
/*    */ 
/*    */   
/*    */   public IntAction(int paramInt1, int paramInt2, float paramFloat, @Null Interpolation paramInterpolation) {
/* 49 */     super(paramFloat, paramInterpolation);
/* 50 */     this.c = paramInt1;
/* 51 */     this.d = paramInt2;
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
/* 64 */     this.e = (int)(this.c + (this.d - this.c) * paramFloat);
/*    */   }
/*    */ 
/*    */   
/*    */   public int getValue() {
/* 69 */     return this.e;
/*    */   }
/*    */ 
/*    */   
/*    */   public void setValue(int paramInt) {
/* 74 */     this.e = paramInt;
/*    */   }
/*    */   
/*    */   public int getStart() {
/* 78 */     return this.c;
/*    */   }
/*    */ 
/*    */   
/*    */   public void setStart(int paramInt) {
/* 83 */     this.c = paramInt;
/*    */   }
/*    */   
/*    */   public int getEnd() {
/* 87 */     return this.d;
/*    */   }
/*    */ 
/*    */   
/*    */   public void setEnd(int paramInt) {
/* 92 */     this.d = paramInt;
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\scene2d\actions\IntAction.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */