/*     */ package com.prineside.tdi2.ui.components;
/*     */ 
/*     */ import com.badlogic.gdx.graphics.Color;
/*     */ import com.badlogic.gdx.utils.Array;
/*     */ import com.badlogic.gdx.utils.StringBuilder;
/*     */ import com.prineside.tdi2.Game;
/*     */ import com.prineside.tdi2.GameSystemProvider;
/*     */ import com.prineside.tdi2.GameValueConfig;
/*     */ import com.prineside.tdi2.Tile;
/*     */ import com.prineside.tdi2.enums.EnemyType;
/*     */ import com.prineside.tdi2.enums.TileType;
/*     */ import com.prineside.tdi2.events.game.MapElementSelect;
/*     */ import com.prineside.tdi2.managers.GameValueManager;
/*     */ import com.prineside.tdi2.scene2d.Actor;
/*     */ import com.prineside.tdi2.scene2d.Group;
/*     */ import com.prineside.tdi2.scene2d.ui.Image;
/*     */ import com.prineside.tdi2.scene2d.ui.ScrollPane;
/*     */ import com.prineside.tdi2.scene2d.ui.Table;
/*     */ import com.prineside.tdi2.scene2d.utils.Drawable;
/*     */ import com.prineside.tdi2.tiles.BossTile;
/*     */ import com.prineside.tdi2.ui.actors.Label;
/*     */ import com.prineside.tdi2.ui.actors.LimitedWidthLabel;
/*     */ import com.prineside.tdi2.ui.actors.SideMenu;
/*     */ import com.prineside.tdi2.utils.MaterialColor;
/*     */ import com.prineside.tdi2.utils.UiUtils;
/*     */ import com.prineside.tdi2.utils.logging.TLog;
/*     */ import java.util.Locale;
/*     */ 
/*     */ public class BossTileMenu
/*     */ {
/*  31 */   private static final TLog a = TLog.forClass(BossTileMenu.class);
/*     */ 
/*     */   
/*  34 */   private static final Color b = new Color(623191551);
/*     */ 
/*     */   
/*     */   private final SideMenu.SideMenuContainer c;
/*     */ 
/*     */   
/*     */   private boolean d;
/*     */   
/*     */   private Table e;
/*     */   
/*     */   private Label f;
/*     */   
/*     */   private GameSystemProvider g;
/*     */   
/*  48 */   private final _SideMenuListener h = new _SideMenuListener((byte)0);
/*     */   
/*  50 */   private static final StringBuilder i = new StringBuilder();
/*     */   
/*     */   public BossTileMenu(SideMenu paramSideMenu, GameSystemProvider paramGameSystemProvider) {
/*  53 */     this.g = paramGameSystemProvider;
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  58 */     this.c = paramSideMenu.createContainer("TargetMenu");
/*     */     
/*  60 */     int i = Game.i.settingsManager.getScaledViewportHeight() - 1080;
/*     */     
/*     */     Label label;
/*     */     
/*  64 */     (label = new Label(Game.i.localeManager.i18n.get("tile_name_BOSS").toUpperCase(), Game.i.assetManager.getLabelStyle(36))).setSize(460.0F, 26.0F);
/*  65 */     label.setPosition(40.0F, 994.0F + i);
/*  66 */     this.c.addActor((Actor)label);
/*     */ 
/*     */ 
/*     */     
/*  70 */     (label = new Label(Game.i.localeManager.i18n.get("tile_description_BOSS"), Game.i.assetManager.getLabelStyle(24))).setSize(420.0F, 100.0F);
/*  71 */     label.setPosition(40.0F, 884.0F + i);
/*  72 */     label.setAlignment(10);
/*  73 */     label.setWrap(true);
/*  74 */     this.c.addActor((Actor)label);
/*     */ 
/*     */     
/*  77 */     this.f = new Label("", Game.i.assetManager.getLabelStyle(36));
/*  78 */     this.f.setSize(600.0F, 26.0F);
/*  79 */     this.f.setPosition(0.0F, 898.0F + i);
/*  80 */     this.f.setAlignment(1);
/*  81 */     this.f.setColor(MaterialColor.GREEN.P500);
/*  82 */     this.c.addActor((Actor)this.f);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  88 */     (label = new Label(Game.i.localeManager.i18n.get("effect").toUpperCase(), Game.i.assetManager.getLabelStyle(21))).setSize(100.0F, 16.0F);
/*  89 */     label.setPosition(40.0F, 846.0F + i);
/*  90 */     label.setColor(1.0F, 1.0F, 1.0F, 0.28F);
/*  91 */     this.c.addActor((Actor)label);
/*     */ 
/*     */     
/*  94 */     (label = new Label(Game.i.localeManager.i18n.get("value_units").toUpperCase(), Game.i.assetManager.getLabelStyle(21))).setSize(100.0F, 16.0F);
/*  95 */     label.setPosition(460.0F, 846.0F + i);
/*  96 */     label.setAlignment(16);
/*  97 */     label.setColor(1.0F, 1.0F, 1.0F, 0.28F);
/*  98 */     this.c.addActor((Actor)label);
/*     */     
/* 100 */     this.e = new Table();
/*     */     ScrollPane scrollPane;
/* 102 */     UiUtils.enableMouseMoveScrollFocus(scrollPane = new ScrollPane((Actor)this.e));
/* 103 */     scrollPane.setSize(600.0F, 830.0F + i);
/* 104 */     this.c.addActor((Actor)scrollPane);
/*     */ 
/*     */     
/* 107 */     paramSideMenu.addListener((SideMenu.SideMenuListener)this.h);
/*     */     
/* 109 */     paramGameSystemProvider.events.getListeners(MapElementSelect.class).add(paramMapElementSelect -> {
/*     */           Tile tile;
/*     */           
/*     */           if ((tile = paramGameSystemProvider._gameMapSelection.getSelectedTile()) != null && tile.type == TileType.BOSS) {
/*     */             a();
/*     */             a(true);
/*     */             return;
/*     */           } 
/*     */           a(false);
/*     */         });
/* 119 */     this.c.hide();
/*     */   }
/*     */   
/*     */   private void a(boolean paramBoolean) {
/* 123 */     if (this.d != paramBoolean) {
/* 124 */       this.d = paramBoolean;
/* 125 */       if (paramBoolean) {
/* 126 */         this.c.show();
/*     */       } else {
/*     */         
/* 129 */         this.c.hide();
/*     */       } 
/*     */       
/* 132 */       a.i(paramBoolean ? "shown" : "hidden", new Object[0]);
/*     */     } 
/*     */   }
/*     */   
/*     */   private void a() {
/* 137 */     this.e.clearChildren();
/*     */     
/*     */     Tile tile;
/* 140 */     if ((tile = this.g._gameMapSelection.getSelectedTile()) != null && tile.type == TileType.BOSS) {
/* 141 */       this.c.setLabelOverTitleTilePos(tile);
/*     */       
/* 143 */       BossTile bossTile = (BossTile)tile;
/*     */       
/* 145 */       this.f.setText(bossTile.getBossTileTypeName());
/*     */       
/*     */       Array array;
/* 148 */       if ((array = bossTile.getGameValues()).size != 0) {
/* 149 */         for (byte b = 0; b < array.size; b++) {
/* 150 */           GameValueConfig gameValueConfig = (GameValueConfig)array.get(b);
/*     */           
/*     */           Group group;
/* 153 */           (group = new Group()).setTransform(false);
/*     */           
/*     */           Image image1;
/* 156 */           (image1 = new Image((Drawable)Game.i.assetManager.getDrawable("blank"))).setSize(600.0F, 52.0F);
/* 157 */           image1.setColor(b);
/* 158 */           group.addActor((Actor)image1);
/*     */           
/*     */           Image image2;
/* 161 */           (image2 = new Image((Drawable)Game.i.gameValueManager.getStockValueConfig(gameValueConfig.getType()).createIconForBackground(new Color(623191551)))).setPosition(40.0F, 6.0F);
/* 162 */           image2.setSize(40.0F, 40.0F);
/* 163 */           group.addActor((Actor)image2);
/*     */           
/* 165 */           i.setLength(0);
/* 166 */           i.append(Game.i.gameValueManager.getTitle(gameValueConfig.getType()));
/*     */           LimitedWidthLabel limitedWidthLabel;
/* 168 */           (limitedWidthLabel = new LimitedWidthLabel((CharSequence)i, 24, 21, 420.0F)).setSize(100.0F, 52.0F);
/* 169 */           limitedWidthLabel.setPosition(96.0F, 0.0F);
/* 170 */           group.addActor((Actor)limitedWidthLabel);
/*     */           
/* 172 */           i.setLength(0);
/*     */           GameValueManager.ValueUnits valueUnits;
/* 174 */           if ((valueUnits = (Game.i.gameValueManager.getStockValueConfig(gameValueConfig.getType())).units) == GameValueManager.ValueUnits.BOOLEAN) {
/*     */             
/* 176 */             if (gameValueConfig.getValue() == 0.0D)
/*     */             {
/* 178 */               i.append(Game.i.localeManager.i18n.get("disabled").toLowerCase(Locale.ENGLISH));
/*     */             }
/*     */           } else {
/* 181 */             i.append(Game.i.gameValueManager.formatEffectValue(gameValueConfig.getValue(), valueUnits));
/* 182 */             if (gameValueConfig.isOverwrite()) {
/* 183 */               i.setCharAt(0, '=');
/*     */             }
/*     */           } 
/*     */           Label label;
/* 187 */           (label = new Label((CharSequence)i, Game.i.assetManager.getLabelStyle(24))).setPosition(460.0F, 0.0F);
/* 188 */           label.setSize(100.0F, 52.0F);
/* 189 */           label.setAlignment(16);
/* 190 */           group.addActor((Actor)label);
/*     */           
/* 192 */           this.e.add((Actor)group).size(600.0F, 52.0F).padBottom(4.0F).row();
/*     */         } 
/*     */       } else {
/*     */         Label label;
/* 196 */         (label = new Label(Game.i.localeManager.i18n.get("tile_has_no_effects"), Game.i.assetManager.getLabelStyle(24))).setAlignment(1);
/* 197 */         this.e.add((Actor)label).size(600.0F, 52.0F).padBottom(4.0F).row();
/*     */       } 
/*     */       
/*     */       BossTile.BossWavesConfig bossWavesConfig;
/*     */       
/* 202 */       if ((bossWavesConfig = bossTile.getBossWavesConfig()).bossWavePairs.size > 0) {
/*     */         Group group;
/* 204 */         (group = new Group()).setTransform(false);
/* 205 */         this.e.add((Actor)group).size(600.0F, 16.0F).padTop(16.0F).padBottom(16.0F).row();
/*     */         
/*     */         Label label;
/* 208 */         (label = new Label(Game.i.localeManager.i18n.get("enemy_name_BOSS").toUpperCase(), Game.i.assetManager.getLabelStyle(21))).setSize(100.0F, 16.0F);
/* 209 */         label.setPosition(40.0F, 0.0F);
/* 210 */         label.setColor(1.0F, 1.0F, 1.0F, 0.28F);
/* 211 */         group.addActor((Actor)label);
/*     */ 
/*     */         
/* 214 */         (label = new Label(Game.i.localeManager.i18n.get("main_ui_wave_title").toUpperCase(), Game.i.assetManager.getLabelStyle(21))).setSize(100.0F, 16.0F);
/* 215 */         label.setPosition(460.0F, 0.0F);
/* 216 */         label.setAlignment(16);
/* 217 */         label.setColor(1.0F, 1.0F, 1.0F, 0.28F);
/* 218 */         group.addActor((Actor)label);
/*     */         
/* 220 */         for (byte b = 0; b < bossWavesConfig.bossWavePairs.size; b++) {
/* 221 */           BossTile.BossTypeWavePair bossTypeWavePair = ((BossTile.BossTypeWavePair[])bossWavesConfig.bossWavePairs.items)[b];
/*     */           
/*     */           Group group1;
/* 224 */           (group1 = new Group()).setTransform(false);
/*     */           
/*     */           Image image2;
/* 227 */           (image2 = new Image((Drawable)Game.i.assetManager.getDrawable("blank"))).setSize(600.0F, 52.0F);
/* 228 */           image2.setColor(b);
/* 229 */           group1.addActor((Actor)image2);
/*     */           
/* 231 */           EnemyType enemyType = Game.i.enemyManager.getBossEnemyType(bossTypeWavePair.bossType);
/*     */           Image image1;
/* 233 */           (image1 = new Image(this.g.enemy.getTexture(enemyType))).setSize(64.0F, 64.0F);
/* 234 */           image1.setPosition(30.0F, -6.0F);
/* 235 */           group1.addActor((Actor)image1);
/*     */           
/*     */           Label label2;
/* 238 */           (label2 = new Label(Game.i.enemyManager.getFactory(enemyType).getTitle(), Game.i.assetManager.getLabelStyle(21))).setSize(64.0F, 52.0F);
/* 239 */           label2.setPosition(112.0F, 0.0F);
/* 240 */           group1.addActor((Actor)label2);
/*     */           
/*     */           int i;
/* 243 */           String str = String.valueOf(i = bossTypeWavePair.wave + bossWavesConfig.startDelay);
/* 244 */           if (bossWavesConfig.repeatCount <= 0) {
/* 245 */             str = str + ", " + (i + bossWavesConfig.cycleLength) + "...";
/*     */           }
/*     */           Label label1;
/* 248 */           (label1 = new Label(str, Game.i.assetManager.getLabelStyle(24))).setSize(100.0F, 52.0F);
/* 249 */           label1.setPosition(460.0F, 0.0F);
/* 250 */           label1.setAlignment(16);
/* 251 */           group1.addActor((Actor)label1);
/*     */           
/* 253 */           this.e.add((Actor)group1).size(600.0F, 52.0F).padBottom(4.0F).row();
/*     */         } 
/*     */       } 
/*     */       
/* 257 */       this.e.add().expandX().fillX().height(40.0F).row();
/* 258 */       this.e.add().expand().fill();
/*     */     } 
/*     */   }
/*     */   
/*     */   private class _SideMenuListener
/*     */     extends SideMenu.SideMenuListener.SideMenuListenerAdapter {
/*     */     public void offscreenChanged() {
/* 265 */       BossTileMenu.a(this.a);
/*     */     }
/*     */     
/*     */     private _SideMenuListener(BossTileMenu this$0) {}
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi\\ui\components\BossTileMenu.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */