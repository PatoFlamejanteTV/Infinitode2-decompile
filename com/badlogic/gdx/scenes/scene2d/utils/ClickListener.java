/*     */ package com.badlogic.gdx.scenes.scene2d.utils;
/*     */ 
/*     */ import com.badlogic.gdx.scenes.scene2d.Actor;
/*     */ import com.badlogic.gdx.scenes.scene2d.InputEvent;
/*     */ import com.badlogic.gdx.scenes.scene2d.InputListener;
/*     */ import com.badlogic.gdx.utils.Null;
/*     */ import com.badlogic.gdx.utils.TimeUtils;
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
/*     */ public class ClickListener
/*     */   extends InputListener
/*     */ {
/*  34 */   public static float visualPressedDuration = 0.1F;
/*     */   
/*  36 */   private float tapSquareSize = 14.0F; private float touchDownX = -1.0F; private float touchDownY = -1.0F;
/*  37 */   private int pressedPointer = -1;
/*  38 */   private int pressedButton = -1;
/*     */   
/*     */   private int button;
/*     */   private boolean pressed;
/*  42 */   private long tapCountInterval = 400000000L;
/*     */   
/*     */   private boolean over;
/*     */   private boolean cancelled;
/*     */   private long visualPressedTime;
/*     */   private int tapCount;
/*     */   private long lastTapTime;
/*     */   
/*     */   public ClickListener() {}
/*     */   
/*     */   public ClickListener(int paramInt) {
/*  53 */     this.button = paramInt;
/*     */   }
/*     */   
/*     */   public boolean touchDown(InputEvent paramInputEvent, float paramFloat1, float paramFloat2, int paramInt1, int paramInt2) {
/*  57 */     if (this.pressed) return false; 
/*  58 */     if (paramInt1 == 0 && this.button != -1 && paramInt2 != this.button) return false; 
/*  59 */     this.pressed = true;
/*  60 */     this.pressedPointer = paramInt1;
/*  61 */     this.pressedButton = paramInt2;
/*  62 */     this.touchDownX = paramFloat1;
/*  63 */     this.touchDownY = paramFloat2;
/*  64 */     setVisualPressed(true);
/*  65 */     return true;
/*     */   }
/*     */   
/*     */   public void touchDragged(InputEvent paramInputEvent, float paramFloat1, float paramFloat2, int paramInt) {
/*  69 */     if (paramInt != this.pressedPointer || this.cancelled)
/*  70 */       return;  this.pressed = isOver(paramInputEvent.getListenerActor(), paramFloat1, paramFloat2);
/*  71 */     if (!this.pressed)
/*     */     {
/*  73 */       invalidateTapSquare();
/*     */     }
/*     */   }
/*     */   
/*     */   public void touchUp(InputEvent paramInputEvent, float paramFloat1, float paramFloat2, int paramInt1, int paramInt2) {
/*  78 */     if (paramInt1 == this.pressedPointer) {
/*  79 */       if (!this.cancelled) {
/*     */         boolean bool;
/*     */         
/*  82 */         if ((bool = isOver(paramInputEvent.getListenerActor(), paramFloat1, paramFloat2)) && paramInt1 == 0 && this.button != -1 && paramInt2 != this.button) bool = false; 
/*  83 */         if (bool) {
/*     */           long l;
/*  85 */           if ((l = TimeUtils.nanoTime()) - this.lastTapTime > this.tapCountInterval) this.tapCount = 0; 
/*  86 */           this.tapCount++;
/*  87 */           this.lastTapTime = l;
/*  88 */           clicked(paramInputEvent, paramFloat1, paramFloat2);
/*     */         } 
/*     */       } 
/*  91 */       this.pressed = false;
/*  92 */       this.pressedPointer = -1;
/*  93 */       this.pressedButton = -1;
/*  94 */       this.cancelled = false;
/*     */     } 
/*     */   }
/*     */   
/*     */   public void enter(InputEvent paramInputEvent, float paramFloat1, float paramFloat2, int paramInt, @Null Actor paramActor) {
/*  99 */     if (paramInt == -1 && !this.cancelled) this.over = true; 
/*     */   }
/*     */   
/*     */   public void exit(InputEvent paramInputEvent, float paramFloat1, float paramFloat2, int paramInt, @Null Actor paramActor) {
/* 103 */     if (paramInt == -1 && !this.cancelled) this.over = false;
/*     */   
/*     */   }
/*     */   
/*     */   public void cancel() {
/* 108 */     if (this.pressedPointer == -1)
/* 109 */       return;  this.cancelled = true;
/* 110 */     this.pressed = false;
/*     */   }
/*     */ 
/*     */   
/*     */   public void clicked(InputEvent paramInputEvent, float paramFloat1, float paramFloat2) {}
/*     */ 
/*     */   
/*     */   public boolean isOver(Actor paramActor, float paramFloat1, float paramFloat2) {
/*     */     Actor actor;
/* 119 */     if ((actor = paramActor.hit(paramFloat1, paramFloat2, true)) == null || !actor.isDescendantOf(paramActor)) return inTapSquare(paramFloat1, paramFloat2); 
/* 120 */     return true;
/*     */   }
/*     */   
/*     */   public boolean inTapSquare(float paramFloat1, float paramFloat2) {
/* 124 */     if (this.touchDownX == -1.0F && this.touchDownY == -1.0F) return false; 
/* 125 */     return (Math.abs(paramFloat1 - this.touchDownX) < this.tapSquareSize && Math.abs(paramFloat2 - this.touchDownY) < this.tapSquareSize);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean inTapSquare() {
/* 130 */     return (this.touchDownX != -1.0F);
/*     */   }
/*     */ 
/*     */   
/*     */   public void invalidateTapSquare() {
/* 135 */     this.touchDownX = -1.0F;
/* 136 */     this.touchDownY = -1.0F;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isPressed() {
/* 141 */     return this.pressed;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isVisualPressed() {
/* 147 */     if (this.pressed) return true; 
/* 148 */     if (this.visualPressedTime <= 0L) return false; 
/* 149 */     if (this.visualPressedTime > TimeUtils.millis()) return true; 
/* 150 */     this.visualPressedTime = 0L;
/* 151 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setVisualPressed(boolean paramBoolean) {
/* 156 */     if (paramBoolean) {
/* 157 */       this.visualPressedTime = TimeUtils.millis() + (long)(visualPressedDuration * 1000.0F); return;
/*     */     } 
/* 159 */     this.visualPressedTime = 0L;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isOver() {
/* 164 */     return (this.over || this.pressed);
/*     */   }
/*     */   
/*     */   public void setTapSquareSize(float paramFloat) {
/* 168 */     this.tapSquareSize = paramFloat;
/*     */   }
/*     */   
/*     */   public float getTapSquareSize() {
/* 172 */     return this.tapSquareSize;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setTapCountInterval(float paramFloat) {
/* 178 */     this.tapCountInterval = (long)(paramFloat * 1.0E9F);
/*     */   }
/*     */ 
/*     */   
/*     */   public int getTapCount() {
/* 183 */     return this.tapCount;
/*     */   }
/*     */   
/*     */   public void setTapCount(int paramInt) {
/* 187 */     this.tapCount = paramInt;
/*     */   }
/*     */   
/*     */   public float getTouchDownX() {
/* 191 */     return this.touchDownX;
/*     */   }
/*     */   
/*     */   public float getTouchDownY() {
/* 195 */     return this.touchDownY;
/*     */   }
/*     */ 
/*     */   
/*     */   public int getPressedButton() {
/* 200 */     return this.pressedButton;
/*     */   }
/*     */ 
/*     */   
/*     */   public int getPressedPointer() {
/* 205 */     return this.pressedPointer;
/*     */   }
/*     */ 
/*     */   
/*     */   public int getButton() {
/* 210 */     return this.button;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setButton(int paramInt) {
/* 215 */     this.button = paramInt;
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gdx\scenes\scene2\\utils\ClickListener.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */