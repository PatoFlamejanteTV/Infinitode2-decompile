/*     */ package com.prineside.tdi2.ui.components;
/*     */ 
/*     */ import com.badlogic.gdx.utils.StringBuilder;
/*     */ import com.prineside.tdi2.Game;
/*     */ import com.prineside.tdi2.GameSystemProvider;
/*     */ import com.prineside.tdi2.Tile;
/*     */ import com.prineside.tdi2.enums.GameValueType;
/*     */ import com.prineside.tdi2.enums.TileType;
/*     */ import com.prineside.tdi2.events.game.MapElementSelect;
/*     */ import com.prineside.tdi2.managers.GameValueManager;
/*     */ import com.prineside.tdi2.scene2d.Actor;
/*     */ import com.prineside.tdi2.scene2d.EventListener;
/*     */ import com.prineside.tdi2.scene2d.InputEvent;
/*     */ import com.prineside.tdi2.scene2d.ui.Image;
/*     */ import com.prineside.tdi2.scene2d.utils.ClickListener;
/*     */ import com.prineside.tdi2.scene2d.utils.Drawable;
/*     */ import com.prineside.tdi2.tiles.GameValueTile;
/*     */ import com.prineside.tdi2.ui.actors.Label;
/*     */ import com.prineside.tdi2.ui.actors.LimitedWidthLabel;
/*     */ import com.prineside.tdi2.ui.actors.SideMenu;
/*     */ import com.prineside.tdi2.ui.shared.Dialog;
/*     */ import com.prineside.tdi2.utils.MaterialColor;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class GameValueMenu
/*     */ {
/*     */   private final SideMenu a;
/*     */   private final SideMenu.SideMenuContainer b;
/*     */   private LimitedWidthLabel c;
/*     */   private Label d;
/*     */   private Label e;
/*     */   private Label f;
/*     */   private GameSystemProvider g;
/*  36 */   private final _SideMenuListener h = new _SideMenuListener((byte)0);
/*     */ 
/*     */ 
/*     */   
/*     */   public GameValueMenu(SideMenu paramSideMenu, GameSystemProvider paramGameSystemProvider) {
/*  41 */     this.g = paramGameSystemProvider;
/*     */     
/*  43 */     this.a = paramSideMenu;
/*     */ 
/*     */     
/*  46 */     this.b = paramSideMenu.createContainer("GameValueMenu");
/*     */     
/*  48 */     int i = Game.i.settingsManager.getScaledViewportHeight() - 1080;
/*     */     
/*     */     Label label;
/*     */     
/*  52 */     (label = new Label(Game.i.localeManager.i18n.get("tile_name_GAME_VALUE").toUpperCase(), Game.i.assetManager.getLabelStyle(36))).setSize(460.0F, 26.0F);
/*  53 */     label.setPosition(40.0F, 994.0F + i);
/*  54 */     this.b.addActor((Actor)label);
/*     */ 
/*     */ 
/*     */     
/*  58 */     (label = new Label(Game.i.localeManager.i18n.get("tile_description_GAME_VALUE"), Game.i.assetManager.getLabelStyle(24))).setSize(420.0F, 100.0F);
/*  59 */     label.setPosition(40.0F, 884.0F + i);
/*  60 */     label.setAlignment(10);
/*  61 */     label.setWrap(true);
/*  62 */     this.b.addActor((Actor)label);
/*     */     
/*     */     Image image;
/*     */     
/*  66 */     (image = new Image((Drawable)Game.i.assetManager.getDrawable("blank"))).setSize(600.0F, 52.0F);
/*  67 */     image.setColor(0.0F, 0.0F, 0.0F, 0.28F);
/*  68 */     image.setPosition(0.0F, 872.0F + i);
/*  69 */     this.b.addActor((Actor)image);
/*     */     
/*  71 */     this.c = new LimitedWidthLabel("", 24, 21, 440.0F);
/*  72 */     this.c.setPosition(40.0F, 872.0F + i);
/*  73 */     this.c.setSize(100.0F, 52.0F);
/*  74 */     this.b.addActor((Actor)this.c);
/*     */     
/*  76 */     this.d = new Label("", Game.i.assetManager.getLabelStyle(24));
/*  77 */     this.d.setPosition(0.0F, 872.0F + i);
/*  78 */     this.d.setAlignment(16);
/*  79 */     this.d.setSize(560.0F, 52.0F);
/*  80 */     this.b.addActor((Actor)this.d);
/*     */     
/*  82 */     this.e = new Label(Game.i.localeManager.i18n.get("overwrites_other_effects"), Game.i.assetManager.getLabelStyle(21));
/*  83 */     this.e.setPosition(40.0F, 816.0F + i);
/*  84 */     this.e.setAlignment(8);
/*  85 */     this.e.setSize(560.0F, 52.0F);
/*  86 */     this.e.setColor(MaterialColor.ORANGE.P500);
/*  87 */     this.b.addActor((Actor)this.e);
/*     */     
/*  89 */     this.f = new Label(Game.i.localeManager.i18n.get("gv_tile_final_multiplier"), Game.i.assetManager.getLabelStyle(21));
/*  90 */     this.f.setPosition(40.0F, 816.0F + i);
/*  91 */     this.f.setAlignment(8);
/*  92 */     this.f.setSize(560.0F, 52.0F);
/*  93 */     this.f.setColor(MaterialColor.ORANGE.P500);
/*  94 */     this.b.addActor((Actor)this.f);
/*     */     
/*  96 */     paramSideMenu.addListener((SideMenu.SideMenuListener)this.h);
/*     */     
/*  98 */     paramGameSystemProvider.events.getListeners(MapElementSelect.class).add(paramMapElementSelect -> {
/*     */           Tile tile;
/*     */           
/*     */           if ((tile = paramGameSystemProvider._gameMapSelection.getSelectedTile()) != null && tile.type == TileType.GAME_VALUE && ((GameValueTile)tile).getGameValueType() != GameValueType.DUMMY) {
/*     */             a();
/*     */             a(true);
/*     */             return;
/*     */           } 
/*     */           a(false);
/*     */         });
/* 108 */     this.b.hide();
/*     */   }
/*     */   
/*     */   private void a(boolean paramBoolean) {
/* 112 */     if (paramBoolean) {
/* 113 */       this.b.show();
/* 114 */       a(); return;
/*     */     } 
/* 116 */     this.b.hide();
/* 117 */     this.a.hideSideTooltip();
/*     */   }
/*     */ 
/*     */   
/*     */   private void a() {
/*     */     Tile tile;
/* 123 */     if ((tile = this.g._gameMapSelection.getSelectedTile()) != null && tile.type == TileType.GAME_VALUE) {
/* 124 */       StringBuilder stringBuilder; this.b.setLabelOverTitleTilePos(tile);
/*     */       
/* 126 */       GameValueTile gameValueTile = (GameValueTile)tile;
/*     */       
/* 128 */       this.c.setText((CharSequence)Game.i.gameValueManager.getTitle(gameValueTile.getGameValueType()));
/* 129 */       this.d.clearListeners();
/*     */       
/* 131 */       if (gameValueTile.isFinalMultiplier()) {
/* 132 */         this.f.setVisible(true);
/* 133 */         this.e.setVisible(false);
/*     */ 
/*     */         
/* 136 */         if (gameValueTile.getDelta() == 0.0D) {
/* 137 */           this.d.setText(Game.i.localeManager.i18n.get("gv_bonus_disabled"));
/* 138 */           this.d.addListener((EventListener)new ClickListener(this)
/*     */               {
/*     */                 public void clicked(InputEvent param1InputEvent, float param1Float1, float param1Float2) {
/* 141 */                   Dialog.i().showAlert(Game.i.localeManager.i18n.get("gv_bonus_disabled_explanation"));
/*     */                 }
/*     */               });
/*     */           return;
/*     */         } 
/* 146 */         (stringBuilder = Game.i.gameValueManager.formatEffectValue(gameValueTile.getDelta(), GameValueManager.ValueUnits.UNITS)).setCharAt(0, 'x');
/*     */       
/*     */       }
/*     */       else {
/*     */         
/* 151 */         this.f.setVisible(false);
/* 152 */         this.e.setVisible(gameValueTile.isOverwrite());
/* 153 */         stringBuilder = Game.i.gameValueManager.formatEffectValue(gameValueTile.getDelta(), Game.i.gameValueManager.getUnits(gameValueTile.getGameValueType()));
/* 154 */         if (gameValueTile.isOverwrite())
/* 155 */           stringBuilder.setCharAt(0, '='); 
/*     */       } 
/* 157 */       this.d.setText((CharSequence)stringBuilder);
/*     */     } 
/*     */   }
/*     */   
/*     */   private class _SideMenuListener extends SideMenu.SideMenuListener.SideMenuListenerAdapter {
/*     */     private _SideMenuListener(GameValueMenu this$0) {}
/*     */     
/*     */     public void offscreenChanged() {
/* 165 */       GameValueMenu.a(this.a);
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi\\ui\components\GameValueMenu.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */