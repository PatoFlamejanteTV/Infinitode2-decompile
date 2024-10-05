/*     */ package com.prineside.tdi2.scene2d.ui;
/*     */ 
/*     */ import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
/*     */ import com.badlogic.gdx.utils.FloatArray;
/*     */ import com.badlogic.gdx.utils.SnapshotArray;
/*     */ import com.prineside.tdi2.scene2d.Actor;
/*     */ import com.prineside.tdi2.scene2d.Touchable;
/*     */ import com.prineside.tdi2.scene2d.utils.Layout;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class VerticalGroup
/*     */   extends WidgetGroup
/*     */ {
/*     */   private float k;
/*     */   private float l;
/*     */   private float m;
/*     */   private boolean n = true;
/*     */   private FloatArray o;
/*  45 */   private int p = 2; private int q; private boolean r; private boolean s = true; private boolean t;
/*     */   private boolean u;
/*     */   private float v;
/*     */   
/*     */   public VerticalGroup() {
/*  50 */     setTouchable(Touchable.childrenOnly);
/*     */   }
/*     */   private float w; private float x; private float y; private float z; private float A; private float B;
/*     */   public void invalidate() {
/*  54 */     super.invalidate();
/*  55 */     this.n = true;
/*     */   }
/*     */   
/*     */   private void d() {
/*  59 */     this.n = false;
/*     */     SnapshotArray snapshotArray;
/*  61 */     int i = (snapshotArray = getChildren()).size;
/*  62 */     this.k = 0.0F;
/*  63 */     if (this.t) {
/*  64 */       this.l = 0.0F;
/*  65 */       if (this.o == null) {
/*  66 */         this.o = new FloatArray();
/*     */       } else {
/*  68 */         this.o.clear();
/*  69 */       }  FloatArray floatArray = this.o;
/*  70 */       float f1 = this.v, f2 = this.w;
/*  71 */       float f3 = this.y + this.A, f4 = getHeight() - f3, f5 = 0.0F, f6 = 0.0F, f7 = 0.0F;
/*  72 */       int j = 0; byte b = 1;
/*  73 */       if (this.r) {
/*  74 */         j = i - 1;
/*  75 */         i = -1;
/*  76 */         b = -1;
/*     */       } 
/*  78 */       for (; j != i; j += b) {
/*     */         float f8, f9;
/*     */         
/*     */         Actor actor;
/*  82 */         if (actor = (Actor)snapshotArray.get(j) instanceof Layout) {
/*     */           Layout layout;
/*  84 */           f9 = (layout = (Layout)actor).getPrefWidth();
/*     */           
/*  86 */           if ((f8 = layout.getPrefHeight()) > f4) f8 = Math.max(f4, layout.getMinHeight()); 
/*     */         } else {
/*  88 */           f9 = f8.getWidth();
/*  89 */           f8 = f8.getHeight();
/*     */         } 
/*     */         
/*  92 */         float f10 = f8 + ((f6 > 0.0F) ? f1 : 0.0F);
/*  93 */         if (f6 + f10 > f4 && f6 > 0.0F) {
/*  94 */           floatArray.add(f6);
/*  95 */           floatArray.add(f7);
/*  96 */           this.l = Math.max(this.l, f6 + f3);
/*  97 */           if (f5 > 0.0F) f5 += f2; 
/*  98 */           f5 += f7;
/*  99 */           f7 = 0.0F;
/* 100 */           f6 = 0.0F;
/* 101 */           f10 = f8;
/*     */         } 
/* 103 */         f6 += f10;
/* 104 */         f7 = Math.max(f7, f9);
/*     */       } 
/* 106 */       floatArray.add(f6);
/* 107 */       floatArray.add(f7);
/* 108 */       this.l = Math.max(this.l, f6 + f3);
/* 109 */       if (f5 > 0.0F) f5 += f2; 
/* 110 */       this.k = Math.max(this.k, f5 + f7);
/*     */     } else {
/* 112 */       this.l = this.y + this.A + this.v * (i - 1);
/* 113 */       for (byte b = 0; b < i; b++) {
/*     */         Actor actor;
/* 115 */         if (actor = (Actor)snapshotArray.get(b) instanceof Layout) {
/* 116 */           Layout layout = (Layout)actor;
/* 117 */           this.k = Math.max(this.k, layout.getPrefWidth());
/* 118 */           this.l += layout.getPrefHeight();
/*     */         } else {
/* 120 */           this.k = Math.max(this.k, actor.getWidth());
/* 121 */           this.l += actor.getHeight();
/*     */         } 
/*     */       } 
/*     */     } 
/* 125 */     this.k += this.z + this.B;
/* 126 */     if (this.s) {
/* 127 */       this.k = (float)Math.ceil(this.k);
/* 128 */       this.l = (float)Math.ceil(this.l);
/*     */     } 
/*     */   }
/*     */   
/*     */   public void layout() {
/* 133 */     if (this.n) d();
/*     */     
/* 135 */     if (this.t) {
/* 136 */       e();
/*     */       
/*     */       return;
/*     */     } 
/* 140 */     boolean bool = this.s;
/* 141 */     int i = this.p;
/* 142 */     float f1 = this.v, f2 = this.z, f3 = this.x;
/* 143 */     float f4 = (this.u ? getWidth() : this.k) - f2 - this.B, f5 = this.l - this.y + f1;
/*     */     
/* 145 */     if ((i & 0x2) != 0) {
/* 146 */       f5 += getHeight() - this.l;
/* 147 */     } else if ((i & 0x4) == 0) {
/* 148 */       f5 += (getHeight() - this.l) / 2.0F;
/*     */     } 
/*     */     
/* 151 */     if ((i & 0x8) != 0) {
/* 152 */       f2 = f2;
/* 153 */     } else if ((i & 0x10) != 0) {
/* 154 */       f2 = getWidth() - this.B - f4;
/*     */     } else {
/* 156 */       f2 += (getWidth() - f2 - this.B - f4) / 2.0F;
/*     */     } 
/* 158 */     i = this.q;
/*     */     
/* 160 */     SnapshotArray snapshotArray = getChildren();
/* 161 */     int j = 0, k = snapshotArray.size; byte b = 1;
/* 162 */     if (this.r) {
/* 163 */       j = k - 1;
/* 164 */       k = -1;
/* 165 */       b = -1;
/*     */     } 
/* 167 */     for (; j != k; j += b) {
/* 168 */       float f7; Actor actor = (Actor)snapshotArray.get(j);
/*     */ 
/*     */       
/* 171 */       Layout layout = null;
/* 172 */       if (actor instanceof Layout) {
/*     */         
/* 174 */         f6 = (layout = (Layout)actor).getPrefWidth();
/* 175 */         f7 = layout.getPrefHeight();
/*     */       } else {
/* 177 */         f6 = actor.getWidth();
/* 178 */         f7 = actor.getHeight();
/*     */       } 
/*     */       
/* 181 */       if (f3 > 0.0F) f6 = f4 * f3;
/*     */ 
/*     */       
/* 184 */       float f6 = Math.max(f6, layout.getMinWidth());
/*     */       float f8;
/* 186 */       if (layout != null && (f8 = layout.getMaxWidth()) > 0.0F && f6 > f8) f6 = f8;
/*     */ 
/*     */       
/* 189 */       f8 = f2;
/* 190 */       if ((i & 0x10) != 0) {
/* 191 */         f8 += f4 - f6;
/* 192 */       } else if ((i & 0x8) == 0) {
/* 193 */         f8 += (f4 - f6) / 2.0F;
/*     */       } 
/* 195 */       f5 -= f7 + f1;
/* 196 */       if (bool) {
/* 197 */         actor.setBounds((float)Math.floor(f8), (float)Math.floor(f5), (float)Math.ceil(f6), (float)Math.ceil(f7));
/*     */       } else {
/* 199 */         actor.setBounds(f8, f5, f6, f7);
/*     */       } 
/* 201 */       if (layout != null) layout.validate(); 
/*     */     } 
/*     */   }
/*     */   
/*     */   private void e() {
/*     */     float f1;
/* 207 */     if ((f1 = getPrefWidth()) != this.m) {
/* 208 */       this.m = f1;
/* 209 */       invalidateHierarchy();
/*     */     } 
/*     */     
/* 212 */     int i = this.p;
/* 213 */     boolean bool = this.s;
/* 214 */     float f2 = this.v, f3 = this.z, f4 = this.x, f5 = this.w;
/* 215 */     float f6 = this.l - this.y - this.A;
/* 216 */     f3 = f3; float f7 = getHeight();
/* 217 */     float f8 = this.l - this.y + f2, f9 = 0.0F, f10 = 0.0F;
/*     */     
/* 219 */     if ((i & 0x10) != 0) {
/* 220 */       f3 += getWidth() - f1;
/* 221 */     } else if ((i & 0x8) == 0) {
/* 222 */       f3 += (getWidth() - f1) / 2.0F;
/*     */     } 
/* 224 */     if ((i & 0x2) != 0) {
/* 225 */       f8 += f7 - this.l;
/* 226 */     } else if ((i & 0x4) == 0) {
/* 227 */       f8 += (f7 - this.l) / 2.0F;
/*     */     } 
/* 229 */     f7 -= this.y;
/* 230 */     i = this.q;
/*     */     
/* 232 */     FloatArray floatArray = this.o;
/* 233 */     SnapshotArray snapshotArray = getChildren();
/* 234 */     int j = 0, k = snapshotArray.size; byte b = 1;
/* 235 */     if (this.r) {
/* 236 */       j = k - 1;
/* 237 */       k = -1;
/* 238 */       b = -1;
/*     */     } 
/* 240 */     for (int m = 0; j != k; j += b) {
/* 241 */       float f12; Actor actor = (Actor)snapshotArray.get(j);
/*     */ 
/*     */       
/* 244 */       Layout layout = null;
/* 245 */       if (actor instanceof Layout) {
/*     */         
/* 247 */         f11 = (layout = (Layout)actor).getPrefWidth();
/*     */         
/* 249 */         if ((f12 = layout.getPrefHeight()) > f7) f12 = Math.max(f7, layout.getMinHeight()); 
/*     */       } else {
/* 251 */         f11 = actor.getWidth();
/* 252 */         f12 = actor.getHeight();
/*     */       } 
/*     */       
/* 255 */       if (f9 - f12 - f2 < this.A || !m) {
/* 256 */         m = Math.min(m, floatArray.size - 2);
/* 257 */         f9 = f8;
/* 258 */         if ((i & 0x4) != 0) {
/* 259 */           f9 -= f6 - floatArray.get(m);
/* 260 */         } else if ((i & 0x2) == 0) {
/* 261 */           f9 -= (f6 - floatArray.get(m)) / 2.0F;
/* 262 */         }  if (m > 0)
/*     */         {
/* 264 */           f3 = (f3 = f3 + f5) + f10;
/*     */         }
/* 266 */         f10 = floatArray.get(m + 1);
/* 267 */         m += 2;
/*     */       } 
/*     */       
/* 270 */       if (f4 > 0.0F) f11 = f10 * f4;
/*     */ 
/*     */       
/* 273 */       float f11 = Math.max(f11, layout.getMinWidth());
/*     */       float f13;
/* 275 */       if (layout != null && (f13 = layout.getMaxWidth()) > 0.0F && f11 > f13) f11 = f13;
/*     */ 
/*     */       
/* 278 */       f13 = f3;
/* 279 */       if ((i & 0x10) != 0) {
/* 280 */         f13 += f10 - f11;
/* 281 */       } else if ((i & 0x8) == 0) {
/* 282 */         f13 += (f10 - f11) / 2.0F;
/*     */       } 
/* 284 */       f9 -= f12 + f2;
/* 285 */       if (bool) {
/* 286 */         actor.setBounds((float)Math.floor(f13), (float)Math.floor(f9), (float)Math.ceil(f11), (float)Math.ceil(f12));
/*     */       } else {
/* 288 */         actor.setBounds(f13, f9, f11, f12);
/*     */       } 
/* 290 */       if (layout != null) layout.validate(); 
/*     */     } 
/*     */   }
/*     */   
/*     */   public float getPrefWidth() {
/* 295 */     if (this.n) d(); 
/* 296 */     return this.k;
/*     */   }
/*     */   
/*     */   public float getPrefHeight() {
/* 300 */     if (this.t) return 0.0F; 
/* 301 */     if (this.n) d(); 
/* 302 */     return this.l;
/*     */   }
/*     */ 
/*     */   
/*     */   public int getColumns() {
/* 307 */     return this.t ? (this.o.size >> 1) : 1;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setRound(boolean paramBoolean) {
/* 312 */     this.s = paramBoolean;
/*     */   }
/*     */ 
/*     */   
/*     */   public VerticalGroup reverse() {
/* 317 */     this.r = true;
/* 318 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   public VerticalGroup reverse(boolean paramBoolean) {
/* 323 */     this.r = paramBoolean;
/* 324 */     return this;
/*     */   }
/*     */   
/*     */   public boolean getReverse() {
/* 328 */     return this.r;
/*     */   }
/*     */ 
/*     */   
/*     */   public VerticalGroup space(float paramFloat) {
/* 333 */     this.v = paramFloat;
/* 334 */     return this;
/*     */   }
/*     */   
/*     */   public float getSpace() {
/* 338 */     return this.v;
/*     */   }
/*     */ 
/*     */   
/*     */   public VerticalGroup wrapSpace(float paramFloat) {
/* 343 */     this.w = paramFloat;
/* 344 */     return this;
/*     */   }
/*     */   
/*     */   public float getWrapSpace() {
/* 348 */     return this.w;
/*     */   }
/*     */ 
/*     */   
/*     */   public VerticalGroup pad(float paramFloat) {
/* 353 */     this.y = paramFloat;
/* 354 */     this.z = paramFloat;
/* 355 */     this.A = paramFloat;
/* 356 */     this.B = paramFloat;
/* 357 */     return this;
/*     */   }
/*     */   
/*     */   public VerticalGroup pad(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4) {
/* 361 */     this.y = paramFloat1;
/* 362 */     this.z = paramFloat2;
/* 363 */     this.A = paramFloat3;
/* 364 */     this.B = paramFloat4;
/* 365 */     return this;
/*     */   }
/*     */   
/*     */   public VerticalGroup padTop(float paramFloat) {
/* 369 */     this.y = paramFloat;
/* 370 */     return this;
/*     */   }
/*     */   
/*     */   public VerticalGroup padLeft(float paramFloat) {
/* 374 */     this.z = paramFloat;
/* 375 */     return this;
/*     */   }
/*     */   
/*     */   public VerticalGroup padBottom(float paramFloat) {
/* 379 */     this.A = paramFloat;
/* 380 */     return this;
/*     */   }
/*     */   
/*     */   public VerticalGroup padRight(float paramFloat) {
/* 384 */     this.B = paramFloat;
/* 385 */     return this;
/*     */   }
/*     */   
/*     */   public float getPadTop() {
/* 389 */     return this.y;
/*     */   }
/*     */   
/*     */   public float getPadLeft() {
/* 393 */     return this.z;
/*     */   }
/*     */   
/*     */   public float getPadBottom() {
/* 397 */     return this.A;
/*     */   }
/*     */   
/*     */   public float getPadRight() {
/* 401 */     return this.B;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public VerticalGroup align(int paramInt) {
/* 407 */     this.p = paramInt;
/* 408 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   public VerticalGroup center() {
/* 413 */     this.p = 1;
/* 414 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   public VerticalGroup top() {
/* 419 */     this.p |= 0x2;
/* 420 */     this.p &= 0xFFFFFFFB;
/* 421 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   public VerticalGroup left() {
/* 426 */     this.p |= 0x8;
/* 427 */     this.p &= 0xFFFFFFEF;
/* 428 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   public VerticalGroup bottom() {
/* 433 */     this.p |= 0x4;
/* 434 */     this.p &= 0xFFFFFFFD;
/* 435 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   public VerticalGroup right() {
/* 440 */     this.p |= 0x10;
/* 441 */     this.p &= 0xFFFFFFF7;
/* 442 */     return this;
/*     */   }
/*     */   
/*     */   public int getAlign() {
/* 446 */     return this.p;
/*     */   }
/*     */   
/*     */   public VerticalGroup fill() {
/* 450 */     this.x = 1.0F;
/* 451 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   public VerticalGroup fill(float paramFloat) {
/* 456 */     this.x = paramFloat;
/* 457 */     return this;
/*     */   }
/*     */   
/*     */   public float getFill() {
/* 461 */     return this.x;
/*     */   }
/*     */   
/*     */   public VerticalGroup expand() {
/* 465 */     this.u = true;
/* 466 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   public VerticalGroup expand(boolean paramBoolean) {
/* 471 */     this.u = paramBoolean;
/* 472 */     return this;
/*     */   }
/*     */   
/*     */   public boolean getExpand() {
/* 476 */     return this.u;
/*     */   }
/*     */ 
/*     */   
/*     */   public VerticalGroup grow() {
/* 481 */     this.u = true;
/* 482 */     this.x = 1.0F;
/* 483 */     return this;
/*     */   }
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
/*     */   public VerticalGroup wrap() {
/* 497 */     this.t = true;
/* 498 */     return this;
/*     */   }
/*     */   
/*     */   public VerticalGroup wrap(boolean paramBoolean) {
/* 502 */     this.t = paramBoolean;
/* 503 */     return this;
/*     */   }
/*     */   
/*     */   public boolean getWrap() {
/* 507 */     return this.t;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public VerticalGroup columnAlign(int paramInt) {
/* 514 */     this.q = paramInt;
/* 515 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   public VerticalGroup columnCenter() {
/* 520 */     this.q = 1;
/* 521 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public VerticalGroup columnTop() {
/* 527 */     this.q |= 0x2;
/* 528 */     this.q &= 0xFFFFFFFB;
/* 529 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   public VerticalGroup columnLeft() {
/* 534 */     this.q |= 0x8;
/* 535 */     this.q &= 0xFFFFFFEF;
/* 536 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public VerticalGroup columnBottom() {
/* 542 */     this.q |= 0x4;
/* 543 */     this.q &= 0xFFFFFFFD;
/* 544 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   public VerticalGroup columnRight() {
/* 549 */     this.q |= 0x10;
/* 550 */     this.q &= 0xFFFFFFF7;
/* 551 */     return this;
/*     */   }
/*     */   
/*     */   protected final void a(ShapeRenderer paramShapeRenderer) {
/* 555 */     super.a(paramShapeRenderer);
/* 556 */     if (!getDebug())
/* 557 */       return;  paramShapeRenderer.set(ShapeRenderer.ShapeType.Line);
/* 558 */     if (getStage() != null) paramShapeRenderer.setColor(getStage().getDebugColor()); 
/* 559 */     paramShapeRenderer.rect(getX() + this.z, getY() + this.A, getOriginX(), getOriginY(), getWidth() - this.z - this.B, 
/* 560 */         getHeight() - this.A - this.y, getScaleX(), getScaleY(), getRotation());
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\scene2\\ui\VerticalGroup.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */