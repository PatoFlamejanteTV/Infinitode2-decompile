/*     */ package com.prineside.tdi2.ui.shared;
/*     */ 
/*     */ import com.badlogic.gdx.graphics.Color;
/*     */ import com.badlogic.gdx.graphics.g2d.BitmapFont;
/*     */ import com.badlogic.gdx.math.Interpolation;
/*     */ import com.badlogic.gdx.math.MathUtils;
/*     */ import com.badlogic.gdx.utils.Array;
/*     */ import com.prineside.tdi2.Game;
/*     */ import com.prineside.tdi2.IssuedItems;
/*     */ import com.prineside.tdi2.ItemStack;
/*     */ import com.prineside.tdi2.enums.StaticSoundType;
/*     */ import com.prineside.tdi2.managers.UiManager;
/*     */ import com.prineside.tdi2.scene2d.Action;
/*     */ import com.prineside.tdi2.scene2d.Actor;
/*     */ import com.prineside.tdi2.scene2d.EventListener;
/*     */ import com.prineside.tdi2.scene2d.Group;
/*     */ import com.prineside.tdi2.scene2d.InputEvent;
/*     */ import com.prineside.tdi2.scene2d.Touchable;
/*     */ import com.prineside.tdi2.scene2d.actions.Actions;
/*     */ import com.prineside.tdi2.scene2d.ui.Cell;
/*     */ import com.prineside.tdi2.scene2d.ui.Image;
/*     */ import com.prineside.tdi2.scene2d.ui.ScrollPane;
/*     */ import com.prineside.tdi2.scene2d.ui.Table;
/*     */ import com.prineside.tdi2.scene2d.utils.ClickListener;
/*     */ import com.prineside.tdi2.scene2d.utils.Drawable;
/*     */ import com.prineside.tdi2.ui.actors.ItemCell;
/*     */ import com.prineside.tdi2.ui.actors.Label;
/*     */ import com.prineside.tdi2.ui.actors.QuadActor;
/*     */ import com.prineside.tdi2.utils.UiUtils;
/*     */ import com.prineside.tdi2.utils.logging.TLog;
/*     */ import java.text.SimpleDateFormat;
/*     */ import java.util.Date;
/*     */ 
/*     */ public class IssuedPrizesOverlay extends UiManager.UiComponent.Adapter {
/*  35 */   private static final TLog a = TLog.forClass(IssuedPrizesOverlay.class);
/*     */   public static IssuedPrizesOverlay i() {
/*  37 */     return (IssuedPrizesOverlay)Game.i.uiManager.getComponent(IssuedPrizesOverlay.class);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*  42 */   private final UiManager.UiLayer b = Game.i.uiManager.addLayer(UiManager.MainUiLayer.OVERLAY, 151, "IssuedPrizes main");
/*     */   
/*     */   private Table c;
/*     */   
/*     */   private ScrollPane d;
/*     */   
/*     */   private Label e;
/*     */   
/*     */   private Label f;
/*     */   private Label g;
/*     */   private Actor h;
/*     */   
/*     */   public IssuedPrizesOverlay() {
/*     */     Table table;
/*  56 */     (table = new Table()).setTouchable(Touchable.childrenOnly);
/*     */     
/*  58 */     this.d = new ScrollPane((Actor)table);
/*  59 */     UiUtils.enableMouseMoveScrollFocus(this.d);
/*  60 */     this.d.setTransform(true);
/*  61 */     this.d.setOrigin(607.0F, Game.i.settingsManager.getScaledViewportHeight() / 2.0F);
/*  62 */     this.d.setTouchable(Touchable.childrenOnly);
/*  63 */     this.b.getTable().add((Actor)this.d).width(1214.0F).expandY().fillY();
/*     */     
/*     */     Group group;
/*     */     
/*  67 */     (group = new Group()).setTransform(false);
/*     */ 
/*     */ 
/*     */     
/*     */     QuadActor quadActor;
/*     */ 
/*     */ 
/*     */     
/*  75 */     (quadActor = new QuadActor(new Color(555819519), new float[] { 0.0F, 0.0F, 0.0F, 110.0F, 1060.0F, 95.0F, 1060.0F, 0.0F })).setSize(1160.0F, 110.0F);
/*  76 */     group.addActor((Actor)quadActor);
/*  77 */     table.add((Actor)group).height(110.0F).padTop(160.0F).padLeft(26.0F).padRight(26.0F).width(1160.0F).row();
/*     */     
/*  79 */     this.e = new Label("", new Label.LabelStyle((BitmapFont)Game.i.assetManager.getFont(36), Color.WHITE));
/*  80 */     this.e.setSize(1000.0F, 26.0F);
/*  81 */     this.e.setPosition(40.0F, 26.0F);
/*  82 */     this.e.setAlignment(12);
/*  83 */     group.addActor((Actor)this.e);
/*     */     
/*  85 */     this.f = new Label("", new Label.LabelStyle((BitmapFont)Game.i.assetManager.getFont(24), Color.WHITE));
/*  86 */     this.f.setPosition(40.0F, 26.0F);
/*  87 */     this.f.setSize(1080.0F, 26.0F);
/*  88 */     this.f.setAlignment(20);
/*  89 */     this.f.setColor(1.0F, 1.0F, 1.0F, 0.56F);
/*  90 */     group.addActor((Actor)this.f);
/*     */ 
/*     */     
/*  93 */     this.c = new Table();
/*  94 */     table.add((Actor)this.c).expandX().fillX().row();
/*     */ 
/*     */ 
/*     */     
/*  98 */     (group = new Group()).setTransform(false);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 106 */     (quadActor = new QuadActor(new Color(555819519), new float[] { 0.0F, 0.0F, 0.0F, 30.0F, 1060.0F, 30.0F, 1060.0F, 15.0F })).setSize(1160.0F, 30.0F);
/* 107 */     group.addActor((Actor)quadActor);
/*     */     
/* 109 */     this.g = new Label("", new Label.LabelStyle((BitmapFont)Game.i.assetManager.getFont(24), Color.WHITE));
/* 110 */     this.g.addAction((Action)Actions.forever(
/* 111 */           (Action)Actions.sequence(
/* 112 */             (Action)Actions.color(Color.WHITE, 0.4F), 
/* 113 */             (Action)Actions.color(new Color(1.0F, 1.0F, 1.0F, 0.56F), 0.8F), 
/* 114 */             (Action)Actions.delay(0.5F))));
/*     */ 
/*     */     
/* 117 */     this.g.setTouchable(Touchable.disabled);
/* 118 */     this.g.setColor(1.0F, 1.0F, 1.0F, 0.56F);
/* 119 */     this.g.setSize(1160.0F, 20.0F);
/* 120 */     this.g.setPosition(0.0F, -60.0F);
/* 121 */     this.g.setAlignment(1);
/* 122 */     group.addActor((Actor)this.g);
/*     */     
/* 124 */     table.add((Actor)group).height(30.0F).padBottom(160.0F).padLeft(26.0F).padRight(26.0F).width(1160.0F).row();
/*     */ 
/*     */     
/* 127 */     this.b.getTable().setVisible(false);
/*     */   }
/*     */   
/*     */   public void show(Array<IssuedItems> paramArray) {
/* 131 */     if (paramArray.size == 0) {
/*     */       return;
/*     */     }
/*     */     
/* 135 */     this.e.setText(Game.i.localeManager.i18n.get("earned_items").toUpperCase());
/* 136 */     this.f.setText(Game.i.localeManager.i18n.get("tap_icons_for_more_info"));
/* 137 */     this.g.setText(Game.i.localeManager.i18n.get("tap_outside_list_to_hide"));
/*     */     
/* 139 */     this.c.clear();
/*     */     
/* 141 */     Label.LabelStyle labelStyle = Game.i.assetManager.getLabelStyle(24);
/*     */     
/* 143 */     float f1 = Game.i.settingsManager.isUiAnimationsEnabled() ? 1.0F : 0.0F;
/*     */     
/* 145 */     paramArray.sort((paramIssuedItems1, paramIssuedItems2) -> Integer.compare(paramIssuedItems2.issueTimestamp, paramIssuedItems1.issueTimestamp));
/* 146 */     float f2 = 0.0F;
/* 147 */     for (byte b = 0; b < paramArray.size; b++) {
/*     */       try {
/*     */         IssuedItems issuedItems;
/*     */ 
/*     */ 
/*     */         
/* 153 */         int i = MathUtils.ceil((issuedItems = (IssuedItems)paramArray.get(b)).items.size / 8.0F);
/*     */         
/*     */         Group group1;
/* 156 */         (group1 = new Group()).setTransform(false);
/* 157 */         float f = 127.0F + i * 142.0F;
/* 158 */         this.c.add((Actor)group1).size(1212.0F, f).padTop(-12.0F).row();
/*     */         
/*     */         Image image;
/* 161 */         (image = new Image((Drawable)Game.i.assetManager.getDrawable("blank"))).setColor(new Color(555819519));
/* 162 */         image.setSize(1160.0F, f - 12.0F);
/* 163 */         image.setPosition(26.0F, 0.0F);
/* 164 */         group1.addActor((Actor)image);
/*     */         
/*     */         Group group2;
/* 167 */         (group2 = new Group()).setTransform(true);
/* 168 */         group2.setSize(1212.0F, f);
/* 169 */         group1.addActor((Actor)group2);
/*     */         
/* 171 */         if (b % 2 == 0) {
/* 172 */           group2.setOrigin(0.0F, f / 2.0F);
/*     */         } else {
/* 174 */           group2.setOrigin(1212.0F, f / 2.0F);
/*     */         } 
/*     */         
/* 177 */         f2 += StrictMath.max(0.2F - b * 0.02F, 0.0F);
/* 178 */         group2.addAction((Action)Actions.sequence(
/* 179 */               (Action)Actions.scaleTo(0.0F, 1.0F), 
/* 180 */               (Action)Actions.delay(f2 * f1), 
/* 181 */               (Action)Actions.scaleTo(1.0F, 1.0F, 0.3F * f1, (Interpolation)Interpolation.exp5Out), 
/* 182 */               (Action)Actions.run(() -> paramGroup.setTransform(false))));
/*     */ 
/*     */         
/* 185 */         if (b % 2 == 0) {
/*     */           QuadActor quadActor;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */           
/* 192 */           (quadActor = new QuadActor(new Color(0.0F, 0.0F, 0.0F, 0.28F), new float[] { 26.0F, 19.0F, 26.0F, 60.0F, 1186.0F, 85.0F, 1186.0F, 0.0F })).setSize(1186.0F, 85.0F);
/* 193 */           group2.addActor((Actor)quadActor);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */           
/* 201 */           (quadActor = new QuadActor(new Color(791621631), new float[] { 6.0F, 26.0F, 0.0F, f - 13.0F, 1212.0F, f, 1206.0F, 13.0F })).setSize(1212.0F, f);
/* 202 */           group2.addActor((Actor)quadActor);
/*     */         } else {
/*     */           QuadActor quadActor;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */           
/* 210 */           (quadActor = new QuadActor(new Color(0.0F, 0.0F, 0.0F, 0.28F), new float[] { 26.0F, 0.0F, 26.0F, 60.0F, 1186.0F, 60.0F, 1186.0F, 18.0F })).setSize(1186.0F, 60.0F);
/* 211 */           group2.addActor((Actor)quadActor);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */           
/* 219 */           (quadActor = new QuadActor(new Color(791621631), new float[] { 6.0F, 12.0F, 0.0F, f, 1212.0F, f - 13.0F, 1206.0F, 25.0F })).setSize(1212.0F, f);
/* 220 */           group2.addActor((Actor)quadActor);
/*     */         } 
/*     */         
/*     */         Label label2;
/* 224 */         (label2 = new Label(issuedItems.getReasonDescription(), labelStyle)).setPosition(66.0F, f - 59.0F);
/* 225 */         label2.setSize(300.0F, 18.0F);
/* 226 */         group2.addActor((Actor)label2);
/*     */         
/* 228 */         Date date = new Date(issuedItems.issueTimestamp * 1000L);
/* 229 */         SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MMMM dd, HH:mm", Game.i.localeManager.i18n.getLocale());
/*     */         Label label1;
/* 231 */         (label1 = new Label(simpleDateFormat.format(date), labelStyle)).setAlignment(16);
/* 232 */         label1.setPosition(0.0F, f - 59.0F);
/* 233 */         label1.setSize(1146.0F, 18.0F);
/* 234 */         group2.addActor((Actor)label1);
/*     */ 
/*     */         
/* 237 */         Table table = new Table();
/* 238 */         byte b1 = 0;
/* 239 */         byte b2 = 0;
/* 240 */         for (byte b3 = 0; b3 < issuedItems.items.size; b3++) {
/* 241 */           ItemStack itemStack = (ItemStack)issuedItems.items.get(b3);
/*     */           
/*     */           ItemCell itemCell;
/* 244 */           (itemCell = new ItemCell()).setColRow(b1, b2);
/* 245 */           itemCell.setItemStack(itemStack);
/* 246 */           itemCell.addListener((EventListener)new ClickListener(this, itemStack)
/*     */               {
/*     */                 public void clicked(InputEvent param1InputEvent, float param1Float1, float param1Float2) {
/* 249 */                   ItemDescriptionDialog.i().showWithCount(this.a.getItem(), this.a.getCount());
/* 250 */                   Game.i.soundManager.playStatic(StaticSoundType.BUTTON);
/*     */                 }
/*     */               });
/*     */           
/* 254 */           Cell cell = table.add((Actor)itemCell);
/* 255 */           b1++;
/* 256 */           if (b1 == 8) {
/* 257 */             b1 = 0;
/* 258 */             b2++;
/* 259 */             table.add().height(1.0F).fillX().expandX();
/* 260 */             cell.row();
/*     */           } 
/*     */         } 
/*     */ 
/*     */         
/* 265 */         if (b2 == 0)
/*     */         {
/* 267 */           table.add().height(1.0F).fillX().expandX();
/*     */         }
/* 269 */         table.setPosition(66.0F, 50.0F);
/* 270 */         table.setSize(1146.0F, 142.0F * i);
/* 271 */         group2.addActor((Actor)table);
/* 272 */       } catch (Exception exception) {
/* 273 */         a.e("Can't add earnings row", new Object[] { exception });
/*     */       } 
/*     */     } 
/*     */     
/* 277 */     this.b.getTable().setVisible(true);
/*     */     
/* 279 */     DarkOverlay.i().addCallerOverlayLayer("IssuedPrizesOverlay", this.b.zIndex - 1, () -> {
/*     */           hide();
/*     */           
/*     */           return true;
/*     */         });
/* 284 */     this.d.clearActions();
/* 285 */     this.d.addAction((Action)Actions.sequence(
/* 286 */           (Action)Actions.scaleTo(0.0F, 0.0F), 
/* 287 */           (Action)Actions.parallel(
/* 288 */             (Action)Actions.sequence(
/* 289 */               (Action)Actions.delay(0.1F * f1), 
/* 290 */               (Action)Actions.scaleBy(1.0F, 0.0F, 0.3F * f1, (Interpolation)Interpolation.swingOut)), 
/*     */             
/* 292 */             (Action)Actions.scaleBy(0.0F, 1.0F, 0.3F * f1, (Interpolation)Interpolation.swingOut))));
/*     */ 
/*     */ 
/*     */     
/* 296 */     if (Game.i.uiManager.stage.getScrollFocus() != this.d) {
/* 297 */       this.h = Game.i.uiManager.stage.getScrollFocus();
/* 298 */       Game.i.uiManager.stage.setScrollFocus((Actor)this.d);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void hide() {
/* 304 */     float f = Game.i.settingsManager.isUiAnimationsEnabled() ? 1.0F : 0.0F;
/*     */     
/* 306 */     DarkOverlay.i().removeCaller("IssuedPrizesOverlay");
/*     */     
/* 308 */     this.d.clearActions();
/* 309 */     this.d.addAction((Action)Actions.sequence(
/* 310 */           (Action)Actions.parallel(
/* 311 */             (Action)Actions.sequence(
/* 312 */               (Action)Actions.delay(0.07F * f), 
/* 313 */               (Action)Actions.scaleBy(0.0F, -this.d.getScaleY(), 0.3F * f, (Interpolation)Interpolation.swingIn)), 
/*     */             
/* 315 */             (Action)Actions.scaleBy(-this.d.getScaleX(), 0.0F, 0.3F * f, (Interpolation)Interpolation.swingIn)), 
/*     */           
/* 317 */           (Action)Actions.run(() -> this.b.getTable().setVisible(false))));
/*     */ 
/*     */     
/* 320 */     if (this.h == null || this.h.getStage() != null) {
/* 321 */       Game.i.uiManager.stage.setScrollFocus(this.h);
/* 322 */       this.h = null;
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi\\ui\shared\IssuedPrizesOverlay.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */