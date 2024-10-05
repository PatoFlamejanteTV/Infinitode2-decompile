/*     */ package com.badlogic.gdx.input;
/*     */ 
/*     */ import com.badlogic.gdx.Gdx;
/*     */ import com.badlogic.gdx.InputAdapter;
/*     */ import com.badlogic.gdx.math.Vector2;
/*     */ import com.badlogic.gdx.utils.TimeUtils;
/*     */ import com.badlogic.gdx.utils.Timer;
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
/*     */ public class GestureDetector
/*     */   extends InputAdapter
/*     */ {
/*     */   final GestureListener listener;
/*     */   private float tapRectangleWidth;
/*     */   private float tapRectangleHeight;
/*     */   private long tapCountInterval;
/*     */   private float longPressSeconds;
/*     */   private long maxFlingDelay;
/*     */   private boolean inTapRectangle;
/*     */   private int tapCount;
/*     */   private long lastTapTime;
/*     */   private float lastTapX;
/*     */   private float lastTapY;
/*     */   private int lastTapButton;
/*     */   private int lastTapPointer;
/*     */   boolean longPressFired;
/*     */   private boolean pinching;
/*     */   private boolean panning;
/*  47 */   private final VelocityTracker tracker = new VelocityTracker(); private float tapRectangleCenterX;
/*     */   private float tapRectangleCenterY;
/*     */   private long touchDownTime;
/*  50 */   Vector2 pointer1 = new Vector2();
/*  51 */   private final Vector2 pointer2 = new Vector2();
/*  52 */   private final Vector2 initialPointer1 = new Vector2();
/*  53 */   private final Vector2 initialPointer2 = new Vector2();
/*     */   
/*  55 */   private final Timer.Task longPressTask = new Timer.Task()
/*     */     {
/*     */       public void run() {
/*  58 */         if (!GestureDetector.this.longPressFired) GestureDetector.this.longPressFired = GestureDetector.this.listener.longPress(GestureDetector.this.pointer1.x, GestureDetector.this.pointer1.y);
/*     */       
/*     */       }
/*     */     };
/*     */ 
/*     */   
/*     */   public GestureDetector(GestureListener paramGestureListener) {
/*  65 */     this(20.0F, 0.4F, 1.1F, 2.1474836E9F, paramGestureListener);
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
/*     */   public GestureDetector(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, GestureListener paramGestureListener) {
/*  77 */     this(paramFloat1, paramFloat1, paramFloat2, paramFloat3, paramFloat4, paramGestureListener);
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
/*     */   public GestureDetector(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, GestureListener paramGestureListener) {
/*  91 */     if (paramGestureListener == null) throw new IllegalArgumentException("listener cannot be null."); 
/*  92 */     this.tapRectangleWidth = paramFloat1;
/*  93 */     this.tapRectangleHeight = paramFloat2;
/*  94 */     this.tapCountInterval = (long)(paramFloat3 * 1.0E9F);
/*  95 */     this.longPressSeconds = paramFloat4;
/*  96 */     this.maxFlingDelay = (long)(paramFloat5 * 1.0E9F);
/*  97 */     this.listener = paramGestureListener;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean touchDown(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
/* 102 */     return touchDown(paramInt1, paramInt2, paramInt3, paramInt4);
/*     */   }
/*     */   
/*     */   public boolean touchDown(float paramFloat1, float paramFloat2, int paramInt1, int paramInt2) {
/* 106 */     if (paramInt1 > 1) return false;
/*     */     
/* 108 */     if (paramInt1 == 0) {
/* 109 */       this.pointer1.set(paramFloat1, paramFloat2);
/* 110 */       this.touchDownTime = Gdx.input.getCurrentEventTime();
/* 111 */       this.tracker.start(paramFloat1, paramFloat2, this.touchDownTime);
/* 112 */       if (Gdx.input.isTouched(1)) {
/*     */         
/* 114 */         this.inTapRectangle = false;
/* 115 */         this.pinching = true;
/* 116 */         this.initialPointer1.set(this.pointer1);
/* 117 */         this.initialPointer2.set(this.pointer2);
/* 118 */         this.longPressTask.cancel();
/*     */       } else {
/*     */         
/* 121 */         this.inTapRectangle = true;
/* 122 */         this.pinching = false;
/* 123 */         this.longPressFired = false;
/* 124 */         this.tapRectangleCenterX = paramFloat1;
/* 125 */         this.tapRectangleCenterY = paramFloat2;
/* 126 */         if (!this.longPressTask.isScheduled()) Timer.schedule(this.longPressTask, this.longPressSeconds);
/*     */       
/*     */       } 
/*     */     } else {
/* 130 */       this.pointer2.set(paramFloat1, paramFloat2);
/* 131 */       this.inTapRectangle = false;
/* 132 */       this.pinching = true;
/* 133 */       this.initialPointer1.set(this.pointer1);
/* 134 */       this.initialPointer2.set(this.pointer2);
/* 135 */       this.longPressTask.cancel();
/*     */     } 
/* 137 */     return this.listener.touchDown(paramFloat1, paramFloat2, paramInt1, paramInt2);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean touchDragged(int paramInt1, int paramInt2, int paramInt3) {
/* 142 */     return touchDragged(paramInt1, paramInt2, paramInt3);
/*     */   }
/*     */   public boolean touchDragged(float paramFloat1, float paramFloat2, int paramInt) {
/*     */     boolean bool;
/* 146 */     if (paramInt > 1) return false; 
/* 147 */     if (this.longPressFired) return false;
/*     */     
/* 149 */     if (paramInt == 0) {
/* 150 */       this.pointer1.set(paramFloat1, paramFloat2);
/*     */     } else {
/* 152 */       this.pointer2.set(paramFloat1, paramFloat2);
/*     */     } 
/*     */     
/* 155 */     if (this.pinching) {
/* 156 */       bool = this.listener.pinch(this.initialPointer1, this.initialPointer2, this.pointer1, this.pointer2);
/* 157 */       return (this.listener.zoom(this.initialPointer1.dst(this.initialPointer2), this.pointer1.dst(this.pointer2)) || bool);
/*     */     } 
/*     */ 
/*     */     
/* 161 */     this.tracker.update(bool, paramFloat2, Gdx.input.getCurrentEventTime());
/*     */ 
/*     */     
/* 164 */     if (this.inTapRectangle && !isWithinTapRectangle(bool, paramFloat2, this.tapRectangleCenterX, this.tapRectangleCenterY)) {
/* 165 */       this.longPressTask.cancel();
/* 166 */       this.inTapRectangle = false;
/*     */     } 
/*     */ 
/*     */     
/* 170 */     if (!this.inTapRectangle) {
/* 171 */       this.panning = true;
/* 172 */       return this.listener.pan(bool, paramFloat2, this.tracker.deltaX, this.tracker.deltaY);
/*     */     } 
/*     */     
/* 175 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean touchUp(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
/* 180 */     return touchUp(paramInt1, paramInt2, paramInt3, paramInt4);
/*     */   }
/*     */   
/*     */   public boolean touchUp(float paramFloat1, float paramFloat2, int paramInt1, int paramInt2) {
/* 184 */     if (paramInt1 > 1) return false;
/*     */ 
/*     */     
/* 187 */     if (this.inTapRectangle && !isWithinTapRectangle(paramFloat1, paramFloat2, this.tapRectangleCenterX, this.tapRectangleCenterY)) this.inTapRectangle = false;
/*     */     
/* 189 */     boolean bool1 = this.panning;
/* 190 */     this.panning = false;
/*     */     
/* 192 */     this.longPressTask.cancel();
/* 193 */     if (this.longPressFired) return false;
/*     */     
/* 195 */     if (this.inTapRectangle) {
/*     */       
/* 197 */       if (this.lastTapButton != paramInt2 || this.lastTapPointer != paramInt1 || TimeUtils.nanoTime() - this.lastTapTime > this.tapCountInterval || 
/* 198 */         !isWithinTapRectangle(paramFloat1, paramFloat2, this.lastTapX, this.lastTapY)) this.tapCount = 0; 
/* 199 */       this.tapCount++;
/* 200 */       this.lastTapTime = TimeUtils.nanoTime();
/* 201 */       this.lastTapX = paramFloat1;
/* 202 */       this.lastTapY = paramFloat2;
/* 203 */       this.lastTapButton = paramInt2;
/* 204 */       this.lastTapPointer = paramInt1;
/* 205 */       this.touchDownTime = 0L;
/* 206 */       return this.listener.tap(paramFloat1, paramFloat2, this.tapCount, paramInt2);
/*     */     } 
/*     */     
/* 209 */     if (this.pinching) {
/*     */       
/* 211 */       this.pinching = false;
/* 212 */       this.listener.pinchStop();
/* 213 */       this.panning = true;
/*     */       
/* 215 */       if (paramInt1 == 0) {
/*     */         
/* 217 */         this.tracker.start(this.pointer2.x, this.pointer2.y, Gdx.input.getCurrentEventTime());
/*     */       } else {
/*     */         
/* 220 */         this.tracker.start(this.pointer1.x, this.pointer1.y, Gdx.input.getCurrentEventTime());
/*     */       } 
/* 222 */       return false;
/*     */     } 
/*     */ 
/*     */     
/* 226 */     boolean bool2 = false;
/* 227 */     if (bool1 && !this.panning) bool2 = this.listener.panStop(paramFloat1, paramFloat2, paramInt1, paramInt2);
/*     */ 
/*     */     
/*     */     long l;
/* 231 */     if ((l = Gdx.input.getCurrentEventTime()) - this.touchDownTime <= this.maxFlingDelay) {
/* 232 */       this.tracker.update(paramFloat1, paramFloat2, l);
/* 233 */       bool2 = (this.listener.fling(this.tracker.getVelocityX(), this.tracker.getVelocityY(), paramInt2) || bool2);
/*     */     } 
/* 235 */     this.touchDownTime = 0L;
/* 236 */     return bool2;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean touchCancelled(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
/* 241 */     cancel();
/* 242 */     return super.touchCancelled(paramInt1, paramInt2, paramInt3, paramInt4);
/*     */   }
/*     */ 
/*     */   
/*     */   public void cancel() {
/* 247 */     this.longPressTask.cancel();
/* 248 */     this.longPressFired = true;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isLongPressed() {
/* 253 */     return isLongPressed(this.longPressSeconds);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isLongPressed(float paramFloat) {
/* 259 */     if (this.touchDownTime == 0L) return false; 
/* 260 */     return (TimeUtils.nanoTime() - this.touchDownTime > (long)(paramFloat * 1.0E9F));
/*     */   }
/*     */   
/*     */   public boolean isPanning() {
/* 264 */     return this.panning;
/*     */   }
/*     */   
/*     */   public void reset() {
/* 268 */     this.longPressTask.cancel();
/* 269 */     this.touchDownTime = 0L;
/* 270 */     this.panning = false;
/* 271 */     this.inTapRectangle = false;
/* 272 */     this.tracker.lastTime = 0L;
/*     */   }
/*     */   
/*     */   private boolean isWithinTapRectangle(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4) {
/* 276 */     return (Math.abs(paramFloat1 - paramFloat3) < this.tapRectangleWidth && Math.abs(paramFloat2 - paramFloat4) < this.tapRectangleHeight);
/*     */   }
/*     */ 
/*     */   
/*     */   public void invalidateTapSquare() {
/* 281 */     this.inTapRectangle = false;
/*     */   }
/*     */   
/*     */   public void setTapSquareSize(float paramFloat) {
/* 285 */     setTapRectangleSize(paramFloat, paramFloat);
/*     */   }
/*     */   
/*     */   public void setTapRectangleSize(float paramFloat1, float paramFloat2) {
/* 289 */     this.tapRectangleWidth = paramFloat1;
/* 290 */     this.tapRectangleHeight = paramFloat2;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setTapCountInterval(float paramFloat) {
/* 296 */     this.tapCountInterval = (long)(paramFloat * 1.0E9F);
/*     */   }
/*     */   
/*     */   public void setLongPressSeconds(float paramFloat) {
/* 300 */     this.longPressSeconds = paramFloat;
/*     */   }
/*     */   
/*     */   public void setMaxFlingDelay(long paramLong) {
/* 304 */     this.maxFlingDelay = paramLong;
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
/*     */   public static class GestureAdapter
/*     */     implements GestureListener
/*     */   {
/*     */     public boolean touchDown(float param1Float1, float param1Float2, int param1Int1, int param1Int2) {
/* 360 */       return false;
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean tap(float param1Float1, float param1Float2, int param1Int1, int param1Int2) {
/* 365 */       return false;
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean longPress(float param1Float1, float param1Float2) {
/* 370 */       return false;
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean fling(float param1Float1, float param1Float2, int param1Int) {
/* 375 */       return false;
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean pan(float param1Float1, float param1Float2, float param1Float3, float param1Float4) {
/* 380 */       return false;
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean panStop(float param1Float1, float param1Float2, int param1Int1, int param1Int2) {
/* 385 */       return false;
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean zoom(float param1Float1, float param1Float2) {
/* 390 */       return false;
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean pinch(Vector2 param1Vector21, Vector2 param1Vector22, Vector2 param1Vector23, Vector2 param1Vector24) {
/* 395 */       return false;
/*     */     }
/*     */ 
/*     */     
/*     */     public void pinchStop() {}
/*     */   }
/*     */   
/*     */   static class VelocityTracker
/*     */   {
/* 404 */     int sampleSize = 10;
/*     */     
/*     */     float lastX;
/*     */     float lastY;
/*     */     float deltaX;
/* 409 */     float[] meanX = new float[this.sampleSize]; float deltaY; long lastTime; int numSamples;
/* 410 */     float[] meanY = new float[this.sampleSize];
/* 411 */     long[] meanTime = new long[this.sampleSize];
/*     */     
/*     */     public void start(float param1Float1, float param1Float2, long param1Long) {
/* 414 */       this.lastX = param1Float1;
/* 415 */       this.lastY = param1Float2;
/* 416 */       this.deltaX = 0.0F;
/* 417 */       this.deltaY = 0.0F;
/* 418 */       this.numSamples = 0;
/* 419 */       for (byte b = 0; b < this.sampleSize; b++) {
/* 420 */         this.meanX[b] = 0.0F;
/* 421 */         this.meanY[b] = 0.0F;
/* 422 */         this.meanTime[b] = 0L;
/*     */       } 
/* 424 */       this.lastTime = param1Long;
/*     */     }
/*     */     
/*     */     public void update(float param1Float1, float param1Float2, long param1Long) {
/* 428 */       this.deltaX = param1Float1 - this.lastX;
/* 429 */       this.deltaY = param1Float2 - this.lastY;
/* 430 */       this.lastX = param1Float1;
/* 431 */       this.lastY = param1Float2;
/* 432 */       long l = param1Long - this.lastTime;
/* 433 */       this.lastTime = param1Long;
/* 434 */       int i = this.numSamples % this.sampleSize;
/* 435 */       this.meanX[i] = this.deltaX;
/* 436 */       this.meanY[i] = this.deltaY;
/* 437 */       this.meanTime[i] = l;
/* 438 */       this.numSamples++;
/*     */     }
/*     */     
/*     */     public float getVelocityX() {
/* 442 */       float f1 = getAverage(this.meanX, this.numSamples);
/*     */       float f2;
/* 444 */       if ((f2 = (float)getAverage(this.meanTime, this.numSamples) / 1.0E9F) == 0.0F) return 0.0F; 
/* 445 */       return f1 / f2;
/*     */     }
/*     */     
/*     */     public float getVelocityY() {
/* 449 */       float f1 = getAverage(this.meanY, this.numSamples);
/*     */       float f2;
/* 451 */       if ((f2 = (float)getAverage(this.meanTime, this.numSamples) / 1.0E9F) == 0.0F) return 0.0F; 
/* 452 */       return f1 / f2;
/*     */     }
/*     */     
/*     */     private float getAverage(float[] param1ArrayOffloat, int param1Int) {
/* 456 */       param1Int = Math.min(this.sampleSize, param1Int);
/* 457 */       float f = 0.0F;
/* 458 */       for (byte b = 0; b < param1Int; b++) {
/* 459 */         f += param1ArrayOffloat[b];
/*     */       }
/* 461 */       return f / param1Int;
/*     */     }
/*     */     
/*     */     private long getAverage(long[] param1ArrayOflong, int param1Int) {
/* 465 */       param1Int = Math.min(this.sampleSize, param1Int);
/* 466 */       long l = 0L;
/* 467 */       for (byte b = 0; b < param1Int; b++) {
/* 468 */         l += param1ArrayOflong[b];
/*     */       }
/* 470 */       if (param1Int == 0) return 0L; 
/* 471 */       return l / param1Int;
/*     */     }
/*     */     
/*     */     private float getSum(float[] param1ArrayOffloat, int param1Int) {
/* 475 */       param1Int = Math.min(this.sampleSize, param1Int);
/* 476 */       float f = 0.0F;
/* 477 */       for (byte b = 0; b < param1Int; b++) {
/* 478 */         f += param1ArrayOffloat[b];
/*     */       }
/* 480 */       if (param1Int == 0) return 0.0F; 
/* 481 */       return f;
/*     */     }
/*     */   }
/*     */   
/*     */   public static interface GestureListener {
/*     */     boolean touchDown(float param1Float1, float param1Float2, int param1Int1, int param1Int2);
/*     */     
/*     */     boolean tap(float param1Float1, float param1Float2, int param1Int1, int param1Int2);
/*     */     
/*     */     boolean longPress(float param1Float1, float param1Float2);
/*     */     
/*     */     boolean fling(float param1Float1, float param1Float2, int param1Int);
/*     */     
/*     */     boolean pan(float param1Float1, float param1Float2, float param1Float3, float param1Float4);
/*     */     
/*     */     boolean panStop(float param1Float1, float param1Float2, int param1Int1, int param1Int2);
/*     */     
/*     */     boolean zoom(float param1Float1, float param1Float2);
/*     */     
/*     */     boolean pinch(Vector2 param1Vector21, Vector2 param1Vector22, Vector2 param1Vector23, Vector2 param1Vector24);
/*     */     
/*     */     void pinchStop();
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gdx\input\GestureDetector.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */