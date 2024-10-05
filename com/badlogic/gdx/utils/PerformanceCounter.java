/*     */ package com.badlogic.gdx.utils;
/*     */ 
/*     */ import com.badlogic.gdx.Gdx;
/*     */ import com.badlogic.gdx.math.FloatCounter;
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
/*     */ public class PerformanceCounter
/*     */ {
/*     */   private static final float nano2seconds = 1.0E-9F;
/*  31 */   private long startTime = 0L;
/*  32 */   private long lastTick = 0L;
/*     */ 
/*     */   
/*     */   public final FloatCounter time;
/*     */ 
/*     */   
/*     */   public final FloatCounter load;
/*     */   
/*     */   public final String name;
/*     */   
/*  42 */   public float current = 0.0F;
/*     */   
/*     */   public boolean valid = false;
/*     */   
/*     */   public PerformanceCounter(String paramString) {
/*  47 */     this(paramString, 5);
/*     */   }
/*     */   
/*     */   public PerformanceCounter(String paramString, int paramInt) {
/*  51 */     this.name = paramString;
/*  52 */     this.time = new FloatCounter(paramInt);
/*  53 */     this.load = new FloatCounter(1);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void tick() {
/*  59 */     long l = TimeUtils.nanoTime();
/*  60 */     if (this.lastTick > 0L) tick((float)(l - this.lastTick) * 1.0E-9F); 
/*  61 */     this.lastTick = l;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void tick(float paramFloat) {
/*  67 */     if (!this.valid) {
/*  68 */       Gdx.app.error("PerformanceCounter", "Invalid data, check if you called PerformanceCounter#stop()");
/*     */       
/*     */       return;
/*     */     } 
/*  72 */     this.time.put(this.current);
/*     */     
/*  74 */     float f = (paramFloat == 0.0F) ? 0.0F : (this.current / paramFloat);
/*  75 */     this.load.put((paramFloat > 1.0F) ? f : (paramFloat * f + (1.0F - paramFloat) * this.load.latest));
/*     */     
/*  77 */     this.current = 0.0F;
/*  78 */     this.valid = false;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void start() {
/*  84 */     this.startTime = TimeUtils.nanoTime();
/*  85 */     this.valid = false;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void stop() {
/*  91 */     if (this.startTime > 0L) {
/*  92 */       this.current += (float)(TimeUtils.nanoTime() - this.startTime) * 1.0E-9F;
/*  93 */       this.startTime = 0L;
/*  94 */       this.valid = true;
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void reset() {
/* 100 */     this.time.reset();
/* 101 */     this.load.reset();
/* 102 */     this.startTime = 0L;
/* 103 */     this.lastTick = 0L;
/* 104 */     this.current = 0.0F;
/* 105 */     this.valid = false;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/* 111 */     StringBuilder stringBuilder = new StringBuilder();
/* 112 */     return toString(stringBuilder).toString();
/*     */   }
/*     */ 
/*     */   
/*     */   public StringBuilder toString(StringBuilder paramStringBuilder) {
/* 117 */     paramStringBuilder.append(this.name).append(": [time: ").append(this.time.value).append(", load: ").append(this.load.value).append("]");
/* 118 */     return paramStringBuilder;
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gd\\utils\PerformanceCounter.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */