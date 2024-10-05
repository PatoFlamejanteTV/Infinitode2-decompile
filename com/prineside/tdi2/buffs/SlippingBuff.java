/*    */ package com.prineside.tdi2.buffs;
/*    */ 
/*    */ import com.badlogic.gdx.graphics.g2d.TextureRegion;
/*    */ import com.esotericsoftware.kryo.Kryo;
/*    */ import com.esotericsoftware.kryo.io.Input;
/*    */ import com.esotericsoftware.kryo.io.Output;
/*    */ import com.prineside.tdi2.Buff;
/*    */ import com.prineside.tdi2.BuffProcessor;
/*    */ import com.prineside.tdi2.buffs.processors.SlippingBuffProcessor;
/*    */ import com.prineside.tdi2.enums.BuffType;
/*    */ import com.prineside.tdi2.managers.AssetManager;
/*    */ import com.prineside.tdi2.utils.REGS;
/*    */ 
/*    */ @REGS
/*    */ public final class SlippingBuff
/*    */   extends Buff {
/*    */   public static final float SPEED_MULTIPLIER = 0.65F;
/*    */   public static final float THROW_BACK_DISTANCE = 1.2F;
/* 19 */   public float speedMultiplier = 0.65F;
/* 20 */   public float throwBackDistance = 1.2F;
/*    */ 
/*    */   
/*    */   public final void write(Kryo paramKryo, Output paramOutput) {
/* 24 */     super.write(paramKryo, paramOutput);
/* 25 */     paramOutput.writeFloat(this.speedMultiplier);
/* 26 */     paramOutput.writeFloat(this.throwBackDistance);
/*    */   }
/*    */ 
/*    */   
/*    */   public final void read(Kryo paramKryo, Input paramInput) {
/* 31 */     super.read(paramKryo, paramInput);
/* 32 */     this.speedMultiplier = paramInput.readFloat();
/* 33 */     this.throwBackDistance = paramInput.readFloat();
/*    */   }
/*    */   
/*    */   public SlippingBuff() {
/* 37 */     super(BuffType.SLIPPING);
/*    */   }
/*    */ 
/*    */   
/*    */   public final SlippingBuff cpy(float paramFloat) {
/* 42 */     SlippingBuff slippingBuff = new SlippingBuff();
/*    */     
/* 44 */     if ((paramFloat = this.duration * paramFloat) > this.maxDuration) paramFloat = this.maxDuration; 
/* 45 */     slippingBuff.setup(paramFloat, this.maxDuration);
/* 46 */     slippingBuff.speedMultiplier = this.speedMultiplier;
/* 47 */     slippingBuff.throwBackDistance = this.throwBackDistance;
/*    */     
/* 49 */     return slippingBuff;
/*    */   }
/*    */ 
/*    */   
/*    */   public final TextureRegion getHealthBarIcon() {
/* 54 */     return (TextureRegion)(AssetManager.TextureRegions.i()).buffHealthBarIconSlipping;
/*    */   }
/*    */   
/*    */   public static final class SlippingBuffFactory
/*    */     extends Buff.Factory<SlippingBuff> {
/*    */     public final BuffProcessor<SlippingBuff> createProcessor() {
/* 60 */       return (BuffProcessor<SlippingBuff>)new SlippingBuffProcessor();
/*    */     }
/*    */ 
/*    */     
/*    */     public final TextureRegion getHealthBarIcon() {
/* 65 */       return (TextureRegion)(AssetManager.TextureRegions.i()).buffHealthBarIconSlipping;
/*    */     }
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\buffs\SlippingBuff.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */