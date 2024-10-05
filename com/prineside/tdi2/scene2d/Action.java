/*     */ package com.prineside.tdi2.scene2d;
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
/*     */   protected Actor a;
/*     */   protected Actor b;
/*     */   @Null
/*     */   private Pool c;
/*     */   
/*     */   public abstract boolean act(float paramFloat);
/*     */   
/*     */   public void restart() {}
/*     */   
/*     */   public void setActor(Actor paramActor) {
/*  57 */     this.a = paramActor;
/*  58 */     if (this.b == null) setTarget(paramActor); 
/*  59 */     if (paramActor == null && 
/*  60 */       this.c != null) {
/*  61 */       this.c.free(this);
/*  62 */       this.c = null;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public Actor getActor() {
/*  69 */     return this.a;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setTarget(Actor paramActor) {
/*  75 */     this.b = paramActor;
/*     */   }
/*     */ 
/*     */   
/*     */   public Actor getTarget() {
/*  80 */     return this.b;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void reset() {
/*  90 */     this.a = null;
/*  91 */     this.b = null;
/*  92 */     this.c = null;
/*  93 */     restart();
/*     */   }
/*     */   @Null
/*     */   public Pool getPool() {
/*  97 */     return this.c;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setPool(@Null Pool paramPool) {
/* 104 */     this.c = paramPool;
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


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\scene2d\Action.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */