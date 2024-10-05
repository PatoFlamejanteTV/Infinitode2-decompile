/*     */ package com.prineside.tdi2.buffs.processors;
/*     */ 
/*     */ import com.badlogic.gdx.graphics.g2d.ParticleEffect;
/*     */ import com.badlogic.gdx.graphics.g2d.ParticleEffectPool;
/*     */ import com.badlogic.gdx.utils.DelayedRemovalArray;
/*     */ import com.badlogic.gdx.utils.ObjectMap;
/*     */ import com.esotericsoftware.kryo.Kryo;
/*     */ import com.esotericsoftware.kryo.KryoSerializable;
/*     */ import com.esotericsoftware.kryo.io.Input;
/*     */ import com.esotericsoftware.kryo.io.Output;
/*     */ import com.prineside.tdi2.Buff;
/*     */ import com.prineside.tdi2.BuffProcessor;
/*     */ import com.prineside.tdi2.Enemy;
/*     */ import com.prineside.tdi2.Game;
/*     */ import com.prineside.tdi2.GameSystemProvider;
/*     */ import com.prineside.tdi2.Tile;
/*     */ import com.prineside.tdi2.buffs.RegenerationBuff;
/*     */ import com.prineside.tdi2.enums.BuffType;
/*     */ import com.prineside.tdi2.enums.StatisticsType;
/*     */ import com.prineside.tdi2.events.Event;
/*     */ import com.prineside.tdi2.events.Listener;
/*     */ import com.prineside.tdi2.events.game.EnemyDie;
/*     */ import com.prineside.tdi2.events.game.EnemyReachTarget;
/*     */ import com.prineside.tdi2.utils.FrameAccumulatorForPerformance;
/*     */ import com.prineside.tdi2.utils.NAGS;
/*     */ import com.prineside.tdi2.utils.NoFieldKryoSerializable;
/*     */ import com.prineside.tdi2.utils.REGS;
/*     */ 
/*     */ @REGS
/*     */ public final class RegenerationBuffProcessor extends BuffProcessor<RegenerationBuff> {
/*  31 */   private OnEnemyDie b = new OnEnemyDie(); @NAGS
/*  32 */   private ParticleEffectPool a; private OnEnemyReachTarget c = new OnEnemyReachTarget((byte)0);
/*     */   
/*     */   @FrameAccumulatorForPerformance
/*     */   private byte d;
/*     */ 
/*     */   
/*     */   public final void write(Kryo paramKryo, Output paramOutput) {
/*  39 */     super.write(paramKryo, paramOutput);
/*  40 */     paramKryo.writeObject(paramOutput, this.b);
/*  41 */     paramKryo.writeObject(paramOutput, this.c);
/*  42 */     paramOutput.writeByte(this.d);
/*     */   }
/*     */ 
/*     */   
/*     */   public final void read(Kryo paramKryo, Input paramInput) {
/*  47 */     super.read(paramKryo, paramInput);
/*  48 */     this.b = (OnEnemyDie)paramKryo.readObject(paramInput, OnEnemyDie.class);
/*  49 */     this.c = (OnEnemyReachTarget)paramKryo.readObject(paramInput, OnEnemyReachTarget.class);
/*  50 */     this.d = paramInput.readByte();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public RegenerationBuffProcessor() {
/*  56 */     if (Game.i.assetManager != null) {
/*  57 */       this.a = Game.i.assetManager.getParticleEffectPool("regeneration.prt");
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public final boolean isDebuff() {
/*  63 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public final void setRegistered(GameSystemProvider paramGameSystemProvider) {
/*  68 */     super.setRegistered(paramGameSystemProvider);
/*  69 */     paramGameSystemProvider.events.getListeners(EnemyDie.class).addStateAffecting(this.b);
/*  70 */     paramGameSystemProvider.events.getListeners(EnemyReachTarget.class).addStateAffecting(this.c);
/*     */   }
/*     */ 
/*     */   
/*     */   public final void setUnregistered() {
/*  75 */     this.S.events.getListeners(EnemyDie.class).remove(this.b);
/*  76 */     this.S.events.getListeners(EnemyReachTarget.class).remove(this.c);
/*  77 */     super.setUnregistered();
/*     */   }
/*     */ 
/*     */   
/*     */   public final StatisticsType getBuffCountStatistic() {
/*  82 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   public final boolean addBuff(Enemy paramEnemy, RegenerationBuff paramRegenerationBuff) {
/*  87 */     return addBuffStackSameSourceRemoveOthers(paramEnemy, paramRegenerationBuff, false);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final boolean addBuffStackSameSourceRemoveOthers(Enemy paramEnemy, RegenerationBuff paramRegenerationBuff, boolean paramBoolean) {
/*     */     // Byte code:
/*     */     //   0: iconst_1
/*     */     //   1: istore #4
/*     */     //   3: aload_1
/*     */     //   4: getstatic com/prineside/tdi2/enums/BuffType.REGENERATION : Lcom/prineside/tdi2/enums/BuffType;
/*     */     //   7: invokevirtual getBuffsByTypeOrNull : (Lcom/prineside/tdi2/enums/BuffType;)Lcom/badlogic/gdx/utils/DelayedRemovalArray;
/*     */     //   10: dup
/*     */     //   11: astore #5
/*     */     //   13: ifnull -> 154
/*     */     //   16: aload #5
/*     */     //   18: getfield size : I
/*     */     //   21: ifeq -> 154
/*     */     //   24: aload #5
/*     */     //   26: invokevirtual first : ()Ljava/lang/Object;
/*     */     //   29: checkcast com/prineside/tdi2/buffs/RegenerationBuff
/*     */     //   32: astore #5
/*     */     //   34: iload_3
/*     */     //   35: ifeq -> 115
/*     */     //   38: aload #5
/*     */     //   40: getfield issuer : Lcom/prineside/tdi2/Enemy$EnemyReference;
/*     */     //   43: aload_2
/*     */     //   44: getfield issuer : Lcom/prineside/tdi2/Enemy$EnemyReference;
/*     */     //   47: if_acmpne -> 103
/*     */     //   50: aload #5
/*     */     //   52: getfield duration : F
/*     */     //   55: aload #5
/*     */     //   57: getfield hpPerSecond : F
/*     */     //   60: fmul
/*     */     //   61: aload_2
/*     */     //   62: getfield duration : F
/*     */     //   65: aload_2
/*     */     //   66: getfield hpPerSecond : F
/*     */     //   69: fmul
/*     */     //   70: fadd
/*     */     //   71: fstore_3
/*     */     //   72: aload #5
/*     */     //   74: dup
/*     */     //   75: getfield duration : F
/*     */     //   78: aload_2
/*     */     //   79: getfield duration : F
/*     */     //   82: invokestatic max : (FF)F
/*     */     //   85: putfield duration : F
/*     */     //   88: aload #5
/*     */     //   90: fload_3
/*     */     //   91: aload #5
/*     */     //   93: getfield duration : F
/*     */     //   96: fdiv
/*     */     //   97: putfield hpPerSecond : F
/*     */     //   100: goto -> 151
/*     */     //   103: aload_0
/*     */     //   104: aload_1
/*     */     //   105: getstatic com/prineside/tdi2/enums/BuffType.REGENERATION : Lcom/prineside/tdi2/enums/BuffType;
/*     */     //   108: iconst_0
/*     */     //   109: invokevirtual removeBuffAtIndex : (Lcom/prineside/tdi2/Enemy;Lcom/prineside/tdi2/enums/BuffType;I)V
/*     */     //   112: goto -> 154
/*     */     //   115: aload #5
/*     */     //   117: getfield hpPerSecond : F
/*     */     //   120: aload #5
/*     */     //   122: getfield duration : F
/*     */     //   125: fmul
/*     */     //   126: aload_2
/*     */     //   127: getfield duration : F
/*     */     //   130: aload_2
/*     */     //   131: getfield hpPerSecond : F
/*     */     //   134: fmul
/*     */     //   135: fcmpg
/*     */     //   136: ifge -> 151
/*     */     //   139: aload_0
/*     */     //   140: aload_1
/*     */     //   141: getstatic com/prineside/tdi2/enums/BuffType.REGENERATION : Lcom/prineside/tdi2/enums/BuffType;
/*     */     //   144: iconst_0
/*     */     //   145: invokevirtual removeBuffAtIndex : (Lcom/prineside/tdi2/Enemy;Lcom/prineside/tdi2/enums/BuffType;I)V
/*     */     //   148: goto -> 154
/*     */     //   151: iconst_0
/*     */     //   152: istore #4
/*     */     //   154: iload #4
/*     */     //   156: ifeq -> 166
/*     */     //   159: aload_0
/*     */     //   160: aload_1
/*     */     //   161: aload_2
/*     */     //   162: invokespecial addBuff : (Lcom/prineside/tdi2/Enemy;Lcom/prineside/tdi2/Buff;)Z
/*     */     //   165: ireturn
/*     */     //   166: iconst_0
/*     */     //   167: ireturn
/*     */     // Line number table:
/*     */     //   Java source line number -> byte code offset
/*     */     //   #91	-> 0
/*     */     //   #94	-> 3
/*     */     //   #95	-> 11
/*     */     //   #97	-> 24
/*     */     //   #99	-> 34
/*     */     //   #100	-> 38
/*     */     //   #103	-> 50
/*     */     //   #104	-> 72
/*     */     //   #105	-> 88
/*     */     //   #107	-> 100
/*     */     //   #109	-> 103
/*     */     //   #112	-> 115
/*     */     //   #114	-> 139
/*     */     //   #117	-> 151
/*     */     //   #122	-> 154
/*     */     //   #123	-> 159
/*     */     //   #125	-> 166
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final void update(float paramFloat) {
/* 132 */     this.d = (byte)(this.d + 1);
/* 133 */     if (this.d == 2) {
/* 134 */       paramFloat *= 2.0F;
/* 135 */       this.d = 0;
/*     */       
/* 137 */       this.S.map.spawnedEnemies.begin(); byte b; int i;
/* 138 */       for (b = 0, i = this.S.map.spawnedEnemies.size; b < i; b++) {
/*     */         Enemy enemy;
/* 140 */         if ((enemy = (((Enemy.EnemyReference[])this.S.map.spawnedEnemies.items)[b]).enemy) != null) {
/*     */           
/* 142 */           boolean bool = false;
/*     */           
/*     */           DelayedRemovalArray delayedRemovalArray;
/*     */           
/* 146 */           if ((delayedRemovalArray = enemy.getBuffsByTypeOrNull(BuffType.REGENERATION)) != null && delayedRemovalArray.size != 0) {
/*     */             
/* 148 */             delayedRemovalArray.begin(); byte b1; int j;
/* 149 */             for (b1 = 0, j = delayedRemovalArray.size; b1 < j; b1++) {
/* 150 */               if (enemy.getHealth() < enemy.maxHealth) {
/*     */                 RegenerationBuff regenerationBuff;
/*     */                 
/* 153 */                 float f = (regenerationBuff = (RegenerationBuff)delayedRemovalArray.get(b1)).hpPerSecond * paramFloat;
/*     */                 
/* 155 */                 if ((f = enemy.getHealth() + f) > enemy.maxHealth) f = enemy.maxHealth; 
/* 156 */                 enemy.setHealth(f);
/* 157 */                 bool = true;
/*     */               } 
/* 159 */             }  delayedRemovalArray.end();
/*     */           } 
/*     */           
/* 162 */           if (bool) {
/* 163 */             if ((enemy.attachedParticles == null || !enemy.attachedParticles.containsKey("RegenerationBuff")) && this.S._particle != null && Game.i.settingsManager.isParticlesDrawing() && !this.S._particle.willParticleBeSkipped() && 
/* 164 */               enemy.otherEnemiesNearby < 8) {
/*     */               ParticleEffectPool.PooledEffect pooledEffect;
/*     */               
/* 167 */               (pooledEffect = (ParticleEffectPool.PooledEffect)this.a.obtain()).setPosition((enemy.getPosition()).x, (enemy.getPosition()).y);
/* 168 */               if (enemy.attachedParticles == null) {
/* 169 */                 enemy.attachedParticles = new ObjectMap();
/*     */               }
/* 171 */               enemy.attachedParticles.put("RegenerationBuff", pooledEffect);
/* 172 */               this.S._particle.addParticle((ParticleEffect)pooledEffect, true);
/*     */             }
/*     */           
/*     */           }
/* 176 */           else if (enemy.attachedParticles != null && enemy.attachedParticles.containsKey("RegenerationBuff")) {
/* 177 */             ((ParticleEffectPool.PooledEffect)enemy.attachedParticles.remove("RegenerationBuff")).allowCompletion();
/* 178 */             if (enemy.attachedParticles.size == 0) {
/* 179 */               enemy.attachedParticles = null;
/*     */             }
/*     */           } 
/*     */         } 
/*     */       } 
/* 184 */       this.S.map.spawnedEnemies.end();
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   @REGS
/*     */   public static final class OnEnemyReachTarget
/*     */     implements KryoSerializable, Listener<EnemyReachTarget>
/*     */   {
/*     */     public final void write(Kryo param1Kryo, Output param1Output) {}
/*     */ 
/*     */     
/*     */     public final void read(Kryo param1Kryo, Input param1Input) {}
/*     */ 
/*     */     
/*     */     private OnEnemyReachTarget() {}
/*     */     
/*     */     public final void handleEvent(EnemyReachTarget param1EnemyReachTarget) {
/*     */       Enemy enemy;
/*     */       Tile tile;
/* 204 */       if (tile = param1EnemyReachTarget.getEnemy().getCurrentTile() instanceof com.prineside.tdi2.tiles.TargetTile && 
/*     */         
/* 206 */         (enemy = param1EnemyReachTarget.getEnemy()).attachedParticles != null && enemy.attachedParticles.containsKey("RegenerationBuff")) {
/* 207 */         ((ParticleEffectPool.PooledEffect)enemy.attachedParticles.remove("RegenerationBuff")).allowCompletion();
/* 208 */         if (enemy.attachedParticles.size == 0) {
/* 209 */           enemy.attachedParticles = null;
/*     */         }
/*     */       } 
/*     */     }
/*     */   }
/*     */   
/*     */   @REGS
/*     */   public static final class OnEnemyDie
/*     */     implements Listener<EnemyDie>, NoFieldKryoSerializable
/*     */   {
/*     */     public final void handleEvent(EnemyDie param1EnemyDie) {
/*     */       Enemy enemy;
/* 221 */       if ((enemy = param1EnemyDie.getLastDamage().getEnemy()).attachedParticles != null && enemy.attachedParticles.containsKey("RegenerationBuff")) {
/* 222 */         ((ParticleEffectPool.PooledEffect)enemy.attachedParticles.remove("RegenerationBuff")).allowCompletion();
/* 223 */         if (enemy.attachedParticles.size == 0)
/* 224 */           enemy.attachedParticles = null; 
/*     */       } 
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\buffs\processors\RegenerationBuffProcessor.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */