/*    */ package com.prineside.tdi2.scene2d.actions;
/*    */ 
/*    */ import com.badlogic.gdx.utils.Pool;
/*    */ import com.prineside.tdi2.scene2d.Action;
/*    */ import com.prineside.tdi2.scene2d.Actor;
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
/*    */   protected Action c;
/*    */   
/*    */   public void setAction(Action paramAction) {
/* 30 */     this.c = paramAction;
/*    */   }
/*    */   
/*    */   public Action getAction() {
/* 34 */     return this.c;
/*    */   }
/*    */   
/*    */   protected abstract boolean a(float paramFloat);
/*    */   
/*    */   public final boolean act(float paramFloat) {
/* 40 */     Pool pool = getPool();
/* 41 */     setPool(null);
/*    */     try {
/* 43 */       return a(paramFloat);
/*    */     } finally {
/* 45 */       setPool(pool);
/*    */     } 
/*    */   }
/*    */   
/*    */   public void restart() {
/* 50 */     if (this.c != null) this.c.restart(); 
/*    */   }
/*    */   
/*    */   public void reset() {
/* 54 */     super.reset();
/* 55 */     this.c = null;
/*    */   }
/*    */   
/*    */   public void setActor(Actor paramActor) {
/* 59 */     if (this.c != null) this.c.setActor(paramActor); 
/* 60 */     super.setActor(paramActor);
/*    */   }
/*    */   
/*    */   public void setTarget(Actor paramActor) {
/* 64 */     if (this.c != null) this.c.setTarget(paramActor); 
/* 65 */     super.setTarget(paramActor);
/*    */   }
/*    */   
/*    */   public String toString() {
/* 69 */     return super.toString() + ((this.c == null) ? "" : ("(" + this.c + ")"));
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\scene2d\actions\DelegateAction.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */