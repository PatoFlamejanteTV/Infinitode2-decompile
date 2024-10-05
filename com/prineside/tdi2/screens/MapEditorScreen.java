/*     */ package com.prineside.tdi2.screens;
/*     */ 
/*     */ import com.badlogic.gdx.Gdx;
/*     */ import com.badlogic.gdx.graphics.Color;
/*     */ import com.badlogic.gdx.utils.Array;
/*     */ import com.prineside.luaj.LuaValue;
/*     */ import com.prineside.luaj.lib.jse.CoerceJavaToLua;
/*     */ import com.prineside.tdi2.BasicLevel;
/*     */ import com.prineside.tdi2.Game;
/*     */ import com.prineside.tdi2.GameSystemProvider;
/*     */ import com.prineside.tdi2.Gate;
/*     */ import com.prineside.tdi2.Item;
/*     */ import com.prineside.tdi2.Map;
/*     */ import com.prineside.tdi2.Screen;
/*     */ import com.prineside.tdi2.Threads;
/*     */ import com.prineside.tdi2.Tile;
/*     */ import com.prineside.tdi2.UserMap;
/*     */ import com.prineside.tdi2.enums.GameValueType;
/*     */ import com.prineside.tdi2.enums.ItemCategoryType;
/*     */ import com.prineside.tdi2.events.Event;
/*     */ import com.prineside.tdi2.events.game.MapSizeChange;
/*     */ import com.prineside.tdi2.events.game.Render;
/*     */ import com.prineside.tdi2.events.mapEditor.MapValidationFail;
/*     */ import com.prineside.tdi2.systems.MapEditorSystem;
/*     */ import com.prineside.tdi2.systems.MapRenderingSystem;
/*     */ import com.prineside.tdi2.ui.shared.Dialog;
/*     */ import com.prineside.tdi2.utils.logging.TLog;
/*     */ 
/*     */ public class MapEditorScreen extends Screen {
/*  30 */   private static final TLog a = TLog.forClass(MapEditorScreen.class);
/*     */ 
/*     */   
/*     */   public GameSystemProvider S;
/*     */   
/*     */   private UserMap b;
/*     */   
/*     */   private BasicLevel c;
/*     */ 
/*     */   
/*     */   public MapEditorScreen(UserMap paramUserMap) {
/*  41 */     this.b = paramUserMap;
/*  42 */     a();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public MapEditorScreen(BasicLevel paramBasicLevel) {
/*  48 */     this.c = paramBasicLevel;
/*  49 */     a();
/*     */   }
/*     */ 
/*     */   
/*     */   public void show() {
/*     */     MapEditorSystem.BackedUpMapInfo backedUpMapInfo;
/*  55 */     if ((backedUpMapInfo = MapEditorSystem.getBackUpInfo()) != null) {
/*  56 */       Threads.i().postRunnable(() -> Dialog.i().showConfirmWithCallbacks("Unsaved backup for map \"" + paramBackedUpMapInfo.mapName + "\" found, would you like to restore and edit that map? Saying \"No\" will delete the backup.", (), MapEditorSystem::deleteBackupFile));
/*     */     }
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
/*     */   private void a() {
/*     */     Map map;
/*  72 */     Game.i.uiManager.hideAllComponents();
/*  73 */     Game.i.musicManager.continuePlayingMenuMusicTrack();
/*     */ 
/*     */     
/*  76 */     this.S = new GameSystemProvider(new GameSystemProvider.SystemsConfig(GameSystemProvider.SystemsConfig.Setup.MAP_EDITOR, false));
/*     */ 
/*     */ 
/*     */     
/*  80 */     this.S.createSystems();
/*     */     
/*  82 */     Game.i.scriptManager.global.getGlobals().set("S", CoerceJavaToLua.coerce(this.S));
/*     */ 
/*     */     
/*  85 */     if (this.b != null) {
/*     */       
/*  87 */       this.S._mapEditor.basicLevelEditor = false;
/*  88 */       this.S._mapEditor.userMap = this.b;
/*     */ 
/*     */       
/*  91 */       this.S._inventory.initAddItems((Array)Game.i.progressManager.getItemsByCategory(ItemCategoryType.MAP_EDITOR));
/*     */       
/*  93 */       map = this.b.map.cpy();
/*     */       int i;
/*  95 */       for (i = 0; i < map.getHeight(); i++) {
/*  96 */         for (byte b = 0; b < map.getWidth(); b++) {
/*     */           Tile tile;
/*  98 */           if ((tile = map.getTile(b, i)) != null && 
/*  99 */             !this.S._inventory.remove((Item)Item.D.F_TILE.create(tile)))
/*     */           {
/* 101 */             map.setTile(b, i, null);
/*     */           }
/*     */         } 
/*     */       } 
/*     */       
/* 106 */       for (i = 0; i <= map.getHeight(); i++) {
/* 107 */         for (byte b = 0; b <= map.getWidth(); b++) {
/* 108 */           boolean[] arrayOfBoolean; byte b1; for (arrayOfBoolean = new boolean[] { false, true }, b1 = 0; b1 < 2; ) { boolean bool = arrayOfBoolean[b1];
/*     */             Gate gate;
/* 110 */             if ((gate = map.getGate(b, i, bool)) != null && 
/* 111 */               !this.S._inventory.remove((Item)Item.D.F_GATE.create(gate))) {
/* 112 */               map.setGate(b, i, bool, null);
/*     */             }
/*     */             
/*     */             b1++; }
/*     */         
/*     */         } 
/*     */       } 
/*     */       
/* 120 */       i = Game.i.gameValueManager.getSnapshot().getIntValue(GameValueType.USER_MAP_MAX_SIZE);
/* 121 */       if (map.getWidth() < i || map.getHeight() < i)
/*     */       {
/* 123 */         (map = map.cpy()).setSize(i, i);
/*     */       }
/*     */     } else {
/*     */       
/* 127 */       this.S._mapEditor.basicLevelEditor = true;
/* 128 */       this.S._mapEditor.basicLevel = this.c;
/*     */ 
/*     */       
/* 131 */       this.S._inventory.initAddItems((Array)Game.i.progressManager.getItemsByCategory(ItemCategoryType.MAP_EDITOR));
/* 132 */       this.S._inventory.setStaticMode(true);
/*     */       
/* 134 */       map = this.c.getMap().cpy();
/*     */     } 
/*     */ 
/*     */     
/* 138 */     this.S.pathfinding.throwExceptionOnMissingPath = false;
/* 139 */     this.S.map.setMap(map);
/*     */     
/* 141 */     this.S.map.drawPathTraces = true;
/* 142 */     this.S._mapRendering.drawMapGrid = true;
/*     */     
/* 144 */     this.S.setupSystems();
/*     */ 
/*     */     
/* 147 */     this.S.postSetupSystems();
/*     */     
/* 149 */     this.S.events.getListeners(MapSizeChange.class).add(paramMapSizeChange -> this.S._input.getCameraController().setMapSize(this.S.map.getMap().getWidth() << 7, this.S.map.getMap().getHeight() << 7))
/*     */       
/* 151 */       .setDescription("MapEditorScreen - updates camera controller map size");
/*     */     
/* 153 */     this.S.events.getListeners(MapValidationFail.class).add(paramMapValidationFail -> {
/*     */           Map.InvalidMapException invalidMapException = paramMapValidationFail.getException();
/*     */           a.e(invalidMapException.getFixHintMessage(), new Object[] { invalidMapException });
/*     */           Dialog.i().showAlert(invalidMapException.getFixHintMessage());
/* 157 */         }).setDescription("MapEditorScreen - shows validation error in the ui");
/*     */     
/* 159 */     this.S._mapRendering.setDrawMode(MapRenderingSystem.DrawMode.MAP_EDITOR);
/* 160 */     this.S._pathRendering.showAllPathTraces(true);
/*     */   }
/*     */   
/*     */   public void draw(float paramFloat) {
/* 164 */     Color color = Game.i.assetManager.getColor("game_background");
/* 165 */     Gdx.gl.glClearColor(color.r, color.g, color.b, color.a);
/* 166 */     Gdx.gl.glClear(16640);
/*     */     
/* 168 */     if (Game.i.settingsManager.isEscButtonJustPressed() && 
/* 169 */       !this.S._mapEditor.mapChanged) {
/* 170 */       this.S._mapEditor.goToPreviousScreen();
/*     */       
/*     */       return;
/*     */     } 
/*     */     
/* 175 */     this.S.updateSystems();
/*     */ 
/*     */     
/* 178 */     this.S.events.trigger((Event)new Render(paramFloat, paramFloat));
/* 179 */     Game.i.renderingManager.stopAnyBatchDrawing();
/*     */   }
/*     */ 
/*     */   
/*     */   public void dispose() {
/* 184 */     Game.i.scriptManager.global.getGlobals().set("S", LuaValue.NIL);
/* 185 */     this.S.dispose();
/* 186 */     this.S = null;
/* 187 */     this.c = null;
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\screens\MapEditorScreen.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */