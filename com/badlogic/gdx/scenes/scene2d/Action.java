/*     */ package com.badlogic.gdx.scenes.scene2d;
/*     */ 
/*     */ import com.badlogic.gdx.utils.Null;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public abstract class Action
/*     */   implements Pool.Poolable
/*     */ {
/*     */   protected Actor actor;
/*     */   protected Actor target;
/*     */   @Null
/*     */   private Pool pool;
/*     */   
/*     */   public abstract boolean act(float paramFloat);
/*     */   
/*     */   public void restart() {}
/*     */   
/*     */   public void setActor(Actor paramActor) {
/*  57 */     this.actor = paramActor;
/*  58 */     if (this.target == null) setTarget(paramActor); 
/*  59 */     if (paramActor == null && 
/*  60 */       this.pool != null) {
/*  61 */       this.pool.free(this);
/*  62 */       this.pool = null;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public Actor getActor() {
/*  69 */     return this.actor;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setTarget(Actor paramActor) {
/*  75 */     this.target = paramActor;
/*     */   }
/*     */ 
/*     */   
/*     */   public Actor getTarget() {
/*  80 */     return this.target;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void reset() {
/*  90 */     this.actor = null;
/*  91 */     this.target = null;
/*  92 */     this.pool = null;
/*  93 */     restart();
/*     */   }
/*     */   @Null
/*     */   public Pool getPool() {
/*  97 */     return this.pool;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setPool(@Null Pool paramPool) {
/* 104 */     this.pool = paramPool;
/*     */   }
/*     */   
/*     */   public String toString() {
/*     */     String str;
/*     */     int i;
/* 110 */     if ((i = (str = getClass().getName()).lastIndexOf('.')) != -1) str = str.substring(i + 1); 
/* 111 */     if (str.endsWith("Action")) str = str.substring(0, str.length() - 6); 
/* 112 */     return str;
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gdx\scenes\scene2d\Action.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */