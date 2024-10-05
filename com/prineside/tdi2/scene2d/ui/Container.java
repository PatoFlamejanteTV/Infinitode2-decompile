/*     */ package com.prineside.tdi2.scene2d.ui;
/*     */ 
/*     */ import com.badlogic.gdx.graphics.Color;
/*     */ import com.badlogic.gdx.graphics.g2d.Batch;
/*     */ import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
/*     */ import com.badlogic.gdx.math.Rectangle;
/*     */ import com.badlogic.gdx.utils.Null;
/*     */ import com.prineside.tdi2.scene2d.Actor;
/*     */ import com.prineside.tdi2.scene2d.Touchable;
/*     */ import com.prineside.tdi2.scene2d.utils.Cullable;
/*     */ import com.prineside.tdi2.scene2d.utils.Drawable;
/*     */ import com.prineside.tdi2.scene2d.utils.Layout;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class Container<T extends Actor>
/*     */   extends WidgetGroup
/*     */ {
/*     */   @Null
/*     */   private T k;
/*  22 */   private Value l = Value.minWidth, m = Value.minHeight;
/*  23 */   private Value n = Value.prefWidth, o = Value.prefHeight;
/*  24 */   private Value p = Value.zero, q = Value.zero;
/*  25 */   private Value r = Value.zero; private Value s = Value.zero; private Value t = Value.zero; private Value u = Value.zero; private float v;
/*     */   private float w;
/*     */   private int x;
/*     */   @Null
/*     */   private Drawable y;
/*     */   private boolean z;
/*     */   private boolean A = true;
/*     */   
/*     */   public Container() {
/*  34 */     setTouchable(Touchable.childrenOnly);
/*  35 */     setTransform(false);
/*     */   }
/*     */   
/*     */   public Container(@Null T paramT) {
/*  39 */     this();
/*  40 */     setActor(paramT);
/*     */   }
/*     */   
/*     */   public void draw(Batch paramBatch, float paramFloat) {
/*  44 */     validate();
/*  45 */     if (isTransform()) {
/*  46 */       a(paramBatch, b());
/*  47 */       a(paramBatch, paramFloat, 0.0F, 0.0F);
/*  48 */       if (this.z) {
/*  49 */         paramBatch.flush();
/*  50 */         float f1 = this.s.get((Actor)this), f2 = this.t.get((Actor)this);
/*  51 */         if (clipBegin(f1, f2, getWidth() - f1 - this.u.get((Actor)this), 
/*  52 */             getHeight() - f2 - this.r.get((Actor)this))) {
/*  53 */           a(paramBatch, paramFloat);
/*  54 */           paramBatch.flush();
/*  55 */           clipEnd();
/*     */         } 
/*     */       } else {
/*  58 */         a(paramBatch, paramFloat);
/*  59 */       }  a(paramBatch); return;
/*     */     } 
/*  61 */     a(paramBatch, paramFloat, getX(), getY());
/*  62 */     super.draw(paramBatch, paramFloat);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void a(Batch paramBatch, float paramFloat1, float paramFloat2, float paramFloat3) {
/*  69 */     if (this.y == null)
/*  70 */       return;  Color color = getColor();
/*  71 */     paramBatch.setColor(color.r, color.g, color.b, color.a * paramFloat1);
/*  72 */     this.y.draw(paramBatch, paramFloat2, paramFloat3, getWidth(), getHeight());
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setBackground(@Null Drawable paramDrawable) {
/*  78 */     setBackground(paramDrawable, true);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setBackground(@Null Drawable paramDrawable, boolean paramBoolean) {
/*  86 */     if (this.y == paramDrawable)
/*  87 */       return;  this.y = paramDrawable;
/*  88 */     if (paramBoolean) {
/*  89 */       if (paramDrawable == null) {
/*  90 */         pad(Value.zero);
/*     */       } else {
/*  92 */         pad(paramDrawable.getTopHeight(), paramDrawable.getLeftWidth(), paramDrawable.getBottomHeight(), paramDrawable.getRightWidth());
/*  93 */       }  invalidate();
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public Container<T> background(@Null Drawable paramDrawable) {
/*  99 */     setBackground(paramDrawable);
/* 100 */     return this;
/*     */   }
/*     */   @Null
/*     */   public Drawable getBackground() {
/* 104 */     return this.y;
/*     */   }
/*     */   
/*     */   public void layout() {
/* 108 */     if (this.k == null)
/*     */       return; 
/* 110 */     float f1 = this.s.get((Actor)this), f2 = this.t.get((Actor)this);
/* 111 */     float f3 = getWidth() - f1 - this.u.get((Actor)this);
/* 112 */     float f4 = getHeight() - f2 - this.r.get((Actor)this);
/* 113 */     float f5 = this.l.get((Actor)this.k), f6 = this.m.get((Actor)this.k);
/* 114 */     float f7 = this.n.get((Actor)this.k), f8 = this.o.get((Actor)this.k);
/* 115 */     float f9 = this.p.get((Actor)this.k), f10 = this.q.get((Actor)this.k);
/*     */ 
/*     */     
/* 118 */     if (this.v > 0.0F) {
/* 119 */       f7 = f3 * this.v;
/*     */     } else {
/* 121 */       f7 = Math.min(f7, f3);
/* 122 */     }  if (f7 < f5) f7 = f5; 
/* 123 */     if (f9 > 0.0F && f7 > f9) f7 = f9;
/*     */ 
/*     */     
/* 126 */     if (this.w > 0.0F) {
/* 127 */       f5 = f4 * this.w;
/*     */     } else {
/* 129 */       f5 = Math.min(f8, f4);
/* 130 */     }  if (f5 < f6) f5 = f6; 
/* 131 */     if (f10 > 0.0F && f5 > f10) f5 = f10;
/*     */     
/* 133 */     f6 = f1;
/* 134 */     if ((this.x & 0x10) != 0) {
/* 135 */       f6 = f1 + f3 - f7;
/* 136 */     } else if ((this.x & 0x8) == 0) {
/* 137 */       f6 = f1 + (f3 - f7) / 2.0F;
/*     */     } 
/* 139 */     f1 = f2;
/* 140 */     if ((this.x & 0x2) != 0) {
/* 141 */       f1 = f2 + f4 - f5;
/* 142 */     } else if ((this.x & 0x4) == 0) {
/* 143 */       f1 = f2 + (f4 - f5) / 2.0F;
/*     */     } 
/* 145 */     if (this.A) {
/* 146 */       f6 = (float)Math.floor(f6);
/* 147 */       f1 = (float)Math.floor(f1);
/* 148 */       f7 = (float)Math.ceil(f7);
/* 149 */       f5 = (float)Math.ceil(f5);
/*     */     } 
/*     */     
/* 152 */     this.k.setBounds(f6, f1, f7, f5);
/* 153 */     if (this.k instanceof Layout) ((Layout)this.k).validate(); 
/*     */   }
/*     */   
/*     */   public void setCullingArea(Rectangle paramRectangle) {
/* 157 */     super.setCullingArea(paramRectangle);
/* 158 */     if (this.v == 1.0F && this.w == 1.0F && this.k instanceof Cullable) ((Cullable)this.k).setCullingArea(paramRectangle);
/*     */   
/*     */   }
/*     */   
/*     */   public void setActor(@Null T paramT) {
/* 163 */     if (paramT == this) throw new IllegalArgumentException("actor cannot be the Container."); 
/* 164 */     if (paramT == this.k)
/* 165 */       return;  if (this.k != null) super.removeActor((Actor)this.k); 
/* 166 */     this.k = paramT;
/* 167 */     if (paramT != null) super.addActor((Actor)paramT); 
/*     */   }
/*     */   
/*     */   @Null
/*     */   public T getActor() {
/* 172 */     return this.k;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   @Deprecated
/*     */   public void addActor(Actor paramActor) {
/* 179 */     throw new UnsupportedOperationException("Use Container#setActor.");
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   @Deprecated
/*     */   public void addActorAt(int paramInt, Actor paramActor) {
/* 186 */     throw new UnsupportedOperationException("Use Container#setActor.");
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   @Deprecated
/*     */   public void addActorBefore(Actor paramActor1, Actor paramActor2) {
/* 193 */     throw new UnsupportedOperationException("Use Container#setActor.");
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   @Deprecated
/*     */   public void addActorAfter(Actor paramActor1, Actor paramActor2) {
/* 200 */     throw new UnsupportedOperationException("Use Container#setActor.");
/*     */   }
/*     */   
/*     */   public boolean removeActor(Actor paramActor) {
/* 204 */     if (paramActor == null) throw new IllegalArgumentException("actor cannot be null."); 
/* 205 */     if (paramActor != this.k) return false; 
/* 206 */     setActor((T)null);
/* 207 */     return true;
/*     */   }
/*     */   
/*     */   public boolean removeActor(Actor paramActor, boolean paramBoolean) {
/* 211 */     if (paramActor == null) throw new IllegalArgumentException("actor cannot be null."); 
/* 212 */     if (paramActor != this.k) return false; 
/* 213 */     this.k = null;
/* 214 */     return super.removeActor(paramActor, paramBoolean);
/*     */   }
/*     */   
/*     */   public Actor removeActorAt(int paramInt, boolean paramBoolean) {
/*     */     Actor actor;
/* 219 */     if ((actor = super.removeActorAt(paramInt, paramBoolean)) == this.k) this.k = null; 
/* 220 */     return actor;
/*     */   }
/*     */ 
/*     */   
/*     */   public Container<T> size(Value paramValue) {
/* 225 */     if (paramValue == null) throw new IllegalArgumentException("size cannot be null."); 
/* 226 */     this.l = paramValue;
/* 227 */     this.m = paramValue;
/* 228 */     this.n = paramValue;
/* 229 */     this.o = paramValue;
/* 230 */     this.p = paramValue;
/* 231 */     this.q = paramValue;
/* 232 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   public Container<T> size(Value paramValue1, Value paramValue2) {
/* 237 */     if (paramValue1 == null) throw new IllegalArgumentException("width cannot be null."); 
/* 238 */     if (paramValue2 == null) throw new IllegalArgumentException("height cannot be null."); 
/* 239 */     this.l = paramValue1;
/* 240 */     this.m = paramValue2;
/* 241 */     this.n = paramValue1;
/* 242 */     this.o = paramValue2;
/* 243 */     this.p = paramValue1;
/* 244 */     this.q = paramValue2;
/* 245 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   public Container<T> size(float paramFloat) {
/* 250 */     size(Value.Fixed.valueOf(paramFloat));
/* 251 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   public Container<T> size(float paramFloat1, float paramFloat2) {
/* 256 */     size(Value.Fixed.valueOf(paramFloat1), Value.Fixed.valueOf(paramFloat2));
/* 257 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   public Container<T> width(Value paramValue) {
/* 262 */     if (paramValue == null) throw new IllegalArgumentException("width cannot be null."); 
/* 263 */     this.l = paramValue;
/* 264 */     this.n = paramValue;
/* 265 */     this.p = paramValue;
/* 266 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   public Container<T> width(float paramFloat) {
/* 271 */     width(Value.Fixed.valueOf(paramFloat));
/* 272 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   public Container<T> height(Value paramValue) {
/* 277 */     if (paramValue == null) throw new IllegalArgumentException("height cannot be null."); 
/* 278 */     this.m = paramValue;
/* 279 */     this.o = paramValue;
/* 280 */     this.q = paramValue;
/* 281 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   public Container<T> height(float paramFloat) {
/* 286 */     height(Value.Fixed.valueOf(paramFloat));
/* 287 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   public Container<T> minSize(Value paramValue) {
/* 292 */     if (paramValue == null) throw new IllegalArgumentException("size cannot be null."); 
/* 293 */     this.l = paramValue;
/* 294 */     this.m = paramValue;
/* 295 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   public Container<T> minSize(Value paramValue1, Value paramValue2) {
/* 300 */     if (paramValue1 == null) throw new IllegalArgumentException("width cannot be null."); 
/* 301 */     if (paramValue2 == null) throw new IllegalArgumentException("height cannot be null."); 
/* 302 */     this.l = paramValue1;
/* 303 */     this.m = paramValue2;
/* 304 */     return this;
/*     */   }
/*     */   
/*     */   public Container<T> minWidth(Value paramValue) {
/* 308 */     if (paramValue == null) throw new IllegalArgumentException("minWidth cannot be null."); 
/* 309 */     this.l = paramValue;
/* 310 */     return this;
/*     */   }
/*     */   
/*     */   public Container<T> minHeight(Value paramValue) {
/* 314 */     if (paramValue == null) throw new IllegalArgumentException("minHeight cannot be null."); 
/* 315 */     this.m = paramValue;
/* 316 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   public Container<T> minSize(float paramFloat) {
/* 321 */     minSize(Value.Fixed.valueOf(paramFloat));
/* 322 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   public Container<T> minSize(float paramFloat1, float paramFloat2) {
/* 327 */     minSize(Value.Fixed.valueOf(paramFloat1), Value.Fixed.valueOf(paramFloat2));
/* 328 */     return this;
/*     */   }
/*     */   
/*     */   public Container<T> minWidth(float paramFloat) {
/* 332 */     this.l = Value.Fixed.valueOf(paramFloat);
/* 333 */     return this;
/*     */   }
/*     */   
/*     */   public Container<T> minHeight(float paramFloat) {
/* 337 */     this.m = Value.Fixed.valueOf(paramFloat);
/* 338 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   public Container<T> prefSize(Value paramValue) {
/* 343 */     if (paramValue == null) throw new IllegalArgumentException("size cannot be null."); 
/* 344 */     this.n = paramValue;
/* 345 */     this.o = paramValue;
/* 346 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   public Container<T> prefSize(Value paramValue1, Value paramValue2) {
/* 351 */     if (paramValue1 == null) throw new IllegalArgumentException("width cannot be null."); 
/* 352 */     if (paramValue2 == null) throw new IllegalArgumentException("height cannot be null."); 
/* 353 */     this.n = paramValue1;
/* 354 */     this.o = paramValue2;
/* 355 */     return this;
/*     */   }
/*     */   
/*     */   public Container<T> prefWidth(Value paramValue) {
/* 359 */     if (paramValue == null) throw new IllegalArgumentException("prefWidth cannot be null."); 
/* 360 */     this.n = paramValue;
/* 361 */     return this;
/*     */   }
/*     */   
/*     */   public Container<T> prefHeight(Value paramValue) {
/* 365 */     if (paramValue == null) throw new IllegalArgumentException("prefHeight cannot be null."); 
/* 366 */     this.o = paramValue;
/* 367 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   public Container<T> prefSize(float paramFloat1, float paramFloat2) {
/* 372 */     prefSize(Value.Fixed.valueOf(paramFloat1), Value.Fixed.valueOf(paramFloat2));
/* 373 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   public Container<T> prefSize(float paramFloat) {
/* 378 */     prefSize(Value.Fixed.valueOf(paramFloat));
/* 379 */     return this;
/*     */   }
/*     */   
/*     */   public Container<T> prefWidth(float paramFloat) {
/* 383 */     this.n = Value.Fixed.valueOf(paramFloat);
/* 384 */     return this;
/*     */   }
/*     */   
/*     */   public Container<T> prefHeight(float paramFloat) {
/* 388 */     this.o = Value.Fixed.valueOf(paramFloat);
/* 389 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   public Container<T> maxSize(Value paramValue) {
/* 394 */     if (paramValue == null) throw new IllegalArgumentException("size cannot be null."); 
/* 395 */     this.p = paramValue;
/* 396 */     this.q = paramValue;
/* 397 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   public Container<T> maxSize(Value paramValue1, Value paramValue2) {
/* 402 */     if (paramValue1 == null) throw new IllegalArgumentException("width cannot be null."); 
/* 403 */     if (paramValue2 == null) throw new IllegalArgumentException("height cannot be null."); 
/* 404 */     this.p = paramValue1;
/* 405 */     this.q = paramValue2;
/* 406 */     return this;
/*     */   }
/*     */   
/*     */   public Container<T> maxWidth(Value paramValue) {
/* 410 */     if (paramValue == null) throw new IllegalArgumentException("maxWidth cannot be null."); 
/* 411 */     this.p = paramValue;
/* 412 */     return this;
/*     */   }
/*     */   
/*     */   public Container<T> maxHeight(Value paramValue) {
/* 416 */     if (paramValue == null) throw new IllegalArgumentException("maxHeight cannot be null."); 
/* 417 */     this.q = paramValue;
/* 418 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   public Container<T> maxSize(float paramFloat) {
/* 423 */     maxSize(Value.Fixed.valueOf(paramFloat));
/* 424 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   public Container<T> maxSize(float paramFloat1, float paramFloat2) {
/* 429 */     maxSize(Value.Fixed.valueOf(paramFloat1), Value.Fixed.valueOf(paramFloat2));
/* 430 */     return this;
/*     */   }
/*     */   
/*     */   public Container<T> maxWidth(float paramFloat) {
/* 434 */     this.p = Value.Fixed.valueOf(paramFloat);
/* 435 */     return this;
/*     */   }
/*     */   
/*     */   public Container<T> maxHeight(float paramFloat) {
/* 439 */     this.q = Value.Fixed.valueOf(paramFloat);
/* 440 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   public Container<T> pad(Value paramValue) {
/* 445 */     if (paramValue == null) throw new IllegalArgumentException("pad cannot be null."); 
/* 446 */     this.r = paramValue;
/* 447 */     this.s = paramValue;
/* 448 */     this.t = paramValue;
/* 449 */     this.u = paramValue;
/* 450 */     return this;
/*     */   }
/*     */   
/*     */   public Container<T> pad(Value paramValue1, Value paramValue2, Value paramValue3, Value paramValue4) {
/* 454 */     if (paramValue1 == null) throw new IllegalArgumentException("top cannot be null."); 
/* 455 */     if (paramValue2 == null) throw new IllegalArgumentException("left cannot be null."); 
/* 456 */     if (paramValue3 == null) throw new IllegalArgumentException("bottom cannot be null."); 
/* 457 */     if (paramValue4 == null) throw new IllegalArgumentException("right cannot be null."); 
/* 458 */     this.r = paramValue1;
/* 459 */     this.s = paramValue2;
/* 460 */     this.t = paramValue3;
/* 461 */     this.u = paramValue4;
/* 462 */     return this;
/*     */   }
/*     */   
/*     */   public Container<T> padTop(Value paramValue) {
/* 466 */     if (paramValue == null) throw new IllegalArgumentException("padTop cannot be null."); 
/* 467 */     this.r = paramValue;
/* 468 */     return this;
/*     */   }
/*     */   
/*     */   public Container<T> padLeft(Value paramValue) {
/* 472 */     if (paramValue == null) throw new IllegalArgumentException("padLeft cannot be null."); 
/* 473 */     this.s = paramValue;
/* 474 */     return this;
/*     */   }
/*     */   
/*     */   public Container<T> padBottom(Value paramValue) {
/* 478 */     if (paramValue == null) throw new IllegalArgumentException("padBottom cannot be null."); 
/* 479 */     this.t = paramValue;
/* 480 */     return this;
/*     */   }
/*     */   
/*     */   public Container<T> padRight(Value paramValue) {
/* 484 */     if (paramValue == null) throw new IllegalArgumentException("padRight cannot be null."); 
/* 485 */     this.u = paramValue;
/* 486 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   public Container<T> pad(float paramFloat) {
/* 491 */     Value.Fixed fixed = Value.Fixed.valueOf(paramFloat);
/* 492 */     this.r = fixed;
/* 493 */     this.s = fixed;
/* 494 */     this.t = fixed;
/* 495 */     this.u = fixed;
/* 496 */     return this;
/*     */   }
/*     */   
/*     */   public Container<T> pad(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4) {
/* 500 */     this.r = Value.Fixed.valueOf(paramFloat1);
/* 501 */     this.s = Value.Fixed.valueOf(paramFloat2);
/* 502 */     this.t = Value.Fixed.valueOf(paramFloat3);
/* 503 */     this.u = Value.Fixed.valueOf(paramFloat4);
/* 504 */     return this;
/*     */   }
/*     */   
/*     */   public Container<T> padTop(float paramFloat) {
/* 508 */     this.r = Value.Fixed.valueOf(paramFloat);
/* 509 */     return this;
/*     */   }
/*     */   
/*     */   public Container<T> padLeft(float paramFloat) {
/* 513 */     this.s = Value.Fixed.valueOf(paramFloat);
/* 514 */     return this;
/*     */   }
/*     */   
/*     */   public Container<T> padBottom(float paramFloat) {
/* 518 */     this.t = Value.Fixed.valueOf(paramFloat);
/* 519 */     return this;
/*     */   }
/*     */   
/*     */   public Container<T> padRight(float paramFloat) {
/* 523 */     this.u = Value.Fixed.valueOf(paramFloat);
/* 524 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   public Container<T> fill() {
/* 529 */     this.v = 1.0F;
/* 530 */     this.w = 1.0F;
/* 531 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   public Container<T> fillX() {
/* 536 */     this.v = 1.0F;
/* 537 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   public Container<T> fillY() {
/* 542 */     this.w = 1.0F;
/* 543 */     return this;
/*     */   }
/*     */   
/*     */   public Container<T> fill(float paramFloat1, float paramFloat2) {
/* 547 */     this.v = paramFloat1;
/* 548 */     this.w = paramFloat2;
/* 549 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   public Container<T> fill(boolean paramBoolean1, boolean paramBoolean2) {
/* 554 */     this.v = paramBoolean1 ? 1.0F : 0.0F;
/* 555 */     this.w = paramBoolean2 ? 1.0F : 0.0F;
/* 556 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   public Container<T> fill(boolean paramBoolean) {
/* 561 */     this.v = paramBoolean ? 1.0F : 0.0F;
/* 562 */     this.w = paramBoolean ? 1.0F : 0.0F;
/* 563 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public Container<T> align(int paramInt) {
/* 569 */     this.x = paramInt;
/* 570 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   public Container<T> center() {
/* 575 */     this.x = 1;
/* 576 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   public Container<T> top() {
/* 581 */     this.x |= 0x2;
/* 582 */     this.x &= 0xFFFFFFFB;
/* 583 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   public Container<T> left() {
/* 588 */     this.x |= 0x8;
/* 589 */     this.x &= 0xFFFFFFEF;
/* 590 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   public Container<T> bottom() {
/* 595 */     this.x |= 0x4;
/* 596 */     this.x &= 0xFFFFFFFD;
/* 597 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   public Container<T> right() {
/* 602 */     this.x |= 0x10;
/* 603 */     this.x &= 0xFFFFFFF7;
/* 604 */     return this;
/*     */   }
/*     */   
/*     */   public float getMinWidth() {
/* 608 */     return this.l.get((Actor)this.k) + this.s.get((Actor)this) + this.u.get((Actor)this);
/*     */   }
/*     */   
/*     */   public Value getMinHeightValue() {
/* 612 */     return this.m;
/*     */   }
/*     */   
/*     */   public float getMinHeight() {
/* 616 */     return this.m.get((Actor)this.k) + this.r.get((Actor)this) + this.t.get((Actor)this);
/*     */   }
/*     */   
/*     */   public Value getPrefWidthValue() {
/* 620 */     return this.n;
/*     */   }
/*     */   
/*     */   public float getPrefWidth() {
/* 624 */     float f = this.n.get((Actor)this.k);
/* 625 */     if (this.y != null) f = Math.max(f, this.y.getMinWidth()); 
/* 626 */     return Math.max(getMinWidth(), f + this.s.get((Actor)this) + this.u.get((Actor)this));
/*     */   }
/*     */   
/*     */   public Value getPrefHeightValue() {
/* 630 */     return this.o;
/*     */   }
/*     */   
/*     */   public float getPrefHeight() {
/* 634 */     float f = this.o.get((Actor)this.k);
/* 635 */     if (this.y != null) f = Math.max(f, this.y.getMinHeight()); 
/* 636 */     return Math.max(getMinHeight(), f + this.r.get((Actor)this) + this.t.get((Actor)this));
/*     */   }
/*     */   
/*     */   public Value getMaxWidthValue() {
/* 640 */     return this.p;
/*     */   }
/*     */   
/*     */   public float getMaxWidth() {
/*     */     float f;
/* 645 */     if ((f = this.p.get((Actor)this.k)) > 0.0F) f += this.s.get((Actor)this) + this.u.get((Actor)this); 
/* 646 */     return f;
/*     */   }
/*     */   
/*     */   public Value getMaxHeightValue() {
/* 650 */     return this.q;
/*     */   }
/*     */   
/*     */   public float getMaxHeight() {
/*     */     float f;
/* 655 */     if ((f = this.q.get((Actor)this.k)) > 0.0F) f += this.r.get((Actor)this) + this.t.get((Actor)this); 
/* 656 */     return f;
/*     */   }
/*     */   
/*     */   public Value getPadTopValue() {
/* 660 */     return this.r;
/*     */   }
/*     */   
/*     */   public float getPadTop() {
/* 664 */     return this.r.get((Actor)this);
/*     */   }
/*     */   
/*     */   public Value getPadLeftValue() {
/* 668 */     return this.s;
/*     */   }
/*     */   
/*     */   public float getPadLeft() {
/* 672 */     return this.s.get((Actor)this);
/*     */   }
/*     */   
/*     */   public Value getPadBottomValue() {
/* 676 */     return this.t;
/*     */   }
/*     */   
/*     */   public float getPadBottom() {
/* 680 */     return this.t.get((Actor)this);
/*     */   }
/*     */   
/*     */   public Value getPadRightValue() {
/* 684 */     return this.u;
/*     */   }
/*     */   
/*     */   public float getPadRight() {
/* 688 */     return this.u.get((Actor)this);
/*     */   }
/*     */ 
/*     */   
/*     */   public float getPadX() {
/* 693 */     return this.s.get((Actor)this) + this.u.get((Actor)this);
/*     */   }
/*     */ 
/*     */   
/*     */   public float getPadY() {
/* 698 */     return this.r.get((Actor)this) + this.t.get((Actor)this);
/*     */   }
/*     */   
/*     */   public float getFillX() {
/* 702 */     return this.v;
/*     */   }
/*     */   
/*     */   public float getFillY() {
/* 706 */     return this.w;
/*     */   }
/*     */   
/*     */   public int getAlign() {
/* 710 */     return this.x;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setRound(boolean paramBoolean) {
/* 715 */     this.A = paramBoolean;
/*     */   }
/*     */ 
/*     */   
/*     */   public Container<T> clip() {
/* 720 */     setClip(true);
/* 721 */     return this;
/*     */   }
/*     */   
/*     */   public Container<T> clip(boolean paramBoolean) {
/* 725 */     setClip(paramBoolean);
/* 726 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setClip(boolean paramBoolean) {
/* 732 */     this.z = paramBoolean;
/* 733 */     setTransform(paramBoolean);
/* 734 */     invalidate();
/*     */   }
/*     */   
/*     */   public boolean getClip() {
/* 738 */     return this.z;
/*     */   }
/*     */   @Null
/*     */   public Actor hit(float paramFloat1, float paramFloat2, boolean paramBoolean) {
/* 742 */     if (this.z) {
/* 743 */       if (paramBoolean && getTouchable() == Touchable.disabled) return null; 
/* 744 */       if (paramFloat1 < 0.0F || paramFloat1 >= getWidth() || paramFloat2 < 0.0F || paramFloat2 >= getHeight()) return null; 
/*     */     } 
/* 746 */     return super.hit(paramFloat1, paramFloat2, paramBoolean);
/*     */   }
/*     */   
/*     */   public void drawDebug(ShapeRenderer paramShapeRenderer) {
/* 750 */     validate();
/* 751 */     if (isTransform()) {
/* 752 */       a(paramShapeRenderer, b());
/* 753 */       if (this.z) {
/* 754 */         paramShapeRenderer.flush();
/* 755 */         float f1 = this.s.get((Actor)this), f2 = this.t.get((Actor)this);
/*     */         
/*     */         boolean bool;
/*     */         
/* 759 */         if (bool = (this.y == null) ? clipBegin(0.0F, 0.0F, getWidth(), getHeight()) : clipBegin(f1, f2, getWidth() - f1 - this.u.get((Actor)this), getHeight() - f2 - this.r.get((Actor)this))) {
/* 760 */           b(paramShapeRenderer);
/* 761 */           clipEnd();
/*     */         } 
/*     */       } else {
/* 764 */         b(paramShapeRenderer);
/* 765 */       }  c(paramShapeRenderer); return;
/*     */     } 
/* 767 */     super.drawDebug(paramShapeRenderer);
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\scene2\\ui\Container.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */