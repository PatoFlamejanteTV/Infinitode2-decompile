/*     */ package com.badlogic.gdx.ai.btree;
/*     */ 
/*     */ import com.badlogic.gdx.math.MathUtils;
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
/*     */ 
/*     */ public abstract class SingleRunningChildBranch<E>
/*     */   extends BranchTask<E>
/*     */ {
/*     */   protected Task<E> runningChild;
/*     */   protected int currentChildIndex;
/*     */   protected Task<E>[] randomChildren;
/*     */   
/*     */   public SingleRunningChildBranch() {}
/*     */   
/*     */   public SingleRunningChildBranch(Array<Task<E>> paramArray) {
/*  48 */     super(paramArray);
/*     */   }
/*     */ 
/*     */   
/*     */   public void childRunning(Task<E> paramTask1, Task<E> paramTask2) {
/*  53 */     this.runningChild = paramTask1;
/*  54 */     running();
/*     */   }
/*     */ 
/*     */   
/*     */   public void childSuccess(Task<E> paramTask) {
/*  59 */     this.runningChild = null;
/*     */   }
/*     */ 
/*     */   
/*     */   public void childFail(Task<E> paramTask) {
/*  64 */     this.runningChild = null;
/*     */   }
/*     */ 
/*     */   
/*     */   public void run() {
/*  69 */     if (this.runningChild != null) {
/*  70 */       this.runningChild.run(); return;
/*     */     } 
/*  72 */     if (this.currentChildIndex < this.children.size) {
/*  73 */       if (this.randomChildren != null) {
/*  74 */         int i = this.children.size - 1;
/*  75 */         if (this.currentChildIndex < i) {
/*     */           
/*  77 */           i = MathUtils.random(this.currentChildIndex, i);
/*  78 */           Task<E> task = this.randomChildren[this.currentChildIndex];
/*  79 */           this.randomChildren[this.currentChildIndex] = this.randomChildren[i];
/*  80 */           this.randomChildren[i] = task;
/*     */         } 
/*  82 */         this.runningChild = this.randomChildren[this.currentChildIndex];
/*     */       } else {
/*  84 */         this.runningChild = (Task<E>)this.children.get(this.currentChildIndex);
/*     */       } 
/*  86 */       this.runningChild.setControl(this);
/*  87 */       this.runningChild.start();
/*  88 */       if (!this.runningChild.checkGuard(this)) {
/*  89 */         this.runningChild.fail(); return;
/*     */       } 
/*  91 */       run();
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void start() {
/* 100 */     this.currentChildIndex = 0;
/* 101 */     this.runningChild = null;
/*     */   }
/*     */ 
/*     */   
/*     */   protected void cancelRunningChildren(int paramInt) {
/* 106 */     super.cancelRunningChildren(paramInt);
/* 107 */     this.runningChild = null;
/*     */   }
/*     */ 
/*     */   
/*     */   public void resetTask() {
/* 112 */     super.resetTask();
/* 113 */     this.currentChildIndex = 0;
/* 114 */     this.runningChild = null;
/* 115 */     this.randomChildren = null;
/*     */   }
/*     */ 
/*     */   
/*     */   protected Task<E> copyTo(Task<E> paramTask) {
/*     */     SingleRunningChildBranch singleRunningChildBranch;
/* 121 */     (singleRunningChildBranch = (SingleRunningChildBranch)paramTask).randomChildren = null;
/*     */     
/* 123 */     return super.copyTo(paramTask);
/*     */   }
/*     */ 
/*     */   
/*     */   protected Task<E>[] createRandomChildren() {
/* 128 */     Task[] arrayOfTask = new Task[this.children.size];
/* 129 */     System.arraycopy(this.children.items, 0, arrayOfTask, 0, this.children.size);
/* 130 */     return (Task<E>[])arrayOfTask;
/*     */   }
/*     */ 
/*     */   
/*     */   public void reset() {
/* 135 */     this.currentChildIndex = 0;
/* 136 */     this.runningChild = null;
/* 137 */     this.randomChildren = null;
/* 138 */     super.reset();
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gdx\ai\btree\SingleRunningChildBranch.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */