/*     */ package com.badlogic.gdx.scenes.scene2d.utils;
/*     */ 
/*     */ import com.badlogic.gdx.math.Vector2;
/*     */ import com.badlogic.gdx.scenes.scene2d.InputEvent;
/*     */ import com.badlogic.gdx.scenes.scene2d.InputListener;
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
/*     */ public class DragListener
/*     */   extends InputListener
/*     */ {
/*  29 */   private float tapSquareSize = 14.0F; private float touchDownX = -1.0F; private float touchDownY = -1.0F; private float stageTouchDownX = -1.0F; private float stageTouchDownY = -1.0F; private float dragStartX; private float dragStartY;
/*     */   private float dragLastX;
/*  31 */   private int pressedPointer = -1; private float dragLastY; private float dragX; private float dragY;
/*     */   private int button;
/*     */   private boolean dragging;
/*     */   
/*     */   public boolean touchDown(InputEvent paramInputEvent, float paramFloat1, float paramFloat2, int paramInt1, int paramInt2) {
/*  36 */     if (this.pressedPointer != -1) return false; 
/*  37 */     if (paramInt1 == 0 && this.button != -1 && paramInt2 != this.button) return false; 
/*  38 */     this.pressedPointer = paramInt1;
/*  39 */     this.touchDownX = paramFloat1;
/*  40 */     this.touchDownY = paramFloat2;
/*  41 */     this.stageTouchDownX = paramInputEvent.getStageX();
/*  42 */     this.stageTouchDownY = paramInputEvent.getStageY();
/*  43 */     return true;
/*     */   }
/*     */   
/*     */   public void touchDragged(InputEvent paramInputEvent, float paramFloat1, float paramFloat2, int paramInt) {
/*  47 */     if (paramInt != this.pressedPointer)
/*  48 */       return;  if (!this.dragging && (Math.abs(this.touchDownX - paramFloat1) > this.tapSquareSize || Math.abs(this.touchDownY - paramFloat2) > this.tapSquareSize)) {
/*  49 */       this.dragging = true;
/*  50 */       this.dragStartX = paramFloat1;
/*  51 */       this.dragStartY = paramFloat2;
/*  52 */       dragStart(paramInputEvent, paramFloat1, paramFloat2, paramInt);
/*  53 */       this.dragX = paramFloat1;
/*  54 */       this.dragY = paramFloat2;
/*     */     } 
/*  56 */     if (this.dragging) {
/*  57 */       this.dragLastX = this.dragX;
/*  58 */       this.dragLastY = this.dragY;
/*  59 */       this.dragX = paramFloat1;
/*  60 */       this.dragY = paramFloat2;
/*  61 */       drag(paramInputEvent, paramFloat1, paramFloat2, paramInt);
/*     */     } 
/*     */   }
/*     */   
/*     */   public void touchUp(InputEvent paramInputEvent, float paramFloat1, float paramFloat2, int paramInt1, int paramInt2) {
/*  66 */     if (paramInt1 == this.pressedPointer && (this.button == -1 || paramInt2 == this.button)) {
/*  67 */       if (this.dragging) dragStop(paramInputEvent, paramFloat1, paramFloat2, paramInt1); 
/*  68 */       cancel();
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void dragStart(InputEvent paramInputEvent, float paramFloat1, float paramFloat2, int paramInt) {}
/*     */ 
/*     */   
/*     */   public void drag(InputEvent paramInputEvent, float paramFloat1, float paramFloat2, int paramInt) {}
/*     */ 
/*     */   
/*     */   public void dragStop(InputEvent paramInputEvent, float paramFloat1, float paramFloat2, int paramInt) {}
/*     */ 
/*     */   
/*     */   public void cancel() {
/*  83 */     this.dragging = false;
/*  84 */     this.pressedPointer = -1;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isDragging() {
/*  89 */     return this.dragging;
/*     */   }
/*     */   
/*     */   public void setTapSquareSize(float paramFloat) {
/*  93 */     this.tapSquareSize = paramFloat;
/*     */   }
/*     */   
/*     */   public float getTapSquareSize() {
/*  97 */     return this.tapSquareSize;
/*     */   }
/*     */   
/*     */   public float getTouchDownX() {
/* 101 */     return this.touchDownX;
/*     */   }
/*     */   
/*     */   public float getTouchDownY() {
/* 105 */     return this.touchDownY;
/*     */   }
/*     */   
/*     */   public float getStageTouchDownX() {
/* 109 */     return this.stageTouchDownX;
/*     */   }
/*     */   
/*     */   public float getStageTouchDownY() {
/* 113 */     return this.stageTouchDownY;
/*     */   }
/*     */   
/*     */   public float getDragStartX() {
/* 117 */     return this.dragStartX;
/*     */   }
/*     */   
/*     */   public void setDragStartX(float paramFloat) {
/* 121 */     this.dragStartX = paramFloat;
/*     */   }
/*     */   
/*     */   public float getDragStartY() {
/* 125 */     return this.dragStartY;
/*     */   }
/*     */   
/*     */   public void setDragStartY(float paramFloat) {
/* 129 */     this.dragStartY = paramFloat;
/*     */   }
/*     */   
/*     */   public float getDragX() {
/* 133 */     return this.dragX;
/*     */   }
/*     */   
/*     */   public float getDragY() {
/* 137 */     return this.dragY;
/*     */   }
/*     */ 
/*     */   
/*     */   public float getDragDistance() {
/* 142 */     return Vector2.len(this.dragX - this.dragStartX, this.dragY - this.dragStartY);
/*     */   }
/*     */ 
/*     */   
/*     */   public float getDeltaX() {
/* 147 */     return this.dragX - this.dragLastX;
/*     */   }
/*     */ 
/*     */   
/*     */   public float getDeltaY() {
/* 152 */     return this.dragY - this.dragLastY;
/*     */   }
/*     */   
/*     */   public int getButton() {
/* 156 */     return this.button;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setButton(int paramInt) {
/* 161 */     this.button = paramInt;
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gdx\scenes\scene2\\utils\DragListener.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */