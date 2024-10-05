/*     */ package com.prineside.tdi2.ui.components;
/*     */ 
/*     */ import com.badlogic.gdx.Application;
/*     */ import com.badlogic.gdx.Gdx;
/*     */ import com.badlogic.gdx.graphics.Color;
/*     */ import com.badlogic.gdx.utils.DelayedRemovalArray;
/*     */ import com.prineside.tdi2.Game;
/*     */ import com.prineside.tdi2.Threads;
/*     */ import com.prineside.tdi2.managers.SettingsManager;
/*     */ import com.prineside.tdi2.scene2d.Action;
/*     */ import com.prineside.tdi2.scene2d.Actor;
/*     */ import com.prineside.tdi2.scene2d.EventListener;
/*     */ import com.prineside.tdi2.scene2d.Group;
/*     */ import com.prineside.tdi2.scene2d.InputEvent;
/*     */ import com.prineside.tdi2.scene2d.InputListener;
/*     */ import com.prineside.tdi2.scene2d.Touchable;
/*     */ import com.prineside.tdi2.scene2d.actions.Actions;
/*     */ import com.prineside.tdi2.scene2d.ui.Image;
/*     */ import com.prineside.tdi2.scene2d.utils.Drawable;
/*     */ import com.prineside.tdi2.ui.actors.ButtonHoldHint;
/*     */ import com.prineside.tdi2.ui.shared.Dialog;
/*     */ import com.prineside.tdi2.utils.MaterialColor;
/*     */ import java.util.Objects;
/*     */ 
/*     */ 
/*     */ public final class TowerAbilityButton
/*     */   extends Group
/*     */ {
/*  29 */   private static final Color k = new Color(0.0F, 0.0F, 0.0F, 0.14F);
/*  30 */   private static final Color l = MaterialColor.LIGHT_BLUE.P800;
/*  31 */   private static final Color m = MaterialColor.LIGHT_BLUE.P700;
/*  32 */   private static final Color n = MaterialColor.LIGHT_BLUE.P900;
/*  33 */   private static final Color o = MaterialColor.GREEN.P500.cpy().mul(1.0F, 1.0F, 1.0F, 0.21F);
/*     */   
/*     */   private final int p;
/*     */   
/*     */   private final Image q;
/*     */   
/*     */   private final Image r;
/*     */   
/*     */   private final Image s;
/*     */   
/*     */   private final Image t;
/*     */   
/*     */   private final Image u;
/*     */   
/*     */   private final Image v;
/*     */   private boolean w;
/*     */   private boolean x;
/*     */   private boolean y;
/*     */   private boolean z;
/*     */   private boolean A;
/*     */   private boolean B;
/*     */   private boolean C;
/*     */   private float D;
/*     */   private ButtonHoldHint E;
/*     */   private Image F;
/*  58 */   private final DelayedRemovalArray<AbilityButtonListener> G = new DelayedRemovalArray(false, 1);
/*     */   
/*     */   TowerAbilityButton(int paramInt) {
/*  61 */     this.p = paramInt;
/*     */     
/*  63 */     setSize(80.0F, 80.0F);
/*  64 */     setTransform(false);
/*  65 */     setTouchable(Touchable.enabled);
/*     */     
/*  67 */     this.q = new Image((Drawable)Game.i.assetManager.getDrawable("blank"));
/*  68 */     this.q.setSize(80.0F, 80.0F);
/*  69 */     this.q.setTouchable(Touchable.disabled);
/*  70 */     addActor((Actor)this.q);
/*     */     
/*  72 */     this.t = new Image();
/*  73 */     this.t.setSize(86.0F, 86.0F);
/*  74 */     this.t.setPosition(-3.0F, -3.0F);
/*  75 */     this.t.setTouchable(Touchable.disabled);
/*  76 */     addActor((Actor)this.t);
/*     */     
/*  78 */     this.r = new Image((Drawable)Game.i.assetManager.getDrawable("ui-tower-ability-outline"));
/*  79 */     this.r.setSize(86.0F, 86.0F);
/*  80 */     this.r.setPosition(-3.0F, -3.0F);
/*  81 */     this.r.setVisible(false);
/*  82 */     this.r.setTouchable(Touchable.disabled);
/*  83 */     addActor((Actor)this.r);
/*     */     
/*  85 */     this.s = new Image((Drawable)Game.i.assetManager.getDrawable("icon-check"));
/*  86 */     this.s.setSize(21.0F, 21.0F);
/*  87 */     this.s.setPosition(64.0F, -4.0F);
/*  88 */     this.s.setColor(MaterialColor.GREEN.P500);
/*  89 */     this.s.setVisible(false);
/*  90 */     this.s.setTouchable(Touchable.disabled);
/*  91 */     addActor((Actor)this.s);
/*     */     
/*  93 */     this.u = new Image();
/*  94 */     this.u.setSize(86.0F, 86.0F);
/*  95 */     this.u.setPosition(-3.0F, -3.0F);
/*  96 */     this.u.setTouchable(Touchable.disabled);
/*  97 */     addActor((Actor)this.u);
/*     */     
/*  99 */     this.v = new Image();
/* 100 */     this.v.setTouchable(Touchable.disabled);
/* 101 */     this.v.setVisible(false);
/* 102 */     this.v.setSize(86.0F, 86.0F);
/* 103 */     this.v.setPosition(-3.0F, -3.0F);
/* 104 */     addActor((Actor)this.v);
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
/*     */     
/* 121 */     addListener((EventListener)new InputListener(this, paramInt)
/*     */         {
/*     */           public void enter(InputEvent param1InputEvent, float param1Float1, float param1Float2, int param1Int, Actor param1Actor) {
/* 124 */             super.enter(param1InputEvent, param1Float1, param1Float2, param1Int, param1Actor);
/*     */             
/* 126 */             if (param1Int == -1) {
/* 127 */               TowerAbilityButton.a(this.b, true);
/* 128 */               if (TowerAbilityButton.a(this.b)) {
/* 129 */                 this.b.setSelected(true);
/*     */               }
/*     */               
/* 132 */               this.b.d();
/*     */             } 
/*     */           }
/*     */ 
/*     */           
/*     */           public void exit(InputEvent param1InputEvent, float param1Float1, float param1Float2, int param1Int, Actor param1Actor) {
/* 138 */             super.exit(param1InputEvent, param1Float1, param1Float2, param1Int, param1Actor);
/*     */             
/* 140 */             if (param1Int == -1) {
/* 141 */               TowerAbilityButton.a(this.b, false);
/* 142 */               if (TowerAbilityButton.a(this.b)) {
/* 143 */                 this.b.setSelected(false);
/*     */               }
/*     */               
/* 146 */               this.b.d();
/*     */             } 
/*     */           }
/*     */ 
/*     */           
/*     */           public void touchUp(InputEvent param1InputEvent, float param1Float1, float param1Float2, int param1Int1, int param1Int2) {
/* 152 */             super.touchUp(param1InputEvent, param1Float1, param1Float2, param1Int1, param1Int2);
/*     */             
/* 154 */             TowerAbilityButton.b(this.b, false);
/*     */             
/* 156 */             if (!TowerAbilityButton.b(this.b) && TowerAbilityButton.c(this.b) && !TowerAbilityButton.d(this.b)) {
/* 157 */               if (TowerAbilityButton.a(this.b)) {
/* 158 */                 TowerAbilityButton.e(this.b);
/*     */               }
/* 160 */               else if (this.b.isSelected()) {
/* 161 */                 TowerAbilityButton.e(this.b);
/*     */               } else {
/* 163 */                 this.b.setSelected(true);
/*     */               } 
/*     */             }
/*     */ 
/*     */             
/* 168 */             if (TowerAbilityButton.f(this.b) != null) {
/* 169 */               ButtonHoldHint buttonHoldHint = TowerAbilityButton.f(this.b);
/* 170 */               Objects.requireNonNull(buttonHoldHint); Threads.i().postRunnable(buttonHoldHint::remove);
/* 171 */               TowerAbilityButton.a(this.b, (ButtonHoldHint)null);
/*     */             } 
/*     */             
/* 174 */             TowerAbilityButton.c(this.b, false);
/*     */             
/* 176 */             this.b.d();
/*     */           }
/*     */ 
/*     */           
/*     */           public boolean touchDown(InputEvent param1InputEvent, float param1Float1, float param1Float2, int param1Int1, int param1Int2) {
/* 181 */             if (param1Int2 == 0) {
/* 182 */               TowerAbilityButton.b(this.b, true);
/* 183 */               this.b.d();
/*     */               
/* 185 */               TowerAbilityButton.c(this.b, true);
/* 186 */               TowerAbilityButton.d(this.b, false);
/* 187 */               TowerAbilityButton.a(this.b, 0.0F);
/*     */ 
/*     */               
/* 190 */               if (this.a != 3) {
/* 191 */                 TowerAbilityButton.a(this.b, new ButtonHoldHint(param1Float1, param1Float2, 0.75F));
/* 192 */                 this.b.addActor((Actor)TowerAbilityButton.f(this.b));
/*     */               } 
/* 194 */             } else if (param1Int2 == 1) {
/*     */               
/* 196 */               if (Game.i.settingsManager.getCustomValue(SettingsManager.CustomValueType.INSTANT_HOLD_BUTTON_ON_RMB) == 1.0D) {
/* 197 */                 TowerAbilityButton.c(this.b, true);
/* 198 */                 TowerAbilityButton.a(this.b, 1.0F);
/*     */               } 
/*     */             } 
/*     */             
/* 202 */             return true;
/*     */           }
/*     */         });
/*     */     
/* 206 */     this.F = new Image((Drawable)Game.i.assetManager.getDrawable("button-hold-mark"));
/* 207 */     this.F.setSize(20.0F, 20.0F);
/* 208 */     this.F.setPosition(4.0F, 4.0F);
/* 209 */     addActor((Actor)this.F);
/*     */     
/* 211 */     a((Drawable)null, (Drawable)null, (Drawable)null);
/* 212 */     d();
/*     */   }
/*     */   
/*     */   private void e() {
/* 216 */     this.G.begin(); byte b; int i;
/* 217 */     for (b = 0, i = this.G.size; b < i; b++) {
/* 218 */       ((AbilityButtonListener)this.G.get(b)).abilityConfirmed();
/*     */     }
/* 220 */     this.G.end();
/*     */   }
/*     */   
/*     */   public final void addListener(AbilityButtonListener paramAbilityButtonListener) {
/* 224 */     if (paramAbilityButtonListener == null) throw new IllegalArgumentException("listener is null");
/*     */     
/* 226 */     if (!this.G.contains(paramAbilityButtonListener, true)) {
/* 227 */       this.G.add(paramAbilityButtonListener);
/*     */     }
/*     */   }
/*     */   
/*     */   public final void removeListener(AbilityButtonListener paramAbilityButtonListener) {
/* 232 */     if (paramAbilityButtonListener == null) throw new IllegalArgumentException("listener is null");
/*     */     
/* 234 */     this.G.removeValue(paramAbilityButtonListener, true);
/*     */   }
/*     */   
/*     */   public final boolean isSelected() {
/* 238 */     return (this.x && this.A);
/*     */   }
/*     */ 
/*     */   
/*     */   public final void setSelected(boolean paramBoolean) {
/* 243 */     this.A = paramBoolean;
/*     */     
/* 245 */     d();
/*     */   }
/*     */   
/*     */   final void a(boolean paramBoolean) {
/* 249 */     this.x = paramBoolean;
/* 250 */     d();
/*     */   }
/*     */   
/*     */   final void b(boolean paramBoolean) {
/* 254 */     this.w = paramBoolean;
/* 255 */     d();
/*     */   }
/*     */   
/*     */   private static boolean f() {
/* 259 */     if (Gdx.app.getType() == Application.ApplicationType.Android || Gdx.app.getType() == Application.ApplicationType.iOS)
/*     */     {
/* 261 */       return false;
/*     */     }
/*     */     
/* 264 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   final void a(Drawable paramDrawable1, Drawable paramDrawable2, Drawable paramDrawable3) {
/* 269 */     if (paramDrawable1 != null) {
/* 270 */       this.t.setDrawable(paramDrawable1);
/* 271 */       this.t.setColor(0.0F, 0.0F, 0.0F, 0.21F);
/* 272 */       this.t.setVisible(true);
/*     */     } else {
/* 274 */       this.t.setVisible(false);
/*     */     } 
/*     */     
/* 277 */     if (paramDrawable2 != null) {
/* 278 */       this.u.setDrawable(paramDrawable2);
/* 279 */       this.u.setColor(0.78F, 0.78F, 0.78F, 1.0F);
/* 280 */       this.u.setVisible(true);
/*     */     } else {
/* 282 */       this.u.setVisible(false);
/*     */     } 
/*     */     
/* 285 */     if (paramDrawable3 != null) {
/* 286 */       this.v.setDrawable(paramDrawable3);
/* 287 */       this.v.setVisible(true); return;
/*     */     } 
/* 289 */     this.v.setVisible(false);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public final void act(float paramFloat) {
/* 295 */     if (this.B) {
/* 296 */       this.D += paramFloat;
/* 297 */       if (this.D > 0.75F) {
/*     */         
/* 299 */         if (this.p != 3) {
/*     */           
/* 301 */           this.C = true;
/*     */           
/* 303 */           if (this.E != null) {
/*     */             
/* 305 */             this.E.disappearing = true;
/* 306 */             this.E = null;
/*     */           } 
/*     */           
/* 309 */           Dialog.i().showConfirm(Game.i.localeManager.i18n.get("select_ability_for_all_towers_confirm"), () -> {
/*     */                 this.G.begin(); byte b = 0; int i = this.G.size;
/*     */                 while (b < i) {
/*     */                   ((AbilityButtonListener)this.G.get(b)).globalAbilityConfirmed();
/*     */                   b++;
/*     */                 } 
/*     */                 this.G.end();
/*     */               });
/*     */         } 
/* 318 */         this.B = false;
/*     */       } 
/*     */     } 
/*     */     
/* 322 */     super.act(paramFloat);
/*     */   }
/*     */   
/*     */   final void d() {
/* 326 */     this.r.setVisible(this.A);
/* 327 */     this.F.setVisible(false);
/* 328 */     if (this.w) {
/* 329 */       this.s.setVisible(true);
/* 330 */       this.q.setColor(o);
/* 331 */       this.q.clearActions(); return;
/*     */     } 
/* 333 */     this.s.setVisible(false);
/* 334 */     if (this.x) {
/* 335 */       if (this.A) {
/* 336 */         this.q.setColor(n);
/* 337 */         this.q.clearActions();
/* 338 */       } else if (this.y) {
/* 339 */         this.q.setColor(n);
/* 340 */         this.q.clearActions();
/* 341 */       } else if (this.z) {
/* 342 */         this.q.setColor(m);
/* 343 */         this.q.clearActions();
/*     */       }
/* 345 */       else if (!this.q.hasActions()) {
/* 346 */         this.q.setColor(l);
/* 347 */         this.q.addAction((Action)Actions.forever((Action)Actions.sequence((Action)Actions.color(l, 0.5F), (Action)Actions.color(n, 0.7F))));
/*     */       } 
/*     */       
/* 350 */       this.F.setVisible(true); return;
/*     */     } 
/* 352 */     this.q.setColor(k);
/* 353 */     this.q.clearActions();
/*     */   }
/*     */   
/*     */   public static interface AbilityButtonListener {
/*     */     void abilityConfirmed();
/*     */     
/*     */     void globalAbilityConfirmed();
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi\\ui\components\TowerAbilityButton.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */