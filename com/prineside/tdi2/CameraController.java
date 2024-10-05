/*     */ package com.prineside.tdi2;
/*     */ 
/*     */ import com.badlogic.gdx.Application;
/*     */ import com.badlogic.gdx.Gdx;
/*     */ import com.badlogic.gdx.InputProcessor;
/*     */ import com.badlogic.gdx.graphics.OrthographicCamera;
/*     */ import com.badlogic.gdx.math.Interpolation;
/*     */ import com.badlogic.gdx.math.Rectangle;
/*     */ import com.badlogic.gdx.math.Vector2;
/*     */ import com.badlogic.gdx.math.Vector3;
/*     */ import com.badlogic.gdx.utils.Array;
/*     */ import com.badlogic.gdx.utils.DelayedRemovalArray;
/*     */ import com.badlogic.gdx.utils.IntArray;
/*     */ import com.badlogic.gdx.utils.IntMap;
/*     */ import com.google.common.base.Preconditions;
/*     */ import com.prineside.tdi2.managers.SettingsManager;
/*     */ import com.prineside.tdi2.ui.shared.CameraTools;
/*     */ import com.prineside.tdi2.utils.FastRandom;
/*     */ import com.prineside.tdi2.utils.IgnoreMethodOverloadLuaDefWarning;
/*     */ import com.prineside.tdi2.utils.IntRectangle;
/*     */ import com.prineside.tdi2.utils.PMath;
/*     */ import java.util.Iterator;
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
/*     */ public final class CameraController
/*     */ {
/*     */   public static final float DEFAULT_MIN_ZOOM_TILE_SIZE = 1.524F;
/*     */   public static final float DEFAULT_MAX_ZOOM_MAP_SCALE = 1.25F;
/*     */   public OrthographicCamera camera;
/*  39 */   public double zoom = 1.0D;
/*     */   
/*  41 */   private final Rectangle a = new Rectangle();
/*  42 */   private final Rectangle b = new Rectangle();
/*     */   
/*  44 */   private double c = 0.5D;
/*  45 */   private double d = 4.0D;
/*     */   
/*     */   public boolean hardZoomLimits = false;
/*  48 */   public double hardMinZoom = 0.5D;
/*  49 */   public double hardMaxZoom = 4.0D;
/*     */   
/*     */   public boolean scrollZoomRequiresAlt = false;
/*     */   public boolean outmapCheckEnabled = true;
/*  53 */   public IntArray dragButtonIndices = new IntArray(new int[] { 0 });
/*     */   
/*     */   private int e;
/*     */   
/*     */   private int f;
/*     */   
/*     */   private int g;
/*     */   
/*     */   private int h;
/*     */   
/*     */   private boolean i;
/*     */   private int j;
/*     */   private int k;
/*     */   private CameraControllerAnimation l;
/*     */   public CameraTools.Scenario currentScenario;
/*     */   public float scenarioTime;
/*     */   public boolean scenarioLooped;
/*  70 */   private float m = 1.524F;
/*  71 */   private float n = 1.25F;
/*     */   
/*     */   private Map o;
/*     */   
/*  75 */   private static final Rectangle p = new Rectangle();
/*  76 */   private static final Vector2 q = new Vector2();
/*  77 */   private static final Vector2 r = new Vector2();
/*     */   
/*  79 */   private final DelayedRemovalArray<CameraControllerListener> s = new DelayedRemovalArray(CameraControllerListener.class);
/*     */   
/*  81 */   private final _InputProcessor t = new _InputProcessor((byte)0);
/*     */   
/*     */   public CameraController(OrthographicCamera paramOrthographicCamera, int paramInt1, int paramInt2) {
/*  84 */     Preconditions.checkNotNull(paramOrthographicCamera, "camera can not be null");
/*     */ 
/*     */     
/*  87 */     this.camera = paramOrthographicCamera;
/*  88 */     this.e = paramInt1;
/*  89 */     this.f = paramInt2;
/*  90 */     setScreenSize(Game.i.uiManager.getScreenWidth(), Game.i.uiManager.getScreenHeight());
/*  91 */     setZoomBoundaries(1.524F, 1.25F);
/*  92 */     updateCamera();
/*     */   }
/*     */   
/*     */   public final double getRevZoomPercent() {
/*  96 */     return 1.0D / this.zoom * 100.0D;
/*     */   }
/*     */   
/*     */   public final void setRevZoomPercent(double paramDouble) {
/* 100 */     if (paramDouble != getRevZoomPercent()) {
/* 101 */       setZoom(1.0D / paramDouble / 100.0D);
/*     */     }
/*     */   }
/*     */   
/*     */   public final double getMinZoom() {
/* 106 */     return this.c;
/*     */   }
/*     */   
/*     */   public final double getMaxZoom() {
/* 110 */     return this.d;
/*     */   }
/*     */   
/*     */   public final void setMap(Map paramMap) {
/* 114 */     this.o = paramMap;
/* 115 */     this.i = true;
/*     */   }
/*     */   
/*     */   public final int getMapWidth() {
/* 119 */     return this.e;
/*     */   }
/*     */   
/*     */   public final int getMapHeight() {
/* 123 */     return this.f;
/*     */   }
/*     */   
/*     */   public final InputProcessor getInputProcessor() {
/* 127 */     return this.t;
/*     */   }
/*     */   
/*     */   public final void playScenario(CameraTools.Scenario paramScenario, float paramFloat, boolean paramBoolean) {
/* 131 */     this.currentScenario = paramScenario;
/* 132 */     this.scenarioTime = paramFloat;
/* 133 */     this.scenarioLooped = paramBoolean;
/*     */   }
/*     */   
/*     */   public final void stopScenario() {
/* 137 */     this.currentScenario = null;
/*     */   }
/*     */   
/*     */   public final void animate(CameraControllerAnimation paramCameraControllerAnimation) {
/* 141 */     stopAnimations();
/* 142 */     this.l = paramCameraControllerAnimation;
/* 143 */     paramCameraControllerAnimation.start(this);
/*     */   }
/*     */   
/*     */   public final void stopAnimations() {
/* 147 */     if (this.l != null) {
/* 148 */       this.l.end();
/* 149 */       this.l = null;
/*     */     } 
/*     */   }
/*     */   
/*     */   public final void setScreenSize(int paramInt1, int paramInt2) {
/* 154 */     if (paramInt1 == 0 || paramInt2 == 0) {
/*     */       
/* 156 */       paramInt1 = 1600;
/* 157 */       paramInt2 = 900;
/*     */     } 
/* 159 */     this.g = paramInt1;
/* 160 */     this.h = paramInt2;
/*     */     
/* 162 */     updateMinMaxZoom();
/* 163 */     updateCamera();
/*     */   }
/*     */   
/*     */   public final void setMapSize(int paramInt1, int paramInt2) {
/* 167 */     this.e = paramInt1;
/* 168 */     this.f = paramInt2;
/*     */     
/* 170 */     updateMinMaxZoom();
/* 171 */     updateCamera();
/*     */   }
/*     */   
/* 174 */   private static final Rectangle u = new Rectangle();
/*     */   public final boolean isRectVisible(Rectangle paramRectangle) {
/* 176 */     return this.a.overlaps(paramRectangle);
/*     */   }
/*     */   
/*     */   public final boolean isIntRectVisible(IntRectangle paramIntRectangle) {
/* 180 */     return this.a.overlaps(u.set(paramIntRectangle.minX, paramIntRectangle.minY, (paramIntRectangle.maxX - paramIntRectangle.minX), (paramIntRectangle.maxY - paramIntRectangle.minY)));
/*     */   }
/*     */   
/*     */   @IgnoreMethodOverloadLuaDefWarning
/*     */   public final boolean isPointVisible(Vector2 paramVector2, float paramFloat) {
/* 185 */     return isRectVisible(u.set(paramVector2.x - paramFloat, paramVector2.y - paramFloat, paramFloat, paramFloat));
/*     */   }
/*     */   
/*     */   @IgnoreMethodOverloadLuaDefWarning
/*     */   public final boolean isPointVisible(float paramFloat1, float paramFloat2, float paramFloat3) {
/* 190 */     return isRectVisible(u.set(paramFloat1 - paramFloat3, paramFloat2 - paramFloat3, paramFloat3, paramFloat3));
/*     */   }
/*     */   
/*     */   public final boolean isRectVisibleMarginSmall(Rectangle paramRectangle) {
/* 194 */     return this.b.overlaps(paramRectangle);
/*     */   }
/*     */   
/*     */   private void c() {
/* 198 */     this.a.set(this.camera.position.x - this.camera.viewportWidth / 2.0F, this.camera.position.y - this.camera.viewportHeight / 2.0F, this.camera.viewportWidth, this.camera.viewportHeight);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 205 */     if (Game.i.settingsManager.getCustomValue(SettingsManager.CustomValueType.DBG_VIEWPORT_CULLING) != 0.0D)
/*     */     {
/* 207 */       this.a.width -= this.a.width * 0.5F;
/*     */     }
/*     */     
/* 210 */     this.b.set(this.a.x - 64.0F, this.a.y - 64.0F, this.a.width + 128.0F, this.a.height + 128.0F);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 217 */     this.s.begin();
/* 218 */     for (byte b = 0; b < this.s.size; b++) {
/* 219 */       ((CameraControllerListener[])this.s.items)[b].onViewportUpdated(this);
/*     */     }
/* 221 */     this.s.end();
/*     */   }
/*     */   
/*     */   public final void addListener(CameraControllerListener paramCameraControllerListener) {
/* 225 */     if (paramCameraControllerListener == null) {
/* 226 */       throw new IllegalArgumentException("listener is null");
/*     */     }
/*     */     
/* 229 */     if (!this.s.contains(paramCameraControllerListener, true)) {
/* 230 */       this.s.add(paramCameraControllerListener);
/*     */     }
/*     */   }
/*     */   
/*     */   public final void removeListener(CameraControllerListener paramCameraControllerListener) {
/* 235 */     if (paramCameraControllerListener == null) {
/* 236 */       throw new IllegalArgumentException("listener is null");
/*     */     }
/*     */     
/* 239 */     this.s.removeValue(paramCameraControllerListener, true);
/*     */   }
/*     */   
/*     */   public final void updateMinMaxZoom() {
/* 243 */     if (this.hardZoomLimits) {
/* 244 */       this.c = this.hardMinZoom;
/* 245 */       this.d = this.hardMaxZoom; return;
/*     */     } 
/* 247 */     float f = Gdx.graphics.getDensity();
/* 248 */     f = 128.0F / f / 160.0F * 2.54F;
/*     */     
/* 250 */     this.c = (f / this.m);
/*     */     
/* 252 */     if (this.c < 0.25D) this.c = 0.25D; 
/* 253 */     if (this.c > 1.0D) this.c = 1.0D;
/*     */     
/* 255 */     if (this.e / this.g < this.f / this.h) {
/*     */       
/* 257 */       this.d = (this.f / this.h * this.n);
/*     */     } else {
/*     */       
/* 260 */       this.d = (this.e / this.g * this.n);
/*     */     } 
/*     */     
/* 263 */     if (this.d > 16.0D) this.d = 16.0D; 
/* 264 */     if (this.d < 2.0D) this.d = 2.0D;
/*     */   
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public final void setZoomBoundaries(float paramFloat1, float paramFloat2) {
/* 271 */     this.m = paramFloat1;
/* 272 */     this.n = paramFloat2;
/* 273 */     updateMinMaxZoom();
/*     */   }
/*     */   
/*     */   public final void setZoom(double paramDouble) {
/* 277 */     this.zoom = paramDouble;
/* 278 */     if (this.zoom < this.c) {
/* 279 */       this.zoom = this.c;
/* 280 */     } else if (this.zoom > this.d) {
/* 281 */       this.zoom = this.d;
/*     */     } 
/*     */     
/* 284 */     if (Game.i.debugManager.isEnabled()) {
/* 285 */       Game.i.debugManager.registerValue("Zoom").append((float)(this.zoom * 100.0D) / 100.0F);
/*     */     }
/*     */     
/* 288 */     updateCamera();
/*     */   }
/*     */   
/*     */   public final void lookAt(float paramFloat1, float paramFloat2) {
/* 292 */     this.camera.position.set(paramFloat1, paramFloat2, this.camera.position.z);
/*     */     
/* 294 */     updateCamera();
/*     */   }
/*     */   
/*     */   public final Vector3 getLookPos() {
/* 298 */     return this.camera.position;
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
/*     */   public final void lookAtAlignToViewport(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4) {
/* 311 */     paramFloat3 = this.camera.viewportWidth * paramFloat3;
/* 312 */     paramFloat4 = this.camera.viewportHeight * paramFloat4;
/*     */ 
/*     */     
/* 315 */     paramFloat3 = this.camera.viewportWidth / 2.0F - paramFloat3;
/* 316 */     paramFloat4 = this.camera.viewportHeight / 2.0F - paramFloat4;
/*     */ 
/*     */     
/* 319 */     lookAt(paramFloat1 + paramFloat3, paramFloat2 + paramFloat4);
/*     */   }
/*     */   
/*     */   public final void screenToViewport(Vector2 paramVector2) {
/* 323 */     paramVector2.x = paramVector2.x / this.g * this.camera.viewportWidth;
/* 324 */     paramVector2.y = (1.0F - paramVector2.y / this.h) * this.camera.viewportHeight;
/*     */   }
/*     */   
/*     */   public final void viewportToScreen(Vector2 paramVector2) {
/* 328 */     paramVector2.x = paramVector2.x / this.camera.viewportWidth * this.g;
/* 329 */     paramVector2.y = (1.0F - paramVector2.y / this.camera.viewportHeight) * this.h;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final void stageToScreen(Vector2 paramVector2) {
/* 336 */     float f = this.h / Game.i.settingsManager.getScaledViewportHeight();
/* 337 */     paramVector2.x *= f;
/* 338 */     paramVector2.y = this.h - paramVector2.y * f;
/*     */   }
/*     */   
/*     */   public final void screenToStage(Vector2 paramVector2) {
/* 342 */     float f = Game.i.settingsManager.getScaledViewportHeight() / this.h;
/* 343 */     paramVector2.x *= f;
/* 344 */     paramVector2.y = Game.i.settingsManager.getScaledViewportHeight() - paramVector2.y * f;
/*     */   }
/*     */ 
/*     */   
/*     */   public final void screenToMap(Vector2 paramVector2) {
/* 349 */     screenToViewport(paramVector2);
/* 350 */     paramVector2.x = this.camera.position.x - this.camera.viewportWidth / 2.0F + paramVector2.x;
/* 351 */     paramVector2.y = this.camera.position.y - this.camera.viewportHeight / 2.0F + paramVector2.y;
/*     */   }
/*     */   
/*     */   public final void stageToMap(Vector2 paramVector2) {
/* 355 */     stageToScreen(paramVector2);
/* 356 */     screenToMap(paramVector2);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public final void mapToViewport(Vector2 paramVector2) {
/* 362 */     paramVector2.x = paramVector2.x - this.camera.position.x + this.camera.viewportWidth / 2.0F;
/* 363 */     paramVector2.y = paramVector2.y - this.camera.position.y + this.camera.viewportHeight / 2.0F;
/*     */   }
/*     */   
/*     */   public final void mapToScreen(Vector2 paramVector2) {
/* 367 */     mapToViewport(paramVector2);
/* 368 */     viewportToScreen(paramVector2);
/*     */   }
/*     */   
/*     */   public final void mapToStage(Vector2 paramVector2) {
/* 372 */     mapToScreen(paramVector2);
/* 373 */     screenToStage(paramVector2);
/*     */   }
/*     */   
/*     */   private void a(double paramDouble, Rectangle paramRectangle) {
/* 377 */     paramRectangle.width = (int)(this.g * paramDouble);
/* 378 */     paramRectangle.height = (int)(this.h * paramDouble);
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final void fitMapToScreen(float paramFloat) {
/* 397 */     stopAnimations();
/* 398 */     this.currentScenario = null;
/*     */     
/* 400 */     lookAt((this.e / 2), (this.f / 2));
/*     */     
/* 402 */     float f = this.g - paramFloat * 2.0F;
/* 403 */     paramFloat = this.h - paramFloat * 2.0F;
/*     */     
/* 405 */     if (this.e / f < this.f / paramFloat) {
/* 406 */       setZoom((this.f / paramFloat)); return;
/*     */     } 
/* 408 */     setZoom((this.e / f));
/*     */   }
/*     */   
/*     */   public final void realUpdate(float paramFloat) {
/*     */     boolean bool;
/* 413 */     if (this.currentScenario != null) {
/* 414 */       this.scenarioTime += paramFloat;
/* 415 */       bool = false;
/* 416 */       if (this.scenarioTime > this.currentScenario.length / this.currentScenario.fps)
/*     */       {
/* 418 */         if (this.scenarioLooped) {
/* 419 */           this.scenarioTime %= this.currentScenario.length / this.currentScenario.fps;
/* 420 */           this.scenarioTime += this.currentScenario.startFrame / this.currentScenario.fps;
/*     */         } else {
/* 422 */           this.scenarioTime = this.currentScenario.length / this.currentScenario.fps;
/* 423 */           bool = true;
/*     */         } 
/*     */       }
/* 426 */       Vector3 vector3 = this.currentScenario.calculate(this.scenarioTime);
/* 427 */       this.camera.position.set(
/* 428 */           Float.isNaN(vector3.x) ? this.camera.position.x : vector3.x, 
/* 429 */           Float.isNaN(vector3.y) ? this.camera.position.y : vector3.y, this.camera.position.z);
/*     */ 
/*     */       
/* 432 */       this.zoom = Float.isNaN(vector3.z) ? this.zoom : vector3.z;
/* 433 */       updateCamera();
/*     */       
/* 435 */       if (bool) {
/* 436 */         this.currentScenario = null;
/*     */       }
/* 438 */     } else if (this.l != null) {
/* 439 */       this.l.update(bool);
/* 440 */       if (this.l.isDone()) {
/* 441 */         stopAnimations();
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 446 */     if (this.o != null && this.i) {
/* 447 */       this.i = false;
/*     */       
/* 449 */       DelayedRemovalArray<Tile> delayedRemovalArray = this.o.getAllTiles(); byte b; int i;
/* 450 */       for (b = 0, i = ((Array)delayedRemovalArray).size; b < i; b++) {
/*     */         Tile tile;
/* 452 */         (tile = ((Tile[])((Array)delayedRemovalArray).items)[b]).visibleOnScreen = isPointVisible(((tile.a << 7) + 64), ((tile.b << 7) + 64), 128.0F);
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public final void updateCamera() {
/* 459 */     float f1 = 1.0F / Game.i.settingsManager.getScaledViewportHeight() * this.h;
/* 460 */     float f2 = 1200.0F * f1;
/* 461 */     float f3 = 1200.0F * f1;
/* 462 */     float f4 = Game.i.settingsManager.getScaledViewportHeight() * 0.5F * f1;
/* 463 */     f1 = Game.i.settingsManager.getScaledViewportHeight() * 0.5F * f1;
/*     */ 
/*     */     
/* 466 */     Rectangle rectangle = p;
/* 467 */     a(this.zoom, rectangle);
/*     */     
/* 469 */     this.camera.viewportWidth = rectangle.width;
/* 470 */     this.camera.viewportHeight = rectangle.height;
/*     */ 
/*     */     
/* 473 */     if (this.outmapCheckEnabled) {
/*     */       
/* 475 */       f3 = (float)(f3 * this.zoom);
/* 476 */       f2 = (float)(f2 * this.zoom);
/* 477 */       if (this.e + f3 + f2 <= this.camera.viewportWidth) {
/*     */         
/* 479 */         this.camera.position.x = (this.e / 2);
/*     */       } else {
/* 481 */         f3 = -f3 + this.camera.viewportWidth / 2.0F;
/* 482 */         f2 = this.e + f2 - this.camera.viewportWidth / 2.0F;
/*     */         
/* 484 */         if (this.camera.position.x < f3) {
/* 485 */           this.camera.position.x = f3;
/* 486 */         } else if (this.camera.position.x > f2) {
/* 487 */           this.camera.position.x = f2;
/*     */         } 
/*     */       } 
/*     */ 
/*     */       
/* 492 */       f3 = (float)(f4 * this.zoom);
/* 493 */       f2 = (float)(f1 * this.zoom);
/* 494 */       if (this.f + f3 + f2 <= this.camera.viewportHeight) {
/*     */         
/* 496 */         this.camera.position.y = (this.f / 2);
/*     */       } else {
/* 498 */         f1 = -f2 + this.camera.viewportHeight / 2.0F;
/* 499 */         f2 = this.f + f3 - this.camera.viewportHeight / 2.0F;
/*     */         
/* 501 */         if (this.camera.position.y < f1) {
/* 502 */           this.camera.position.y = f1;
/* 503 */         } else if (this.camera.position.y > f2) {
/* 504 */           this.camera.position.y = f2;
/*     */         } 
/*     */       } 
/*     */     } 
/*     */     
/* 509 */     this.camera.update();
/*     */     
/* 511 */     c();
/*     */   }
/*     */   
/*     */   private class _InputProcessor
/*     */     implements InputProcessor {
/*     */     private int a;
/*     */     private int b;
/*     */     private long c;
/*     */     private boolean d;
/* 520 */     private final IntMap<CameraController.CameraControllerTouch> e = new IntMap();
/*     */ 
/*     */     
/*     */     public boolean keyDown(int param1Int) {
/* 524 */       return false;
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean keyUp(int param1Int) {
/* 529 */       return false;
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean keyTyped(char param1Char) {
/* 534 */       return false;
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean touchDown(int param1Int1, int param1Int2, int param1Int3, int param1Int4) {
/* 539 */       if (!this.f.dragButtonIndices.contains(param1Int4)) return false;
/*     */ 
/*     */       
/* 542 */       this.f.stopAnimations();
/* 543 */       if (Game.i.settingsManager.getCustomValue(SettingsManager.CustomValueType.TOUCHES_STOP_CAMERA_SCENARIOS) != 0.0D) {
/* 544 */         this.f.currentScenario = null;
/*     */       }
/*     */       
/* 547 */       if (this.e.size > 2) return false;
/*     */       
/*     */       CameraController.CameraControllerTouch cameraControllerTouch;
/* 550 */       (cameraControllerTouch = new CameraController.CameraControllerTouch()).setup(param1Int1, param1Int2, this.f.camera.position.x, this.f.camera.position.y, this.f.zoom);
/*     */       
/* 552 */       if (this.e.size == 1) {
/*     */         
/* 554 */         CameraController.CameraControllerTouch cameraControllerTouch1 = null; Iterator<?> iterator;
/* 555 */         if ((iterator = this.e.values().iterator()).hasNext()) {
/* 556 */           cameraControllerTouch1 = cameraControllerTouch1 = (CameraController.CameraControllerTouch)iterator.next();
/*     */         }
/*     */ 
/*     */         
/* 560 */         if (cameraControllerTouch1 != null) {
/* 561 */           cameraControllerTouch1.c = cameraControllerTouch1.x;
/* 562 */           cameraControllerTouch1.d = cameraControllerTouch1.y;
/*     */         } 
/* 564 */       } else if (this.e.size == 0) {
/*     */         
/* 566 */         if (Math.abs(this.a - param1Int1) < 32 && Math.abs(this.b - param1Int2) < 32 && Game.getTimestampMillis() - this.c < 300L)
/*     */         {
/* 568 */           if (Gdx.app.getType() != Application.ApplicationType.Desktop) {
/* 569 */             this.d = true;
/*     */           }
/*     */         }
/*     */       } 
/*     */       
/* 574 */       this.e.put(param1Int3, cameraControllerTouch);
/*     */       
/* 576 */       this.a = param1Int1;
/* 577 */       this.b = param1Int2;
/* 578 */       this.c = Game.getTimestampMillis();
/*     */       
/* 580 */       return false;
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean touchUp(int param1Int1, int param1Int2, int param1Int3, int param1Int4) {
/* 585 */       this.d = false;
/*     */       
/* 587 */       if (this.e.get(param1Int3) != null) {
/* 588 */         CameraController.CameraControllerTouch cameraControllerTouch = (CameraController.CameraControllerTouch)this.e.get(param1Int3);
/*     */ 
/*     */         
/* 591 */         param1Int2 = 0;
/*     */         
/* 593 */         if (cameraControllerTouch.i || cameraControllerTouch.j) {
/* 594 */           param1Int2 = 1;
/*     */         }
/*     */         
/* 597 */         this.e.remove(param1Int3);
/*     */         
/* 599 */         return param1Int2;
/*     */       } 
/*     */       
/* 602 */       return false;
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean touchCancelled(int param1Int1, int param1Int2, int param1Int3, int param1Int4) {
/* 607 */       return false;
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean touchDragged(int param1Int1, int param1Int2, int param1Int3) {
/* 612 */       if (this.e.size != 0)
/*     */       {
/* 614 */         if (this.e.size == 1) {
/*     */           
/* 616 */           if (this.d) {
/* 617 */             CameraController.CameraControllerTouch cameraControllerTouch1 = null; Iterator<?> iterator;
/* 618 */             if ((iterator = this.e.values().iterator()).hasNext()) {
/* 619 */               CameraController.CameraControllerTouch cameraControllerTouch2 = (CameraController.CameraControllerTouch)iterator.next();
/*     */             }
/*     */             
/* 622 */             if (cameraControllerTouch1 == null) {
/* 623 */               this.d = false;
/* 624 */               return false;
/*     */             } 
/*     */ 
/*     */             
/* 628 */             float f = (f = (this.a - param1Int1 + this.b - param1Int2)) * 1080.0F / Game.i.uiManager.getScreenHeight();
/*     */             
/* 630 */             this.f.setZoom(this.f.zoom + (f * 0.002F));
/*     */             
/* 632 */             this.a = param1Int1;
/* 633 */             this.b = param1Int2;
/*     */           } else {
/*     */             CameraController.CameraControllerTouch cameraControllerTouch1;
/*     */             
/* 637 */             if ((cameraControllerTouch1 = (CameraController.CameraControllerTouch)this.e.get(param1Int3)) != null && !cameraControllerTouch1.i) {
/*     */               
/* 639 */               int i = param1Int1 - cameraControllerTouch1.a;
/* 640 */               int j = param1Int2 - cameraControllerTouch1.b;
/*     */               
/* 642 */               float f1 = -(i) * (float)this.f.zoom;
/* 643 */               float f2 = j * (float)this.f.zoom;
/*     */               
/* 645 */               this.f.camera.position.set(cameraControllerTouch1.e + f1, cameraControllerTouch1.f + f2, this.f.camera.position.z);
/* 646 */               this.f.updateCamera();
/*     */               
/* 648 */               if (StrictMath.abs(i) > 20 || StrictMath.abs(j) > 20)
/*     */               {
/* 650 */                 cameraControllerTouch1.j = true;
/*     */               }
/*     */             } 
/*     */           } 
/* 654 */         } else if (this.e.size == 2) {
/*     */           
/* 656 */           CameraController.CameraControllerTouch cameraControllerTouch1 = null;
/* 657 */           CameraController.CameraControllerTouch cameraControllerTouch2 = null;
/* 658 */           for (CameraController.CameraControllerTouch cameraControllerTouch3 : this.e.values()) {
/* 659 */             if (cameraControllerTouch1 == null) {
/* 660 */               cameraControllerTouch1 = cameraControllerTouch3;
/*     */               continue;
/*     */             } 
/* 663 */             cameraControllerTouch2 = cameraControllerTouch3;
/*     */           } 
/*     */ 
/*     */           
/* 667 */           double d1 = PMath.getDistanceBetweenPoints(cameraControllerTouch1.c, cameraControllerTouch1.d, cameraControllerTouch2.c, cameraControllerTouch2.d);
/*     */           
/* 669 */           double d2, d3 = (d2 = PMath.getDistanceBetweenPoints(cameraControllerTouch1.x, cameraControllerTouch1.y, cameraControllerTouch2.x, cameraControllerTouch2.y)) / d1;
/*     */           
/* 671 */           if (!cameraControllerTouch1.i) {
/*     */             
/* 673 */             float f1 = ((cameraControllerTouch1.x + cameraControllerTouch2.x) / 2);
/* 674 */             float f2 = ((cameraControllerTouch1.y + cameraControllerTouch2.y) / 2);
/*     */             
/*     */             Vector2 vector2;
/* 677 */             (vector2 = new Vector2()).set(f1, f2);
/* 678 */             this.f.screenToMap(vector2);
/*     */             
/* 680 */             cameraControllerTouch1.h = vector2;
/* 681 */             cameraControllerTouch2.h = vector2;
/*     */           } else {
/*     */             
/* 684 */             double d = cameraControllerTouch1.g;
/*     */             
/* 686 */             int i = (cameraControllerTouch1.x + cameraControllerTouch2.x) / 2;
/* 687 */             int j = (cameraControllerTouch1.y + cameraControllerTouch2.y) / 2;
/*     */             
/* 689 */             CameraController.a().set(i, j);
/* 690 */             this.f.screenToViewport(CameraController.a());
/* 691 */             float f1 = (CameraController.a()).x / this.f.camera.viewportWidth;
/* 692 */             float f2 = (CameraController.a()).y / this.f.camera.viewportHeight;
/*     */             
/* 694 */             this.f.setZoom(cameraControllerTouch1.g / d3);
/*     */             
/* 696 */             if (this.f.zoom != d)
/*     */             {
/* 698 */               if (cameraControllerTouch1.h != null) {
/* 699 */                 this.f.lookAtAlignToViewport((int)cameraControllerTouch1.h.x, (int)cameraControllerTouch1.h.y, f1, f2);
/*     */               }
/*     */             }
/*     */           } 
/*     */           
/* 704 */           cameraControllerTouch1.i = true;
/* 705 */           cameraControllerTouch2.i = true;
/*     */         } 
/*     */       }
/*     */       
/*     */       CameraController.CameraControllerTouch cameraControllerTouch;
/* 710 */       if ((cameraControllerTouch = (CameraController.CameraControllerTouch)this.e.get(param1Int3)) != null) {
/* 711 */         cameraControllerTouch.x = param1Int1;
/* 712 */         cameraControllerTouch.y = param1Int2;
/*     */       } 
/*     */       
/* 715 */       return false;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public boolean mouseMoved(int param1Int1, int param1Int2) {
/* 721 */       CameraController.a(this.f, param1Int1);
/* 722 */       CameraController.b(this.f, param1Int2);
/*     */       
/* 724 */       return false;
/*     */     }
/*     */     
/*     */     public boolean scrolled(float param1Float1, float param1Float2) {
/*     */       double d3;
/* 729 */       if (this.f.scrollZoomRequiresAlt && !Gdx.input.isKeyPressed(57)) return false;
/*     */ 
/*     */       
/* 732 */       if (Game.i.settingsManager.getCustomValue(SettingsManager.CustomValueType.TOUCHES_STOP_CAMERA_SCENARIOS) != 0.0D) {
/* 733 */         this.f.currentScenario = null;
/*     */       }
/*     */       
/* 736 */       this.f.stopAnimations();
/*     */       
/* 738 */       Vector2 vector21 = CameraController.a();
/* 739 */       Vector2 vector22 = CameraController.b();
/*     */       
/* 741 */       vector21.set(CameraController.a(this.f), CameraController.b(this.f));
/* 742 */       this.f.screenToMap(vector21);
/*     */       
/* 744 */       vector22.set(CameraController.a(this.f), CameraController.b(this.f));
/* 745 */       this.f.screenToViewport(vector22);
/*     */       
/* 747 */       float f2 = vector22.x / this.f.camera.viewportWidth;
/* 748 */       float f1 = vector22.y / this.f.camera.viewportHeight;
/*     */       
/* 750 */       double d1 = this.f.zoom;
/* 751 */       double d2 = this.f.getRevZoomPercent();
/*     */ 
/*     */       
/* 754 */       if (param1Float2 > 0.0F) {
/*     */         
/* 756 */         d3 = d2 * 0.9D;
/*     */       } else {
/*     */         
/* 759 */         d3 = d2 * 1.1111111111111112D;
/*     */       } 
/* 761 */       this.f.setRevZoomPercent(d3);
/*     */       
/* 763 */       if (this.f.zoom != d1)
/*     */       {
/* 765 */         this.f.lookAtAlignToViewport((int)vector21.x, (int)vector21.y, f2, f1);
/*     */       }
/*     */       
/* 768 */       return false;
/*     */     }
/*     */ 
/*     */     
/*     */     private _InputProcessor(CameraController this$0) {}
/*     */   }
/*     */ 
/*     */   
/*     */   private static class CameraControllerTouch
/*     */   {
/*     */     public int x;
/*     */     
/*     */     public int y;
/*     */     
/*     */     int a;
/*     */     int b;
/*     */     int c;
/*     */     int d;
/*     */     float e;
/*     */     float f;
/*     */     double g;
/*     */     Vector2 h;
/*     */     boolean i = false;
/*     */     boolean j = false;
/*     */     
/*     */     public void setup(int param1Int1, int param1Int2, float param1Float1, float param1Float2, double param1Double) {
/* 794 */       this.x = param1Int1;
/* 795 */       this.y = param1Int2;
/*     */       
/* 797 */       this.a = param1Int1;
/* 798 */       this.b = param1Int2;
/*     */       
/* 800 */       this.c = param1Int1;
/* 801 */       this.d = param1Int2;
/*     */       
/* 803 */       this.e = param1Float1;
/* 804 */       this.f = param1Float2;
/*     */       
/* 806 */       this.g = param1Double;
/*     */     }
/*     */ 
/*     */     
/*     */     public String toString() {
/* 811 */       return getClass().getSimpleName() + "@" + Integer.toHexString(hashCode()) + " (" + this.a + ", " + this.b + ")";
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public static class BasicAnimation
/*     */     implements CameraControllerAnimation
/*     */   {
/*     */     private float a;
/*     */     
/*     */     private float b;
/*     */     
/*     */     private double c;
/*     */     
/*     */     private float d;
/*     */     
/*     */     private CameraController e;
/*     */     
/*     */     private float f;
/*     */     
/*     */     private float g;
/*     */     
/*     */     private double h;
/*     */     
/*     */     private float i;
/*     */     
/*     */     private Interpolation j;
/*     */     
/*     */     public BasicAnimation(float param1Float1, float param1Float2, double param1Double, float param1Float3, Interpolation param1Interpolation) {
/* 840 */       this.f = param1Float1;
/* 841 */       this.g = param1Float2;
/* 842 */       this.h = param1Double;
/* 843 */       this.i = param1Float3;
/* 844 */       this.j = param1Interpolation;
/*     */     }
/*     */ 
/*     */     
/*     */     public void start(CameraController param1CameraController) {
/* 849 */       this.a = param1CameraController.camera.position.x;
/* 850 */       this.b = param1CameraController.camera.position.y;
/* 851 */       this.c = param1CameraController.zoom;
/* 852 */       this.d = 0.0F;
/* 853 */       this.e = param1CameraController;
/*     */     }
/*     */ 
/*     */     
/*     */     public void update(float param1Float) {
/* 858 */       this.d += param1Float;
/* 859 */       if (this.d >= this.i) {
/* 860 */         this.d = this.i;
/*     */       }
/* 862 */       param1Float = this.j.apply(this.d / this.i);
/* 863 */       float f1 = this.a + (this.f - this.a) * param1Float;
/* 864 */       float f2 = this.b + (this.g - this.b) * param1Float;
/* 865 */       this.e.camera.position.set(f1, f2, this.e.camera.position.z);
/* 866 */       this.e.zoom = this.c + (this.h - this.c) * param1Float;
/* 867 */       this.e.updateCamera();
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public void end() {}
/*     */ 
/*     */ 
/*     */     
/*     */     public boolean isDone() {
/* 877 */       return (this.d == this.i);
/*     */     }
/*     */   }
/*     */   
/*     */   public static class ShakeAnimation
/*     */     implements CameraControllerAnimation {
/*     */     private float a;
/*     */     private float b;
/*     */     private float c;
/*     */     private CameraController d;
/*     */     private float e;
/*     */     private float f;
/*     */     
/*     */     public ShakeAnimation(float param1Float1, float param1Float2) {
/* 891 */       this.e = param1Float1;
/* 892 */       this.f = param1Float2;
/*     */     }
/*     */ 
/*     */     
/*     */     public void start(CameraController param1CameraController) {
/* 897 */       this.a = param1CameraController.camera.position.x;
/* 898 */       this.b = param1CameraController.camera.position.y;
/* 899 */       this.c = 0.0F;
/* 900 */       this.d = param1CameraController;
/*     */     }
/*     */ 
/*     */     
/*     */     public void update(float param1Float) {
/* 905 */       this.c += param1Float;
/* 906 */       if (this.c >= this.f) {
/* 907 */         this.c = this.f;
/*     */       }
/*     */       
/* 910 */       param1Float = 1.0F - Interpolation.exp5Out.apply(this.c / this.f);
/* 911 */       param1Float = this.e * param1Float;
/*     */       
/* 913 */       float f = (FastRandom.getFloat() * 2.0F - 1.0F) * param1Float;
/* 914 */       param1Float = (FastRandom.getFloat() * 2.0F - 1.0F) * param1Float;
/* 915 */       this.d.camera.position.set(this.a + f, this.b + param1Float, this.d.camera.position.z);
/* 916 */       this.d.updateCamera();
/*     */     }
/*     */ 
/*     */     
/*     */     public void end() {
/* 921 */       this.d.camera.position.set(this.a, this.b, this.d.camera.position.z);
/* 922 */       this.d.updateCamera();
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean isDone() {
/* 927 */       return (this.c == this.f);
/*     */     }
/*     */   }
/*     */   
/*     */   public static interface CameraControllerListener {
/*     */     void onViewportUpdated(CameraController param1CameraController);
/*     */   }
/*     */   
/*     */   public static interface CameraControllerAnimation {
/*     */     void start(CameraController param1CameraController);
/*     */     
/*     */     void update(float param1Float);
/*     */     
/*     */     void end();
/*     */     
/*     */     boolean isDone();
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\CameraController.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */