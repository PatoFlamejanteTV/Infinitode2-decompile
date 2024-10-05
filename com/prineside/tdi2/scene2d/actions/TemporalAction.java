/*     */ package com.prineside.tdi2.scene2d.actions;
/*     */ 
/*     */ import com.badlogic.gdx.math.Interpolation;
/*     */ import com.badlogic.gdx.utils.Null;
/*     */ import com.badlogic.gdx.utils.Pool;
/*     */ import com.prineside.tdi2.scene2d.Action;
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
/*     */ public abstract class TemporalAction
/*     */   extends Action
/*     */ {
/*     */   private float c;
/*     */   private float d;
/*     */   @Null
/*     */   private Interpolation e;
/*     */   private boolean f;
/*     */   private boolean g;
/*     */   private boolean h;
/*     */   
/*     */   public TemporalAction() {}
/*     */   
/*     */   public TemporalAction(float paramFloat) {
/*  35 */     this.c = paramFloat;
/*     */   }
/*     */   
/*     */   public TemporalAction(float paramFloat, @Null Interpolation paramInterpolation) {
/*  39 */     this.c = paramFloat;
/*  40 */     this.e = paramInterpolation;
/*     */   }
/*     */   
/*     */   public boolean act(float paramFloat) {
/*  44 */     if (this.h) return true; 
/*  45 */     Pool pool = getPool();
/*  46 */     setPool(null);
/*     */     try {
/*  48 */       if (!this.g) {
/*  49 */         a();
/*  50 */         this.g = true;
/*     */       } 
/*  52 */       this.d += paramFloat;
/*  53 */       this.h = (this.d >= this.c);
/*  54 */       paramFloat = this.h ? 1.0F : (this.d / this.c);
/*  55 */       if (this.e != null) paramFloat = this.e.apply(paramFloat); 
/*  56 */       a(this.f ? (1.0F - paramFloat) : paramFloat);
/*     */       
/*  58 */       return this.h;
/*     */     } finally {
/*  60 */       setPool(pool);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void a() {}
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected abstract void a(float paramFloat);
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void finish() {
/*  80 */     this.d = this.c;
/*     */   }
/*     */   
/*     */   public void restart() {
/*  84 */     this.d = 0.0F;
/*  85 */     this.g = false;
/*  86 */     this.h = false;
/*     */   }
/*     */   
/*     */   public void reset() {
/*  90 */     super.reset();
/*  91 */     this.f = false;
/*  92 */     this.e = null;
/*     */   }
/*     */ 
/*     */   
/*     */   public float getTime() {
/*  97 */     return this.d;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setTime(float paramFloat) {
/* 102 */     this.d = paramFloat;
/*     */   }
/*     */   
/*     */   public float getDuration() {
/* 106 */     return this.c;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setDuration(float paramFloat) {
/* 111 */     this.c = paramFloat;
/*     */   }
/*     */   @Null
/*     */   public Interpolation getInterpolation() {
/* 115 */     return this.e;
/*     */   }
/*     */   
/*     */   public void setInterpolation(@Null Interpolation paramInterpolation) {
/* 119 */     this.e = paramInterpolation;
/*     */   }
/*     */   
/*     */   public boolean isReverse() {
/* 123 */     return this.f;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setReverse(boolean paramBoolean) {
/* 128 */     this.f = paramBoolean;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isComplete() {
/* 133 */     return this.h;
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\scene2d\actions\TemporalAction.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */