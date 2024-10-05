/*     */ package com.prineside.tdi2.scene2d;
/*     */ 
/*     */ import com.badlogic.gdx.Application;
/*     */ import com.badlogic.gdx.Gdx;
/*     */ import com.badlogic.gdx.InputAdapter;
/*     */ import com.badlogic.gdx.graphics.Camera;
/*     */ import com.badlogic.gdx.graphics.Color;
/*     */ import com.badlogic.gdx.graphics.g2d.Batch;
/*     */ import com.badlogic.gdx.graphics.g2d.SpriteBatch;
/*     */ import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
/*     */ import com.badlogic.gdx.math.Matrix4;
/*     */ import com.badlogic.gdx.math.Rectangle;
/*     */ import com.badlogic.gdx.math.Vector2;
/*     */ import com.badlogic.gdx.utils.Array;
/*     */ import com.badlogic.gdx.utils.Disposable;
/*     */ import com.badlogic.gdx.utils.Null;
/*     */ import com.badlogic.gdx.utils.Pool;
/*     */ import com.badlogic.gdx.utils.Pools;
/*     */ import com.badlogic.gdx.utils.SnapshotArray;
/*     */ import com.badlogic.gdx.utils.viewport.Viewport;
/*     */ import com.prineside.tdi2.managers.RenderingManager;
/*     */ import com.prineside.tdi2.scene2d.ui.Table;
/*     */ import com.prineside.tdi2.scene2d.utils.FocusListener;
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
/*     */ public class Stage
/*     */   extends InputAdapter
/*     */   implements Disposable
/*     */ {
/*     */   static boolean a;
/*     */   private Viewport c;
/*     */   private final Batch d;
/*     */   private boolean e;
/*     */   private Group f;
/*  72 */   private final Vector2 g = new Vector2();
/*  73 */   private final Actor[] h = new Actor[20];
/*  74 */   private final boolean[] i = new boolean[20];
/*  75 */   private final int[] j = new int[20]; private final int[] k = new int[20];
/*     */   
/*     */   private int l;
/*     */   private int m;
/*  79 */   final SnapshotArray<TouchFocus> b = new SnapshotArray(true, 4, TouchFocus.class); @Null
/*     */   private Actor n; @Null
/*     */   private Actor o; @Null
/*     */   private Actor p; private boolean q = true; private ShapeRenderer r; private boolean s; private boolean t;
/*     */   private boolean u;
/*  84 */   private Table.Debug v = Table.Debug.none;
/*  85 */   private final Color w = new Color(0.0F, 1.0F, 0.0F, 0.85F);
/*     */ 
/*     */ 
/*     */   
/*     */   public Stage(Viewport paramViewport) {
/*  90 */     this(paramViewport, (Batch)new SpriteBatch());
/*  91 */     this.e = true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Stage(Viewport paramViewport, Batch paramBatch) {
/*  98 */     if (paramViewport == null) throw new IllegalArgumentException("viewport cannot be null."); 
/*  99 */     if (paramBatch == null) throw new IllegalArgumentException("batch cannot be null."); 
/* 100 */     this.c = paramViewport;
/* 101 */     this.d = paramBatch;
/*     */     
/* 103 */     this.f = new Group();
/* 104 */     this.f.a(this);
/*     */     
/* 106 */     paramViewport.update(Gdx.graphics.getWidth(), Gdx.graphics.getHeight(), true);
/*     */   }
/*     */   
/*     */   public void draw() {
/*     */     Camera camera;
/* 111 */     (camera = this.c.getCamera()).update();
/*     */     
/* 113 */     if (!this.f.isVisible())
/*     */       return; 
/*     */     Batch batch;
/* 116 */     (batch = this.d).setProjectionMatrix(camera.combined);
/* 117 */     batch.begin();
/* 118 */     this.f.draw(batch, 1.0F);
/* 119 */     batch.end();
/*     */     
/* 121 */     if (a) a(); 
/*     */   }
/*     */   
/*     */   private void a() {
/* 125 */     if (this.r == null) {
/* 126 */       this.r = new ShapeRenderer(5000, RenderingManager.createDefaultShapeRendererShader());
/* 127 */       this.r.setAutoShapeType(true);
/*     */     } 
/*     */     
/* 130 */     if (this.t || this.u || this.v != Table.Debug.none)
/* 131 */     { screenToStageCoordinates(this.g.set(Gdx.input.getX(), Gdx.input.getY()));
/*     */       Actor actor;
/* 133 */       if ((actor = hit(this.g.x, this.g.y, true)) == null)
/*     */         return; 
/* 135 */       if (this.u && actor.b != null) actor = actor.b;
/*     */       
/* 137 */       if (this.v == Table.Debug.none) {
/* 138 */         actor.setDebug(true);
/*     */       } else {
/* 140 */         while (actor != null && 
/* 141 */           !(actor instanceof Table)) {
/* 142 */           actor = actor.b;
/*     */         }
/* 144 */         if (actor == null)
/* 145 */           return;  ((Table)actor).debug(this.v);
/*     */       } 
/*     */       
/* 148 */       if (this.s && actor instanceof Group) ((Group)actor).debugAll();
/*     */       
/* 150 */       a(this.f, actor); }
/*     */     
/* 152 */     else if (this.s) { this.f.debugAll(); }
/*     */ 
/*     */     
/* 155 */     Gdx.gl.glEnable(3042);
/* 156 */     this.r.setProjectionMatrix((this.c.getCamera()).combined);
/* 157 */     this.r.begin();
/* 158 */     this.f.drawDebug(this.r);
/* 159 */     this.r.end();
/* 160 */     Gdx.gl.glDisable(3042);
/*     */   }
/*     */ 
/*     */   
/*     */   private void a(Actor paramActor1, Actor paramActor2) {
/* 165 */     if (paramActor1 == paramActor2)
/* 166 */       return;  paramActor1.setDebug(false);
/* 167 */     if (paramActor1 instanceof Group) {
/* 168 */       SnapshotArray<Actor> snapshotArray = ((Group)paramActor1).j; byte b; int i;
/* 169 */       for (b = 0, i = snapshotArray.size; b < i; b++) {
/* 170 */         a((Actor)snapshotArray.get(b), paramActor2);
/*     */       }
/*     */     } 
/*     */   }
/*     */   
/*     */   public void act() {
/* 176 */     act(Math.min(Gdx.graphics.getDeltaTime(), 0.033333335F));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void act(float paramFloat) {
/*     */     byte b;
/*     */     int i;
/* 184 */     for (b = 0, i = this.h.length; b < i; b++) {
/* 185 */       Actor actor = this.h[b];
/* 186 */       if (this.i[b]) {
/*     */         
/* 188 */         this.h[b] = a(actor, this.j[b], this.k[b], b);
/* 189 */       } else if (actor != null) {
/*     */         
/* 191 */         this.h[b] = null;
/* 192 */         b(actor, this.j[b], this.k[b], b);
/*     */       } 
/*     */     } 
/*     */     
/*     */     Application.ApplicationType applicationType;
/*     */     
/* 198 */     if ((applicationType = Gdx.app.getType()) == Application.ApplicationType.Desktop || applicationType == Application.ApplicationType.Applet || applicationType == Application.ApplicationType.WebGL) {
/* 199 */       this.n = a(this.n, this.l, this.m, -1);
/*     */     }
/* 201 */     this.f.act(paramFloat);
/*     */   }
/*     */   
/*     */   @Null
/*     */   private Actor a(@Null Actor paramActor, int paramInt1, int paramInt2, int paramInt3) {
/* 206 */     screenToStageCoordinates(this.g.set(paramInt1, paramInt2));
/*     */     Actor actor;
/* 208 */     if ((actor = hit(this.g.x, this.g.y, true)) == paramActor) return paramActor;
/*     */ 
/*     */     
/* 211 */     if (paramActor != null) {
/*     */       InputEvent inputEvent;
/* 213 */       (inputEvent = (InputEvent)Pools.obtain(InputEvent.class)).setType(InputEvent.Type.exit);
/* 214 */       inputEvent.setStage(this);
/* 215 */       inputEvent.setStageX(this.g.x);
/* 216 */       inputEvent.setStageY(this.g.y);
/* 217 */       inputEvent.setPointer(paramInt3);
/* 218 */       inputEvent.setRelatedActor(actor);
/* 219 */       paramActor.fire(inputEvent);
/* 220 */       Pools.free(inputEvent);
/*     */     } 
/*     */ 
/*     */     
/* 224 */     if (actor != null) {
/*     */       InputEvent inputEvent;
/* 226 */       (inputEvent = (InputEvent)Pools.obtain(InputEvent.class)).setType(InputEvent.Type.enter);
/* 227 */       inputEvent.setStage(this);
/* 228 */       inputEvent.setStageX(this.g.x);
/* 229 */       inputEvent.setStageY(this.g.y);
/* 230 */       inputEvent.setPointer(paramInt3);
/* 231 */       inputEvent.setRelatedActor(paramActor);
/* 232 */       actor.fire(inputEvent);
/* 233 */       Pools.free(inputEvent);
/*     */     } 
/* 235 */     return actor;
/*     */   }
/*     */   
/*     */   private void b(Actor paramActor, int paramInt1, int paramInt2, int paramInt3) {
/* 239 */     screenToStageCoordinates(this.g.set(paramInt1, paramInt2));
/*     */     InputEvent inputEvent;
/* 241 */     (inputEvent = (InputEvent)Pools.obtain(InputEvent.class)).setType(InputEvent.Type.exit);
/* 242 */     inputEvent.setStage(this);
/* 243 */     inputEvent.setStageX(this.g.x);
/* 244 */     inputEvent.setStageY(this.g.y);
/* 245 */     inputEvent.setPointer(paramInt3);
/* 246 */     inputEvent.setRelatedActor(paramActor);
/* 247 */     paramActor.fire(inputEvent);
/* 248 */     Pools.free(inputEvent);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean touchDown(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
/* 254 */     if (!a(paramInt1, paramInt2)) return false;
/*     */     
/* 256 */     this.i[paramInt3] = true;
/* 257 */     this.j[paramInt3] = paramInt1;
/* 258 */     this.k[paramInt3] = paramInt2;
/*     */     
/* 260 */     screenToStageCoordinates(this.g.set(paramInt1, paramInt2));
/*     */     
/*     */     InputEvent inputEvent;
/* 263 */     (inputEvent = (InputEvent)Pools.obtain(InputEvent.class)).setType(InputEvent.Type.touchDown);
/* 264 */     inputEvent.setStage(this);
/* 265 */     inputEvent.setStageX(this.g.x);
/* 266 */     inputEvent.setStageY(this.g.y);
/* 267 */     inputEvent.setPointer(paramInt3);
/* 268 */     inputEvent.setButton(paramInt4);
/*     */     
/*     */     Actor actor;
/* 271 */     if ((actor = hit(this.g.x, this.g.y, true)) == null) {
/* 272 */       if (this.f.getTouchable() == Touchable.enabled) this.f.fire(inputEvent); 
/*     */     } else {
/* 274 */       actor.fire(inputEvent);
/*     */     } 
/* 276 */     boolean bool = inputEvent.isHandled();
/* 277 */     Pools.free(inputEvent);
/* 278 */     return bool;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean touchDragged(int paramInt1, int paramInt2, int paramInt3) {
/* 284 */     this.j[paramInt3] = paramInt1;
/* 285 */     this.k[paramInt3] = paramInt2;
/* 286 */     this.l = paramInt1;
/* 287 */     this.m = paramInt2;
/*     */     
/* 289 */     if (this.b.size == 0) return false;
/*     */     
/* 291 */     screenToStageCoordinates(this.g.set(paramInt1, paramInt2));
/*     */     
/*     */     InputEvent inputEvent;
/* 294 */     (inputEvent = (InputEvent)Pools.obtain(InputEvent.class)).setType(InputEvent.Type.touchDragged);
/* 295 */     inputEvent.setStage(this);
/* 296 */     inputEvent.setStageX(this.g.x);
/* 297 */     inputEvent.setStageY(this.g.y);
/* 298 */     inputEvent.setPointer(paramInt3);
/*     */     
/*     */     SnapshotArray<TouchFocus> snapshotArray;
/* 301 */     TouchFocus[] arrayOfTouchFocus = (TouchFocus[])(snapshotArray = this.b).begin(); byte b; int i;
/* 302 */     for (b = 0, i = snapshotArray.size; b < i; b++) {
/*     */       TouchFocus touchFocus;
/* 304 */       if ((touchFocus = arrayOfTouchFocus[b]).d == paramInt3 && 
/* 305 */         snapshotArray.contains(touchFocus, true)) {
/* 306 */         inputEvent.setTarget(touchFocus.c);
/* 307 */         inputEvent.setListenerActor(touchFocus.b);
/* 308 */         if (touchFocus.a.handle(inputEvent)) inputEvent.handle(); 
/*     */       } 
/* 310 */     }  snapshotArray.end();
/*     */     
/* 312 */     boolean bool = inputEvent.isHandled();
/* 313 */     Pools.free(inputEvent);
/* 314 */     return bool;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean touchUp(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
/* 320 */     this.i[paramInt3] = false;
/* 321 */     this.j[paramInt3] = paramInt1;
/* 322 */     this.k[paramInt3] = paramInt2;
/*     */     
/* 324 */     if (this.b.size == 0) return false;
/*     */     
/* 326 */     screenToStageCoordinates(this.g.set(paramInt1, paramInt2));
/*     */     
/*     */     InputEvent inputEvent;
/* 329 */     (inputEvent = (InputEvent)Pools.obtain(InputEvent.class)).setType(InputEvent.Type.touchUp);
/* 330 */     inputEvent.setStage(this);
/* 331 */     inputEvent.setStageX(this.g.x);
/* 332 */     inputEvent.setStageY(this.g.y);
/* 333 */     inputEvent.setPointer(paramInt3);
/* 334 */     inputEvent.setButton(paramInt4);
/*     */     
/*     */     SnapshotArray<TouchFocus> snapshotArray;
/* 337 */     TouchFocus[] arrayOfTouchFocus = (TouchFocus[])(snapshotArray = this.b).begin(); byte b; int i;
/* 338 */     for (b = 0, i = snapshotArray.size; b < i; b++) {
/*     */       TouchFocus touchFocus;
/* 340 */       if ((touchFocus = arrayOfTouchFocus[b]).d == paramInt3 && touchFocus.e == paramInt4 && 
/* 341 */         snapshotArray.removeValue(touchFocus, true)) {
/* 342 */         inputEvent.setTarget(touchFocus.c);
/* 343 */         inputEvent.setListenerActor(touchFocus.b);
/* 344 */         if (touchFocus.a.handle(inputEvent)) inputEvent.handle(); 
/* 345 */         Pools.free(touchFocus);
/*     */       } 
/* 347 */     }  snapshotArray.end();
/*     */     
/* 349 */     boolean bool = inputEvent.isHandled();
/* 350 */     Pools.free(inputEvent);
/* 351 */     return bool;
/*     */   }
/*     */   
/*     */   public boolean touchCancelled(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
/* 355 */     cancelTouchFocus();
/* 356 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean mouseMoved(int paramInt1, int paramInt2) {
/* 362 */     this.l = paramInt1;
/* 363 */     this.m = paramInt2;
/*     */     
/* 365 */     if (!a(paramInt1, paramInt2)) return false;
/*     */     
/* 367 */     screenToStageCoordinates(this.g.set(paramInt1, paramInt2));
/*     */     
/*     */     InputEvent inputEvent;
/* 370 */     (inputEvent = (InputEvent)Pools.obtain(InputEvent.class)).setType(InputEvent.Type.mouseMoved);
/* 371 */     inputEvent.setStage(this);
/* 372 */     inputEvent.setStageX(this.g.x);
/* 373 */     inputEvent.setStageY(this.g.y);
/*     */     
/*     */     Actor actor;
/* 376 */     if ((actor = hit(this.g.x, this.g.y, true)) == null) actor = this.f;
/*     */     
/* 378 */     actor.fire(inputEvent);
/* 379 */     boolean bool = inputEvent.isHandled();
/* 380 */     Pools.free(inputEvent);
/* 381 */     return bool;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean scrolled(float paramFloat1, float paramFloat2) {
/* 387 */     Actor actor = (this.p == null) ? this.f : this.p;
/*     */     
/* 389 */     screenToStageCoordinates(this.g.set(this.l, this.m));
/*     */     
/*     */     InputEvent inputEvent;
/* 392 */     (inputEvent = (InputEvent)Pools.obtain(InputEvent.class)).setType(InputEvent.Type.scrolled);
/* 393 */     inputEvent.setStage(this);
/* 394 */     inputEvent.setStageX(this.g.x);
/* 395 */     inputEvent.setStageY(this.g.y);
/* 396 */     inputEvent.setScrollAmountX(paramFloat1);
/* 397 */     inputEvent.setScrollAmountY(paramFloat2);
/* 398 */     actor.fire(inputEvent);
/* 399 */     boolean bool = inputEvent.isHandled();
/* 400 */     Pools.free(inputEvent);
/* 401 */     return bool;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean keyDown(int paramInt) {
/* 407 */     Actor actor = (this.o == null) ? this.f : this.o;
/*     */     InputEvent inputEvent;
/* 409 */     (inputEvent = (InputEvent)Pools.obtain(InputEvent.class)).setType(InputEvent.Type.keyDown);
/* 410 */     inputEvent.setStage(this);
/* 411 */     inputEvent.setKeyCode(paramInt);
/* 412 */     actor.fire(inputEvent);
/* 413 */     boolean bool = inputEvent.isHandled();
/* 414 */     Pools.free(inputEvent);
/* 415 */     return bool;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean keyUp(int paramInt) {
/* 421 */     Actor actor = (this.o == null) ? this.f : this.o;
/*     */     InputEvent inputEvent;
/* 423 */     (inputEvent = (InputEvent)Pools.obtain(InputEvent.class)).setType(InputEvent.Type.keyUp);
/* 424 */     inputEvent.setStage(this);
/* 425 */     inputEvent.setKeyCode(paramInt);
/* 426 */     actor.fire(inputEvent);
/* 427 */     boolean bool = inputEvent.isHandled();
/* 428 */     Pools.free(inputEvent);
/* 429 */     return bool;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean keyTyped(char paramChar) {
/* 435 */     Actor actor = (this.o == null) ? this.f : this.o;
/*     */     InputEvent inputEvent;
/* 437 */     (inputEvent = (InputEvent)Pools.obtain(InputEvent.class)).setType(InputEvent.Type.keyTyped);
/* 438 */     inputEvent.setStage(this);
/* 439 */     inputEvent.setCharacter(paramChar);
/* 440 */     actor.fire(inputEvent);
/* 441 */     boolean bool = inputEvent.isHandled();
/* 442 */     Pools.free(inputEvent);
/* 443 */     return bool;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void addTouchFocus(EventListener paramEventListener, Actor paramActor1, Actor paramActor2, int paramInt1, int paramInt2) {
/*     */     TouchFocus touchFocus;
/* 452 */     (touchFocus = (TouchFocus)Pools.obtain(TouchFocus.class)).b = paramActor1;
/* 453 */     touchFocus.c = paramActor2;
/* 454 */     touchFocus.a = paramEventListener;
/* 455 */     touchFocus.d = paramInt1;
/* 456 */     touchFocus.e = paramInt2;
/* 457 */     this.b.add(touchFocus);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void removeTouchFocus(EventListener paramEventListener, Actor paramActor1, Actor paramActor2, int paramInt1, int paramInt2) {
/*     */     SnapshotArray<TouchFocus> snapshotArray;
/* 464 */     for (int i = (snapshotArray = this.b).size - 1; i >= 0; i--) {
/*     */       TouchFocus touchFocus;
/* 466 */       if ((touchFocus = (TouchFocus)snapshotArray.get(i)).a == paramEventListener && touchFocus.b == paramActor1 && touchFocus.c == paramActor2 && touchFocus.d == paramInt1 && touchFocus.e == paramInt2) {
/*     */         
/* 468 */         snapshotArray.removeIndex(i);
/* 469 */         Pools.free(touchFocus);
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void cancelTouchFocus(Actor paramActor) {
/* 479 */     InputEvent inputEvent = null;
/*     */     SnapshotArray<TouchFocus> snapshotArray;
/* 481 */     TouchFocus[] arrayOfTouchFocus = (TouchFocus[])(snapshotArray = this.b).begin(); byte b; int i;
/* 482 */     for (b = 0, i = snapshotArray.size; b < i; b++) {
/*     */       TouchFocus touchFocus;
/* 484 */       if ((touchFocus = arrayOfTouchFocus[b]).b == paramActor && 
/* 485 */         snapshotArray.removeValue(touchFocus, true)) {
/*     */         
/* 487 */         if (inputEvent == null) {
/*     */           
/* 489 */           (inputEvent = (InputEvent)Pools.obtain(InputEvent.class)).setType(InputEvent.Type.touchUp);
/* 490 */           inputEvent.setStage(this);
/* 491 */           inputEvent.setStageX(-2.1474836E9F);
/* 492 */           inputEvent.setStageY(-2.1474836E9F);
/*     */         } 
/*     */         
/* 495 */         inputEvent.setTarget(touchFocus.c);
/* 496 */         inputEvent.setListenerActor(touchFocus.b);
/* 497 */         inputEvent.setPointer(touchFocus.d);
/* 498 */         inputEvent.setButton(touchFocus.e);
/* 499 */         touchFocus.a.handle(inputEvent);
/*     */       } 
/*     */     } 
/* 502 */     snapshotArray.end();
/*     */     
/* 504 */     if (inputEvent != null) Pools.free(inputEvent);
/*     */   
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void cancelTouchFocus() {
/* 511 */     cancelTouchFocusExcept(null, null);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void cancelTouchFocusExcept(@Null EventListener paramEventListener, @Null Actor paramActor) {
/*     */     InputEvent inputEvent;
/* 518 */     (inputEvent = (InputEvent)Pools.obtain(InputEvent.class)).setType(InputEvent.Type.touchUp);
/* 519 */     inputEvent.setStage(this);
/* 520 */     inputEvent.setStageX(-2.1474836E9F);
/* 521 */     inputEvent.setStageY(-2.1474836E9F);
/*     */ 
/*     */     
/*     */     SnapshotArray<TouchFocus> snapshotArray;
/*     */     
/* 526 */     TouchFocus[] arrayOfTouchFocus = (TouchFocus[])(snapshotArray = this.b).begin(); byte b; int i;
/* 527 */     for (b = 0, i = snapshotArray.size; b < i; b++) {
/*     */       TouchFocus touchFocus;
/* 529 */       if (((touchFocus = arrayOfTouchFocus[b]).a != paramEventListener || touchFocus.b != paramActor) && 
/* 530 */         snapshotArray.removeValue(touchFocus, true)) {
/* 531 */         inputEvent.setTarget(touchFocus.c);
/* 532 */         inputEvent.setListenerActor(touchFocus.b);
/* 533 */         inputEvent.setPointer(touchFocus.d);
/* 534 */         inputEvent.setButton(touchFocus.e);
/* 535 */         touchFocus.a.handle(inputEvent);
/*     */       } 
/*     */     } 
/* 538 */     snapshotArray.end();
/*     */     
/* 540 */     Pools.free(inputEvent);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void addActor(Actor paramActor) {
/* 546 */     this.f.addActor(paramActor);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void addAction(Action paramAction) {
/* 552 */     this.f.addAction(paramAction);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public Array<Actor> getActors() {
/* 558 */     return (Array<Actor>)this.f.j;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean addListener(EventListener paramEventListener) {
/* 564 */     return this.f.addListener(paramEventListener);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean removeListener(EventListener paramEventListener) {
/* 570 */     return this.f.removeListener(paramEventListener);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean addCaptureListener(EventListener paramEventListener) {
/* 576 */     return this.f.addCaptureListener(paramEventListener);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean removeCaptureListener(EventListener paramEventListener) {
/* 582 */     return this.f.removeCaptureListener(paramEventListener);
/*     */   }
/*     */ 
/*     */   
/*     */   protected final void a(Actor paramActor) {
/*     */     byte b;
/*     */     int i;
/* 589 */     for (b = 0, i = this.h.length; b < i; b++) {
/* 590 */       if (paramActor == this.h[b]) {
/* 591 */         this.h[b] = null;
/* 592 */         b(paramActor, this.j[b], this.k[b], b);
/*     */       } 
/*     */     } 
/*     */     
/* 596 */     if (paramActor == this.n) {
/* 597 */       this.n = null;
/* 598 */       b(paramActor, this.l, this.m, -1);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void clear() {
/* 604 */     unfocusAll();
/* 605 */     this.f.clear();
/*     */   }
/*     */ 
/*     */   
/*     */   public void unfocusAll() {
/* 610 */     setScrollFocus(null);
/* 611 */     setKeyboardFocus(null);
/* 612 */     cancelTouchFocus();
/*     */   }
/*     */ 
/*     */   
/*     */   public void unfocus(Actor paramActor) {
/* 617 */     cancelTouchFocus(paramActor);
/* 618 */     if (this.p != null && this.p.isDescendantOf(paramActor)) setScrollFocus(null); 
/* 619 */     if (this.o != null && this.o.isDescendantOf(paramActor)) setKeyboardFocus(null);
/*     */   
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setKeyboardFocus(@Null Actor paramActor) {
/* 626 */     if (this.o == paramActor) return true; 
/*     */     FocusListener.FocusEvent focusEvent;
/* 628 */     (focusEvent = (FocusListener.FocusEvent)Pools.obtain(FocusListener.FocusEvent.class)).setStage(this);
/* 629 */     focusEvent.setType(FocusListener.FocusEvent.Type.keyboard);
/*     */     Actor actor;
/* 631 */     if ((actor = this.o) != null) {
/* 632 */       focusEvent.setFocused(false);
/* 633 */       focusEvent.setRelatedActor(paramActor);
/* 634 */       actor.fire((Event)focusEvent);
/*     */     } 
/*     */     boolean bool;
/* 637 */     if (bool = !focusEvent.isCancelled() ? true : false) {
/* 638 */       this.o = paramActor;
/* 639 */       if (paramActor != null) {
/* 640 */         focusEvent.setFocused(true);
/* 641 */         focusEvent.setRelatedActor(actor);
/* 642 */         paramActor.fire((Event)focusEvent);
/*     */         
/* 644 */         if (!(bool = !focusEvent.isCancelled() ? true : false)) this.o = actor; 
/*     */       } 
/*     */     } 
/* 647 */     Pools.free(focusEvent);
/* 648 */     return bool;
/*     */   }
/*     */ 
/*     */   
/*     */   @Null
/*     */   public Actor getKeyboardFocus() {
/* 654 */     return this.o;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setScrollFocus(@Null Actor paramActor) {
/* 661 */     if (this.p == paramActor) return true; 
/*     */     FocusListener.FocusEvent focusEvent;
/* 663 */     (focusEvent = (FocusListener.FocusEvent)Pools.obtain(FocusListener.FocusEvent.class)).setStage(this);
/* 664 */     focusEvent.setType(FocusListener.FocusEvent.Type.scroll);
/*     */     Actor actor;
/* 666 */     if ((actor = this.p) != null) {
/* 667 */       focusEvent.setFocused(false);
/* 668 */       focusEvent.setRelatedActor(paramActor);
/* 669 */       actor.fire((Event)focusEvent);
/*     */     } 
/*     */     boolean bool;
/* 672 */     if (bool = !focusEvent.isCancelled() ? true : false) {
/* 673 */       this.p = paramActor;
/* 674 */       if (paramActor != null) {
/* 675 */         focusEvent.setFocused(true);
/* 676 */         focusEvent.setRelatedActor(actor);
/* 677 */         paramActor.fire((Event)focusEvent);
/*     */         
/* 679 */         if (!(bool = !focusEvent.isCancelled() ? true : false)) this.p = actor; 
/*     */       } 
/*     */     } 
/* 682 */     Pools.free(focusEvent);
/* 683 */     return bool;
/*     */   }
/*     */ 
/*     */   
/*     */   @Null
/*     */   public Actor getScrollFocus() {
/* 689 */     return this.p;
/*     */   }
/*     */   
/*     */   public Batch getBatch() {
/* 693 */     return this.d;
/*     */   }
/*     */   
/*     */   public Viewport getViewport() {
/* 697 */     return this.c;
/*     */   }
/*     */   
/*     */   public void setViewport(Viewport paramViewport) {
/* 701 */     this.c = paramViewport;
/*     */   }
/*     */ 
/*     */   
/*     */   public float getWidth() {
/* 706 */     return this.c.getWorldWidth();
/*     */   }
/*     */ 
/*     */   
/*     */   public float getHeight() {
/* 711 */     return this.c.getWorldHeight();
/*     */   }
/*     */ 
/*     */   
/*     */   public Camera getCamera() {
/* 716 */     return this.c.getCamera();
/*     */   }
/*     */ 
/*     */   
/*     */   public Group getRoot() {
/* 721 */     return this.f;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setRoot(Group paramGroup) {
/* 727 */     if (paramGroup.b != null) paramGroup.b.removeActor(paramGroup, false); 
/* 728 */     this.f = paramGroup;
/* 729 */     paramGroup.a((Group)null);
/* 730 */     paramGroup.a(this);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Null
/*     */   public Actor hit(float paramFloat1, float paramFloat2, boolean paramBoolean) {
/* 739 */     this.f.parentToLocalCoordinates(this.g.set(paramFloat1, paramFloat2));
/* 740 */     return this.f.hit(this.g.x, this.g.y, paramBoolean);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public Vector2 screenToStageCoordinates(Vector2 paramVector2) {
/* 746 */     this.c.unproject(paramVector2);
/* 747 */     return paramVector2;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public Vector2 stageToScreenCoordinates(Vector2 paramVector2) {
/* 753 */     this.c.project(paramVector2);
/* 754 */     paramVector2.y = Gdx.graphics.getHeight() - paramVector2.y;
/* 755 */     return paramVector2;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Vector2 toScreenCoordinates(Vector2 paramVector2, Matrix4 paramMatrix4) {
/* 763 */     return this.c.toScreenCoordinates(paramVector2, paramMatrix4);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void calculateScissors(Rectangle paramRectangle1, Rectangle paramRectangle2) {
/*     */     Matrix4 matrix4;
/* 770 */     if (this.r != null && this.r.isDrawing()) {
/* 771 */       matrix4 = this.r.getTransformMatrix();
/*     */     } else {
/* 773 */       matrix4 = this.d.getTransformMatrix();
/* 774 */     }  this.c.calculateScissors(matrix4, paramRectangle1, paramRectangle2);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setActionsRequestRendering(boolean paramBoolean) {
/* 781 */     this.q = paramBoolean;
/*     */   }
/*     */   
/*     */   public boolean getActionsRequestRendering() {
/* 785 */     return this.q;
/*     */   }
/*     */ 
/*     */   
/*     */   public Color getDebugColor() {
/* 790 */     return this.w;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setDebugInvisible(boolean paramBoolean) {}
/*     */ 
/*     */ 
/*     */   
/*     */   public void setDebugAll(boolean paramBoolean) {
/* 800 */     if (this.s == paramBoolean)
/* 801 */       return;  this.s = paramBoolean;
/* 802 */     if (paramBoolean) {
/* 803 */       a = true; return;
/*     */     } 
/* 805 */     this.f.setDebug(false, true);
/*     */   }
/*     */   
/*     */   public boolean isDebugAll() {
/* 809 */     return this.s;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setDebugUnderMouse(boolean paramBoolean) {
/* 814 */     if (this.t == paramBoolean)
/* 815 */       return;  this.t = paramBoolean;
/* 816 */     if (paramBoolean) {
/* 817 */       a = true; return;
/*     */     } 
/* 819 */     this.f.setDebug(false, true);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setDebugParentUnderMouse(boolean paramBoolean) {
/* 825 */     if (this.u == paramBoolean)
/* 826 */       return;  this.u = paramBoolean;
/* 827 */     if (paramBoolean) {
/* 828 */       a = true; return;
/*     */     } 
/* 830 */     this.f.setDebug(false, true);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setDebugTableUnderMouse(@Null Table.Debug paramDebug) {
/* 837 */     if (paramDebug == null) paramDebug = Table.Debug.none; 
/* 838 */     if (this.v == paramDebug)
/* 839 */       return;  this.v = paramDebug;
/* 840 */     if (paramDebug != Table.Debug.none) {
/* 841 */       a = true; return;
/*     */     } 
/* 843 */     this.f.setDebug(false, true);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setDebugTableUnderMouse(boolean paramBoolean) {
/* 849 */     setDebugTableUnderMouse(paramBoolean ? Table.Debug.all : Table.Debug.none);
/*     */   }
/*     */   
/*     */   public void dispose() {
/* 853 */     clear();
/* 854 */     if (this.e) this.d.dispose(); 
/* 855 */     if (this.r != null) this.r.dispose();
/*     */   
/*     */   }
/*     */ 
/*     */   
/*     */   private boolean a(int paramInt1, int paramInt2) {
/* 861 */     int i, j = (i = this.c.getScreenX()) + this.c.getScreenWidth();
/*     */     
/* 863 */     int k, m = (k = this.c.getScreenY()) + this.c.getScreenHeight();
/* 864 */     paramInt2 = Gdx.graphics.getHeight() - 1 - paramInt2;
/* 865 */     return (paramInt1 >= i && paramInt1 < j && paramInt2 >= k && paramInt2 < m);
/*     */   }
/*     */   
/*     */   public static final class TouchFocus implements Pool.Poolable {
/*     */     EventListener a;
/*     */     Actor b;
/*     */     Actor c;
/*     */     int d;
/*     */     int e;
/*     */     
/*     */     public final void reset() {
/* 876 */       this.b = null;
/* 877 */       this.a = null;
/* 878 */       this.c = null;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\scene2d\Stage.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */