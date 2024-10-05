/*    */ package com.prineside.tdi2.buffs;
/*    */ 
/*    */ import com.badlogic.gdx.graphics.g2d.TextureRegion;
/*    */ import com.esotericsoftware.kryo.Kryo;
/*    */ import com.esotericsoftware.kryo.io.Input;
/*    */ import com.esotericsoftware.kryo.io.Output;
/*    */ import com.prineside.tdi2.Buff;
/*    */ import com.prineside.tdi2.BuffProcessor;
/*    */ import com.prineside.tdi2.buffs.processors.StunBuffProcessor;
/*    */ import com.prineside.tdi2.enums.BuffType;
/*    */ import com.prineside.tdi2.managers.AssetManager;
/*    */ import com.prineside.tdi2.utils.REGS;
/*    */ 
/*    */ @REGS
/*    */ public final class StunBuff extends Buff {
/*    */   public static final int MAX_STUNS_IN_TOTAL = 6;
/*    */   public static final float FULL_IMMUNITY_COEFF = 1.0F;
/*    */   public static final float FULL_IMMUNITY_TILES = 3.0F;
/*    */   public static final float IMMUNITY_DROP_PER_TILE = 0.2F;
/* 20 */   public static final float[] STUN_DURATION_BY_STUN_COUNT = new float[] { 1.0F, 0.75F, 0.5F, 0.25F };
/*    */ 
/*    */   
/* 23 */   public static final float[] STUN_CHANCE_PENALTY_SAME_TOWER = new float[] { 1.0F, 0.8F, 0.64F, 0.512F, 0.4096F };
/*    */ 
/*    */   
/*    */   public int issuerId;
/*    */ 
/*    */   
/*    */   public boolean copyDisabled;
/*    */ 
/*    */   
/*    */   public final void write(Kryo paramKryo, Output paramOutput) {
/* 33 */     super.write(paramKryo, paramOutput);
/* 34 */     paramOutput.writeVarInt(this.issuerId, true);
/* 35 */     paramOutput.writeBoolean(this.copyDisabled);
/*    */   }
/*    */ 
/*    */   
/*    */   public final void read(Kryo paramKryo, Input paramInput) {
/* 40 */     super.read(paramKryo, paramInput);
/* 41 */     this.issuerId = paramInput.readVarInt(true);
/* 42 */     this.copyDisabled = paramInput.readBoolean();
/*    */   }
/*    */ 
/*    */   
/*    */   public StunBuff() {
/* 47 */     super(BuffType.STUN);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public final void setup(float paramFloat1, float paramFloat2, int paramInt) {
/* 54 */     super.setup(paramFloat1, paramFloat2);
/* 55 */     this.issuerId = paramInt;
/* 56 */     this.copyDisabled = false;
/*    */   }
/*    */ 
/*    */   
/*    */   @Deprecated
/*    */   public final void setup(float paramFloat1, float paramFloat2) {
/* 62 */     throw new IllegalStateException("Use other constructor");
/*    */   }
/*    */ 
/*    */   
/*    */   public final TextureRegion getHealthBarIcon() {
/* 67 */     return (TextureRegion)(AssetManager.TextureRegions.i()).buffHealthBarIconStun;
/*    */   }
/*    */ 
/*    */   
/*    */   public final StunBuff cpy(float paramFloat) {
/* 72 */     if (this.copyDisabled) return null;
/*    */     
/* 74 */     StunBuff stunBuff = new StunBuff();
/*    */     
/* 76 */     if ((paramFloat = this.duration * paramFloat) > this.maxDuration) paramFloat = this.maxDuration; 
/* 77 */     stunBuff.setup(paramFloat, this.maxDuration, this.issuerId);
/*    */     
/* 79 */     return stunBuff;
/*    */   }
/*    */   
/*    */   public static class StunBuffFactory
/*    */     extends Buff.Factory<StunBuff> {
/*    */     public BuffProcessor<StunBuff> createProcessor() {
/* 85 */       return (BuffProcessor<StunBuff>)new StunBuffProcessor();
/*    */     }
/*    */ 
/*    */     
/*    */     public TextureRegion getHealthBarIcon() {
/* 90 */       return (TextureRegion)(AssetManager.TextureRegions.i()).buffHealthBarIconStun;
/*    */     }
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\buffs\StunBuff.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */