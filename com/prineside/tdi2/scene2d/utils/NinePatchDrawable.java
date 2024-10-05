/*    */ package com.prineside.tdi2.scene2d.utils;
/*    */ 
/*    */ import com.badlogic.gdx.graphics.Color;
/*    */ import com.badlogic.gdx.graphics.g2d.Batch;
/*    */ import com.badlogic.gdx.graphics.g2d.NinePatch;
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
/*    */ public class NinePatchDrawable
/*    */   extends BaseDrawable
/*    */   implements TransformDrawable
/*    */ {
/*    */   private NinePatch a;
/*    */   
/*    */   public NinePatchDrawable() {}
/*    */   
/*    */   public NinePatchDrawable(NinePatch paramNinePatch) {
/* 40 */     setPatch(paramNinePatch);
/*    */   }
/*    */   
/*    */   public NinePatchDrawable(NinePatchDrawable paramNinePatchDrawable) {
/* 44 */     super(paramNinePatchDrawable);
/* 45 */     this.a = paramNinePatchDrawable.a;
/*    */   }
/*    */   
/*    */   public void draw(Batch paramBatch, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4) {
/* 49 */     this.a.draw(paramBatch, paramFloat1, paramFloat2, paramFloat3, paramFloat4);
/*    */   }
/*    */ 
/*    */   
/*    */   public void draw(Batch paramBatch, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6, float paramFloat7, float paramFloat8, float paramFloat9) {
/* 54 */     this.a.draw(paramBatch, paramFloat1, paramFloat2, paramFloat3, paramFloat4, paramFloat5, paramFloat6, paramFloat7, paramFloat8, paramFloat9);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void setPatch(NinePatch paramNinePatch) {
/* 60 */     this.a = paramNinePatch;
/* 61 */     if (paramNinePatch != null) {
/* 62 */       setMinWidth(paramNinePatch.getTotalWidth());
/* 63 */       setMinHeight(paramNinePatch.getTotalHeight());
/* 64 */       setTopHeight(paramNinePatch.getPadTop());
/* 65 */       setRightWidth(paramNinePatch.getPadRight());
/* 66 */       setBottomHeight(paramNinePatch.getPadBottom());
/* 67 */       setLeftWidth(paramNinePatch.getPadLeft());
/*    */     } 
/*    */   }
/*    */   
/*    */   public NinePatch getPatch() {
/* 72 */     return this.a;
/*    */   }
/*    */ 
/*    */   
/*    */   public NinePatchDrawable tint(Color paramColor) {
/*    */     NinePatchDrawable ninePatchDrawable;
/* 78 */     (ninePatchDrawable = new NinePatchDrawable(this)).a = new NinePatch(ninePatchDrawable.getPatch(), paramColor);
/* 79 */     return ninePatchDrawable;
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\scene2\\utils\NinePatchDrawable.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */