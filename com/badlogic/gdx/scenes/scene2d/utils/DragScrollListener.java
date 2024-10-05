/*     */ package com.badlogic.gdx.scenes.scene2d.utils;
/*     */ 
/*     */ import com.badlogic.gdx.math.Interpolation;
/*     */ import com.badlogic.gdx.math.Vector2;
/*     */ import com.badlogic.gdx.scenes.scene2d.Actor;
/*     */ import com.badlogic.gdx.scenes.scene2d.InputEvent;
/*     */ import com.badlogic.gdx.scenes.scene2d.ui.ScrollPane;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class DragScrollListener
/*     */   extends DragListener
/*     */ {
/*  37 */   static final Vector2 tmpCoords = new Vector2();
/*     */   private ScrollPane scroll;
/*     */   private Timer.Task scrollUp;
/*     */   private Timer.Task scrollDown;
/*  41 */   Interpolation interpolation = (Interpolation)Interpolation.exp5In;
/*  42 */   float minSpeed = 15.0F; float maxSpeed = 75.0F; float tickSecs = 0.05F; long startTime;
/*  43 */   long rampTime = 1750L; float padTop;
/*     */   float padBottom;
/*     */   
/*     */   public DragScrollListener(final ScrollPane scroll) {
/*  47 */     this.scroll = scroll;
/*     */     
/*  49 */     this.scrollUp = new Timer.Task() {
/*     */         public void run() {
/*  51 */           DragScrollListener.this.scroll(scroll.getScrollY() - DragScrollListener.this.getScrollPixels());
/*     */         }
/*     */       };
/*  54 */     this.scrollDown = new Timer.Task() {
/*     */         public void run() {
/*  56 */           DragScrollListener.this.scroll(scroll.getScrollY() + DragScrollListener.this.getScrollPixels());
/*     */         }
/*     */       };
/*     */   }
/*     */   
/*     */   public void setup(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4) {
/*  62 */     this.minSpeed = paramFloat1;
/*  63 */     this.maxSpeed = paramFloat2;
/*  64 */     this.tickSecs = paramFloat3;
/*  65 */     this.rampTime = (long)(paramFloat4 * 1000.0F);
/*     */   }
/*     */   
/*     */   float getScrollPixels() {
/*  69 */     return this.interpolation.apply(this.minSpeed, this.maxSpeed, Math.min(1.0F, (float)(System.currentTimeMillis() - this.startTime) / (float)this.rampTime));
/*     */   }
/*     */   
/*     */   public void drag(InputEvent paramInputEvent, float paramFloat1, float paramFloat2, int paramInt) {
/*  73 */     paramInputEvent.getListenerActor().localToActorCoordinates((Actor)this.scroll, tmpCoords.set(paramFloat1, paramFloat2));
/*  74 */     if (isAbove(tmpCoords.y)) {
/*  75 */       this.scrollDown.cancel();
/*  76 */       if (!this.scrollUp.isScheduled()) {
/*  77 */         this.startTime = System.currentTimeMillis();
/*  78 */         Timer.schedule(this.scrollUp, this.tickSecs, this.tickSecs);
/*     */       }  return;
/*     */     } 
/*  81 */     if (isBelow(tmpCoords.y)) {
/*  82 */       this.scrollUp.cancel();
/*  83 */       if (!this.scrollDown.isScheduled()) {
/*  84 */         this.startTime = System.currentTimeMillis();
/*  85 */         Timer.schedule(this.scrollDown, this.tickSecs, this.tickSecs);
/*     */       } 
/*     */       return;
/*     */     } 
/*  89 */     this.scrollUp.cancel();
/*  90 */     this.scrollDown.cancel();
/*     */   }
/*     */   
/*     */   public void dragStop(InputEvent paramInputEvent, float paramFloat1, float paramFloat2, int paramInt) {
/*  94 */     this.scrollUp.cancel();
/*  95 */     this.scrollDown.cancel();
/*     */   }
/*     */   
/*     */   protected boolean isAbove(float paramFloat) {
/*  99 */     return (paramFloat >= this.scroll.getHeight() - this.padTop);
/*     */   }
/*     */   
/*     */   protected boolean isBelow(float paramFloat) {
/* 103 */     return (paramFloat < this.padBottom);
/*     */   }
/*     */   
/*     */   protected void scroll(float paramFloat) {
/* 107 */     this.scroll.setScrollY(paramFloat);
/*     */   }
/*     */   
/*     */   public void setPadding(float paramFloat1, float paramFloat2) {
/* 111 */     this.padTop = paramFloat1;
/* 112 */     this.padBottom = paramFloat2;
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gdx\scenes\scene2\\utils\DragScrollListener.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */