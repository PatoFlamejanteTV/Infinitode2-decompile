/*     */ package com.prineside.tdi2.systems;
/*     */ import com.badlogic.gdx.utils.Array;
/*     */ import com.badlogic.gdx.utils.DelayedRemovalArray;
/*     */ import com.badlogic.gdx.utils.IntArray;
/*     */ import com.esotericsoftware.kryo.Kryo;
/*     */ import com.esotericsoftware.kryo.io.Input;
/*     */ import com.esotericsoftware.kryo.io.Output;
/*     */ import com.prineside.tdi2.Ability;
/*     */ import com.prineside.tdi2.BasicLevel;
/*     */ import com.prineside.tdi2.Config;
/*     */ import com.prineside.tdi2.DamageRecord;
/*     */ import com.prineside.tdi2.Enemy;
/*     */ import com.prineside.tdi2.Game;
/*     */ import com.prineside.tdi2.GameSystem;
/*     */ import com.prineside.tdi2.GameSystemProvider;
/*     */ import com.prineside.tdi2.Map;
/*     */ import com.prineside.tdi2.Projectile;
/*     */ import com.prineside.tdi2.SerializableListener;
/*     */ import com.prineside.tdi2.Tile;
/*     */ import com.prineside.tdi2.Tower;
/*     */ import com.prineside.tdi2.Unit;
/*     */ import com.prineside.tdi2.enums.AbilityType;
/*     */ import com.prineside.tdi2.enums.AchievementType;
/*     */ import com.prineside.tdi2.enums.BuffType;
/*     */ import com.prineside.tdi2.enums.DifficultyMode;
/*     */ import com.prineside.tdi2.enums.EnemyType;
/*     */ import com.prineside.tdi2.enums.ProjectileType;
/*     */ import com.prineside.tdi2.enums.TileType;
/*     */ import com.prineside.tdi2.enums.UnitType;
/*     */ import com.prineside.tdi2.events.Event;
/*     */ import com.prineside.tdi2.events.Listener;
/*     */ import com.prineside.tdi2.events.game.EnemyDie;
/*     */ import com.prineside.tdi2.events.game.MdpsUpdate;
/*     */ import com.prineside.tdi2.events.game.ScoreChange;
/*     */ import com.prineside.tdi2.events.game.TowerBuild;
/*     */ import com.prineside.tdi2.events.game.WaveComplete;
/*     */ import com.prineside.tdi2.projectiles.MultishotProjectile;
/*     */ import com.prineside.tdi2.units.DisorientedUnit;
/*     */ import com.prineside.tdi2.utils.NAGS;
/*     */ import com.prineside.tdi2.utils.REGS;
/*     */ 
/*     */ @REGS
/*     */ public final class AchievementSystem extends GameSystem {
/*     */   @NAGS
/*     */   private float e;
/*     */   @NAGS
/*  47 */   private int f = 0; @NAGS
/*     */   private boolean g; @NAGS
/*     */   private boolean h;
/*     */   @NAGS
/*  51 */   int a = 0; @NAGS
/*  52 */   int b = 0; @NAGS
/*  53 */   private int[] i = new int[AchievementType.values.length];
/*     */   @NAGS
/*  55 */   IntArray c = new IntArray(false, 8); @NAGS
/*  56 */   int d = 0;
/*     */ 
/*     */   
/*     */   public final void write(Kryo paramKryo, Output paramOutput) {
/*  60 */     super.write(paramKryo, paramOutput);
/*  61 */     paramOutput.writeFloat(this.e);
/*  62 */     paramOutput.writeVarInt(this.f, true);
/*  63 */     paramOutput.writeBoolean(this.g);
/*  64 */     paramOutput.writeBoolean(this.h);
/*  65 */     paramOutput.writeVarInt(this.a, true);
/*  66 */     paramOutput.writeVarInt(this.b, true);
/*  67 */     paramKryo.writeObject(paramOutput, this.i);
/*  68 */     paramKryo.writeObject(paramOutput, this.c);
/*  69 */     paramOutput.writeInt(this.d);
/*     */   }
/*     */ 
/*     */   
/*     */   public final void read(Kryo paramKryo, Input paramInput) {
/*  74 */     super.read(paramKryo, paramInput);
/*  75 */     this.e = paramInput.readFloat();
/*  76 */     this.f = paramInput.readVarInt(true);
/*  77 */     this.g = paramInput.readBoolean();
/*  78 */     this.h = paramInput.readBoolean();
/*  79 */     this.a = paramInput.readVarInt(true);
/*  80 */     this.b = paramInput.readVarInt(true);
/*  81 */     this.i = (int[])paramKryo.readObject(paramInput, int[].class);
/*  82 */     this.c = (IntArray)paramKryo.readObject(paramInput, IntArray.class);
/*  83 */     this.d = paramInput.readInt();
/*     */   }
/*     */   
/*  86 */   private static final EnemyType[] j = new EnemyType[] { EnemyType.REGULAR, EnemyType.FAST, EnemyType.STRONG, EnemyType.HELI, EnemyType.JET, EnemyType.ARMORED, EnemyType.HEALER, EnemyType.TOXIC, EnemyType.ICY, EnemyType.FIGHTER, EnemyType.LIGHT };
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
/*     */   public final boolean isActive() {
/* 101 */     return this.g;
/*     */   }
/*     */ 
/*     */   
/*     */   public final void setup() {
/* 106 */     a();
/* 107 */     if (isActive()) {
/* 108 */       this.S.events.getListeners(TowerBuild.class).addStateAffecting(new OnTowerBuild(this, (byte)0));
/* 109 */       this.S.events.getListeners(WaveComplete.class).addStateAffecting(new OnWaveComplete(this, (byte)0));
/* 110 */       this.S.events.getListeners(MdpsUpdate.class).addStateAffecting(new OnMdpsUpdate(this));
/* 111 */       this.S.events.getListeners(EnemyDie.class).addStateAffecting(new OnEnemyDie(this));
/* 112 */       this.S.events.getListeners(ScoreChange.class).addStateAffecting(new OnScoreChange(this, (byte)0));
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public final void postSetup() {
/* 118 */     a();
/*     */   }
/*     */ 
/*     */   
/*     */   public final void postStateRestore() {
/* 123 */     a();
/*     */   }
/*     */   
/*     */   private void a() {
/* 127 */     if (Config.isHeadless()) {
/* 128 */       this.g = false;
/*     */       return;
/*     */     } 
/* 131 */     this.g = (!this.h && this.S.gameState.difficultyMode == DifficultyMode.NORMAL && !this.S.gameState.replayMode && Game.i.isInMainThread());
/*     */     BasicLevel basicLevel;
/* 133 */     if (this.S.gameState.basicLevelName != null && (
/*     */       
/* 135 */       basicLevel = Game.i.basicLevelManager.getLevel(this.S.gameState.basicLevelName)) != null && 
/* 136 */       basicLevel.achievementsDisabled) {
/* 137 */       this.g = false;
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public final void setEnabled(boolean paramBoolean) {
/* 144 */     this.h = !paramBoolean;
/* 145 */     a();
/*     */   }
/*     */   
/*     */   public final void registerDelta(AchievementType paramAchievementType, int paramInt) {
/* 149 */     if (isActive()) {
/* 150 */       this.i[paramAchievementType.ordinal()] = this.i[paramAchievementType.ordinal()] + paramInt;
/* 151 */       Game.i.achievementManager.setProgress(paramAchievementType, this.i[paramAchievementType.ordinal()]);
/*     */     } 
/*     */   }
/*     */   
/*     */   public final void setProgress(AchievementType paramAchievementType, int paramInt) {
/* 156 */     if (isActive()) {
/* 157 */       Game.i.achievementManager.setProgress(paramAchievementType, paramInt);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public final void update(float paramFloat) {
/* 163 */     if (!isActive())
/*     */       return; 
/* 165 */     this.d = 0;
/*     */     
/* 167 */     this.e += paramFloat;
/* 168 */     if (this.e > 0.1F) {
/* 169 */       byte b1, b3; Map map; byte b2; DelayedRemovalArray delayedRemovalArray; int i; byte b4; this.e -= 0.1F;
/*     */       
/* 171 */       switch (this.f) {
/*     */         
/*     */         case 0:
/* 174 */           if (!Game.i.achievementManager.isRequirementMet(AchievementType.EVERY_ENEMY_MET)) {
/* 175 */             byte b5 = 0; EnemyType[] arrayOfEnemyType; int j; byte b6;
/* 176 */             for (j = (arrayOfEnemyType = j).length, b6 = 0; b6 < j; ) { EnemyType enemyType = arrayOfEnemyType[b6];
/* 177 */               if (!Game.i.enemyManager.isEnemyTypeNewForPlayer(enemyType, false))
/* 178 */                 b5++; 
/*     */               b6++; }
/*     */             
/* 181 */             setProgress(AchievementType.EVERY_ENEMY_MET, b5);
/*     */           } 
/*     */           break;
/*     */ 
/*     */ 
/*     */         
/*     */         case 1:
/* 188 */           paramFloat = 0.0F;
/* 189 */           for (b3 = 0; b3 < this.S.tower.towers.size; b3++) {
/*     */             Tower tower;
/* 191 */             float f = (tower = ((Tower[])this.S.tower.towers.items)[b3]).getStat(TowerStatType.ATTACK_SPEED);
/* 192 */             if (paramFloat < f) {
/* 193 */               paramFloat = f;
/*     */             }
/*     */           } 
/* 196 */           setProgress(AchievementType.HUGE_TOWER_ATTACK_SPEED, (int)paramFloat);
/*     */           break;
/*     */ 
/*     */ 
/*     */         
/*     */         case 2:
/* 202 */           if (!Game.i.achievementManager.isRequirementMet(AchievementType.MASS_TOWERS_LEVEL_DEV) && 
/* 203 */             this.S.gameState.basicLevelName != null && this.S.gameState.basicLevelName.equals("dev")) {
/* 204 */             setProgress(AchievementType.MASS_TOWERS_LEVEL_DEV, this.S.tower.towers.size);
/*     */           }
/*     */           break;
/*     */ 
/*     */ 
/*     */         
/*     */         case 3:
/* 211 */           setProgress(AchievementType.MASS_MINERS, this.S.miner.miners.size);
/*     */           break;
/*     */ 
/*     */         
/*     */         case 4:
/* 216 */           if (this.a == 1) {
/* 217 */             setProgress(AchievementType.BUILD_TOWER_FINISH_WITH_TEN, this.S.tower.towers.size);
/*     */           }
/*     */           break;
/*     */ 
/*     */ 
/*     */         
/*     */         case 5:
/* 224 */           b1 = 0;
/* 225 */           for (b3 = 0; b3 < this.S.map.spawnedUnits.size; b3++) {
/*     */             Unit unit;
/* 227 */             if ((unit = ((Unit[])this.S.map.spawnedUnits.items)[b3]).type == UnitType.MINE) {
/* 228 */               b1++;
/*     */             }
/*     */           } 
/* 231 */           setProgress(AchievementType.PLACE_MINES_ONE_GAME, b1);
/*     */           break;
/*     */ 
/*     */ 
/*     */ 
/*     */         
/*     */         case 6:
/* 238 */           b1 = 0;
/*     */           
/* 240 */           delayedRemovalArray = (map = this.S.map.getMap()).getAllTiles();
/* 241 */           for (i = 0; i < ((Array)delayedRemovalArray).size; i++) {
/*     */             Tile tile;
/* 243 */             if ((tile = ((Tile[])((Array)delayedRemovalArray).items)[i]).type == TileType.PLATFORM) {
/* 244 */               b1++;
/*     */             }
/*     */           } 
/* 247 */           i = this.S.tower.towers.size;
/* 248 */           for (b4 = 0; b4 < this.S.map.spawnedUnits.size; b4++) {
/*     */             Unit unit;
/* 250 */             if ((unit = ((Unit[])this.S.map.spawnedUnits.items)[b4]).type == UnitType.MICROGUN) {
/* 251 */               i++;
/*     */             }
/*     */           } 
/* 254 */           setProgress(AchievementType.PLACE_MICROGUNS, i - b1);
/*     */           break;
/*     */ 
/*     */ 
/*     */ 
/*     */         
/*     */         case 7:
/* 261 */           b1 = 0;
/* 262 */           for (b2 = 0; b2 < this.S.ability.activeAbilities.size; b2++) {
/* 263 */             if (((Ability[])this.S.ability.activeAbilities.items)[b2].getType() == AbilityType.BALL_LIGHTNING) {
/* 264 */               b1++;
/*     */             }
/*     */           } 
/* 267 */           setProgress(AchievementType.MASS_BALL_LIGHTNINGS, b1);
/*     */           break;
/*     */ 
/*     */ 
/*     */ 
/*     */         
/*     */         case 8:
/* 274 */           b1 = 0;
/* 275 */           for (b2 = 0; b2 < this.S.projectile.projectiles.size; b2++) {
/* 276 */             if ((((Projectile[])this.S.projectile.projectiles.items)[b2]).type == ProjectileType.MISSILE) {
/* 277 */               b1++;
/*     */             }
/*     */           } 
/* 280 */           setProgress(AchievementType.MASS_MISSILES, b1);
/*     */           break;
/*     */ 
/*     */ 
/*     */ 
/*     */         
/*     */         case 9:
/* 287 */           b1 = 0;
/* 288 */           for (b2 = 0; b2 < this.S.map.spawnedUnits.size; b2++) {
/*     */             Unit unit;
/* 290 */             if (unit = ((Unit[])this.S.map.spawnedUnits.items)[b2] instanceof DisorientedUnit && ((DisorientedUnit)unit).getSpawnedByTower() != null) {
/* 291 */               b1++;
/*     */             }
/*     */           } 
/* 294 */           setProgress(AchievementType.RECRUIT_ENEMIES, b1);
/*     */           break;
/*     */         
/*     */         default:
/* 298 */           this.f = 0; break;
/*     */       } 
/* 300 */       this.f++;
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public final boolean affectsGameState() {
/* 306 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public final String getSystemName() {
/* 311 */     return "Achievement";
/*     */   }
/*     */   
/*     */   @REGS
/*     */   public static class OnScoreChange extends SerializableListener<AchievementSystem> implements Listener<ScoreChange> {
/*     */     private OnScoreChange() {}
/*     */     
/*     */     private OnScoreChange(AchievementSystem param1AchievementSystem) {
/* 319 */       this.a = param1AchievementSystem;
/*     */     }
/*     */ 
/*     */     
/*     */     public void handleEvent(ScoreChange param1ScoreChange) {
/* 324 */       ((AchievementSystem)this.a).setProgress(AchievementType.MILLION_SCORE_ONE_GAME, (((AchievementSystem)this.a).S.gameState.getScore() >= 2147483647L) ? Integer.MAX_VALUE : (int)((AchievementSystem)this.a).S.gameState.getScore());
/*     */     }
/*     */   }
/*     */   
/*     */   @REGS
/*     */   public static final class OnTowerBuild extends SerializableListener<AchievementSystem> implements Listener<TowerBuild> {
/*     */     private OnTowerBuild() {}
/*     */     
/*     */     private OnTowerBuild(AchievementSystem param1AchievementSystem) {
/* 333 */       this.a = param1AchievementSystem;
/*     */     }
/*     */ 
/*     */     
/*     */     public final void handleEvent(TowerBuild param1TowerBuild) {
/* 338 */       if (!((AchievementSystem)this.a).isActive())
/*     */         return; 
/* 340 */       if (param1TowerBuild.getPrice() > 0) {
/* 341 */         ((AchievementSystem)this.a).a++; return;
/*     */       } 
/* 343 */       ((AchievementSystem)this.a).b++;
/* 344 */       ((AchievementSystem)this.a).setProgress(AchievementType.COPY_TOWERS_ONE_GAME, ((AchievementSystem)this.a).b);
/*     */     }
/*     */   }
/*     */   
/*     */   @REGS
/*     */   public static final class OnWaveComplete
/*     */     extends SerializableListener<AchievementSystem> implements Listener<WaveComplete> {
/*     */     private OnWaveComplete() {}
/*     */     
/*     */     private OnWaveComplete(AchievementSystem param1AchievementSystem) {
/* 354 */       this.a = param1AchievementSystem;
/*     */     }
/*     */ 
/*     */     
/*     */     public final void handleEvent(WaveComplete param1WaveComplete) {
/* 359 */       ((AchievementSystem)this.a).setProgress(AchievementType.REACH_HIGH_WAVE_ONE_GAME, (param1WaveComplete.getWave()).waveNumber);
/*     */     }
/*     */   }
/*     */   
/*     */   @REGS
/*     */   public static final class OnEnemyDie extends SerializableListener<AchievementSystem> implements Listener<EnemyDie> {
/*     */     private OnEnemyDie() {}
/*     */     
/*     */     public OnEnemyDie(AchievementSystem param1AchievementSystem) {
/* 368 */       this.a = param1AchievementSystem;
/*     */     }
/*     */ 
/*     */     
/*     */     public final void handleEvent(EnemyDie param1EnemyDie) {
/*     */       GameSystemProvider gameSystemProvider;
/* 374 */       if (!(gameSystemProvider = ((AchievementSystem)this.a).S).achievement.isActive())
/*     */         return; 
/*     */       DamageRecord damageRecord;
/*     */       Enemy enemy;
/* 378 */       if ((enemy = (damageRecord = param1EnemyDie.getLastDamage()).getEnemy()).type == EnemyType.BROOT_BOSS || enemy.type == EnemyType.SNAKE_BOSS_HEAD || enemy.type == EnemyType.METAPHOR_BOSS || enemy.type == EnemyType.MOBCHAIN_BOSS_HEAD || enemy.type == EnemyType.CONSTRUCTOR_BOSS) {
/* 379 */         if (enemy.existsTime <= 3.0F) {
/* 380 */           ((AchievementSystem)this.a).setProgress(AchievementType.FAST_BOSS_KILL, 1);
/*     */         }
/* 382 */         if (enemy.hasBuffsByType(BuffType.BONUS_COINS)) {
/* 383 */           ((AchievementSystem)this.a).setProgress(AchievementType.KILL_BOSS_BONUS_COINS, 1);
/*     */         }
/*     */       } 
/*     */       
/* 387 */       if (enemy.hasBuffsByType(BuffType.THROW_BACK)) {
/* 388 */         ((AchievementSystem)this.a).registerDelta(AchievementType.KILL_THROWN_BACK_ENEMIES, 1);
/*     */       }
/*     */       Projectile projectile;
/*     */       MultishotProjectile multishotProjectile;
/* 392 */       if ((projectile = damageRecord.getProjectile()) != null && projectile.type == ProjectileType.MULTISHOT && 
/*     */         
/* 394 */         (multishotProjectile = (MultishotProjectile)projectile).flyingBack) {
/* 395 */         ((AchievementSystem)this.a).registerDelta(AchievementType.KILL_ENEMY_WITH_BACK_PROJECTILE, 1);
/*     */       }
/*     */ 
/*     */       
/* 399 */       if (damageRecord.getDamageType() == DamageType.FIRE) {
/* 400 */         ((AchievementSystem)this.a).c.add(gameSystemProvider.gameState.updateNumber);
/*     */         
/* 402 */         int i = gameSystemProvider.gameState.updateNumber;
/* 403 */         byte b = 0;
/* 404 */         for (int j = ((AchievementSystem)this.a).c.size - 1; j >= 0; j--) {
/* 405 */           int k = ((AchievementSystem)this.a).c.items[j];
/* 406 */           if (i - k <= gameSystemProvider.gameValue.getTickRate()) {
/* 407 */             b++;
/*     */           } else {
/* 409 */             ((AchievementSystem)this.a).c.removeIndex(j);
/*     */           } 
/*     */         } 
/* 412 */         ((AchievementSystem)this.a).setProgress(AchievementType.MASS_BURN_ENEMIES, b);
/*     */       } 
/*     */       
/* 415 */       if (!enemy.isAir() && damageRecord.getTower() instanceof com.prineside.tdi2.towers.AirTower) {
/* 416 */         ((AchievementSystem)this.a).registerDelta(AchievementType.KILL_GROUND_ENEMY_WITH_AIR, 1);
/*     */       }
/*     */       
/* 419 */       if (damageRecord.getAbility() instanceof com.prineside.tdi2.abilities.NukeAbility) {
/* 420 */         ((AchievementSystem)this.a).d++;
/* 421 */         ((AchievementSystem)this.a).setProgress(AchievementType.HUNDRED_KILLS_NUKE, ((AchievementSystem)this.a).d);
/*     */       } 
/*     */       
/* 424 */       if ((enemy.type == EnemyType.BROOT_BOSS || enemy.type == EnemyType.SNAKE_BOSS_HEAD || enemy.type == EnemyType.MOBCHAIN_BOSS_HEAD || enemy.type == EnemyType.METAPHOR_BOSS || enemy.type == EnemyType.CONSTRUCTOR_BOSS) && damageRecord
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 430 */         .getUnit() instanceof DisorientedUnit)
/* 431 */         ((AchievementSystem)this.a).registerDelta(AchievementType.KILL_BOSS_WITH_RECRUIT, 1); 
/*     */     }
/*     */   }
/*     */   
/*     */   @REGS
/*     */   public static final class OnMdpsUpdate
/*     */     extends SerializableListener<AchievementSystem> implements Listener<MdpsUpdate> {
/*     */     private OnMdpsUpdate() {}
/*     */     
/*     */     public OnMdpsUpdate(AchievementSystem param1AchievementSystem) {
/* 441 */       this.a = param1AchievementSystem;
/*     */     }
/*     */ 
/*     */     
/*     */     public final void handleEvent(MdpsUpdate param1MdpsUpdate) {
/* 446 */       ((AchievementSystem)this.a).S.achievement.setProgress(AchievementType.MILLION_MDPS_ONE_GAME, (int)((AchievementSystem)this.a).S.damage.getTowersMaxDps());
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\systems\AchievementSystem.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */