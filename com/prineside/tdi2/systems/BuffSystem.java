/*     */ package com.prineside.tdi2.systems;
/*     */ 
/*     */ import com.badlogic.gdx.utils.DelayedRemovalArray;
/*     */ import com.esotericsoftware.kryo.Kryo;
/*     */ import com.esotericsoftware.kryo.io.Input;
/*     */ import com.esotericsoftware.kryo.io.Output;
/*     */ import com.prineside.tdi2.Buff;
/*     */ import com.prineside.tdi2.BuffProcessor;
/*     */ import com.prineside.tdi2.Enemy;
/*     */ import com.prineside.tdi2.Game;
/*     */ import com.prineside.tdi2.GameSystem;
/*     */ import com.prineside.tdi2.buffs.processors.ArmorBuffProcessor;
/*     */ import com.prineside.tdi2.buffs.processors.BlizzardBuffProcessor;
/*     */ import com.prineside.tdi2.buffs.processors.BonusCoinsBuffProcessor;
/*     */ import com.prineside.tdi2.buffs.processors.BonusXpBuffProcessor;
/*     */ import com.prineside.tdi2.buffs.processors.BurnBuffProcessor;
/*     */ import com.prineside.tdi2.buffs.processors.ChainReactionBuffProcessor;
/*     */ import com.prineside.tdi2.buffs.processors.DeathExplosionBuffProcessor;
/*     */ import com.prineside.tdi2.buffs.processors.FreezingBuffProcessor;
/*     */ import com.prineside.tdi2.buffs.processors.InvulnerabilityBuffProcessor;
/*     */ import com.prineside.tdi2.buffs.processors.NoBonusSystemPointsBuffProcessor;
/*     */ import com.prineside.tdi2.buffs.processors.NoDamageBuffProcessor;
/*     */ import com.prineside.tdi2.buffs.processors.PoisonBuffProcessor;
/*     */ import com.prineside.tdi2.buffs.processors.RegenerationBuffProcessor;
/*     */ import com.prineside.tdi2.buffs.processors.SlippingBuffProcessor;
/*     */ import com.prineside.tdi2.buffs.processors.SnowballBuffProcessor;
/*     */ import com.prineside.tdi2.buffs.processors.StunBuffProcessor;
/*     */ import com.prineside.tdi2.buffs.processors.ThrowBackBuffProcessor;
/*     */ import com.prineside.tdi2.buffs.processors.VulnerabilityBuffProcessor;
/*     */ import com.prineside.tdi2.enums.BuffType;
/*     */ import com.prineside.tdi2.utils.REGS;
/*     */ 
/*     */ @REGS
/*     */ public final class BuffSystem extends GameSystem {
/*  35 */   private BuffProcessor[] a = new BuffProcessor[BuffType.values.length];
/*     */   
/*     */   public FreezingBuffProcessor P_FREEZING;
/*     */   
/*     */   public PoisonBuffProcessor P_POISON;
/*     */   public BurnBuffProcessor P_BURN;
/*     */   public BlizzardBuffProcessor P_BLIZZARD;
/*     */   public ArmorBuffProcessor P_ARMOR;
/*     */   public SnowballBuffProcessor P_SNOWBALL;
/*     */   public RegenerationBuffProcessor P_REGENERATION;
/*     */   public ThrowBackBuffProcessor P_THROW_BACK;
/*     */   public StunBuffProcessor P_STUN;
/*     */   public BonusCoinsBuffProcessor P_BONUS_COINS;
/*     */   public BonusXpBuffProcessor P_BONUS_XP;
/*     */   public DeathExplosionBuffProcessor P_DEATH_EXPLOSION;
/*     */   public ChainReactionBuffProcessor P_CHAIN_REACTION;
/*     */   public VulnerabilityBuffProcessor P_VULNERABILITY;
/*     */   public InvulnerabilityBuffProcessor P_INVULNERABILITY;
/*     */   public SlippingBuffProcessor P_SLIPPING;
/*     */   public NoDamageBuffProcessor P_NO_DAMAGE;
/*     */   public NoBonusSystemPointsBuffProcessor P_NO_BONUS_SYSTEM_POINTS;
/*     */   
/*     */   public final void write(Kryo paramKryo, Output paramOutput) {
/*  58 */     super.write(paramKryo, paramOutput);
/*  59 */     paramKryo.writeObject(paramOutput, this.a);
/*     */     
/*  61 */     paramKryo.writeObject(paramOutput, this.P_FREEZING);
/*  62 */     paramKryo.writeObject(paramOutput, this.P_POISON);
/*  63 */     paramKryo.writeObject(paramOutput, this.P_BURN);
/*  64 */     paramKryo.writeObject(paramOutput, this.P_BLIZZARD);
/*  65 */     paramKryo.writeObject(paramOutput, this.P_ARMOR);
/*  66 */     paramKryo.writeObject(paramOutput, this.P_SNOWBALL);
/*  67 */     paramKryo.writeObject(paramOutput, this.P_REGENERATION);
/*  68 */     paramKryo.writeObject(paramOutput, this.P_THROW_BACK);
/*  69 */     paramKryo.writeObject(paramOutput, this.P_STUN);
/*  70 */     paramKryo.writeObject(paramOutput, this.P_BONUS_COINS);
/*  71 */     paramKryo.writeObject(paramOutput, this.P_BONUS_XP);
/*  72 */     paramKryo.writeObject(paramOutput, this.P_DEATH_EXPLOSION);
/*  73 */     paramKryo.writeObject(paramOutput, this.P_CHAIN_REACTION);
/*  74 */     paramKryo.writeObject(paramOutput, this.P_VULNERABILITY);
/*  75 */     paramKryo.writeObject(paramOutput, this.P_INVULNERABILITY);
/*  76 */     paramKryo.writeObject(paramOutput, this.P_SLIPPING);
/*  77 */     paramKryo.writeObject(paramOutput, this.P_NO_DAMAGE);
/*  78 */     paramKryo.writeObject(paramOutput, this.P_NO_BONUS_SYSTEM_POINTS);
/*     */   }
/*     */ 
/*     */   
/*     */   public final void read(Kryo paramKryo, Input paramInput) {
/*  83 */     super.read(paramKryo, paramInput);
/*  84 */     this.a = (BuffProcessor[])paramKryo.readObject(paramInput, BuffProcessor[].class);
/*     */     
/*  86 */     this.P_FREEZING = (FreezingBuffProcessor)paramKryo.readObject(paramInput, FreezingBuffProcessor.class);
/*  87 */     this.P_POISON = (PoisonBuffProcessor)paramKryo.readObject(paramInput, PoisonBuffProcessor.class);
/*  88 */     this.P_BURN = (BurnBuffProcessor)paramKryo.readObject(paramInput, BurnBuffProcessor.class);
/*  89 */     this.P_BLIZZARD = (BlizzardBuffProcessor)paramKryo.readObject(paramInput, BlizzardBuffProcessor.class);
/*  90 */     this.P_ARMOR = (ArmorBuffProcessor)paramKryo.readObject(paramInput, ArmorBuffProcessor.class);
/*  91 */     this.P_SNOWBALL = (SnowballBuffProcessor)paramKryo.readObject(paramInput, SnowballBuffProcessor.class);
/*  92 */     this.P_REGENERATION = (RegenerationBuffProcessor)paramKryo.readObject(paramInput, RegenerationBuffProcessor.class);
/*  93 */     this.P_THROW_BACK = (ThrowBackBuffProcessor)paramKryo.readObject(paramInput, ThrowBackBuffProcessor.class);
/*  94 */     this.P_STUN = (StunBuffProcessor)paramKryo.readObject(paramInput, StunBuffProcessor.class);
/*  95 */     this.P_BONUS_COINS = (BonusCoinsBuffProcessor)paramKryo.readObject(paramInput, BonusCoinsBuffProcessor.class);
/*  96 */     this.P_BONUS_XP = (BonusXpBuffProcessor)paramKryo.readObject(paramInput, BonusXpBuffProcessor.class);
/*  97 */     this.P_DEATH_EXPLOSION = (DeathExplosionBuffProcessor)paramKryo.readObject(paramInput, DeathExplosionBuffProcessor.class);
/*  98 */     this.P_CHAIN_REACTION = (ChainReactionBuffProcessor)paramKryo.readObject(paramInput, ChainReactionBuffProcessor.class);
/*  99 */     this.P_VULNERABILITY = (VulnerabilityBuffProcessor)paramKryo.readObject(paramInput, VulnerabilityBuffProcessor.class);
/* 100 */     this.P_INVULNERABILITY = (InvulnerabilityBuffProcessor)paramKryo.readObject(paramInput, InvulnerabilityBuffProcessor.class);
/* 101 */     this.P_SLIPPING = (SlippingBuffProcessor)paramKryo.readObject(paramInput, SlippingBuffProcessor.class);
/* 102 */     this.P_NO_DAMAGE = (NoDamageBuffProcessor)paramKryo.readObject(paramInput, NoDamageBuffProcessor.class);
/* 103 */     this.P_NO_BONUS_SYSTEM_POINTS = (NoBonusSystemPointsBuffProcessor)paramKryo.readObject(paramInput, NoBonusSystemPointsBuffProcessor.class);
/*     */   }
/*     */ 
/*     */   
/*     */   public final boolean affectsGameState() {
/* 108 */     return true;
/*     */   }
/*     */   
/*     */   public final void setup() {
/*     */     BuffType[] arrayOfBuffType;
/*     */     int i;
/*     */     byte b;
/* 115 */     for (i = (arrayOfBuffType = BuffType.values).length, b = 0; b < i; ) { BuffType buffType = arrayOfBuffType[b];
/* 116 */       this.a[buffType.ordinal()] = Game.i.buffManager.getFactory(buffType).createProcessor();
/* 117 */       this.a[buffType.ordinal()].setRegistered(this.S);
/*     */       b++; }
/*     */     
/* 120 */     this.P_FREEZING = (FreezingBuffProcessor)getProcessor(BuffType.FREEZING);
/* 121 */     this.P_POISON = (PoisonBuffProcessor)getProcessor(BuffType.POISON);
/* 122 */     this.P_BURN = (BurnBuffProcessor)getProcessor(BuffType.BURN);
/* 123 */     this.P_BLIZZARD = (BlizzardBuffProcessor)getProcessor(BuffType.BLIZZARD);
/* 124 */     this.P_ARMOR = (ArmorBuffProcessor)getProcessor(BuffType.ARMOR);
/* 125 */     this.P_SNOWBALL = (SnowballBuffProcessor)getProcessor(BuffType.SNOWBALL);
/* 126 */     this.P_REGENERATION = (RegenerationBuffProcessor)getProcessor(BuffType.REGENERATION);
/* 127 */     this.P_THROW_BACK = (ThrowBackBuffProcessor)getProcessor(BuffType.THROW_BACK);
/* 128 */     this.P_STUN = (StunBuffProcessor)getProcessor(BuffType.STUN);
/* 129 */     this.P_BONUS_COINS = (BonusCoinsBuffProcessor)getProcessor(BuffType.BONUS_COINS);
/* 130 */     this.P_BONUS_XP = (BonusXpBuffProcessor)getProcessor(BuffType.BONUS_XP);
/* 131 */     this.P_DEATH_EXPLOSION = (DeathExplosionBuffProcessor)getProcessor(BuffType.DEATH_EXPLOSION);
/* 132 */     this.P_CHAIN_REACTION = (ChainReactionBuffProcessor)getProcessor(BuffType.CHAIN_REACTION);
/* 133 */     this.P_VULNERABILITY = (VulnerabilityBuffProcessor)getProcessor(BuffType.VULNERABILITY);
/* 134 */     this.P_INVULNERABILITY = (InvulnerabilityBuffProcessor)getProcessor(BuffType.INVULNERABILITY);
/* 135 */     this.P_SLIPPING = (SlippingBuffProcessor)getProcessor(BuffType.SLIPPING);
/* 136 */     this.P_NO_DAMAGE = (NoDamageBuffProcessor)getProcessor(BuffType.NO_DAMAGE);
/* 137 */     this.P_NO_BONUS_SYSTEM_POINTS = (NoBonusSystemPointsBuffProcessor)getProcessor(BuffType.NO_BONUS_SYSTEM_POINTS);
/*     */   }
/*     */   
/*     */   public final BuffProcessor getProcessor(BuffType paramBuffType) {
/* 141 */     return this.a[paramBuffType.ordinal()];
/*     */   }
/*     */ 
/*     */   
/*     */   public final void update(float paramFloat) {
/*     */     int i;
/* 147 */     for (byte b1 = 0; b1 < i; b1++) {
/*     */       Enemy enemy;
/* 149 */       if ((enemy = (((Enemy.EnemyReference[])this.S.map.spawnedEnemies.items)[b1]).enemy) != null && enemy.buffsByType != null) {
/*     */         BuffType[] arrayOfBuffType; int j; byte b;
/* 151 */         for (j = (arrayOfBuffType = BuffType.values).length, b = 0; b < j; ) { BuffType buffType = arrayOfBuffType[b];
/*     */           DelayedRemovalArray delayedRemovalArray;
/* 153 */           (delayedRemovalArray = enemy.buffsByType[buffType.ordinal()]).begin(); byte b3; int k;
/* 154 */           for (b3 = 0, k = delayedRemovalArray.size; b3 < k; b3++) {
/*     */             Buff buff;
/* 156 */             (buff = ((Buff[])delayedRemovalArray.items)[b3]).duration -= paramFloat;
/* 157 */             if (buff.duration <= 0.0F) {
/* 158 */               this.a[buffType.ordinal()].removeBuffAtIndex(enemy, buffType, b3);
/*     */             }
/*     */           } 
/* 161 */           delayedRemovalArray.end(); b++; }
/*     */       
/*     */       } 
/*     */     }  BuffProcessor[] arrayOfBuffProcessor;
/*     */     byte b2;
/* 166 */     for (i = (arrayOfBuffProcessor = this.a).length, b2 = 0; b2 < i; b2++) {
/* 167 */       BuffProcessor buffProcessor; (buffProcessor = arrayOfBuffProcessor[b2]).update(paramFloat);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public final String getSystemName() {
/* 173 */     return "Buff";
/*     */   }
/*     */ 
/*     */   
/*     */   public final void dispose() {
/* 178 */     for (byte b = 0; b < this.a.length; b++) {
/* 179 */       this.a[b].setUnregistered();
/* 180 */       this.a[b] = null;
/*     */     } 
/*     */     
/* 183 */     super.dispose();
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\systems\BuffSystem.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */