/*     */ package com.prineside.tdi2.ui.components;
/*     */ 
/*     */ import com.badlogic.gdx.Application;
/*     */ import com.badlogic.gdx.Gdx;
/*     */ import com.badlogic.gdx.graphics.Color;
/*     */ import com.badlogic.gdx.graphics.g2d.BitmapFont;
/*     */ import com.badlogic.gdx.utils.DelayedRemovalArray;
/*     */ import com.badlogic.gdx.utils.StringBuilder;
/*     */ import com.prineside.tdi2.Game;
/*     */ import com.prineside.tdi2.managers.SettingsManager;
/*     */ import com.prineside.tdi2.scene2d.Actor;
/*     */ import com.prineside.tdi2.scene2d.EventListener;
/*     */ import com.prineside.tdi2.scene2d.Group;
/*     */ import com.prineside.tdi2.scene2d.InputEvent;
/*     */ import com.prineside.tdi2.scene2d.InputListener;
/*     */ import com.prineside.tdi2.scene2d.Touchable;
/*     */ import com.prineside.tdi2.scene2d.ui.Image;
/*     */ import com.prineside.tdi2.scene2d.utils.Drawable;
/*     */ import com.prineside.tdi2.scene2d.utils.TextureRegionDrawable;
/*     */ import com.prineside.tdi2.ui.actors.ButtonHoldHint;
/*     */ import com.prineside.tdi2.ui.actors.HotKeyHintLabel;
/*     */ import com.prineside.tdi2.ui.actors.Label;
/*     */ import com.prineside.tdi2.utils.MaterialColor;
/*     */ 
/*     */ 
/*     */ public final class UpgradeSubmenu
/*     */   extends Group
/*     */ {
/*  29 */   private static final Color k = MaterialColor.GREEN.P800;
/*  30 */   private static final Color l = MaterialColor.GREEN.P900;
/*  31 */   private static final Color m = MaterialColor.LIGHT_BLUE.P800;
/*  32 */   private static final Color n = MaterialColor.LIGHT_BLUE.P700;
/*  33 */   private static final Color o = MaterialColor.LIGHT_BLUE.P900;
/*  34 */   private static final Color p = new Color(1.0F, 1.0F, 1.0F, 0.14F);
/*     */   
/*  36 */   private final Image[] q = new Image[10];
/*     */   
/*     */   private final Label r;
/*     */   private final Image s;
/*     */   private final Label t;
/*     */   private final Label u;
/*     */   private final Image v;
/*     */   private final Label w;
/*     */   private final Label x;
/*     */   public final Group upgradeButton;
/*  46 */   private int y = 10;
/*     */   
/*     */   private int z;
/*     */   
/*     */   private boolean A;
/*     */   
/*     */   private boolean B;
/*     */   private boolean C;
/*     */   private boolean D;
/*     */   private boolean E;
/*     */   private float F;
/*     */   private ButtonHoldHint G;
/*     */   private Image H;
/*  59 */   private final DelayedRemovalArray<UpgradeSubmenuListener> I = new DelayedRemovalArray(false, 1);
/*     */   
/*  61 */   private static final StringBuilder J = new StringBuilder();
/*     */   
/*     */   public UpgradeSubmenu() {
/*  64 */     setSize(600.0F, 116.0F);
/*  65 */     setTransform(false);
/*  66 */     setTouchable(Touchable.childrenOnly);
/*     */ 
/*     */     
/*  69 */     this.q[0] = new Image((Drawable)Game.i.assetManager.getDrawable("ui-upgrade-level-line-start"));
/*  70 */     this.q[0].setSize(42.0F, 24.0F);
/*  71 */     this.q[0].setPosition(40.0F, 92.0F);
/*  72 */     addActor((Actor)this.q[0]);
/*     */     
/*  74 */     TextureRegionDrawable textureRegionDrawable = Game.i.assetManager.getDrawable("ui-upgrade-level-line");
/*  75 */     for (byte b = 1; b < 10; b++) {
/*  76 */       this.q[b] = new Image((Drawable)textureRegionDrawable);
/*  77 */       this.q[b].setSize(46.0F, 24.0F);
/*  78 */       this.q[b].setPosition(80.0F + 44.0F * (b - 1), 92.0F);
/*  79 */       addActor((Actor)this.q[b]);
/*     */     } 
/*     */ 
/*     */     
/*  83 */     this.r = new Label("", new Label.LabelStyle((BitmapFont)Game.i.assetManager.getFont(24), Color.WHITE));
/*  84 */     this.r.setSize(80.0F, 24.0F);
/*  85 */     this.r.setPosition(480.0F, 92.0F);
/*  86 */     this.r.setAlignment(16);
/*  87 */     addActor((Actor)this.r);
/*     */ 
/*     */     
/*  90 */     this.upgradeButton = new Group();
/*     */     
/*  92 */     this.upgradeButton.setSize(338.0F, 80.0F);
/*  93 */     this.upgradeButton.setPosition(40.0F, 0.0F);
/*  94 */     this.upgradeButton.setTransform(false);
/*  95 */     this.upgradeButton.setTouchable(Touchable.enabled);
/*  96 */     this.upgradeButton.addListener((EventListener)new InputListener(this)
/*     */         {
/*     */           public boolean touchDown(InputEvent param1InputEvent, float param1Float1, float param1Float2, int param1Int1, int param1Int2) {
/*  99 */             if (param1Int2 == 0) {
/* 100 */               UpgradeSubmenu.a(this.a, true);
/* 101 */               this.a.d();
/*     */               
/* 103 */               UpgradeSubmenu.b(this.a, false);
/* 104 */               UpgradeSubmenu.a(this.a, 0.0F);
/*     */ 
/*     */               
/* 107 */               UpgradeSubmenu.a(this.a, new ButtonHoldHint(param1Float1, param1Float2, 0.75F));
/* 108 */               this.a.upgradeButton.addActor((Actor)UpgradeSubmenu.a(this.a));
/* 109 */             } else if (param1Int2 == 1) {
/*     */               
/* 111 */               if (Game.i.settingsManager.getCustomValue(SettingsManager.CustomValueType.INSTANT_HOLD_BUTTON_ON_RMB) == 1.0D) {
/* 112 */                 UpgradeSubmenu.a(this.a, true);
/* 113 */                 UpgradeSubmenu.a(this.a, 1.0F);
/*     */               } 
/*     */             } 
/*     */             
/* 117 */             return true;
/*     */           }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */           
/*     */           public void touchUp(InputEvent param1InputEvent, float param1Float1, float param1Float2, int param1Int1, int param1Int2) {
/*     */             // Byte code:
/*     */             //   0: aload_0
/*     */             //   1: aload_1
/*     */             //   2: fload_2
/*     */             //   3: fload_3
/*     */             //   4: iload #4
/*     */             //   6: iload #5
/*     */             //   8: invokespecial touchUp : (Lcom/prineside/tdi2/scene2d/InputEvent;FFII)V
/*     */             //   11: aload_0
/*     */             //   12: getfield a : Lcom/prineside/tdi2/ui/components/UpgradeSubmenu;
/*     */             //   15: iconst_0
/*     */             //   16: invokestatic a : (Lcom/prineside/tdi2/ui/components/UpgradeSubmenu;Z)Z
/*     */             //   19: pop
/*     */             //   20: aload_0
/*     */             //   21: getfield a : Lcom/prineside/tdi2/ui/components/UpgradeSubmenu;
/*     */             //   24: invokestatic b : (Lcom/prineside/tdi2/ui/components/UpgradeSubmenu;)Z
/*     */             //   27: ifne -> 112
/*     */             //   30: aload_0
/*     */             //   31: getfield a : Lcom/prineside/tdi2/ui/components/UpgradeSubmenu;
/*     */             //   34: invokestatic c : (Lcom/prineside/tdi2/ui/components/UpgradeSubmenu;)Z
/*     */             //   37: ifne -> 61
/*     */             //   40: aload_0
/*     */             //   41: getfield a : Lcom/prineside/tdi2/ui/components/UpgradeSubmenu;
/*     */             //   44: invokevirtual isButtonSelected : ()Z
/*     */             //   47: ifne -> 61
/*     */             //   50: aload_0
/*     */             //   51: getfield a : Lcom/prineside/tdi2/ui/components/UpgradeSubmenu;
/*     */             //   54: iconst_1
/*     */             //   55: invokevirtual setButtonSelected : (Z)V
/*     */             //   58: goto -> 68
/*     */             //   61: aload_0
/*     */             //   62: getfield a : Lcom/prineside/tdi2/ui/components/UpgradeSubmenu;
/*     */             //   65: invokestatic d : (Lcom/prineside/tdi2/ui/components/UpgradeSubmenu;)V
/*     */             //   68: aload_0
/*     */             //   69: getfield a : Lcom/prineside/tdi2/ui/components/UpgradeSubmenu;
/*     */             //   72: invokestatic a : (Lcom/prineside/tdi2/ui/components/UpgradeSubmenu;)Lcom/prineside/tdi2/ui/actors/ButtonHoldHint;
/*     */             //   75: ifnull -> 112
/*     */             //   78: aload_0
/*     */             //   79: getfield a : Lcom/prineside/tdi2/ui/components/UpgradeSubmenu;
/*     */             //   82: invokestatic a : (Lcom/prineside/tdi2/ui/components/UpgradeSubmenu;)Lcom/prineside/tdi2/ui/actors/ButtonHoldHint;
/*     */             //   85: astore_1
/*     */             //   86: invokestatic i : ()Lcom/prineside/tdi2/Threads;
/*     */             //   89: aload_1
/*     */             //   90: dup
/*     */             //   91: invokestatic requireNonNull : (Ljava/lang/Object;)Ljava/lang/Object;
/*     */             //   94: pop
/*     */             //   95: <illegal opcode> run : (Lcom/prineside/tdi2/ui/actors/PieChartActor;)Ljava/lang/Runnable;
/*     */             //   100: invokevirtual postRunnable : (Ljava/lang/Runnable;)V
/*     */             //   103: aload_0
/*     */             //   104: getfield a : Lcom/prineside/tdi2/ui/components/UpgradeSubmenu;
/*     */             //   107: aconst_null
/*     */             //   108: invokestatic a : (Lcom/prineside/tdi2/ui/components/UpgradeSubmenu;Lcom/prineside/tdi2/ui/actors/ButtonHoldHint;)Lcom/prineside/tdi2/ui/actors/ButtonHoldHint;
/*     */             //   111: pop
/*     */             //   112: aload_0
/*     */             //   113: getfield a : Lcom/prineside/tdi2/ui/components/UpgradeSubmenu;
/*     */             //   116: invokevirtual d : ()V
/*     */             //   119: return
/*     */             // Line number table:
/*     */             //   Java source line number -> byte code offset
/*     */             //   #122	-> 0
/*     */             //   #124	-> 11
/*     */             //   #126	-> 20
/*     */             //   #128	-> 30
/*     */             //   #130	-> 40
/*     */             //   #133	-> 50
/*     */             //   #137	-> 61
/*     */             //   #140	-> 68
/*     */             //   #141	-> 78
/*     */             //   #142	-> 86
/*     */             //   #143	-> 103
/*     */             //   #147	-> 112
/*     */             //   #148	-> 119
/*     */           }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */           
/*     */           public void enter(InputEvent param1InputEvent, float param1Float1, float param1Float2, int param1Int, Actor param1Actor) {
/* 152 */             super.enter(param1InputEvent, param1Float1, param1Float2, param1Int, param1Actor);
/*     */             
/* 154 */             if (param1Int == -1) {
/* 155 */               UpgradeSubmenu.c(this.a, true);
/* 156 */               if (UpgradeSubmenu.c(this.a)) {
/* 157 */                 this.a.setButtonSelected(true);
/*     */               }
/* 159 */               this.a.d();
/*     */             } 
/*     */           }
/*     */ 
/*     */           
/*     */           public void exit(InputEvent param1InputEvent, float param1Float1, float param1Float2, int param1Int, Actor param1Actor) {
/* 165 */             super.exit(param1InputEvent, param1Float1, param1Float2, param1Int, param1Actor);
/*     */             
/* 167 */             if (param1Int == -1) {
/* 168 */               UpgradeSubmenu.c(this.a, false);
/* 169 */               if (UpgradeSubmenu.c(this.a)) {
/* 170 */                 this.a.setButtonSelected(false);
/*     */               }
/* 172 */               this.a.d();
/*     */             } 
/*     */           }
/*     */         });
/* 176 */     addActor((Actor)this.upgradeButton);
/*     */     
/* 178 */     this.s = new Image((Drawable)Game.i.assetManager.getDrawable("ui-upgrade-button"));
/* 179 */     this.s.setSize(338.0F, 80.0F);
/* 180 */     this.upgradeButton.addActor((Actor)this.s);
/*     */     
/*     */     Image image;
/* 183 */     (image = new Image((Drawable)Game.i.assetManager.getDrawable("icon-double-arrow-up"))).setSize(40.0F, 40.0F);
/* 184 */     image.setPosition(20.0F, 20.0F);
/* 185 */     this.upgradeButton.addActor((Actor)image);
/*     */     
/* 187 */     this.w = new Label(Game.i.localeManager.i18n.get("do_upgrade"), new Label.LabelStyle((BitmapFont)Game.i.assetManager.getFont(30), Color.WHITE));
/* 188 */     this.w.setSize(100.0F, 40.0F);
/* 189 */     this.w.setPosition(80.0F, 20.0F);
/* 190 */     this.upgradeButton.addActor((Actor)this.w);
/*     */     
/* 192 */     this.x = new Label(Game.i.localeManager.i18n.get("click_to_confirm"), new Label.LabelStyle((BitmapFont)Game.i.assetManager.getFont(21), Color.WHITE));
/* 193 */     this.x.setSize(100.0F, 30.0F);
/* 194 */     this.x.setPosition(80.0F, 10.0F);
/* 195 */     this.x.setColor(1.0F, 1.0F, 1.0F, 0.56F);
/* 196 */     this.upgradeButton.addActor((Actor)this.x);
/*     */     
/* 198 */     if (HotKeyHintLabel.isEnabled()) {
/*     */       HotKeyHintLabel hotKeyHintLabel;
/* 200 */       (hotKeyHintLabel = new HotKeyHintLabel(Game.i.settingsManager.getHotKey(SettingsManager.HotkeyAction.UPGRADE_BUILDING), 12.0F, 59.0F, 8)).addVariant(Game.i.settingsManager.getHotKey(SettingsManager.HotkeyAction.UPGRADE_ALL_BUILDINGS));
/* 201 */       this.upgradeButton.addActor((Actor)hotKeyHintLabel);
/*     */     } 
/*     */     
/* 204 */     this.H = new Image((Drawable)Game.i.assetManager.getDrawable("button-hold-mark"));
/* 205 */     this.H.setSize(20.0F, 20.0F);
/* 206 */     this.H.setPosition(4.0F, 4.0F);
/* 207 */     this.upgradeButton.addActor((Actor)this.H);
/*     */     
/* 209 */     this.t = new Label(Game.i.localeManager.i18n.get("for_price_glue_word"), new Label.LabelStyle((BitmapFont)Game.i.assetManager.getFont(21), Color.WHITE));
/* 210 */     this.t.setColor(1.0F, 1.0F, 1.0F, 0.56F);
/* 211 */     this.t.setSize(50.0F, 80.0F);
/* 212 */     this.t.setPosition(378.0F, 0.0F);
/* 213 */     this.t.setAlignment(1);
/* 214 */     addActor((Actor)this.t);
/*     */     
/* 216 */     this.v = new Image((Drawable)Game.i.assetManager.getDrawable("game-ui-coin-icon"));
/* 217 */     this.v.setSize(40.0F, 40.0F);
/* 218 */     this.v.setPosition(436.0F, 20.0F);
/* 219 */     addActor((Actor)this.v);
/*     */     
/* 221 */     this.u = new Label("32123", new Label.LabelStyle((BitmapFont)Game.i.assetManager.getFont(30), Color.WHITE));
/* 222 */     this.u.setSize(132.0F, 80.0F);
/* 223 */     this.u.setPosition(428.0F, 0.0F);
/* 224 */     this.u.setAlignment(16);
/* 225 */     addActor((Actor)this.u);
/*     */     
/* 227 */     a(1, 1);
/* 228 */     setButtonSelected(false);
/* 229 */     g();
/* 230 */     d();
/*     */   }
/*     */ 
/*     */   
/*     */   public final void act(float paramFloat) {
/* 235 */     if (this.B) {
/* 236 */       this.F += paramFloat;
/* 237 */       if (this.F > 0.75F) {
/*     */         
/* 239 */         this.E = true;
/*     */         
/* 241 */         this.I.begin(); byte b; int i;
/* 242 */         for (b = 0, i = this.I.size; b < i; b++) {
/* 243 */           ((UpgradeSubmenuListener)this.I.get(b)).globalUpgradeButtonConfirmed();
/*     */         }
/* 245 */         this.I.end();
/*     */         
/* 247 */         if (this.G != null) {
/*     */           
/* 249 */           this.G.disappearing = true;
/* 250 */           this.G = null;
/*     */         } 
/*     */         
/* 253 */         this.B = false;
/*     */       } 
/*     */     } 
/*     */     
/* 257 */     super.act(paramFloat);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static boolean e() {
/* 264 */     if (Gdx.app.getType() == Application.ApplicationType.Android || Gdx.app.getType() == Application.ApplicationType.iOS)
/*     */     {
/* 266 */       return false;
/*     */     }
/*     */     
/* 269 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void f() {
/* 277 */     this.I.begin(); byte b; int i;
/* 278 */     for (b = 0, i = this.I.size; b < i; b++) {
/* 279 */       ((UpgradeSubmenuListener)this.I.get(b)).upgradeButtonConfirmed();
/*     */     }
/* 281 */     this.I.end();
/*     */   }
/*     */   
/*     */   public final void addListener(UpgradeSubmenuListener paramUpgradeSubmenuListener) {
/* 285 */     if (paramUpgradeSubmenuListener == null) {
/* 286 */       throw new IllegalArgumentException("listener is null");
/*     */     }
/*     */     
/* 289 */     if (!this.I.contains(paramUpgradeSubmenuListener, true)) {
/* 290 */       this.I.add(paramUpgradeSubmenuListener);
/*     */     }
/*     */   }
/*     */   
/*     */   public final void removeListener(UpgradeSubmenuListener paramUpgradeSubmenuListener) {
/* 295 */     if (paramUpgradeSubmenuListener == null) {
/* 296 */       throw new IllegalArgumentException("listener is null");
/*     */     }
/*     */     
/* 299 */     this.I.removeValue(paramUpgradeSubmenuListener, true);
/*     */   }
/*     */   
/*     */   public final void setButtonSelected(boolean paramBoolean) {
/* 303 */     this.D = paramBoolean;
/*     */     
/* 305 */     this.I.begin(); byte b; int i;
/* 306 */     for (b = 0, i = this.I.size; b < i; b++) {
/* 307 */       ((UpgradeSubmenuListener)this.I.get(b)).upgradeButtonStateChanged(paramBoolean);
/*     */     }
/* 309 */     this.I.end();
/*     */     
/* 311 */     d();
/*     */   }
/*     */   
/*     */   public final boolean isButtonSelected() {
/* 315 */     return (this.A && this.D);
/*     */   }
/*     */   
/*     */   final void a(int paramInt1, int paramInt2) {
/* 319 */     this.z = paramInt1;
/* 320 */     this.y = paramInt2;
/*     */     
/* 322 */     J.setLength(0);
/* 323 */     J.append(paramInt1).append(" LVL");
/* 324 */     this.r.setText((CharSequence)J);
/*     */     
/* 326 */     g();
/*     */   }
/*     */   
/*     */   final void a(boolean paramBoolean) {
/* 330 */     this.A = paramBoolean;
/* 331 */     if (!paramBoolean) {
/* 332 */       this.D = false;
/*     */     }
/* 334 */     d();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   final void a(int paramInt) {
/* 342 */     if (paramInt < 0) {
/*     */       
/* 344 */       this.t.setVisible(false);
/* 345 */       this.u.setText("MAX");
/* 346 */       this.v.setVisible(false);
/*     */       return;
/*     */     } 
/* 349 */     this.t.setVisible(true);
/*     */     
/* 351 */     J.setLength(0);
/* 352 */     J.append(paramInt);
/* 353 */     this.u.setText((CharSequence)J);
/* 354 */     this.v.setVisible(true);
/*     */   }
/*     */ 
/*     */   
/*     */   final void d() {
/* 359 */     this.H.setVisible(false);
/* 360 */     if (this.A) {
/* 361 */       this.H.setVisible(true);
/* 362 */       if (this.D) {
/* 363 */         if (this.B) {
/* 364 */           this.s.setColor(l);
/*     */         } else {
/* 366 */           this.s.setColor(k);
/*     */         } 
/* 368 */       } else if (this.B) {
/* 369 */         this.s.setColor(o);
/* 370 */       } else if (this.C) {
/* 371 */         this.s.setColor(n);
/*     */       } else {
/* 373 */         this.s.setColor(m);
/*     */       } 
/*     */     } else {
/* 376 */       this.s.setColor(p);
/*     */     } 
/*     */ 
/*     */     
/* 380 */     if (this.A && this.D) {
/* 381 */       this.x.setVisible(true);
/* 382 */       this.w.setY(30.0F); return;
/*     */     } 
/* 384 */     this.x.setVisible(false);
/* 385 */     this.w.setY(20.0F);
/*     */   }
/*     */ 
/*     */   
/*     */   private void g() {
/* 390 */     for (byte b = 0; b < this.q.length; b++) {
/* 391 */       if (b < this.z) {
/* 392 */         this.q[b].setVisible(true);
/* 393 */         this.q[b].setColor(Color.WHITE);
/* 394 */       } else if (b < this.y) {
/* 395 */         this.q[b].setVisible(true);
/* 396 */         this.q[b].setColor(1.0F, 1.0F, 1.0F, 0.14F);
/*     */       } else {
/* 398 */         this.q[b].setVisible(false);
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   public static interface UpgradeSubmenuListener {
/*     */     void upgradeButtonStateChanged(boolean param1Boolean);
/*     */     
/*     */     void upgradeButtonConfirmed();
/*     */     
/*     */     void globalUpgradeButtonConfirmed();
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi\\ui\components\UpgradeSubmenu.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */