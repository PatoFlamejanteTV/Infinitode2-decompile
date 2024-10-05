/*      */ package com.prineside.tdi2.scene2d.ui;
/*      */ 
/*      */ import com.badlogic.gdx.Gdx;
/*      */ import com.badlogic.gdx.graphics.Color;
/*      */ import com.badlogic.gdx.graphics.g2d.Batch;
/*      */ import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
/*      */ import com.badlogic.gdx.math.Interpolation;
/*      */ import com.badlogic.gdx.math.MathUtils;
/*      */ import com.badlogic.gdx.math.Rectangle;
/*      */ import com.badlogic.gdx.math.Vector2;
/*      */ import com.badlogic.gdx.utils.Null;
/*      */ import com.prineside.tdi2.scene2d.Actor;
/*      */ import com.prineside.tdi2.scene2d.Event;
/*      */ import com.prineside.tdi2.scene2d.EventListener;
/*      */ import com.prineside.tdi2.scene2d.InputEvent;
/*      */ import com.prineside.tdi2.scene2d.InputListener;
/*      */ import com.prineside.tdi2.scene2d.Stage;
/*      */ import com.prineside.tdi2.scene2d.Touchable;
/*      */ import com.prineside.tdi2.scene2d.utils.ActorGestureListener;
/*      */ import com.prineside.tdi2.scene2d.utils.Cullable;
/*      */ import com.prineside.tdi2.scene2d.utils.Drawable;
/*      */ import com.prineside.tdi2.scene2d.utils.Layout;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ public class ScrollPane
/*      */   extends WidgetGroup
/*      */ {
/*      */   private ScrollPaneStyle E;
/*      */   private Actor F;
/*   52 */   final Rectangle k = new Rectangle();
/*   53 */   final Rectangle l = new Rectangle(), m = new Rectangle();
/*   54 */   final Rectangle n = new Rectangle(); final Rectangle o = new Rectangle(); private ActorGestureListener H; boolean p; boolean q; private boolean I = true; private boolean J = true; float r; float s;
/*   55 */   private final Rectangle G = new Rectangle();
/*      */   
/*      */   private float K;
/*      */   
/*      */   private float L;
/*      */   private float M;
/*      */   private float N;
/*      */   boolean t;
/*      */   boolean u;
/*   64 */   final Vector2 v = new Vector2(); private boolean O = true; private boolean P = true; boolean w = true;
/*      */   float x;
/*   66 */   private float Q = 1.0F; private float R; private float S = 1.0F;
/*      */   
/*      */   boolean y = true;
/*      */   boolean z = true;
/*   70 */   float A = 1.0F; float B; private float T; private float U; private boolean V = true;
/*      */   private boolean W = true;
/*   72 */   private float X = 50.0F; private float Y = 30.0F; private float Z = 200.0F; private boolean aa; private boolean ab;
/*      */   private boolean ac;
/*      */   boolean C;
/*      */   private boolean ad = true;
/*      */   private boolean ae;
/*      */   private boolean af = true;
/*   78 */   int D = -1;
/*      */ 
/*      */   
/*      */   public ScrollPane(@Null Actor paramActor) {
/*   82 */     this(paramActor, new ScrollPaneStyle());
/*      */   }
/*      */ 
/*      */   
/*      */   public ScrollPane(@Null Actor paramActor, ScrollPaneStyle paramScrollPaneStyle) {
/*   87 */     if (paramScrollPaneStyle == null) throw new IllegalArgumentException("style cannot be null."); 
/*   88 */     this.E = paramScrollPaneStyle;
/*   89 */     setActor(paramActor);
/*   90 */     setSize(150.0F, 150.0F);
/*      */     
/*   92 */     g();
/*   93 */     this.H = h();
/*   94 */     addListener((EventListener)this.H);
/*   95 */     i();
/*      */   }
/*      */   
/*      */   private void g() {
/*   99 */     addCaptureListener((EventListener)new InputListener(this) {
/*      */           private float a;
/*      */           
/*      */           public boolean touchDown(InputEvent param1InputEvent, float param1Float1, float param1Float2, int param1Int1, int param1Int2) {
/*  103 */             if (this.b.D != -1) return false; 
/*  104 */             if (param1Int1 == 0 && param1Int2 != 0) return false; 
/*  105 */             if (this.b.getStage() != null) this.b.getStage().setScrollFocus((Actor)this.b);
/*      */             
/*  107 */             if (!this.b.z) this.b.setScrollbarsVisible(true);
/*      */             
/*  109 */             if (this.b.x == 0.0F) return false;
/*      */             
/*  111 */             if (this.b.w && this.b.p && this.b.l.contains(param1Float1, param1Float2)) {
/*  112 */               param1InputEvent.stop();
/*  113 */               this.b.setScrollbarsVisible(true);
/*  114 */               if (this.b.m.contains(param1Float1, param1Float2)) {
/*  115 */                 this.b.v.set(param1Float1, param1Float2);
/*  116 */                 this.a = this.b.m.x;
/*  117 */                 this.b.t = true;
/*  118 */                 this.b.D = param1Int1;
/*  119 */                 return true;
/*      */               } 
/*  121 */               this.b.setScrollX(this.b.r + this.b.k.width * ((param1Float1 < this.b.m.x) ? -1 : true));
/*  122 */               return true;
/*      */             } 
/*  124 */             if (this.b.w && this.b.q && this.b.n.contains(param1Float1, param1Float2)) {
/*  125 */               param1InputEvent.stop();
/*  126 */               this.b.setScrollbarsVisible(true);
/*  127 */               if (this.b.o.contains(param1Float1, param1Float2)) {
/*  128 */                 this.b.v.set(param1Float1, param1Float2);
/*  129 */                 this.a = this.b.o.y;
/*  130 */                 this.b.u = true;
/*  131 */                 this.b.D = param1Int1;
/*  132 */                 return true;
/*      */               } 
/*  134 */               this.b.setScrollY(this.b.s + this.b.k.height * ((param1Float2 < this.b.o.y) ? true : -1));
/*  135 */               return true;
/*      */             } 
/*  137 */             return false;
/*      */           }
/*      */           
/*      */           public void touchUp(InputEvent param1InputEvent, float param1Float1, float param1Float2, int param1Int1, int param1Int2) {
/*  141 */             if (param1Int1 != this.b.D)
/*  142 */               return;  this.b.cancel();
/*      */           }
/*      */           
/*      */           public void touchDragged(InputEvent param1InputEvent, float param1Float1, float param1Float2, int param1Int) {
/*  146 */             if (param1Int != this.b.D)
/*  147 */               return;  if (this.b.t) {
/*  148 */               float f1 = param1Float1 - this.b.v.x;
/*  149 */               f1 = this.a + f1;
/*  150 */               this.a = f1;
/*  151 */               f1 = Math.max(this.b.l.x, f1);
/*  152 */               f1 = Math.min(this.b.l.x + this.b.l.width - this.b.m.width, f1);
/*      */               float f2;
/*  154 */               if ((f2 = this.b.l.width - this.b.m.width) != 0.0F) this.b.setScrollPercentX((f1 - this.b.l.x) / f2); 
/*  155 */               this.b.v.set(param1Float1, param1Float2); return;
/*  156 */             }  if (this.b.u) {
/*  157 */               float f1 = param1Float2 - this.b.v.y;
/*  158 */               f1 = this.a + f1;
/*  159 */               this.a = f1;
/*  160 */               f1 = Math.max(this.b.n.y, f1);
/*  161 */               f1 = Math.min(this.b.n.y + this.b.n.height - this.b.o.height, f1);
/*      */               float f2;
/*  163 */               if ((f2 = this.b.n.height - this.b.o.height) != 0.0F) this.b.setScrollPercentY(1.0F - (f1 - this.b.n.y) / f2); 
/*  164 */               this.b.v.set(param1Float1, param1Float2);
/*      */             } 
/*      */           }
/*      */           
/*      */           public boolean mouseMoved(InputEvent param1InputEvent, float param1Float1, float param1Float2) {
/*  169 */             if (!this.b.z) this.b.setScrollbarsVisible(true); 
/*  170 */             return false;
/*      */           }
/*      */         });
/*      */   }
/*      */ 
/*      */   
/*      */   private ActorGestureListener h() {
/*  177 */     return new ActorGestureListener(this) {
/*      */         public void pan(InputEvent param1InputEvent, float param1Float1, float param1Float2, float param1Float3, float param1Float4) {
/*  179 */           this.e.setScrollbarsVisible(true);
/*  180 */           if (!this.e.p) param1Float3 = 0.0F; 
/*  181 */           if (!this.e.q) param1Float4 = 0.0F; 
/*  182 */           this.e.r -= param1Float3;
/*  183 */           this.e.s += param1Float4;
/*  184 */           this.e.d();
/*  185 */           if (this.e.y && (param1Float3 != 0.0F || param1Float4 != 0.0F)) this.e.cancelTouchFocus(); 
/*      */         }
/*      */         
/*      */         public void fling(InputEvent param1InputEvent, float param1Float1, float param1Float2, int param1Int) {
/*  189 */           float f = (Math.abs(param1Float1) > 150.0F && this.e.p) ? param1Float1 : 0.0F;
/*  190 */           param1Float1 = (Math.abs(param1Float2) > 150.0F && this.e.q) ? -param1Float2 : 0.0F;
/*  191 */           if (f != 0.0F || param1Float1 != 0.0F) {
/*  192 */             if (this.e.y) this.e.cancelTouchFocus(); 
/*  193 */             this.e.fling(this.e.A, f, param1Float1);
/*      */           } 
/*      */         }
/*      */         
/*      */         public boolean handle(Event param1Event) {
/*  198 */           if (super.handle(param1Event)) {
/*  199 */             if (((InputEvent)param1Event).getType() == InputEvent.Type.touchDown) this.e.B = 0.0F; 
/*  200 */             return true;
/*  201 */           }  if (param1Event instanceof InputEvent && ((InputEvent)param1Event).isTouchFocusCancel())
/*  202 */             this.e.cancel(); 
/*  203 */           return false;
/*      */         }
/*      */       };
/*      */   }
/*      */   
/*      */   private void i() {
/*  209 */     addListener((EventListener)new InputListener(this) {
/*      */           public boolean scrolled(InputEvent param1InputEvent, float param1Float1, float param1Float2, float param1Float3, float param1Float4) {
/*  211 */             param1InputEvent.cancel();
/*  212 */             this.a.setScrollbarsVisible(true);
/*  213 */             if (this.a.q || this.a.p) {
/*  214 */               if (this.a.q)
/*  215 */               { if (!this.a.p && param1Float4 == 0.0F) param1Float4 = param1Float3;
/*      */                  }
/*  217 */               else if (this.a.p && param1Float3 == 0.0F) { param1Float3 = param1Float4; }
/*      */               
/*  219 */               this.a.setScrollY(this.a.s + this.a.f() * param1Float4);
/*  220 */               this.a.setScrollX(this.a.r + this.a.e() * param1Float3);
/*      */             } else {
/*  222 */               return false;
/*  223 */             }  return true;
/*      */           }
/*      */         });
/*      */   }
/*      */ 
/*      */   
/*      */   public void setScrollbarsVisible(boolean paramBoolean) {
/*  230 */     if (paramBoolean) {
/*  231 */       this.x = this.Q;
/*  232 */       this.R = this.S; return;
/*      */     } 
/*  234 */     this.x = 0.0F;
/*  235 */     this.R = 0.0F;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void cancelTouchFocus() {
/*      */     Stage stage;
/*  244 */     if ((stage = getStage()) != null) stage.cancelTouchFocusExcept((EventListener)this.H, (Actor)this);
/*      */   
/*      */   }
/*      */   
/*      */   public void cancel() {
/*  249 */     this.D = -1;
/*  250 */     this.t = false;
/*  251 */     this.u = false;
/*  252 */     this.H.getGestureDetector().cancel();
/*      */   }
/*      */   
/*      */   final void d() {
/*  256 */     if (!this.ad)
/*  257 */       return;  a(this.V ? MathUtils.clamp(this.r, -this.X, this.M + this.X) : 
/*  258 */         MathUtils.clamp(this.r, 0.0F, this.M));
/*  259 */     b(this.W ? MathUtils.clamp(this.s, -this.X, this.N + this.X) : 
/*  260 */         MathUtils.clamp(this.s, 0.0F, this.N));
/*      */   }
/*      */   
/*      */   public void setStyle(ScrollPaneStyle paramScrollPaneStyle) {
/*  264 */     if (paramScrollPaneStyle == null) throw new IllegalArgumentException("style cannot be null."); 
/*  265 */     this.E = paramScrollPaneStyle;
/*  266 */     invalidateHierarchy();
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public ScrollPaneStyle getStyle() {
/*  272 */     return this.E;
/*      */   }
/*      */   
/*      */   public void act(float paramFloat) {
/*  276 */     super.act(paramFloat);
/*      */     
/*  278 */     boolean bool = this.H.getGestureDetector().isPanning();
/*  279 */     boolean bool1 = false;
/*      */     
/*  281 */     if (this.x > 0.0F && this.O && !bool && !this.t && !this.u) {
/*  282 */       this.R -= paramFloat;
/*  283 */       if (this.R <= 0.0F) this.x = Math.max(0.0F, this.x - paramFloat); 
/*  284 */       bool1 = true;
/*      */     } 
/*      */     
/*  287 */     if (this.B > 0.0F) {
/*  288 */       setScrollbarsVisible(true);
/*      */       
/*  290 */       float f = this.B / this.A;
/*  291 */       this.r -= this.T * f * paramFloat;
/*  292 */       this.s -= this.U * f * paramFloat;
/*  293 */       d();
/*      */ 
/*      */       
/*  296 */       if (this.r == -this.X) this.T = 0.0F; 
/*  297 */       if (this.r >= this.M + this.X) this.T = 0.0F; 
/*  298 */       if (this.s == -this.X) this.U = 0.0F; 
/*  299 */       if (this.s >= this.N + this.X) this.U = 0.0F;
/*      */       
/*  301 */       this.B -= paramFloat;
/*  302 */       if (this.B <= 0.0F) {
/*  303 */         this.T = 0.0F;
/*  304 */         this.U = 0.0F;
/*      */       } 
/*      */       
/*  307 */       boolean bool2 = true;
/*      */     } 
/*      */     
/*  310 */     if (this.P && this.B <= 0.0F && !bool && (!this.t || (this.p && this.M / (this.l.width - this.m.width) > this.k.width * 0.1F)) && (!this.u || (this.q && this.N / (this.n.height - this.o.height) > this.k.height * 0.1F))) {
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  315 */       if (this.K != this.r) {
/*  316 */         if (this.K < this.r) {
/*  317 */           c(Math.min(this.r, this.K + Math.max(200.0F * paramFloat, (this.r - this.K) * 7.0F * paramFloat)));
/*      */         } else {
/*  319 */           c(Math.max(this.r, this.K - Math.max(200.0F * paramFloat, (this.K - this.r) * 7.0F * paramFloat)));
/*  320 */         }  bool1 = true;
/*      */       } 
/*  322 */       if (this.L != this.s) {
/*  323 */         if (this.L < this.s) {
/*  324 */           d(Math.min(this.s, this.L + Math.max(200.0F * paramFloat, (this.s - this.L) * 7.0F * paramFloat)));
/*      */         } else {
/*  326 */           d(Math.max(this.s, this.L - Math.max(200.0F * paramFloat, (this.L - this.s) * 7.0F * paramFloat)));
/*  327 */         }  bool1 = true;
/*      */       } 
/*      */     } else {
/*  330 */       if (this.K != this.r) c(this.r); 
/*  331 */       if (this.L != this.s) d(this.s);
/*      */     
/*      */     } 
/*  334 */     if (!bool) {
/*  335 */       if (this.V && this.p) {
/*  336 */         if (this.r < 0.0F) {
/*  337 */           setScrollbarsVisible(true);
/*  338 */           this.r += (this.Y + (this.Z - this.Y) * -this.r / this.X) * paramFloat;
/*      */           
/*  340 */           if (this.r > 0.0F) a(0.0F); 
/*  341 */           bool1 = true;
/*  342 */         } else if (this.r > this.M) {
/*  343 */           setScrollbarsVisible(true);
/*  344 */           this.r -= (this.Y + (this.Z - this.Y) * -(this.M - this.r) / this.X) * paramFloat;
/*      */           
/*  346 */           if (this.r < this.M) a(this.M); 
/*  347 */           bool1 = true;
/*      */         } 
/*      */       }
/*  350 */       if (this.W && this.q) {
/*  351 */         if (this.s < 0.0F) {
/*  352 */           setScrollbarsVisible(true);
/*  353 */           this.s += (this.Y + (this.Z - this.Y) * -this.s / this.X) * paramFloat;
/*      */           
/*  355 */           if (this.s > 0.0F) b(0.0F); 
/*  356 */           bool1 = true;
/*  357 */         } else if (this.s > this.N) {
/*  358 */           setScrollbarsVisible(true);
/*  359 */           this.s -= (this.Y + (this.Z - this.Y) * -(this.N - this.s) / this.X) * paramFloat;
/*      */           
/*  361 */           if (this.s < this.N) b(this.N); 
/*  362 */           bool1 = true;
/*      */         } 
/*      */       }
/*      */     } 
/*      */     Stage stage;
/*  367 */     if (bool1 && (
/*      */       
/*  369 */       stage = getStage()) != null && stage.getActionsRequestRendering()) Gdx.graphics.requestRendering();
/*      */   
/*      */   }
/*      */   
/*      */   public void layout() {
/*  374 */     Drawable drawable1 = this.E.background, drawable2 = this.E.hScrollKnob, drawable3 = this.E.vScrollKnob;
/*  375 */     float f2 = 0.0F, f3 = 0.0F, f4 = 0.0F, f5 = 0.0F;
/*  376 */     if (drawable1 != null) {
/*  377 */       f2 = drawable1.getLeftWidth();
/*  378 */       f3 = drawable1.getRightWidth();
/*  379 */       f4 = drawable1.getTopHeight();
/*  380 */       f5 = drawable1.getBottomHeight();
/*      */     } 
/*  382 */     float f1 = getWidth(), f6 = getHeight();
/*  383 */     this.k.set(f2, f5, f1 - f2 - f3, f6 - f4 - f5);
/*      */     
/*  385 */     if (this.F == null)
/*      */       return; 
/*  387 */     float f7 = 0.0F, f8 = 0.0F;
/*  388 */     if (drawable2 != null) f7 = drawable2.getMinHeight(); 
/*  389 */     if (this.E.hScroll != null) f7 = Math.max(f7, this.E.hScroll.getMinHeight()); 
/*  390 */     if (drawable3 != null) f8 = drawable3.getMinWidth(); 
/*  391 */     if (this.E.vScroll != null) f8 = Math.max(f8, this.E.vScroll.getMinWidth());
/*      */ 
/*      */ 
/*      */     
/*  395 */     if (this.F instanceof Layout) {
/*      */       Layout layout;
/*  397 */       f9 = (layout = (Layout)this.F).getPrefWidth();
/*  398 */       f10 = layout.getPrefHeight();
/*      */     } else {
/*  400 */       f9 = this.F.getWidth();
/*  401 */       f10 = this.F.getHeight();
/*      */     } 
/*      */ 
/*      */     
/*  405 */     this.p = (this.aa || (f9 > this.k.width && !this.ac));
/*  406 */     this.q = (this.ab || (f10 > this.k.height && !this.C));
/*      */ 
/*      */     
/*  409 */     if (!this.ae) {
/*  410 */       if (this.q) {
/*  411 */         this.k.width -= f8;
/*  412 */         if (!this.I) this.k.x += f8;
/*      */         
/*  414 */         if (!this.p && f9 > this.k.width && !this.ac) this.p = true; 
/*      */       } 
/*  416 */       if (this.p) {
/*  417 */         this.k.height -= f7;
/*  418 */         if (this.J) this.k.y += f7;
/*      */         
/*  420 */         if (!this.q && f10 > this.k.height && !this.C) {
/*  421 */           this.q = true;
/*  422 */           this.k.width -= f8;
/*  423 */           if (!this.I) this.k.x += f8;
/*      */         
/*      */         } 
/*      */       } 
/*      */     } 
/*      */     
/*  429 */     float f9 = this.ac ? this.k.width : Math.max(this.k.width, f9);
/*  430 */     float f10 = this.C ? this.k.height : Math.max(this.k.height, f10);
/*      */     
/*  432 */     this.M = f9 - this.k.width;
/*  433 */     this.N = f10 - this.k.height;
/*  434 */     a(MathUtils.clamp(this.r, 0.0F, this.M));
/*  435 */     b(MathUtils.clamp(this.s, 0.0F, this.N));
/*      */ 
/*      */     
/*  438 */     if (this.p) {
/*  439 */       if (drawable2 != null) {
/*  440 */         float f = this.ae ? f2 : this.k.x;
/*  441 */         f4 = this.J ? f5 : (f6 - f4 - f7);
/*  442 */         this.l.set(f, f4, this.k.width, f7);
/*  443 */         if (this.q && this.ae) {
/*  444 */           this.l.width -= f8;
/*  445 */           if (!this.I) this.l.x += f8;
/*      */         
/*      */         } 
/*  448 */         if (this.af) {
/*  449 */           this.m.width = Math.max(drawable2.getMinWidth(), (int)(this.l.width * this.k.width / f9));
/*      */         } else {
/*  451 */           this.m.width = drawable2.getMinWidth();
/*  452 */         }  if (this.m.width > f9) this.m.width = 0.0F; 
/*  453 */         this.m.height = drawable2.getMinHeight();
/*  454 */         this.l.x += (int)((this.l.width - this.m.width) * getScrollPercentX());
/*  455 */         this.m.y = this.l.y;
/*      */       } else {
/*  457 */         this.l.set(0.0F, 0.0F, 0.0F, 0.0F);
/*  458 */         this.m.set(0.0F, 0.0F, 0.0F, 0.0F);
/*      */       } 
/*      */     }
/*  461 */     if (this.q) {
/*  462 */       if (drawable3 != null) {
/*  463 */         float f = this.I ? (f1 - f3 - f8) : f2;
/*  464 */         f4 = this.ae ? f5 : this.k.y;
/*  465 */         this.n.set(f, f4, f8, this.k.height);
/*  466 */         if (this.p && this.ae) {
/*  467 */           this.n.height -= f7;
/*  468 */           if (this.J) this.n.y += f7;
/*      */         
/*      */         } 
/*  471 */         this.o.width = drawable3.getMinWidth();
/*  472 */         if (this.af) {
/*  473 */           this.o.height = Math.max(drawable3.getMinHeight(), (int)(this.n.height * this.k.height / f10));
/*      */         } else {
/*      */           
/*  476 */           this.o.height = drawable3.getMinHeight();
/*  477 */         }  if (this.o.height > f10) this.o.height = 0.0F; 
/*  478 */         this.o.x = this.I ? (f1 - f3 - drawable3.getMinWidth()) : f2;
/*  479 */         this.n.y += (int)((this.n.height - this.o.height) * (1.0F - getScrollPercentY()));
/*      */       } else {
/*  481 */         this.n.set(0.0F, 0.0F, 0.0F, 0.0F);
/*  482 */         this.o.set(0.0F, 0.0F, 0.0F, 0.0F);
/*      */       } 
/*      */     }
/*      */     
/*  486 */     j();
/*  487 */     if (this.F instanceof Layout) {
/*  488 */       this.F.setSize(f9, f10);
/*  489 */       ((Layout)this.F).validate();
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   private void j() {
/*  495 */     float f1 = this.k.x - (this.p ? (int)this.K : false);
/*  496 */     float f2 = this.k.y - (int)(this.q ? (this.N - this.L) : this.N);
/*  497 */     this.F.setPosition(f1, f2);
/*      */     
/*  499 */     if (this.F instanceof Cullable) {
/*  500 */       this.k.x -= f1;
/*  501 */       this.k.y -= f2;
/*  502 */       this.G.width = this.k.width;
/*  503 */       this.G.height = this.k.height;
/*  504 */       ((Cullable)this.F).setCullingArea(this.G);
/*      */     } 
/*      */   }
/*      */   
/*      */   public void draw(Batch paramBatch, float paramFloat) {
/*  509 */     if (this.F == null)
/*      */       return; 
/*  511 */     validate();
/*      */ 
/*      */     
/*  514 */     a(paramBatch, b());
/*      */     
/*  516 */     if (this.p) this.l.x += (int)((this.l.width - this.m.width) * getVisualScrollPercentX()); 
/*  517 */     if (this.q) {
/*  518 */       this.n.y += (int)((this.n.height - this.o.height) * (1.0F - getVisualScrollPercentY()));
/*      */     }
/*  520 */     j();
/*      */     
/*      */     Color color;
/*      */     
/*  524 */     float f = (color = getColor()).a * paramFloat;
/*  525 */     if (this.E.background != null) {
/*  526 */       paramBatch.setColor(color.r, color.g, color.b, f);
/*  527 */       this.E.background.draw(paramBatch, 0.0F, 0.0F, getWidth(), getHeight());
/*      */     } 
/*      */     
/*  530 */     paramBatch.flush();
/*  531 */     if (clipBegin(this.k.x, this.k.y, this.k.width, this.k.height)) {
/*  532 */       a(paramBatch, paramFloat);
/*  533 */       paramBatch.flush();
/*  534 */       clipEnd();
/*      */     } 
/*      */ 
/*      */     
/*  538 */     paramBatch.setColor(color.r, color.g, color.b, f);
/*  539 */     if (this.O) f *= Interpolation.fade.apply(this.x / this.Q); 
/*  540 */     a(paramBatch, color.r, color.g, color.b, f);
/*      */     
/*  542 */     a(paramBatch);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   private void a(Batch paramBatch, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4) {
/*  548 */     if (paramFloat4 <= 0.0F)
/*  549 */       return;  paramBatch.setColor(paramFloat1, paramFloat2, paramFloat3, paramFloat4);
/*      */     
/*  551 */     boolean bool1 = (this.p && this.m.width > 0.0F) ? true : false;
/*  552 */     boolean bool2 = (this.q && this.o.height > 0.0F) ? true : false;
/*  553 */     if (bool1) {
/*  554 */       if (bool2 && this.E.corner != null) this.E.corner.draw(paramBatch, this.l.x + this.l.width, this.l.y, this.n.width, this.n.y);
/*      */ 
/*      */       
/*  557 */       if (this.E.hScroll != null)
/*  558 */         this.E.hScroll.draw(paramBatch, this.l.x, this.l.y, this.l.width, this.l.height); 
/*  559 */       if (this.E.hScrollKnob != null)
/*  560 */         this.E.hScrollKnob.draw(paramBatch, this.m.x, this.m.y, this.m.width, this.m.height); 
/*      */     } 
/*  562 */     if (bool2) {
/*  563 */       if (this.E.vScroll != null)
/*  564 */         this.E.vScroll.draw(paramBatch, this.n.x, this.n.y, this.n.width, this.n.height); 
/*  565 */       if (this.E.vScrollKnob != null) {
/*  566 */         this.E.vScrollKnob.draw(paramBatch, this.o.x, this.o.y, this.o.width, this.o.height);
/*      */       }
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void fling(float paramFloat1, float paramFloat2, float paramFloat3) {
/*  575 */     this.B = paramFloat1;
/*  576 */     this.T = paramFloat2;
/*  577 */     this.U = paramFloat3;
/*      */   }
/*      */   
/*      */   public float getPrefWidth() {
/*  581 */     float f = 0.0F;
/*  582 */     if (this.F instanceof Layout) {
/*  583 */       f = ((Layout)this.F).getPrefWidth();
/*  584 */     } else if (this.F != null) {
/*  585 */       f = this.F.getWidth();
/*      */     } 
/*      */     Drawable drawable;
/*  588 */     if ((drawable = this.E.background) != null) {
/*  589 */       f = Math.max(f + drawable.getLeftWidth() + drawable.getRightWidth(), drawable.getMinWidth());
/*      */     }
/*  591 */     if (this.q) {
/*  592 */       float f1 = 0.0F;
/*  593 */       if (this.E.vScrollKnob != null) f1 = this.E.vScrollKnob.getMinWidth(); 
/*  594 */       if (this.E.vScroll != null) f1 = Math.max(f1, this.E.vScroll.getMinWidth()); 
/*  595 */       f += f1;
/*      */     } 
/*  597 */     return f;
/*      */   }
/*      */   
/*      */   public float getPrefHeight() {
/*  601 */     float f = 0.0F;
/*  602 */     if (this.F instanceof Layout) {
/*  603 */       f = ((Layout)this.F).getPrefHeight();
/*  604 */     } else if (this.F != null) {
/*  605 */       f = this.F.getHeight();
/*      */     } 
/*      */     Drawable drawable;
/*  608 */     if ((drawable = this.E.background) != null) {
/*  609 */       f = Math.max(f + drawable.getTopHeight() + drawable.getBottomHeight(), drawable.getMinHeight());
/*      */     }
/*  611 */     if (this.p) {
/*  612 */       float f1 = 0.0F;
/*  613 */       if (this.E.hScrollKnob != null) f1 = this.E.hScrollKnob.getMinHeight(); 
/*  614 */       if (this.E.hScroll != null) f1 = Math.max(f1, this.E.hScroll.getMinHeight()); 
/*  615 */       f += f1;
/*      */     } 
/*  617 */     return f;
/*      */   }
/*      */   
/*      */   public float getMinWidth() {
/*  621 */     return 0.0F;
/*      */   }
/*      */   
/*      */   public float getMinHeight() {
/*  625 */     return 0.0F;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public void setActor(@Null Actor paramActor) {
/*  631 */     if (this.F == this) throw new IllegalArgumentException("actor cannot be the ScrollPane."); 
/*  632 */     if (this.F != null) super.removeActor(this.F); 
/*  633 */     this.F = paramActor;
/*  634 */     if (paramActor != null) super.addActor(paramActor); 
/*      */   }
/*      */   
/*      */   @Null
/*      */   public Actor getActor() {
/*  639 */     return this.F;
/*      */   }
/*      */ 
/*      */   
/*      */   @Deprecated
/*      */   public void setWidget(@Null Actor paramActor) {
/*  645 */     setActor(paramActor);
/*      */   }
/*      */   
/*      */   @Deprecated
/*      */   @Null
/*      */   public Actor getWidget() {
/*  651 */     return this.F;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   @Deprecated
/*      */   public void addActor(Actor paramActor) {
/*  658 */     throw new UnsupportedOperationException("Use ScrollPane#setActor.");
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   @Deprecated
/*      */   public void addActorAt(int paramInt, Actor paramActor) {
/*  665 */     throw new UnsupportedOperationException("Use ScrollPane#setActor.");
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   @Deprecated
/*      */   public void addActorBefore(Actor paramActor1, Actor paramActor2) {
/*  672 */     throw new UnsupportedOperationException("Use ScrollPane#setActor.");
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   @Deprecated
/*      */   public void addActorAfter(Actor paramActor1, Actor paramActor2) {
/*  679 */     throw new UnsupportedOperationException("Use ScrollPane#setActor.");
/*      */   }
/*      */   
/*      */   public boolean removeActor(Actor paramActor) {
/*  683 */     if (paramActor == null) throw new IllegalArgumentException("actor cannot be null."); 
/*  684 */     if (paramActor != this.F) return false; 
/*  685 */     setActor((Actor)null);
/*  686 */     return true;
/*      */   }
/*      */   
/*      */   public boolean removeActor(Actor paramActor, boolean paramBoolean) {
/*  690 */     if (paramActor == null) throw new IllegalArgumentException("actor cannot be null."); 
/*  691 */     if (paramActor != this.F) return false; 
/*  692 */     this.F = null;
/*  693 */     return super.removeActor(paramActor, paramBoolean);
/*      */   }
/*      */   
/*      */   public Actor removeActorAt(int paramInt, boolean paramBoolean) {
/*      */     Actor actor;
/*  698 */     if ((actor = super.removeActorAt(paramInt, paramBoolean)) == this.F) this.F = null; 
/*  699 */     return actor;
/*      */   }
/*      */   @Null
/*      */   public Actor hit(float paramFloat1, float paramFloat2, boolean paramBoolean) {
/*  703 */     if (paramFloat1 < 0.0F || paramFloat1 >= getWidth() || paramFloat2 < 0.0F || paramFloat2 >= getHeight()) return null; 
/*  704 */     if (paramBoolean && getTouchable() == Touchable.enabled && isVisible()) {
/*  705 */       if (this.p && this.t && this.l.contains(paramFloat1, paramFloat2)) return (Actor)this; 
/*  706 */       if (this.q && this.u && this.n.contains(paramFloat1, paramFloat2)) return (Actor)this; 
/*      */     } 
/*  708 */     return super.hit(paramFloat1, paramFloat2, paramBoolean);
/*      */   }
/*      */ 
/*      */   
/*      */   private void a(float paramFloat) {
/*  713 */     this.r = paramFloat;
/*      */   }
/*      */ 
/*      */   
/*      */   private void b(float paramFloat) {
/*  718 */     this.s = paramFloat;
/*      */   }
/*      */ 
/*      */   
/*      */   private void c(float paramFloat) {
/*  723 */     this.K = paramFloat;
/*      */   }
/*      */ 
/*      */   
/*      */   private void d(float paramFloat) {
/*  728 */     this.L = paramFloat;
/*      */   }
/*      */ 
/*      */   
/*      */   protected final float e() {
/*  733 */     return Math.min(this.k.width, Math.max(this.k.width * 0.9F, this.M * 0.1F) / 4.0F);
/*      */   }
/*      */ 
/*      */   
/*      */   protected final float f() {
/*  738 */     return Math.min(this.k.height, Math.max(this.k.height * 0.9F, this.N * 0.1F) / 4.0F);
/*      */   }
/*      */   
/*      */   public void setScrollX(float paramFloat) {
/*  742 */     a(MathUtils.clamp(paramFloat, 0.0F, this.M));
/*      */   }
/*      */ 
/*      */   
/*      */   public float getScrollX() {
/*  747 */     return this.r;
/*      */   }
/*      */   
/*      */   public void setScrollY(float paramFloat) {
/*  751 */     b(MathUtils.clamp(paramFloat, 0.0F, this.N));
/*      */   }
/*      */ 
/*      */   
/*      */   public float getScrollY() {
/*  756 */     return this.s;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public void updateVisualScroll() {
/*  762 */     this.K = this.r;
/*  763 */     this.L = this.s;
/*      */   }
/*      */   
/*      */   public float getVisualScrollX() {
/*  767 */     return !this.p ? 0.0F : this.K;
/*      */   }
/*      */   
/*      */   public float getVisualScrollY() {
/*  771 */     return !this.q ? 0.0F : this.L;
/*      */   }
/*      */   
/*      */   public float getVisualScrollPercentX() {
/*  775 */     if (this.M == 0.0F) return 0.0F; 
/*  776 */     return MathUtils.clamp(this.K / this.M, 0.0F, 1.0F);
/*      */   }
/*      */   
/*      */   public float getVisualScrollPercentY() {
/*  780 */     if (this.N == 0.0F) return 0.0F; 
/*  781 */     return MathUtils.clamp(this.L / this.N, 0.0F, 1.0F);
/*      */   }
/*      */   
/*      */   public float getScrollPercentX() {
/*  785 */     if (this.M == 0.0F) return 0.0F; 
/*  786 */     return MathUtils.clamp(this.r / this.M, 0.0F, 1.0F);
/*      */   }
/*      */   
/*      */   public void setScrollPercentX(float paramFloat) {
/*  790 */     a(this.M * MathUtils.clamp(paramFloat, 0.0F, 1.0F));
/*      */   }
/*      */   
/*      */   public float getScrollPercentY() {
/*  794 */     if (this.N == 0.0F) return 0.0F; 
/*  795 */     return MathUtils.clamp(this.s / this.N, 0.0F, 1.0F);
/*      */   }
/*      */   
/*      */   public void setScrollPercentY(float paramFloat) {
/*  799 */     b(this.N * MathUtils.clamp(paramFloat, 0.0F, 1.0F));
/*      */   }
/*      */   
/*      */   public void setFlickScroll(boolean paramBoolean) {
/*  803 */     if (this.z == paramBoolean)
/*  804 */       return;  this.z = paramBoolean;
/*  805 */     if (paramBoolean) {
/*  806 */       addListener((EventListener)this.H);
/*      */     } else {
/*  808 */       removeListener((EventListener)this.H);
/*  809 */     }  invalidate();
/*      */   }
/*      */   
/*      */   public void setFlickScrollTapSquareSize(float paramFloat) {
/*  813 */     this.H.getGestureDetector().setTapSquareSize(paramFloat);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public void scrollTo(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4) {
/*  819 */     scrollTo(paramFloat1, paramFloat2, paramFloat3, paramFloat4, false, false);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public void scrollTo(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, boolean paramBoolean1, boolean paramBoolean2) {
/*  825 */     validate();
/*      */     
/*  827 */     float f = this.r;
/*  828 */     if (paramBoolean1) {
/*  829 */       f = paramFloat1 + (paramFloat3 - this.k.width) / 2.0F;
/*      */     } else {
/*  831 */       f = MathUtils.clamp(f, paramFloat1, paramFloat1 + paramFloat3 - this.k.width);
/*  832 */     }  a(MathUtils.clamp(f, 0.0F, this.M));
/*      */     
/*  834 */     paramFloat1 = this.s;
/*  835 */     paramFloat2 = this.N - paramFloat2;
/*  836 */     if (paramBoolean2) {
/*  837 */       paramFloat1 = paramFloat2 + (this.k.height + paramFloat4) / 2.0F;
/*      */     } else {
/*  839 */       paramFloat1 = MathUtils.clamp(paramFloat1, paramFloat2 + paramFloat4, paramFloat2 + this.k.height);
/*  840 */     }  b(MathUtils.clamp(paramFloat1, 0.0F, this.N));
/*      */   }
/*      */ 
/*      */   
/*      */   public float getMaxX() {
/*  845 */     return this.M;
/*      */   }
/*      */ 
/*      */   
/*      */   public float getMaxY() {
/*  850 */     return this.N;
/*      */   }
/*      */   
/*      */   public float getScrollBarHeight() {
/*  854 */     if (!this.p) return 0.0F; 
/*  855 */     float f = 0.0F;
/*  856 */     if (this.E.hScrollKnob != null) f = this.E.hScrollKnob.getMinHeight(); 
/*  857 */     if (this.E.hScroll != null) f = Math.max(f, this.E.hScroll.getMinHeight()); 
/*  858 */     return f;
/*      */   }
/*      */   
/*      */   public float getScrollBarWidth() {
/*  862 */     if (!this.q) return 0.0F; 
/*  863 */     float f = 0.0F;
/*  864 */     if (this.E.vScrollKnob != null) f = this.E.vScrollKnob.getMinWidth(); 
/*  865 */     if (this.E.vScroll != null) f = Math.max(f, this.E.vScroll.getMinWidth()); 
/*  866 */     return f;
/*      */   }
/*      */ 
/*      */   
/*      */   public float getScrollWidth() {
/*  871 */     return this.k.width;
/*      */   }
/*      */ 
/*      */   
/*      */   public float getScrollHeight() {
/*  876 */     return this.k.height;
/*      */   }
/*      */ 
/*      */   
/*      */   public boolean isScrollX() {
/*  881 */     return this.p;
/*      */   }
/*      */ 
/*      */   
/*      */   public boolean isScrollY() {
/*  886 */     return this.q;
/*      */   }
/*      */ 
/*      */   
/*      */   public void setScrollingDisabled(boolean paramBoolean1, boolean paramBoolean2) {
/*  891 */     if (paramBoolean1 == this.ac && paramBoolean2 == this.C)
/*  892 */       return;  this.ac = paramBoolean1;
/*  893 */     this.C = paramBoolean2;
/*  894 */     invalidate();
/*      */   }
/*      */   
/*      */   public boolean isScrollingDisabledX() {
/*  898 */     return this.ac;
/*      */   }
/*      */   
/*      */   public boolean isScrollingDisabledY() {
/*  902 */     return this.C;
/*      */   }
/*      */   
/*      */   public boolean isLeftEdge() {
/*  906 */     return (!this.p || this.r <= 0.0F);
/*      */   }
/*      */   
/*      */   public boolean isRightEdge() {
/*  910 */     return (!this.p || this.r >= this.M);
/*      */   }
/*      */   
/*      */   public boolean isTopEdge() {
/*  914 */     return (!this.q || this.s <= 0.0F);
/*      */   }
/*      */   
/*      */   public boolean isBottomEdge() {
/*  918 */     return (!this.q || this.s >= this.N);
/*      */   }
/*      */   
/*      */   public boolean isDragging() {
/*  922 */     return (this.D != -1);
/*      */   }
/*      */   
/*      */   public boolean isPanning() {
/*  926 */     return this.H.getGestureDetector().isPanning();
/*      */   }
/*      */   
/*      */   public boolean isFlinging() {
/*  930 */     return (this.B > 0.0F);
/*      */   }
/*      */   
/*      */   public void setVelocityX(float paramFloat) {
/*  934 */     this.T = paramFloat;
/*      */   }
/*      */ 
/*      */   
/*      */   public float getVelocityX() {
/*  939 */     return this.T;
/*      */   }
/*      */   
/*      */   public void setVelocityY(float paramFloat) {
/*  943 */     this.U = paramFloat;
/*      */   }
/*      */ 
/*      */   
/*      */   public float getVelocityY() {
/*  948 */     return this.U;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public void setOverscroll(boolean paramBoolean1, boolean paramBoolean2) {
/*  954 */     this.V = paramBoolean1;
/*  955 */     this.W = paramBoolean2;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public void setupOverscroll(float paramFloat1, float paramFloat2, float paramFloat3) {
/*  961 */     this.X = paramFloat1;
/*  962 */     this.Y = paramFloat2;
/*  963 */     this.Z = paramFloat3;
/*      */   }
/*      */   
/*      */   public float getOverscrollDistance() {
/*  967 */     return this.X;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public void setForceScroll(boolean paramBoolean1, boolean paramBoolean2) {
/*  973 */     this.aa = paramBoolean1;
/*  974 */     this.ab = paramBoolean2;
/*      */   }
/*      */   
/*      */   public boolean isForceScrollX() {
/*  978 */     return this.aa;
/*      */   }
/*      */   
/*      */   public boolean isForceScrollY() {
/*  982 */     return this.ab;
/*      */   }
/*      */ 
/*      */   
/*      */   public void setFlingTime(float paramFloat) {
/*  987 */     this.A = paramFloat;
/*      */   }
/*      */ 
/*      */   
/*      */   public void setClamp(boolean paramBoolean) {
/*  992 */     this.ad = paramBoolean;
/*      */   }
/*      */ 
/*      */   
/*      */   public void setScrollBarPositions(boolean paramBoolean1, boolean paramBoolean2) {
/*  997 */     this.J = paramBoolean1;
/*  998 */     this.I = paramBoolean2;
/*      */   }
/*      */ 
/*      */   
/*      */   public void setFadeScrollBars(boolean paramBoolean) {
/* 1003 */     if (this.O == paramBoolean)
/* 1004 */       return;  this.O = paramBoolean;
/* 1005 */     if (!paramBoolean) this.x = this.Q; 
/* 1006 */     invalidate();
/*      */   }
/*      */   
/*      */   public void setupFadeScrollBars(float paramFloat1, float paramFloat2) {
/* 1010 */     this.Q = paramFloat1;
/* 1011 */     this.S = paramFloat2;
/*      */   }
/*      */   
/*      */   public boolean getFadeScrollBars() {
/* 1015 */     return this.O;
/*      */   }
/*      */ 
/*      */   
/*      */   public void setScrollBarTouch(boolean paramBoolean) {
/* 1020 */     this.w = paramBoolean;
/*      */   }
/*      */   
/*      */   public void setSmoothScrolling(boolean paramBoolean) {
/* 1024 */     this.P = paramBoolean;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setScrollbarsOnTop(boolean paramBoolean) {
/* 1031 */     this.ae = paramBoolean;
/* 1032 */     invalidate();
/*      */   }
/*      */   
/*      */   public boolean getVariableSizeKnobs() {
/* 1036 */     return this.af;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public void setVariableSizeKnobs(boolean paramBoolean) {
/* 1042 */     this.af = paramBoolean;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public void setCancelTouchFocus(boolean paramBoolean) {
/* 1048 */     this.y = paramBoolean;
/*      */   }
/*      */   
/*      */   public void drawDebug(ShapeRenderer paramShapeRenderer) {
/* 1052 */     a(paramShapeRenderer);
/* 1053 */     a(paramShapeRenderer, b());
/* 1054 */     if (clipBegin(this.k.x, this.k.y, this.k.width, this.k.height)) {
/* 1055 */       b(paramShapeRenderer);
/* 1056 */       paramShapeRenderer.flush();
/* 1057 */       clipEnd();
/*      */     } 
/* 1059 */     c(paramShapeRenderer);
/*      */   }
/*      */   public static class ScrollPaneStyle { @Null
/*      */     public Drawable background; @Null
/*      */     public Drawable corner; @Null
/*      */     public Drawable hScroll;
/*      */     @Null
/*      */     public Drawable hScrollKnob;
/*      */     @Null
/*      */     public Drawable vScroll;
/*      */     @Null
/*      */     public Drawable vScrollKnob;
/*      */     
/*      */     public ScrollPaneStyle() {}
/*      */     
/*      */     public ScrollPaneStyle(@Null Drawable param1Drawable1, @Null Drawable param1Drawable2, @Null Drawable param1Drawable3, @Null Drawable param1Drawable4, @Null Drawable param1Drawable5) {
/* 1075 */       this.background = param1Drawable1;
/* 1076 */       this.hScroll = param1Drawable2;
/* 1077 */       this.hScrollKnob = param1Drawable3;
/* 1078 */       this.vScroll = param1Drawable4;
/* 1079 */       this.vScrollKnob = param1Drawable5;
/*      */     }
/*      */     
/*      */     public ScrollPaneStyle(ScrollPaneStyle param1ScrollPaneStyle) {
/* 1083 */       this.background = param1ScrollPaneStyle.background;
/* 1084 */       this.corner = param1ScrollPaneStyle.corner;
/*      */       
/* 1086 */       this.hScroll = param1ScrollPaneStyle.hScroll;
/* 1087 */       this.hScrollKnob = param1ScrollPaneStyle.hScrollKnob;
/*      */       
/* 1089 */       this.vScroll = param1ScrollPaneStyle.vScroll;
/* 1090 */       this.vScrollKnob = param1ScrollPaneStyle.vScrollKnob;
/*      */     } }
/*      */ 
/*      */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\scene2\\ui\ScrollPane.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */