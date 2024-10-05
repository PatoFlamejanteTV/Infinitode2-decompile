/*    */ package com.prineside.tdi2.utils;
/*    */ 
/*    */ import com.badlogic.gdx.graphics.g2d.Batch;
/*    */ import com.prineside.tdi2.scene2d.utils.BaseDrawable;
/*    */ import com.prineside.tdi2.scene2d.utils.Drawable;
/*    */ import com.prineside.tdi2.scene2d.utils.TransformDrawable;
/*    */ import com.prineside.tdi2.ui.actors.QuadActor;
/*    */ 
/*    */ public final class QuadDrawable
/*    */   extends BaseDrawable
/*    */   implements TransformDrawable
/*    */ {
/*    */   private QuadActor a;
/*    */   
/*    */   public QuadDrawable() {}
/*    */   
/*    */   public QuadDrawable(QuadActor paramQuadActor) {
/* 18 */     setQuadActor(paramQuadActor);
/*    */   }
/*    */   
/*    */   public QuadDrawable(QuadDrawable paramQuadDrawable) {
/* 22 */     super((Drawable)paramQuadDrawable);
/* 23 */     setQuadActor(paramQuadDrawable.a);
/*    */   }
/*    */ 
/*    */   
/*    */   @IgnoreMethodOverloadLuaDefWarning
/*    */   public final void draw(Batch paramBatch, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4) {
/* 29 */     this.a.setPosition(paramFloat1, paramFloat2);
/* 30 */     this.a.setSize(paramFloat3, paramFloat4);
/* 31 */     this.a.setColor(paramBatch.getColor());
/* 32 */     this.a.draw(paramBatch, 1.0F);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   @IgnoreMethodOverloadLuaDefWarning
/*    */   public final void draw(Batch paramBatch, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6, float paramFloat7, float paramFloat8, float paramFloat9) {
/* 39 */     this.a.setPosition(paramFloat1, paramFloat2);
/* 40 */     this.a.setSize(paramFloat5, paramFloat6);
/* 41 */     this.a.setColor(paramBatch.getColor());
/* 42 */     this.a.draw(paramBatch, 1.0F);
/*    */   }
/*    */   
/*    */   public final void setQuadActor(QuadActor paramQuadActor) {
/* 46 */     this.a = paramQuadActor;
/* 47 */     if (paramQuadActor != null) {
/* 48 */       setMinWidth(paramQuadActor.getMinWidth());
/* 49 */       setMinHeight(paramQuadActor.getMinHeight());
/*    */     } 
/*    */   }
/*    */   
/*    */   public final QuadActor getQuadActor() {
/* 54 */     return this.a;
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi\\utils\QuadDrawable.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */