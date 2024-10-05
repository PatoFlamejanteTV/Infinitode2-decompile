/*    */ package com.prineside.tdi2.buffs;
/*    */ 
/*    */ import com.badlogic.gdx.graphics.g2d.TextureRegion;
/*    */ import com.esotericsoftware.kryo.Kryo;
/*    */ import com.esotericsoftware.kryo.io.Input;
/*    */ import com.esotericsoftware.kryo.io.Output;
/*    */ import com.prineside.tdi2.Ability;
/*    */ import com.prineside.tdi2.Buff;
/*    */ import com.prineside.tdi2.BuffProcessor;
/*    */ import com.prineside.tdi2.Tower;
/*    */ import com.prineside.tdi2.buffs.processors.BurnBuffProcessor;
/*    */ import com.prineside.tdi2.enums.BuffType;
/*    */ import com.prineside.tdi2.managers.AssetManager;
/*    */ import com.prineside.tdi2.utils.REGS;
/*    */ 
/*    */ @REGS
/*    */ public final class BurnBuff
/*    */   extends Buff {
/*    */   public Tower tower;
/*    */   public float fireDamage;
/*    */   public float bonusDamagePerEnemyNearby;
/*    */   public Ability fromAbility;
/*    */   
/*    */   public final void write(Kryo paramKryo, Output paramOutput) {
/* 25 */     super.write(paramKryo, paramOutput);
/* 26 */     paramKryo.writeClassAndObject(paramOutput, this.tower);
/* 27 */     paramOutput.writeFloat(this.fireDamage);
/* 28 */     paramOutput.writeFloat(this.bonusDamagePerEnemyNearby);
/* 29 */     paramKryo.writeClassAndObject(paramOutput, this.fromAbility);
/*    */   }
/*    */ 
/*    */   
/*    */   public final void read(Kryo paramKryo, Input paramInput) {
/* 34 */     super.read(paramKryo, paramInput);
/* 35 */     this.tower = (Tower)paramKryo.readClassAndObject(paramInput);
/* 36 */     this.fireDamage = paramInput.readFloat();
/* 37 */     this.bonusDamagePerEnemyNearby = paramInput.readFloat();
/* 38 */     this.fromAbility = (Ability)paramKryo.readClassAndObject(paramInput);
/*    */   }
/*    */   
/*    */   public BurnBuff() {
/* 42 */     super(BuffType.BURN);
/*    */   }
/*    */ 
/*    */   
/*    */   @Deprecated
/*    */   public final void setup(float paramFloat1, float paramFloat2) {
/* 48 */     throw new IllegalStateException("Use other constructor");
/*    */   }
/*    */ 
/*    */   
/*    */   public final TextureRegion getHealthBarIcon() {
/* 53 */     return (TextureRegion)(AssetManager.TextureRegions.i()).buffHealthBarIconBurn;
/*    */   }
/*    */   
/*    */   public final void setup(Tower paramTower, float paramFloat1, float paramFloat2, float paramFloat3, Ability paramAbility) {
/* 57 */     super.setup(paramFloat1, paramFloat2);
/* 58 */     this.tower = paramTower;
/* 59 */     this.fireDamage = paramFloat3;
/* 60 */     this.fromAbility = paramAbility;
/*    */   }
/*    */ 
/*    */   
/*    */   public final BurnBuff cpy(float paramFloat) {
/* 65 */     BurnBuff burnBuff = new BurnBuff();
/*    */     
/* 67 */     if ((paramFloat = this.duration * paramFloat) > this.maxDuration) paramFloat = this.maxDuration; 
/* 68 */     burnBuff.setup(this.tower, paramFloat, this.maxDuration, this.fireDamage, this.fromAbility);
/* 69 */     burnBuff.bonusDamagePerEnemyNearby = this.bonusDamagePerEnemyNearby;
/* 70 */     return burnBuff;
/*    */   }
/*    */   
/*    */   public static class BurnBuffFactory
/*    */     extends Buff.Factory<BurnBuff> {
/*    */     public BuffProcessor<BurnBuff> createProcessor() {
/* 76 */       return (BuffProcessor<BurnBuff>)new BurnBuffProcessor();
/*    */     }
/*    */ 
/*    */     
/*    */     public TextureRegion getHealthBarIcon() {
/* 81 */       return (TextureRegion)(AssetManager.TextureRegions.i()).buffHealthBarIconBurn;
/*    */     }
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\buffs\BurnBuff.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */