/*    */ package com.prineside.tdi2.managers;
/*    */ 
/*    */ import com.prineside.tdi2.Buff;
/*    */ import com.prineside.tdi2.Game;
/*    */ import com.prineside.tdi2.Manager;
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
/*    */ import com.prineside.tdi2.enums.BuffType;
/*    */ import com.prineside.tdi2.serializers.SingletonSerializer;
/*    */ import com.prineside.tdi2.utils.REGS;
/*    */ 
/*    */ @REGS(serializer = BuffManager.Serializer.class)
/*    */ public class BuffManager extends Manager.ManagerAdapter {
/*    */   public static class Serializer extends SingletonSerializer<BuffManager> {
/*    */     public BuffManager read() {
/* 32 */       return Game.i.buffManager;
/*    */     } }
/*    */   
/* 35 */   public final Factories F = new Factories();
/*    */   
/*    */   public static class Factories {
/*    */     public FreezingBuff.FreezingBuffFactory FREEZING;
/*    */     public PoisonBuff.PoisonBuffFactory POISON;
/*    */     public BlizzardBuff.BlizzardBuffFactory BLIZZARD;
/*    */     public SnowballBuff.SnowballBuffFactory SNOWBALL;
/*    */     public ThrowBackBuff.BlastThrowBackBuffFactory THROW_BACK;
/*    */     public StunBuff.StunBuffFactory STUN;
/*    */     public BurnBuff.BurnBuffFactory BURN;
/*    */     public RegenerationBuff.RegenerationBuffFactory REGENERATION;
/*    */     public ArmorBuff.ArmorBuffFactory ARMOR;
/*    */     public BonusCoinsBuff.BonusCoinsBuffFactory BONUS_COINS;
/*    */     public BonusXpBuff.BonusXpBuffFactory BONUS_XP;
/*    */     public DeathExplosionBuff.ExplosionChargeBuffFactory DEATH_EXPLOSION;
/*    */     public ChainReactionBuff.ChainReactionBuffFactory CHAIN_REACTION;
/*    */     public VulnerabilityBuff.VulnerabilityBuffFactory VULNERABILITY;
/*    */     public InvulnerabilityBuff.InvulnerabilityBuffFactory INVULNERABILITY;
/*    */     public SlippingBuff.SlippingBuffFactory SLIPPING;
/*    */     public NoDamageBuff.NoDamageBuffFactory NO_DAMAGE;
/*    */     public NoBonusSystemPointsBuff.NoBonusSystemPointsBuffFactory NO_BONUS_SYSTEM_POINTS;
/*    */   }
/* 57 */   private final Buff.Factory[] a = new Buff.Factory[BuffType.values.length];
/*    */   
/*    */   public BuffManager() {
/* 60 */     this.a[BuffType.FREEZING.ordinal()] = (Buff.Factory)(this.F.FREEZING = new FreezingBuff.FreezingBuffFactory());
/* 61 */     this.a[BuffType.POISON.ordinal()] = (Buff.Factory)(this.F.POISON = new PoisonBuff.PoisonBuffFactory());
/* 62 */     this.a[BuffType.BLIZZARD.ordinal()] = (Buff.Factory)(this.F.BLIZZARD = new BlizzardBuff.BlizzardBuffFactory());
/* 63 */     this.a[BuffType.SNOWBALL.ordinal()] = (Buff.Factory)(this.F.SNOWBALL = new SnowballBuff.SnowballBuffFactory());
/* 64 */     this.a[BuffType.THROW_BACK.ordinal()] = (Buff.Factory)(this.F.THROW_BACK = new ThrowBackBuff.BlastThrowBackBuffFactory());
/* 65 */     this.a[BuffType.STUN.ordinal()] = (Buff.Factory)(this.F.STUN = new StunBuff.StunBuffFactory());
/* 66 */     this.a[BuffType.BURN.ordinal()] = (Buff.Factory)(this.F.BURN = new BurnBuff.BurnBuffFactory());
/* 67 */     this.a[BuffType.REGENERATION.ordinal()] = (Buff.Factory)(this.F.REGENERATION = new RegenerationBuff.RegenerationBuffFactory());
/* 68 */     this.a[BuffType.ARMOR.ordinal()] = (Buff.Factory)(this.F.ARMOR = new ArmorBuff.ArmorBuffFactory());
/* 69 */     this.a[BuffType.BONUS_COINS.ordinal()] = (Buff.Factory)(this.F.BONUS_COINS = new BonusCoinsBuff.BonusCoinsBuffFactory());
/* 70 */     this.a[BuffType.BONUS_XP.ordinal()] = (Buff.Factory)(this.F.BONUS_XP = new BonusXpBuff.BonusXpBuffFactory());
/* 71 */     this.a[BuffType.DEATH_EXPLOSION.ordinal()] = (Buff.Factory)(this.F.DEATH_EXPLOSION = new DeathExplosionBuff.ExplosionChargeBuffFactory());
/* 72 */     this.a[BuffType.CHAIN_REACTION.ordinal()] = (Buff.Factory)(this.F.CHAIN_REACTION = new ChainReactionBuff.ChainReactionBuffFactory());
/* 73 */     this.a[BuffType.VULNERABILITY.ordinal()] = (Buff.Factory)(this.F.VULNERABILITY = new VulnerabilityBuff.VulnerabilityBuffFactory());
/* 74 */     this.a[BuffType.INVULNERABILITY.ordinal()] = (Buff.Factory)(this.F.INVULNERABILITY = new InvulnerabilityBuff.InvulnerabilityBuffFactory());
/* 75 */     this.a[BuffType.SLIPPING.ordinal()] = (Buff.Factory)(this.F.SLIPPING = new SlippingBuff.SlippingBuffFactory());
/* 76 */     this.a[BuffType.NO_DAMAGE.ordinal()] = (Buff.Factory)(this.F.NO_DAMAGE = new NoDamageBuff.NoDamageBuffFactory());
/* 77 */     this.a[BuffType.NO_BONUS_SYSTEM_POINTS.ordinal()] = (Buff.Factory)(this.F.NO_BONUS_SYSTEM_POINTS = new NoBonusSystemPointsBuff.NoBonusSystemPointsBuffFactory()); BuffType[] arrayOfBuffType; int i;
/*    */     byte b;
/* 79 */     for (i = (arrayOfBuffType = BuffType.values).length, b = 0; b < i; ) { BuffType buffType = arrayOfBuffType[b];
/* 80 */       if (this.a[buffType.ordinal()] == null)
/* 81 */         throw new RuntimeException("Not all buff factories were created"); 
/*    */       b++; }
/*    */   
/*    */   } public void setup() {
/*    */     Buff.Factory[] arrayOfFactory;
/*    */     int i;
/*    */     byte b;
/* 88 */     for (i = (arrayOfFactory = this.a).length, b = 0; b < i; b++) {
/* 89 */       Buff.Factory factory; (factory = arrayOfFactory[b]).setup();
/*    */     } 
/*    */   }
/*    */   
/*    */   public Buff.Factory<? extends Buff> getFactory(BuffType paramBuffType) {
/* 94 */     return this.a[paramBuffType.ordinal()];
/*    */   }
/*    */   
/*    */   public void dispose() {}
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\managers\BuffManager.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */