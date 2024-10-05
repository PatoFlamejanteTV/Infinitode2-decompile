/*     */ package com.prineside.tdi2.buffs.processors;
/*     */ 
/*     */ import com.badlogic.gdx.utils.DelayedRemovalArray;
/*     */ import com.esotericsoftware.kryo.Kryo;
/*     */ import com.esotericsoftware.kryo.io.Input;
/*     */ import com.esotericsoftware.kryo.io.Output;
/*     */ import com.prineside.tdi2.Buff;
/*     */ import com.prineside.tdi2.BuffProcessor;
/*     */ import com.prineside.tdi2.DamageRecord;
/*     */ import com.prineside.tdi2.Enemy;
/*     */ import com.prineside.tdi2.GameSystemProvider;
/*     */ import com.prineside.tdi2.Projectile;
/*     */ import com.prineside.tdi2.SerializableListener;
/*     */ import com.prineside.tdi2.buffs.ChainReactionBuff;
/*     */ import com.prineside.tdi2.enums.BuffType;
/*     */ import com.prineside.tdi2.enums.StatisticsType;
/*     */ import com.prineside.tdi2.events.Event;
/*     */ import com.prineside.tdi2.events.Listener;
/*     */ import com.prineside.tdi2.events.game.EnemyDie;
/*     */ import com.prineside.tdi2.projectiles.BuffProjectile;
/*     */ import com.prineside.tdi2.utils.REGS;
/*     */ 
/*     */ @REGS
/*     */ public final class ChainReactionBuffProcessor extends BuffProcessor<ChainReactionBuff> {
/*     */   public static final int MAX_BUFFS_PER_ENEMY = 2;
/*  26 */   private OnEnemyDie a = new OnEnemyDie(this);
/*     */ 
/*     */   
/*     */   public final void write(Kryo paramKryo, Output paramOutput) {
/*  30 */     super.write(paramKryo, paramOutput);
/*  31 */     paramKryo.writeObject(paramOutput, this.a);
/*     */   }
/*     */ 
/*     */   
/*     */   public final void read(Kryo paramKryo, Input paramInput) {
/*  36 */     super.read(paramKryo, paramInput);
/*  37 */     this.a = (OnEnemyDie)paramKryo.readObject(paramInput, OnEnemyDie.class);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public final boolean addBuff(Enemy paramEnemy, ChainReactionBuff paramChainReactionBuff) {
/*     */     DelayedRemovalArray delayedRemovalArray;
/*  44 */     if ((delayedRemovalArray = paramEnemy.getBuffsByTypeOrNull(BuffType.CHAIN_REACTION)) != null && delayedRemovalArray.size != 0) {
/*     */       ChainReactionBuff chainReactionBuff;
/*  46 */       if ((chainReactionBuff = ((ChainReactionBuff[])delayedRemovalArray.items)[0]).chance > paramChainReactionBuff.chance)
/*     */       {
/*  48 */         return false;
/*     */       }
/*     */       
/*  51 */       removeBuffAtIndex(paramEnemy, BuffType.CHAIN_REACTION, 0);
/*     */     } 
/*     */ 
/*     */     
/*  55 */     return super.addBuff(paramEnemy, (Buff)paramChainReactionBuff);
/*     */   }
/*     */   
/*     */   private static void b(GameSystemProvider paramGameSystemProvider, Enemy paramEnemy1, Enemy paramEnemy2, float paramFloat) {
/*  59 */     if (paramEnemy2.wasAimedAtWithChainReactionBuff) {
/*     */       return;
/*     */     }
/*  62 */     paramEnemy2.wasAimedAtWithChainReactionBuff = true;
/*     */     
/*  64 */     BuffProjectile buffProjectile = (BuffProjectile)paramGameSystemProvider.projectile.F.BUFF.obtain(); BuffType[] arrayOfBuffType; int i;
/*     */     byte b;
/*  66 */     for (i = (arrayOfBuffType = BuffType.values).length, b = 0; b < i; ) { BuffType buffType = arrayOfBuffType[b];
/*  67 */       DelayedRemovalArray delayedRemovalArray = paramEnemy1.buffsByType[buffType.ordinal()];
/*  68 */       for (byte b1 = 0; b1 < delayedRemovalArray.size; b1++) {
/*  69 */         Buff buff = ((Buff[])delayedRemovalArray.items)[b1];
/*  70 */         if (paramGameSystemProvider.buff.getProcessor(buff.getType()).isDebuff() && (
/*     */           
/*  72 */           buff = buff.cpy(paramFloat)) != null) {
/*  73 */           buffProjectile.buffs.add(buff);
/*     */         }
/*     */       } 
/*     */       
/*     */       b++; }
/*     */     
/*  79 */     paramGameSystemProvider.projectile.register((Projectile)buffProjectile);
/*  80 */     buffProjectile.setup(paramEnemy2, buffProjectile.buffs, paramEnemy1.getPosition(), 1.75F);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final void setRegistered(GameSystemProvider paramGameSystemProvider) {
/*  87 */     super.setRegistered(paramGameSystemProvider);
/*  88 */     this.S.events.getListeners(EnemyDie.class).addStateAffecting(this.a);
/*     */   }
/*     */ 
/*     */   
/*     */   public final void setUnregistered() {
/*  93 */     this.S.events.getListeners(EnemyDie.class).remove(this.a);
/*  94 */     super.setUnregistered();
/*     */   }
/*     */ 
/*     */   
/*     */   public final StatisticsType getBuffCountStatistic() {
/*  99 */     return StatisticsType.EB_CR;
/*     */   }
/*     */   
/*     */   @REGS
/*     */   public static final class OnEnemyDie extends SerializableListener<ChainReactionBuffProcessor> implements Listener<EnemyDie> {
/*     */     private OnEnemyDie() {}
/*     */     
/*     */     public OnEnemyDie(ChainReactionBuffProcessor param1ChainReactionBuffProcessor) {
/* 107 */       this.a = param1ChainReactionBuffProcessor;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public final void handleEvent(EnemyDie param1EnemyDie) {
/*     */       Enemy enemy;
/*     */       DamageRecord damageRecord;
/*     */       DelayedRemovalArray delayedRemovalArray;
/* 116 */       if ((delayedRemovalArray = (enemy = (damageRecord = param1EnemyDie.getLastDamage()).getEnemy()).getBuffsByTypeOrNull(BuffType.CHAIN_REACTION)) != null && delayedRemovalArray.size != 0) {
/*     */         ChainReactionBuff chainReactionBuff;
/*     */         
/* 119 */         float f1 = (chainReactionBuff = (ChainReactionBuff)delayedRemovalArray.first()).rangeInTiles * 64.0F;
/* 120 */         float f2 = chainReactionBuff.chance;
/*     */         
/* 122 */         ((ChainReactionBuffProcessor)this.a).S.map.getEnemiesInRect(
/* 123 */             (enemy.getPosition()).x - f1, 
/* 124 */             (enemy.getPosition()).y - f1, 
/* 125 */             (enemy.getPosition()).x + f1, 
/* 126 */             (enemy.getPosition()).y + f1, (param1EnemyReference, param1Float2, param1Float3, param1Float4) -> {
/*     */               Enemy enemy;
/*     */               if ((enemy = param1EnemyReference.enemy) == null)
/*     */                 return true; 
/*     */               if (enemy != param1Enemy && ((ChainReactionBuffProcessor)this.a).S.gameState.randomFloat() <= param1Float1)
/*     */                 ChainReactionBuffProcessor.a(((ChainReactionBuffProcessor)this.a).S, param1Enemy, enemy, param1ChainReactionBuff.durationMultiplier); 
/*     */               return true;
/*     */             });
/*     */       } 
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\buffs\processors\ChainReactionBuffProcessor.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */