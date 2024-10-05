/*     */ package com.badlogic.gdx.ai.btree;
/*     */ 
/*     */ import com.badlogic.gdx.utils.Array;
/*     */ import java.util.Iterator;
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
/*     */ public class BehaviorTree<E>
/*     */   extends Task<E>
/*     */ {
/*     */   private Task<E> rootTask;
/*     */   private E object;
/*     */   GuardEvaluator<E> guardEvaluator;
/*     */   public Array<Listener<E>> listeners;
/*     */   
/*     */   public BehaviorTree() {
/*  39 */     this((Task<E>)null, (E)null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public BehaviorTree(Task<E> paramTask) {
/*  48 */     this(paramTask, (E)null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public BehaviorTree(Task<E> paramTask, E paramE) {
/*  58 */     this.rootTask = paramTask;
/*  59 */     this.object = paramE;
/*  60 */     this.tree = this;
/*  61 */     this.guardEvaluator = new GuardEvaluator<>(this);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public E getObject() {
/*  67 */     return this.object;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setObject(E paramE) {
/*  74 */     this.object = paramE;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected int addChildToTask(Task<E> paramTask) {
/*  84 */     if (this.rootTask != null) throw new IllegalStateException("A behavior tree cannot have more than one root task"); 
/*  85 */     this.rootTask = paramTask;
/*  86 */     return 0;
/*     */   }
/*     */ 
/*     */   
/*     */   public int getChildCount() {
/*  91 */     return (this.rootTask == null) ? 0 : 1;
/*     */   }
/*     */ 
/*     */   
/*     */   public Task<E> getChild(int paramInt) {
/*  96 */     if (paramInt == 0 && this.rootTask != null) return this.rootTask; 
/*  97 */     throw new IndexOutOfBoundsException("index can't be >= size: " + paramInt + " >= " + getChildCount());
/*     */   }
/*     */ 
/*     */   
/*     */   public void childRunning(Task<E> paramTask1, Task<E> paramTask2) {
/* 102 */     running();
/*     */   }
/*     */ 
/*     */   
/*     */   public void childFail(Task<E> paramTask) {
/* 107 */     fail();
/*     */   }
/*     */ 
/*     */   
/*     */   public void childSuccess(Task<E> paramTask) {
/* 112 */     success();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void step() {
/* 118 */     if (this.rootTask.status == Task.Status.RUNNING) {
/* 119 */       this.rootTask.run(); return;
/*     */     } 
/* 121 */     this.rootTask.setControl(this);
/* 122 */     this.rootTask.start();
/* 123 */     if (this.rootTask.checkGuard(this)) {
/* 124 */       this.rootTask.run(); return;
/*     */     } 
/* 126 */     this.rootTask.fail();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void run() {}
/*     */ 
/*     */ 
/*     */   
/*     */   public void resetTask() {
/* 136 */     super.resetTask();
/* 137 */     this.tree = this;
/*     */   }
/*     */ 
/*     */   
/*     */   protected Task<E> copyTo(Task<E> paramTask) {
/*     */     BehaviorTree behaviorTree;
/* 143 */     (behaviorTree = (BehaviorTree)paramTask).rootTask = this.rootTask.cloneTask();
/*     */     
/* 145 */     return paramTask;
/*     */   }
/*     */   
/*     */   public void addListener(Listener<E> paramListener) {
/* 149 */     if (this.listeners == null) this.listeners = new Array(); 
/* 150 */     this.listeners.add(paramListener);
/*     */   }
/*     */   
/*     */   public void removeListener(Listener<E> paramListener) {
/* 154 */     if (this.listeners != null) this.listeners.removeValue(paramListener, true); 
/*     */   }
/*     */   
/*     */   public void removeListeners() {
/* 158 */     if (this.listeners != null) this.listeners.clear(); 
/*     */   }
/*     */   
/*     */   public void notifyStatusUpdated(Task<E> paramTask, Task.Status paramStatus) {
/* 162 */     for (Iterator<Listener> iterator = this.listeners.iterator(); iterator.hasNext();) {
/* 163 */       (listener = iterator.next()).statusUpdated(paramTask, paramStatus);
/*     */     }
/*     */   }
/*     */   
/*     */   public void notifyChildAdded(Task<E> paramTask, int paramInt) {
/* 168 */     for (Iterator<Listener> iterator = this.listeners.iterator(); iterator.hasNext();) {
/* 169 */       (listener = iterator.next()).childAdded(paramTask, paramInt);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public void reset() {
/* 175 */     removeListeners();
/* 176 */     this.rootTask = null;
/* 177 */     this.object = null;
/* 178 */     this.listeners = null;
/* 179 */     super.reset();
/*     */   }
/*     */   
/*     */   public static interface Listener<E> {
/*     */     void statusUpdated(Task<E> param1Task, Task.Status param1Status);
/*     */     
/*     */     void childAdded(Task<E> param1Task, int param1Int); }
/*     */   
/*     */   private static final class GuardEvaluator<E> extends Task<E> { public GuardEvaluator() {}
/*     */     
/*     */     public GuardEvaluator(BehaviorTree<E> param1BehaviorTree) {
/* 190 */       this.tree = param1BehaviorTree;
/*     */     }
/*     */ 
/*     */     
/*     */     protected final int addChildToTask(Task<E> param1Task) {
/* 195 */       return 0;
/*     */     }
/*     */ 
/*     */     
/*     */     public final int getChildCount() {
/* 200 */       return 0;
/*     */     }
/*     */ 
/*     */     
/*     */     public final Task<E> getChild(int param1Int) {
/* 205 */       return null;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public final void run() {}
/*     */ 
/*     */ 
/*     */     
/*     */     public final void childSuccess(Task<E> param1Task) {}
/*     */ 
/*     */ 
/*     */     
/*     */     public final void childFail(Task<E> param1Task) {}
/*     */ 
/*     */ 
/*     */     
/*     */     public final void childRunning(Task<E> param1Task1, Task<E> param1Task2) {}
/*     */ 
/*     */     
/*     */     protected final Task<E> copyTo(Task<E> param1Task) {
/* 226 */       return null;
/*     */     } }
/*     */ 
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gdx\ai\btree\BehaviorTree.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */