/*    */ package com.badlogic.gdx.ai.steer.behaviors;
/*    */ 
/*    */ import com.badlogic.gdx.ai.steer.Limiter;
/*    */ import com.badlogic.gdx.ai.steer.Steerable;
/*    */ import com.badlogic.gdx.ai.steer.SteeringBehavior;
/*    */ import com.badlogic.gdx.math.Vector;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class Evade<T extends Vector<T>>
/*    */   extends Pursue<T>
/*    */ {
/*    */   public Evade(Steerable<T> paramSteerable1, Steerable<T> paramSteerable2) {
/* 35 */     this(paramSteerable1, paramSteerable2, 1.0F);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public Evade(Steerable<T> paramSteerable1, Steerable<T> paramSteerable2, float paramFloat) {
/* 44 */     super(paramSteerable1, paramSteerable2, paramFloat);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   protected float getActualMaxLinearAcceleration() {
/* 50 */     return -getActualLimiter().getMaxLinearAcceleration();
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public Evade<T> setOwner(Steerable<T> paramSteerable) {
/* 59 */     this.owner = paramSteerable;
/* 60 */     return this;
/*    */   }
/*    */ 
/*    */   
/*    */   public Evade<T> setEnabled(boolean paramBoolean) {
/* 65 */     this.enabled = paramBoolean;
/* 66 */     return this;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public Evade<T> setLimiter(Limiter paramLimiter) {
/* 73 */     this.limiter = paramLimiter;
/* 74 */     return this;
/*    */   }
/*    */ 
/*    */   
/*    */   public Evade<T> setTarget(Steerable<T> paramSteerable) {
/* 79 */     this.target = paramSteerable;
/* 80 */     return this;
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gdx\ai\steer\behaviors\Evade.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */