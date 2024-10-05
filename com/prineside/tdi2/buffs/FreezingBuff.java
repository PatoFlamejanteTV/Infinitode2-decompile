/*    */ package com.prineside.tdi2.buffs;
/*    */ 
/*    */ import com.badlogic.gdx.graphics.g2d.TextureRegion;
/*    */ import com.esotericsoftware.kryo.Kryo;
/*    */ import com.esotericsoftware.kryo.io.Input;
/*    */ import com.esotericsoftware.kryo.io.Output;
/*    */ import com.prineside.tdi2.Buff;
/*    */ import com.prineside.tdi2.BuffProcessor;
/*    */ import com.prineside.tdi2.Tower;
/*    */ import com.prineside.tdi2.buffs.processors.FreezingBuffProcessor;
/*    */ import com.prineside.tdi2.enums.BuffType;
/*    */ import com.prineside.tdi2.managers.AssetManager;
/*    */ import com.prineside.tdi2.utils.REGS;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ @REGS
/*    */ public final class FreezingBuff
/*    */   extends Buff
/*    */ {
/*    */   public float speed;
/*    */   public float maxPercent;
/*    */   public float poisonDurationBonus;
/*    */   public float lightningLengthBonus;
/*    */   public Tower tower;
/*    */   public boolean copyDisabled;
/*    */   
/*    */   public final void write(Kryo paramKryo, Output paramOutput) {
/* 33 */     super.write(paramKryo, paramOutput);
/* 34 */     paramOutput.writeFloat(this.speed);
/* 35 */     paramOutput.writeFloat(this.maxPercent);
/* 36 */     paramOutput.writeFloat(this.poisonDurationBonus);
/* 37 */     paramOutput.writeFloat(this.lightningLengthBonus);
/* 38 */     paramKryo.writeClassAndObject(paramOutput, this.tower);
/* 39 */     paramOutput.writeBoolean(this.copyDisabled);
/*    */   }
/*    */ 
/*    */   
/*    */   public final void read(Kryo paramKryo, Input paramInput) {
/* 44 */     super.read(paramKryo, paramInput);
/* 45 */     this.speed = paramInput.readFloat();
/* 46 */     this.maxPercent = paramInput.readFloat();
/* 47 */     this.poisonDurationBonus = paramInput.readFloat();
/* 48 */     this.lightningLengthBonus = paramInput.readFloat();
/* 49 */     this.tower = (Tower)paramKryo.readClassAndObject(paramInput);
/* 50 */     this.copyDisabled = paramInput.readBoolean();
/*    */   }
/*    */   
/*    */   public FreezingBuff() {
/* 54 */     super(BuffType.FREEZING);
/*    */   }
/*    */ 
/*    */   
/*    */   @Deprecated
/*    */   public final void setup(float paramFloat1, float paramFloat2) {
/* 60 */     throw new IllegalStateException("Use other constructor");
/*    */   }
/*    */ 
/*    */   
/*    */   public final TextureRegion getHealthBarIcon() {
/* 65 */     return (TextureRegion)(AssetManager.TextureRegions.i()).buffHealthBarIconFreezing;
/*    */   }
/*    */   
/*    */   public final void setup(Tower paramTower, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6) {
/* 69 */     super.setup(paramFloat3, paramFloat4);
/* 70 */     this.tower = paramTower;
/* 71 */     this.speed = paramFloat1;
/* 72 */     this.maxPercent = paramFloat2;
/* 73 */     this.poisonDurationBonus = paramFloat5;
/* 74 */     this.lightningLengthBonus = paramFloat6;
/* 75 */     this.copyDisabled = false;
/*    */   }
/*    */ 
/*    */   
/*    */   public final FreezingBuff cpy(float paramFloat) {
/* 80 */     if (this.copyDisabled) return null;
/*    */     
/* 82 */     FreezingBuff freezingBuff = new FreezingBuff();
/*    */     
/* 84 */     if ((paramFloat = this.duration * paramFloat) > this.maxDuration) paramFloat = this.maxDuration; 
/* 85 */     freezingBuff.setup(this.tower, this.speed, this.maxPercent, paramFloat, this.maxDuration, this.poisonDurationBonus, this.lightningLengthBonus);
/*    */     
/* 87 */     return freezingBuff;
/*    */   }
/*    */   
/*    */   public static class FreezingBuffFactory
/*    */     extends Buff.Factory<FreezingBuff> {
/*    */     public BuffProcessor<FreezingBuff> createProcessor() {
/* 93 */       return (BuffProcessor<FreezingBuff>)new FreezingBuffProcessor();
/*    */     }
/*    */ 
/*    */     
/*    */     public TextureRegion getHealthBarIcon() {
/* 98 */       return (TextureRegion)(AssetManager.TextureRegions.i()).buffHealthBarIconFreezing;
/*    */     }
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\buffs\FreezingBuff.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */