/*     */ package com.prineside.tdi2.systems;
/*     */ 
/*     */ import com.badlogic.gdx.Application;
/*     */ import com.badlogic.gdx.Gdx;
/*     */ import com.badlogic.gdx.graphics.g2d.Batch;
/*     */ import com.badlogic.gdx.math.Vector2;
/*     */ import com.badlogic.gdx.utils.Array;
/*     */ import com.badlogic.gdx.utils.Null;
/*     */ import com.badlogic.gdx.utils.Pool;
/*     */ import com.prineside.tdi2.Enemy;
/*     */ import com.prineside.tdi2.Game;
/*     */ import com.prineside.tdi2.GameSystem;
/*     */ import com.prineside.tdi2.Map;
/*     */ import com.prineside.tdi2.Tower;
/*     */ import com.prineside.tdi2.configs.GameRenderingOrder;
/*     */ import com.prineside.tdi2.enums.AbilityType;
/*     */ import com.prineside.tdi2.enums.StaticSoundType;
/*     */ import com.prineside.tdi2.events.game.AbilityApply;
/*     */ import com.prineside.tdi2.events.game.CoreTileUpgradeInstall;
/*     */ import com.prineside.tdi2.events.game.EnemyDie;
/*     */ import com.prineside.tdi2.events.game.EnemyReachTarget;
/*     */ import com.prineside.tdi2.events.game.GamePaused;
/*     */ import com.prineside.tdi2.events.game.GameResumed;
/*     */ import com.prineside.tdi2.events.game.MinerBuild;
/*     */ import com.prineside.tdi2.events.game.MinerUpgrade;
/*     */ import com.prineside.tdi2.events.game.ModifierBuild;
/*     */ import com.prineside.tdi2.events.game.TowerAbilityChange;
/*     */ import com.prineside.tdi2.events.game.TowerBuild;
/*     */ import com.prineside.tdi2.events.game.TowerUpgrade;
/*     */ import com.prineside.tdi2.events.game.WaveStatusChange;
/*     */ import com.prineside.tdi2.ibxm.Module;
/*     */ import com.prineside.tdi2.managers.SettingsManager;
/*     */ import com.prineside.tdi2.ui.shared.MusicListOverlay;
/*     */ import com.prineside.tdi2.utils.FastRandom;
/*     */ import com.prineside.tdi2.utils.NAGS;
/*     */ import com.prineside.tdi2.utils.logging.TLog;
/*     */ import java.util.Arrays;
/*     */ 
/*     */ @NAGS
/*     */ public final class SoundSystem extends GameSystem {
/*  41 */   private static final TLog a = TLog.forClass(SoundSystem.class);
/*     */ 
/*     */   
/*  44 */   private int b = 44;
/*     */   
/*  46 */   private final Array<QueuedSound> c = new Array(QueuedSound.class);
/*     */   
/*  48 */   private final boolean[] d = new boolean[StaticSoundType.values.length]; private final float[] e; private final float[] f; @Null
/*     */   private Runnable g; public SoundSystem() {
/*  50 */     this.d[StaticSoundType.SHOT_GAUSS.ordinal()] = true;
/*  51 */     this.d[StaticSoundType.BUTTON.ordinal()] = true;
/*  52 */     this.d[StaticSoundType.UPGRADE.ordinal()] = true;
/*  53 */     this.d[StaticSoundType.ENEMY_REACHED.ordinal()] = true;
/*  54 */     this.d[StaticSoundType.FAIL.ordinal()] = true;
/*  55 */     this.d[StaticSoundType.GAME_OVER.ordinal()] = true;
/*  56 */     this.d[StaticSoundType.NOTIFICATION.ordinal()] = true;
/*  57 */     this.d[StaticSoundType.SUCCESS.ordinal()] = true;
/*  58 */     this.d[StaticSoundType.LOOT_EPIC.ordinal()] = true;
/*  59 */     this.d[StaticSoundType.LOOT_LEGENDARY.ordinal()] = true;
/*  60 */     this.d[StaticSoundType.BUILDING_BUILT.ordinal()] = true;
/*  61 */     this.d[StaticSoundType.AUTO_FORCE_WAVE.ordinal()] = true;
/*  62 */     this.d[StaticSoundType.WARNING.ordinal()] = true;
/*  63 */     this.d[StaticSoundType.ABILITY_NUKE.ordinal()] = true;
/*  64 */     this.d[StaticSoundType.ABILITY_BLIZZARD.ordinal()] = true;
/*  65 */     this.d[StaticSoundType.ABILITY_FIREBALL.ordinal()] = true;
/*  66 */     this.d[StaticSoundType.ABILITY_WINDSTORM.ordinal()] = true;
/*  67 */     this.d[StaticSoundType.ABILITY_THUNDER.ordinal()] = true;
/*  68 */     this.d[StaticSoundType.ABILITY_SMOKE_BOMB.ordinal()] = true;
/*  69 */     this.d[StaticSoundType.ABILITY_FIRESTORM.ordinal()] = true;
/*  70 */     this.d[StaticSoundType.ABILITY_MAGNET.ordinal()] = true;
/*  71 */     this.d[StaticSoundType.ABILITY_BULLET_WALL.ordinal()] = true;
/*  72 */     this.d[StaticSoundType.ABILITY_BALL_LIGHTNING.ordinal()] = true;
/*  73 */     this.d[StaticSoundType.ABILITY_LOIC.ordinal()] = true;
/*  74 */     this.d[StaticSoundType.ABILITY_OVERLOAD.ordinal()] = true;
/*     */ 
/*     */     
/*  77 */     this.e = new float[StaticSoundType.values.length];
/*     */     
/*  79 */     Arrays.fill(this.e, 0.08F);
/*  80 */     this.e[StaticSoundType.EXPLOSION.ordinal()] = 0.16F;
/*  81 */     this.e[StaticSoundType.LOOT_COMMON.ordinal()] = 0.3F;
/*  82 */     this.e[StaticSoundType.LOOT_RARE.ordinal()] = 0.25F;
/*  83 */     this.e[StaticSoundType.LOOT_VERY_RARE.ordinal()] = 0.2F;
/*  84 */     this.e[StaticSoundType.LOOT_EPIC.ordinal()] = 0.15F;
/*  85 */     this.e[StaticSoundType.LOOT_LEGENDARY.ordinal()] = 0.12F;
/*  86 */     this.e[StaticSoundType.SHOT_BLAST.ordinal()] = 0.15F;
/*     */ 
/*     */     
/*  89 */     this.f = new float[StaticSoundType.values.length];
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  95 */     if (Gdx.app.getType() == Application.ApplicationType.Android) {
/*  96 */       this.b = 29;
/*  97 */       for (byte b = 0; b < this.e.length; b++)
/*  98 */         this.e[b] = this.e[b] * 1.7F; 
/*     */     } 
/*     */   }
/*     */   private static final Vector2 h = new Vector2();
/*     */   
/*     */   public final boolean profileUpdate() {
/* 104 */     return false;
/*     */   }
/*     */   
/*     */   public final String getSystemName() {
/* 108 */     return "Sound";
/*     */   }
/*     */ 
/*     */   
/*     */   public final boolean affectsGameState() {
/* 113 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public final void setup() {
/* 118 */     this.S.events.getListeners(GamePaused.class).add(paramGamePaused -> updateMusicPlayback()).setDescription("SoundSystem - updates music playback");
/* 119 */     this.S.events.getListeners(GameResumed.class).add(paramGameResumed -> updateMusicPlayback()).setDescription("SoundSystem - updates music playback");
/*     */     
/* 121 */     this.S.events.getListeners(AbilityApply.class).add(paramAbilityApply -> { switch (null.a[paramAbilityApply.getAbility().getType().ordinal()]) { case 1: playStatic(StaticSoundType.ABILITY_NUKE); return;
/*     */             case 2: playStatic(StaticSoundType.ABILITY_BLIZZARD); return;
/*     */             case 3: playStatic(StaticSoundType.ABILITY_FIREBALL); return;
/*     */             case 4: playStatic(StaticSoundType.ABILITY_WINDSTORM); return;
/*     */             case 5: playStatic(StaticSoundType.ABILITY_THUNDER); return;
/*     */             case 6: playStatic(StaticSoundType.ABILITY_SMOKE_BOMB); return;
/*     */             case 7: playStatic(StaticSoundType.ABILITY_FIRESTORM); return;
/*     */             case 8: playStatic(StaticSoundType.ABILITY_MAGNET); return;
/*     */             case 9: playStatic(StaticSoundType.ABILITY_BULLET_WALL); return;
/*     */             case 10:
/*     */               playStatic(StaticSoundType.ABILITY_BALL_LIGHTNING); return;
/*     */             case 11:
/*     */               playStatic(StaticSoundType.ABILITY_LOIC); return;
/*     */             case 12:
/*     */               playStatic(StaticSoundType.ABILITY_OVERLOAD); return;
/*     */             case 13:
/* 137 */               playStatic(StaticSoundType.ABILITY_LOOP); break; }  }).setDescription("SoundSystem - plays ability sound");
/*     */     
/* 139 */     this.S.events.getListeners(EnemyDie.class).add(paramEnemyDie -> {
/*     */           Enemy enemy = paramEnemyDie.getLastDamage().getEnemy();
/*     */           
/*     */           float f1 = a((enemy.getPosition()).x);
/*     */           float f2;
/*     */           if ((f2 = (float)((f2 = b(f1)) * Game.i.settingsManager.getCustomValue(SettingsManager.CustomValueType.SHOOTING_SOUNDS_VOLUME))) > 0.01F) {
/*     */             float f3 = 1.0F;
/*     */             float f4;
/*     */             if ((f4 = FastRandom.getFloat()) < 0.25F) {
/*     */               f3 = 1.12246F;
/*     */             } else if (f4 < 0.5F) {
/*     */               f3 = 1.059465F;
/*     */             } else if (f4 < 0.75F) {
/*     */               f3 = 0.943876F;
/*     */             } 
/*     */             playStaticParameterized(StaticSoundType.ENEMY_DIE, f2 * 0.7F, f3, f1);
/*     */           } 
/*     */         });
/* 157 */     this.S.events.getListeners(EnemyReachTarget.class).add(paramEnemyReachTarget -> {
/*     */           if (paramEnemyReachTarget.getEnemy().getCurrentTile() instanceof com.prineside.tdi2.tiles.TargetTile) {
/*     */             playStatic(StaticSoundType.ENEMY_REACHED);
/*     */           }
/*     */         });
/*     */     
/* 163 */     this.S.events.getListeners(CoreTileUpgradeInstall.class).add(paramCoreTileUpgradeInstall -> playStatic(StaticSoundType.UPGRADE));
/* 164 */     this.S.events.getListeners(MinerUpgrade.class).add(paramMinerUpgrade -> playStatic(StaticSoundType.UPGRADE));
/* 165 */     this.S.events.getListeners(MinerBuild.class).add(paramMinerBuild -> playStatic(StaticSoundType.BUILDING_BUILT));
/* 166 */     this.S.events.getListeners(ModifierBuild.class).add(paramModifierBuild -> playStatic(StaticSoundType.BUILDING_BUILT));
/* 167 */     this.S.events.getListeners(TowerBuild.class).add(paramTowerBuild -> playStatic(StaticSoundType.BUILDING_BUILT));
/* 168 */     this.S.events.getListeners(TowerUpgrade.class).add(paramTowerUpgrade -> playStatic(StaticSoundType.UPGRADE));
/* 169 */     this.S.events.getListeners(TowerAbilityChange.class).add(paramTowerAbilityChange -> {
/*     */           if (paramTowerAbilityChange.isInstalled()) {
/*     */             playStatic(StaticSoundType.UPGRADE);
/*     */           }
/*     */         });
/* 174 */     this.S.events.getListeners(WaveStatusChange.class).add(paramWaveStatusChange -> {
/*     */           if (paramWaveStatusChange.getOldStatus() == WaveSystem.Status.NOT_STARTED) {
/*     */             updateMusicPlayback();
/*     */           }
/*     */         });
/*     */     
/* 180 */     this.S._render.addLayer((new RenderSystem.Layer(GameRenderingOrder.SOUND_DRAW, false, (paramBatch, paramFloat1, paramFloat2, paramFloat3) -> draw(paramFloat1)))
/*     */ 
/*     */         
/* 183 */         .setName("Sound-draw"));
/*     */   }
/*     */ 
/*     */   
/*     */   public final void postSetup() {
/* 188 */     super.postSetup();
/*     */     
/* 190 */     updateMusicPlayback();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final void setMusicPlaybackHandler(@Null Runnable paramRunnable) {
/* 201 */     this.g = paramRunnable;
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
/*     */   public final void updateMusicPlayback() {
/* 218 */     if (this.g != null) {
/* 219 */       a.i("updateMusicPlayback - using custom handler", new Object[0]);
/* 220 */       this.g.run();
/*     */       
/*     */       return;
/*     */     } 
/* 224 */     a.i("updateMusicPlayback - using default handler", new Object[0]);
/* 225 */     if (this.S.wave.status == null || this.S.wave.status == WaveSystem.Status.NOT_STARTED || !Game.i.settingsManager.isMusicEnabled()) {
/*     */       
/* 227 */       a.i("- not started - stopping music", new Object[0]);
/* 228 */       Game.i.musicManager.stopMusic(); return;
/*     */     } 
/* 230 */     if (Game.i.settingsManager.getCustomValue(SettingsManager.CustomValueType.IGNORE_MAP_MUSIC) == 1.0D) {
/*     */       
/* 232 */       a.i("- map music ignored, playing menu music", new Object[0]);
/* 233 */       Game.i.musicManager.continuePlayingMenuMusicTrack();
/*     */     } else {
/* 235 */       Map map = null;
/* 236 */       if (this.S.gameState.basicLevelName != null) {
/* 237 */         map = Game.i.basicLevelManager.getLevel(this.S.gameState.basicLevelName).getMap();
/* 238 */       } else if (this.S.gameState.userMapId != null) {
/* 239 */         map = (Game.i.userMapManager.getUserMap(this.S.gameState.userMapId)).map;
/*     */       } 
/* 241 */       if (map != null && map.getMusicTile() != null && map.getMusicTile().getModule() != null) {
/*     */         
/* 243 */         a.i("- found a map with a music tile", new Object[0]);
/* 244 */         Module module1 = map.getMusicTile().getModule();
/* 245 */         Module module2 = Game.i.musicManager.getPlayingMusic();
/* 246 */         boolean bool1 = (module1 == null) ? true : module1.moduleHashCode();
/* 247 */         boolean bool2 = (module2 == null) ? true : module2.moduleHashCode();
/* 248 */         if (bool1 != bool2) {
/* 249 */           a.i("- playing different music from the map " + module1 + " (" + bool1 + ") / " + module2 + " (" + bool2 + ")", new Object[0]);
/* 250 */           Game.i.musicManager.playMusic(map.getMusicTile().getModule());
/* 251 */           Game.i.musicManager.setVolumeToStartNewTrack();
/*     */         } else {
/*     */           
/* 254 */           a.i("- playing same music from the map", new Object[0]);
/* 255 */           Game.i.musicManager.setVolume(1.0F, 2.0F, false);
/*     */         } 
/*     */       } else {
/*     */         
/* 259 */         a.i("- no map / music tile, playing menu music", new Object[0]);
/* 260 */         Game.i.musicManager.continuePlayingMenuMusicTrack();
/*     */       } 
/*     */     } 
/*     */     
/* 264 */     if (this.S.gameState.isPaused() && !MusicListOverlay.i().isVisible()) {
/*     */       
/* 266 */       a.i("- fading out the volume", new Object[0]);
/* 267 */       Game.i.musicManager.setVolume(0.25F, 2.0F, false);
/*     */       return;
/*     */     } 
/* 270 */     a.i("- fading in the volume", new Object[0]);
/* 271 */     Game.i.musicManager.setVolume(1.0F, 2.0F, false);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public final void draw(float paramFloat) {
/* 277 */     if (this.c.size != 0) {
/* 278 */       for (int i = this.c.size - 1; i >= 0; i--) {
/* 279 */         QueuedSound queuedSound = ((QueuedSound[])this.c.items)[i];
/* 280 */         Game.i.soundManager.playStaticParameterized(queuedSound.a, queuedSound.c, queuedSound.b, queuedSound.d, false);
/*     */       } 
/* 282 */       this.c.clear();
/*     */     } 
/*     */     
/* 285 */     for (byte b = 0; b < this.f.length; b++) {
/* 286 */       this.f[b] = this.f[b] - paramFloat;
/* 287 */       if (this.f[b] < 0.0F) this.f[b] = 0.0F; 
/*     */     } 
/*     */   }
/*     */   
/*     */   private float a(float paramFloat) {
/* 292 */     h.set(paramFloat, 0.0F);
/* 293 */     this.S._input.cameraController.mapToViewport(h);
/*     */     
/* 295 */     return -0.5F + h.x / this.S._input.cameraController.camera.viewportWidth;
/*     */   }
/*     */   
/*     */   private float b(float paramFloat) {
/* 299 */     float f = 1.0F - (float)(this.S._input.cameraController.zoom - 0.5D) * 0.25F;
/* 300 */     if (paramFloat < -0.5F) {
/* 301 */       f *= 1.0F + (paramFloat + 0.5F) * 2.0F;
/* 302 */     } else if (paramFloat > 0.5F) {
/* 303 */       f *= 1.0F - (paramFloat - 0.5F) * 2.0F;
/*     */     } 
/*     */     
/* 306 */     return f;
/*     */   }
/*     */   
/*     */   public final void playShotSound(StaticSoundType paramStaticSoundType, Tower paramTower) {
/* 310 */     float f1 = a((paramTower.getTile()).center.x);
/*     */     
/*     */     float f2;
/* 313 */     if ((f2 = (float)((f2 = b(f1)) * Game.i.settingsManager.getCustomValue(SettingsManager.CustomValueType.SHOOTING_SOUNDS_VOLUME))) > 0.05F)
/*     */     {
/* 315 */       playStaticParameterized(paramStaticSoundType, f2 * 0.6F, 1.0F, f1);
/*     */     }
/*     */   }
/*     */   
/*     */   public final void playStatic(StaticSoundType paramStaticSoundType) {
/* 320 */     playStaticParameterized(paramStaticSoundType, 1.0F, 1.0F, 0.0F);
/*     */   }
/*     */   
/*     */   public final void playExplosionSound(float paramFloat) {
/* 324 */     paramFloat = a(paramFloat);
/*     */     
/*     */     float f;
/* 327 */     if ((f = (float)((f = b(paramFloat)) * Game.i.settingsManager.getCustomValue(SettingsManager.CustomValueType.SHOOTING_SOUNDS_VOLUME))) > 0.05F) {
/* 328 */       playStaticParameterized(StaticSoundType.EXPLOSION, f * 0.6F, 0.9F + FastRandom.getFloat() * 0.2F, paramFloat);
/*     */     }
/*     */   }
/*     */   
/*     */   public final void playStaticParameterized(StaticSoundType paramStaticSoundType, float paramFloat1, float paramFloat2, float paramFloat3) {
/* 333 */     if (!this.S.CFG.headless && !this.S.gameState.isFastForwarding()) {
/* 334 */       if (this.f[paramStaticSoundType.ordinal()] != 0.0F)
/*     */         return; 
/* 336 */       if (Game.i.soundManager.playingSoundStats.size + Game.i.soundManager.soundsToPlay.size >= this.b && !this.d[paramStaticSoundType.ordinal()]) {
/*     */         return;
/*     */       }
/*     */ 
/*     */       
/* 341 */       for (byte b = 0; b < this.c.size; b++) {
/* 342 */         if ((((QueuedSound[])this.c.items)[b]).a == paramStaticSoundType) {
/*     */           return;
/*     */         }
/*     */       } 
/*     */       
/*     */       QueuedSound queuedSound;
/* 348 */       (queuedSound = new QueuedSound((byte)0)).a = paramStaticSoundType;
/* 349 */       queuedSound.d = paramFloat3;
/* 350 */       queuedSound.c = paramFloat1;
/* 351 */       queuedSound.b = paramFloat2;
/* 352 */       this.c.add(queuedSound);
/*     */       
/* 354 */       paramFloat1 = this.e[paramStaticSoundType.ordinal()];
/*     */       int i;
/* 356 */       if ((i = Game.i.soundManager.playingSoundStats.size + Game.i.soundManager.soundsToPlay.size) >= this.b * 0.9F) {
/* 357 */         paramFloat1 *= 2.0F;
/* 358 */       } else if (i >= this.b * 0.75F) {
/* 359 */         paramFloat1 *= 1.5F;
/* 360 */       } else if (i >= this.b * 0.5F) {
/* 361 */         paramFloat1 *= 1.25F;
/*     */       } 
/* 363 */       this.f[paramStaticSoundType.ordinal()] = paramFloat1;
/*     */     } 
/*     */   }
/*     */   
/*     */   private static class QueuedSound implements Pool.Poolable {
/*     */     StaticSoundType a;
/*     */     float b;
/*     */     float c;
/*     */     float d;
/*     */     
/*     */     private QueuedSound() {}
/*     */     
/*     */     public void reset() {}
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\systems\SoundSystem.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */