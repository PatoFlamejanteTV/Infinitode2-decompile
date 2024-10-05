/*     */ package com.badlogic.gdx.ai.steer;
/*     */ 
/*     */ import com.badlogic.gdx.ai.utils.Location;
/*     */ import com.badlogic.gdx.math.Vector;
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
/*     */ public class SteerableAdapter<T extends Vector<T>>
/*     */   implements Steerable<T>
/*     */ {
/*     */   public float getZeroLinearSpeedThreshold() {
/*  32 */     return 0.001F;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setZeroLinearSpeedThreshold(float paramFloat) {}
/*     */ 
/*     */   
/*     */   public float getMaxLinearSpeed() {
/*  41 */     return 0.0F;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setMaxLinearSpeed(float paramFloat) {}
/*     */ 
/*     */   
/*     */   public float getMaxLinearAcceleration() {
/*  50 */     return 0.0F;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setMaxLinearAcceleration(float paramFloat) {}
/*     */ 
/*     */   
/*     */   public float getMaxAngularSpeed() {
/*  59 */     return 0.0F;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setMaxAngularSpeed(float paramFloat) {}
/*     */ 
/*     */   
/*     */   public float getMaxAngularAcceleration() {
/*  68 */     return 0.0F;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setMaxAngularAcceleration(float paramFloat) {}
/*     */ 
/*     */   
/*     */   public T getPosition() {
/*  77 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   public float getOrientation() {
/*  82 */     return 0.0F;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setOrientation(float paramFloat) {}
/*     */ 
/*     */   
/*     */   public T getLinearVelocity() {
/*  91 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   public float getAngularVelocity() {
/*  96 */     return 0.0F;
/*     */   }
/*     */ 
/*     */   
/*     */   public float getBoundingRadius() {
/* 101 */     return 0.0F;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isTagged() {
/* 106 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setTagged(boolean paramBoolean) {}
/*     */ 
/*     */   
/*     */   public Location<T> newLocation() {
/* 115 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   public float vectorToAngle(T paramT) {
/* 120 */     return 0.0F;
/*     */   }
/*     */ 
/*     */   
/*     */   public T angleToVector(T paramT, float paramFloat) {
/* 125 */     return null;
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gdx\ai\steer\SteerableAdapter.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */