/*    */ package com.prineside.tdi2.ui.actors;
/*    */ 
/*    */ import com.badlogic.gdx.graphics.g2d.Batch;
/*    */ import com.prineside.tdi2.scene2d.Group;
/*    */ 
/*    */ public final class GroupClipping
/*    */   extends Group {
/*    */   public final void draw(Batch paramBatch, float paramFloat) {
/*  9 */     paramBatch.flush();
/* 10 */     if (clipBegin(getX(), getY(), getWidth(), getHeight())) {
/* 11 */       a(paramBatch, paramFloat);
/* 12 */       paramBatch.flush();
/* 13 */       clipEnd();
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi\\ui\actors\GroupClipping.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */