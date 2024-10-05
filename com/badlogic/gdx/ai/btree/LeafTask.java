/*    */ package com.badlogic.gdx.ai.btree;
/*    */ 
/*    */ import com.badlogic.gdx.ai.btree.annotation.TaskConstraint;
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
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ @TaskConstraint(minChildren = 0, maxChildren = 0)
/*    */ public abstract class LeafTask<E>
/*    */   extends Task<E>
/*    */ {
/*    */   public abstract Task.Status execute();
/*    */   
/*    */   public final void run() {
/*    */     Task.Status status;
/* 43 */     if ((status = execute()) == null) throw new IllegalStateException("Invalid status 'null' returned by the execute method"); 
/* 44 */     switch (status) {
/*    */       case SUCCEEDED:
/* 46 */         success();
/*    */         return;
/*    */       case FAILED:
/* 49 */         fail();
/*    */         return;
/*    */       case RUNNING:
/* 52 */         running();
/*    */         return;
/*    */     } 
/* 55 */     throw new IllegalStateException("Invalid status '" + status.name() + "' returned by the execute method");
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   protected int addChildToTask(Task<E> paramTask) {
/* 62 */     throw new IllegalStateException("A leaf task cannot have any children");
/*    */   }
/*    */ 
/*    */   
/*    */   public int getChildCount() {
/* 67 */     return 0;
/*    */   }
/*    */ 
/*    */   
/*    */   public Task<E> getChild(int paramInt) {
/* 72 */     throw new IndexOutOfBoundsException("A leaf task can not have any child");
/*    */   }
/*    */   
/*    */   public final void childRunning(Task<E> paramTask1, Task<E> paramTask2) {}
/*    */   
/*    */   public final void childFail(Task<E> paramTask) {}
/*    */   
/*    */   public final void childSuccess(Task<E> paramTask) {}
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gdx\ai\btree\LeafTask.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */