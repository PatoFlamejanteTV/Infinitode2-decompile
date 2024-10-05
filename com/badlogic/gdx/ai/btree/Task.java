/*     */ package com.badlogic.gdx.ai.btree;
/*     */ 
/*     */ import com.badlogic.gdx.ai.btree.annotation.TaskConstraint;
/*     */ import com.badlogic.gdx.utils.Pool;
/*     */ import com.badlogic.gdx.utils.reflect.ClassReflection;
/*     */ import com.badlogic.gdx.utils.reflect.ReflectionException;
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
/*     */ @TaskConstraint
/*     */ public abstract class Task<E>
/*     */   implements Pool.Poolable
/*     */ {
/*     */   public enum Status
/*     */   {
/*  39 */     FRESH,
/*     */     
/*  41 */     RUNNING,
/*     */     
/*  43 */     FAILED,
/*     */     
/*  45 */     SUCCEEDED,
/*     */     
/*  47 */     CANCELLED;
/*     */   }
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
/*  72 */   public static TaskCloner TASK_CLONER = null;
/*     */ 
/*     */   
/*  75 */   protected Status status = Status.FRESH;
/*     */ 
/*     */ 
/*     */   
/*     */   protected Task<E> control;
/*     */ 
/*     */ 
/*     */   
/*     */   protected BehaviorTree<E> tree;
/*     */ 
/*     */ 
/*     */   
/*     */   protected Task<E> guard;
/*     */ 
/*     */ 
/*     */   
/*     */   public final int addChild(Task<E> paramTask) {
/*  92 */     int i = addChildToTask(paramTask);
/*  93 */     if (this.tree != null && this.tree.listeners != null) this.tree.notifyChildAdded(this, i); 
/*  94 */     return i;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected abstract int addChildToTask(Task<E> paramTask);
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public abstract int getChildCount();
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public abstract Task<E> getChild(int paramInt);
/*     */ 
/*     */ 
/*     */   
/*     */   public E getObject() {
/* 115 */     if (this.tree == null) throw new IllegalStateException("This task has never run"); 
/* 116 */     return this.tree.getObject();
/*     */   }
/*     */ 
/*     */   
/*     */   public Task<E> getGuard() {
/* 121 */     return this.guard;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setGuard(Task<E> paramTask) {
/* 127 */     this.guard = paramTask;
/*     */   }
/*     */ 
/*     */   
/*     */   public final Status getStatus() {
/* 132 */     return this.status;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final void setControl(Task<E> paramTask) {
/* 139 */     this.control = paramTask;
/* 140 */     this.tree = paramTask.tree;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean checkGuard(Task<E> paramTask) {
/* 150 */     if (this.guard == null) return true;
/*     */ 
/*     */     
/* 153 */     if (!this.guard.checkGuard(paramTask)) return false;
/*     */ 
/*     */     
/* 156 */     this.guard.setControl(paramTask.tree.guardEvaluator);
/* 157 */     this.guard.start();
/* 158 */     this.guard.run();
/* 159 */     switch (this.guard.getStatus()) {
/*     */       case SUCCEEDED:
/* 161 */         return true;
/*     */       case FAILED:
/* 163 */         return false;
/*     */     } 
/* 165 */     throw new IllegalStateException("Illegal guard status '" + this.guard.getStatus() + "'. Guards must either succeed or fail in one step.");
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void start() {}
/*     */ 
/*     */ 
/*     */   
/*     */   public void end() {}
/*     */ 
/*     */ 
/*     */   
/*     */   public abstract void run();
/*     */ 
/*     */ 
/*     */   
/*     */   public final void running() {
/* 184 */     Status status = this.status;
/* 185 */     this.status = Status.RUNNING;
/* 186 */     if (this.tree.listeners != null && this.tree.listeners.size > 0) this.tree.notifyStatusUpdated(this, status); 
/* 187 */     if (this.control != null) this.control.childRunning(this, this);
/*     */   
/*     */   }
/*     */   
/*     */   public final void success() {
/* 192 */     Status status = this.status;
/* 193 */     this.status = Status.SUCCEEDED;
/* 194 */     if (this.tree.listeners != null && this.tree.listeners.size > 0) this.tree.notifyStatusUpdated(this, status); 
/* 195 */     end();
/* 196 */     if (this.control != null) this.control.childSuccess(this);
/*     */   
/*     */   }
/*     */   
/*     */   public final void fail() {
/* 201 */     Status status = this.status;
/* 202 */     this.status = Status.FAILED;
/* 203 */     if (this.tree.listeners != null && this.tree.listeners.size > 0) this.tree.notifyStatusUpdated(this, status); 
/* 204 */     end();
/* 205 */     if (this.control != null) this.control.childFail(this);
/*     */   
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public abstract void childSuccess(Task<E> paramTask);
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public abstract void childFail(Task<E> paramTask);
/*     */ 
/*     */ 
/*     */   
/*     */   public abstract void childRunning(Task<E> paramTask1, Task<E> paramTask2);
/*     */ 
/*     */ 
/*     */   
/*     */   public final void cancel() {
/* 226 */     cancelRunningChildren(0);
/* 227 */     Status status = this.status;
/* 228 */     this.status = Status.CANCELLED;
/* 229 */     if (this.tree.listeners != null && this.tree.listeners.size > 0) this.tree.notifyStatusUpdated(this, status); 
/* 230 */     end();
/*     */   }
/*     */ 
/*     */   
/*     */   protected void cancelRunningChildren(int paramInt) {
/*     */     int i;
/* 236 */     for (paramInt = paramInt, i = getChildCount(); paramInt < i; paramInt++) {
/*     */       Task<E> task;
/* 238 */       if ((task = getChild(paramInt)).status == Status.RUNNING) task.cancel();
/*     */     
/*     */     } 
/*     */   }
/*     */   
/*     */   public void resetTask() {
/* 244 */     if (this.status == Status.RUNNING) cancel();  byte b; int i;
/* 245 */     for (b = 0, i = getChildCount(); b < i; b++) {
/* 246 */       getChild(b).resetTask();
/*     */     }
/* 248 */     this.status = Status.FRESH;
/* 249 */     this.tree = null;
/* 250 */     this.control = null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Task<E> cloneTask() {
/* 259 */     if (TASK_CLONER != null) {
/*     */       try {
/* 261 */         return TASK_CLONER.cloneTask(this);
/* 262 */       } catch (Throwable throwable) {
/* 263 */         throw new TaskCloneException(throwable);
/*     */       } 
/*     */     }
/*     */     try {
/*     */       Task<E> task;
/* 268 */       (task = copyTo((Task<E>)ClassReflection.newInstance(getClass()))).guard = (this.guard == null) ? null : this.guard.cloneTask();
/* 269 */       return task;
/* 270 */     } catch (ReflectionException reflectionException) {
/* 271 */       throw new TaskCloneException(reflectionException);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected abstract Task<E> copyTo(Task<E> paramTask);
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void reset() {
/* 284 */     this.control = null;
/* 285 */     this.guard = null;
/* 286 */     this.status = Status.FRESH;
/* 287 */     this.tree = null;
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gdx\ai\btree\Task.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */