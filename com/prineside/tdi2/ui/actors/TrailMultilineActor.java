/*    */ package com.prineside.tdi2.ui.actors;
/*    */ 
/*    */ import com.badlogic.gdx.graphics.Color;
/*    */ import com.badlogic.gdx.graphics.g2d.Batch;
/*    */ import com.badlogic.gdx.utils.Disposable;
/*    */ import com.prineside.tdi2.Game;
/*    */ import com.prineside.tdi2.Shape;
/*    */ import com.prineside.tdi2.enums.ShapeType;
/*    */ import com.prineside.tdi2.scene2d.ui.Widget;
/*    */ import com.prineside.tdi2.shapes.TrailMultiLine;
/*    */ 
/*    */ 
/*    */ public class TrailMultilineActor
/*    */   extends Widget
/*    */   implements Disposable
/*    */ {
/*    */   public final TrailMultiLine trail;
/*    */   private long j;
/*    */   private boolean k;
/*    */   private boolean l;
/*    */   
/*    */   public TrailMultilineActor() {
/* 23 */     this.trail = (TrailMultiLine)Game.i.shapeManager.getFactory(ShapeType.TRAIL_MULTI_LINE).obtain();
/* 24 */     setSize(1.0F, 1.0F);
/*    */   }
/*    */   
/*    */   public void setup(Color paramColor, float paramFloat1, float paramFloat2, float paramFloat3) {
/* 28 */     this.trail.setup(paramColor, paramFloat1, paramFloat2, paramFloat3);
/* 29 */     this.k = true;
/* 30 */     this.l = false;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void stop() {
/* 38 */     this.l = false;
/*    */   }
/*    */ 
/*    */   
/*    */   public void draw(Batch paramBatch, float paramFloat) {
/* 43 */     super.draw(paramBatch, paramFloat);
/*    */     
/* 45 */     if (!this.k) {
/*    */       return;
/*    */     }
/* 48 */     if ((paramFloat = (float)(Game.getRealTickCount() - this.j) / 1000000.0F) > 0.5F) paramFloat = 0.5F; 
/* 49 */     this.j = Game.getRealTickCount();
/*    */     
/* 51 */     if (!this.l) {
/* 52 */       if (getX() != 0.0F && getY() != 0.0F) {
/* 53 */         this.trail.setStartPoint(getX(), getY());
/* 54 */         this.l = true; return;
/*    */       } 
/*    */     } else {
/* 57 */       this.trail.setHeadPosition(getX(), getY());
/* 58 */       this.trail.update(paramFloat);
/* 59 */       this.trail.draw(paramBatch);
/*    */     } 
/*    */   }
/*    */ 
/*    */   
/*    */   public void dispose() {
/* 65 */     ((TrailMultiLine.TrailMultiLineFactory)Game.i.shapeManager.getFactory(ShapeType.TRAIL_MULTI_LINE)).free((Shape)this.trail);
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi\\ui\actors\TrailMultilineActor.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */