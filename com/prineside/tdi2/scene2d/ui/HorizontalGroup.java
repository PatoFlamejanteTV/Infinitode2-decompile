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
/*     */ public class HorizontalGroup
/*     */   extends WidgetGroup
/*     */ {
/*     */   private float k;
/*     */   private float l;
/*     */   private float m;
/*     */   private boolean n = true;
/*     */   private FloatArray o;
/*  45 */   private int p = 8; private int q; private boolean r; private boolean s = true; private boolean t;
/*     */   private boolean u;
/*     */   private boolean v;
/*     */   
/*     */   public HorizontalGroup() {
/*  50 */     setTouchable(Touchable.childrenOnly);
/*     */   }
/*     */   private float w; private float x; private float y; private float z; private float A; private float B; private float C;
/*     */   public void invalidate() {
/*  54 */     super.invalidate();
/*  55 */     this.n = true;
/*     */   }
/*     */   
/*     */   private void d() {
/*  59 */     this.n = false;
/*     */     SnapshotArray snapshotArray;
/*  61 */     int i = (snapshotArray = getChildren()).size;
/*  62 */     this.l = 0.0F;
/*  63 */     if (this.t) {
/*  64 */       this.k = 0.0F;
/*  65 */       if (this.o == null) {
/*  66 */         this.o = new FloatArray();
/*     */       } else {
/*  68 */         this.o.clear();
/*  69 */       }  FloatArray floatArray = this.o;
/*  70 */       float f1 = this.w, f2 = this.x;
/*  71 */       float f3 = this.A + this.C, f4 = getWidth() - f3, f5 = 0.0F, f6 = 0.0F, f7 = 0.0F;
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
/*     */           
/*  85 */           if ((f9 = (layout = (Layout)actor).getPrefWidth()) > f4) f9 = Math.max(f4, layout.getMinWidth()); 
/*  86 */           f8 = layout.getPrefHeight();
/*     */         } else {
/*  88 */           f9 = f8.getWidth();
/*  89 */           f8 = f8.getHeight();
/*     */         } 
/*     */         
/*  92 */         float f10 = f9 + ((f5 > 0.0F) ? f1 : 0.0F);
/*  93 */         if (f5 + f10 > f4 && f5 > 0.0F) {
/*  94 */           floatArray.add(f5);
/*  95 */           floatArray.add(f7);
/*  96 */           this.k = Math.max(this.k, f5 + f3);
/*  97 */           if (f6 > 0.0F) f6 += f2; 
/*  98 */           f6 += f7;
/*  99 */           f7 = 0.0F;
/* 100 */           f5 = 0.0F;
/* 101 */           f10 = f9;
/*     */         } 
/* 103 */         f5 += f10;
/* 104 */         f7 = Math.max(f7, f8);
/*     */       } 
/* 106 */       floatArray.add(f5);
/* 107 */       floatArray.add(f7);
/* 108 */       this.k = Math.max(this.k, f5 + f3);
/* 109 */       if (f6 > 0.0F) f6 += f2; 
/* 110 */       this.l = Math.max(this.l, f6 + f7);
/*     */     } else {
/* 112 */       this.k = this.A + this.C + this.w * (i - 1);
/* 113 */       for (byte b = 0; b < i; b++) {
/*     */         Actor actor;
/* 115 */         if (actor = (Actor)snapshotArray.get(b) instanceof Layout) {
/* 116 */           Layout layout = (Layout)actor;
/* 117 */           this.k += layout.getPrefWidth();
/* 118 */           this.l = Math.max(this.l, layout.getPrefHeight());
/*     */         } else {
/* 120 */           this.k += actor.getWidth();
/* 121 */           this.l = Math.max(this.l, actor.getHeight());
/*     */         } 
/*     */       } 
/*     */     } 
/* 125 */     this.l += this.z + this.B;
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
/* 142 */     float f1 = this.w, f2 = this.B, f3 = this.y;
/* 143 */     float f4 = (this.v ? getHeight() : this.l) - this.z - f2, f5 = this.A;
/*     */     
/* 145 */     if ((i & 0x10) != 0) {
/* 146 */       f5 += getWidth() - this.k;
/* 147 */     } else if ((i & 0x8) == 0) {
/* 148 */       f5 += (getWidth() - this.k) / 2.0F;
/*     */     } 
/*     */     
/* 151 */     if ((i & 0x4) != 0) {
/* 152 */       f2 = f2;
/* 153 */     } else if ((i & 0x2) != 0) {
/* 154 */       f2 = getHeight() - this.z - f4;
/*     */     } else {
/* 156 */       f2 += (getHeight() - f2 - this.z - f4) / 2.0F;
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
/* 168 */       float f6; Actor actor = (Actor)snapshotArray.get(j);
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
/* 181 */       if (f3 > 0.0F) f7 = f4 * f3;
/*     */ 
/*     */       
/* 184 */       float f7 = Math.max(f7, layout.getMinHeight());
/*     */       float f8;
/* 186 */       if (layout != null && (f8 = layout.getMaxHeight()) > 0.0F && f7 > f8) f7 = f8;
/*     */ 
/*     */       
/* 189 */       f8 = f2;
/* 190 */       if ((i & 0x2) != 0) {
/* 191 */         f8 += f4 - f7;
/* 192 */       } else if ((i & 0x4) == 0) {
/* 193 */         f8 += (f4 - f7) / 2.0F;
/*     */       } 
/* 195 */       if (bool) {
/* 196 */         actor.setBounds((float)Math.floor(f5), (float)Math.floor(f8), (float)Math.ceil(f6), (float)Math.ceil(f7));
/*     */       } else {
/* 198 */         actor.setBounds(f5, f8, f6, f7);
/* 199 */       }  f5 += f6 + f1;
/*     */       
/* 201 */       if (layout != null) layout.validate(); 
/*     */     } 
/*     */   }
/*     */   
/*     */   private void e() {
/*     */     float f1;
/* 207 */     if ((f1 = getPrefHeight()) != this.m) {
/* 208 */       this.m = f1;
/* 209 */       invalidateHierarchy();
/*     */     } 
/*     */     
/* 212 */     int i = this.p;
/* 213 */     boolean bool = this.s;
/* 214 */     float f2 = this.w, f3 = this.y, f4 = this.x;
/* 215 */     float f5 = this.k - this.A - this.C;
/* 216 */     float f6 = f1 - this.z, f7 = getWidth(), f8 = this.A, f9 = 0.0F, f10 = 0.0F, f11 = -1.0F;
/*     */     
/* 218 */     if ((i & 0x2) != 0) {
/* 219 */       f6 += getHeight() - f1;
/* 220 */     } else if ((i & 0x4) == 0) {
/* 221 */       f6 += (getHeight() - f1) / 2.0F;
/* 222 */     }  if (this.u) {
/* 223 */       f6 -= f1 + this.o.get(1);
/* 224 */       f11 = 1.0F;
/*     */     } 
/*     */     
/* 227 */     if ((i & 0x10) != 0) {
/* 228 */       f8 += f7 - this.k;
/* 229 */     } else if ((i & 0x8) == 0) {
/* 230 */       f8 += (f7 - this.k) / 2.0F;
/*     */     } 
/* 232 */     f7 -= this.C;
/* 233 */     i = this.q;
/*     */     
/* 235 */     FloatArray floatArray = this.o;
/* 236 */     SnapshotArray snapshotArray = getChildren();
/* 237 */     int j = 0, k = snapshotArray.size; byte b = 1;
/* 238 */     if (this.r) {
/* 239 */       j = k - 1;
/* 240 */       k = -1;
/* 241 */       b = -1;
/*     */     } 
/* 243 */     for (int m = 0; j != k; j += b) {
/* 244 */       float f12; Actor actor = (Actor)snapshotArray.get(j);
/*     */ 
/*     */       
/* 247 */       Layout layout = null;
/* 248 */       if (actor instanceof Layout) {
/*     */ 
/*     */         
/* 251 */         if ((f12 = (layout = (Layout)actor).getPrefWidth()) > f7) f12 = Math.max(f7, layout.getMinWidth()); 
/* 252 */         f13 = layout.getPrefHeight();
/*     */       } else {
/* 254 */         f12 = actor.getWidth();
/* 255 */         f13 = actor.getHeight();
/*     */       } 
/*     */       
/* 258 */       if (f9 + f12 > f7 || !m) {
/* 259 */         m = Math.min(m, floatArray.size - 2);
/* 260 */         f9 = f8;
/* 261 */         if ((i & 0x10) != 0) {
/* 262 */           f9 += f5 - floatArray.get(m);
/* 263 */         } else if ((i & 0x8) == 0) {
/* 264 */           f9 += (f5 - floatArray.get(m)) / 2.0F;
/* 265 */         }  f10 = floatArray.get(m + 1);
/* 266 */         if (m > 0) f6 += f4 * f11; 
/* 267 */         f6 += f10 * f11;
/* 268 */         m += 2;
/*     */       } 
/*     */       
/* 271 */       if (f3 > 0.0F) f13 = f10 * f3;
/*     */ 
/*     */       
/* 274 */       float f13 = Math.max(f13, layout.getMinHeight());
/*     */       float f14;
/* 276 */       if (layout != null && (f14 = layout.getMaxHeight()) > 0.0F && f13 > f14) f13 = f14;
/*     */ 
/*     */       
/* 279 */       f14 = f6;
/* 280 */       if ((i & 0x2) != 0) {
/* 281 */         f14 += f10 - f13;
/* 282 */       } else if ((i & 0x4) == 0) {
/* 283 */         f14 += (f10 - f13) / 2.0F;
/*     */       } 
/* 285 */       if (bool) {
/* 286 */         actor.setBounds((float)Math.floor(f9), (float)Math.floor(f14), (float)Math.ceil(f12), (float)Math.ceil(f13));
/*     */       } else {
/* 288 */         actor.setBounds(f9, f14, f12, f13);
/* 289 */       }  f9 += f12 + f2;
/*     */       
/* 291 */       if (layout != null) layout.validate(); 
/*     */     } 
/*     */   }
/*     */   
/*     */   public float getPrefWidth() {
/* 296 */     if (this.t) return 0.0F; 
/* 297 */     if (this.n) d(); 
/* 298 */     return this.k;
/*     */   }
/*     */   
/*     */   public float getPrefHeight() {
/* 302 */     if (this.n) d(); 
/* 303 */     return this.l;
/*     */   }
/*     */ 
/*     */   
/*     */   public int getRows() {
/* 308 */     return this.t ? (this.o.size >> 1) : 1;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setRound(boolean paramBoolean) {
/* 313 */     this.s = paramBoolean;
/*     */   }
/*     */ 
/*     */   
/*     */   public HorizontalGroup reverse() {
/* 318 */     this.r = true;
/* 319 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   public HorizontalGroup reverse(boolean paramBoolean) {
/* 324 */     this.r = paramBoolean;
/* 325 */     return this;
/*     */   }
/*     */   
/*     */   public boolean getReverse() {
/* 329 */     return this.r;
/*     */   }
/*     */ 
/*     */   
/*     */   public HorizontalGroup wrapReverse() {
/* 334 */     this.u = true;
/* 335 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   public HorizontalGroup wrapReverse(boolean paramBoolean) {
/* 340 */     this.u = paramBoolean;
/* 341 */     return this;
/*     */   }
/*     */   
/*     */   public boolean getWrapReverse() {
/* 345 */     return this.u;
/*     */   }
/*     */ 
/*     */   
/*     */   public HorizontalGroup space(float paramFloat) {
/* 350 */     this.w = paramFloat;
/* 351 */     return this;
/*     */   }
/*     */   
/*     */   public float getSpace() {
/* 355 */     return this.w;
/*     */   }
/*     */ 
/*     */   
/*     */   public HorizontalGroup wrapSpace(float paramFloat) {
/* 360 */     this.x = paramFloat;
/* 361 */     return this;
/*     */   }
/*     */   
/*     */   public float getWrapSpace() {
/* 365 */     return this.x;
/*     */   }
/*     */ 
/*     */   
/*     */   public HorizontalGroup pad(float paramFloat) {
/* 370 */     this.z = paramFloat;
/* 371 */     this.A = paramFloat;
/* 372 */     this.B = paramFloat;
/* 373 */     this.C = paramFloat;
/* 374 */     return this;
/*     */   }
/*     */   
/*     */   public HorizontalGroup pad(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4) {
/* 378 */     this.z = paramFloat1;
/* 379 */     this.A = paramFloat2;
/* 380 */     this.B = paramFloat3;
/* 381 */     this.C = paramFloat4;
/* 382 */     return this;
/*     */   }
/*     */   
/*     */   public HorizontalGroup padTop(float paramFloat) {
/* 386 */     this.z = paramFloat;
/* 387 */     return this;
/*     */   }
/*     */   
/*     */   public HorizontalGroup padLeft(float paramFloat) {
/* 391 */     this.A = paramFloat;
/* 392 */     return this;
/*     */   }
/*     */   
/*     */   public HorizontalGroup padBottom(float paramFloat) {
/* 396 */     this.B = paramFloat;
/* 397 */     return this;
/*     */   }
/*     */   
/*     */   public HorizontalGroup padRight(float paramFloat) {
/* 401 */     this.C = paramFloat;
/* 402 */     return this;
/*     */   }
/*     */   
/*     */   public float getPadTop() {
/* 406 */     return this.z;
/*     */   }
/*     */   
/*     */   public float getPadLeft() {
/* 410 */     return this.A;
/*     */   }
/*     */   
/*     */   public float getPadBottom() {
/* 414 */     return this.B;
/*     */   }
/*     */   
/*     */   public float getPadRight() {
/* 418 */     return this.C;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public HorizontalGroup align(int paramInt) {
/* 424 */     this.p = paramInt;
/* 425 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   public HorizontalGroup center() {
/* 430 */     this.p = 1;
/* 431 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   public HorizontalGroup top() {
/* 436 */     this.p |= 0x2;
/* 437 */     this.p &= 0xFFFFFFFB;
/* 438 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   public HorizontalGroup left() {
/* 443 */     this.p |= 0x8;
/* 444 */     this.p &= 0xFFFFFFEF;
/* 445 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   public HorizontalGroup bottom() {
/* 450 */     this.p |= 0x4;
/* 451 */     this.p &= 0xFFFFFFFD;
/* 452 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   public HorizontalGroup right() {
/* 457 */     this.p |= 0x10;
/* 458 */     this.p &= 0xFFFFFFF7;
/* 459 */     return this;
/*     */   }
/*     */   
/*     */   public int getAlign() {
/* 463 */     return this.p;
/*     */   }
/*     */   
/*     */   public HorizontalGroup fill() {
/* 467 */     this.y = 1.0F;
/* 468 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   public HorizontalGroup fill(float paramFloat) {
/* 473 */     this.y = paramFloat;
/* 474 */     return this;
/*     */   }
/*     */   
/*     */   public float getFill() {
/* 478 */     return this.y;
/*     */   }
/*     */   
/*     */   public HorizontalGroup expand() {
/* 482 */     this.v = true;
/* 483 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   public HorizontalGroup expand(boolean paramBoolean) {
/* 488 */     this.v = paramBoolean;
/* 489 */     return this;
/*     */   }
/*     */   
/*     */   public boolean getExpand() {
/* 493 */     return this.v;
/*     */   }
/*     */ 
/*     */   
/*     */   public HorizontalGroup grow() {
/* 498 */     this.v = true;
/* 499 */     this.y = 1.0F;
/* 500 */     return this;
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
/*     */   public HorizontalGroup wrap() {
/* 514 */     this.t = true;
/* 515 */     return this;
/*     */   }
/*     */   
/*     */   public HorizontalGroup wrap(boolean paramBoolean) {
/* 519 */     this.t = paramBoolean;
/* 520 */     return this;
/*     */   }
/*     */   
/*     */   public boolean getWrap() {
/* 524 */     return this.t;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public HorizontalGroup rowAlign(int paramInt) {
/* 531 */     this.q = paramInt;
/* 532 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   public HorizontalGroup rowCenter() {
/* 537 */     this.q = 1;
/* 538 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   public HorizontalGroup rowTop() {
/* 543 */     this.q |= 0x2;
/* 544 */     this.q &= 0xFFFFFFFB;
/* 545 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public HorizontalGroup rowLeft() {
/* 551 */     this.q |= 0x8;
/* 552 */     this.q &= 0xFFFFFFEF;
/* 553 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   public HorizontalGroup rowBottom() {
/* 558 */     this.q |= 0x4;
/* 559 */     this.q &= 0xFFFFFFFD;
/* 560 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public HorizontalGroup rowRight() {
/* 566 */     this.q |= 0x10;
/* 567 */     this.q &= 0xFFFFFFF7;
/* 568 */     return this;
/*     */   }
/*     */   
/*     */   protected final void a(ShapeRenderer paramShapeRenderer) {
/* 572 */     super.a(paramShapeRenderer);
/* 573 */     if (!getDebug())
/* 574 */       return;  paramShapeRenderer.set(ShapeRenderer.ShapeType.Line);
/* 575 */     if (getStage() != null) paramShapeRenderer.setColor(getStage().getDebugColor()); 
/* 576 */     paramShapeRenderer.rect(getX() + this.A, getY() + this.B, getOriginX(), getOriginY(), getWidth() - this.A - this.C, 
/* 577 */         getHeight() - this.B - this.z, getScaleX(), getScaleY(), getRotation());
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\scene2\\ui\HorizontalGroup.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */