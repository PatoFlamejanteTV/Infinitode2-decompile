/*     */ package com.prineside.tdi2.buffs.processors;
/*     */ 
/*     */ import com.badlogic.gdx.utils.Array;
/*     */ import com.badlogic.gdx.utils.DelayedRemovalArray;
/*     */ import com.esotericsoftware.kryo.Kryo;
/*     */ import com.esotericsoftware.kryo.io.Input;
/*     */ import com.esotericsoftware.kryo.io.Output;
/*     */ import com.prineside.tdi2.Buff;
/*     */ import com.prineside.tdi2.BuffProcessor;
/*     */ import com.prineside.tdi2.Enemy;
/*     */ import com.prineside.tdi2.buffs.PoisonBuff;
/*     */ import com.prineside.tdi2.enums.BuffType;
/*     */ import com.prineside.tdi2.enums.DamageType;
/*     */ import com.prineside.tdi2.enums.GameValueType;
/*     */ import com.prineside.tdi2.enums.StatisticsType;
/*     */ import com.prineside.tdi2.utils.FrameAccumulatorForPerformance;
/*     */ import com.prineside.tdi2.utils.REGS;
/*     */ import java.util.Comparator;
/*     */ 
/*     */ @REGS
/*     */ public final class PoisonBuffProcessor extends BuffProcessor<PoisonBuff> {
/*     */   private static final Comparator<PoisonBuff> a;
/*     */   
/*     */   static {
/*  25 */     a = ((paramPoisonBuff1, paramPoisonBuff2) -> (paramPoisonBuff1.poisonDamage == paramPoisonBuff2.poisonDamage) ? 0 : ((paramPoisonBuff1.poisonDamage > paramPoisonBuff2.poisonDamage) ? -1 : 1));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   @FrameAccumulatorForPerformance
/*     */   private byte b;
/*     */ 
/*     */   
/*     */   public final void write(Kryo paramKryo, Output paramOutput) {
/*  35 */     super.write(paramKryo, paramOutput);
/*  36 */     paramOutput.writeByte(this.b);
/*     */   }
/*     */ 
/*     */   
/*     */   public final void read(Kryo paramKryo, Input paramInput) {
/*  41 */     super.read(paramKryo, paramInput);
/*  42 */     this.b = paramInput.readByte();
/*     */   }
/*     */ 
/*     */   
/*     */   public final StatisticsType getBuffCountStatistic() {
/*  47 */     return StatisticsType.EB_P;
/*     */   }
/*     */ 
/*     */   
/*     */   public final boolean addBuff(Enemy paramEnemy, PoisonBuff paramPoisonBuff) {
/*     */     int i;
/*     */     DelayedRemovalArray delayedRemovalArray;
/*  54 */     if ((delayedRemovalArray = paramEnemy.getBuffsByTypeOrNull(BuffType.POISON)) != null && delayedRemovalArray.size != 0)
/*     */     {
/*  56 */       for (byte b = 0; b < delayedRemovalArray.size; b++) {
/*     */         PoisonBuff poisonBuff;
/*  58 */         if ((poisonBuff = ((PoisonBuff[])delayedRemovalArray.items)[b]).tower == paramPoisonBuff.tower) {
/*  59 */           if (paramPoisonBuff.tower instanceof com.prineside.tdi2.towers.VenomTower && paramPoisonBuff.tower.isAbilityInstalled(2)) {
/*     */             
/*  61 */             i = this.S.gameValue.getIntValue(GameValueType.TOWER_VENOM_A_FAST_MAX_DEBUFFS);
/*  62 */             if (poisonBuff.fastShellsStackCount < i) {
/*  63 */               poisonBuff.fastShellsStackCount++;
/*  64 */               poisonBuff.poisonDamage = (float)(poisonBuff.poisonDamage + paramPoisonBuff.poisonDamage * this.S.gameValue.getPercentValueAsMultiplier(GameValueType.TOWER_VENOM_A_FAST_DAMAGE_PER_STACK));
/*     */             } 
/*     */           } else {
/*  67 */             poisonBuff.poisonDamage = paramPoisonBuff.poisonDamage;
/*     */           } 
/*  69 */           poisonBuff.duration = paramPoisonBuff.duration;
/*  70 */           return true;
/*     */         } 
/*     */       } 
/*     */     }
/*     */     
/*  75 */     return super.addBuff(i, (Buff)paramPoisonBuff);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public final void update(float paramFloat) {
/*  81 */     this.b = (byte)(this.b + 1);
/*  82 */     if (this.b == 9) {
/*  83 */       paramFloat *= 9.0F;
/*  84 */       this.b = 0;
/*     */       
/*  86 */       this.S.map.spawnedEnemies.begin(); byte b; int i;
/*  87 */       for (b = 0, i = this.S.map.spawnedEnemies.size; b < i; b++) {
/*     */         Enemy.EnemyReference enemyReference;
/*  89 */         if ((enemyReference = ((Enemy.EnemyReference[])this.S.map.spawnedEnemies.items)[b]).enemy != null) {
/*     */           DelayedRemovalArray delayedRemovalArray;
/*     */ 
/*     */           
/*  93 */           if ((delayedRemovalArray = enemyReference.enemy.getBuffsByTypeOrNull(BuffType.POISON)) != null && delayedRemovalArray.size != 0) {
/*     */             
/*  95 */             this.S.TSH.sort.sort((Array)delayedRemovalArray, a);
/*     */             
/*  97 */             float f = 1.0F;
/*  98 */             delayedRemovalArray.begin(); byte b1; int j;
/*  99 */             for (b1 = 0, j = delayedRemovalArray.size; b1 < j; b1++) {
/*     */               PoisonBuff poisonBuff;
/* 101 */               float f1 = (poisonBuff = ((PoisonBuff[])delayedRemovalArray.items)[b1]).poisonDamage * paramFloat * f;
/*     */               
/* 103 */               poisonBuff.duration += enemyReference.enemy.buffFreezingPoisonDurationBonus * 0.01F * paramFloat;
/* 104 */               if (f1 > 0.0F) {
/* 105 */                 this.S.damage.queueDamage(this.S.damage.obtainRecord().setup(enemyReference.enemy, f1, DamageType.POISON).setTower(poisonBuff.tower).setAbility(poisonBuff.fromAbility).setEfficiency(4));
/*     */               }
/*     */               
/* 108 */               if ((f = f * 0.75F) < 0.15F) {
/* 109 */                 f = 0.15F;
/*     */               }
/*     */             } 
/* 112 */             delayedRemovalArray.end();
/*     */           } 
/*     */         } 
/* 115 */       }  this.S.map.spawnedEnemies.end();
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\buffs\processors\PoisonBuffProcessor.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */