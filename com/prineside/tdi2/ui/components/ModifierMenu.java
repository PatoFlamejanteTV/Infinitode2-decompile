/*     */ package com.prineside.tdi2.ui.components;
/*     */ import com.badlogic.gdx.InputAdapter;
/*     */ import com.badlogic.gdx.graphics.Color;
/*     */ import com.badlogic.gdx.graphics.g2d.BitmapFont;
/*     */ import com.badlogic.gdx.graphics.g2d.GlyphLayout;
/*     */ import com.badlogic.gdx.math.MathUtils;
/*     */ import com.badlogic.gdx.math.Vector2;
/*     */ import com.badlogic.gdx.utils.ObjectMap;
/*     */ import com.prineside.tdi2.Game;
/*     */ import com.prineside.tdi2.GameSystemProvider;
/*     */ import com.prineside.tdi2.GameValueProvider;
/*     */ import com.prineside.tdi2.Modifier;
/*     */ import com.prineside.tdi2.Tile;
/*     */ import com.prineside.tdi2.enums.BuildingType;
/*     */ import com.prineside.tdi2.enums.TileType;
/*     */ import com.prineside.tdi2.events.game.BuildingRemove;
/*     */ import com.prineside.tdi2.events.game.MapElementSelect;
/*     */ import com.prineside.tdi2.events.game.ModifierCustomButtonPress;
/*     */ import com.prineside.tdi2.events.game.ModifierPlace;
/*     */ import com.prineside.tdi2.scene2d.Actor;
/*     */ import com.prineside.tdi2.scene2d.Group;
/*     */ import com.prineside.tdi2.scene2d.utils.Drawable;
/*     */ import com.prineside.tdi2.tiles.PlatformTile;
/*     */ import com.prineside.tdi2.ui.actors.ComplexButton;
/*     */ import com.prineside.tdi2.ui.actors.Label;
/*     */ import com.prineside.tdi2.ui.actors.QuadActor;
/*     */ import com.prineside.tdi2.ui.actors.SideMenu;
/*     */ import com.prineside.tdi2.utils.MaterialColor;
/*     */ import com.prineside.tdi2.utils.QuadDrawable;
/*     */ import com.prineside.tdi2.utils.StringFormatter;
/*     */ import com.prineside.tdi2.utils.logging.TLog;
/*     */ 
/*     */ public class ModifierMenu implements Disposable {
/*  34 */   private static final TLog a = TLog.forClass(ModifierMenu.class);
/*     */   
/*     */   private final SideMenu.SideMenuContainer b;
/*     */   
/*     */   private boolean c;
/*     */   
/*     */   private final Label d;
/*     */   
/*     */   private final Label e;
/*     */   
/*     */   private final Group f;
/*     */   
/*  46 */   private ObjectMap<String, Object> g = new ObjectMap();
/*     */   
/*     */   private final SellButton h;
/*     */   private ComplexButton i;
/*     */   private InputAdapter j;
/*     */   private Label k;
/*  52 */   private int l = -1;
/*     */   
/*     */   private boolean m;
/*     */   
/*     */   private final GameSystemProvider n;
/*  57 */   private final _SideMenuListener o = new _SideMenuListener((byte)0);
/*     */   
/*  59 */   private static final Vector2 p = new Vector2(); private final Runnable q = () -> {
/*     */       c();
/*     */       a(true);
/*     */     }; private final Runnable r = () -> updateCustomButton();
/*     */   
/*     */   public ModifierMenu(SideMenu paramSideMenu, GameSystemProvider paramGameSystemProvider) {
/*  65 */     this.n = paramGameSystemProvider;
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  70 */     this.b = paramSideMenu.createContainer("ModifierMenu");
/*  71 */     this.b.setName("modifier_menu_container");
/*     */     
/*  73 */     int i = Game.i.settingsManager.getScaledViewportHeight() - 1080;
/*     */ 
/*     */     
/*  76 */     this.d = new Label("", new Label.LabelStyle((BitmapFont)Game.i.assetManager.getFont(36), Color.WHITE));
/*  77 */     this.d.setSize(520.0F, 26.0F);
/*  78 */     this.d.setPosition(40.0F, 994.0F + i);
/*  79 */     this.b.addActor((Actor)this.d);
/*     */     
/*  81 */     this.e = new Label("", new Label.LabelStyle((BitmapFont)Game.i.assetManager.getFont(24), Color.WHITE));
/*  82 */     this.e.setSize(520.0F, 100.0F);
/*  83 */     this.e.setPosition(40.0F, 884.0F + i);
/*  84 */     this.e.setAlignment(10);
/*  85 */     this.e.setWrap(true);
/*  86 */     this.b.addActor((Actor)this.e);
/*     */ 
/*     */     
/*  89 */     this.f = new Group();
/*  90 */     this.f.setTransform(false);
/*  91 */     this.f.setSize(600.0F, 400.0F);
/*  92 */     this.f.setPosition(0.0F, 160.0F);
/*  93 */     this.b.addActor((Actor)this.f);
/*     */ 
/*     */     
/*  96 */     this.i = new ComplexButton("", Game.i.assetManager.getLabelStyle(30), () -> {
/*     */           if (this.m) {
/*     */             cancelUsingCustomButton();
/*     */             return;
/*     */           } 
/*     */           Modifier modifier;
/*     */           if ((modifier = b()) != null && modifier.hasCustomButton()) {
/*     */             if (modifier.isCustomButtonNeedMapPoint()) {
/*     */               startUsingCustomButton();
/*     */               return;
/*     */             } 
/*     */             paramGameSystemProvider.modifier.customModifierButtonAction(modifier, 0, 0);
/*     */             updateCustomButton();
/*     */           } 
/*     */         });
/* 111 */     this.i.setLabel(80.0F, 20.0F, 200.0F, 40.0F, 8);
/* 112 */     this.i.label.setWrap(true);
/* 113 */     this.i.icon.setSize(40.0F, 40.0F);
/* 114 */     this.i.icon.setPosition(20.0F, 20.0F);
/* 115 */     this.i.setPosition(40.0F, 40.0F);
/* 116 */     this.i.setSize(309.0F, 80.0F);
/* 117 */     this.i.setBackground((Drawable)new QuadDrawable(new QuadActor(Color.WHITE, new float[] { 0.0F, 0.0F, 0.0F, 80.0F, 309.0F, 80.0F, 283.0F, 0.0F })), 0.0F, 0.0F, 309.0F, 80.0F);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 126 */     this.b.addActor((Actor)this.i);
/*     */ 
/*     */     
/* 129 */     this.k = new Label("", Game.i.assetManager.getLabelStyle(21));
/* 130 */     this.k.setSize(192.0F, 16.0F);
/* 131 */     this.k.setPosition(368.0F, 132.0F);
/* 132 */     this.k.setAlignment(16);
/* 133 */     this.k.setColor(MaterialColor.RED.P500);
/* 134 */     this.k.setVisible(false);
/* 135 */     this.b.addActor((Actor)this.k);
/*     */     
/* 137 */     this.h = new SellButton(() -> {
/*     */           Modifier modifier;
/*     */           if ((modifier = b()) != null) {
/*     */             paramGameSystemProvider.modifier.sellModifierAction(modifier);
/*     */           }
/*     */         });
/* 143 */     this.h.setPosition(368.0F, 40.0F);
/* 144 */     this.b.addActor((Actor)this.h);
/*     */     
/* 146 */     this.j = new InputAdapter(this, paramGameSystemProvider)
/*     */       {
/*     */         public boolean touchUp(int param1Int1, int param1Int2, int param1Int3, int param1Int4) {
/* 149 */           if (this.a._input == null) return false;
/*     */           
/*     */           Modifier modifier;
/* 152 */           if ((modifier = ModifierMenu.a(this.b)) != null && ModifierMenu.b(this.b)) {
/* 153 */             ModifierMenu.a().set(param1Int1, param1Int2);
/* 154 */             this.a._input.getCameraController().screenToMap(ModifierMenu.a());
/* 155 */             if (ModifierMenu.b(this.b)) {
/* 156 */               this.a.modifier.customModifierButtonAction(ModifierMenu.a(this.b), (int)(ModifierMenu.a()).x, (int)(ModifierMenu.a()).y);
/* 157 */               this.b.updateCustomButton();
/*     */             } 
/*     */           } 
/*     */           
/* 161 */           this.b.cancelUsingCustomButton();
/* 162 */           return false;
/*     */         }
/*     */       };
/*     */     
/* 166 */     paramSideMenu.addListener((SideMenu.SideMenuListener)this.o);
/*     */     
/* 168 */     paramGameSystemProvider.events.getListeners(MapElementSelect.class).add(paramMapElementSelect -> {
/*     */           Tile tile;
/*     */           if ((tile = paramGameSystemProvider._gameMapSelection.getSelectedTile()) != null && tile.type == TileType.PLATFORM && ((PlatformTile)tile).building != null && ((PlatformTile)tile).building.buildingType == BuildingType.MODIFIER) {
/*     */             c();
/*     */             a(true);
/*     */             return;
/*     */           } 
/*     */           a(false);
/* 176 */         }).setDescription("ModifierMenu - shows or hides itself if tile is selected");
/*     */     
/* 178 */     paramGameSystemProvider.events.getListeners(ModifierPlace.class).add(paramModifierPlace -> {
/*     */           if (paramModifierPlace.getModifier().getTile() == paramGameSystemProvider._gameMapSelection.getSelectedTile()) {
/*     */             Game.i.uiManager.runOnStageActOnce(this.q);
/*     */           }
/*     */         });
/* 183 */     paramGameSystemProvider.events.getListeners(BuildingRemove.class).add(paramBuildingRemove -> {
/*     */           if ((paramBuildingRemove.getBuilding()).buildingType == BuildingType.MODIFIER && paramBuildingRemove.getOldTile() == paramGameSystemProvider._gameMapSelection.getSelectedTile()) {
/*     */             a(false);
/*     */           }
/*     */         });
/* 188 */     paramGameSystemProvider.events.getListeners(ModifierCustomButtonPress.class).add(paramModifierCustomButtonPress -> Game.i.uiManager.runOnStageActOnce(this.r));
/*     */   }
/*     */   
/*     */   public void startUsingCustomButton() {
/* 192 */     if (this.m) {
/* 193 */       a.e("been using custom button, canceling", new Object[0]);
/* 194 */       cancelUsingCustomButton();
/*     */     } 
/*     */     
/* 197 */     this.m = true;
/* 198 */     this.n._input.setupInputMultiplexer(true, true, false).addProcessor((InputProcessor)this.j);
/* 199 */     updateCustomButton();
/*     */   }
/*     */   
/*     */   public void updateCustomButton() {
/* 203 */     Modifier modifier = b();
/*     */     
/* 205 */     this.i.setVisible(false);
/* 206 */     if (modifier != null && 
/* 207 */       modifier.hasCustomButton()) {
/*     */       
/* 209 */       this.i.setVisible(true);
/* 210 */       modifier.updateCustomButton(this.i, this.m);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void cancelUsingCustomButton() {
/* 219 */     this.n._input.enableAllInput();
/* 220 */     this.m = false;
/* 221 */     updateCustomButton();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private Modifier b() {
/*     */     Tile tile;
/* 229 */     if ((tile = this.n._gameMapSelection.getSelectedTile()) != null && tile.type == TileType.PLATFORM) {
/*     */       PlatformTile platformTile;
/*     */       
/* 232 */       if ((platformTile = (PlatformTile)tile).building != null && platformTile.building.buildingType == BuildingType.MODIFIER)
/* 233 */         return (Modifier)platformTile.building; 
/* 234 */       return null;
/*     */     } 
/* 236 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isVisible() {
/* 241 */     return this.c;
/*     */   }
/*     */   
/*     */   public void draw(float paramFloat) {
/* 245 */     if (!this.c) {
/*     */       return;
/*     */     }
/*     */     Modifier modifier;
/* 249 */     if ((modifier = b()) != null) {
/* 250 */       modifier.fillModifierMenu(this.f, this.g);
/*     */ 
/*     */       
/* 253 */       int i = MathUtils.ceil(modifier.getTimeTillSellAvailable());
/*     */ 
/*     */       
/*     */       int j;
/*     */       
/* 258 */       if ((j = (j = 31 + (modifier.isSellAvailable() ? 1 : 0)) * 31 + i) != this.l) {
/* 259 */         this.l = j;
/*     */         
/* 261 */         j = modifier.getSellPrice();
/* 262 */         if (modifier.isSellAvailable()) {
/* 263 */           this.h.setPrice(j);
/* 264 */           this.h.setColors(MaterialColor.RED.P800, MaterialColor.RED.P900, MaterialColor.RED.P700);
/* 265 */           this.k.setVisible(false); return;
/*     */         } 
/* 267 */         j = (int)(j * 0.75F);
/* 268 */         this.h.setPrice(j);
/* 269 */         this.h.setColors(MaterialColor.GREY.P800, MaterialColor.GREY.P900, MaterialColor.GREY.P700);
/* 270 */         this.k.setText((CharSequence)StringFormatter.digestTime(i));
/* 271 */         this.k.setVisible(true);
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   private void c() {
/* 278 */     this.l = -1;
/* 279 */     this.g.clear();
/* 280 */     this.f.clearChildren();
/*     */     
/*     */     Tile tile;
/* 283 */     if ((tile = this.n._gameMapSelection.getSelectedTile()) != null && tile.type == TileType.PLATFORM && ((PlatformTile)tile).building != null && ((PlatformTile)tile).building.buildingType == BuildingType.MODIFIER) {
/* 284 */       this.b.setLabelOverTitleTilePos(tile);
/*     */       
/*     */       PlatformTile platformTile;
/* 287 */       Modifier modifier = (Modifier)(platformTile = (PlatformTile)tile).building;
/*     */       
/* 289 */       this.d.setText(Game.i.modifierManager.getFactory(modifier.type).getTitle());
/*     */ 
/*     */       
/* 292 */       CharSequence charSequence = Game.i.modifierManager.getFactory(modifier.type).getDescription((GameValueProvider)this.n.gameValue);
/*     */       GlyphLayout glyphLayout;
/* 294 */       if ((glyphLayout = new GlyphLayout((BitmapFont)Game.i.assetManager.getFont(24), charSequence, Color.WHITE, this.e.getWidth(), 8, true)).height > 150.0F) {
/* 295 */         this.e.setStyle(new Label.LabelStyle((BitmapFont)Game.i.assetManager.getFont(21), Color.WHITE));
/*     */       } else {
/* 297 */         this.e.setStyle(new Label.LabelStyle((BitmapFont)Game.i.assetManager.getFont(24), Color.WHITE));
/*     */       } 
/* 299 */       this.e.setText(charSequence);
/*     */     } 
/*     */     
/* 302 */     updateCustomButton();
/*     */   }
/*     */   
/*     */   private void a(boolean paramBoolean) {
/* 306 */     if (this.c != paramBoolean) {
/* 307 */       this.c = paramBoolean;
/* 308 */       if (paramBoolean) {
/* 309 */         this.b.show();
/* 310 */         c(); return;
/*     */       } 
/* 312 */       this.g.clear();
/* 313 */       this.b.hide();
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void dispose() {}
/*     */ 
/*     */   
/*     */   private class _SideMenuListener
/*     */     extends SideMenu.SideMenuListener.SideMenuListenerAdapter
/*     */   {
/*     */     private _SideMenuListener(ModifierMenu this$0) {}
/*     */     
/*     */     public void offscreenChanged() {
/* 327 */       ModifierMenu.c(this.a);
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi\\ui\components\ModifierMenu.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */