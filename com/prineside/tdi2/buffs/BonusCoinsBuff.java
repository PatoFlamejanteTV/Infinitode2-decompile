/*    */ package com.prineside.tdi2.buffs;
/*    */ 
/*    */ import com.badlogic.gdx.graphics.g2d.TextureRegion;
/*    */ import com.esotericsoftware.kryo.Kryo;
/*    */ import com.esotericsoftware.kryo.io.Input;
/*    */ import com.esotericsoftware.kryo.io.Output;
/*    */ import com.prineside.tdi2.Buff;
/*    */ import com.prineside.tdi2.BuffProcessor;
/*    */ import com.prineside.tdi2.Tower;
/*    */ import com.prineside.tdi2.buffs.processors.BonusCoinsBuffProcessor;
/*    */ import com.prineside.tdi2.enums.BuffType;
/*    */ import com.prineside.tdi2.managers.AssetManager;
/*    */ import com.prineside.tdi2.utils.REGS;
/*    */ 
/*    */ @REGS
/*    */ public final class BonusCoinsBuff
/*    */   extends Buff {
/*    */   public float bonusCoinsMultiplier;
/*    */   public Tower issuer;
/*    */   
/*    */   public final void write(Kryo paramKryo, Output paramOutput) {
/* 22 */     super.write(paramKryo, paramOutput);
/* 23 */     paramOutput.writeFloat(this.bonusCoinsMultiplier);
/* 24 */     paramKryo.writeClassAndObject(paramOutput, this.issuer);
/*    */   }
/*    */ 
/*    */   
/*    */   public final void read(Kryo paramKryo, Input paramInput) {
/* 29 */     super.read(paramKryo, paramInput);
/* 30 */     this.bonusCoinsMultiplier = paramInput.readFloat();
/* 31 */     this.issuer = (Tower)paramKryo.readClassAndObject(paramInput);
/*    */   }
/*    */   
/*    */   public BonusCoinsBuff() {
/* 35 */     super(BuffType.BONUS_COINS);
/*    */   }
/*    */ 
/*    */   
/*    */   public final BonusCoinsBuff cpy(float paramFloat) {
/* 40 */     BonusCoinsBuff bonusCoinsBuff = new BonusCoinsBuff();
/*    */ 
/*    */     
/* 43 */     if ((paramFloat = this.duration * paramFloat) > this.maxDuration) paramFloat = this.maxDuration; 
/* 44 */     bonusCoinsBuff.setup(paramFloat, this.maxDuration, this.bonusCoinsMultiplier, this.issuer);
/*    */     
/* 46 */     return bonusCoinsBuff;
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
/* 57 */     return (TextureRegion)(AssetManager.TextureRegions.i()).buffHealthBarIconBonusCoins;
/*    */   }
/*    */   
/*    */   public final void setup(float paramFloat1, float paramFloat2, float paramFloat3, Tower paramTower) {
/* 61 */     super.setup(paramFloat1, paramFloat2);
/*    */     
/* 63 */     this.bonusCoinsMultiplier = paramFloat3;
/* 64 */     this.issuer = paramTower;
/*    */   }
/*    */   
/*    */   public static class BonusCoinsBuffFactory
/*    */     extends Buff.Factory<BonusCoinsBuff> {
/*    */     public BuffProcessor<BonusCoinsBuff> createProcessor() {
/* 70 */       return (BuffProcessor<BonusCoinsBuff>)new BonusCoinsBuffProcessor();
/*    */     }
/*    */ 
/*    */     
/*    */     public TextureRegion getHealthBarIcon() {
/* 75 */       return (TextureRegion)(AssetManager.TextureRegions.i()).buffHealthBarIconBonusCoins;
/*    */     }
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\buffs\BonusCoinsBuff.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */