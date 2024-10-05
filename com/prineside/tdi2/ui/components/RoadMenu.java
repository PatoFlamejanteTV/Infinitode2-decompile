/*     */ package com.prineside.tdi2.ui.components;
/*     */ 
/*     */ import com.badlogic.gdx.utils.Disposable;
/*     */ import com.prineside.tdi2.Game;
/*     */ import com.prineside.tdi2.GameSystemProvider;
/*     */ import com.prineside.tdi2.Tile;
/*     */ import com.prineside.tdi2.enums.TileType;
/*     */ import com.prineside.tdi2.events.game.MapElementSelect;
/*     */ import com.prineside.tdi2.scene2d.Actor;
/*     */ import com.prineside.tdi2.scene2d.Group;
/*     */ import com.prineside.tdi2.scene2d.Touchable;
/*     */ import com.prineside.tdi2.ui.actors.Label;
/*     */ import com.prineside.tdi2.ui.actors.SideMenu;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class RoadMenu
/*     */   implements Disposable
/*     */ {
/*     */   private final SideMenu.SideMenuContainer a;
/*     */   private boolean b;
/*     */   private Group c;
/*     */   private GameSystemProvider d;
/*  30 */   private final _SideMenuListener e = new _SideMenuListener((byte)0);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public RoadMenu(SideMenu paramSideMenu, GameSystemProvider paramGameSystemProvider) {
/*  37 */     this.d = paramGameSystemProvider;
/*     */ 
/*     */     
/*  40 */     this.a = paramSideMenu.createContainer("RoadMenu");
/*     */     
/*  42 */     int i = Game.i.settingsManager.getScaledViewportHeight() - 1080;
/*     */     
/*     */     Label label;
/*     */     
/*  46 */     (label = new Label(Game.i.localeManager.i18n.get("tile_name_ROAD").toUpperCase(), Game.i.assetManager.getLabelStyle(36))).setSize(460.0F, 26.0F);
/*  47 */     label.setPosition(40.0F, 994.0F + i);
/*  48 */     this.a.addActor((Actor)label);
/*     */ 
/*     */ 
/*     */     
/*  52 */     (label = new Label(Game.i.localeManager.i18n.get("tile_description_ROAD"), Game.i.assetManager.getLabelStyle(24))).setSize(420.0F, 100.0F);
/*  53 */     label.setPosition(40.0F, 884.0F + i);
/*  54 */     label.setAlignment(10);
/*  55 */     label.setWrap(true);
/*  56 */     this.a.addActor((Actor)label);
/*     */     
/*  58 */     this.c = new Group();
/*  59 */     this.c.setTransform(false);
/*  60 */     this.c.setSize(600.0F, 1080.0F);
/*  61 */     this.c.setTouchable(Touchable.disabled);
/*  62 */     this.a.addActor((Actor)this.c);
/*     */     
/*  64 */     paramSideMenu.addListener((SideMenu.SideMenuListener)this.e);
/*  65 */     paramGameSystemProvider.events.getListeners(MapElementSelect.class).add(paramMapElementSelect -> {
/*     */           Tile tile;
/*     */           if ((tile = paramGameSystemProvider._gameMapSelection.getSelectedTile()) != null && tile.type == TileType.ROAD) {
/*     */             a();
/*     */             a(true);
/*     */             return;
/*     */           } 
/*     */           a(false);
/*  73 */         }).setDescription("RoadMenu - shows or hides itself if road tile is selected");
/*     */     
/*  75 */     this.a.hide();
/*     */   }
/*     */   
/*     */   private void a(boolean paramBoolean) {
/*  79 */     if (this.b != paramBoolean) {
/*  80 */       this.b = paramBoolean;
/*  81 */       if (paramBoolean) {
/*  82 */         this.a.show();
/*     */         return;
/*     */       } 
/*  85 */       this.a.hide();
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   private void a() {
/*  91 */     Tile tile = this.d._gameMapSelection.getSelectedTile();
/*     */     
/*  93 */     this.c.clear();
/*  94 */     if (tile != null && tile.type == TileType.ROAD) {
/*  95 */       this.a.setLabelOverTitleTilePos(tile);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void dispose() {}
/*     */ 
/*     */ 
/*     */   
/*     */   private class _SideMenuListener
/*     */     extends SideMenu.SideMenuListener.SideMenuListenerAdapter
/*     */   {
/*     */     private _SideMenuListener(RoadMenu this$0) {}
/*     */ 
/*     */     
/*     */     public void offscreenChanged() {
/* 112 */       RoadMenu.a(this.a);
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi\\ui\components\RoadMenu.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */