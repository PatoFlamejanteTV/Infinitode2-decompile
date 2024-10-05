/*     */ package com.badlogic.gdx.ai.steer.limiters;
/*     */ 
/*     */ import com.badlogic.gdx.ai.steer.Limiter;
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
/*     */ public class NullLimiter
/*     */   implements Limiter
/*     */ {
/*  29 */   public static final NullLimiter NEUTRAL_LIMITER = new NullLimiter()
/*     */     {
/*     */       public final float getMaxLinearSpeed()
/*     */       {
/*  33 */         return Float.POSITIVE_INFINITY;
/*     */       }
/*     */ 
/*     */       
/*     */       public final float getMaxLinearAcceleration() {
/*  38 */         return Float.POSITIVE_INFINITY;
/*     */       }
/*     */ 
/*     */       
/*     */       public final float getMaxAngularSpeed() {
/*  43 */         return Float.POSITIVE_INFINITY;
/*     */       }
/*     */ 
/*     */       
/*     */       public final float getMaxAngularAcceleration() {
/*  48 */         return Float.POSITIVE_INFINITY;
/*     */       }
/*     */     };
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public float getMaxLinearSpeed() {
/*  61 */     throw new UnsupportedOperationException();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setMaxLinearSpeed(float paramFloat) {
/*  68 */     throw new UnsupportedOperationException();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public float getMaxLinearAcceleration() {
/*  75 */     throw new UnsupportedOperationException();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setMaxLinearAcceleration(float paramFloat) {
/*  82 */     throw new UnsupportedOperationException();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public float getMaxAngularSpeed() {
/*  89 */     throw new UnsupportedOperationException();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setMaxAngularSpeed(float paramFloat) {
/*  96 */     throw new UnsupportedOperationException();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public float getMaxAngularAcceleration() {
/* 103 */     throw new UnsupportedOperationException();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setMaxAngularAcceleration(float paramFloat) {
/* 110 */     throw new UnsupportedOperationException();
/*     */   }
/*     */ 
/*     */   
/*     */   public float getZeroLinearSpeedThreshold() {
/* 115 */     return 0.001F;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setZeroLinearSpeedThreshold(float paramFloat) {
/* 122 */     throw new UnsupportedOperationException();
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gdx\ai\steer\limiters\NullLimiter.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */