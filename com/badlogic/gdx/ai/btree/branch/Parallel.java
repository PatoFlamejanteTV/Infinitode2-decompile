/*     */ package com.badlogic.gdx.ai.btree.branch;
/*     */ 
/*     */ import com.badlogic.gdx.ai.btree.BranchTask;
/*     */ import com.badlogic.gdx.ai.btree.Task;
/*     */ import com.badlogic.gdx.ai.btree.annotation.TaskAttribute;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class Parallel<E>
/*     */   extends BranchTask<E>
/*     */ {
/*     */   @TaskAttribute
/*     */   public Policy policy;
/*     */   @TaskAttribute
/*     */   public Orchestrator orchestrator;
/*     */   private boolean noRunningTasks;
/*     */   private Boolean lastResult;
/*     */   private int currentChildIndex;
/*     */   
/*     */   public Parallel() {
/*  61 */     this(new Array());
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public Parallel(Task<E>... paramVarArgs) {
/*  67 */     this(new Array((Object[])paramVarArgs));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public Parallel(Array<Task<E>> paramArray) {
/*  73 */     this(Policy.Sequence, paramArray);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public Parallel(Policy paramPolicy) {
/*  79 */     this(paramPolicy, new Array());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Parallel(Policy paramPolicy, Task<E>... paramVarArgs) {
/*  86 */     this(paramPolicy, new Array((Object[])paramVarArgs));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Parallel(Policy paramPolicy, Array<Task<E>> paramArray) {
/*  93 */     this(paramPolicy, Orchestrator.Resume, paramArray);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Parallel(Orchestrator paramOrchestrator, Array<Task<E>> paramArray) {
/* 100 */     this(Policy.Sequence, paramOrchestrator, paramArray);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Parallel(Orchestrator paramOrchestrator, Task<E>... paramVarArgs) {
/* 107 */     this(Policy.Sequence, paramOrchestrator, new Array((Object[])paramVarArgs));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Parallel(Policy paramPolicy, Orchestrator paramOrchestrator, Array<Task<E>> paramArray) {
/* 115 */     super(paramArray);
/* 116 */     this.policy = paramPolicy;
/* 117 */     this.orchestrator = paramOrchestrator;
/* 118 */     this.noRunningTasks = true;
/*     */   }
/*     */ 
/*     */   
/*     */   public void run() {
/* 123 */     this.orchestrator.execute(this);
/*     */   }
/*     */ 
/*     */   
/*     */   public void childRunning(Task<E> paramTask1, Task<E> paramTask2) {
/* 128 */     this.noRunningTasks = false;
/*     */   }
/*     */ 
/*     */   
/*     */   public void childSuccess(Task<E> paramTask) {
/* 133 */     this.lastResult = this.policy.onChildSuccess(this);
/*     */   }
/*     */ 
/*     */   
/*     */   public void childFail(Task<E> paramTask) {
/* 138 */     this.lastResult = this.policy.onChildFail(this);
/*     */   }
/*     */ 
/*     */   
/*     */   public void resetTask() {
/* 143 */     super.resetTask();
/* 144 */     this.noRunningTasks = true;
/*     */   }
/*     */ 
/*     */   
/*     */   protected Task<E> copyTo(Task<E> paramTask) {
/*     */     Parallel parallel;
/* 150 */     (parallel = (Parallel)paramTask).policy = this.policy;
/* 151 */     parallel.orchestrator = this.orchestrator;
/* 152 */     return super.copyTo(paramTask);
/*     */   } public void resetAllChildren() {
/*     */     byte b;
/*     */     int i;
/* 156 */     for (b = 0, i = getChildCount(); b < i; b++) {
/*     */       Task task;
/* 158 */       (task = getChild(b)).reset();
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public enum Orchestrator
/*     */   {
/* 165 */     Resume
/*     */     {
/*     */       public final void execute(Parallel<?> param2Parallel) {
/* 168 */         param2Parallel.noRunningTasks = true;
/* 169 */         param2Parallel.lastResult = null;
/* 170 */         param2Parallel.currentChildIndex = 0; for (; param2Parallel.currentChildIndex < param2Parallel.children.size; param2Parallel.currentChildIndex++) {
/*     */           Task task;
/* 172 */           if ((task = (Task)param2Parallel.children.get(param2Parallel.currentChildIndex)).getStatus() == Task.Status.RUNNING) {
/* 173 */             task.run();
/*     */           } else {
/* 175 */             task.setControl((Task)param2Parallel);
/* 176 */             task.start();
/* 177 */             if (task.checkGuard((Task)param2Parallel)) {
/* 178 */               task.run();
/*     */             } else {
/* 180 */               task.fail();
/*     */             } 
/*     */           } 
/* 183 */           if (param2Parallel.lastResult != null) {
/* 184 */             param2Parallel.cancelRunningChildren(param2Parallel.noRunningTasks ? (param2Parallel.currentChildIndex + 1) : 0);
/* 185 */             if (param2Parallel.lastResult.booleanValue()) {
/* 186 */               param2Parallel.success(); return;
/*     */             } 
/* 188 */             param2Parallel.fail();
/*     */             return;
/*     */           } 
/*     */         } 
/* 192 */         param2Parallel.running();
/*     */       }
/*     */     },
/*     */     
/* 196 */     Join
/*     */     {
/*     */       public final void execute(Parallel<?> param2Parallel) {
/* 199 */         param2Parallel.noRunningTasks = true;
/* 200 */         param2Parallel.lastResult = null;
/* 201 */         param2Parallel.currentChildIndex = 0; for (; param2Parallel.currentChildIndex < param2Parallel.children.size; param2Parallel.currentChildIndex++) {
/* 202 */           Task task = (Task)param2Parallel.children.get(param2Parallel.currentChildIndex);
/*     */           
/* 204 */           switch (task.getStatus()) {
/*     */             case Join:
/* 206 */               task.run();
/*     */               break;
/*     */             case Resume:
/*     */             case null:
/*     */               break;
/*     */             default:
/* 212 */               task.setControl((Task)param2Parallel);
/* 213 */               task.start();
/* 214 */               if (task.checkGuard((Task)param2Parallel)) {
/* 215 */                 task.run(); break;
/*     */               } 
/* 217 */               task.fail();
/*     */               break;
/*     */           } 
/*     */           
/* 221 */           if (param2Parallel.lastResult != null) {
/* 222 */             param2Parallel.cancelRunningChildren(param2Parallel.noRunningTasks ? (param2Parallel.currentChildIndex + 1) : 0);
/* 223 */             param2Parallel.resetAllChildren();
/* 224 */             if (param2Parallel.lastResult.booleanValue()) {
/* 225 */               param2Parallel.success(); return;
/*     */             } 
/* 227 */             param2Parallel.fail();
/*     */             return;
/*     */           } 
/*     */         } 
/* 231 */         param2Parallel.running();
/*     */       }
/*     */     };
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public abstract void execute(Parallel<?> param1Parallel);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void reset() {
/* 244 */     this.policy = Policy.Sequence;
/* 245 */     this.orchestrator = Orchestrator.Resume;
/* 246 */     this.noRunningTasks = true;
/* 247 */     this.lastResult = null;
/* 248 */     this.currentChildIndex = 0;
/* 249 */     super.reset();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public enum Policy
/*     */   {
/* 256 */     Sequence
/*     */     {
/*     */       public final Boolean onChildSuccess(Parallel<?> param2Parallel) {
/* 259 */         switch (param2Parallel.orchestrator) {
/*     */           case Join:
/* 261 */             return (param2Parallel.noRunningTasks && ((Task)param2Parallel.children.get(param2Parallel.children.size - 1)).getStatus() == Task.Status.SUCCEEDED) ? Boolean.TRUE : null;
/*     */         } 
/*     */         
/* 264 */         return (param2Parallel.noRunningTasks && param2Parallel.currentChildIndex == param2Parallel.children.size - 1) ? Boolean.TRUE : null;
/*     */       }
/*     */ 
/*     */ 
/*     */       
/*     */       public final Boolean onChildFail(Parallel<?> param2Parallel) {
/* 270 */         return Boolean.FALSE;
/*     */       }
/*     */     },
/*     */ 
/*     */     
/* 275 */     Selector
/*     */     {
/*     */       public final Boolean onChildSuccess(Parallel<?> param2Parallel) {
/* 278 */         return Boolean.TRUE;
/*     */       }
/*     */ 
/*     */       
/*     */       public final Boolean onChildFail(Parallel<?> param2Parallel) {
/* 283 */         return (param2Parallel.noRunningTasks && param2Parallel.currentChildIndex == param2Parallel.children.size - 1) ? Boolean.FALSE : null;
/*     */       }
/*     */     };
/*     */     
/*     */     public abstract Boolean onChildSuccess(Parallel<?> param1Parallel);
/*     */     
/*     */     public abstract Boolean onChildFail(Parallel<?> param1Parallel);
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gdx\ai\btree\branch\Parallel.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */