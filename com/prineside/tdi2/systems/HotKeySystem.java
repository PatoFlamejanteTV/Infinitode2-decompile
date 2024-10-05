/*     */ package com.prineside.tdi2.systems;
/*     */ 
/*     */ import com.badlogic.gdx.Gdx;
/*     */ import com.badlogic.gdx.graphics.g2d.Batch;
/*     */ import com.badlogic.gdx.graphics.g2d.TextureRegion;
/*     */ import com.badlogic.gdx.utils.Array;
/*     */ import com.prineside.tdi2.Building;
/*     */ import com.prineside.tdi2.Config;
/*     */ import com.prineside.tdi2.Game;
/*     */ import com.prineside.tdi2.GameSystem;
/*     */ import com.prineside.tdi2.Miner;
/*     */ import com.prineside.tdi2.Modifier;
/*     */ import com.prineside.tdi2.Tile;
/*     */ import com.prineside.tdi2.Tower;
/*     */ import com.prineside.tdi2.configs.GameRenderingOrder;
/*     */ import com.prineside.tdi2.enums.AbilityType;
/*     */ import com.prineside.tdi2.enums.BuildingType;
/*     */ import com.prineside.tdi2.enums.MinerType;
/*     */ import com.prineside.tdi2.enums.ModifierType;
/*     */ import com.prineside.tdi2.enums.StaticSoundType;
/*     */ import com.prineside.tdi2.enums.TowerType;
/*     */ import com.prineside.tdi2.events.game.MapElementSelect;
/*     */ import com.prineside.tdi2.events.game.Render;
/*     */ import com.prineside.tdi2.managers.AssetManager;
/*     */ import com.prineside.tdi2.managers.SettingsManager;
/*     */ import com.prineside.tdi2.tiles.PlatformTile;
/*     */ import com.prineside.tdi2.tiles.SourceTile;
/*     */ import com.prineside.tdi2.utils.NAGS;
/*     */ import com.prineside.tdi2.utils.logging.TLog;
/*     */ 
/*     */ @NAGS
/*     */ public final class HotKeySystem
/*     */   extends GameSystem
/*     */ {
/*  35 */   private static final TLog a = TLog.forClass(HotKeySystem.class);
/*     */   
/*     */   private boolean b;
/*     */   
/*     */   private boolean c = false;
/*     */   
/*     */   private float d;
/*     */   
/*     */   private int e;
/*     */   private int f;
/*     */   
/*     */   public final void setup() {
/*  47 */     this.e = this.S.map.getMap().getWidth() / 2;
/*  48 */     this.f = this.S.map.getMap().getHeight() / 2;
/*  49 */     this.S.events.getListeners(MapElementSelect.class).add(paramMapElementSelect -> {
/*     */           Tile tile;
/*     */           if ((tile = this.S._gameMapSelection.getSelectedTile()) != null) {
/*     */             this.e = tile.getX();
/*     */             this.f = tile.getY();
/*     */           } 
/*  55 */         }).setDescription("HotKeySystem - moves cursor to the selected tile");
/*     */     
/*  57 */     this.S.events.getListeners(Render.class).addWithPriority(paramRender -> handleHotKeys(), 3000).setDescription("HotKeySystem - handles hot keys");
/*     */     
/*  59 */     this.S._render.addLayer((new RenderSystem.Layer(GameRenderingOrder.HOT_KEY_DRAW_CURSOR, false, (paramBatch, paramFloat1, paramFloat2, paramFloat3) -> a(paramBatch, paramFloat1)))
/*     */ 
/*     */         
/*  62 */         .setName("HotKey-drawCursor"));
/*     */   }
/*     */ 
/*     */   
/*     */   public final boolean affectsGameState() {
/*  67 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public final String getSystemName() {
/*  72 */     return "HotKey";
/*     */   }
/*     */   
/*     */   public final void setHotKeysEnabled(boolean paramBoolean) {
/*  76 */     this.b = !paramBoolean;
/*     */   }
/*     */ 
/*     */   
/*     */   private void a(Batch paramBatch, float paramFloat) {
/*  81 */     if (this.d != 0.0F) {
/*  82 */       paramBatch.setColor(1.0F, 1.0F, 1.0F, this.d);
/*  83 */       paramBatch.draw((TextureRegion)(AssetManager.TextureRegions.i()).tileOutlineHover, (this.e << 7) - 12.0F, (this.f << 7) - 12.0F, 152.0F, 152.0F);
/*  84 */       paramBatch.setColor(Config.WHITE_COLOR_CACHED_FLOAT_BITS);
/*     */       
/*  86 */       this.d -= paramFloat;
/*  87 */       if (this.d < 0.0F) {
/*  88 */         this.d = 0.0F;
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public final void handleHotKeys() {
/*  95 */     if (!this.c && !this.S.gameState.isPaused() && !this.b && !(Game.i.uiManager.stage.getKeyboardFocus() instanceof com.prineside.tdi2.scene2d.ui.TextField)) {
/*  96 */       SettingsManager settingsManager = Game.i.settingsManager;
/*     */       
/*  98 */       byte b = 0;
/*  99 */       if (Gdx.input.isKeyJustPressed(20)) {
/* 100 */         this.f--;
/* 101 */         if (this.f < 0) {
/* 102 */           this.f = 0;
/*     */         }
/* 104 */         b = 1;
/*     */       } 
/* 106 */       if (Gdx.input.isKeyJustPressed(21)) {
/* 107 */         this.e--;
/* 108 */         if (this.e < 0) {
/* 109 */           this.e = 0;
/*     */         }
/* 111 */         b = 1;
/*     */       } 
/* 113 */       if (Gdx.input.isKeyJustPressed(22)) {
/* 114 */         this.e++;
/* 115 */         if (this.e > this.S.map.getMap().getWidth() - 1) {
/* 116 */           this.e = this.S.map.getMap().getWidth() - 1;
/*     */         }
/* 118 */         b = 1;
/*     */       } 
/* 120 */       if (Gdx.input.isKeyJustPressed(19)) {
/* 121 */         this.f++;
/* 122 */         if (this.f > this.S.map.getMap().getHeight() - 1) {
/* 123 */           this.f = this.S.map.getMap().getHeight() - 1;
/*     */         }
/* 125 */         b = 1;
/*     */       } 
/* 127 */       if (b) {
/* 128 */         this.S._gameMapSelection.setSelectedTile(this.S.map.getMap().getTile(this.e, this.f));
/* 129 */         this.d = 1.0F;
/* 130 */         Game.i.soundManager.playStatic(StaticSoundType.BUTTON);
/*     */       } 
/*     */ 
/*     */       
/* 134 */       Array array = settingsManager.getHotkeysJustPressed();
/* 135 */       for (b = 0; b < array.size; b++) {
/* 136 */         int i; Tile tile7; float f; byte b1; AbilityType abilityType; Tile tile6; Building building6; Miner miner3; Tile tile5; Building building5; Tile tile4; Building building4; Miner miner2; Tile tile3; Building building3; Miner miner1; Tile tile2; Building building2; Tile tile1; Building building1; SettingsManager.HotkeyAction hotkeyAction = ((SettingsManager.HotkeyAction[])array.items)[b];
/* 137 */         switch (null.a[hotkeyAction.ordinal()]) {
/*     */           
/*     */           case 1:
/*     */           case 2:
/*     */           case 3:
/*     */           case 4:
/*     */           case 5:
/*     */           case 6:
/*     */           case 7:
/*     */           case 8:
/*     */           case 9:
/*     */           case 10:
/*     */           case 11:
/*     */           case 12:
/*     */           case 13:
/*     */           case 14:
/*     */           case 15:
/*     */           case 16:
/* 155 */             if (tile7 = this.S._gameMapSelection.getSelectedTile() instanceof PlatformTile && 
/* 156 */               ((PlatformTile)tile7).building == null) {
/* 157 */               TowerType towerType; tile7 = null;
/* 158 */               switch (null.a[hotkeyAction.ordinal()]) {
/*     */                 case 1:
/* 160 */                   towerType = TowerType.BASIC;
/*     */                   break;
/*     */                 case 2:
/* 163 */                   towerType = TowerType.SNIPER;
/*     */                   break;
/*     */                 case 3:
/* 166 */                   towerType = TowerType.CANNON;
/*     */                   break;
/*     */                 case 4:
/* 169 */                   towerType = TowerType.FREEZING;
/*     */                   break;
/*     */                 case 5:
/* 172 */                   towerType = TowerType.AIR;
/*     */                   break;
/*     */                 case 6:
/* 175 */                   towerType = TowerType.SPLASH;
/*     */                   break;
/*     */                 case 7:
/* 178 */                   towerType = TowerType.BLAST;
/*     */                   break;
/*     */                 case 8:
/* 181 */                   towerType = TowerType.MULTISHOT;
/*     */                   break;
/*     */                 case 9:
/* 184 */                   towerType = TowerType.MINIGUN;
/*     */                   break;
/*     */                 case 10:
/* 187 */                   towerType = TowerType.VENOM;
/*     */                   break;
/*     */                 case 11:
/* 190 */                   towerType = TowerType.TESLA;
/*     */                   break;
/*     */                 case 12:
/* 193 */                   towerType = TowerType.MISSILE;
/*     */                   break;
/*     */                 case 13:
/* 196 */                   towerType = TowerType.FLAMETHROWER;
/*     */                   break;
/*     */                 case 14:
/* 199 */                   towerType = TowerType.LASER;
/*     */                   break;
/*     */                 case 15:
/* 202 */                   towerType = TowerType.GAUSS;
/*     */                   break;
/*     */                 case 16:
/* 205 */                   towerType = TowerType.CRUSHER;
/*     */                   break;
/*     */               } 
/* 208 */               if (towerType != null) {
/* 209 */                 this.S.tower.buildTowerActionOnSelectedTile(towerType);
/*     */               }
/*     */             } 
/*     */             break;
/*     */ 
/*     */ 
/*     */           
/*     */           case 17:
/*     */           case 18:
/*     */           case 19:
/*     */           case 20:
/*     */           case 21:
/*     */           case 22:
/*     */           case 23:
/*     */           case 24:
/* 224 */             if (tile7 = this.S._gameMapSelection.getSelectedTile() instanceof PlatformTile && 
/* 225 */               ((PlatformTile)tile7).building == null) {
/* 226 */               ModifierType modifierType; tile7 = null;
/* 227 */               switch (null.a[hotkeyAction.ordinal()]) {
/*     */                 case 17:
/* 229 */                   modifierType = ModifierType.BALANCE;
/*     */                   break;
/*     */                 case 18:
/* 232 */                   modifierType = ModifierType.SEARCH;
/*     */                   break;
/*     */                 case 19:
/* 235 */                   modifierType = ModifierType.POWER;
/*     */                   break;
/*     */                 case 20:
/* 238 */                   modifierType = ModifierType.DAMAGE;
/*     */                   break;
/*     */                 case 21:
/* 241 */                   modifierType = ModifierType.ATTACK_SPEED;
/*     */                   break;
/*     */                 case 22:
/* 244 */                   modifierType = ModifierType.MINING_SPEED;
/*     */                   break;
/*     */                 case 23:
/* 247 */                   modifierType = ModifierType.BOUNTY;
/*     */                   break;
/*     */                 case 24:
/* 250 */                   modifierType = ModifierType.EXPERIENCE;
/*     */                   break;
/*     */               } 
/* 253 */               this.S.modifier.buildModifierActionAtSelectedTile(modifierType);
/*     */             } 
/*     */             break;
/*     */ 
/*     */ 
/*     */           
/*     */           case 25:
/*     */           case 26:
/*     */           case 27:
/*     */           case 28:
/*     */           case 29:
/* 264 */             if (tile7 = this.S._gameMapSelection.getSelectedTile() instanceof SourceTile && 
/* 265 */               ((SourceTile)tile7).miner == null) {
/* 266 */               MinerType minerType; tile7 = null;
/* 267 */               switch (null.a[hotkeyAction.ordinal()]) {
/*     */                 case 25:
/* 269 */                   minerType = MinerType.SCALAR;
/*     */                   break;
/*     */                 case 26:
/* 272 */                   minerType = MinerType.VECTOR;
/*     */                   break;
/*     */                 case 27:
/* 275 */                   minerType = MinerType.MATRIX;
/*     */                   break;
/*     */                 case 28:
/* 278 */                   minerType = MinerType.TENSOR;
/*     */                   break;
/*     */                 case 29:
/* 281 */                   minerType = MinerType.INFIAR;
/*     */                   break;
/*     */               } 
/* 284 */               this.S.miner.buildMinerActionForSelectedTile(minerType);
/*     */             } 
/*     */             break;
/*     */ 
/*     */           
/*     */           case 48:
/* 290 */             if (this.S._gameUi.mainUi.nextWaveButtonVisible()) {
/* 291 */               this.S.wave.forceNextWaveAction();
/* 292 */               Game.i.soundManager.playStatic(StaticSoundType.BUTTON);
/*     */             } 
/*     */             break;
/*     */           
/*     */           case 49:
/* 297 */             this.S._gameUi.sideMenu.setOffscreen(!this.S._gameUi.sideMenu.isOffscreen());
/* 298 */             Game.i.soundManager.playStatic(StaticSoundType.BUTTON);
/*     */             break;
/*     */           
/*     */           case 50:
/* 302 */             this.S.wave.setAutoForceWaveEnabled(!this.S.wave.autoForceWaveEnabled);
/* 303 */             if (this.S._gameUi != null) {
/* 304 */               this.S._gameUi.mainUi.updateForceWaveButton();
/*     */             }
/* 306 */             if (this.S.wave.autoForceWaveEnabled) {
/* 307 */               this.S._sound.playStatic(StaticSoundType.AUTO_FORCE_WAVE);
/*     */             }
/*     */             break;
/*     */           
/*     */           case 51:
/* 312 */             if (this.S.gameState.getGameSpeed() <= 0.0667F) {
/* 313 */               this.S.gameState.setGameSpeed(1.0F); break;
/*     */             } 
/* 315 */             f = (Game.i.settingsManager.getCustomValue(SettingsManager.CustomValueType.SLOW_MOTION_PAUSE) == 0.0D) ? 0.0F : 0.0667F;
/* 316 */             this.S.gameState.setGameSpeed(f);
/*     */             break;
/*     */ 
/*     */           
/*     */           case 52:
/* 321 */             this.S.gameState.higherGameSpeed();
/* 322 */             Game.i.soundManager.playStatic(StaticSoundType.BUTTON);
/*     */             break;
/*     */           
/*     */           case 53:
/* 326 */             this.S.gameState.lowerGameSpeed();
/* 327 */             Game.i.soundManager.playStatic(StaticSoundType.BUTTON);
/*     */             break;
/*     */           
/*     */           case 54:
/* 331 */             this.S._mapRendering.switchMapDrawMode();
/* 332 */             Game.i.soundManager.playStatic(StaticSoundType.BUTTON);
/*     */             break;
/*     */           
/*     */           case 55:
/* 336 */             this.S._gameUi.questList.setVisible(!this.S._gameUi.questList.isVisible());
/* 337 */             Game.i.soundManager.playStatic(StaticSoundType.BUTTON);
/*     */             break;
/*     */           
/*     */           case 56:
/* 341 */             if (this.S._gameUi._statisticsChart != null) {
/* 342 */               this.S._gameUi._statisticsChart.setVisible(!this.S._gameUi._statisticsChart.isVisible());
/* 343 */               Game.i.soundManager.playStatic(StaticSoundType.BUTTON);
/*     */             } 
/*     */             break;
/*     */           
/*     */           case 57:
/* 348 */             this.S._gameUi.liveLeaderboard.toggleVisible();
/* 349 */             Game.i.soundManager.playStatic(StaticSoundType.BUTTON);
/*     */             break;
/*     */           
/*     */           case 58:
/* 353 */             this.S._input.cameraController.setZoom(1.0D);
/* 354 */             Game.i.soundManager.playStatic(StaticSoundType.BUTTON);
/*     */             break;
/*     */           
/*     */           case 59:
/* 358 */             this.S._input.cameraController.fitMapToScreen(60.0F);
/* 359 */             Game.i.soundManager.playStatic(StaticSoundType.BUTTON);
/*     */             break;
/*     */           
/*     */           case 60:
/* 363 */             Game.exit();
/*     */             break;
/*     */           
/*     */           case 30:
/*     */           case 31:
/*     */           case 32:
/*     */           case 33:
/*     */           case 34:
/*     */           case 35:
/* 372 */             b1 = 0;
/* 373 */             switch (null.a[hotkeyAction.ordinal()]) {
/*     */               case 30:
/* 375 */                 b1 = 0;
/*     */                 break;
/*     */               case 31:
/* 378 */                 b1 = 1;
/*     */                 break;
/*     */               case 32:
/* 381 */                 b1 = 2;
/*     */                 break;
/*     */               case 33:
/* 384 */                 b1 = 3;
/*     */                 break;
/*     */               case 34:
/* 387 */                 b1 = 4;
/*     */                 break;
/*     */               case 35:
/* 390 */                 b1 = 5;
/*     */                 break;
/*     */             } 
/*     */             
/* 394 */             if ((abilityType = this.S.ability.abilitiesConfiguration.slots[b1]) != null) {
/* 395 */               if (this.S.ability.getUiCurrentlyUsingAbility() == abilityType) {
/* 396 */                 this.S.ability.cancelUsingAbility();
/*     */               } else {
/* 398 */                 this.S.ability.startUsingAbility(abilityType);
/*     */               } 
/* 400 */               Game.i.soundManager.playStatic(StaticSoundType.BUTTON);
/*     */             } 
/*     */             break;
/*     */ 
/*     */           
/*     */           case 61:
/* 406 */             if (tile6 = this.S._gameMapSelection.getSelectedTile() instanceof PlatformTile) {
/*     */               
/* 408 */               if ((building6 = ((PlatformTile)tile6).building) != null && building6.buildingType == BuildingType.TOWER)
/* 409 */                 this.S.tower.upgradeTowerAction((Tower)building6);  break;
/*     */             } 
/* 411 */             if (building6 instanceof SourceTile && (
/*     */               
/* 413 */               miner3 = ((SourceTile)building6).miner) != null) {
/* 414 */               this.S.miner.upgradeMinerAction(miner3);
/*     */             }
/*     */             break;
/*     */ 
/*     */ 
/*     */           
/*     */           case 62:
/* 421 */             if (tile5 = this.S._gameMapSelection.getSelectedTile() instanceof PlatformTile && (
/*     */               
/* 423 */               building5 = ((PlatformTile)tile5).building) != null && building5.buildingType == BuildingType.TOWER) {
/* 424 */               this.S.tower.toggleTowerEnabledAction();
/*     */             }
/*     */             break;
/*     */ 
/*     */ 
/*     */           
/*     */           case 63:
/* 431 */             if (tile4 = this.S._gameMapSelection.getSelectedTile() instanceof PlatformTile) {
/*     */               
/* 433 */               if ((building4 = ((PlatformTile)tile4).building) != null)
/* 434 */                 if (building4.buildingType == BuildingType.TOWER) {
/* 435 */                   this.S.tower.globalUpgradeTowerAction(((Tower)building4).type);
/*     */                   break;
/*     */                 }  
/*     */               break;
/*     */             } 
/* 440 */             if (building4 instanceof SourceTile && (
/*     */               
/* 442 */               miner2 = ((SourceTile)building4).miner) != null) {
/* 443 */               this.S.miner.globalUpgradeMinerAction(miner2.type);
/*     */             }
/*     */             break;
/*     */ 
/*     */ 
/*     */           
/*     */           case 64:
/* 450 */             if (tile3 = this.S._gameMapSelection.getSelectedTile() instanceof PlatformTile) {
/*     */               
/* 452 */               if ((building3 = ((PlatformTile)tile3).building) != null) {
/* 453 */                 if (building3.buildingType == BuildingType.TOWER) {
/* 454 */                   this.S.tower.sellTowerAction((Tower)building3);
/* 455 */                   Game.i.soundManager.playStatic(StaticSoundType.BUTTON); break;
/* 456 */                 }  if (building3.buildingType == BuildingType.MODIFIER) {
/* 457 */                   this.S.modifier.sellModifierAction((Modifier)building3);
/* 458 */                   Game.i.soundManager.playStatic(StaticSoundType.BUTTON);
/*     */                 } 
/*     */               }  break;
/* 461 */             }  if (building3 instanceof SourceTile && (
/*     */               
/* 463 */               miner1 = ((SourceTile)building3).miner) != null) {
/* 464 */               this.S.miner.sellMinerAction(miner1);
/* 465 */               Game.i.soundManager.playStatic(StaticSoundType.BUTTON);
/*     */             } 
/*     */             break;
/*     */ 
/*     */ 
/*     */           
/*     */           case 65:
/* 472 */             if (tile2 = this.S._gameMapSelection.getSelectedTile() instanceof PlatformTile) {
/*     */               Building building;
/* 474 */               if ((building = ((PlatformTile)tile2).building) != null && building.buildingType == BuildingType.TOWER) {
/*     */                 
/* 476 */                 Tower tower = (Tower)building;
/* 477 */                 i = 0;
/* 478 */                 if (tower.aimStrategy.ordinal() < Tower.AimStrategy.values.length - 1) {
/* 479 */                   i = tower.aimStrategy.ordinal() + 1;
/*     */                 }
/* 481 */                 this.S.tower.setTowerAimStrategyAction(tower, Tower.AimStrategy.values[i]);
/* 482 */                 this.S._gameUi.tooltip.show(Game.i.towerManager.getAimStrategyName(Tower.AimStrategy.values[i]));
/* 483 */                 Game.i.soundManager.playStatic(StaticSoundType.BUTTON);
/*     */                 break;
/*     */               } 
/* 486 */               int j = 0;
/* 487 */               if (this.S.tower.getDefaultAimStrategy().ordinal() < Tower.AimStrategy.values.length - 1) {
/* 488 */                 j = this.S.tower.getDefaultAimStrategy().ordinal() + 1;
/*     */               }
/* 490 */               this.S.tower.setDefaultAimStrategy(Tower.AimStrategy.values[j]);
/* 491 */               this.S._gameUi.tooltip.show(Game.i.towerManager.getAimStrategyName(Tower.AimStrategy.values[j]));
/* 492 */               Game.i.soundManager.playStatic(StaticSoundType.BUTTON);
/*     */             } 
/*     */             break;
/*     */ 
/*     */ 
/*     */           
/*     */           case 66:
/* 499 */             if (tile2 = this.S._gameMapSelection.getSelectedTile() instanceof PlatformTile) {
/*     */               Building building;
/* 501 */               if ((building = ((PlatformTile)tile2).building) != null && building.buildingType == BuildingType.TOWER) {
/*     */                 
/* 503 */                 Tower tower = (Tower)building;
/* 504 */                 i = Tower.AimStrategy.values.length - 1;
/* 505 */                 if (tower.aimStrategy.ordinal() != 0) {
/* 506 */                   i = tower.aimStrategy.ordinal() - 1;
/*     */                 }
/* 508 */                 this.S.tower.setTowerAimStrategyAction(tower, Tower.AimStrategy.values[i]);
/* 509 */                 this.S._gameUi.tooltip.show(Game.i.towerManager.getAimStrategyName(Tower.AimStrategy.values[i]));
/* 510 */                 Game.i.soundManager.playStatic(StaticSoundType.BUTTON);
/*     */                 break;
/*     */               } 
/* 513 */               int j = Tower.AimStrategy.values.length - 1;
/* 514 */               if (this.S.tower.getDefaultAimStrategy().ordinal() != 0) {
/* 515 */                 j = this.S.tower.getDefaultAimStrategy().ordinal() - 1;
/*     */               }
/* 517 */               this.S.tower.setDefaultAimStrategy(Tower.AimStrategy.values[j]);
/* 518 */               this.S._gameUi.tooltip.show(Game.i.towerManager.getAimStrategyName(Tower.AimStrategy.values[j]));
/* 519 */               Game.i.soundManager.playStatic(StaticSoundType.BUTTON);
/*     */             } 
/*     */             break;
/*     */ 
/*     */ 
/*     */           
/*     */           case 36:
/*     */           case 37:
/*     */           case 38:
/*     */           case 39:
/*     */           case 40:
/*     */           case 41:
/* 531 */             if (tile2 = this.S._gameMapSelection.getSelectedTile() instanceof PlatformTile && (
/*     */               
/* 533 */               building2 = ((PlatformTile)tile2).building) != null && building2.buildingType == BuildingType.TOWER) {
/* 534 */               byte b2 = 0;
/* 535 */               switch (null.a[i.ordinal()]) {
/*     */                 case 36:
/* 537 */                   b2 = 0;
/*     */                   break;
/*     */                 case 37:
/* 540 */                   b2 = 1;
/*     */                   break;
/*     */                 case 38:
/* 543 */                   b2 = 2;
/*     */                   break;
/*     */                 case 39:
/* 546 */                   b2 = 3;
/*     */                   break;
/*     */                 case 40:
/* 549 */                   b2 = 4;
/*     */                   break;
/*     */                 case 41:
/* 552 */                   b2 = 5;
/*     */                   break;
/*     */               } 
/*     */               
/* 556 */               this.S.tower.selectTowerAbilityAction((Tower)building2, b2);
/*     */             } 
/*     */             break;
/*     */ 
/*     */           
/*     */           case 42:
/*     */           case 43:
/*     */           case 44:
/*     */           case 45:
/*     */           case 46:
/*     */           case 47:
/* 567 */             a.i(i.name(), new Object[0]);
/*     */             
/* 569 */             if (tile1 = this.S._gameMapSelection.getSelectedTile() instanceof PlatformTile && (
/*     */               
/* 571 */               building1 = ((PlatformTile)tile1).building) != null && building1.buildingType == BuildingType.TOWER) {
/* 572 */               byte b2 = 0;
/* 573 */               switch (null.a[i.ordinal()]) {
/*     */                 case 42:
/* 575 */                   b2 = 0;
/*     */                   break;
/*     */                 case 43:
/* 578 */                   b2 = 1;
/*     */                   break;
/*     */                 case 44:
/* 581 */                   b2 = 2;
/*     */                   break;
/*     */                 case 45:
/* 584 */                   b2 = 3;
/*     */                   break;
/*     */                 case 46:
/* 587 */                   b2 = 4;
/*     */                   break;
/*     */                 case 47:
/* 590 */                   b2 = 5;
/*     */                   break;
/*     */               } 
/*     */               
/* 594 */               this.S.tower.selectGlobalTowerAbilityAction((Tower)building1, b2);
/*     */             } 
/*     */             break;
/*     */         } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final void dispose() {
/* 606 */     this.c = true;
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\systems\HotKeySystem.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */