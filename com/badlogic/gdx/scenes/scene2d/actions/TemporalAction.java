/*     */ package com.badlogic.gdx.scenes.scene2d.actions;
/*     */ 
/*     */ import com.badlogic.gdx.math.Interpolation;
/*     */ import com.badlogic.gdx.scenes.scene2d.Action;
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
/*     */ public abstract class TemporalAction
/*     */   extends Action
/*     */ {
/*     */   private float duration;
/*     */   private float time;
/*     */   @Null
/*     */   private Interpolation interpolation;
/*     */   private boolean reverse;
/*     */   private boolean began;
/*     */   private boolean complete;
/*     */   
/*     */   public TemporalAction() {}
/*     */   
/*     */   public TemporalAction(float paramFloat) {
/*  35 */     this.duration = paramFloat;
/*     */   }
/*     */   
/*     */   public TemporalAction(float paramFloat, @Null Interpolation paramInterpolation) {
/*  39 */     this.duration = paramFloat;
/*  40 */     this.interpolation = paramInterpolation;
/*     */   }
/*     */   
/*     */   public boolean act(float paramFloat) {
/*  44 */     if (this.complete) return true; 
/*  45 */     Pool pool = getPool();
/*  46 */     setPool(null);
/*     */     try {
/*  48 */       if (!this.began) {
/*  49 */         begin();
/*  50 */         this.began = true;
/*     */       } 
/*  52 */       this.time += paramFloat;
/*  53 */       this.complete = (this.time >= this.duration);
/*  54 */       paramFloat = this.complete ? 1.0F : (this.time / this.duration);
/*  55 */       if (this.interpolation != null) paramFloat = this.interpolation.apply(paramFloat); 
/*  56 */       update(this.reverse ? (1.0F - paramFloat) : paramFloat);
/*  57 */       if (this.complete) end(); 
/*  58 */       return this.complete;
/*     */     } finally {
/*  60 */       setPool(pool);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void begin() {}
/*     */ 
/*     */ 
/*     */   
/*     */   protected void end() {}
/*     */ 
/*     */ 
/*     */   
/*     */   protected abstract void update(float paramFloat);
/*     */ 
/*     */ 
/*     */   
/*     */   public void finish() {
/*  80 */     this.time = this.duration;
/*     */   }
/*     */   
/*     */   public void restart() {
/*  84 */     this.time = 0.0F;
/*  85 */     this.began = false;
/*  86 */     this.complete = false;
/*     */   }
/*     */   
/*     */   public void reset() {
/*  90 */     super.reset();
/*  91 */     this.reverse = false;
/*  92 */     this.interpolation = null;
/*     */   }
/*     */ 
/*     */   
/*     */   public float getTime() {
/*  97 */     return this.time;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setTime(float paramFloat) {
/* 102 */     this.time = paramFloat;
/*     */   }
/*     */   
/*     */   public float getDuration() {
/* 106 */     return this.duration;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setDuration(float paramFloat) {
/* 111 */     this.duration = paramFloat;
/*     */   }
/*     */   @Null
/*     */   public Interpolation getInterpolation() {
/* 115 */     return this.interpolation;
/*     */   }
/*     */   
/*     */   public void setInterpolation(@Null Interpolation paramInterpolation) {
/* 119 */     this.interpolation = paramInterpolation;
/*     */   }
/*     */   
/*     */   public boolean isReverse() {
/* 123 */     return this.reverse;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setReverse(boolean paramBoolean) {
/* 128 */     this.reverse = paramBoolean;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isComplete() {
/* 133 */     return this.complete;
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gdx\scenes\scene2d\actions\TemporalAction.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */