/*     */ package com.badlogic.gdx.scenes.scene2d;
/*     */ 
/*     */ import com.badlogic.gdx.Application;
/*     */ import com.badlogic.gdx.Gdx;
/*     */ import com.badlogic.gdx.InputAdapter;
/*     */ import com.badlogic.gdx.graphics.Camera;
/*     */ import com.badlogic.gdx.graphics.Color;
/*     */ import com.badlogic.gdx.graphics.OrthographicCamera;
/*     */ import com.badlogic.gdx.graphics.g2d.Batch;
/*     */ import com.badlogic.gdx.graphics.g2d.SpriteBatch;
/*     */ import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
/*     */ import com.badlogic.gdx.math.Matrix4;
/*     */ import com.badlogic.gdx.math.Rectangle;
/*     */ import com.badlogic.gdx.math.Vector2;
/*     */ import com.badlogic.gdx.scenes.scene2d.ui.Table;
/*     */ import com.badlogic.gdx.scenes.scene2d.utils.FocusListener;
/*     */ import com.badlogic.gdx.utils.Array;
/*     */ import com.badlogic.gdx.utils.Disposable;
/*     */ import com.badlogic.gdx.utils.Null;
/*     */ import com.badlogic.gdx.utils.Pool;
/*     */ import com.badlogic.gdx.utils.Pools;
/*     */ import com.badlogic.gdx.utils.Scaling;
/*     */ import com.badlogic.gdx.utils.SnapshotArray;
/*     */ import com.badlogic.gdx.utils.viewport.ScalingViewport;
/*     */ import com.badlogic.gdx.utils.viewport.Viewport;
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
/*     */   static boolean debug;
/*     */   private Viewport viewport;
/*     */   private final Batch batch;
/*     */   private boolean ownsBatch;
/*     */   private Group root;
/*  74 */   private final Vector2 tempCoords = new Vector2();
/*  75 */   private final Actor[] pointerOverActors = new Actor[20];
/*  76 */   private final boolean[] pointerTouched = new boolean[20];
/*  77 */   private final int[] pointerScreenX = new int[20]; private int mouseScreenX; private int mouseScreenY; @Null private Actor mouseOverActor; private final int[] pointerScreenY = new int[20]; @Null
/*     */   private Actor keyboardFocus;
/*     */   @Null
/*     */   private Actor scrollFocus;
/*  81 */   final SnapshotArray<TouchFocus> touchFocuses = new SnapshotArray(true, 4, TouchFocus.class); private boolean actionsRequestRendering = true; private ShapeRenderer debugShapes;
/*     */   private boolean debugInvisible;
/*     */   private boolean debugAll;
/*     */   private boolean debugUnderMouse;
/*     */   private boolean debugParentUnderMouse;
/*  86 */   private Table.Debug debugTableUnderMouse = Table.Debug.none;
/*  87 */   private final Color debugColor = new Color(0.0F, 1.0F, 0.0F, 0.85F);
/*     */ 
/*     */ 
/*     */   
/*     */   public Stage() {
/*  92 */     this((Viewport)new ScalingViewport(Scaling.stretch, Gdx.graphics.getWidth(), Gdx.graphics.getHeight(), (Camera)new OrthographicCamera()), (Batch)new SpriteBatch());
/*     */     
/*  94 */     this.ownsBatch = true;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public Stage(Viewport paramViewport) {
/* 100 */     this(paramViewport, (Batch)new SpriteBatch());
/* 101 */     this.ownsBatch = true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Stage(Viewport paramViewport, Batch paramBatch) {
/* 108 */     if (paramViewport == null) throw new IllegalArgumentException("viewport cannot be null."); 
/* 109 */     if (paramBatch == null) throw new IllegalArgumentException("batch cannot be null."); 
/* 110 */     this.viewport = paramViewport;
/* 111 */     this.batch = paramBatch;
/*     */     
/* 113 */     this.root = new Group();
/* 114 */     this.root.setStage(this);
/*     */     
/* 116 */     paramViewport.update(Gdx.graphics.getWidth(), Gdx.graphics.getHeight(), true);
/*     */   }
/*     */   
/*     */   public void draw() {
/*     */     Camera camera;
/* 121 */     (camera = this.viewport.getCamera()).update();
/*     */     
/* 123 */     if (!this.root.isVisible())
/*     */       return; 
/*     */     Batch batch;
/* 126 */     (batch = this.batch).setProjectionMatrix(camera.combined);
/* 127 */     batch.begin();
/* 128 */     this.root.draw(batch, 1.0F);
/* 129 */     batch.end();
/*     */     
/* 131 */     if (debug) drawDebug(); 
/*     */   }
/*     */   
/*     */   private void drawDebug() {
/* 135 */     if (this.debugShapes == null) {
/* 136 */       this.debugShapes = new ShapeRenderer();
/* 137 */       this.debugShapes.setAutoShapeType(true);
/*     */     } 
/*     */     
/* 140 */     if (this.debugUnderMouse || this.debugParentUnderMouse || this.debugTableUnderMouse != Table.Debug.none)
/* 141 */     { screenToStageCoordinates(this.tempCoords.set(Gdx.input.getX(), Gdx.input.getY()));
/*     */       Actor actor;
/* 143 */       if ((actor = hit(this.tempCoords.x, this.tempCoords.y, true)) == null)
/*     */         return; 
/* 145 */       if (this.debugParentUnderMouse && actor.parent != null) actor = actor.parent;
/*     */       
/* 147 */       if (this.debugTableUnderMouse == Table.Debug.none) {
/* 148 */         actor.setDebug(true);
/*     */       } else {
/* 150 */         while (actor != null && 
/* 151 */           !(actor instanceof Table)) {
/* 152 */           actor = actor.parent;
/*     */         }
/* 154 */         if (actor == null)
/* 155 */           return;  ((Table)actor).debug(this.debugTableUnderMouse);
/*     */       } 
/*     */       
/* 158 */       if (this.debugAll && actor instanceof Group) ((Group)actor).debugAll();
/*     */       
/* 160 */       disableDebug(this.root, actor); }
/*     */     
/* 162 */     else if (this.debugAll) { this.root.debugAll(); }
/*     */ 
/*     */     
/* 165 */     Gdx.gl.glEnable(3042);
/* 166 */     this.debugShapes.setProjectionMatrix((this.viewport.getCamera()).combined);
/* 167 */     this.debugShapes.begin();
/* 168 */     this.root.drawDebug(this.debugShapes);
/* 169 */     this.debugShapes.end();
/* 170 */     Gdx.gl.glDisable(3042);
/*     */   }
/*     */ 
/*     */   
/*     */   private void disableDebug(Actor paramActor1, Actor paramActor2) {
/* 175 */     if (paramActor1 == paramActor2)
/* 176 */       return;  paramActor1.setDebug(false);
/* 177 */     if (paramActor1 instanceof Group) {
/* 178 */       SnapshotArray<Actor> snapshotArray = ((Group)paramActor1).children; byte b; int i;
/* 179 */       for (b = 0, i = snapshotArray.size; b < i; b++) {
/* 180 */         disableDebug((Actor)snapshotArray.get(b), paramActor2);
/*     */       }
/*     */     } 
/*     */   }
/*     */   
/*     */   public void act() {
/* 186 */     act(Math.min(Gdx.graphics.getDeltaTime(), 0.033333335F));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void act(float paramFloat) {
/*     */     byte b;
/*     */     int i;
/* 194 */     for (b = 0, i = this.pointerOverActors.length; b < i; b++) {
/* 195 */       Actor actor = this.pointerOverActors[b];
/* 196 */       if (this.pointerTouched[b]) {
/*     */         
/* 198 */         this.pointerOverActors[b] = fireEnterAndExit(actor, this.pointerScreenX[b], this.pointerScreenY[b], b);
/* 199 */       } else if (actor != null) {
/*     */         
/* 201 */         this.pointerOverActors[b] = null;
/* 202 */         fireExit(actor, this.pointerScreenX[b], this.pointerScreenY[b], b);
/*     */       } 
/*     */     } 
/*     */     
/*     */     Application.ApplicationType applicationType;
/*     */     
/* 208 */     if ((applicationType = Gdx.app.getType()) == Application.ApplicationType.Desktop || applicationType == Application.ApplicationType.Applet || applicationType == Application.ApplicationType.WebGL) {
/* 209 */       this.mouseOverActor = fireEnterAndExit(this.mouseOverActor, this.mouseScreenX, this.mouseScreenY, -1);
/*     */     }
/* 211 */     this.root.act(paramFloat);
/*     */   }
/*     */   
/*     */   @Null
/*     */   private Actor fireEnterAndExit(@Null Actor paramActor, int paramInt1, int paramInt2, int paramInt3) {
/* 216 */     screenToStageCoordinates(this.tempCoords.set(paramInt1, paramInt2));
/*     */     Actor actor;
/* 218 */     if ((actor = hit(this.tempCoords.x, this.tempCoords.y, true)) == paramActor) return paramActor;
/*     */ 
/*     */     
/* 221 */     if (paramActor != null) {
/*     */       InputEvent inputEvent;
/* 223 */       (inputEvent = (InputEvent)Pools.obtain(InputEvent.class)).setType(InputEvent.Type.exit);
/* 224 */       inputEvent.setStage(this);
/* 225 */       inputEvent.setStageX(this.tempCoords.x);
/* 226 */       inputEvent.setStageY(this.tempCoords.y);
/* 227 */       inputEvent.setPointer(paramInt3);
/* 228 */       inputEvent.setRelatedActor(actor);
/* 229 */       paramActor.fire(inputEvent);
/* 230 */       Pools.free(inputEvent);
/*     */     } 
/*     */ 
/*     */     
/* 234 */     if (actor != null) {
/*     */       InputEvent inputEvent;
/* 236 */       (inputEvent = (InputEvent)Pools.obtain(InputEvent.class)).setType(InputEvent.Type.enter);
/* 237 */       inputEvent.setStage(this);
/* 238 */       inputEvent.setStageX(this.tempCoords.x);
/* 239 */       inputEvent.setStageY(this.tempCoords.y);
/* 240 */       inputEvent.setPointer(paramInt3);
/* 241 */       inputEvent.setRelatedActor(paramActor);
/* 242 */       actor.fire(inputEvent);
/* 243 */       Pools.free(inputEvent);
/*     */     } 
/* 245 */     return actor;
/*     */   }
/*     */   
/*     */   private void fireExit(Actor paramActor, int paramInt1, int paramInt2, int paramInt3) {
/* 249 */     screenToStageCoordinates(this.tempCoords.set(paramInt1, paramInt2));
/*     */     InputEvent inputEvent;
/* 251 */     (inputEvent = (InputEvent)Pools.obtain(InputEvent.class)).setType(InputEvent.Type.exit);
/* 252 */     inputEvent.setStage(this);
/* 253 */     inputEvent.setStageX(this.tempCoords.x);
/* 254 */     inputEvent.setStageY(this.tempCoords.y);
/* 255 */     inputEvent.setPointer(paramInt3);
/* 256 */     inputEvent.setRelatedActor(paramActor);
/* 257 */     paramActor.fire(inputEvent);
/* 258 */     Pools.free(inputEvent);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean touchDown(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
/* 264 */     if (!isInsideViewport(paramInt1, paramInt2)) return false;
/*     */     
/* 266 */     this.pointerTouched[paramInt3] = true;
/* 267 */     this.pointerScreenX[paramInt3] = paramInt1;
/* 268 */     this.pointerScreenY[paramInt3] = paramInt2;
/*     */     
/* 270 */     screenToStageCoordinates(this.tempCoords.set(paramInt1, paramInt2));
/*     */     
/*     */     InputEvent inputEvent;
/* 273 */     (inputEvent = (InputEvent)Pools.obtain(InputEvent.class)).setType(InputEvent.Type.touchDown);
/* 274 */     inputEvent.setStage(this);
/* 275 */     inputEvent.setStageX(this.tempCoords.x);
/* 276 */     inputEvent.setStageY(this.tempCoords.y);
/* 277 */     inputEvent.setPointer(paramInt3);
/* 278 */     inputEvent.setButton(paramInt4);
/*     */     
/*     */     Actor actor;
/* 281 */     if ((actor = hit(this.tempCoords.x, this.tempCoords.y, true)) == null) {
/* 282 */       if (this.root.getTouchable() == Touchable.enabled) this.root.fire(inputEvent); 
/*     */     } else {
/* 284 */       actor.fire(inputEvent);
/*     */     } 
/* 286 */     boolean bool = inputEvent.isHandled();
/* 287 */     Pools.free(inputEvent);
/* 288 */     return bool;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean touchDragged(int paramInt1, int paramInt2, int paramInt3) {
/* 294 */     this.pointerScreenX[paramInt3] = paramInt1;
/* 295 */     this.pointerScreenY[paramInt3] = paramInt2;
/* 296 */     this.mouseScreenX = paramInt1;
/* 297 */     this.mouseScreenY = paramInt2;
/*     */     
/* 299 */     if (this.touchFocuses.size == 0) return false;
/*     */     
/* 301 */     screenToStageCoordinates(this.tempCoords.set(paramInt1, paramInt2));
/*     */     
/*     */     InputEvent inputEvent;
/* 304 */     (inputEvent = (InputEvent)Pools.obtain(InputEvent.class)).setType(InputEvent.Type.touchDragged);
/* 305 */     inputEvent.setStage(this);
/* 306 */     inputEvent.setStageX(this.tempCoords.x);
/* 307 */     inputEvent.setStageY(this.tempCoords.y);
/* 308 */     inputEvent.setPointer(paramInt3);
/*     */     
/*     */     SnapshotArray<TouchFocus> snapshotArray;
/* 311 */     TouchFocus[] arrayOfTouchFocus = (TouchFocus[])(snapshotArray = this.touchFocuses).begin(); byte b; int i;
/* 312 */     for (b = 0, i = snapshotArray.size; b < i; b++) {
/*     */       TouchFocus touchFocus;
/* 314 */       if ((touchFocus = arrayOfTouchFocus[b]).pointer == paramInt3 && 
/* 315 */         snapshotArray.contains(touchFocus, true)) {
/* 316 */         inputEvent.setTarget(touchFocus.target);
/* 317 */         inputEvent.setListenerActor(touchFocus.listenerActor);
/* 318 */         if (touchFocus.listener.handle(inputEvent)) inputEvent.handle(); 
/*     */       } 
/* 320 */     }  snapshotArray.end();
/*     */     
/* 322 */     boolean bool = inputEvent.isHandled();
/* 323 */     Pools.free(inputEvent);
/* 324 */     return bool;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean touchUp(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
/* 330 */     this.pointerTouched[paramInt3] = false;
/* 331 */     this.pointerScreenX[paramInt3] = paramInt1;
/* 332 */     this.pointerScreenY[paramInt3] = paramInt2;
/*     */     
/* 334 */     if (this.touchFocuses.size == 0) return false;
/*     */     
/* 336 */     screenToStageCoordinates(this.tempCoords.set(paramInt1, paramInt2));
/*     */     
/*     */     InputEvent inputEvent;
/* 339 */     (inputEvent = (InputEvent)Pools.obtain(InputEvent.class)).setType(InputEvent.Type.touchUp);
/* 340 */     inputEvent.setStage(this);
/* 341 */     inputEvent.setStageX(this.tempCoords.x);
/* 342 */     inputEvent.setStageY(this.tempCoords.y);
/* 343 */     inputEvent.setPointer(paramInt3);
/* 344 */     inputEvent.setButton(paramInt4);
/*     */     
/*     */     SnapshotArray<TouchFocus> snapshotArray;
/* 347 */     TouchFocus[] arrayOfTouchFocus = (TouchFocus[])(snapshotArray = this.touchFocuses).begin(); byte b; int i;
/* 348 */     for (b = 0, i = snapshotArray.size; b < i; b++) {
/*     */       TouchFocus touchFocus;
/* 350 */       if ((touchFocus = arrayOfTouchFocus[b]).pointer == paramInt3 && touchFocus.button == paramInt4 && 
/* 351 */         snapshotArray.removeValue(touchFocus, true)) {
/* 352 */         inputEvent.setTarget(touchFocus.target);
/* 353 */         inputEvent.setListenerActor(touchFocus.listenerActor);
/* 354 */         if (touchFocus.listener.handle(inputEvent)) inputEvent.handle(); 
/* 355 */         Pools.free(touchFocus);
/*     */       } 
/* 357 */     }  snapshotArray.end();
/*     */     
/* 359 */     boolean bool = inputEvent.isHandled();
/* 360 */     Pools.free(inputEvent);
/* 361 */     return bool;
/*     */   }
/*     */   
/*     */   public boolean touchCancelled(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
/* 365 */     cancelTouchFocus();
/* 366 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean mouseMoved(int paramInt1, int paramInt2) {
/* 372 */     this.mouseScreenX = paramInt1;
/* 373 */     this.mouseScreenY = paramInt2;
/*     */     
/* 375 */     if (!isInsideViewport(paramInt1, paramInt2)) return false;
/*     */     
/* 377 */     screenToStageCoordinates(this.tempCoords.set(paramInt1, paramInt2));
/*     */     
/*     */     InputEvent inputEvent;
/* 380 */     (inputEvent = (InputEvent)Pools.obtain(InputEvent.class)).setType(InputEvent.Type.mouseMoved);
/* 381 */     inputEvent.setStage(this);
/* 382 */     inputEvent.setStageX(this.tempCoords.x);
/* 383 */     inputEvent.setStageY(this.tempCoords.y);
/*     */     
/*     */     Actor actor;
/* 386 */     if ((actor = hit(this.tempCoords.x, this.tempCoords.y, true)) == null) actor = this.root;
/*     */     
/* 388 */     actor.fire(inputEvent);
/* 389 */     boolean bool = inputEvent.isHandled();
/* 390 */     Pools.free(inputEvent);
/* 391 */     return bool;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean scrolled(float paramFloat1, float paramFloat2) {
/* 397 */     Actor actor = (this.scrollFocus == null) ? this.root : this.scrollFocus;
/*     */     
/* 399 */     screenToStageCoordinates(this.tempCoords.set(this.mouseScreenX, this.mouseScreenY));
/*     */     
/*     */     InputEvent inputEvent;
/* 402 */     (inputEvent = (InputEvent)Pools.obtain(InputEvent.class)).setType(InputEvent.Type.scrolled);
/* 403 */     inputEvent.setStage(this);
/* 404 */     inputEvent.setStageX(this.tempCoords.x);
/* 405 */     inputEvent.setStageY(this.tempCoords.y);
/* 406 */     inputEvent.setScrollAmountX(paramFloat1);
/* 407 */     inputEvent.setScrollAmountY(paramFloat2);
/* 408 */     actor.fire(inputEvent);
/* 409 */     boolean bool = inputEvent.isHandled();
/* 410 */     Pools.free(inputEvent);
/* 411 */     return bool;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean keyDown(int paramInt) {
/* 417 */     Actor actor = (this.keyboardFocus == null) ? this.root : this.keyboardFocus;
/*     */     InputEvent inputEvent;
/* 419 */     (inputEvent = (InputEvent)Pools.obtain(InputEvent.class)).setType(InputEvent.Type.keyDown);
/* 420 */     inputEvent.setStage(this);
/* 421 */     inputEvent.setKeyCode(paramInt);
/* 422 */     actor.fire(inputEvent);
/* 423 */     boolean bool = inputEvent.isHandled();
/* 424 */     Pools.free(inputEvent);
/* 425 */     return bool;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean keyUp(int paramInt) {
/* 431 */     Actor actor = (this.keyboardFocus == null) ? this.root : this.keyboardFocus;
/*     */     InputEvent inputEvent;
/* 433 */     (inputEvent = (InputEvent)Pools.obtain(InputEvent.class)).setType(InputEvent.Type.keyUp);
/* 434 */     inputEvent.setStage(this);
/* 435 */     inputEvent.setKeyCode(paramInt);
/* 436 */     actor.fire(inputEvent);
/* 437 */     boolean bool = inputEvent.isHandled();
/* 438 */     Pools.free(inputEvent);
/* 439 */     return bool;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean keyTyped(char paramChar) {
/* 445 */     Actor actor = (this.keyboardFocus == null) ? this.root : this.keyboardFocus;
/*     */     InputEvent inputEvent;
/* 447 */     (inputEvent = (InputEvent)Pools.obtain(InputEvent.class)).setType(InputEvent.Type.keyTyped);
/* 448 */     inputEvent.setStage(this);
/* 449 */     inputEvent.setCharacter(paramChar);
/* 450 */     actor.fire(inputEvent);
/* 451 */     boolean bool = inputEvent.isHandled();
/* 452 */     Pools.free(inputEvent);
/* 453 */     return bool;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void addTouchFocus(EventListener paramEventListener, Actor paramActor1, Actor paramActor2, int paramInt1, int paramInt2) {
/*     */     TouchFocus touchFocus;
/* 462 */     (touchFocus = (TouchFocus)Pools.obtain(TouchFocus.class)).listenerActor = paramActor1;
/* 463 */     touchFocus.target = paramActor2;
/* 464 */     touchFocus.listener = paramEventListener;
/* 465 */     touchFocus.pointer = paramInt1;
/* 466 */     touchFocus.button = paramInt2;
/* 467 */     this.touchFocuses.add(touchFocus);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void removeTouchFocus(EventListener paramEventListener, Actor paramActor1, Actor paramActor2, int paramInt1, int paramInt2) {
/*     */     SnapshotArray<TouchFocus> snapshotArray;
/* 474 */     for (int i = (snapshotArray = this.touchFocuses).size - 1; i >= 0; i--) {
/*     */       TouchFocus touchFocus;
/* 476 */       if ((touchFocus = (TouchFocus)snapshotArray.get(i)).listener == paramEventListener && touchFocus.listenerActor == paramActor1 && touchFocus.target == paramActor2 && touchFocus.pointer == paramInt1 && touchFocus.button == paramInt2) {
/*     */         
/* 478 */         snapshotArray.removeIndex(i);
/* 479 */         Pools.free(touchFocus);
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void cancelTouchFocus(Actor paramActor) {
/* 489 */     InputEvent inputEvent = null;
/*     */     SnapshotArray<TouchFocus> snapshotArray;
/* 491 */     TouchFocus[] arrayOfTouchFocus = (TouchFocus[])(snapshotArray = this.touchFocuses).begin(); byte b; int i;
/* 492 */     for (b = 0, i = snapshotArray.size; b < i; b++) {
/*     */       TouchFocus touchFocus;
/* 494 */       if ((touchFocus = arrayOfTouchFocus[b]).listenerActor == paramActor && 
/* 495 */         snapshotArray.removeValue(touchFocus, true)) {
/*     */         
/* 497 */         if (inputEvent == null) {
/*     */           
/* 499 */           (inputEvent = (InputEvent)Pools.obtain(InputEvent.class)).setType(InputEvent.Type.touchUp);
/* 500 */           inputEvent.setStage(this);
/* 501 */           inputEvent.setStageX(-2.1474836E9F);
/* 502 */           inputEvent.setStageY(-2.1474836E9F);
/*     */         } 
/*     */         
/* 505 */         inputEvent.setTarget(touchFocus.target);
/* 506 */         inputEvent.setListenerActor(touchFocus.listenerActor);
/* 507 */         inputEvent.setPointer(touchFocus.pointer);
/* 508 */         inputEvent.setButton(touchFocus.button);
/* 509 */         touchFocus.listener.handle(inputEvent);
/*     */       } 
/*     */     } 
/* 512 */     snapshotArray.end();
/*     */     
/* 514 */     if (inputEvent != null) Pools.free(inputEvent);
/*     */   
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void cancelTouchFocus() {
/* 521 */     cancelTouchFocusExcept(null, null);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void cancelTouchFocusExcept(@Null EventListener paramEventListener, @Null Actor paramActor) {
/*     */     InputEvent inputEvent;
/* 528 */     (inputEvent = (InputEvent)Pools.obtain(InputEvent.class)).setType(InputEvent.Type.touchUp);
/* 529 */     inputEvent.setStage(this);
/* 530 */     inputEvent.setStageX(-2.1474836E9F);
/* 531 */     inputEvent.setStageY(-2.1474836E9F);
/*     */ 
/*     */     
/*     */     SnapshotArray<TouchFocus> snapshotArray;
/*     */     
/* 536 */     TouchFocus[] arrayOfTouchFocus = (TouchFocus[])(snapshotArray = this.touchFocuses).begin(); byte b; int i;
/* 537 */     for (b = 0, i = snapshotArray.size; b < i; b++) {
/*     */       TouchFocus touchFocus;
/* 539 */       if (((touchFocus = arrayOfTouchFocus[b]).listener != paramEventListener || touchFocus.listenerActor != paramActor) && 
/* 540 */         snapshotArray.removeValue(touchFocus, true)) {
/* 541 */         inputEvent.setTarget(touchFocus.target);
/* 542 */         inputEvent.setListenerActor(touchFocus.listenerActor);
/* 543 */         inputEvent.setPointer(touchFocus.pointer);
/* 544 */         inputEvent.setButton(touchFocus.button);
/* 545 */         touchFocus.listener.handle(inputEvent);
/*     */       } 
/*     */     } 
/* 548 */     snapshotArray.end();
/*     */     
/* 550 */     Pools.free(inputEvent);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void addActor(Actor paramActor) {
/* 556 */     this.root.addActor(paramActor);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void addAction(Action paramAction) {
/* 562 */     this.root.addAction(paramAction);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public Array<Actor> getActors() {
/* 568 */     return (Array<Actor>)this.root.children;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean addListener(EventListener paramEventListener) {
/* 574 */     return this.root.addListener(paramEventListener);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean removeListener(EventListener paramEventListener) {
/* 580 */     return this.root.removeListener(paramEventListener);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean addCaptureListener(EventListener paramEventListener) {
/* 586 */     return this.root.addCaptureListener(paramEventListener);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean removeCaptureListener(EventListener paramEventListener) {
/* 592 */     return this.root.removeCaptureListener(paramEventListener);
/*     */   }
/*     */ 
/*     */   
/*     */   protected void actorRemoved(Actor paramActor) {
/*     */     byte b;
/*     */     int i;
/* 599 */     for (b = 0, i = this.pointerOverActors.length; b < i; b++) {
/* 600 */       if (paramActor == this.pointerOverActors[b]) {
/* 601 */         this.pointerOverActors[b] = null;
/* 602 */         fireExit(paramActor, this.pointerScreenX[b], this.pointerScreenY[b], b);
/*     */       } 
/*     */     } 
/*     */     
/* 606 */     if (paramActor == this.mouseOverActor) {
/* 607 */       this.mouseOverActor = null;
/* 608 */       fireExit(paramActor, this.mouseScreenX, this.mouseScreenY, -1);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void clear() {
/* 614 */     unfocusAll();
/* 615 */     this.root.clear();
/*     */   }
/*     */ 
/*     */   
/*     */   public void unfocusAll() {
/* 620 */     setScrollFocus(null);
/* 621 */     setKeyboardFocus(null);
/* 622 */     cancelTouchFocus();
/*     */   }
/*     */ 
/*     */   
/*     */   public void unfocus(Actor paramActor) {
/* 627 */     cancelTouchFocus(paramActor);
/* 628 */     if (this.scrollFocus != null && this.scrollFocus.isDescendantOf(paramActor)) setScrollFocus(null); 
/* 629 */     if (this.keyboardFocus != null && this.keyboardFocus.isDescendantOf(paramActor)) setKeyboardFocus(null);
/*     */   
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setKeyboardFocus(@Null Actor paramActor) {
/* 636 */     if (this.keyboardFocus == paramActor) return true; 
/*     */     FocusListener.FocusEvent focusEvent;
/* 638 */     (focusEvent = (FocusListener.FocusEvent)Pools.obtain(FocusListener.FocusEvent.class)).setStage(this);
/* 639 */     focusEvent.setType(FocusListener.FocusEvent.Type.keyboard);
/*     */     Actor actor;
/* 641 */     if ((actor = this.keyboardFocus) != null) {
/* 642 */       focusEvent.setFocused(false);
/* 643 */       focusEvent.setRelatedActor(paramActor);
/* 644 */       actor.fire((Event)focusEvent);
/*     */     } 
/*     */     boolean bool;
/* 647 */     if (bool = !focusEvent.isCancelled() ? true : false) {
/* 648 */       this.keyboardFocus = paramActor;
/* 649 */       if (paramActor != null) {
/* 650 */         focusEvent.setFocused(true);
/* 651 */         focusEvent.setRelatedActor(actor);
/* 652 */         paramActor.fire((Event)focusEvent);
/*     */         
/* 654 */         if (!(bool = !focusEvent.isCancelled() ? true : false)) this.keyboardFocus = actor; 
/*     */       } 
/*     */     } 
/* 657 */     Pools.free(focusEvent);
/* 658 */     return bool;
/*     */   }
/*     */ 
/*     */   
/*     */   @Null
/*     */   public Actor getKeyboardFocus() {
/* 664 */     return this.keyboardFocus;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setScrollFocus(@Null Actor paramActor) {
/* 671 */     if (this.scrollFocus == paramActor) return true; 
/*     */     FocusListener.FocusEvent focusEvent;
/* 673 */     (focusEvent = (FocusListener.FocusEvent)Pools.obtain(FocusListener.FocusEvent.class)).setStage(this);
/* 674 */     focusEvent.setType(FocusListener.FocusEvent.Type.scroll);
/*     */     Actor actor;
/* 676 */     if ((actor = this.scrollFocus) != null) {
/* 677 */       focusEvent.setFocused(false);
/* 678 */       focusEvent.setRelatedActor(paramActor);
/* 679 */       actor.fire((Event)focusEvent);
/*     */     } 
/*     */     boolean bool;
/* 682 */     if (bool = !focusEvent.isCancelled() ? true : false) {
/* 683 */       this.scrollFocus = paramActor;
/* 684 */       if (paramActor != null) {
/* 685 */         focusEvent.setFocused(true);
/* 686 */         focusEvent.setRelatedActor(actor);
/* 687 */         paramActor.fire((Event)focusEvent);
/*     */         
/* 689 */         if (!(bool = !focusEvent.isCancelled() ? true : false)) this.scrollFocus = actor; 
/*     */       } 
/*     */     } 
/* 692 */     Pools.free(focusEvent);
/* 693 */     return bool;
/*     */   }
/*     */ 
/*     */   
/*     */   @Null
/*     */   public Actor getScrollFocus() {
/* 699 */     return this.scrollFocus;
/*     */   }
/*     */   
/*     */   public Batch getBatch() {
/* 703 */     return this.batch;
/*     */   }
/*     */   
/*     */   public Viewport getViewport() {
/* 707 */     return this.viewport;
/*     */   }
/*     */   
/*     */   public void setViewport(Viewport paramViewport) {
/* 711 */     this.viewport = paramViewport;
/*     */   }
/*     */ 
/*     */   
/*     */   public float getWidth() {
/* 716 */     return this.viewport.getWorldWidth();
/*     */   }
/*     */ 
/*     */   
/*     */   public float getHeight() {
/* 721 */     return this.viewport.getWorldHeight();
/*     */   }
/*     */ 
/*     */   
/*     */   public Camera getCamera() {
/* 726 */     return this.viewport.getCamera();
/*     */   }
/*     */ 
/*     */   
/*     */   public Group getRoot() {
/* 731 */     return this.root;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setRoot(Group paramGroup) {
/* 737 */     if (paramGroup.parent != null) paramGroup.parent.removeActor(paramGroup, false); 
/* 738 */     this.root = paramGroup;
/* 739 */     paramGroup.setParent(null);
/* 740 */     paramGroup.setStage(this);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Null
/*     */   public Actor hit(float paramFloat1, float paramFloat2, boolean paramBoolean) {
/* 749 */     this.root.parentToLocalCoordinates(this.tempCoords.set(paramFloat1, paramFloat2));
/* 750 */     return this.root.hit(this.tempCoords.x, this.tempCoords.y, paramBoolean);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public Vector2 screenToStageCoordinates(Vector2 paramVector2) {
/* 756 */     this.viewport.unproject(paramVector2);
/* 757 */     return paramVector2;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public Vector2 stageToScreenCoordinates(Vector2 paramVector2) {
/* 763 */     this.viewport.project(paramVector2);
/* 764 */     paramVector2.y = Gdx.graphics.getHeight() - paramVector2.y;
/* 765 */     return paramVector2;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Vector2 toScreenCoordinates(Vector2 paramVector2, Matrix4 paramMatrix4) {
/* 773 */     return this.viewport.toScreenCoordinates(paramVector2, paramMatrix4);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void calculateScissors(Rectangle paramRectangle1, Rectangle paramRectangle2) {
/*     */     Matrix4 matrix4;
/* 780 */     if (this.debugShapes != null && this.debugShapes.isDrawing()) {
/* 781 */       matrix4 = this.debugShapes.getTransformMatrix();
/*     */     } else {
/* 783 */       matrix4 = this.batch.getTransformMatrix();
/* 784 */     }  this.viewport.calculateScissors(matrix4, paramRectangle1, paramRectangle2);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setActionsRequestRendering(boolean paramBoolean) {
/* 791 */     this.actionsRequestRendering = paramBoolean;
/*     */   }
/*     */   
/*     */   public boolean getActionsRequestRendering() {
/* 795 */     return this.actionsRequestRendering;
/*     */   }
/*     */ 
/*     */   
/*     */   public Color getDebugColor() {
/* 800 */     return this.debugColor;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setDebugInvisible(boolean paramBoolean) {
/* 805 */     this.debugInvisible = paramBoolean;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setDebugAll(boolean paramBoolean) {
/* 810 */     if (this.debugAll == paramBoolean)
/* 811 */       return;  this.debugAll = paramBoolean;
/* 812 */     if (paramBoolean) {
/* 813 */       debug = true; return;
/*     */     } 
/* 815 */     this.root.setDebug(false, true);
/*     */   }
/*     */   
/*     */   public boolean isDebugAll() {
/* 819 */     return this.debugAll;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setDebugUnderMouse(boolean paramBoolean) {
/* 824 */     if (this.debugUnderMouse == paramBoolean)
/* 825 */       return;  this.debugUnderMouse = paramBoolean;
/* 826 */     if (paramBoolean) {
/* 827 */       debug = true; return;
/*     */     } 
/* 829 */     this.root.setDebug(false, true);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setDebugParentUnderMouse(boolean paramBoolean) {
/* 835 */     if (this.debugParentUnderMouse == paramBoolean)
/* 836 */       return;  this.debugParentUnderMouse = paramBoolean;
/* 837 */     if (paramBoolean) {
/* 838 */       debug = true; return;
/*     */     } 
/* 840 */     this.root.setDebug(false, true);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setDebugTableUnderMouse(@Null Table.Debug paramDebug) {
/* 847 */     if (paramDebug == null) paramDebug = Table.Debug.none; 
/* 848 */     if (this.debugTableUnderMouse == paramDebug)
/* 849 */       return;  this.debugTableUnderMouse = paramDebug;
/* 850 */     if (paramDebug != Table.Debug.none) {
/* 851 */       debug = true; return;
/*     */     } 
/* 853 */     this.root.setDebug(false, true);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setDebugTableUnderMouse(boolean paramBoolean) {
/* 859 */     setDebugTableUnderMouse(paramBoolean ? Table.Debug.all : Table.Debug.none);
/*     */   }
/*     */   
/*     */   public void dispose() {
/* 863 */     clear();
/* 864 */     if (this.ownsBatch) this.batch.dispose(); 
/* 865 */     if (this.debugShapes != null) this.debugShapes.dispose();
/*     */   
/*     */   }
/*     */ 
/*     */   
/*     */   protected boolean isInsideViewport(int paramInt1, int paramInt2) {
/* 871 */     int i, j = (i = this.viewport.getScreenX()) + this.viewport.getScreenWidth();
/*     */     
/* 873 */     int k, m = (k = this.viewport.getScreenY()) + this.viewport.getScreenHeight();
/* 874 */     paramInt2 = Gdx.graphics.getHeight() - 1 - paramInt2;
/* 875 */     return (paramInt1 >= i && paramInt1 < j && paramInt2 >= k && paramInt2 < m);
/*     */   }
/*     */   
/*     */   public static final class TouchFocus implements Pool.Poolable {
/*     */     EventListener listener;
/*     */     Actor listenerActor;
/*     */     Actor target;
/*     */     int pointer;
/*     */     int button;
/*     */     
/*     */     public final void reset() {
/* 886 */       this.listenerActor = null;
/* 887 */       this.listener = null;
/* 888 */       this.target = null;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gdx\scenes\scene2d\Stage.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */