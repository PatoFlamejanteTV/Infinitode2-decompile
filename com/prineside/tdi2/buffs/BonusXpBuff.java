/*    */ package com.prineside.tdi2.buffs;
/*    */ 
/*    */ import com.badlogic.gdx.graphics.g2d.TextureRegion;
/*    */ import com.esotericsoftware.kryo.Kryo;
/*    */ import com.esotericsoftware.kryo.io.Input;
/*    */ import com.esotericsoftware.kryo.io.Output;
/*    */ import com.prineside.tdi2.Buff;
/*    */ import com.prineside.tdi2.BuffProcessor;
/*    */ import com.prineside.tdi2.Tower;
/*    */ import com.prineside.tdi2.buffs.processors.BonusXpBuffProcessor;
/*    */ import com.prineside.tdi2.enums.BuffType;
/*    */ import com.prineside.tdi2.managers.AssetManager;
/*    */ import com.prineside.tdi2.utils.REGS;
/*    */ 
/*    */ @REGS
/*    */ public final class BonusXpBuff
/*    */   extends Buff {
/*    */   public float bonusXpMultiplier;
/*    */   public Tower issuer;
/*    */   
/*    */   public final void write(Kryo paramKryo, Output paramOutput) {
/* 22 */     super.write(paramKryo, paramOutput);
/* 23 */     paramOutput.writeFloat(this.bonusXpMultiplier);
/* 24 */     paramKryo.writeClassAndObject(paramOutput, this.issuer);
/*    */   }
/*    */ 
/*    */   
/*    */   public final void read(Kryo paramKryo, Input paramInput) {
/* 29 */     super.read(paramKryo, paramInput);
/* 30 */     this.bonusXpMultiplier = paramInput.readFloat();
/* 31 */     this.issuer = (Tower)paramKryo.readClassAndObject(paramInput);
/*    */   }
/*    */   
/*    */   public BonusXpBuff() {
/* 35 */     super(BuffType.BONUS_XP);
/*    */   }
/*    */ 
/*    */   
/*    */   public final BonusXpBuff cpy(float paramFloat) {
/* 40 */     BonusXpBuff bonusXpBuff = new BonusXpBuff();
/*    */     
/* 42 */     if ((paramFloat = this.duration * paramFloat) > this.maxDuration) paramFloat = this.maxDuration; 
/* 43 */     bonusXpBuff.setup(paramFloat, this.maxDuration, this.bonusXpMultiplier, this.issuer);
/*    */     
/* 45 */     return bonusXpBuff;
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
/* 56 */     return (TextureRegion)(AssetManager.TextureRegions.i()).buffHealthBarIconBonusXp;
/*    */   }
/*    */   
/*    */   public final void setup(float paramFloat1, float paramFloat2, float paramFloat3, Tower paramTower) {
/* 60 */     super.setup(paramFloat1, paramFloat2);
/*    */     
/* 62 */     this.bonusXpMultiplier = paramFloat3;
/* 63 */     this.issuer = paramTower;
/*    */   }
/*    */   
/*    */   public static class BonusXpBuffFactory
/*    */     extends Buff.Factory<BonusXpBuff> {
/*    */     public BuffProcessor<BonusXpBuff> createProcessor() {
/* 69 */       return (BuffProcessor<BonusXpBuff>)new BonusXpBuffProcessor();
/*    */     }
/*    */ 
/*    */     
/*    */     public TextureRegion getHealthBarIcon() {
/* 74 */       return (TextureRegion)(AssetManager.TextureRegions.i()).buffHealthBarIconBonusXp;
/*    */     }
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\buffs\BonusXpBuff.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */