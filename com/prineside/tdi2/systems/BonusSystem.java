/*     */ package com.prineside.tdi2.systems;
/*     */ 
/*     */ import com.badlogic.gdx.math.RandomXS128;
/*     */ import com.badlogic.gdx.utils.Array;
/*     */ import com.badlogic.gdx.utils.DelayedRemovalArray;
/*     */ import com.badlogic.gdx.utils.IntArray;
/*     */ import com.badlogic.gdx.utils.Null;
/*     */ import com.esotericsoftware.kryo.Kryo;
/*     */ import com.esotericsoftware.kryo.KryoSerializable;
/*     */ import com.esotericsoftware.kryo.io.Input;
/*     */ import com.esotericsoftware.kryo.io.Output;
/*     */ import com.google.common.base.Preconditions;
/*     */ import com.prineside.tdi2.Action;
/*     */ import com.prineside.tdi2.Config;
/*     */ import com.prineside.tdi2.Enemy;
/*     */ import com.prineside.tdi2.GameSystem;
/*     */ import com.prineside.tdi2.SerializableListener;
/*     */ import com.prineside.tdi2.actions.ReRollBonusesAction;
/*     */ import com.prineside.tdi2.actions.SelectGameplayBonusAction;
/*     */ import com.prineside.tdi2.enums.ActionType;
/*     */ import com.prineside.tdi2.enums.BuffType;
/*     */ import com.prineside.tdi2.events.Event;
/*     */ import com.prineside.tdi2.events.Listener;
/*     */ import com.prineside.tdi2.events.game.BonusPointsUpdate;
/*     */ import com.prineside.tdi2.events.game.BonusSelect;
/*     */ import com.prineside.tdi2.events.game.BonusStageRequirementMet;
/*     */ import com.prineside.tdi2.events.game.BonusStagesConfigSet;
/*     */ import com.prineside.tdi2.events.game.BonusesReRoll;
/*     */ import com.prineside.tdi2.events.game.EnemyDie;
/*     */ import com.prineside.tdi2.gameplayMods.BonusStagesConfig;
/*     */ import com.prineside.tdi2.gameplayMods.GameplayMod;
/*     */ import com.prineside.tdi2.gameplayMods.ProbableBonus;
/*     */ import com.prineside.tdi2.gameplayMods.mods.ReceiveGreenPapers;
/*     */ import com.prineside.tdi2.utils.FastRandom;
/*     */ import com.prineside.tdi2.utils.NAGS;
/*     */ import com.prineside.tdi2.utils.ObjectSupplier;
/*     */ import com.prineside.tdi2.utils.REGS;
/*     */ import com.prineside.tdi2.utils.logging.TLog;
/*     */ 
/*     */ @REGS
/*     */ public final class BonusSystem
/*     */   extends GameSystem
/*     */ {
/*  44 */   private static final TLog a = TLog.forClass(BonusSystem.class);
/*     */   
/*     */   public static final String GAMEPLAY_MOD_SOURCE_NAME = "BonusSystem";
/*     */   
/*     */   public static final int MAX_TECHNICAL_BONUS_STAGES = 2048;
/*     */   
/*     */   public static final int FORCED_SELECTION_MAX_FRAME_DELAY = 3;
/*     */   public static final int BONUSES_TO_CHOOSE_COUNT = 3;
/*     */   private BonusStagesConfig b;
/*  53 */   private int c = 1;
/*     */   
/*     */   public boolean additionalBonusToSelectFrom;
/*     */   @NAGS
/*     */   public boolean autoSelectionOnSingleBonus;
/*  58 */   public IntArray selectedBonuses = new IntArray();
/*  59 */   public IntArray stageReRolls = new IntArray();
/*     */   @NAGS
/*  61 */   private final RandomXS128 d = new RandomXS128();
/*     */   
/*  63 */   private Array<BonusStage> e = new Array(true, 1, BonusStage.class);
/*     */ 
/*     */   
/*     */   public final void write(Kryo paramKryo, Output paramOutput) {
/*  67 */     super.write(paramKryo, paramOutput);
/*     */     
/*  69 */     paramKryo.writeObjectOrNull(paramOutput, this.b, BonusStagesConfig.class);
/*  70 */     paramOutput.writeVarInt(this.c, true);
/*  71 */     paramOutput.writeBoolean(this.additionalBonusToSelectFrom);
/*  72 */     paramKryo.writeObject(paramOutput, this.selectedBonuses);
/*  73 */     paramKryo.writeObject(paramOutput, this.stageReRolls);
/*  74 */     paramKryo.writeObject(paramOutput, this.e);
/*     */   }
/*     */ 
/*     */   
/*     */   public final void read(Kryo paramKryo, Input paramInput) {
/*  79 */     super.read(paramKryo, paramInput);
/*     */     
/*  81 */     this.b = (BonusStagesConfig)paramKryo.readObjectOrNull(paramInput, BonusStagesConfig.class);
/*  82 */     this.c = paramInput.readVarInt(true);
/*  83 */     this.additionalBonusToSelectFrom = paramInput.readBoolean();
/*  84 */     this.selectedBonuses = (IntArray)paramKryo.readObject(paramInput, IntArray.class);
/*  85 */     this.stageReRolls = (IntArray)paramKryo.readObject(paramInput, IntArray.class);
/*  86 */     this.e = (Array<BonusStage>)paramKryo.readObject(paramInput, Array.class);
/*     */   }
/*     */   
/*     */   public final int getBonusesToChooseCount() {
/*  90 */     if (this.additionalBonusToSelectFrom) {
/*  91 */       return 4;
/*     */     }
/*  93 */     return 3;
/*     */   }
/*     */ 
/*     */   
/*     */   public final boolean isAutoSelectionOnSingleBonus() {
/*  98 */     return this.autoSelectionOnSingleBonus;
/*     */   }
/*     */   
/*     */   public final void setAutoSelectionOnSingleBonus(boolean paramBoolean) {
/* 102 */     this.autoSelectionOnSingleBonus = paramBoolean;
/*     */   }
/*     */   @Null
/*     */   public final BonusStage getStageToChooseBonusFor() {
/* 106 */     if (!isEnabled())
/* 107 */       return null;  byte b;
/*     */     int i;
/* 109 */     for (b = 1, i = getMaxTechnicalBonusStages(); b <= i; b++) {
/*     */       BonusStage bonusStage;
/* 111 */       if ((bonusStage = getBonusStage(b)) == null) {
/* 112 */         return null;
/*     */       }
/* 114 */       if (bonusStage.canSelectBonus()) {
/* 115 */         return bonusStage;
/*     */       }
/*     */     } 
/*     */     
/* 119 */     return null;
/*     */   }
/*     */   
/*     */   public final int getMaxBonusStages() {
/* 123 */     if (!isEnabled()) {
/* 124 */       return 0;
/*     */     }
/* 126 */     return this.b.getMaxStages();
/*     */   }
/*     */   
/*     */   public final int getMaxTechnicalBonusStages() {
/* 130 */     if (!isEnabled()) {
/* 131 */       return 0;
/*     */     }
/*     */     
/*     */     int i;
/* 135 */     if ((i = this.b.getMaxStages()) <= 0) {
/* 136 */       return 2048;
/*     */     }
/* 138 */     return i;
/*     */   }
/*     */ 
/*     */   
/*     */   public final int getAllTimeReRollCount() {
/* 143 */     return this.stageReRolls.size;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final boolean canReRollBonuses(int paramInt) {
/* 150 */     if (this.b.reRollEnabled) {
/*     */       
/* 152 */       if (this.b.maxReRollsPerStage > 0) {
/*     */         
/* 154 */         byte b1 = 0;
/* 155 */         for (byte b2 = 0; b2 < this.stageReRolls.size; b2++) {
/*     */ 
/*     */           
/* 158 */           b1++; int i;
/* 159 */           if ((i = this.stageReRolls.items[b2]) == paramInt && b1 == this.b.maxReRollsPerStage) {
/* 160 */             return false;
/*     */           }
/*     */         } 
/*     */       } 
/*     */ 
/*     */       
/* 166 */       if (this.b.maxReRollsAllTime > 0 && 
/* 167 */         this.stageReRolls.size >= this.b.maxReRollsAllTime) {
/* 168 */         return false;
/*     */       }
/*     */ 
/*     */       
/* 172 */       if (this.e.size > paramInt - 1) {
/*     */         BonusStage bonusStage;
/* 174 */         if ((bonusStage = (BonusStage)this.e.get(paramInt - 1)) == null) {
/* 175 */           return true;
/*     */         }
/* 177 */         return ((a(paramInt, getBonusesToChooseCount(), bonusStage.getProbableBonuses())).size != 0);
/*     */       } 
/*     */       
/* 180 */       return true;
/*     */     } 
/* 182 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public final int getActiveBonusesCount() {
/* 187 */     DelayedRemovalArray<GameplayModSystem.ActiveMod> delayedRemovalArray = this.S.gameplayMod.getActiveMods();
/* 188 */     byte b1 = 0;
/* 189 */     for (byte b2 = 0; b2 < delayedRemovalArray.size; b2++) {
/* 190 */       if ("BonusSystem".equals(((GameplayModSystem.ActiveMod)delayedRemovalArray.get(b2)).getSource())) {
/* 191 */         b1++;
/*     */       }
/*     */     } 
/*     */     
/* 195 */     return b1;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final boolean isEnabled() {
/* 202 */     return (this.b != null);
/*     */   }
/*     */   
/*     */   public final void addProgressPoints(int paramInt) {
/* 206 */     int i = 0;
/*     */     int j;
/* 208 */     if ((j = this.b.getMaxStages()) <= 0)
/* 209 */       j = this.c + 100; 
/*     */     BonusStage bonusStage;
/* 211 */     for (int k = this.c; k <= j && (
/*     */       
/* 213 */       bonusStage = getBonusStage(k)) != null; k++) {
/*     */       int m;
/*     */ 
/*     */       
/* 217 */       if ((m = BonusStage.a(bonusStage) - BonusStage.b(bonusStage)) != 0) {
/*     */         
/* 219 */         m = Math.min(paramInt, m);
/* 220 */         BonusStage.a(bonusStage, m);
/* 221 */         i += m;
/* 222 */         paramInt -= m;
/*     */         
/* 224 */         if (BonusStage.a(bonusStage) == BonusStage.b(bonusStage)) {
/*     */           
/* 226 */           this.c = Math.min(BonusStage.c(bonusStage) + 1, getMaxTechnicalBonusStages());
/*     */           
/*     */           BonusStage bonusStage1;
/*     */           
/* 230 */           if ((bonusStage1 = getStageToChooseBonusFor()) == bonusStage) {
/* 231 */             a(bonusStage);
/* 232 */             b(bonusStage);
/*     */           } 
/*     */           
/* 235 */           this.S.events.trigger((Event)new BonusStageRequirementMet(bonusStage));
/*     */         } 
/* 237 */         if (paramInt != 0)
/*     */           continue; 
/*     */         break;
/*     */       } 
/*     */       continue;
/*     */     } 
/* 243 */     if (i != 0)
/* 244 */       this.S.events.trigger((Event)new BonusPointsUpdate()); 
/*     */   }
/*     */   
/*     */   private void a(BonusStage paramBonusStage) {
/* 248 */     BonusStage.a(paramBonusStage, (Array)this.b.getProbableBonuses(BonusStage.c(paramBonusStage), this.S));
/* 249 */     a.i("setProbableBonuses - called for stage " + BonusStage.c(paramBonusStage) + " (" + (BonusStage.d(paramBonusStage)).size + " items)", new Object[0]);
/* 250 */     for (byte b = 0; b < (BonusStage.d(paramBonusStage)).size; b++) {
/* 251 */       ProbableBonus probableBonus = (ProbableBonus)BonusStage.d(paramBonusStage).get(b);
/* 252 */       a.i(probableBonus.getProbability() + ": " + probableBonus.getBonus().getId(), new Object[0]);
/*     */     } 
/*     */   }
/*     */   
/*     */   private void b(BonusStage paramBonusStage) {
/* 257 */     BonusStage.b(paramBonusStage, a(BonusStage.c(paramBonusStage), getBonusesToChooseCount(), paramBonusStage.getProbableBonuses()));
/*     */     
/*     */     byte b1;
/* 260 */     for (b1 = 0; b1 < (BonusStage.e(paramBonusStage)).size; b1++) {
/* 261 */       GameplayMod gameplayMod = (GameplayMod)BonusStage.e(paramBonusStage).get(b1);
/* 262 */       boolean bool = false;
/* 263 */       for (byte b = 0; b < (BonusStage.d(paramBonusStage)).size; b++) {
/*     */         ProbableBonus probableBonus;
/* 265 */         if ((probableBonus = (ProbableBonus)BonusStage.d(paramBonusStage).get(b)).getBonus() == gameplayMod) {
/* 266 */           bool = true;
/* 267 */           BonusStage.d(paramBonusStage).removeIndex(b);
/*     */           break;
/*     */         } 
/*     */       } 
/* 271 */       if (!bool) {
/* 272 */         a.i("can't remove " + gameplayMod.getId() + " from stage.probableBonuses - exists in bonusesToChooseFrom but not in probableBonuses", new Object[0]);
/*     */       }
/*     */     } 
/*     */     
/* 276 */     b1 = 0;
/* 277 */     for (byte b2 = 0; b2 < (BonusStage.e(paramBonusStage)).size; b2++) {
/*     */       GameplayMod gameplayMod;
/* 279 */       if ((gameplayMod = (GameplayMod)BonusStage.e(paramBonusStage).get(b2)).getNotSatisfiedPreconditions(this.S) == null) {
/* 280 */         b1 = 1;
/*     */         break;
/*     */       } 
/*     */     } 
/* 284 */     if (b1 == 0) {
/*     */       ReceiveGreenPapers receiveGreenPapers;
/*     */       
/* 287 */       (receiveGreenPapers = ReceiveGreenPapers.BonusProvider.getInstance().provideFallback(getStagesConfig(), (Array)this.S.gameplayMod.getActiveMods())).configure(this.S);
/* 288 */       BonusStage.e(paramBonusStage).add(receiveGreenPapers);
/*     */     } 
/*     */     
/* 291 */     RandomXS128 randomXS128 = getPreparedRandom(BonusStage.c(paramBonusStage));
/* 292 */     a.i("setBonusesToChooseFrom - called for stage " + BonusStage.c(paramBonusStage) + " (" + (BonusStage.e(paramBonusStage)).size + " items), probableBonuses: " + (BonusStage.d(paramBonusStage)).size + ", random state " + randomXS128.getState(0) + ":", new Object[0]);
/* 293 */     for (byte b3 = 0; b3 < (BonusStage.e(paramBonusStage)).size; b3++) {
/* 294 */       GameplayMod gameplayMod = (GameplayMod)BonusStage.e(paramBonusStage).get(b3);
/* 295 */       a.i("- " + gameplayMod.getId(), new Object[0]);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public final boolean affectsGameState() {
/* 301 */     return true;
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
/*     */   public final void setup() {
/* 313 */     this.S.events.getListeners(EnemyDie.class).addStateAffecting(new OnEnemyDie(this));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final void setStagesConfig(BonusStagesConfig paramBonusStagesConfig) {
/* 324 */     a.i("setStagesConfig " + paramBonusStagesConfig, new Object[0]);
/*     */ 
/*     */     
/* 327 */     if ((paramBonusStagesConfig = paramBonusStagesConfig.cpy()).seed == -2) {
/* 328 */       if (this.S.gameState.dailyQuestLevel != null) {
/* 329 */         paramBonusStagesConfig.seed = this.S.gameState.dailyQuestLevel.forDateTimestamp;
/* 330 */         a.i("setting bonus stages seed to daily quest timestamp: " + this.S.gameState.dailyQuestLevel.forDateTimestamp, new Object[0]);
/*     */       } else {
/* 332 */         a.i("stage config seed to SEED_TAKE_FROM_DAILY_QUEST but not in a daily quest", new Object[0]);
/* 333 */         paramBonusStagesConfig.seed = -1;
/*     */       } 
/*     */     }
/* 336 */     if (paramBonusStagesConfig.seed == -1) {
/* 337 */       paramBonusStagesConfig.seed = (int)this.S.gameState.getSeed();
/* 338 */       a.i("setting bonus stages seed from main seed: " + paramBonusStagesConfig.seed, new Object[0]);
/*     */     } 
/* 340 */     if (paramBonusStagesConfig.seed == 0) {
/* 341 */       paramBonusStagesConfig.seed = this.S.gameState.randomIntIndependent(2147483647, this.S.gameState.gameStartTimestamp);
/* 342 */       a.i("setting random bonus stages seed from game start timestamp: " + paramBonusStagesConfig.seed, new Object[0]);
/*     */     } 
/*     */     
/* 345 */     this.b = paramBonusStagesConfig;
/*     */     
/* 347 */     this.e.clear();
/*     */     
/* 349 */     this.S.events.trigger((Event)new BonusStagesConfigSet());
/*     */   }
/*     */   @Null
/*     */   public final BonusStage getBonusStage(int paramInt) {
/* 353 */     int i = getMaxTechnicalBonusStages();
/*     */     
/* 355 */     if (paramInt > i) {
/* 356 */       return null;
/*     */     }
/* 358 */     BonusStage bonusStage = null;
/* 359 */     if (this.e.size > paramInt - 1) {
/* 360 */       bonusStage = (BonusStage)this.e.get(paramInt - 1);
/*     */     } else {
/* 362 */       this.e.setSize(paramInt);
/*     */     } 
/* 364 */     if (bonusStage == null) {
/* 365 */       bonusStage = new BonusStage(paramInt, this.b.getStageRequirement(paramInt));
/* 366 */       this.e.set(paramInt - 1, bonusStage);
/*     */     } 
/*     */     
/* 369 */     return bonusStage;
/*     */   }
/*     */ 
/*     */   
/*     */   public final BonusStagesConfig getStagesConfig() {
/* 374 */     return this.b;
/*     */   }
/*     */   
/*     */   public final void reRollBonusesAction() {
/*     */     BonusStage bonusStage;
/* 379 */     if ((bonusStage = getStageToChooseBonusFor()) != null) {
/* 380 */       if (canReRollBonuses(BonusStage.c(bonusStage))) {
/* 381 */         int i = this.b.getReRollPrice(BonusStage.c(bonusStage), this.S);
/* 382 */         if (this.S.gameState.getMoney() >= i) {
/* 383 */           this.S.gameState.pushActionNextUpdate((Action)new ReRollBonusesAction());
/*     */         } else {
/* 385 */           a.i("reRollBonusesAction skipped - not enough coins (" + this.S.gameState.getMoney() + " / " + i + ")", new Object[0]); return;
/*     */         } 
/*     */       } else {
/* 388 */         a.i("reRollBonusesAction skipped - disabled by config", new Object[0]); return;
/*     */       } 
/*     */     } else {
/* 391 */       a.i("reRollBonusesAction skipped - bonus selection not available now", new Object[0]);
/*     */     } 
/*     */   }
/*     */   
/*     */   public final void selectBonusAction(int paramInt) {
/*     */     BonusStage bonusStage;
/* 397 */     if ((bonusStage = getStageToChooseBonusFor()) != null) {
/* 398 */       if (paramInt >= 0 && paramInt < (bonusStage.getBonusesToChooseFrom()).size) {
/*     */         GameplayMod gameplayMod;
/*     */         ObjectSupplier objectSupplier;
/* 401 */         if ((objectSupplier = (gameplayMod = (GameplayMod)bonusStage.getBonusesToChooseFrom().get(paramInt)).getNotSatisfiedPreconditions(this.S)) == null) {
/* 402 */           this.S.gameState.pushActionNextUpdate((Action)new SelectGameplayBonusAction(BonusStage.c(bonusStage), paramInt));
/*     */         }
/* 404 */         else if (Config.isHeadless()) {
/* 405 */           a.i("selectBonusAction skipped - bonus preconditions not satisfied (" + gameplayMod + ")", new Object[0]);
/*     */         } else {
/* 407 */           a.i("selectBonusAction skipped - bonus preconditions not satisfied (" + gameplayMod + "): " + objectSupplier.get(), new Object[0]);
/*     */           return;
/*     */         } 
/*     */       } else {
/* 411 */         a.i("invalid bonus idx " + paramInt, new Object[0]); return;
/*     */       } 
/*     */     } else {
/* 414 */       a.i("selectBonusAction skipped - bonus selection not available now", new Object[0]);
/*     */     } 
/*     */   }
/*     */   
/*     */   public final void setSelectedBonus(int paramInt1, int paramInt2) {
/*     */     BonusStage bonusStage1, bonusStage2;
/* 420 */     if ((bonusStage2 = getBonusStage(paramInt1)) != null && bonusStage2.canSelectBonus()) {
/*     */       Array<GameplayMod> array;
/* 422 */       GameplayMod gameplayMod = (GameplayMod)(array = bonusStage2.getBonusesToChooseFrom()).get(paramInt2);
/* 423 */       a.i("enabling bonus " + gameplayMod.getId() + " on stage " + bonusStage2, new Object[0]);
/*     */       ObjectSupplier objectSupplier;
/* 425 */       if ((objectSupplier = gameplayMod.getNotSatisfiedPreconditions(this.S)) != null) {
/* 426 */         if (Config.isHeadless()) {
/* 427 */           a.e("bonus selection failed - preconditions not satisfied " + gameplayMod.getId(), new Object[0]); return;
/*     */         } 
/* 429 */         a.e("bonus selection failed - preconditions not satisfied " + gameplayMod.getId() + ": " + objectSupplier.get(), new Object[0]);
/*     */         
/*     */         return;
/*     */       } 
/*     */       
/* 434 */       while (this.selectedBonuses.size <= paramInt1) {
/* 435 */         this.selectedBonuses.add(0);
/*     */       }
/* 437 */       this.selectedBonuses.set(paramInt1 - 1, paramInt2);
/*     */       
/* 439 */       this.S.gameplayMod.activateMod(gameplayMod, "BonusSystem");
/* 440 */       a.i("enabled bonus " + gameplayMod.getId() + " on stage " + bonusStage2, new Object[0]);
/* 441 */       BonusStage.a(bonusStage2, Integer.valueOf(paramInt2));
/* 442 */       BonusStage.b(bonusStage2, null);
/* 443 */       BonusStage.a(bonusStage2, (Array)null);
/*     */       
/* 445 */       this.S.events.trigger((Event)new BonusSelect(paramInt1));
/*     */ 
/*     */ 
/*     */       
/* 449 */       if ((bonusStage1 = getStageToChooseBonusFor()) != null) {
/* 450 */         a(bonusStage1);
/* 451 */         b(bonusStage1);
/*     */       }  return;
/*     */     } 
/* 454 */     a.e("bonus selection not available for stage " + bonusStage1, new Object[0]);
/*     */   }
/*     */ 
/*     */   
/*     */   public final void reRollBonuses() {
/*     */     BonusStage bonusStage;
/* 460 */     if ((bonusStage = getStageToChooseBonusFor()) == null) {
/* 461 */       throw new IllegalStateException("No stage to re-roll for");
/*     */     }
/*     */ 
/*     */     
/* 465 */     this.stageReRolls.add(BonusStage.c(bonusStage));
/*     */     
/* 467 */     a.i("reRollBonuses called", new Object[0]);
/*     */ 
/*     */ 
/*     */     
/* 471 */     b(bonusStage);
/*     */     
/* 473 */     bonusStage.setAvailableOnFrame(this.S.gameState.updateNumber);
/*     */     
/* 475 */     this.S.events.trigger((Event)new BonusesReRoll());
/*     */   }
/*     */   
/*     */   private void a() {
/* 479 */     long l1 = this.d.nextLong();
/* 480 */     long l2 = this.d.nextLong();
/* 481 */     this.d.setState(l1, l2);
/*     */   }
/*     */   
/*     */   public final RandomXS128 getPreparedRandom(int paramInt) {
/* 485 */     this.d.setSeed(this.b.seed); byte b;
/* 486 */     for (b = 0; b < paramInt; b++) {
/* 487 */       this.d.nextLong();
/*     */     }
/*     */     
/* 490 */     if (this.b.selectedBonusAffectsRandom) {
/* 491 */       for (b = 0; b < Math.min(this.selectedBonuses.size, paramInt); b++) {
/* 492 */         a();
/*     */         
/* 494 */         int i = this.selectedBonuses.get(b);
/* 495 */         for (byte b1 = 0; b1 < i; b1++) {
/* 496 */           a();
/*     */         }
/*     */       } 
/*     */     }
/* 500 */     a();
/*     */     
/* 502 */     if (this.b.chainReRoll) {
/*     */       
/* 504 */       for (b = 0; b < this.stageReRolls.size; b++) {
/* 505 */         if (this.stageReRolls.get(b) <= paramInt) {
/* 506 */           a();
/*     */         }
/*     */       } 
/*     */     } else {
/*     */       
/* 511 */       for (b = 0; b < this.stageReRolls.size; b++) {
/* 512 */         if (this.stageReRolls.get(b) == paramInt) {
/* 513 */           a();
/*     */         }
/*     */       } 
/*     */     } 
/*     */     
/* 518 */     return this.d;
/*     */   }
/*     */   
/*     */   public final void resetState() {
/* 522 */     this.selectedBonuses.clear();
/* 523 */     this.stageReRolls.clear();
/*     */   }
/*     */   
/*     */   public final int getCurrentlyProgressingStage() {
/* 527 */     return this.c;
/*     */   }
/*     */   
/*     */   public final int getCurrentVisualProgressStageNumber() {
/*     */     BonusStage bonusStage;
/* 532 */     if ((bonusStage = getStageToChooseBonusFor()) != null) {
/* 533 */       return BonusStage.c(bonusStage);
/*     */     }
/* 535 */     return this.c;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private Array<GameplayMod> a(int paramInt1, int paramInt2, Array<ProbableBonus> paramArray) {
/* 545 */     paramArray = new Array(paramArray);
/*     */     
/* 547 */     RandomXS128 randomXS128 = getPreparedRandom(paramInt1);
/*     */     
/* 549 */     DelayedRemovalArray delayedRemovalArray = new DelayedRemovalArray(true, paramInt2, GameplayMod.class);
/*     */     
/* 551 */     long l = 0L; byte b;
/* 552 */     for (b = 0; b < paramArray.size; b++) {
/* 553 */       l += ((ProbableBonus)paramArray.get(b)).getProbability();
/*     */     }
/* 555 */     if (l == 0L)
/*     */     {
/* 557 */       return (Array<GameplayMod>)delayedRemovalArray;
/*     */     }
/*     */     
/* 560 */     for (b = 0; b < paramInt2 && 
/* 561 */       paramArray.size != 0; b++) {
/*     */       
/* 563 */       long l1 = randomXS128.nextLong(l);
/* 564 */       long l2 = 0L;
/* 565 */       for (byte b1 = 0; b1 < paramArray.size; b1++) {
/* 566 */         ProbableBonus probableBonus = (ProbableBonus)paramArray.get(b1);
/* 567 */         if (l2 + probableBonus.getProbability() >= l1) {
/*     */           GameplayMod gameplayMod;
/*     */           
/* 570 */           (gameplayMod = probableBonus.getBonus().cpy()).configure(this.S);
/* 571 */           delayedRemovalArray.add(gameplayMod);
/* 572 */           paramArray.removeIndex(b1);
/* 573 */           l -= probableBonus.getProbability();
/*     */           break;
/*     */         } 
/* 576 */         l2 += probableBonus.getProbability();
/*     */       } 
/*     */     } 
/*     */ 
/*     */     
/* 581 */     if ((getStagesConfig()).replaceBonusesWithNotSatisfiedPreconditions) {
/*     */       
/* 583 */       IntArray intArray = new IntArray(); byte b1;
/* 584 */       for (b1 = 0; b1 < delayedRemovalArray.size; b1++) {
/*     */         GameplayMod gameplayMod;
/* 586 */         if ((gameplayMod = (GameplayMod)delayedRemovalArray.get(b1)).getNotSatisfiedPreconditions(this.S) != null) {
/*     */           
/* 588 */           a.i("variant " + b1 + " (" + gameplayMod.getId() + ") is not satisfied, trying to replace", new Object[0]);
/* 589 */           boolean bool = false;
/* 590 */           label60: while (paramArray.size != 0) {
/* 591 */             long l1 = randomXS128.nextLong(l);
/* 592 */             long l2 = 0L;
/* 593 */             for (paramInt2 = 0; paramInt2 < paramArray.size; paramInt2++) {
/* 594 */               ProbableBonus probableBonus = (ProbableBonus)paramArray.get(paramInt2);
/* 595 */               if (l2 + probableBonus.getProbability() >= l1) {
/*     */                 GameplayMod gameplayMod1;
/*     */                 
/* 598 */                 if ((gameplayMod1 = probableBonus.getBonus()).getNotSatisfiedPreconditions(this.S) != null) {
/*     */                   
/* 600 */                   paramArray.removeIndex(paramInt2);
/* 601 */                   l -= probableBonus.getProbability();
/*     */                 } else {
/*     */                   
/* 604 */                   gameplayMod1.configure(this.S);
/* 605 */                   delayedRemovalArray.set(b1, gameplayMod1);
/* 606 */                   paramArray.removeIndex(paramInt2);
/* 607 */                   l -= probableBonus.getProbability();
/* 608 */                   bool = true;
/* 609 */                   a.i("replacing variant " + gameplayMod.getId() + " with " + gameplayMod1.getId() + " due to unsatisfied preconditions", new Object[0]);
/*     */                   
/* 611 */                   gameplayMod1.setReplacesUnsatisfiedMod(gameplayMod);
/*     */                   break label60;
/*     */                 } 
/*     */               } else {
/* 615 */                 l2 += probableBonus.getProbability();
/*     */               } 
/*     */             } 
/*     */           } 
/* 619 */           if (!bool) {
/*     */             
/* 621 */             a.i("removing variant index " + b1 + " (" + gameplayMod.getId() + ") due to unsatisfied preconditions and no replacement available", new Object[0]);
/* 622 */             intArray.add(b1);
/*     */           } 
/*     */         } 
/*     */       } 
/* 626 */       delayedRemovalArray.begin();
/* 627 */       for (b1 = 0; b1 < intArray.size; b1++) {
/* 628 */         delayedRemovalArray.removeIndex(intArray.get(b1));
/*     */       }
/* 630 */       delayedRemovalArray.end();
/*     */     } 
/*     */     
/* 633 */     return (Array<GameplayMod>)delayedRemovalArray;
/*     */   }
/*     */   
/*     */   public final int getCurrentVisualProgressPoints() {
/*     */     BonusStage bonusStage;
/* 638 */     if ((bonusStage = getStageToChooseBonusFor()) != null) {
/* 639 */       return BonusStage.b(bonusStage);
/*     */     }
/*     */     
/* 642 */     return ((bonusStage = getBonusStage(this.c)) == null) ? 0 : BonusStage.b(bonusStage);
/*     */   }
/*     */ 
/*     */   
/*     */   public final int getNextStagePointsRequirement() {
/*     */     BonusStage bonusStage;
/* 648 */     if ((bonusStage = getStageToChooseBonusFor()) != null) {
/* 649 */       return BonusStage.a(bonusStage);
/*     */     }
/*     */     
/* 652 */     return ((bonusStage = getBonusStage(this.c)) == null) ? 0 : BonusStage.a(bonusStage);
/*     */   }
/*     */ 
/*     */   
/*     */   public final boolean bonusSelectionAvailable() {
/* 657 */     if (!isEnabled()) {
/* 658 */       return false;
/*     */     }
/* 660 */     return (getStageToChooseBonusFor() != null);
/*     */   }
/*     */ 
/*     */   
/*     */   public final void update(float paramFloat) {
/* 665 */     if (!isEnabled())
/*     */       return; 
/*     */     StateSystem.ActionsArray actionsArray;
/* 668 */     if ((actionsArray = this.S.gameState.getCurrentUpdateActions()) != null) {
/* 669 */       for (byte b = 0; b < actionsArray.size; b++) {
/*     */         SelectGameplayBonusAction selectGameplayBonusAction; Action action;
/* 671 */         if ((action = actionsArray.actions[b]).getType() == ActionType.SGB) {
/*     */           
/* 673 */           selectGameplayBonusAction = (SelectGameplayBonusAction)action;
/*     */           BonusStage bonusStage1;
/* 675 */           if ((bonusStage1 = getStageToChooseBonusFor()) != null) {
/* 676 */             Array<GameplayMod> array = bonusStage1.getBonusesToChooseFrom();
/* 677 */             if (selectGameplayBonusAction.bonusIdx >= 0 && selectGameplayBonusAction.bonusIdx < array.size) {
/* 678 */               setSelectedBonus(BonusStage.c(bonusStage1), selectGameplayBonusAction.bonusIdx);
/*     */             }
/*     */           } 
/* 681 */         } else if (selectGameplayBonusAction.getType() == ActionType.RRB) {
/*     */           BonusStage bonusStage1;
/*     */ 
/*     */           
/* 685 */           if ((bonusStage1 = getStageToChooseBonusFor()) != null) {
/* 686 */             if (canReRollBonuses(BonusStage.c(bonusStage1))) {
/* 687 */               int i = this.b.getReRollPrice(BonusStage.c(bonusStage1), this.S);
/* 688 */               if (this.S.gameState.removeMoney(i)) {
/* 689 */                 reRollBonuses();
/*     */               } else {
/* 691 */                 a.i("reRollBonusesAction ignored - not enough coins (" + this.S.gameState.getMoney() + " / " + i + ")", new Object[0]);
/*     */               } 
/*     */             } else {
/* 694 */               a.i("reRollBonusesAction ignored - disabled by config", new Object[0]);
/*     */             } 
/*     */           } else {
/* 697 */             a.i("reRollBonusesAction ignored - bonus selection not available now", new Object[0]);
/*     */           } 
/*     */         } 
/*     */       } 
/*     */     }
/*     */     
/*     */     BonusStage bonusStage;
/*     */     
/* 705 */     if ((bonusStage = getStageToChooseBonusFor()) != null) {
/* 706 */       if (bonusStage.getAvailableOnFrame() == -1) {
/* 707 */         bonusStage.setAvailableOnFrame(this.S.gameState.updateNumber);
/*     */       }
/*     */       
/* 710 */       if (this.b.forceImmediateSelection && this.S.gameState.updateNumber - bonusStage.getAvailableOnFrame() >= 3) {
/*     */         
/* 712 */         int i = FastRandom.getFairInt((bonusStage.getBonusesToChooseFrom()).size);
/* 713 */         setSelectedBonus(BonusStage.c(bonusStage), i);
/*     */         
/* 715 */         a.e("player has not selected a bonus but frame has continued, selecting random: " + i, new Object[0]);
/* 716 */         a.e("frame " + this.S.gameState.updateNumber + ", bonus stage " + bonusStage.getNumber(), new Object[0]);
/*     */         
/* 718 */         if (this.S._gameUi != null) {
/* 719 */           this.S._gameUi.gameplayBonusesOverlay.hide();
/*     */         }
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public final String getSystemName() {
/* 727 */     return "Bonus";
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public final void dispose() {
/* 733 */     super.dispose();
/*     */   }
/*     */   
/*     */   @REGS
/*     */   public static final class BonusStage implements KryoSerializable { private int a;
/*     */     private int b;
/*     */     private int c;
/*     */     @Null
/* 741 */     private Integer d = null;
/*     */     @Null
/*     */     private Array<ProbableBonus> e;
/*     */     @Null
/*     */     private Array<GameplayMod> f;
/* 746 */     private int g = -1;
/*     */ 
/*     */     
/*     */     public final void write(Kryo param1Kryo, Output param1Output) {
/* 750 */       param1Output.writeVarInt(this.a, true);
/* 751 */       param1Output.writeVarInt(this.b, true);
/* 752 */       param1Output.writeVarInt(this.c, true);
/* 753 */       param1Kryo.writeObjectOrNull(param1Output, this.d, Integer.class);
/* 754 */       param1Kryo.writeClassAndObject(param1Output, this.e);
/* 755 */       param1Kryo.writeClassAndObject(param1Output, this.f);
/* 756 */       param1Output.writeInt(this.g);
/*     */     }
/*     */ 
/*     */     
/*     */     public final void read(Kryo param1Kryo, Input param1Input) {
/* 761 */       this.a = param1Input.readVarInt(true);
/* 762 */       this.b = param1Input.readVarInt(true);
/* 763 */       this.c = param1Input.readVarInt(true);
/* 764 */       this.d = (Integer)param1Kryo.readObjectOrNull(param1Input, Integer.class);
/* 765 */       this.e = (Array<ProbableBonus>)param1Kryo.readClassAndObject(param1Input);
/* 766 */       this.f = (Array<GameplayMod>)param1Kryo.readClassAndObject(param1Input);
/* 767 */       this.g = param1Input.readInt();
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public BonusStage(int param1Int1, int param1Int2) {
/* 773 */       Preconditions.checkArgument((param1Int1 > 0), "number must be > 0, %s given", param1Int1);
/* 774 */       Preconditions.checkArgument((param1Int2 > 0), "requirement must be > 0, %s given. Stage number: %s", param1Int2, param1Int1);
/* 775 */       this.a = param1Int1;
/* 776 */       this.b = param1Int2;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public final int getAvailableOnFrame() {
/* 784 */       return this.g;
/*     */     }
/*     */     
/*     */     public final void setAvailableOnFrame(int param1Int) {
/* 788 */       this.g = param1Int;
/*     */     }
/*     */     
/*     */     public final Array<GameplayMod> getBonusesToChooseFrom() {
/* 792 */       if (this.f == null) {
/* 793 */         throw new IllegalStateException("Bonuses not set yet " + this.c + " / " + this.b);
/*     */       }
/*     */       
/* 796 */       return this.f;
/*     */     }
/*     */     
/*     */     public final Array<ProbableBonus> getProbableBonuses() {
/* 800 */       if (this.e == null) {
/* 801 */         throw new IllegalStateException("probableBonuses not set yet");
/*     */       }
/* 803 */       return this.e;
/*     */     }
/*     */     
/*     */     public final int getNumber() {
/* 807 */       return this.a;
/*     */     }
/*     */     
/*     */     public final boolean canSelectBonus() {
/* 811 */       return (this.c == this.b && this.d == null);
/*     */     }
/*     */     
/*     */     public final boolean isBonusSelected() {
/* 815 */       return (this.d != null);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public final int getSelectedBonusIdx() {
/* 822 */       return (this.d == null) ? -1 : this.d.intValue();
/*     */     }
/*     */     
/*     */     public final int getPointsRequirement() {
/* 826 */       return this.b;
/*     */     }
/*     */     
/*     */     public final int getPoints() {
/* 830 */       return this.c;
/*     */     }
/*     */     
/*     */     private BonusStage() {} }
/*     */ 
/*     */   
/*     */   @REGS
/*     */   public static final class OnEnemyDie extends SerializableListener<BonusSystem> implements Listener<EnemyDie> {
/*     */     public OnEnemyDie(BonusSystem param1BonusSystem) {
/* 839 */       this.a = param1BonusSystem;
/*     */     }
/*     */     private OnEnemyDie() {}
/*     */     
/*     */     public final void handleEvent(EnemyDie param1EnemyDie) {
/* 844 */       if (!((BonusSystem)this.a).isEnabled())
/*     */         return; 
/*     */       Enemy enemy;
/* 847 */       if (!(enemy = param1EnemyDie.getLastDamage().getEnemy()).notAffectsWaveKillCounter.isTrue() && !enemy.hasBuffsByType(BuffType.NO_BONUS_SYSTEM_POINTS))
/* 848 */         ((BonusSystem)this.a).addProgressPoints(1); 
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\systems\BonusSystem.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */