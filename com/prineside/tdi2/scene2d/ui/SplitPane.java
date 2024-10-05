/*     */ package com.prineside.tdi2.scene2d.ui;
/*     */ 
/*     */ import com.badlogic.gdx.graphics.Color;
/*     */ import com.badlogic.gdx.graphics.g2d.Batch;
/*     */ import com.badlogic.gdx.math.Rectangle;
/*     */ import com.badlogic.gdx.math.Vector2;
/*     */ import com.badlogic.gdx.utils.GdxRuntimeException;
/*     */ import com.badlogic.gdx.utils.Null;
/*     */ import com.prineside.tdi2.scene2d.Actor;
/*     */ import com.prineside.tdi2.scene2d.EventListener;
/*     */ import com.prineside.tdi2.scene2d.InputEvent;
/*     */ import com.prineside.tdi2.scene2d.InputListener;
/*     */ import com.prineside.tdi2.scene2d.Stage;
/*     */ import com.prineside.tdi2.scene2d.utils.Drawable;
/*     */ import com.prineside.tdi2.scene2d.utils.Layout;
/*     */ import com.prineside.tdi2.scene2d.utils.ScissorStack;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class SplitPane
/*     */   extends WidgetGroup
/*     */ {
/*     */   SplitPaneStyle k;
/*     */   @Null
/*     */   private Actor r;
/*     */   @Null
/*     */   private Actor s;
/*     */   boolean l;
/*  50 */   float m = 0.5F; private float u = 1.0F;
/*     */   private float t;
/*  52 */   private final Rectangle v = new Rectangle();
/*  53 */   private final Rectangle w = new Rectangle();
/*  54 */   final Rectangle n = new Rectangle();
/*     */   boolean o;
/*  56 */   private final Rectangle x = new Rectangle();
/*     */   
/*  58 */   Vector2 p = new Vector2();
/*  59 */   Vector2 q = new Vector2();
/*     */ 
/*     */ 
/*     */   
/*     */   public SplitPane(@Null Actor paramActor1, @Null Actor paramActor2, boolean paramBoolean, SplitPaneStyle paramSplitPaneStyle) {
/*  64 */     this.l = paramBoolean;
/*  65 */     setStyle(paramSplitPaneStyle);
/*  66 */     setFirstWidget(paramActor1);
/*  67 */     setSecondWidget(paramActor2);
/*  68 */     setSize(getPrefWidth(), getPrefHeight());
/*  69 */     d();
/*     */   }
/*     */   
/*     */   private void d() {
/*  73 */     addListener((EventListener)new InputListener(this) {
/*  74 */           private int a = -1;
/*     */           
/*     */           public boolean touchDown(InputEvent param1InputEvent, float param1Float1, float param1Float2, int param1Int1, int param1Int2) {
/*  77 */             if (this.a != -1) return false; 
/*  78 */             if (param1Int1 == 0 && param1Int2 != 0) return false; 
/*  79 */             if (this.b.n.contains(param1Float1, param1Float2)) {
/*  80 */               this.a = param1Int1;
/*  81 */               this.b.p.set(param1Float1, param1Float2);
/*  82 */               this.b.q.set(this.b.n.x, this.b.n.y);
/*  83 */               return true;
/*     */             } 
/*  85 */             return false;
/*     */           }
/*     */           
/*     */           public void touchUp(InputEvent param1InputEvent, float param1Float1, float param1Float2, int param1Int1, int param1Int2) {
/*  89 */             if (param1Int1 == this.a) this.a = -1; 
/*     */           }
/*     */           public void touchDragged(InputEvent param1InputEvent, float param1Float1, float param1Float2, int param1Int) {
/*     */             float f;
/*  93 */             if (param1Int != this.a)
/*     */               return; 
/*  95 */             Drawable drawable = this.b.k.handle;
/*  96 */             if (!this.b.l) {
/*  97 */               float f1 = param1Float1 - this.b.p.x;
/*  98 */               f = this.b.getWidth() - drawable.getMinWidth();
/*  99 */               f1 = this.b.q.x + f1;
/* 100 */               this.b.q.x = f1;
/* 101 */               f1 = Math.max(0.0F, f1);
/* 102 */               f1 = Math.min(f, f1);
/* 103 */               this.b.m = f1 / f;
/* 104 */               this.b.p.set(param1Float1, param1Float2);
/*     */             } else {
/* 106 */               float f1 = param1Float2 - this.b.p.y;
/* 107 */               f = this.b.getHeight() - f.getMinHeight();
/* 108 */               f1 = this.b.q.y + f1;
/* 109 */               this.b.q.y = f1;
/* 110 */               f1 = Math.max(0.0F, f1);
/* 111 */               f1 = Math.min(f, f1);
/* 112 */               this.b.m = 1.0F - f1 / f;
/* 113 */               this.b.p.set(param1Float1, param1Float2);
/*     */             } 
/* 115 */             this.b.invalidate();
/*     */           }
/*     */           
/*     */           public boolean mouseMoved(InputEvent param1InputEvent, float param1Float1, float param1Float2) {
/* 119 */             this.b.o = this.b.n.contains(param1Float1, param1Float2);
/* 120 */             return false;
/*     */           }
/*     */         });
/*     */   }
/*     */   
/*     */   public void setStyle(SplitPaneStyle paramSplitPaneStyle) {
/* 126 */     this.k = paramSplitPaneStyle;
/* 127 */     invalidateHierarchy();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public SplitPaneStyle getStyle() {
/* 133 */     return this.k;
/*     */   }
/*     */   
/*     */   public void layout() {
/* 137 */     g();
/* 138 */     if (!this.l) {
/* 139 */       e();
/*     */     } else {
/* 141 */       f();
/*     */     } 
/*     */     Actor actor1;
/* 144 */     if ((actor1 = this.r) != null) {
/* 145 */       Rectangle rectangle = this.v;
/* 146 */       actor1.setBounds(rectangle.x, rectangle.y, rectangle.width, rectangle.height);
/* 147 */       if (actor1 instanceof Layout) ((Layout)actor1).validate(); 
/*     */     } 
/*     */     Actor actor2;
/* 150 */     if ((actor2 = this.s) != null) {
/* 151 */       Rectangle rectangle = this.w;
/* 152 */       actor2.setBounds(rectangle.x, rectangle.y, rectangle.width, rectangle.height);
/* 153 */       if (actor2 instanceof Layout) ((Layout)actor2).validate();
/*     */     
/*     */     } 
/*     */   }
/*     */   
/*     */   public float getPrefWidth() {
/* 159 */     float f1 = (this.r == null) ? 0.0F : ((this.r instanceof Layout) ? ((Layout)this.r).getPrefWidth() : this.r.getWidth());
/*     */     
/* 161 */     float f2 = (this.s == null) ? 0.0F : ((this.s instanceof Layout) ? ((Layout)this.s).getPrefWidth() : this.s.getWidth());
/* 162 */     if (this.l) return Math.max(f1, f2); 
/* 163 */     return f1 + this.k.handle.getMinWidth() + f2;
/*     */   }
/*     */ 
/*     */   
/*     */   public float getPrefHeight() {
/* 168 */     float f1 = (this.r == null) ? 0.0F : ((this.r instanceof Layout) ? ((Layout)this.r).getPrefHeight() : this.r.getHeight());
/*     */     
/* 170 */     float f2 = (this.s == null) ? 0.0F : ((this.s instanceof Layout) ? ((Layout)this.s).getPrefHeight() : this.s.getHeight());
/* 171 */     if (!this.l) return Math.max(f1, f2); 
/* 172 */     return f1 + this.k.handle.getMinHeight() + f2;
/*     */   }
/*     */   
/*     */   public float getMinWidth() {
/* 176 */     float f1 = (this.r instanceof Layout) ? ((Layout)this.r).getMinWidth() : 0.0F;
/* 177 */     float f2 = (this.s instanceof Layout) ? ((Layout)this.s).getMinWidth() : 0.0F;
/* 178 */     if (this.l) return Math.max(f1, f2); 
/* 179 */     return f1 + this.k.handle.getMinWidth() + f2;
/*     */   }
/*     */   
/*     */   public float getMinHeight() {
/* 183 */     float f1 = (this.r instanceof Layout) ? ((Layout)this.r).getMinHeight() : 0.0F;
/* 184 */     float f2 = (this.s instanceof Layout) ? ((Layout)this.s).getMinHeight() : 0.0F;
/* 185 */     if (!this.l) return Math.max(f1, f2); 
/* 186 */     return f1 + this.k.handle.getMinHeight() + f2;
/*     */   }
/*     */   
/*     */   public void setVertical(boolean paramBoolean) {
/* 190 */     if (this.l == paramBoolean)
/* 191 */       return;  this.l = paramBoolean;
/* 192 */     invalidateHierarchy();
/*     */   }
/*     */   
/*     */   public boolean isVertical() {
/* 196 */     return this.l;
/*     */   }
/*     */   
/*     */   private void e() {
/* 200 */     Drawable drawable = this.k.handle;
/*     */     
/* 202 */     float f2 = getHeight();
/*     */ 
/*     */     
/* 205 */     float f3, f4 = (int)((f3 = getWidth() - drawable.getMinWidth()) * this.m);
/* 206 */     f3 -= f4;
/* 207 */     float f1 = drawable.getMinWidth();
/*     */     
/* 209 */     this.v.set(0.0F, 0.0F, f4, f2);
/* 210 */     this.w.set(f4 + f1, 0.0F, f3, f2);
/* 211 */     this.n.set(f4, 0.0F, f1, f2);
/*     */   }
/*     */   
/*     */   private void f() {
/* 215 */     Drawable drawable = this.k.handle;
/*     */     
/* 217 */     float f2 = getWidth();
/*     */ 
/*     */ 
/*     */     
/* 221 */     float f3, f4, f5 = (int)((f4 = (f3 = getHeight()) - drawable.getMinHeight()) * this.m);
/* 222 */     f4 -= f5;
/* 223 */     float f1 = drawable.getMinHeight();
/*     */     
/* 225 */     this.v.set(0.0F, f3 - f5, f2, f5);
/* 226 */     this.w.set(0.0F, 0.0F, f2, f4);
/* 227 */     this.n.set(0.0F, f4, f2, f1);
/*     */   }
/*     */   
/*     */   public void draw(Batch paramBatch, float paramFloat) {
/*     */     Stage stage;
/* 232 */     if ((stage = getStage()) == null)
/*     */       return; 
/* 234 */     validate();
/*     */     
/*     */     Color color;
/* 237 */     paramFloat = (color = getColor()).a * paramFloat;
/*     */     
/* 239 */     a(paramBatch, b());
/* 240 */     if (this.r != null && this.r.isVisible()) {
/* 241 */       paramBatch.flush();
/* 242 */       stage.calculateScissors(this.v, this.x);
/* 243 */       if (ScissorStack.pushScissors(this.x)) {
/* 244 */         this.r.draw(paramBatch, paramFloat);
/* 245 */         paramBatch.flush();
/* 246 */         ScissorStack.popScissors();
/*     */       } 
/*     */     } 
/* 249 */     if (this.s != null && this.s.isVisible()) {
/* 250 */       paramBatch.flush();
/* 251 */       stage.calculateScissors(this.w, this.x);
/* 252 */       if (ScissorStack.pushScissors(this.x)) {
/* 253 */         this.s.draw(paramBatch, paramFloat);
/* 254 */         paramBatch.flush();
/* 255 */         ScissorStack.popScissors();
/*     */       } 
/*     */     } 
/* 258 */     paramBatch.setColor(color.r, color.g, color.b, paramFloat);
/* 259 */     this.k.handle.draw(paramBatch, this.n.x, this.n.y, this.n.width, this.n.height);
/* 260 */     a(paramBatch);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setSplitAmount(float paramFloat) {
/* 266 */     this.m = paramFloat;
/* 267 */     invalidate();
/*     */   }
/*     */   
/*     */   public float getSplitAmount() {
/* 271 */     return this.m;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void g() {
/* 278 */     float f1 = this.t, f2 = this.u;
/*     */     
/* 280 */     if (this.l) {
/* 281 */       float f = getHeight() - this.k.handle.getMinHeight();
/* 282 */       if (this.r instanceof Layout) f1 = Math.max(f1, 
/* 283 */             Math.min(((Layout)this.r).getMinHeight() / f, 1.0F)); 
/* 284 */       if (this.s instanceof Layout) f2 = Math.min(f2, 1.0F - 
/* 285 */             Math.min(((Layout)this.s).getMinHeight() / f, 1.0F)); 
/*     */     } else {
/* 287 */       float f = getWidth() - this.k.handle.getMinWidth();
/* 288 */       if (this.r instanceof Layout)
/* 289 */         f1 = Math.max(f1, Math.min(((Layout)this.r).getMinWidth() / f, 1.0F)); 
/* 290 */       if (this.s instanceof Layout) f2 = Math.min(f2, 1.0F - 
/* 291 */             Math.min(((Layout)this.s).getMinWidth() / f, 1.0F));
/*     */     
/*     */     } 
/* 294 */     if (f1 > f2) {
/* 295 */       this.m = 0.5F * (f1 + f2); return;
/*     */     } 
/* 297 */     this.m = Math.max(Math.min(this.m, f2), f1);
/*     */   }
/*     */   
/*     */   public float getMinSplitAmount() {
/* 301 */     return this.t;
/*     */   }
/*     */   
/*     */   public void setMinSplitAmount(float paramFloat) {
/* 305 */     if (paramFloat < 0.0F || paramFloat > 1.0F) throw new GdxRuntimeException("minAmount has to be >= 0 and <= 1"); 
/* 306 */     this.t = paramFloat;
/*     */   }
/*     */   
/*     */   public float getMaxSplitAmount() {
/* 310 */     return this.u;
/*     */   }
/*     */   
/*     */   public void setMaxSplitAmount(float paramFloat) {
/* 314 */     if (paramFloat < 0.0F || paramFloat > 1.0F) throw new GdxRuntimeException("maxAmount has to be >= 0 and <= 1"); 
/* 315 */     this.u = paramFloat;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setFirstWidget(@Null Actor paramActor) {
/* 320 */     if (this.r != null) super.removeActor(this.r); 
/* 321 */     this.r = paramActor;
/* 322 */     if (paramActor != null) super.addActor(paramActor); 
/* 323 */     invalidate();
/*     */   }
/*     */ 
/*     */   
/*     */   public void setSecondWidget(@Null Actor paramActor) {
/* 328 */     if (this.s != null) super.removeActor(this.s); 
/* 329 */     this.s = paramActor;
/* 330 */     if (paramActor != null) super.addActor(paramActor); 
/* 331 */     invalidate();
/*     */   }
/*     */   
/*     */   public void addActor(Actor paramActor) {
/* 335 */     throw new UnsupportedOperationException("Use SplitPane#setWidget.");
/*     */   }
/*     */   
/*     */   public void addActorAt(int paramInt, Actor paramActor) {
/* 339 */     throw new UnsupportedOperationException("Use SplitPane#setWidget.");
/*     */   }
/*     */   
/*     */   public void addActorBefore(Actor paramActor1, Actor paramActor2) {
/* 343 */     throw new UnsupportedOperationException("Use SplitPane#setWidget.");
/*     */   }
/*     */   
/*     */   public boolean removeActor(Actor paramActor) {
/* 347 */     if (paramActor == null) throw new IllegalArgumentException("actor cannot be null."); 
/* 348 */     if (paramActor == this.r) {
/* 349 */       setFirstWidget((Actor)null);
/* 350 */       return true;
/*     */     } 
/* 352 */     if (paramActor == this.s) {
/* 353 */       setSecondWidget((Actor)null);
/* 354 */       return true;
/*     */     } 
/* 356 */     return true;
/*     */   }
/*     */   
/*     */   public boolean removeActor(Actor paramActor, boolean paramBoolean) {
/* 360 */     if (paramActor == null) throw new IllegalArgumentException("actor cannot be null."); 
/* 361 */     if (paramActor == this.r) {
/* 362 */       super.removeActor(paramActor, paramBoolean);
/* 363 */       this.r = null;
/* 364 */       invalidate();
/* 365 */       return true;
/*     */     } 
/* 367 */     if (paramActor == this.s) {
/* 368 */       super.removeActor(paramActor, paramBoolean);
/* 369 */       this.s = null;
/* 370 */       invalidate();
/* 371 */       return true;
/*     */     } 
/* 373 */     return false;
/*     */   }
/*     */   
/*     */   public Actor removeActorAt(int paramInt, boolean paramBoolean) {
/*     */     Actor actor;
/* 378 */     if ((actor = super.removeActorAt(paramInt, paramBoolean)) == this.r) {
/* 379 */       super.removeActor(actor, paramBoolean);
/* 380 */       this.r = null;
/* 381 */       invalidate();
/* 382 */     } else if (actor == this.s) {
/* 383 */       super.removeActor(actor, paramBoolean);
/* 384 */       this.s = null;
/* 385 */       invalidate();
/*     */     } 
/* 387 */     return actor;
/*     */   }
/*     */   
/*     */   public boolean isCursorOverHandle() {
/* 391 */     return this.o;
/*     */   }
/*     */ 
/*     */   
/*     */   public static class SplitPaneStyle
/*     */   {
/*     */     public Drawable handle;
/*     */ 
/*     */     
/*     */     public SplitPaneStyle() {}
/*     */ 
/*     */     
/*     */     public SplitPaneStyle(Drawable param1Drawable) {
/* 404 */       this.handle = param1Drawable;
/*     */     }
/*     */     
/*     */     public SplitPaneStyle(SplitPaneStyle param1SplitPaneStyle) {
/* 408 */       this.handle = param1SplitPaneStyle.handle;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\scene2\\ui\SplitPane.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */