/*     */ package com.prineside.tdi2.scene2d.utils;
/*     */ 
/*     */ import com.badlogic.gdx.math.Interpolation;
/*     */ import com.badlogic.gdx.math.Vector2;
/*     */ import com.badlogic.gdx.utils.Timer;
/*     */ import com.prineside.tdi2.scene2d.Actor;
/*     */ import com.prineside.tdi2.scene2d.InputEvent;
/*     */ import com.prineside.tdi2.scene2d.ui.ScrollPane;
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
/*  37 */   private static Vector2 a = new Vector2();
/*     */   private ScrollPane b;
/*     */   private Timer.Task c;
/*     */   private Timer.Task d;
/*  41 */   private Interpolation e = (Interpolation)Interpolation.exp5In;
/*  42 */   private float f = 15.0F; private float g = 75.0F; private float h = 0.05F; private long i;
/*  43 */   private long j = 1750L; private float k;
/*     */   private float l;
/*     */   
/*     */   public DragScrollListener(ScrollPane paramScrollPane) {
/*  47 */     this.b = paramScrollPane;
/*     */     
/*  49 */     this.c = new Timer.Task(this, paramScrollPane) {
/*     */         public void run() {
/*  51 */           this.b.a(this.a.getScrollY() - this.b.a());
/*     */         }
/*     */       };
/*  54 */     this.d = new Timer.Task(this, paramScrollPane) {
/*     */         public void run() {
/*  56 */           this.b.a(this.a.getScrollY() + this.b.a());
/*     */         }
/*     */       };
/*     */   }
/*     */   
/*     */   public void setup(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4) {
/*  62 */     this.f = paramFloat1;
/*  63 */     this.g = paramFloat2;
/*  64 */     this.h = paramFloat3;
/*  65 */     this.j = (long)(paramFloat4 * 1000.0F);
/*     */   }
/*     */   
/*     */   final float a() {
/*  69 */     return this.e.apply(this.f, this.g, Math.min(1.0F, (float)(System.currentTimeMillis() - this.i) / (float)this.j));
/*     */   }
/*     */   
/*     */   public void drag(InputEvent paramInputEvent, float paramFloat1, float paramFloat2, int paramInt) {
/*  73 */     paramInputEvent.getListenerActor().localToActorCoordinates((Actor)this.b, a.set(paramFloat1, paramFloat2));
/*  74 */     if (b(a.y)) {
/*  75 */       this.d.cancel();
/*  76 */       if (!this.c.isScheduled()) {
/*  77 */         this.i = System.currentTimeMillis();
/*  78 */         Timer.schedule(this.c, this.h, this.h);
/*     */       }  return;
/*     */     } 
/*  81 */     if (c(a.y)) {
/*  82 */       this.c.cancel();
/*  83 */       if (!this.d.isScheduled()) {
/*  84 */         this.i = System.currentTimeMillis();
/*  85 */         Timer.schedule(this.d, this.h, this.h);
/*     */       } 
/*     */       return;
/*     */     } 
/*  89 */     this.c.cancel();
/*  90 */     this.d.cancel();
/*     */   }
/*     */   
/*     */   public void dragStop(InputEvent paramInputEvent, float paramFloat1, float paramFloat2, int paramInt) {
/*  94 */     this.c.cancel();
/*  95 */     this.d.cancel();
/*     */   }
/*     */   
/*     */   private boolean b(float paramFloat) {
/*  99 */     return (paramFloat >= this.b.getHeight() - this.k);
/*     */   }
/*     */   
/*     */   private boolean c(float paramFloat) {
/* 103 */     return (paramFloat < this.l);
/*     */   }
/*     */   
/*     */   protected final void a(float paramFloat) {
/* 107 */     this.b.setScrollY(paramFloat);
/*     */   }
/*     */   
/*     */   public void setPadding(float paramFloat1, float paramFloat2) {
/* 111 */     this.k = paramFloat1;
/* 112 */     this.l = paramFloat2;
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\scene2\\utils\DragScrollListener.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */