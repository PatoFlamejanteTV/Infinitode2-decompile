/*    */ package com.prineside.tdi2.buffs;
/*    */ 
/*    */ import com.badlogic.gdx.graphics.g2d.TextureRegion;
/*    */ import com.esotericsoftware.kryo.Kryo;
/*    */ import com.esotericsoftware.kryo.io.Input;
/*    */ import com.esotericsoftware.kryo.io.Output;
/*    */ import com.prineside.tdi2.Buff;
/*    */ import com.prineside.tdi2.BuffProcessor;
/*    */ import com.prineside.tdi2.buffs.processors.ThrowBackBuffProcessor;
/*    */ import com.prineside.tdi2.enums.BuffType;
/*    */ import com.prineside.tdi2.managers.AssetManager;
/*    */ import com.prineside.tdi2.utils.REGS;
/*    */ 
/*    */ @REGS
/*    */ public final class ThrowBackBuff
/*    */   extends Buff {
/*    */   public int ownerId;
/*    */   public float force;
/*    */   
/*    */   public final void write(Kryo paramKryo, Output paramOutput) {
/* 21 */     super.write(paramKryo, paramOutput);
/* 22 */     paramOutput.writeVarInt(this.ownerId, false);
/* 23 */     paramOutput.writeFloat(this.force);
/*    */   }
/*    */ 
/*    */   
/*    */   public final void read(Kryo paramKryo, Input paramInput) {
/* 28 */     super.read(paramKryo, paramInput);
/* 29 */     this.ownerId = paramInput.readVarInt(false);
/* 30 */     this.force = paramInput.readFloat();
/*    */   }
/*    */ 
/*    */   
/*    */   public final ThrowBackBuff cpy(float paramFloat) {
/* 35 */     ThrowBackBuff throwBackBuff = new ThrowBackBuff();
/*    */     
/* 37 */     if ((paramFloat = this.duration * paramFloat) > this.maxDuration) paramFloat = this.maxDuration; 
/* 38 */     throwBackBuff.setup(this.ownerId, this.force, paramFloat, this.maxDuration);
/*    */     
/* 40 */     return throwBackBuff;
/*    */   }
/*    */   
/*    */   public ThrowBackBuff() {
/* 44 */     super(BuffType.THROW_BACK);
/*    */   }
/*    */   
/*    */   public final void setup(int paramInt, float paramFloat1, float paramFloat2, float paramFloat3) {
/* 48 */     super.setup(paramFloat2, paramFloat3);
/* 49 */     this.ownerId = paramInt;
/* 50 */     this.force = paramFloat1;
/*    */   }
/*    */ 
/*    */   
/*    */   @Deprecated
/*    */   public final void setup(float paramFloat1, float paramFloat2) {
/* 56 */     throw new IllegalStateException("Use other constructor");
/*    */   }
/*    */ 
/*    */   
/*    */   public final TextureRegion getHealthBarIcon() {
/* 61 */     return (TextureRegion)(AssetManager.TextureRegions.i()).buffHealthBarIconBlastThrowBack;
/*    */   }
/*    */   
/*    */   public static class BlastThrowBackBuffFactory
/*    */     extends Buff.Factory<ThrowBackBuff> {
/*    */     public BuffProcessor<ThrowBackBuff> createProcessor() {
/* 67 */       return (BuffProcessor<ThrowBackBuff>)new ThrowBackBuffProcessor();
/*    */     }
/*    */ 
/*    */     
/*    */     public TextureRegion getHealthBarIcon() {
/* 72 */       return (TextureRegion)(AssetManager.TextureRegions.i()).buffHealthBarIconBlastThrowBack;
/*    */     }
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\buffs\ThrowBackBuff.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */