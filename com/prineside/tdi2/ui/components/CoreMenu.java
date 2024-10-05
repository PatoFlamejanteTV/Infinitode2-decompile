/*     */ package com.prineside.tdi2.ui.components;
/*     */ 
/*     */ import com.badlogic.gdx.Gdx;
/*     */ import com.badlogic.gdx.graphics.Color;
/*     */ import com.badlogic.gdx.graphics.g2d.BitmapFont;
/*     */ import com.badlogic.gdx.graphics.g2d.ParticleEffect;
/*     */ import com.badlogic.gdx.graphics.g2d.ParticleEmitter;
/*     */ import com.badlogic.gdx.math.Rectangle;
/*     */ import com.prineside.tdi2.Game;
/*     */ import com.prineside.tdi2.GameSystemProvider;
/*     */ import com.prineside.tdi2.Tile;
/*     */ import com.prineside.tdi2.enums.GameValueType;
/*     */ import com.prineside.tdi2.enums.StaticSoundType;
/*     */ import com.prineside.tdi2.enums.TileType;
/*     */ import com.prineside.tdi2.events.game.CoreTileLevelUp;
/*     */ import com.prineside.tdi2.events.game.CoreTileUpgradeInstall;
/*     */ import com.prineside.tdi2.events.game.MapElementSelect;
/*     */ import com.prineside.tdi2.managers.GameValueManager;
/*     */ import com.prineside.tdi2.managers.SettingsManager;
/*     */ import com.prineside.tdi2.scene2d.Actor;
/*     */ import com.prineside.tdi2.scene2d.EventListener;
/*     */ import com.prineside.tdi2.scene2d.Group;
/*     */ import com.prineside.tdi2.scene2d.InputEvent;
/*     */ import com.prineside.tdi2.scene2d.ui.Image;
/*     */ import com.prineside.tdi2.scene2d.ui.Table;
/*     */ import com.prineside.tdi2.scene2d.utils.ClickListener;
/*     */ import com.prineside.tdi2.scene2d.utils.Drawable;
/*     */ import com.prineside.tdi2.tiles.CoreTile;
/*     */ import com.prineside.tdi2.ui.actors.ExpLine;
/*     */ import com.prineside.tdi2.ui.actors.Label;
/*     */ import com.prineside.tdi2.ui.actors.ParticlesCanvas;
/*     */ import com.prineside.tdi2.ui.actors.QuadActor;
/*     */ import com.prineside.tdi2.ui.actors.SideMenu;
/*     */ import com.prineside.tdi2.utils.MaterialColor;
/*     */ import com.prineside.tdi2.utils.Quad;
/*     */ import com.prineside.tdi2.utils.QuadRegion;
/*     */ import com.prineside.tdi2.utils.StringFormatter;
/*     */ 
/*     */ 
/*     */ public class CoreMenu
/*     */ {
/*  42 */   private static final Rectangle a = new Rectangle(40.0F, 954.0F, 520.0F, 66.0F);
/*     */   
/*     */   private final SideMenu b;
/*     */   
/*     */   private final SideMenu.SideMenuContainer c;
/*     */   
/*     */   private boolean d;
/*     */   private QuadActor e;
/*     */   private Table f;
/*     */   private Group g;
/*     */   private Label h;
/*     */   private Label i;
/*     */   private Label j;
/*     */   private Label k;
/*     */   private Label l;
/*     */   private Label m;
/*     */   private Label n;
/*     */   private Group o;
/*     */   private ParticlesCanvas p;
/*     */   private ParticleEffect q;
/*     */   private ExpLine r;
/*  63 */   private int s = -1;
/*  64 */   private int t = -1;
/*     */   
/*  66 */   private int u = -1;
/*     */ 
/*     */   
/*     */   private GameSystemProvider v;
/*     */   
/*  71 */   private final _SideMenuListener w = new _SideMenuListener((byte)0);
/*     */   
/*  73 */   private static final StringBuilder x = new StringBuilder();
/*  74 */   private static final Color y = new Color();
/*  75 */   private static final Color z = new Color();
/*     */ 
/*     */   
/*  78 */   private final Runnable A = this::b;
/*     */   
/*     */   public CoreMenu(SideMenu paramSideMenu, GameSystemProvider paramGameSystemProvider) {
/*  81 */     this.v = paramGameSystemProvider;
/*     */     
/*  83 */     this.b = paramSideMenu;
/*     */ 
/*     */     
/*  86 */     this.c = paramSideMenu.createContainer("CoreMenu");
/*     */     
/*  88 */     int i = Game.i.settingsManager.getScaledViewportHeight() - 1080;
/*     */ 
/*     */     
/*  91 */     this.e = new QuadActor(new float[] { 0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F, 1.0F, 0.0F }, Color.WHITE);
/*     */ 
/*     */     
/*  94 */     this.e.setSize(600.0F, 156.0F);
/*  95 */     this.e.setPosition(0.0F, 924.0F + i);
/*  96 */     this.c.addActor((Actor)this.e);
/*     */ 
/*     */     
/*  99 */     this.f = new Table();
/* 100 */     this.f.setPosition(40.0F, 994.0F + i);
/* 101 */     this.f.setSize(520.0F, 26.0F);
/* 102 */     this.c.addActor((Actor)this.f);
/*     */ 
/*     */     
/* 105 */     this.g = new Group();
/* 106 */     this.g.setName("core_menu_experience");
/* 107 */     this.g.setTransform(false);
/* 108 */     this.g.setPosition(a.x, a.y + i);
/* 109 */     this.g.setSize(a.width, a.height);
/* 110 */     this.g.setOrigin(a.width / 2.0F, a.height / 2.0F);
/* 111 */     this.c.addActor((Actor)this.g);
/*     */     
/* 113 */     this.k = new Label("", new Label.LabelStyle((BitmapFont)Game.i.assetManager.getFont(21), Color.WHITE));
/* 114 */     this.k.setColor(0.0F, 0.0F, 0.0F, 0.28F);
/* 115 */     this.k.setSize(159.0F, 24.0F);
/* 116 */     this.k.setPosition(50.0F, 954.0F + i - 2.0F);
/* 117 */     this.k.setAlignment(8);
/* 118 */     this.c.addActor((Actor)this.k);
/*     */     
/* 120 */     this.j = new Label("", new Label.LabelStyle((BitmapFont)Game.i.assetManager.getFont(21), Color.WHITE));
/* 121 */     this.j.setColor(Color.WHITE);
/* 122 */     this.j.setSize(159.0F, 24.0F);
/* 123 */     this.j.setPosition(48.0F, 954.0F + i);
/* 124 */     this.j.setAlignment(8);
/* 125 */     this.c.addActor((Actor)this.j);
/*     */ 
/*     */     
/* 128 */     this.h = new Label("L10", new Label.LabelStyle((BitmapFont)Game.i.assetManager.getFont(36), Color.WHITE));
/* 129 */     this.h.setSize(40.0F, 26.0F);
/* 130 */     this.h.setPosition(480.0F, 40.0F);
/* 131 */     this.h.setAlignment(16);
/* 132 */     this.g.addActor((Actor)this.h);
/*     */     
/* 134 */     this.r = new ExpLine();
/* 135 */     this.r.setPosition(0.0F, 0.0F);
/* 136 */     this.g.addActor((Actor)this.r);
/*     */ 
/*     */     
/* 139 */     this.i = new Label("53 / 90 XP", new Label.LabelStyle((BitmapFont)Game.i.assetManager.getFont(24), Color.WHITE));
/* 140 */     this.i.setColor(1.0F, 1.0F, 1.0F, 0.56F);
/* 141 */     this.i.setPosition(0.0F, 0.0F);
/* 142 */     this.i.setSize(520.0F, 24.0F);
/* 143 */     this.i.setAlignment(16);
/* 144 */     this.g.addActor((Actor)this.i);
/*     */     
/*     */     Image image;
/*     */     
/* 148 */     (image = new Image((Drawable)Game.i.assetManager.getDrawable("blank"))).setSize(600.0F, 52.0F);
/* 149 */     image.setColor(0.0F, 0.0F, 0.0F, 0.28F);
/* 150 */     image.setPosition(0.0F, 872.0F + i);
/* 151 */     this.c.addActor((Actor)image);
/*     */     
/*     */     Label label;
/* 154 */     (label = new Label(Game.i.localeManager.i18n.get("tower_stat_EXPERIENCE_GENERATION"), Game.i.assetManager.getLabelStyle(24))).setPosition(40.0F, 872.0F + i);
/* 155 */     label.setSize(100.0F, 52.0F);
/* 156 */     this.c.addActor((Actor)label);
/*     */ 
/*     */     
/* 159 */     (label = new Label("/s", Game.i.assetManager.getLabelStyle(24))).setPosition(0.0F, 872.0F + i);
/* 160 */     label.setColor(1.0F, 1.0F, 1.0F, 0.56F);
/* 161 */     label.setAlignment(16);
/* 162 */     label.setSize(560.0F, 52.0F);
/* 163 */     this.c.addActor((Actor)label);
/*     */     
/* 165 */     this.l = new Label("2.5", Game.i.assetManager.getLabelStyle(30));
/* 166 */     this.l.setPosition(0.0F, 872.0F + i);
/* 167 */     this.l.setAlignment(16);
/* 168 */     this.l.setSize(528.0F, 52.0F);
/* 169 */     this.c.addActor((Actor)this.l);
/*     */ 
/*     */     
/* 172 */     this.o = new Group();
/* 173 */     this.o.setTransform(false);
/* 174 */     this.o.setPosition(0.0F, 0.0F);
/* 175 */     this.o.setSize(600.0F, Game.i.settingsManager.getScaledViewportHeight() - 200.0F);
/* 176 */     this.c.addActor((Actor)this.o);
/*     */ 
/*     */     
/* 179 */     this.n = new Label("", Game.i.assetManager.getLabelStyle(60));
/* 180 */     this.n.setPosition(0.0F, 142.0F);
/* 181 */     this.n.setSize(600.0F, 44.0F);
/* 182 */     this.n.setAlignment(1);
/* 183 */     this.c.addActor((Actor)this.n);
/*     */     
/* 185 */     this.m = new Label(Game.i.localeManager.i18n.get("upgrade_points").toUpperCase(), Game.i.assetManager.getLabelStyle(24));
/* 186 */     this.m.setPosition(0.0F, 104.0F);
/* 187 */     this.m.setSize(600.0F, 20.0F);
/* 188 */     this.m.setAlignment(1);
/* 189 */     this.c.addActor((Actor)this.m);
/*     */     
/* 191 */     this.q = new ParticleEffect();
/* 192 */     this.q.load(Gdx.files.internal("particles/core-menu-upgrade-points-highlight.prt"), Game.i.assetManager.getTextureRegion("particle-triangle").getAtlas());
/* 193 */     this.q.setEmittersCleanUpBlendFunction(false);
/*     */     
/* 195 */     this.p = new ParticlesCanvas();
/* 196 */     this.p.setSize(600.0F, 64.0F);
/* 197 */     this.p.setPosition(0.0F, 132.0F);
/* 198 */     this.c.addActor((Actor)this.p);
/* 199 */     this.p.addParticle(this.q, 300.0F, 32.0F);
/* 200 */     this.p.setVisible(false);
/*     */     
/* 202 */     paramSideMenu.addListener((SideMenu.SideMenuListener)this.w);
/*     */     
/* 204 */     paramGameSystemProvider.events.getListeners(CoreTileLevelUp.class).add(paramCoreTileLevelUp -> {
/*     */           if (this.d && paramGameSystemProvider._gameMapSelection.getSelectedTile() == paramCoreTileLevelUp.getCoreTile() && this.u != a()) {
/*     */             Game.i.uiManager.runOnStageActOnce(this.A);
/*     */           }
/*     */         });
/*     */ 
/*     */ 
/*     */     
/* 212 */     paramGameSystemProvider.events.getListeners(CoreTileUpgradeInstall.class).add(paramCoreTileUpgradeInstall -> {
/*     */           if (this.d && paramGameSystemProvider._gameMapSelection.getSelectedTile() == paramCoreTileUpgradeInstall.getCoreTile()) {
/*     */             Game.i.uiManager.runOnStageActOnce(this.A);
/*     */           }
/*     */         });
/*     */     
/* 218 */     paramGameSystemProvider.events.getListeners(MapElementSelect.class).add(paramMapElementSelect -> {
/*     */           Tile tile;
/*     */           
/*     */           if ((tile = paramGameSystemProvider._gameMapSelection.getSelectedTile()) != null && tile.type == TileType.CORE) {
/*     */             if (this.u != a()) {
/*     */               this.s = -1;
/*     */               this.t = -1;
/*     */               b();
/*     */             } 
/*     */             a(true);
/*     */             return;
/*     */           } 
/*     */           a(false);
/*     */         });
/* 232 */     this.c.hide();
/*     */   }
/*     */   
/*     */   private void a(boolean paramBoolean) {
/* 236 */     if (this.d != paramBoolean) {
/* 237 */       this.d = paramBoolean;
/* 238 */       if (paramBoolean) {
/* 239 */         this.c.show();
/*     */         
/* 241 */         b();
/*     */ 
/*     */         
/* 244 */         if (Game.i.settingsManager.getCustomValue(SettingsManager.CustomValueType.CORE_HINT_SHOWN) == 0.0D) {
/*     */           Tile tile;
/*     */           
/* 247 */           if ((tile = this.v._gameMapSelection.getSelectedTile()) != null && tile.type == TileType.CORE) {
/*     */             CoreTile coreTile;
/*     */             Group group;
/* 250 */             (group = (coreTile = (CoreTile)tile).generateUiIcon(96.0F)).setOrigin(48.0F, 48.0F);
/*     */             
/* 252 */             this.v._gameUi.uiElementsEmphasizer.show((Actor)group, new Rectangle(-48.0F, -48.0F, 96.0F, 96.0F), Game.i.localeManager.i18n
/* 253 */                 .get("tile_name_CORE"), Game.i.localeManager.i18n
/* 254 */                 .get("tile_description_CORE"), null);
/*     */ 
/*     */             
/* 257 */             Game.i.settingsManager.setCustomValue(SettingsManager.CustomValueType.CORE_HINT_SHOWN, 1.0D);
/*     */           }  return;
/*     */         } 
/*     */       } else {
/* 261 */         this.c.hide();
/* 262 */         this.s = -1;
/* 263 */         this.t = -1;
/* 264 */         this.b.hideSideTooltip();
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   private int a() {
/* 270 */     int i = 1;
/*     */     
/*     */     Tile tile;
/* 273 */     if ((tile = this.v._gameMapSelection.getSelectedTile()) != null && tile.type == TileType.CORE) {
/*     */       CoreTile coreTile;
/*     */       
/* 276 */       int j = (coreTile = (CoreTile)tile).getUpgradeCols();
/* 277 */       int k = coreTile.getUpgradeRows();
/* 278 */       int m = coreTile.getFreeUpgradePoints();
/* 279 */       i = m + 31;
/* 280 */       int n = this.v.gameState.getMoney();
/*     */       
/* 282 */       for (byte b = 0; b < k; b++) {
/* 283 */         for (byte b1 = 0; b1 < j; b1++) {
/*     */           CoreTile.Upgrade upgrade;
/* 285 */           if ((upgrade = coreTile.getUpgrade(b1, b)) == null) {
/* 286 */             i = i * 31 - 131;
/*     */           
/*     */           }
/*     */           else {
/*     */             
/* 291 */             i = (i = i * 31 + (upgrade.isAction ? 1 : -1)) * 31 + (upgrade.isAction ? upgrade.getActionType().ordinal() : upgrade.getGameValueType().ordinal());
/*     */             int i1;
/* 293 */             if ((i1 = coreTile.getUpgradeInstallLevel(b1, b)) < upgrade.upgradeLevels.size) {
/* 294 */               CoreTile.Upgrade.UpgradeLevel upgradeLevel = ((CoreTile.Upgrade.UpgradeLevel[])upgrade.upgradeLevels.items)[i1];
/* 295 */               if (upgrade.costsCoins) {
/* 296 */                 i = i * 31 + ((upgradeLevel.price <= n) ? 1 : 0);
/*     */               } else {
/* 298 */                 i = i * 31 + ((upgradeLevel.price <= m) ? 1 : 0);
/*     */               } 
/*     */             } 
/*     */           } 
/*     */         } 
/*     */       } 
/*     */     } 
/* 305 */     return i;
/*     */   }
/*     */   
/*     */   private void b() {
/*     */     Tile tile;
/* 310 */     if ((tile = this.v._gameMapSelection.getSelectedTile()) != null && tile.type == TileType.CORE) {
/* 311 */       this.c.setLabelOverTitleTilePos(tile);
/*     */       
/* 313 */       CoreTile coreTile = (CoreTile)tile;
/* 314 */       y.set(Game.i.tileManager.F.CORE.getTierColor(coreTile.getTier()));
/* 315 */       z.set(y);
/* 316 */       y.a = 0.0F;
/* 317 */       z.a = 0.07F;
/* 318 */       this.e.setVertexColors(z, y, y, z);
/*     */       
/* 320 */       this.f.clearChildren();
/*     */       
/*     */       Label label;
/* 323 */       (label = new Label(coreTile.getName(), Game.i.assetManager.getLabelStyle(36))).setColor(Game.i.tileManager.F.CORE.getTierColor(coreTile.getTier()));
/* 324 */       this.f.add((Actor)label).height(26.0F).bottom().left().padRight(16.0F);
/*     */       
/* 326 */       (label = new Label(Game.i.tileManager.F.CORE.getTierDescription(coreTile.getTier()).toString().toUpperCase(), Game.i.assetManager.getLabelStyle(21))).setColor(1.0F, 1.0F, 1.0F, 0.56F);
/* 327 */       this.f.add((Actor)label).expandX().fillX().bottom().left();
/*     */       
/* 329 */       c();
/*     */ 
/*     */       
/* 332 */       y.a = 1.0F;
/* 333 */       this.l.setColor(y);
/* 334 */       this.l.setText((CharSequence)StringFormatter.compactNumber((coreTile.getExperienceGeneration() * (float)this.v.gameValue.getPercentValueAsMultiplier(GameValueType.CORES_LEVEL_UP_SPEED)), true));
/*     */ 
/*     */       
/* 337 */       int i = coreTile.getUpgradeCols();
/* 338 */       int j = coreTile.getUpgradeRows();
/* 339 */       int k = coreTile.getFreeUpgradePoints();
/*     */       
/* 341 */       this.o.clearChildren();
/* 342 */       float f1 = i * 128.0F;
/* 343 */       f1 = (600.0F - f1) / 2.0F;
/* 344 */       float f2 = Game.i.settingsManager.getScaledViewportHeight() - 356.0F; byte b;
/* 345 */       for (b = 0; b < j; b++) {
/* 346 */         for (byte b1 = 0; b1 < i; b1++) {
/*     */           CoreTile.Upgrade upgrade;
/* 348 */           if ((upgrade = coreTile.getUpgrade(b1, b)) != null) {
/*     */             Group group;
/*     */             
/* 351 */             (group = new Group()).setTransform(false);
/* 352 */             group.setPosition(f1 + b1 * 128.0F, f2 - b * 128.0F);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */             
/* 358 */             int m = b1;
/* 359 */             byte b2 = b;
/* 360 */             group.addListener((EventListener)new ClickListener(this, m, b2, coreTile, upgrade)
/*     */                 {
/*     */                   public void clicked(InputEvent param1InputEvent, float param1Float1, float param1Float2) {
/* 363 */                     if (CoreMenu.a(this.e) == this.a && CoreMenu.b(this.e) == this.b) {
/*     */                       
/* 365 */                       int i = (CoreMenu.c(this.e)).gameState.getMoney();
/*     */                       int j;
/* 367 */                       if ((j = this.c.getUpgradeInstallLevel(this.a, this.b)) < this.d.upgradeLevels.size)
/*     */                       {
/* 369 */                         CoreTile.Upgrade.UpgradeLevel upgradeLevel = ((CoreTile.Upgrade.UpgradeLevel[])this.d.upgradeLevels.items)[j];
/* 370 */                         i = this.d.costsCoins ? ((upgradeLevel.price <= i) ? 1 : 0) : ((upgradeLevel.price <= this.c.getFreeUpgradePoints()) ? 1 : 0);
/*     */                         
/* 372 */                         if (this.c.canUpgradeBeInstalled(this.a, this.b) && i != 0) {
/* 373 */                           (CoreMenu.c(this.e)).map.upgradeCoreActionAt(this.c.getX(), this.c.getY(), CoreMenu.a(this.e), CoreMenu.b(this.e));
/*     */                         }
/*     */                       }
/*     */                     
/*     */                     }
/*     */                     else {
/*     */                       
/* 380 */                       CoreMenu.a(this.e, this.a);
/* 381 */                       CoreMenu.b(this.e, this.b);
/*     */                     } 
/* 383 */                     CoreMenu.d(this.e);
/*     */                     
/* 385 */                     (CoreMenu.c(this.e))._sound.playStatic(StaticSoundType.BUTTON);
/*     */                   }
/*     */                 });
/* 388 */             this.o.addActor((Actor)group);
/*     */             
/* 390 */             if (coreTile.getUpgradeInstallLevel(b1, b) >= upgrade.upgradeLevels.size) {
/*     */               
/* 392 */               if (upgrade.isAction) {
/*     */                 Group group1;
/* 394 */                 (group1 = Game.i.triggeredActionManager.generateIcon(upgrade.getActionType(), 64.0F, y)).setPosition(32.0F, 32.0F);
/* 395 */                 group.addActor((Actor)group1);
/*     */               } else {
/* 397 */                 Quad quad = Game.i.gameValueManager.getStockValueConfig(upgrade.getGameValueType()).createIconForBackground(new Color(724249599));
/*     */                 Image image;
/* 399 */                 (image = new Image((Drawable)quad)).setPosition(32.0F, 32.0F);
/* 400 */                 image.setSize(64.0F, 64.0F);
/* 401 */                 group.addActor((Actor)image);
/*     */               } 
/*     */             } else {
/*     */               String str;
/* 405 */               Color color = new Color();
/* 406 */               boolean bool = coreTile.canUpgradeBeInstalled(b1, b);
/* 407 */               int i1 = this.v.gameState.getMoney();
/* 408 */               m = coreTile.getUpgradeInstallLevel(m, b2);
/*     */               
/* 410 */               CoreTile.Upgrade.UpgradeLevel upgradeLevel = ((CoreTile.Upgrade.UpgradeLevel[])upgrade.upgradeLevels.items)[m];
/*     */               
/* 412 */               m = upgrade.costsCoins ? ((upgradeLevel.price <= i1) ? 1 : 0) : ((upgradeLevel.price <= k) ? 1 : 0);
/* 413 */               if (bool && m != 0) {
/*     */                 Image image;
/*     */                 
/* 416 */                 (image = new Image((Drawable)Game.i.assetManager.getDrawable("ui-core-menu-upgrade-button"))).setSize(100.0F, 100.0F);
/* 417 */                 image.setPosition(16.0F, 12.0F);
/* 418 */                 image.setColor(y);
/* 419 */                 color.set(y).mul(0.7F, 0.7F, 0.7F, 1.0F);
/* 420 */                 group.addActor((Actor)image);
/*     */                 
/* 422 */                 if (upgrade.isAction) {
/*     */                   Group group1;
/* 424 */                   (group1 = Game.i.triggeredActionManager.generateIcon(upgrade.getActionType(), 64.0F, Color.WHITE)).setPosition(32.0F, 32.0F);
/* 425 */                   group.addActor((Actor)group1);
/*     */                 } else {
/* 427 */                   Quad quad = Game.i.gameValueManager.getStockValueConfig(upgrade.getGameValueType()).createIconForBackground(color);
/* 428 */                   for (byte b4 = 0; b4 < (quad.getRegions()).size; b4++) {
/* 429 */                     QuadRegion quadRegion = (QuadRegion)quad.getRegions().get(b4);
/* 430 */                     if (!"shadow".equals(quadRegion.getQuadName()) && (
/* 431 */                       !quadRegion.isSingleColor() || !quadRegion.getCornerColors().get(0).toString().startsWith("000000")))
/*     */                     {
/*     */                       
/* 434 */                       quadRegion.setSameCornerColors(Color.WHITE);
/*     */                     }
/*     */                   } 
/*     */                   
/*     */                   Image image1;
/* 439 */                   (image1 = new Image((Drawable)quad)).setPosition(32.0F, 32.0F);
/* 440 */                   image1.setSize(64.0F, 64.0F);
/* 441 */                   group.addActor((Actor)image1);
/*     */                 } 
/*     */               } else {
/*     */                 Image image;
/*     */                 
/* 446 */                 (image = new Image((Drawable)Game.i.assetManager.getDrawable("blank"))).setSize(96.0F, 96.0F);
/* 447 */                 image.setPosition(16.0F, 16.0F);
/* 448 */                 image.setColor(0.0F, 0.0F, 0.0F, 0.28F);
/* 449 */                 color.set(MaterialColor.GREY.P900);
/* 450 */                 group.addActor((Actor)image);
/*     */                 
/* 452 */                 if (upgrade.isAction) {
/*     */                   Group group1;
/* 454 */                   (group1 = Game.i.triggeredActionManager.generateIcon(upgrade.getActionType(), 64.0F, new Color(0.56F, 0.56F, 0.56F, 1.0F))).setPosition(32.0F, 32.0F);
/* 455 */                   group.addActor((Actor)group1);
/*     */                 } else {
/* 457 */                   Quad quad = new Quad(Game.i.gameValueManager.getStockValueConfig(upgrade.getGameValueType()).createIconForBackground(new Color(522133503)), true);
/*     */                   Image image1;
/* 459 */                   (image1 = new Image((Drawable)quad)).setColor(1.0F, 1.0F, 1.0F, 0.56F);
/* 460 */                   image1.setPosition(32.0F, 32.0F);
/* 461 */                   image1.setSize(64.0F, 64.0F);
/* 462 */                   group.addActor((Actor)image1);
/*     */                 } 
/*     */               } 
/*     */ 
/*     */               
/* 467 */               float f = 103.0F;
/* 468 */               if (upgrade.costsCoins) {
/* 469 */                 f = 95.0F;
/*     */               }
/*     */ 
/*     */               
/* 473 */               if (upgradeLevel.price < 100000) {
/* 474 */                 str = String.valueOf(upgradeLevel.price);
/*     */               } else {
/* 476 */                 str = StringFormatter.compactNumber(upgradeLevel.price, false).toString();
/*     */               } 
/*     */               Label label1;
/* 479 */               (label1 = new Label(str, Game.i.assetManager.getLabelStyle(24))).setColor(color);
/* 480 */               label1.setPosition(f - 2.0F, 25.0F);
/* 481 */               label1.setSize(1.0F, 18.0F);
/* 482 */               label1.setAlignment(16);
/* 483 */               group.addActor((Actor)label1);
/*     */ 
/*     */               
/* 486 */               (label1 = new Label(str, Game.i.assetManager.getLabelStyle(24))).setColor(color);
/* 487 */               label1.setPosition(f, 25.0F);
/* 488 */               label1.setSize(1.0F, 18.0F);
/* 489 */               label1.setAlignment(16);
/* 490 */               group.addActor((Actor)label1);
/*     */               
/*     */               Label label2;
/* 493 */               (label2 = new Label(str, Game.i.assetManager.getLabelStyle(24))).setPosition(f, 23.0F);
/* 494 */               label2.setSize(1.0F, 18.0F);
/* 495 */               label2.setAlignment(16);
/* 496 */               if (!bool || m == 0) {
/* 497 */                 label2.setColor(y);
/*     */               }
/* 499 */               group.addActor((Actor)label2);
/*     */               
/* 501 */               if (upgrade.costsCoins) {
/*     */                 Image image;
/* 503 */                 (image = new Image((Drawable)Game.i.assetManager.getDrawable("icon-coin"))).setPosition(f + 3.0F, 20.0F);
/* 504 */                 image.setSize(24.0F, 24.0F);
/* 505 */                 image.setColor(MaterialColor.YELLOW.P500);
/* 506 */                 group.addActor((Actor)image);
/*     */                 
/* 508 */                 label2.setColor(MaterialColor.YELLOW.P500);
/*     */               } 
/*     */             } 
/*     */ 
/*     */             
/* 513 */             if (upgrade.upgradeLevels.size > 1) {
/*     */               
/* 515 */               int i1 = coreTile.getUpgradeInstallLevel(b1, b);
/*     */               
/* 517 */               for (byte b4 = 0; b4 < upgrade.upgradeLevels.size; b4++) {
/*     */                 Image image;
/* 519 */                 (image = new Image((Drawable)Game.i.assetManager.getDrawable("icon-triangle-top-hollow"))).setSize(24.0F, 24.0F);
/* 520 */                 image.setPosition(15.0F, 12.0F + b4 * 11.0F);
/* 521 */                 if (i1 > b4) {
/* 522 */                   image.setColor(Color.WHITE);
/*     */                 } else {
/* 524 */                   image.setColor(0.0F, 0.0F, 0.0F, 0.56F);
/*     */                 } 
/* 526 */                 group.addActor((Actor)image);
/*     */               } 
/*     */             }  CoreTile.LinkDirection[] arrayOfLinkDirection;
/*     */             int n;
/*     */             byte b3;
/* 531 */             for (n = (arrayOfLinkDirection = CoreTile.LinkDirection.values).length, b3 = 0; b3 < n; ) { CoreTile.LinkDirection linkDirection = arrayOfLinkDirection[b3];
/* 532 */               if (upgrade.hasLink(linkDirection)) {
/*     */                 Image image;
/* 534 */                 (image = new Image()).setSize(32.0F, 32.0F);
/*     */                 
/* 536 */                 switch (null.a[linkDirection.ordinal()]) { case 1:
/* 537 */                     image.setPosition(48.0F, 112.0F); image.setDrawable((Drawable)Game.i.assetManager.getDrawable("tiny-arrow-top")); break;
/* 538 */                   case 2: image.setPosition(48.0F, -16.0F); image.setDrawable((Drawable)Game.i.assetManager.getDrawable("tiny-arrow-bottom")); break;
/* 539 */                   case 3: image.setPosition(-16.0F, 48.0F); image.setDrawable((Drawable)Game.i.assetManager.getDrawable("tiny-arrow-left")); break;
/* 540 */                   case 4: image.setPosition(112.0F, 48.0F); image.setDrawable((Drawable)Game.i.assetManager.getDrawable("tiny-arrow-right")); break;
/* 541 */                   case 5: image.setPosition(-16.0F, 112.0F); image.setDrawable((Drawable)Game.i.assetManager.getDrawable("tiny-arrow-top-left")); break;
/* 542 */                   case 6: image.setPosition(112.0F, 112.0F); image.setDrawable((Drawable)Game.i.assetManager.getDrawable("tiny-arrow-top-right")); break;
/* 543 */                   case 7: image.setPosition(-16.0F, -16.0F); image.setDrawable((Drawable)Game.i.assetManager.getDrawable("tiny-arrow-bottom-left")); break;
/* 544 */                   case 8: image.setPosition(112.0F, -16.0F); image.setDrawable((Drawable)Game.i.assetManager.getDrawable("tiny-arrow-bottom-right"));
/*     */                     break; }
/*     */                 
/* 547 */                 if (coreTile.getUpgradeInstallLevel(b1, b) > 0) {
/* 548 */                   image.setColor(y);
/*     */                 } else {
/* 550 */                   image.setColor(0.0F, 0.0F, 0.0F, 0.28F);
/*     */                 } 
/*     */                 
/* 553 */                 group.addActor((Actor)image);
/*     */               } 
/*     */               b3++; }
/*     */             
/* 557 */             if (b1 == this.s && b == this.t) {
/*     */               Image image;
/*     */               
/* 560 */               (image = new Image((Drawable)Game.i.assetManager.getDrawable("ui-core-menu-upgrade-selection"))).setSize(110.0F, 110.0F);
/* 561 */               image.setPosition(9.0F, 9.0F);
/* 562 */               group.addActor((Actor)image);
/*     */             } 
/*     */           } 
/*     */         } 
/*     */       } 
/*     */       
/* 568 */       if (this.c.isVisible()) {
/* 569 */         if (this.s >= 0 && this.s < i && this.t >= 0 && this.t < j) {
/*     */           CoreTile.Upgrade upgrade;
/* 571 */           if ((upgrade = coreTile.getUpgrade(this.s, this.t)) != null) {
/*     */             int m;
/*     */             
/* 574 */             if ((m = coreTile.getUpgradeInstallLevel(this.s, this.t)) < upgrade.upgradeLevels.size) {
/*     */               
/* 576 */               CoreTile.Upgrade.UpgradeLevel upgradeLevel = ((CoreTile.Upgrade.UpgradeLevel[])upgrade.upgradeLevels.items)[m];
/*     */               
/* 578 */               if (upgrade.isAction) {
/*     */                 
/* 580 */                 x.setLength(0);
/* 581 */                 String str1 = Game.i.triggeredActionManager.getTitleAlias(upgrade.getActionType());
/* 582 */                 String str2 = "[#" + y + "]" + StringFormatter.compactNumberWithPrecisionTrimZeros(upgradeLevel.delta, 2, true) + "[]";
/* 583 */                 x.append(Game.i.localeManager.i18n.format(str1, new Object[] { str2 }));
/*     */               } else {
/*     */                 
/* 586 */                 x.setLength(0);
/*     */                 GameValueManager.GameValueStockConfig gameValueStockConfig;
/* 588 */                 if ((gameValueStockConfig = Game.i.gameValueManager.getStockValueConfig(upgrade.getGameValueType())).units == GameValueManager.ValueUnits.BOOLEAN) {
/*     */                   
/* 590 */                   if (m != 0) {
/*     */                     CoreTile.Upgrade.UpgradeLevel upgradeLevel1;
/*     */                     
/* 593 */                     if ((upgradeLevel1 = ((CoreTile.Upgrade.UpgradeLevel[])upgrade.upgradeLevels.items)[m - 1]).delta <= 0.0F) {
/* 594 */                       x.append((CharSequence)Game.i.gameValueManager.getDisabledTitle(upgrade.getGameValueType()));
/*     */                     } else {
/* 596 */                       x.append((CharSequence)Game.i.gameValueManager.getTitle(upgrade.getGameValueType()));
/*     */                     } 
/* 598 */                     x.append("\n");
/*     */                     
/* 600 */                     x.append(" >> [#");
/* 601 */                     x.append(y);
/* 602 */                     x.append("]");
/*     */                     
/* 604 */                     if (upgradeLevel1.delta + upgradeLevel.delta <= 0.0F) {
/* 605 */                       x.append((CharSequence)Game.i.gameValueManager.getDisabledTitle(upgrade.getGameValueType()));
/*     */                     } else {
/* 607 */                       x.append((CharSequence)Game.i.gameValueManager.getTitle(upgrade.getGameValueType()));
/*     */                     } 
/*     */                   } else {
/*     */                     
/* 611 */                     x.append(" [#");
/* 612 */                     x.append(y);
/* 613 */                     x.append("]");
/* 614 */                     if (upgradeLevel.delta <= 0.0F) {
/* 615 */                       x.append((CharSequence)Game.i.gameValueManager.getDisabledTitle(upgrade.getGameValueType()));
/*     */                     } else {
/* 617 */                       x.append((CharSequence)Game.i.gameValueManager.getTitle(upgrade.getGameValueType()));
/*     */                     } 
/*     */                   } 
/* 620 */                   x.append("[]");
/*     */                 } else {
/*     */                   
/* 623 */                   x.append((CharSequence)Game.i.gameValueManager.getTitle(upgrade.getGameValueType()));
/* 624 */                   if (m != 0) {
/*     */                     
/* 626 */                     x.append("\n");
/*     */                     
/* 628 */                     CoreTile.Upgrade.UpgradeLevel upgradeLevel1 = ((CoreTile.Upgrade.UpgradeLevel[])upgrade.upgradeLevels.items)[m - 1];
/* 629 */                     x.append((CharSequence)Game.i.gameValueManager.formatEffectValue(upgradeLevel1.delta, gameValueStockConfig.units));
/*     */                     
/* 631 */                     x.append(" >> [#");
/* 632 */                     x.append(y);
/* 633 */                     x.append("]");
/*     */                     
/* 635 */                     x.append((CharSequence)Game.i.gameValueManager.formatEffectValue(upgradeLevel.delta, gameValueStockConfig.units));
/*     */                   } else {
/* 637 */                     x.append(" [#");
/* 638 */                     x.append(y);
/* 639 */                     x.append("]");
/* 640 */                     x.append((CharSequence)Game.i.gameValueManager.formatEffectValue(upgradeLevel.delta, gameValueStockConfig.units));
/*     */                   } 
/* 642 */                   x.append("[]");
/*     */                 } 
/*     */               } 
/*     */             } else {
/*     */               
/* 647 */               CoreTile.Upgrade.UpgradeLevel upgradeLevel = ((CoreTile.Upgrade.UpgradeLevel[])upgrade.upgradeLevels.items)[m - 1];
/* 648 */               if (upgrade.isAction) {
/*     */                 
/* 650 */                 x.setLength(0);
/* 651 */                 String str1 = Game.i.triggeredActionManager.getTitleAlias(upgrade.getActionType());
/* 652 */                 String str2 = "[#" + y + "]" + StringFormatter.compactNumberWithPrecisionTrimZeros(upgradeLevel.delta, 2, true) + "[]";
/* 653 */                 x.append(Game.i.localeManager.i18n.format(str1, new Object[] { str2 }));
/*     */               } else {
/*     */                 
/* 656 */                 x.setLength(0);
/*     */                 GameValueManager.GameValueStockConfig gameValueStockConfig;
/* 658 */                 if ((gameValueStockConfig = Game.i.gameValueManager.getStockValueConfig(upgrade.getGameValueType())).units == GameValueManager.ValueUnits.BOOLEAN) {
/*     */                   
/* 660 */                   x.append(" [#");
/* 661 */                   x.append(y);
/* 662 */                   x.append("]");
/*     */                   
/* 664 */                   if (upgradeLevel.delta <= 0.0F) {
/* 665 */                     x.append((CharSequence)Game.i.gameValueManager.getDisabledTitle(upgrade.getGameValueType()));
/*     */                   } else {
/* 667 */                     x.append((CharSequence)Game.i.gameValueManager.getTitle(upgrade.getGameValueType()));
/*     */                   } 
/*     */                   
/* 670 */                   x.append("[]");
/*     */                 } else {
/*     */                   
/* 673 */                   x.append((CharSequence)Game.i.gameValueManager.getTitle(upgrade.getGameValueType()));
/*     */                   
/* 675 */                   x.append(" [#");
/* 676 */                   x.append(y);
/* 677 */                   x.append("]");
/* 678 */                   x.append((CharSequence)Game.i.gameValueManager.formatEffectValue(upgradeLevel.delta, gameValueStockConfig.units));
/* 679 */                   x.append("[]");
/*     */                 } 
/*     */               } 
/*     */             } 
/*     */ 
/*     */             
/* 685 */             if (upgrade.upgradeLevels.size > 1) {
/* 686 */               x.append("\n\n");
/* 687 */               for (byte b1 = 0; b1 < upgrade.upgradeLevels.size; b1++) {
/* 688 */                 x.append("[#888888]L").append(b1 + 1).append(":[] ");
/*     */                 
/* 690 */                 if (b1 < m) {
/* 691 */                   x.append(" [#");
/* 692 */                   x.append(y);
/* 693 */                   x.append("]");
/*     */                 } 
/*     */                 
/* 696 */                 if (upgrade.isAction) {
/* 697 */                   x.append((CharSequence)StringFormatter.compactNumberWithPrecisionTrimZeros((((CoreTile.Upgrade.UpgradeLevel[])upgrade.upgradeLevels.items)[b1]).delta, 2, true));
/*     */                 } else {
/*     */                   GameValueManager.GameValueStockConfig gameValueStockConfig;
/* 700 */                   if ((gameValueStockConfig = Game.i.gameValueManager.getStockValueConfig(upgrade.getGameValueType())).units == GameValueManager.ValueUnits.BOOLEAN) {
/* 701 */                     if ((((CoreTile.Upgrade.UpgradeLevel[])upgrade.upgradeLevels.items)[b1]).delta <= 0.0F) {
/* 702 */                       x.append((CharSequence)Game.i.gameValueManager.getDisabledTitle(upgrade.getGameValueType()));
/*     */                     } else {
/* 704 */                       x.append((CharSequence)Game.i.gameValueManager.getTitle(upgrade.getGameValueType()));
/*     */                     } 
/*     */                   } else {
/* 707 */                     x.append((CharSequence)Game.i.gameValueManager.formatEffectValue((((CoreTile.Upgrade.UpgradeLevel[])upgrade.upgradeLevels.items)[b1]).delta, gameValueStockConfig.units));
/*     */                   } 
/*     */                 } 
/* 710 */                 if (b1 < m) {
/* 711 */                   x.append("[]");
/*     */                 }
/* 713 */                 if (b1 != upgrade.upgradeLevels.size - 1) x.append("\n");
/*     */               
/*     */               } 
/*     */             } 
/* 717 */             this.b.showSideTooltip(x, f2 - this.t * 128.0F + 64.0F);
/*     */           } else {
/* 719 */             this.b.hideSideTooltip();
/*     */           } 
/*     */         } else {
/* 722 */           this.b.hideSideTooltip();
/*     */         } 
/*     */       }
/*     */ 
/*     */       
/* 727 */       this.n.setTextFromInt(k);
/* 728 */       if (k > 0) {
/* 729 */         this.n.setColor(y);
/* 730 */         this.m.setColor(y);
/*     */         
/* 732 */         this.p.setVisible(true);
/* 733 */         for (b = 0; b < (this.q.getEmitters()).size; b++) {
/* 734 */           ((ParticleEmitter)this.q.getEmitters().get(b)).getTint().setColors(new float[] { y.r, y.g, y.b });
/*     */         
/*     */         }
/*     */       
/*     */       }
/*     */       else {
/*     */         
/* 741 */         this.n.setColor(1.0F, 1.0F, 1.0F, 0.56F);
/* 742 */         this.m.setColor(1.0F, 1.0F, 1.0F, 0.56F);
/* 743 */         this.p.setVisible(false);
/*     */       } 
/*     */     } 
/*     */     
/* 747 */     this.u = a();
/*     */   }
/*     */   
/*     */   private void c() {
/*     */     Tile tile;
/* 752 */     if ((tile = this.v._gameMapSelection.getSelectedTile()) != null && tile.type == TileType.CORE) {
/* 753 */       CoreTile coreTile = (CoreTile)tile;
/*     */       
/* 755 */       x.setLength(0);
/* 756 */       x.append("L").append(coreTile.getLevel());
/* 757 */       this.h.setText(x);
/* 758 */       this.r.setColor(Game.i.tileManager.F.CORE.getTierColor(coreTile.getTier()));
/* 759 */       this.r.setCoeff(coreTile.getCurrentLevelExperience() / coreTile.getNextLevelExperience());
/* 760 */       this.i.setText(StrictMath.round(coreTile.getCurrentLevelExperience()) + " / " + StrictMath.round(coreTile.getNextLevelExperience()) + " XP");
/*     */ 
/*     */       
/* 763 */       if (coreTile.doubleSpeedTimeLeft > 0.0F) {
/* 764 */         x.setLength(0);
/* 765 */         x.append("x2: ");
/* 766 */         x.append((CharSequence)StringFormatter.digestTime(StrictMath.round(coreTile.doubleSpeedTimeLeft)));
/* 767 */         this.j.setText(x);
/* 768 */         this.k.setText(x);
/* 769 */         this.j.setVisible(true);
/* 770 */         this.k.setVisible(true); return;
/*     */       } 
/* 772 */       this.j.setVisible(false);
/* 773 */       this.k.setVisible(false);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void draw(float paramFloat) {
/* 779 */     if (this.d) {
/* 780 */       c();
/*     */ 
/*     */       
/* 783 */       if (this.u != a())
/* 784 */         b(); 
/*     */     } 
/*     */   }
/*     */   
/*     */   private class _SideMenuListener extends SideMenu.SideMenuListener.SideMenuListenerAdapter {
/*     */     private _SideMenuListener(CoreMenu this$0) {}
/*     */     
/*     */     public void offscreenChanged() {
/* 792 */       CoreMenu.a(this.a, -1);
/* 793 */       CoreMenu.b(this.a, -1);
/* 794 */       CoreMenu.d(this.a);
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi\\ui\components\CoreMenu.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */