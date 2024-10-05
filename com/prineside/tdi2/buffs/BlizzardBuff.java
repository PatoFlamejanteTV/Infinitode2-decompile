/*    */ package com.prineside.tdi2.buffs;
/*    */ 
/*    */ import com.badlogic.gdx.graphics.g2d.TextureRegion;
/*    */ import com.esotericsoftware.kryo.Kryo;
/*    */ import com.esotericsoftware.kryo.io.Input;
/*    */ import com.esotericsoftware.kryo.io.Output;
/*    */ import com.prineside.tdi2.Buff;
/*    */ import com.prineside.tdi2.BuffProcessor;
/*    */ import com.prineside.tdi2.buffs.processors.BlizzardBuffProcessor;
/*    */ import com.prineside.tdi2.enums.BuffType;
/*    */ import com.prineside.tdi2.managers.AssetManager;
/*    */ import com.prineside.tdi2.utils.REGS;
/*    */ 
/*    */ @REGS
/*    */ public final class BlizzardBuff
/*    */   extends Buff {
/*    */   public float timePassed;
/*    */   public float damageMultiplier;
/*    */   
/*    */   public final void write(Kryo paramKryo, Output paramOutput) {
/* 21 */     super.write(paramKryo, paramOutput);
/* 22 */     paramOutput.writeFloat(this.timePassed);
/* 23 */     paramOutput.writeFloat(this.damageMultiplier);
/*    */   }
/*    */ 
/*    */   
/*    */   public final void read(Kryo paramKryo, Input paramInput) {
/* 28 */     super.read(paramKryo, paramInput);
/* 29 */     this.timePassed = paramInput.readFloat();
/* 30 */     this.damageMultiplier = paramInput.readFloat();
/*    */   }
/*    */   
/*    */   public BlizzardBuff() {
/* 34 */     super(BuffType.BLIZZARD);
/*    */   }
/*    */ 
/*    */   
/*    */   public final BlizzardBuff cpy(float paramFloat) {
/* 39 */     BlizzardBuff blizzardBuff = new BlizzardBuff();
/*    */     
/* 41 */     if ((paramFloat = this.duration * paramFloat) > this.maxDuration) paramFloat = this.maxDuration; 
/* 42 */     blizzardBuff.setup(paramFloat, this.maxDuration, this.damageMultiplier);
/*    */     
/* 44 */     return blizzardBuff;
/*    */   }
/*    */ 
/*    */   
/*    */   @Deprecated
/*    */   public final void setup(float paramFloat1, float paramFloat2) {
/* 50 */     throw new IllegalStateException("Use other constructor");
/*    */   }
/*    */ 
/*    */   
/*    */   public final TextureRegion getHealthBarIcon() {
/* 55 */     return (TextureRegion)(AssetManager.TextureRegions.i()).buffHealthBarIconBlizzard;
/*    */   }
/*    */   
/*    */   public final void setup(float paramFloat1, float paramFloat2, float paramFloat3) {
/* 59 */     super.setup(paramFloat1, paramFloat2);
/* 60 */     this.damageMultiplier = paramFloat3;
/*    */   }
/*    */   
/*    */   public static class BlizzardBuffFactory
/*    */     extends Buff.Factory<BlizzardBuff> {
/*    */     public BuffProcessor<BlizzardBuff> createProcessor() {
/* 66 */       return (BuffProcessor<BlizzardBuff>)new BlizzardBuffProcessor();
/*    */     }
/*    */ 
/*    */     
/*    */     public TextureRegion getHealthBarIcon() {
/* 71 */       return (TextureRegion)(AssetManager.TextureRegions.i()).buffHealthBarIconBlizzard;
/*    */     }
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\buffs\BlizzardBuff.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */