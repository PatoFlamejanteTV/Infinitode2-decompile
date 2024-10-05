/*     */ package com.prineside.tdi2.ui.components;
/*     */ import com.badlogic.gdx.graphics.Color;
/*     */ import com.badlogic.gdx.utils.StringBuilder;
/*     */ import com.prineside.tdi2.Game;
/*     */ import com.prineside.tdi2.GameSystemProvider;
/*     */ import com.prineside.tdi2.GameValueProvider;
/*     */ import com.prineside.tdi2.enums.AbilityType;
/*     */ import com.prineside.tdi2.enums.StaticSoundType;
/*     */ import com.prineside.tdi2.events.game.AbilitiesConfigChange;
/*     */ import com.prineside.tdi2.events.game.AbilityUseStart;
/*     */ import com.prineside.tdi2.events.game.AbilityUseStop;
/*     */ import com.prineside.tdi2.events.game.GameValuesRecalculate;
/*     */ import com.prineside.tdi2.managers.SettingsManager;
/*     */ import com.prineside.tdi2.managers.UiManager;
/*     */ import com.prineside.tdi2.scene2d.Action;
/*     */ import com.prineside.tdi2.scene2d.Actor;
/*     */ import com.prineside.tdi2.scene2d.Group;
/*     */ import com.prineside.tdi2.scene2d.InputEvent;
/*     */ import com.prineside.tdi2.scene2d.Touchable;
/*     */ import com.prineside.tdi2.scene2d.actions.Actions;
/*     */ import com.prineside.tdi2.scene2d.ui.Image;
/*     */ import com.prineside.tdi2.scene2d.utils.ClickListener;
/*     */ import com.prineside.tdi2.scene2d.utils.Drawable;
/*     */ import com.prineside.tdi2.ui.actors.AbilitySlotButton;
/*     */ import com.prineside.tdi2.ui.actors.HotKeyHintLabel;
/*     */ import com.prineside.tdi2.ui.actors.Label;
/*     */ import com.prineside.tdi2.ui.actors.QuadActor;
/*     */ import com.prineside.tdi2.utils.MaterialColor;
/*     */ 
/*     */ public class AbilityMenu implements Disposable {
/*  31 */   private final UiManager.UiLayer a = Game.i.uiManager.addLayer(UiManager.MainUiLayer.SCREEN, 101, "AbilityMenu");
/*     */ 
/*     */ 
/*     */   
/*  35 */   private final AbilitySlotButton[] b = new AbilitySlotButton[6];
/*     */   private final Label c;
/*     */   private final Group d;
/*     */   private final Label e;
/*     */   private final Label f;
/*  40 */   private final Image[] g = new Image[10];
/*     */   
/*     */   private final GameSystemProvider h;
/*     */   private boolean i;
/*  44 */   private int j = -1;
/*  45 */   private int k = -1;
/*     */   
/*  47 */   private static final StringBuilder l = new StringBuilder();
/*     */   
/*  49 */   private final Runnable m = this::update;
/*     */   
/*     */   public AbilityMenu(GameSystemProvider paramGameSystemProvider) {
/*  52 */     this.h = paramGameSystemProvider;
/*     */     
/*  54 */     paramGameSystemProvider.events.getListeners(AbilitiesConfigChange.class).add(paramAbilitiesConfigChange -> Game.i.uiManager.runOnStageActOnce(this.m));
/*  55 */     paramGameSystemProvider.events.getListeners(AbilityUseStart.class).add(paramAbilityUseStart -> Game.i.uiManager.runOnStageActOnce(this.m));
/*  56 */     paramGameSystemProvider.events.getListeners(AbilityUseStop.class).add(paramAbilityUseStop -> Game.i.uiManager.runOnStageActOnce(this.m));
/*  57 */     paramGameSystemProvider.events.getListeners(GameValuesRecalculate.class).add(paramGameValuesRecalculate -> Game.i.uiManager.runOnStageActOnce(this.m));
/*     */     
/*     */     Group group;
/*  60 */     (group = new Group()).setTransform(false);
/*     */     
/*  62 */     this.a.getTable().add((Actor)group).expand().bottom().left().padBottom(192.0F).padLeft(32.0F).size(234.0F, 381.0F);
/*     */ 
/*     */     
/*  65 */     this.c = new Label("", Game.i.assetManager.getLabelStyle(24));
/*  66 */     this.c.setPosition(250.0F, 10.0F);
/*  67 */     this.c.setWrap(true);
/*  68 */     this.c.setSize(256.0F, 100.0F);
/*  69 */     group.addActor((Actor)this.c);
/*  70 */     this.c.setVisible(false);
/*     */ 
/*     */     
/*  73 */     this.d = new Group();
/*  74 */     this.d.setTransform(false);
/*  75 */     this.d.setTouchable(Touchable.childrenOnly);
/*  76 */     this.d.setSize(250.0F, 68.0F);
/*  77 */     this.d.setPosition(0.0F, 386.0F);
/*  78 */     group.addActor((Actor)this.d);
/*     */     
/*     */     Image image;
/*  81 */     (image = new Image((Drawable)Game.i.assetManager.getDrawable("icon-lightning-bolt"))).setSize(48.0F, 48.0F);
/*  82 */     image.setPosition(7.0F, 2.0F);
/*  83 */     image.setColor(0.0F, 0.0F, 0.0F, 0.28F);
/*  84 */     this.d.addActor((Actor)image);
/*     */ 
/*     */     
/*  87 */     (image = new Image((Drawable)Game.i.assetManager.getDrawable("icon-lightning-bolt"))).setSize(48.0F, 48.0F);
/*  88 */     image.setPosition(-3.0F, 12.0F);
/*  89 */     image.setColor(MaterialColor.CYAN.P300);
/*  90 */     this.d.addActor((Actor)image);
/*     */ 
/*     */ 
/*     */     
/*     */     QuadActor quadActor;
/*     */ 
/*     */ 
/*     */     
/*  98 */     (quadActor = new QuadActor(new Color(0.0F, 0.0F, 0.0F, 0.28F), new float[] { 0.0F, 14.0F, 0.0F, 32.0F, 178.0F, 17.0F, 178.0F, 0.0F })).setPosition(56.0F, 0.0F);
/*  99 */     this.d.addActor((Actor)quadActor);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 107 */     (quadActor = new QuadActor(MaterialColor.CYAN.P900.cpy().mul(0.75F, 0.75F, 0.75F, 1.0F), new float[] { 0.0F, 14.0F, 0.0F, 32.0F, 178.0F, 17.0F, 178.0F, 0.0F })).setPosition(46.0F, 10.0F);
/* 108 */     this.d.addActor((Actor)quadActor);
/*     */     
/* 110 */     this.e = new Label("", Game.i.assetManager.getLabelStyle(24));
/* 111 */     this.e.setPosition(240.0F, 10.0F);
/* 112 */     this.e.setSize(40.0F, 17.0F);
/* 113 */     this.e.setColor(MaterialColor.CYAN.P300);
/* 114 */     this.d.addActor((Actor)this.e);
/*     */     
/* 116 */     this.f = new Label("", Game.i.assetManager.getLabelStyle(21));
/* 117 */     this.f.setPosition(195.0F, 37.0F);
/* 118 */     this.f.setSize(40.0F, 17.0F);
/* 119 */     this.f.setColor(1.0F, 1.0F, 1.0F, 0.56F);
/* 120 */     this.d.addActor((Actor)this.f);
/*     */     byte b;
/* 122 */     for (b = 0; b < 10; b++) {
/* 123 */       this.g[b] = new Image((Drawable)Game.i.assetManager.getDrawable("ui-ability-energy-bar"));
/* 124 */       this.g[b].setPosition(0.0F + b * 18.0F + 46.0F, 13.0F - b * 15.0F / 10.0F + 396.0F - 386.0F);
/* 125 */       this.g[b].setSize(16.0F, 19.0F);
/* 126 */       this.d.addActor((Actor)this.g[b]);
/*     */     } 
/*     */ 
/*     */     
/* 130 */     for (b = 0; b < 6; b++) {
/* 131 */       this.b[b] = new AbilitySlotButton(false, (GameValueProvider)paramGameSystemProvider.gameValue);
/* 132 */       this.b[b].setPosition((b % 2) * 128.0F, 0.0F + (b / 2) * 128.0F + (1 - b % 2) * 10.0F);
/* 133 */       group.addActor((Actor)this.b[b]);
/*     */       
/* 135 */       if (HotKeyHintLabel.isEnabled()) {
/* 136 */         SettingsManager.HotkeyAction hotkeyAction = SettingsManager.HotkeyAction.ABILITY_1;
/* 137 */         switch (b) { case 0:
/* 138 */             hotkeyAction = SettingsManager.HotkeyAction.ABILITY_1; break;
/* 139 */           case 1: hotkeyAction = SettingsManager.HotkeyAction.ABILITY_2; break;
/* 140 */           case 2: hotkeyAction = SettingsManager.HotkeyAction.ABILITY_3; break;
/* 141 */           case 3: hotkeyAction = SettingsManager.HotkeyAction.ABILITY_4; break;
/* 142 */           case 4: hotkeyAction = SettingsManager.HotkeyAction.ABILITY_5; break;
/* 143 */           case 5: hotkeyAction = SettingsManager.HotkeyAction.ABILITY_6;
/*     */             break; }
/*     */         
/* 146 */         HotKeyHintLabel hotKeyHintLabel = new HotKeyHintLabel(Game.i.settingsManager.getHotKey(hotkeyAction), 12.0F, 91.0F);
/* 147 */         this.b[b].addActor((Actor)hotKeyHintLabel);
/*     */       } 
/*     */       
/* 150 */       byte b1 = b;
/* 151 */       this.b[b].addListener((EventListener)new ClickListener(this, b1, paramGameSystemProvider)
/*     */           {
/*     */             public void clicked(InputEvent param1InputEvent, float param1Float1, float param1Float2) {
/* 154 */               if (AbilityMenu.a(this.c)[this.a].isSelected()) {
/* 155 */                 this.b.ability.cancelUsingAbility();
/*     */               } else {
/* 157 */                 this.b.ability.startUsingAbility(AbilityMenu.a(this.c)[this.a].getAbility());
/*     */               } 
/* 159 */               this.b._sound.playStatic(StaticSoundType.BUTTON);
/*     */             }
/*     */           });
/*     */     } 
/*     */     
/* 164 */     if (paramGameSystemProvider.gameState.startingAbilitiesConfiguration == null) {
/*     */ 
/*     */       
/* 167 */       setVisible(false);
/*     */       return;
/*     */     } 
/* 170 */     setVisible(true);
/*     */   }
/*     */ 
/*     */   
/*     */   private void a() {
/* 175 */     int i = this.h.ability.getEnergy();
/*     */     
/* 177 */     if (this.j != i) {
/* 178 */       l.setLength(0);
/* 179 */       l.append('x').append(i);
/* 180 */       this.e.setText((CharSequence)l);
/* 181 */       this.j = i;
/*     */       
/* 183 */       int j = this.h.ability.getMaxEnergy();
/* 184 */       for (byte b1 = 0; b1 < this.g.length; b1++) {
/* 185 */         if (b1 + 1 <= i) {
/*     */           
/* 187 */           this.g[b1].setVisible(true);
/* 188 */           this.g[b1].setColor(Color.WHITE);
/*     */         
/*     */         }
/* 191 */         else if (b1 + 1 > j) {
/*     */           
/* 193 */           this.g[b1].setColor(0.0F, 0.0F, 0.0F, 0.28F);
/* 194 */           this.g[b1].setVisible(true);
/*     */         } else {
/*     */           
/* 197 */           this.g[b1].setVisible(false);
/*     */         } 
/*     */       } 
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/* 204 */     if (i < this.h.ability.getMaxEnergy()) {
/* 205 */       int j = MathUtils.ceil(this.h.ability.getEnergyRegenerationTime() - this.h.ability.getNextEnergyGenerationTime());
/* 206 */       if (this.k != j) {
/* 207 */         l.setLength(0);
/* 208 */         l.append(j).append('s');
/* 209 */         this.f.setText((CharSequence)l);
/* 210 */         this.f.setVisible(true);
/* 211 */         this.k = j;
/*     */       } 
/*     */     } else {
/* 214 */       this.f.setVisible(false);
/*     */     } 
/*     */     
/* 217 */     float f = i + this.h.ability.getNextEnergyGenerationTime() / this.h.ability.getEnergyRegenerationTime(); AbilitySlotButton[] arrayOfAbilitySlotButton;
/*     */     byte b;
/* 219 */     for (i = (arrayOfAbilitySlotButton = this.b).length, b = 0; b < i; b++) {
/* 220 */       AbilitySlotButton abilitySlotButton; if ((abilitySlotButton = arrayOfAbilitySlotButton[b]).getGameEnergy() != f) {
/* 221 */         abilitySlotButton.setGameEnergy(f);
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void update() {
/* 230 */     if (this.h.ability.abilitiesConfiguration == null)
/*     */       return; 
/* 232 */     boolean bool1 = false;
/* 233 */     for (byte b1 = 0; b1 < this.b.length; b1++) {
/* 234 */       AbilitySlotButton abilitySlotButton = this.b[b1];
/* 235 */       AbilityType abilityType = this.h.ability.abilitiesConfiguration.slots[b1];
/* 236 */       int j = this.h.ability.getAvailableAbilities(b1);
/* 237 */       boolean bool = (abilityType == null) ? false : this.h.ability.getEnergyCost(abilityType);
/*     */       
/* 239 */       if (abilityType != null) {
/* 240 */         bool1 = true;
/*     */       }
/*     */       
/* 243 */       if (abilitySlotButton.getAbility() != abilityType) {
/* 244 */         abilitySlotButton.setAbility(abilityType);
/*     */       }
/* 246 */       if (abilitySlotButton.getCount() != j) {
/* 247 */         abilitySlotButton.setCount(j);
/*     */       }
/*     */       
/* 250 */       if (abilityType == null || j <= 0) {
/* 251 */         abilitySlotButton.setTouchable(Touchable.disabled);
/*     */       } else {
/* 253 */         abilitySlotButton.setTouchable(Touchable.enabled);
/*     */       } 
/*     */       
/* 256 */       if (abilitySlotButton.getEnergyCost() != bool) {
/* 257 */         abilitySlotButton.update();
/*     */       }
/*     */     } 
/*     */     
/* 261 */     this.d.setVisible(bool1); AbilitySlotButton[] arrayOfAbilitySlotButton;
/*     */     int i;
/*     */     byte b2;
/* 264 */     for (i = (arrayOfAbilitySlotButton = this.b).length, b2 = 0; b2 < i; b2++) {
/* 265 */       AbilitySlotButton abilitySlotButton; (abilitySlotButton = arrayOfAbilitySlotButton[b2]).setSelected(false);
/*     */     } 
/*     */     
/* 268 */     boolean bool2 = false;
/* 269 */     if (this.h.ability.getUiCurrentlyUsingAbility() != null && (
/*     */       
/* 271 */       i = this.h.ability.abilitiesConfiguration.getSlot(this.h.ability.getUiCurrentlyUsingAbility())) != -1) {
/* 272 */       this.b[i].setSelected(true);
/* 273 */       bool2 = true;
/*     */     } 
/*     */ 
/*     */     
/* 277 */     if (bool2) {
/* 278 */       if (Game.i.abilityManager.getFactory(this.h.ability.getUiCurrentlyUsingAbility()).requiresMapPointing()) {
/* 279 */         this.c.setText(Game.i.localeManager.i18n.get("ability_menu_select_point_to_apply"));
/*     */       } else {
/* 281 */         this.c.setText(Game.i.localeManager.i18n.get("ability_menu_tap_map_to_apply"));
/*     */       } 
/* 283 */       this.c.clearActions();
/* 284 */       this.c.setVisible(true);
/* 285 */       this.c.addAction((Action)Actions.alpha(1.0F, 0.3F));
/*     */     } else {
/* 287 */       this.c.clearActions();
/* 288 */       this.c.addAction((Action)Actions.sequence(
/* 289 */             (Action)Actions.alpha(0.0F, 0.3F), 
/* 290 */             (Action)Actions.hide()));
/*     */     } 
/*     */     
/* 293 */     a();
/* 294 */     this.i = true;
/*     */   }
/*     */   
/*     */   public void draw(float paramFloat) {
/* 298 */     if (!this.i) {
/* 299 */       update();
/*     */     }
/* 301 */     a();
/*     */   }
/*     */   
/*     */   public void finalFadeOut() {
/* 305 */     this.a.getTable().setTouchable(Touchable.disabled);
/* 306 */     this.a.getTable().clearActions();
/* 307 */     this.a.getTable().addAction((Action)Actions.alpha(0.0F, 1.0F));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setVisible(boolean paramBoolean) {
/* 313 */     this.a.getTable().setVisible(paramBoolean);
/*     */   }
/*     */ 
/*     */   
/*     */   public void dispose() {
/* 318 */     Game.i.uiManager.removeLayer(this.a);
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi\\ui\components\AbilityMenu.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */