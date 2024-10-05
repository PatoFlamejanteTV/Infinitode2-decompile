/*    */ package com.prineside.tdi2.buffs;
/*    */ 
/*    */ import com.badlogic.gdx.graphics.g2d.TextureRegion;
/*    */ import com.prineside.tdi2.Buff;
/*    */ import com.prineside.tdi2.BuffProcessor;
/*    */ import com.prineside.tdi2.buffs.processors.NoDamageBuffProcessor;
/*    */ import com.prineside.tdi2.enums.BuffType;
/*    */ import com.prineside.tdi2.managers.AssetManager;
/*    */ import com.prineside.tdi2.utils.REGS;
/*    */ 
/*    */ @REGS
/*    */ public final class NoDamageBuff extends Buff {
/*    */   public NoDamageBuff() {
/* 14 */     super(BuffType.NO_DAMAGE);
/*    */   }
/*    */ 
/*    */   
/*    */   public final SlippingBuff cpy(float paramFloat) {
/* 19 */     return null;
/*    */   }
/*    */ 
/*    */   
/*    */   public final TextureRegion getHealthBarIcon() {
/* 24 */     return (TextureRegion)(AssetManager.TextureRegions.i()).buffHealthBarIconNoDamage;
/*    */   }
/*    */   
/*    */   public static final class NoDamageBuffFactory
/*    */     extends Buff.Factory<NoDamageBuff> {
/*    */     public final BuffProcessor<NoDamageBuff> createProcessor() {
/* 30 */       return (BuffProcessor<NoDamageBuff>)new NoDamageBuffProcessor();
/*    */     }
/*    */ 
/*    */     
/*    */     public final TextureRegion getHealthBarIcon() {
/* 35 */       return (TextureRegion)(AssetManager.TextureRegions.i()).buffHealthBarIconNoDamage;
/*    */     }
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\buffs\NoDamageBuff.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */