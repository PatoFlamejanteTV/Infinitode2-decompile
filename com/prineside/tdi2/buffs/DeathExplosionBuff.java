/*    */ package com.prineside.tdi2.buffs;
/*    */ 
/*    */ import com.badlogic.gdx.graphics.g2d.TextureRegion;
/*    */ import com.esotericsoftware.kryo.Kryo;
/*    */ import com.esotericsoftware.kryo.io.Input;
/*    */ import com.esotericsoftware.kryo.io.Output;
/*    */ import com.prineside.tdi2.Buff;
/*    */ import com.prineside.tdi2.BuffProcessor;
/*    */ import com.prineside.tdi2.Explosion;
/*    */ import com.prineside.tdi2.buffs.processors.DeathExplosionBuffProcessor;
/*    */ import com.prineside.tdi2.enums.BuffType;
/*    */ import com.prineside.tdi2.managers.AssetManager;
/*    */ import com.prineside.tdi2.utils.REGS;
/*    */ 
/*    */ @REGS
/*    */ public final class DeathExplosionBuff
/*    */   extends Buff {
/*    */   public Explosion explosion;
/*    */   
/*    */   public final void write(Kryo paramKryo, Output paramOutput) {
/* 21 */     super.write(paramKryo, paramOutput);
/* 22 */     paramKryo.writeClassAndObject(paramOutput, this.explosion);
/*    */   }
/*    */ 
/*    */   
/*    */   public final void read(Kryo paramKryo, Input paramInput) {
/* 27 */     super.read(paramKryo, paramInput);
/* 28 */     this.explosion = (Explosion)paramKryo.readClassAndObject(paramInput);
/*    */   }
/*    */ 
/*    */   
/*    */   public final DeathExplosionBuff cpy(float paramFloat) {
/* 33 */     if (this.explosion == null) return null; 
/*    */     Explosion explosion;
/* 35 */     if ((explosion = this.explosion.cpy()) == null) return null;
/*    */     
/* 37 */     DeathExplosionBuff deathExplosionBuff = new DeathExplosionBuff();
/*    */     
/* 39 */     if ((paramFloat = this.duration * paramFloat) > this.maxDuration) paramFloat = this.maxDuration; 
/* 40 */     deathExplosionBuff.setup(paramFloat, this.maxDuration, explosion);
/*    */     
/* 42 */     return deathExplosionBuff;
/*    */   }
/*    */   
/*    */   public DeathExplosionBuff() {
/* 46 */     super(BuffType.DEATH_EXPLOSION);
/*    */   }
/*    */ 
/*    */   
/*    */   @Deprecated
/*    */   public final void setup(float paramFloat1, float paramFloat2) {
/* 52 */     throw new IllegalStateException("Use other constructor");
/*    */   }
/*    */ 
/*    */   
/*    */   public final TextureRegion getHealthBarIcon() {
/* 57 */     return (TextureRegion)(AssetManager.TextureRegions.i()).buffHealthBarIconDeathExplosion;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public final DeathExplosionBuff setup(float paramFloat1, float paramFloat2, Explosion paramExplosion) {
/* 64 */     super.setup(paramFloat1, paramFloat2);
/*    */     
/* 66 */     this.explosion = paramExplosion;
/*    */     
/* 68 */     return this;
/*    */   }
/*    */   
/*    */   public static class ExplosionChargeBuffFactory
/*    */     extends Buff.Factory<DeathExplosionBuff> {
/*    */     public BuffProcessor<DeathExplosionBuff> createProcessor() {
/* 74 */       return (BuffProcessor<DeathExplosionBuff>)new DeathExplosionBuffProcessor();
/*    */     }
/*    */ 
/*    */     
/*    */     public TextureRegion getHealthBarIcon() {
/* 79 */       return (TextureRegion)(AssetManager.TextureRegions.i()).buffHealthBarIconDeathExplosion;
/*    */     }
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\buffs\DeathExplosionBuff.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */