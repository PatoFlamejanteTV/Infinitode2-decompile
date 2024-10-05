/*     */ package com.prineside.tdi2.scene2d.utils;
/*     */ 
/*     */ import com.badlogic.gdx.utils.Null;
/*     */ import com.badlogic.gdx.utils.TimeUtils;
/*     */ import com.prineside.tdi2.scene2d.Actor;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ public class ClickListener
/*     */   extends InputListener
/*     */ {
/*  34 */   public static float visualPressedDuration = 0.1F;
/*     */   
/*  36 */   private float a = 14.0F; private float b = -1.0F; private float c = -1.0F;
/*  37 */   private int d = -1;
/*  38 */   private int e = -1;
/*     */   
/*     */   private int f;
/*     */   private boolean g;
/*  42 */   private long k = 400000000L;
/*     */   
/*     */   private boolean h;
/*     */   private boolean i;
/*     */   private long j;
/*     */   private int l;
/*     */   private long m;
/*     */   
/*     */   public ClickListener() {}
/*     */   
/*     */   public ClickListener(int paramInt) {
/*  53 */     this.f = paramInt;
/*     */   }
/*     */   
/*     */   public boolean touchDown(InputEvent paramInputEvent, float paramFloat1, float paramFloat2, int paramInt1, int paramInt2) {
/*  57 */     if (this.g) return false; 
/*  58 */     if (paramInt1 == 0 && this.f != -1 && paramInt2 != this.f) return false; 
/*  59 */     this.g = true;
/*  60 */     this.d = paramInt1;
/*  61 */     this.e = paramInt2;
/*  62 */     this.b = paramFloat1;
/*  63 */     this.c = paramFloat2;
/*  64 */     setVisualPressed(true);
/*  65 */     return true;
/*     */   }
/*     */   
/*     */   public void touchDragged(InputEvent paramInputEvent, float paramFloat1, float paramFloat2, int paramInt) {
/*  69 */     if (paramInt != this.d || this.i)
/*  70 */       return;  this.g = isOver(paramInputEvent.getListenerActor(), paramFloat1, paramFloat2);
/*  71 */     if (!this.g)
/*     */     {
/*  73 */       invalidateTapSquare();
/*     */     }
/*     */   }
/*     */   
/*     */   public void touchUp(InputEvent paramInputEvent, float paramFloat1, float paramFloat2, int paramInt1, int paramInt2) {
/*  78 */     if (paramInt1 == this.d) {
/*  79 */       if (!this.i) {
/*     */         boolean bool;
/*     */         
/*  82 */         if ((bool = isOver(paramInputEvent.getListenerActor(), paramFloat1, paramFloat2)) && paramInt1 == 0 && this.f != -1 && paramInt2 != this.f) bool = false; 
/*  83 */         if (bool) {
/*     */           long l;
/*  85 */           if ((l = TimeUtils.nanoTime()) - this.m > this.k) this.l = 0; 
/*  86 */           this.l++;
/*  87 */           this.m = l;
/*  88 */           clicked(paramInputEvent, paramFloat1, paramFloat2);
/*     */         } 
/*     */       } 
/*  91 */       this.g = false;
/*  92 */       this.d = -1;
/*  93 */       this.e = -1;
/*  94 */       this.i = false;
/*     */     } 
/*     */   }
/*     */   
/*     */   public void enter(InputEvent paramInputEvent, float paramFloat1, float paramFloat2, int paramInt, @Null Actor paramActor) {
/*  99 */     if (paramInt == -1 && !this.i) this.h = true; 
/*     */   }
/*     */   
/*     */   public void exit(InputEvent paramInputEvent, float paramFloat1, float paramFloat2, int paramInt, @Null Actor paramActor) {
/* 103 */     if (paramInt == -1 && !this.i) this.h = false;
/*     */   
/*     */   }
/*     */   
/*     */   public void cancel() {
/* 108 */     if (this.d == -1)
/* 109 */       return;  this.i = true;
/* 110 */     this.g = false;
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
/* 124 */     if (this.b == -1.0F && this.c == -1.0F) return false; 
/* 125 */     return (Math.abs(paramFloat1 - this.b) < this.a && Math.abs(paramFloat2 - this.c) < this.a);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean inTapSquare() {
/* 130 */     return (this.b != -1.0F);
/*     */   }
/*     */ 
/*     */   
/*     */   public void invalidateTapSquare() {
/* 135 */     this.b = -1.0F;
/* 136 */     this.c = -1.0F;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isPressed() {
/* 141 */     return this.g;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isVisualPressed() {
/* 147 */     if (this.g) return true; 
/* 148 */     if (this.j <= 0L) return false; 
/* 149 */     if (this.j > TimeUtils.millis()) return true; 
/* 150 */     this.j = 0L;
/* 151 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setVisualPressed(boolean paramBoolean) {
/* 156 */     if (paramBoolean) {
/* 157 */       this.j = TimeUtils.millis() + (long)(visualPressedDuration * 1000.0F); return;
/*     */     } 
/* 159 */     this.j = 0L;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isOver() {
/* 164 */     return (this.h || this.g);
/*     */   }
/*     */   
/*     */   public void setTapSquareSize(float paramFloat) {
/* 168 */     this.a = paramFloat;
/*     */   }
/*     */   
/*     */   public float getTapSquareSize() {
/* 172 */     return this.a;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setTapCountInterval(float paramFloat) {
/* 178 */     this.k = (long)(paramFloat * 1.0E9F);
/*     */   }
/*     */ 
/*     */   
/*     */   public int getTapCount() {
/* 183 */     return this.l;
/*     */   }
/*     */   
/*     */   public void setTapCount(int paramInt) {
/* 187 */     this.l = paramInt;
/*     */   }
/*     */   
/*     */   public float getTouchDownX() {
/* 191 */     return this.b;
/*     */   }
/*     */   
/*     */   public float getTouchDownY() {
/* 195 */     return this.c;
/*     */   }
/*     */ 
/*     */   
/*     */   public int getPressedButton() {
/* 200 */     return this.e;
/*     */   }
/*     */ 
/*     */   
/*     */   public int getPressedPointer() {
/* 205 */     return this.d;
/*     */   }
/*     */ 
/*     */   
/*     */   public int getButton() {
/* 210 */     return this.f;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setButton(int paramInt) {
/* 215 */     this.f = paramInt;
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\scene2\\utils\ClickListener.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */