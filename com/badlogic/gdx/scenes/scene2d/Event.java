/*     */ package com.badlogic.gdx.scenes.scene2d;
/*     */ 
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
/*     */ public class Event
/*     */   implements Pool.Poolable
/*     */ {
/*     */   private Stage stage;
/*     */   private Actor targetActor;
/*     */   private Actor listenerActor;
/*     */   private boolean capture;
/*     */   private boolean bubbles = true;
/*     */   private boolean handled;
/*     */   private boolean stopped;
/*     */   private boolean cancelled;
/*     */   
/*     */   public void handle() {
/*  50 */     this.handled = true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void cancel() {
/*  57 */     this.cancelled = true;
/*  58 */     this.stopped = true;
/*  59 */     this.handled = true;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void stop() {
/*  65 */     this.stopped = true;
/*     */   }
/*     */   
/*     */   public void reset() {
/*  69 */     this.stage = null;
/*  70 */     this.targetActor = null;
/*  71 */     this.listenerActor = null;
/*  72 */     this.capture = false;
/*  73 */     this.bubbles = true;
/*  74 */     this.handled = false;
/*  75 */     this.stopped = false;
/*  76 */     this.cancelled = false;
/*     */   }
/*     */ 
/*     */   
/*     */   public Actor getTarget() {
/*  81 */     return this.targetActor;
/*     */   }
/*     */   
/*     */   public void setTarget(Actor paramActor) {
/*  85 */     this.targetActor = paramActor;
/*     */   }
/*     */ 
/*     */   
/*     */   public Actor getListenerActor() {
/*  90 */     return this.listenerActor;
/*     */   }
/*     */   
/*     */   public void setListenerActor(Actor paramActor) {
/*  94 */     this.listenerActor = paramActor;
/*     */   }
/*     */   
/*     */   public boolean getBubbles() {
/*  98 */     return this.bubbles;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setBubbles(boolean paramBoolean) {
/* 104 */     this.bubbles = paramBoolean;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isHandled() {
/* 109 */     return this.handled;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isStopped() {
/* 114 */     return this.stopped;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isCancelled() {
/* 119 */     return this.cancelled;
/*     */   }
/*     */   
/*     */   public void setCapture(boolean paramBoolean) {
/* 123 */     this.capture = paramBoolean;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isCapture() {
/* 129 */     return this.capture;
/*     */   }
/*     */   
/*     */   public void setStage(Stage paramStage) {
/* 133 */     this.stage = paramStage;
/*     */   }
/*     */ 
/*     */   
/*     */   public Stage getStage() {
/* 138 */     return this.stage;
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gdx\scenes\scene2d\Event.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */