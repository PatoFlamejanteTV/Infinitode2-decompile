/*     */ package com.badlogic.gdx.scenes.scene2d.actions;
/*     */ 
/*     */ import com.badlogic.gdx.scenes.scene2d.Action;
/*     */ import com.badlogic.gdx.scenes.scene2d.Actor;
/*     */ import com.badlogic.gdx.utils.Array;
/*     */ import com.badlogic.gdx.utils.Pool;
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
/*     */ public class ParallelAction
/*     */   extends Action
/*     */ {
/*  27 */   Array<Action> actions = new Array(4);
/*     */   
/*     */   private boolean complete;
/*     */   
/*     */   public ParallelAction() {}
/*     */   
/*     */   public ParallelAction(Action paramAction) {
/*  34 */     addAction(paramAction);
/*     */   }
/*     */   
/*     */   public ParallelAction(Action paramAction1, Action paramAction2) {
/*  38 */     addAction(paramAction1);
/*  39 */     addAction(paramAction2);
/*     */   }
/*     */   
/*     */   public ParallelAction(Action paramAction1, Action paramAction2, Action paramAction3) {
/*  43 */     addAction(paramAction1);
/*  44 */     addAction(paramAction2);
/*  45 */     addAction(paramAction3);
/*     */   }
/*     */   
/*     */   public ParallelAction(Action paramAction1, Action paramAction2, Action paramAction3, Action paramAction4) {
/*  49 */     addAction(paramAction1);
/*  50 */     addAction(paramAction2);
/*  51 */     addAction(paramAction3);
/*  52 */     addAction(paramAction4);
/*     */   }
/*     */   
/*     */   public ParallelAction(Action paramAction1, Action paramAction2, Action paramAction3, Action paramAction4, Action paramAction5) {
/*  56 */     addAction(paramAction1);
/*  57 */     addAction(paramAction2);
/*  58 */     addAction(paramAction3);
/*  59 */     addAction(paramAction4);
/*  60 */     addAction(paramAction5);
/*     */   }
/*     */   
/*     */   public boolean act(float paramFloat) {
/*  64 */     if (this.complete) return true; 
/*  65 */     this.complete = true;
/*  66 */     Pool pool = getPool();
/*  67 */     setPool(null);
/*     */     try {
/*  69 */       Array<Action> array = this.actions; byte b; int i;
/*  70 */       for (b = 0, i = array.size; b < i && this.actor != null; b++) {
/*     */         Action action;
/*  72 */         if ((action = (Action)array.get(b)).getActor() != null && !action.act(paramFloat)) this.complete = false; 
/*  73 */         if (this.actor == null) return true; 
/*     */       } 
/*  75 */       return this.complete;
/*     */     } finally {
/*  77 */       setPool(pool);
/*     */     } 
/*     */   }
/*     */   
/*     */   public void restart() {
/*  82 */     this.complete = false;
/*  83 */     Array<Action> array = this.actions; byte b; int i;
/*  84 */     for (b = 0, i = array.size; b < i; b++)
/*  85 */       ((Action)array.get(b)).restart(); 
/*     */   }
/*     */   
/*     */   public void reset() {
/*  89 */     super.reset();
/*  90 */     this.actions.clear();
/*     */   }
/*     */   
/*     */   public void addAction(Action paramAction) {
/*  94 */     this.actions.add(paramAction);
/*  95 */     if (this.actor != null) paramAction.setActor(this.actor); 
/*     */   }
/*     */   
/*     */   public void setActor(Actor paramActor) {
/*  99 */     Array<Action> array = this.actions; byte b; int i;
/* 100 */     for (b = 0, i = array.size; b < i; b++)
/* 101 */       ((Action)array.get(b)).setActor(paramActor); 
/* 102 */     super.setActor(paramActor);
/*     */   }
/*     */   
/*     */   public Array<Action> getActions() {
/* 106 */     return this.actions;
/*     */   }
/*     */   
/*     */   public String toString() {
/*     */     StringBuilder stringBuilder;
/* 111 */     (stringBuilder = new StringBuilder(64)).append(super.toString());
/* 112 */     stringBuilder.append('(');
/* 113 */     Array<Action> array = this.actions; byte b; int i;
/* 114 */     for (b = 0, i = array.size; b < i; b++) {
/* 115 */       if (b > 0) stringBuilder.append(", "); 
/* 116 */       stringBuilder.append(array.get(b));
/*     */     } 
/* 118 */     stringBuilder.append(')');
/* 119 */     return stringBuilder.toString();
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gdx\scenes\scene2d\actions\ParallelAction.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */