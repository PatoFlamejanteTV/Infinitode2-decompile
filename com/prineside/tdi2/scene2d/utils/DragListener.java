/*     */ package com.prineside.tdi2.scene2d.utils;
/*     */ 
/*     */ import com.badlogic.gdx.math.Vector2;
/*     */ import com.prineside.tdi2.scene2d.InputEvent;
/*     */ import com.prineside.tdi2.scene2d.InputListener;
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
/*  29 */   private float a = 14.0F; private float b = -1.0F; private float c = -1.0F; private float d = -1.0F; private float e = -1.0F; private float f; private float g;
/*     */   private float h;
/*  31 */   private int l = -1; private float i; private float j; private float k;
/*     */   private int m;
/*     */   private boolean n;
/*     */   
/*     */   public boolean touchDown(InputEvent paramInputEvent, float paramFloat1, float paramFloat2, int paramInt1, int paramInt2) {
/*  36 */     if (this.l != -1) return false; 
/*  37 */     if (paramInt1 == 0 && this.m != -1 && paramInt2 != this.m) return false; 
/*  38 */     this.l = paramInt1;
/*  39 */     this.b = paramFloat1;
/*  40 */     this.c = paramFloat2;
/*  41 */     this.d = paramInputEvent.getStageX();
/*  42 */     this.e = paramInputEvent.getStageY();
/*  43 */     return true;
/*     */   }
/*     */   
/*     */   public void touchDragged(InputEvent paramInputEvent, float paramFloat1, float paramFloat2, int paramInt) {
/*  47 */     if (paramInt != this.l)
/*  48 */       return;  if (!this.n && (Math.abs(this.b - paramFloat1) > this.a || Math.abs(this.c - paramFloat2) > this.a)) {
/*  49 */       this.n = true;
/*  50 */       this.f = paramFloat1;
/*  51 */       this.g = paramFloat2;
/*  52 */       dragStart(paramInputEvent, paramFloat1, paramFloat2, paramInt);
/*  53 */       this.j = paramFloat1;
/*  54 */       this.k = paramFloat2;
/*     */     } 
/*  56 */     if (this.n) {
/*  57 */       this.h = this.j;
/*  58 */       this.i = this.k;
/*  59 */       this.j = paramFloat1;
/*  60 */       this.k = paramFloat2;
/*  61 */       drag(paramInputEvent, paramFloat1, paramFloat2, paramInt);
/*     */     } 
/*     */   }
/*     */   
/*     */   public void touchUp(InputEvent paramInputEvent, float paramFloat1, float paramFloat2, int paramInt1, int paramInt2) {
/*  66 */     if (paramInt1 == this.l && (this.m == -1 || paramInt2 == this.m)) {
/*  67 */       if (this.n) dragStop(paramInputEvent, paramFloat1, paramFloat2, paramInt1); 
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
/*  83 */     this.n = false;
/*  84 */     this.l = -1;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isDragging() {
/*  89 */     return this.n;
/*     */   }
/*     */   
/*     */   public void setTapSquareSize(float paramFloat) {
/*  93 */     this.a = paramFloat;
/*     */   }
/*     */   
/*     */   public float getTapSquareSize() {
/*  97 */     return this.a;
/*     */   }
/*     */   
/*     */   public float getTouchDownX() {
/* 101 */     return this.b;
/*     */   }
/*     */   
/*     */   public float getTouchDownY() {
/* 105 */     return this.c;
/*     */   }
/*     */   
/*     */   public float getStageTouchDownX() {
/* 109 */     return this.d;
/*     */   }
/*     */   
/*     */   public float getStageTouchDownY() {
/* 113 */     return this.e;
/*     */   }
/*     */   
/*     */   public float getDragStartX() {
/* 117 */     return this.f;
/*     */   }
/*     */   
/*     */   public void setDragStartX(float paramFloat) {
/* 121 */     this.f = paramFloat;
/*     */   }
/*     */   
/*     */   public float getDragStartY() {
/* 125 */     return this.g;
/*     */   }
/*     */   
/*     */   public void setDragStartY(float paramFloat) {
/* 129 */     this.g = paramFloat;
/*     */   }
/*     */   
/*     */   public float getDragX() {
/* 133 */     return this.j;
/*     */   }
/*     */   
/*     */   public float getDragY() {
/* 137 */     return this.k;
/*     */   }
/*     */ 
/*     */   
/*     */   public float getDragDistance() {
/* 142 */     return Vector2.len(this.j - this.f, this.k - this.g);
/*     */   }
/*     */ 
/*     */   
/*     */   public float getDeltaX() {
/* 147 */     return this.j - this.h;
/*     */   }
/*     */ 
/*     */   
/*     */   public float getDeltaY() {
/* 152 */     return this.k - this.i;
/*     */   }
/*     */   
/*     */   public int getButton() {
/* 156 */     return this.m;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setButton(int paramInt) {
/* 161 */     this.m = paramInt;
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\scene2\\utils\DragListener.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */