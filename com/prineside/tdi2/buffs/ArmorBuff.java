/*    */ package com.prineside.tdi2.buffs;
/*    */ 
/*    */ import com.badlogic.gdx.graphics.g2d.TextureRegion;
/*    */ import com.prineside.tdi2.Buff;
/*    */ import com.prineside.tdi2.BuffProcessor;
/*    */ import com.prineside.tdi2.buffs.processors.ArmorBuffProcessor;
/*    */ import com.prineside.tdi2.enums.BuffType;
/*    */ import com.prineside.tdi2.managers.AssetManager;
/*    */ import com.prineside.tdi2.utils.REGS;
/*    */ 
/*    */ @REGS
/*    */ public final class ArmorBuff extends Buff {
/*    */   public ArmorBuff() {
/* 14 */     super(BuffType.ARMOR);
/*    */   }
/*    */ 
/*    */   
/*    */   public final ArmorBuff cpy(float paramFloat) {
/* 19 */     ArmorBuff armorBuff = new ArmorBuff();
/*    */     
/* 21 */     if ((paramFloat = this.duration * paramFloat) > this.maxDuration) paramFloat = this.maxDuration; 
/* 22 */     armorBuff.setup(paramFloat, this.maxDuration);
/*    */     
/* 24 */     return armorBuff;
/*    */   }
/*    */ 
/*    */   
/*    */   public final TextureRegion getHealthBarIcon() {
/* 29 */     return (TextureRegion)(AssetManager.TextureRegions.i()).buffHealthBarIconArmor;
/*    */   }
/*    */   
/*    */   public static class ArmorBuffFactory
/*    */     extends Buff.Factory<ArmorBuff> {
/*    */     public BuffProcessor<ArmorBuff> createProcessor() {
/* 35 */       return (BuffProcessor<ArmorBuff>)new ArmorBuffProcessor();
/*    */     }
/*    */ 
/*    */     
/*    */     public TextureRegion getHealthBarIcon() {
/* 40 */       return (TextureRegion)(AssetManager.TextureRegions.i()).buffHealthBarIconArmor;
/*    */     }
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\buffs\ArmorBuff.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */