/*     */ package com.badlogic.gdx.scenes.scene2d.ui;
/*     */ 
/*     */ import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
/*     */ import com.badlogic.gdx.scenes.scene2d.Actor;
/*     */ import com.badlogic.gdx.scenes.scene2d.Touchable;
/*     */ import com.badlogic.gdx.scenes.scene2d.utils.Layout;
/*     */ import com.badlogic.gdx.utils.FloatArray;
/*     */ import com.badlogic.gdx.utils.SnapshotArray;
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
/*     */   private float prefWidth;
/*     */   private float prefHeight;
/*     */   private float lastPrefWidth;
/*     */   private boolean sizeInvalid = true;
/*     */   private FloatArray columnSizes;
/*  45 */   private int align = 2; private int columnAlign; private boolean reverse; private boolean round = true; private boolean wrap;
/*     */   private boolean expand;
/*     */   private float space;
/*     */   
/*     */   public VerticalGroup() {
/*  50 */     setTouchable(Touchable.childrenOnly);
/*     */   }
/*     */   private float wrapSpace; private float fill; private float padTop; private float padLeft; private float padBottom; private float padRight;
/*     */   public void invalidate() {
/*  54 */     super.invalidate();
/*  55 */     this.sizeInvalid = true;
/*     */   }
/*     */   
/*     */   private void computeSize() {
/*  59 */     this.sizeInvalid = false;
/*     */     SnapshotArray snapshotArray;
/*  61 */     int i = (snapshotArray = getChildren()).size;
/*  62 */     this.prefWidth = 0.0F;
/*  63 */     if (this.wrap) {
/*  64 */       this.prefHeight = 0.0F;
/*  65 */       if (this.columnSizes == null) {
/*  66 */         this.columnSizes = new FloatArray();
/*     */       } else {
/*  68 */         this.columnSizes.clear();
/*  69 */       }  FloatArray floatArray = this.columnSizes;
/*  70 */       float f1 = this.space, f2 = this.wrapSpace;
/*  71 */       float f3 = this.padTop + this.padBottom, f4 = getHeight() - f3, f5 = 0.0F, f6 = 0.0F, f7 = 0.0F;
/*  72 */       int j = 0; byte b = 1;
/*  73 */       if (this.reverse) {
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
/*  96 */           this.prefHeight = Math.max(this.prefHeight, f6 + f3);
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
/* 108 */       this.prefHeight = Math.max(this.prefHeight, f6 + f3);
/* 109 */       if (f5 > 0.0F) f5 += f2; 
/* 110 */       this.prefWidth = Math.max(this.prefWidth, f5 + f7);
/*     */     } else {
/* 112 */       this.prefHeight = this.padTop + this.padBottom + this.space * (i - 1);
/* 113 */       for (byte b = 0; b < i; b++) {
/*     */         Actor actor;
/* 115 */         if (actor = (Actor)snapshotArray.get(b) instanceof Layout) {
/* 116 */           Layout layout = (Layout)actor;
/* 117 */           this.prefWidth = Math.max(this.prefWidth, layout.getPrefWidth());
/* 118 */           this.prefHeight += layout.getPrefHeight();
/*     */         } else {
/* 120 */           this.prefWidth = Math.max(this.prefWidth, actor.getWidth());
/* 121 */           this.prefHeight += actor.getHeight();
/*     */         } 
/*     */       } 
/*     */     } 
/* 125 */     this.prefWidth += this.padLeft + this.padRight;
/* 126 */     if (this.round) {
/* 127 */       this.prefWidth = (float)Math.ceil(this.prefWidth);
/* 128 */       this.prefHeight = (float)Math.ceil(this.prefHeight);
/*     */     } 
/*     */   }
/*     */   
/*     */   public void layout() {
/* 133 */     if (this.sizeInvalid) computeSize();
/*     */     
/* 135 */     if (this.wrap) {
/* 136 */       layoutWrapped();
/*     */       
/*     */       return;
/*     */     } 
/* 140 */     boolean bool = this.round;
/* 141 */     int i = this.align;
/* 142 */     float f1 = this.space, f2 = this.padLeft, f3 = this.fill;
/* 143 */     float f4 = (this.expand ? getWidth() : this.prefWidth) - f2 - this.padRight, f5 = this.prefHeight - this.padTop + f1;
/*     */     
/* 145 */     if ((i & 0x2) != 0) {
/* 146 */       f5 += getHeight() - this.prefHeight;
/* 147 */     } else if ((i & 0x4) == 0) {
/* 148 */       f5 += (getHeight() - this.prefHeight) / 2.0F;
/*     */     } 
/*     */     
/* 151 */     if ((i & 0x8) != 0) {
/* 152 */       f2 = f2;
/* 153 */     } else if ((i & 0x10) != 0) {
/* 154 */       f2 = getWidth() - this.padRight - f4;
/*     */     } else {
/* 156 */       f2 += (getWidth() - f2 - this.padRight - f4) / 2.0F;
/*     */     } 
/* 158 */     i = this.columnAlign;
/*     */     
/* 160 */     SnapshotArray snapshotArray = getChildren();
/* 161 */     int j = 0, k = snapshotArray.size; byte b = 1;
/* 162 */     if (this.reverse) {
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
/*     */   private void layoutWrapped() {
/*     */     float f1;
/* 207 */     if ((f1 = getPrefWidth()) != this.lastPrefWidth) {
/* 208 */       this.lastPrefWidth = f1;
/* 209 */       invalidateHierarchy();
/*     */     } 
/*     */     
/* 212 */     int i = this.align;
/* 213 */     boolean bool = this.round;
/* 214 */     float f2 = this.space, f3 = this.padLeft, f4 = this.fill, f5 = this.wrapSpace;
/* 215 */     float f6 = this.prefHeight - this.padTop - this.padBottom;
/* 216 */     float f7 = f3, f8 = getHeight();
/* 217 */     float f9 = this.prefHeight - this.padTop + f2, f10 = 0.0F, f11 = 0.0F;
/*     */     
/* 219 */     if ((i & 0x10) != 0) {
/* 220 */       f7 = f3 + getWidth() - f1;
/* 221 */     } else if ((i & 0x8) == 0) {
/* 222 */       f7 = f3 + (getWidth() - f1) / 2.0F;
/*     */     } 
/* 224 */     if ((i & 0x2) != 0) {
/* 225 */       f9 += f8 - this.prefHeight;
/* 226 */     } else if ((i & 0x4) == 0) {
/* 227 */       f9 += (f8 - this.prefHeight) / 2.0F;
/*     */     } 
/* 229 */     f8 -= this.padTop;
/* 230 */     i = this.columnAlign;
/*     */     
/* 232 */     FloatArray floatArray = this.columnSizes;
/* 233 */     SnapshotArray snapshotArray = getChildren();
/* 234 */     int j = 0, k = snapshotArray.size; byte b = 1;
/* 235 */     if (this.reverse) {
/* 236 */       j = k - 1;
/* 237 */       k = -1;
/* 238 */       b = -1;
/*     */     } 
/* 240 */     for (int m = 0; j != k; j += b) {
/* 241 */       float f13; Actor actor = (Actor)snapshotArray.get(j);
/*     */ 
/*     */       
/* 244 */       Layout layout = null;
/* 245 */       if (actor instanceof Layout) {
/*     */         
/* 247 */         f12 = (layout = (Layout)actor).getPrefWidth();
/*     */         
/* 249 */         if ((f13 = layout.getPrefHeight()) > f8) f13 = Math.max(f8, layout.getMinHeight()); 
/*     */       } else {
/* 251 */         f12 = actor.getWidth();
/* 252 */         f13 = actor.getHeight();
/*     */       } 
/*     */       
/* 255 */       if (f10 - f13 - f2 < this.padBottom || !m) {
/* 256 */         m = Math.min(m, floatArray.size - 2);
/* 257 */         f10 = f9;
/* 258 */         if ((i & 0x4) != 0) {
/* 259 */           f10 -= f6 - floatArray.get(m);
/* 260 */         } else if ((i & 0x2) == 0) {
/* 261 */           f10 -= (f6 - floatArray.get(m)) / 2.0F;
/* 262 */         }  if (m > 0)
/*     */         {
/* 264 */           f7 = (f7 = f7 + f5) + f11;
/*     */         }
/* 266 */         f11 = floatArray.get(m + 1);
/* 267 */         m += 2;
/*     */       } 
/*     */       
/* 270 */       if (f4 > 0.0F) f12 = f11 * f4;
/*     */ 
/*     */       
/* 273 */       float f12 = Math.max(f12, layout.getMinWidth());
/*     */       float f14;
/* 275 */       if (layout != null && (f14 = layout.getMaxWidth()) > 0.0F && f12 > f14) f12 = f14;
/*     */ 
/*     */       
/* 278 */       f14 = f7;
/* 279 */       if ((i & 0x10) != 0) {
/* 280 */         f14 += f11 - f12;
/* 281 */       } else if ((i & 0x8) == 0) {
/* 282 */         f14 += (f11 - f12) / 2.0F;
/*     */       } 
/* 284 */       f10 -= f13 + f2;
/* 285 */       if (bool) {
/* 286 */         actor.setBounds((float)Math.floor(f14), (float)Math.floor(f10), (float)Math.ceil(f12), (float)Math.ceil(f13));
/*     */       } else {
/* 288 */         actor.setBounds(f14, f10, f12, f13);
/*     */       } 
/* 290 */       if (layout != null) layout.validate(); 
/*     */     } 
/*     */   }
/*     */   
/*     */   public float getPrefWidth() {
/* 295 */     if (this.sizeInvalid) computeSize(); 
/* 296 */     return this.prefWidth;
/*     */   }
/*     */   
/*     */   public float getPrefHeight() {
/* 300 */     if (this.wrap) return 0.0F; 
/* 301 */     if (this.sizeInvalid) computeSize(); 
/* 302 */     return this.prefHeight;
/*     */   }
/*     */ 
/*     */   
/*     */   public int getColumns() {
/* 307 */     return this.wrap ? (this.columnSizes.size >> 1) : 1;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setRound(boolean paramBoolean) {
/* 312 */     this.round = paramBoolean;
/*     */   }
/*     */ 
/*     */   
/*     */   public VerticalGroup reverse() {
/* 317 */     this.reverse = true;
/* 318 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   public VerticalGroup reverse(boolean paramBoolean) {
/* 323 */     this.reverse = paramBoolean;
/* 324 */     return this;
/*     */   }
/*     */   
/*     */   public boolean getReverse() {
/* 328 */     return this.reverse;
/*     */   }
/*     */ 
/*     */   
/*     */   public VerticalGroup space(float paramFloat) {
/* 333 */     this.space = paramFloat;
/* 334 */     return this;
/*     */   }
/*     */   
/*     */   public float getSpace() {
/* 338 */     return this.space;
/*     */   }
/*     */ 
/*     */   
/*     */   public VerticalGroup wrapSpace(float paramFloat) {
/* 343 */     this.wrapSpace = paramFloat;
/* 344 */     return this;
/*     */   }
/*     */   
/*     */   public float getWrapSpace() {
/* 348 */     return this.wrapSpace;
/*     */   }
/*     */ 
/*     */   
/*     */   public VerticalGroup pad(float paramFloat) {
/* 353 */     this.padTop = paramFloat;
/* 354 */     this.padLeft = paramFloat;
/* 355 */     this.padBottom = paramFloat;
/* 356 */     this.padRight = paramFloat;
/* 357 */     return this;
/*     */   }
/*     */   
/*     */   public VerticalGroup pad(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4) {
/* 361 */     this.padTop = paramFloat1;
/* 362 */     this.padLeft = paramFloat2;
/* 363 */     this.padBottom = paramFloat3;
/* 364 */     this.padRight = paramFloat4;
/* 365 */     return this;
/*     */   }
/*     */   
/*     */   public VerticalGroup padTop(float paramFloat) {
/* 369 */     this.padTop = paramFloat;
/* 370 */     return this;
/*     */   }
/*     */   
/*     */   public VerticalGroup padLeft(float paramFloat) {
/* 374 */     this.padLeft = paramFloat;
/* 375 */     return this;
/*     */   }
/*     */   
/*     */   public VerticalGroup padBottom(float paramFloat) {
/* 379 */     this.padBottom = paramFloat;
/* 380 */     return this;
/*     */   }
/*     */   
/*     */   public VerticalGroup padRight(float paramFloat) {
/* 384 */     this.padRight = paramFloat;
/* 385 */     return this;
/*     */   }
/*     */   
/*     */   public float getPadTop() {
/* 389 */     return this.padTop;
/*     */   }
/*     */   
/*     */   public float getPadLeft() {
/* 393 */     return this.padLeft;
/*     */   }
/*     */   
/*     */   public float getPadBottom() {
/* 397 */     return this.padBottom;
/*     */   }
/*     */   
/*     */   public float getPadRight() {
/* 401 */     return this.padRight;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public VerticalGroup align(int paramInt) {
/* 407 */     this.align = paramInt;
/* 408 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   public VerticalGroup center() {
/* 413 */     this.align = 1;
/* 414 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   public VerticalGroup top() {
/* 419 */     this.align |= 0x2;
/* 420 */     this.align &= 0xFFFFFFFB;
/* 421 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   public VerticalGroup left() {
/* 426 */     this.align |= 0x8;
/* 427 */     this.align &= 0xFFFFFFEF;
/* 428 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   public VerticalGroup bottom() {
/* 433 */     this.align |= 0x4;
/* 434 */     this.align &= 0xFFFFFFFD;
/* 435 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   public VerticalGroup right() {
/* 440 */     this.align |= 0x10;
/* 441 */     this.align &= 0xFFFFFFF7;
/* 442 */     return this;
/*     */   }
/*     */   
/*     */   public int getAlign() {
/* 446 */     return this.align;
/*     */   }
/*     */   
/*     */   public VerticalGroup fill() {
/* 450 */     this.fill = 1.0F;
/* 451 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   public VerticalGroup fill(float paramFloat) {
/* 456 */     this.fill = paramFloat;
/* 457 */     return this;
/*     */   }
/*     */   
/*     */   public float getFill() {
/* 461 */     return this.fill;
/*     */   }
/*     */   
/*     */   public VerticalGroup expand() {
/* 465 */     this.expand = true;
/* 466 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   public VerticalGroup expand(boolean paramBoolean) {
/* 471 */     this.expand = paramBoolean;
/* 472 */     return this;
/*     */   }
/*     */   
/*     */   public boolean getExpand() {
/* 476 */     return this.expand;
/*     */   }
/*     */ 
/*     */   
/*     */   public VerticalGroup grow() {
/* 481 */     this.expand = true;
/* 482 */     this.fill = 1.0F;
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
/* 497 */     this.wrap = true;
/* 498 */     return this;
/*     */   }
/*     */   
/*     */   public VerticalGroup wrap(boolean paramBoolean) {
/* 502 */     this.wrap = paramBoolean;
/* 503 */     return this;
/*     */   }
/*     */   
/*     */   public boolean getWrap() {
/* 507 */     return this.wrap;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public VerticalGroup columnAlign(int paramInt) {
/* 514 */     this.columnAlign = paramInt;
/* 515 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   public VerticalGroup columnCenter() {
/* 520 */     this.columnAlign = 1;
/* 521 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public VerticalGroup columnTop() {
/* 527 */     this.columnAlign |= 0x2;
/* 528 */     this.columnAlign &= 0xFFFFFFFB;
/* 529 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   public VerticalGroup columnLeft() {
/* 534 */     this.columnAlign |= 0x8;
/* 535 */     this.columnAlign &= 0xFFFFFFEF;
/* 536 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public VerticalGroup columnBottom() {
/* 542 */     this.columnAlign |= 0x4;
/* 543 */     this.columnAlign &= 0xFFFFFFFD;
/* 544 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   public VerticalGroup columnRight() {
/* 549 */     this.columnAlign |= 0x10;
/* 550 */     this.columnAlign &= 0xFFFFFFF7;
/* 551 */     return this;
/*     */   }
/*     */   
/*     */   protected void drawDebugBounds(ShapeRenderer paramShapeRenderer) {
/* 555 */     super.drawDebugBounds(paramShapeRenderer);
/* 556 */     if (!getDebug())
/* 557 */       return;  paramShapeRenderer.set(ShapeRenderer.ShapeType.Line);
/* 558 */     if (getStage() != null) paramShapeRenderer.setColor(getStage().getDebugColor()); 
/* 559 */     paramShapeRenderer.rect(getX() + this.padLeft, getY() + this.padBottom, getOriginX(), getOriginY(), getWidth() - this.padLeft - this.padRight, 
/* 560 */         getHeight() - this.padBottom - this.padTop, getScaleX(), getScaleY(), getRotation());
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gdx\scenes\scene2\\ui\VerticalGroup.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */