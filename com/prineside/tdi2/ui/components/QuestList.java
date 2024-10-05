/*     */ package com.prineside.tdi2.ui.components;
/*     */ 
/*     */ import com.badlogic.gdx.graphics.Color;
/*     */ import com.badlogic.gdx.graphics.g2d.BitmapFont;
/*     */ import com.badlogic.gdx.math.Interpolation;
/*     */ import com.badlogic.gdx.utils.Array;
/*     */ import com.badlogic.gdx.utils.Disposable;
/*     */ import com.badlogic.gdx.utils.SnapshotArray;
/*     */ import com.badlogic.gdx.utils.StringBuilder;
/*     */ import com.prineside.tdi2.Game;
/*     */ import com.prineside.tdi2.managers.SettingsManager;
/*     */ import com.prineside.tdi2.managers.UiManager;
/*     */ import com.prineside.tdi2.scene2d.Action;
/*     */ import com.prineside.tdi2.scene2d.Actor;
/*     */ import com.prineside.tdi2.scene2d.EventListener;
/*     */ import com.prineside.tdi2.scene2d.Group;
/*     */ import com.prineside.tdi2.scene2d.InputEvent;
/*     */ import com.prineside.tdi2.scene2d.Touchable;
/*     */ import com.prineside.tdi2.scene2d.actions.Actions;
/*     */ import com.prineside.tdi2.scene2d.ui.Image;
/*     */ import com.prineside.tdi2.scene2d.utils.ClickListener;
/*     */ import com.prineside.tdi2.scene2d.utils.Drawable;
/*     */ import com.prineside.tdi2.ui.actors.HotKeyHintLabel;
/*     */ import com.prineside.tdi2.ui.actors.Label;
/*     */ 
/*     */ public class QuestList
/*     */   implements Disposable {
/*  28 */   private final UiManager.UiLayer a = Game.i.uiManager.addLayer(UiManager.MainUiLayer.SCREEN, 101, "QuestList");
/*     */   
/*     */   public static final float LIST_ITEM_HEIGHT = 44.0F;
/*     */   
/*     */   public static final float LIST_ITEM_HEIGHT_COMPACT = 40.0F;
/*     */   
/*     */   private Image b;
/*     */   private Image c;
/*     */   private Group d;
/*     */   private Label e;
/*     */   private boolean f;
/*  39 */   private Array<QuestListItem> g = new Array();
/*     */   
/*  41 */   private static final StringBuilder h = new StringBuilder();
/*     */   
/*     */   public QuestList() {
/*     */     Group group;
/*  45 */     (group = new Group()).setTransform(false);
/*     */     
/*  47 */     this.a.getTable().add((Actor)group).expand().top().left().padTop(175.0F).size(563.0F, 280.0F);
/*     */ 
/*     */     
/*  50 */     this.b = new Image((Drawable)Game.i.assetManager.getDrawable("ui-quest-list-background"));
/*  51 */     this.b.setSize(683.0F, 258.0F);
/*  52 */     this.b.setPosition(-120.0F, 22.0F);
/*  53 */     this.b.setTouchable(Touchable.disabled);
/*  54 */     group.addActor((Actor)this.b);
/*     */     
/*  56 */     this.d = new Group();
/*  57 */     this.d.setTransform(false);
/*  58 */     this.d.setTouchable(Touchable.disabled);
/*  59 */     this.d.setSize(563.0F, 280.0F);
/*  60 */     this.d.setOrigin(0.0F, 140.0F);
/*  61 */     group.addActor((Actor)this.d);
/*     */     
/*     */     Image image;
/*     */     
/*  65 */     (image = new Image((Drawable)Game.i.assetManager.getDrawable("ui-quest-list-title-background"))).setSize(488.0F, 64.0F);
/*  66 */     image.setPosition(-120.0F, 216.0F);
/*  67 */     image.setTouchable(Touchable.enabled);
/*  68 */     image.addListener((EventListener)new ClickListener(this)
/*     */         {
/*     */           public void clicked(InputEvent param1InputEvent, float param1Float1, float param1Float2) {
/*  71 */             this.a.setVisible(!QuestList.a(this.a));
/*     */           }
/*     */         });
/*  74 */     group.addActor((Actor)image);
/*     */     
/*  76 */     this.c = new Image((Drawable)Game.i.assetManager.getDrawable("icon-triangle-bottom"));
/*  77 */     this.c.setColor(1.0F, 1.0F, 1.0F, 0.56F);
/*  78 */     this.c.setSize(32.0F, 32.0F);
/*  79 */     this.c.setPosition(48.0F, 232.0F);
/*  80 */     this.c.setTouchable(Touchable.disabled);
/*  81 */     group.addActor((Actor)this.c);
/*     */     
/*     */     Label label;
/*  84 */     (label = new Label(Game.i.localeManager.i18n.get("quests").toUpperCase(), new Label.LabelStyle((BitmapFont)Game.i.assetManager.getFont(30), Color.WHITE))).setColor(1.0F, 1.0F, 1.0F, 0.56F);
/*  85 */     label.setSize(368.0F, 64.0F);
/*  86 */     label.setAlignment(8);
/*  87 */     label.setPosition(106.0F, 216.0F);
/*  88 */     label.setTouchable(Touchable.disabled);
/*  89 */     group.addActor((Actor)label);
/*     */     
/*  91 */     this.e = new Label("1/3", new Label.LabelStyle((BitmapFont)Game.i.assetManager.getFont(30), Color.WHITE));
/*  92 */     this.e.setAlignment(16);
/*  93 */     this.e.setColor(1.0F, 1.0F, 1.0F, 0.56F);
/*  94 */     this.e.setSize(320.0F, 64.0F);
/*  95 */     this.e.setPosition(0.0F, 216.0F);
/*  96 */     this.e.setTouchable(Touchable.disabled);
/*  97 */     group.addActor((Actor)this.e);
/*     */     
/*  99 */     if (HotKeyHintLabel.isEnabled()) {
/* 100 */       group.addActor((Actor)new HotKeyHintLabel(Game.i.settingsManager.getHotKey(SettingsManager.HotkeyAction.TOGGLE_QUEST_LIST), 32.0F, 240.0F));
/*     */     }
/*     */     
/* 103 */     if (Game.i.settingsManager.getCustomValue(SettingsManager.CustomValueType.UI_QUEST_LIST_VISIBLE) == 1.0D) {
/* 104 */       this.f = false;
/* 105 */       setVisible(true);
/*     */     } else {
/* 107 */       this.f = true;
/* 108 */       setVisible(false);
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 118 */     Game.i.uiManager.runOnStageAct(() -> {
/*     */           try {
/*     */             b(); return;
/* 121 */           } catch (Exception exception) {
/*     */             return;
/*     */           } 
/*     */         });
/*     */   } public void finalFadeOut() {
/* 126 */     float f = Game.i.settingsManager.isUiAnimationsEnabled() ? 1.0F : 0.0F;
/*     */     
/* 128 */     this.a.getTable().setTouchable(Touchable.disabled);
/* 129 */     this.a.getTable().clearActions();
/* 130 */     this.a.getTable().addAction((Action)Actions.alpha(0.0F, f * 1.0F));
/*     */   }
/*     */   
/*     */   private void b() {
/* 134 */     SnapshotArray snapshotArray = this.d.getChildren();
/*     */     
/*     */     int i;
/* 137 */     for (byte b = 0; b < i; b++) {
/*     */       Actor actor;
/* 139 */       for (int j = ((actor = (Actor)snapshotArray.get(b)).getActions()).size - 1; j >= 0; j--) {
/*     */         Action action;
/* 141 */         if (action = (Action)actor.getActions().get(j) instanceof com.prineside.tdi2.scene2d.actions.AlphaAction || action instanceof com.prineside.tdi2.scene2d.actions.MoveToAction || action instanceof com.prineside.tdi2.scene2d.actions.DelayAction) {
/* 142 */           actor.removeAction(action);
/*     */         }
/*     */       } 
/*     */     } 
/*     */     
/* 147 */     float f = Game.i.settingsManager.isUiAnimationsEnabled() ? 1.0F : 0.0F;
/*     */     
/* 149 */     if (this.f) {
/*     */       
/* 151 */       float f1 = 162.0F; byte b1; int j;
/* 152 */       for (b1 = 0, j = ((Array)snapshotArray).size; b1 < j; b1++) {
/*     */         QuestListItem questListItem;
/* 154 */         if (!QuestListItem.a(questListItem = (QuestListItem)snapshotArray.get(b1))) {
/*     */           
/* 156 */           questListItem.setVisible(true);
/* 157 */           questListItem.clearActions();
/* 158 */           questListItem.addAction((Action)Actions.parallel(
/* 159 */                 (Action)Actions.alpha(1.0F, 0.2F * f), 
/* 160 */                 (Action)Actions.moveTo(0.0F, f1, 0.2F * f)));
/*     */ 
/*     */           
/* 163 */           if (((Array)snapshotArray).size <= 4) {
/* 164 */             f1 -= 44.0F;
/*     */           } else {
/* 166 */             f1 -= 40.0F;
/*     */           } 
/*     */         } 
/*     */       } 
/* 170 */       this.b.clearActions();
/* 171 */       this.b.addAction((Action)Actions.moveTo(-120.0F, 22.0F, 0.2F * f));
/*     */       
/* 173 */       this.d.clearActions();
/* 174 */       if (((Array)snapshotArray).size <= 4) {
/* 175 */         this.d.clearActions();
/* 176 */         this.d.addAction((Action)Actions.sequence(
/* 177 */               (Action)Actions.parallel(
/* 178 */                 (Action)Actions.scaleTo(1.0F, 1.0F, 0.3F * f), 
/* 179 */                 (Action)Actions.moveTo(0.0F, 0.0F, 0.3F * f)), 
/*     */               
/* 181 */               (Action)Actions.run(() -> this.d.setTransform(false))));
/*     */       
/*     */       }
/*     */       else {
/*     */         
/* 186 */         this.d.setTransform(true);
/* 187 */         this.d.clearActions();
/* 188 */         this.d.addAction((Action)Actions.parallel(
/* 189 */               (Action)Actions.scaleTo(0.87F, 0.87F, 0.3F * f), 
/* 190 */               (Action)Actions.moveTo(5.0F, 10.0F, 0.3F * f)));
/*     */       } 
/*     */ 
/*     */       
/* 194 */       this.c.setDrawable((Drawable)Game.i.assetManager.getDrawable("icon-triangle-bottom"));
/*     */     } else {
/*     */       int j;
/* 197 */       for (i = 0, j = ((Array)snapshotArray).size; i < j; i++) {
/*     */         QuestListItem questListItem;
/* 199 */         if (!QuestListItem.a(questListItem = (QuestListItem)snapshotArray.get(i))) {
/*     */           
/* 201 */           questListItem.setVisible(true);
/* 202 */           questListItem.clearActions();
/* 203 */           questListItem.addAction((Action)Actions.parallel(
/* 204 */                 (Action)Actions.alpha(0.0F, 0.2F * f), 
/* 205 */                 (Action)Actions.moveTo(0.0F, 232.0F, 0.2F * f), 
/* 206 */                 (Action)Actions.delay(0.2F * f, (Action)Actions.hide())));
/*     */         } 
/*     */       } 
/*     */       
/* 210 */       this.b.clearActions();
/* 211 */       this.b.addAction((Action)Actions.moveTo(-683.0F, 22.0F, 0.2F * f));
/*     */       
/* 213 */       this.c.setDrawable((Drawable)Game.i.assetManager.getDrawable("icon-triangle-right"));
/*     */     } 
/*     */     
/* 216 */     d();
/* 217 */     c();
/*     */   }
/*     */   
/*     */   private void c() {
/* 221 */     float f = Game.i.settingsManager.isUiAnimationsEnabled() ? 1.0F : 0.0F;
/*     */     
/* 223 */     if (this.g.size != 0) {
/*     */       
/* 225 */       this.a.getTable().clearActions();
/* 226 */       this.a.getTable().addAction((Action)Actions.sequence(
/* 227 */             (Action)Actions.show(), 
/* 228 */             (Action)Actions.alpha(1.0F, 0.3F * f)));
/*     */       
/*     */       return;
/*     */     } 
/* 232 */     this.a.getTable().clearActions();
/* 233 */     this.a.getTable().addAction((Action)Actions.sequence(
/* 234 */           (Action)Actions.alpha(0.0F, 0.3F * f), 
/* 235 */           (Action)Actions.hide()));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private void d() {
/* 241 */     if (this.g.size != 0) {
/* 242 */       byte b1 = 0;
/* 243 */       for (byte b2 = 0; b2 < this.g.size; b2++) {
/* 244 */         if (((QuestListItem)this.g.get(b2)).isCompleted()) {
/* 245 */           b1++;
/*     */         }
/*     */       } 
/* 248 */       this.e.setText(b1 + "/" + this.g.size);
/*     */       return;
/*     */     } 
/* 251 */     this.e.setText("");
/*     */   }
/*     */ 
/*     */   
/*     */   public QuestListItem addQuestListItem() {
/* 256 */     float f = Game.i.settingsManager.isUiAnimationsEnabled() ? 1.0F : 0.0F;
/*     */     
/* 258 */     QuestListItem questListItem = new QuestListItem((byte)0);
/* 259 */     this.d.addActorAt(0, (Actor)questListItem);
/* 260 */     questListItem.setPosition(0.0F, 162.0F);
/* 261 */     questListItem.setOrigin(8);
/* 262 */     questListItem.setTransform(true);
/* 263 */     questListItem.clearActions();
/* 264 */     questListItem.addAction((Action)Actions.sequence(
/* 265 */           (Action)Actions.scaleTo(0.5F, 0.5F), 
/* 266 */           (Action)Actions.scaleTo(1.25F, 1.25F, 0.2F * f), 
/* 267 */           (Action)Actions.scaleTo(1.0F, 1.0F, 0.2F * f), 
/* 268 */           (Action)Actions.run(() -> paramQuestListItem.setTransform(false))));
/*     */     
/* 270 */     this.g.add(questListItem);
/* 271 */     b();
/*     */     
/* 273 */     return questListItem;
/*     */   }
/*     */   
/*     */   public void removeQuestListItem(QuestListItem paramQuestListItem) {
/* 277 */     if (QuestListItem.a(paramQuestListItem))
/* 278 */       return;  float f = Game.i.settingsManager.isUiAnimationsEnabled() ? 1.0F : 0.0F;
/*     */     
/* 280 */     QuestListItem.a(paramQuestListItem, true);
/* 281 */     paramQuestListItem.clearActions();
/* 282 */     paramQuestListItem.addAction((Action)Actions.sequence(
/* 283 */           (Action)Actions.parallel(
/* 284 */             (Action)Actions.moveBy(-300.0F, 0.0F, 0.3F * f, Interpolation.circleIn), 
/* 285 */             (Action)Actions.alpha(0.0F, 0.25F * f)), 
/*     */           
/* 287 */           (Action)Actions.run(() -> {
/*     */               this.d.removeActor((Actor)paramQuestListItem);
/*     */               
/*     */               b();
/*     */             })));
/* 292 */     this.g.removeValue(paramQuestListItem, true);
/*     */   }
/*     */   
/*     */   public boolean isVisible() {
/* 296 */     return this.f;
/*     */   }
/*     */   
/*     */   public void setVisible(boolean paramBoolean) {
/* 300 */     this.f = paramBoolean;
/* 301 */     Game.i.settingsManager.setCustomValue(SettingsManager.CustomValueType.UI_QUEST_LIST_VISIBLE, paramBoolean ? 1.0D : 0.0D);
/* 302 */     b();
/*     */   }
/*     */ 
/*     */   
/*     */   public void dispose() {
/* 307 */     Game.i.uiManager.removeLayer(this.a);
/*     */   }
/*     */   
/*     */   public class QuestListItem
/*     */     extends Group {
/*     */     private Label k;
/*     */     private Image l;
/*     */     private boolean m;
/*     */     private boolean n;
/* 316 */     private StringBuilder o = new StringBuilder();
/* 317 */     private StringBuilder p = new StringBuilder();
/*     */     
/*     */     private QuestListItem(QuestList this$0) {
/* 320 */       setHeight(44.0F);
/*     */       
/* 322 */       this.l = new Image((Drawable)Game.i.assetManager.getDrawable("checkbox"));
/* 323 */       this.l.setPosition(40.0F, 2.0F);
/* 324 */       this.l.setSize(44.0F, 44.0F);
/* 325 */       addActor((Actor)this.l);
/*     */       
/* 327 */       this.k = new Label("", Game.i.assetManager.getLabelStyle(30));
/* 328 */       this.k.setSize(100.0F, 44.0F);
/* 329 */       this.k.setPosition(106.0F, 0.0F);
/* 330 */       addActor((Actor)this.k);
/*     */     }
/*     */     
/*     */     public void setTitlePrefix(CharSequence param1CharSequence) {
/* 334 */       this.o.setLength(0);
/* 335 */       this.o.append(param1CharSequence);
/*     */       
/* 337 */       setText((CharSequence)this.p);
/*     */     }
/*     */     
/*     */     public void setText(CharSequence param1CharSequence) {
/* 341 */       this.p.setLength(0);
/* 342 */       this.p.append(param1CharSequence);
/*     */       
/* 344 */       QuestList.a().setLength(0);
/* 345 */       QuestList.a().append(this.o).append(param1CharSequence);
/*     */       
/* 347 */       this.k.setText((CharSequence)QuestList.a());
/*     */     }
/*     */     
/*     */     public void setCompleted(boolean param1Boolean) {
/* 351 */       float f = Game.i.settingsManager.isUiAnimationsEnabled() ? 1.0F : 0.0F;
/*     */       
/* 353 */       if (param1Boolean) {
/* 354 */         this.l.setDrawable((Drawable)Game.i.assetManager.getDrawable("checkbox-checked"));
/*     */         
/* 356 */         if (!this.n) {
/* 357 */           setTransform(true);
/* 358 */           clearActions();
/* 359 */           addAction((Action)Actions.sequence(
/* 360 */                 (Action)Actions.scaleTo(1.25F, 1.25F, 0.2F * f), 
/* 361 */                 (Action)Actions.scaleTo(1.0F, 1.0F, 0.2F * f), 
/* 362 */                 (Action)Actions.run(() -> setTransform(false))));
/*     */         } 
/*     */       } else {
/*     */         
/* 366 */         this.l.setDrawable((Drawable)Game.i.assetManager.getDrawable("checkbox"));
/*     */       } 
/* 368 */       this.m = param1Boolean;
/* 369 */       QuestList.b(this.q);
/* 370 */       QuestList.c(this.q);
/*     */     }
/*     */     
/*     */     public boolean isCompleted() {
/* 374 */       return this.m;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi\\ui\components\QuestList.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */