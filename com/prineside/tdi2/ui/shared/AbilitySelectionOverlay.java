/*     */ package com.prineside.tdi2.ui.shared;
/*     */ import com.badlogic.gdx.graphics.Color;
/*     */ import com.badlogic.gdx.graphics.g2d.BitmapFont;
/*     */ import com.badlogic.gdx.graphics.g2d.TextureRegion;
/*     */ import com.badlogic.gdx.utils.Array;
/*     */ import com.badlogic.gdx.utils.Json;
/*     */ import com.badlogic.gdx.utils.JsonValue;
/*     */ import com.esotericsoftware.kryo.Kryo;
/*     */ import com.esotericsoftware.kryo.io.Input;
/*     */ import com.esotericsoftware.kryo.io.Output;
/*     */ import com.google.common.base.Preconditions;
/*     */ import com.prineside.tdi2.Ability;
/*     */ import com.prineside.tdi2.Game;
/*     */ import com.prineside.tdi2.GameValueProvider;
/*     */ import com.prineside.tdi2.Item;
/*     */ import com.prineside.tdi2.enums.AbilityType;
/*     */ import com.prineside.tdi2.enums.ResourceType;
/*     */ import com.prineside.tdi2.enums.StaticSoundType;
/*     */ import com.prineside.tdi2.managers.UiManager;
/*     */ import com.prineside.tdi2.managers.preferences.categories.ProgressPrefs;
/*     */ import com.prineside.tdi2.managers.preferences.categories.SettingsPrefs;
/*     */ import com.prineside.tdi2.scene2d.Action;
/*     */ import com.prineside.tdi2.scene2d.Actor;
/*     */ import com.prineside.tdi2.scene2d.EventListener;
/*     */ import com.prineside.tdi2.scene2d.Group;
/*     */ import com.prineside.tdi2.scene2d.InputEvent;
/*     */ import com.prineside.tdi2.scene2d.Touchable;
/*     */ import com.prineside.tdi2.scene2d.actions.Actions;
/*     */ import com.prineside.tdi2.scene2d.ui.Image;
/*     */ import com.prineside.tdi2.scene2d.ui.ScrollPane;
/*     */ import com.prineside.tdi2.scene2d.ui.Table;
/*     */ import com.prineside.tdi2.scene2d.utils.ClickListener;
/*     */ import com.prineside.tdi2.scene2d.utils.Drawable;
/*     */ import com.prineside.tdi2.ui.actors.AbilitySlotButton;
/*     */ import com.prineside.tdi2.ui.actors.ComplexButton;
/*     */ import com.prineside.tdi2.ui.actors.Label;
/*     */ import com.prineside.tdi2.ui.actors.OverlayContinueButton;
/*     */ import com.prineside.tdi2.ui.actors.QuadActor;
/*     */ import com.prineside.tdi2.utils.MaterialColor;
/*     */ import com.prineside.tdi2.utils.ObjectConsumer;
/*     */ import com.prineside.tdi2.utils.QuadDrawable;
/*     */ import com.prineside.tdi2.utils.REGS;
/*     */ import com.prineside.tdi2.utils.StringFormatter;
/*     */ import com.prineside.tdi2.utils.UiUtils;
/*     */ import com.prineside.tdi2.utils.logging.TLog;
/*     */ import java.util.Locale;
/*     */ 
/*     */ public final class AbilitySelectionOverlay extends UiManager.UiComponent.Adapter {
/*  49 */   private static final TLog a = TLog.forClass(AbilitySelectionOverlay.class);
/*     */   public static AbilitySelectionOverlay i() {
/*  51 */     return (AbilitySelectionOverlay)Game.i.uiManager.getComponent(AbilitySelectionOverlay.class);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*  56 */   private final UiManager.UiLayer b = Game.i.uiManager.addLayer(UiManager.MainUiLayer.SCREEN, 207, "AbilitySelectionOverlay main");
/*     */   
/*     */   private Runnable c;
/*     */   
/*     */   private ObjectConsumer<SelectedAbilitiesConfiguration> d;
/*     */   private Label e;
/*     */   private Label f;
/*     */   private Label g;
/*     */   private Group h;
/*     */   private Group i;
/*     */   private Group j;
/*     */   private Table k;
/*     */   private ComplexButton l;
/*     */   private Label m;
/*     */   private Label n;
/*     */   private OverlayContinueButton o;
/*  72 */   private final Array<AbilityListItem> p = new Array();
/*     */   private boolean q;
/*  74 */   private final AbilitySlotButton[] r = new AbilitySlotButton[6];
/*     */   
/*  76 */   private int s = -1;
/*     */   
/*     */   public AbilitySelectionOverlay() {
/*     */     Group group;
/*  80 */     (group = new Group()).setTransform(false);
/*  81 */     group.setOrigin(600.0F, 380.0F);
/*  82 */     this.b.getTable().add((Actor)group).size(1200.0F, 760.0F);
/*     */     
/*  84 */     this.h = new Group();
/*  85 */     this.h.setTransform(true);
/*  86 */     this.h.setOrigin(600.0F, 380.0F);
/*  87 */     this.h.setSize(1200.0F, 760.0F);
/*  88 */     group.addActor((Actor)this.h);
/*     */     
/*  90 */     QuadActor quadActor = new QuadActor(new Color(791621631), new float[] { 0.0F, 22.0F, 10.0F, 748.0F, 1200.0F, 760.0F, 1200.0F, 0.0F });
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  96 */     this.h.addActor((Actor)quadActor);
/*     */     
/*  98 */     this.e = new Label("", new Label.LabelStyle((BitmapFont)Game.i.assetManager.getFont(36), Color.WHITE));
/*  99 */     this.e.setPosition(60.0F, 666.0F);
/* 100 */     this.e.setSize(300.0F, 27.0F);
/* 101 */     this.h.addActor((Actor)this.e);
/*     */ 
/*     */     
/* 104 */     this.l = new ComplexButton("", Game.i.assetManager.getLabelStyle(24), () -> {
/*     */           int i;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */           
/*     */           if ((i = Game.i.progressManager.getItemsCount((Item)Item.D.ABILITY_TOKEN)) <= 0) {
/*     */             Dialog.i().showAlert(Game.i.localeManager.i18n.get("not_enough_tokens"));
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */             
/*     */             return;
/*     */           } 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */           
/*     */           Dialog.i().showConfirm(Game.i.localeManager.i18n.get("ability_selection_token_confirm"), ());
/*     */         });
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 136 */     this.l.setBackground((Drawable)Game.i.assetManager.getDrawable("ui-ability-selection-token-button"), 0.0F, 0.0F, 158.0F, 79.0F);
/* 137 */     this.l.setSize(158.0F, 79.0F);
/* 138 */     this.l.setPosition(-7.0F, 550.0F);
/*     */     
/*     */     Image image2;
/* 141 */     (image2 = new Image((Drawable)Game.i.assetManager.getDrawable("ability-token"))).setPosition(42.0F, 12.0F);
/* 142 */     image2.setSize(64.0F, 64.0F);
/* 143 */     image2.setColor(0.0F, 0.0F, 0.0F, 0.28F);
/* 144 */     this.l.addActor((Actor)image2);
/*     */ 
/*     */     
/* 147 */     (image2 = new Image((Drawable)Game.i.assetManager.getDrawable("ability-token"))).setPosition(40.0F, 14.0F);
/* 148 */     image2.setSize(64.0F, 64.0F);
/* 149 */     this.l.addActor((Actor)image2);
/*     */     
/* 151 */     this.n = new Label("0", Game.i.assetManager.getLabelStyle(24));
/* 152 */     this.n.setPosition(105.0F, 20.0F);
/* 153 */     this.n.setSize(2.0F, 21.0F);
/* 154 */     this.n.setAlignment(1);
/* 155 */     this.n.setColor(0.0F, 0.0F, 0.0F, 0.28F);
/* 156 */     this.l.addActor((Actor)this.n);
/*     */     
/* 158 */     this.m = new Label("0", Game.i.assetManager.getLabelStyle(24));
/* 159 */     this.m.setPosition(103.0F, 22.0F);
/* 160 */     this.m.setSize(2.0F, 21.0F);
/* 161 */     this.m.setAlignment(1);
/* 162 */     this.l.addActor((Actor)this.m);
/*     */     
/* 164 */     this.h.addActor((Actor)this.l);
/*     */ 
/*     */     
/* 167 */     (image2 = new Image((Drawable)Game.i.assetManager.getDrawable("icon-info-circle"))).setSize(48.0F, 48.0F);
/* 168 */     image2.setPosition(168.0F, 565.0F);
/* 169 */     image2.setColor(1.0F, 1.0F, 1.0F, 0.28F);
/* 170 */     image2.setTouchable(Touchable.enabled);
/* 171 */     image2.addListener((EventListener)new ClickListener(this, image2)
/*     */         {
/*     */           public void clicked(InputEvent param1InputEvent, float param1Float1, float param1Float2)
/*     */           {
/* 175 */             int i = 0;
/* 176 */             int[] arrayOfInt = new int[ResourceType.values.length]; AbilityType[] arrayOfAbilityType;
/*     */             int k;
/* 178 */             for (int j = (arrayOfAbilityType = AbilityType.values).length; k < j; ) { AbilityType abilityType = arrayOfAbilityType[k];
/* 179 */               if (Game.i.gameValueManager.getSnapshot().getIntValue(Game.i.abilityManager.getMaxPerGameGameValueType(abilityType)) != 0) {
/*     */                 
/* 181 */                 int m = Game.i.gameValueManager.getSnapshot().getIntValue(Game.i.abilityManager.getMaxPerGameGameValueType(abilityType));
/* 182 */                 int n = Game.i.progressManager.getAbilities(abilityType);
/*     */                 
/* 184 */                 while (n < m) {
/* 185 */                   Ability.Factory factory = Game.i.abilityManager.getFactory(abilityType);
/* 186 */                   i += factory.getPriceInGreenPapers(n); ResourceType[] arrayOfResourceType1; int i1; byte b1;
/* 187 */                   for (i1 = (arrayOfResourceType1 = ResourceType.values).length, b1 = 0; b1 < i1; ) { ResourceType resourceType = arrayOfResourceType1[b1];
/* 188 */                     arrayOfInt[resourceType.ordinal()] = arrayOfInt[resourceType.ordinal()] + factory.getPriceInResources(resourceType, n); b1++; }
/*     */                   
/* 190 */                   n++;
/*     */                 } 
/*     */               }  k++; }
/*     */             
/* 194 */             StringBuilder stringBuilder = new StringBuilder("[#81C784]<@icon-money>" + StringFormatter.commaSeparatedNumber(i) + "[]"); ResourceType[] arrayOfResourceType; byte b;
/* 195 */             for (k = (arrayOfResourceType = ResourceType.values).length, b = 0; b < k; ) { ResourceType resourceType = arrayOfResourceType[b];
/* 196 */               if (arrayOfInt[resourceType.ordinal()] > 0) {
/*     */                 String str1;
/* 198 */                 if ((str1 = Game.i.resourceManager.getColor(resourceType).toString().toUpperCase(Locale.US)).length() > 6) {
/* 199 */                   str1 = str1.substring(0, 6);
/*     */                 }
/* 201 */                 stringBuilder.append("  [#").append(str1).append("]<@resource-")
/* 202 */                   .append(resourceType.name().toLowerCase(Locale.ENGLISH)).append(">")
/* 203 */                   .append((CharSequence)StringFormatter.commaSeparatedNumber(arrayOfInt[resourceType.ordinal()]))
/* 204 */                   .append("[]");
/*     */               } 
/*     */               b++; }
/*     */             
/* 208 */             String str = Game.i.localeManager.i18n.format("ability_selection_token_hint", new Object[] { stringBuilder.toString() });
/*     */             
/* 210 */             TooltipsOverlay.i().showText("_generic_", (Actor)this.a, Game.i.assetManager.replaceRegionAliasesWithChars(str), (AbilitySelectionOverlay.a(this.b)).mainUiLayer, (AbilitySelectionOverlay.a(this.b)).zIndex + 1, 4);
/*     */           }
/*     */         });
/*     */     
/* 214 */     this.h.addActor((Actor)image2);
/*     */ 
/*     */     
/* 217 */     for (byte b = 0; b < 6; b++) {
/* 218 */       this.r[b] = new AbilitySlotButton(true, (GameValueProvider)Game.i.gameValueManager.getSnapshot());
/* 219 */       this.r[b].setPosition(60.0F + (b % 2) * 128.0F, 172.0F + (b / 2) * 128.0F + (1 - b % 2) * 10.0F - 40.0F);
/* 220 */       this.h.addActor((Actor)this.r[b]);
/*     */       
/* 222 */       byte b1 = b;
/* 223 */       this.r[b].addListener((EventListener)new ClickListener(this, b1)
/*     */           {
/*     */             public void clicked(InputEvent param1InputEvent, float param1Float1, float param1Float2) {
/* 226 */               if (AbilitySelectionOverlay.b(this.b) == this.a) {
/* 227 */                 this.b.selectSlot(-1);
/*     */               } else {
/* 229 */                 this.b.selectSlot(this.a);
/*     */               } 
/* 231 */               Game.i.soundManager.playStatic(StaticSoundType.BUTTON);
/*     */             }
/*     */           });
/*     */     } 
/*     */ 
/*     */     
/* 237 */     this.k = new Table();
/* 238 */     this.k.setWidth(780.0F);
/*     */     
/*     */     ScrollPane scrollPane;
/* 241 */     UiUtils.enableMouseMoveScrollFocus(scrollPane = new ScrollPane((Actor)this.k));
/* 242 */     scrollPane.setSize(780.0F, 642.0F);
/* 243 */     scrollPane.setPosition(358.0F, 52.0F);
/* 244 */     this.h.addActor((Actor)scrollPane);
/*     */ 
/*     */     
/*     */     Image image3;
/*     */     
/* 249 */     (image3 = new Image((Drawable)Game.i.assetManager.getDrawable("gradient-top"))).setColor(new Color(791621631));
/* 250 */     image3.setSize(780.0F, 64.0F);
/* 251 */     image3.setPosition(358.0F, 631.0F);
/* 252 */     image3.setTouchable(Touchable.disabled);
/* 253 */     this.h.addActor((Actor)image3);
/*     */     
/*     */     Image image1;
/* 256 */     (image1 = new Image((Drawable)Game.i.assetManager.getDrawable("gradient-bottom"))).setColor(new Color(791621631));
/* 257 */     image1.setSize(780.0F, 64.0F);
/* 258 */     image1.setPosition(358.0F, 51.0F);
/* 259 */     image1.setTouchable(Touchable.disabled);
/* 260 */     this.h.addActor((Actor)image1);
/*     */ 
/*     */     
/* 263 */     this.i = new Group();
/* 264 */     this.i.setTransform(false);
/* 265 */     this.i.setPosition(155.0F, 50.0F);
/* 266 */     this.i.setSize(280.0F, 64.0F);
/* 267 */     this.i.setTouchable(Touchable.disabled);
/* 268 */     this.h.addActor((Actor)this.i);
/*     */ 
/*     */     
/* 271 */     (image1 = new Image((Drawable)Game.i.assetManager.getDrawable("icon-arrow-pointer-top-left"))).setSize(64.0F, 64.0F);
/* 272 */     image1.setPosition(0.0F, 0.0F);
/* 273 */     this.i.addActor((Actor)image1);
/*     */     
/* 275 */     this.f = new Label("", new Label.LabelStyle((BitmapFont)Game.i.assetManager.getFont(24), Color.WHITE));
/* 276 */     this.f.setPosition(80.0F, 0.0F);
/* 277 */     this.i.addActor((Actor)this.f);
/* 278 */     this.i.setVisible(false);
/*     */     
/* 280 */     this.j = new Group();
/* 281 */     this.j.setTransform(false);
/* 282 */     this.j.setPosition(240.0F, 50.0F);
/* 283 */     this.j.setSize(380.0F, 64.0F);
/* 284 */     this.h.addActor((Actor)this.j);
/*     */ 
/*     */     
/* 287 */     (image1 = new Image((Drawable)Game.i.assetManager.getDrawable("icon-arrow-pointer-top-right"))).setSize(64.0F, 64.0F);
/* 288 */     image1.setPosition(316.0F, 0.0F);
/* 289 */     this.j.addActor((Actor)image1);
/*     */     
/* 291 */     this.g = new Label("", new Label.LabelStyle((BitmapFont)Game.i.assetManager.getFont(24), Color.WHITE));
/* 292 */     this.g.setPosition(0.0F, 0.0F);
/* 293 */     this.g.setSize(296.0F, 20.0F);
/* 294 */     this.g.setAlignment(16);
/* 295 */     this.j.addActor((Actor)this.g);
/*     */     
/* 297 */     this.o = new OverlayContinueButton("", "icon-triangle-right", MaterialColor.LIGHT_BLUE.P800, MaterialColor.LIGHT_BLUE.P900, MaterialColor.LIGHT_BLUE.P700, () -> {
/*     */           if (this.d != null) {
/*     */             SelectedAbilitiesConfiguration selectedAbilitiesConfiguration;
/*     */             
/*     */             a(selectedAbilitiesConfiguration = b());
/*     */             this.d.accept(selectedAbilitiesConfiguration);
/*     */           } 
/*     */           setVisible(false);
/*     */         });
/* 306 */     this.o.setPosition(812.0F, -13.0F);
/* 307 */     this.h.addActor((Actor)this.o);
/*     */     
/* 309 */     this.b.getTable().setVisible(false);
/* 310 */     this.q = false;
/*     */   }
/*     */   
/*     */   private SelectedAbilitiesConfiguration b() {
/* 314 */     SelectedAbilitiesConfiguration selectedAbilitiesConfiguration = new SelectedAbilitiesConfiguration();
/* 315 */     byte b1 = 0; AbilitySlotButton[] arrayOfAbilitySlotButton; int i; byte b2;
/* 316 */     for (i = (arrayOfAbilitySlotButton = this.r).length, b2 = 0; b2 < i; b2++) {
/* 317 */       AbilitySlotButton abilitySlotButton; if ((abilitySlotButton = arrayOfAbilitySlotButton[b2]).getAbility() != null) {
/* 318 */         selectedAbilitiesConfiguration.slots[b1] = abilitySlotButton.getAbility();
/* 319 */         selectedAbilitiesConfiguration.counts[b1] = Game.i.progressManager.getAbilities(abilitySlotButton.getAbility());
/*     */       } 
/* 321 */       b1++;
/*     */     } 
/*     */     
/* 324 */     return selectedAbilitiesConfiguration;
/*     */   }
/*     */   
/*     */   private static void a(SelectedAbilitiesConfiguration paramSelectedAbilitiesConfiguration) {
/* 328 */     (ProgressPrefs.i()).inventory.lastSelectedAbilities.clear();
/* 329 */     for (byte b = 0; b < paramSelectedAbilitiesConfiguration.slots.length; b++) {
/* 330 */       (ProgressPrefs.i()).inventory.lastSelectedAbilities.add(paramSelectedAbilitiesConfiguration.slots[b]);
/*     */     }
/* 332 */     ProgressPrefs.i().requireSave();
/*     */   }
/*     */ 
/*     */   
/*     */   public final void update() {
/* 337 */     int i = Game.i.progressManager.getItemsCount((Item)Item.D.ABILITY_TOKEN);
/* 338 */     this.n.setText(i);
/* 339 */     this.m.setText(i);
/* 340 */     if (i <= 0) {
/* 341 */       this.l.setBackgroundColors(MaterialColor.GREY.P800, MaterialColor.GREY.P800, MaterialColor.GREY.P800, MaterialColor.GREY.P800);
/*     */     } else {
/* 343 */       this.l.setBackgroundColors(MaterialColor.LIGHT_BLUE.P800, MaterialColor.LIGHT_BLUE.P900, MaterialColor.LIGHT_BLUE.P700, MaterialColor.GREY.P800);
/*     */     }  AbilitySlotButton[] arrayOfAbilitySlotButton; int j;
/*     */     byte b2;
/* 346 */     for (j = (arrayOfAbilitySlotButton = this.r).length, b2 = 0; b2 < j; b2++) {
/* 347 */       AbilitySlotButton abilitySlotButton; if ((abilitySlotButton = arrayOfAbilitySlotButton[b2]).getAbility() != null)
/*     */       {
/* 349 */         abilitySlotButton.setCount(Game.i.progressManager.getAbilities(abilitySlotButton.getAbility()));
/*     */       }
/*     */     } 
/* 352 */     for (byte b1 = 0; b1 < this.p.size; b1++) {
/* 353 */       ((AbilityListItem)this.p.get(b1)).update();
/*     */     }
/*     */   }
/*     */   
/*     */   public final void show(Runnable paramRunnable, ObjectConsumer<SelectedAbilitiesConfiguration> paramObjectConsumer) {
/* 358 */     this.c = paramRunnable;
/* 359 */     this.d = paramObjectConsumer;
/*     */     
/* 361 */     this.e.setText(Game.i.localeManager.i18n.get("select_abilities"));
/* 362 */     this.f.setText(Game.i.localeManager.i18n.get("tap_to_select_slot"));
/* 363 */     this.g.setText(Game.i.localeManager.i18n.get("choose_ability_for_slot"));
/* 364 */     this.o.label.setText(Game.i.localeManager.i18n.get("play"));
/*     */     
/* 366 */     setVisible(true);
/*     */     AbilitySlotButton[] arrayOfAbilitySlotButton;
/*     */     int j;
/* 369 */     for (int i = (arrayOfAbilitySlotButton = this.r).length; j < i; j++) {
/* 370 */       AbilitySlotButton abilitySlotButton; (abilitySlotButton = arrayOfAbilitySlotButton[j]).setAbility(null);
/*     */     } 
/*     */     
/* 373 */     byte b1 = 0;
/*     */     
/* 375 */     if ((SettingsPrefs.i()).settings.lastSelectedAbilities.size != 0) {
/* 376 */       for (Array.ArrayIterator<AbilityType> arrayIterator = (SettingsPrefs.i()).settings.lastSelectedAbilities.iterator(); arrayIterator.hasNext(); ) { AbilityType abilityType = arrayIterator.next();
/* 377 */         this.r[b1].setAbility(abilityType);
/* 378 */         b1++;
/* 379 */         if (b1 != 6); }
/*     */     
/*     */     } else {
/* 382 */       for (Array.ArrayIterator<AbilityType> arrayIterator = (ProgressPrefs.i()).inventory.lastSelectedAbilities.iterator(); arrayIterator.hasNext(); ) { AbilityType abilityType = arrayIterator.next();
/* 383 */         this.r[b1].setAbility(abilityType);
/* 384 */         b1++;
/* 385 */         if (b1 != 6); }
/*     */     
/*     */     } 
/*     */ 
/*     */     
/* 390 */     this.k.clear();
/* 391 */     this.k.add().expandX().height(64.0F).row();
/*     */     
/* 393 */     this.p.clear(); AbilityType[] arrayOfAbilityType; byte b2;
/* 394 */     for (j = (arrayOfAbilityType = AbilityType.values).length, b2 = 0; b2 < j; ) { AbilityType abilityType = arrayOfAbilityType[b2];
/* 395 */       if (Game.i.gameValueManager.getSnapshot().getIntValue(Game.i.abilityManager.getMaxPerGameGameValueType(abilityType)) != 0) {
/*     */         
/* 397 */         AbilityListItem abilityListItem = new AbilityListItem(abilityType, (byte)0);
/* 398 */         this.p.add(abilityListItem);
/* 399 */         this.k.add((Actor)abilityListItem).size(780.0F, abilityListItem.getHeight()).padBottom(4.0F).row();
/*     */       }  b2++; }
/* 401 */      this.k.add().expandX().height(64.0F).row();
/* 402 */     this.k.add().expand();
/*     */     
/* 404 */     selectSlot(-1);
/* 405 */     update();
/*     */   }
/*     */ 
/*     */   
/*     */   public final void hide() {
/* 410 */     if (this.c != null) {
/*     */       SelectedAbilitiesConfiguration selectedAbilitiesConfiguration;
/* 412 */       a(selectedAbilitiesConfiguration = b());
/*     */       
/* 414 */       this.c.run();
/*     */     } 
/* 416 */     setVisible(false);
/*     */     
/* 418 */     this.c = null;
/* 419 */     this.d = null;
/*     */   }
/*     */   
/*     */   public final void setVisible(boolean paramBoolean) {
/* 423 */     float f = Game.i.settingsManager.isUiAnimationsEnabled() ? 1.0F : 0.0F;
/*     */ 
/*     */     
/* 426 */     if (paramBoolean) {
/* 427 */       DarkOverlay.i().addCaller("AbilitySelectionOverlay", UiManager.MainUiLayer.SCREEN, 206, () -> {
/*     */             hide();
/*     */             return true;
/*     */           });
/* 431 */       this.b.getTable().setVisible(true);
/* 432 */       this.b.getTable().setTouchable(Touchable.childrenOnly);
/*     */       
/* 434 */       this.h.clearActions();
/* 435 */       this.h.addAction((Action)Actions.sequence(
/* 436 */             (Action)Actions.scaleTo(1.0F, 1.0F), 
/* 437 */             (Action)Actions.moveTo(Game.i.settingsManager.getScaledViewportHeight() * 2.0F, 0.0F), 
/* 438 */             (Action)Actions.moveTo(0.0F, 0.0F, 0.2F * f)));
/*     */     } else {
/*     */       
/* 441 */       DarkOverlay.i().removeCaller("AbilitySelectionOverlay");
/* 442 */       this.b.getTable().setTouchable(Touchable.disabled);
/*     */       
/* 444 */       this.h.clearActions();
/* 445 */       this.h.addAction((Action)Actions.sequence(
/* 446 */             (Action)Actions.moveTo(Game.i.settingsManager.getScaledViewportHeight() * 2.0F, 0.0F, 0.2F * f), 
/* 447 */             (Action)Actions.run(() -> this.b.getTable().setVisible(false))));
/*     */     } 
/*     */ 
/*     */     
/* 451 */     this.q = paramBoolean;
/*     */   }
/*     */   
/*     */   public final void selectSlot(int paramInt) {
/*     */     AbilitySlotButton[] arrayOfAbilitySlotButton;
/*     */     int i;
/*     */     byte b;
/* 458 */     for (i = (arrayOfAbilitySlotButton = this.r).length, b = 0; b < i; b++) {
/* 459 */       AbilitySlotButton abilitySlotButton; (abilitySlotButton = arrayOfAbilitySlotButton[b]).setSelected(false);
/*     */     } 
/* 461 */     if (paramInt != -1) {
/*     */       
/* 463 */       this.r[paramInt].setSelected(true);
/*     */       
/* 465 */       this.i.setVisible(false);
/* 466 */       this.j.setVisible(true);
/*     */     } else {
/*     */       
/* 469 */       this.i.setVisible(true);
/* 470 */       this.j.setVisible(false);
/*     */     } 
/* 472 */     this.s = paramInt;
/* 473 */     update();
/*     */   }
/*     */   
/*     */   public final void setSelectedSlotAbilityType(AbilityType paramAbilityType) {
/* 477 */     if (this.s == -1)
/*     */       return;  AbilitySlotButton[] arrayOfAbilitySlotButton; int i; byte b;
/* 479 */     for (i = (arrayOfAbilitySlotButton = this.r).length, b = 0; b < i; b++) {
/* 480 */       AbilitySlotButton abilitySlotButton; if ((abilitySlotButton = arrayOfAbilitySlotButton[b]).getAbility() == paramAbilityType) {
/* 481 */         abilitySlotButton.setAbility(null);
/*     */       }
/*     */     } 
/* 484 */     this.r[this.s].setAbility(paramAbilityType);
/*     */     
/* 486 */     selectSlot(-1);
/*     */   }
/*     */   
/*     */   public final boolean isVisible() {
/* 490 */     return this.q;
/*     */   }
/*     */ 
/*     */   
/*     */   private class AbilityListItem
/*     */     extends Group
/*     */   {
/*     */     private AbilityType l;
/*     */     private Image m;
/*     */     private Image n;
/*     */     private Label o;
/*     */     private Label p;
/*     */     private ComplexButton q;
/*     */     private Label r;
/*     */     private Table s;
/*     */     private boolean t;
/*     */     
/*     */     private AbilityListItem(AbilitySelectionOverlay this$0, AbilityType param1AbilityType) {
/* 508 */       this.l = param1AbilityType;
/*     */       
/* 510 */       Ability.Factory factory = Game.i.abilityManager.getFactory(param1AbilityType);
/*     */       
/*     */       Label label2;
/* 513 */       (label2 = new Label(factory.getDescription((GameValueProvider)Game.i.gameValueManager.getSnapshot()), new Label.LabelStyle((BitmapFont)Game.i.assetManager.getFont(24), Color.WHITE))).setColor(1.0F, 1.0F, 1.0F, 0.78F);
/* 514 */       label2.setPosition(96.0F, 8.0F);
/* 515 */       label2.setWidth(400.0F);
/* 516 */       label2.setWrap(true);
/* 517 */       label2.setAlignment(10);
/* 518 */       label2.layout();
/* 519 */       label2.pack();
/* 520 */       label2.setWidth(400.0F);
/*     */       
/* 522 */       if (label2.getHeight() < 64.0F) {
/* 523 */         label2.setHeight(64.0F);
/*     */       }
/*     */       
/* 526 */       float f = 64.0F + label2.getHeight();
/*     */       
/* 528 */       setTransform(false);
/* 529 */       setSize(780.0F, f);
/*     */       
/* 531 */       this.m = new Image((TextureRegion)Game.i.assetManager.getBlankWhiteTextureRegion());
/*     */       
/* 533 */       this.m.setSize(780.0F, f);
/* 534 */       addActor((Actor)this.m);
/*     */       
/* 536 */       setTouchable(Touchable.enabled);
/* 537 */       addListener((EventListener)new ClickListener(this, AbilitySelectionOverlay.this, param1AbilityType)
/*     */           {
/*     */             public void enter(InputEvent param2InputEvent, float param2Float1, float param2Float2, int param2Int, Actor param2Actor) {
/* 540 */               super.enter(param2InputEvent, param2Float1, param2Float2, param2Int, param2Actor);
/*     */               
/* 542 */               AbilitySelectionOverlay.AbilityListItem.a(this.b, isOver());
/* 543 */               AbilitySelectionOverlay.AbilityListItem.a(this.b);
/*     */             }
/*     */ 
/*     */             
/*     */             public void exit(InputEvent param2InputEvent, float param2Float1, float param2Float2, int param2Int, Actor param2Actor) {
/* 548 */               super.exit(param2InputEvent, param2Float1, param2Float2, param2Int, param2Actor);
/*     */               
/* 550 */               AbilitySelectionOverlay.AbilityListItem.a(this.b, isOver());
/* 551 */               AbilitySelectionOverlay.AbilityListItem.a(this.b);
/*     */             }
/*     */ 
/*     */             
/*     */             public void clicked(InputEvent param2InputEvent, float param2Float1, float param2Float2) {
/* 556 */               this.b.k.setSelectedSlotAbilityType(this.a);
/*     */             }
/*     */           });
/*     */       
/* 560 */       this.n = new Image((TextureRegion)Game.i.assetManager.getBlankWhiteTextureRegion());
/* 561 */       this.n.setColor(MaterialColor.GREEN.P500);
/* 562 */       this.n.setSize(6.0F, f);
/* 563 */       addActor((Actor)this.n);
/*     */       
/*     */       Image image;
/* 566 */       (image = new Image((Drawable)factory.getIconDrawable())).setColor(factory.getColor());
/* 567 */       image.setSize(64.0F, 64.0F);
/* 568 */       image.setPosition(22.0F, f - 80.0F);
/* 569 */       addActor((Actor)image);
/*     */       
/*     */       Label label1;
/* 572 */       (label1 = new Label(factory.getTitle(), new Label.LabelStyle((BitmapFont)Game.i.assetManager.getFont(30), Color.WHITE))).setColor(factory.getColor());
/* 573 */       label1.setPosition(96.0F, f - 53.0F);
/* 574 */       addActor((Actor)label1);
/*     */       
/* 576 */       addActor((Actor)label2);
/*     */       
/*     */       Table table;
/* 579 */       (table = new Table()).setSize(64.0F, 64.0F);
/* 580 */       table.setPosition(450.0F, f - 64.0F);
/* 581 */       addActor((Actor)table);
/*     */       
/* 583 */       this.o = new Label("", new Label.LabelStyle((BitmapFont)Game.i.assetManager.getFont(36), Color.WHITE));
/* 584 */       table.add((Actor)this.o);
/*     */       
/* 586 */       this.p = new Label("", new Label.LabelStyle((BitmapFont)Game.i.assetManager.getFont(24), Color.WHITE));
/* 587 */       this.p.setColor(1.0F, 1.0F, 1.0F, 0.56F);
/* 588 */       table.add((Actor)this.p);
/*     */       
/*     */       QuadActor quadActor;
/* 591 */       (quadActor = new QuadActor(new Color(0.0F, 0.0F, 0.0F, 0.14F), new float[] { 0.0F, 0.0F, 16.0F, f, 156.0F, f, 140.0F, 0.0F })).setPosition(540.0F, 0.0F);
/* 592 */       addActor((Actor)quadActor);
/*     */       
/* 594 */       this.s = new Table();
/* 595 */       this.s.setSize(124.0F, f);
/* 596 */       this.s.setPosition(557.0F, 0.0F);
/* 597 */       addActor((Actor)this.s);
/*     */       
/* 599 */       this.q = new ComplexButton("", new Label.LabelStyle((BitmapFont)Game.i.assetManager.getFont(24), Color.WHITE), () -> {
/*     */             if (Game.i.progressManager.getAbilities(param1AbilityType) >= Game.i.gameValueManager.getSnapshot().getIntValue(Game.i.abilityManager.getMaxPerGameGameValueType(param1AbilityType)))
/*     */               return;  int i = Game.i.progressManager.getAbilities(param1AbilityType); if (Game.i.progressManager.getGreenPapers() < param1Factory.getPriceInGreenPapers(i)) {
/*     */               Dialog.i().showAlert(Game.i.localeManager.i18n.get("not_enough_green_papers"));
/*     */               return;
/*     */             } 
/*     */             ResourceType[] arrayOfResourceType;
/*     */             int j = (arrayOfResourceType = ResourceType.values).length;
/*     */             byte b;
/*     */             for (b = 0; b < j; b++) {
/*     */               ResourceType resourceType = arrayOfResourceType[b];
/*     */               if (Game.i.progressManager.getResources(resourceType) < param1Factory.getPriceInResources(resourceType, i)) {
/*     */                 Dialog.i().showAlert(Game.i.localeManager.i18n.get("not_enough_resources"));
/*     */                 return;
/*     */               } 
/*     */             } 
/*     */             Game.i.progressManager.addAbilities(param1AbilityType, 1);
/*     */             Game.i.progressManager.removeGreenPapers(param1Factory.getPriceInGreenPapers(i));
/*     */             j = (arrayOfResourceType = ResourceType.values).length;
/*     */             for (b = 0; b < j; b++) {
/*     */               ResourceType resourceType = arrayOfResourceType[b];
/*     */               Game.i.progressManager.removeResources(resourceType, param1Factory.getPriceInResources(resourceType, i));
/*     */             } 
/*     */             this.k.update();
/*     */           });
/* 624 */       this.q.setSize(100.0F, f);
/* 625 */       this.q.setPosition(680.0F, 0.0F);
/* 626 */       this.q.setBackground((Drawable)new QuadDrawable(new QuadActor(Color.WHITE, new float[] { 0.0F, 0.0F, 16.0F, f, 100.0F, f, 100.0F, 0.0F })), 0.0F, 0.0F, 100.0F, f);
/* 627 */       this.q.setIconPositioned((Drawable)Game.i.assetManager.getDrawable("icon-plus"), 30.0F, f * 0.5F - 24.0F, 48.0F, 48.0F);
/* 628 */       addActor((Actor)this.q);
/*     */       
/* 630 */       this.r = new Label("MAX", new Label.LabelStyle((BitmapFont)Game.i.assetManager.getFont(24), Color.WHITE));
/* 631 */       this.r.setPosition(680.0F, 0.0F);
/* 632 */       this.r.setSize(100.0F, f);
/* 633 */       this.r.setAlignment(1);
/* 634 */       addActor((Actor)this.r);
/*     */       
/* 636 */       d();
/* 637 */       update();
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     private void d() {
/* 643 */       if (this.t && AbilitySelectionOverlay.b(this.k) != -1) {
/* 644 */         this.m.setColor(0.0F, 0.0F, 0.0F, 0.42F); return;
/*     */       } 
/* 646 */       this.m.setColor(0.0F, 0.0F, 0.0F, 0.21F);
/*     */     }
/*     */ 
/*     */     
/*     */     public void update() {
/* 651 */       int i = Game.i.gameValueManager.getSnapshot().getIntValue(Game.i.abilityManager.getMaxPerGameGameValueType(this.l));
/* 652 */       int j = Game.i.progressManager.getAbilities(this.l);
/*     */       
/* 654 */       this.o.setText(String.valueOf(j));
/* 655 */       this.p.setText("  / " + i);
/*     */       
/* 657 */       this.s.clearChildren();
/*     */       
/* 659 */       if (j >= i) {
/*     */         
/* 661 */         this.r.setVisible(true);
/* 662 */         this.q.setVisible(false);
/*     */       } else {
/*     */         
/* 665 */         i = 1;
/*     */         Ability.Factory factory;
/* 667 */         if ((factory = Game.i.abilityManager.getFactory(this.l)).getPriceInGreenPapers(j) > Game.i.progressManager.getGreenPapers()) {
/*     */           
/* 669 */           i = 0;
/*     */         } else {
/* 671 */           ResourceType[] arrayOfResourceType1; int n; byte b2; for (n = (arrayOfResourceType1 = ResourceType.values).length, b2 = 0; b2 < n; ) { ResourceType resourceType = arrayOfResourceType1[b2];
/* 672 */             if (Game.i.progressManager.getResources(resourceType) < factory.getPriceInResources(resourceType, j)) {
/* 673 */               i = 0;
/*     */               break;
/*     */             } 
/*     */             b2++; }
/*     */         
/*     */         } 
/* 679 */         if (i != 0) {
/* 680 */           this.q.setBackgroundColors(MaterialColor.GREEN.P800, MaterialColor.GREEN.P900, MaterialColor.GREEN.P600, Color.WHITE);
/*     */         } else {
/* 682 */           this.q.setBackgroundColors(MaterialColor.RED.P800, MaterialColor.RED.P900, MaterialColor.RED.P600, Color.WHITE);
/*     */         } 
/*     */         
/* 685 */         if (factory.getPriceInGreenPapers(j) != 0) {
/* 686 */           Image image = new Image((Drawable)Game.i.assetManager.getDrawable("icon-money"));
/* 687 */           this.s.add((Actor)image).size(32.0F).padRight(6.0F).padBottom(4.0F);
/* 688 */           Label label = new Label(String.valueOf(factory.getPriceInGreenPapers(j)), new Label.LabelStyle((BitmapFont)Game.i.assetManager.getFont(24), Color.WHITE));
/* 689 */           this.s.add((Actor)label).padBottom(4.0F).row();
/*     */         }  ResourceType[] arrayOfResourceType; int m; byte b1;
/* 691 */         for (m = (arrayOfResourceType = ResourceType.values).length, b1 = 0; b1 < m; ) { ResourceType resourceType = arrayOfResourceType[b1];
/* 692 */           if (factory.getPriceInResources(resourceType, j) != 0) {
/*     */             Image image;
/* 694 */             (image = new Image((Drawable)Game.i.assetManager.getDrawable(Resource.TEXTURE_REGION_NAMES[resourceType.ordinal()]))).setColor(Game.i.resourceManager.getColor(resourceType));
/* 695 */             this.s.add((Actor)image).size(32.0F).padRight(6.0F).padBottom(4.0F);
/* 696 */             Label label = new Label(String.valueOf(factory.getPriceInResources(resourceType, j)), new Label.LabelStyle((BitmapFont)Game.i.assetManager.getFont(24), Color.WHITE));
/* 697 */             this.s.add((Actor)label).padBottom(4.0F).row();
/*     */           } 
/*     */           b1++; }
/*     */         
/* 701 */         this.r.setVisible(false);
/* 702 */         this.q.setVisible(true);
/*     */       } 
/*     */ 
/*     */       
/* 706 */       this.n.setVisible(false); AbilitySlotButton[] arrayOfAbilitySlotButton; int k; byte b;
/* 707 */       for (k = (arrayOfAbilitySlotButton = AbilitySelectionOverlay.c(this.k)).length, b = 0; b < k; b++) {
/* 708 */         AbilitySlotButton abilitySlotButton; if ((abilitySlotButton = arrayOfAbilitySlotButton[b]).getAbility() == this.l) {
/* 709 */           this.n.setVisible(true);
/*     */           return;
/*     */         } 
/*     */       } 
/*     */     }
/*     */   }
/*     */   
/*     */   @REGS
/*     */   public static class SelectedAbilitiesConfiguration implements KryoSerializable {
/* 718 */     public AbilityType[] slots = new AbilityType[6];
/* 719 */     public int[] counts = new int[6];
/*     */ 
/*     */     
/*     */     public void write(Kryo param1Kryo, Output param1Output) {
/* 723 */       param1Kryo.writeObject(param1Output, this.slots);
/* 724 */       param1Kryo.writeObject(param1Output, this.counts);
/*     */     }
/*     */ 
/*     */     
/*     */     public void read(Kryo param1Kryo, Input param1Input) {
/* 729 */       this.slots = (AbilityType[])param1Kryo.readObject(param1Input, AbilityType[].class);
/* 730 */       this.counts = (int[])param1Kryo.readObject(param1Input, int[].class);
/*     */     }
/*     */     
/*     */     public SelectedAbilitiesConfiguration() {}
/*     */     
/*     */     public SelectedAbilitiesConfiguration(SelectedAbilitiesConfiguration param1SelectedAbilitiesConfiguration) {
/* 736 */       if (param1SelectedAbilitiesConfiguration != null) {
/* 737 */         for (byte b = 0; b < this.slots.length; b++) {
/* 738 */           this.slots[b] = param1SelectedAbilitiesConfiguration.slots[b];
/* 739 */           this.counts[b] = param1SelectedAbilitiesConfiguration.counts[b];
/*     */         } 
/*     */       }
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public int getSlot(AbilityType param1AbilityType) {
/* 749 */       Preconditions.checkNotNull(param1AbilityType);
/* 750 */       for (byte b = 0; b < this.slots.length; b++) {
/* 751 */         if (this.slots[b] == param1AbilityType) {
/* 752 */           return b;
/*     */         }
/*     */       } 
/*     */       
/* 756 */       return -1;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public void toJson(Json param1Json) {
/* 763 */       for (byte b = 0; b < 6; b++) {
/* 764 */         param1Json.writeObjectStart();
/* 765 */         if (this.slots[b] != null) {
/* 766 */           param1Json.writeValue("type", this.slots[b].name());
/* 767 */           param1Json.writeValue("count", Integer.valueOf(this.counts[b]));
/*     */         } 
/* 769 */         param1Json.writeObjectEnd();
/*     */       } 
/*     */     }
/*     */     
/*     */     public static SelectedAbilitiesConfiguration fromJson(JsonValue param1JsonValue) {
/* 774 */       SelectedAbilitiesConfiguration selectedAbilitiesConfiguration = new SelectedAbilitiesConfiguration();
/*     */       
/* 776 */       byte b = 0;
/* 777 */       for (JsonValue.JsonIterator<JsonValue> jsonIterator = param1JsonValue.iterator(); jsonIterator.hasNext(); ) {
/* 778 */         JsonValue jsonValue; if ((jsonValue = jsonIterator.next()).get("type") != null) {
/*     */           try {
/* 780 */             selectedAbilitiesConfiguration.slots[b] = AbilityType.valueOf(jsonValue.getString("type"));
/* 781 */             selectedAbilitiesConfiguration.counts[b] = jsonValue.getInt("count");
/* 782 */           } catch (Exception exception) {
/* 783 */             AbilitySelectionOverlay.a().e("failed to load configuration slot " + b, new Object[] { exception });
/*     */           } 
/*     */         }
/* 786 */         b++;
/*     */       } 
/*     */       
/* 789 */       return selectedAbilitiesConfiguration;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi\\ui\shared\AbilitySelectionOverlay.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */