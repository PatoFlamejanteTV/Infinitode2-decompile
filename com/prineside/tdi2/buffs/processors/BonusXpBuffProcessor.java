/*     */ package com.prineside.tdi2.buffs.processors;
/*     */ import com.badlogic.gdx.utils.DelayedRemovalArray;
/*     */ import com.esotericsoftware.kryo.Kryo;
/*     */ import com.esotericsoftware.kryo.io.Input;
/*     */ import com.esotericsoftware.kryo.io.Output;
/*     */ import com.prineside.tdi2.Buff;
/*     */ import com.prineside.tdi2.BuffProcessor;
/*     */ import com.prineside.tdi2.DamageRecord;
/*     */ import com.prineside.tdi2.Enemy;
/*     */ import com.prineside.tdi2.GameSystemProvider;
/*     */ import com.prineside.tdi2.SerializableListener;
/*     */ import com.prineside.tdi2.Tower;
/*     */ import com.prineside.tdi2.buffs.BonusXpBuff;
/*     */ import com.prineside.tdi2.enums.BuffType;
/*     */ import com.prineside.tdi2.enums.StatisticsType;
/*     */ import com.prineside.tdi2.events.Event;
/*     */ import com.prineside.tdi2.events.Listener;
/*     */ import com.prineside.tdi2.events.game.EnemyDie;
/*     */ import com.prineside.tdi2.events.game.EnemyTakeDamage;
/*     */ import com.prineside.tdi2.utils.REGS;
/*     */ 
/*     */ @REGS
/*     */ public final class BonusXpBuffProcessor extends BuffProcessor<BonusXpBuff> {
/*  24 */   private OnEnemyDie a = new OnEnemyDie(this);
/*  25 */   private OnEnemyTakeDamage b = new OnEnemyTakeDamage(this);
/*     */   
/*     */   private GameSystemProvider c;
/*     */   
/*     */   public final void write(Kryo paramKryo, Output paramOutput) {
/*  30 */     super.write(paramKryo, paramOutput);
/*  31 */     paramKryo.writeObject(paramOutput, this.a);
/*  32 */     paramKryo.writeObject(paramOutput, this.b);
/*  33 */     paramKryo.writeObjectOrNull(paramOutput, this.c, GameSystemProvider.class);
/*     */   }
/*     */ 
/*     */   
/*     */   public final void read(Kryo paramKryo, Input paramInput) {
/*  38 */     super.read(paramKryo, paramInput);
/*  39 */     this.a = (OnEnemyDie)paramKryo.readObject(paramInput, OnEnemyDie.class);
/*  40 */     this.b = (OnEnemyTakeDamage)paramKryo.readObject(paramInput, OnEnemyTakeDamage.class);
/*  41 */     this.c = (GameSystemProvider)paramKryo.readObjectOrNull(paramInput, GameSystemProvider.class);
/*     */   }
/*     */ 
/*     */   
/*     */   public final void setRegistered(GameSystemProvider paramGameSystemProvider) {
/*  46 */     super.setRegistered(paramGameSystemProvider);
/*     */     
/*  48 */     this.c = paramGameSystemProvider;
/*  49 */     this.c.events.getListeners(EnemyDie.class).addStateAffecting(this.a);
/*  50 */     this.c.events.getListeners(EnemyTakeDamage.class).addStateAffecting(this.b);
/*     */   }
/*     */ 
/*     */   
/*     */   public final void setUnregistered() {
/*  55 */     this.c.events.getListeners(EnemyDie.class).remove(this.a);
/*  56 */     this.c.events.getListeners(EnemyTakeDamage.class).remove(this.b);
/*  57 */     super.setUnregistered();
/*     */   }
/*     */ 
/*     */   
/*     */   public final boolean addBuff(Enemy paramEnemy, BonusXpBuff paramBonusXpBuff) {
/*  62 */     return a(paramEnemy, (Buff)paramBonusXpBuff);
/*     */   }
/*     */ 
/*     */   
/*     */   public final StatisticsType getBuffCountStatistic() {
/*  67 */     return StatisticsType.EB_BXP;
/*     */   }
/*     */   
/*     */   @REGS
/*     */   public static final class OnEnemyDie extends SerializableListener<BonusXpBuffProcessor> implements Listener<EnemyDie> {
/*     */     private OnEnemyDie() {}
/*     */     
/*     */     public OnEnemyDie(BonusXpBuffProcessor param1BonusXpBuffProcessor) {
/*  75 */       this.a = param1BonusXpBuffProcessor;
/*     */     }
/*     */ 
/*     */     
/*     */     public final void handleEvent(EnemyDie param1EnemyDie) {
/*     */       DamageRecord damageRecord;
/*     */       Tower tower;
/*  82 */       if ((tower = (damageRecord = param1EnemyDie.getLastDamage()).getTower()) == null)
/*     */         return; 
/*     */       Enemy enemy;
/*     */       DelayedRemovalArray delayedRemovalArray;
/*  86 */       if ((delayedRemovalArray = (enemy = damageRecord.getEnemy()).getBuffsByTypeOrNull(BuffType.BONUS_XP)) != null && delayedRemovalArray.size != 0) {
/*     */         
/*  88 */         BonusXpBuff bonusXpBuff = (BonusXpBuff)delayedRemovalArray.first();
/*     */         
/*  90 */         float f = (BonusXpBuffProcessor.a((BonusXpBuffProcessor)this.a)).experience.addExperienceBuffed(tower, enemy.getKillExp() * bonusXpBuff.bonusXpMultiplier);
/*  91 */         (BonusXpBuffProcessor.a((BonusXpBuffProcessor)this.a)).statistics.addStatistic(StatisticsType.XPG_BB, f);
/*     */       } 
/*     */     }
/*     */   }
/*     */   
/*     */   @REGS
/*     */   public static final class OnEnemyTakeDamage extends SerializableListener<BonusXpBuffProcessor> implements Listener<EnemyTakeDamage> {
/*     */     private OnEnemyTakeDamage() {}
/*     */     
/*     */     public OnEnemyTakeDamage(BonusXpBuffProcessor param1BonusXpBuffProcessor) {
/* 101 */       this.a = param1BonusXpBuffProcessor;
/*     */     }
/*     */ 
/*     */     
/*     */     public final void handleEvent(EnemyTakeDamage param1EnemyTakeDamage) {
/*     */       DamageRecord damageRecord;
/*     */       Tower tower;
/* 108 */       if ((tower = (damageRecord = param1EnemyTakeDamage.getRecord()).getTower()) == null)
/*     */         return; 
/* 110 */       Enemy enemy = damageRecord.getEnemy();
/* 111 */       float f = damageRecord.getFactDamage();
/*     */       DelayedRemovalArray delayedRemovalArray;
/* 113 */       if ((delayedRemovalArray = enemy.getBuffsByTypeOrNull(BuffType.BONUS_XP)) != null && delayedRemovalArray.size != 0 && f > 0.0F) {
/*     */         
/* 115 */         BonusXpBuff bonusXpBuff = (BonusXpBuff)delayedRemovalArray.first();
/* 116 */         f = f / enemy.maxHealth * enemy.getKillExp() * 2.0F * bonusXpBuff.bonusXpMultiplier;
/* 117 */         f = (BonusXpBuffProcessor.a((BonusXpBuffProcessor)this.a)).experience.addExperienceBuffed(tower, f);
/* 118 */         (BonusXpBuffProcessor.a((BonusXpBuffProcessor)this.a)).statistics.addStatistic(StatisticsType.XPG_BB, f);
/*     */       } 
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\buffs\processors\BonusXpBuffProcessor.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */