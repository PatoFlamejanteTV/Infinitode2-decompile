/*    */ package com.prineside.tdi2.utils;
/*    */ 
/*    */ import com.prineside.tdi2.scene2d.utils.Drawable;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public abstract class AbstractDrawable
/*    */   implements Drawable
/*    */ {
/*    */   public static final int DRAWABLE_PARAM_LEFT_WIDTH = 0;
/*    */   public static final int DRAWABLE_PARAM_RIGHT_WIDTH = 1;
/*    */   public static final int DRAWABLE_PARAM_TOP_HEIGHT = 2;
/*    */   public static final int DRAWABLE_PARAM_BOTTOM_HEIGHT = 3;
/*    */   public static final int DRAWABLE_PARAM_MIN_WIDTH = 4;
/*    */   public static final int DRAWABLE_PARAM_MIN_HEIGHT = 5;
/*    */   protected float[] a;
/*    */   
/*    */   protected final void a() {
/* 20 */     if (this.a == null) {
/* 21 */       this.a = new float[6];
/*    */     }
/*    */   }
/*    */ 
/*    */   
/*    */   public float getLeftWidth() {
/* 27 */     return (this.a == null) ? 0.0F : this.a[0];
/*    */   }
/*    */ 
/*    */   
/*    */   public void setLeftWidth(float paramFloat) {
/* 32 */     a();
/* 33 */     this.a[0] = paramFloat;
/*    */   }
/*    */ 
/*    */   
/*    */   public float getRightWidth() {
/* 38 */     return (this.a == null) ? 0.0F : this.a[1];
/*    */   }
/*    */ 
/*    */   
/*    */   public void setRightWidth(float paramFloat) {
/* 43 */     a();
/* 44 */     this.a[1] = paramFloat;
/*    */   }
/*    */ 
/*    */   
/*    */   public float getTopHeight() {
/* 49 */     return (this.a == null) ? 0.0F : this.a[2];
/*    */   }
/*    */ 
/*    */   
/*    */   public void setTopHeight(float paramFloat) {
/* 54 */     a();
/* 55 */     this.a[2] = paramFloat;
/*    */   }
/*    */ 
/*    */   
/*    */   public float getBottomHeight() {
/* 60 */     return (this.a == null) ? 0.0F : this.a[3];
/*    */   }
/*    */ 
/*    */   
/*    */   public void setBottomHeight(float paramFloat) {
/* 65 */     a();
/* 66 */     this.a[3] = paramFloat;
/*    */   }
/*    */ 
/*    */   
/*    */   public float getMinWidth() {
/* 71 */     return (this.a == null) ? 0.0F : this.a[4];
/*    */   }
/*    */ 
/*    */   
/*    */   public void setMinWidth(float paramFloat) {
/* 76 */     a();
/* 77 */     this.a[4] = paramFloat;
/*    */   }
/*    */ 
/*    */   
/*    */   public float getMinHeight() {
/* 82 */     return (this.a == null) ? 0.0F : this.a[5];
/*    */   }
/*    */ 
/*    */   
/*    */   public void setMinHeight(float paramFloat) {
/* 87 */     a();
/* 88 */     this.a[5] = paramFloat;
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi\\utils\AbstractDrawable.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */