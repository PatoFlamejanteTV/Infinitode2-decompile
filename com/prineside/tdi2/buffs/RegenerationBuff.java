/*    */ package com.prineside.tdi2.buffs;
/*    */ 
/*    */ import com.badlogic.gdx.graphics.g2d.TextureRegion;
/*    */ import com.esotericsoftware.kryo.Kryo;
/*    */ import com.esotericsoftware.kryo.io.Input;
/*    */ import com.esotericsoftware.kryo.io.Output;
/*    */ import com.prineside.tdi2.Buff;
/*    */ import com.prineside.tdi2.BuffProcessor;
/*    */ import com.prineside.tdi2.Enemy;
/*    */ import com.prineside.tdi2.buffs.processors.RegenerationBuffProcessor;
/*    */ import com.prineside.tdi2.enums.BuffType;
/*    */ import com.prineside.tdi2.managers.AssetManager;
/*    */ import com.prineside.tdi2.utils.REGS;
/*    */ 
/*    */ @REGS
/*    */ public final class RegenerationBuff extends Buff {
/* 17 */   public Enemy.EnemyReference issuer = Enemy.EnemyReference.NULL;
/*    */   
/*    */   public float hpPerSecond;
/*    */   
/*    */   public final void write(Kryo paramKryo, Output paramOutput) {
/* 22 */     super.write(paramKryo, paramOutput);
/* 23 */     paramKryo.writeObject(paramOutput, this.issuer);
/* 24 */     paramOutput.writeFloat(this.hpPerSecond);
/*    */   }
/*    */ 
/*    */   
/*    */   public final void read(Kryo paramKryo, Input paramInput) {
/* 29 */     super.read(paramKryo, paramInput);
/* 30 */     this.issuer = (Enemy.EnemyReference)paramKryo.readObject(paramInput, Enemy.EnemyReference.class);
/* 31 */     this.hpPerSecond = paramInput.readFloat();
/*    */   }
/*    */   
/*    */   public RegenerationBuff() {
/* 35 */     super(BuffType.REGENERATION);
/*    */   }
/*    */ 
/*    */   
/*    */   public final RegenerationBuff cpy(float paramFloat) {
/* 40 */     RegenerationBuff regenerationBuff = new RegenerationBuff();
/*    */     
/* 42 */     if ((paramFloat = this.duration * paramFloat) > this.maxDuration) paramFloat = this.maxDuration; 
/* 43 */     regenerationBuff.setup(paramFloat, this.maxDuration, this.hpPerSecond, this.issuer);
/*    */     
/* 45 */     return regenerationBuff;
/*    */   }
/*    */ 
/*    */   
/*    */   @Deprecated
/*    */   public final void setup(float paramFloat1, float paramFloat2) {
/* 51 */     throw new IllegalStateException("Use other constructor");
/*    */   }
/*    */ 
/*    */   
/*    */   public final TextureRegion getHealthBarIcon() {
/* 56 */     return (TextureRegion)(AssetManager.TextureRegions.i()).buffHealthBarIconRegeneration;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public final void setup(float paramFloat1, float paramFloat2, float paramFloat3, Enemy.EnemyReference paramEnemyReference) {
/* 63 */     super.setup(paramFloat1, paramFloat2);
/* 64 */     this.hpPerSecond = paramFloat3;
/* 65 */     this.issuer = paramEnemyReference;
/*    */   }
/*    */   
/*    */   public static class RegenerationBuffFactory
/*    */     extends Buff.Factory<RegenerationBuff> {
/*    */     public BuffProcessor<RegenerationBuff> createProcessor() {
/* 71 */       return (BuffProcessor<RegenerationBuff>)new RegenerationBuffProcessor();
/*    */     }
/*    */ 
/*    */     
/*    */     public TextureRegion getHealthBarIcon() {
/* 76 */       return (TextureRegion)(AssetManager.TextureRegions.i()).buffHealthBarIconRegeneration;
/*    */     }
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\buffs\RegenerationBuff.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */