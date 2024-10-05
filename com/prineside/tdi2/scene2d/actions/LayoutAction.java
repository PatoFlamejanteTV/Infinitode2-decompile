/*    */ package com.prineside.tdi2.scene2d.actions;
/*    */ 
/*    */ import com.badlogic.gdx.utils.GdxRuntimeException;
/*    */ import com.prineside.tdi2.scene2d.Action;
/*    */ import com.prineside.tdi2.scene2d.Actor;
/*    */ import com.prineside.tdi2.scene2d.utils.Layout;
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
/*    */ public class LayoutAction
/*    */   extends Action
/*    */ {
/*    */   private boolean c;
/*    */   
/*    */   public void setTarget(Actor paramActor) {
/* 31 */     if (paramActor != null && !(paramActor instanceof Layout)) throw new GdxRuntimeException("Actor must implement layout: " + paramActor); 
/* 32 */     super.setTarget(paramActor);
/*    */   }
/*    */   
/*    */   public boolean act(float paramFloat) {
/* 36 */     ((Layout)this.b).setLayoutEnabled(this.c);
/* 37 */     return true;
/*    */   }
/*    */   
/*    */   public boolean isEnabled() {
/* 41 */     return this.c;
/*    */   }
/*    */   
/*    */   public void setLayoutEnabled(boolean paramBoolean) {
/* 45 */     this.c = paramBoolean;
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\scene2d\actions\LayoutAction.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */