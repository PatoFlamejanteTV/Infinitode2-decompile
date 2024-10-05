/*     */ package com.prineside.tdi2.ui.components;
/*     */ import com.badlogic.gdx.graphics.Color;
/*     */ import com.badlogic.gdx.graphics.g2d.TextureRegion;
/*     */ import com.badlogic.gdx.math.Interpolation;
/*     */ import com.badlogic.gdx.utils.Array;
/*     */ import com.badlogic.gdx.utils.Disposable;
/*     */ import com.badlogic.gdx.utils.Null;
/*     */ import com.prineside.tdi2.Game;
/*     */ import com.prineside.tdi2.GameSystemProvider;
/*     */ import com.prineside.tdi2.enums.StaticSoundType;
/*     */ import com.prineside.tdi2.events.game.BonusesReRoll;
/*     */ import com.prineside.tdi2.gameplayMods.GameplayMod;
/*     */ import com.prineside.tdi2.managers.AssetManager;
/*     */ import com.prineside.tdi2.managers.UiManager;
/*     */ import com.prineside.tdi2.scene2d.Action;
/*     */ import com.prineside.tdi2.scene2d.Actor;
/*     */ import com.prineside.tdi2.scene2d.EventListener;
/*     */ import com.prineside.tdi2.scene2d.InputEvent;
/*     */ import com.prineside.tdi2.scene2d.InputListener;
/*     */ import com.prineside.tdi2.scene2d.Touchable;
/*     */ import com.prineside.tdi2.scene2d.actions.Actions;
/*     */ import com.prineside.tdi2.scene2d.ui.Image;
/*     */ import com.prineside.tdi2.scene2d.ui.ScrollPane;
/*     */ import com.prineside.tdi2.scene2d.ui.Table;
/*     */ import com.prineside.tdi2.scene2d.utils.ClickListener;
/*     */ import com.prineside.tdi2.scene2d.utils.Drawable;
/*     */ import com.prineside.tdi2.systems.BonusSystem;
/*     */ import com.prineside.tdi2.systems.GameplayModSystem;
/*     */ import com.prineside.tdi2.ui.actors.FancyButton;
/*     */ import com.prineside.tdi2.ui.actors.Label;
/*     */ import com.prineside.tdi2.ui.actors.PaddedImageButton;
/*     */ import com.prineside.tdi2.ui.shared.DarkOverlay;
/*     */ import com.prineside.tdi2.ui.shared.Notifications;
/*     */ import com.prineside.tdi2.ui.shared.TooltipsOverlay;
/*     */ import com.prineside.tdi2.utils.MaterialColor;
/*     */ import com.prineside.tdi2.utils.ObjectSupplier;
/*     */ import com.prineside.tdi2.utils.Quad;
/*     */ import com.prineside.tdi2.utils.logging.TLog;
/*     */ import java.util.Locale;
/*     */ 
/*     */ public class GameplayBonusesOverlay implements Disposable {
/*  42 */   private static final TLog a = TLog.forClass(GameplayBonusesOverlay.class);
/*     */ 
/*     */   
/*  45 */   private final UiManager.UiLayer b = Game.i.uiManager.addLayer(UiManager.MainUiLayer.SCREEN, 207, "AbilitySelectionOverlay main");
/*     */   
/*     */   private GameSystemProvider c;
/*  48 */   private float d = -1.0F;
/*     */   
/*     */   private long e;
/*     */   private long f;
/*     */   
/*     */   public GameplayBonusesOverlay(GameSystemProvider paramGameSystemProvider) {
/*  54 */     this.c = paramGameSystemProvider;
/*     */     
/*  56 */     paramGameSystemProvider.events.getListeners(BonusesReRoll.class).add(paramBonusesReRoll -> {
/*     */           if (!paramGameSystemProvider.gameState.replayMode) {
/*     */             show();
/*     */           }
/*  60 */         }).setDescription("GameplayBonusesOverlay - shows the overlay");
/*  61 */     this.b.getTable().setVisible(false);
/*     */   }
/*     */   
/*     */   public boolean isVisible() {
/*  65 */     return this.b.getTable().isVisible();
/*     */   }
/*     */   
/*     */   public void show() {
/*  69 */     if (!this.c.bonus.isEnabled()) {
/*     */       return;
/*     */     }
/*  72 */     this.e = Game.getTimestampMillis();
/*     */     
/*  74 */     if (this.d == -1.0F) {
/*  75 */       this.d = this.c.gameState.getNonAnimatedGameSpeed();
/*     */     }
/*  77 */     this.c.gameState.setGameSpeed(0.0F);
/*     */     
/*  79 */     DarkOverlay.i().addCaller("GameplayBonusesOverlay", UiManager.MainUiLayer.SCREEN, 206, () -> {
/*     */           if (Game.getTimestampMillis() - this.e < 500L) {
/*     */             return false;
/*     */           }
/*     */           
/*     */           if ((this.c.bonus.getStagesConfig()).forceImmediateSelection && this.c.bonus.getStageToChooseBonusFor() != null) {
/*     */             if (Game.getTimestampMillis() - this.f > 1000L) {
/*     */               Notifications.i().add(Game.i.localeManager.i18n.get("bonus_selection_notification_selection_required"), null, null, StaticSoundType.FAIL);
/*     */               
/*     */               this.f = Game.getTimestampMillis();
/*     */             } 
/*     */             return false;
/*     */           } 
/*     */           hide();
/*     */           return true;
/*     */         });
/*  95 */     this.b.getTable().setVisible(true);
/*     */     
/*  97 */     this.b.getTable().clear();
/*     */     
/*     */     Label label;
/*     */     
/* 101 */     (label = new Label(Game.i.localeManager.i18n.get("bonuses_menu_active_bonuses_title"), Game.i.assetManager.getLabelStyle(24))).setColor(MaterialColor.LIGHT_GREEN.P500);
/* 102 */     this.b.getTable().add((Actor)label).padBottom(16.0F).row();
/*     */     
/* 104 */     Table table = new Table();
/* 105 */     ScrollPane scrollPane = new ScrollPane((Actor)table, Game.i.assetManager.getScrollPaneStyle(0.0F));
/* 106 */     this.b.getTable().add((Actor)scrollPane).height(308.0F).width(1280.0F).row();
/*     */     
/* 108 */     table.add().width(1.0F).height(4.0F).row();
/*     */     
/* 110 */     Array array1 = new Array(true, 1, GameplayModSystem.ActiveMod.class); int i;
/* 111 */     for (i = 0; i < (this.c.gameplayMod.getActiveMods()).size; i++) {
/*     */       GameplayModSystem.ActiveMod activeMod;
/* 113 */       if ((activeMod = (GameplayModSystem.ActiveMod)this.c.gameplayMod.getActiveMods().get(i)).getSource().equals("BonusSystem")) {
/* 114 */         array1.add(activeMod);
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 119 */     array1.sort((paramActiveMod1, paramActiveMod2) -> {
/*     */           int i;
/*     */ 
/*     */ 
/*     */           
/*     */           return ((i = Boolean.compare(paramActiveMod1.getMod().isImmediateAndNotListed(), paramActiveMod2.getMod().isImmediateAndNotListed())) != 0) ? i : paramActiveMod1.getMod().getId().compareTo(paramActiveMod2.getMod().getId());
/*     */         });
/*     */ 
/*     */ 
/*     */     
/* 129 */     if ((i = (this.c.bonus.getStagesConfig()).activeBonusesSlotLimit) > 0) {
/*     */       
/* 131 */       int j = array1.size;
/*     */       
/* 133 */       byte b5 = 0; byte b6;
/* 134 */       for (b6 = 0; b6 < array1.size; b6++) {
/*     */         GameplayModSystem.ActiveMod activeMod;
/* 136 */         if ((activeMod = (GameplayModSystem.ActiveMod)array1.get(b6)).getMod().isImmediateAndNotListed()) {
/* 137 */           j = b6;
/*     */           break;
/*     */         } 
/* 140 */         b5++;
/*     */       } 
/*     */       
/* 143 */       for (b6 = 0; b6 < i - b5; b6++) {
/* 144 */         array1.insert(j, null);
/*     */       }
/*     */     } 
/*     */     
/* 148 */     byte b1 = 0;
/* 149 */     byte b2 = 0;
/* 150 */     byte b3 = 0;
/* 151 */     for (byte b4 = 0; b4 < array1.size; b4++) {
/* 152 */       GameplayModSystem.ActiveMod activeMod = (GameplayModSystem.ActiveMod)array1.get(b4);
/* 153 */       Table table1 = new Table();
/* 154 */       table.add((Actor)table1).width(96.0F).height(128.0F).padRight(8.0F).padLeft(8.0F).padBottom(16.0F);
/*     */       
/* 156 */       boolean bool = ((b2 + b1) % 2 == 0) ? true : false;
/* 157 */       if (activeMod == null) {
/*     */         
/* 159 */         table1.background((Drawable)Game.i.assetManager.getQuad(
/* 160 */               bool ? "ui.gameplayBonuses.activeBonusCell.emptyEven" : "ui.gameplayBonuses.activeBonusCell.emptyOdd"));
/*     */       } else {
/*     */         
/* 163 */         table1.addListener((EventListener)new ClickListener(this, activeMod, table1)
/*     */             {
/*     */               public void clicked(InputEvent param1InputEvent, float param1Float1, float param1Float2) {
/* 166 */                 String str = String.valueOf(Game.i.assetManager.replaceRegionAliasesWithChars(this.a.getMod().getDescription()));
/* 167 */                 if (this.a.getMod().isImmediateAndNotListed()) {
/* 168 */                   String str1 = Game.i.localeManager.i18n.get("bonuses_menu_active_bonus_immediate_hint");
/* 169 */                   str = str + "\n[#607D8B]" + str1 + "[]";
/*     */                 } 
/* 171 */                 TooltipsOverlay.i().showText("GameplayBonusesOverlay.activeBonusDescription", (Actor)this.b, str, UiManager.MainUiLayer.SCREEN, 208, 4);
/*     */               }
/*     */             });
/*     */         
/* 175 */         table1.background((Drawable)Game.i.assetManager.getQuad(
/* 176 */               activeMod.getMod().isImmediateAndNotListed() ? (
/* 177 */               bool ? "ui.gameplayBonuses.activeBonusCell.immediateEven" : "ui.gameplayBonuses.activeBonusCell.immediateOdd") : (
/*     */               
/* 179 */               bool ? "ui.gameplayBonuses.activeBonusCell.even" : "ui.gameplayBonuses.activeBonusCell.odd")));
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 184 */         Image image = new Image(activeMod.getMod().getIcon());
/* 185 */         table1.add((Actor)image).size(80.0F).row();
/*     */ 
/*     */         
/* 188 */         if (activeMod.getMod().getMaxPower() != 2048) {
/*     */           int j;
/* 190 */           if ((j = activeMod.getMod().getMaxPower()) > 10) {
/* 191 */             j = 10;
/*     */           }
/* 193 */           int k = activeMod.getMod().getPower();
/*     */           Table table2;
/* 195 */           (table2 = new Table()).add().width(1.0F).growY().row();
/* 196 */           table1.add((Actor)table2).size(80.0F, 24.0F).padTop(4.0F);
/* 197 */           for (byte b = 0; b < j; b++) {
/* 198 */             Image image1 = new Image((TextureRegion)(AssetManager.TextureRegions.i()).smallCircle);
/* 199 */             table2.add((Actor)image1).size(8.0F).pad(2.0F);
/* 200 */             if (b >= k) {
/* 201 */               image1.setColor(0.0F, 0.0F, 0.0F, 1.0F);
/*     */             }
/* 203 */             else if (activeMod.getMod().isPowerLevelUpgradedByOtherMod(b + 1)) {
/* 204 */               image1.setColor(MaterialColor.LIGHT_GREEN.P500);
/*     */             } 
/*     */             
/* 207 */             if ((b + 1) % 5 == 0) {
/* 208 */               table2.row();
/*     */             }
/*     */           } 
/*     */         } else {
/* 212 */           table1.add().size(80.0F, 24.0F).padTop(4.0F);
/*     */         } 
/*     */       } 
/*     */       
/* 216 */       b1++;
/* 217 */       if (b1 == 10) {
/* 218 */         table.row();
/* 219 */         b1 = 0;
/* 220 */         b2++;
/*     */       } 
/* 222 */       b3++;
/*     */     } 
/*     */     
/* 225 */     if (b3 == 0) {
/*     */       Label label1;
/* 227 */       (label1 = new Label(Game.i.localeManager.i18n.get("bonuses_menu_no_active_bonuses_hint"), Game.i.assetManager.getLabelStyle(21))).setColor(1.0F, 1.0F, 1.0F, 0.56F);
/* 228 */       table.add((Actor)label1).row();
/*     */     } 
/*     */     
/* 231 */     table.row();
/* 232 */     table.add().width(1.0F).height(4.0F).row();
/* 233 */     table.add().width(1.0F).growY();
/*     */     Array array2;
/*     */     BonusSystem.BonusStage bonusStage;
/* 236 */     if ((bonusStage = this.c.bonus.getStageToChooseBonusFor()) != null && (
/*     */       
/* 238 */       array2 = bonusStage.getBonusesToChooseFrom()) != null && array2.size > 0) {
/*     */       Label label1;
/* 240 */       (label1 = new Label(Game.i.localeManager.i18n.get("bonuses_menu_select_bonus_title"), Game.i.assetManager.getLabelStyle(24))).setColor(MaterialColor.LIGHT_GREEN.P500);
/* 241 */       this.b.getTable().add((Actor)label1).padBottom(26.0F).padTop(16.0F).row();
/*     */       
/* 243 */       Table table1 = new Table();
/* 244 */       this.b.getTable().add((Actor)table1).padTop(58.0F).row();
/*     */       
/* 246 */       for (byte b = 0; b < array2.size; b++) {
/* 247 */         GameplayMod gameplayMod2 = (GameplayMod)array2.get(b);
/*     */         
/*     */         Table table3;
/* 250 */         (table3 = new Table()).setTouchable(Touchable.enabled);
/*     */         
/*     */         Image image2;
/* 253 */         (image2 = new Image((Drawable)Game.i.assetManager.getQuad("ui.gameplayBonuses.card"))).setFillParent(true);
/* 254 */         table3.addActor((Actor)image2);
/*     */         
/* 256 */         String str = "ui.gameplayBonuses.cardOverlay." + gameplayMod2.getCategory().name().toLowerCase(Locale.US);
/* 257 */         if (gameplayMod2.getAdditionalCategory() != null) {
/* 258 */           str = str + "-" + gameplayMod2.getAdditionalCategory().name().toLowerCase(Locale.US);
/*     */         }
/*     */         Quad quad;
/* 261 */         if ((quad = Game.i.assetManager.getQuad(str)) != Quad.getNoQuad()) {
/*     */           Image image;
/* 263 */           (image = new Image((Drawable)quad)).setFillParent(true);
/* 264 */           table3.addActor((Actor)image);
/*     */         } else {
/* 266 */           a.i("no overlay quad for " + str, new Object[0]);
/*     */         } 
/*     */         
/* 269 */         if (!gameplayMod2.isImmediateAndNotListed() && gameplayMod2.getPower() > 1) {
/*     */           Image image;
/* 271 */           (image = new Image((Drawable)Game.i.assetManager.getQuad("ui.gameplayBonuses.cardOverlay.upgrade"))).setFillParent(true);
/* 272 */           table3.addActor((Actor)image);
/*     */         } 
/*     */         
/* 275 */         table1.add((Actor)table3).width(350.0F).padLeft(20.0F).padRight(20.0F).height(250.0F);
/* 276 */         table3.setTransform(true);
/*     */         
/* 278 */         float f = Game.i.settingsManager.isUiAnimationsEnabled() ? 1.5F : 0.0F;
/* 279 */         table3.setOrigin(175.0F, 0.0F);
/* 280 */         table3.addAction((Action)Actions.sequence(
/* 281 */               (Action)Actions.scaleTo(0.0F, 0.0F), 
/* 282 */               (Action)Actions.moveBy(0.0F, 0.0F), 
/* 283 */               (Action)Actions.delay(f * 0.1F * (b + 1)), 
/* 284 */               (Action)Actions.parallel(
/* 285 */                 (Action)Actions.moveBy(0.0F, 0.0F, 0.2F * f), 
/* 286 */                 (Action)Actions.sequence(
/* 287 */                   (Action)Actions.scaleTo(1.0F, 1.0F, 0.2F * f, (Interpolation)Interpolation.swingOut))), 
/*     */ 
/*     */               
/* 290 */               (Action)Actions.run(() -> paramTable.setTransform(false))));
/*     */ 
/*     */ 
/*     */         
/*     */         Image image1;
/*     */ 
/*     */         
/* 297 */         (image1 = new Image(gameplayMod2.getIcon())).setSize(80.0F, 80.0F);
/* 298 */         image1.setPosition(135.0F, 220.0F);
/* 299 */         table3.addActor((Actor)image1);
/*     */         
/*     */         Label label3;
/* 302 */         (label3 = new Label(Game.i.assetManager.replaceRegionAliasesWithChars(gameplayMod2.getDescription()), Game.i.assetManager.getLabelStyle(24))).setWrap(true);
/* 303 */         label3.setAlignment(2);
/* 304 */         table3.add((Actor)label3).growX().padLeft(25.0F).padRight(25.0F).padTop(58.0F).row();
/*     */         
/* 306 */         table3.add().growY().width(1.0F).row();
/*     */         
/* 308 */         if (gameplayMod2.getMaxPower() < 30) {
/* 309 */           String str1 = gameplayMod2.getPower() + " / " + gameplayMod2.getMaxPower();
/* 310 */           String str2 = Game.i.localeManager.i18n.format("bonus_gmod_level", new Object[] { str1 });
/*     */           Label label4;
/* 312 */           (label4 = new Label(str2, Game.i.assetManager.getLabelStyle(18))).setColor(1.0F, 1.0F, 1.0F, 0.56F);
/* 313 */           label4.setAlignment(4);
/* 314 */           table3.add((Actor)label4).growX().padLeft(20.0F).padRight(20.0F).padBottom(5.0F).row();
/*     */           
/* 316 */           Table table4 = new Table();
/* 317 */           table3.add((Actor)table4).growX().padLeft(20.0F).padRight(20.0F).padBottom(12.0F).row();
/*     */           
/* 319 */           for (byte b6 = 1; b6 <= gameplayMod2.getMaxPower(); b6++) {
/* 320 */             Image image = new Image((TextureRegion)(AssetManager.TextureRegions.i()).smallCircle);
/* 321 */             table4.add((Actor)image).padLeft(2.0F).padRight(2.0F).size(8.0F);
/* 322 */             if (gameplayMod2.getPower() >= b6) {
/* 323 */               image.setColor(Color.WHITE);
/*     */             } else {
/* 325 */               image.setColor(0.0F, 0.0F, 0.0F, 0.35F);
/*     */             } 
/*     */           } 
/*     */         } else {
/* 329 */           table3.add().height(22.0F).growX().padLeft(20.0F).padRight(20.0F).padBottom(5.0F).row();
/*     */         } 
/*     */         
/* 332 */         if (gameplayMod2.getNotSatisfiedPreconditions(this.c) != null) {
/*     */           Image image;
/* 334 */           (image = new Image((Drawable)Game.i.assetManager.getQuad("ui.gameplayBonuses.cardOverlay.notAvailable"))).setFillParent(true);
/* 335 */           table3.addActor((Actor)image);
/*     */           
/* 337 */           for (byte b6 = 0; b6 < 4; b6++) {
/* 338 */             Label label5 = new Label(Game.i.localeManager.i18n.get("bonus_selection_requirements_not_met_label"), Game.i.assetManager.getLabelStyle(21));
/* 339 */             switch (b6) { case 0:
/* 340 */                 label5.setPosition(0.0F, 18.0F); break;
/* 341 */               case 1: label5.setPosition(0.0F, 22.0F); break;
/* 342 */               case 2: label5.setPosition(2.0F, 20.0F); break;
/* 343 */               case 3: label5.setPosition(-2.0F, 20.0F); break; }
/*     */             
/* 345 */             label5.setSize(350.0F, 20.0F);
/* 346 */             label5.setAlignment(1);
/* 347 */             label5.setColor(0.0F, 0.0F, 0.0F, 0.56F);
/* 348 */             table3.addActor((Actor)label5);
/*     */           } 
/*     */           
/*     */           Label label4;
/* 352 */           (label4 = new Label(Game.i.localeManager.i18n.get("bonus_selection_requirements_not_met_label"), Game.i.assetManager.getLabelStyle(21))).setPosition(0.0F, 20.0F);
/* 353 */           label4.setSize(350.0F, 20.0F);
/* 354 */           label4.setAlignment(1);
/* 355 */           label4.setColor(MaterialColor.DEEP_ORANGE.P500);
/* 356 */           table3.addActor((Actor)label4);
/*     */         } 
/*     */         
/*     */         Actor actor;
/*     */         
/* 361 */         (actor = new Actor()).setSize(350.0F, 250.0F);
/* 362 */         table3.addActor(actor);
/*     */         
/* 364 */         byte b5 = b;
/* 365 */         actor.addListener((EventListener)new ClickListener(this, gameplayMod2, b5)
/*     */             {
/*     */               public void clicked(InputEvent param1InputEvent, float param1Float1, float param1Float2) {
/* 368 */                 if (Game.getTimestampMillis() - GameplayBonusesOverlay.a(this.c) < 500L) {
/*     */                   return;
/*     */                 }
/*     */                 ObjectSupplier objectSupplier;
/* 372 */                 if ((objectSupplier = this.a.getNotSatisfiedPreconditions(GameplayBonusesOverlay.b(this.c))) == null) {
/* 373 */                   (GameplayBonusesOverlay.b(this.c)).bonus.selectBonusAction(this.b);
/* 374 */                   this.c.hide(); return;
/*     */                 } 
/* 376 */                 String str = Game.i.localeManager.i18n.get("bonus_selection_preconditions_not_satisfied");
/* 377 */                 str = str + ":\n" + objectSupplier.get();
/* 378 */                 Notifications.i().add(str, null, null, StaticSoundType.FAIL);
/*     */               }
/*     */             });
/*     */         
/* 382 */         actor.addListener((EventListener)new InputListener(this, image2)
/*     */             {
/*     */               public void enter(InputEvent param1InputEvent, float param1Float1, float param1Float2, int param1Int, @Null Actor param1Actor) {
/* 385 */                 this.a.setDrawable((Drawable)Game.i.assetManager.getQuad("ui.gameplayBonuses.cardHover"));
/*     */               }
/*     */               
/*     */               public void exit(InputEvent param1InputEvent, float param1Float1, float param1Float2, int param1Int, @Null Actor param1Actor) {
/* 389 */                 this.a.setDrawable((Drawable)Game.i.assetManager.getQuad("ui.gameplayBonuses.card"));
/*     */               }
/*     */             });
/*     */         
/*     */         GameplayMod gameplayMod1;
/* 394 */         if ((gameplayMod1 = gameplayMod2.getReplacesUnsatisfiedMod()) != null) {
/*     */           PaddedImageButton paddedImageButton;
/* 396 */           (paddedImageButton = new PaddedImageButton((Drawable)Game.i.assetManager.getDrawable("icon-clockwise"), null, MaterialColor.PINK.P500, MaterialColor.PINK.P300, MaterialColor.PINK.P700)).disableClickThrough = true;
/* 397 */           paddedImageButton.setClickHandler(() -> {
/*     */                 a.i("show tooltip", new Object[0]);
/*     */                 
/*     */                 Table table = new Table();
/*     */                 
/*     */                 Label label2;
/*     */                 
/*     */                 (label2 = new Label(Game.i.localeManager.i18n.get("bonus_selection_bonus_is_replacement_tooltip") + ":", Game.i.assetManager.getLabelStyle(18))).setWrap(true);
/*     */                 
/*     */                 table.add((Actor)label2).width(350.0F).growX().row();
/*     */                 
/*     */                 Image image = new Image(paramGameplayMod.getIcon());
/*     */                 
/*     */                 table.add((Actor)image).size(64.0F).padTop(8.0F).padBottom(8.0F).row();
/*     */                 
/*     */                 Label label1;
/*     */                 
/*     */                 (label1 = new Label(paramGameplayMod.getDescription(), Game.i.assetManager.getLabelStyle(21))).setWrap(true);
/*     */                 
/*     */                 label1.setColor(MaterialColor.GREY.P500);
/*     */                 
/*     */                 table.add((Actor)label1).width(350.0F).growX().row();
/*     */                 
/*     */                 (label1 = new Label(Game.i.localeManager.i18n.get("bonus_selection_requirements_not_met_label") + ":", Game.i.assetManager.getLabelStyle(18))).setWrap(true);
/*     */                 label1.setColor(MaterialColor.PINK.P500);
/*     */                 table.add((Actor)label1).width(350.0F).growX().padTop(8.0F).row();
/*     */                 ObjectSupplier objectSupplier = paramGameplayMod.getNotSatisfiedPreconditions(this.c);
/*     */                 (label1 = new Label((objectSupplier == null) ? "" : (CharSequence)objectSupplier.get(), Game.i.assetManager.getLabelStyle(21))).setWrap(true);
/*     */                 table.add((Actor)label1).width(350.0F).growX().row();
/*     */                 (label1 = new Label(Game.i.localeManager.i18n.get("bonus_selection_requirements_not_met_next_run_hint"), Game.i.assetManager.getLabelStyle(18))).setWrap(true);
/*     */                 label1.setColor(MaterialColor.LIGHT_GREEN.P500);
/*     */                 table.add((Actor)label1).width(350.0F).growX().padTop(8.0F).row();
/*     */                 TooltipsOverlay.i().showActor("GameplayBonusesOverlay_replacedBonusHint", (Actor)paramPaddedImageButton, (Actor)table, this.b.mainUiLayer, this.b.zIndex + 1, 4);
/*     */               });
/* 431 */           paddedImageButton.setSize(64.0F, 64.0F);
/* 432 */           paddedImageButton.setPosition(235.0F, 248.0F);
/* 433 */           paddedImageButton.setIconSize(48.0F, 48.0F);
/* 434 */           paddedImageButton.setIconPosition(8.0F, 8.0F);
/* 435 */           table3.addActor((Actor)paddedImageButton);
/*     */           
/*     */           Image image;
/* 438 */           (image = new Image((Drawable)Game.i.assetManager.getDrawable("icon-info"))).setTouchable(Touchable.disabled);
/* 439 */           image.setSize(16.0F, 16.0F);
/* 440 */           image.setPosition(259.0F, 272.0F);
/* 441 */           table3.addActor((Actor)image);
/*     */         } 
/*     */       } 
/*     */       
/* 445 */       Table table2 = new Table();
/* 446 */       this.b.getTable().add((Actor)table2).size(1024.0F, 64.0F).padTop(32.0F).row();
/*     */       
/* 448 */       if (array2.size == 1 && ((GameplayMod)array2.first()).getNotSatisfiedPreconditions(this.c) == null) {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 454 */         FancyButton fancyButton = (new FancyButton("regularGreenButton.a", () -> { this.c.bonus.setAutoSelectionOnSingleBonus(true); this.c.bonus.selectBonusAction(0); hide(); })).withLabel(24, Game.i.localeManager.i18n.get("bonus_selection_auto_toggle"));
/* 455 */         table2.add((Actor)fancyButton).height(64.0F).width(256.0F).padRight(16.0F);
/*     */       } 
/*     */       
/* 458 */       if (this.c.bonus.canReRollBonuses(bonusStage.getNumber())) {
/*     */         String str;
/*     */         int j;
/* 461 */         if ((j = this.c.bonus.getStagesConfig().getReRollPrice(bonusStage.getNumber(), this.c)) > 0) {
/* 462 */           str = Game.i.localeManager.i18n.format("bonus_selection_reroll_button", new Object[] { Integer.valueOf(j) });
/*     */         } else {
/* 464 */           str = Game.i.localeManager.i18n.get("bonus_selection_reroll_button_free");
/*     */         } 
/*     */ 
/*     */         
/* 468 */         FancyButton fancyButton = (new FancyButton("regularButton.b", () -> this.c.bonus.reRollBonusesAction())).withLabel(24, str);
/* 469 */         table2.add((Actor)fancyButton).size(256.0F, 64.0F);
/*     */         
/* 471 */         if ((this.c.bonus.getStagesConfig()).maxReRollsAllTime > 0) {
/*     */           
/* 473 */           int k = (this.c.bonus.getStagesConfig()).maxReRollsAllTime - this.c.bonus.getAllTimeReRollCount();
/* 474 */           String str1 = Game.i.localeManager.i18n.format("bonus_selection_reroll_count_left", new Object[] { Integer.valueOf(k) });
/*     */           Label label3;
/* 476 */           (label3 = new Label(str1, Game.i.assetManager.getLabelStyle(21))).setSize(256.0F, 16.0F);
/* 477 */           label3.setAlignment(1);
/* 478 */           label3.setPosition(0.0F, -28.0F);
/* 479 */           fancyButton.addActor((Actor)label3);
/*     */         } 
/*     */       } 
/*     */       
/* 483 */       Label label2 = new Label("", Game.i.assetManager.getLabelStyle(21));
/* 484 */       if ((this.c.bonus.getStagesConfig()).forceImmediateSelection) {
/* 485 */         label2.setColor(MaterialColor.ORANGE.P300);
/* 486 */         label2.setText(Game.i.localeManager.i18n.get("bonus_selection_overlay_hint_forced_selection"));
/*     */       } else {
/* 488 */         label2.setColor(MaterialColor.LIGHT_GREEN.P300);
/* 489 */         label2.setText(Game.i.localeManager.i18n.get("bonus_selection_overlay_hint_not_forced_selection"));
/*     */       } 
/* 491 */       this.b.getTable().add((Actor)label2).padTop(40.0F).row();
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void hide() {
/* 497 */     if (!this.c.gameState.isPaused()) {
/* 498 */       this.c.gameState.setGameSpeed(this.d);
/*     */     }
/* 500 */     this.d = -1.0F;
/* 501 */     DarkOverlay.i().removeCaller("GameplayBonusesOverlay");
/* 502 */     this.b.getTable().setVisible(false);
/*     */   }
/*     */ 
/*     */   
/*     */   public void dispose() {
/* 507 */     DarkOverlay.i().removeCaller("GameplayBonusesOverlay");
/* 508 */     Game.i.uiManager.removeLayer(this.b);
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi\\ui\components\GameplayBonusesOverlay.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */