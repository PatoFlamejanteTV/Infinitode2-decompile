/*    */ package com.prineside.tdi2.buffs;
/*    */ 
/*    */ import com.badlogic.gdx.graphics.g2d.TextureRegion;
/*    */ import com.prineside.tdi2.Buff;
/*    */ import com.prineside.tdi2.BuffProcessor;
/*    */ import com.prineside.tdi2.buffs.processors.NoBonusSystemPointsBuffProcessor;
/*    */ import com.prineside.tdi2.enums.BuffType;
/*    */ import com.prineside.tdi2.managers.AssetManager;
/*    */ import com.prineside.tdi2.utils.REGS;
/*    */ 
/*    */ @REGS
/*    */ public final class NoBonusSystemPointsBuff extends Buff {
/*    */   public NoBonusSystemPointsBuff() {
/* 14 */     super(BuffType.NO_BONUS_SYSTEM_POINTS);
/*    */   }
/*    */ 
/*    */   
/*    */   public final SlippingBuff cpy(float paramFloat) {
/* 19 */     return null;
/*    */   }
/*    */ 
/*    */   
/*    */   public final TextureRegion getHealthBarIcon() {
/* 24 */     return (TextureRegion)(AssetManager.TextureRegions.i()).buffHealthBarIconNoBonusSystemPoints;
/*    */   }
/*    */   
/*    */   public static final class NoBonusSystemPointsBuffFactory
/*    */     extends Buff.Factory<NoBonusSystemPointsBuff> {
/*    */     public final BuffProcessor<NoBonusSystemPointsBuff> createProcessor() {
/* 30 */       return (BuffProcessor<NoBonusSystemPointsBuff>)new NoBonusSystemPointsBuffProcessor();
/*    */     }
/*    */ 
/*    */     
/*    */     public final TextureRegion getHealthBarIcon() {
/* 35 */       return (TextureRegion)(AssetManager.TextureRegions.i()).buffHealthBarIconNoBonusSystemPoints;
/*    */     }
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\buffs\NoBonusSystemPointsBuff.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */