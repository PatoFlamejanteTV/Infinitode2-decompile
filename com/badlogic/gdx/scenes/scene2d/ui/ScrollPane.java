/*      */ package com.badlogic.gdx.scenes.scene2d.ui;
/*      */ 
/*      */ import com.badlogic.gdx.Gdx;
/*      */ import com.badlogic.gdx.graphics.Color;
/*      */ import com.badlogic.gdx.graphics.g2d.Batch;
/*      */ import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
/*      */ import com.badlogic.gdx.math.Interpolation;
/*      */ import com.badlogic.gdx.math.MathUtils;
/*      */ import com.badlogic.gdx.math.Rectangle;
/*      */ import com.badlogic.gdx.math.Vector2;
/*      */ import com.badlogic.gdx.scenes.scene2d.Actor;
/*      */ import com.badlogic.gdx.scenes.scene2d.Event;
/*      */ import com.badlogic.gdx.scenes.scene2d.EventListener;
/*      */ import com.badlogic.gdx.scenes.scene2d.InputEvent;
/*      */ import com.badlogic.gdx.scenes.scene2d.InputListener;
/*      */ import com.badlogic.gdx.scenes.scene2d.Stage;
/*      */ import com.badlogic.gdx.scenes.scene2d.Touchable;
/*      */ import com.badlogic.gdx.scenes.scene2d.utils.ActorGestureListener;
/*      */ import com.badlogic.gdx.scenes.scene2d.utils.Cullable;
/*      */ import com.badlogic.gdx.scenes.scene2d.utils.Drawable;
/*      */ import com.badlogic.gdx.scenes.scene2d.utils.Layout;
/*      */ import com.badlogic.gdx.utils.Null;
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
/*      */   private ScrollPaneStyle style;
/*      */   private Actor actor;
/*   52 */   final Rectangle actorArea = new Rectangle();
/*   53 */   final Rectangle hScrollBounds = new Rectangle(), hKnobBounds = new Rectangle();
/*   54 */   final Rectangle vScrollBounds = new Rectangle(); final Rectangle vKnobBounds = new Rectangle(); private ActorGestureListener flickScrollListener; boolean scrollX; boolean scrollY; boolean vScrollOnRight = true; boolean hScrollOnBottom = true; float amountX; float amountY;
/*   55 */   private final Rectangle actorCullingArea = new Rectangle();
/*      */   
/*      */   float visualAmountX;
/*      */   
/*      */   float visualAmountY;
/*      */   float maxX;
/*      */   float maxY;
/*      */   boolean touchScrollH;
/*      */   boolean touchScrollV;
/*   64 */   final Vector2 lastPoint = new Vector2(); boolean fadeScrollBars = true; boolean smoothScrolling = true; boolean scrollBarTouch = true;
/*      */   float fadeAlpha;
/*   66 */   float fadeAlphaSeconds = 1.0F; float fadeDelay; float fadeDelaySeconds = 1.0F;
/*      */   
/*      */   boolean cancelTouchFocus = true;
/*      */   boolean flickScroll = true;
/*   70 */   float flingTime = 1.0F; float flingTimer; float velocityX; float velocityY; private boolean overscrollX = true;
/*      */   private boolean overscrollY = true;
/*   72 */   private float overscrollDistance = 50.0F; private float overscrollSpeedMin = 30.0F; private float overscrollSpeedMax = 200.0F; private boolean forceScrollX; private boolean forceScrollY;
/*      */   boolean disableX;
/*      */   boolean disableY;
/*      */   private boolean clamp = true;
/*      */   private boolean scrollbarsOnTop;
/*      */   private boolean variableSizeKnobs = true;
/*   78 */   int draggingPointer = -1;
/*      */ 
/*      */   
/*      */   public ScrollPane(@Null Actor paramActor) {
/*   82 */     this(paramActor, new ScrollPaneStyle());
/*      */   }
/*      */ 
/*      */   
/*      */   public ScrollPane(@Null Actor paramActor, Skin paramSkin) {
/*   87 */     this(paramActor, paramSkin.<ScrollPaneStyle>get(ScrollPaneStyle.class));
/*      */   }
/*      */ 
/*      */   
/*      */   public ScrollPane(@Null Actor paramActor, Skin paramSkin, String paramString) {
/*   92 */     this(paramActor, paramSkin.<ScrollPaneStyle>get(paramString, ScrollPaneStyle.class));
/*      */   }
/*      */ 
/*      */   
/*      */   public ScrollPane(@Null Actor paramActor, ScrollPaneStyle paramScrollPaneStyle) {
/*   97 */     if (paramScrollPaneStyle == null) throw new IllegalArgumentException("style cannot be null."); 
/*   98 */     this.style = paramScrollPaneStyle;
/*   99 */     setActor(paramActor);
/*  100 */     setSize(150.0F, 150.0F);
/*      */     
/*  102 */     addCaptureListener();
/*  103 */     this.flickScrollListener = getFlickScrollListener();
/*  104 */     addListener((EventListener)this.flickScrollListener);
/*  105 */     addScrollListener();
/*      */   }
/*      */   
/*      */   protected void addCaptureListener() {
/*  109 */     addCaptureListener((EventListener)new InputListener() {
/*      */           private float handlePosition;
/*      */           
/*      */           public boolean touchDown(InputEvent param1InputEvent, float param1Float1, float param1Float2, int param1Int1, int param1Int2) {
/*  113 */             if (ScrollPane.this.draggingPointer != -1) return false; 
/*  114 */             if (param1Int1 == 0 && param1Int2 != 0) return false; 
/*  115 */             if (ScrollPane.this.getStage() != null) ScrollPane.this.getStage().setScrollFocus((Actor)ScrollPane.this);
/*      */             
/*  117 */             if (!ScrollPane.this.flickScroll) ScrollPane.this.setScrollbarsVisible(true);
/*      */             
/*  119 */             if (ScrollPane.this.fadeAlpha == 0.0F) return false;
/*      */             
/*  121 */             if (ScrollPane.this.scrollBarTouch && ScrollPane.this.scrollX && ScrollPane.this.hScrollBounds.contains(param1Float1, param1Float2)) {
/*  122 */               param1InputEvent.stop();
/*  123 */               ScrollPane.this.setScrollbarsVisible(true);
/*  124 */               if (ScrollPane.this.hKnobBounds.contains(param1Float1, param1Float2)) {
/*  125 */                 ScrollPane.this.lastPoint.set(param1Float1, param1Float2);
/*  126 */                 this.handlePosition = ScrollPane.this.hKnobBounds.x;
/*  127 */                 ScrollPane.this.touchScrollH = true;
/*  128 */                 ScrollPane.this.draggingPointer = param1Int1;
/*  129 */                 return true;
/*      */               } 
/*  131 */               ScrollPane.this.setScrollX(ScrollPane.this.amountX + ScrollPane.this.actorArea.width * ((param1Float1 < ScrollPane.this.hKnobBounds.x) ? -1 : true));
/*  132 */               return true;
/*      */             } 
/*  134 */             if (ScrollPane.this.scrollBarTouch && ScrollPane.this.scrollY && ScrollPane.this.vScrollBounds.contains(param1Float1, param1Float2)) {
/*  135 */               param1InputEvent.stop();
/*  136 */               ScrollPane.this.setScrollbarsVisible(true);
/*  137 */               if (ScrollPane.this.vKnobBounds.contains(param1Float1, param1Float2)) {
/*  138 */                 ScrollPane.this.lastPoint.set(param1Float1, param1Float2);
/*  139 */                 this.handlePosition = ScrollPane.this.vKnobBounds.y;
/*  140 */                 ScrollPane.this.touchScrollV = true;
/*  141 */                 ScrollPane.this.draggingPointer = param1Int1;
/*  142 */                 return true;
/*      */               } 
/*  144 */               ScrollPane.this.setScrollY(ScrollPane.this.amountY + ScrollPane.this.actorArea.height * ((param1Float2 < ScrollPane.this.vKnobBounds.y) ? true : -1));
/*  145 */               return true;
/*      */             } 
/*  147 */             return false;
/*      */           }
/*      */           
/*      */           public void touchUp(InputEvent param1InputEvent, float param1Float1, float param1Float2, int param1Int1, int param1Int2) {
/*  151 */             if (param1Int1 != ScrollPane.this.draggingPointer)
/*  152 */               return;  ScrollPane.this.cancel();
/*      */           }
/*      */           
/*      */           public void touchDragged(InputEvent param1InputEvent, float param1Float1, float param1Float2, int param1Int) {
/*  156 */             if (param1Int != ScrollPane.this.draggingPointer)
/*  157 */               return;  if (ScrollPane.this.touchScrollH) {
/*  158 */               float f1 = param1Float1 - ScrollPane.this.lastPoint.x;
/*  159 */               f1 = this.handlePosition + f1;
/*  160 */               this.handlePosition = f1;
/*  161 */               f1 = Math.max(ScrollPane.this.hScrollBounds.x, f1);
/*  162 */               f1 = Math.min(ScrollPane.this.hScrollBounds.x + ScrollPane.this.hScrollBounds.width - ScrollPane.this.hKnobBounds.width, f1);
/*      */               float f2;
/*  164 */               if ((f2 = ScrollPane.this.hScrollBounds.width - ScrollPane.this.hKnobBounds.width) != 0.0F) ScrollPane.this.setScrollPercentX((f1 - ScrollPane.this.hScrollBounds.x) / f2); 
/*  165 */               ScrollPane.this.lastPoint.set(param1Float1, param1Float2); return;
/*  166 */             }  if (ScrollPane.this.touchScrollV) {
/*  167 */               float f1 = param1Float2 - ScrollPane.this.lastPoint.y;
/*  168 */               f1 = this.handlePosition + f1;
/*  169 */               this.handlePosition = f1;
/*  170 */               f1 = Math.max(ScrollPane.this.vScrollBounds.y, f1);
/*  171 */               f1 = Math.min(ScrollPane.this.vScrollBounds.y + ScrollPane.this.vScrollBounds.height - ScrollPane.this.vKnobBounds.height, f1);
/*      */               float f2;
/*  173 */               if ((f2 = ScrollPane.this.vScrollBounds.height - ScrollPane.this.vKnobBounds.height) != 0.0F) ScrollPane.this.setScrollPercentY(1.0F - (f1 - ScrollPane.this.vScrollBounds.y) / f2); 
/*  174 */               ScrollPane.this.lastPoint.set(param1Float1, param1Float2);
/*      */             } 
/*      */           }
/*      */           
/*      */           public boolean mouseMoved(InputEvent param1InputEvent, float param1Float1, float param1Float2) {
/*  179 */             if (!ScrollPane.this.flickScroll) ScrollPane.this.setScrollbarsVisible(true); 
/*  180 */             return false;
/*      */           }
/*      */         });
/*      */   }
/*      */ 
/*      */   
/*      */   protected ActorGestureListener getFlickScrollListener() {
/*  187 */     return new ActorGestureListener() {
/*      */         public void pan(InputEvent param1InputEvent, float param1Float1, float param1Float2, float param1Float3, float param1Float4) {
/*  189 */           ScrollPane.this.setScrollbarsVisible(true);
/*  190 */           if (!ScrollPane.this.scrollX) param1Float3 = 0.0F; 
/*  191 */           if (!ScrollPane.this.scrollY) param1Float4 = 0.0F; 
/*  192 */           ScrollPane.this.amountX -= param1Float3;
/*  193 */           ScrollPane.this.amountY += param1Float4;
/*  194 */           ScrollPane.this.clamp();
/*  195 */           if (ScrollPane.this.cancelTouchFocus && (param1Float3 != 0.0F || param1Float4 != 0.0F)) ScrollPane.this.cancelTouchFocus(); 
/*      */         }
/*      */         
/*      */         public void fling(InputEvent param1InputEvent, float param1Float1, float param1Float2, int param1Int) {
/*  199 */           float f = (Math.abs(param1Float1) > 150.0F && ScrollPane.this.scrollX) ? param1Float1 : 0.0F;
/*  200 */           param1Float1 = (Math.abs(param1Float2) > 150.0F && ScrollPane.this.scrollY) ? -param1Float2 : 0.0F;
/*  201 */           if (f != 0.0F || param1Float1 != 0.0F) {
/*  202 */             if (ScrollPane.this.cancelTouchFocus) ScrollPane.this.cancelTouchFocus(); 
/*  203 */             ScrollPane.this.fling(ScrollPane.this.flingTime, f, param1Float1);
/*      */           } 
/*      */         }
/*      */         
/*      */         public boolean handle(Event param1Event) {
/*  208 */           if (super.handle(param1Event)) {
/*  209 */             if (((InputEvent)param1Event).getType() == InputEvent.Type.touchDown) ScrollPane.this.flingTimer = 0.0F; 
/*  210 */             return true;
/*  211 */           }  if (param1Event instanceof InputEvent && ((InputEvent)param1Event).isTouchFocusCancel())
/*  212 */             ScrollPane.this.cancel(); 
/*  213 */           return false;
/*      */         }
/*      */       };
/*      */   }
/*      */   
/*      */   protected void addScrollListener() {
/*  219 */     addListener((EventListener)new InputListener() {
/*      */           public boolean scrolled(InputEvent param1InputEvent, float param1Float1, float param1Float2, float param1Float3, float param1Float4) {
/*  221 */             param1InputEvent.cancel();
/*  222 */             ScrollPane.this.setScrollbarsVisible(true);
/*  223 */             if (ScrollPane.this.scrollY || ScrollPane.this.scrollX) {
/*  224 */               if (ScrollPane.this.scrollY)
/*  225 */               { if (!ScrollPane.this.scrollX && param1Float4 == 0.0F) param1Float4 = param1Float3;
/*      */                  }
/*  227 */               else if (ScrollPane.this.scrollX && param1Float3 == 0.0F) { param1Float3 = param1Float4; }
/*      */               
/*  229 */               ScrollPane.this.setScrollY(ScrollPane.this.amountY + ScrollPane.this.getMouseWheelY() * param1Float4);
/*  230 */               ScrollPane.this.setScrollX(ScrollPane.this.amountX + ScrollPane.this.getMouseWheelX() * param1Float3);
/*      */             } else {
/*  232 */               return false;
/*  233 */             }  return true;
/*      */           }
/*      */         });
/*      */   }
/*      */ 
/*      */   
/*      */   public void setScrollbarsVisible(boolean paramBoolean) {
/*  240 */     if (paramBoolean) {
/*  241 */       this.fadeAlpha = this.fadeAlphaSeconds;
/*  242 */       this.fadeDelay = this.fadeDelaySeconds; return;
/*      */     } 
/*  244 */     this.fadeAlpha = 0.0F;
/*  245 */     this.fadeDelay = 0.0F;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void cancelTouchFocus() {
/*      */     Stage stage;
/*  254 */     if ((stage = getStage()) != null) stage.cancelTouchFocusExcept((EventListener)this.flickScrollListener, (Actor)this);
/*      */   
/*      */   }
/*      */   
/*      */   public void cancel() {
/*  259 */     this.draggingPointer = -1;
/*  260 */     this.touchScrollH = false;
/*  261 */     this.touchScrollV = false;
/*  262 */     this.flickScrollListener.getGestureDetector().cancel();
/*      */   }
/*      */   
/*      */   void clamp() {
/*  266 */     if (!this.clamp)
/*  267 */       return;  scrollX(this.overscrollX ? MathUtils.clamp(this.amountX, -this.overscrollDistance, this.maxX + this.overscrollDistance) : 
/*  268 */         MathUtils.clamp(this.amountX, 0.0F, this.maxX));
/*  269 */     scrollY(this.overscrollY ? MathUtils.clamp(this.amountY, -this.overscrollDistance, this.maxY + this.overscrollDistance) : 
/*  270 */         MathUtils.clamp(this.amountY, 0.0F, this.maxY));
/*      */   }
/*      */   
/*      */   public void setStyle(ScrollPaneStyle paramScrollPaneStyle) {
/*  274 */     if (paramScrollPaneStyle == null) throw new IllegalArgumentException("style cannot be null."); 
/*  275 */     this.style = paramScrollPaneStyle;
/*  276 */     invalidateHierarchy();
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public ScrollPaneStyle getStyle() {
/*  282 */     return this.style;
/*      */   }
/*      */   
/*      */   public void act(float paramFloat) {
/*  286 */     super.act(paramFloat);
/*      */     
/*  288 */     boolean bool = this.flickScrollListener.getGestureDetector().isPanning();
/*  289 */     boolean bool1 = false;
/*      */     
/*  291 */     if (this.fadeAlpha > 0.0F && this.fadeScrollBars && !bool && !this.touchScrollH && !this.touchScrollV) {
/*  292 */       this.fadeDelay -= paramFloat;
/*  293 */       if (this.fadeDelay <= 0.0F) this.fadeAlpha = Math.max(0.0F, this.fadeAlpha - paramFloat); 
/*  294 */       bool1 = true;
/*      */     } 
/*      */     
/*  297 */     if (this.flingTimer > 0.0F) {
/*  298 */       setScrollbarsVisible(true);
/*      */       
/*  300 */       float f = this.flingTimer / this.flingTime;
/*  301 */       this.amountX -= this.velocityX * f * paramFloat;
/*  302 */       this.amountY -= this.velocityY * f * paramFloat;
/*  303 */       clamp();
/*      */ 
/*      */       
/*  306 */       if (this.amountX == -this.overscrollDistance) this.velocityX = 0.0F; 
/*  307 */       if (this.amountX >= this.maxX + this.overscrollDistance) this.velocityX = 0.0F; 
/*  308 */       if (this.amountY == -this.overscrollDistance) this.velocityY = 0.0F; 
/*  309 */       if (this.amountY >= this.maxY + this.overscrollDistance) this.velocityY = 0.0F;
/*      */       
/*  311 */       this.flingTimer -= paramFloat;
/*  312 */       if (this.flingTimer <= 0.0F) {
/*  313 */         this.velocityX = 0.0F;
/*  314 */         this.velocityY = 0.0F;
/*      */       } 
/*      */       
/*  317 */       boolean bool2 = true;
/*      */     } 
/*      */     
/*  320 */     if (this.smoothScrolling && this.flingTimer <= 0.0F && !bool && (!this.touchScrollH || (this.scrollX && this.maxX / (this.hScrollBounds.width - this.hKnobBounds.width) > this.actorArea.width * 0.1F)) && (!this.touchScrollV || (this.scrollY && this.maxY / (this.vScrollBounds.height - this.vKnobBounds.height) > this.actorArea.height * 0.1F))) {
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  325 */       if (this.visualAmountX != this.amountX) {
/*  326 */         if (this.visualAmountX < this.amountX) {
/*  327 */           visualScrollX(Math.min(this.amountX, this.visualAmountX + Math.max(200.0F * paramFloat, (this.amountX - this.visualAmountX) * 7.0F * paramFloat)));
/*      */         } else {
/*  329 */           visualScrollX(Math.max(this.amountX, this.visualAmountX - Math.max(200.0F * paramFloat, (this.visualAmountX - this.amountX) * 7.0F * paramFloat)));
/*  330 */         }  bool1 = true;
/*      */       } 
/*  332 */       if (this.visualAmountY != this.amountY) {
/*  333 */         if (this.visualAmountY < this.amountY) {
/*  334 */           visualScrollY(Math.min(this.amountY, this.visualAmountY + Math.max(200.0F * paramFloat, (this.amountY - this.visualAmountY) * 7.0F * paramFloat)));
/*      */         } else {
/*  336 */           visualScrollY(Math.max(this.amountY, this.visualAmountY - Math.max(200.0F * paramFloat, (this.visualAmountY - this.amountY) * 7.0F * paramFloat)));
/*  337 */         }  bool1 = true;
/*      */       } 
/*      */     } else {
/*  340 */       if (this.visualAmountX != this.amountX) visualScrollX(this.amountX); 
/*  341 */       if (this.visualAmountY != this.amountY) visualScrollY(this.amountY);
/*      */     
/*      */     } 
/*  344 */     if (!bool) {
/*  345 */       if (this.overscrollX && this.scrollX) {
/*  346 */         if (this.amountX < 0.0F) {
/*  347 */           setScrollbarsVisible(true);
/*  348 */           this.amountX += (this.overscrollSpeedMin + (this.overscrollSpeedMax - this.overscrollSpeedMin) * -this.amountX / this.overscrollDistance) * paramFloat;
/*      */           
/*  350 */           if (this.amountX > 0.0F) scrollX(0.0F); 
/*  351 */           bool1 = true;
/*  352 */         } else if (this.amountX > this.maxX) {
/*  353 */           setScrollbarsVisible(true);
/*  354 */           this.amountX -= (this.overscrollSpeedMin + (this.overscrollSpeedMax - this.overscrollSpeedMin) * -(this.maxX - this.amountX) / this.overscrollDistance) * paramFloat;
/*      */           
/*  356 */           if (this.amountX < this.maxX) scrollX(this.maxX); 
/*  357 */           bool1 = true;
/*      */         } 
/*      */       }
/*  360 */       if (this.overscrollY && this.scrollY) {
/*  361 */         if (this.amountY < 0.0F) {
/*  362 */           setScrollbarsVisible(true);
/*  363 */           this.amountY += (this.overscrollSpeedMin + (this.overscrollSpeedMax - this.overscrollSpeedMin) * -this.amountY / this.overscrollDistance) * paramFloat;
/*      */           
/*  365 */           if (this.amountY > 0.0F) scrollY(0.0F); 
/*  366 */           bool1 = true;
/*  367 */         } else if (this.amountY > this.maxY) {
/*  368 */           setScrollbarsVisible(true);
/*  369 */           this.amountY -= (this.overscrollSpeedMin + (this.overscrollSpeedMax - this.overscrollSpeedMin) * -(this.maxY - this.amountY) / this.overscrollDistance) * paramFloat;
/*      */           
/*  371 */           if (this.amountY < this.maxY) scrollY(this.maxY); 
/*  372 */           bool1 = true;
/*      */         } 
/*      */       }
/*      */     } 
/*      */     Stage stage;
/*  377 */     if (bool1 && (
/*      */       
/*  379 */       stage = getStage()) != null && stage.getActionsRequestRendering()) Gdx.graphics.requestRendering();
/*      */   
/*      */   }
/*      */   
/*      */   public void layout() {
/*  384 */     Drawable drawable1 = this.style.background, drawable2 = this.style.hScrollKnob, drawable3 = this.style.vScrollKnob;
/*  385 */     float f2 = 0.0F, f3 = 0.0F, f4 = 0.0F, f5 = 0.0F;
/*  386 */     if (drawable1 != null) {
/*  387 */       f2 = drawable1.getLeftWidth();
/*  388 */       f3 = drawable1.getRightWidth();
/*  389 */       f4 = drawable1.getTopHeight();
/*  390 */       f5 = drawable1.getBottomHeight();
/*      */     } 
/*  392 */     float f1 = getWidth(), f6 = getHeight();
/*  393 */     this.actorArea.set(f2, f5, f1 - f2 - f3, f6 - f4 - f5);
/*      */     
/*  395 */     if (this.actor == null)
/*      */       return; 
/*  397 */     float f7 = 0.0F, f8 = 0.0F;
/*  398 */     if (drawable2 != null) f7 = drawable2.getMinHeight(); 
/*  399 */     if (this.style.hScroll != null) f7 = Math.max(f7, this.style.hScroll.getMinHeight()); 
/*  400 */     if (drawable3 != null) f8 = drawable3.getMinWidth(); 
/*  401 */     if (this.style.vScroll != null) f8 = Math.max(f8, this.style.vScroll.getMinWidth());
/*      */ 
/*      */ 
/*      */     
/*  405 */     if (this.actor instanceof Layout) {
/*      */       Layout layout;
/*  407 */       f9 = (layout = (Layout)this.actor).getPrefWidth();
/*  408 */       f10 = layout.getPrefHeight();
/*      */     } else {
/*  410 */       f9 = this.actor.getWidth();
/*  411 */       f10 = this.actor.getHeight();
/*      */     } 
/*      */ 
/*      */     
/*  415 */     this.scrollX = (this.forceScrollX || (f9 > this.actorArea.width && !this.disableX));
/*  416 */     this.scrollY = (this.forceScrollY || (f10 > this.actorArea.height && !this.disableY));
/*      */ 
/*      */     
/*  419 */     if (!this.scrollbarsOnTop) {
/*  420 */       if (this.scrollY) {
/*  421 */         this.actorArea.width -= f8;
/*  422 */         if (!this.vScrollOnRight) this.actorArea.x += f8;
/*      */         
/*  424 */         if (!this.scrollX && f9 > this.actorArea.width && !this.disableX) this.scrollX = true; 
/*      */       } 
/*  426 */       if (this.scrollX) {
/*  427 */         this.actorArea.height -= f7;
/*  428 */         if (this.hScrollOnBottom) this.actorArea.y += f7;
/*      */         
/*  430 */         if (!this.scrollY && f10 > this.actorArea.height && !this.disableY) {
/*  431 */           this.scrollY = true;
/*  432 */           this.actorArea.width -= f8;
/*  433 */           if (!this.vScrollOnRight) this.actorArea.x += f8;
/*      */         
/*      */         } 
/*      */       } 
/*      */     } 
/*      */     
/*  439 */     float f9 = this.disableX ? this.actorArea.width : Math.max(this.actorArea.width, f9);
/*  440 */     float f10 = this.disableY ? this.actorArea.height : Math.max(this.actorArea.height, f10);
/*      */     
/*  442 */     this.maxX = f9 - this.actorArea.width;
/*  443 */     this.maxY = f10 - this.actorArea.height;
/*  444 */     scrollX(MathUtils.clamp(this.amountX, 0.0F, this.maxX));
/*  445 */     scrollY(MathUtils.clamp(this.amountY, 0.0F, this.maxY));
/*      */ 
/*      */     
/*  448 */     if (this.scrollX) {
/*  449 */       if (drawable2 != null) {
/*  450 */         float f = this.scrollbarsOnTop ? f2 : this.actorArea.x;
/*  451 */         f4 = this.hScrollOnBottom ? f5 : (f6 - f4 - f7);
/*  452 */         this.hScrollBounds.set(f, f4, this.actorArea.width, f7);
/*  453 */         if (this.scrollY && this.scrollbarsOnTop) {
/*  454 */           this.hScrollBounds.width -= f8;
/*  455 */           if (!this.vScrollOnRight) this.hScrollBounds.x += f8;
/*      */         
/*      */         } 
/*  458 */         if (this.variableSizeKnobs) {
/*  459 */           this.hKnobBounds.width = Math.max(drawable2.getMinWidth(), (int)(this.hScrollBounds.width * this.actorArea.width / f9));
/*      */         } else {
/*  461 */           this.hKnobBounds.width = drawable2.getMinWidth();
/*  462 */         }  if (this.hKnobBounds.width > f9) this.hKnobBounds.width = 0.0F; 
/*  463 */         this.hKnobBounds.height = drawable2.getMinHeight();
/*  464 */         this.hScrollBounds.x += (int)((this.hScrollBounds.width - this.hKnobBounds.width) * getScrollPercentX());
/*  465 */         this.hKnobBounds.y = this.hScrollBounds.y;
/*      */       } else {
/*  467 */         this.hScrollBounds.set(0.0F, 0.0F, 0.0F, 0.0F);
/*  468 */         this.hKnobBounds.set(0.0F, 0.0F, 0.0F, 0.0F);
/*      */       } 
/*      */     }
/*  471 */     if (this.scrollY) {
/*  472 */       if (drawable3 != null) {
/*  473 */         float f = this.vScrollOnRight ? (f1 - f3 - f8) : f2;
/*  474 */         f4 = this.scrollbarsOnTop ? f5 : this.actorArea.y;
/*  475 */         this.vScrollBounds.set(f, f4, f8, this.actorArea.height);
/*  476 */         if (this.scrollX && this.scrollbarsOnTop) {
/*  477 */           this.vScrollBounds.height -= f7;
/*  478 */           if (this.hScrollOnBottom) this.vScrollBounds.y += f7;
/*      */         
/*      */         } 
/*  481 */         this.vKnobBounds.width = drawable3.getMinWidth();
/*  482 */         if (this.variableSizeKnobs) {
/*  483 */           this.vKnobBounds.height = Math.max(drawable3.getMinHeight(), (int)(this.vScrollBounds.height * this.actorArea.height / f10));
/*      */         } else {
/*      */           
/*  486 */           this.vKnobBounds.height = drawable3.getMinHeight();
/*  487 */         }  if (this.vKnobBounds.height > f10) this.vKnobBounds.height = 0.0F; 
/*  488 */         this.vKnobBounds.x = this.vScrollOnRight ? (f1 - f3 - drawable3.getMinWidth()) : f2;
/*  489 */         this.vScrollBounds.y += (int)((this.vScrollBounds.height - this.vKnobBounds.height) * (1.0F - getScrollPercentY()));
/*      */       } else {
/*  491 */         this.vScrollBounds.set(0.0F, 0.0F, 0.0F, 0.0F);
/*  492 */         this.vKnobBounds.set(0.0F, 0.0F, 0.0F, 0.0F);
/*      */       } 
/*      */     }
/*      */     
/*  496 */     updateActorPosition();
/*  497 */     if (this.actor instanceof Layout) {
/*  498 */       this.actor.setSize(f9, f10);
/*  499 */       ((Layout)this.actor).validate();
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   private void updateActorPosition() {
/*  505 */     float f1 = this.actorArea.x - (this.scrollX ? (int)this.visualAmountX : false);
/*  506 */     float f2 = this.actorArea.y - (int)(this.scrollY ? (this.maxY - this.visualAmountY) : this.maxY);
/*  507 */     this.actor.setPosition(f1, f2);
/*      */     
/*  509 */     if (this.actor instanceof Cullable) {
/*  510 */       this.actorArea.x -= f1;
/*  511 */       this.actorArea.y -= f2;
/*  512 */       this.actorCullingArea.width = this.actorArea.width;
/*  513 */       this.actorCullingArea.height = this.actorArea.height;
/*  514 */       ((Cullable)this.actor).setCullingArea(this.actorCullingArea);
/*      */     } 
/*      */   }
/*      */   
/*      */   public void draw(Batch paramBatch, float paramFloat) {
/*  519 */     if (this.actor == null)
/*      */       return; 
/*  521 */     validate();
/*      */ 
/*      */     
/*  524 */     applyTransform(paramBatch, computeTransform());
/*      */     
/*  526 */     if (this.scrollX) this.hScrollBounds.x += (int)((this.hScrollBounds.width - this.hKnobBounds.width) * getVisualScrollPercentX()); 
/*  527 */     if (this.scrollY) {
/*  528 */       this.vScrollBounds.y += (int)((this.vScrollBounds.height - this.vKnobBounds.height) * (1.0F - getVisualScrollPercentY()));
/*      */     }
/*  530 */     updateActorPosition();
/*      */     
/*      */     Color color;
/*      */     
/*  534 */     float f = (color = getColor()).a * paramFloat;
/*  535 */     if (this.style.background != null) {
/*  536 */       paramBatch.setColor(color.r, color.g, color.b, f);
/*  537 */       this.style.background.draw(paramBatch, 0.0F, 0.0F, getWidth(), getHeight());
/*      */     } 
/*      */     
/*  540 */     paramBatch.flush();
/*  541 */     if (clipBegin(this.actorArea.x, this.actorArea.y, this.actorArea.width, this.actorArea.height)) {
/*  542 */       drawChildren(paramBatch, paramFloat);
/*  543 */       paramBatch.flush();
/*  544 */       clipEnd();
/*      */     } 
/*      */ 
/*      */     
/*  548 */     paramBatch.setColor(color.r, color.g, color.b, f);
/*  549 */     if (this.fadeScrollBars) f *= Interpolation.fade.apply(this.fadeAlpha / this.fadeAlphaSeconds); 
/*  550 */     drawScrollBars(paramBatch, color.r, color.g, color.b, f);
/*      */     
/*  552 */     resetTransform(paramBatch);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   protected void drawScrollBars(Batch paramBatch, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4) {
/*  558 */     if (paramFloat4 <= 0.0F)
/*  559 */       return;  paramBatch.setColor(paramFloat1, paramFloat2, paramFloat3, paramFloat4);
/*      */     
/*  561 */     boolean bool1 = (this.scrollX && this.hKnobBounds.width > 0.0F) ? true : false;
/*  562 */     boolean bool2 = (this.scrollY && this.vKnobBounds.height > 0.0F) ? true : false;
/*  563 */     if (bool1) {
/*  564 */       if (bool2 && this.style.corner != null) this.style.corner.draw(paramBatch, this.hScrollBounds.x + this.hScrollBounds.width, this.hScrollBounds.y, this.vScrollBounds.width, this.vScrollBounds.y);
/*      */ 
/*      */       
/*  567 */       if (this.style.hScroll != null)
/*  568 */         this.style.hScroll.draw(paramBatch, this.hScrollBounds.x, this.hScrollBounds.y, this.hScrollBounds.width, this.hScrollBounds.height); 
/*  569 */       if (this.style.hScrollKnob != null)
/*  570 */         this.style.hScrollKnob.draw(paramBatch, this.hKnobBounds.x, this.hKnobBounds.y, this.hKnobBounds.width, this.hKnobBounds.height); 
/*      */     } 
/*  572 */     if (bool2) {
/*  573 */       if (this.style.vScroll != null)
/*  574 */         this.style.vScroll.draw(paramBatch, this.vScrollBounds.x, this.vScrollBounds.y, this.vScrollBounds.width, this.vScrollBounds.height); 
/*  575 */       if (this.style.vScrollKnob != null) {
/*  576 */         this.style.vScrollKnob.draw(paramBatch, this.vKnobBounds.x, this.vKnobBounds.y, this.vKnobBounds.width, this.vKnobBounds.height);
/*      */       }
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void fling(float paramFloat1, float paramFloat2, float paramFloat3) {
/*  585 */     this.flingTimer = paramFloat1;
/*  586 */     this.velocityX = paramFloat2;
/*  587 */     this.velocityY = paramFloat3;
/*      */   }
/*      */   
/*      */   public float getPrefWidth() {
/*  591 */     float f = 0.0F;
/*  592 */     if (this.actor instanceof Layout) {
/*  593 */       f = ((Layout)this.actor).getPrefWidth();
/*  594 */     } else if (this.actor != null) {
/*  595 */       f = this.actor.getWidth();
/*      */     } 
/*      */     Drawable drawable;
/*  598 */     if ((drawable = this.style.background) != null) {
/*  599 */       f = Math.max(f + drawable.getLeftWidth() + drawable.getRightWidth(), drawable.getMinWidth());
/*      */     }
/*  601 */     if (this.scrollY) {
/*  602 */       float f1 = 0.0F;
/*  603 */       if (this.style.vScrollKnob != null) f1 = this.style.vScrollKnob.getMinWidth(); 
/*  604 */       if (this.style.vScroll != null) f1 = Math.max(f1, this.style.vScroll.getMinWidth()); 
/*  605 */       f += f1;
/*      */     } 
/*  607 */     return f;
/*      */   }
/*      */   
/*      */   public float getPrefHeight() {
/*  611 */     float f = 0.0F;
/*  612 */     if (this.actor instanceof Layout) {
/*  613 */       f = ((Layout)this.actor).getPrefHeight();
/*  614 */     } else if (this.actor != null) {
/*  615 */       f = this.actor.getHeight();
/*      */     } 
/*      */     Drawable drawable;
/*  618 */     if ((drawable = this.style.background) != null) {
/*  619 */       f = Math.max(f + drawable.getTopHeight() + drawable.getBottomHeight(), drawable.getMinHeight());
/*      */     }
/*  621 */     if (this.scrollX) {
/*  622 */       float f1 = 0.0F;
/*  623 */       if (this.style.hScrollKnob != null) f1 = this.style.hScrollKnob.getMinHeight(); 
/*  624 */       if (this.style.hScroll != null) f1 = Math.max(f1, this.style.hScroll.getMinHeight()); 
/*  625 */       f += f1;
/*      */     } 
/*  627 */     return f;
/*      */   }
/*      */   
/*      */   public float getMinWidth() {
/*  631 */     return 0.0F;
/*      */   }
/*      */   
/*      */   public float getMinHeight() {
/*  635 */     return 0.0F;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public void setActor(@Null Actor paramActor) {
/*  641 */     if (this.actor == this) throw new IllegalArgumentException("actor cannot be the ScrollPane."); 
/*  642 */     if (this.actor != null) super.removeActor(this.actor); 
/*  643 */     this.actor = paramActor;
/*  644 */     if (paramActor != null) super.addActor(paramActor); 
/*      */   }
/*      */   
/*      */   @Null
/*      */   public Actor getActor() {
/*  649 */     return this.actor;
/*      */   }
/*      */ 
/*      */   
/*      */   @Deprecated
/*      */   public void setWidget(@Null Actor paramActor) {
/*  655 */     setActor(paramActor);
/*      */   }
/*      */   
/*      */   @Deprecated
/*      */   @Null
/*      */   public Actor getWidget() {
/*  661 */     return this.actor;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   @Deprecated
/*      */   public void addActor(Actor paramActor) {
/*  668 */     throw new UnsupportedOperationException("Use ScrollPane#setActor.");
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   @Deprecated
/*      */   public void addActorAt(int paramInt, Actor paramActor) {
/*  675 */     throw new UnsupportedOperationException("Use ScrollPane#setActor.");
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   @Deprecated
/*      */   public void addActorBefore(Actor paramActor1, Actor paramActor2) {
/*  682 */     throw new UnsupportedOperationException("Use ScrollPane#setActor.");
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   @Deprecated
/*      */   public void addActorAfter(Actor paramActor1, Actor paramActor2) {
/*  689 */     throw new UnsupportedOperationException("Use ScrollPane#setActor.");
/*      */   }
/*      */   
/*      */   public boolean removeActor(Actor paramActor) {
/*  693 */     if (paramActor == null) throw new IllegalArgumentException("actor cannot be null."); 
/*  694 */     if (paramActor != this.actor) return false; 
/*  695 */     setActor((Actor)null);
/*  696 */     return true;
/*      */   }
/*      */   
/*      */   public boolean removeActor(Actor paramActor, boolean paramBoolean) {
/*  700 */     if (paramActor == null) throw new IllegalArgumentException("actor cannot be null."); 
/*  701 */     if (paramActor != this.actor) return false; 
/*  702 */     this.actor = null;
/*  703 */     return super.removeActor(paramActor, paramBoolean);
/*      */   }
/*      */   
/*      */   public Actor removeActorAt(int paramInt, boolean paramBoolean) {
/*      */     Actor actor;
/*  708 */     if ((actor = super.removeActorAt(paramInt, paramBoolean)) == this.actor) this.actor = null; 
/*  709 */     return actor;
/*      */   }
/*      */   @Null
/*      */   public Actor hit(float paramFloat1, float paramFloat2, boolean paramBoolean) {
/*  713 */     if (paramFloat1 < 0.0F || paramFloat1 >= getWidth() || paramFloat2 < 0.0F || paramFloat2 >= getHeight()) return null; 
/*  714 */     if (paramBoolean && getTouchable() == Touchable.enabled && isVisible()) {
/*  715 */       if (this.scrollX && this.touchScrollH && this.hScrollBounds.contains(paramFloat1, paramFloat2)) return (Actor)this; 
/*  716 */       if (this.scrollY && this.touchScrollV && this.vScrollBounds.contains(paramFloat1, paramFloat2)) return (Actor)this; 
/*      */     } 
/*  718 */     return super.hit(paramFloat1, paramFloat2, paramBoolean);
/*      */   }
/*      */ 
/*      */   
/*      */   protected void scrollX(float paramFloat) {
/*  723 */     this.amountX = paramFloat;
/*      */   }
/*      */ 
/*      */   
/*      */   protected void scrollY(float paramFloat) {
/*  728 */     this.amountY = paramFloat;
/*      */   }
/*      */ 
/*      */   
/*      */   protected void visualScrollX(float paramFloat) {
/*  733 */     this.visualAmountX = paramFloat;
/*      */   }
/*      */ 
/*      */   
/*      */   protected void visualScrollY(float paramFloat) {
/*  738 */     this.visualAmountY = paramFloat;
/*      */   }
/*      */ 
/*      */   
/*      */   protected float getMouseWheelX() {
/*  743 */     return Math.min(this.actorArea.width, Math.max(this.actorArea.width * 0.9F, this.maxX * 0.1F) / 4.0F);
/*      */   }
/*      */ 
/*      */   
/*      */   protected float getMouseWheelY() {
/*  748 */     return Math.min(this.actorArea.height, Math.max(this.actorArea.height * 0.9F, this.maxY * 0.1F) / 4.0F);
/*      */   }
/*      */   
/*      */   public void setScrollX(float paramFloat) {
/*  752 */     scrollX(MathUtils.clamp(paramFloat, 0.0F, this.maxX));
/*      */   }
/*      */ 
/*      */   
/*      */   public float getScrollX() {
/*  757 */     return this.amountX;
/*      */   }
/*      */   
/*      */   public void setScrollY(float paramFloat) {
/*  761 */     scrollY(MathUtils.clamp(paramFloat, 0.0F, this.maxY));
/*      */   }
/*      */ 
/*      */   
/*      */   public float getScrollY() {
/*  766 */     return this.amountY;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public void updateVisualScroll() {
/*  772 */     this.visualAmountX = this.amountX;
/*  773 */     this.visualAmountY = this.amountY;
/*      */   }
/*      */   
/*      */   public float getVisualScrollX() {
/*  777 */     return !this.scrollX ? 0.0F : this.visualAmountX;
/*      */   }
/*      */   
/*      */   public float getVisualScrollY() {
/*  781 */     return !this.scrollY ? 0.0F : this.visualAmountY;
/*      */   }
/*      */   
/*      */   public float getVisualScrollPercentX() {
/*  785 */     if (this.maxX == 0.0F) return 0.0F; 
/*  786 */     return MathUtils.clamp(this.visualAmountX / this.maxX, 0.0F, 1.0F);
/*      */   }
/*      */   
/*      */   public float getVisualScrollPercentY() {
/*  790 */     if (this.maxY == 0.0F) return 0.0F; 
/*  791 */     return MathUtils.clamp(this.visualAmountY / this.maxY, 0.0F, 1.0F);
/*      */   }
/*      */   
/*      */   public float getScrollPercentX() {
/*  795 */     if (this.maxX == 0.0F) return 0.0F; 
/*  796 */     return MathUtils.clamp(this.amountX / this.maxX, 0.0F, 1.0F);
/*      */   }
/*      */   
/*      */   public void setScrollPercentX(float paramFloat) {
/*  800 */     scrollX(this.maxX * MathUtils.clamp(paramFloat, 0.0F, 1.0F));
/*      */   }
/*      */   
/*      */   public float getScrollPercentY() {
/*  804 */     if (this.maxY == 0.0F) return 0.0F; 
/*  805 */     return MathUtils.clamp(this.amountY / this.maxY, 0.0F, 1.0F);
/*      */   }
/*      */   
/*      */   public void setScrollPercentY(float paramFloat) {
/*  809 */     scrollY(this.maxY * MathUtils.clamp(paramFloat, 0.0F, 1.0F));
/*      */   }
/*      */   
/*      */   public void setFlickScroll(boolean paramBoolean) {
/*  813 */     if (this.flickScroll == paramBoolean)
/*  814 */       return;  this.flickScroll = paramBoolean;
/*  815 */     if (paramBoolean) {
/*  816 */       addListener((EventListener)this.flickScrollListener);
/*      */     } else {
/*  818 */       removeListener((EventListener)this.flickScrollListener);
/*  819 */     }  invalidate();
/*      */   }
/*      */   
/*      */   public void setFlickScrollTapSquareSize(float paramFloat) {
/*  823 */     this.flickScrollListener.getGestureDetector().setTapSquareSize(paramFloat);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public void scrollTo(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4) {
/*  829 */     scrollTo(paramFloat1, paramFloat2, paramFloat3, paramFloat4, false, false);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public void scrollTo(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, boolean paramBoolean1, boolean paramBoolean2) {
/*  835 */     validate();
/*      */     
/*  837 */     float f = this.amountX;
/*  838 */     if (paramBoolean1) {
/*  839 */       f = paramFloat1 + (paramFloat3 - this.actorArea.width) / 2.0F;
/*      */     } else {
/*  841 */       f = MathUtils.clamp(f, paramFloat1, paramFloat1 + paramFloat3 - this.actorArea.width);
/*  842 */     }  scrollX(MathUtils.clamp(f, 0.0F, this.maxX));
/*      */     
/*  844 */     paramFloat1 = this.amountY;
/*  845 */     paramFloat2 = this.maxY - paramFloat2;
/*  846 */     if (paramBoolean2) {
/*  847 */       paramFloat1 = paramFloat2 + (this.actorArea.height + paramFloat4) / 2.0F;
/*      */     } else {
/*  849 */       paramFloat1 = MathUtils.clamp(paramFloat1, paramFloat2 + paramFloat4, paramFloat2 + this.actorArea.height);
/*  850 */     }  scrollY(MathUtils.clamp(paramFloat1, 0.0F, this.maxY));
/*      */   }
/*      */ 
/*      */   
/*      */   public float getMaxX() {
/*  855 */     return this.maxX;
/*      */   }
/*      */ 
/*      */   
/*      */   public float getMaxY() {
/*  860 */     return this.maxY;
/*      */   }
/*      */   
/*      */   public float getScrollBarHeight() {
/*  864 */     if (!this.scrollX) return 0.0F; 
/*  865 */     float f = 0.0F;
/*  866 */     if (this.style.hScrollKnob != null) f = this.style.hScrollKnob.getMinHeight(); 
/*  867 */     if (this.style.hScroll != null) f = Math.max(f, this.style.hScroll.getMinHeight()); 
/*  868 */     return f;
/*      */   }
/*      */   
/*      */   public float getScrollBarWidth() {
/*  872 */     if (!this.scrollY) return 0.0F; 
/*  873 */     float f = 0.0F;
/*  874 */     if (this.style.vScrollKnob != null) f = this.style.vScrollKnob.getMinWidth(); 
/*  875 */     if (this.style.vScroll != null) f = Math.max(f, this.style.vScroll.getMinWidth()); 
/*  876 */     return f;
/*      */   }
/*      */ 
/*      */   
/*      */   public float getScrollWidth() {
/*  881 */     return this.actorArea.width;
/*      */   }
/*      */ 
/*      */   
/*      */   public float getScrollHeight() {
/*  886 */     return this.actorArea.height;
/*      */   }
/*      */ 
/*      */   
/*      */   public boolean isScrollX() {
/*  891 */     return this.scrollX;
/*      */   }
/*      */ 
/*      */   
/*      */   public boolean isScrollY() {
/*  896 */     return this.scrollY;
/*      */   }
/*      */ 
/*      */   
/*      */   public void setScrollingDisabled(boolean paramBoolean1, boolean paramBoolean2) {
/*  901 */     if (paramBoolean1 == this.disableX && paramBoolean2 == this.disableY)
/*  902 */       return;  this.disableX = paramBoolean1;
/*  903 */     this.disableY = paramBoolean2;
/*  904 */     invalidate();
/*      */   }
/*      */   
/*      */   public boolean isScrollingDisabledX() {
/*  908 */     return this.disableX;
/*      */   }
/*      */   
/*      */   public boolean isScrollingDisabledY() {
/*  912 */     return this.disableY;
/*      */   }
/*      */   
/*      */   public boolean isLeftEdge() {
/*  916 */     return (!this.scrollX || this.amountX <= 0.0F);
/*      */   }
/*      */   
/*      */   public boolean isRightEdge() {
/*  920 */     return (!this.scrollX || this.amountX >= this.maxX);
/*      */   }
/*      */   
/*      */   public boolean isTopEdge() {
/*  924 */     return (!this.scrollY || this.amountY <= 0.0F);
/*      */   }
/*      */   
/*      */   public boolean isBottomEdge() {
/*  928 */     return (!this.scrollY || this.amountY >= this.maxY);
/*      */   }
/*      */   
/*      */   public boolean isDragging() {
/*  932 */     return (this.draggingPointer != -1);
/*      */   }
/*      */   
/*      */   public boolean isPanning() {
/*  936 */     return this.flickScrollListener.getGestureDetector().isPanning();
/*      */   }
/*      */   
/*      */   public boolean isFlinging() {
/*  940 */     return (this.flingTimer > 0.0F);
/*      */   }
/*      */   
/*      */   public void setVelocityX(float paramFloat) {
/*  944 */     this.velocityX = paramFloat;
/*      */   }
/*      */ 
/*      */   
/*      */   public float getVelocityX() {
/*  949 */     return this.velocityX;
/*      */   }
/*      */   
/*      */   public void setVelocityY(float paramFloat) {
/*  953 */     this.velocityY = paramFloat;
/*      */   }
/*      */ 
/*      */   
/*      */   public float getVelocityY() {
/*  958 */     return this.velocityY;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public void setOverscroll(boolean paramBoolean1, boolean paramBoolean2) {
/*  964 */     this.overscrollX = paramBoolean1;
/*  965 */     this.overscrollY = paramBoolean2;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public void setupOverscroll(float paramFloat1, float paramFloat2, float paramFloat3) {
/*  971 */     this.overscrollDistance = paramFloat1;
/*  972 */     this.overscrollSpeedMin = paramFloat2;
/*  973 */     this.overscrollSpeedMax = paramFloat3;
/*      */   }
/*      */   
/*      */   public float getOverscrollDistance() {
/*  977 */     return this.overscrollDistance;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public void setForceScroll(boolean paramBoolean1, boolean paramBoolean2) {
/*  983 */     this.forceScrollX = paramBoolean1;
/*  984 */     this.forceScrollY = paramBoolean2;
/*      */   }
/*      */   
/*      */   public boolean isForceScrollX() {
/*  988 */     return this.forceScrollX;
/*      */   }
/*      */   
/*      */   public boolean isForceScrollY() {
/*  992 */     return this.forceScrollY;
/*      */   }
/*      */ 
/*      */   
/*      */   public void setFlingTime(float paramFloat) {
/*  997 */     this.flingTime = paramFloat;
/*      */   }
/*      */ 
/*      */   
/*      */   public void setClamp(boolean paramBoolean) {
/* 1002 */     this.clamp = paramBoolean;
/*      */   }
/*      */ 
/*      */   
/*      */   public void setScrollBarPositions(boolean paramBoolean1, boolean paramBoolean2) {
/* 1007 */     this.hScrollOnBottom = paramBoolean1;
/* 1008 */     this.vScrollOnRight = paramBoolean2;
/*      */   }
/*      */ 
/*      */   
/*      */   public void setFadeScrollBars(boolean paramBoolean) {
/* 1013 */     if (this.fadeScrollBars == paramBoolean)
/* 1014 */       return;  this.fadeScrollBars = paramBoolean;
/* 1015 */     if (!paramBoolean) this.fadeAlpha = this.fadeAlphaSeconds; 
/* 1016 */     invalidate();
/*      */   }
/*      */   
/*      */   public void setupFadeScrollBars(float paramFloat1, float paramFloat2) {
/* 1020 */     this.fadeAlphaSeconds = paramFloat1;
/* 1021 */     this.fadeDelaySeconds = paramFloat2;
/*      */   }
/*      */   
/*      */   public boolean getFadeScrollBars() {
/* 1025 */     return this.fadeScrollBars;
/*      */   }
/*      */ 
/*      */   
/*      */   public void setScrollBarTouch(boolean paramBoolean) {
/* 1030 */     this.scrollBarTouch = paramBoolean;
/*      */   }
/*      */   
/*      */   public void setSmoothScrolling(boolean paramBoolean) {
/* 1034 */     this.smoothScrolling = paramBoolean;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setScrollbarsOnTop(boolean paramBoolean) {
/* 1041 */     this.scrollbarsOnTop = paramBoolean;
/* 1042 */     invalidate();
/*      */   }
/*      */   
/*      */   public boolean getVariableSizeKnobs() {
/* 1046 */     return this.variableSizeKnobs;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public void setVariableSizeKnobs(boolean paramBoolean) {
/* 1052 */     this.variableSizeKnobs = paramBoolean;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public void setCancelTouchFocus(boolean paramBoolean) {
/* 1058 */     this.cancelTouchFocus = paramBoolean;
/*      */   }
/*      */   
/*      */   public void drawDebug(ShapeRenderer paramShapeRenderer) {
/* 1062 */     drawDebugBounds(paramShapeRenderer);
/* 1063 */     applyTransform(paramShapeRenderer, computeTransform());
/* 1064 */     if (clipBegin(this.actorArea.x, this.actorArea.y, this.actorArea.width, this.actorArea.height)) {
/* 1065 */       drawDebugChildren(paramShapeRenderer);
/* 1066 */       paramShapeRenderer.flush();
/* 1067 */       clipEnd();
/*      */     } 
/* 1069 */     resetTransform(paramShapeRenderer);
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
/* 1085 */       this.background = param1Drawable1;
/* 1086 */       this.hScroll = param1Drawable2;
/* 1087 */       this.hScrollKnob = param1Drawable3;
/* 1088 */       this.vScroll = param1Drawable4;
/* 1089 */       this.vScrollKnob = param1Drawable5;
/*      */     }
/*      */     
/*      */     public ScrollPaneStyle(ScrollPaneStyle param1ScrollPaneStyle) {
/* 1093 */       this.background = param1ScrollPaneStyle.background;
/* 1094 */       this.corner = param1ScrollPaneStyle.corner;
/*      */       
/* 1096 */       this.hScroll = param1ScrollPaneStyle.hScroll;
/* 1097 */       this.hScrollKnob = param1ScrollPaneStyle.hScrollKnob;
/*      */       
/* 1099 */       this.vScroll = param1ScrollPaneStyle.vScroll;
/* 1100 */       this.vScrollKnob = param1ScrollPaneStyle.vScrollKnob;
/*      */     } }
/*      */ 
/*      */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gdx\scenes\scene2\\ui\ScrollPane.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */