/*    */ package com.badlogic.gdx.scenes.scene2d.actions;
/*    */ 
/*    */ import com.badlogic.gdx.scenes.scene2d.Action;
/*    */ import com.badlogic.gdx.scenes.scene2d.Actor;
/*    */ import com.badlogic.gdx.utils.Pool;
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
/*    */ public abstract class DelegateAction
/*    */   extends Action
/*    */ {
/*    */   protected Action action;
/*    */   
/*    */   public void setAction(Action paramAction) {
/* 30 */     this.action = paramAction;
/*    */   }
/*    */   
/*    */   public Action getAction() {
/* 34 */     return this.action;
/*    */   }
/*    */   
/*    */   protected abstract boolean delegate(float paramFloat);
/*    */   
/*    */   public final boolean act(float paramFloat) {
/* 40 */     Pool pool = getPool();
/* 41 */     setPool(null);
/*    */     try {
/* 43 */       return delegate(paramFloat);
/*    */     } finally {
/* 45 */       setPool(pool);
/*    */     } 
/*    */   }
/*    */   
/*    */   public void restart() {
/* 50 */     if (this.action != null) this.action.restart(); 
/*    */   }
/*    */   
/*    */   public void reset() {
/* 54 */     super.reset();
/* 55 */     this.action = null;
/*    */   }
/*    */   
/*    */   public void setActor(Actor paramActor) {
/* 59 */     if (this.action != null) this.action.setActor(paramActor); 
/* 60 */     super.setActor(paramActor);
/*    */   }
/*    */   
/*    */   public void setTarget(Actor paramActor) {
/* 64 */     if (this.action != null) this.action.setTarget(paramActor); 
/* 65 */     super.setTarget(paramActor);
/*    */   }
/*    */   
/*    */   public String toString() {
/* 69 */     return super.toString() + ((this.action == null) ? "" : ("(" + this.action + ")"));
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gdx\scenes\scene2d\actions\DelegateAction.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */