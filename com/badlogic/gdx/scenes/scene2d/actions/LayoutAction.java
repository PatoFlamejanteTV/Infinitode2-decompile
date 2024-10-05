/*    */ package com.badlogic.gdx.scenes.scene2d.actions;
/*    */ 
/*    */ import com.badlogic.gdx.scenes.scene2d.Action;
/*    */ import com.badlogic.gdx.scenes.scene2d.Actor;
/*    */ import com.badlogic.gdx.scenes.scene2d.utils.Layout;
/*    */ import com.badlogic.gdx.utils.GdxRuntimeException;
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
/*    */   private boolean enabled;
/*    */   
/*    */   public void setTarget(Actor paramActor) {
/* 31 */     if (paramActor != null && !(paramActor instanceof Layout)) throw new GdxRuntimeException("Actor must implement layout: " + paramActor); 
/* 32 */     super.setTarget(paramActor);
/*    */   }
/*    */   
/*    */   public boolean act(float paramFloat) {
/* 36 */     ((Layout)this.target).setLayoutEnabled(this.enabled);
/* 37 */     return true;
/*    */   }
/*    */   
/*    */   public boolean isEnabled() {
/* 41 */     return this.enabled;
/*    */   }
/*    */   
/*    */   public void setLayoutEnabled(boolean paramBoolean) {
/* 45 */     this.enabled = paramBoolean;
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gdx\scenes\scene2d\actions\LayoutAction.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */