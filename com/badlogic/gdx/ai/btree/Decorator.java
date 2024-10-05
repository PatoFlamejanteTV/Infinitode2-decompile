/*     */ package com.badlogic.gdx.ai.btree;
/*     */ 
/*     */ import com.badlogic.gdx.ai.btree.annotation.TaskConstraint;
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
/*     */ @TaskConstraint(minChildren = 1, maxChildren = 1)
/*     */ public abstract class Decorator<E>
/*     */   extends Task<E>
/*     */ {
/*     */   protected Task<E> child;
/*     */   
/*     */   public Decorator() {}
/*     */   
/*     */   public Decorator(Task<E> paramTask) {
/*  42 */     this.child = paramTask;
/*     */   }
/*     */ 
/*     */   
/*     */   protected int addChildToTask(Task<E> paramTask) {
/*  47 */     if (this.child != null) throw new IllegalStateException("A decorator task cannot have more than one child"); 
/*  48 */     this.child = paramTask;
/*  49 */     return 0;
/*     */   }
/*     */ 
/*     */   
/*     */   public int getChildCount() {
/*  54 */     return (this.child == null) ? 0 : 1;
/*     */   }
/*     */ 
/*     */   
/*     */   public Task<E> getChild(int paramInt) {
/*  59 */     if (paramInt == 0 && this.child != null) return this.child; 
/*  60 */     throw new IndexOutOfBoundsException("index can't be >= size: " + paramInt + " >= " + getChildCount());
/*     */   }
/*     */ 
/*     */   
/*     */   public void run() {
/*  65 */     if (this.child.status == Task.Status.RUNNING) {
/*  66 */       this.child.run(); return;
/*     */     } 
/*  68 */     this.child.setControl(this);
/*  69 */     this.child.start();
/*  70 */     if (this.child.checkGuard(this)) {
/*  71 */       this.child.run(); return;
/*     */     } 
/*  73 */     this.child.fail();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void childRunning(Task<E> paramTask1, Task<E> paramTask2) {
/*  79 */     running();
/*     */   }
/*     */ 
/*     */   
/*     */   public void childFail(Task<E> paramTask) {
/*  84 */     fail();
/*     */   }
/*     */ 
/*     */   
/*     */   public void childSuccess(Task<E> paramTask) {
/*  89 */     success();
/*     */   }
/*     */ 
/*     */   
/*     */   protected Task<E> copyTo(Task<E> paramTask) {
/*  94 */     if (this.child != null) {
/*     */       Decorator decorator;
/*  96 */       (decorator = (Decorator)paramTask).child = this.child.cloneTask();
/*     */     } 
/*     */     
/*  99 */     return paramTask;
/*     */   }
/*     */ 
/*     */   
/*     */   public void reset() {
/* 104 */     this.child = null;
/* 105 */     super.reset();
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gdx\ai\btree\Decorator.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */