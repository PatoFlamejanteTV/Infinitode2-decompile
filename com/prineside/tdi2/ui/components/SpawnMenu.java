/*     */ package com.prineside.tdi2.ui.components;
/*     */ 
/*     */ import com.badlogic.gdx.graphics.Color;
/*     */ import com.badlogic.gdx.graphics.g2d.BitmapFont;
/*     */ import com.badlogic.gdx.utils.Array;
/*     */ import com.badlogic.gdx.utils.Disposable;
/*     */ import com.badlogic.gdx.utils.ObjectMap;
/*     */ import com.badlogic.gdx.utils.StringBuilder;
/*     */ import com.prineside.tdi2.EnemyGroup;
/*     */ import com.prineside.tdi2.Game;
/*     */ import com.prineside.tdi2.GameSystemProvider;
/*     */ import com.prineside.tdi2.Tile;
/*     */ import com.prineside.tdi2.enums.TileType;
/*     */ import com.prineside.tdi2.events.Event;
/*     */ import com.prineside.tdi2.events.Listener;
/*     */ import com.prineside.tdi2.events.game.EnemySpawn;
/*     */ import com.prineside.tdi2.events.game.MapElementSelect;
/*     */ import com.prineside.tdi2.events.game.WaveStatusChange;
/*     */ import com.prineside.tdi2.scene2d.Actor;
/*     */ import com.prineside.tdi2.scene2d.EventListener;
/*     */ import com.prineside.tdi2.scene2d.Group;
/*     */ import com.prineside.tdi2.scene2d.InputEvent;
/*     */ import com.prineside.tdi2.scene2d.Touchable;
/*     */ import com.prineside.tdi2.scene2d.ui.Image;
/*     */ import com.prineside.tdi2.scene2d.utils.ClickListener;
/*     */ import com.prineside.tdi2.scene2d.utils.Drawable;
/*     */ import com.prineside.tdi2.tiles.SpawnTile;
/*     */ import com.prineside.tdi2.ui.actors.ComplexButton;
/*     */ import com.prineside.tdi2.ui.actors.Label;
/*     */ import com.prineside.tdi2.ui.actors.SideMenu;
/*     */ import com.prineside.tdi2.ui.shared.WavesTimelineOverlay;
/*     */ import com.prineside.tdi2.utils.MaterialColor;
/*     */ import com.prineside.tdi2.utils.StringFormatter;
/*     */ 
/*     */ public class SpawnMenu implements Disposable, Listener<EnemySpawn> {
/*  36 */   private static final Color a = new Color(808464639);
/*  37 */   private static final Color b = new Color(623191551);
/*     */   
/*     */   public final SideMenu sideMenu;
/*     */   
/*     */   public final SideMenu.SideMenuContainer container;
/*     */   
/*     */   private boolean c;
/*     */   
/*     */   private Label d;
/*     */   private Group e;
/*     */   private Group f;
/*     */   private ComplexButton g;
/*  49 */   private ObjectMap<EnemyGroup, Label> h = new ObjectMap();
/*     */   
/*     */   private final GameSystemProvider i;
/*     */   
/*  53 */   private static final StringBuilder j = new StringBuilder();
/*     */   
/*     */   public SpawnMenu(SideMenu paramSideMenu, GameSystemProvider paramGameSystemProvider) {
/*  56 */     this.i = paramGameSystemProvider;
/*     */     
/*  58 */     this.sideMenu = paramSideMenu;
/*     */ 
/*     */     
/*  61 */     this.container = paramSideMenu.createContainer("SpawnMenu");
/*     */     
/*  63 */     int i = Game.i.settingsManager.getScaledViewportHeight() - 1080;
/*     */     
/*     */     Label label1;
/*     */     
/*  67 */     (label1 = new Label(Game.i.localeManager.i18n.get("tile_name_SPAWN").toUpperCase(), new Label.LabelStyle((BitmapFont)Game.i.assetManager.getFont(36), Color.WHITE))).setSize(460.0F, 26.0F);
/*  68 */     label1.setPosition(40.0F, 994.0F + i);
/*  69 */     this.container.addActor((Actor)label1);
/*     */     
/*  71 */     this.d = new Label("250%", new Label.LabelStyle((BitmapFont)Game.i.assetManager.getFont(36), Color.WHITE));
/*  72 */     this.d.setSize(100.0F, 26.0F);
/*  73 */     this.d.setAlignment(16);
/*  74 */     this.d.setPosition(460.0F, 994.0F + i);
/*  75 */     this.container.addActor((Actor)this.d);
/*     */ 
/*     */ 
/*     */     
/*  79 */     (label1 = new Label(Game.i.localeManager.i18n.get("tile_description_SPAWN"), new Label.LabelStyle((BitmapFont)Game.i.assetManager.getFont(24), Color.WHITE))).setSize(420.0F, 100.0F);
/*  80 */     label1.setPosition(40.0F, 884.0F + i);
/*  81 */     label1.setAlignment(10);
/*  82 */     label1.setWrap(true);
/*  83 */     this.container.addActor((Actor)label1);
/*     */ 
/*     */     
/*  86 */     (label1 = new Label(Game.i.localeManager.i18n.get("difficulty").toUpperCase(), new Label.LabelStyle((BitmapFont)Game.i.assetManager.getFont(24), Color.WHITE))).setSize(100.0F, 100.0F);
/*  87 */     label1.setPosition(460.0F, 884.0F + i);
/*  88 */     label1.setAlignment(18);
/*  89 */     label1.setColor(1.0F, 1.0F, 1.0F, 0.28F);
/*  90 */     this.container.addActor((Actor)label1);
/*     */     
/*     */     Group group;
/*     */     
/*  94 */     (group = new Group()).setTransform(false);
/*  95 */     group.setName("spawn_menu_details");
/*  96 */     this.container.addActor((Actor)group);
/*     */     
/*     */     Label label2;
/*  99 */     (label2 = new Label(Game.i.localeManager.i18n.get("enemies_that_can_be_spawned"), new Label.LabelStyle((BitmapFont)Game.i.assetManager.getFont(21), Color.WHITE))).setColor(1.0F, 1.0F, 1.0F, 0.28F);
/* 100 */     label2.setPosition(40.0F, 906.0F + i);
/* 101 */     label2.setSize(100.0F, 17.0F);
/* 102 */     group.addActor((Actor)label2);
/*     */     
/* 104 */     this.e = new Group();
/* 105 */     this.e.setTransform(false);
/* 106 */     this.e.setPosition(0.0F, 840.0F + i);
/* 107 */     this.e.setSize(600.0F, 64.0F);
/* 108 */     group.addActor((Actor)this.e);
/*     */ 
/*     */ 
/*     */     
/* 112 */     (label2 = new Label(Game.i.localeManager.i18n.get("enemies_by_wave").toUpperCase(), new Label.LabelStyle((BitmapFont)Game.i.assetManager.getFont(21), Color.WHITE))).setColor(1.0F, 1.0F, 1.0F, 0.28F);
/* 113 */     label2.setPosition(40.0F, 820.0F + i);
/* 114 */     label2.setSize(100.0F, 17.0F);
/* 115 */     group.addActor((Actor)label2);
/*     */ 
/*     */     
/* 118 */     (label2 = new Label(Game.i.localeManager.i18n.get("density"), new Label.LabelStyle((BitmapFont)Game.i.assetManager.getFont(21), Color.WHITE))).setColor(1.0F, 1.0F, 1.0F, 0.56F);
/* 119 */     label2.setPosition(270.0F, 774.0F + i);
/* 120 */     label2.setSize(110.0F, 32.0F);
/* 121 */     label2.setAlignment(1);
/* 122 */     group.addActor((Actor)label2);
/*     */     
/*     */     Image image;
/* 125 */     (image = new Image((Drawable)Game.i.assetManager.getDrawable("icon-heart"))).setColor(1.0F, 1.0F, 1.0F, 0.56F);
/* 126 */     image.setSize(32.0F, 32.0F);
/* 127 */     image.setPosition(419.0F, 774.0F + i);
/* 128 */     group.addActor((Actor)image);
/*     */ 
/*     */     
/* 131 */     (image = new Image((Drawable)Game.i.assetManager.getDrawable("icon-count"))).setColor(1.0F, 1.0F, 1.0F, 0.56F);
/* 132 */     image.setSize(32.0F, 32.0F);
/* 133 */     image.setPosition(528.0F, 774.0F + i);
/* 134 */     group.addActor((Actor)image);
/*     */     
/* 136 */     this.f = new Group();
/* 137 */     this.f.setTransform(false);
/* 138 */     this.f.setPosition(0.0F, 0.0F);
/* 139 */     this.f.setSize(600.0F, 766.0F + i);
/* 140 */     group.addActor((Actor)this.f);
/*     */     
/* 142 */     this.g = new ComplexButton(Game.i.localeManager.i18n.get("waves"), Game.i.assetManager.getLabelStyle(30), () -> {
/*     */           if (paramGameSystemProvider.gameState.basicLevelName != null) {
/*     */             WavesTimelineOverlay.i().setConfiguration(paramGameSystemProvider.wave.generateWavesTimelineConfigurationBasicLevel(Game.i.basicLevelManager.getLevel(paramGameSystemProvider.gameState.basicLevelName), paramGameSystemProvider.map.getMap(), (paramGameSystemProvider.wave.wave == null) ? 1 : paramGameSystemProvider.wave.wave.waveNumber));
/*     */           } else if (paramGameSystemProvider.gameState.userMapId != null) {
/*     */             WavesTimelineOverlay.i().setConfiguration(paramGameSystemProvider.wave.generateWavesTimelineConfigurationUserMap(Game.i.userMapManager.getUserMap(paramGameSystemProvider.gameState.userMapId), paramGameSystemProvider.map.getMap(), (paramGameSystemProvider.wave.wave == null) ? 1 : paramGameSystemProvider.wave.wave.waveNumber, paramGameSystemProvider.wave.bossWaves));
/*     */           } else {
/*     */             return;
/*     */           } 
/*     */ 
/*     */ 
/*     */ 
/*     */           
/*     */           paramGameSystemProvider.gameState.getNonAnimatedGameSpeed();
/*     */ 
/*     */ 
/*     */ 
/*     */           
/*     */           WavesTimelineOverlay.i().setVisible(true);
/*     */         });
/*     */ 
/*     */ 
/*     */     
/* 164 */     this.g.setBackground((Drawable)Game.i.assetManager.getDrawable("blank"), 0.0F, 0.0F, 296.0F, 80.0F);
/* 165 */     this.g.setSize(296.0F, 80.0F);
/* 166 */     this.g.setIconPositioned((Drawable)Game.i.assetManager.getDrawable("icon-wave"), 20.0F, 16.0F, 40.0F, 40.0F);
/* 167 */     this.g.setLabel(76.0F, 20.0F, 100.0F, 40.0F, 8);
/* 168 */     this.g.setPosition(304.0F, 40.0F);
/* 169 */     group.addActor((Actor)this.g);
/*     */ 
/*     */ 
/*     */     
/* 173 */     _SideMenuListener _SideMenuListener = new _SideMenuListener((byte)0);
/* 174 */     paramSideMenu.addListener((SideMenu.SideMenuListener)_SideMenuListener);
/*     */ 
/*     */     
/* 177 */     paramGameSystemProvider.events.getListeners(EnemySpawn.class).add(this).setDescription("Updates menu if some enemy has spawned from the selected spawn");
/* 178 */     paramGameSystemProvider.events.getListeners(WaveStatusChange.class).add(paramWaveStatusChange -> {
/*     */           if (this.c) {
/*     */             update();
/*     */           }
/*     */         });
/*     */     
/* 184 */     paramGameSystemProvider.events.getListeners(MapElementSelect.class).add(paramMapElementSelect -> {
/*     */           Tile tile;
/*     */           
/*     */           if ((tile = paramGameSystemProvider._gameMapSelection.getSelectedTile()) != null && tile.type == TileType.SPAWN) {
/*     */             update();
/*     */             a(true);
/*     */             return;
/*     */           } 
/*     */           a(false);
/*     */         });
/* 194 */     this.container.hide();
/*     */   }
/*     */   
/*     */   private void a(boolean paramBoolean) {
/* 198 */     if (this.c != paramBoolean) {
/* 199 */       this.c = paramBoolean;
/* 200 */       if (paramBoolean) {
/* 201 */         this.container.show();
/* 202 */         update(); return;
/*     */       } 
/* 204 */       this.container.hide();
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void update() {
/*     */     Tile tile;
/* 211 */     if ((tile = this.i._gameMapSelection.getSelectedTile()) != null && tile.type == TileType.SPAWN) {
/* 212 */       float f1, f2; this.container.setLabelOverTitleTilePos(tile);
/*     */       
/*     */       SpawnTile spawnTile;
/*     */       
/* 216 */       int i = StrictMath.round((spawnTile = (SpawnTile)tile).difficulty);
/*     */       
/* 218 */       j.setLength(0);
/* 219 */       j.append(i).append('%');
/* 220 */       this.d.setText((CharSequence)j);
/* 221 */       if (i < 100) {
/* 222 */         this.d.setColor(MaterialColor.GREEN.P500);
/* 223 */       } else if (i > 100) {
/* 224 */         this.d.setColor(MaterialColor.RED.P500);
/*     */       } else {
/* 226 */         this.d.setColor(MaterialColor.AMBER.P500);
/*     */       } 
/*     */ 
/*     */       
/* 230 */       this.e.clearChildren();
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 235 */       if ((i = (spawnTile.getAllowedEnemies()).size) * 64.0F <= 520.0F) {
/* 236 */         f2 = (520.0F - i * 64.0F) / 2.0F + 40.0F;
/* 237 */         f1 = 64.0F;
/*     */       } else {
/* 239 */         f2 = 40.0F;
/* 240 */         f1 = 456.0F / (f1 - 1);
/*     */       } 
/* 242 */       for (Array.ArrayIterator<SpawnTile.AllowedEnemyConfig> arrayIterator = spawnTile.getAllowedEnemies().iterator(); arrayIterator.hasNext(); ) { SpawnTile.AllowedEnemyConfig allowedEnemyConfig = arrayIterator.next();
/*     */         Image image;
/* 244 */         (image = new Image(this.i.enemy.getTexture(allowedEnemyConfig.enemyType))).setSize(32.0F, 32.0F);
/* 245 */         image.setPosition(f2 + 16.0F, 16.0F);
/* 246 */         image.setTouchable(Touchable.enabled);
/* 247 */         image.addListener((EventListener)new ClickListener(this, allowedEnemyConfig)
/*     */             {
/*     */               public void clicked(InputEvent param1InputEvent, float param1Float1, float param1Float2) {
/* 250 */                 (SpawnMenu.a(this.b))._gameUi.newEnemyOverlay.show(this.a.enemyType);
/*     */               }
/*     */             });
/* 253 */         this.e.addActor((Actor)image);
/* 254 */         f2 += f1; }
/*     */ 
/*     */ 
/*     */       
/* 258 */       this.f.clearChildren();
/*     */       
/* 260 */       this.h.clear();
/*     */       
/* 262 */       byte b1 = (this.i.wave.wave == null) ? 0 : this.i.wave.wave.waveNumber;
/* 263 */       float f3 = this.f.getHeight();
/* 264 */       for (byte b2 = 0; b2 <= 10 && 
/* 265 */         f3 >= 100.0F; b2++) {
/*     */         int j;
/*     */         
/* 268 */         if ((j = b2 + b1) > 0) {
/*     */ 
/*     */ 
/*     */           
/* 272 */           boolean bool = (j == b1) ? true : false;
/*     */           
/*     */           Image image;
/* 275 */           (image = new Image((Drawable)Game.i.assetManager.getDrawable("icon-wave"))).setPosition(40.0F, f3 - 42.0F);
/* 276 */           image.setSize(32.0F, 32.0F);
/* 277 */           this.f.addActor((Actor)image);
/*     */           
/* 279 */           j.setLength(0);
/* 280 */           j.append(j);
/*     */           Label label;
/* 282 */           (label = new Label((CharSequence)j, new Label.LabelStyle((BitmapFont)Game.i.assetManager.getFont(30), Color.WHITE))).setSize(100.0F, 32.0F);
/* 283 */           label.setPosition(80.0F, f3 - 42.0F);
/* 284 */           this.f.addActor((Actor)label);
/*     */           
/* 286 */           label = null;
/* 287 */           if (b2 == 0) {
/* 288 */             label = new Label(Game.i.localeManager.i18n.get("current"), new Label.LabelStyle((BitmapFont)Game.i.assetManager.getFont(21), Color.WHITE));
/* 289 */           } else if (b2 == 1) {
/* 290 */             label = new Label(Game.i.localeManager.i18n.get("next"), new Label.LabelStyle((BitmapFont)Game.i.assetManager.getFont(21), Color.WHITE));
/*     */           } 
/* 292 */           if (label != null) {
/* 293 */             label.setSize(80.0F, 32.0F);
/* 294 */             label.setPosition(40.0F, f3 - 76.0F);
/* 295 */             this.f.addActor((Actor)label);
/*     */           } 
/*     */           
/*     */           Array array;
/* 299 */           if ((array = (Array)spawnTile.enemySpawnQueues.get(b2)).size == 0) {
/*     */             
/* 301 */             (image = new Image((Drawable)Game.i.assetManager.getDrawable("blank"))).setSize(440.0F, 52.0F);
/* 302 */             image.setPosition(160.0F, f3 - 52.0F);
/* 303 */             image.setColor(bool ? a : b);
/* 304 */             this.f.addActor((Actor)image);
/*     */             
/*     */             Label label1;
/* 307 */             (label1 = new Label(Game.i.localeManager.i18n.get("no_enemies"), new Label.LabelStyle((BitmapFont)Game.i.assetManager.getFont(21), Color.WHITE))).setSize(100.0F, 52.0F);
/* 308 */             label1.setPosition(176.0F, f3 - 52.0F);
/* 309 */             label1.setColor(1.0F, 1.0F, 1.0F, 0.56F);
/* 310 */             this.f.addActor((Actor)label1);
/*     */             
/* 312 */             f3 -= 108.0F;
/*     */           } else {
/* 314 */             for (byte b = 0; b < array.size; b++) {
/* 315 */               String str; EnemyGroup enemyGroup = (EnemyGroup)array.get(b);
/*     */               
/*     */               Image image2;
/* 318 */               (image2 = new Image((Drawable)Game.i.assetManager.getDrawable("blank"))).setSize(440.0F, 52.0F);
/* 319 */               image2.setPosition(160.0F, f3 - 52.0F);
/* 320 */               image2.setColor(bool ? a : b);
/* 321 */               this.f.addActor((Actor)image2);
/*     */ 
/*     */               
/* 324 */               (image2 = new Image(this.i.enemy.getTexture(enemyGroup.getEnemyType()))).setSize(40.0F, 40.0F);
/* 325 */               image2.setPosition(183.0F, f3 - 46.0F);
/* 326 */               this.f.addActor((Actor)image2);
/*     */ 
/*     */               
/* 329 */               if (enemyGroup.interval <= 0.25F) {
/* 330 */                 str = "icon-density-high";
/* 331 */               } else if (enemyGroup.interval >= 1.0F) {
/* 332 */                 str = "icon-density-low";
/*     */               } else {
/* 334 */                 str = "icon-density-medium";
/*     */               } 
/*     */               Image image1;
/* 337 */               (image1 = new Image((Drawable)Game.i.assetManager.getDrawable(str))).setSize(32.0F, 32.0F);
/* 338 */               image1.setPosition(309.0F, f3 - 42.0F);
/* 339 */               this.f.addActor((Actor)image1);
/*     */               
/*     */               Label label1;
/* 342 */               (label1 = new Label((CharSequence)StringFormatter.compactNumber(enemyGroup.health, false), new Label.LabelStyle((BitmapFont)Game.i.assetManager.getFont(24), Color.WHITE))).setSize(110.0F, 52.0F);
/* 343 */               label1.setAlignment(1);
/* 344 */               label1.setPosition(380.0F, f3 - 52.0F);
/* 345 */               this.f.addActor((Actor)label1);
/*     */ 
/*     */               
/* 348 */               (label1 = new Label((CharSequence)StringFormatter.compactNumber((enemyGroup.count - enemyGroup.getSpawnedCount()), false), new Label.LabelStyle((BitmapFont)Game.i.assetManager.getFont(24), Color.WHITE))).setSize(100.0F, 52.0F);
/* 349 */               label1.setAlignment(16);
/* 350 */               label1.setPosition(460.0F, f3 - 52.0F);
/* 351 */               this.f.addActor((Actor)label1);
/*     */               
/* 353 */               if (bool) {
/* 354 */                 this.h.put(enemyGroup, label1);
/*     */               }
/*     */               
/* 357 */               f3 -= 56.0F;
/*     */             } 
/*     */             
/* 360 */             f3 -= 56.0F;
/*     */           } 
/*     */         } 
/*     */       } 
/*     */ 
/*     */       
/* 366 */       this.g.setVisible((this.i.wave.getWaveGenerator() == null));
/*     */     } 
/*     */   }
/*     */   
/*     */   private void a() {
/* 371 */     if (this.i.wave.wave == null)
/*     */       return; 
/*     */     Tile tile;
/* 374 */     if ((tile = this.i._gameMapSelection.getSelectedTile()) != null && tile.type == TileType.SPAWN) {
/*     */       SpawnTile spawnTile;
/*     */       
/* 377 */       Array array = (Array)(spawnTile = (SpawnTile)tile).enemySpawnQueues.get(0);
/* 378 */       for (byte b = 0; b < array.size; b++) {
/* 379 */         EnemyGroup enemyGroup = (EnemyGroup)array.get(b);
/*     */         Label label;
/* 381 */         if ((label = (Label)this.h.get(enemyGroup)) != null) {
/* 382 */           label.setText((CharSequence)StringFormatter.compactNumber((enemyGroup.count - enemyGroup.getSpawnedCount()), false));
/*     */         }
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void dispose() {}
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void handleEvent(EnemySpawn paramEnemySpawn) {
/* 397 */     if (this.c && 
/* 398 */       (paramEnemySpawn.getEnemy()).spawnTile == this.i._gameMapSelection.getSelectedTile())
/* 399 */       a(); 
/*     */   }
/*     */   
/*     */   private class _SideMenuListener
/*     */     extends SideMenu.SideMenuListener.SideMenuListenerAdapter {
/*     */     private _SideMenuListener(SpawnMenu this$0) {}
/*     */     
/*     */     public void offscreenChanged() {
/* 407 */       this.a.update();
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi\\ui\components\SpawnMenu.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */