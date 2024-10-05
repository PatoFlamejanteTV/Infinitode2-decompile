/*      */ package com.prineside.tdi2.ui.actors;
/*      */ 
/*      */ import com.badlogic.gdx.Gdx;
/*      */ import com.badlogic.gdx.graphics.Color;
/*      */ import com.badlogic.gdx.graphics.Cursor;
/*      */ import com.badlogic.gdx.math.Interpolation;
/*      */ import com.badlogic.gdx.math.MathUtils;
/*      */ import com.badlogic.gdx.math.Rectangle;
/*      */ import com.badlogic.gdx.math.Vector2;
/*      */ import com.badlogic.gdx.utils.Align;
/*      */ import com.badlogic.gdx.utils.Array;
/*      */ import com.badlogic.gdx.utils.DelayedRemovalArray;
/*      */ import com.badlogic.gdx.utils.Null;
/*      */ import com.badlogic.gdx.utils.StringBuilder;
/*      */ import com.prineside.tdi2.Game;
/*      */ import com.prineside.tdi2.events.global.StartRender;
/*      */ import com.prineside.tdi2.scene2d.Action;
/*      */ import com.prineside.tdi2.scene2d.Actor;
/*      */ import com.prineside.tdi2.scene2d.EventListener;
/*      */ import com.prineside.tdi2.scene2d.InputEvent;
/*      */ import com.prineside.tdi2.scene2d.InputListener;
/*      */ import com.prineside.tdi2.scene2d.Touchable;
/*      */ import com.prineside.tdi2.scene2d.actions.Actions;
/*      */ import com.prineside.tdi2.scene2d.ui.Cell;
/*      */ import com.prineside.tdi2.scene2d.ui.Image;
/*      */ import com.prineside.tdi2.scene2d.ui.ScrollPane;
/*      */ import com.prineside.tdi2.scene2d.ui.Table;
/*      */ import com.prineside.tdi2.scene2d.utils.Drawable;
/*      */ import com.prineside.tdi2.ui.events.MoveToFrontListener;
/*      */ import com.prineside.tdi2.utils.IgnoreMethodOverloadLuaDefWarning;
/*      */ import com.prineside.tdi2.utils.InputVoid;
/*      */ import com.prineside.tdi2.utils.MaterialColor;
/*      */ import com.prineside.tdi2.utils.ObjectConsumer;
/*      */ import com.prineside.tdi2.utils.PackColor;
/*      */ import com.prineside.tdi2.utils.UiUtils;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ public class Window
/*      */   extends Table
/*      */ {
/*      */   private WindowStyle n;
/*      */   public Table headerLayout;
/*      */   public Label title;
/*      */   private ScrollPane o;
/*      */   public Table main;
/*      */   public float minWidth;
/*      */   public float minHeight;
/*   53 */   public float maxWidth = 4096.0F;
/*   54 */   public float maxHeight = 4096.0F;
/*      */   
/*      */   private Image[] p;
/*      */   
/*      */   protected boolean k;
/*      */   private boolean q = true;
/*      */   private boolean r = false;
/*      */   private boolean s = false;
/*   62 */   private int t = 1;
/*      */   
/*      */   private DelayedRemovalArray<WindowListener> u;
/*      */   private ObjectConsumer<ObjectConsumer<Boolean>> v;
/*   66 */   protected static final Rectangle l = new Rectangle();
/*   67 */   private static Vector2 w = new Vector2();
/*      */   
/*      */   public Window() {
/*   70 */     this(Game.i.assetManager.createDefaultWindowStyle());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Window(WindowStyle paramWindowStyle) {
/*   78 */     this.n = paramWindowStyle;
/*      */     
/*   80 */     if (paramWindowStyle.catchAllTouches) {
/*   81 */       addListener((EventListener)new InputVoid());
/*      */     }
/*      */     
/*      */     Image image;
/*   85 */     (image = new Image(paramWindowStyle.background)).setFillParent(true);
/*   86 */     addActor((Actor)image);
/*      */ 
/*      */     
/*   89 */     if (paramWindowStyle.headerBackground != null) {
/*   90 */       float f = getHeaderHeight();
/*      */       
/*   92 */       this.headerLayout = new Table();
/*   93 */       this.headerLayout.setTouchable(Touchable.enabled);
/*   94 */       add((Actor)this.headerLayout).fillX().expandX().fillY().row();
/*      */       
/*   96 */       this.headerLayout.background(paramWindowStyle.headerBackground);
/*      */       
/*   98 */       this.title = new Label("", paramWindowStyle.titleLabelStyle);
/*   99 */       this.headerLayout.add((Actor)this.title).expandX().fillX().height(f).padLeft(paramWindowStyle.defaultPadding);
/*      */       
/*  101 */       if (paramWindowStyle.closeButton == null) {
/*      */         PaddedImageButton paddedImageButton;
/*  103 */         (paddedImageButton = new PaddedImageButton((Drawable)Game.i.assetManager.getDrawable("icon-times"), this::close, Color.WHITE, MaterialColor.RED.P500, MaterialColor.RED.P300)).setIconSize(0.625F * f, 0.625F * f);
/*  104 */         paddedImageButton.setIconPosition(0.1875F * f, 0.1875F * f);
/*  105 */         this.headerLayout.add((Actor)paddedImageButton).size(f).padLeft(paramWindowStyle.defaultPadding).padRight(paramWindowStyle.defaultPadding * 0.5F);
/*      */       } else {
/*      */         PaddedImageButton paddedImageButton;
/*      */         
/*  109 */         (paddedImageButton = new PaddedImageButton(paramWindowStyle.closeButton, this::close, paramWindowStyle.closeButtonColor.getColorAtIndex(0), paramWindowStyle.closeButtonColor.getColorAtIndex(1), paramWindowStyle.closeButtonColor.getColorAtIndex(2))).setIconSize(f, f);
/*  110 */         this.headerLayout.add((Actor)paddedImageButton).size(f).padLeft(paramWindowStyle.defaultPadding);
/*      */       } 
/*      */     } 
/*      */     
/*  114 */     this.main = new Table();
/*  115 */     if (paramWindowStyle.scrollPaneStyle != null) {
/*  116 */       this.o = new ScrollPane((Actor)this.main, paramWindowStyle.scrollPaneStyle);
/*  117 */       this.o.setOverscroll(false, false);
/*  118 */       this.o.setFadeScrollBars(false);
/*  119 */       this.o.setName("Window content scroll");
/*  120 */       UiUtils.enableMouseMoveScrollFocus(this.o);
/*  121 */       add((Actor)this.o).grow().row();
/*      */     } else {
/*  123 */       add((Actor)this.main).grow().row();
/*      */     } 
/*      */     
/*  126 */     if (paramWindowStyle.resizeable) {
/*  127 */       setResizeable(true);
/*      */     }
/*  129 */     if (paramWindowStyle.draggable) {
/*  130 */       setDraggable(true);
/*      */     }
/*  132 */     this.k = paramWindowStyle.resizeHasMinSize;
/*      */     
/*  134 */     addListener((EventListener)new InputListener(this)
/*      */         {
/*      */           public boolean touchDown(InputEvent param1InputEvent, float param1Float1, float param1Float2, int param1Int1, int param1Int2) {
/*  137 */             this.a.bringToFront();
/*  138 */             return false;
/*      */           }
/*      */         });
/*      */     
/*  142 */     if (paramWindowStyle.alwaysOnTop) {
/*  143 */       addListener((EventListener)new MoveToFrontListener(this)
/*      */           {
/*      */             private int a;
/*      */             
/*      */             public void actorMovedToFront(MoveToFrontListener.MoveToFrontEvent param1MoveToFrontEvent, Actor param1Actor, boolean param1Boolean) {
/*  148 */               if (!param1Boolean) {
/*  149 */                 int i = Game.EVENTS.getListeners(StartRender.class).getEventsTriggered();
/*  150 */                 if (this.a != i) {
/*  151 */                   this.a = i;
/*  152 */                   param1MoveToFrontEvent.cancel();
/*  153 */                   this.b.bringToFront();
/*      */                 } 
/*      */               } 
/*      */             }
/*      */           });
/*      */     }
/*      */     
/*  160 */     setVisible(false);
/*      */     
/*  162 */     setTitle("Window-" + Integer.toHexString(hashCode()));
/*      */   }
/*      */   @Null
/*      */   public ScrollPane getScrollPane() {
/*  166 */     return this.o;
/*      */   }
/*      */   
/*      */   public void setCloseHandler(ObjectConsumer<ObjectConsumer<Boolean>> paramObjectConsumer) {
/*  170 */     this.v = paramObjectConsumer;
/*      */   }
/*      */   
/*      */   public WindowStyle getStyle() {
/*  174 */     return this.n;
/*      */   }
/*      */   
/*      */   public int getHeaderHeight() {
/*  178 */     if (this.n.headerBackground == null) {
/*  179 */       return 0;
/*      */     }
/*  181 */     return MathUtils.round(this.n.headerBackground.getMinHeight());
/*      */   }
/*      */ 
/*      */   
/*      */   public int getContentHeight() {
/*  186 */     return MathUtils.round(getHeight()) - getHeaderHeight();
/*      */   }
/*      */   
/*      */   public Cell<Actor> setContents(Actor paramActor) {
/*  190 */     this.main.clear();
/*  191 */     return this.main.add(paramActor).grow();
/*      */   }
/*      */   
/*      */   public Actor getContents() {
/*  195 */     return this.main.getChild(0);
/*      */   }
/*      */ 
/*      */   
/*      */   protected void sizeChanged() {
/*  200 */     super.sizeChanged();
/*  201 */     d();
/*      */   }
/*      */ 
/*      */   
/*      */   public void positionChanged() {
/*  206 */     super.positionChanged();
/*  207 */     a(WindowListener::moved);
/*      */   }
/*      */ 
/*      */   
/*      */   protected final void a() {
/*  212 */     super.a();
/*  213 */     d();
/*      */   }
/*      */   
/*      */   private void d() {
/*  217 */     e();
/*      */   }
/*      */   
/*      */   public void setResizeable(boolean paramBoolean) {
/*  221 */     if (paramBoolean) {
/*  222 */       if (this.p == null) {
/*  223 */         this.p = new Image[8];
/*  224 */         for (paramBoolean = false; paramBoolean < this.p.length; paramBoolean++) {
/*  225 */           this.p[paramBoolean] = new Image();
/*  226 */           addActor((Actor)this.p[paramBoolean]);
/*  227 */           this.p[paramBoolean].setTouchable(Touchable.enabled);
/*  228 */           this.p[paramBoolean].addListener((EventListener)new ResizeHandleListener(this, paramBoolean));
/*      */         } 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*  235 */         if (Game.i.cursorGraphics != null) {
/*  236 */           Game.i.cursorGraphics.setActorCustomMouseCursor((Actor)this.p[1], Cursor.SystemCursor.VerticalResize);
/*  237 */           Game.i.cursorGraphics.setActorCustomMouseCursor((Actor)this.p[6], Cursor.SystemCursor.VerticalResize);
/*  238 */           Game.i.cursorGraphics.setActorCustomMouseCursor((Actor)this.p[3], Cursor.SystemCursor.HorizontalResize);
/*  239 */           Game.i.cursorGraphics.setActorCustomMouseCursor((Actor)this.p[4], Cursor.SystemCursor.HorizontalResize);
/*  240 */           Game.i.cursorGraphics.setActorCustomMouseCursor((Actor)this.p[0], Cursor.SystemCursor.NWSEResize);
/*  241 */           Game.i.cursorGraphics.setActorCustomMouseCursor((Actor)this.p[7], Cursor.SystemCursor.NWSEResize);
/*  242 */           Game.i.cursorGraphics.setActorCustomMouseCursor((Actor)this.p[2], Cursor.SystemCursor.NESWResize);
/*  243 */           Game.i.cursorGraphics.setActorCustomMouseCursor((Actor)this.p[5], Cursor.SystemCursor.NESWResize);
/*      */         } 
/*      */       } 
/*  246 */       e(); return;
/*      */     } 
/*  248 */     if (this.p != null) {
/*  249 */       Image[] arrayOfImage; int i; byte b; for (i = (arrayOfImage = this.p).length, b = 0; b < i; b++) {
/*  250 */         Image image; (image = arrayOfImage[b]).remove();
/*      */       } 
/*  252 */       this.p = null;
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   public void setDraggable(boolean paramBoolean) {
/*  258 */     if (this.s != paramBoolean) {
/*  259 */       this.s = paramBoolean;
/*  260 */       if (paramBoolean) {
/*  261 */         if (this.headerLayout != null) {
/*  262 */           this.headerLayout.addListener((EventListener)new DragHandleListener(this)); return;
/*      */         } 
/*  264 */         addListener((EventListener)new DragHandleListener(this));
/*      */         return;
/*      */       } 
/*  267 */       if (this.headerLayout != null) {
/*  268 */         paramBoolean = false; while (true) { if (paramBoolean < (this.headerLayout.getListeners()).size) {
/*  269 */             if (this.headerLayout.getListeners().get(paramBoolean) instanceof DragHandleListener) {
/*  270 */               this.headerLayout.removeListener((EventListener)this.headerLayout.getListeners().get(paramBoolean)); break;
/*      */             }  paramBoolean++; continue;
/*      */           }  return; }
/*      */       
/*      */       } else {
/*  275 */         for (paramBoolean = false; paramBoolean < (getListeners()).size; paramBoolean++) {
/*  276 */           if (getListeners().get(paramBoolean) instanceof DragHandleListener) {
/*  277 */             removeListener((EventListener)getListeners().get(paramBoolean));
/*      */             return;
/*      */           } 
/*      */         } 
/*      */       } 
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   private void e() {
/*  287 */     if (this.p != null) {
/*  288 */       float f1 = this.n.resizeHandleSize;
/*  289 */       float f2 = this.n.resizeHandleOverlap;
/*  290 */       float f3 = this.n.resizeHandleSizeHeader;
/*  291 */       float f4 = this.n.resizeHandleOverlapHeader;
/*      */       
/*  293 */       this.p[0].setSize(f3, f3);
/*  294 */       this.p[0].setPosition(-f3 + f4, getHeight() - f4);
/*  295 */       this.p[1].setSize(getWidth() - f4 * 2.0F, f3);
/*  296 */       this.p[1].setPosition(f4, getHeight() - f4);
/*  297 */       this.p[2].setSize(f3, f3);
/*  298 */       this.p[2].setPosition(getWidth() - f4, getHeight() - f4);
/*      */       
/*  300 */       this.p[3].setSize(f1, getHeight() - f4 - f2);
/*  301 */       this.p[3].setPosition(-f1 + f2, f2);
/*      */       
/*  303 */       this.p[4].setSize(f1, getHeight() - f4 - f2);
/*  304 */       this.p[4].setPosition(getWidth() - f2, f2);
/*      */       
/*  306 */       this.p[5].setSize(f1, f1);
/*  307 */       this.p[5].setPosition(-f1 + f2, -f1 + f2);
/*      */       
/*  309 */       this.p[6].setSize(getWidth() - f2 * 2.0F, f1);
/*  310 */       this.p[6].setPosition(f2, -f1 + f2);
/*      */       
/*  312 */       this.p[7].setSize(f1, f1);
/*  313 */       this.p[7].setPosition(getWidth() - f2, -f1 + f2);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void flash() {
/*  323 */     setTransform(true);
/*  324 */     setOrigin(1);
/*  325 */     addAction((Action)Actions.sequence(
/*  326 */           (Action)Actions.scaleTo(1.1F, 0.9F, 0.1F, (Interpolation)Interpolation.pow2Out), 
/*  327 */           (Action)Actions.scaleTo(0.9F, 1.1F, 0.1F, (Interpolation)Interpolation.pow2), 
/*  328 */           (Action)Actions.scaleTo(1.0F, 1.0F, 0.07F, (Interpolation)Interpolation.pow2), 
/*  329 */           (Action)Actions.run(() -> setTransform(false))));
/*      */   }
/*      */ 
/*      */   
/*      */   public void bringToFront() {
/*  334 */     UiUtils.bringToFront((Actor)this);
/*      */   }
/*      */   
/*      */   public static Rectangle getBox(Actor paramActor, Rectangle paramRectangle) {
/*  338 */     return paramRectangle.set(paramActor.getX(), paramActor.getY(), paramActor.getWidth(), paramActor.getHeight());
/*      */   }
/*      */   
/*      */   public Rectangle getBox(Rectangle paramRectangle) {
/*  342 */     return getBox((Actor)this, paramRectangle);
/*      */   }
/*      */   
/*      */   public Rectangle getContentBox(Rectangle paramRectangle) {
/*  346 */     return getBox((Actor)this.main, paramRectangle);
/*      */   }
/*      */   
/*      */   public void addListener(WindowListener paramWindowListener) {
/*  350 */     if (this.u == null) {
/*  351 */       this.u = new DelayedRemovalArray(true, 1, WindowListener.class);
/*      */     }
/*  353 */     this.u.add(paramWindowListener);
/*      */   }
/*      */   
/*      */   public void removeListener(WindowListener paramWindowListener) {
/*  357 */     if (this.u != null) {
/*  358 */       this.u.removeValue(paramWindowListener, true);
/*      */     }
/*      */   }
/*      */   
/*      */   public Array<WindowListener> getWindowListeners() {
/*  363 */     return (Array<WindowListener>)this.u;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setTitle(CharSequence paramCharSequence) {
/*  370 */     if (this.title != null) {
/*  371 */       this.title.setText(paramCharSequence);
/*  372 */       this.title.setName("window-title-" + paramCharSequence);
/*      */     } 
/*  374 */     if (this.o != null) {
/*  375 */       this.o.setName("window-scroll-" + paramCharSequence);
/*      */     }
/*  377 */     this.main.setName("window-main-" + paramCharSequence);
/*      */   }
/*      */   
/*      */   public StringBuilder getTitle() {
/*  381 */     return (this.title == null) ? null : this.title.getText();
/*      */   }
/*      */   
/*      */   public void setAnimated(boolean paramBoolean) {
/*  385 */     this.q = paramBoolean;
/*      */   }
/*      */   
/*      */   public boolean isAnimated() {
/*  389 */     return this.q;
/*      */   }
/*      */   
/*      */   public boolean isResizeable() {
/*  393 */     return (this.p != null);
/*      */   }
/*      */   
/*      */   public void setAppearAlign(int paramInt) {
/*  397 */     this.t = paramInt;
/*      */   }
/*      */   
/*      */   public void alignToPoint(float paramFloat1, float paramFloat2, int paramInt) {
/*  401 */     float f1 = getWidth();
/*  402 */     float f2 = getHeight();
/*      */     
/*  404 */     switch (paramInt) {
/*      */       case 10:
/*  406 */         setPosition(paramFloat1, paramFloat2 - f2);
/*      */         return;
/*      */       case 18:
/*  409 */         setPosition(paramFloat1 - f1, paramFloat2 - f2);
/*      */         return;
/*      */       case 12:
/*  412 */         setPosition(paramFloat1, paramFloat2);
/*      */         return;
/*      */       case 20:
/*  415 */         setPosition(paramFloat1 - f1, paramFloat2);
/*      */         return;
/*      */       case 1:
/*  418 */         setPosition(paramFloat1 - f1 * 0.5F, paramFloat2 - f2 * 0.5F);
/*      */         return;
/*      */       case 2:
/*  421 */         setPosition(paramFloat1 - f1 * 0.5F, paramFloat2 - f2);
/*      */         return;
/*      */       case 4:
/*  424 */         setPosition(paramFloat1 - f1 * 0.5F, paramFloat2);
/*      */         return;
/*      */       case 8:
/*  427 */         setPosition(paramFloat1, paramFloat2 - f2 * 0.5F);
/*      */         return;
/*      */       case 16:
/*  430 */         setPosition(paramFloat1 - f1, paramFloat2 - f2 * 0.5F);
/*      */         break;
/*      */     } 
/*      */   }
/*      */   
/*      */   protected final void a(ObjectConsumer<WindowListener> paramObjectConsumer) {
/*  436 */     if (this.u != null) {
/*  437 */       this.u.begin();
/*  438 */       for (byte b = 0; b < this.u.size; b++) {
/*  439 */         paramObjectConsumer.accept(this.u.get(b));
/*      */       }
/*  441 */       this.u.end();
/*      */     } 
/*      */   }
/*      */   
/*      */   public void showAtCursor() {
/*  446 */     Vector2 vector2 = new Vector2(Gdx.input.getX(), Gdx.input.getY());
/*  447 */     Game.i.uiManager.stage.screenToStageCoordinates(vector2);
/*  448 */     showAtPointAligned(vector2.x, vector2.y, 1);
/*      */   }
/*      */   
/*      */   public void show() {
/*  452 */     clearActions();
/*  453 */     if (this.q) {
/*  454 */       setOrigin(this.t);
/*  455 */       setTransform(true);
/*  456 */       addAction((Action)Actions.sequence(
/*  457 */             (Action)Actions.scaleTo(0.0F, 0.0F), 
/*  458 */             (Action)Actions.scaleTo(1.0F, 1.0F, 0.08F), 
/*  459 */             (Action)Actions.run(() -> setTransform(false))));
/*      */     } else {
/*      */       
/*  462 */       setScale(1.0F);
/*  463 */       setTransform(false);
/*      */     } 
/*  465 */     clampWindowPosition();
/*      */     
/*  467 */     setVisible(true);
/*  468 */     this.r = true;
/*      */     
/*  470 */     bringToFront();
/*  471 */     a(WindowListener::shown);
/*      */   }
/*      */   
/*      */   public void showAtPoint(float paramFloat1, float paramFloat2) {
/*  475 */     alignToPoint(paramFloat1, paramFloat2, this.t);
/*  476 */     show();
/*      */   }
/*      */   
/*      */   public void showAtPointAligned(float paramFloat1, float paramFloat2, int paramInt) {
/*  480 */     setAppearAlign(paramInt);
/*  481 */     alignToPoint(paramFloat1, paramFloat2, paramInt);
/*  482 */     show();
/*      */   }
/*      */   
/*      */   public int getWindowAlign() {
/*  486 */     return this.t;
/*      */   }
/*      */   
/*      */   private void f() {
/*  490 */     this.r = false;
/*      */     
/*  492 */     clearActions();
/*  493 */     if (this.q) {
/*  494 */       setOrigin(this.t);
/*  495 */       setTransform(true);
/*  496 */       addAction((Action)Actions.sequence(
/*  497 */             (Action)Actions.scaleTo(0.0F, 0.0F, 0.08F), 
/*  498 */             (Action)Actions.run(() -> {
/*      */                 setTransform(false);
/*      */                 setVisible(false);
/*      */                 a(WindowListener::closed);
/*      */               })));
/*      */       return;
/*      */     } 
/*  505 */     setTransform(false);
/*  506 */     setVisible(false);
/*  507 */     a(WindowListener::closed);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void close() {
/*  518 */     if (!this.r)
/*  519 */       return;  if (this.v == null) {
/*  520 */       f(); return;
/*      */     } 
/*  522 */     this.v.accept(paramBoolean -> {
/*      */           if (paramBoolean.booleanValue()) {
/*      */             f();
/*      */           }
/*      */         });
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void fitToContentSimple() {
/*  535 */     fitToContent(this.t, true, true, false);
/*      */   }
/*      */   
/*      */   public void fitToContent(int paramInt, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3) {
/*  539 */     if (getStage() == null) {
/*  540 */       throw new IllegalStateException("Actor has no stage");
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*  545 */     float f1 = Align.isLeft(paramInt) ? getX() : (Align.isRight(paramInt) ? (getX() + getWidth()) : (getX() + getWidth() * 0.5F));
/*      */ 
/*      */     
/*  548 */     float f2 = Align.isBottom(paramInt) ? getY() : (Align.isTop(paramInt) ? (getY() + getHeight()) : (getY() + getHeight() * 0.5F));
/*      */     
/*  550 */     float f3 = getWidth();
/*  551 */     float f4 = getHeight();
/*      */     
/*  553 */     layout();
/*  554 */     pack();
/*  555 */     g();
/*      */     
/*  557 */     if (!paramBoolean2) {
/*  558 */       setHeight(f4);
/*      */     }
/*  560 */     if (!paramBoolean1) {
/*  561 */       setWidth(f3);
/*      */     }
/*  563 */     if (paramBoolean3 && getWidth() < f3) {
/*  564 */       setWidth(f3);
/*      */     }
/*  566 */     if (paramBoolean3 && getHeight() < f4) {
/*  567 */       setHeight(f4);
/*      */     }
/*      */     
/*  570 */     setPosition(f1, f2, paramInt);
/*      */     
/*  572 */     clampWindowPosition();
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public void setPositionByCorner(int paramInt, float paramFloat1, float paramFloat2) {
/*  578 */     paramFloat1 = Align.isLeft(paramInt) ? paramFloat1 : (Align.isRight(paramInt) ? (paramFloat1 - getWidth()) : (paramFloat1 - getWidth() * 0.5F));
/*      */ 
/*      */     
/*  581 */     float f = Align.isBottom(paramInt) ? paramFloat2 : (Align.isTop(paramInt) ? (paramFloat2 - getHeight()) : (paramFloat2 - getHeight() * 0.5F));
/*  582 */     setPosition(paramFloat1, f);
/*      */   }
/*      */   
/*      */   private void g() {
/*  586 */     if (getWidth() > getMaxWidth()) {
/*  587 */       setWidth(getMaxWidth());
/*      */     }
/*  589 */     if (getHeight() > getMaxHeight()) {
/*  590 */       setHeight(getMaxHeight());
/*      */     }
/*  592 */     if (getWidth() < getMinWidth()) {
/*  593 */       setWidth(getMinWidth());
/*      */     }
/*  595 */     if (getHeight() < getMinHeight()) {
/*  596 */       setHeight(getMinHeight());
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   @IgnoreMethodOverloadLuaDefWarning
/*      */   public void setPosition(float paramFloat1, float paramFloat2, int paramInt) {
/*  604 */     if (Align.isBottom(paramInt)) {
/*  605 */       paramFloat2 = paramFloat2;
/*  606 */     } else if (Align.isTop(paramInt)) {
/*  607 */       paramFloat2 -= getHeight();
/*      */     } else {
/*  609 */       paramFloat2 -= getHeight() * 0.5F;
/*      */     } 
/*  611 */     if (Align.isLeft(paramInt)) {
/*  612 */       paramFloat1 = paramFloat1;
/*  613 */     } else if (Align.isRight(paramInt)) {
/*  614 */       paramFloat1 -= getWidth();
/*      */     } else {
/*  616 */       paramFloat1 -= getWidth() * 0.5F;
/*      */     } 
/*  618 */     setPosition(paramFloat1, paramFloat2);
/*      */   }
/*      */   
/*      */   public boolean clampWindowPosition() {
/*  622 */     if (getParent() == null) return false;
/*      */     
/*  624 */     w.set(getParent().getWidth(), getParent().getHeight());
/*  625 */     Rectangle rectangle = moveIntoViewport(getBox(l), w);
/*  626 */     if (getX() != rectangle.x || getY() != rectangle.y) {
/*  627 */       setPosition(rectangle.x, rectangle.y);
/*  628 */       return true;
/*      */     } 
/*  630 */     return false;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public void act(float paramFloat) {
/*  636 */     clampWindowPosition();
/*  637 */     super.act(paramFloat);
/*      */   }
/*      */ 
/*      */   
/*      */   @IgnoreMethodOverloadLuaDefWarning
/*      */   public void setPosition(float paramFloat1, float paramFloat2) {
/*  643 */     super.setPosition(MathUtils.round(paramFloat1), MathUtils.round(paramFloat2));
/*      */   }
/*      */ 
/*      */   
/*      */   public void setSize(float paramFloat1, float paramFloat2) {
/*  648 */     if (paramFloat1 > getMaxWidth()) {
/*  649 */       paramFloat1 = getMaxWidth();
/*      */     }
/*  651 */     if (paramFloat2 > getMaxHeight()) {
/*  652 */       paramFloat2 = getMaxHeight();
/*      */     }
/*  654 */     if (paramFloat1 < getMinWidth()) {
/*  655 */       paramFloat1 = getMinWidth();
/*      */     }
/*  657 */     if (paramFloat2 < getMinHeight()) {
/*  658 */       paramFloat2 = getMinHeight();
/*      */     }
/*      */     
/*  661 */     super.setSize(MathUtils.round(paramFloat1), MathUtils.round(paramFloat2));
/*      */   }
/*      */ 
/*      */   
/*      */   public float getMinWidth() {
/*  666 */     return Math.max(this.minWidth, this.n.inheritWidgetMinSize ? super.getMinWidth() : 0.0F);
/*      */   }
/*      */ 
/*      */   
/*      */   public float getMinHeight() {
/*  671 */     return Math.max(this.minHeight, this.n.inheritWidgetMinSize ? super.getMinHeight() : 0.0F);
/*      */   }
/*      */ 
/*      */   
/*      */   public float getMaxWidth() {
/*  676 */     return Math.min(this.maxWidth, getStage().getWidth());
/*      */   }
/*      */ 
/*      */   
/*      */   public float getMaxHeight() {
/*  681 */     return Math.min(this.maxHeight, getStage().getHeight());
/*      */   }
/*      */   
/*  684 */   private static final Rectangle x = new Rectangle();
/*      */ 
/*      */   
/*      */   public String toString() {
/*  688 */     return getClass().getName() + "@" + Integer.toHexString(hashCode());
/*      */   }
/*      */   
/*      */   public static Rectangle moveIntoViewport(Rectangle paramRectangle, Vector2 paramVector2) {
/*  692 */     if (paramRectangle.x < 0.0F) paramRectangle.x = 0.0F; 
/*  693 */     if (paramRectangle.y < 0.0F) paramRectangle.y = 0.0F;
/*      */     
/*  695 */     x.set(paramRectangle);
/*  696 */     if (x.x < 0.0F) {
/*  697 */       x.x = 0.0F;
/*  698 */     } else if (x.x + x.width > paramVector2.x) {
/*  699 */       x.x = paramVector2.x - x.width;
/*      */     } 
/*      */     
/*  702 */     if (x.y < 0.0F) {
/*  703 */       x.y = 0.0F;
/*  704 */     } else if (x.y + x.height > paramVector2.y) {
/*  705 */       x.y = paramVector2.y - x.height;
/*      */     } 
/*      */     
/*  708 */     return x;
/*      */   }
/*      */ 
/*      */   
/*      */   public static interface WindowListener
/*      */   {
/*      */     void dragged();
/*      */ 
/*      */     
/*      */     void shown();
/*      */ 
/*      */     
/*      */     void closed();
/*      */     
/*      */     void resized();
/*      */     
/*      */     void moved();
/*      */     
/*      */     public static class Adapter
/*      */       implements WindowListener
/*      */     {
/*      */       public void dragged() {}
/*      */       
/*      */       public void shown() {}
/*      */       
/*      */       public void closed() {}
/*      */       
/*      */       public void resized() {}
/*      */       
/*      */       public void moved() {}
/*      */     }
/*      */   }
/*      */   
/*      */   protected class DragHandleListener
/*      */     extends InputListener
/*      */   {
/*      */     private float a;
/*      */     private float b;
/*      */     private float c;
/*      */     private float d;
/*      */     
/*      */     protected DragHandleListener(Window this$0) {}
/*      */     
/*      */     public boolean touchDown(InputEvent param1InputEvent, float param1Float1, float param1Float2, int param1Int1, int param1Int2) {
/*  752 */       if (param1Int2 == 0) {
/*  753 */         this.c = param1InputEvent.getStageX();
/*  754 */         this.d = param1InputEvent.getStageY();
/*  755 */         this.a = this.e.getX();
/*  756 */         this.b = this.e.getY();
/*  757 */         return true;
/*      */       } 
/*  759 */       return false;
/*      */     }
/*      */ 
/*      */     
/*      */     public void touchDragged(InputEvent param1InputEvent, float param1Float1, float param1Float2, int param1Int) {
/*  764 */       param1Float1 = param1InputEvent.getStageX() - this.c;
/*  765 */       float f = param1InputEvent.getStageY() - this.d;
/*      */       
/*  767 */       this.e.setPosition((int)(this.a + param1Float1), (int)(this.b + f));
/*  768 */       this.e.clampWindowPosition();
/*  769 */       this.e.a(Window.WindowListener::dragged);
/*      */     }
/*      */   }
/*      */   
/*      */   protected class ResizeHandleListener extends InputListener {
/*      */     private int a;
/*      */     private boolean b;
/*  776 */     private Rectangle c = new Rectangle();
/*  777 */     private Rectangle d = new Rectangle();
/*      */     private float e;
/*      */     private float f;
/*      */     
/*      */     public ResizeHandleListener(Window this$0, int param1Int) {
/*  782 */       this.a = param1Int;
/*      */     }
/*      */     
/*      */     private void a() {
/*  786 */       if (this.g.getParent() == null)
/*      */         return; 
/*  788 */       if (this.d.x < 0.0F) {
/*  789 */         this.d.width += this.d.x;
/*  790 */         this.d.x = 0.0F;
/*      */       } 
/*  792 */       if (this.d.y < 0.0F) {
/*  793 */         this.d.height += this.d.y;
/*  794 */         this.d.y = 0.0F;
/*      */       } 
/*  796 */       float f1 = this.g.getParent().getWidth();
/*  797 */       float f2 = this.g.getParent().getHeight();
/*  798 */       if (this.d.x + this.d.width > f1) {
/*  799 */         this.d.width -= this.d.x + this.d.width - f1;
/*      */       }
/*  801 */       if (this.d.y + this.d.height > f2) {
/*  802 */         this.d.height -= this.d.y + this.d.height - f2;
/*      */       }
/*      */       
/*  805 */       if (this.g.k) {
/*  806 */         if (this.d.width < this.g.getMinWidth()) {
/*  807 */           if (this.a == 0 || this.a == 3 || this.a == 5) {
/*  808 */             this.d.x -= this.g.getMinWidth() - this.d.width;
/*      */           }
/*  810 */           this.d.width = this.g.getMinWidth();
/*      */         } 
/*  812 */         if (this.d.height < this.g.getMinHeight()) {
/*  813 */           if (this.a == 5 || this.a == 6 || this.a == 7) {
/*  814 */             this.d.y -= this.g.getMinHeight() - this.d.height;
/*      */           }
/*  816 */           this.d.height = this.g.getMinHeight();
/*      */         } 
/*      */       } 
/*  819 */       if (this.d.width > this.g.getMaxWidth()) {
/*  820 */         if (this.a == 0 || this.a == 3 || this.a == 5) {
/*  821 */           this.d.x -= this.g.getMaxWidth() - this.d.width;
/*      */         }
/*  823 */         this.d.width = this.g.getMaxWidth();
/*      */       } 
/*  825 */       if (this.d.height > this.g.getMaxHeight()) {
/*  826 */         if (this.a == 5 || this.a == 6 || this.a == 7) {
/*  827 */           this.d.y -= this.g.getMaxHeight() - this.d.height;
/*      */         }
/*  829 */         this.d.height = this.g.getMaxHeight();
/*      */       } 
/*      */       
/*  832 */       this.g.setPosition(this.d.x, this.d.y);
/*  833 */       this.g.setSize(this.d.width, this.d.height);
/*  834 */       this.g.a(Window.WindowListener::resized);
/*      */     }
/*      */ 
/*      */     
/*      */     public boolean touchDown(InputEvent param1InputEvent, float param1Float1, float param1Float2, int param1Int1, int param1Int2) {
/*  839 */       if (param1Int2 == 0) {
/*  840 */         this.e = param1InputEvent.getStageX();
/*  841 */         this.f = param1InputEvent.getStageY();
/*  842 */         this.c.set(this.g.getBox(Window.l));
/*  843 */         this.d.set(this.c);
/*  844 */         this.b = true;
/*  845 */         return true;
/*      */       } 
/*      */       
/*  848 */       return false;
/*      */     }
/*      */ 
/*      */     
/*      */     public void touchDragged(InputEvent param1InputEvent, float param1Float1, float param1Float2, int param1Int) {
/*  853 */       if (this.b) {
/*  854 */         param1Float1 = param1InputEvent.getStageX() - this.e;
/*  855 */         float f = param1InputEvent.getStageY() - this.f;
/*  856 */         switch (this.a) {
/*      */           
/*      */           case 0:
/*  859 */             this.d.set(this.c);
/*  860 */             this.d.x += param1Float1;
/*  861 */             this.d.width -= param1Float1;
/*  862 */             this.d.height += f;
/*      */             break;
/*      */ 
/*      */           
/*      */           case 1:
/*  867 */             this.d.set(this.c);
/*  868 */             this.d.height += f;
/*      */             break;
/*      */ 
/*      */           
/*      */           case 2:
/*  873 */             this.d.set(this.c);
/*  874 */             this.d.width += param1Float1;
/*  875 */             this.d.height += f;
/*      */             break;
/*      */ 
/*      */           
/*      */           case 3:
/*  880 */             this.d.set(this.c);
/*  881 */             this.d.x += param1Float1;
/*  882 */             this.d.width -= param1Float1;
/*      */             break;
/*      */ 
/*      */           
/*      */           case 4:
/*  887 */             this.d.set(this.c);
/*  888 */             this.d.width += param1Float1;
/*      */             break;
/*      */ 
/*      */           
/*      */           case 5:
/*  893 */             this.d.set(this.c);
/*  894 */             this.d.x += param1Float1;
/*  895 */             this.d.y += f;
/*  896 */             this.d.width -= param1Float1;
/*  897 */             this.d.height -= f;
/*      */             break;
/*      */ 
/*      */           
/*      */           case 6:
/*  902 */             this.d.set(this.c);
/*  903 */             this.d.y += f;
/*  904 */             this.d.height -= f;
/*      */             break;
/*      */ 
/*      */           
/*      */           case 7:
/*  909 */             this.d.set(this.c);
/*  910 */             this.d.width += param1Float1;
/*  911 */             this.d.height -= f;
/*  912 */             this.d.y += f;
/*      */             break;
/*      */         } 
/*      */         
/*  916 */         a();
/*      */       } 
/*      */     }
/*      */ 
/*      */     
/*      */     public void touchUp(InputEvent param1InputEvent, float param1Float1, float param1Float2, int param1Int1, int param1Int2) {
/*  922 */       if (this.b) {
/*  923 */         this.b = false;
/*  924 */         this.g.clampWindowPosition();
/*      */       } 
/*      */     } }
/*      */   
/*      */   public static class WindowStyle {
/*      */     public boolean catchAllTouches = true;
/*      */     public Drawable background;
/*      */     public Drawable headerBackground;
/*      */     @Null
/*      */     public ScrollPane.ScrollPaneStyle scrollPaneStyle;
/*      */     public Label.LabelStyle titleLabelStyle;
/*  935 */     public float defaultPadding = 8.0F;
/*  936 */     public float resizeHandleSize = 8.0F;
/*  937 */     public float resizeHandleOverlap = 1.0F;
/*  938 */     public float resizeHandleSizeHeader = 13.0F;
/*  939 */     public float resizeHandleOverlapHeader = 3.0F;
/*      */     public boolean resizeable = false;
/*      */     public boolean draggable = true;
/*      */     public boolean resizeHasMinSize = true;
/*      */     public boolean alwaysOnTop = false;
/*      */     public boolean inheritWidgetMinSize = true;
/*      */     public Drawable closeButton;
/*  946 */     public PackColor closeButtonColor = new PackColor(Color.WHITE);
/*      */     
/*      */     public WindowStyle() {}
/*      */     
/*      */     public WindowStyle(WindowStyle param1WindowStyle) {
/*  951 */       this.catchAllTouches = param1WindowStyle.catchAllTouches;
/*  952 */       this.background = param1WindowStyle.background;
/*  953 */       this.headerBackground = param1WindowStyle.headerBackground;
/*  954 */       this.titleLabelStyle = param1WindowStyle.titleLabelStyle;
/*  955 */       this.defaultPadding = param1WindowStyle.defaultPadding;
/*  956 */       this.resizeHandleSize = param1WindowStyle.resizeHandleSize;
/*  957 */       this.resizeHandleOverlap = param1WindowStyle.resizeHandleOverlap;
/*  958 */       this.resizeHandleSizeHeader = param1WindowStyle.resizeHandleSizeHeader;
/*  959 */       this.resizeHandleOverlapHeader = param1WindowStyle.resizeHandleOverlapHeader;
/*  960 */       this.alwaysOnTop = param1WindowStyle.alwaysOnTop;
/*  961 */       this.scrollPaneStyle = param1WindowStyle.scrollPaneStyle;
/*  962 */       this.resizeable = param1WindowStyle.resizeable;
/*  963 */       this.draggable = param1WindowStyle.draggable;
/*  964 */       this.inheritWidgetMinSize = param1WindowStyle.inheritWidgetMinSize;
/*  965 */       this.resizeHasMinSize = param1WindowStyle.resizeHasMinSize;
/*  966 */       this.closeButton = param1WindowStyle.closeButton;
/*  967 */       this.closeButtonColor = param1WindowStyle.closeButtonColor;
/*      */     }
/*      */     
/*      */     public WindowStyle setCatchAllTouches(boolean param1Boolean) {
/*  971 */       this.catchAllTouches = param1Boolean;
/*  972 */       return this;
/*      */     }
/*      */     
/*      */     public WindowStyle setDraggable(boolean param1Boolean) {
/*  976 */       this.draggable = param1Boolean;
/*  977 */       return this;
/*      */     }
/*      */     
/*      */     public WindowStyle setAlwaysOnTop(boolean param1Boolean) {
/*  981 */       this.alwaysOnTop = param1Boolean;
/*  982 */       return this;
/*      */     }
/*      */     
/*      */     public WindowStyle setBackground(Drawable param1Drawable) {
/*  986 */       this.background = param1Drawable;
/*  987 */       return this;
/*      */     }
/*      */     
/*      */     public WindowStyle setHeaderBackground(Drawable param1Drawable) {
/*  991 */       this.headerBackground = param1Drawable;
/*  992 */       return this;
/*      */     }
/*      */     
/*      */     public WindowStyle setInheritWidgetMinSize(boolean param1Boolean) {
/*  996 */       this.inheritWidgetMinSize = param1Boolean;
/*  997 */       return this;
/*      */     }
/*      */     
/*      */     public WindowStyle setTitleLabelStyle(Label.LabelStyle param1LabelStyle) {
/* 1001 */       this.titleLabelStyle = param1LabelStyle;
/* 1002 */       return this;
/*      */     }
/*      */     
/*      */     public WindowStyle setDefaultPadding(float param1Float) {
/* 1006 */       this.defaultPadding = param1Float;
/* 1007 */       return this;
/*      */     }
/*      */     
/*      */     public WindowStyle setScrollPaneStyle(ScrollPane.ScrollPaneStyle param1ScrollPaneStyle) {
/* 1011 */       this.scrollPaneStyle = param1ScrollPaneStyle;
/* 1012 */       return this;
/*      */     }
/*      */     
/*      */     public WindowStyle setResizeable(boolean param1Boolean) {
/* 1016 */       this.resizeable = param1Boolean;
/* 1017 */       return this;
/*      */     }
/*      */     
/*      */     public WindowStyle setResizeHasMinSize(boolean param1Boolean) {
/* 1021 */       this.resizeHasMinSize = param1Boolean;
/* 1022 */       return this;
/*      */     }
/*      */   }
/*      */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi\\ui\actors\Window.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */