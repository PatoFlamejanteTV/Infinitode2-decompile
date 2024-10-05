/*     */ package com.prineside.tdi2.ui.shared;
/*     */ import com.badlogic.gdx.Gdx;
/*     */ import com.badlogic.gdx.graphics.Color;
/*     */ import com.badlogic.gdx.math.MathUtils;
/*     */ import com.badlogic.gdx.utils.Array;
/*     */ import com.prineside.tdi2.Game;
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
/*     */ import com.prineside.tdi2.scene2d.ui.Image;
/*     */ import com.prineside.tdi2.scene2d.ui.Table;
/*     */ import com.prineside.tdi2.scene2d.utils.ClickListener;
/*     */ import com.prineside.tdi2.scene2d.utils.Drawable;
/*     */ import com.prineside.tdi2.ui.actors.ItemCell;
/*     */ import com.prineside.tdi2.ui.actors.Label;
/*     */ import com.prineside.tdi2.utils.InputVoid;
/*     */ import com.prineside.tdi2.utils.MaterialColor;
/*     */ import com.prineside.tdi2.utils.logging.TLog;
/*     */ 
/*     */ public final class Dialog extends UiManager.UiComponent.Adapter {
/*     */   static {
/*  29 */     TLog.forClass(Dialog.class);
/*     */   } public static Dialog i() {
/*  31 */     return (Dialog)Game.i.uiManager.getComponent(Dialog.class);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  39 */   private static final Color a = MaterialColor.LIGHT_BLUE.P700;
/*  40 */   private static final Color b = MaterialColor.LIGHT_BLUE.P600;
/*  41 */   private static final Color c = MaterialColor.LIGHT_BLUE.P800;
/*  42 */   private static final Color d = MaterialColor.GREY.P800;
/*     */   
/*  44 */   private final UiManager.UiLayer e = Game.i.uiManager.addLayer(UiManager.MainUiLayer.OVERLAY, 201, "Dialog main");
/*     */   
/*     */   private final Label f;
/*     */   
/*     */   private final Group g;
/*     */   
/*     */   private final Image h;
/*     */   
/*     */   private final Image i;
/*     */   
/*     */   private final Label j;
/*     */   
/*     */   private Runnable k;
/*     */   
/*     */   private final Group l;
/*     */   private final Image m;
/*     */   private final Image n;
/*     */   private final Label o;
/*     */   private Runnable p;
/*     */   private final Image q;
/*     */   private final Image r;
/*     */   private final Image s;
/*     */   private final Table t;
/*     */   public boolean ignoreEscForFrame;
/*  68 */   private String u = "default";
/*  69 */   private float v = 0.0F;
/*     */   
/*     */   private boolean w;
/*     */   
/*     */   private boolean x;
/*     */   
/*     */   private final Runnable y = () -> hide();
/*     */   
/*     */   public Dialog() {
/*  78 */     Table table = this.e.getTable();
/*     */     
/*     */     Group group;
/*  81 */     (group = new Group()).setTransform(false);
/*  82 */     group.setTouchable(Touchable.enabled);
/*  83 */     group.addListener((EventListener)new InputVoid());
/*  84 */     table.add((Actor)group).expand().bottom().right().padBottom(293.0F).size(651.0F, 456.0F);
/*     */     
/*  86 */     this.q = new Image((Drawable)Game.i.assetManager.getDrawable("ui-dialog-background-1"));
/*  87 */     this.q.setPosition(115.0F, 87.0F);
/*  88 */     this.q.setSize(566.0F, 179.0F);
/*  89 */     group.addActor((Actor)this.q);
/*  90 */     this.r = new Image((Drawable)Game.i.assetManager.getDrawable("ui-dialog-background-2"));
/*  91 */     this.r.setPosition(115.0F, 106.0F);
/*  92 */     this.r.setSize(514.0F, 320.0F);
/*  93 */     group.addActor((Actor)this.r);
/*  94 */     this.s = new Image((Drawable)Game.i.assetManager.getDrawable("ui-dialog-background-3"));
/*  95 */     this.s.setPosition(0.0F, 136.0F);
/*  96 */     this.s.setSize(611.0F, 320.0F);
/*  97 */     group.addActor((Actor)this.s);
/*     */     
/*  99 */     this.t = new Table();
/* 100 */     this.t.setPosition(-691.0F, 0.0F);
/* 101 */     this.t.setSize(651.0F, 456.0F);
/* 102 */     group.addActor((Actor)this.t);
/*     */ 
/*     */     
/* 105 */     this.f = new Label("", new Label.LabelStyle((BitmapFont)Game.i.assetManager.getFont(30), Color.WHITE));
/* 106 */     this.f.setWrap(true);
/* 107 */     this.f.setAlignment(1);
/* 108 */     this.f.setPosition(78.0F, 185.0F);
/* 109 */     this.f.setSize(489.0F, 240.0F);
/* 110 */     group.addActor((Actor)this.f);
/*     */ 
/*     */     
/* 113 */     this.g = new Group();
/* 114 */     this.g.setName("dialog_left_button");
/* 115 */     this.g.setTransform(false);
/* 116 */     this.g.setPosition(65.0F, 0.0F);
/* 117 */     this.g.setSize(265.0F, 139.0F);
/* 118 */     group.addActor((Actor)this.g);
/*     */     
/* 120 */     this.h = new Image((Drawable)Game.i.assetManager.getDrawable("ui-dialog-button-left"));
/* 121 */     this.h.setColor(a);
/* 122 */     this.h.setSize(265.0F, 139.0F);
/* 123 */     this.g.addActor((Actor)this.h);
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 128 */     this.g.setTouchable(Touchable.enabled);
/* 129 */     this.g.addListener((EventListener)new ClickListener(this) {
/*     */           private boolean a = false;
/*     */           private boolean b = false;
/*     */           
/*     */           private void a() {
/* 134 */             if (Dialog.a(this.c)) {
/* 135 */               Dialog.b(this.c).setColor(Dialog.a()); return;
/*     */             } 
/* 137 */             if (this.a) {
/* 138 */               Dialog.b(this.c).setColor(Dialog.b()); return;
/*     */             } 
/* 140 */             if (this.b) {
/* 141 */               Dialog.b(this.c).setColor(Dialog.c()); return;
/*     */             } 
/* 143 */             Dialog.b(this.c).setColor(Dialog.d());
/*     */           }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */           
/*     */           public void clicked(InputEvent param1InputEvent, float param1Float1, float param1Float2) {
/* 151 */             if (Dialog.a(this.c))
/*     */               return; 
/* 153 */             Runnable runnable = Dialog.c(this.c);
/* 154 */             this.c.hide();
/*     */             
/* 156 */             if (runnable != null) {
/* 157 */               runnable.run();
/* 158 */               Game.i.soundManager.playStatic(StaticSoundType.BUTTON);
/*     */             } 
/*     */           }
/*     */ 
/*     */           
/*     */           public boolean touchDown(InputEvent param1InputEvent, float param1Float1, float param1Float2, int param1Int1, int param1Int2) {
/* 164 */             this.a = true;
/* 165 */             a();
/*     */             
/* 167 */             return super.touchDown(param1InputEvent, param1Float1, param1Float2, param1Int1, param1Int2);
/*     */           }
/*     */ 
/*     */           
/*     */           public void touchUp(InputEvent param1InputEvent, float param1Float1, float param1Float2, int param1Int1, int param1Int2) {
/* 172 */             this.a = false;
/* 173 */             a();
/*     */             
/* 175 */             super.touchUp(param1InputEvent, param1Float1, param1Float2, param1Int1, param1Int2);
/*     */           }
/*     */ 
/*     */           
/*     */           public void enter(InputEvent param1InputEvent, float param1Float1, float param1Float2, int param1Int, Actor param1Actor) {
/* 180 */             if (param1Int == -1) {
/* 181 */               this.b = true;
/* 182 */               a();
/*     */             } 
/*     */             
/* 185 */             super.enter(param1InputEvent, param1Float1, param1Float2, param1Int, param1Actor);
/*     */           }
/*     */ 
/*     */           
/*     */           public void exit(InputEvent param1InputEvent, float param1Float1, float param1Float2, int param1Int, Actor param1Actor) {
/* 190 */             if (param1Int == -1) {
/* 191 */               this.b = false;
/* 192 */               a();
/*     */             } 
/*     */             
/* 195 */             super.exit(param1InputEvent, param1Float1, param1Float2, param1Int, param1Actor);
/*     */           }
/*     */         });
/*     */     
/* 199 */     this.i = new Image((Drawable)Game.i.assetManager.getDrawable("icon-times"));
/* 200 */     this.i.setPosition(100.0F, 46.0F);
/* 201 */     this.i.setSize(64.0F, 64.0F);
/* 202 */     this.g.addActor((Actor)this.i);
/*     */     
/* 204 */     this.j = new Label("", Game.i.assetManager.getLabelStyle(30));
/* 205 */     this.j.setPosition(100.0F, 46.0F);
/* 206 */     this.j.setSize(64.0F, 64.0F);
/* 207 */     this.j.setAlignment(1);
/* 208 */     this.j.setVisible(false);
/* 209 */     this.j.setColor(1.0F, 1.0F, 1.0F, 0.56F);
/* 210 */     this.g.addActor((Actor)this.j);
/*     */ 
/*     */     
/* 213 */     this.l = new Group();
/* 214 */     this.l.setName("dialog_right_button");
/* 215 */     this.l.setPosition(344.0F, 14.0F);
/* 216 */     this.l.setSize(259.0F, 141.0F);
/* 217 */     group.addActor((Actor)this.l);
/*     */     
/* 219 */     this.m = new Image((Drawable)Game.i.assetManager.getDrawable("ui-dialog-button-right"));
/* 220 */     this.m.setColor(a);
/* 221 */     this.m.setSize(259.0F, 141.0F);
/* 222 */     this.l.addActor((Actor)this.m);
/*     */     
/* 224 */     this.l.setTouchable(Touchable.enabled);
/*     */ 
/*     */ 
/*     */     
/* 228 */     this.l.addListener((EventListener)new ClickListener(this) {
/*     */           private boolean a = false;
/*     */           private boolean b = false;
/*     */           
/*     */           private void a() {
/* 233 */             if (Dialog.d(this.c)) {
/* 234 */               Dialog.e(this.c).setColor(Dialog.a()); return;
/*     */             } 
/* 236 */             if (this.a) {
/* 237 */               Dialog.e(this.c).setColor(Dialog.b()); return;
/*     */             } 
/* 239 */             if (this.b) {
/* 240 */               Dialog.e(this.c).setColor(Dialog.c()); return;
/*     */             } 
/* 242 */             Dialog.e(this.c).setColor(Dialog.d());
/*     */           }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */           
/*     */           public void clicked(InputEvent param1InputEvent, float param1Float1, float param1Float2) {
/* 250 */             if (Dialog.d(this.c))
/*     */               return; 
/* 252 */             Runnable runnable = Dialog.f(this.c);
/* 253 */             this.c.hide();
/*     */             
/* 255 */             if (runnable != null) {
/* 256 */               runnable.run();
/* 257 */               Game.i.soundManager.playStatic(StaticSoundType.BUTTON);
/*     */             } 
/*     */           }
/*     */ 
/*     */           
/*     */           public boolean touchDown(InputEvent param1InputEvent, float param1Float1, float param1Float2, int param1Int1, int param1Int2) {
/* 263 */             this.a = true;
/* 264 */             a();
/*     */             
/* 266 */             return super.touchDown(param1InputEvent, param1Float1, param1Float2, param1Int1, param1Int2);
/*     */           }
/*     */ 
/*     */           
/*     */           public void touchUp(InputEvent param1InputEvent, float param1Float1, float param1Float2, int param1Int1, int param1Int2) {
/* 271 */             this.a = false;
/* 272 */             a();
/*     */             
/* 274 */             super.touchUp(param1InputEvent, param1Float1, param1Float2, param1Int1, param1Int2);
/*     */           }
/*     */ 
/*     */           
/*     */           public void enter(InputEvent param1InputEvent, float param1Float1, float param1Float2, int param1Int, Actor param1Actor) {
/* 279 */             if (param1Int == -1) {
/* 280 */               this.b = true;
/* 281 */               a();
/*     */             } 
/*     */             
/* 284 */             super.enter(param1InputEvent, param1Float1, param1Float2, param1Int, param1Actor);
/*     */           }
/*     */ 
/*     */           
/*     */           public void exit(InputEvent param1InputEvent, float param1Float1, float param1Float2, int param1Int, Actor param1Actor) {
/* 289 */             if (param1Int == -1) {
/* 290 */               this.b = false;
/* 291 */               a();
/*     */             } 
/*     */             
/* 294 */             super.exit(param1InputEvent, param1Float1, param1Float2, param1Int, param1Actor);
/*     */           }
/*     */         });
/*     */     
/* 298 */     this.n = new Image((Drawable)Game.i.assetManager.getDrawable("icon-times"));
/* 299 */     this.n.setPosition(81.0F, 42.0F);
/* 300 */     this.n.setSize(64.0F, 64.0F);
/* 301 */     this.l.addActor((Actor)this.n);
/*     */     
/* 303 */     this.o = new Label("", Game.i.assetManager.getLabelStyle(30));
/* 304 */     this.o.setPosition(81.0F, 42.0F);
/* 305 */     this.o.setSize(64.0F, 64.0F);
/* 306 */     this.o.setAlignment(1);
/* 307 */     this.o.setColor(1.0F, 1.0F, 1.0F, 0.56F);
/* 308 */     this.o.setVisible(false);
/* 309 */     this.l.addActor((Actor)this.o);
/*     */     
/* 311 */     this.e.getTable().setVisible(false);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final void setItemsHintForVisibleDialog(Array<ItemStack> paramArray) {
/* 318 */     this.t.clear();
/*     */     
/* 320 */     byte b1 = 0;
/* 321 */     byte b2 = 0;
/* 322 */     for (Array.ArrayIterator<ItemStack> arrayIterator = paramArray.iterator(); arrayIterator.hasNext(); ) { ItemStack itemStack = arrayIterator.next();
/*     */       ItemCell itemCell;
/* 324 */       (itemCell = new ItemCell()).setItemStack(itemStack);
/* 325 */       itemCell.setColRow(b1, b2);
/* 326 */       itemCell.addListener((EventListener)new ClickListener(this, itemStack)
/*     */           {
/*     */             public void clicked(InputEvent param1InputEvent, float param1Float1, float param1Float2) {
/* 329 */               ItemDescriptionDialog.i().showWithCount(this.a.getItem(), this.a.getCount());
/*     */             }
/*     */           });
/* 332 */       this.t.add((Actor)itemCell);
/* 333 */       b1++;
/* 334 */       if (b1 == 5) {
/* 335 */         b1 = 0;
/* 336 */         b2++;
/* 337 */         this.t.row();
/*     */       }  }
/*     */   
/*     */   }
/*     */   
/*     */   private void e() {
/* 343 */     this.q.clearActions();
/* 344 */     this.r.clearActions();
/* 345 */     this.s.clearActions();
/* 346 */     this.f.clearActions();
/* 347 */     this.g.clearActions();
/* 348 */     this.l.clearActions();
/* 349 */     this.e.getTable().clearActions();
/*     */   }
/*     */   
/*     */   private void f() {
/* 353 */     this.q.setVisible(false);
/* 354 */     this.r.setVisible(false);
/* 355 */     this.s.setVisible(false);
/* 356 */     this.f.setVisible(false);
/* 357 */     this.g.setVisible(false);
/* 358 */     this.l.setVisible(false);
/*     */   }
/*     */   
/*     */   private void g() {
/* 362 */     e();
/* 363 */     f();
/*     */     
/* 365 */     this.q.setVisible(true);
/*     */     
/* 367 */     if (Game.i.settingsManager.isUiAnimationsEnabled()) {
/* 368 */       this.r.addAction((Action)Actions.sequence((Action)Actions.delay(0.05F), (Action)Actions.visible(true)));
/* 369 */       this.s.addAction((Action)Actions.sequence((Action)Actions.delay(0.1F), (Action)Actions.visible(true)));
/* 370 */       this.f.addAction((Action)Actions.sequence((Action)Actions.delay(0.1F), (Action)Actions.visible(true)));
/* 371 */       if (this.k != null) {
/* 372 */         this.g.addAction((Action)Actions.sequence((Action)Actions.delay(0.1F), (Action)Actions.visible(true)));
/*     */       }
/* 374 */       if (this.p != null) {
/* 375 */         this.l.addAction((Action)Actions.sequence((Action)Actions.delay(0.1F), (Action)Actions.visible(true)));
/*     */       }
/*     */     } else {
/* 378 */       this.r.setVisible(true);
/* 379 */       this.s.setVisible(true);
/* 380 */       this.f.setVisible(true);
/* 381 */       if (this.k != null) {
/* 382 */         this.g.setVisible(true);
/*     */       }
/* 384 */       if (this.p != null) {
/* 385 */         this.l.setVisible(true);
/*     */       }
/*     */     } 
/*     */     
/* 389 */     DarkOverlay.i().addCallerOverlayLayer("Dialog", this.e.zIndex - 1, () -> false);
/* 390 */     this.e.getTable().setVisible(true);
/*     */     
/* 392 */     j();
/*     */   }
/*     */   
/*     */   public final boolean isVisible() {
/* 396 */     return this.e.getTable().isVisible();
/*     */   }
/*     */   
/*     */   public final String getLastConfirmId() {
/* 400 */     return this.u;
/*     */   }
/*     */ 
/*     */   
/*     */   public final void postRender(float paramFloat) {
/* 405 */     if (isVisible()) {
/* 406 */       if (this.v != 0.0F) {
/* 407 */         this.v -= paramFloat;
/* 408 */         if (this.v < 0.0F) {
/* 409 */           this.v = 0.0F;
/*     */         }
/* 411 */         j();
/*     */       } 
/*     */       
/* 414 */       if (!this.ignoreEscForFrame && (Gdx.input.isKeyJustPressed(4) || Gdx.input.isKeyJustPressed(111))) {
/* 415 */         Runnable runnable = this.p;
/* 416 */         hide();
/*     */         
/* 418 */         if (runnable != null) {
/* 419 */           runnable.run();
/* 420 */           Game.i.soundManager.playStatic(StaticSoundType.BUTTON);
/*     */         } 
/* 422 */       } else if ((Gdx.input.isKeyJustPressed(66) || Gdx.input.isKeyJustPressed(160)) && 
/* 423 */         !h()) {
/* 424 */         Runnable runnable = this.k;
/* 425 */         hide();
/*     */         
/* 427 */         if (runnable != null) {
/* 428 */           runnable.run();
/* 429 */           Game.i.soundManager.playStatic(StaticSoundType.BUTTON);
/*     */         } 
/*     */       } 
/*     */     } 
/*     */     
/* 434 */     this.ignoreEscForFrame = false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final Table getHintTable() {
/* 441 */     return this.t;
/*     */   }
/*     */   
/*     */   public final void hide() {
/* 445 */     e();
/*     */     
/* 447 */     this.k = null;
/* 448 */     this.p = null;
/*     */     
/* 450 */     this.t.clear();
/* 451 */     this.v = 0.0F;
/*     */     
/* 453 */     this.g.setVisible(false);
/* 454 */     this.l.setVisible(false);
/* 455 */     this.f.setVisible(false);
/* 456 */     this.s.setVisible(false);
/* 457 */     if (Game.i.settingsManager.isUiAnimationsEnabled()) {
/* 458 */       this.r.addAction((Action)Actions.sequence(
/* 459 */             (Action)Actions.delay(0.05F), 
/* 460 */             (Action)Actions.visible(false)));
/*     */       
/* 462 */       this.q.addAction((Action)Actions.sequence(
/* 463 */             (Action)Actions.delay(0.1F), 
/* 464 */             (Action)Actions.visible(false)));
/*     */       
/* 466 */       this.e.getTable().addAction((Action)Actions.sequence(
/* 467 */             (Action)Actions.delay(0.1F), 
/* 468 */             (Action)Actions.visible(false)));
/*     */     } else {
/*     */       
/* 471 */       this.r.setVisible(false);
/* 472 */       this.q.setVisible(false);
/* 473 */       this.e.getTable().setVisible(false);
/*     */     } 
/*     */     
/* 476 */     DarkOverlay.i().removeCaller("Dialog");
/*     */   }
/*     */   
/*     */   public final void showConfirm(CharSequence paramCharSequence, Runnable paramRunnable) {
/* 480 */     showConfirmWithId(paramCharSequence, paramRunnable, "default");
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public final void showConfirmWithId(CharSequence paramCharSequence, Runnable paramRunnable, String paramString) {
/* 486 */     this.f.setText(paramCharSequence);
/*     */     
/* 488 */     this.i.setDrawable((Drawable)Game.i.assetManager.getDrawable("icon-check"));
/* 489 */     this.k = paramRunnable;
/*     */     
/* 491 */     this.n.setDrawable((Drawable)Game.i.assetManager.getDrawable("icon-times"));
/* 492 */     this.p = this.y;
/*     */     
/* 494 */     this.u = paramString;
/*     */     
/* 496 */     g();
/*     */   }
/*     */   
/*     */   public final void showConfirmWithCallbacks(CharSequence paramCharSequence, Runnable paramRunnable1, Runnable paramRunnable2) {
/* 500 */     showConfirmWithCallbacksAndId(paramCharSequence, paramRunnable1, paramRunnable2, "default");
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public final void showConfirmWithCallbacksAndId(CharSequence paramCharSequence, Runnable paramRunnable1, Runnable paramRunnable2, String paramString) {
/* 506 */     this.f.setText(paramCharSequence);
/*     */     
/* 508 */     this.i.setDrawable((Drawable)Game.i.assetManager.getDrawable("icon-check"));
/* 509 */     this.k = paramRunnable1;
/*     */     
/* 511 */     this.n.setDrawable((Drawable)Game.i.assetManager.getDrawable("icon-times"));
/* 512 */     this.p = paramRunnable2;
/*     */     
/* 514 */     this.u = paramString;
/*     */     
/* 516 */     g();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public final void showAlert(CharSequence paramCharSequence) {
/* 522 */     this.f.setText(paramCharSequence);
/*     */     
/* 524 */     this.k = null;
/*     */     
/* 526 */     this.n.setDrawable((Drawable)Game.i.assetManager.getDrawable("icon-check"));
/* 527 */     this.p = this.y;
/*     */     
/* 529 */     g();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public final void showAlertWithConfirmCallback(CharSequence paramCharSequence, Runnable paramRunnable) {
/* 535 */     this.f.setText(paramCharSequence);
/*     */     
/* 537 */     this.k = null;
/*     */     
/* 539 */     this.n.setDrawable((Drawable)Game.i.assetManager.getDrawable("icon-check"));
/* 540 */     this.p = paramRunnable;
/*     */     
/* 542 */     g();
/*     */   }
/*     */   
/*     */   private boolean h() {
/* 546 */     return (this.v > 0.0F);
/*     */   }
/*     */ 
/*     */   
/*     */   private void j() {
/* 551 */     if (h()) {
/* 552 */       String str = MathUtils.floor(this.v) + "." + (MathUtils.ceil(this.v * 10.0F) % 10) + Game.i.localeManager.i18n.get("TIME_CHAR_SECOND");
/* 553 */       if (this.k == null) {
/*     */         
/* 555 */         this.w = false;
/* 556 */         this.x = true;
/* 557 */         this.o.setText(str);
/*     */       } else {
/*     */         
/* 560 */         this.w = true;
/* 561 */         this.x = false;
/* 562 */         this.j.setText(str);
/*     */       } 
/*     */     } else {
/* 565 */       this.w = false;
/* 566 */       this.x = false;
/*     */     } 
/*     */     
/* 569 */     if (!this.w) {
/* 570 */       this.h.setColor(a);
/* 571 */       this.j.setVisible(false);
/* 572 */       this.i.setVisible(true);
/*     */     } else {
/* 574 */       this.h.setColor(d);
/* 575 */       this.j.setVisible(true);
/* 576 */       this.i.setVisible(false);
/*     */     } 
/*     */     
/* 579 */     if (!this.x) {
/* 580 */       this.m.setColor(a);
/* 581 */       this.o.setVisible(false);
/* 582 */       this.n.setVisible(true); return;
/*     */     } 
/* 584 */     this.m.setColor(d);
/* 585 */     this.o.setVisible(true);
/* 586 */     this.n.setVisible(false);
/*     */   }
/*     */ 
/*     */   
/*     */   public final void makeConfirmButtonDisabled(int paramInt) {
/* 591 */     if (paramInt < 0) paramInt = 0; 
/* 592 */     this.v = paramInt;
/* 593 */     j();
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi\\ui\shared\Dialog.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */