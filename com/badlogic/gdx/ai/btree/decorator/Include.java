/*     */ package com.badlogic.gdx.ai.btree.decorator;
/*     */ 
/*     */ import com.badlogic.gdx.ai.btree.Decorator;
/*     */ import com.badlogic.gdx.ai.btree.Task;
/*     */ import com.badlogic.gdx.ai.btree.TaskCloneException;
/*     */ import com.badlogic.gdx.ai.btree.annotation.TaskAttribute;
/*     */ import com.badlogic.gdx.ai.btree.annotation.TaskConstraint;
/*     */ import com.badlogic.gdx.ai.btree.utils.BehaviorTreeLibraryManager;
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
/*     */ @TaskConstraint(minChildren = 0, maxChildren = 0)
/*     */ public class Include<E>
/*     */   extends Decorator<E>
/*     */ {
/*     */   @TaskAttribute(required = true)
/*     */   public String subtree;
/*     */   @TaskAttribute
/*     */   public boolean lazy;
/*     */   
/*     */   public Include() {}
/*     */   
/*     */   public Include(String paramString) {
/*  50 */     this.subtree = paramString;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Include(String paramString, boolean paramBoolean) {
/*  57 */     this.subtree = paramString;
/*  58 */     this.lazy = paramBoolean;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void start() {
/*  68 */     if (!this.lazy) {
/*  69 */       throw new UnsupportedOperationException("A non-lazy " + Include.class.getSimpleName() + " isn't meant to be run!");
/*     */     }
/*  71 */     if (this.child == null)
/*     */     {
/*  73 */       addChild(createSubtreeRootTask());
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public Task<E> cloneTask() {
/*  80 */     if (this.lazy) return super.cloneTask();
/*     */ 
/*     */     
/*  83 */     return createSubtreeRootTask();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected Task<E> copyTo(Task<E> paramTask) {
/*  92 */     if (!this.lazy) throw new TaskCloneException("A non-lazy " + getClass().getSimpleName() + " should never be copied.");
/*     */     
/*     */     Include include;
/*  95 */     (include = (Include)paramTask).subtree = this.subtree;
/*  96 */     include.lazy = this.lazy;
/*     */     
/*  98 */     return paramTask;
/*     */   }
/*     */   
/*     */   private Task<E> createSubtreeRootTask() {
/* 102 */     return BehaviorTreeLibraryManager.getInstance().createRootTask(this.subtree);
/*     */   }
/*     */ 
/*     */   
/*     */   public void reset() {
/* 107 */     this.lazy = false;
/* 108 */     this.subtree = null;
/* 109 */     super.reset();
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gdx\ai\btree\decorator\Include.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */