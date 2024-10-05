/*    */ package com.prineside.tdi2.enums;
/*    */ 
/*    */ import com.prineside.tdi2.buffs.ArmorBuff;
/*    */ import com.prineside.tdi2.buffs.BlizzardBuff;
/*    */ import com.prineside.tdi2.buffs.BonusCoinsBuff;
/*    */ import com.prineside.tdi2.buffs.BonusXpBuff;
/*    */ import com.prineside.tdi2.buffs.BurnBuff;
/*    */ import com.prineside.tdi2.buffs.ChainReactionBuff;
/*    */ import com.prineside.tdi2.buffs.DeathExplosionBuff;
/*    */ import com.prineside.tdi2.buffs.FreezingBuff;
/*    */ import com.prineside.tdi2.buffs.InvulnerabilityBuff;
/*    */ import com.prineside.tdi2.buffs.NoBonusSystemPointsBuff;
/*    */ import com.prineside.tdi2.buffs.NoDamageBuff;
/*    */ import com.prineside.tdi2.buffs.PoisonBuff;
/*    */ import com.prineside.tdi2.buffs.RegenerationBuff;
/*    */ import com.prineside.tdi2.buffs.SlippingBuff;
/*    */ import com.prineside.tdi2.buffs.SnowballBuff;
/*    */ import com.prineside.tdi2.buffs.StunBuff;
/*    */ import com.prineside.tdi2.buffs.ThrowBackBuff;
/*    */ import com.prineside.tdi2.buffs.VulnerabilityBuff;
/*    */ import com.prineside.tdi2.utils.REGS;
/*    */ 
/*    */ @REGS
/*    */ public enum BuffType {
/* 25 */   FREEZING,
/* 26 */   POISON,
/* 27 */   BURN,
/* 28 */   BLIZZARD,
/* 29 */   ARMOR,
/* 30 */   SNOWBALL,
/* 31 */   REGENERATION,
/* 32 */   THROW_BACK,
/* 33 */   STUN,
/* 34 */   BONUS_COINS,
/* 35 */   BONUS_XP,
/* 36 */   DEATH_EXPLOSION,
/* 37 */   CHAIN_REACTION,
/* 38 */   VULNERABILITY,
/* 39 */   INVULNERABILITY,
/* 40 */   SLIPPING,
/* 41 */   NO_DAMAGE,
/* 42 */   NO_BONUS_SYSTEM_POINTS;
/*    */   static {
/* 44 */     relevantClasses = new Class[] { FreezingBuff.class, PoisonBuff.class, BurnBuff.class, BlizzardBuff.class, ArmorBuff.class, SnowballBuff.class, RegenerationBuff.class, ThrowBackBuff.class, StunBuff.class, BonusCoinsBuff.class, BonusXpBuff.class, DeathExplosionBuff.class, ChainReactionBuff.class, VulnerabilityBuff.class, InvulnerabilityBuff.class, SlippingBuff.class, NoDamageBuff.class, NoBonusSystemPointsBuff.class };
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */     
/* 65 */     values = values();
/*    */   }
/*    */   
/*    */   public static final Class[] relevantClasses;
/*    */   public static final BuffType[] values;
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\enums\BuffType.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */