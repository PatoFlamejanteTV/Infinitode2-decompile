/*     */ package com.badlogic.gdx.scenes.scene2d.ui;
/*     */ 
/*     */ import com.badlogic.gdx.graphics.Color;
/*     */ import com.badlogic.gdx.graphics.g2d.Batch;
/*     */ import com.badlogic.gdx.math.Rectangle;
/*     */ import com.badlogic.gdx.math.Vector2;
/*     */ import com.badlogic.gdx.scenes.scene2d.Actor;
/*     */ import com.badlogic.gdx.scenes.scene2d.EventListener;
/*     */ import com.badlogic.gdx.scenes.scene2d.InputEvent;
/*     */ import com.badlogic.gdx.scenes.scene2d.InputListener;
/*     */ import com.badlogic.gdx.scenes.scene2d.Stage;
/*     */ import com.badlogic.gdx.scenes.scene2d.utils.Drawable;
/*     */ import com.badlogic.gdx.scenes.scene2d.utils.Layout;
/*     */ import com.badlogic.gdx.scenes.scene2d.utils.ScissorStack;
/*     */ import com.badlogic.gdx.utils.GdxRuntimeException;
/*     */ import com.badlogic.gdx.utils.Null;
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
/*     */   SplitPaneStyle style;
/*     */   @Null
/*     */   private Actor firstWidget;
/*     */   @Null
/*     */   private Actor secondWidget;
/*     */   boolean vertical;
/*  50 */   float splitAmount = 0.5F; float maxAmount = 1.0F;
/*     */   float minAmount;
/*  52 */   private final Rectangle firstWidgetBounds = new Rectangle();
/*  53 */   private final Rectangle secondWidgetBounds = new Rectangle();
/*  54 */   final Rectangle handleBounds = new Rectangle();
/*     */   boolean cursorOverHandle;
/*  56 */   private final Rectangle tempScissors = new Rectangle();
/*     */   
/*  58 */   Vector2 lastPoint = new Vector2();
/*  59 */   Vector2 handlePosition = new Vector2();
/*     */ 
/*     */ 
/*     */   
/*     */   public SplitPane(@Null Actor paramActor1, @Null Actor paramActor2, boolean paramBoolean, Skin paramSkin) {
/*  64 */     this(paramActor1, paramActor2, paramBoolean, paramSkin, "default-" + (paramBoolean ? "vertical" : "horizontal"));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public SplitPane(@Null Actor paramActor1, @Null Actor paramActor2, boolean paramBoolean, Skin paramSkin, String paramString) {
/*  70 */     this(paramActor1, paramActor2, paramBoolean, paramSkin.<SplitPaneStyle>get(paramString, SplitPaneStyle.class));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public SplitPane(@Null Actor paramActor1, @Null Actor paramActor2, boolean paramBoolean, SplitPaneStyle paramSplitPaneStyle) {
/*  76 */     this.vertical = paramBoolean;
/*  77 */     setStyle(paramSplitPaneStyle);
/*  78 */     setFirstWidget(paramActor1);
/*  79 */     setSecondWidget(paramActor2);
/*  80 */     setSize(getPrefWidth(), getPrefHeight());
/*  81 */     initialize();
/*     */   }
/*     */   
/*     */   private void initialize() {
/*  85 */     addListener((EventListener)new InputListener() {
/*  86 */           int draggingPointer = -1;
/*     */           
/*     */           public boolean touchDown(InputEvent param1InputEvent, float param1Float1, float param1Float2, int param1Int1, int param1Int2) {
/*  89 */             if (this.draggingPointer != -1) return false; 
/*  90 */             if (param1Int1 == 0 && param1Int2 != 0) return false; 
/*  91 */             if (SplitPane.this.handleBounds.contains(param1Float1, param1Float2)) {
/*  92 */               this.draggingPointer = param1Int1;
/*  93 */               SplitPane.this.lastPoint.set(param1Float1, param1Float2);
/*  94 */               SplitPane.this.handlePosition.set(SplitPane.this.handleBounds.x, SplitPane.this.handleBounds.y);
/*  95 */               return true;
/*     */             } 
/*  97 */             return false;
/*     */           }
/*     */           
/*     */           public void touchUp(InputEvent param1InputEvent, float param1Float1, float param1Float2, int param1Int1, int param1Int2) {
/* 101 */             if (param1Int1 == this.draggingPointer) this.draggingPointer = -1; 
/*     */           }
/*     */           public void touchDragged(InputEvent param1InputEvent, float param1Float1, float param1Float2, int param1Int) {
/*     */             float f;
/* 105 */             if (param1Int != this.draggingPointer)
/*     */               return; 
/* 107 */             Drawable drawable = SplitPane.this.style.handle;
/* 108 */             if (!SplitPane.this.vertical) {
/* 109 */               float f1 = param1Float1 - SplitPane.this.lastPoint.x;
/* 110 */               f = SplitPane.this.getWidth() - drawable.getMinWidth();
/* 111 */               f1 = SplitPane.this.handlePosition.x + f1;
/* 112 */               SplitPane.this.handlePosition.x = f1;
/* 113 */               f1 = Math.max(0.0F, f1);
/* 114 */               f1 = Math.min(f, f1);
/* 115 */               SplitPane.this.splitAmount = f1 / f;
/* 116 */               SplitPane.this.lastPoint.set(param1Float1, param1Float2);
/*     */             } else {
/* 118 */               float f1 = param1Float2 - SplitPane.this.lastPoint.y;
/* 119 */               f = SplitPane.this.getHeight() - f.getMinHeight();
/* 120 */               f1 = SplitPane.this.handlePosition.y + f1;
/* 121 */               SplitPane.this.handlePosition.y = f1;
/* 122 */               f1 = Math.max(0.0F, f1);
/* 123 */               f1 = Math.min(f, f1);
/* 124 */               SplitPane.this.splitAmount = 1.0F - f1 / f;
/* 125 */               SplitPane.this.lastPoint.set(param1Float1, param1Float2);
/*     */             } 
/* 127 */             SplitPane.this.invalidate();
/*     */           }
/*     */           
/*     */           public boolean mouseMoved(InputEvent param1InputEvent, float param1Float1, float param1Float2) {
/* 131 */             SplitPane.this.cursorOverHandle = SplitPane.this.handleBounds.contains(param1Float1, param1Float2);
/* 132 */             return false;
/*     */           }
/*     */         });
/*     */   }
/*     */   
/*     */   public void setStyle(SplitPaneStyle paramSplitPaneStyle) {
/* 138 */     this.style = paramSplitPaneStyle;
/* 139 */     invalidateHierarchy();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public SplitPaneStyle getStyle() {
/* 145 */     return this.style;
/*     */   }
/*     */   
/*     */   public void layout() {
/* 149 */     clampSplitAmount();
/* 150 */     if (!this.vertical) {
/* 151 */       calculateHorizBoundsAndPositions();
/*     */     } else {
/* 153 */       calculateVertBoundsAndPositions();
/*     */     } 
/*     */     Actor actor1;
/* 156 */     if ((actor1 = this.firstWidget) != null) {
/* 157 */       Rectangle rectangle = this.firstWidgetBounds;
/* 158 */       actor1.setBounds(rectangle.x, rectangle.y, rectangle.width, rectangle.height);
/* 159 */       if (actor1 instanceof Layout) ((Layout)actor1).validate(); 
/*     */     } 
/*     */     Actor actor2;
/* 162 */     if ((actor2 = this.secondWidget) != null) {
/* 163 */       Rectangle rectangle = this.secondWidgetBounds;
/* 164 */       actor2.setBounds(rectangle.x, rectangle.y, rectangle.width, rectangle.height);
/* 165 */       if (actor2 instanceof Layout) ((Layout)actor2).validate();
/*     */     
/*     */     } 
/*     */   }
/*     */   
/*     */   public float getPrefWidth() {
/* 171 */     float f1 = (this.firstWidget == null) ? 0.0F : ((this.firstWidget instanceof Layout) ? ((Layout)this.firstWidget).getPrefWidth() : this.firstWidget.getWidth());
/*     */     
/* 173 */     float f2 = (this.secondWidget == null) ? 0.0F : ((this.secondWidget instanceof Layout) ? ((Layout)this.secondWidget).getPrefWidth() : this.secondWidget.getWidth());
/* 174 */     if (this.vertical) return Math.max(f1, f2); 
/* 175 */     return f1 + this.style.handle.getMinWidth() + f2;
/*     */   }
/*     */ 
/*     */   
/*     */   public float getPrefHeight() {
/* 180 */     float f1 = (this.firstWidget == null) ? 0.0F : ((this.firstWidget instanceof Layout) ? ((Layout)this.firstWidget).getPrefHeight() : this.firstWidget.getHeight());
/*     */     
/* 182 */     float f2 = (this.secondWidget == null) ? 0.0F : ((this.secondWidget instanceof Layout) ? ((Layout)this.secondWidget).getPrefHeight() : this.secondWidget.getHeight());
/* 183 */     if (!this.vertical) return Math.max(f1, f2); 
/* 184 */     return f1 + this.style.handle.getMinHeight() + f2;
/*     */   }
/*     */   
/*     */   public float getMinWidth() {
/* 188 */     float f1 = (this.firstWidget instanceof Layout) ? ((Layout)this.firstWidget).getMinWidth() : 0.0F;
/* 189 */     float f2 = (this.secondWidget instanceof Layout) ? ((Layout)this.secondWidget).getMinWidth() : 0.0F;
/* 190 */     if (this.vertical) return Math.max(f1, f2); 
/* 191 */     return f1 + this.style.handle.getMinWidth() + f2;
/*     */   }
/*     */   
/*     */   public float getMinHeight() {
/* 195 */     float f1 = (this.firstWidget instanceof Layout) ? ((Layout)this.firstWidget).getMinHeight() : 0.0F;
/* 196 */     float f2 = (this.secondWidget instanceof Layout) ? ((Layout)this.secondWidget).getMinHeight() : 0.0F;
/* 197 */     if (!this.vertical) return Math.max(f1, f2); 
/* 198 */     return f1 + this.style.handle.getMinHeight() + f2;
/*     */   }
/*     */   
/*     */   public void setVertical(boolean paramBoolean) {
/* 202 */     if (this.vertical == paramBoolean)
/* 203 */       return;  this.vertical = paramBoolean;
/* 204 */     invalidateHierarchy();
/*     */   }
/*     */   
/*     */   public boolean isVertical() {
/* 208 */     return this.vertical;
/*     */   }
/*     */   
/*     */   private void calculateHorizBoundsAndPositions() {
/* 212 */     Drawable drawable = this.style.handle;
/*     */     
/* 214 */     float f2 = getHeight();
/*     */ 
/*     */     
/* 217 */     float f3, f4 = (int)((f3 = getWidth() - drawable.getMinWidth()) * this.splitAmount);
/* 218 */     f3 -= f4;
/* 219 */     float f1 = drawable.getMinWidth();
/*     */     
/* 221 */     this.firstWidgetBounds.set(0.0F, 0.0F, f4, f2);
/* 222 */     this.secondWidgetBounds.set(f4 + f1, 0.0F, f3, f2);
/* 223 */     this.handleBounds.set(f4, 0.0F, f1, f2);
/*     */   }
/*     */   
/*     */   private void calculateVertBoundsAndPositions() {
/* 227 */     Drawable drawable = this.style.handle;
/*     */     
/* 229 */     float f2 = getWidth();
/*     */ 
/*     */ 
/*     */     
/* 233 */     float f3, f4, f5 = (int)((f4 = (f3 = getHeight()) - drawable.getMinHeight()) * this.splitAmount);
/* 234 */     f4 -= f5;
/* 235 */     float f1 = drawable.getMinHeight();
/*     */     
/* 237 */     this.firstWidgetBounds.set(0.0F, f3 - f5, f2, f5);
/* 238 */     this.secondWidgetBounds.set(0.0F, 0.0F, f2, f4);
/* 239 */     this.handleBounds.set(0.0F, f4, f2, f1);
/*     */   }
/*     */   
/*     */   public void draw(Batch paramBatch, float paramFloat) {
/*     */     Stage stage;
/* 244 */     if ((stage = getStage()) == null)
/*     */       return; 
/* 246 */     validate();
/*     */     
/*     */     Color color;
/* 249 */     paramFloat = (color = getColor()).a * paramFloat;
/*     */     
/* 251 */     applyTransform(paramBatch, computeTransform());
/* 252 */     if (this.firstWidget != null && this.firstWidget.isVisible()) {
/* 253 */       paramBatch.flush();
/* 254 */       stage.calculateScissors(this.firstWidgetBounds, this.tempScissors);
/* 255 */       if (ScissorStack.pushScissors(this.tempScissors)) {
/* 256 */         this.firstWidget.draw(paramBatch, paramFloat);
/* 257 */         paramBatch.flush();
/* 258 */         ScissorStack.popScissors();
/*     */       } 
/*     */     } 
/* 261 */     if (this.secondWidget != null && this.secondWidget.isVisible()) {
/* 262 */       paramBatch.flush();
/* 263 */       stage.calculateScissors(this.secondWidgetBounds, this.tempScissors);
/* 264 */       if (ScissorStack.pushScissors(this.tempScissors)) {
/* 265 */         this.secondWidget.draw(paramBatch, paramFloat);
/* 266 */         paramBatch.flush();
/* 267 */         ScissorStack.popScissors();
/*     */       } 
/*     */     } 
/* 270 */     paramBatch.setColor(color.r, color.g, color.b, paramFloat);
/* 271 */     this.style.handle.draw(paramBatch, this.handleBounds.x, this.handleBounds.y, this.handleBounds.width, this.handleBounds.height);
/* 272 */     resetTransform(paramBatch);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setSplitAmount(float paramFloat) {
/* 278 */     this.splitAmount = paramFloat;
/* 279 */     invalidate();
/*     */   }
/*     */   
/*     */   public float getSplitAmount() {
/* 283 */     return this.splitAmount;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void clampSplitAmount() {
/* 290 */     float f1 = this.minAmount, f2 = this.maxAmount;
/*     */     
/* 292 */     if (this.vertical) {
/* 293 */       float f = getHeight() - this.style.handle.getMinHeight();
/* 294 */       if (this.firstWidget instanceof Layout) f1 = Math.max(f1, 
/* 295 */             Math.min(((Layout)this.firstWidget).getMinHeight() / f, 1.0F)); 
/* 296 */       if (this.secondWidget instanceof Layout) f2 = Math.min(f2, 1.0F - 
/* 297 */             Math.min(((Layout)this.secondWidget).getMinHeight() / f, 1.0F)); 
/*     */     } else {
/* 299 */       float f = getWidth() - this.style.handle.getMinWidth();
/* 300 */       if (this.firstWidget instanceof Layout)
/* 301 */         f1 = Math.max(f1, Math.min(((Layout)this.firstWidget).getMinWidth() / f, 1.0F)); 
/* 302 */       if (this.secondWidget instanceof Layout) f2 = Math.min(f2, 1.0F - 
/* 303 */             Math.min(((Layout)this.secondWidget).getMinWidth() / f, 1.0F));
/*     */     
/*     */     } 
/* 306 */     if (f1 > f2) {
/* 307 */       this.splitAmount = 0.5F * (f1 + f2); return;
/*     */     } 
/* 309 */     this.splitAmount = Math.max(Math.min(this.splitAmount, f2), f1);
/*     */   }
/*     */   
/*     */   public float getMinSplitAmount() {
/* 313 */     return this.minAmount;
/*     */   }
/*     */   
/*     */   public void setMinSplitAmount(float paramFloat) {
/* 317 */     if (paramFloat < 0.0F || paramFloat > 1.0F) throw new GdxRuntimeException("minAmount has to be >= 0 and <= 1"); 
/* 318 */     this.minAmount = paramFloat;
/*     */   }
/*     */   
/*     */   public float getMaxSplitAmount() {
/* 322 */     return this.maxAmount;
/*     */   }
/*     */   
/*     */   public void setMaxSplitAmount(float paramFloat) {
/* 326 */     if (paramFloat < 0.0F || paramFloat > 1.0F) throw new GdxRuntimeException("maxAmount has to be >= 0 and <= 1"); 
/* 327 */     this.maxAmount = paramFloat;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setFirstWidget(@Null Actor paramActor) {
/* 332 */     if (this.firstWidget != null) super.removeActor(this.firstWidget); 
/* 333 */     this.firstWidget = paramActor;
/* 334 */     if (paramActor != null) super.addActor(paramActor); 
/* 335 */     invalidate();
/*     */   }
/*     */ 
/*     */   
/*     */   public void setSecondWidget(@Null Actor paramActor) {
/* 340 */     if (this.secondWidget != null) super.removeActor(this.secondWidget); 
/* 341 */     this.secondWidget = paramActor;
/* 342 */     if (paramActor != null) super.addActor(paramActor); 
/* 343 */     invalidate();
/*     */   }
/*     */   
/*     */   public void addActor(Actor paramActor) {
/* 347 */     throw new UnsupportedOperationException("Use SplitPane#setWidget.");
/*     */   }
/*     */   
/*     */   public void addActorAt(int paramInt, Actor paramActor) {
/* 351 */     throw new UnsupportedOperationException("Use SplitPane#setWidget.");
/*     */   }
/*     */   
/*     */   public void addActorBefore(Actor paramActor1, Actor paramActor2) {
/* 355 */     throw new UnsupportedOperationException("Use SplitPane#setWidget.");
/*     */   }
/*     */   
/*     */   public boolean removeActor(Actor paramActor) {
/* 359 */     if (paramActor == null) throw new IllegalArgumentException("actor cannot be null."); 
/* 360 */     if (paramActor == this.firstWidget) {
/* 361 */       setFirstWidget((Actor)null);
/* 362 */       return true;
/*     */     } 
/* 364 */     if (paramActor == this.secondWidget) {
/* 365 */       setSecondWidget((Actor)null);
/* 366 */       return true;
/*     */     } 
/* 368 */     return true;
/*     */   }
/*     */   
/*     */   public boolean removeActor(Actor paramActor, boolean paramBoolean) {
/* 372 */     if (paramActor == null) throw new IllegalArgumentException("actor cannot be null."); 
/* 373 */     if (paramActor == this.firstWidget) {
/* 374 */       super.removeActor(paramActor, paramBoolean);
/* 375 */       this.firstWidget = null;
/* 376 */       invalidate();
/* 377 */       return true;
/*     */     } 
/* 379 */     if (paramActor == this.secondWidget) {
/* 380 */       super.removeActor(paramActor, paramBoolean);
/* 381 */       this.secondWidget = null;
/* 382 */       invalidate();
/* 383 */       return true;
/*     */     } 
/* 385 */     return false;
/*     */   }
/*     */   
/*     */   public Actor removeActorAt(int paramInt, boolean paramBoolean) {
/*     */     Actor actor;
/* 390 */     if ((actor = super.removeActorAt(paramInt, paramBoolean)) == this.firstWidget) {
/* 391 */       super.removeActor(actor, paramBoolean);
/* 392 */       this.firstWidget = null;
/* 393 */       invalidate();
/* 394 */     } else if (actor == this.secondWidget) {
/* 395 */       super.removeActor(actor, paramBoolean);
/* 396 */       this.secondWidget = null;
/* 397 */       invalidate();
/*     */     } 
/* 399 */     return actor;
/*     */   }
/*     */   
/*     */   public boolean isCursorOverHandle() {
/* 403 */     return this.cursorOverHandle;
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
/* 416 */       this.handle = param1Drawable;
/*     */     }
/*     */     
/*     */     public SplitPaneStyle(SplitPaneStyle param1SplitPaneStyle) {
/* 420 */       this.handle = param1SplitPaneStyle.handle;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gdx\scenes\scene2\\ui\SplitPane.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */