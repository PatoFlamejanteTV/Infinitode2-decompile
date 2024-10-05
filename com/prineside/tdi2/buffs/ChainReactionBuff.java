/*    */ package com.prineside.tdi2.buffs;
/*    */ 
/*    */ import com.badlogic.gdx.graphics.g2d.TextureRegion;
/*    */ import com.esotericsoftware.kryo.Kryo;
/*    */ import com.esotericsoftware.kryo.io.Input;
/*    */ import com.esotericsoftware.kryo.io.Output;
/*    */ import com.prineside.tdi2.Buff;
/*    */ import com.prineside.tdi2.BuffProcessor;
/*    */ import com.prineside.tdi2.buffs.processors.ChainReactionBuffProcessor;
/*    */ import com.prineside.tdi2.enums.BuffType;
/*    */ import com.prineside.tdi2.managers.AssetManager;
/*    */ import com.prineside.tdi2.utils.REGS;
/*    */ 
/*    */ @REGS
/*    */ public final class ChainReactionBuff
/*    */   extends Buff {
/*    */   public float rangeInTiles;
/*    */   public float chance;
/*    */   public float durationMultiplier;
/*    */   
/*    */   public final void write(Kryo paramKryo, Output paramOutput) {
/* 22 */     super.write(paramKryo, paramOutput);
/* 23 */     paramOutput.writeFloat(this.rangeInTiles);
/* 24 */     paramOutput.writeFloat(this.chance);
/* 25 */     paramOutput.writeFloat(this.durationMultiplier);
/*    */   }
/*    */ 
/*    */   
/*    */   public final void read(Kryo paramKryo, Input paramInput) {
/* 30 */     super.read(paramKryo, paramInput);
/* 31 */     this.rangeInTiles = paramInput.readFloat();
/* 32 */     this.chance = paramInput.readFloat();
/* 33 */     this.durationMultiplier = paramInput.readFloat();
/*    */   }
/*    */   
/*    */   public ChainReactionBuff() {
/* 37 */     super(BuffType.CHAIN_REACTION);
/*    */   }
/*    */ 
/*    */   
/*    */   public final ChainReactionBuff cpy(float paramFloat) {
/* 42 */     ChainReactionBuff chainReactionBuff = new ChainReactionBuff();
/*    */     float f;
/* 44 */     if ((f = this.duration * paramFloat) > this.maxDuration) f = this.maxDuration; 
/* 45 */     chainReactionBuff.setup(f, this.maxDuration, this.chance, this.rangeInTiles, paramFloat);
/*    */     
/* 47 */     return chainReactionBuff;
/*    */   }
/*    */ 
/*    */   
/*    */   @Deprecated
/*    */   public final void setup(float paramFloat1, float paramFloat2) {
/* 53 */     throw new IllegalStateException("Use other constructor");
/*    */   }
/*    */ 
/*    */   
/*    */   public final TextureRegion getHealthBarIcon() {
/* 58 */     return (TextureRegion)(AssetManager.TextureRegions.i()).buffHealthBarIconChainReaction;
/*    */   }
/*    */   
/*    */   public final void setup(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5) {
/* 62 */     super.setup(paramFloat1, paramFloat2);
/*    */     
/* 64 */     this.chance = paramFloat3;
/* 65 */     this.rangeInTiles = paramFloat4;
/* 66 */     this.durationMultiplier = paramFloat5;
/*    */   }
/*    */   
/*    */   public static class ChainReactionBuffFactory
/*    */     extends Buff.Factory<ChainReactionBuff> {
/*    */     public BuffProcessor<ChainReactionBuff> createProcessor() {
/* 72 */       return (BuffProcessor<ChainReactionBuff>)new ChainReactionBuffProcessor();
/*    */     }
/*    */ 
/*    */     
/*    */     public TextureRegion getHealthBarIcon() {
/* 77 */       return (TextureRegion)(AssetManager.TextureRegions.i()).buffHealthBarIconChainReaction;
/*    */     }
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\buffs\ChainReactionBuff.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */