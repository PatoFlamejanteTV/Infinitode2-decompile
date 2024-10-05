/*    */ package com.badlogic.gdx.ai.btree;
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
/*    */ 
/*    */ 
/*    */ public abstract class LoopDecorator<E>
/*    */   extends Decorator<E>
/*    */ {
/*    */   protected boolean loop;
/*    */   
/*    */   public LoopDecorator() {}
/*    */   
/*    */   public LoopDecorator(Task<E> paramTask) {
/* 37 */     super(paramTask);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public boolean condition() {
/* 43 */     return this.loop;
/*    */   }
/*    */ 
/*    */   
/*    */   public void run() {
/* 48 */     this.loop = true;
/* 49 */     while (condition()) {
/* 50 */       if (this.child.status == Task.Status.RUNNING) {
/* 51 */         this.child.run(); continue;
/*    */       } 
/* 53 */       this.child.setControl(this);
/* 54 */       this.child.start();
/* 55 */       if (this.child.checkGuard(this)) {
/* 56 */         this.child.run(); continue;
/*    */       } 
/* 58 */       this.child.fail();
/*    */     } 
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void childRunning(Task<E> paramTask1, Task<E> paramTask2) {
/* 65 */     super.childRunning(paramTask1, paramTask2);
/* 66 */     this.loop = false;
/*    */   }
/*    */ 
/*    */   
/*    */   public void reset() {
/* 71 */     this.loop = false;
/* 72 */     super.reset();
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gdx\ai\btree\LoopDecorator.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */