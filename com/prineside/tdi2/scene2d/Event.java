/*     */ package com.prineside.tdi2.scene2d;
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
/*     */   private Stage a;
/*     */   private Actor b;
/*     */   private Actor c;
/*     */   private boolean d;
/*     */   private boolean e = true;
/*     */   private boolean f;
/*     */   private boolean g;
/*     */   private boolean h;
/*     */   private boolean i;
/*     */   
/*     */   public void handle() {
/*  51 */     this.f = true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void cancel() {
/*  58 */     this.i = true;
/*  59 */     this.g = true;
/*  60 */     this.f = true;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void stop() {
/*  66 */     this.g = true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void halt() {
/*  73 */     this.h = true;
/*  74 */     this.g = true;
/*     */   }
/*     */   
/*     */   public void reset() {
/*  78 */     this.a = null;
/*  79 */     this.b = null;
/*  80 */     this.c = null;
/*  81 */     this.d = false;
/*  82 */     this.e = true;
/*  83 */     this.f = false;
/*  84 */     this.g = false;
/*  85 */     this.h = false;
/*  86 */     this.i = false;
/*     */   }
/*     */ 
/*     */   
/*     */   public Actor getTarget() {
/*  91 */     return this.b;
/*     */   }
/*     */   
/*     */   public void setTarget(Actor paramActor) {
/*  95 */     this.b = paramActor;
/*     */   }
/*     */ 
/*     */   
/*     */   public Actor getListenerActor() {
/* 100 */     return this.c;
/*     */   }
/*     */   
/*     */   public void setListenerActor(Actor paramActor) {
/* 104 */     this.c = paramActor;
/*     */   }
/*     */   
/*     */   public boolean getBubbles() {
/* 108 */     return this.e;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setBubbles(boolean paramBoolean) {
/* 114 */     this.e = paramBoolean;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isHandled() {
/* 119 */     return this.f;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isStopped() {
/* 124 */     return this.g;
/*     */   }
/*     */   
/*     */   public boolean isHalted() {
/* 128 */     return this.h;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isCancelled() {
/* 133 */     return this.i;
/*     */   }
/*     */   
/*     */   public void setCapture(boolean paramBoolean) {
/* 137 */     this.d = paramBoolean;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isCapture() {
/* 143 */     return this.d;
/*     */   }
/*     */   
/*     */   public void setStage(Stage paramStage) {
/* 147 */     this.a = paramStage;
/*     */   }
/*     */ 
/*     */   
/*     */   public Stage getStage() {
/* 152 */     return this.a;
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\scene2d\Event.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */