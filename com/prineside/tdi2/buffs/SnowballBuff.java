/*    */ package com.prineside.tdi2.buffs;
/*    */ 
/*    */ import com.badlogic.gdx.graphics.g2d.TextureRegion;
/*    */ import com.prineside.tdi2.Buff;
/*    */ import com.prineside.tdi2.BuffProcessor;
/*    */ import com.prineside.tdi2.buffs.processors.SnowballBuffProcessor;
/*    */ import com.prineside.tdi2.enums.BuffType;
/*    */ import com.prineside.tdi2.managers.AssetManager;
/*    */ import com.prineside.tdi2.utils.REGS;
/*    */ 
/*    */ @REGS
/*    */ public final class SnowballBuff extends Buff {
/*    */   public SnowballBuff() {
/* 14 */     super(BuffType.SNOWBALL);
/*    */   }
/*    */ 
/*    */   
/*    */   public final SnowballBuff cpy(float paramFloat) {
/* 19 */     SnowballBuff snowballBuff = new SnowballBuff();
/*    */     
/* 21 */     if ((paramFloat = this.duration * paramFloat) > this.maxDuration) paramFloat = this.maxDuration; 
/* 22 */     snowballBuff.setup(paramFloat, this.maxDuration);
/*    */     
/* 24 */     return snowballBuff;
/*    */   }
/*    */ 
/*    */   
/*    */   public final TextureRegion getHealthBarIcon() {
/* 29 */     return (TextureRegion)(AssetManager.TextureRegions.i()).buffHealthBarIconSnowball;
/*    */   }
/*    */   
/*    */   public static final class SnowballBuffFactory
/*    */     extends Buff.Factory<SnowballBuff> {
/*    */     public final BuffProcessor<SnowballBuff> createProcessor() {
/* 35 */       return (BuffProcessor<SnowballBuff>)new SnowballBuffProcessor();
/*    */     }
/*    */ 
/*    */     
/*    */     public final TextureRegion getHealthBarIcon() {
/* 40 */       return (TextureRegion)(AssetManager.TextureRegions.i()).buffHealthBarIconSnowball;
/*    */     }
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\buffs\SnowballBuff.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */