/*    */ package com.prineside.tdi2.ui.actors;
/*    */ 
/*    */ import com.badlogic.gdx.graphics.Color;
/*    */ import com.prineside.tdi2.scene2d.utils.Drawable;
/*    */ import com.prineside.tdi2.utils.QuadDrawable;
/*    */ 
/*    */ 
/*    */ public class RectButton
/*    */   extends ComplexButton
/*    */ {
/*    */   private final QuadDrawable l;
/*    */   
/*    */   public RectButton(CharSequence paramCharSequence, Label.LabelStyle paramLabelStyle, Runnable paramRunnable) {
/* 14 */     super(paramCharSequence, paramLabelStyle, paramRunnable);
/*    */     
/* 16 */     this.l = new QuadDrawable(new QuadActor(Color.WHITE, new float[] { 0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F, 1.0F, 0.0F }));
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   private void d() {
/* 22 */     setBackground((Drawable)this.l, 0.0F, 0.0F, getWidth(), getHeight());
/* 23 */     if (!this.k) {
/* 24 */       setLabel(0.0F, 0.0F, getWidth(), getHeight(), 1);
/* 25 */       this.k = false;
/*    */     } 
/*    */   }
/*    */ 
/*    */   
/*    */   protected void positionChanged() {
/* 31 */     super.positionChanged();
/*    */     
/* 33 */     d();
/*    */   }
/*    */ 
/*    */   
/*    */   protected void sizeChanged() {
/* 38 */     super.sizeChanged();
/*    */     
/* 40 */     d();
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi\\ui\actors\RectButton.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */