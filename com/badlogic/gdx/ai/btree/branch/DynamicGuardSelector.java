/*     */ package com.badlogic.gdx.ai.btree.branch;
/*     */ 
/*     */ import com.badlogic.gdx.ai.btree.BranchTask;
/*     */ import com.badlogic.gdx.ai.btree.Task;
/*     */ import com.badlogic.gdx.utils.Array;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class DynamicGuardSelector<E>
/*     */   extends BranchTask<E>
/*     */ {
/*     */   protected Task<E> runningChild;
/*     */   
/*     */   public DynamicGuardSelector() {}
/*     */   
/*     */   public DynamicGuardSelector(Task<E>... paramVarArgs) {
/*  46 */     super(new Array((Object[])paramVarArgs));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public DynamicGuardSelector(Array<Task<E>> paramArray) {
/*  53 */     super(paramArray);
/*     */   }
/*     */ 
/*     */   
/*     */   public void childRunning(Task<E> paramTask1, Task<E> paramTask2) {
/*  58 */     this.runningChild = paramTask1;
/*  59 */     running();
/*     */   }
/*     */ 
/*     */   
/*     */   public void childSuccess(Task<E> paramTask) {
/*  64 */     this.runningChild = null;
/*  65 */     success();
/*     */   }
/*     */ 
/*     */   
/*     */   public void childFail(Task<E> paramTask) {
/*  70 */     this.runningChild = null;
/*  71 */     fail();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void run() {
/*  77 */     Task<E> task = null; byte b; int i;
/*  78 */     for (b = 0, i = this.children.size; b < i; b++) {
/*     */       Task<E> task1;
/*  80 */       if ((task1 = (Task)this.children.get(b)).checkGuard((Task)this)) {
/*  81 */         task = task1;
/*     */         
/*     */         break;
/*     */       } 
/*     */     } 
/*  86 */     if (this.runningChild != null && this.runningChild != task) {
/*  87 */       this.runningChild.cancel();
/*  88 */       this.runningChild = null;
/*     */     } 
/*  90 */     if (task == null) {
/*  91 */       fail(); return;
/*     */     } 
/*  93 */     if (this.runningChild == null) {
/*  94 */       this.runningChild = task;
/*  95 */       this.runningChild.setControl((Task)this);
/*  96 */       this.runningChild.start();
/*     */     } 
/*  98 */     this.runningChild.run();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void resetTask() {
/* 104 */     super.resetTask();
/* 105 */     this.runningChild = null;
/*     */   }
/*     */ 
/*     */   
/*     */   protected Task<E> copyTo(Task<E> paramTask) {
/*     */     DynamicGuardSelector dynamicGuardSelector;
/* 111 */     (dynamicGuardSelector = (DynamicGuardSelector)paramTask).runningChild = null;
/*     */     
/* 113 */     return super.copyTo(paramTask);
/*     */   }
/*     */ 
/*     */   
/*     */   public void reset() {
/* 118 */     this.runningChild = null;
/* 119 */     super.reset();
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gdx\ai\btree\branch\DynamicGuardSelector.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */