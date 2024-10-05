/*     */ package com.prineside.tdi2.buffs.processors;
/*     */ 
/*     */ import com.badlogic.gdx.utils.DelayedRemovalArray;
/*     */ import com.esotericsoftware.kryo.Kryo;
/*     */ import com.esotericsoftware.kryo.io.Input;
/*     */ import com.esotericsoftware.kryo.io.Output;
/*     */ import com.prineside.tdi2.Buff;
/*     */ import com.prineside.tdi2.BuffProcessor;
/*     */ import com.prineside.tdi2.Enemy;
/*     */ import com.prineside.tdi2.buffs.FreezingBuff;
/*     */ import com.prineside.tdi2.enums.BuffType;
/*     */ import com.prineside.tdi2.enums.StatisticsType;
/*     */ import com.prineside.tdi2.utils.FrameAccumulatorForPerformance;
/*     */ import com.prineside.tdi2.utils.REGS;
/*     */ 
/*     */ 
/*     */ @REGS
/*     */ public final class FreezingBuffProcessor
/*     */   extends BuffProcessor<FreezingBuff>
/*     */ {
/*     */   @FrameAccumulatorForPerformance
/*     */   private byte a;
/*     */   
/*     */   public final void write(Kryo paramKryo, Output paramOutput) {
/*  25 */     super.write(paramKryo, paramOutput);
/*  26 */     paramOutput.writeByte(this.a);
/*     */   }
/*     */ 
/*     */   
/*     */   public final void read(Kryo paramKryo, Input paramInput) {
/*  31 */     super.read(paramKryo, paramInput);
/*  32 */     this.a = paramInput.readByte();
/*     */   }
/*     */ 
/*     */   
/*     */   public final StatisticsType getBuffCountStatistic() {
/*  37 */     return StatisticsType.EB_F;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final boolean addBuff(Enemy paramEnemy, FreezingBuff paramFreezingBuff) {
/*     */     DelayedRemovalArray delayedRemovalArray;
/*  45 */     if ((delayedRemovalArray = paramEnemy.getBuffsByTypeOrNull(BuffType.FREEZING)) != null && delayedRemovalArray.size != 0) {
/*  46 */       delayedRemovalArray.begin();
/*  47 */       for (byte b = 0; b < delayedRemovalArray.size; b++) {
/*  48 */         if ((((FreezingBuff[])delayedRemovalArray.items)[b]).tower == paramFreezingBuff.tower) {
/*     */           
/*  50 */           removeBuffAtIndex(paramEnemy, BuffType.FREEZING, b);
/*     */           break;
/*     */         } 
/*     */       } 
/*  54 */       delayedRemovalArray.end();
/*     */     } 
/*     */     
/*  57 */     return super.addBuff(paramEnemy, (Buff)paramFreezingBuff);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public final void update(float paramFloat) {
/*  63 */     this.a = (byte)(this.a + 1);
/*  64 */     if (this.a == 3) {
/*  65 */       paramFloat *= 3.0F;
/*  66 */       this.a = 0;
/*     */       
/*  68 */       this.S.map.spawnedEnemies.begin(); byte b; int i;
/*  69 */       for (b = 0, i = this.S.map.spawnedEnemies.size; b < i; b++) {
/*     */         Enemy enemy;
/*  71 */         if ((enemy = (((Enemy.EnemyReference[])this.S.map.spawnedEnemies.items)[b]).enemy) != null) {
/*     */ 
/*     */           
/*  74 */           DelayedRemovalArray delayedRemovalArray = enemy.getBuffsByTypeOrNull(BuffType.FREEZING);
/*  75 */           if (enemy.buffFreezingPercent != 0.0F || (delayedRemovalArray != null && delayedRemovalArray.size != 0)) {
/*     */             
/*  77 */             boolean bool = enemy.hasBuffsByType(BuffType.BURN);
/*  78 */             if (delayedRemovalArray != null && delayedRemovalArray.size != 0) {
/*     */               
/*  80 */               enemy.buffFreezingLightningLengthBonus = 0.0F;
/*  81 */               enemy.buffFreezingPoisonDurationBonus = 0.0F;
/*     */               
/*  83 */               float f = 0.0F;
/*  84 */               delayedRemovalArray.begin(); byte b1; int j;
/*  85 */               for (b1 = 0, j = delayedRemovalArray.size; b1 < j; b1++) {
/*  86 */                 FreezingBuff freezingBuff = ((FreezingBuff[])delayedRemovalArray.items)[b1];
/*  87 */                 if (enemy.buffFreezingPercent < freezingBuff.maxPercent) {
/*     */                   
/*  89 */                   float f1 = freezingBuff.maxPercent - enemy.buffFreezingPercent;
/*  90 */                   float f2 = paramFloat * freezingBuff.speed;
/*  91 */                   if (bool)
/*     */                   {
/*  93 */                     f2 *= 0.333F;
/*     */                   }
/*     */                   
/*  96 */                   if (f2 > f1)
/*  97 */                     f2 = f1; 
/*  98 */                   enemy.buffFreezingPercent += f2;
/*     */ 
/*     */                   
/* 101 */                   if (freezingBuff.tower != null) {
/* 102 */                     this.S.experience.addExperienceBuffed(freezingBuff.tower, f2 * 0.02F);
/*     */                   }
/*     */                 } 
/*     */                 
/* 106 */                 if (freezingBuff.maxPercent > f) {
/* 107 */                   f = freezingBuff.maxPercent;
/*     */                 }
/*     */                 
/* 110 */                 if (enemy.buffFreezingPoisonDurationBonus < freezingBuff.poisonDurationBonus) {
/* 111 */                   enemy.buffFreezingPoisonDurationBonus = freezingBuff.poisonDurationBonus;
/*     */                 }
/* 113 */                 if (enemy.buffFreezingLightningLengthBonus < freezingBuff.lightningLengthBonus) {
/* 114 */                   enemy.buffFreezingLightningLengthBonus = freezingBuff.lightningLengthBonus;
/*     */                 }
/*     */               } 
/* 117 */               delayedRemovalArray.end();
/*     */               
/* 119 */               if (bool)
/*     */               {
/* 121 */                 f *= 0.67F;
/*     */               }
/*     */               
/* 124 */               if (enemy.buffFreezingPercent > f) {
/*     */                 
/* 126 */                 float f1 = StrictMath.min(100.0F * paramFloat, enemy.buffFreezingPercent - f);
/*     */                 
/* 128 */                 enemy.buffFreezingPercent -= f1;
/* 129 */                 if (enemy.buffFreezingPercent < 0.0F) enemy.buffFreezingPercent = 0.0F;
/*     */               
/*     */               } 
/*     */             } else {
/* 133 */               float f = 100.0F * paramFloat;
/* 134 */               if (bool)
/*     */               {
/* 136 */                 f *= 3.0F;
/*     */               }
/*     */               
/* 139 */               enemy.buffFreezingPercent -= f;
/* 140 */               if (enemy.buffFreezingPercent < 0.0F) enemy.buffFreezingPercent = 0.0F;
/*     */               
/* 142 */               enemy.buffFreezingLightningLengthBonus = 0.0F;
/* 143 */               enemy.buffFreezingPoisonDurationBonus = 0.0F;
/*     */             } 
/*     */             
/* 146 */             if (enemy.buffFreezingPercent > 100.0F) enemy.buffFreezingPercent = 100.0F; 
/*     */           } 
/*     */         } 
/* 149 */       }  this.S.map.spawnedEnemies.end();
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\buffs\processors\FreezingBuffProcessor.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */