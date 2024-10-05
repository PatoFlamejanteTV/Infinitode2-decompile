/*     */ package com.prineside.tdi2;
/*     */ import com.badlogic.gdx.utils.Array;
/*     */ import com.badlogic.gdx.utils.DelayedRemovalArray;
/*     */ import com.esotericsoftware.kryo.Kryo;
/*     */ import com.esotericsoftware.kryo.io.Input;
/*     */ import com.esotericsoftware.kryo.io.Output;
/*     */ import com.prineside.tdi2.enums.AchievementType;
/*     */ import com.prineside.tdi2.enums.BuffType;
/*     */ import com.prineside.tdi2.enums.StatisticsType;
/*     */ import com.prineside.tdi2.events.Event;
/*     */ import com.prineside.tdi2.events.EventListeners;
/*     */ import com.prineside.tdi2.events.game.AddBuffToEnemy;
/*     */ import com.prineside.tdi2.events.game.RemoveBuffFromEnemy;
/*     */ import com.prineside.tdi2.utils.NAGS;
/*     */ import com.prineside.tdi2.utils.REGS;
/*     */ 
/*     */ @REGS(arrayLevels = 1)
/*     */ public abstract class BuffProcessor<T extends Buff> extends Registrable {
/*  19 */   public ListenerGroup<BuffProcessorListener> listeners = new ListenerGroup<>(BuffProcessorListener.class);
/*     */   @NAGS
/*  21 */   private AddBuffToEnemy a = new AddBuffToEnemy();
/*     */ 
/*     */   
/*     */   public void write(Kryo paramKryo, Output paramOutput) {
/*  25 */     super.write(paramKryo, paramOutput);
/*  26 */     paramKryo.writeObject(paramOutput, this.listeners);
/*     */   }
/*     */ 
/*     */   
/*     */   public void read(Kryo paramKryo, Input paramInput) {
/*  31 */     super.read(paramKryo, paramInput);
/*  32 */     this.listeners = (ListenerGroup<BuffProcessorListener>)paramKryo.readObject(paramInput, ListenerGroup.class);
/*     */   }
/*     */   
/*     */   public StatisticsType getBuffCountStatistic() {
/*  36 */     return null;
/*     */   }
/*     */   
/*     */   public boolean isDebuff() {
/*  40 */     return true;
/*     */   }
/*     */   
/*     */   protected final boolean a(Enemy paramEnemy, T paramT) {
/*  44 */     if (paramEnemy.hasBuffsByType(paramT.getType())) {
/*  45 */       removeBuffAtIndex(paramEnemy, paramT.getType(), 0);
/*     */     }
/*     */     
/*  48 */     return b(paramEnemy, paramT);
/*     */   }
/*     */   
/*     */   private boolean b(Enemy paramEnemy, T paramT) {
/*  52 */     if (!paramEnemy.canBeBuffed(paramT.getType())) {
/*  53 */       return false;
/*     */     }
/*     */     
/*     */     EventListeners eventListeners;
/*  57 */     if ((eventListeners = this.S.events.getListeners(AddBuffToEnemy.class)).size() != 0) {
/*     */       AddBuffToEnemy addBuffToEnemy;
/*     */       boolean bool1;
/*  60 */       if (this.a == null) {
/*  61 */         addBuffToEnemy = new AddBuffToEnemy();
/*  62 */         bool1 = false;
/*     */       } else {
/*  64 */         addBuffToEnemy = this.a;
/*  65 */         this.a = null;
/*  66 */         bool1 = true;
/*     */       } 
/*  68 */       eventListeners.trigger((Event)addBuffToEnemy.setup(paramEnemy, (Buff)paramT));
/*  69 */       boolean bool = addBuffToEnemy.isCancelled();
/*  70 */       if (bool1) {
/*  71 */         this.a = addBuffToEnemy.reset();
/*     */       }
/*  73 */       if (bool) return false;
/*     */     
/*     */     } 
/*  76 */     paramEnemy.initBuffsByTypeArray();
/*     */ 
/*     */     
/*  79 */     if (this.S.syncChecking) {
/*  80 */       this.S.map.spawnedEnemies.begin();
/*  81 */       for (byte b1 = 0; b1 < this.S.map.spawnedEnemies.size; b1++) {
/*     */         Enemy enemy;
/*  83 */         if ((enemy = (((Enemy.EnemyReference[])this.S.map.spawnedEnemies.items)[b1]).enemy) != null)
/*     */         {
/*  85 */           if (enemy.buffsByType != null) {
/*  86 */             DelayedRemovalArray delayedRemovalArray = enemy.buffsByType[paramT.getType().ordinal()];
/*  87 */             for (byte b2 = 0; b2 < delayedRemovalArray.size; b2++) {
/*  88 */               if (delayedRemovalArray.items[b2] == paramT)
/*  89 */                 throw new IllegalStateException("Buff " + paramT + " is already applied to " + enemy + ", can't apply to " + paramEnemy); 
/*     */             } 
/*     */           } 
/*     */         }
/*     */       } 
/*  94 */       this.S.map.spawnedEnemies.end();
/*     */     } 
/*     */     
/*  97 */     paramEnemy.buffsByType[paramT.getType().ordinal()].add(paramT);
/*     */     
/*  99 */     this.listeners.begin();
/* 100 */     for (byte b = 0; b < this.listeners.size(); b++) {
/* 101 */       ((BuffProcessorListener)this.listeners.get(b)).buffAdded(paramEnemy, (Buff)paramT);
/*     */     }
/* 103 */     this.listeners.end();
/*     */     
/* 105 */     this.S.statistics.addStatistic(StatisticsType.EB, 1.0D);
/* 106 */     if (paramEnemy.buffsAppliedByType == null)
/* 107 */       paramEnemy.buffsAppliedByType = new boolean[BuffType.values.length]; 
/*     */     StatisticsType statisticsType;
/* 109 */     if (!paramEnemy.buffsAppliedByType[paramT.getType().ordinal()] && (
/*     */       
/* 111 */       statisticsType = getBuffCountStatistic()) != null) {
/* 112 */       this.S.statistics.addStatistic(statisticsType, 1.0D);
/* 113 */       paramEnemy.buffsAppliedByType[paramT.getType().ordinal()] = true;
/*     */     } 
/*     */ 
/*     */     
/* 117 */     if (this.S.achievement.isActive()) {
/* 118 */       byte b1 = 0; int i; DelayedRemovalArray[] arrayOfDelayedRemovalArray; byte b2;
/* 119 */       for (i = (arrayOfDelayedRemovalArray = paramEnemy.buffsByType).length, b2 = 0; b2 < i; b2++) {
/* 120 */         DelayedRemovalArray delayedRemovalArray; if (((Array)(delayedRemovalArray = arrayOfDelayedRemovalArray[b2])).size != 0) b1++; 
/*     */       } 
/* 122 */       this.S.achievement.setProgress(AchievementType.MASS_BUFF_ENEMY, b1);
/*     */     } 
/*     */     
/* 125 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean addBuff(Enemy paramEnemy, T paramT) {
/* 132 */     return b(paramEnemy, paramT);
/*     */   }
/*     */   
/*     */   public void removeBuffAtIndex(Enemy paramEnemy, BuffType paramBuffType, int paramInt) {
/* 136 */     Buff buff = ((Buff[])((Array)paramEnemy.buffsByType[paramBuffType.ordinal()]).items)[paramInt];
/*     */     
/* 138 */     this.listeners.begin();
/* 139 */     for (byte b = 0; b < this.listeners.size(); b++) {
/* 140 */       ((BuffProcessorListener)this.listeners.get(b)).buffRemoved(paramEnemy, buff);
/*     */     }
/* 142 */     this.listeners.end();
/*     */     
/* 144 */     paramEnemy.buffsByType[paramBuffType.ordinal()].removeIndex(paramInt);
/*     */     
/* 146 */     this.S.events.trigger((Event)new RemoveBuffFromEnemy(paramEnemy, buff));
/*     */   }
/*     */   
/*     */   public void removeBuff(Enemy paramEnemy, T paramT) {
/* 150 */     if (paramEnemy.buffsByType == null)
/*     */       return;  int i;
/* 152 */     if ((i = paramEnemy.buffsByType[paramT.getType().ordinal()].indexOf(paramT, true)) != -1) {
/* 153 */       removeBuffAtIndex(paramEnemy, paramT.getType(), i);
/*     */     }
/*     */   }
/*     */   
/*     */   public void removeAllBuffs(Enemy paramEnemy, BuffType paramBuffType) {
/* 158 */     if (paramEnemy.buffsByType == null) {
/*     */       return;
/*     */     }
/*     */     DelayedRemovalArray delayedRemovalArray;
/* 162 */     (delayedRemovalArray = paramEnemy.buffsByType[paramBuffType.ordinal()]).begin();
/* 163 */     for (byte b = 0; b < delayedRemovalArray.size; b++) {
/* 164 */       removeBuffAtIndex(paramEnemy, paramBuffType, b);
/*     */     }
/* 166 */     delayedRemovalArray.end();
/*     */   }
/*     */   
/*     */   public void update(float paramFloat) {}
/*     */   
/*     */   @REGS(classOnly = true)
/*     */   public static interface BuffProcessorListener extends GameListener {
/*     */     void buffAdded(Enemy param1Enemy, Buff param1Buff);
/*     */     
/*     */     void buffRemoved(Enemy param1Enemy, Buff param1Buff);
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\BuffProcessor.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */