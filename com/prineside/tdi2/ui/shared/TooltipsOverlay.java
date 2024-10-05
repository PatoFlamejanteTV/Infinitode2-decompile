/*     */ package com.prineside.tdi2.ui.shared;
/*     */ import com.badlogic.gdx.math.Interpolation;
/*     */ import com.badlogic.gdx.math.MathUtils;
/*     */ import com.badlogic.gdx.math.Vector2;
/*     */ import com.badlogic.gdx.utils.DelayedRemovalArray;
/*     */ import com.badlogic.gdx.utils.Null;
/*     */ import com.google.common.base.Preconditions;
/*     */ import com.prineside.tdi2.Game;
/*     */ import com.prineside.tdi2.Threads;
/*     */ import com.prineside.tdi2.managers.UiManager;
/*     */ import com.prineside.tdi2.managers.preferences.categories.SettingsPrefs;
/*     */ import com.prineside.tdi2.scene2d.Action;
/*     */ import com.prineside.tdi2.scene2d.Actor;
/*     */ import com.prineside.tdi2.scene2d.EventListener;
/*     */ import com.prineside.tdi2.scene2d.InputEvent;
/*     */ import com.prineside.tdi2.scene2d.Touchable;
/*     */ import com.prineside.tdi2.scene2d.actions.Actions;
/*     */ import com.prineside.tdi2.scene2d.ui.Cell;
/*     */ import com.prineside.tdi2.scene2d.ui.Image;
/*     */ import com.prineside.tdi2.scene2d.ui.Table;
/*     */ import com.prineside.tdi2.scene2d.ui.Widget;
/*     */ import com.prineside.tdi2.scene2d.ui.WidgetGroup;
/*     */ import com.prineside.tdi2.scene2d.utils.ClickListener;
/*     */ import com.prineside.tdi2.scene2d.utils.Drawable;
/*     */ import com.prineside.tdi2.ui.actors.Label;
/*     */ import com.prineside.tdi2.utils.MaterialColor;
/*     */ import com.prineside.tdi2.utils.Quad;
/*     */ import com.prineside.tdi2.utils.UiUtils;
/*     */ 
/*     */ public final class TooltipsOverlay extends UiManager.UiComponent.Adapter {
/*     */   public static TooltipsOverlay i() {
/*  32 */     return (TooltipsOverlay)Game.i.uiManager.getComponent(TooltipsOverlay.class);
/*     */   }
/*     */ 
/*     */   
/*     */   public static final String TAG_GENERIC_TOOLTIP = "_generic_";
/*     */   
/*     */   public static final float PREF_WIDTH = 400.0F;
/*     */   public static final float MAX_WIDTH = 500.0F;
/*  40 */   private final DelayedRemovalArray<Entry> a = new DelayedRemovalArray(false, 1, Entry.class);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final Entry showActor(String paramString, @Null Actor paramActor1, Actor paramActor2, UiManager.MainUiLayer paramMainUiLayer, int paramInt1, int paramInt2) {
/*  47 */     Preconditions.checkNotNull(paramActor2, "contents can not be null");
/*  48 */     if (paramInt2 != 2 && paramInt2 != 4 && paramInt2 != 8 && paramInt2 != 16) {
/*  49 */       throw new IllegalArgumentException("align must be one of top, bottom, left or right");
/*     */     }
/*     */     
/*  52 */     hideEntry(paramString);
/*     */     
/*  54 */     Entry entry = new Entry(paramString, paramActor1, paramActor2, paramMainUiLayer, paramInt1, paramInt2, (byte)0);
/*  55 */     this.a.add(entry);
/*     */     
/*  57 */     return entry;
/*     */   }
/*     */   
/*     */   private void a() {
/*  61 */     this.a.begin();
/*  62 */     for (byte b = 0; b < this.a.size; b++) {
/*  63 */       Entry.a((Entry)this.a.get(b));
/*     */     }
/*  65 */     this.a.end();
/*     */   }
/*     */ 
/*     */   
/*     */   public final void preRender(float paramFloat) {
/*  70 */     a();
/*     */   }
/*     */   
/*     */   public final void markTagShown(String paramString) {
/*  74 */     Preconditions.checkNotNull(paramString);
/*  75 */     if ((SettingsPrefs.i()).settings.shownTooltipTags.add(paramString)) {
/*  76 */       SettingsPrefs.i().requireSave();
/*     */     }
/*     */   }
/*     */   
/*     */   public final boolean isTagShown(String paramString) {
/*  81 */     return (SettingsPrefs.i()).settings.shownTooltipTags.contains(paramString);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final Entry showText(String paramString, @Null Actor paramActor, CharSequence paramCharSequence, UiManager.MainUiLayer paramMainUiLayer, int paramInt1, int paramInt2) {
/*     */     Label label;
/*  90 */     (label = new Label(paramCharSequence, Game.i.assetManager.getLabelStyle(21))).setWrap(true);
/*  91 */     label.setAlignment(1);
/*  92 */     return showActor(paramString, paramActor, (Actor)label, paramMainUiLayer, paramInt1, paramInt2);
/*     */   }
/*     */ 
/*     */   
/*     */   public final void hide() {
/*  97 */     hideAll(false);
/*     */   }
/*     */   
/*     */   public final boolean isVisible(String paramString) {
/* 101 */     for (byte b = 0; b < this.a.size; b++) {
/* 102 */       if (paramString.equals(Entry.b((Entry)this.a.get(b)))) {
/* 103 */         return true;
/*     */       }
/*     */     } 
/* 106 */     return false;
/*     */   }
/*     */   
/*     */   public final void hideAll(boolean paramBoolean) {
/* 110 */     this.a.begin();
/* 111 */     for (byte b = 0; b < this.a.size; b++) {
/* 112 */       if (!paramBoolean) {
/* 113 */         ((Entry)this.a.get(b)).onDispose = null;
/*     */       }
/* 115 */       Entry.c((Entry)this.a.get(b));
/*     */     } 
/* 117 */     this.a.end();
/* 118 */     this.a.clear();
/*     */   }
/*     */   
/*     */   public final void hideEntry(String paramString) {
/* 122 */     Preconditions.checkNotNull(paramString);
/* 123 */     this.a.begin();
/* 124 */     for (byte b = 0; b < this.a.size; b++) {
/* 125 */       if (paramString.equals(Entry.b((Entry)this.a.get(b)))) {
/* 126 */         Entry.c((Entry)this.a.get(b));
/* 127 */         this.a.removeIndex(b);
/*     */         break;
/*     */       } 
/*     */     } 
/* 131 */     this.a.end();
/*     */   }
/*     */   
/*     */   public final class Entry { private String b;
/*     */     @Null
/*     */     private Actor c;
/*     */     private Table d;
/*     */     private final Image e;
/*     */     private final Image f;
/*     */     private final Table g;
/*     */     private boolean h;
/*     */     private int i;
/*     */     private UiManager.UiLayer j;
/* 144 */     private final Vector2 k = new Vector2();
/*     */     
/*     */     public Runnable onDispose;
/*     */     
/*     */     private Entry(@Null TooltipsOverlay this$0, @Null String param1String, Actor param1Actor1, Actor param1Actor2, UiManager.MainUiLayer param1MainUiLayer, int param1Int1, int param1Int2) {
/* 149 */       if (param1String == null) {
/* 150 */         param1String = "_generic_";
/*     */       }
/*     */       
/* 153 */       this.b = param1String;
/* 154 */       this.i = param1Int2;
/* 155 */       this.c = param1Actor1;
/* 156 */       this.j = Game.i.uiManager.addLayer(param1MainUiLayer, param1Int1, "tooltips_overlay_" + param1String);
/* 157 */       this.j.getTable().setTouchable(Touchable.childrenOnly);
/*     */       
/* 159 */       Quad quad1 = Game.i.assetManager.getQuad("ui.tooltips.background");
/* 160 */       Quad quad2 = Game.i.assetManager.getQuad("ui.tooltips.overlay");
/* 161 */       Quad quad3 = Game.i.assetManager.getQuad("ui.tooltips.glow");
/*     */       
/* 163 */       long l = Game.getTimestampMillis();
/*     */       
/* 165 */       this.d = new Table();
/* 166 */       this.d.background((Drawable)quad1);
/* 167 */       this.d.setTouchable(Touchable.enabled);
/* 168 */       this.d.addListener((EventListener)new ClickListener(this, TooltipsOverlay.this, l)
/*     */           {
/*     */             public void clicked(InputEvent param2InputEvent, float param2Float1, float param2Float2) {
/* 171 */               if (Game.getTimestampMillis() - this.a > 500L) {
/* 172 */                 this.b.a.markTagShown(TooltipsOverlay.Entry.b(this.b));
/* 173 */                 this.b.a.hideEntry(TooltipsOverlay.Entry.b(this.b));
/*     */               } 
/*     */             }
/*     */           });
/*     */       
/* 178 */       Cell cell = this.d.add(param1Actor2).maxWidth(500.0F).padLeft(quad1.getLeftWidth()).padRight(quad1.getRightWidth()).padTop(quad1.getTopHeight());
/* 179 */       if (param1Actor2.getWidth() < 5.0F || (param1Actor2 instanceof Widget && ((Widget)param1Actor2).getPrefWidth() < 5.0F) || (param1Actor2 instanceof WidgetGroup && ((WidgetGroup)param1Actor2).getPrefWidth() < 5.0F)) {
/* 180 */         if (param1Actor2 instanceof Label) {
/*     */           Label label1;
/* 182 */           if ((label1 = (Label)param1Actor2).getWrap()) {
/*     */             
/* 184 */             label1.setWrap(false);
/* 185 */             label1.layout();
/* 186 */             float f = label1.getPrefWidth();
/* 187 */             label1.setWrap(true);
/* 188 */             label1.layout();
/* 189 */             cell.prefWidth((int)(f + 2.0F));
/*     */           } 
/*     */         } else {
/* 192 */           cell.prefWidth(400.0F);
/*     */         } 
/*     */       }
/* 195 */       cell.row();
/*     */       
/* 197 */       this.g = new Table();
/* 198 */       this.d.add((Actor)this.g).center().padTop(8.0F).padBottom(quad1.getBottomHeight()).fillX();
/*     */       
/*     */       Label label;
/* 201 */       (label = new Label(Game.i.localeManager.i18n.get("click_to_close"), Game.i.assetManager.getLabelStyle(18))).setColor(1.0F, 1.0F, 1.0F, 0.0F);
/* 202 */       label.addAction(
/* 203 */           (Action)Actions.sequence(
/* 204 */             (Action)Actions.delay(0.4F), 
/* 205 */             (Action)Actions.alpha(0.3F, 0.6F), 
/* 206 */             (Action)Actions.forever((Action)Actions.sequence(
/* 207 */                 (Action)Actions.alpha(0.6F, 0.3F), 
/* 208 */                 (Action)Actions.alpha(0.3F, 0.7F)))));
/*     */ 
/*     */ 
/*     */       
/* 212 */       this.g.add((Actor)label);
/*     */       
/*     */       Image image2;
/* 215 */       (image2 = new Image((Drawable)quad2)).setFillParent(true);
/* 216 */       this.d.addActor((Actor)image2);
/*     */       
/*     */       Image image1;
/* 219 */       (image1 = new Image((Drawable)quad3)).setFillParent(true);
/* 220 */       image1.setColor(1.0F, 1.0F, 1.0F, 0.0F);
/* 221 */       image1.addAction((Action)Actions.forever(
/* 222 */             (Action)Actions.sequence(
/* 223 */               (Action)Actions.alpha(1.0F, 0.3F), 
/* 224 */               (Action)Actions.alpha(0.0F, 0.7F))));
/*     */ 
/*     */       
/* 227 */       this.d.addActor((Actor)image1);
/*     */       
/* 229 */       this.e = new Image();
/* 230 */       this.d.addActor((Actor)this.e);
/*     */       
/* 232 */       this.f = new Image();
/* 233 */       this.f.setColor(1.0F, 1.0F, 1.0F, 0.0F);
/* 234 */       this.f.addAction((Action)Actions.forever(
/* 235 */             (Action)Actions.sequence(
/* 236 */               (Action)Actions.alpha(1.0F, 0.3F), 
/* 237 */               (Action)Actions.alpha(0.0F, 0.7F))));
/*     */ 
/*     */       
/* 240 */       this.d.addActor((Actor)this.f);
/*     */       
/* 242 */       this.d.setTransform(true);
/* 243 */       this.d.setScale(0.0F);
/* 244 */       this.d.setVisible(false);
/* 245 */       this.h = true;
/*     */       
/* 247 */       this.j.getTable().addActor((Actor)this.d);
/*     */     }
/*     */     
/*     */     public final void setTargetPoint(float param1Float1, float param1Float2) {
/* 251 */       this.k.set(param1Float1, param1Float2);
/*     */     }
/*     */     
/*     */     public final void setTargetActor(@Null Actor param1Actor) {
/* 255 */       this.c = param1Actor;
/*     */     }
/*     */     
/*     */     private void a() {
/* 259 */       if (this.d != null) {
/* 260 */         Quad quad1, quad2; float f5, f6; if (this.c != null) {
/*     */           
/* 262 */           if (this.c.getStage() == null) {
/* 263 */             this.a.hideEntry(this.b);
/*     */             
/*     */             return;
/*     */           } 
/*     */           
/* 268 */           if (!UiUtils.isVisibleRecursive(this.c)) {
/* 269 */             if (this.d.isVisible()) {
/* 270 */               this.d.setVisible(false);
/*     */             }
/*     */             
/*     */             return;
/*     */           } 
/*     */           
/* 276 */           this.k.setZero();
/* 277 */           this.c.localToStageCoordinates(this.k);
/*     */           
/* 279 */           if (this.i == 8 || this.i == 16) {
/* 280 */             this.k.y += this.c.getHeight() * 0.5F;
/* 281 */             if (this.i == 16) {
/* 282 */               this.k.x += this.c.getWidth();
/*     */             }
/*     */           } else {
/* 285 */             this.k.x += this.c.getWidth() * 0.5F;
/* 286 */             if (this.i == 2) {
/* 287 */               this.k.y += this.c.getHeight();
/*     */             }
/*     */           } 
/*     */         } 
/*     */         
/* 292 */         this.d.layout();
/* 293 */         this.d.pack();
/* 294 */         float f1 = this.d.getPrefWidth();
/* 295 */         float f2 = this.d.getPrefHeight();
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 300 */         float f3 = this.k.x - this.j.getTable().getX();
/* 301 */         float f4 = this.k.y;
/*     */ 
/*     */         
/* 304 */         switch (this.i) {
/*     */           case 8:
/* 306 */             quad1 = Game.i.assetManager.getQuad("ui.tooltips.arrowRight");
/* 307 */             quad2 = Game.i.assetManager.getQuad("ui.tooltips.arrowRightGlow");
/* 308 */             f3 -= f1 + quad1.getMinWidth();
/* 309 */             f4 -= f2 * 0.5F;
/* 310 */             f5 = f1;
/* 311 */             f6 = f2 * 0.5F - quad1.getMinHeight() * 0.5F;
/*     */             break;
/*     */           
/*     */           case 16:
/* 315 */             quad1 = Game.i.assetManager.getQuad("ui.tooltips.arrowLeft");
/* 316 */             quad2 = Game.i.assetManager.getQuad("ui.tooltips.arrowLeftGlow");
/* 317 */             f3 += quad1.getMinWidth();
/* 318 */             f4 -= f2 * 0.5F;
/* 319 */             f5 = -quad1.getMinWidth();
/* 320 */             f6 = f2 * 0.5F - quad1.getMinHeight() * 0.5F;
/*     */             break;
/*     */           
/*     */           case 2:
/* 324 */             quad1 = Game.i.assetManager.getQuad("ui.tooltips.arrowDown");
/* 325 */             quad2 = Game.i.assetManager.getQuad("ui.tooltips.arrowDownGlow");
/* 326 */             f3 -= f1 * 0.5F;
/* 327 */             f4 += quad1.getMinHeight();
/* 328 */             f5 = f1 * 0.5F - quad1.getMinWidth() * 0.5F;
/* 329 */             f6 = -quad1.getMinHeight();
/*     */             break;
/*     */           
/*     */           default:
/* 333 */             quad1 = Game.i.assetManager.getQuad("ui.tooltips.arrowUp");
/* 334 */             quad2 = Game.i.assetManager.getQuad("ui.tooltips.arrowUpGlow");
/* 335 */             f3 -= f1 * 0.5F;
/* 336 */             f4 -= f2 + quad1.getMinHeight();
/* 337 */             f5 = f1 * 0.5F - quad1.getMinWidth() * 0.5F;
/* 338 */             f6 = f2;
/*     */             break;
/*     */         } 
/*     */ 
/*     */ 
/*     */         
/* 344 */         float f7 = this.j.getTable().getWidth();
/* 345 */         float f8 = this.j.getTable().getHeight();
/*     */         
/* 347 */         if (this.i == 8 || this.i == 16) {
/* 348 */           float f = 0.0F;
/* 349 */           if (f4 < 40.0F) {
/* 350 */             f = 40.0F - f4;
/* 351 */           } else if (f4 + f2 > f8 - 40.0F) {
/* 352 */             f = f8 - 40.0F - f4 + f2;
/*     */           } 
/* 354 */           f4 += f;
/*     */           
/* 356 */           f6 = MathUtils.clamp(f6 = f6 - f, 0.0F, f2 - quad1.getMinHeight());
/*     */         } else {
/* 358 */           float f = 0.0F;
/* 359 */           if (f3 < 40.0F) {
/* 360 */             f = 40.0F - f3;
/* 361 */           } else if (f3 + f1 > f7 - 40.0F) {
/* 362 */             f = f7 - 40.0F - f3 + f1;
/*     */           } 
/* 364 */           f3 += f;
/*     */           
/* 366 */           f5 = MathUtils.clamp(f5 = f5 - f, 0.0F, f1 - quad1.getMinWidth());
/*     */         } 
/*     */         
/* 369 */         this.e.setDrawable((Drawable)quad1);
/* 370 */         this.e.setSize(quad1.getMinWidth(), quad1.getMinHeight());
/* 371 */         this.e.setPosition(f5, f6);
/* 372 */         this.f.setDrawable((Drawable)quad2);
/* 373 */         this.f.setSize(quad1.getMinWidth(), quad1.getMinHeight());
/* 374 */         this.f.setPosition(f5, f6);
/*     */         
/* 376 */         this.d.setPosition(f3, f4);
/*     */         
/* 378 */         if (!this.d.isVisible()) {
/* 379 */           this.d.setVisible(true);
/*     */         }
/*     */         
/* 382 */         if (this.h) {
/*     */           
/* 384 */           this.d.setOrigin(1);
/* 385 */           this.d.addAction((Action)Actions.sequence(
/* 386 */                 (Action)Actions.scaleTo(0.0F, 1.1F), 
/* 387 */                 (Action)Actions.delay(0.05F), 
/* 388 */                 (Action)Actions.parallel(
/* 389 */                   (Action)Actions.sequence(
/* 390 */                     (Action)Actions.scaleBy(1.1F, 0.0F, 0.2F, (Interpolation)Interpolation.pow2Out), 
/* 391 */                     (Action)Actions.scaleBy(-0.1F, 0.0F, 0.1F, (Interpolation)Interpolation.pow2)), 
/*     */                   
/* 393 */                   (Action)Actions.sequence(
/* 394 */                     (Action)Actions.scaleBy(0.0F, -0.2F, 0.2F, (Interpolation)Interpolation.pow2Out), 
/* 395 */                     (Action)Actions.scaleBy(0.0F, 0.1F, 0.1F, (Interpolation)Interpolation.pow2))), 
/*     */ 
/*     */                 
/* 398 */                 (Action)Actions.run(() -> this.d.setTransform(false))));
/*     */ 
/*     */           
/* 401 */           Quad quad = Game.i.assetManager.getQuad("ui.tooltips.background");
/*     */           
/*     */           Image image;
/* 404 */           (image = new Image((Drawable)Game.i.assetManager.getDrawable("blank"))).setColor(MaterialColor.BLUE_GREY.P300);
/* 405 */           image.setSize(14.0F, 14.0F);
/* 406 */           image.setPosition(f1 / 2.0F - quad.getLeftWidth() - 7.0F, -20.0F);
/* 407 */           image.addAction((Action)Actions.sequence(
/* 408 */                 (Action)Actions.delay(0.1F), 
/* 409 */                 (Action)Actions.parallel(
/* 410 */                   (Action)Actions.moveBy(0.0F, 22.0F, 0.4F, (Interpolation)Interpolation.swingOut)), 
/*     */                 
/* 412 */                 (Action)Actions.delay(0.05F), 
/* 413 */                 (Action)Actions.parallel(
/* 414 */                   (Action)Actions.alpha(0.0F, 0.8F, (Interpolation)Interpolation.pow2Out), 
/* 415 */                   (Action)Actions.moveTo(-quad.getLeftWidth(), 9.0F, 0.8F, (Interpolation)Interpolation.pow2Out), 
/* 416 */                   (Action)Actions.sizeTo(f1, 0.0F, 0.8F, (Interpolation)Interpolation.pow2Out), 
/* 417 */                   (Action)Actions.scaleTo(1.0F, 0.0F, 0.8F))));
/*     */ 
/*     */           
/* 420 */           this.g.addActor((Actor)image);
/* 421 */           this.h = false;
/*     */         } 
/*     */       } 
/*     */     }
/*     */     
/*     */     public final boolean exists() {
/* 427 */       return (this.d != null);
/*     */     }
/*     */     
/*     */     private void b() {
/* 431 */       if (this.d != null) {
/* 432 */         if (this.onDispose != null) {
/* 433 */           Threads.i().postRunnable(this.onDispose);
/*     */         }
/* 435 */         this.onDispose = null;
/* 436 */         this.d.remove();
/* 437 */         this.d = null;
/* 438 */         this.c = null;
/* 439 */         this.b = null;
/* 440 */         Game.i.uiManager.removeLayer(this.j);
/* 441 */         this.j = null;
/*     */       } 
/*     */     } }
/*     */ 
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi\\ui\shared\TooltipsOverlay.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */