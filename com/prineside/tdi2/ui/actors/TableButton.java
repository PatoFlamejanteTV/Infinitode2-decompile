/*     */ package com.prineside.tdi2.ui.actors;
/*     */ import com.badlogic.gdx.graphics.Color;
/*     */ import com.badlogic.gdx.utils.Array;
/*     */ import com.badlogic.gdx.utils.Timer;
/*     */ import com.prineside.tdi2.Game;
/*     */ import com.prineside.tdi2.enums.StaticSoundType;
/*     */ import com.prineside.tdi2.scene2d.Actor;
/*     */ import com.prineside.tdi2.scene2d.EventListener;
/*     */ import com.prineside.tdi2.scene2d.InputEvent;
/*     */ import com.prineside.tdi2.scene2d.Touchable;
/*     */ import com.prineside.tdi2.scene2d.ui.Cell;
/*     */ import com.prineside.tdi2.scene2d.ui.Image;
/*     */ import com.prineside.tdi2.scene2d.ui.Table;
/*     */ import com.prineside.tdi2.scene2d.utils.ClickListener;
/*     */ import com.prineside.tdi2.scene2d.utils.Drawable;
/*     */ import com.prineside.tdi2.utils.MaterialColor;
/*     */ 
/*     */ public class TableButton extends Table {
/*     */   private Runnable k;
/*     */   private Runnable l;
/*  21 */   public static final Color DEFAULT_NORMAL_BG_COLOR = Color.WHITE.cpy();
/*  22 */   public static final Color DEFAULT_HOVER_BG_COLOR = Color.WHITE.cpy();
/*  23 */   public static final Color DEFAULT_ACTIVE_BG_COLOR = Color.WHITE.cpy();
/*  24 */   public static final Color DEFAULT_DISABLED_BG_COLOR = Color.WHITE.cpy();
/*     */   
/*     */   private boolean n = false;
/*     */   
/*     */   private boolean o = false;
/*     */   
/*     */   private boolean p = true;
/*     */   
/*     */   private boolean q = false;
/*     */   private final Image r;
/*     */   public boolean clickableWhenDisabled;
/*     */   private Drawable s;
/*     */   private Drawable t;
/*     */   private Drawable u;
/*     */   private Drawable v;
/*  39 */   private final Color w = DEFAULT_NORMAL_BG_COLOR.cpy();
/*  40 */   private final Color x = DEFAULT_HOVER_BG_COLOR.cpy();
/*  41 */   private final Color y = DEFAULT_ACTIVE_BG_COLOR.cpy();
/*  42 */   private final Color z = DEFAULT_DISABLED_BG_COLOR.cpy();
/*     */   
/*  44 */   private final Color A = Color.WHITE.cpy();
/*  45 */   private final Color B = Color.WHITE.cpy();
/*  46 */   private final Color C = Color.WHITE.cpy();
/*  47 */   private final Color D = MaterialColor.GREY.P500.cpy();
/*     */   
/*     */   private boolean E;
/*     */   
/*     */   public TableButton(Runnable paramRunnable) {
/*  52 */     this(paramRunnable, (Runnable)null);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public TableButton(Runnable paramRunnable1, Runnable paramRunnable2) {
/*  58 */     this.k = paramRunnable1;
/*  59 */     this.l = paramRunnable2;
/*     */     
/*  61 */     this.r = new Image();
/*  62 */     this.r.setFillParent(true);
/*  63 */     addActor((Actor)this.r);
/*     */     
/*  65 */     setTouchable(Touchable.enabled);
/*  66 */     addListener((EventListener)new ClickListener(this) {
/*  67 */           private final Timer.Task b = new Timer.Task(this)
/*     */             {
/*     */               public void run() {
/*  70 */                 TableButton.null.a(this.a);
/*     */                 
/*  72 */                 if (TableButton.a(this.a.a) != null) {
/*  73 */                   TableButton.a(this.a.a).run();
/*  74 */                   if (!TableButton.b(this.a.a)) Game.i.soundManager.playStatic(StaticSoundType.BUTTON); 
/*     */                 } 
/*     */               }
/*     */             };
/*     */           private ButtonHoldHint c;
/*     */           
/*     */           private void a() {
/*  81 */             if (this.c != null) {
/*  82 */               this.c.disappearing = true;
/*  83 */               this.c = null;
/*     */             } 
/*     */           }
/*     */ 
/*     */ 
/*     */           
/*     */           public void clicked(InputEvent param1InputEvent, float param1Float1, float param1Float2) {
/*     */             boolean bool;
/*  91 */             if ((bool = (this.a.clickableWhenDisabled || TableButton.c(this.a)) ? true : false) && TableButton.d(this.a) != null) {
/*  92 */               TableButton.d(this.a).run();
/*  93 */               if (!TableButton.b(this.a)) Game.i.soundManager.playStatic(StaticSoundType.BUTTON);
/*     */             
/*     */             } 
/*     */           }
/*     */           
/*     */           public boolean touchDown(InputEvent param1InputEvent, float param1Float1, float param1Float2, int param1Int1, int param1Int2) {
/*  99 */             if (param1Int2 == 0) {
/*     */               
/* 101 */               TableButton.a(this.a, true);
/* 102 */               TableButton.e(this.a);
/*     */               
/* 104 */               if (this.b.isScheduled()) {
/* 105 */                 this.b.cancel();
/*     */               }
/*     */               
/* 108 */               if (TableButton.a(this.a) != null) {
/* 109 */                 Timer.schedule(this.b, 0.5F);
/*     */ 
/*     */                 
/* 112 */                 a();
/* 113 */                 this.c = new ButtonHoldHint(param1Float1, param1Float2, 0.5F);
/* 114 */                 this.a.addActor((Actor)this.c);
/*     */               } 
/*     */               
/*     */               boolean bool;
/* 118 */               if (bool = super.touchDown(param1InputEvent, param1Float1, param1Float2, param1Int1, param1Int2)) {
/* 119 */                 param1InputEvent.halt();
/*     */               }
/*     */               
/* 122 */               return bool;
/* 123 */             }  if (param1Int2 == 1) {
/*     */               
/* 125 */               if (TableButton.a(this.a) != null) {
/* 126 */                 TableButton.a(this.a).run();
/* 127 */                 if (!TableButton.b(this.a)) Game.i.soundManager.playStatic(StaticSoundType.BUTTON); 
/*     */               } 
/* 129 */               return false;
/*     */             } 
/* 131 */             return false;
/*     */           }
/*     */ 
/*     */ 
/*     */           
/*     */           public void touchUp(InputEvent param1InputEvent, float param1Float1, float param1Float2, int param1Int1, int param1Int2) {
/* 137 */             TableButton.a(this.a, false);
/* 138 */             TableButton.e(this.a);
/*     */             
/* 140 */             if (TableButton.a(this.a) != null && !this.b.isScheduled())
/*     */             {
/* 142 */               cancel();
/*     */             }
/* 144 */             this.b.cancel();
/* 145 */             a();
/*     */             
/* 147 */             super.touchUp(param1InputEvent, param1Float1, param1Float2, param1Int1, param1Int2);
/*     */           }
/*     */ 
/*     */           
/*     */           public void enter(InputEvent param1InputEvent, float param1Float1, float param1Float2, int param1Int, Actor param1Actor) {
/* 152 */             if (param1Int == -1) {
/* 153 */               TableButton.b(this.a, true);
/* 154 */               TableButton.e(this.a);
/*     */             } 
/*     */             
/* 157 */             super.enter(param1InputEvent, param1Float1, param1Float2, param1Int, param1Actor);
/*     */           }
/*     */ 
/*     */           
/*     */           public void exit(InputEvent param1InputEvent, float param1Float1, float param1Float2, int param1Int, Actor param1Actor) {
/* 162 */             if (param1Int == -1) {
/* 163 */               TableButton.b(this.a, false);
/* 164 */               TableButton.e(this.a);
/*     */             } 
/*     */             
/* 167 */             super.exit(param1InputEvent, param1Float1, param1Float2, param1Int, param1Actor);
/*     */           }
/*     */         });
/*     */ 
/*     */ 
/*     */     
/* 173 */     d();
/*     */   }
/*     */   
/*     */   public void setEnabled(boolean paramBoolean) {
/* 177 */     if (this.p != paramBoolean) {
/* 178 */       this.p = paramBoolean;
/* 179 */       d();
/*     */     } 
/*     */   }
/*     */   
/*     */   public void setClickHandler(Runnable paramRunnable) {
/* 184 */     this.k = paramRunnable;
/*     */   }
/*     */   
/*     */   public void setHoldHandler(Runnable paramRunnable) {
/* 188 */     this.l = paramRunnable;
/*     */   }
/*     */   
/*     */   public TableButton setMuted(boolean paramBoolean) {
/* 192 */     this.q = paramBoolean;
/* 193 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   public void layout() {
/* 198 */     super.layout();
/*     */     
/* 200 */     if (!this.E) {
/* 201 */       this.E = true;
/* 202 */       d();
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public TableButton setBackgroundDrawable(Drawable paramDrawable) {
/* 210 */     this.s = paramDrawable;
/* 211 */     this.t = null;
/* 212 */     this.u = null;
/* 213 */     this.v = null;
/* 214 */     d();
/* 215 */     return this;
/*     */   }
/*     */   
/*     */   public TableButton setBackgroundDrawables(Drawable paramDrawable1, Drawable paramDrawable2, Drawable paramDrawable3, Drawable paramDrawable4) {
/* 219 */     this.s = paramDrawable1;
/* 220 */     this.t = paramDrawable2;
/* 221 */     this.u = paramDrawable3;
/* 222 */     this.v = paramDrawable4;
/* 223 */     d();
/* 224 */     return this;
/*     */   }
/*     */   
/*     */   public TableButton setRectBackground() {
/* 228 */     return setBackgroundDrawable((Drawable)Game.i.assetManager.getDrawable("blank"));
/*     */   }
/*     */   
/*     */   public TableButton setContentColors(Color paramColor1, Color paramColor2, Color paramColor3, Color paramColor4) {
/* 232 */     if (paramColor1 != null) this.A.set(paramColor1); 
/* 233 */     if (paramColor2 != null) this.C.set(paramColor3); 
/* 234 */     if (paramColor3 != null) this.B.set(paramColor2); 
/* 235 */     if (paramColor4 != null) this.D.set(paramColor4); 
/* 236 */     d();
/* 237 */     return this;
/*     */   }
/*     */   
/*     */   public TableButton setBackgroundColors(Color paramColor1, Color paramColor2, Color paramColor3, Color paramColor4) {
/* 241 */     this.w.set((paramColor1 == null) ? DEFAULT_NORMAL_BG_COLOR : paramColor1);
/* 242 */     this.y.set((paramColor3 == null) ? DEFAULT_ACTIVE_BG_COLOR : paramColor3);
/* 243 */     this.x.set((paramColor2 == null) ? DEFAULT_HOVER_BG_COLOR : paramColor2);
/* 244 */     this.z.set((paramColor4 == null) ? DEFAULT_DISABLED_BG_COLOR : paramColor4);
/* 245 */     d();
/* 246 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   private void d() {
/* 251 */     if (this.p) {
/* 252 */       if (this.n) {
/* 253 */         this.r.setDrawable((this.t != null) ? this.t : this.s);
/* 254 */         this.r.setColor(this.y);
/* 255 */       } else if (this.o) {
/* 256 */         this.r.setDrawable((this.u != null) ? this.u : this.s);
/* 257 */         this.r.setColor(this.x);
/*     */       } else {
/* 259 */         this.r.setDrawable(this.s);
/* 260 */         this.r.setColor(this.w);
/*     */       } 
/*     */     } else {
/* 263 */       this.r.setDrawable((this.v != null) ? this.v : this.s);
/* 264 */       this.r.setColor(this.z);
/*     */     } 
/*     */ 
/*     */     
/* 268 */     for (Array.ArrayIterator<Cell> arrayIterator = getCells().iterator(); arrayIterator.hasNext();) {
/*     */       
/* 270 */       if ((actor = (cell = arrayIterator.next()).getActor()) != null) {
/* 271 */         if (this.p) {
/* 272 */           if (this.n) {
/* 273 */             actor.setColor(this.C); continue;
/* 274 */           }  if (this.o) {
/* 275 */             actor.setColor(this.B); continue;
/*     */           } 
/* 277 */           actor.setColor(this.A);
/*     */           continue;
/*     */         } 
/* 280 */         actor.setColor(this.D);
/*     */       } 
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi\\ui\actors\TableButton.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */