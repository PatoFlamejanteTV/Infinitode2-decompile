/*     */ package com.prineside.tdi2.ui.actors;
/*     */ 
/*     */ import com.badlogic.gdx.graphics.Color;
/*     */ import com.badlogic.gdx.utils.Timer;
/*     */ import com.prineside.tdi2.Game;
/*     */ import com.prineside.tdi2.Threads;
/*     */ import com.prineside.tdi2.enums.StaticSoundType;
/*     */ import com.prineside.tdi2.managers.SettingsManager;
/*     */ import com.prineside.tdi2.scene2d.Actor;
/*     */ import com.prineside.tdi2.scene2d.EventListener;
/*     */ import com.prineside.tdi2.scene2d.Group;
/*     */ import com.prineside.tdi2.scene2d.InputEvent;
/*     */ import com.prineside.tdi2.scene2d.Touchable;
/*     */ import com.prineside.tdi2.scene2d.ui.Image;
/*     */ import com.prineside.tdi2.scene2d.utils.ClickListener;
/*     */ import com.prineside.tdi2.scene2d.utils.Drawable;
/*     */ import com.prineside.tdi2.utils.MaterialColor;
/*     */ import java.util.Objects;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class ComplexButton
/*     */   extends Group
/*     */ {
/*     */   private boolean l = false;
/*     */   private boolean m = false;
/*     */   private boolean n = true;
/*     */   private boolean o = false;
/*     */   public final Image background;
/*     */   public final Image backgroundShadow;
/*     */   public final Image iconShadow;
/*     */   public final Image icon;
/*     */   public final Label label;
/*     */   public final Label labelShadow;
/*     */   public Image holdHintIcon;
/*     */   protected boolean k;
/*  42 */   private final Color p = MaterialColor.LIGHT_BLUE.P800.cpy();
/*  43 */   private final Color q = MaterialColor.LIGHT_BLUE.P700.cpy();
/*  44 */   private final Color r = MaterialColor.LIGHT_BLUE.P900.cpy();
/*  45 */   private final Color s = MaterialColor.GREY.P800.cpy();
/*     */   
/*  47 */   private final Color t = Color.WHITE.cpy();
/*  48 */   private final Color u = Color.WHITE.cpy();
/*  49 */   private final Color v = Color.WHITE.cpy();
/*  50 */   private final Color w = MaterialColor.GREY.P500.cpy();
/*  51 */   private final Color x = Color.WHITE.cpy();
/*  52 */   private final Color y = Color.WHITE.cpy();
/*  53 */   private final Color z = Color.WHITE.cpy();
/*  54 */   private final Color A = MaterialColor.GREY.P500.cpy();
/*     */   
/*     */   private Runnable B;
/*     */   private Runnable C;
/*     */   
/*     */   public ComplexButton(CharSequence paramCharSequence, Label.LabelStyle paramLabelStyle, Runnable paramRunnable1, Runnable paramRunnable2) {
/*  60 */     this.B = paramRunnable1;
/*  61 */     this.C = paramRunnable2;
/*     */     
/*  63 */     setTransform(false);
/*     */     
/*  65 */     this.backgroundShadow = new Image();
/*  66 */     this.backgroundShadow.setVisible(false);
/*  67 */     addActor((Actor)this.backgroundShadow);
/*     */     
/*  69 */     this.background = new Image();
/*  70 */     addActor((Actor)this.background);
/*     */     
/*  72 */     this.iconShadow = new Image();
/*  73 */     this.iconShadow.setVisible(false);
/*  74 */     this.iconShadow.setColor(0.0F, 0.0F, 0.0F, 0.28F);
/*  75 */     addActor((Actor)this.iconShadow);
/*     */     
/*  77 */     this.icon = new Image();
/*  78 */     addActor((Actor)this.icon);
/*     */     
/*  80 */     this.labelShadow = new Label(paramCharSequence, paramLabelStyle);
/*  81 */     this.labelShadow.setColor(0.0F, 0.0F, 0.0F, 0.28F);
/*  82 */     this.labelShadow.setVisible(false);
/*  83 */     addActor((Actor)this.labelShadow);
/*     */     
/*  85 */     this.label = new Label(paramCharSequence, paramLabelStyle);
/*  86 */     addActor((Actor)this.label);
/*     */     
/*  88 */     setTouchable(Touchable.enabled);
/*  89 */     addListener((EventListener)new ClickListener(this) {
/*  90 */           private final Timer.Task b = new Timer.Task(this)
/*     */             {
/*     */               public void run() {
/*  93 */                 if (ComplexButton.null.a(this.a) != null) {
/*     */                   
/*  95 */                   (ComplexButton.null.a(this.a)).disappearing = true;
/*  96 */                   ComplexButton.null.a(this.a, null);
/*     */                 } 
/*     */                 
/*  99 */                 if (ComplexButton.a(this.a.a) != null) {
/* 100 */                   ComplexButton.a(this.a.a).run();
/*     */                 }
/*     */               }
/*     */             };
/*     */ 
/*     */           
/*     */           private ButtonHoldHint c;
/*     */           
/*     */           public void clicked(InputEvent param1InputEvent, float param1Float1, float param1Float2) {
/* 109 */             if (ComplexButton.b(this.a) && ComplexButton.c(this.a) != null) {
/*     */               
/* 111 */               ComplexButton.c(this.a).run();
/* 112 */               if (!ComplexButton.d(this.a)) Game.i.soundManager.playStatic(StaticSoundType.BUTTON);
/*     */             
/*     */             } 
/*     */           }
/*     */           
/*     */           public boolean touchDown(InputEvent param1InputEvent, float param1Float1, float param1Float2, int param1Int1, int param1Int2) {
/* 118 */             if (param1Int2 == 0) {
/*     */               
/* 120 */               ComplexButton.a(this.a, true);
/* 121 */               ComplexButton.e(this.a);
/*     */               
/* 123 */               if (this.b.isScheduled()) {
/* 124 */                 this.b.cancel();
/*     */               }
/*     */               
/* 127 */               if (ComplexButton.a(this.a) != null) {
/* 128 */                 Timer.schedule(this.b, 0.5F);
/*     */ 
/*     */                 
/* 131 */                 this.c = new ButtonHoldHint(param1Float1, param1Float2, 0.5F);
/* 132 */                 this.a.addActor((Actor)this.c);
/*     */               } 
/* 134 */             } else if (param1Int2 == 1) {
/*     */               
/* 136 */               if (Game.i.settingsManager.getCustomValue(SettingsManager.CustomValueType.INSTANT_HOLD_BUTTON_ON_RMB) == 1.0D) {
/* 137 */                 if (this.b.isScheduled()) {
/* 138 */                   this.b.cancel();
/*     */                 }
/* 140 */                 this.b.run();
/*     */               } 
/*     */             } 
/*     */             
/* 144 */             return super.touchDown(param1InputEvent, param1Float1, param1Float2, param1Int1, param1Int2);
/*     */           }
/*     */ 
/*     */           
/*     */           public void touchUp(InputEvent param1InputEvent, float param1Float1, float param1Float2, int param1Int1, int param1Int2) {
/* 149 */             ComplexButton.a(this.a, false);
/* 150 */             ComplexButton.e(this.a);
/*     */             
/* 152 */             if (ComplexButton.a(this.a) != null && !this.b.isScheduled())
/*     */             {
/* 154 */               cancel();
/*     */             }
/* 156 */             this.b.cancel();
/* 157 */             if (this.c != null) {
/* 158 */               ButtonHoldHint buttonHoldHint = this.c;
/* 159 */               Objects.requireNonNull(buttonHoldHint); Threads.i().postRunnable(buttonHoldHint::remove);
/* 160 */               this.c = null;
/*     */             } 
/*     */             
/* 163 */             super.touchUp(param1InputEvent, param1Float1, param1Float2, param1Int1, param1Int2);
/*     */           }
/*     */ 
/*     */           
/*     */           public void enter(InputEvent param1InputEvent, float param1Float1, float param1Float2, int param1Int, Actor param1Actor) {
/* 168 */             if (param1Int == -1) {
/* 169 */               ComplexButton.b(this.a, true);
/* 170 */               ComplexButton.e(this.a);
/*     */             } 
/*     */             
/* 173 */             super.enter(param1InputEvent, param1Float1, param1Float2, param1Int, param1Actor);
/*     */           }
/*     */ 
/*     */           
/*     */           public void exit(InputEvent param1InputEvent, float param1Float1, float param1Float2, int param1Int, Actor param1Actor) {
/* 178 */             if (param1Int == -1) {
/* 179 */               ComplexButton.b(this.a, false);
/* 180 */               ComplexButton.e(this.a);
/*     */             } 
/*     */             
/* 183 */             super.exit(param1InputEvent, param1Float1, param1Float2, param1Int, param1Actor);
/*     */           }
/*     */         });
/*     */     
/* 187 */     if (paramRunnable2 != null) {
/* 188 */       this.holdHintIcon = new Image((Drawable)Game.i.assetManager.getDrawable("button-hold-mark"));
/* 189 */       this.holdHintIcon.setSize(20.0F, 20.0F);
/* 190 */       this.holdHintIcon.setPosition(12.0F, 12.0F);
/* 191 */       addActor((Actor)this.holdHintIcon);
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/* 196 */     d();
/*     */   }
/*     */   
/*     */   public ComplexButton(CharSequence paramCharSequence, Label.LabelStyle paramLabelStyle, Runnable paramRunnable) {
/* 200 */     this(paramCharSequence, paramLabelStyle, paramRunnable, (Runnable)null);
/*     */   }
/*     */   
/*     */   public void setHoldHintIconBright(boolean paramBoolean) {
/* 204 */     if (this.holdHintIcon != null) {
/* 205 */       if (paramBoolean) {
/* 206 */         this.holdHintIcon.setDrawable((Drawable)Game.i.assetManager.getDrawable("button-hold-mark-white")); return;
/*     */       } 
/* 208 */       this.holdHintIcon.setDrawable((Drawable)Game.i.assetManager.getDrawable("button-hold-mark"));
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void setMuted(boolean paramBoolean) {
/* 214 */     this.o = paramBoolean;
/*     */   }
/*     */   
/*     */   public void setClickHandler(Runnable paramRunnable) {
/* 218 */     this.B = paramRunnable;
/*     */   }
/*     */   
/*     */   public ComplexButton setBackground(Drawable paramDrawable, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4) {
/* 222 */     this.background.setDrawable(paramDrawable);
/* 223 */     this.background.setPosition(paramFloat1, paramFloat2);
/* 224 */     this.background.setSize(paramFloat3, paramFloat4);
/*     */     
/* 226 */     return this;
/*     */   }
/*     */   
/*     */   public ComplexButton setIconPositioned(Drawable paramDrawable, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4) {
/* 230 */     this.icon.setDrawable(paramDrawable);
/* 231 */     this.icon.setPosition(paramFloat1, paramFloat2);
/* 232 */     this.icon.setSize(paramFloat3, paramFloat4);
/*     */     
/* 234 */     this.iconShadow.setDrawable(paramDrawable);
/* 235 */     this.iconShadow.setPosition(paramFloat1, paramFloat2 - 3.0F);
/* 236 */     this.iconShadow.setSize(paramFloat3, paramFloat4);
/*     */     
/* 238 */     return this;
/*     */   }
/*     */   
/*     */   public ComplexButton setIcon(Drawable paramDrawable) {
/* 242 */     this.icon.setDrawable(paramDrawable);
/* 243 */     this.iconShadow.setDrawable(paramDrawable);
/*     */     
/* 245 */     return this;
/*     */   }
/*     */   
/*     */   public ComplexButton setText(CharSequence paramCharSequence) {
/* 249 */     this.label.setText(paramCharSequence);
/*     */     
/* 251 */     return this;
/*     */   }
/*     */   
/*     */   public ComplexButton setTextFromInt(int paramInt) {
/* 255 */     this.label.setTextFromInt(paramInt);
/* 256 */     this.labelShadow.setTextFromInt(paramInt);
/*     */     
/* 258 */     return this;
/*     */   }
/*     */   
/*     */   public ComplexButton setLabel(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, int paramInt) {
/* 262 */     this.label.setPosition(paramFloat1, paramFloat2);
/* 263 */     this.label.setSize(paramFloat3, paramFloat4);
/* 264 */     this.label.setAlignment(paramInt);
/* 265 */     this.labelShadow.setPosition(paramFloat1, paramFloat2 - 2.0F);
/* 266 */     this.labelShadow.setSize(paramFloat3, paramFloat4);
/* 267 */     this.labelShadow.setAlignment(paramInt);
/* 268 */     this.k = true;
/*     */     
/* 270 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ComplexButton setBackgroundColors(Color paramColor1, Color paramColor2, Color paramColor3, Color paramColor4) {
/* 277 */     if (paramColor1 != null) this.p.set(paramColor1); 
/* 278 */     if (paramColor3 != null) this.q.set(paramColor3); 
/* 279 */     if (paramColor2 != null) this.r.set(paramColor2); 
/* 280 */     if (paramColor4 != null) this.s.set(paramColor4); 
/* 281 */     d();
/*     */     
/* 283 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ComplexButton setIconLabelColors(Color paramColor1, Color paramColor2, Color paramColor3, Color paramColor4) {
/* 290 */     setIconColors(paramColor1, paramColor2, paramColor3, paramColor4);
/* 291 */     setLabelColors(paramColor1, paramColor2, paramColor3, paramColor4);
/*     */     
/* 293 */     return this;
/*     */   }
/*     */   
/*     */   public ComplexButton setIconColors(Color paramColor1, Color paramColor2, Color paramColor3, Color paramColor4) {
/* 297 */     if (paramColor1 != null) this.x.set(paramColor1); 
/* 298 */     if (paramColor3 != null) this.z.set(paramColor3); 
/* 299 */     if (paramColor2 != null) this.y.set(paramColor2); 
/* 300 */     if (paramColor4 != null) this.A.set(paramColor4);
/*     */     
/* 302 */     d();
/*     */     
/* 304 */     return this;
/*     */   }
/*     */   
/*     */   public void setIconLabelShadowEnabled(boolean paramBoolean) {
/* 308 */     this.iconShadow.setVisible(paramBoolean);
/* 309 */     this.labelShadow.setVisible(paramBoolean);
/*     */   }
/*     */   
/*     */   public ComplexButton setLabelColors(Color paramColor1, Color paramColor2, Color paramColor3, Color paramColor4) {
/* 313 */     if (paramColor1 != null) this.t.set(paramColor1); 
/* 314 */     if (paramColor3 != null) this.v.set(paramColor3); 
/* 315 */     if (paramColor2 != null) this.u.set(paramColor2); 
/* 316 */     if (paramColor4 != null) this.w.set(paramColor4);
/*     */     
/* 318 */     d();
/*     */     
/* 320 */     return this;
/*     */   }
/*     */   
/*     */   public ComplexButton setEnabled(boolean paramBoolean) {
/* 324 */     this.n = paramBoolean;
/* 325 */     d();
/*     */     
/* 327 */     return this;
/*     */   }
/*     */   
/*     */   private void d() {
/* 331 */     if (this.n) {
/* 332 */       if (this.l) {
/* 333 */         this.label.setColor(this.v);
/* 334 */         this.icon.setColor(this.z);
/* 335 */         this.background.setColor(this.r); return;
/* 336 */       }  if (this.m) {
/* 337 */         this.label.setColor(this.u);
/* 338 */         this.icon.setColor(this.y);
/* 339 */         this.background.setColor(this.q); return;
/*     */       } 
/* 341 */       this.label.setColor(this.t);
/* 342 */       this.icon.setColor(this.x);
/* 343 */       this.background.setColor(this.p);
/*     */       return;
/*     */     } 
/* 346 */     this.background.setColor(this.s);
/* 347 */     this.label.setColor(this.w);
/* 348 */     this.icon.setColor(this.A);
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi\\ui\actors\ComplexButton.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */