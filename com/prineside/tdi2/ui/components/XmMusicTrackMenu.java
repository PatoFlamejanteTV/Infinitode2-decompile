/*     */ package com.prineside.tdi2.ui.components;
/*     */ 
/*     */ import com.badlogic.gdx.Gdx;
/*     */ import com.badlogic.gdx.graphics.Color;
/*     */ import com.badlogic.gdx.utils.Array;
/*     */ import com.badlogic.gdx.utils.Disposable;
/*     */ import com.badlogic.gdx.utils.Null;
/*     */ import com.prineside.tdi2.Game;
/*     */ import com.prineside.tdi2.GameSystemProvider;
/*     */ import com.prineside.tdi2.Tile;
/*     */ import com.prineside.tdi2.enums.TileType;
/*     */ import com.prineside.tdi2.events.game.MapElementSelect;
/*     */ import com.prineside.tdi2.ibxm.Module;
/*     */ import com.prineside.tdi2.scene2d.Actor;
/*     */ import com.prineside.tdi2.scene2d.EventListener;
/*     */ import com.prineside.tdi2.scene2d.InputEvent;
/*     */ import com.prineside.tdi2.scene2d.InputListener;
/*     */ import com.prineside.tdi2.scene2d.Touchable;
/*     */ import com.prineside.tdi2.scene2d.ui.Image;
/*     */ import com.prineside.tdi2.scene2d.ui.Table;
/*     */ import com.prineside.tdi2.scene2d.utils.ClickListener;
/*     */ import com.prineside.tdi2.scene2d.utils.Drawable;
/*     */ import com.prineside.tdi2.tiles.XmMusicTrackTile;
/*     */ import com.prineside.tdi2.ui.actors.Label;
/*     */ import com.prineside.tdi2.ui.actors.LimitedWidthLabel;
/*     */ import com.prineside.tdi2.ui.actors.SideMenu;
/*     */ import com.prineside.tdi2.utils.MaterialColor;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class XmMusicTrackMenu
/*     */   implements Disposable
/*     */ {
/*     */   private final SideMenu.SideMenuContainer a;
/*     */   private boolean b;
/*     */   private Table c;
/*     */   private GameSystemProvider d;
/*  42 */   private final _SideMenuListener e = new _SideMenuListener((byte)0);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public XmMusicTrackMenu(SideMenu paramSideMenu, GameSystemProvider paramGameSystemProvider) {
/*  49 */     this.d = paramGameSystemProvider;
/*     */ 
/*     */     
/*  52 */     this.a = paramSideMenu.createContainer("XmMusicTrackMenu");
/*     */     
/*  54 */     int i = Game.i.settingsManager.getScaledViewportHeight() - 1080;
/*     */     
/*     */     Label label;
/*     */     
/*  58 */     (label = new Label(Game.i.localeManager.i18n.get("tile_name_XM_MUSIC_TRACK").toUpperCase(), Game.i.assetManager.getLabelStyle(36))).setSize(460.0F, 26.0F);
/*  59 */     label.setPosition(40.0F, 994.0F + i);
/*  60 */     this.a.addActor((Actor)label);
/*     */ 
/*     */ 
/*     */     
/*  64 */     (label = new Label(Game.i.localeManager.i18n.get("tile_description_XM_MUSIC_TRACK"), Game.i.assetManager.getLabelStyle(24))).setSize(420.0F, 100.0F);
/*  65 */     label.setPosition(40.0F, 884.0F + i);
/*  66 */     label.setAlignment(10);
/*  67 */     label.setWrap(true);
/*  68 */     this.a.addActor((Actor)label);
/*     */     
/*  70 */     this.c = new Table();
/*  71 */     this.c.setSize(600.0F, (i + 950));
/*  72 */     this.c.setTouchable(Touchable.childrenOnly);
/*  73 */     this.a.addActor((Actor)this.c);
/*     */     
/*  75 */     paramSideMenu.addListener((SideMenu.SideMenuListener)this.e);
/*     */     
/*  77 */     paramGameSystemProvider.events.getListeners(MapElementSelect.class).add(paramMapElementSelect -> {
/*     */           Tile tile;
/*     */           
/*     */           if ((tile = paramGameSystemProvider._gameMapSelection.getSelectedTile()) != null && tile.type == TileType.XM_MUSIC_TRACK) {
/*     */             a();
/*     */             a(true);
/*     */             return;
/*     */           } 
/*     */           a(false);
/*     */         });
/*  87 */     this.a.hide();
/*     */   }
/*     */   
/*     */   private void a(boolean paramBoolean) {
/*  91 */     if (this.b != paramBoolean) {
/*  92 */       this.b = paramBoolean;
/*  93 */       if (paramBoolean) {
/*  94 */         this.a.show();
/*     */         return;
/*     */       } 
/*  97 */       this.a.hide();
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   private void a() {
/* 103 */     Tile tile = this.d._gameMapSelection.getSelectedTile();
/* 104 */     this.c.clear();
/* 105 */     if (tile != null && tile.type == TileType.XM_MUSIC_TRACK) {
/* 106 */       this.a.setLabelOverTitleTilePos(tile);
/* 107 */       XmMusicTrackTile xmMusicTrackTile = (XmMusicTrackTile)tile;
/*     */ 
/*     */       
/* 110 */       Table table1 = new Table();
/* 111 */       this.c.add((Actor)table1).width(600.0F).height(32.0F).row();
/*     */       
/* 113 */       Color[] arrayOfColor1 = xmMusicTrackTile.getIdColors();
/* 114 */       float f = 600.0F / arrayOfColor1.length; Color[] arrayOfColor2; int i; byte b;
/* 115 */       for (i = (arrayOfColor2 = arrayOfColor1).length, b = 0; b < i; ) { Color color = arrayOfColor2[b];
/*     */         Image image1;
/* 117 */         (image1 = new Image((Drawable)Game.i.assetManager.getDrawable("blank"))).setColor(color);
/* 118 */         table1.add((Actor)image1).size(f, 8.0F);
/*     */         b++; }
/*     */       
/* 121 */       table1.row();
/*     */       
/*     */       Image image;
/* 124 */       (image = new Image((Drawable)Game.i.assetManager.getDrawable("blank"))).setColor(0.0F, 0.0F, 0.0F, 0.14F);
/* 125 */       table1.add((Actor)image).colspan(arrayOfColor1.length).width(600.0F).height(4.0F);
/*     */ 
/*     */       
/* 128 */       Table table2 = new Table();
/* 129 */       this.c.add((Actor)table2).width(520.0F).row();
/*     */       
/*     */       String str;
/* 132 */       if ((str = xmMusicTrackTile.getTitleCached()) != null) {
/*     */         Label label;
/* 134 */         (label = new Label(str, Game.i.assetManager.getLabelStyle(30))).setColor(MaterialColor.AMBER.P500);
/* 135 */         table2.add((Actor)label).growX().padTop(15.0F).row();
/*     */         
/*     */         Array array;
/* 138 */         for (Array.ArrayIterator<Module.TrackInfoEntry> arrayIterator = (array = xmMusicTrackTile.getDescriptionCached()).iterator(); arrayIterator.hasNext(); ) { Label label1; Module.TrackInfoEntry trackInfoEntry = arrayIterator.next();
/* 139 */           LimitedWidthLabel limitedWidthLabel = new LimitedWidthLabel(trackInfoEntry.value, 24, 18, 540.0F);
/* 140 */           switch (null.a[trackInfoEntry.type.ordinal()]) {
/*     */             
/*     */             case 1:
/* 143 */               (label1 = new Label(Game.i.localeManager.i18n.get("music_track_author") + ":", Game.i.assetManager.getLabelStyle(18))).setColor(1.0F, 1.0F, 1.0F, 0.56F);
/* 144 */               table2.add((Actor)label1).growX().padTop(15.0F).row();
/*     */               break;
/*     */ 
/*     */             
/*     */             case 2:
/* 149 */               (label1 = new Label(Game.i.localeManager.i18n.get("music_track_group") + ":", Game.i.assetManager.getLabelStyle(18))).setColor(1.0F, 1.0F, 1.0F, 0.56F);
/* 150 */               table2.add((Actor)label1).growX().padTop(15.0F).row();
/*     */               break;
/*     */             
/*     */             case 3:
/* 154 */               limitedWidthLabel.setTouchable(Touchable.enabled);
/* 155 */               limitedWidthLabel.addListener((EventListener)new ClickListener(this, (Module.TrackInfoEntry)label1)
/*     */                   {
/*     */                     public void clicked(InputEvent param1InputEvent, float param1Float1, float param1Float2) {
/* 158 */                       Gdx.net.openURI(this.a.getCompleteLink());
/*     */                     }
/*     */                   });
/* 161 */               limitedWidthLabel.addListener((EventListener)new InputListener(this, limitedWidthLabel)
/*     */                   {
/*     */                     public void enter(InputEvent param1InputEvent, float param1Float1, float param1Float2, int param1Int, @Null Actor param1Actor) {
/* 164 */                       this.a.setColor(MaterialColor.LIGHT_BLUE.P300);
/*     */                     }
/*     */                     
/*     */                     public void exit(InputEvent param1InputEvent, float param1Float1, float param1Float2, int param1Int, @Null Actor param1Actor) {
/* 168 */                       this.a.setColor(MaterialColor.LIGHT_BLUE.P500);
/*     */                     }
/*     */                   });
/* 171 */               limitedWidthLabel.setText(limitedWidthLabel.getText() + Game.i.assetManager.replaceRegionAliasesWithChars("<@icon-link-out>").toString());
/* 172 */               limitedWidthLabel.setColor(MaterialColor.LIGHT_BLUE.P500);
/*     */               break;
/*     */           } 
/* 175 */           limitedWidthLabel.setAlignment(8);
/* 176 */           table2.add((Actor)limitedWidthLabel).growX().row(); }
/*     */       
/*     */       } 
/*     */     } 
/* 180 */     this.c.row();
/* 181 */     this.c.add().width(1.0F).growY().row();
/*     */   }
/*     */ 
/*     */   
/*     */   public void dispose() {}
/*     */   
/*     */   private class _SideMenuListener
/*     */     extends SideMenu.SideMenuListener.SideMenuListenerAdapter
/*     */   {
/*     */     private _SideMenuListener(XmMusicTrackMenu this$0) {}
/*     */     
/*     */     public void offscreenChanged() {
/* 193 */       XmMusicTrackMenu.a(this.a);
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi\\ui\components\XmMusicTrackMenu.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */