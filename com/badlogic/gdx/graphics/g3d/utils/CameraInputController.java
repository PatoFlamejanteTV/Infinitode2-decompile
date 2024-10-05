/*     */ package com.badlogic.gdx.graphics.g3d.utils;
/*     */ 
/*     */ import com.badlogic.gdx.Gdx;
/*     */ import com.badlogic.gdx.graphics.Camera;
/*     */ import com.badlogic.gdx.input.GestureDetector;
/*     */ import com.badlogic.gdx.math.MathUtils;
/*     */ import com.badlogic.gdx.math.Vector2;
/*     */ import com.badlogic.gdx.math.Vector3;
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
/*     */ public class CameraInputController
/*     */   extends GestureDetector
/*     */ {
/*  30 */   public int rotateButton = 0;
/*     */   
/*  32 */   public float rotateAngle = 360.0F;
/*     */   
/*  34 */   public int translateButton = 1;
/*     */   
/*  36 */   public float translateUnits = 10.0F;
/*     */   
/*  38 */   public int forwardButton = 2;
/*     */   
/*  40 */   public int activateKey = 0;
/*     */   
/*     */   protected boolean activatePressed;
/*     */   
/*     */   public boolean alwaysScroll = true;
/*     */   
/*  46 */   public float scrollFactor = -0.1F;
/*     */   
/*  48 */   public float pinchZoomFactor = 10.0F;
/*     */   
/*     */   public boolean autoUpdate = true;
/*     */   
/*  52 */   public Vector3 target = new Vector3();
/*     */   
/*     */   public boolean translateTarget = true;
/*     */   
/*     */   public boolean forwardTarget = true;
/*     */   
/*     */   public boolean scrollTarget = false;
/*  59 */   public int forwardKey = 51;
/*     */   protected boolean forwardPressed;
/*  61 */   public int backwardKey = 47;
/*     */   protected boolean backwardPressed;
/*  63 */   public int rotateRightKey = 29;
/*     */   protected boolean rotateRightPressed;
/*  65 */   public int rotateLeftKey = 32;
/*     */   
/*     */   protected boolean rotateLeftPressed;
/*     */   
/*     */   protected boolean controlsInverted;
/*     */   public Camera camera;
/*  71 */   protected int button = -1;
/*     */   private float startX;
/*     */   private float startY;
/*  74 */   private final Vector3 tmpV1 = new Vector3();
/*  75 */   private final Vector3 tmpV2 = new Vector3();
/*     */   protected final CameraGestureListener gestureListener;
/*     */   private int touched;
/*     */   private boolean multiTouch;
/*     */   
/*     */   protected static class CameraGestureListener extends GestureDetector.GestureAdapter { public CameraInputController controller;
/*     */     
/*     */     public boolean touchDown(float param1Float1, float param1Float2, int param1Int1, int param1Int2) {
/*  83 */       this.previousZoom = 0.0F;
/*  84 */       return false;
/*     */     }
/*     */     private float previousZoom;
/*     */     
/*     */     public boolean tap(float param1Float1, float param1Float2, int param1Int1, int param1Int2) {
/*  89 */       return false;
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean longPress(float param1Float1, float param1Float2) {
/*  94 */       return false;
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean fling(float param1Float1, float param1Float2, int param1Int) {
/*  99 */       return false;
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean pan(float param1Float1, float param1Float2, float param1Float3, float param1Float4) {
/* 104 */       return false;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public boolean zoom(float param1Float1, float param1Float2) {
/* 110 */       param1Float2 = (param1Float1 = param1Float2 - param1Float1) - this.previousZoom;
/* 111 */       this.previousZoom = param1Float1;
/* 112 */       param1Float1 = Gdx.graphics.getWidth(); float f = Gdx.graphics.getHeight();
/* 113 */       return this.controller.pinchZoom(param1Float2 / ((param1Float1 > f) ? f : param1Float1));
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean pinch(Vector2 param1Vector21, Vector2 param1Vector22, Vector2 param1Vector23, Vector2 param1Vector24) {
/* 118 */       return false;
/*     */     } }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected CameraInputController(CameraGestureListener paramCameraGestureListener, Camera paramCamera) {
/* 125 */     super((GestureDetector.GestureListener)paramCameraGestureListener);
/* 126 */     this.gestureListener = paramCameraGestureListener;
/* 127 */     this.gestureListener.controller = this;
/* 128 */     this.camera = paramCamera;
/*     */   }
/*     */   
/*     */   public CameraInputController(Camera paramCamera) {
/* 132 */     this(new CameraGestureListener(), paramCamera);
/*     */   }
/*     */   
/*     */   public void update() {
/* 136 */     if (this.rotateRightPressed || this.rotateLeftPressed || this.forwardPressed || this.backwardPressed) {
/* 137 */       float f = Gdx.graphics.getDeltaTime();
/* 138 */       if (this.rotateRightPressed) this.camera.rotate(this.camera.up, -f * this.rotateAngle); 
/* 139 */       if (this.rotateLeftPressed) this.camera.rotate(this.camera.up, f * this.rotateAngle); 
/* 140 */       if (this.forwardPressed) {
/* 141 */         this.camera.translate(this.tmpV1.set(this.camera.direction).scl(f * this.translateUnits));
/* 142 */         if (this.forwardTarget) this.target.add(this.tmpV1); 
/*     */       } 
/* 144 */       if (this.backwardPressed) {
/* 145 */         this.camera.translate(this.tmpV1.set(this.camera.direction).scl(-f * this.translateUnits));
/* 146 */         if (this.forwardTarget) this.target.add(this.tmpV1); 
/*     */       } 
/* 148 */       if (this.autoUpdate) this.camera.update();
/*     */     
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean touchDown(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
/* 157 */     this.touched |= 1 << paramInt3;
/* 158 */     this.multiTouch = !MathUtils.isPowerOfTwo(this.touched);
/* 159 */     if (this.multiTouch) {
/* 160 */       this.button = -1;
/* 161 */     } else if (this.button < 0 && (this.activateKey == 0 || this.activatePressed)) {
/* 162 */       this.startX = paramInt1;
/* 163 */       this.startY = paramInt2;
/* 164 */       this.button = paramInt4;
/*     */     } 
/* 166 */     return (super.touchDown(paramInt1, paramInt2, paramInt3, paramInt4) || this.activateKey == 0 || this.activatePressed);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean touchUp(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
/* 171 */     this.touched &= 0xFFFFFFFF ^ 1 << paramInt3;
/* 172 */     this.multiTouch = !MathUtils.isPowerOfTwo(this.touched);
/* 173 */     if (paramInt4 == this.button) this.button = -1; 
/* 174 */     return (super.touchUp(paramInt1, paramInt2, paramInt3, paramInt4) || this.activatePressed);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setInvertedControls(boolean paramBoolean) {
/* 180 */     if (this.controlsInverted != paramBoolean)
/*     */     {
/* 182 */       this.rotateAngle = -this.rotateAngle;
/*     */     }
/* 184 */     this.controlsInverted = paramBoolean;
/*     */   }
/*     */   
/*     */   protected boolean process(float paramFloat1, float paramFloat2, int paramInt) {
/* 188 */     if (paramInt == this.rotateButton) {
/* 189 */       (this.tmpV1.set(this.camera.direction).crs(this.camera.up)).y = 0.0F;
/* 190 */       this.camera.rotateAround(this.target, this.tmpV1.nor(), paramFloat2 * this.rotateAngle);
/* 191 */       this.camera.rotateAround(this.target, Vector3.Y, paramFloat1 * -this.rotateAngle);
/* 192 */     } else if (paramInt == this.translateButton) {
/* 193 */       this.camera.translate(this.tmpV1.set(this.camera.direction).crs(this.camera.up).nor().scl(-paramFloat1 * this.translateUnits));
/* 194 */       this.camera.translate(this.tmpV2.set(this.camera.up).scl(-paramFloat2 * this.translateUnits));
/* 195 */       if (this.translateTarget) this.target.add(this.tmpV1).add(this.tmpV2); 
/* 196 */     } else if (paramInt == this.forwardButton) {
/* 197 */       this.camera.translate(this.tmpV1.set(this.camera.direction).scl(paramFloat2 * this.translateUnits));
/* 198 */       if (this.forwardTarget) this.target.add(this.tmpV1); 
/*     */     } 
/* 200 */     if (this.autoUpdate) this.camera.update(); 
/* 201 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean touchDragged(int paramInt1, int paramInt2, int paramInt3) {
/*     */     boolean bool;
/* 207 */     if ((bool = super.touchDragged(paramInt1, paramInt2, paramInt3)) || this.button < 0) return bool; 
/* 208 */     float f1 = (paramInt1 - this.startX) / Gdx.graphics.getWidth();
/* 209 */     float f2 = (this.startY - paramInt2) / Gdx.graphics.getHeight();
/* 210 */     this.startX = paramInt1;
/* 211 */     this.startY = paramInt2;
/* 212 */     return process(f1, f2, this.button);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean scrolled(float paramFloat1, float paramFloat2) {
/* 217 */     return zoom(paramFloat2 * this.scrollFactor * this.translateUnits);
/*     */   }
/*     */   
/*     */   public boolean zoom(float paramFloat) {
/* 221 */     if (!this.alwaysScroll && this.activateKey != 0 && !this.activatePressed) return false; 
/* 222 */     this.camera.translate(this.tmpV1.set(this.camera.direction).scl(paramFloat));
/* 223 */     if (this.scrollTarget) this.target.add(this.tmpV1); 
/* 224 */     if (this.autoUpdate) this.camera.update(); 
/* 225 */     return true;
/*     */   }
/*     */   
/*     */   protected boolean pinchZoom(float paramFloat) {
/* 229 */     return zoom(this.pinchZoomFactor * paramFloat);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean keyDown(int paramInt) {
/* 234 */     if (paramInt == this.activateKey) this.activatePressed = true; 
/* 235 */     if (paramInt == this.forwardKey)
/* 236 */     { this.forwardPressed = true; }
/* 237 */     else if (paramInt == this.backwardKey)
/* 238 */     { this.backwardPressed = true; }
/* 239 */     else if (paramInt == this.rotateRightKey)
/* 240 */     { this.rotateRightPressed = true; }
/* 241 */     else if (paramInt == this.rotateLeftKey) { this.rotateLeftPressed = true; }
/* 242 */      return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean keyUp(int paramInt) {
/* 247 */     if (paramInt == this.activateKey) {
/* 248 */       this.activatePressed = false;
/* 249 */       this.button = -1;
/*     */     } 
/* 251 */     if (paramInt == this.forwardKey)
/* 252 */     { this.forwardPressed = false; }
/* 253 */     else if (paramInt == this.backwardKey)
/* 254 */     { this.backwardPressed = false; }
/* 255 */     else if (paramInt == this.rotateRightKey)
/* 256 */     { this.rotateRightPressed = false; }
/* 257 */     else if (paramInt == this.rotateLeftKey) { this.rotateLeftPressed = false; }
/* 258 */      return false;
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gdx\graphics\g3\\utils\CameraInputController.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */