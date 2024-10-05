/*    */ package com.badlogic.gdx.graphics.g2d;
/*    */ 
/*    */ import com.badlogic.gdx.utils.Array;
/*    */ import com.badlogic.gdx.utils.Pool;
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
/*    */ public class ParticleEffectPool
/*    */   extends Pool<ParticleEffectPool.PooledEffect>
/*    */ {
/*    */   private final ParticleEffect effect;
/*    */   
/*    */   public ParticleEffectPool(ParticleEffect paramParticleEffect, int paramInt1, int paramInt2) {
/* 27 */     super(paramInt1, paramInt2);
/* 28 */     this.effect = paramParticleEffect;
/*    */   }
/*    */   
/*    */   protected PooledEffect newObject() {
/*    */     PooledEffect pooledEffect;
/* 33 */     (pooledEffect = new PooledEffect(this.effect)).start();
/* 34 */     return pooledEffect;
/*    */   }
/*    */   
/*    */   public void free(PooledEffect paramPooledEffect) {
/* 38 */     super.free(paramPooledEffect);
/*    */     
/* 40 */     paramPooledEffect.reset(false);
/* 41 */     if (paramPooledEffect.xSizeScale != this.effect.xSizeScale || paramPooledEffect.ySizeScale != this.effect.ySizeScale || paramPooledEffect.motionScale != this.effect.motionScale) {
/*    */       
/* 43 */       Array<ParticleEmitter> array1 = paramPooledEffect.getEmitters();
/* 44 */       Array<ParticleEmitter> array2 = this.effect.getEmitters();
/* 45 */       for (byte b = 0; b < array1.size; b++) {
/* 46 */         ParticleEmitter particleEmitter1 = (ParticleEmitter)array1.get(b);
/* 47 */         ParticleEmitter particleEmitter2 = (ParticleEmitter)array2.get(b);
/* 48 */         particleEmitter1.matchSize(particleEmitter2);
/* 49 */         particleEmitter1.matchMotion(particleEmitter2);
/*    */       } 
/* 51 */       paramPooledEffect.xSizeScale = this.effect.xSizeScale;
/* 52 */       paramPooledEffect.ySizeScale = this.effect.ySizeScale;
/* 53 */       paramPooledEffect.motionScale = this.effect.motionScale;
/*    */     } 
/*    */   }
/*    */   
/*    */   public class PooledEffect extends ParticleEffect {
/*    */     PooledEffect(ParticleEffect param1ParticleEffect) {
/* 59 */       super(param1ParticleEffect);
/*    */     }
/*    */     
/*    */     public void free() {
/* 63 */       ParticleEffectPool.this.free(this);
/*    */     }
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gdx\graphics\g2d\ParticleEffectPool.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */