/*     */ package com.badlogic.gdx.ai.btree.decorator;
/*     */ 
/*     */ import com.badlogic.gdx.ai.btree.Decorator;
/*     */ import com.badlogic.gdx.ai.btree.Task;
/*     */ import com.badlogic.gdx.ai.btree.annotation.TaskAttribute;
/*     */ import com.badlogic.gdx.ai.utils.NonBlockingSemaphore;
/*     */ import com.badlogic.gdx.ai.utils.NonBlockingSemaphoreRepository;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ public class SemaphoreGuard<E>
/*     */   extends Decorator<E>
/*     */ {
/*     */   @TaskAttribute(required = true)
/*     */   public String name;
/*     */   private transient NonBlockingSemaphore semaphore;
/*     */   private boolean semaphoreAcquired;
/*     */   
/*     */   public SemaphoreGuard() {}
/*     */   
/*     */   public SemaphoreGuard(Task<E> paramTask) {
/*  55 */     super(paramTask);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public SemaphoreGuard(String paramString) {
/*  63 */     this.name = paramString;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public SemaphoreGuard(String paramString, Task<E> paramTask) {
/*  71 */     super(paramTask);
/*  72 */     this.name = paramString;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void start() {
/*  80 */     if (this.semaphore == null) {
/*  81 */       this.semaphore = NonBlockingSemaphoreRepository.getSemaphore(this.name);
/*     */     }
/*  83 */     this.semaphoreAcquired = this.semaphore.acquire();
/*  84 */     super.start();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void run() {
/*  90 */     if (this.semaphoreAcquired) {
/*  91 */       super.run(); return;
/*     */     } 
/*  93 */     fail();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void end() {
/* 102 */     if (this.semaphoreAcquired) {
/* 103 */       if (this.semaphore == null) {
/* 104 */         this.semaphore = NonBlockingSemaphoreRepository.getSemaphore(this.name);
/*     */       }
/* 106 */       this.semaphore.release();
/* 107 */       this.semaphoreAcquired = false;
/*     */     } 
/* 109 */     super.end();
/*     */   }
/*     */ 
/*     */   
/*     */   public void resetTask() {
/* 114 */     super.resetTask();
/* 115 */     this.semaphore = null;
/* 116 */     this.semaphoreAcquired = false;
/*     */   }
/*     */ 
/*     */   
/*     */   protected Task<E> copyTo(Task<E> paramTask) {
/*     */     SemaphoreGuard semaphoreGuard;
/* 122 */     (semaphoreGuard = (SemaphoreGuard)paramTask).name = this.name;
/* 123 */     semaphoreGuard.semaphore = null;
/* 124 */     semaphoreGuard.semaphoreAcquired = false;
/*     */     
/* 126 */     return super.copyTo(paramTask);
/*     */   }
/*     */ 
/*     */   
/*     */   public void reset() {
/* 131 */     this.name = null;
/* 132 */     this.semaphore = null;
/* 133 */     this.semaphoreAcquired = false;
/* 134 */     super.reset();
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gdx\ai\btree\decorator\SemaphoreGuard.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */