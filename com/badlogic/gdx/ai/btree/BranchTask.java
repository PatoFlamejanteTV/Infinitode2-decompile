/*    */ package com.badlogic.gdx.ai.btree;
/*    */ 
/*    */ import com.badlogic.gdx.ai.btree.annotation.TaskConstraint;
/*    */ import com.badlogic.gdx.utils.Array;
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
/*    */ @TaskConstraint(minChildren = 1)
/*    */ public abstract class BranchTask<E>
/*    */   extends Task<E>
/*    */ {
/*    */   protected Array<Task<E>> children;
/*    */   
/*    */   public BranchTask() {
/* 36 */     this(new Array());
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public BranchTask(Array<Task<E>> paramArray) {
/* 43 */     this.children = paramArray;
/*    */   }
/*    */ 
/*    */   
/*    */   protected int addChildToTask(Task<E> paramTask) {
/* 48 */     this.children.add(paramTask);
/* 49 */     return this.children.size - 1;
/*    */   }
/*    */ 
/*    */   
/*    */   public int getChildCount() {
/* 54 */     return this.children.size;
/*    */   }
/*    */ 
/*    */   
/*    */   public Task<E> getChild(int paramInt) {
/* 59 */     return (Task<E>)this.children.get(paramInt);
/*    */   }
/*    */ 
/*    */   
/*    */   protected Task<E> copyTo(Task<E> paramTask) {
/* 64 */     BranchTask branchTask = (BranchTask)paramTask;
/* 65 */     if (this.children != null) {
/* 66 */       for (byte b = 0; b < this.children.size; b++) {
/* 67 */         branchTask.children.add(((Task)this.children.get(b)).cloneTask());
/*    */       }
/*    */     }
/*    */     
/* 71 */     return paramTask;
/*    */   }
/*    */ 
/*    */   
/*    */   public void reset() {
/* 76 */     this.children.clear();
/* 77 */     super.reset();
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gdx\ai\btree\BranchTask.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */